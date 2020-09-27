/*     */ package com.wanniu.game.daoyou.dao;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.db.ModifyDataType;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.poes.DaoYouMemberPO;
/*     */ import com.wanniu.game.poes.DaoYouPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.Transaction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DaoYouDao
/*     */ {
/*     */   public static List<DaoYouPO> getAllDaoYouList() {
/*  31 */     Map<String, String> dataMap = GCache.hgetAll(ConstsTR.daoYouTR.value);
/*  32 */     if (dataMap == null || dataMap.isEmpty()) {
/*  33 */       List<DaoYouPO> daoYouList = GameDao.findFromDB(ConstsTR.daoYouTR, null, DaoYouPO.class);
/*  34 */       dataMap = new HashMap<>();
/*  35 */       for (int i = 0; i < daoYouList.size(); i++) {
/*  36 */         DaoYouPO dy = daoYouList.get(i);
/*  37 */         dataMap.put(dy.id, Utils.serialize(dy));
/*     */       } 
/*  39 */       if (dataMap.size() > 0) {
/*  40 */         GCache.hmset(ConstsTR.daoYouTR.value, dataMap);
/*     */       }
/*  42 */       return daoYouList;
/*     */     } 
/*  44 */     List<DaoYouPO> list = new ArrayList<>();
/*  45 */     if (dataMap != null && !dataMap.isEmpty()) {
/*  46 */       for (String data : dataMap.values()) {
/*  47 */         DaoYouPO daoYouPO = (DaoYouPO)Utils.deserialize(data, DaoYouPO.class);
/*  48 */         if (daoYouPO != null) {
/*  49 */           list.add(daoYouPO);
/*     */         }
/*     */       } 
/*     */     }
/*  53 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateDaoYou(DaoYouPO data) {
/*     */     try {
/*  63 */       GCache.hset(ConstsTR.daoYouTR.value, data.id, Utils.serialize(data));
/*  64 */       GameDao.updateToDB(ConstsTR.daoYouTR, data.id, ModifyDataType.MAP);
/*  65 */     } catch (Exception e) {
/*  66 */       Out.error(new Object[] { e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<DaoYouMemberPO> getAllDaoYouMember() {
/*  76 */     Map<String, String> dataMap = GCache.hgetAll(ConstsTR.daoYouMemberTR.value);
/*  77 */     if (dataMap == null || dataMap.isEmpty()) {
/*  78 */       List<DaoYouMemberPO> members = GameDao.findFromDB(ConstsTR.daoYouMemberTR, null, DaoYouMemberPO.class);
/*  79 */       dataMap = new HashMap<>();
/*  80 */       for (int i = 0; i < members.size(); i++) {
/*  81 */         DaoYouMemberPO mem = members.get(i);
/*  82 */         dataMap.put(mem.playerId, Utils.serialize(mem));
/*     */       } 
/*  84 */       if (dataMap.size() > 0) {
/*  85 */         GCache.hmset(ConstsTR.daoYouMemberTR.value, dataMap);
/*     */       }
/*  87 */       return members;
/*     */     } 
/*  89 */     List<DaoYouMemberPO> list = new ArrayList<>();
/*  90 */     if (dataMap != null && !dataMap.isEmpty()) {
/*  91 */       for (String data : dataMap.values()) {
/*  92 */         DaoYouMemberPO daoYouMemPo = (DaoYouMemberPO)Utils.deserialize(data, DaoYouMemberPO.class);
/*  93 */         if (daoYouMemPo != null) {
/*  94 */           list.add(daoYouMemPo);
/*     */         }
/*     */       } 
/*     */     }
/*  98 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateDaoYouMember(DaoYouMemberPO data) {
/*     */     try {
/* 108 */       GCache.hset(ConstsTR.daoYouMemberTR.value, data.playerId, Utils.serialize(data));
/* 109 */       GameDao.updateToDB(ConstsTR.daoYouMemberTR, data.playerId, ModifyDataType.MAP);
/* 110 */     } catch (Exception err) {
/* 111 */       Out.error(new Object[] { err });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeDaoYou(DaoYouPO data) {
/* 121 */     String daoYouId = data.id;
/* 122 */     Jedis redis = GCache.getRedis();
/*     */     try {
/* 124 */       Transaction multi = redis.multi();
/* 125 */       multi.hdel(ConstsTR.daoYouTR.value, new String[] { daoYouId });
/* 126 */       multi.exec();
/*     */       
/* 128 */       GameDao.delToDB(ConstsTR.daoYouTR, daoYouId);
/* 129 */     } catch (Exception e) {
/* 130 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 132 */       GCache.release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeDaoYouMember(DaoYouMemberPO data) {
/* 142 */     String daoYouMemId = data.playerId;
/* 143 */     Jedis redis = GCache.getRedis();
/*     */     try {
/* 145 */       Transaction multi = redis.multi();
/* 146 */       multi.hdel(ConstsTR.daoYouMemberTR.value, new String[] { daoYouMemId });
/* 147 */       multi.exec();
/*     */       
/* 149 */       GameDao.delToDB(ConstsTR.daoYouMemberTR, daoYouMemId);
/* 150 */     } catch (Exception e) {
/* 151 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 153 */       GCache.release(redis);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\daoyou\dao\DaoYouDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */