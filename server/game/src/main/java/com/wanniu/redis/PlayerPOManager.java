/*     */ package com.wanniu.redis;
/*     */ 
/*     */ import com.wanniu.core.db.QueryVo;
/*     */ import com.wanniu.core.db.connet.DBClient;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.friend.FriendsCenter;
/*     */ import com.wanniu.game.mail.MailCenter;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public class PlayerPOManager
/*     */ {
/*  26 */   public static int MAX_COUNT = 100000;
/*     */   
/*  28 */   public static long EXPIRE = 3600000L;
/*     */   
/*  30 */   public static Map<String, Map<String, GEntity>> pos = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*     */   static {
/*  34 */     JobFactory.addScheduleJob(() -> clearOfflinePO(), EXPIRE, EXPIRE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, GEntity> getPlayerPOMap(String playerId) {
/*  40 */     Map<String, GEntity> playerPOMap = pos.get(playerId);
/*  41 */     if (playerPOMap == null) {
/*  42 */       playerPOMap = new ConcurrentHashMap<>();
/*  43 */       pos.put(playerId, playerPOMap);
/*     */     } 
/*  45 */     return playerPOMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends GEntity> T findPO(ConstsTR tr, String playerId, Class<T> clazz) {
/*  53 */     GEntity po = null;
/*  54 */     Map<String, GEntity> playerPOMap = getPlayerPOMap(playerId);
/*     */     
/*  56 */     String key = tr.value;
/*  57 */     if (playerPOMap.containsKey(key)) {
/*  58 */       po = playerPOMap.get(key);
/*     */     } else {
/*  60 */       po = GameDao.<GEntity>get(playerId, tr, clazz);
/*  61 */       if (po != null) {
/*  62 */         playerPOMap.put(key, po);
/*     */       } else {
/*  64 */         po = (GEntity)DBClient.getInstance().get(new QueryVo(tr.value, playerId), clazz);
/*  65 */         if (po != null) {
/*  66 */           playerPOMap.put(key, po);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  72 */     int size = pos.size();
/*  73 */     if (pos.size() > MAX_COUNT) {
/*  74 */       Out.warn(new Object[] { "po count is: ", Integer.valueOf(size) });
/*  75 */       clearOfflinePO();
/*     */     } 
/*     */     
/*  78 */     return (T)po;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearOfflinePO() {
/*  85 */     for (String rid : pos.keySet()) {
/*  86 */       if (!PlayerUtil.isLocal(rid)) {
/*  87 */         MailCenter.getInstance().onPlayerDisponse(rid);
/*  88 */         FriendsCenter.getInstance().onPlayerDisponse(rid);
/*     */         
/*  90 */         update(rid, pos.remove(rid));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void onCloseGame() {
/*  96 */     clearOfflinePO();
/*     */   }
/*     */   
/*     */   public static void clearOfflinePO(String playerId) {
/* 100 */     if (pos.containsKey(playerId)) {
/* 101 */       MailCenter.getInstance().onPlayerDisponse(playerId);
/* 102 */       FriendsCenter.getInstance().onPlayerDisponse(playerId);
/*     */       
/* 104 */       update(playerId, pos.remove(playerId));
/* 105 */       DBClient.getInstance().onPlayerleave(playerId);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sync(String playerId) {
/* 114 */     update(playerId, pos.get(playerId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void update(String playerId, Map<String, GEntity> playerPos) {
/* 122 */     if (playerPos == null) {
/*     */       return;
/*     */     }
/* 125 */     for (String tr : playerPos.keySet()) {
/* 126 */       GEntity entity = playerPos.get(tr);
/* 127 */       GameDao.update(playerId, tr, entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ConstsTR tr, String playerId, GEntity po) {
/* 135 */     Map<String, GEntity> playerPoMap = getPlayerPOMap(playerId);
/* 136 */     playerPoMap.put(tr.value, po);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\redis\PlayerPOManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */