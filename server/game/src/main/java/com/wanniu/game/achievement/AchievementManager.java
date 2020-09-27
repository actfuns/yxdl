/*      */ package com.wanniu.game.achievement;
/*      */ 
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.game.achievement.po.BaseInfo;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.data.AchievementCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.base.DItemBase;
/*      */ import com.wanniu.game.data.ext.AchievementConfigExt;
/*      */ import com.wanniu.game.data.ext.AchievementExt;
/*      */ import com.wanniu.game.data.ext.ArmourAttributeExt;
/*      */ import com.wanniu.game.data.ext.ArmourPlusExt;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.player.AttributeUtil;
/*      */ import com.wanniu.game.player.BILogService;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.AchievementDataPO;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.task.TaskEvent;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import pomelo.area.AchievementHandler;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AchievementManager
/*      */ {
/*      */   private WNPlayer player;
/*      */   public AchievementDataPO achievementDataPO;
/*      */   public Map<Integer, AchievementDataPO.AchievePO> achievementRecordMap;
/*      */   private AchievementServiceNew achievementService;
/*      */   
/*      */   protected AchievementManager() {}
/*      */   
/*      */   public AchievementManager(WNPlayer player, AchievementDataPO achievementData) {
/*   57 */     this.player = player;
/*   58 */     this.achievementDataPO = achievementData;
/*   59 */     if (this.achievementDataPO == null) {
/*   60 */       this.achievementDataPO = new AchievementDataPO();
/*   61 */       PlayerPOManager.put(ConstsTR.achievementTR, player.getId(), (GEntity)this.achievementDataPO);
/*      */     } 
/*      */     
/*   64 */     this.achievementRecordMap = this.achievementDataPO.achievements;
/*      */     
/*   66 */     this.achievementService = AchievementServiceNew.getInstance();
/*      */   }
/*      */   
/*      */   public Map<Integer, AchievementDataPO.AchievePO> getAchievementRecords() {
/*   70 */     return this.achievementRecordMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson4PayloadbyTypeId(int chapterId, AchievementHandler.AchievementGetTypeElementResponse.Builder res) {
/*   80 */     List<AchievementExt> achievements = GameData.findAchievements(t -> (t.chapterID == chapterId));
/*      */ 
/*      */     
/*   83 */     AchievementConfigExt configExt = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(chapterId));
/*   84 */     int recordCount = 0;
/*   85 */     for (AchievementExt achievementRelation : achievements) {
/*   86 */       AchievementHandler.Achievement.Builder builder = AchievementHandler.Achievement.newBuilder();
/*   87 */       AchievementDataPO.AchievePO achieve = this.achievementRecordMap.get(Integer.valueOf(achievementRelation.id));
/*   88 */       if (achieve != null) {
/*   89 */         builder.setId(achieve.id);
/*   90 */         builder.setScheduleCurr(achieve.scheduleCurr);
/*   91 */         builder.setStatus(0);
/*   92 */         if (achieve.awardState == 1) {
/*      */           
/*   94 */           recordCount++;
/*   95 */           builder.setStatus(2);
/*   96 */           builder.setScheduleCurr(achievementRelation.targetNum);
/*      */         }
/*   98 */         else if (this.achievementService.isComplete(achieve, achievementRelation)) {
/*   99 */           recordCount++;
/*      */           
/*  101 */           builder.setStatus(1);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/*  106 */         builder.setId(achievementRelation.id);
/*  107 */         builder.setScheduleCurr(0);
/*      */         
/*  109 */         builder.setStatus(0);
/*      */       } 
/*  111 */       res.addS2CAchievements(builder);
/*      */     } 
/*  113 */     res.setS2CRewardCount(recordCount);
/*  114 */     int status = 0;
/*  115 */     if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(chapterId))) {
/*  116 */       status = 2;
/*  117 */     } else if (achievements.size() > 0 && recordCount >= achievements.size()) {
/*  118 */       status = 1;
/*      */     } 
/*  120 */     res.setS2CRewardStatus(status);
/*      */ 
/*      */     
/*  123 */     List<Integer> list_opend_chapter = new ArrayList<>();
/*  124 */     for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {
/*  125 */       if (this.player.getLevel() < config.lv) {
/*      */         continue;
/*      */       }
/*  128 */       if (config.quest != 0 && !this.player.taskManager.finishedNormalTasks.containsKey(Integer.valueOf(config.quest))) {
/*      */         continue;
/*      */       }
/*  131 */       list_opend_chapter.add(Integer.valueOf(config.typeId));
/*      */     } 
/*  133 */     res.addAllS2COpenedChapter(list_opend_chapter);
/*      */ 
/*      */     
/*  136 */     List<ItemOuterClass.MiniItem> list_chest = new ArrayList<>();
/*  137 */     for (String itemCode : configExt.awards.keySet()) {
/*  138 */       list_chest.add(ItemUtil.getMiniItemData(itemCode, ((Integer)configExt.awards.get(itemCode)).intValue()).build());
/*      */     }
/*  140 */     res.addAllS2CChestView(list_chest);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BaseInfo getAward(int type, int awardId) {
/*  151 */     BaseInfo data = new BaseInfo();
/*  152 */     data.code = 200;
/*      */ 
/*      */     
/*  155 */     if (this.player == null) {
/*  156 */       data.code = 500;
/*  157 */       data.msg = LangService.getValue("SOMETHING_ERR");
/*  158 */       return data;
/*      */     } 
/*      */ 
/*      */     
/*  162 */     if (type == 0) {
/*  163 */       AchievementConfigExt configExt = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(awardId));
/*      */       
/*  165 */       if (configExt == null) {
/*  166 */         data.code = 500;
/*  167 */         data.msg = LangService.getValue("SOMETHING_ERR");
/*  168 */         return data;
/*      */       } 
/*      */ 
/*      */       
/*  172 */       if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(awardId))) {
/*  173 */         data.code = 500;
/*  174 */         data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
/*  175 */         return data;
/*      */       } 
/*      */ 
/*      */       
/*  179 */       List<AchievementExt> list_achieves = GameData.findAchievements(t -> (t.chapterID == awardId));
/*      */ 
/*      */       
/*  182 */       AchievementDataPO.AchievePO achivePO = null;
/*  183 */       for (AchievementExt ext : list_achieves) {
/*  184 */         achivePO = this.achievementRecordMap.get(Integer.valueOf(awardId));
/*  185 */         if (achivePO == null) {
/*      */           break;
/*      */         }
/*  188 */         if (achivePO.awardState == 1) {
/*      */           break;
/*      */         }
/*  191 */         if (!this.achievementService.isComplete(achivePO, ext)) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  197 */       this.achievementDataPO.receivedAwards.add(Integer.valueOf(awardId));
/*      */ 
/*      */       
/*  200 */       List<NormalItem> list_items = ItemUtil.createItemsByItemCode(configExt.awards);
/*  201 */       this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.achieve, "Bag_full_common");
/*  202 */     } else if (type == 1) {
/*  203 */       AchievementExt achievementExt = (AchievementExt)GameData.Achievements.get(Integer.valueOf(awardId));
/*  204 */       AchievementDataPO.AchievePO achivePO = this.achievementRecordMap.get(Integer.valueOf(awardId));
/*      */       
/*  206 */       if (achievementExt == null || achivePO == null) {
/*  207 */         data.code = 500;
/*  208 */         data.msg = LangService.getValue("SOMETHING_ERR");
/*  209 */         return data;
/*      */       } 
/*      */ 
/*      */       
/*  213 */       if (achivePO.awardState == 1) {
/*  214 */         data.code = 500;
/*  215 */         data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
/*  216 */         return data;
/*      */       } 
/*      */ 
/*      */       
/*  220 */       if (!this.achievementService.isComplete(achivePO, achievementExt)) {
/*  221 */         data.code = 500;
/*  222 */         data.msg = LangService.getValue("SIGN_HAVE_RECEIVED");
/*  223 */         return data;
/*      */       } 
/*      */ 
/*      */       
/*  227 */       achivePO.awardState = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  232 */       this.player.bag.addCodeItemMail(achievementExt.awardKey, achievementExt.awardValue, null, Const.GOODS_CHANGE_TYPE.achieve, "Bag_full_common");
/*      */     } else {
/*  234 */       data.code = 500;
/*  235 */       data.msg = LangService.getValue("SOMETHING_ERR");
/*  236 */       return data;
/*      */     } 
/*      */     
/*  239 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onIllusionTimeChange(int minutes) {
/*  249 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ILLUSION_TIME);
/*  250 */     if (achievementArray.size() > 0) {
/*  251 */       this.achievementService._onConditionChange(minutes, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onKillBoss(int num) {
/*  259 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.KILL_BOSS);
/*  260 */     if (achievementArray.size() > 0) {
/*  261 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPassDemonTower(int floor, boolean win) {
/*  269 */     if (win) {
/*  270 */       List<AchievementExt> list = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PASS_DEMONTOWER);
/*  271 */       if (list.size() > 0) {
/*  272 */         this.achievementService._onConditionChange(floor, list, this.player, false);
/*      */       }
/*      */     } 
/*  275 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.DEMONTOWER_TIMES);
/*  276 */     if (achievementArray.size() > 0) {
/*  277 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onWorldSpeakTimes() {
/*  285 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.WORLD_SPEAK_TIME);
/*  286 */     if (achievementArray.size() > 0) {
/*  287 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onGemFillTotalLevel() {
/*  295 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_FILL_TOTAL_LEVEL);
/*  296 */     int level = 0;
/*  297 */     for (PlayerBasePO.EquipStrengthPos pos : this.player.equipManager.strengthPos.values()) {
/*  298 */       for (String code : pos.gems.values()) {
/*  299 */         if (StringUtil.isEmpty(code))
/*      */           continue; 
/*  301 */         DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
/*  302 */         level += prop.levelReq;
/*      */       } 
/*      */     } 
/*  305 */     if (achievementArray.size() > 0) {
/*  306 */       this.achievementService._onConditionChange(level, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEquipPosStrengthLevel(int pos, int level) {
/*  314 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_POS_LEVEL);
/*      */     
/*  316 */     List<AchievementExt> tmpArray = new ArrayList<>();
/*  317 */     if (achievementArray.size() > 0) {
/*  318 */       for (AchievementExt achievement : achievementArray) {
/*  319 */         if (Integer.parseInt(achievement.targetID) <= level) {
/*  320 */           tmpArray.add(achievement);
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  325 */     if (tmpArray.size() > 0) {
/*  326 */       this.achievementService._onConditionChange(pos, tmpArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEquipMake() {
/*  334 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_MAKE_TIMES);
/*  335 */     if (achievementArray.size() > 0) {
/*  336 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEquipReborn() {
/*  344 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REBORN_TIMES);
/*  345 */     if (achievementArray.size() > 0) {
/*  346 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEquipRefine() {
/*  354 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REFINE_TIMES);
/*  355 */     if (achievementArray.size() > 0) {
/*  356 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEquipRebuild() {
/*  364 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIP_REBUILD_TIMES);
/*  365 */     if (achievementArray.size() > 0) {
/*  366 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPassFiveVsFive() {
/*  374 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FIVE_VS_FIVE_TIMES);
/*  375 */     if (achievementArray.size() > 0) {
/*  376 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onArenaBattle() {
/*  384 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.AREANA_TIMES);
/*  385 */     if (achievementArray.size() > 0) {
/*  386 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onSoloBattle() {
/*  394 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_TIMES);
/*  395 */     if (achievementArray.size() > 0) {
/*  396 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onWorldLevelTimes() {
/*  404 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.WORLD_LEVEL_TIMES);
/*  405 */     if (achievementArray.size() > 0) {
/*  406 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onMountGot() {
/*  414 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.MOUNT_COUNT);
/*  415 */     if (achievementArray.size() > 0) {
/*  416 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onXianyuanChange(int num) {
/*  424 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.XIANYUAN_COUNT);
/*  425 */     if (achievementArray.size() > 0) {
/*  426 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void playerLevelChange(int newLevel) {
/*  436 */     if (this.achievementService.achievementLevelArray.size() > 0) {
/*  437 */       this.achievementService._onConditionChange(newLevel, this.achievementService.achievementLevelArray, this.player, false);
/*      */     }
/*      */     
/*  440 */     updateSuperScript();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void playerRankChange(int newRank) {
/*  449 */     List<AchievementExt> achievementArray = this.achievementService.achievementUpLevelArray;
/*  450 */     if (achievementArray.size() > 0) {
/*  451 */       this.achievementService._onConditionChange(newRank, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void playerPowerChange(int newPower) {
/*  461 */     List<AchievementExt> achievementArray = this.achievementService.achievementPower;
/*  462 */     if (achievementArray.size() > 0) {
/*  463 */       this.achievementService._onConditionChange(newPower, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void killNpc(String npcId) {
/*  473 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.KILL_NPC, Integer.parseInt(npcId));
/*      */     
/*  475 */     if (achievementArray.size() > 0) {
/*  476 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void equipEnhance(int pos, int level) {
/*  486 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENHANCE, pos);
/*  487 */     if (achievementArray.size() > 0) {
/*  488 */       this.achievementService._onConditionChange(level, achievementArray, this.player, false);
/*      */     }
/*      */     
/*  491 */     List<AchievementExt> achievementArray_every_pos = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENHANCE, 0);
/*      */     
/*  493 */     if (achievementArray_every_pos.size() > 0) {
/*  494 */       this.achievementService._onConditionChange(level, achievementArray_every_pos, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onPlaceArrived(int achievementId) {
/*  499 */     List<AchievementExt> achievementArray = this.achievementService.findAchievementsByIdAndConditionType(achievementId, Const.ACHIEVEMENT_CONDITION_TYPE.PLACE_ARRIVED);
/*      */     
/*  501 */     if (achievementArray.size() > 0) {
/*  502 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onFinishTask(int taskId) {
/*  507 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_TASK, taskId);
/*      */     
/*  509 */     if (achievementArray.size() > 0) {
/*  510 */       this.achievementService._onConditionChange(1, achievementArray, this.player, false);
/*      */     }
/*      */     
/*  513 */     for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {
/*  514 */       if (config.quest == taskId) {
/*  515 */         updateSuperScript();
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onFinishTaskNum(int kind) {
/*  522 */     Const.ACHIEVEMENT_CONDITION_TYPE conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.DEFAULT;
/*      */     
/*  524 */     if (kind == 2) {
/*  525 */       conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_DAILY_TASK;
/*  526 */     } else if (kind == 3) {
/*  527 */       conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_LOOP_TASK;
/*  528 */     } else if (kind == 0 || kind == 1) {
/*  529 */       conditionType = Const.ACHIEVEMENT_CONDITION_TYPE.FINISH_TASK_NUM;
/*      */     } 
/*      */     
/*  532 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(conditionType);
/*      */     
/*  534 */     if (achievementArray.size() > 0) {
/*  535 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetGold(int num) {
/*  540 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_GOLD);
/*      */     
/*  542 */     if (achievementArray.size() > 0) {
/*  543 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetDiamondInConsignment(int num) {
/*  548 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_DIAMOND_IN_CONSIGNMENT);
/*      */     
/*  550 */     if (achievementArray.size() > 0) {
/*  551 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetMagicRing(String ringId) {
/*  556 */     List<AchievementExt> achievementArray = new ArrayList<>();
/*  557 */     Collection<AchievementExt> datas = GameData.Achievements.values();
/*      */     
/*  559 */     for (AchievementCO d : datas) {
/*  560 */       AchievementExt data = (AchievementExt)d;
/*  561 */       if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_MAGIC_RING.value != data.conditionType) {
/*      */         continue;
/*      */       }
/*  564 */       if (!data.targetID.equals(ringId)) {
/*      */         continue;
/*      */       }
/*  567 */       achievementArray.add(data);
/*      */     } 
/*      */     
/*  570 */     if (achievementArray.size() > 0) {
/*  571 */       this.achievementService._onConditionChange(1, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetMedal(String medalId) {
/*  576 */     List<AchievementExt> achievementArray = new ArrayList<>();
/*  577 */     Collection<AchievementExt> datas = GameData.Achievements.values();
/*      */     
/*  579 */     for (AchievementCO d : datas) {
/*  580 */       AchievementExt data = (AchievementExt)d;
/*  581 */       if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_MEDAL.value != data.conditionType) {
/*      */         continue;
/*      */       }
/*      */       
/*  585 */       if (!data.targetID.equals(medalId)) {
/*      */         continue;
/*      */       }
/*  588 */       achievementArray.add(data);
/*      */     } 
/*      */     
/*  591 */     if (achievementArray.size() > 0) {
/*  592 */       this.achievementService._onConditionChange(1, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetNecklace(String medalId) {
/*  597 */     List<AchievementExt> achievementArray = new ArrayList<>();
/*  598 */     Collection<AchievementExt> datas = GameData.Achievements.values();
/*      */     
/*  600 */     for (AchievementCO d : datas) {
/*  601 */       AchievementExt data = (AchievementExt)d;
/*  602 */       if (Const.ACHIEVEMENT_CONDITION_TYPE.GET_NECKLACE.value != data.conditionType) {
/*      */         continue;
/*      */       }
/*      */       
/*  606 */       if (!data.targetID.equals(medalId)) {
/*      */         continue;
/*      */       }
/*  609 */       achievementArray.add(data);
/*      */     } 
/*      */     
/*  612 */     if (achievementArray.size() > 0) {
/*  613 */       this.achievementService._onConditionChange(1, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onGetEquipment(String code) {
/*  621 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GET_EQUIPMENT, code);
/*      */     
/*  623 */     if (achievementArray.size() > 0) {
/*  624 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onEquipEnchant() {
/*  629 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.EQUIPMENT_ENCHANT);
/*      */     
/*  631 */     if (achievementArray.size() > 0) {
/*  632 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetPet(int color) {
/*  637 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_PET);
/*      */     
/*  639 */     if (achievementArray.size() > 0) {
/*  640 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */ 
/*      */     
/*  644 */     List<AchievementExt> achievementArray_petColor = new ArrayList<>();
/*      */     
/*  646 */     List<AchievementExt> datas = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.GET_QUALITY_PET);
/*      */     
/*  648 */     for (AchievementExt data : datas) {
/*  649 */       if (Integer.parseInt(data.targetID) > color) {
/*      */         continue;
/*      */       }
/*  652 */       achievementArray_petColor.add(data);
/*      */     } 
/*      */     
/*  655 */     if (achievementArray_petColor.size() > 0) {
/*  656 */       this.achievementService._onConditionChange(1, achievementArray_petColor, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetPetLevel(int petId, int level) {
/*  661 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_LEVEL);
/*  662 */     List<AchievementExt> tmpArray = new ArrayList<>();
/*  663 */     if (achievementArray.size() > 0) {
/*  664 */       for (AchievementExt achievement : achievementArray) {
/*  665 */         if (Integer.parseInt(achievement.targetID) <= level) {
/*  666 */           tmpArray.add(achievement);
/*      */         }
/*      */       } 
/*      */       
/*  670 */       this.achievementService._onConditionChange(petId, tmpArray, this.player, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onPetUpGrade(int olderLevel, int level) {
/*  675 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_UPGRADE_LEVEL);
/*  676 */     List<AchievementExt> tmpArray = new ArrayList<>();
/*  677 */     if (achievementArray.size() > 0) {
/*  678 */       for (AchievementExt achievement : achievementArray) {
/*  679 */         if (Integer.parseInt(achievement.targetID) > olderLevel && Integer.parseInt(achievement.targetID) <= level) {
/*  680 */           tmpArray.add(achievement);
/*      */         }
/*      */       } 
/*      */       
/*  684 */       this.achievementService._onConditionChange(1, tmpArray, this.player, false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onPetTransformLevel(int olderLevel, int level) {
/*  689 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.PET_TRANSFORM_LEVEL);
/*  690 */     List<AchievementExt> tmpArray = new ArrayList<>();
/*  691 */     if (achievementArray.size() > 0) {
/*  692 */       for (AchievementExt achievement : achievementArray) {
/*  693 */         if (Integer.parseInt(achievement.targetID) > olderLevel && Integer.parseInt(achievement.targetID) <= level) {
/*  694 */           tmpArray.add(achievement);
/*      */         }
/*      */       } 
/*      */       
/*  698 */       this.achievementService._onConditionChange(1, tmpArray, this.player, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onHorseLevelChange(int level) {
/*  703 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.RIDE_DEVELOPMENT);
/*      */     
/*  705 */     if (achievementArray.size() > 0) {
/*  706 */       this.achievementService._onConditionChange(level, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onWingLevelChange(int id) {
/*  711 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.WING_LEVEL, id);
/*      */     
/*  713 */     if (achievementArray.size() > 0) {
/*  714 */       this.achievementService._onConditionChange(1, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFishing() {
/*  728 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FISH_ITEM);
/*      */     
/*  730 */     if (achievementArray.size() > 0) {
/*  731 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onSkillLevelChange(int level) {
/*  736 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SKILL_LEVEL);
/*      */     
/*  738 */     if (achievementArray.size() > 0) {
/*  739 */       this.achievementService._onConditionChange(level, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onPassedDungeon(int id) {
/*  744 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.DUNGEON_PASSED, id);
/*      */     
/*  746 */     if (achievementArray.size() > 0) {
/*  747 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onWinSolo(int rankId) {
/*  752 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_WIN);
/*      */     
/*  754 */     if (achievementArray.size() > 0) {
/*  755 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */ 
/*      */     
/*  759 */     List<AchievementExt> achievementArray_soloRank = this.achievementService.findByConditionTypeAndTargetIdInt(Const.ACHIEVEMENT_CONDITION_TYPE.SOLO_RANK, rankId);
/*      */     
/*  761 */     if (achievementArray_soloRank.size() > 0) {
/*  762 */       this.achievementService._onConditionChange(1, achievementArray_soloRank, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onArenaKill() {
/*  767 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ARENA_KILL_PLAYER);
/*      */     
/*  769 */     if (achievementArray.size() > 0) {
/*  770 */       this.achievementService._onConditionChange(1, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onArenaScore(int score) {
/*  775 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ARENA_SCORE);
/*      */     
/*  777 */     if (achievementArray.size() > 0) {
/*  778 */       this.achievementService._onConditionChange(score, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetAllyGold(int gold) {
/*  783 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ALLY_GOLD);
/*      */     
/*  785 */     if (achievementArray.size() > 0) {
/*  786 */       this.achievementService._onConditionChange(gold, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGetAllyKillCount(int count) {
/*  791 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.ALLY_KILL_PLAYER);
/*      */     
/*  793 */     if (achievementArray.size() > 0) {
/*  794 */       this.achievementService._onConditionChange(count, achievementArray, this.player, false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onFriendNumber(int friendNum) {
/*  799 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FRIENDS_NUM);
/*      */     
/*  801 */     if (achievementArray.size() > 0) {
/*  802 */       this.achievementService._onConditionChange(friendNum, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onGemCombine(String code, int num) {
/*  807 */     List<AchievementExt> achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_COMBINE, code);
/*      */     
/*  809 */     if (achievementArray.size() > 0) {
/*  810 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onTaskEvent(TaskEvent event) {
/*  818 */     int eventName = event.type;
/*  819 */     if (eventName == Const.EventType.killMonster.getValue()) {
/*  820 */       killNpc(event.params[0].toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEvent(Const.ACHIEVEMENT_CONDITION_TYPE condition_type, Object... params) {
/*  828 */     List<AchievementExt> achievementArray = null;
/*  829 */     int num = 0;
/*  830 */     switch (condition_type) {
/*      */       case GEM_COMBINE:
/*  832 */         achievementArray = this.achievementService.findByConditionTypeAndTargetIdString(Const.ACHIEVEMENT_CONDITION_TYPE.GEM_COMBINE, (String)params[0]);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  838 */     if (achievementArray.size() > 0) {
/*  839 */       this.achievementService._onConditionChange(num, achievementArray, this.player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/*  851 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*  852 */     int number = 0;
/*      */     
/*  854 */     Map<Integer, Integer> chapters = new HashMap<>();
/*  855 */     for (null = GameData.AchievementConfigs.keySet().iterator(); null.hasNext(); ) { int typeId = ((Integer)null.next()).intValue();
/*  856 */       chapters.put(Integer.valueOf(typeId), Integer.valueOf(0)); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  870 */     for (AchievementDataPO.AchievePO achievePO : this.achievementDataPO.achievements.values()) {
/*  871 */       AchievementExt prop = (AchievementExt)GameData.Achievements.get(Integer.valueOf(achievePO.id));
/*  872 */       if (prop == null) {
/*  873 */         Out.error(new Object[] { AchievementManager.class, Integer.valueOf(achievePO.id) });
/*      */         
/*      */         continue;
/*      */       } 
/*  877 */       AchievementConfigExt config = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(prop.chapterID));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  882 */       if (!AchievementServiceNew.GetChapterOpened(this.player.getId(), prop.chapterID)) {
/*      */         continue;
/*      */       }
/*  885 */       if (achievePO.scheduleCurr >= prop.targetNum && 
/*  886 */         achievePO.awardState == 0) {
/*  887 */         number++;
/*      */ 
/*      */         
/*  890 */         if (chapters.containsKey(Integer.valueOf(config.typeId))) {
/*  891 */           chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(((Integer)chapters.get(Integer.valueOf(config.typeId))).intValue() + 1)); continue;
/*      */         } 
/*  893 */         chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(1));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  899 */     for (AchievementConfigExt config : GameData.AchievementConfigs.values()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  907 */       if (!AchievementServiceNew.GetChapterOpened(this.player.getId(), config.typeId)) {
/*      */         continue;
/*      */       }
/*  910 */       if (this.achievementDataPO.receivedAwards.contains(Integer.valueOf(config.typeId))) {
/*      */         continue;
/*      */       }
/*  913 */       List<AchievementExt> list_achieve = GameData.findAchievements(t -> (t.chapterID == config.typeId));
/*      */ 
/*      */       
/*  916 */       if (list_achieve.size() == 0) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/*  921 */       int recordCount = 0;
/*  922 */       for (AchievementExt achievementProp : list_achieve) {
/*  923 */         AchievementDataPO.AchievePO achieve = this.achievementRecordMap.get(Integer.valueOf(achievementProp.id));
/*      */         
/*  925 */         if (achieve == null) {
/*      */           continue;
/*      */         }
/*  928 */         if (achieve.awardState == 1) {
/*  929 */           recordCount++; continue;
/*      */         } 
/*  931 */         if (this.achievementService.isComplete(achieve, achievementProp)) {
/*  932 */           recordCount++;
/*      */         }
/*      */       } 
/*      */       
/*  936 */       if (recordCount == list_achieve.size()) {
/*  937 */         number++;
/*      */ 
/*      */         
/*  940 */         if (chapters.containsKey(Integer.valueOf(config.typeId))) {
/*  941 */           chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(((Integer)chapters.get(Integer.valueOf(config.typeId))).intValue() + 1)); continue;
/*      */         } 
/*  943 */         chapters.put(Integer.valueOf(config.typeId), Integer.valueOf(1));
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  948 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  949 */     data.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TARGET.getValue());
/*  950 */     data.setNumber(number);
/*  951 */     list.add(data.build());
/*      */ 
/*      */     
/*  954 */     for (Iterator<Integer> iterator = chapters.keySet().iterator(); iterator.hasNext(); ) { int chapterId = ((Integer)iterator.next()).intValue();
/*  955 */       PlayerHandler.SuperScriptType.Builder sc = PlayerHandler.SuperScriptType.newBuilder();
/*  956 */       sc.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TARGET.getValue() + chapterId / 10);
/*  957 */       sc.setNumber(((Integer)chapters.get(Integer.valueOf(chapterId))).intValue());
/*  958 */       list.add(sc.build()); }
/*      */ 
/*      */ 
/*      */     
/*  962 */     Map<Integer, int[]> progressMap = AchievementServiceNew.GetChapterProgress(this.player.getId());
/*  963 */     int progress = 0;
/*  964 */     for (int[] ar : progressMap.values()) {
/*  965 */       progress += ar[0];
/*      */     }
/*  967 */     PlayerHandler.SuperScriptType.Builder progressData = PlayerHandler.SuperScriptType.newBuilder();
/*  968 */     progressData.setType(Const.SUPERSCRIPT_TYPE.GROWUP_TOTAL.getValue());
/*  969 */     progressData.setNumber(progress);
/*  970 */     list.add(progressData.build());
/*  971 */     return list;
/*      */   }
/*      */   
/*      */   public void updateSuperScript() {
/*  975 */     this.player.updateSuperScriptList(getSuperScript());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
/*  982 */     Map<Const.PlayerBtlData, Integer> data = new HashMap<>();
/*      */     
/*  984 */     int haveCount = 0;
/*  985 */     for (AchievementDataPO.HolyArmour holyArmour : this.achievementDataPO.holyArmourMap.values()) {
/*  986 */       if (holyArmour.states == 3) {
/*  987 */         ArmourAttributeExt armourAttributeExt = (ArmourAttributeExt)GameData.ArmourAttributes.get(Integer.valueOf(holyArmour.id));
/*  988 */         AttributeUtil.addData2AllData(armourAttributeExt.atts, data);
/*  989 */         haveCount++;
/*      */       } 
/*      */     } 
/*  992 */     if (haveCount > 0) {
/*  993 */       int x = haveCount;
/*  994 */       for (ArmourPlusExt armourPlusExt : GameData.findArmourPluss(v -> (x >= v.activateNum))) {
/*  995 */         AttributeUtil.addData2AllData(armourPlusExt.atts, data);
/*      */       }
/*      */     } 
/*  998 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean activateHolyArmour(int id) {
/* 1005 */     AchievementDataPO.HolyArmour armour = (AchievementDataPO.HolyArmour)this.player.achievementManager.achievementDataPO.holyArmourMap.get(Integer.valueOf(id));
/* 1006 */     if (armour.states != 2) {
/* 1007 */       return false;
/*      */     }
/* 1009 */     armour.states = 3;
/* 1010 */     this.player.btlDataManager.data_holy_armour = calAllInfluence();
/* 1011 */     this.player.btlDataManager.calFinalData();
/* 1012 */     this.player.onArmourActive();
/* 1013 */     this.player.refreshBattlerServerAvatar();
/*      */ 
/*      */     
/* 1016 */     Map<Integer, String> data = new HashMap<>();
/* 1017 */     for (AchievementDataPO.HolyArmour holyArmour : this.achievementDataPO.holyArmourMap.values()) {
/* 1018 */       if (holyArmour.states == 3) {
/* 1019 */         ArmourAttributeExt armourAttributeExt = (ArmourAttributeExt)GameData.ArmourAttributes.get(Integer.valueOf(holyArmour.id));
/* 1020 */         if (armourAttributeExt != null) {
/* 1021 */           data.put(Integer.valueOf(holyArmour.id), armourAttributeExt.name);
/*      */         }
/*      */       } 
/*      */     } 
/* 1025 */     BILogService.getInstance().ansycReportHolyArmour(this.player.getPlayer(), data);
/*      */     
/* 1027 */     Out.info(new Object[] { "玩家：", this.player.getId(), "激活了元始圣甲，部位id:", Integer.valueOf(id) });
/* 1028 */     return true;
/*      */   }
/*      */   
/*      */   public void FinishChapterAchievement(int chapterId) {
/* 1032 */     Map<Integer, AchievementDataPO.AchievePO> achievementRecords = this.player.achievementManager.getAchievementRecords();
/*      */     
/* 1034 */     List<AchievementExt> achievementArray = GameData.findAchievements(t -> (t.chapterID == chapterId));
/*      */ 
/*      */ 
/*      */     
/* 1038 */     for (AchievementExt achievement : achievementArray) {
/*      */ 
/*      */ 
/*      */       
/* 1042 */       AchievementDataPO.AchievePO achievementRecord = achievementRecords.get(Integer.valueOf(achievement.id));
/* 1043 */       if (achievementRecord == null) {
/* 1044 */         achievementRecord = new AchievementDataPO.AchievePO();
/* 1045 */         achievementRecord.id = achievement.id;
/* 1046 */         achievementRecord.scheduleCurr = 0;
/* 1047 */         achievementRecords.put(Integer.valueOf(achievement.id), achievementRecord);
/*      */       } 
/* 1049 */       achievementRecord.scheduleCurr = achievement.targetNum;
/*      */     } 
/*      */ 
/*      */     
/* 1053 */     this.player.achievementManager.updateSuperScript();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\achievement\AchievementManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */