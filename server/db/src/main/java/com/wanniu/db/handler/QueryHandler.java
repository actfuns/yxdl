/*    */ package com.wanniu.db.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.db.PoolFactory;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.tcp.protocol.Prefix;
/*    */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*    */ import com.wanniu.db.dao.MysqlDao;
/*    */ import java.io.IOException;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class QueryHandler
/*    */   extends DBHandler
/*    */ {
/* 27 */   private final Executor ansycExec = new ThreadPoolExecutor(
/* 28 */       GConfig.getInstance().getInt("async.query.min", 1), 
/* 29 */       GConfig.getInstance().getInt("async.query.max", 5), 
/* 30 */       GConfig.getInstance().getInt("async.query.idle", 30), TimeUnit.SECONDS, 
/* 31 */       new LinkedBlockingQueue<>(), (ThreadFactory)new PoolFactory("查询服务"));
/*    */   
/*    */   private void ansycExec(final Runnable command) {
/* 34 */     this.ansycExec.execute(new Runnable()
/*    */         {
/*    */           public void run() {
/*    */             try {
/* 38 */               command.run();
/* 39 */             } catch (Exception e) {
/* 40 */               Out.error(new Object[] { e });
/*    */             } 
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(Packet pak) {
/* 48 */     ansycExec(() -> {
/*    */           String tableName;
/*    */           String dsName = (String)paramPacket.getAttr(GGlobal._KEY_USER_ID);
/*    */           String dbName = (String)paramPacket.getAttr(GGlobal._KEY_USER_NAME);
/*    */           long reqId = paramPacket.getLong();
/*    */           String table = paramPacket.getString();
/*    */           int type = paramPacket.getByte();
/*    */           String val = paramPacket.getString();
/*    */           JSONObject conVal = null;
/*    */           switch (type) {
/*    */             case 1:
/*    */               tableName = tableName(table);
/*    */               if (MysqlDao.isTable(dsName, tableName)) {
/*    */                 conVal = new JSONObject();
/*    */                 conVal.put((MysqlDao.getPkeyField(dsName, tableName)).filedName, val);
/*    */               } 
/*    */               break;
/*    */             case 2:
/*    */             case 3:
/*    */               if (val != null) {
/*    */                 conVal = JSON.parseObject(val);
/*    */               }
/*    */               break;
/*    */           } 
/*    */           final String result = (type == 3) ? MysqlDao.executeQuery(dsName, table, conVal) : MysqlDao.select(dsName, dbName, tableName(table), conVal);
/*    */           RequestMessage res = new RequestMessage()
/*    */             {
/*    */               protected void write() throws IOException {
/* 76 */                 this.body.writeLong(this.reqId);
/* 77 */                 this.body.writeBytes(Prefix.INT, (result == null) ? null : result.getBytes(GGlobal.UTF_8));
/*    */               }
/*    */               
/*    */               public short getType() {
/* 81 */                 return DBType.QUERY;
/*    */               }
/*    */             };
/*    */           res.setReqId(reqId);
/*    */           paramPacket.getSession().writeAndFlush(res);
/*    */         });
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\handler\QueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */