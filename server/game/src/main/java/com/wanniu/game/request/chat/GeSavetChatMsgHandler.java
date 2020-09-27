/*    */ package com.wanniu.game.request.chat;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.chat.ChatHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("chat.chatHandler.getSaveChatMsgRequest")
/*    */ public class GeSavetChatMsgHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     ChatHandler.GetSaveChatMsgRequest req = ChatHandler.GetSaveChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
/* 17 */     int scope = req.getC2SScope();
/* 18 */     String uid = req.getC2SUid();
/* 19 */     int index = req.getC2SIndex();
/*    */ 
/*    */     
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           ChatHandler.GetSaveChatMsgResponse.Builder res = ChatHandler.GetSaveChatMsgResponse.newBuilder();
/* 26 */           res.setS2CCode(200);
/*    */           
/* 28 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\chat\GeSavetChatMsgHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */