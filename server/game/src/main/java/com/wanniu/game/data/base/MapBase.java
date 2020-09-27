/*     */ package com.wanniu.game.data.base;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MapBase
/*     */ {
/*     */   public int mapID;
/*     */   public String name;
/*     */   public int templateID;
/*     */   public int type;
/*     */   public String monsterHard;
/*     */   public int hardModel;
/*     */   public int dungeonTab;
/*     */   public int dungeonShow;
/*     */   public int allowedPlayers;
/*     */   public int allowedPet;
/*     */   public int autoReset;
/*     */   public int mapTypeID;
/*     */   public int defaultTimes;
/*     */   public int maxPurchase;
/*     */   public String bonusViewTC;
/*     */   public int adCombatPower;
/*     */   public int race;
/*     */   public int isSafe;
/*     */   public int pktype;
/*     */   public int changePKtype;
/*     */   public int ignorePkRule;
/*     */   public int canBeTrans;
/*     */   public int mapLevel;
/*     */   public int disConnToMapID;
/*     */   public int revivedMapID;
/*     */   public int fullPlayers;
/*     */   public int maxPlayers;
/*     */   public int lifeTime;
/*     */   public int boundary;
/*     */   public int reqLevel;
/*     */   public int reqUpLevel;
/*     */   public int levellimit;
/*     */   public int upLevellimit;
/*     */   public int reqVip;
/*     */   public int reqQuestId;
/*     */   public int allowedRace;
/*     */   public String reqState;
/*     */   public int stateValue;
/*     */   public int openRule;
/*     */   public String openDate;
/*     */   public String beginTime;
/*     */   public String endTime;
/*     */   public int closedToMapID;
/*     */   public String reqItemCode;
/*     */   public int reqItemCount;
/*     */   public int reduceItemCount;
/*     */   public int allowedTransfer;
/*     */   public String costItem;
/*     */   public int costItemNum;
/*     */   public int costGold;
/*     */   public int randChestChance;
/*     */   public int maxRandChest;
/*     */   public String randChestTC;
/*     */   public String sceneSmallMap;
/*     */   public String mapDesc;
/*     */   public String mapPic;
/*     */   public String connect;
/*     */   public int isChange;
/*     */   public int distribution;
/*     */   public int autoFight;
/*     */   public int useAgent;
/*     */   public int rideMount;
/*     */   public int takePet;
/*     */   public int revival;
/*     */   public int recovery;
/*     */   public int changePetAI;
/*     */   public int petAI;
/*     */   public int isSweep;
/*     */   public String monsterInfo;
/*     */   public int bossInfoShow;
/*     */   public int teamTips;
/*     */   public int qcolor;
/*     */   public int allowedPlayersMix;
/*     */   public int allowedPlayersMax;
/*     */   public String bossPic;
/*     */   public int fcValue;
/*     */   public int timeCount;
/*     */   public int leaveToMapID;
/*     */   public Map<String, Integer> toPath;
/*     */   public Map<Integer, float[]> toAreaXY;
/*     */   public Map<String, float[]> toPathXY;
/*     */   public List<Integer> OpenDate;
/*     */   public Map<Integer, Integer> m_monsterInfo;
/*     */   
/*     */   public int getKey() {
/* 184 */     return this.mapID;
/*     */   }
/*     */ 
/*     */   
/*     */   public void beforeProperty() {}
/*     */ 
/*     */   
/*     */   public void initProperty() {
/* 192 */     this.m_monsterInfo = new HashMap<>();
/* 193 */     this.toPath = new HashMap<>();
/* 194 */     this.toPathXY = (Map)new HashMap<>();
/* 195 */     this.toAreaXY = (Map)new HashMap<>();
/* 196 */     if (!StringUtil.isEmpty(this.connect)) {
/* 197 */       String[] connectStrs = this.connect.split(";");
/* 198 */       for (String connectStr : connectStrs) {
/* 199 */         if (!StringUtil.isEmpty(connectStr)) {
/* 200 */           String[] data = connectStr.split(":");
/* 201 */           int areaId = Integer.parseInt(data[0]);
/* 202 */           this.toPath.put(data[1], Integer.valueOf(areaId));
/* 203 */           if (data.length > 2) {
/* 204 */             String[] xys = data[2].split(",");
/* 205 */             float[] xy = new float[2];
/* 206 */             xy[0] = Float.valueOf(xys[0]).floatValue();
/* 207 */             xy[1] = Float.valueOf(xys[1]).floatValue();
/* 208 */             this.toPathXY.put(data[1], xy);
/* 209 */             this.toAreaXY.put(Integer.valueOf(areaId), xy);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 215 */     if (this.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
/* 216 */       String[] openDays = this.openDate.split(",");
/* 217 */       if (openDays.length > 0) {
/* 218 */         this.OpenDate = new ArrayList<>();
/* 219 */         for (int i = 0; i < openDays.length; i++) {
/* 220 */           this.OpenDate.add(Integer.valueOf(Integer.parseInt(openDays[i])));
/*     */         }
/*     */         
/* 223 */         int index = this.OpenDate.indexOf(Integer.valueOf(7));
/* 224 */         if (index >= 0) {
/* 225 */           this.OpenDate.set(index, Integer.valueOf(0));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     if (this.lifeTime > 300) {
/* 231 */       Out.warn(new Object[] { "sceneProp lifeTime is inValid, it should be between 0 and 300 mapId:", Integer.valueOf(this.mapID), " lifeTime:", Integer.valueOf(this.lifeTime) });
/* 232 */     } else if (this.lifeTime == 0) {
/* 233 */       this.lifeTime = 300;
/*     */     } 
/*     */     
/* 236 */     boolean valid = false;
/* 237 */     for (Const.SCENE_TYPE sceneType : Const.SCENE_TYPE.values()) {
/* 238 */       if (this.type == sceneType.getValue()) {
/* 239 */         valid = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 243 */     if (!valid) {
/* 244 */       Out.error(new Object[] { "sceneProp Type value inValid, mapId:", Integer.valueOf(this.mapID) });
/*     */     }
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
/*     */ 
/*     */     
/* 260 */     if (!StringUtil.isEmpty(this.monsterInfo)) {
/*     */       
/* 262 */       int dungeonIdAdd = 0;
/*     */       
/* 264 */       if (this.hardModel == 2) {
/* 265 */         dungeonIdAdd = 10000;
/* 266 */       } else if (this.hardModel == 3) {
/* 267 */         dungeonIdAdd = 20000;
/*     */       } 
/*     */       
/* 270 */       String[] datas = this.monsterInfo.split(";");
/* 271 */       for (String data : datas) {
/* 272 */         String[] as = data.split(":");
/*     */         
/* 274 */         if (as.length > 1)
/*     */         {
/* 276 */           this.m_monsterInfo.put(Integer.valueOf(Integer.parseInt(as[0]) + dungeonIdAdd), Integer.valueOf(Integer.parseInt(as[1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\MapBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */