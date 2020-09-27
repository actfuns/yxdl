/*    */ package com.wanniu.db.handler;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.db.DBServer;
/*    */ import com.wanniu.db.dao.RedisDao;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*    */ import redis.clients.jedis.JedisPool;
/*    */ import redis.clients.jedis.JedisPoolConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegisterHandler
/*    */   extends DBHandler
/*    */ {
/*    */   public void execute(Packet pak) {
/* 25 */     long reqId = pak.getLong();
/* 26 */     int logicServerId = pak.getInt();
/* 27 */     pak.setAttr(GGlobal._KEY_LOGICSERVERID, Integer.valueOf(logicServerId));
/*    */     
/*    */     try {
/* 30 */       String redisHost = pak.getString();
/* 31 */       int redisPort = pak.getShort();
/* 32 */       int db = pak.getByte();
/* 33 */       String pwd = pak.getString();
/*    */       
/* 35 */       int timeout = GConfig.getInstance().getInt("server.redis.timeout", 2000);
/*    */       
/* 37 */       JedisPoolConfig config = new JedisPoolConfig();
/*    */       
/* 39 */       config.setTestOnBorrow(GConfig.getInstance().getBoolean("server.redis.testonborrow", true));
/*    */       
/* 41 */       config.setTestOnReturn(GConfig.getInstance().getBoolean("server.redis.testonreturn", true));
/* 42 */       config.setMaxIdle(GConfig.getInstance().getInt("server.redis.maxidle", 20));
/* 43 */       config.setMaxWaitMillis(GConfig.getInstance().getInt("server.redis.maxwait", 1000));
/* 44 */       config.setMaxTotal(GConfig.getInstance().getInt("server.redis.total", 5));
/*    */       
/* 46 */       JedisPool pool = new JedisPool((GenericObjectPoolConfig)config, redisHost, redisPort, timeout, pwd, db);
/*    */       
/* 48 */       JedisPool oldPool = RedisDao.putRedisPools(logicServerId, pool);
/* 49 */       if (oldPool != null) {
/* 50 */         oldPool.destroy();
/*    */       }
/*    */ 
/*    */ 
/*    */       
/* 55 */       String dsName = pak.getString();
/* 56 */       String dbName = pak.getString();
/* 57 */       pak.setAttr(GGlobal._KEY_USER_ID, dsName);
/* 58 */       pak.setAttr(GGlobal._KEY_USER_NAME, dbName);
/*    */     }
/* 60 */     catch (Exception e) {
/* 61 */       write(new RegisterResponse(reqId, 500));
/* 62 */       Out.error(new Object[] { e });
/*    */       
/*    */       return;
/*    */     } 
/* 66 */     DBServer.Channels.put(Integer.valueOf(logicServerId), pak.getSession());
/*    */     
/* 68 */     Out.info(new Object[] { "服务器:【" + logicServerId + "】 注册成功！" });
/* 69 */     write(new RegisterResponse(reqId, 200));
/*    */   }
/*    */   
/*    */   private static class RegisterResponse
/*    */     extends Message {
/*    */     long reqId;
/*    */     int status;
/*    */     
/*    */     RegisterResponse(long reqId, int status) {
/* 78 */       this.reqId = reqId;
/* 79 */       this.status = status;
/*    */     }
/*    */ 
/*    */     
/*    */     protected void write() throws IOException {
/* 84 */       this.body.writeLong(this.reqId);
/* 85 */       this.body.writeInt(this.status);
/*    */     }
/*    */ 
/*    */     
/*    */     public short getType() {
/* 90 */       return DBType.JOIN;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\handler\RegisterHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */