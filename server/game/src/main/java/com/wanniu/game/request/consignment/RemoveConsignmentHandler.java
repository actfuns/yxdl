/*    */ package com.wanniu.game.request.consignment;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.MessageUtil;
/*    */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*    */ import com.wanniu.game.data.base.DItemEquipBase;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.mail.MailUtil;
/*    */ import com.wanniu.game.mail.WNMail;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import com.wanniu.game.mail.data.MailSysData;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.ConsignmentLineHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.consignmentLineHandler.removeConsignmentRequest")
/*    */ public class RemoveConsignmentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 33 */     ConsignmentLineHandler.RemoveConsignmentRequest msg = ConsignmentLineHandler.RemoveConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     final String id = msg.getC2SId();
/* 35 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 38 */           ConsignmentLineHandler.RemoveConsignmentResponse.Builder res = ConsignmentLineHandler.RemoveConsignmentResponse.newBuilder();
/* 39 */           ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
/* 40 */           if (item == null || !player.getId().equals(item.consignmentPlayerId)) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("ITEM_NULL"));
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 47 */           boolean ret = ConsignmentLineService.getInstance().remove(id);
/* 48 */           if (!ret) {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_BUY"));
/* 51 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 55 */           Out.info(new Object[] { "回收拍卖道具 playerId=", this.val$player.getId(), ",itemId=", this.val$id, ",code=", item.db.code, ",count=", Integer.valueOf(item.groupCount) });
/*    */           
/* 57 */           DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
/* 58 */           String itemName = MessageUtil.itemColorName(itemBase.qcolor, itemBase.name);
/* 59 */           MailSysData mailData = new MailSysData("Consignment_withdraw");
/* 60 */           mailData.replace = new TreeMap<>();
/* 61 */           mailData.replace.put("storeItem", itemName);
/* 62 */           mailData.entityItems = new ArrayList();
/* 63 */           mailData.entityItems.add(item.db);
/* 64 */           WNMail mail = MailUtil.getInstance().createMail((MailData)mailData, player.getId(), Const.GOODS_CHANGE_TYPE.CONSIGNMENT_REMOVE);
/* 65 */           MailUtil.getInstance().sendMail(player, mail);
/*    */           
/* 67 */           res.setS2CCode(200);
/* 68 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\RemoveConsignmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */