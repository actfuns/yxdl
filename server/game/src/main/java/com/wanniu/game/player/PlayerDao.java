/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.TypeReference;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.poes.AchievementDataPO;
/*     */ import com.wanniu.game.poes.HookSetPO;
/*     */ import com.wanniu.game.poes.PlayerAttachPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import com.wanniu.game.poes.PlayerChouRenPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.PlayerTempPO;
/*     */ import com.wanniu.game.poes.TaskListPO;
/*     */ import com.wanniu.game.poes.XianYuanPO;
/*     */ import com.wanniu.redis.GlobalDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class PlayerDao
/*     */ {
/*     */   public static void insertPlayerId(AllBlobPO allBlob) {
/*  35 */     int logicServerId = allBlob.player.logicServerId;
/*  36 */     List<String> rids = getPlayerIdsByUid(allBlob.player.uid, logicServerId);
/*  37 */     rids.add(allBlob.player.id);
/*  38 */     String key = ConstsTR.playerIdsTR + "/" + allBlob.player.uid;
/*  39 */     GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void insertPlayerId(PlayerPO po, AllBlobPO newBlob) {
/*  46 */     int logicServerId = newBlob.player.logicServerId;
/*  47 */     List<String> rids = getPlayerIdsByUid(newBlob.player.uid, logicServerId);
/*  48 */     rids.add(po.id);
/*  49 */     String key = ConstsTR.playerIdsTR + "/" + newBlob.player.uid;
/*  50 */     GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
/*     */   }
/*     */   
/*     */   public static List<String> getPlayerIdsByUid(String uid, int logicServerId) {
/*  54 */     String key = ConstsTR.playerIdsTR + "/" + uid;
/*  55 */     String existsRids = GlobalDao.hget(String.valueOf(logicServerId), key);
/*  56 */     List<String> rids = null;
/*  57 */     if (StringUtil.isNotEmpty(existsRids)) {
/*  58 */       rids = (List<String>)JSON.parseObject(existsRids, new TypeReference<List<String>>() {  }, new com.alibaba.fastjson.parser.Feature[0]);
/*     */     }
/*  60 */     return (rids == null) ? new ArrayList<>() : rids;
/*     */   }
/*     */   
/*     */   public static void updatePlayerIds(String uid, int logicServerId, List<String> rids) {
/*  64 */     String key = ConstsTR.playerIdsTR + "/" + uid;
/*  65 */     GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
/*     */   }
/*     */   
/*     */   public static AllBlobPO getAllBlobData(String playerId) {
/*  69 */     PlayerPO player = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*     */     
/*  71 */     PlayerBasePO playerBase = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);
/*     */     
/*  73 */     PlayerTempPO playerTemp = (PlayerTempPO)PlayerPOManager.findPO(ConstsTR.playerTempTR, playerId, PlayerTempPO.class);
/*     */     
/*  75 */     AllBlobPO allBlobData = new AllBlobPO(player, playerBase, playerTemp);
/*  76 */     allBlobData.playerAttachPO = (PlayerAttachPO)PlayerPOManager.findPO(ConstsTR.playerAttachTR, playerId, PlayerAttachPO.class);
/*  77 */     allBlobData.tasks = (TaskListPO)PlayerPOManager.findPO(ConstsTR.taskTR, playerId, TaskListPO.class);
/*  78 */     allBlobData.achievements = (AchievementDataPO)PlayerPOManager.findPO(ConstsTR.achievementTR, playerId, AchievementDataPO.class);
/*  79 */     allBlobData.hookSetData = (HookSetPO)PlayerPOManager.findPO(ConstsTR.hookSetTR, playerId, HookSetPO.class);
/*  80 */     allBlobData.chouRens = (PlayerChouRenPO)PlayerPOManager.findPO(ConstsTR.player_chourenTR, playerId, PlayerChouRenPO.class);
/*  81 */     allBlobData.xianYuan = (XianYuanPO)PlayerPOManager.findPO(ConstsTR.xianYuanTR, playerId, XianYuanPO.class);
/*     */     
/*  83 */     return allBlobData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PlayerPO getPlayerDataById(String playerId) throws Exception {
/*  91 */     PlayerPO player = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*  92 */     if (null != player && player.isDelete == 0) {
/*  93 */       return player;
/*     */     }
/*  95 */     return player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean putName(String name, String playerId) {
/* 102 */     long code = GlobalDao.hsetnx(ConstsTR.NAME_MODULE.value, name, playerId);
/* 103 */     return (code > 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean existsName(String name) {
/* 110 */     return GlobalDao.hexists(ConstsTR.NAME_MODULE.value, name);
/*     */   }
/*     */   
/*     */   public static void freeName(String name) {
/* 114 */     GlobalDao.hremove(ConstsTR.NAME_MODULE.value, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getIdByName(String name) {
/* 121 */     return GlobalDao.hget(ConstsTR.NAME_MODULE.value, name);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PlayerDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */