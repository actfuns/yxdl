/*     */ package com.wanniu.game.guild.guildBless;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.RecordInfo;
/*     */ import com.wanniu.game.guild.po.GuildBlessPO;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.guild.GuildManagerHandler;
/*     */ 
/*     */ 
/*     */ public class GuildBlessCenter
/*     */ {
/*     */   private static GuildBlessCenter instance;
/*     */   public Map<String, GuildBless> blessMap;
/*     */   
/*     */   public static GuildBlessCenter getInstance() {
/*  24 */     if (instance == null) {
/*  25 */       instance = new GuildBlessCenter();
/*     */     }
/*     */     
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */   private GuildBlessCenter() {
/*  32 */     init();
/*     */   }
/*     */   
/*     */   public void init() {
/*  36 */     this.blessMap = new HashMap<>();
/*  37 */     initFromRedis();
/*     */ 
/*     */     
/*  40 */     JobFactory.addDelayJob(new Runnable()
/*     */         {
/*     */           public void run() {
/*  43 */             GuildBlessCenter.this.saveAllBless();
/*     */           }
/*  45 */         },  Const.Time.Minute.getValue());
/*     */   }
/*     */   
/*     */   public GuildBlessPO getBlessData(String guildId) {
/*  49 */     if (StringUtil.isEmpty(guildId)) {
/*  50 */       return null;
/*     */     }
/*     */     
/*  53 */     GuildBless bless = this.blessMap.get(guildId);
/*  54 */     if (null == bless) {
/*  55 */       return null;
/*     */     }
/*     */     
/*  58 */     return bless.blessData;
/*     */   }
/*     */   
/*     */   public GuildBless getBless(String guildId) {
/*  62 */     return this.blessMap.get(guildId);
/*     */   }
/*     */   
/*     */   public void initFromRedis() {
/*  66 */     ArrayList<GuildBlessPO> blessList = GuildUtil.getGuildBlessList();
/*  67 */     for (GuildBlessPO blessData : blessList) {
/*  68 */       GuildBless bless = new GuildBless(blessData, blessData.logicServerId);
/*  69 */       this.blessMap.put(bless.id, bless);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createBless(String guildId, int logicServerId) {
/*  74 */     GuildBless bless = getBless(guildId);
/*  75 */     if (null == bless) {
/*  76 */       bless = new GuildBless(guildId, logicServerId);
/*  77 */       this.blessMap.put(bless.id, bless);
/*     */       
/*  79 */       saveBless(guildId);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveAllBless() {
/*  84 */     for (String key : this.blessMap.keySet()) {
/*  85 */       saveBless(key);
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveBless(String id) {
/*  90 */     GuildBless bless = getBless(id);
/*  91 */     if (null == bless) {
/*     */       return;
/*     */     }
/*  94 */     bless.saveToMysql();
/*     */   }
/*     */   
/*     */   public GuildBless getBlessByPlayerId(String playerId) {
/*  98 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  99 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 100 */     if (null == myInfo) {
/* 101 */       return null;
/*     */     }
/* 103 */     GuildBless bless = getBless(myInfo.guildId);
/* 104 */     if (null == bless) {
/* 105 */       return null;
/*     */     }
/* 107 */     return bless;
/*     */   }
/*     */   
/*     */   public GuildManagerHandler.GuildBlessInfo getBlessInfoByPlayerId(String playerId) {
/* 111 */     GuildManagerHandler.GuildBlessInfo.Builder data = GuildManagerHandler.GuildBlessInfo.newBuilder();
/* 112 */     GuildBless bless = getBlessByPlayerId(playerId);
/* 113 */     if (null == bless) {
/* 114 */       return data.build();
/*     */     }
/*     */     
/* 117 */     return bless.toJson4PayLoad();
/*     */   }
/*     */   
/*     */   public List<RecordInfo> getBlessRecordByPlayerId(String playerId, int page) {
/* 121 */     List<RecordInfo> data = new ArrayList<>();
/* 122 */     GuildBless bless = getBlessByPlayerId(playerId);
/* 123 */     if (null == bless) {
/* 124 */       return data;
/*     */     }
/* 126 */     return bless.getRecordList(page);
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {
/* 130 */     for (GuildBless bless : this.blessMap.values()) {
/* 131 */       if (null == bless) {
/*     */         continue;
/*     */       }
/* 134 */       bless.checkRefreshNewDay(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBless\GuildBlessCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */