/*     */ package com.wanniu.game.rank;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RankCenter
/*     */ {
/*  27 */   private static final RankCenter instance = new RankCenter();
/*     */   
/*     */   public static RankCenter getInstance() {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */   public PlayerRankInfoPO findRankPO(String playerId) {
/*  34 */     return (PlayerRankInfoPO)PlayerPOManager.findPO(ConstsTR.playerRankTR, playerId, PlayerRankInfoPO.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*  41 */     String accountTime = GlobalConfig.WorldExp_Bonus_AccountTime;
/*  42 */     String[] rewardTime = accountTime.split("-");
/*  43 */     if (3 == rewardTime.length) {
/*  44 */       Calendar c = Calendar.getInstance();
/*  45 */       c.set(11, Integer.parseInt(rewardTime[0]));
/*  46 */       c.set(12, Integer.parseInt(rewardTime[1]));
/*  47 */       c.set(13, Integer.parseInt(rewardTime[2]));
/*  48 */       c.set(14, 0);
/*  49 */       Date nowDate = new Date();
/*  50 */       long diffTime = c.getTimeInMillis() - nowDate.getTime();
/*     */       
/*  52 */       if (diffTime < 0L) {
/*  53 */         diffTime += Const.Time.Day.getValue();
/*     */       }
/*     */       
/*  56 */       JobFactory.addDelayJob(() -> { worldLevelReward(); JobFactory.addFixedRateJob((), Const.Time.Day.getValue(), Const.Time.Day.getValue()); }diffTime);
/*     */     } 
/*     */   }
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
/*     */   
/*     */   public String getFirstRankMemberId(RankType type, int serverId) {
/*  72 */     Set<String> members = GCache.zrevrange(type.getRedisKey(serverId, 0), 0L, 0L);
/*  73 */     return members.isEmpty() ? "" : members.iterator().next();
/*     */   }
/*     */   
/*     */   public void worldLevelReward() {
/*  77 */     Out.info(new Object[] { "send world level award..." });
/*  78 */     String itemList = GlobalConfig.WorldExp_Winner_ItemList;
/*  79 */     List<MailData.Attachment> items = new ArrayList<>();
/*  80 */     String[] itemLists = itemList.split(",");
/*  81 */     for (String code : itemLists) {
/*  82 */       MailData.Attachment attachment = new MailData.Attachment();
/*  83 */       attachment.itemCode = code;
/*  84 */       attachment.itemNum = 1;
/*  85 */       items.add(attachment);
/*     */     } 
/*     */     
/*  88 */     String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
/*  89 */     if (PlayerUtil.isPlayerOpenedFunction(playerId, Const.FunctionType.WORLD_EXP.getValue())) {
/*     */       
/*  91 */       MailSysData mailData = new MailSysData("Worldexp_reward");
/*  92 */       mailData.attachments = items;
/*  93 */       MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.WORLD_LEVEL);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void delRoleClear(String playerId) {
/*  98 */     for (RankType type : RankType.values()) {
/*  99 */       if (type.getHandler() != null) {
/* 100 */         type.getHandler().delRankMember(GWorld.__SERVER_ID, playerId);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, SimpleRankData> getSimpleRankData(RankType type, int minRank, int maxRank) {
/* 107 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\RankCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */