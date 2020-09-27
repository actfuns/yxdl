/*    */ package com.wanniu.db.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.db.dao.MysqlDao;
/*    */ import com.wanniu.db.dao.RedisDao;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NotifyHandler
/*    */   extends DBHandler
/*    */ {
/*    */   public void execute(Packet pak) {
/* 20 */     int logicServerId = ((Integer)pak.getAttr(GGlobal._KEY_LOGICSERVERID)).intValue();
/* 21 */     String dsName = (String)pak.getAttr(GGlobal._KEY_USER_ID);
/* 22 */     String dbName = (String)pak.getAttr(GGlobal._KEY_USER_NAME);
/* 23 */     String playerId = pak.getString();
/*    */     
/* 25 */     Map<String, String> pos = RedisDao.hgetAll(logicServerId, playerId);
/* 26 */     for (Map.Entry<String, String> entry : pos.entrySet()) {
/* 27 */       String table = tableName(entry.getKey());
/* 28 */       if (MysqlDao.isTable(dsName, table)) {
/* 29 */         JSONObject entityJson = JSONObject.parseObject(entry.getValue());
/* 30 */         entityJson.put("playerId", playerId);
/* 31 */         if (MysqlDao.update(dsName, dbName, table, entityJson) == 0)
/* 32 */           MysqlDao.insert(dsName, dbName, table, entityJson); 
/*    */         continue;
/*    */       } 
/* 35 */       Out.debug(new Object[] { table, " not exists!!!" });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\handler\NotifyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */