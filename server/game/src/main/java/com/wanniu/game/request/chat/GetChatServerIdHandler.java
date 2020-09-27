/*    */ package com.wanniu.game.request.chat;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ 
/*    */ @GClientEvent("chat.chatHandler.getChatServerIdRequest")
/*    */ public class GetChatServerIdHandler
/*    */   extends PomeloRequest {
/*    */   public PomeloResponse request() throws Exception {
/* 12 */     return (PomeloResponse)new ErrorResponse("404");
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\chat\GetChatServerIdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */