package com.wanniu.game.request.intergalmall;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.IntergalShopBase;
import com.wanniu.game.intergalmall.IntergalMallConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.IntergalMallPO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pomelo.area.IntergalMallHandler;


@GClientEvent("area.intergalMallHandler.buyIntergalItemRequest")
public class BuyIntergalItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        IntergalMallHandler.BuyIntergalItemRequest req = IntergalMallHandler.BuyIntergalItemRequest.parseFrom(this.pak.getRemaingBytes());

        final int shopType = req.getC2SType();
        final int itemId = req.getC2SItemId();
        final int buyNum = req.getC2SNum();

        return new PomeloResponse() {
            protected void write() throws IOException {
                IntergalMallHandler.BuyIntergalItemResponse.Builder res = IntergalMallHandler.BuyIntergalItemResponse.newBuilder();


                if (buyNum <= 0 || buyNum > 9999) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                IntergalShopBase prop = IntergalMallConfig.getInstance().getIntergalMallProp(shopType, itemId);

                if (prop == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NULL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (prop.isShow == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (prop.periodStartDate != null && prop.periodStartDate.getTime() > System.currentTimeMillis()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (prop.periodEndDate != null && prop.periodEndDate.getTime() < System.currentTimeMillis()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                IntergalMallPO intergalMallPO = (player.getIntergalMallManager()).intergalMallPO;

                Map<Integer, Integer> shopHasBuyMap = (Map<Integer, Integer>) intergalMallPO.hasBuyItem.get(Integer.valueOf(shopType));
                if (shopHasBuyMap == null) {
                    shopHasBuyMap = new HashMap<>();
                    intergalMallPO.hasBuyItem.put(Integer.valueOf(shopType), shopHasBuyMap);
                }
                int hasBuyNum = shopHasBuyMap.containsKey(Integer.valueOf(itemId)) ? ((Integer) shopHasBuyMap.get(Integer.valueOf(itemId))).intValue() : 0;


                int vip = player.baseDataManager.getVip();
                int add = 0;
                if (vip > 0) {
                    add = ((CardCO) GameData.Cards.get(Integer.valueOf(vip))).prv7;
                }


                if (prop.buyTimes != -1 && hasBuyNum + buyNum > prop.buyTimes + add) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SHOPMALL_REMAINNUM_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                int needNum = prop.price;
                if (prop.price2 > 0) {
                    needNum = prop.price2;
                }


                if (1L * needNum * buyNum > 2147483647L) {
                    needNum = Integer.MAX_VALUE;
                } else {
                    needNum *= buyNum;
                }

                boolean pointEnough = false;
                String msg = null;
                if (shopType == 2) {
                    pointEnough = player.moneyManager.enoughConsumePoint(needNum);
                    msg = LangService.getValue("PLAER_CONSUMEPOINT_NOT_ENOUGH");
                } else if (shopType == 3) {
                    pointEnough = player.moneyManager.enoughXianYuan(needNum);
                    msg = LangService.getValue("PLAER_XIANYUAN_NOT_ENOUGH");
                } else if (shopType == 4) {
                    pointEnough = player.soloManager.enoughSolopoint(needNum);
                    msg = LangService.getValue("SOLOPOINT_NOT_ENOUGH");
                } else if (shopType == 5) {
                    pointEnough = player.guildManager.enoughContribution(needNum);
                    msg = LangService.getValue("GUILD_POINT_NOT_ENOUGH");
                } else if (shopType == 1) {
                    pointEnough = player.moneyManager.enoughGold(needNum);
                    msg = LangService.getValue("GOLD_NOT_ENOUGH");
                }
                if (!pointEnough) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                Out.info(new Object[]{"积分商城购买道具 playerId=", this.val$player.getId(), ",itemId=", prop.itemCode, ",count=", Integer.valueOf(prop.num * this.val$buyNum)});


                int currencyNum = 0;
                if (shopType == 2) {
                    player.moneyManager.costConsumePoint(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
                    currencyNum = player.moneyManager.getConsumePoint();
                } else if (shopType == 3) {
                    player.moneyManager.costXianYuan(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
                    currencyNum = player.moneyManager.getXianYuan();
                } else if (shopType == 4) {
                    player.soloManager.costSolopoint(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
                    currencyNum = player.soloManager.getSolopoint();
                } else if (shopType == 5) {
                    player.guildManager.costContribution(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
                    currencyNum = player.guildManager.getContribution();
                } else if (shopType == 1) {
                    player.moneyManager.costGold(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
                    currencyNum = player.baseDataManager.baseData.gold;
                }


                player.bag.addCodeItemMail(prop.itemCode, prop.num * buyNum, Const.ForceType.getE(prop.isBind), Const.GOODS_CHANGE_TYPE.intergalmall, "Bag_full_common");


                hasBuyNum += buyNum;
                shopHasBuyMap.put(Integer.valueOf(itemId), Integer.valueOf(hasBuyNum));


                if (prop.buyTimes != -1) {
                    res.setLastcount(prop.buyTimes - hasBuyNum + add);
                } else {
                    res.setLastcount(-1);
                }


                LogReportService.getInstance().ansycReportShop(player, prop.itemCode, prop.num * buyNum, shopType + 10, needNum);

                res.setCurrencyNum(currencyNum);
                res.setTotalNum(player.bag.findItemNumByCode(prop.itemCode));
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


