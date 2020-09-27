/*     */ package com.wanniu.game.guild.guildTech;
/*     */ 
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GTechnologyItemCO;
/*     */ import com.wanniu.game.data.GTechnologyLevelCO;
/*     */ import com.wanniu.game.data.GuildBuildingCO;
/*     */ import com.wanniu.game.guild.GuildMsg;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildTech
/*     */ {
/*     */   public String id;
/*     */   public int level;
/*     */   public int buffLevel;
/*     */   public int refreshLevel;
/*     */   public Map<String, Integer> products;
/*     */   
/*     */   public int randIndexByWeight(ArrayList<Map<String, Integer>> objArr, String weightKey) {
/*  28 */     if (objArr.size() == 0) {
/*  29 */       return -1;
/*     */     }
/*     */     
/*  32 */     String key = "weight";
/*  33 */     if (null != weightKey) {
/*  34 */       key = weightKey;
/*     */     }
/*     */     
/*  37 */     int totalWeight = 0;
/*  38 */     for (int i = 0; i < objArr.size(); i++) {
/*  39 */       totalWeight += ((Integer)((Map)objArr.get(i)).get(key)).intValue();
/*     */     }
/*  41 */     int randNum = Utils.random(1, totalWeight);
/*  42 */     int totalNum = 0;
/*  43 */     for (int j = 0; j < objArr.size(); j++) {
/*  44 */       totalNum += ((Integer)((Map)objArr.get(j)).get(key)).intValue();
/*  45 */       if (randNum <= totalNum) {
/*  46 */         return j;
/*     */       }
/*     */     } 
/*  49 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuildTech(GuildTechData techData) {
/*  59 */     this.id = techData.id;
/*  60 */     GuildTechData.GuildTechBlob blobData = techData.blobData;
/*  61 */     this.level = blobData.level;
/*  62 */     this.buffLevel = blobData.buffLevel;
/*  63 */     this.refreshLevel = blobData.refreshLevel;
/*  64 */     this.products = blobData.products;
/*  65 */     if (null != this.products && this.products.size() > 0) {
/*  66 */       randomProduce();
/*     */     }
/*     */   }
/*     */   
/*     */   public GuildTech(String guildId) {
/*  71 */     createDefaultTech(guildId);
/*     */   }
/*     */   
/*     */   public void createDefaultTech(String guildId) {
/*  75 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
/*  76 */     this.id = guildId;
/*  77 */     this.level = buildProp.minLv;
/*  78 */     this.buffLevel = 0;
/*  79 */     this.refreshLevel = this.level;
/*  80 */     this.products = new HashMap<>();
/*     */     
/*  82 */     randomProduce();
/*     */   }
/*     */   
/*     */   public void randomProduce() {
/*  86 */     this.refreshLevel = this.level;
/*  87 */     if (null != this.products) {
/*  88 */       this.products.clear();
/*     */     }
/*  90 */     Map<Integer, GTechnologyItemCO> producePropList = GuildUtil.getTechProducePropList();
/*  91 */     GTechnologyLevelCO levelProp = GuildUtil.getTechLevelPropByLevel(this.refreshLevel);
/*     */     
/*  93 */     ArrayList<Map<String, Integer>> produceList = new ArrayList<>();
/*  94 */     for (GTechnologyItemCO prop : producePropList.values()) {
/*  95 */       Map<String, Integer> item = new HashMap<>();
/*  96 */       item.put("iD", Integer.valueOf(prop.iD));
/*  97 */       item.put("pro", Integer.valueOf(prop.pro));
/*  98 */       item.put("count", Integer.valueOf(prop.count));
/*  99 */       produceList.add(item);
/*     */     } 
/*     */     
/* 102 */     int kindNum = (levelProp.techItemDayCount < produceList.size()) ? levelProp.techItemDayCount : produceList.size();
/* 103 */     for (int i = 0; i < kindNum; i++) {
/* 104 */       int index = randIndexByWeight(produceList, "pro");
/* 105 */       if (index == -1) {
/*     */         break;
/*     */       }
/* 108 */       Map<String, Integer> item = produceList.get(index);
/* 109 */       this.products.put(Integer.toString(((Integer)item.get("iD")).intValue()), item.get("count"));
/* 110 */       produceList.remove(index);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void refreshNewDay(boolean isPush) {
/* 116 */     randomProduce();
/* 117 */     if (isPush) {
/* 118 */       GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
/* 119 */       msgData.techData.blobData.products = this.products;
/* 120 */       GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_NEW_DAY_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 121 */       GuildService.notifyAllMemberRefreshGuild(this.id, msg, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuildTechData toJson4Serialize() {
/* 126 */     GuildTechData data = new GuildTechData();
/* 127 */     data.id = this.id;
/* 128 */     data.blobData = new GuildTechData.GuildTechBlob();
/* 129 */     data.blobData.level = this.level;
/* 130 */     data.blobData.buffLevel = this.buffLevel;
/* 131 */     data.blobData.refreshLevel = this.refreshLevel;
/* 132 */     data.blobData.products = this.products;
/* 133 */     return data;
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
/*     */   public void upgradeLevel(WNPlayer player) {
/* 146 */     this.level++;
/* 147 */     GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
/* 148 */     msgData.techData.blobData.level = this.level;
/* 149 */     GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_LEVEL_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 150 */     GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
/*     */   }
/*     */   
/*     */   public void upgradeBuffLevel(WNPlayer player) {
/* 154 */     this.buffLevel++;
/* 155 */     GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
/* 156 */     msgData.techData.blobData.buffLevel = this.buffLevel;
/* 157 */     GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_BUFF_LEVEL_PUSH.getValue(), (GuildMsg.GuildMsgData)msgData);
/* 158 */     GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildTech\GuildTech.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */