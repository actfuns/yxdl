/*    */ package com.wanniu.csharp.message;
/*    */ 
/*    */ import com.wanniu.csharp.protocol.CSharpHeader;
/*    */ import com.wanniu.csharp.protocol.CSharpMessage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpPingMessage
/*    */   extends CSharpMessage
/*    */ {
/*    */   public CSharpPingMessage() {
/* 13 */     CSharpHeader header = getHeader();
/* 14 */     header.setUid("ping");
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\message\CSharpPingMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */