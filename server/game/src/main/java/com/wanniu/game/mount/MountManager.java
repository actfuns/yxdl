/*     */ package com.wanniu.game.mount;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.RideListExt;
/*     */ import com.wanniu.game.data.ext.SkinListExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.MountPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.MountHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MountManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   public MountPO mount;
/*  42 */   public Map<Const.PlayerBtlData, Integer> data_mount_show = new HashMap<>();
/*  43 */   public Map<Const.PlayerBtlData, Integer> data_mount_show_next = new HashMap<>();
/*  44 */   public Map<Const.PlayerBtlData, Integer> data_mount_final = new HashMap<>();
/*     */   
/*     */   public MountManager(WNPlayer player, MountPO mount) {
/*  47 */     this.player = player;
/*  48 */     this.mount = mount;
/*  49 */     player.player.openMount = (mount != null);
/*  50 */     calMountData();
/*     */   }
/*     */   
/*     */   public static MountPO createMount(String playerId) {
/*  54 */     MountPO mount = new MountPO();
/*  55 */     mount.rideLevel = GlobalConfig.Ride_InitUpLevel;
/*  56 */     mount.starLv = GlobalConfig.Ride_InitStar;
/*  57 */     mount.mountSkins = new ArrayList();
/*  58 */     mount.usingSkinId = GlobalConfig.Ride_DefaultSkinID;
/*  59 */     mount.mountSkins.add(Integer.valueOf(mount.usingSkinId));
/*     */     
/*  61 */     PlayerPOManager.put(ConstsTR.mountTR, playerId, (GEntity)mount);
/*  62 */     return mount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calMountData() {
/*  69 */     if (this.mount == null || !this.player.functionOpenManager.isOpen(Const.FunctionType.MOUNT.getValue())) {
/*     */       return;
/*     */     }
/*     */     
/*  73 */     this.data_mount_show.clear();
/*  74 */     this.data_mount_final.clear();
/*  75 */     this.data_mount_show = MountUtil.getMountBaseProp(this.mount.rideLevel, this.mount.starLv);
/*  76 */     int next_lvl = this.mount.rideLevel;
/*  77 */     int next_star = this.mount.starLv + 1;
/*  78 */     if (next_star > GlobalConfig.mountMaxStar) {
/*  79 */       next_lvl++;
/*  80 */       next_star = 0;
/*     */     } 
/*  82 */     if (next_lvl > GlobalConfig.Ride_MaxUpLevel) {
/*  83 */       this.data_mount_show_next.clear();
/*     */     } else {
/*  85 */       this.data_mount_show_next = MountUtil.getMountBaseProp(next_lvl, next_star);
/*     */     } 
/*  87 */     AttributeUtil.addData2AllData(this.data_mount_show, this.data_mount_final);
/*  88 */     int maxSpeed = 0;
/*  89 */     for (Iterator<Integer> iterator = this.mount.mountSkins.iterator(); iterator.hasNext(); ) { int skinId = ((Integer)iterator.next()).intValue();
/*  90 */       SkinListExt skin = (SkinListExt)GameData.SkinLists.get(Integer.valueOf(skinId));
/*  91 */       if (skin != null) {
/*  92 */         AttributeUtil.addData2AllData(skin.skinAttrs, this.data_mount_final);
/*  93 */         if (skin.skinAttrs.containsKey(Const.PlayerBtlData.RunSpeed) && (
/*  94 */           (Integer)skin.skinAttrs.get(Const.PlayerBtlData.RunSpeed)).intValue() > maxSpeed) {
/*  95 */           maxSpeed = ((Integer)skin.skinAttrs.get(Const.PlayerBtlData.RunSpeed)).intValue();
/*     */         }
/*     */       }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.data_mount_final.put(Const.PlayerBtlData.RunSpeed, Integer.valueOf(maxSpeed));
/* 105 */     if (this.mount.rideFlag == Const.MOUNT_RIDING_STATE.off.getValue()) {
/* 106 */       this.data_mount_final.remove(Const.PlayerBtlData.RunSpeed);
/*     */     }
/*     */     
/* 109 */     refreshFightPower();
/* 110 */     if (this.player.rankManager != null) {
/* 111 */       this.player.rankManager.onEvent(RankType.Mount, new Object[] { Integer.valueOf(this.mount.fightPower), Integer.valueOf(this.mount.usingSkinId) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgradeStar() {
/* 121 */     if (this.mount.starLv >= GlobalConfig.mountMaxStar)
/* 122 */       return -1; 
/* 123 */     RideListExt prop = GameData.findRideLists(t -> (t.rideLevel == this.mount.rideLevel)).get(0);
/*     */ 
/*     */     
/* 126 */     if (this.player.bag.discardItem(prop.upStarItemCode, prop.upStarItemCount, Const.GOODS_CHANGE_TYPE.equipColorUp)) {
/* 127 */       this.mount.starLv++;
/* 128 */       calMountData();
/* 129 */       this.player.onMountPropChange();
/*     */     } else {
/* 131 */       return -2;
/*     */     } 
/*     */     
/* 134 */     this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.TRAIN_RIDE, "0", 1);
/*     */     
/* 136 */     this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, "0", this.mount.rideLevel * 11 + this.mount.starLv);
/*     */     
/* 138 */     LogReportService.getInstance().ansycReportMountUpgrade(this.player, this.mount.rideLevel, this.mount.starLv);
/* 139 */     BILogService.getInstance().ansycReportRideTrainBI(this.player.getPlayer(), 1, this.mount.rideLevel, this.mount.starLv, prop.upStarItemCode, prop.upStarItemCount);
/* 140 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgradeLv() {
/* 149 */     if (this.mount.rideLevel >= GlobalConfig.Ride_MaxUpLevel)
/* 150 */       return -1; 
/* 151 */     if (this.mount.starLv != GlobalConfig.mountMaxStar)
/* 152 */       return -2; 
/* 153 */     RideListExt prop = GameData.findRideLists(t -> (t.rideLevel == this.mount.rideLevel)).get(0);
/* 154 */     if (this.player.bag.discardItem(prop.upLevelItemCode, prop.upLevelItemCount, Const.GOODS_CHANGE_TYPE.equipLevelUp)) {
/* 155 */       this.mount.rideLevel++;
/* 156 */       this.mount.starLv = 0;
/* 157 */       calMountData();
/* 158 */       this.player.onMountPropChange();
/*     */     } else {
/*     */       
/* 161 */       return -3;
/*     */     } 
/* 163 */     this.player.achievementManager.onHorseLevelChange(this.mount.rideLevel);
/*     */     
/* 165 */     this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.TRAIN_RIDE, "0", 1);
/*     */     
/* 167 */     this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, "0", this.mount.rideLevel * 11 + this.mount.starLv);
/*     */     
/* 169 */     LogReportService.getInstance().ansycReportMountUpgrade(this.player, this.mount.rideLevel, this.mount.starLv);
/* 170 */     BILogService.getInstance().ansycReportRideTrainBI(this.player.getPlayer(), 2, this.mount.rideLevel, this.mount.starLv, prop.upLevelItemCode, prop.upLevelItemCount);
/*     */     
/* 172 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.MOUNT_UPGRADE_LV, new Object[] { Integer.valueOf(getMountLevel()) });
/* 173 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int changeSkin(int _skinId) {
/* 183 */     if (this.mount == null) {
/* 184 */       return -1;
/*     */     }
/* 186 */     if (!this.mount.mountSkins.contains(Integer.valueOf(_skinId))) {
/* 187 */       return -1;
/*     */     }
/* 189 */     if (this.mount.usingSkinId == _skinId) {
/* 190 */       return -2;
/*     */     }
/* 192 */     this.mount.usingSkinId = _skinId;
/* 193 */     calMountData();
/* 194 */     this.player.onMountPropChange();
/* 195 */     this.player.refreshBattlerServerAvatar();
/* 196 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addNewSkin(int _skinId) {
/* 206 */     if (!this.player.player.openMount || this.mount == null)
/* 207 */       return -3; 
/* 208 */     if (this.mount.mountSkins.contains(Integer.valueOf(_skinId)))
/* 209 */       return -1; 
/* 210 */     if (!GameData.SkinLists.containsKey(Integer.valueOf(_skinId)))
/* 211 */       return -2; 
/* 212 */     this.mount.mountSkins.add(Integer.valueOf(_skinId));
/*     */ 
/*     */     
/* 215 */     LogReportService.getInstance().ansycReportMountSkin(this.player, _skinId);
/* 216 */     SkinListExt prop = (SkinListExt)GameData.SkinLists.get(Integer.valueOf(_skinId));
/* 217 */     if (prop != null) {
/* 218 */       BILogService.getInstance().ansycReportMountActivate(this.player.getPlayer(), _skinId, prop.skinName);
/*     */     }
/*     */     
/* 221 */     MountHandler.MountNewSkinPush.Builder data = MountHandler.MountNewSkinPush.newBuilder();
/* 222 */     data.setS2CSkinId(_skinId);
/* 223 */     this.player.receive("area.mountPush.mountNewSkinPush", (GeneratedMessage)data.build());
/*     */ 
/*     */     
/* 226 */     this.player.achievementManager.onMountGot();
/* 227 */     return 1;
/*     */   }
/*     */   
/*     */   public int getMountLevel() {
/* 231 */     if (this.mount != null)
/* 232 */       return this.mount.rideLevel; 
/* 233 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshFightPower() {
/* 240 */     this.mount.fightPower = CommonUtil.calFightPower(this.data_mount_final);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void openMount() {
/* 249 */     if (this.mount == null) {
/* 250 */       this.mount = createMount(this.player.getId());
/* 251 */       this.player.player.openMount = true;
/* 252 */       calMountData();
/* 253 */       this.player.onMountPropChange();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpenMount() {
/* 264 */     if (this.mount != null)
/* 265 */       return true; 
/* 266 */     return false;
/*     */   }
/*     */   
/*     */   public MountHandler.MountData.Builder getMountData() {
/* 270 */     MountHandler.MountData.Builder data = MountHandler.MountData.newBuilder();
/* 271 */     data.setRideLevel(this.mount.rideLevel);
/* 272 */     data.setUsingSkinID(this.mount.usingSkinId);
/* 273 */     data.addAllMountSkins(this.mount.mountSkins);
/* 274 */     List<Common.AttributeBase> list = new ArrayList<>();
/* 275 */     for (Const.PlayerBtlData pbd : this.data_mount_show.keySet()) {
/* 276 */       if (pbd == Const.PlayerBtlData.RunSpeed)
/*     */         continue; 
/* 278 */       Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
/* 279 */       ab.setId(pbd.id);
/* 280 */       ab.setMaxValue(((Integer)this.data_mount_show.get(pbd)).intValue());
/* 281 */       list.add(ab.build());
/*     */     } 
/* 283 */     data.setStarLv(this.mount.starLv);
/* 284 */     data.setFightPowerValue(0);
/* 285 */     data.addAllMountAttrs(list);
/* 286 */     List<Common.AttributeBase> list_next = new ArrayList<>();
/* 287 */     for (Const.PlayerBtlData pbd : this.data_mount_show_next.keySet()) {
/* 288 */       if (pbd == Const.PlayerBtlData.RunSpeed)
/*     */         continue; 
/* 290 */       Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
/* 291 */       ab.setId(pbd.id);
/* 292 */       ab.setMaxValue(((Integer)this.data_mount_show_next.get(pbd)).intValue());
/* 293 */       list_next.add(ab.build());
/*     */     } 
/* 295 */     data.addAllMountAttrsNext(list_next);
/* 296 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int ridingMount(int isUp) {
/* 301 */     if (this.mount == null) {
/* 302 */       return 0;
/*     */     }
/* 304 */     int times = 0;
/* 305 */     this.player.getXmdsManager().refreshSummonMount(this.player.getId(), times, isUp);
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
/* 316 */     return 0;
/*     */   }
/*     */   
/*     */   public void onEvent(TaskEvent event) {
/* 320 */     if (event.type == Const.EventType.summonMount.getValue()) {
/* 321 */       boolean flag = ((Boolean)event.params[0]).booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 328 */       int rideFlag = flag ? Const.MOUNT_RIDING_STATE.on.getValue() : Const.MOUNT_RIDING_STATE.off.getValue();
/* 329 */       if (this.mount == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 334 */       this.mount.rideFlag = rideFlag;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 339 */       pushToClientMountsFlag();
/* 340 */       this.player.refreshBattlerServerAvatar();
/* 341 */       calMountData();
/* 342 */       this.player.onMountPropChange();
/*     */       
/* 344 */       this.mount.firstChoose = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushToClientMountsFlag() {
/* 350 */     MountHandler.MountFlagPush.Builder data = MountHandler.MountFlagPush.newBuilder();
/* 351 */     if (this.mount == null) {
/* 352 */       data.setS2CFlag(Const.MOUNT_RIDING_STATE.off.getValue());
/*     */     } else {
/* 354 */       data.setS2CFlag(this.mount.rideFlag);
/* 355 */       data.setS2CUsingSkinId(this.mount.usingSkinId);
/*     */     } 
/*     */     
/* 358 */     this.player.receive("area.mountPush.mountFlagPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void unMountData() {
/* 362 */     if (this.mount != null) {
/* 363 */       if (this.mount.rideFlag == 0) {
/*     */         return;
/*     */       }
/* 366 */       this.mount.rideFlag = Const.MOUNT_RIDING_STATE.off.getValue();
/* 367 */       calMountData();
/* 368 */       this.player.onMountPropChange();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 373 */     pushToClientMountsFlag();
/*     */   }
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 377 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 378 */     int number = 0;
/* 379 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 380 */     data.setType(Const.SUPERSCRIPT_TYPE.MOUNT.getValue());
/* 381 */     data.setNumber(number);
/*     */     
/* 383 */     list.add(data.build());
/* 384 */     return list;
/*     */   }
/*     */   
/*     */   public void addTestSKin() {
/* 388 */     List<Integer> mountSkins = this.mount.mountSkins;
/* 389 */     if (mountSkins.size() < 4) {
/* 390 */       int maxId = ((Integer)mountSkins.get(mountSkins.size() - 1)).intValue();
/*     */       
/* 392 */       addNewSkin(maxId + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 398 */     switch (eventType) {
/*     */     
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
/*     */   public Const.ManagerType getManagerType() {
/* 411 */     return Const.ManagerType.MOUNT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAllSkin() {
/* 418 */     if (this.mount == null)
/*     */       return; 
/* 420 */     this.mount.mountSkins = new ArrayList();
/* 421 */     for (SkinListExt skin : GameData.SkinLists.values()) {
/* 422 */       this.mount.mountSkins.add(Integer.valueOf(skin.skinID));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean chooseFirstSkin(int skinId) {
/* 427 */     if (this.mount == null)
/* 428 */       return false; 
/* 429 */     if (this.mount.firstChoose)
/* 430 */       return false; 
/* 431 */     SkinListExt prop = (SkinListExt)GameData.SkinLists.get(Integer.valueOf(skinId));
/* 432 */     if (prop == null || prop.skinQColor != 1)
/* 433 */       return false; 
/* 434 */     this.mount.mountSkins.clear();
/* 435 */     this.mount.usingSkinId = skinId;
/* 436 */     this.mount.firstChoose = true;
/* 437 */     addNewSkin(skinId);
/* 438 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mount\MountManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */