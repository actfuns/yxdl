/*    */ package com.wanniu.csharp.message;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.csharp.protocol.CSharpHeader;
/*    */ import com.wanniu.csharp.protocol.CSharpMessage;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpJoinMessage
/*    */   extends CSharpMessage
/*    */ {
/*    */   private byte[] serverId;
/*    */   
/*    */   public CSharpJoinMessage(String serverId) {
/* 18 */     this.serverId = serverId.getBytes(GGlobal.UTF_8);
/* 19 */     CSharpHeader header = getHeader();
/* 20 */     header.setUid("connetorId");
/* 21 */     header.setLength(this.serverId.length);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 26 */     this.body.writeBytes(this.serverId);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\message\CSharpJoinMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */