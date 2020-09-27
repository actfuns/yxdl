/*    */ package com.wanniu.core.db.message;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBJoinMessage
/*    */   extends RequestMessage
/*    */ {
/*    */   protected void write() throws IOException {
/* 18 */     this.body.writeLong(this.reqId);
/* 19 */     this.body.writeInt(GGame.__SERVER_ID);
/*    */     
/* 21 */     String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
/* 22 */     int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
/* 23 */     String pwd = GConfig.getInstance().get("server.redis.password");
/* 24 */     int db = GConfig.getInstance().getInt("server.redis.db", 0);
/*    */     
/* 26 */     this.body.writeString(redisHost);
/* 27 */     this.body.writeShort(redisPort);
/* 28 */     this.body.writeString(pwd);
/* 29 */     this.body.writeByte(db);
/*    */     
/* 31 */     this.body.writeString(GConfig.getInstance().get("game.dsname", "game-ds"));
/* 32 */     this.body.writeString(GConfig.getInstance().get("game.dbname", "game_db"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getType() {
/* 38 */     return DBType.JOIN;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\message\DBJoinMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */