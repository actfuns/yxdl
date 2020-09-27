/*    */ package com.wanniu.core.proxy.message;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProxyJoinMessage
/*    */   extends Message
/*    */ {
/* 17 */   public static String SECRT = GConfig.getInstance().get("server.proxy.auth");
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 21 */     this.body.writeString(SECRT);
/* 22 */     this.body.writeInt(GGame.__SERVER_ID);
/* 23 */     this.body.writeInt(GConfig.getInstance().getInt("game.areaId", 0));
/* 24 */     this.body.writeShort(GGame.getInstance().getOnlineCount());
/* 25 */     this.body.writeString(JSON.toJSONString(GGame.__CS_NODE));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getType() {
/* 31 */     return 255;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\proxy\message\ProxyJoinMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */