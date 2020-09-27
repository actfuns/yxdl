/*    */ package com.wanniu.redis;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.TypeReference;
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.db.ModifyDataType;
/*    */ import com.wanniu.core.db.ModifyOperateType;
/*    */ import com.wanniu.core.db.ModifyVo;
/*    */ import com.wanniu.core.db.QueryVo;
/*    */ import com.wanniu.core.db.connet.DBClient;
/*    */ import com.wanniu.core.db.message.DBModifyMessage;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class GameDao
/*    */ {
/*    */   public static void update(String key, ConstsTR field, Object po) {
/* 23 */     update(key, field.value, po);
/*    */   }
/*    */   
/*    */   public static void update(String key, String field, Object po) {
/* 27 */     GCache.hset(key, field, Utils.serialize(po));
/*    */   }
/*    */   
/*    */   public static <T> T get(String key, String field, TypeReference<T> ref) {
/* 31 */     String data = GCache.hget(key, field);
/* 32 */     T po = null;
/* 33 */     if (StringUtil.isNotEmpty(data)) {
/* 34 */       return (T)JSON.parseObject(data, ref, new com.alibaba.fastjson.parser.Feature[0]);
/*    */     }
/* 36 */     return po;
/*    */   }
/*    */   
/*    */   public static <T> T get(String key, ConstsTR field, Class<T> clazz) {
/* 40 */     return get(key, field.value, clazz);
/*    */   }
/*    */   
/*    */   public static <T> T get(String key, String field, Class<T> clazz) {
/* 44 */     String data = GCache.hget(key, field);
/* 45 */     T po = null;
/* 46 */     if (StringUtil.isNotEmpty(data)) {
/* 47 */       Out.debug(new Object[] { data });
/* 48 */       Out.debug(new Object[] { clazz });
/* 49 */       return (T)JSON.parseObject(data, clazz);
/*    */     } 
/* 51 */     return po;
/*    */   }
/*    */   
/*    */   public static void updateToDB(ConstsTR tr, String key, ModifyDataType dataType) {
/* 55 */     ModifyVo mv = new ModifyVo(tr.value, key, ModifyOperateType.UPDATE, dataType);
/* 56 */     DBClient.getInstance().add((Message)new DBModifyMessage(mv));
/*    */   }
/*    */   
/*    */   public static void delToDB(ConstsTR tr, String key) {
/* 60 */     ModifyVo mv = new ModifyVo(tr.value, key, ModifyOperateType.DELETE);
/* 61 */     DBClient.getInstance().add((Message)new DBModifyMessage(mv));
/*    */   }
/*    */   
/*    */   public static <T> T getFromDB(ConstsTR tr, String key, Class<T> clazz) {
/* 65 */     QueryVo queryVo = new QueryVo(tr.value, key);
/* 66 */     List<T> result = DBClient.getInstance().query(queryVo, clazz);
/* 67 */     if (result.size() > 0) {
/* 68 */       return result.get(0);
/*    */     }
/* 70 */     return null;
/*    */   }
/*    */   
/*    */   public static <T> List<T> findFromDB(ConstsTR tr, String key, Class<T> clazz) {
/* 74 */     QueryVo queryVo = new QueryVo(tr.value, key);
/* 75 */     return DBClient.getInstance().query(queryVo, clazz);
/*    */   }
/*    */   
/*    */   public static boolean putName(String name, String playerId) {
/* 79 */     long code = GCache.hsetnx(ConstsTR.NAME_MODULE.value, name, playerId);
/* 80 */     return (code > 0L);
/*    */   }
/*    */   
/*    */   public static void freeName(String name) {
/* 84 */     GCache.hremove(ConstsTR.NAME_MODULE.value, name);
/*    */   }
/*    */   
/*    */   public static final Set<String> hkeys(String key) {
/* 88 */     return GCache.hkeys(key);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getIdByName(String name) {
/* 95 */     return GCache.hget(ConstsTR.NAME_MODULE.value, name);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\redis\GameDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */