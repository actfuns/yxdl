/*     */ package com.wanniu.game.five2Five.dao;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.TypeReference;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.five2Five.Five2FivePlayerResultInfoVo;
/*     */ import com.wanniu.game.poes.Five2FivePO;
/*     */ import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
/*     */ import com.wanniu.game.poes.Five2FiveSystemPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
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
/*     */ public class Five2FiveDao
/*     */ {
/*     */   public static void updateFive2FiveSystem(Five2FiveSystemPO systemPo) {
/*  38 */     GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fivie2FiveSystemTR, systemPo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Five2FiveSystemPO getFive2FivePO(String logicServerId) {
/*  47 */     return (Five2FiveSystemPO)GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fivie2FiveSystemTR, Five2FiveSystemPO.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updatePlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
/*  56 */     Jedis redis = GCache.getRedis();
/*     */     try {
/*  58 */       Transaction multi = redis.multi();
/*  59 */       multi.hset(getBtlReportTR(btlPo.playerId), btlPo.id, Utils.serialize(btlPo));
/*  60 */       multi.exec();
/*  61 */     } catch (Exception e) {
/*  62 */       Out.error(new Object[] { e });
/*     */     } finally {
/*  64 */       GCache.release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void delPlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
/*  74 */     Jedis redis = GCache.getRedis();
/*     */     try {
/*  76 */       Transaction multi = redis.multi();
/*  77 */       multi.hdel(getBtlReportTR(btlPo.playerId), new String[] { btlPo.id });
/*  78 */       multi.exec();
/*  79 */     } catch (Exception e) {
/*  80 */       Out.error(new Object[] { e });
/*     */     } finally {
/*  82 */       GCache.release(redis);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Five2FivePO getPlayerFive2FivePO(String playerId) {
/*  93 */     return (Five2FivePO)PlayerPOManager.findPO(ConstsTR.five2FiveTR, playerId, Five2FivePO.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Five2FivePlayerBtlReportPO> getPlayerFive2FiveBtlReportPO(String playerId) {
/* 103 */     List<Five2FivePlayerBtlReportPO> list = new ArrayList<>();
/* 104 */     Map<String, String> dataMap = GCache.hgetAll(getBtlReportTR(playerId));
/* 105 */     if (dataMap != null && !dataMap.isEmpty()) {
/* 106 */       for (String data : dataMap.values()) {
/* 107 */         Five2FivePlayerBtlReportPO btlReportPo = (Five2FivePlayerBtlReportPO)Utils.deserialize(data, Five2FivePlayerBtlReportPO.class);
/* 108 */         if (btlReportPo != null) {
/* 109 */           list.add(btlReportPo);
/*     */         }
/*     */       } 
/*     */     }
/* 113 */     Collections.sort(list, new Comparator<Five2FivePlayerBtlReportPO>()
/*     */         {
/*     */           public int compare(Five2FivePlayerBtlReportPO o1, Five2FivePlayerBtlReportPO o2)
/*     */           {
/* 117 */             long i = o2.createTime.getTime() - o1.createTime.getTime();
/* 118 */             if (i > 0L)
/* 119 */               return 1; 
/* 120 */             if (i < 0L) {
/* 121 */               return -1;
/*     */             }
/* 123 */             return 0;
/*     */           }
/*     */         });
/* 126 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateShardBtlReport(String instanceId, List<Five2FivePlayerResultInfoVo> resultInfos) {
/* 136 */     String resultInfoJson = Utils.serialize(resultInfos);
/* 137 */     int expired = 86400;
/* 138 */     GCache.put(getShardBtlReportTR(instanceId), resultInfoJson, expired);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Five2FivePlayerResultInfoVo> getShardBtlReport(String instanceId) {
/* 148 */     String data = GCache.get(getShardBtlReportTR(instanceId));
/* 149 */     List<Five2FivePlayerResultInfoVo> resultInfos = new ArrayList<>();
/* 150 */     if (StringUtil.isNotEmpty(data)) {
/* 151 */       resultInfos = (List<Five2FivePlayerResultInfoVo>)JSON.parseObject(data, new TypeReference<List<Five2FivePlayerResultInfoVo>>() {  }, new com.alibaba.fastjson.parser.Feature[0]);
/*     */     }
/* 153 */     return resultInfos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getBtlReportTR(String playerId) {
/* 163 */     return ConstsTR.five2FiveBtlTR.value + "/" + playerId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getShardBtlReportTR(String instanceId) {
/* 173 */     return ConstsTR.five2FiveShardBtlReportTR.value + "/" + instanceId;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\dao\Five2FiveDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */