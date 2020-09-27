/*     */ package com.wanniu.game.playerData;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.CharacterLevelCO;
/*     */ import com.wanniu.game.data.DungeonMapCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.UpLevelEventCO;
/*     */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ public class PlayerBaseDataManager
/*     */   extends ModuleManager {
/*     */   public WNPlayer player;
/*     */   public PlayerPO baseData;
/*     */   
/*     */   public PlayerBaseDataManager(WNPlayer player, PlayerPO baseData) {
/*  41 */     this.player = player;
/*  42 */     this.baseData = baseData;
/*  43 */     player.player = baseData;
/*  44 */     this.curLevelData = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
/*  45 */     this.curMaxLv = PlayerUtil.initCurMaxLv(this.baseData);
/*     */   }
/*     */   
/*     */   private int curMaxLv;
/*     */   private CharacterLevelCO curLevelData;
/*     */   
/*     */   public void addExp(long exp, Const.GOODS_CHANGE_TYPE from, int teamExp) {
/*  52 */     if (exp <= 0L) {
/*     */       return;
/*     */     }
/*     */     
/*  56 */     if (PlayerUtil.isRobot(this.baseData) && 
/*  57 */       this.baseData.level >= GWorld.ROBOT_MAX_LEVEL) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  62 */     long expAdd = 0L;
/*  63 */     if ((from == Const.GOODS_CHANGE_TYPE.monsterdrop || from == Const.GOODS_CHANGE_TYPE.task) && this.player.getLevel() >= GlobalConfig.WorldExp_ReqLevel) {
/*  64 */       String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
/*  65 */       if (StringUtil.isNotEmpty(playerId)) {
/*  66 */         PlayerPO result = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*  67 */         expAdd = (long)Math.ceil((this.player.leaderBoardManager.getExpAdd(result) / 100.0F * (float)exp));
/*     */       } 
/*  69 */       exp += expAdd;
/*     */     } 
/*     */     
/*  72 */     int preLevel = this.baseData.level;
/*  73 */     long preExp = this.baseData.exp;
/*     */     
/*  75 */     if (this.baseData.level == this.curMaxLv && this.baseData.exp >= this.curLevelData.experience) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  83 */       int canUpgradeLv = PlayerUtil.calExpLv(this.baseData.exp, this.baseData.level);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  88 */       int punishRate = -GlobalConfig.Exp_RoleRank_Basic + (canUpgradeLv - this.curMaxLv) * GlobalConfig.Exp_RoleRank_PenaltyCoefficient;
/*  89 */       if (punishRate > 10000) {
/*  90 */         punishRate = 10000;
/*     */       }
/*  92 */       long realAddExp = exp * (10000 - punishRate) / 10000L;
/*  93 */       expAdd = expAdd * (10000 - punishRate) / 10000L;
/*  94 */       this.baseData.exp += realAddExp;
/*  95 */       if (this.baseData.exp >= 2147483647L) {
/*  96 */         this.baseData.exp = 2147483647L;
/*     */       }
/*     */     } else {
/*     */       
/* 100 */       this.baseData.exp += exp;
/* 101 */       if (this.baseData.exp >= 2147483647L) {
/* 102 */         this.baseData.exp = 2147483647L;
/*     */       }
/* 104 */       if (this.baseData.exp >= this.curLevelData.experience && this.baseData.level < this.curMaxLv) {
/* 105 */         _upgrade(preExp);
/*     */ 
/*     */         
/* 108 */         long expGot = this.player.player.exp - preExp;
/* 109 */         for (int lv = preLevel; lv < this.baseData.level; lv++) {
/* 110 */           expGot += ((CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(lv))).experience;
/*     */         }
/* 112 */         String addStr = LangService.getValue("GAIN_EXP1");
/* 113 */         addStr = addStr.replace("%s", String.valueOf(expGot));
/* 114 */         this.player.sendSysTip(addStr, Const.TipsType.LEFTDWON);
/* 115 */         if (expAdd > 0L) {
/* 116 */           this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.EXP, String.valueOf(expGot), Long.valueOf(expAdd), null);
/*     */         } else {
/* 118 */           this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.EXP, String.valueOf(expGot), null, null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     if (teamExp > 0) {
/* 124 */       this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.TEAM_EXP, String.valueOf(exp), String.valueOf(teamExp), null);
/*     */     }
/*     */     
/* 127 */     if (expAdd > 0L && this.baseData.exp - preExp > 0L) {
/* 128 */       this.player.pushDynamicData("exp", this.player.player.exp + ":" + expAdd);
/*     */     } else {
/* 130 */       this.player.pushDynamicData("exp", Long.valueOf(this.player.player.exp));
/*     */     } 
/*     */     
/* 133 */     BILogService.getInstance().recordNum(this.player, Const.BiLogType.Exp, exp, from);
/*     */   }
/*     */   
/*     */   public void _upgrade(long preExp) {
/* 137 */     long[] finalData = PlayerUtil.getLevelByExp(this.baseData.exp, this.baseData.level, this.curMaxLv);
/* 138 */     int finalLevel = (int)finalData[1];
/* 139 */     upgrade(finalLevel, finalData[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upgrade(int level, long exp) {
/* 150 */     if (PlayerUtil.isRobot(this.baseData)) {
/* 151 */       level = Math.min(GWorld.ROBOT_MAX_LEVEL, level);
/*     */     }
/*     */     
/* 154 */     if (this.baseData.level < level) {
/* 155 */       this.baseData.level = level;
/* 156 */       this.baseData.exp = exp;
/* 157 */       Out.info(new Object[] { "角色升级 playerId=", this.baseData.id, ",name=", this.baseData.name, ",level=", Integer.valueOf(this.baseData.level) });
/* 158 */       if (!this.player.isRobot()) {
/* 159 */         this.player.rankManager.onEvent(RankType.LEVEL, new Object[] { Integer.valueOf(this.player.getLevel()), Integer.valueOf(this.player.getUpOrder()) });
/*     */         
/* 161 */         LogReportService.getInstance().ansycReportUpgrade(this.player);
/* 162 */         BILogService.getInstance().ansycReportPlayerData(this.player.getSession(), this.player.getPlayer(), true);
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     CharacterLevelCO levelData = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
/* 167 */     this.player.player.needExp = levelData.experience;
/* 168 */     this.curLevelData = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
/* 169 */     this.player.onUpgrade();
/* 170 */     this.player.pushDynamicData(Utils.ofMap(new Object[] { "level", Integer.valueOf(this.player.player.level), "needExp", Integer.valueOf(this.player.player.needExp) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendIconMsgType() {
/* 177 */     String result = upgradeClass(true);
/* 178 */     if (result == null) {
/* 179 */       CommonUtil.sendIconMsgType(Const.MESSAGE_TYPE.upLevel_up, this.player.getId());
/* 180 */       updateSuperScript();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addClassExp(int exp, Const.GOODS_CHANGE_TYPE from) {
/* 186 */     long expAdd = 0L;
/* 187 */     if (this.player.getLevel() >= GlobalConfig.WorldExp_ReqLevel && Const.GOODS_CHANGE_TYPE.use != from) {
/* 188 */       String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
/* 189 */       if (StringUtil.isNotEmpty(playerId)) {
/* 190 */         PlayerPO result = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/* 191 */         expAdd = (long)Math.ceil((this.player.leaderBoardManager.getExpAdd(result) / 100.0F * exp));
/*     */       } 
/* 193 */       exp = (int)(exp + expAdd);
/*     */     } 
/*     */     
/* 196 */     this.baseData.classExp += exp;
/* 197 */     Out.info(new Object[] { "add classexp. playerId=", this.player.getId(), ",classexp=", Integer.valueOf(this.baseData.classExp), ",value=", Integer.valueOf(exp), ",from=", Integer.valueOf((from == null) ? 0 : from.value) });
/*     */     
/* 199 */     this.player.pushDynamicData("classExp", Integer.valueOf(this.player.player.classExp));
/* 200 */     sendIconMsgType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String upgradeClass() {
/* 206 */     return upgradeClass(false);
/*     */   }
/*     */   
/*     */   public UpLevelExpExt getNextUpLevelExp() {
/* 210 */     int upOrderId_next = this.baseData.upOrder + 1;
/* 211 */     UpLevelExpExt prop_next = (UpLevelExpExt)GameData.UpLevelExps.get(Integer.valueOf(upOrderId_next));
/* 212 */     return prop_next;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String upgradeClass(boolean justCheck) {
/* 222 */     if (this.baseData.upOrder >= PlayerUtil.maxUpOrder)
/* 223 */       return LangService.getValue("UPGRADE_MAX_LEVEL"); 
/* 224 */     UpLevelExpExt prop_next = getNextUpLevelExp();
/* 225 */     int classID_next = prop_next.classID;
/*     */     
/* 227 */     if (prop_next.reqClassExp > this.baseData.classExp)
/* 228 */       return LangService.getValue("UPGRADE_NEED_UPLEVELEXP"); 
/* 229 */     if (prop_next.reqLevel > this.baseData.level) {
/*     */       
/* 231 */       if (this.player.getLevel() >= GlobalConfig.Role_LevelLimit) {
/* 232 */         return LangService.getValue("UPGRADE_MAX_LEVEL");
/*     */       }
/* 234 */       return LangService.getValue("UPGRADE_NEED_LEVEL").replace("{x}", "" + prop_next.reqLevel);
/*     */     } 
/*     */     
/* 237 */     if (StringUtil.isNotEmpty(prop_next.reqEvents)) {
/* 238 */       String result = checkClassEvent(prop_next);
/* 239 */       if (result != null)
/* 240 */         return result; 
/*     */     } 
/* 242 */     if (justCheck) {
/* 243 */       return null;
/*     */     }
/* 245 */     this.baseData.classExp -= prop_next.reqClassExp;
/* 246 */     this.baseData.upOrder++;
/* 247 */     this.baseData.upLevel = classID_next;
/* 248 */     this.player.pushDynamicData(Utils.ofMap(new Object[] { "classExp", Integer.valueOf(this.player.player.classExp), "upOrder", Integer.valueOf(this.player.player.upOrder) }));
/* 249 */     this.curMaxLv = PlayerUtil.initCurMaxLv(this.baseData);
/* 250 */     this.player.onClassUpgrade();
/*     */     
/* 252 */     Out.info(new Object[] { "玩家进阶成功 playerId=", this.player.getId(), ", name=", this.player.getName(), ", upOrder=", Integer.valueOf(this.baseData.upOrder) });
/*     */     
/* 254 */     int oldLevel = this.baseData.level;
/* 255 */     if (this.baseData.exp >= this.curLevelData.experience && this.baseData.level < this.curMaxLv) {
/* 256 */       long preExp = this.baseData.exp;
/* 257 */       _upgrade(preExp);
/*     */     } 
/* 259 */     if (this.baseData.level == oldLevel && this.player.rankManager != null) {
/*     */ 
/*     */ 
/*     */       
/* 263 */       PlayerRankInfoPO info = this.player.rankManager.getRankPO();
/* 264 */       if (info != null) {
/* 265 */         info.setUpOrder(this.baseData.upOrder);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 270 */     this.player.taskManager.dealTaskEvent(Const.TaskType.ROLE_UPGRADE, "", this.baseData.upLevel);
/*     */ 
/*     */     
/* 273 */     this.player.achievementManager.playerRankChange(this.baseData.upLevel);
/*     */     
/* 275 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String checkClassEvent(UpLevelExpExt prop_next) {
/* 285 */     if (StringUtil.isNotEmpty(prop_next.reqEvents)) {
/* 286 */       int reqEvents = Integer.parseInt(prop_next.reqEvents);
/* 287 */       UpLevelEventCO event = (UpLevelEventCO)GameData.UpLevelEvents.get(Integer.valueOf(reqEvents));
/* 288 */       if (event == null)
/* 289 */         return null; 
/* 290 */       int eventPar = event.eventPar;
/* 291 */       DungeonMapCO dungeonMap = (DungeonMapCO)GameData.DungeonMaps.get(Integer.valueOf(eventPar));
/* 292 */       if (dungeonMap == null) {
/* 293 */         return null;
/*     */       }
/* 295 */       int templateID = dungeonMap.templateID;
/* 296 */       int hardModel = dungeonMap.hardModel;
/* 297 */       int hard = this.player.fightLevelManager.getCurrHard(templateID);
/* 298 */       if (hard > hardModel) {
/* 299 */         return null;
/*     */       }
/* 301 */       Const.DungeonHardModel dhm = Const.DungeonHardModel.getE(hardModel);
/* 302 */       if (dhm == null)
/* 303 */         return null; 
/* 304 */       StringBuffer hardModel_str = new StringBuffer("<f color='");
/* 305 */       hardModel_str.append(dhm.color);
/* 306 */       hardModel_str.append("'>");
/* 307 */       hardModel_str.append(dhm.desc).append("</f>");
/*     */       
/* 309 */       StringBuffer dungeonName = new StringBuffer("<f color='");
/* 310 */       dungeonName.append(dhm.color);
/* 311 */       dungeonName.append("'>");
/* 312 */       dungeonName.append(dungeonMap.name).append("</f>");
/* 313 */       return LangService.getValue("UPGRADE_NEED_OPTION").replace("{HardModel}", hardModel_str.toString()).replace("{Dungeon}", dungeonName.toString());
/*     */     } 
/*     */     
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPrestige(int prestige, Const.GOODS_CHANGE_TYPE from) {
/* 321 */     if (prestige >= 0) {
/* 322 */       this.baseData.prestige += prestige;
/* 323 */       if (this.baseData.prestige >= Integer.MAX_VALUE) {
/* 324 */         this.baseData.prestige = Integer.MAX_VALUE;
/*     */       }
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
/*     */   public boolean addFriendly(int num) {
/* 338 */     if (num > 0) {
/* 339 */       this.baseData.friendly += num;
/* 340 */       if (this.baseData.friendly >= Integer.MAX_VALUE) {
/* 341 */         this.baseData.friendly = Integer.MAX_VALUE;
/*     */       }
/* 343 */       return true;
/*     */     } 
/* 345 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costFriendly(int num) {
/* 352 */     if (num <= 0 || this.baseData.friendly < num) {
/* 353 */       return false;
/*     */     }
/* 355 */     this.baseData.friendly -= num;
/* 356 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean enoughFriendly(int num) {
/* 361 */     return (this.baseData.friendly >= num);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPawnGold() {
/* 370 */     return this.baseData.pawnGold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughPawnGold(int num) {
/* 377 */     return (this.baseData.pawnGold >= num);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addPawnGold(int num) {
/* 384 */     if (num > 0) {
/* 385 */       this.baseData.pawnGold += num;
/* 386 */       if (this.baseData.pawnGold >= Integer.MAX_VALUE) {
/* 387 */         this.baseData.pawnGold = Integer.MAX_VALUE;
/*     */       }
/* 389 */       return true;
/*     */     } 
/* 391 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costPawnGold(int num) {
/* 398 */     if (num < 0 || this.baseData.pawnGold < num) {
/* 399 */       return false;
/*     */     }
/* 401 */     this.baseData.pawnGold -= num;
/* 402 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enoughTreasurePoint(int num) {
/* 410 */     return (this.baseData.treasurePoint >= num);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addTreasurePoint(int num) {
/* 417 */     if (num > 0) {
/* 418 */       this.baseData.treasurePoint += num;
/* 419 */       if (this.baseData.treasurePoint >= Integer.MAX_VALUE) {
/* 420 */         this.baseData.treasurePoint = Integer.MAX_VALUE;
/*     */       }
/* 422 */       return true;
/*     */     } 
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean costTreasurePoint(int num) {
/* 431 */     if (num < 0 || this.baseData.treasurePoint < num) {
/* 432 */       return false;
/*     */     }
/* 434 */     this.baseData.treasurePoint -= num;
/* 435 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addGuildPoint(int num) {
/* 443 */     if (num > 0) {
/* 444 */       this.baseData.guildpoint += num;
/* 445 */       if (this.baseData.guildpoint >= Integer.MAX_VALUE) {
/* 446 */         this.baseData.guildpoint = Integer.MAX_VALUE;
/*     */       }
/* 448 */       return true;
/*     */     } 
/* 450 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginTime(Date loginTime) {
/* 457 */     this.baseData.loginTime = loginTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogoutTime(Date logoutTime) {
/* 464 */     this.baseData.logoutTime = logoutTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPrestige() {
/* 471 */     return this.baseData.prestige;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void modifyVip(int vip, int lastTime) {
/* 493 */     Const.VipType vt = Const.VipType.getE(vip);
/*     */     
/* 495 */     getVip();
/* 496 */     if (vt == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 501 */     if (vt == Const.VipType.month) {
/* 502 */       if (this.baseData.vip == Const.VipType.forever.value || this.baseData.vip == Const.VipType.sb_double.value) {
/* 503 */         this.baseData.vip = Const.VipType.sb_double.value;
/*     */       } else {
/* 505 */         this.baseData.vip = vt.value;
/*     */       }
/*     */     
/*     */     }
/* 509 */     else if (vt == Const.VipType.forever) {
/* 510 */       if (this.baseData.vip == Const.VipType.month.value || this.baseData.vip == Const.VipType.sb_double.value) {
/* 511 */         this.baseData.vip = Const.VipType.sb_double.value;
/*     */       } else {
/* 513 */         this.baseData.vip = vt.value;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 518 */     if (vt == Const.VipType.month) {
/* 519 */       CardCO cardProp = (CardCO)GameData.Cards.get(Integer.valueOf(vip));
/* 520 */       Calendar c = Calendar.getInstance();
/* 521 */       if (this.baseData.vipEndTime != null && this.baseData.vipEndTime.after(Calendar.getInstance().getTime())) {
/* 522 */         c.setTime(this.baseData.vipEndTime);
/* 523 */         c.add(5, cardProp.lastTime);
/* 524 */         this.baseData.vipEndTime = c.getTime();
/*     */       } else {
/* 526 */         c.add(5, cardProp.lastTime);
/* 527 */         this.baseData.vipEndTime = c.getTime();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVip() {
/* 534 */     if ((this.baseData.vip == Const.VipType.month.value || this.baseData.vip == Const.VipType.sb_double.value) && 
/* 535 */       this.baseData.vipEndTime.before(Calendar.getInstance().getTime())) {
/* 536 */       this.baseData.vipEndTime = null;
/* 537 */       if (this.baseData.vip == Const.VipType.month.value) {
/* 538 */         this.baseData.vip = Const.VipType.none.value;
/*     */       } else {
/* 540 */         this.baseData.vip = Const.VipType.forever.value;
/*     */       } 
/*     */     } 
/* 543 */     return this.baseData.vip;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 548 */     switch (eventType) {
/*     */       case UPGRADE:
/* 550 */         sendIconMsgType();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 561 */     return Const.ManagerType.BASE_DATA;
/*     */   }
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 565 */     UpLevelExpExt prop_next = getNextUpLevelExp();
/* 566 */     String flag = checkClassEvent(prop_next);
/* 567 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 568 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*     */     
/* 570 */     data.setType(Const.SUPERSCRIPT_TYPE.UPLEVEL.getValue());
/* 571 */     data.setNumber((flag == null) ? 1 : 0);
/*     */     
/* 573 */     list.add(data.build());
/* 574 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateSuperScript() {
/* 579 */     if (this.player != null) {
/* 580 */       this.player.updateSuperScriptList(getSuperScript());
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateLvChangeTime(Date time) {
/* 585 */     this.baseData.lvChangeTime = time;
/*     */   }
/*     */   
/*     */   public void updateFightTime(Date time) {
/* 589 */     this.baseData.fightChangeTime = time;
/*     */   }
/*     */   
/*     */   public Date getLvChangeTime() {
/* 593 */     return this.baseData.lvChangeTime;
/*     */   }
/*     */   
/*     */   public Date getFightChangeTime() {
/* 597 */     return this.baseData.fightChangeTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PomeloResponse exchange(int type) {
/* 603 */     if (this.player.getLevel() < GlobalConfig.Exchange_OpenLV) {
/* 604 */       Out.warn(new Object[] { "未满级也想兑换属性吗？playerId=", this.player.getId() });
/* 605 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     } 
/*     */     
/* 608 */     switch (type) {
/*     */       case 1:
/* 610 */         return exchangeByExp();
/*     */       case 2:
/* 612 */         return exchangeByUpexp();
/*     */       case 3:
/* 614 */         return exchangeByGold();
/*     */     } 
/* 616 */     return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */   }
/*     */ 
/*     */   
/*     */   private PomeloResponse exchangeByGold() {
/* 621 */     int needGold = GlobalConfig.Exchange_Gold;
/*     */     
/* 623 */     if (!this.player.moneyManager.costGold(needGold, Const.GOODS_CHANGE_TYPE.EXCHANGE_PROPARTY)) {
/* 624 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/*     */     }
/*     */     
/* 627 */     (this.player.getPlayer()).exchangCount++;
/*     */     
/* 629 */     Out.info(new Object[] { "银两兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount) });
/*     */ 
/*     */     
/* 632 */     this.player.onExchangeProparty();
/*     */ 
/*     */     
/* 635 */     return null;
/*     */   }
/*     */   
/*     */   private PomeloResponse exchangeByUpexp() {
/* 639 */     int needUpExp = GlobalConfig.Exchange_UpExp;
/* 640 */     if ((this.player.getPlayer()).classExp < needUpExp) {
/* 641 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAER_EXCHANGE_UPEXP_NOT_ENOUGH"));
/*     */     }
/*     */     
/* 644 */     (this.player.getPlayer()).classExp -= needUpExp;
/* 645 */     (this.player.getPlayer()).exchangCount++;
/* 646 */     Out.info(new Object[] { "修为兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount) });
/* 647 */     this.player.pushDynamicData("classExp", Integer.valueOf(this.player.player.classExp));
/*     */ 
/*     */     
/* 650 */     this.player.onExchangeProparty();
/*     */ 
/*     */     
/* 653 */     return null;
/*     */   }
/*     */   
/*     */   private PomeloResponse exchangeByExp() {
/* 657 */     int needExp = GlobalConfig.Exchange_Exp;
/* 658 */     if (this.player.getExp() < needExp) {
/* 659 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAER_EXCHANGE_EXP_NOT_ENOUGH"));
/*     */     }
/*     */     
/* 662 */     (this.player.getPlayer()).exp -= needExp;
/* 663 */     (this.player.getPlayer()).exchangCount++;
/* 664 */     Out.info(new Object[] { "经验兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount) });
/* 665 */     this.player.pushDynamicData("exp", Long.valueOf(this.player.player.exp));
/*     */ 
/*     */     
/* 668 */     this.player.onExchangeProparty();
/*     */ 
/*     */     
/* 671 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\playerData\PlayerBaseDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */