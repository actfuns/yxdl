package com.wanniu.game.request.consignment;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.consignmentShop.ConsignmentUtil;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import pomelo.area.ConsignmentLineHandler;


@GClientEvent("area.consignmentLineHandler.addConsignmentRequest")
public class AddConsignmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ConsignmentLineHandler.AddConsignmentRequest msg = ConsignmentLineHandler.AddConsignmentRequest.parseFrom(this.pak.getRemaingBytes());

        int index = msg.getC2SIndex();
        int num = msg.getC2SNumber();
        int salePrice = msg.getC2SPrice();
        String itemId = msg.getC2SId();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        int needLevel = ConsignmentUtil.getConsignmentLevel();
        if (needLevel > player.getLevel()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_OPEN_LEVEL").replace("{needLevel}", String.valueOf(needLevel)));
        }

        if (num < 1) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_NUM_LESS_ONE"));
        }

        NormalItem item = player.getWnBag().getItem(index);
        if (item == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NULL"));
        }


        if (!item.isEquip() && item.prop.salePrice > 0) {

            if (salePrice < item.prop.salePrice * GlobalConfig.Consignment_Advertisement_minPercent * num / 100) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_LESS"));
            }

            if (salePrice > item.prop.salePrice * GlobalConfig.Consignment_Advertisement_maxPercent * num / 100) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_MORE"));

            }
        } else {

            if (salePrice < 2 * num) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_LESS"));
            }

            if (salePrice > 10000000) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_MORE"));
            }
        }


        if (StringUtils.isNotEmpty(itemId)) {
            return handleReshelf(player, itemId, salePrice);
        }


        if (item.isBinding()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_BIND_CANNOT"));
        }


        if (!item.canAuction()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_SALE"));
        }


        if (item.itemDb.groupCount < num) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
        }


        List<ConsignmentItemsPO> myList = ConsignmentLineService.getInstance().findByPlayerId(player.getId());
        if (myList.size() >= ConsignmentUtil.sellNum(player)) {
            player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.CONSIGNMENT, null, null, null);
            return (PomeloResponse) new ErrorResponse();
        }


        int depositCoin = ConsignmentUtil.depositPrice(item.prop.price * num);
        if (!player.moneyManager.enoughGold(depositCoin)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_GOLD_NOT_ENOUGH"));
        }

        int lateMinutes = ConsignmentUtil.getLateMinutes(salePrice);
        ConsignmentItemsPO data = item.toJSON4ConsignmentLine(salePrice, player.getName(), player.getPro(), player.getId(), ConsignmentUtil.sellTime(), num, lateMinutes);
        boolean ret = ConsignmentLineService.getInstance().insert(data);
        if (!ret) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CommonUtil_ITEM_IS_IN_SALE"));
        }
        Out.info(new Object[]{"上架拍卖道具 playerId=", player.getId(), ",itemId=", data.id, ",code=", data.db.code, ",count=", Integer.valueOf(num), ",price=", Integer.valueOf(salePrice)});
        player.getWnBag().discardItemByPos(index, num, false, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD);

        player.moneyManager.costGold(depositCoin, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.AddConsignmentResponse.Builder res = ConsignmentLineHandler.AddConsignmentResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }


    private PomeloResponse handleReshelf(WNPlayer player, String itemId, int salePrice) {
        ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(itemId);
        if (item == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NULL"));
        }


        DItemEquipBase prop = ItemConfig.getInstance().getItemProp(item.db.code);
        if (prop == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NULL"));
        }


        int depositCoin = ConsignmentUtil.depositPrice(prop.price * item.db.groupCount);
        if (!player.moneyManager.costGold(depositCoin, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_GOLD_NOT_ENOUGH"));
        }
        Out.info(new Object[]{"重新上架拍卖道具 playerId=", player.getId(), ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.groupCount), ",price=", Integer.valueOf(salePrice)});

        int lateMinutes = ConsignmentUtil.getLateMinutes(salePrice);
        item.consignmentPrice = salePrice;
        item.consignmentTime = System.currentTimeMillis() + ConsignmentUtil.sellTime() + (lateMinutes * Const.Time.Minute.getValue());
        item.lateMinutes = lateMinutes;

        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.AddConsignmentResponse.Builder res = ConsignmentLineHandler.AddConsignmentResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


