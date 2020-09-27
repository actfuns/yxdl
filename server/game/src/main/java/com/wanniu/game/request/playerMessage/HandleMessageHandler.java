/*    */ package com.wanniu.game.request.playerMessage;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.message.MessageData;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MessageHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.messageHandler.handleMessageRequest")
/*    */ public class HandleMessageHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     final MessageHandler.HandleMessageRequest req = MessageHandler.HandleMessageRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final String id = req.getC2SId();
/* 26 */     final int operate = req.getC2SOperate();
/* 27 */     if (id == null || (operate != Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue() && operate != Const.MESSAGE_OPERATE.TYPE_REFUSE.getValue())) {
/* 28 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     }
/*    */     
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 34 */           MessageHandler.HandleMessageResponse.Builder res = MessageHandler.HandleMessageResponse.newBuilder();
/* 35 */           res.setS2CCode(200);
/* 36 */           int type = req.getC2SType();
/* 37 */           if (type == Const.MESSAGE_TYPE.team_invite.getValue() || type == Const.MESSAGE_TYPE.team_apply.getValue()) {
/* 38 */             boolean isValid = player.getTeamManager().onMessage(type, operate, id);
/* 39 */             res.setS2CIsClear(isValid ? 0 : 1);
/* 40 */           } else if (type == Const.MESSAGE_TYPE.daoyou_invite.getValue()) {
/* 41 */             boolean isValid = DaoYouService.getInstance().onMessage(player, operate, id);
/* 42 */             res.setS2CIsClear(isValid ? 0 : 1);
/*    */           } else {
/* 44 */             MessageData message = player.messageManager.getReceivedMessage(type, id);
/* 45 */             if (message != null) {
/* 46 */               boolean isValid = true;
/* 47 */               if (message.isPastDue()) {
/* 48 */                 player.messageManager.deleteReceivedMessage(type, id);
/*    */               } else {
/* 50 */                 isValid = player.onMessage(operate, message);
/*    */               } 
/* 52 */               res.setS2CIsClear(isValid ? 0 : 1);
/*    */             } else {
/* 54 */               res.setS2CCode(500);
/* 55 */               res.setS2CMsg(LangService.getValue("HAVE_THIS_MSG"));
/*    */             } 
/*    */           } 
/* 58 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerMessage\HandleMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */