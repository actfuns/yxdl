/*    */ package com.wanniu.core.gm.message;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.gm.GMType;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GMJoinMessage
/*    */   extends Message
/*    */ {
/*    */   protected void write() throws IOException {
/* 19 */     this.body.writeString(GConfig.getInstance().get("server.gm.auth"));
/* 20 */     this.body.writeInt(GGame.__SERVER_ID);
/* 21 */     this.body.writeShort(GGame.getInstance().getOnlineCount());
/* 22 */     this.body.writeString(GConfig.getInstance().getGamePubHost());
/* 23 */     this.body.writeInt(GConfig.getInstance().getGamePort());
/* 24 */     this.body.writeString(GConfig.getInstance().get("game.name"));
/* 25 */     this.body.writeInt(GConfig.getInstance().getInt("game.areaId", 0));
/* 26 */     this.body.writeInt(GGame.__APP_ID);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 31 */     return GMType.JOIN;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\message\GMJoinMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */