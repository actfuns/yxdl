package com.wanniu.game.request.consignment;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.data.ChatSettingCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.io.IOException;
import java.util.HashMap;

import pomelo.area.ConsignmentLineHandler;


@GClientEvent("area.consignmentLineHandler.publicItemRequest")
public class PublicItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.PublicItemRequest msg = ConsignmentLineHandler.PublicItemRequest.parseFrom(this.pak.getRemaingBytes());
        final String id = msg.getId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.PublicItemResponse.Builder res = ConsignmentLineHandler.PublicItemResponse.newBuilder();

                ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
                if (item == null) {
                    Out.error(new Object[]{"publicItemRequest ", this.val$id, " not found."});
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NULL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                int scope = Const.CHAT_SCOPE.WORLD.getValue();
                ChatSettingCO setting = (ChatSettingCO) GameData.ChatSettings.get(Integer.valueOf(scope));
                if (player.chatTime == null) {
                    player.chatTime = new HashMap<>();
                }
                Long lasttime = (Long) player.chatTime.get(Integer.valueOf(scope));
                long currTime = System.currentTimeMillis();
                long second = 0L;
                if (lasttime != null) {
                    second = setting.coolDown - (currTime - lasttime.longValue()) / 1000L;
                }


                if (item.publishTimes == 0) {
                    if (second > 0L) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[]{Long.valueOf(second)}));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                } else if (item.publishTimes > 0 && item.publishTimes <= GlobalConfig.Consignment_Advertisement_goldNum) {


                    if (player.player.gold < GlobalConfig.Consignment_Advertisement_gold) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    if (second > 0L) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[]{Long.valueOf(second)}));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    player.moneyManager.costGold(GlobalConfig.Consignment_Advertisement_gold, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
                } else if (item.publishTimes > GlobalConfig.Consignment_Advertisement_goldNum) {


                    if (player.player.ticket < GlobalConfig.Consignment_Advertisement_diamond && player.player.diamond < GlobalConfig.Consignment_Advertisement_diamond) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    if (second > 0L) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[]{Long.valueOf(second)}));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    if (player.player.ticket >= GlobalConfig.Consignment_Advertisement_diamond) {
                        player.moneyManager.costTicket(GlobalConfig.Consignment_Advertisement_diamond, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
                    } else {
                        player.moneyManager.costDiamond(GlobalConfig.Consignment_Advertisement_diamond, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
                    }
                }

                item.publishTimes++;

                GCache.put(ConstsTR.chat_item_tr.value + "/" + id, JSON.toJSONString(item.db), 600);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


