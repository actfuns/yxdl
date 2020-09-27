package com.wanniu.game.request.consignment;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.consignmentShop.ConsignmentUtil;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.WNMail;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pomelo.Common;
import pomelo.area.ConsignmentLineHandler;


@GClientEvent("area.consignmentLineHandler.buyConsignmentRequest")
public class BuyConsignmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.BuyConsignmentRequest msg = ConsignmentLineHandler.BuyConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
        String id = msg.getC2SId();
        int globalZone = msg.getC2SGlobal();


        int needLevel = ConsignmentUtil.getConsignmentLevel();
        if (needLevel > player.getLevel()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_OPEN_LEVEL").replace("{needLevel}", String.valueOf(needLevel)));
        }

        ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
        if (item == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_BUY"));
        }


        if (item.consignmentPlayerId.equals(player.getId())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CONSIGNMENT_CANNOT_BUY_SELF_ITEM"));
        }


        if (!player.moneyManager.enoughDiamond(item.consignmentPrice)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DIAMAND_NOT_ENOUGH"));
        }


        List<Common.KeyValueStruct> changeItems = new ArrayList<>();
        Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
        items.setKey(item.db.code);
        items.setValue(String.valueOf(item.db.groupCount));
        changeItems.add(items.build());
        player.moneyManager.costDiamond(item.consignmentPrice, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_BUY, changeItems);

        DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
        String itemName = MessageUtil.itemColorName(itemBase.qcolor, itemBase.name);


        if (!id.equals(ConsignmentUtil.sysItemId)) {
            Out.info(new Object[]{"拍卖道具出售成功 playerId=", item.consignmentPlayerId, ",name=", item.consignmentPlayerName, ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.db.groupCount), ",price=", Integer.valueOf(item.consignmentPrice)});

            int salePrice = item.consignmentPrice - ConsignmentUtil.commissionPrice(globalZone, item.consignmentPrice);
            if (salePrice < 0) {
                salePrice = 0;
            }
            MailSysData mailSaleData = new MailSysData("Consignment_sale");
            mailSaleData.attachments = new ArrayList();
            MailData.Attachment att = new MailData.Attachment();
            att.itemCode = "diamond";
            att.itemNum = salePrice;
            mailSaleData.attachments.add(att);
            mailSaleData.replace = new HashMap<>();
            mailSaleData.replace.put("storeItem", itemName);
            mailSaleData.replace.put("price", String.valueOf(item.consignmentPrice));
            mailSaleData.replace.put("realprice", String.valueOf(salePrice));
            MailUtil.getInstance().sendMailToOnePlayer(item.consignmentPlayerId, (MailData) mailSaleData, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_SELL);

            ConsignmentLineService.getInstance().remove(item.id);
        } else {
            player.consignmentManager.signBuyFirstConsignItem();
        }


        Out.info(new Object[]{"拍卖道具购买成功 playerId=", player.getId(), ",name=", player.getName(), ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.db.groupCount), ",price=", Integer.valueOf(item.consignmentPrice)});
        MailSysData mailData = new MailSysData("Consignment_buy");
        mailData.replace = new HashMap<>();
        mailData.replace.put("storeItem", itemName);
        mailData.entityItems = new ArrayList();
        mailData.entityItems.add(item.db);

        WNMail mail = MailUtil.getInstance().createMail((MailData) mailData, player.getId(), Const.GOODS_CHANGE_TYPE.CONSIGNMENT_BUY);
        MailUtil.getInstance().sendMail(player, mail);

        PlayerUtil.sendSysMessageToPlayer("购买成功，请到邮箱中查收！", player.getId(), null);


        LogReportService.getInstance().ansycReportConsignment(player, item.consignmentPlayerId, item.consignmentPlayerName, item.db.code, item.db.groupCount);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.BuyConsignmentResponse.Builder res = ConsignmentLineHandler.BuyConsignmentResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


