/*    */ package com.wanniu.csharp;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpNode
/*    */ {
/*    */   public String serverId;
/*    */   public String host;
/*    */   public int port;
/* 13 */   public int icePort = 3905;
/*    */   
/*    */   public String getNodeId() {
/* 16 */     return this.serverId + ":" + GGame.__SERVER_ID;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CSharpNode() {}
/*    */ 
/*    */   
/*    */   public CSharpNode(String serverId, String host, int port, int icePort) {
/* 25 */     this.serverId = serverId;
/* 26 */     this.host = host;
/* 27 */     this.port = port;
/* 28 */     this.icePort = icePort;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 32 */     return this.serverId + " <-> " + this.host + ":" + this.port + ":" + this.icePort;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\CSharpNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */