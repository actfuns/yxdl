/*     */ package com.wanniu.game.guild.guidDepot;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.RecordInfo;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildDepotPO;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ public class GuildDepotCenter
/*     */ {
/*     */   private static GuildDepotCenter instance;
/*     */   public Map<String, GuildDepot> depotMap;
/*     */   
/*     */   public static GuildDepotCenter getInstance() {
/*  23 */     if (instance == null) {
/*  24 */       instance = new GuildDepotCenter();
/*     */     }
/*     */     
/*  27 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuildDepotCenter() {
/*  33 */     this.depotMap = new HashMap<>();
/*  34 */     init();
/*     */   }
/*     */   
/*     */   public void init() {
/*  38 */     initFromRedis();
/*     */     
/*  40 */     JobFactory.addDelayJob(new Runnable() {
/*     */           public void run() {
/*  42 */             GuildDepotCenter.this.saveAllDepot();
/*     */           }
/*  44 */         },  Const.Time.Minute.getValue());
/*     */   }
/*     */   
/*     */   public GuildDepot getDepot(String guildId) {
/*  48 */     return this.depotMap.get(guildId);
/*     */   }
/*     */   
/*     */   public void initFromRedis() {
/*  52 */     ArrayList<GuildDepotPO> depotList = GuildUtil.getGuildDepotList();
/*  53 */     for (GuildDepotPO depotData : depotList) {
/*  54 */       GuildDepot depot = new GuildDepot(depotData);
/*  55 */       this.depotMap.put(depot.depotData.id, depot);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createDepot(String guildId, int logicServerId) {
/*  60 */     GuildDepot depot = getDepot(guildId);
/*  61 */     if (null == depot) {
/*  62 */       depot = GuildDepot.createEmptyDepot(guildId, logicServerId);
/*  63 */       this.depotMap.put(depot.depotData.id, depot);
/*     */       
/*  65 */       saveDepot(guildId);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveAllDepot() {
/*  70 */     for (String key : this.depotMap.keySet()) {
/*  71 */       saveDepot(key);
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveDepot(String id) {
/*  76 */     GuildDepot depot = getDepot(id);
/*  77 */     if (null == depot) {
/*     */       return;
/*     */     }
/*  80 */     GuildDepotPO depotData = depot.toJson4Serialize();
/*  81 */     GuildUtil.updateGuildDepot(depotData);
/*     */   }
/*     */   
/*     */   public PlayerGuildDepot getDepotDataByPlayerId(WNPlayer player) {
/*  85 */     PlayerGuildDepot data = new PlayerGuildDepot();
/*  86 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
/*  87 */     if (null == myInfo) {
/*  88 */       return null;
/*     */     }
/*     */     
/*  91 */     GuildDepot depot = getDepot(myInfo.guildId);
/*  92 */     if (null == depot) {
/*  93 */       return data;
/*     */     }
/*     */     
/*  96 */     data.depotInfo = depot.getDepotInfo();
/*  97 */     data.bagInfo = depot.bag.toJson4Payload();
/*  98 */     data.detailInfo = depot.bag.getAllEquipDetails4PayLoad(player.playerBasePO);
/*  99 */     return data;
/*     */   }
/*     */   
/*     */   public ArrayList<RecordInfo> getDepotRecordByPlayerId(String playerId, int page) {
/* 103 */     ArrayList<RecordInfo> data = new ArrayList<>();
/* 104 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
/* 105 */     if (null == myInfo) {
/* 106 */       return null;
/*     */     }
/*     */     
/* 109 */     GuildDepot depot = getDepot(myInfo.guildId);
/* 110 */     if (null == depot) {
/* 111 */       return data;
/*     */     }
/*     */     
/* 114 */     data = depot.getRecordList(page);
/* 115 */     return data;
/*     */   }
/*     */   
/*     */   public ArrayList<ItemOuterClass.ItemDetail> getDepotDetailsByPlayerId(WNPlayer player) {
/* 119 */     ArrayList<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/* 120 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
/* 121 */     if (null == myInfo) {
/* 122 */       return null;
/*     */     }
/* 124 */     GuildDepot depot = getDepot(myInfo.guildId);
/* 125 */     if (null == depot) {
/* 126 */       return null;
/*     */     }
/* 128 */     data = depot.bag.getAllEquipDetails4PayLoad(player.playerBasePO);
/* 129 */     return data;
/*     */   }
/*     */   
/*     */   public GuildDepotOneGrid getDepotOneGridInfoByPlayerId(WNPlayer player, int bagIndex) {
/* 133 */     GuildDepotOneGrid data = new GuildDepotOneGrid();
/* 134 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
/* 135 */     if (null == myInfo) {
/* 136 */       return null;
/*     */     }
/*     */     
/* 139 */     GuildDepot depot = getDepot(myInfo.guildId);
/* 140 */     if (null == depot) {
/* 141 */       return null;
/*     */     }
/*     */     
/* 144 */     data = depot.bag.getGridAndDetailByIndex(player.playerBasePO, bagIndex);
/*     */     
/* 146 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guidDepot\GuildDepotCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */