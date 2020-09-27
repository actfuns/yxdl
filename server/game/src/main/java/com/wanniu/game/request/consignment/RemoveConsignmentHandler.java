package com.wanniu.game.request.consignment;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.WNMail;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import pomelo.area.ConsignmentLineHandler;


@GClientEvent("area.consignmentLineHandler.removeConsignmentRequest")
public class RemoveConsignmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.RemoveConsignmentRequest msg = ConsignmentLineHandler.RemoveConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
        final String id = msg.getC2SId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.RemoveConsignmentResponse.Builder res = ConsignmentLineHandler.RemoveConsignmentResponse.newBuilder();
                ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
                if (item == null || !player.getId().equals(item.consignmentPlayerId)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NULL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                boolean ret = ConsignmentLineService.getInstance().remove(id);
                if (!ret) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_BUY"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                Out.info(new Object[]{"回收拍卖道具 playerId=", this.val$player.getId(), ",itemId=", this.val$id, ",code=", item.db.code, ",count=", Integer.valueOf(item.groupCount)});

                DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
                String itemName = MessageUtil.itemColorName(itemBase.qcolor, itemBase.name);
                MailSysData mailData = new MailSysData("Consignment_withdraw");
                mailData.replace = new TreeMap<>();
                mailData.replace.put("storeItem", itemName);
                mailData.entityItems = new ArrayList();
                mailData.entityItems.add(item.db);
                WNMail mail = MailUtil.getInstance().createMail((MailData) mailData, player.getId(), Const.GOODS_CHANGE_TYPE.CONSIGNMENT_REMOVE);
                MailUtil.getInstance().sendMail(player, mail);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


