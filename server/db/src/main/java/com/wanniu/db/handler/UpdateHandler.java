/*    */ package com.wanniu.db.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.db.ModifyDataType;
/*    */ import com.wanniu.core.db.ModifyOperateType;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.db.dao.MysqlDao;
/*    */ import com.wanniu.db.dao.RedisDao;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateHandler
/*    */   extends DBHandler
/*    */ {
/*    */   public void execute(Packet pak) {
/* 20 */     int logicServerId = ((Integer)pak.getAttr(GGlobal._KEY_LOGICSERVERID)).intValue();
/* 21 */     String dsName = (String)pak.getAttr(GGlobal._KEY_USER_ID);
/* 22 */     String dbName = (String)pak.getAttr(GGlobal._KEY_USER_NAME);
/* 23 */     String table = pak.getString();
/* 24 */     String field = pak.getString();
/* 25 */     int op = pak.getByte();
/* 26 */     String tableName = tableName(table);
/* 27 */     if (op == ModifyOperateType.DELETE.value) {
/* 28 */       MysqlDao.delete(dsName, dbName, tableName, field);
/*    */     } else {
/* 30 */       int type = pak.getByte();
/* 31 */       JSONObject entityJson = null;
/* 32 */       if (type == ModifyDataType.MAP.value) {
/* 33 */         String entityStr = RedisDao.hget(logicServerId, table, field);
/* 34 */         entityJson = JSONObject.parseObject(entityStr);
/* 35 */       } else if (type == ModifyDataType.STRING.value) {
/* 36 */         String entityStr = RedisDao.get(logicServerId, field);
/* 37 */         entityJson = JSONObject.parseObject(entityStr);
/*    */       } 
/* 39 */       if (entityJson != null) {
/* 40 */         if (op == ModifyOperateType.INSERT.value) {
/* 41 */           MysqlDao.insert(dsName, dbName, tableName, entityJson);
/*    */         }
/* 43 */         else if (MysqlDao.update(dsName, dbName, tableName, entityJson) == 0) {
/* 44 */           MysqlDao.insert(dsName, dbName, tableName, entityJson);
/*    */         } 
/*    */       } else {
/*    */         
/* 48 */         Out.error(new Object[] { Integer.valueOf(logicServerId), " 找不到TR: ", table, " Key: ", field, " type: ", Integer.valueOf(type), " 的数据 ;有可能REDIS中已经被删除" });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\handler\UpdateHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */