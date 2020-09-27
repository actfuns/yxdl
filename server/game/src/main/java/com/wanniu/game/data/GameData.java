/*      */ package com.wanniu.game.data;
/*      */ 
/*      */ import com.wanniu.game.data.ext.AccumulateExt;
/*      */ import com.wanniu.game.data.ext.AchievementConfigExt;
/*      */ import com.wanniu.game.data.ext.AchievementExt;
/*      */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*      */ import com.wanniu.game.data.ext.ActivityExt;
/*      */ import com.wanniu.game.data.ext.AffixExt;
/*      */ import com.wanniu.game.data.ext.ArmourAttributeExt;
/*      */ import com.wanniu.game.data.ext.ArmourPlusExt;
/*      */ import com.wanniu.game.data.ext.AttributeExt;
/*      */ import com.wanniu.game.data.ext.BaseDataExt;
/*      */ import com.wanniu.game.data.ext.BattleRoyaleRankExt;
/*      */ import com.wanniu.game.data.ext.BattleRoyaleRankSeasonRewardExt;
/*      */ import com.wanniu.game.data.ext.BlackWordExt;
/*      */ import com.wanniu.game.data.ext.BlessBuffExt;
/*      */ import com.wanniu.game.data.ext.BlessLevelExt;
/*      */ import com.wanniu.game.data.ext.BlesslibaoExt;
/*      */ import com.wanniu.game.data.ext.BloodSuitListExt;
/*      */ import com.wanniu.game.data.ext.BlueEquipExt;
/*      */ import com.wanniu.game.data.ext.CharacterExt;
/*      */ import com.wanniu.game.data.ext.CombineExt;
/*      */ import com.wanniu.game.data.ext.DailyPayExt;
/*      */ import com.wanniu.game.data.ext.DayRewardExt;
/*      */ import com.wanniu.game.data.ext.DrawExt;
/*      */ import com.wanniu.game.data.ext.DropListExt;
/*      */ import com.wanniu.game.data.ext.EnchantBonusExt;
/*      */ import com.wanniu.game.data.ext.EnchantExt;
/*      */ import com.wanniu.game.data.ext.EquipMakeExt;
/*      */ import com.wanniu.game.data.ext.EquipSockExt;
/*      */ import com.wanniu.game.data.ext.ExchangeMallExt;
/*      */ import com.wanniu.game.data.ext.FashSuitConfigExt;
/*      */ import com.wanniu.game.data.ext.FashionExt;
/*      */ import com.wanniu.game.data.ext.FirstPayExt;
/*      */ import com.wanniu.game.data.ext.GBuffExt;
/*      */ import com.wanniu.game.data.ext.GShopExt;
/*      */ import com.wanniu.game.data.ext.GTechnologyExt;
/*      */ import com.wanniu.game.data.ext.GuildFortExt;
/*      */ import com.wanniu.game.data.ext.GuildSettingExt;
/*      */ import com.wanniu.game.data.ext.InspireLevelExt;
/*      */ import com.wanniu.game.data.ext.ItemIdConfigExt;
/*      */ import com.wanniu.game.data.ext.ItemTypeConfigExt;
/*      */ import com.wanniu.game.data.ext.JJCRewardExt;
/*      */ import com.wanniu.game.data.ext.KaiGuangExt;
/*      */ import com.wanniu.game.data.ext.LegendEquipExt;
/*      */ import com.wanniu.game.data.ext.LuxurySignExt;
/*      */ import com.wanniu.game.data.ext.MasterPropExt;
/*      */ import com.wanniu.game.data.ext.MasterUpgradePropExt;
/*      */ import com.wanniu.game.data.ext.MasteryPropExt;
/*      */ import com.wanniu.game.data.ext.MedalListExt;
/*      */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*      */ import com.wanniu.game.data.ext.NormalEquipExt;
/*      */ import com.wanniu.game.data.ext.NormalSignExt;
/*      */ import com.wanniu.game.data.ext.NoticeSendExt;
/*      */ import com.wanniu.game.data.ext.NpcListExt;
/*      */ import com.wanniu.game.data.ext.OlGiftExt;
/*      */ import com.wanniu.game.data.ext.PassiveSkillExt;
/*      */ import com.wanniu.game.data.ext.PayRewardExt;
/*      */ import com.wanniu.game.data.ext.PersonalRankExt;
/*      */ import com.wanniu.game.data.ext.PetAssociateExt;
/*      */ import com.wanniu.game.data.ext.PetConfigExt;
/*      */ import com.wanniu.game.data.ext.PetSkillExt;
/*      */ import com.wanniu.game.data.ext.PetUpgradeExt;
/*      */ import com.wanniu.game.data.ext.PurpleEquipExt;
/*      */ import com.wanniu.game.data.ext.RandomBoxExt;
/*      */ import com.wanniu.game.data.ext.RankListExt;
/*      */ import com.wanniu.game.data.ext.RankRewardExt;
/*      */ import com.wanniu.game.data.ext.ReBornExt;
/*      */ import com.wanniu.game.data.ext.ReBuildExt;
/*      */ import com.wanniu.game.data.ext.RecoveryExt;
/*      */ import com.wanniu.game.data.ext.RefineExt;
/*      */ import com.wanniu.game.data.ext.RideEquipExt;
/*      */ import com.wanniu.game.data.ext.RideListExt;
/*      */ import com.wanniu.game.data.ext.ScheduleExt;
/*      */ import com.wanniu.game.data.ext.SeniorReBuildExt;
/*      */ import com.wanniu.game.data.ext.SevTaskRewardExt;
/*      */ import com.wanniu.game.data.ext.ShopMallItemsExt;
/*      */ import com.wanniu.game.data.ext.SkillDataExt;
/*      */ import com.wanniu.game.data.ext.SkillValueExt;
/*      */ import com.wanniu.game.data.ext.SkinListExt;
/*      */ import com.wanniu.game.data.ext.SmritiExt;
/*      */ import com.wanniu.game.data.ext.SoloRankExt;
/*      */ import com.wanniu.game.data.ext.SoloRankSeasonRewardExt;
/*      */ import com.wanniu.game.data.ext.SuitConfigExt;
/*      */ import com.wanniu.game.data.ext.SuitEquipExt;
/*      */ import com.wanniu.game.data.ext.SuitListExt;
/*      */ import com.wanniu.game.data.ext.TeamPropExt;
/*      */ import com.wanniu.game.data.ext.TeamTargetExt;
/*      */ import com.wanniu.game.data.ext.TotalPayExt;
/*      */ import com.wanniu.game.data.ext.TransportExt;
/*      */ import com.wanniu.game.data.ext.TreasureClassExt;
/*      */ import com.wanniu.game.data.ext.TurnRewardExt;
/*      */ import com.wanniu.game.data.ext.UniqueEquipExt;
/*      */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*      */ import com.wanniu.game.data.ext.VitBonusExt;
/*      */ import com.wanniu.game.data.ext.WayTreasureExt;
/*      */ import com.wanniu.game.data.ext.WingsListExt;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.function.Predicate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class GameData
/*      */ {
/*  111 */   public static Map<Integer, DayRewardExt> DayRewards = new HashMap<>();
/*      */   public static List<DayRewardExt> findDayRewards(Predicate<DayRewardExt> pre) {
/*  113 */     List<DayRewardExt> results = new ArrayList<>();
/*  114 */     for (DayRewardExt t : DayRewards.values()) {
/*  115 */       if (pre.test(t)) {
/*  116 */         results.add(t);
/*      */       }
/*      */     } 
/*  119 */     return results;
/*      */   }
/*      */   
/*  122 */   public static Map<Integer, PersonalRankExt> PersonalRanks = new HashMap<>();
/*      */   public static List<PersonalRankExt> findPersonalRanks(Predicate<PersonalRankExt> pre) {
/*  124 */     List<PersonalRankExt> results = new ArrayList<>();
/*  125 */     for (PersonalRankExt t : PersonalRanks.values()) {
/*  126 */       if (pre.test(t)) {
/*  127 */         results.add(t);
/*      */       }
/*      */     } 
/*  130 */     return results;
/*      */   }
/*      */   
/*  133 */   public static Map<Integer, AchievementExt> Achievements = new HashMap<>();
/*      */   public static List<AchievementExt> findAchievements(Predicate<AchievementExt> pre) {
/*  135 */     List<AchievementExt> results = new ArrayList<>();
/*  136 */     for (AchievementExt t : Achievements.values()) {
/*  137 */       if (pre.test(t)) {
/*  138 */         results.add(t);
/*      */       }
/*      */     } 
/*  141 */     return results;
/*      */   }
/*      */   
/*  144 */   public static Map<Integer, AchievementConfigExt> AchievementConfigs = new HashMap<>();
/*      */   public static List<AchievementConfigExt> findAchievementConfigs(Predicate<AchievementConfigExt> pre) {
/*  146 */     List<AchievementConfigExt> results = new ArrayList<>();
/*  147 */     for (AchievementConfigExt t : AchievementConfigs.values()) {
/*  148 */       if (pre.test(t)) {
/*  149 */         results.add(t);
/*      */       }
/*      */     } 
/*  152 */     return results;
/*      */   }
/*      */   
/*  155 */   public static Map<Integer, ArmourAttributeExt> ArmourAttributes = new HashMap<>();
/*      */   public static List<ArmourAttributeExt> findArmourAttributes(Predicate<ArmourAttributeExt> pre) {
/*  157 */     List<ArmourAttributeExt> results = new ArrayList<>();
/*  158 */     for (ArmourAttributeExt t : ArmourAttributes.values()) {
/*  159 */       if (pre.test(t)) {
/*  160 */         results.add(t);
/*      */       }
/*      */     } 
/*  163 */     return results;
/*      */   }
/*      */   
/*  166 */   public static Map<Integer, ArmourPlusExt> ArmourPluss = new HashMap<>();
/*      */   public static List<ArmourPlusExt> findArmourPluss(Predicate<ArmourPlusExt> pre) {
/*  168 */     List<ArmourPlusExt> results = new ArrayList<>();
/*  169 */     for (ArmourPlusExt t : ArmourPluss.values()) {
/*  170 */       if (pre.test(t)) {
/*  171 */         results.add(t);
/*      */       }
/*      */     } 
/*  174 */     return results;
/*      */   }
/*      */   
/*  177 */   public static Map<Integer, AchievementSeniorCO> AchievementSeniors = new HashMap<>();
/*      */   public static List<AchievementSeniorCO> findAchievementSeniors(Predicate<AchievementSeniorCO> pre) {
/*  179 */     List<AchievementSeniorCO> results = new ArrayList<>();
/*  180 */     for (AchievementSeniorCO t : AchievementSeniors.values()) {
/*  181 */       if (pre.test(t)) {
/*  182 */         results.add(t);
/*      */       }
/*      */     } 
/*  185 */     return results;
/*      */   }
/*      */   
/*  188 */   public static Map<Integer, AchievementAwardCO> AchievementAwards = new HashMap<>();
/*      */   public static List<AchievementAwardCO> findAchievementAwards(Predicate<AchievementAwardCO> pre) {
/*  190 */     List<AchievementAwardCO> results = new ArrayList<>();
/*  191 */     for (AchievementAwardCO t : AchievementAwards.values()) {
/*  192 */       if (pre.test(t)) {
/*  193 */         results.add(t);
/*      */       }
/*      */     } 
/*  196 */     return results;
/*      */   }
/*      */   
/*  199 */   public static Map<Integer, AchievementConfigSeniorCO> AchievementConfigSeniors = new HashMap<>();
/*      */   public static List<AchievementConfigSeniorCO> findAchievementConfigSeniors(Predicate<AchievementConfigSeniorCO> pre) {
/*  201 */     List<AchievementConfigSeniorCO> results = new ArrayList<>();
/*  202 */     for (AchievementConfigSeniorCO t : AchievementConfigSeniors.values()) {
/*  203 */       if (pre.test(t)) {
/*  204 */         results.add(t);
/*      */       }
/*      */     } 
/*  207 */     return results;
/*      */   }
/*      */   
/*  210 */   public static Map<Integer, AchievewordsCO> Achievewordss = new HashMap<>();
/*      */   public static List<AchievewordsCO> findAchievewordss(Predicate<AchievewordsCO> pre) {
/*  212 */     List<AchievewordsCO> results = new ArrayList<>();
/*  213 */     for (AchievewordsCO t : Achievewordss.values()) {
/*  214 */       if (pre.test(t)) {
/*  215 */         results.add(t);
/*      */       }
/*      */     } 
/*  218 */     return results;
/*      */   }
/*      */   
/*  221 */   public static Map<Integer, ActivityExt> Activitys = new HashMap<>();
/*      */   public static List<ActivityExt> findActivitys(Predicate<ActivityExt> pre) {
/*  223 */     List<ActivityExt> results = new ArrayList<>();
/*  224 */     for (ActivityExt t : Activitys.values()) {
/*  225 */       if (pre.test(t)) {
/*  226 */         results.add(t);
/*      */       }
/*      */     } 
/*  229 */     return results;
/*      */   }
/*      */   
/*  232 */   public static Map<Integer, ActivityConfigExt> ActivityConfigs = new HashMap<>();
/*      */   public static List<ActivityConfigExt> findActivityConfigs(Predicate<ActivityConfigExt> pre) {
/*  234 */     List<ActivityConfigExt> results = new ArrayList<>();
/*  235 */     for (ActivityConfigExt t : ActivityConfigs.values()) {
/*  236 */       if (pre.test(t)) {
/*  237 */         results.add(t);
/*      */       }
/*      */     } 
/*  240 */     return results;
/*      */   }
/*      */   
/*  243 */   public static Map<Integer, DiceCostCO> DiceCosts = new HashMap<>();
/*      */   public static List<DiceCostCO> findDiceCosts(Predicate<DiceCostCO> pre) {
/*  245 */     List<DiceCostCO> results = new ArrayList<>();
/*  246 */     for (DiceCostCO t : DiceCosts.values()) {
/*  247 */       if (pre.test(t)) {
/*  248 */         results.add(t);
/*      */       }
/*      */     } 
/*  251 */     return results;
/*      */   }
/*      */   
/*  254 */   public static Map<Integer, DiceFreeCO> DiceFrees = new HashMap<>();
/*      */   public static List<DiceFreeCO> findDiceFrees(Predicate<DiceFreeCO> pre) {
/*  256 */     List<DiceFreeCO> results = new ArrayList<>();
/*  257 */     for (DiceFreeCO t : DiceFrees.values()) {
/*  258 */       if (pre.test(t)) {
/*  259 */         results.add(t);
/*      */       }
/*      */     } 
/*  262 */     return results;
/*      */   }
/*      */   
/*  265 */   public static Map<Integer, DiceRewardCO> DiceRewards = new HashMap<>();
/*      */   public static List<DiceRewardCO> findDiceRewards(Predicate<DiceRewardCO> pre) {
/*  267 */     List<DiceRewardCO> results = new ArrayList<>();
/*  268 */     for (DiceRewardCO t : DiceRewards.values()) {
/*  269 */       if (pre.test(t)) {
/*  270 */         results.add(t);
/*      */       }
/*      */     } 
/*  273 */     return results;
/*      */   }
/*      */   
/*  276 */   public static Map<Integer, DiceTurnRewardCO> DiceTurnRewards = new HashMap<>();
/*      */   public static List<DiceTurnRewardCO> findDiceTurnRewards(Predicate<DiceTurnRewardCO> pre) {
/*  278 */     List<DiceTurnRewardCO> results = new ArrayList<>();
/*  279 */     for (DiceTurnRewardCO t : DiceTurnRewards.values()) {
/*  280 */       if (pre.test(t)) {
/*  281 */         results.add(t);
/*      */       }
/*      */     } 
/*  284 */     return results;
/*      */   }
/*      */   
/*  287 */   public static Map<Integer, FestivalGiftCO> FestivalGifts = new HashMap<>();
/*      */   public static List<FestivalGiftCO> findFestivalGifts(Predicate<FestivalGiftCO> pre) {
/*  289 */     List<FestivalGiftCO> results = new ArrayList<>();
/*  290 */     for (FestivalGiftCO t : FestivalGifts.values()) {
/*  291 */       if (pre.test(t)) {
/*  292 */         results.add(t);
/*      */       }
/*      */     } 
/*  295 */     return results;
/*      */   }
/*      */   
/*  298 */   public static Map<Integer, LimitTimeGiftCO> LimitTimeGifts = new HashMap<>();
/*      */   public static List<LimitTimeGiftCO> findLimitTimeGifts(Predicate<LimitTimeGiftCO> pre) {
/*  300 */     List<LimitTimeGiftCO> results = new ArrayList<>();
/*  301 */     for (LimitTimeGiftCO t : LimitTimeGifts.values()) {
/*  302 */       if (pre.test(t)) {
/*  303 */         results.add(t);
/*      */       }
/*      */     } 
/*  306 */     return results;
/*      */   }
/*      */   
/*  309 */   public static Map<Integer, AddRechargeLimitCO> AddRechargeLimits = new HashMap<>();
/*      */   public static List<AddRechargeLimitCO> findAddRechargeLimits(Predicate<AddRechargeLimitCO> pre) {
/*  311 */     List<AddRechargeLimitCO> results = new ArrayList<>();
/*  312 */     for (AddRechargeLimitCO t : AddRechargeLimits.values()) {
/*  313 */       if (pre.test(t)) {
/*  314 */         results.add(t);
/*      */       }
/*      */     } 
/*  317 */     return results;
/*      */   }
/*      */   
/*  320 */   public static Map<Integer, AdventureItemCO> AdventureItems = new HashMap<>();
/*      */   public static List<AdventureItemCO> findAdventureItems(Predicate<AdventureItemCO> pre) {
/*  322 */     List<AdventureItemCO> results = new ArrayList<>();
/*  323 */     for (AdventureItemCO t : AdventureItems.values()) {
/*  324 */       if (pre.test(t)) {
/*  325 */         results.add(t);
/*      */       }
/*      */     } 
/*  328 */     return results;
/*      */   }
/*      */   
/*  331 */   public static Map<Integer, AdventureItemAddCO> AdventureItemAdds = new HashMap<>();
/*      */   public static List<AdventureItemAddCO> findAdventureItemAdds(Predicate<AdventureItemAddCO> pre) {
/*  333 */     List<AdventureItemAddCO> results = new ArrayList<>();
/*  334 */     for (AdventureItemAddCO t : AdventureItemAdds.values()) {
/*  335 */       if (pre.test(t)) {
/*  336 */         results.add(t);
/*      */       }
/*      */     } 
/*  339 */     return results;
/*      */   }
/*      */   
/*  342 */   public static Map<Integer, ForgedRandomCO> ForgedRandoms = new HashMap<>();
/*      */   public static List<ForgedRandomCO> findForgedRandoms(Predicate<ForgedRandomCO> pre) {
/*  344 */     List<ForgedRandomCO> results = new ArrayList<>();
/*  345 */     for (ForgedRandomCO t : ForgedRandoms.values()) {
/*  346 */       if (pre.test(t)) {
/*  347 */         results.add(t);
/*      */       }
/*      */     } 
/*  350 */     return results;
/*      */   }
/*      */   
/*  353 */   public static Map<Integer, ForgedRandomAddCO> ForgedRandomAdds = new HashMap<>();
/*      */   public static List<ForgedRandomAddCO> findForgedRandomAdds(Predicate<ForgedRandomAddCO> pre) {
/*  355 */     List<ForgedRandomAddCO> results = new ArrayList<>();
/*  356 */     for (ForgedRandomAddCO t : ForgedRandomAdds.values()) {
/*  357 */       if (pre.test(t)) {
/*  358 */         results.add(t);
/*      */       }
/*      */     } 
/*  361 */     return results;
/*      */   }
/*      */   
/*  364 */   public static Map<Integer, GroupRandomCO> GroupRandoms = new HashMap<>();
/*      */   public static List<GroupRandomCO> findGroupRandoms(Predicate<GroupRandomCO> pre) {
/*  366 */     List<GroupRandomCO> results = new ArrayList<>();
/*  367 */     for (GroupRandomCO t : GroupRandoms.values()) {
/*  368 */       if (pre.test(t)) {
/*  369 */         results.add(t);
/*      */       }
/*      */     } 
/*  372 */     return results;
/*      */   }
/*      */   
/*  375 */   public static Map<Integer, GroupRandomAddCO> GroupRandomAdds = new HashMap<>();
/*      */   public static List<GroupRandomAddCO> findGroupRandomAdds(Predicate<GroupRandomAddCO> pre) {
/*  377 */     List<GroupRandomAddCO> results = new ArrayList<>();
/*  378 */     for (GroupRandomAddCO t : GroupRandomAdds.values()) {
/*  379 */       if (pre.test(t)) {
/*  380 */         results.add(t);
/*      */       }
/*      */     } 
/*  383 */     return results;
/*      */   }
/*      */   
/*  386 */   public static Map<Integer, BombboxCO> Bombboxs = new HashMap<>();
/*      */   public static List<BombboxCO> findBombboxs(Predicate<BombboxCO> pre) {
/*  388 */     List<BombboxCO> results = new ArrayList<>();
/*  389 */     for (BombboxCO t : Bombboxs.values()) {
/*  390 */       if (pre.test(t)) {
/*  391 */         results.add(t);
/*      */       }
/*      */     } 
/*  394 */     return results;
/*      */   }
/*      */   
/*  397 */   public static Map<Integer, PpresentCO> Ppresents = new HashMap<>();
/*      */   public static List<PpresentCO> findPpresents(Predicate<PpresentCO> pre) {
/*  399 */     List<PpresentCO> results = new ArrayList<>();
/*  400 */     for (PpresentCO t : Ppresents.values()) {
/*  401 */       if (pre.test(t)) {
/*  402 */         results.add(t);
/*      */       }
/*      */     } 
/*  405 */     return results;
/*      */   }
/*      */   
/*  408 */   public static Map<Integer, RankpreCO> Rankpres = new HashMap<>();
/*      */   public static List<RankpreCO> findRankpres(Predicate<RankpreCO> pre) {
/*  410 */     List<RankpreCO> results = new ArrayList<>();
/*  411 */     for (RankpreCO t : Rankpres.values()) {
/*  412 */       if (pre.test(t)) {
/*  413 */         results.add(t);
/*      */       }
/*      */     } 
/*  416 */     return results;
/*      */   }
/*      */   
/*  419 */   public static Map<Integer, DropListExt> DropLists = new HashMap<>();
/*      */   public static List<DropListExt> findDropLists(Predicate<DropListExt> pre) {
/*  421 */     List<DropListExt> results = new ArrayList<>();
/*  422 */     for (DropListExt t : DropLists.values()) {
/*  423 */       if (pre.test(t)) {
/*  424 */         results.add(t);
/*      */       }
/*      */     } 
/*  427 */     return results;
/*      */   }
/*      */   
/*  430 */   public static Map<String, MonsterConfigCO> MonsterConfigs = new HashMap<>();
/*      */   public static List<MonsterConfigCO> findMonsterConfigs(Predicate<MonsterConfigCO> pre) {
/*  432 */     List<MonsterConfigCO> results = new ArrayList<>();
/*  433 */     for (MonsterConfigCO t : MonsterConfigs.values()) {
/*  434 */       if (pre.test(t)) {
/*  435 */         results.add(t);
/*      */       }
/*      */     } 
/*  438 */     return results;
/*      */   }
/*      */   
/*  441 */   public static Map<Integer, DrawExt> Draws = new HashMap<>();
/*      */   public static List<DrawExt> findDraws(Predicate<DrawExt> pre) {
/*  443 */     List<DrawExt> results = new ArrayList<>();
/*  444 */     for (DrawExt t : Draws.values()) {
/*  445 */       if (pre.test(t)) {
/*  446 */         results.add(t);
/*      */       }
/*      */     } 
/*  449 */     return results;
/*      */   }
/*      */   
/*  452 */   public static Map<Integer, NoticeCO> Notices = new HashMap<>();
/*      */   public static List<NoticeCO> findNotices(Predicate<NoticeCO> pre) {
/*  454 */     List<NoticeCO> results = new ArrayList<>();
/*  455 */     for (NoticeCO t : Notices.values()) {
/*  456 */       if (pre.test(t)) {
/*  457 */         results.add(t);
/*      */       }
/*      */     } 
/*  460 */     return results;
/*      */   }
/*      */   
/*  463 */   public static Map<Integer, NoticeSendExt> NoticeSends = new HashMap<>();
/*      */   public static List<NoticeSendExt> findNoticeSends(Predicate<NoticeSendExt> pre) {
/*  465 */     List<NoticeSendExt> results = new ArrayList<>();
/*  466 */     for (NoticeSendExt t : NoticeSends.values()) {
/*  467 */       if (pre.test(t)) {
/*  468 */         results.add(t);
/*      */       }
/*      */     } 
/*  471 */     return results;
/*      */   }
/*      */   
/*  474 */   public static Map<Integer, OffLineExpCO> OffLineExps = new HashMap<>();
/*      */   public static List<OffLineExpCO> findOffLineExps(Predicate<OffLineExpCO> pre) {
/*  476 */     List<OffLineExpCO> results = new ArrayList<>();
/*  477 */     for (OffLineExpCO t : OffLineExps.values()) {
/*  478 */       if (pre.test(t)) {
/*  479 */         results.add(t);
/*      */       }
/*      */     } 
/*  482 */     return results;
/*      */   }
/*      */   
/*  485 */   public static Map<Integer, OlGiftExt> OlGifts = new HashMap<>();
/*      */   public static List<OlGiftExt> findOlGifts(Predicate<OlGiftExt> pre) {
/*  487 */     List<OlGiftExt> results = new ArrayList<>();
/*  488 */     for (OlGiftExt t : OlGifts.values()) {
/*  489 */       if (pre.test(t)) {
/*  490 */         results.add(t);
/*      */       }
/*      */     } 
/*  493 */     return results;
/*      */   }
/*      */   
/*  496 */   public static Map<Integer, GetLandCO> GetLands = new HashMap<>();
/*      */   public static List<GetLandCO> findGetLands(Predicate<GetLandCO> pre) {
/*  498 */     List<GetLandCO> results = new ArrayList<>();
/*  499 */     for (GetLandCO t : GetLands.values()) {
/*  500 */       if (pre.test(t)) {
/*  501 */         results.add(t);
/*      */       }
/*      */     } 
/*  504 */     return results;
/*      */   }
/*      */   
/*  507 */   public static Map<Integer, PlantingCO> Plantings = new HashMap<>();
/*      */   public static List<PlantingCO> findPlantings(Predicate<PlantingCO> pre) {
/*  509 */     List<PlantingCO> results = new ArrayList<>();
/*  510 */     for (PlantingCO t : Plantings.values()) {
/*  511 */       if (pre.test(t)) {
/*  512 */         results.add(t);
/*      */       }
/*      */     } 
/*  515 */     return results;
/*      */   }
/*      */   
/*  518 */   public static Map<Integer, PlantLevelCO> PlantLevels = new HashMap<>();
/*      */   public static List<PlantLevelCO> findPlantLevels(Predicate<PlantLevelCO> pre) {
/*  520 */     List<PlantLevelCO> results = new ArrayList<>();
/*  521 */     for (PlantLevelCO t : PlantLevels.values()) {
/*  522 */       if (pre.test(t)) {
/*  523 */         results.add(t);
/*      */       }
/*      */     } 
/*  526 */     return results;
/*      */   }
/*      */   
/*  529 */   public static Map<Integer, PlantRecordCO> PlantRecords = new HashMap<>();
/*      */   public static List<PlantRecordCO> findPlantRecords(Predicate<PlantRecordCO> pre) {
/*  531 */     List<PlantRecordCO> results = new ArrayList<>();
/*  532 */     for (PlantRecordCO t : PlantRecords.values()) {
/*  533 */       if (pre.test(t)) {
/*  534 */         results.add(t);
/*      */       }
/*      */     } 
/*  537 */     return results;
/*      */   }
/*      */   
/*  540 */   public static Map<Integer, PlantShopCO> PlantShops = new HashMap<>();
/*      */   public static List<PlantShopCO> findPlantShops(Predicate<PlantShopCO> pre) {
/*  542 */     List<PlantShopCO> results = new ArrayList<>();
/*  543 */     for (PlantShopCO t : PlantShops.values()) {
/*  544 */       if (pre.test(t)) {
/*  545 */         results.add(t);
/*      */       }
/*      */     } 
/*  548 */     return results;
/*      */   }
/*      */   
/*  551 */   public static Map<Integer, RecoveryExt> Recoverys = new HashMap<>();
/*      */   public static List<RecoveryExt> findRecoverys(Predicate<RecoveryExt> pre) {
/*  553 */     List<RecoveryExt> results = new ArrayList<>();
/*  554 */     for (RecoveryExt t : Recoverys.values()) {
/*  555 */       if (pre.test(t)) {
/*  556 */         results.add(t);
/*      */       }
/*      */     } 
/*  559 */     return results;
/*      */   }
/*      */   
/*  562 */   public static Map<Integer, KingCO> Kings = new HashMap<>();
/*      */   public static List<KingCO> findKings(Predicate<KingCO> pre) {
/*  564 */     List<KingCO> results = new ArrayList<>();
/*  565 */     for (KingCO t : Kings.values()) {
/*  566 */       if (pre.test(t)) {
/*  567 */         results.add(t);
/*      */       }
/*      */     } 
/*  570 */     return results;
/*      */   }
/*      */   
/*  573 */   public static Map<String, RevelryCO> Revelrys = new HashMap<>();
/*      */   public static List<RevelryCO> findRevelrys(Predicate<RevelryCO> pre) {
/*  575 */     List<RevelryCO> results = new ArrayList<>();
/*  576 */     for (RevelryCO t : Revelrys.values()) {
/*  577 */       if (pre.test(t)) {
/*  578 */         results.add(t);
/*      */       }
/*      */     } 
/*  581 */     return results;
/*      */   }
/*      */   
/*  584 */   public static Map<Integer, RevelryConfigCO> RevelryConfigs = new HashMap<>();
/*      */   public static List<RevelryConfigCO> findRevelryConfigs(Predicate<RevelryConfigCO> pre) {
/*  586 */     List<RevelryConfigCO> results = new ArrayList<>();
/*  587 */     for (RevelryConfigCO t : RevelryConfigs.values()) {
/*  588 */       if (pre.test(t)) {
/*  589 */         results.add(t);
/*      */       }
/*      */     } 
/*  592 */     return results;
/*      */   }
/*      */   
/*  595 */   public static Map<Integer, StartSerRechargeCO> StartSerRecharges = new HashMap<>();
/*      */   public static List<StartSerRechargeCO> findStartSerRecharges(Predicate<StartSerRechargeCO> pre) {
/*  597 */     List<StartSerRechargeCO> results = new ArrayList<>();
/*  598 */     for (StartSerRechargeCO t : StartSerRecharges.values()) {
/*  599 */       if (pre.test(t)) {
/*  600 */         results.add(t);
/*      */       }
/*      */     } 
/*  603 */     return results;
/*      */   }
/*      */   
/*  606 */   public static Map<Integer, OutPutTypeCO> OutPutTypes = new HashMap<>();
/*      */   public static List<OutPutTypeCO> findOutPutTypes(Predicate<OutPutTypeCO> pre) {
/*  608 */     List<OutPutTypeCO> results = new ArrayList<>();
/*  609 */     for (OutPutTypeCO t : OutPutTypes.values()) {
/*  610 */       if (pre.test(t)) {
/*  611 */         results.add(t);
/*      */       }
/*      */     } 
/*  614 */     return results;
/*      */   }
/*      */   
/*  617 */   public static Map<Integer, RecomPlayCO> RecomPlays = new HashMap<>();
/*      */   public static List<RecomPlayCO> findRecomPlays(Predicate<RecomPlayCO> pre) {
/*  619 */     List<RecomPlayCO> results = new ArrayList<>();
/*  620 */     for (RecomPlayCO t : RecomPlays.values()) {
/*  621 */       if (pre.test(t)) {
/*  622 */         results.add(t);
/*      */       }
/*      */     } 
/*  625 */     return results;
/*      */   }
/*      */   
/*  628 */   public static Map<Integer, ScheduleExt> Schedules = new HashMap<>();
/*      */   public static List<ScheduleExt> findSchedules(Predicate<ScheduleExt> pre) {
/*  630 */     List<ScheduleExt> results = new ArrayList<>();
/*  631 */     for (ScheduleExt t : Schedules.values()) {
/*  632 */       if (pre.test(t)) {
/*  633 */         results.add(t);
/*      */       }
/*      */     } 
/*  636 */     return results;
/*      */   }
/*      */   
/*  639 */   public static Map<Integer, TaskCycleTypeCO> TaskCycleTypes = new HashMap<>();
/*      */   public static List<TaskCycleTypeCO> findTaskCycleTypes(Predicate<TaskCycleTypeCO> pre) {
/*  641 */     List<TaskCycleTypeCO> results = new ArrayList<>();
/*  642 */     for (TaskCycleTypeCO t : TaskCycleTypes.values()) {
/*  643 */       if (pre.test(t)) {
/*  644 */         results.add(t);
/*      */       }
/*      */     } 
/*  647 */     return results;
/*      */   }
/*      */   
/*  650 */   public static Map<Integer, VitBonusExt> VitBonuss = new HashMap<>();
/*      */   public static List<VitBonusExt> findVitBonuss(Predicate<VitBonusExt> pre) {
/*  652 */     List<VitBonusExt> results = new ArrayList<>();
/*  653 */     for (VitBonusExt t : VitBonuss.values()) {
/*  654 */       if (pre.test(t)) {
/*  655 */         results.add(t);
/*      */       }
/*      */     } 
/*  658 */     return results;
/*      */   }
/*      */   
/*  661 */   public static Map<Integer, SevDayTaskCO> SevDayTasks = new HashMap<>();
/*      */   public static List<SevDayTaskCO> findSevDayTasks(Predicate<SevDayTaskCO> pre) {
/*  663 */     List<SevDayTaskCO> results = new ArrayList<>();
/*  664 */     for (SevDayTaskCO t : SevDayTasks.values()) {
/*  665 */       if (pre.test(t)) {
/*  666 */         results.add(t);
/*      */       }
/*      */     } 
/*  669 */     return results;
/*      */   }
/*      */   
/*  672 */   public static Map<Integer, SevTaskInsCO> SevTaskInss = new HashMap<>();
/*      */   public static List<SevTaskInsCO> findSevTaskInss(Predicate<SevTaskInsCO> pre) {
/*  674 */     List<SevTaskInsCO> results = new ArrayList<>();
/*  675 */     for (SevTaskInsCO t : SevTaskInss.values()) {
/*  676 */       if (pre.test(t)) {
/*  677 */         results.add(t);
/*      */       }
/*      */     } 
/*  680 */     return results;
/*      */   }
/*      */   
/*  683 */   public static Map<Integer, SevTaskRewardExt> SevTaskRewards = new HashMap<>();
/*      */   public static List<SevTaskRewardExt> findSevTaskRewards(Predicate<SevTaskRewardExt> pre) {
/*  685 */     List<SevTaskRewardExt> results = new ArrayList<>();
/*  686 */     for (SevTaskRewardExt t : SevTaskRewards.values()) {
/*  687 */       if (pre.test(t)) {
/*  688 */         results.add(t);
/*      */       }
/*      */     } 
/*  691 */     return results;
/*      */   }
/*      */   
/*  694 */   public static Map<Integer, SevenLoginCO> SevenLogins = new HashMap<>();
/*      */   public static List<SevenLoginCO> findSevenLogins(Predicate<SevenLoginCO> pre) {
/*  696 */     List<SevenLoginCO> results = new ArrayList<>();
/*  697 */     for (SevenLoginCO t : SevenLogins.values()) {
/*  698 */       if (pre.test(t)) {
/*  699 */         results.add(t);
/*      */       }
/*      */     } 
/*  702 */     return results;
/*      */   }
/*      */   
/*  705 */   public static Map<Object, SingleCzCO> SingleCzs = new HashMap<>();
/*      */   public static List<SingleCzCO> findSingleCzs(Predicate<SingleCzCO> pre) {
/*  707 */     List<SingleCzCO> results = new ArrayList<>();
/*  708 */     for (SingleCzCO t : SingleCzs.values()) {
/*  709 */       if (pre.test(t)) {
/*  710 */         results.add(t);
/*      */       }
/*      */     } 
/*  713 */     return results;
/*      */   }
/*      */   
/*  716 */   public static Map<Integer, SuperPackageCO> SuperPackages = new HashMap<>();
/*      */   public static List<SuperPackageCO> findSuperPackages(Predicate<SuperPackageCO> pre) {
/*  718 */     List<SuperPackageCO> results = new ArrayList<>();
/*  719 */     for (SuperPackageCO t : SuperPackages.values()) {
/*  720 */       if (pre.test(t)) {
/*  721 */         results.add(t);
/*      */       }
/*      */     } 
/*  724 */     return results;
/*      */   }
/*      */   
/*  727 */   public static Map<Integer, GroupProbCO> GroupProbs = new HashMap<>();
/*      */   public static List<GroupProbCO> findGroupProbs(Predicate<GroupProbCO> pre) {
/*  729 */     List<GroupProbCO> results = new ArrayList<>();
/*  730 */     for (GroupProbCO t : GroupProbs.values()) {
/*  731 */       if (pre.test(t)) {
/*  732 */         results.add(t);
/*      */       }
/*      */     } 
/*  735 */     return results;
/*      */   }
/*      */   
/*  738 */   public static Map<Integer, PseudoRandomCO> PseudoRandoms = new HashMap<>();
/*      */   public static List<PseudoRandomCO> findPseudoRandoms(Predicate<PseudoRandomCO> pre) {
/*  740 */     List<PseudoRandomCO> results = new ArrayList<>();
/*  741 */     for (PseudoRandomCO t : PseudoRandoms.values()) {
/*  742 */       if (pre.test(t)) {
/*  743 */         results.add(t);
/*      */       }
/*      */     } 
/*  746 */     return results;
/*      */   }
/*      */   
/*  749 */   public static Map<Integer, TreasuresItemCO> TreasuresItems = new HashMap<>();
/*      */   public static List<TreasuresItemCO> findTreasuresItems(Predicate<TreasuresItemCO> pre) {
/*  751 */     List<TreasuresItemCO> results = new ArrayList<>();
/*  752 */     for (TreasuresItemCO t : TreasuresItems.values()) {
/*  753 */       if (pre.test(t)) {
/*  754 */         results.add(t);
/*      */       }
/*      */     } 
/*  757 */     return results;
/*      */   }
/*      */   
/*  760 */   public static Map<Integer, TreasuresShowCO> TreasuresShows = new HashMap<>();
/*      */   public static List<TreasuresShowCO> findTreasuresShows(Predicate<TreasuresShowCO> pre) {
/*  762 */     List<TreasuresShowCO> results = new ArrayList<>();
/*  763 */     for (TreasuresShowCO t : TreasuresShows.values()) {
/*  764 */       if (pre.test(t)) {
/*  765 */         results.add(t);
/*      */       }
/*      */     } 
/*  768 */     return results;
/*      */   }
/*      */   
/*  771 */   public static Map<Integer, WelfareCO> Welfares = new HashMap<>();
/*      */   public static List<WelfareCO> findWelfares(Predicate<WelfareCO> pre) {
/*  773 */     List<WelfareCO> results = new ArrayList<>();
/*  774 */     for (WelfareCO t : Welfares.values()) {
/*  775 */       if (pre.test(t)) {
/*  776 */         results.add(t);
/*      */       }
/*      */     } 
/*  779 */     return results;
/*      */   }
/*      */   
/*  782 */   public static Map<Integer, TurnRewardExt> TurnRewards = new HashMap<>();
/*      */   public static List<TurnRewardExt> findTurnRewards(Predicate<TurnRewardExt> pre) {
/*  784 */     List<TurnRewardExt> results = new ArrayList<>();
/*  785 */     for (TurnRewardExt t : TurnRewards.values()) {
/*  786 */       if (pre.test(t)) {
/*  787 */         results.add(t);
/*      */       }
/*      */     } 
/*  790 */     return results;
/*      */   }
/*      */   
/*  793 */   public static Map<Integer, ZillionaireCageCO> ZillionaireCages = new HashMap<>();
/*      */   public static List<ZillionaireCageCO> findZillionaireCages(Predicate<ZillionaireCageCO> pre) {
/*  795 */     List<ZillionaireCageCO> results = new ArrayList<>();
/*  796 */     for (ZillionaireCageCO t : ZillionaireCages.values()) {
/*  797 */       if (pre.test(t)) {
/*  798 */         results.add(t);
/*      */       }
/*      */     } 
/*  801 */     return results;
/*      */   }
/*      */   
/*  804 */   public static Map<Integer, ZillionaireFreeCO> ZillionaireFrees = new HashMap<>();
/*      */   public static List<ZillionaireFreeCO> findZillionaireFrees(Predicate<ZillionaireFreeCO> pre) {
/*  806 */     List<ZillionaireFreeCO> results = new ArrayList<>();
/*  807 */     for (ZillionaireFreeCO t : ZillionaireFrees.values()) {
/*  808 */       if (pre.test(t)) {
/*  809 */         results.add(t);
/*      */       }
/*      */     } 
/*  812 */     return results;
/*      */   }
/*      */   
/*  815 */   public static Map<Integer, BattleRoyaleRankExt> BattleRoyaleRanks = new HashMap<>();
/*      */   public static List<BattleRoyaleRankExt> findBattleRoyaleRanks(Predicate<BattleRoyaleRankExt> pre) {
/*  817 */     List<BattleRoyaleRankExt> results = new ArrayList<>();
/*  818 */     for (BattleRoyaleRankExt t : BattleRoyaleRanks.values()) {
/*  819 */       if (pre.test(t)) {
/*  820 */         results.add(t);
/*      */       }
/*      */     } 
/*  823 */     return results;
/*      */   }
/*      */   
/*  826 */   public static Map<Integer, BattleRoyaleRankSeasonRewardExt> BattleRoyaleRankSeasonRewards = new HashMap<>();
/*      */   public static List<BattleRoyaleRankSeasonRewardExt> findBattleRoyaleRankSeasonRewards(Predicate<BattleRoyaleRankSeasonRewardExt> pre) {
/*  828 */     List<BattleRoyaleRankSeasonRewardExt> results = new ArrayList<>();
/*  829 */     for (BattleRoyaleRankSeasonRewardExt t : BattleRoyaleRankSeasonRewards.values()) {
/*  830 */       if (pre.test(t)) {
/*  831 */         results.add(t);
/*      */       }
/*      */     } 
/*  834 */     return results;
/*      */   }
/*      */   
/*  837 */   public static Map<Integer, BeStrConfigCO> BeStrConfigs = new HashMap<>();
/*      */   public static List<BeStrConfigCO> findBeStrConfigs(Predicate<BeStrConfigCO> pre) {
/*  839 */     List<BeStrConfigCO> results = new ArrayList<>();
/*  840 */     for (BeStrConfigCO t : BeStrConfigs.values()) {
/*  841 */       if (pre.test(t)) {
/*  842 */         results.add(t);
/*      */       }
/*      */     } 
/*  845 */     return results;
/*      */   }
/*      */   
/*  848 */   public static Map<Integer, BeStrListCO> BeStrLists = new HashMap<>();
/*      */   public static List<BeStrListCO> findBeStrLists(Predicate<BeStrListCO> pre) {
/*  850 */     List<BeStrListCO> results = new ArrayList<>();
/*  851 */     for (BeStrListCO t : BeStrLists.values()) {
/*  852 */       if (pre.test(t)) {
/*  853 */         results.add(t);
/*      */       }
/*      */     } 
/*  856 */     return results;
/*      */   }
/*      */   
/*  859 */   public static Map<Integer, BloodListCO> BloodLists = new HashMap<>();
/*      */   public static List<BloodListCO> findBloodLists(Predicate<BloodListCO> pre) {
/*  861 */     List<BloodListCO> results = new ArrayList<>();
/*  862 */     for (BloodListCO t : BloodLists.values()) {
/*  863 */       if (pre.test(t)) {
/*  864 */         results.add(t);
/*      */       }
/*      */     } 
/*  867 */     return results;
/*      */   }
/*      */   
/*  870 */   public static Map<Integer, BloodLVUpCO> BloodLVUps = new HashMap<>();
/*      */   public static List<BloodLVUpCO> findBloodLVUps(Predicate<BloodLVUpCO> pre) {
/*  872 */     List<BloodLVUpCO> results = new ArrayList<>();
/*  873 */     for (BloodLVUpCO t : BloodLVUps.values()) {
/*  874 */       if (pre.test(t)) {
/*  875 */         results.add(t);
/*      */       }
/*      */     } 
/*  878 */     return results;
/*      */   }
/*      */   
/*  881 */   public static Map<Integer, BloodLVLimitCO> BloodLVLimits = new HashMap<>();
/*      */   public static List<BloodLVLimitCO> findBloodLVLimits(Predicate<BloodLVLimitCO> pre) {
/*  883 */     List<BloodLVLimitCO> results = new ArrayList<>();
/*  884 */     for (BloodLVLimitCO t : BloodLVLimits.values()) {
/*  885 */       if (pre.test(t)) {
/*  886 */         results.add(t);
/*      */       }
/*      */     } 
/*  889 */     return results;
/*      */   }
/*      */   
/*  892 */   public static Map<Integer, BloodProCO> BloodPros = new HashMap<>();
/*      */   public static List<BloodProCO> findBloodPros(Predicate<BloodProCO> pre) {
/*  894 */     List<BloodProCO> results = new ArrayList<>();
/*  895 */     for (BloodProCO t : BloodPros.values()) {
/*  896 */       if (pre.test(t)) {
/*  897 */         results.add(t);
/*      */       }
/*      */     } 
/*  900 */     return results;
/*      */   }
/*      */   
/*  903 */   public static Map<Integer, BloodProNumCO> BloodProNums = new HashMap<>();
/*      */   public static List<BloodProNumCO> findBloodProNums(Predicate<BloodProNumCO> pre) {
/*  905 */     List<BloodProNumCO> results = new ArrayList<>();
/*  906 */     for (BloodProNumCO t : BloodProNums.values()) {
/*  907 */       if (pre.test(t)) {
/*  908 */         results.add(t);
/*      */       }
/*      */     } 
/*  911 */     return results;
/*      */   }
/*      */   
/*  914 */   public static Map<Integer, BloodSuitConfigCO> BloodSuitConfigs = new HashMap<>();
/*      */   public static List<BloodSuitConfigCO> findBloodSuitConfigs(Predicate<BloodSuitConfigCO> pre) {
/*  916 */     List<BloodSuitConfigCO> results = new ArrayList<>();
/*  917 */     for (BloodSuitConfigCO t : BloodSuitConfigs.values()) {
/*  918 */       if (pre.test(t)) {
/*  919 */         results.add(t);
/*      */       }
/*      */     } 
/*  922 */     return results;
/*      */   }
/*      */   
/*  925 */   public static Map<Integer, BloodSuitListExt> BloodSuitLists = new HashMap<>();
/*      */   public static List<BloodSuitListExt> findBloodSuitLists(Predicate<BloodSuitListExt> pre) {
/*  927 */     List<BloodSuitListExt> results = new ArrayList<>();
/*  928 */     for (BloodSuitListExt t : BloodSuitLists.values()) {
/*  929 */       if (pre.test(t)) {
/*  930 */         results.add(t);
/*      */       }
/*      */     } 
/*  933 */     return results;
/*      */   }
/*      */   
/*  936 */   public static Map<Integer, BloodTipsCO> BloodTipss = new HashMap<>();
/*      */   public static List<BloodTipsCO> findBloodTipss(Predicate<BloodTipsCO> pre) {
/*  938 */     List<BloodTipsCO> results = new ArrayList<>();
/*  939 */     for (BloodTipsCO t : BloodTipss.values()) {
/*  940 */       if (pre.test(t)) {
/*  941 */         results.add(t);
/*      */       }
/*      */     } 
/*  944 */     return results;
/*      */   }
/*      */   
/*  947 */   public static Map<String, BlackWordExt> BlackWords = new HashMap<>();
/*      */   public static List<BlackWordExt> findBlackWords(Predicate<BlackWordExt> pre) {
/*  949 */     List<BlackWordExt> results = new ArrayList<>();
/*  950 */     for (BlackWordExt t : BlackWords.values()) {
/*  951 */       if (pre.test(t)) {
/*  952 */         results.add(t);
/*      */       }
/*      */     } 
/*  955 */     return results;
/*      */   }
/*      */   
/*  958 */   public static Map<Integer, ActionCO> Actions = new HashMap<>();
/*      */   public static List<ActionCO> findActions(Predicate<ActionCO> pre) {
/*  960 */     List<ActionCO> results = new ArrayList<>();
/*  961 */     for (ActionCO t : Actions.values()) {
/*  962 */       if (pre.test(t)) {
/*  963 */         results.add(t);
/*      */       }
/*      */     } 
/*  966 */     return results;
/*      */   }
/*      */   
/*  969 */   public static Map<Integer, ChatSettingCO> ChatSettings = new HashMap<>();
/*      */   public static List<ChatSettingCO> findChatSettings(Predicate<ChatSettingCO> pre) {
/*  971 */     List<ChatSettingCO> results = new ArrayList<>();
/*  972 */     for (ChatSettingCO t : ChatSettings.values()) {
/*  973 */       if (pre.test(t)) {
/*  974 */         results.add(t);
/*      */       }
/*      */     } 
/*  977 */     return results;
/*      */   }
/*      */   
/*  980 */   public static Map<Integer, DefMsgCO> DefMsgs = new HashMap<>();
/*      */   public static List<DefMsgCO> findDefMsgs(Predicate<DefMsgCO> pre) {
/*  982 */     List<DefMsgCO> results = new ArrayList<>();
/*  983 */     for (DefMsgCO t : DefMsgs.values()) {
/*  984 */       if (pre.test(t)) {
/*  985 */         results.add(t);
/*      */       }
/*      */     } 
/*  988 */     return results;
/*      */   }
/*      */   
/*  991 */   public static Map<Integer, EmoteCO> Emotes = new HashMap<>();
/*      */   public static List<EmoteCO> findEmotes(Predicate<EmoteCO> pre) {
/*  993 */     List<EmoteCO> results = new ArrayList<>();
/*  994 */     for (EmoteCO t : Emotes.values()) {
/*  995 */       if (pre.test(t)) {
/*  996 */         results.add(t);
/*      */       }
/*      */     } 
/*  999 */     return results;
/*      */   }
/*      */   
/* 1002 */   public static Map<Integer, InteractionCO> Interactions = new HashMap<>();
/*      */   public static List<InteractionCO> findInteractions(Predicate<InteractionCO> pre) {
/* 1004 */     List<InteractionCO> results = new ArrayList<>();
/* 1005 */     for (InteractionCO t : Interactions.values()) {
/* 1006 */       if (pre.test(t)) {
/* 1007 */         results.add(t);
/*      */       }
/*      */     } 
/* 1010 */     return results;
/*      */   }
/*      */   
/* 1013 */   public static Map<Integer, ShowMsgCO> ShowMsgs = new HashMap<>();
/*      */   public static List<ShowMsgCO> findShowMsgs(Predicate<ShowMsgCO> pre) {
/* 1015 */     List<ShowMsgCO> results = new ArrayList<>();
/* 1016 */     for (ShowMsgCO t : ShowMsgs.values()) {
/* 1017 */       if (pre.test(t)) {
/* 1018 */         results.add(t);
/*      */       }
/*      */     } 
/* 1021 */     return results;
/*      */   }
/*      */   
/* 1024 */   public static Map<Integer, DungeonMapCostCO> DungeonMapCosts = new HashMap<>();
/*      */   public static List<DungeonMapCostCO> findDungeonMapCosts(Predicate<DungeonMapCostCO> pre) {
/* 1026 */     List<DungeonMapCostCO> results = new ArrayList<>();
/* 1027 */     for (DungeonMapCostCO t : DungeonMapCosts.values()) {
/* 1028 */       if (pre.test(t)) {
/* 1029 */         results.add(t);
/*      */       }
/*      */     } 
/* 1032 */     return results;
/*      */   }
/*      */   
/* 1035 */   public static Map<Integer, RechargeCostCO> RechargeCosts = new HashMap<>();
/*      */   public static List<RechargeCostCO> findRechargeCosts(Predicate<RechargeCostCO> pre) {
/* 1037 */     List<RechargeCostCO> results = new ArrayList<>();
/* 1038 */     for (RechargeCostCO t : RechargeCosts.values()) {
/* 1039 */       if (pre.test(t)) {
/* 1040 */         results.add(t);
/*      */       }
/*      */     } 
/* 1043 */     return results;
/*      */   }
/*      */   
/* 1046 */   public static Map<Integer, ResRewardCO> ResRewards = new HashMap<>();
/*      */   public static List<ResRewardCO> findResRewards(Predicate<ResRewardCO> pre) {
/* 1048 */     List<ResRewardCO> results = new ArrayList<>();
/* 1049 */     for (ResRewardCO t : ResRewards.values()) {
/* 1050 */       if (pre.test(t)) {
/* 1051 */         results.add(t);
/*      */       }
/*      */     } 
/* 1054 */     return results;
/*      */   }
/*      */   
/* 1057 */   public static Map<Integer, SaleReviewTimeCO> SaleReviewTimes = new HashMap<>();
/*      */   public static List<SaleReviewTimeCO> findSaleReviewTimes(Predicate<SaleReviewTimeCO> pre) {
/* 1059 */     List<SaleReviewTimeCO> results = new ArrayList<>();
/* 1060 */     for (SaleReviewTimeCO t : SaleReviewTimes.values()) {
/* 1061 */       if (pre.test(t)) {
/* 1062 */         results.add(t);
/*      */       }
/*      */     } 
/* 1065 */     return results;
/*      */   }
/*      */   
/* 1068 */   public static Map<Integer, SoloTimesCostCO> SoloTimesCosts = new HashMap<>();
/*      */   public static List<SoloTimesCostCO> findSoloTimesCosts(Predicate<SoloTimesCostCO> pre) {
/* 1070 */     List<SoloTimesCostCO> results = new ArrayList<>();
/* 1071 */     for (SoloTimesCostCO t : SoloTimesCosts.values()) {
/* 1072 */       if (pre.test(t)) {
/* 1073 */         results.add(t);
/*      */       }
/*      */     } 
/* 1076 */     return results;
/*      */   }
/*      */   
/* 1079 */   public static Map<Integer, EffectsConfigCO> EffectsConfigs = new HashMap<>();
/*      */   public static List<EffectsConfigCO> findEffectsConfigs(Predicate<EffectsConfigCO> pre) {
/* 1081 */     List<EffectsConfigCO> results = new ArrayList<>();
/* 1082 */     for (EffectsConfigCO t : EffectsConfigs.values()) {
/* 1083 */       if (pre.test(t)) {
/* 1084 */         results.add(t);
/*      */       }
/*      */     } 
/* 1087 */     return results;
/*      */   }
/*      */   
/* 1090 */   public static Map<String, DebugParametersCO> DebugParameterss = new HashMap<>();
/*      */   public static List<DebugParametersCO> findDebugParameterss(Predicate<DebugParametersCO> pre) {
/* 1092 */     List<DebugParametersCO> results = new ArrayList<>();
/* 1093 */     for (DebugParametersCO t : DebugParameterss.values()) {
/* 1094 */       if (pre.test(t)) {
/* 1095 */         results.add(t);
/*      */       }
/*      */     } 
/* 1098 */     return results;
/*      */   }
/*      */   
/* 1101 */   public static Map<Integer, MoneyCO> Moneys = new HashMap<>();
/*      */   public static List<MoneyCO> findMoneys(Predicate<MoneyCO> pre) {
/* 1103 */     List<MoneyCO> results = new ArrayList<>();
/* 1104 */     for (MoneyCO t : Moneys.values()) {
/* 1105 */       if (pre.test(t)) {
/* 1106 */         results.add(t);
/*      */       }
/*      */     } 
/* 1109 */     return results;
/*      */   }
/*      */   
/* 1112 */   public static Map<String, ParametersCO> Parameterss = new HashMap<>();
/*      */   public static List<ParametersCO> findParameterss(Predicate<ParametersCO> pre) {
/* 1114 */     List<ParametersCO> results = new ArrayList<>();
/* 1115 */     for (ParametersCO t : Parameterss.values()) {
/* 1116 */       if (pre.test(t)) {
/* 1117 */         results.add(t);
/*      */       }
/*      */     } 
/* 1120 */     return results;
/*      */   }
/*      */   
/* 1123 */   public static Map<String, ServerConfigCO> ServerConfigs = new HashMap<>();
/*      */   public static List<ServerConfigCO> findServerConfigs(Predicate<ServerConfigCO> pre) {
/* 1125 */     List<ServerConfigCO> results = new ArrayList<>();
/* 1126 */     for (ServerConfigCO t : ServerConfigs.values()) {
/* 1127 */       if (pre.test(t)) {
/* 1128 */         results.add(t);
/*      */       }
/*      */     } 
/* 1131 */     return results;
/*      */   }
/*      */   
/* 1134 */   public static Map<Integer, SystemConfigCO> SystemConfigs = new HashMap<>();
/*      */   public static List<SystemConfigCO> findSystemConfigs(Predicate<SystemConfigCO> pre) {
/* 1136 */     List<SystemConfigCO> results = new ArrayList<>();
/* 1137 */     for (SystemConfigCO t : SystemConfigs.values()) {
/* 1138 */       if (pre.test(t)) {
/* 1139 */         results.add(t);
/*      */       }
/*      */     } 
/* 1142 */     return results;
/*      */   }
/*      */   
/* 1145 */   public static Map<Integer, CurrencyUICO> CurrencyUIs = new HashMap<>();
/*      */   public static List<CurrencyUICO> findCurrencyUIs(Predicate<CurrencyUICO> pre) {
/* 1147 */     List<CurrencyUICO> results = new ArrayList<>();
/* 1148 */     for (CurrencyUICO t : CurrencyUIs.values()) {
/* 1149 */       if (pre.test(t)) {
/* 1150 */         results.add(t);
/*      */       }
/*      */     } 
/* 1153 */     return results;
/*      */   }
/*      */   
/* 1156 */   public static Map<Integer, ResEventCO> ResEvents = new HashMap<>();
/*      */   public static List<ResEventCO> findResEvents(Predicate<ResEventCO> pre) {
/* 1158 */     List<ResEventCO> results = new ArrayList<>();
/* 1159 */     for (ResEventCO t : ResEvents.values()) {
/* 1160 */       if (pre.test(t)) {
/* 1161 */         results.add(t);
/*      */       }
/*      */     } 
/* 1164 */     return results;
/*      */   }
/*      */   
/* 1167 */   public static Map<String, EventCO> Events = new HashMap<>();
/*      */   public static List<EventCO> findEvents(Predicate<EventCO> pre) {
/* 1169 */     List<EventCO> results = new ArrayList<>();
/* 1170 */     for (EventCO t : Events.values()) {
/* 1171 */       if (pre.test(t)) {
/* 1172 */         results.add(t);
/*      */       }
/*      */     } 
/* 1175 */     return results;
/*      */   }
/*      */   
/* 1178 */   public static Map<Integer, FateCO> Fates = new HashMap<>();
/*      */   public static List<FateCO> findFates(Predicate<FateCO> pre) {
/* 1180 */     List<FateCO> results = new ArrayList<>();
/* 1181 */     for (FateCO t : Fates.values()) {
/* 1182 */       if (pre.test(t)) {
/* 1183 */         results.add(t);
/*      */       }
/*      */     } 
/* 1186 */     return results;
/*      */   }
/*      */   
/* 1189 */   public static Map<String, FunctionsCO> Functionss = new HashMap<>();
/*      */   public static List<FunctionsCO> findFunctionss(Predicate<FunctionsCO> pre) {
/* 1191 */     List<FunctionsCO> results = new ArrayList<>();
/* 1192 */     for (FunctionsCO t : Functionss.values()) {
/* 1193 */       if (pre.test(t)) {
/* 1194 */         results.add(t);
/*      */       }
/*      */     } 
/* 1197 */     return results;
/*      */   }
/*      */   
/* 1200 */   public static Map<Integer, FunGoToCO> FunGoTos = new HashMap<>();
/*      */   public static List<FunGoToCO> findFunGoTos(Predicate<FunGoToCO> pre) {
/* 1202 */     List<FunGoToCO> results = new ArrayList<>();
/* 1203 */     for (FunGoToCO t : FunGoTos.values()) {
/* 1204 */       if (pre.test(t)) {
/* 1205 */         results.add(t);
/*      */       }
/*      */     } 
/* 1208 */     return results;
/*      */   }
/*      */   
/* 1211 */   public static Map<Integer, GuideCO> Guides = new HashMap<>();
/*      */   public static List<GuideCO> findGuides(Predicate<GuideCO> pre) {
/* 1213 */     List<GuideCO> results = new ArrayList<>();
/* 1214 */     for (GuideCO t : Guides.values()) {
/* 1215 */       if (pre.test(t)) {
/* 1216 */         results.add(t);
/*      */       }
/*      */     } 
/* 1219 */     return results;
/*      */   }
/*      */   
/* 1222 */   public static Map<Integer, OpenLvCO> OpenLvs = new HashMap<>();
/*      */   public static List<OpenLvCO> findOpenLvs(Predicate<OpenLvCO> pre) {
/* 1224 */     List<OpenLvCO> results = new ArrayList<>();
/* 1225 */     for (OpenLvCO t : OpenLvs.values()) {
/* 1226 */       if (pre.test(t)) {
/* 1227 */         results.add(t);
/*      */       }
/*      */     } 
/* 1230 */     return results;
/*      */   }
/*      */   
/* 1233 */   public static Map<Integer, GiftCO> Gifts = new HashMap<>();
/*      */   public static List<GiftCO> findGifts(Predicate<GiftCO> pre) {
/* 1235 */     List<GiftCO> results = new ArrayList<>();
/* 1236 */     for (GiftCO t : Gifts.values()) {
/* 1237 */       if (pre.test(t)) {
/* 1238 */         results.add(t);
/*      */       }
/*      */     } 
/* 1241 */     return results;
/*      */   }
/*      */   
/* 1244 */   public static Map<Integer, BlessBuffExt> BlessBuffs = new HashMap<>();
/*      */   public static List<BlessBuffExt> findBlessBuffs(Predicate<BlessBuffExt> pre) {
/* 1246 */     List<BlessBuffExt> results = new ArrayList<>();
/* 1247 */     for (BlessBuffExt t : BlessBuffs.values()) {
/* 1248 */       if (pre.test(t)) {
/* 1249 */         results.add(t);
/*      */       }
/*      */     } 
/* 1252 */     return results;
/*      */   }
/*      */   
/* 1255 */   public static Map<Integer, BlessItemCO> BlessItems = new HashMap<>();
/*      */   public static List<BlessItemCO> findBlessItems(Predicate<BlessItemCO> pre) {
/* 1257 */     List<BlessItemCO> results = new ArrayList<>();
/* 1258 */     for (BlessItemCO t : BlessItems.values()) {
/* 1259 */       if (pre.test(t)) {
/* 1260 */         results.add(t);
/*      */       }
/*      */     } 
/* 1263 */     return results;
/*      */   }
/*      */   
/* 1266 */   public static Map<Integer, BlessLevelExt> BlessLevels = new HashMap<>();
/*      */   public static List<BlessLevelExt> findBlessLevels(Predicate<BlessLevelExt> pre) {
/* 1268 */     List<BlessLevelExt> results = new ArrayList<>();
/* 1269 */     for (BlessLevelExt t : BlessLevels.values()) {
/* 1270 */       if (pre.test(t)) {
/* 1271 */         results.add(t);
/*      */       }
/*      */     } 
/* 1274 */     return results;
/*      */   }
/*      */   
/* 1277 */   public static Map<Integer, BlesslibaoExt> Blesslibaos = new HashMap<>();
/*      */   public static List<BlesslibaoExt> findBlesslibaos(Predicate<BlesslibaoExt> pre) {
/* 1279 */     List<BlesslibaoExt> results = new ArrayList<>();
/* 1280 */     for (BlesslibaoExt t : Blesslibaos.values()) {
/* 1281 */       if (pre.test(t)) {
/* 1282 */         results.add(t);
/*      */       }
/*      */     } 
/* 1285 */     return results;
/*      */   }
/*      */   
/* 1288 */   public static Map<Integer, AuctionRecordCO> AuctionRecords = new HashMap<>();
/*      */   public static List<AuctionRecordCO> findAuctionRecords(Predicate<AuctionRecordCO> pre) {
/* 1290 */     List<AuctionRecordCO> results = new ArrayList<>();
/* 1291 */     for (AuctionRecordCO t : AuctionRecords.values()) {
/* 1292 */       if (pre.test(t)) {
/* 1293 */         results.add(t);
/*      */       }
/*      */     } 
/* 1296 */     return results;
/*      */   }
/*      */   
/* 1299 */   public static Map<Integer, InspireLevelExt> InspireLevels = new HashMap<>();
/*      */   public static List<InspireLevelExt> findInspireLevels(Predicate<InspireLevelExt> pre) {
/* 1301 */     List<InspireLevelExt> results = new ArrayList<>();
/* 1302 */     for (InspireLevelExt t : InspireLevels.values()) {
/* 1303 */       if (pre.test(t)) {
/* 1304 */         results.add(t);
/*      */       }
/*      */     } 
/* 1307 */     return results;
/*      */   }
/*      */   
/* 1310 */   public static Map<Integer, RankRewardExt> RankRewards = new HashMap<>();
/*      */   public static List<RankRewardExt> findRankRewards(Predicate<RankRewardExt> pre) {
/* 1312 */     List<RankRewardExt> results = new ArrayList<>();
/* 1313 */     for (RankRewardExt t : RankRewards.values()) {
/* 1314 */       if (pre.test(t)) {
/* 1315 */         results.add(t);
/*      */       }
/*      */     } 
/* 1318 */     return results;
/*      */   }
/*      */   
/* 1321 */   public static Map<Integer, RewardListCO> RewardLists = new HashMap<>();
/*      */   public static List<RewardListCO> findRewardLists(Predicate<RewardListCO> pre) {
/* 1323 */     List<RewardListCO> results = new ArrayList<>();
/* 1324 */     for (RewardListCO t : RewardLists.values()) {
/* 1325 */       if (pre.test(t)) {
/* 1326 */         results.add(t);
/*      */       }
/*      */     } 
/* 1329 */     return results;
/*      */   }
/*      */   
/* 1332 */   public static Map<String, GDungeonCO> GDungeons = new HashMap<>();
/*      */   public static List<GDungeonCO> findGDungeons(Predicate<GDungeonCO> pre) {
/* 1334 */     List<GDungeonCO> results = new ArrayList<>();
/* 1335 */     for (GDungeonCO t : GDungeons.values()) {
/* 1336 */       if (pre.test(t)) {
/* 1337 */         results.add(t);
/*      */       }
/*      */     } 
/* 1340 */     return results;
/*      */   }
/*      */   
/* 1343 */   public static Map<Integer, GDungeonMapCO> GDungeonMaps = new HashMap<>();
/*      */   public static List<GDungeonMapCO> findGDungeonMaps(Predicate<GDungeonMapCO> pre) {
/* 1345 */     List<GDungeonMapCO> results = new ArrayList<>();
/* 1346 */     for (GDungeonMapCO t : GDungeonMaps.values()) {
/* 1347 */       if (pre.test(t)) {
/* 1348 */         results.add(t);
/*      */       }
/*      */     } 
/* 1351 */     return results;
/*      */   }
/*      */   
/* 1354 */   public static Map<Integer, GDungeonRankCO> GDungeonRanks = new HashMap<>();
/*      */   public static List<GDungeonRankCO> findGDungeonRanks(Predicate<GDungeonRankCO> pre) {
/* 1356 */     List<GDungeonRankCO> results = new ArrayList<>();
/* 1357 */     for (GDungeonRankCO t : GDungeonRanks.values()) {
/* 1358 */       if (pre.test(t)) {
/* 1359 */         results.add(t);
/*      */       }
/*      */     } 
/* 1362 */     return results;
/*      */   }
/*      */   
/* 1365 */   public static Map<Integer, GuildFortExt> GuildForts = new HashMap<>();
/*      */   public static List<GuildFortExt> findGuildForts(Predicate<GuildFortExt> pre) {
/* 1367 */     List<GuildFortExt> results = new ArrayList<>();
/* 1368 */     for (GuildFortExt t : GuildForts.values()) {
/* 1369 */       if (pre.test(t)) {
/* 1370 */         results.add(t);
/*      */       }
/*      */     } 
/* 1373 */     return results;
/*      */   }
/*      */   
/* 1376 */   public static Map<Integer, GShopExt> GShops = new HashMap<>();
/*      */   public static List<GShopExt> findGShops(Predicate<GShopExt> pre) {
/* 1378 */     List<GShopExt> results = new ArrayList<>();
/* 1379 */     for (GShopExt t : GShops.values()) {
/* 1380 */       if (pre.test(t)) {
/* 1381 */         results.add(t);
/*      */       }
/*      */     } 
/* 1384 */     return results;
/*      */   }
/*      */   
/* 1387 */   public static Map<Integer, GBuffExt> GBuffs = new HashMap<>();
/*      */   public static List<GBuffExt> findGBuffs(Predicate<GBuffExt> pre) {
/* 1389 */     List<GBuffExt> results = new ArrayList<>();
/* 1390 */     for (GBuffExt t : GBuffs.values()) {
/* 1391 */       if (pre.test(t)) {
/* 1392 */         results.add(t);
/*      */       }
/*      */     } 
/* 1395 */     return results;
/*      */   }
/*      */   
/* 1398 */   public static Map<Integer, GTechnologyExt> GTechnologys = new HashMap<>();
/*      */   public static List<GTechnologyExt> findGTechnologys(Predicate<GTechnologyExt> pre) {
/* 1400 */     List<GTechnologyExt> results = new ArrayList<>();
/* 1401 */     for (GTechnologyExt t : GTechnologys.values()) {
/* 1402 */       if (pre.test(t)) {
/* 1403 */         results.add(t);
/*      */       }
/*      */     } 
/* 1406 */     return results;
/*      */   }
/*      */   
/* 1409 */   public static Map<Integer, GTechnologyItemCO> GTechnologyItems = new HashMap<>();
/*      */   public static List<GTechnologyItemCO> findGTechnologyItems(Predicate<GTechnologyItemCO> pre) {
/* 1411 */     List<GTechnologyItemCO> results = new ArrayList<>();
/* 1412 */     for (GTechnologyItemCO t : GTechnologyItems.values()) {
/* 1413 */       if (pre.test(t)) {
/* 1414 */         results.add(t);
/*      */       }
/*      */     } 
/* 1417 */     return results;
/*      */   }
/*      */   
/* 1420 */   public static Map<Integer, GTechnologyLevelCO> GTechnologyLevels = new HashMap<>();
/*      */   public static List<GTechnologyLevelCO> findGTechnologyLevels(Predicate<GTechnologyLevelCO> pre) {
/* 1422 */     List<GTechnologyLevelCO> results = new ArrayList<>();
/* 1423 */     for (GTechnologyLevelCO t : GTechnologyLevels.values()) {
/* 1424 */       if (pre.test(t)) {
/* 1425 */         results.add(t);
/*      */       }
/*      */     } 
/* 1428 */     return results;
/*      */   }
/*      */   
/* 1431 */   public static Map<Integer, GuildBuildingCO> GuildBuildings = new HashMap<>();
/*      */   public static List<GuildBuildingCO> findGuildBuildings(Predicate<GuildBuildingCO> pre) {
/* 1433 */     List<GuildBuildingCO> results = new ArrayList<>();
/* 1434 */     for (GuildBuildingCO t : GuildBuildings.values()) {
/* 1435 */       if (pre.test(t)) {
/* 1436 */         results.add(t);
/*      */       }
/*      */     } 
/* 1439 */     return results;
/*      */   }
/*      */   
/* 1442 */   public static Map<Integer, GuildConditionCO> GuildConditions = new HashMap<>();
/*      */   public static List<GuildConditionCO> findGuildConditions(Predicate<GuildConditionCO> pre) {
/* 1444 */     List<GuildConditionCO> results = new ArrayList<>();
/* 1445 */     for (GuildConditionCO t : GuildConditions.values()) {
/* 1446 */       if (pre.test(t)) {
/* 1447 */         results.add(t);
/*      */       }
/*      */     } 
/* 1450 */     return results;
/*      */   }
/*      */   
/* 1453 */   public static Map<String, GuildContributeCO> GuildContributes = new HashMap<>();
/*      */   public static List<GuildContributeCO> findGuildContributes(Predicate<GuildContributeCO> pre) {
/* 1455 */     List<GuildContributeCO> results = new ArrayList<>();
/* 1456 */     for (GuildContributeCO t : GuildContributes.values()) {
/* 1457 */       if (pre.test(t)) {
/* 1458 */         results.add(t);
/*      */       }
/*      */     } 
/* 1461 */     return results;
/*      */   }
/*      */   
/* 1464 */   public static Map<Integer, GuildLevelCO> GuildLevels = new HashMap<>();
/*      */   public static List<GuildLevelCO> findGuildLevels(Predicate<GuildLevelCO> pre) {
/* 1466 */     List<GuildLevelCO> results = new ArrayList<>();
/* 1467 */     for (GuildLevelCO t : GuildLevels.values()) {
/* 1468 */       if (pre.test(t)) {
/* 1469 */         results.add(t);
/*      */       }
/*      */     } 
/* 1472 */     return results;
/*      */   }
/*      */   
/* 1475 */   public static Map<Integer, GuildPositionCO> GuildPositions = new HashMap<>();
/*      */   public static List<GuildPositionCO> findGuildPositions(Predicate<GuildPositionCO> pre) {
/* 1477 */     List<GuildPositionCO> results = new ArrayList<>();
/* 1478 */     for (GuildPositionCO t : GuildPositions.values()) {
/* 1479 */       if (pre.test(t)) {
/* 1480 */         results.add(t);
/*      */       }
/*      */     } 
/* 1483 */     return results;
/*      */   }
/*      */   
/* 1486 */   public static Map<Integer, GuildRecordCO> GuildRecords = new HashMap<>();
/*      */   public static List<GuildRecordCO> findGuildRecords(Predicate<GuildRecordCO> pre) {
/* 1488 */     List<GuildRecordCO> results = new ArrayList<>();
/* 1489 */     for (GuildRecordCO t : GuildRecords.values()) {
/* 1490 */       if (pre.test(t)) {
/* 1491 */         results.add(t);
/*      */       }
/*      */     } 
/* 1494 */     return results;
/*      */   }
/*      */   
/* 1497 */   public static Map<Integer, GuildSettingExt> GuildSettings = new HashMap<>();
/*      */   public static List<GuildSettingExt> findGuildSettings(Predicate<GuildSettingExt> pre) {
/* 1499 */     List<GuildSettingExt> results = new ArrayList<>();
/* 1500 */     for (GuildSettingExt t : GuildSettings.values()) {
/* 1501 */       if (pre.test(t)) {
/* 1502 */         results.add(t);
/*      */       }
/*      */     } 
/* 1505 */     return results;
/*      */   }
/*      */   
/* 1508 */   public static Map<Integer, WareHouseConditionCO> WareHouseConditions = new HashMap<>();
/*      */   public static List<WareHouseConditionCO> findWareHouseConditions(Predicate<WareHouseConditionCO> pre) {
/* 1510 */     List<WareHouseConditionCO> results = new ArrayList<>();
/* 1511 */     for (WareHouseConditionCO t : WareHouseConditions.values()) {
/* 1512 */       if (pre.test(t)) {
/* 1513 */         results.add(t);
/*      */       }
/*      */     } 
/* 1516 */     return results;
/*      */   }
/*      */   
/* 1519 */   public static Map<Integer, WareHouseCondition2CO> WareHouseCondition2s = new HashMap<>();
/*      */   public static List<WareHouseCondition2CO> findWareHouseCondition2s(Predicate<WareHouseCondition2CO> pre) {
/* 1521 */     List<WareHouseCondition2CO> results = new ArrayList<>();
/* 1522 */     for (WareHouseCondition2CO t : WareHouseCondition2s.values()) {
/* 1523 */       if (pre.test(t)) {
/* 1524 */         results.add(t);
/*      */       }
/*      */     } 
/* 1527 */     return results;
/*      */   }
/*      */   
/* 1530 */   public static Map<Integer, WareHouseLevelCO> WareHouseLevels = new HashMap<>();
/*      */   public static List<WareHouseLevelCO> findWareHouseLevels(Predicate<WareHouseLevelCO> pre) {
/* 1532 */     List<WareHouseLevelCO> results = new ArrayList<>();
/* 1533 */     for (WareHouseLevelCO t : WareHouseLevels.values()) {
/* 1534 */       if (pre.test(t)) {
/* 1535 */         results.add(t);
/*      */       }
/*      */     } 
/* 1538 */     return results;
/*      */   }
/*      */   
/* 1541 */   public static Map<Integer, WareHouseValueCO> WareHouseValues = new HashMap<>();
/*      */   public static List<WareHouseValueCO> findWareHouseValues(Predicate<WareHouseValueCO> pre) {
/* 1543 */     List<WareHouseValueCO> results = new ArrayList<>();
/* 1544 */     for (WareHouseValueCO t : WareHouseValues.values()) {
/* 1545 */       if (pre.test(t)) {
/* 1546 */         results.add(t);
/*      */       }
/*      */     } 
/* 1549 */     return results;
/*      */   }
/*      */   
/* 1552 */   public static Map<Integer, ExpReduceCO> ExpReduces = new HashMap<>();
/*      */   public static List<ExpReduceCO> findExpReduces(Predicate<ExpReduceCO> pre) {
/* 1554 */     List<ExpReduceCO> results = new ArrayList<>();
/* 1555 */     for (ExpReduceCO t : ExpReduces.values()) {
/* 1556 */       if (pre.test(t)) {
/* 1557 */         results.add(t);
/*      */       }
/*      */     } 
/* 1560 */     return results;
/*      */   }
/*      */   
/* 1563 */   public static Map<Integer, GoldReduceCO> GoldReduces = new HashMap<>();
/*      */   public static List<GoldReduceCO> findGoldReduces(Predicate<GoldReduceCO> pre) {
/* 1565 */     List<GoldReduceCO> results = new ArrayList<>();
/* 1566 */     for (GoldReduceCO t : GoldReduces.values()) {
/* 1567 */       if (pre.test(t)) {
/* 1568 */         results.add(t);
/*      */       }
/*      */     } 
/* 1571 */     return results;
/*      */   }
/*      */   
/* 1574 */   public static Map<Integer, ResLimitCO> ResLimits = new HashMap<>();
/*      */   public static List<ResLimitCO> findResLimits(Predicate<ResLimitCO> pre) {
/* 1576 */     List<ResLimitCO> results = new ArrayList<>();
/* 1577 */     for (ResLimitCO t : ResLimits.values()) {
/* 1578 */       if (pre.test(t)) {
/* 1579 */         results.add(t);
/*      */       }
/*      */     } 
/* 1582 */     return results;
/*      */   }
/*      */   
/* 1585 */   public static Map<Integer, SectionCO> Sections = new HashMap<>();
/*      */   public static List<SectionCO> findSections(Predicate<SectionCO> pre) {
/* 1587 */     List<SectionCO> results = new ArrayList<>();
/* 1588 */     for (SectionCO t : Sections.values()) {
/* 1589 */       if (pre.test(t)) {
/* 1590 */         results.add(t);
/*      */       }
/*      */     } 
/* 1593 */     return results;
/*      */   }
/*      */   
/* 1596 */   public static Map<Integer, CombineExt> Combines = new HashMap<>();
/*      */   public static List<CombineExt> findCombines(Predicate<CombineExt> pre) {
/* 1598 */     List<CombineExt> results = new ArrayList<>();
/* 1599 */     for (CombineExt t : Combines.values()) {
/* 1600 */       if (pre.test(t)) {
/* 1601 */         results.add(t);
/*      */       }
/*      */     } 
/* 1604 */     return results;
/*      */   }
/*      */   
/* 1607 */   public static Map<Integer, CombineTypeCO> CombineTypes = new HashMap<>();
/*      */   public static List<CombineTypeCO> findCombineTypes(Predicate<CombineTypeCO> pre) {
/* 1609 */     List<CombineTypeCO> results = new ArrayList<>();
/* 1610 */     for (CombineTypeCO t : CombineTypes.values()) {
/* 1611 */       if (pre.test(t)) {
/* 1612 */         results.add(t);
/*      */       }
/*      */     } 
/* 1615 */     return results;
/*      */   }
/*      */   
/* 1618 */   public static Map<Integer, EnchantExt> Enchants = new HashMap<>();
/*      */   public static List<EnchantExt> findEnchants(Predicate<EnchantExt> pre) {
/* 1620 */     List<EnchantExt> results = new ArrayList<>();
/* 1621 */     for (EnchantExt t : Enchants.values()) {
/* 1622 */       if (pre.test(t)) {
/* 1623 */         results.add(t);
/*      */       }
/*      */     } 
/* 1626 */     return results;
/*      */   }
/*      */   
/* 1629 */   public static Map<Integer, EnchantBonusExt> EnchantBonuss = new HashMap<>();
/*      */   public static List<EnchantBonusExt> findEnchantBonuss(Predicate<EnchantBonusExt> pre) {
/* 1631 */     List<EnchantBonusExt> results = new ArrayList<>();
/* 1632 */     for (EnchantBonusExt t : EnchantBonuss.values()) {
/* 1633 */       if (pre.test(t)) {
/* 1634 */         results.add(t);
/*      */       }
/*      */     } 
/* 1637 */     return results;
/*      */   }
/*      */   
/* 1640 */   public static Map<Integer, EquipMakeExt> EquipMakes = new HashMap<>();
/*      */   public static List<EquipMakeExt> findEquipMakes(Predicate<EquipMakeExt> pre) {
/* 1642 */     List<EquipMakeExt> results = new ArrayList<>();
/* 1643 */     for (EquipMakeExt t : EquipMakes.values()) {
/* 1644 */       if (pre.test(t)) {
/* 1645 */         results.add(t);
/*      */       }
/*      */     } 
/* 1648 */     return results;
/*      */   }
/*      */   
/* 1651 */   public static Map<Integer, EquipMakeIndexCO> EquipMakeIndexs = new HashMap<>();
/*      */   public static List<EquipMakeIndexCO> findEquipMakeIndexs(Predicate<EquipMakeIndexCO> pre) {
/* 1653 */     List<EquipMakeIndexCO> results = new ArrayList<>();
/* 1654 */     for (EquipMakeIndexCO t : EquipMakeIndexs.values()) {
/* 1655 */       if (pre.test(t)) {
/* 1656 */         results.add(t);
/*      */       }
/*      */     } 
/* 1659 */     return results;
/*      */   }
/*      */   
/* 1662 */   public static Map<Integer, EquipSockExt> EquipSocks = new HashMap<>();
/*      */   public static List<EquipSockExt> findEquipSocks(Predicate<EquipSockExt> pre) {
/* 1664 */     List<EquipSockExt> results = new ArrayList<>();
/* 1665 */     for (EquipSockExt t : EquipSocks.values()) {
/* 1666 */       if (pre.test(t)) {
/* 1667 */         results.add(t);
/*      */       }
/*      */     } 
/* 1670 */     return results;
/*      */   }
/*      */   
/* 1673 */   public static Map<Integer, KaiGuangExt> KaiGuangs = new HashMap<>();
/*      */   public static List<KaiGuangExt> findKaiGuangs(Predicate<KaiGuangExt> pre) {
/* 1675 */     List<KaiGuangExt> results = new ArrayList<>();
/* 1676 */     for (KaiGuangExt t : KaiGuangs.values()) {
/* 1677 */       if (pre.test(t)) {
/* 1678 */         results.add(t);
/*      */       }
/*      */     } 
/* 1681 */     return results;
/*      */   }
/*      */   
/* 1684 */   public static Map<Integer, MeltConfigCO> MeltConfigs = new HashMap<>();
/*      */   public static List<MeltConfigCO> findMeltConfigs(Predicate<MeltConfigCO> pre) {
/* 1686 */     List<MeltConfigCO> results = new ArrayList<>();
/* 1687 */     for (MeltConfigCO t : MeltConfigs.values()) {
/* 1688 */       if (pre.test(t)) {
/* 1689 */         results.add(t);
/*      */       }
/*      */     } 
/* 1692 */     return results;
/*      */   }
/*      */   
/* 1695 */   public static Map<Integer, ReBornExt> ReBorns = new HashMap<>();
/*      */   public static List<ReBornExt> findReBorns(Predicate<ReBornExt> pre) {
/* 1697 */     List<ReBornExt> results = new ArrayList<>();
/* 1698 */     for (ReBornExt t : ReBorns.values()) {
/* 1699 */       if (pre.test(t)) {
/* 1700 */         results.add(t);
/*      */       }
/*      */     } 
/* 1703 */     return results;
/*      */   }
/*      */   
/* 1706 */   public static Map<Integer, ReBuildExt> ReBuilds = new HashMap<>();
/*      */   public static List<ReBuildExt> findReBuilds(Predicate<ReBuildExt> pre) {
/* 1708 */     List<ReBuildExt> results = new ArrayList<>();
/* 1709 */     for (ReBuildExt t : ReBuilds.values()) {
/* 1710 */       if (pre.test(t)) {
/* 1711 */         results.add(t);
/*      */       }
/*      */     } 
/* 1714 */     return results;
/*      */   }
/*      */   
/* 1717 */   public static Map<Integer, ReBuildCfCO> ReBuildCfs = new HashMap<>();
/*      */   public static List<ReBuildCfCO> findReBuildCfs(Predicate<ReBuildCfCO> pre) {
/* 1719 */     List<ReBuildCfCO> results = new ArrayList<>();
/* 1720 */     for (ReBuildCfCO t : ReBuildCfs.values()) {
/* 1721 */       if (pre.test(t)) {
/* 1722 */         results.add(t);
/*      */       }
/*      */     } 
/* 1725 */     return results;
/*      */   }
/*      */   
/* 1728 */   public static Map<Integer, ReBuildStarCO> ReBuildStars = new HashMap<>();
/*      */   public static List<ReBuildStarCO> findReBuildStars(Predicate<ReBuildStarCO> pre) {
/* 1730 */     List<ReBuildStarCO> results = new ArrayList<>();
/* 1731 */     for (ReBuildStarCO t : ReBuildStars.values()) {
/* 1732 */       if (pre.test(t)) {
/* 1733 */         results.add(t);
/*      */       }
/*      */     } 
/* 1736 */     return results;
/*      */   }
/*      */   
/* 1739 */   public static Map<Integer, RefineExt> Refines = new HashMap<>();
/*      */   public static List<RefineExt> findRefines(Predicate<RefineExt> pre) {
/* 1741 */     List<RefineExt> results = new ArrayList<>();
/* 1742 */     for (RefineExt t : Refines.values()) {
/* 1743 */       if (pre.test(t)) {
/* 1744 */         results.add(t);
/*      */       }
/*      */     } 
/* 1747 */     return results;
/*      */   }
/*      */   
/* 1750 */   public static Map<Integer, SeniorReBuildExt> SeniorReBuilds = new HashMap<>();
/*      */   public static List<SeniorReBuildExt> findSeniorReBuilds(Predicate<SeniorReBuildExt> pre) {
/* 1752 */     List<SeniorReBuildExt> results = new ArrayList<>();
/* 1753 */     for (SeniorReBuildExt t : SeniorReBuilds.values()) {
/* 1754 */       if (pre.test(t)) {
/* 1755 */         results.add(t);
/*      */       }
/*      */     } 
/* 1758 */     return results;
/*      */   }
/*      */   
/* 1761 */   public static Map<Integer, SmritiExt> Smritis = new HashMap<>();
/*      */   public static List<SmritiExt> findSmritis(Predicate<SmritiExt> pre) {
/* 1763 */     List<SmritiExt> results = new ArrayList<>();
/* 1764 */     for (SmritiExt t : Smritis.values()) {
/* 1765 */       if (pre.test(t)) {
/* 1766 */         results.add(t);
/*      */       }
/*      */     } 
/* 1769 */     return results;
/*      */   }
/*      */   
/* 1772 */   public static Map<Integer, SuitConfigExt> SuitConfigs = new HashMap<>();
/*      */   public static List<SuitConfigExt> findSuitConfigs(Predicate<SuitConfigExt> pre) {
/* 1774 */     List<SuitConfigExt> results = new ArrayList<>();
/* 1775 */     for (SuitConfigExt t : SuitConfigs.values()) {
/* 1776 */       if (pre.test(t)) {
/* 1777 */         results.add(t);
/*      */       }
/*      */     } 
/* 1780 */     return results;
/*      */   }
/*      */   
/* 1783 */   public static Map<Integer, SuitListExt> SuitLists = new HashMap<>();
/*      */   public static List<SuitListExt> findSuitLists(Predicate<SuitListExt> pre) {
/* 1785 */     List<SuitListExt> results = new ArrayList<>();
/* 1786 */     for (SuitListExt t : SuitLists.values()) {
/* 1787 */       if (pre.test(t)) {
/* 1788 */         results.add(t);
/*      */       }
/*      */     } 
/* 1791 */     return results;
/*      */   }
/*      */   
/* 1794 */   public static Map<Integer, EquipdituConfigCO> EquipdituConfigs = new HashMap<>();
/*      */   public static List<EquipdituConfigCO> findEquipdituConfigs(Predicate<EquipdituConfigCO> pre) {
/* 1796 */     List<EquipdituConfigCO> results = new ArrayList<>();
/* 1797 */     for (EquipdituConfigCO t : EquipdituConfigs.values()) {
/* 1798 */       if (pre.test(t)) {
/* 1799 */         results.add(t);
/*      */       }
/*      */     } 
/* 1802 */     return results;
/*      */   }
/*      */   
/* 1805 */   public static Map<String, BlueEquipExt> BlueEquips = new HashMap<>();
/*      */   public static List<BlueEquipExt> findBlueEquips(Predicate<BlueEquipExt> pre) {
/* 1807 */     List<BlueEquipExt> results = new ArrayList<>();
/* 1808 */     for (BlueEquipExt t : BlueEquips.values()) {
/* 1809 */       if (pre.test(t)) {
/* 1810 */         results.add(t);
/*      */       }
/*      */     } 
/* 1813 */     return results;
/*      */   }
/*      */   
/* 1816 */   public static Map<String, LegendEquipExt> LegendEquips = new HashMap<>();
/*      */   public static List<LegendEquipExt> findLegendEquips(Predicate<LegendEquipExt> pre) {
/* 1818 */     List<LegendEquipExt> results = new ArrayList<>();
/* 1819 */     for (LegendEquipExt t : LegendEquips.values()) {
/* 1820 */       if (pre.test(t)) {
/* 1821 */         results.add(t);
/*      */       }
/*      */     } 
/* 1824 */     return results;
/*      */   }
/*      */   
/* 1827 */   public static Map<String, NormalEquipExt> NormalEquips = new HashMap<>();
/*      */   public static List<NormalEquipExt> findNormalEquips(Predicate<NormalEquipExt> pre) {
/* 1829 */     List<NormalEquipExt> results = new ArrayList<>();
/* 1830 */     for (NormalEquipExt t : NormalEquips.values()) {
/* 1831 */       if (pre.test(t)) {
/* 1832 */         results.add(t);
/*      */       }
/*      */     } 
/* 1835 */     return results;
/*      */   }
/*      */   
/* 1838 */   public static Map<String, PurpleEquipExt> PurpleEquips = new HashMap<>();
/*      */   public static List<PurpleEquipExt> findPurpleEquips(Predicate<PurpleEquipExt> pre) {
/* 1840 */     List<PurpleEquipExt> results = new ArrayList<>();
/* 1841 */     for (PurpleEquipExt t : PurpleEquips.values()) {
/* 1842 */       if (pre.test(t)) {
/* 1843 */         results.add(t);
/*      */       }
/*      */     } 
/* 1846 */     return results;
/*      */   }
/*      */   
/* 1849 */   public static Map<String, RideEquipExt> RideEquips = new HashMap<>();
/*      */   public static List<RideEquipExt> findRideEquips(Predicate<RideEquipExt> pre) {
/* 1851 */     List<RideEquipExt> results = new ArrayList<>();
/* 1852 */     for (RideEquipExt t : RideEquips.values()) {
/* 1853 */       if (pre.test(t)) {
/* 1854 */         results.add(t);
/*      */       }
/*      */     } 
/* 1857 */     return results;
/*      */   }
/*      */   
/* 1860 */   public static Map<String, SuitEquipExt> SuitEquips = new HashMap<>();
/*      */   public static List<SuitEquipExt> findSuitEquips(Predicate<SuitEquipExt> pre) {
/* 1862 */     List<SuitEquipExt> results = new ArrayList<>();
/* 1863 */     for (SuitEquipExt t : SuitEquips.values()) {
/* 1864 */       if (pre.test(t)) {
/* 1865 */         results.add(t);
/*      */       }
/*      */     } 
/* 1868 */     return results;
/*      */   }
/*      */   
/* 1871 */   public static Map<String, UniqueEquipExt> UniqueEquips = new HashMap<>();
/*      */   public static List<UniqueEquipExt> findUniqueEquips(Predicate<UniqueEquipExt> pre) {
/* 1873 */     List<UniqueEquipExt> results = new ArrayList<>();
/* 1874 */     for (UniqueEquipExt t : UniqueEquips.values()) {
/* 1875 */       if (pre.test(t)) {
/* 1876 */         results.add(t);
/*      */       }
/*      */     } 
/* 1879 */     return results;
/*      */   }
/*      */   
/* 1882 */   public static Map<String, FashionExt> Fashions = new HashMap<>();
/*      */   public static List<FashionExt> findFashions(Predicate<FashionExt> pre) {
/* 1884 */     List<FashionExt> results = new ArrayList<>();
/* 1885 */     for (FashionExt t : Fashions.values()) {
/* 1886 */       if (pre.test(t)) {
/* 1887 */         results.add(t);
/*      */       }
/*      */     } 
/* 1890 */     return results;
/*      */   }
/*      */   
/* 1893 */   public static Map<Integer, FashSuitConfigExt> FashSuitConfigs = new HashMap<>();
/*      */   public static List<FashSuitConfigExt> findFashSuitConfigs(Predicate<FashSuitConfigExt> pre) {
/* 1895 */     List<FashSuitConfigExt> results = new ArrayList<>();
/* 1896 */     for (FashSuitConfigExt t : FashSuitConfigs.values()) {
/* 1897 */       if (pre.test(t)) {
/* 1898 */         results.add(t);
/*      */       }
/*      */     } 
/* 1901 */     return results;
/*      */   }
/*      */   
/* 1904 */   public static Map<String, ActiveCO> Actives = new HashMap<>();
/*      */   public static List<ActiveCO> findActives(Predicate<ActiveCO> pre) {
/* 1906 */     List<ActiveCO> results = new ArrayList<>();
/* 1907 */     for (ActiveCO t : Actives.values()) {
/* 1908 */       if (pre.test(t)) {
/* 1909 */         results.add(t);
/*      */       }
/*      */     } 
/* 1912 */     return results;
/*      */   }
/*      */   
/* 1915 */   public static Map<String, ChestCO> Chests = new HashMap<>();
/*      */   public static List<ChestCO> findChests(Predicate<ChestCO> pre) {
/* 1917 */     List<ChestCO> results = new ArrayList<>();
/* 1918 */     for (ChestCO t : Chests.values()) {
/* 1919 */       if (pre.test(t)) {
/* 1920 */         results.add(t);
/*      */       }
/*      */     } 
/* 1923 */     return results;
/*      */   }
/*      */   
/* 1926 */   public static Map<String, FashionItemCO> FashionItems = new HashMap<>();
/*      */   public static List<FashionItemCO> findFashionItems(Predicate<FashionItemCO> pre) {
/* 1928 */     List<FashionItemCO> results = new ArrayList<>();
/* 1929 */     for (FashionItemCO t : FashionItems.values()) {
/* 1930 */       if (pre.test(t)) {
/* 1931 */         results.add(t);
/*      */       }
/*      */     } 
/* 1934 */     return results;
/*      */   }
/*      */   
/* 1937 */   public static Map<String, JewelCO> Jewels = new HashMap<>();
/*      */   public static List<JewelCO> findJewels(Predicate<JewelCO> pre) {
/* 1939 */     List<JewelCO> results = new ArrayList<>();
/* 1940 */     for (JewelCO t : Jewels.values()) {
/* 1941 */       if (pre.test(t)) {
/* 1942 */         results.add(t);
/*      */       }
/*      */     } 
/* 1945 */     return results;
/*      */   }
/*      */   
/* 1948 */   public static Map<String, MateCO> Mates = new HashMap<>();
/*      */   public static List<MateCO> findMates(Predicate<MateCO> pre) {
/* 1950 */     List<MateCO> results = new ArrayList<>();
/* 1951 */     for (MateCO t : Mates.values()) {
/* 1952 */       if (pre.test(t)) {
/* 1953 */         results.add(t);
/*      */       }
/*      */     } 
/* 1956 */     return results;
/*      */   }
/*      */   
/* 1959 */   public static Map<String, MiscCO> Miscs = new HashMap<>();
/*      */   public static List<MiscCO> findMiscs(Predicate<MiscCO> pre) {
/* 1961 */     List<MiscCO> results = new ArrayList<>();
/* 1962 */     for (MiscCO t : Miscs.values()) {
/* 1963 */       if (pre.test(t)) {
/* 1964 */         results.add(t);
/*      */       }
/*      */     } 
/* 1967 */     return results;
/*      */   }
/*      */   
/* 1970 */   public static Map<String, PetItemCO> PetItems = new HashMap<>();
/*      */   public static List<PetItemCO> findPetItems(Predicate<PetItemCO> pre) {
/* 1972 */     List<PetItemCO> results = new ArrayList<>();
/* 1973 */     for (PetItemCO t : PetItems.values()) {
/* 1974 */       if (pre.test(t)) {
/* 1975 */         results.add(t);
/*      */       }
/*      */     } 
/* 1978 */     return results;
/*      */   }
/*      */   
/* 1981 */   public static Map<String, PotionCO> Potions = new HashMap<>();
/*      */   public static List<PotionCO> findPotions(Predicate<PotionCO> pre) {
/* 1983 */     List<PotionCO> results = new ArrayList<>();
/* 1984 */     for (PotionCO t : Potions.values()) {
/* 1985 */       if (pre.test(t)) {
/* 1986 */         results.add(t);
/*      */       }
/*      */     } 
/* 1989 */     return results;
/*      */   }
/*      */   
/* 1992 */   public static Map<String, QuestCO> Quests = new HashMap<>();
/*      */   public static List<QuestCO> findQuests(Predicate<QuestCO> pre) {
/* 1994 */     List<QuestCO> results = new ArrayList<>();
/* 1995 */     for (QuestCO t : Quests.values()) {
/* 1996 */       if (pre.test(t)) {
/* 1997 */         results.add(t);
/*      */       }
/*      */     } 
/* 2000 */     return results;
/*      */   }
/*      */   
/* 2003 */   public static Map<String, RankCO> Ranks = new HashMap<>();
/*      */   public static List<RankCO> findRanks(Predicate<RankCO> pre) {
/* 2005 */     List<RankCO> results = new ArrayList<>();
/* 2006 */     for (RankCO t : Ranks.values()) {
/* 2007 */       if (pre.test(t)) {
/* 2008 */         results.add(t);
/*      */       }
/*      */     } 
/* 2011 */     return results;
/*      */   }
/*      */   
/* 2014 */   public static Map<String, RideItemCO> RideItems = new HashMap<>();
/*      */   public static List<RideItemCO> findRideItems(Predicate<RideItemCO> pre) {
/* 2016 */     List<RideItemCO> results = new ArrayList<>();
/* 2017 */     for (RideItemCO t : RideItems.values()) {
/* 2018 */       if (pre.test(t)) {
/* 2019 */         results.add(t);
/*      */       }
/*      */     } 
/* 2022 */     return results;
/*      */   }
/*      */   
/* 2025 */   public static Map<String, VirtualCO> Virtuals = new HashMap<>();
/*      */   public static List<VirtualCO> findVirtuals(Predicate<VirtualCO> pre) {
/* 2027 */     List<VirtualCO> results = new ArrayList<>();
/* 2028 */     for (VirtualCO t : Virtuals.values()) {
/* 2029 */       if (pre.test(t)) {
/* 2030 */         results.add(t);
/*      */       }
/*      */     } 
/* 2033 */     return results;
/*      */   }
/*      */   
/* 2036 */   public static Map<String, ItemIdConfigExt> ItemIdConfigs = new HashMap<>();
/*      */   public static List<ItemIdConfigExt> findItemIdConfigs(Predicate<ItemIdConfigExt> pre) {
/* 2038 */     List<ItemIdConfigExt> results = new ArrayList<>();
/* 2039 */     for (ItemIdConfigExt t : ItemIdConfigs.values()) {
/* 2040 */       if (pre.test(t)) {
/* 2041 */         results.add(t);
/*      */       }
/*      */     } 
/* 2044 */     return results;
/*      */   }
/*      */   
/* 2047 */   public static Map<Integer, ItemTypeConfigExt> ItemTypeConfigs = new HashMap<>();
/*      */   public static List<ItemTypeConfigExt> findItemTypeConfigs(Predicate<ItemTypeConfigExt> pre) {
/* 2049 */     List<ItemTypeConfigExt> results = new ArrayList<>();
/* 2050 */     for (ItemTypeConfigExt t : ItemTypeConfigs.values()) {
/* 2051 */       if (pre.test(t)) {
/* 2052 */         results.add(t);
/*      */       }
/*      */     } 
/* 2055 */     return results;
/*      */   }
/*      */   
/* 2058 */   public static Map<Integer, AffixExt> Affixs = new HashMap<>();
/*      */   public static List<AffixExt> findAffixs(Predicate<AffixExt> pre) {
/* 2060 */     List<AffixExt> results = new ArrayList<>();
/* 2061 */     for (AffixExt t : Affixs.values()) {
/* 2062 */       if (pre.test(t)) {
/* 2063 */         results.add(t);
/*      */       }
/*      */     } 
/* 2066 */     return results;
/*      */   }
/*      */   
/* 2069 */   public static Map<Integer, MagicRingCO> MagicRings = new HashMap<>();
/*      */   public static List<MagicRingCO> findMagicRings(Predicate<MagicRingCO> pre) {
/* 2071 */     List<MagicRingCO> results = new ArrayList<>();
/* 2072 */     for (MagicRingCO t : MagicRings.values()) {
/* 2073 */       if (pre.test(t)) {
/* 2074 */         results.add(t);
/*      */       }
/*      */     } 
/* 2077 */     return results;
/*      */   }
/*      */   
/* 2080 */   public static Map<Integer, MasteryCO> Masterys = new HashMap<>();
/*      */   public static List<MasteryCO> findMasterys(Predicate<MasteryCO> pre) {
/* 2082 */     List<MasteryCO> results = new ArrayList<>();
/* 2083 */     for (MasteryCO t : Masterys.values()) {
/* 2084 */       if (pre.test(t)) {
/* 2085 */         results.add(t);
/*      */       }
/*      */     } 
/* 2088 */     return results;
/*      */   }
/*      */   
/* 2091 */   public static Map<Integer, MasteryPropExt> MasteryProps = new HashMap<>();
/*      */   public static List<MasteryPropExt> findMasteryProps(Predicate<MasteryPropExt> pre) {
/* 2093 */     List<MasteryPropExt> results = new ArrayList<>();
/* 2094 */     for (MasteryPropExt t : MasteryProps.values()) {
/* 2095 */       if (pre.test(t)) {
/* 2096 */         results.add(t);
/*      */       }
/*      */     } 
/* 2099 */     return results;
/*      */   }
/*      */   
/* 2102 */   public static Map<Integer, PickItemCO> PickItems = new HashMap<>();
/*      */   public static List<PickItemCO> findPickItems(Predicate<PickItemCO> pre) {
/* 2104 */     List<PickItemCO> results = new ArrayList<>();
/* 2105 */     for (PickItemCO t : PickItems.values()) {
/* 2106 */       if (pre.test(t)) {
/* 2107 */         results.add(t);
/*      */       }
/*      */     } 
/* 2110 */     return results;
/*      */   }
/*      */   
/* 2113 */   public static Map<Integer, RandomBoxExt> RandomBoxs = new HashMap<>();
/*      */   public static List<RandomBoxExt> findRandomBoxs(Predicate<RandomBoxExt> pre) {
/* 2115 */     List<RandomBoxExt> results = new ArrayList<>();
/* 2116 */     for (RandomBoxExt t : RandomBoxs.values()) {
/* 2117 */       if (pre.test(t)) {
/* 2118 */         results.add(t);
/*      */       }
/*      */     } 
/* 2121 */     return results;
/*      */   }
/*      */   
/* 2124 */   public static Map<String, PKLostBagItemTypeCO> PKLostBagItemTypes = new HashMap<>();
/*      */   public static List<PKLostBagItemTypeCO> findPKLostBagItemTypes(Predicate<PKLostBagItemTypeCO> pre) {
/* 2126 */     List<PKLostBagItemTypeCO> results = new ArrayList<>();
/* 2127 */     for (PKLostBagItemTypeCO t : PKLostBagItemTypes.values()) {
/* 2128 */       if (pre.test(t)) {
/* 2129 */         results.add(t);
/*      */       }
/*      */     } 
/* 2132 */     return results;
/*      */   }
/*      */   
/* 2135 */   public static Map<String, TreasureClassExt> TreasureClasss = new HashMap<>();
/*      */   public static List<TreasureClassExt> findTreasureClasss(Predicate<TreasureClassExt> pre) {
/* 2137 */     List<TreasureClassExt> results = new ArrayList<>();
/* 2138 */     for (TreasureClassExt t : TreasureClasss.values()) {
/* 2139 */       if (pre.test(t)) {
/* 2140 */         results.add(t);
/*      */       }
/*      */     } 
/* 2143 */     return results;
/*      */   }
/*      */   
/* 2146 */   public static Map<String, AfterFilterCO> AfterFilters = new HashMap<>();
/*      */   public static List<AfterFilterCO> findAfterFilters(Predicate<AfterFilterCO> pre) {
/* 2148 */     List<AfterFilterCO> results = new ArrayList<>();
/* 2149 */     for (AfterFilterCO t : AfterFilters.values()) {
/* 2150 */       if (pre.test(t)) {
/* 2151 */         results.add(t);
/*      */       }
/*      */     } 
/* 2154 */     return results;
/*      */   }
/*      */   
/* 2157 */   public static Map<String, BeforeFilterCO> BeforeFilters = new HashMap<>();
/*      */   public static List<BeforeFilterCO> findBeforeFilters(Predicate<BeforeFilterCO> pre) {
/* 2159 */     List<BeforeFilterCO> results = new ArrayList<>();
/* 2160 */     for (BeforeFilterCO t : BeforeFilters.values()) {
/* 2161 */       if (pre.test(t)) {
/* 2162 */         results.add(t);
/*      */       }
/*      */     } 
/* 2165 */     return results;
/*      */   }
/*      */   
/* 2168 */   public static Map<String, StoreFilterCO> StoreFilters = new HashMap<>();
/*      */   public static List<StoreFilterCO> findStoreFilters(Predicate<StoreFilterCO> pre) {
/* 2170 */     List<StoreFilterCO> results = new ArrayList<>();
/* 2171 */     for (StoreFilterCO t : StoreFilters.values()) {
/* 2172 */       if (pre.test(t)) {
/* 2173 */         results.add(t);
/*      */       }
/*      */     } 
/* 2176 */     return results;
/*      */   }
/*      */   
/* 2179 */   public static Map<Integer, StoreMenuCO> StoreMenus = new HashMap<>();
/*      */   public static List<StoreMenuCO> findStoreMenus(Predicate<StoreMenuCO> pre) {
/* 2181 */     List<StoreMenuCO> results = new ArrayList<>();
/* 2182 */     for (StoreMenuCO t : StoreMenus.values()) {
/* 2183 */       if (pre.test(t)) {
/* 2184 */         results.add(t);
/*      */       }
/*      */     } 
/* 2187 */     return results;
/*      */   }
/*      */   
/* 2190 */   public static Map<Integer, AthleticShopCO> AthleticShops = new HashMap<>();
/*      */   public static List<AthleticShopCO> findAthleticShops(Predicate<AthleticShopCO> pre) {
/* 2192 */     List<AthleticShopCO> results = new ArrayList<>();
/* 2193 */     for (AthleticShopCO t : AthleticShops.values()) {
/* 2194 */       if (pre.test(t)) {
/* 2195 */         results.add(t);
/*      */       }
/*      */     } 
/* 2198 */     return results;
/*      */   }
/*      */   
/* 2201 */   public static Map<Integer, FateShopCO> FateShops = new HashMap<>();
/*      */   public static List<FateShopCO> findFateShops(Predicate<FateShopCO> pre) {
/* 2203 */     List<FateShopCO> results = new ArrayList<>();
/* 2204 */     for (FateShopCO t : FateShops.values()) {
/* 2205 */       if (pre.test(t)) {
/* 2206 */         results.add(t);
/*      */       }
/*      */     } 
/* 2209 */     return results;
/*      */   }
/*      */   
/* 2212 */   public static Map<Integer, GuildShopCO> GuildShops = new HashMap<>();
/*      */   public static List<GuildShopCO> findGuildShops(Predicate<GuildShopCO> pre) {
/* 2214 */     List<GuildShopCO> results = new ArrayList<>();
/* 2215 */     for (GuildShopCO t : GuildShops.values()) {
/* 2216 */       if (pre.test(t)) {
/* 2217 */         results.add(t);
/*      */       }
/*      */     } 
/* 2220 */     return results;
/*      */   }
/*      */   
/* 2223 */   public static Map<Integer, MallShopCO> MallShops = new HashMap<>();
/*      */   public static List<MallShopCO> findMallShops(Predicate<MallShopCO> pre) {
/* 2225 */     List<MallShopCO> results = new ArrayList<>();
/* 2226 */     for (MallShopCO t : MallShops.values()) {
/* 2227 */       if (pre.test(t)) {
/* 2228 */         results.add(t);
/*      */       }
/*      */     } 
/* 2231 */     return results;
/*      */   }
/*      */   
/* 2234 */   public static Map<Integer, ShopLabCO> ShopLabs = new HashMap<>();
/*      */   public static List<ShopLabCO> findShopLabs(Predicate<ShopLabCO> pre) {
/* 2236 */     List<ShopLabCO> results = new ArrayList<>();
/* 2237 */     for (ShopLabCO t : ShopLabs.values()) {
/* 2238 */       if (pre.test(t)) {
/* 2239 */         results.add(t);
/*      */       }
/*      */     } 
/* 2242 */     return results;
/*      */   }
/*      */   
/* 2245 */   public static Map<Integer, SundryShopCO> SundryShops = new HashMap<>();
/*      */   public static List<SundryShopCO> findSundryShops(Predicate<SundryShopCO> pre) {
/* 2247 */     List<SundryShopCO> results = new ArrayList<>();
/* 2248 */     for (SundryShopCO t : SundryShops.values()) {
/* 2249 */       if (pre.test(t)) {
/* 2250 */         results.add(t);
/*      */       }
/*      */     } 
/* 2253 */     return results;
/*      */   }
/*      */   
/* 2256 */   public static Map<Integer, MenuUISaleCO> MenuUISales = new HashMap<>();
/*      */   public static List<MenuUISaleCO> findMenuUISales(Predicate<MenuUISaleCO> pre) {
/* 2258 */     List<MenuUISaleCO> results = new ArrayList<>();
/* 2259 */     for (MenuUISaleCO t : MenuUISales.values()) {
/* 2260 */       if (pre.test(t)) {
/* 2261 */         results.add(t);
/*      */       }
/*      */     } 
/* 2264 */     return results;
/*      */   }
/*      */   
/* 2267 */   public static Map<Integer, NpcSaleCO> NpcSales = new HashMap<>();
/*      */   public static List<NpcSaleCO> findNpcSales(Predicate<NpcSaleCO> pre) {
/* 2269 */     List<NpcSaleCO> results = new ArrayList<>();
/* 2270 */     for (NpcSaleCO t : NpcSales.values()) {
/* 2271 */       if (pre.test(t)) {
/* 2272 */         results.add(t);
/*      */       }
/*      */     } 
/* 2275 */     return results;
/*      */   }
/*      */   
/* 2278 */   public static Map<Integer, ExchangeMallExt> ExchangeMalls = new HashMap<>();
/*      */   public static List<ExchangeMallExt> findExchangeMalls(Predicate<ExchangeMallExt> pre) {
/* 2280 */     List<ExchangeMallExt> results = new ArrayList<>();
/* 2281 */     for (ExchangeMallExt t : ExchangeMalls.values()) {
/* 2282 */       if (pre.test(t)) {
/* 2283 */         results.add(t);
/*      */       }
/*      */     } 
/* 2286 */     return results;
/*      */   }
/*      */   
/* 2289 */   public static Map<Integer, ShopMallConfigCO> ShopMallConfigs = new HashMap<>();
/*      */   public static List<ShopMallConfigCO> findShopMallConfigs(Predicate<ShopMallConfigCO> pre) {
/* 2291 */     List<ShopMallConfigCO> results = new ArrayList<>();
/* 2292 */     for (ShopMallConfigCO t : ShopMallConfigs.values()) {
/* 2293 */       if (pre.test(t)) {
/* 2294 */         results.add(t);
/*      */       }
/*      */     } 
/* 2297 */     return results;
/*      */   }
/*      */   
/* 2300 */   public static Map<Integer, ShopMallIconCO> ShopMallIcons = new HashMap<>();
/*      */   public static List<ShopMallIconCO> findShopMallIcons(Predicate<ShopMallIconCO> pre) {
/* 2302 */     List<ShopMallIconCO> results = new ArrayList<>();
/* 2303 */     for (ShopMallIconCO t : ShopMallIcons.values()) {
/* 2304 */       if (pre.test(t)) {
/* 2305 */         results.add(t);
/*      */       }
/*      */     } 
/* 2308 */     return results;
/*      */   }
/*      */   
/* 2311 */   public static Map<Integer, ShopMallItemsExt> ShopMallItemss = new HashMap<>();
/*      */   public static List<ShopMallItemsExt> findShopMallItemss(Predicate<ShopMallItemsExt> pre) {
/* 2313 */     List<ShopMallItemsExt> results = new ArrayList<>();
/* 2314 */     for (ShopMallItemsExt t : ShopMallItemss.values()) {
/* 2315 */       if (pre.test(t)) {
/* 2316 */         results.add(t);
/*      */       }
/*      */     } 
/* 2319 */     return results;
/*      */   }
/*      */   
/* 2322 */   public static Map<Integer, JJCRewardExt> JJCRewards = new HashMap<>();
/*      */   public static List<JJCRewardExt> findJJCRewards(Predicate<JJCRewardExt> pre) {
/* 2324 */     List<JJCRewardExt> results = new ArrayList<>();
/* 2325 */     for (JJCRewardExt t : JJCRewards.values()) {
/* 2326 */       if (pre.test(t)) {
/* 2327 */         results.add(t);
/*      */       }
/*      */     } 
/* 2330 */     return results;
/*      */   }
/*      */   
/* 2333 */   public static Map<Integer, MailOperateCO> MailOperates = new HashMap<>();
/*      */   public static List<MailOperateCO> findMailOperates(Predicate<MailOperateCO> pre) {
/* 2335 */     List<MailOperateCO> results = new ArrayList<>();
/* 2336 */     for (MailOperateCO t : MailOperates.values()) {
/* 2337 */       if (pre.test(t)) {
/* 2338 */         results.add(t);
/*      */       }
/*      */     } 
/* 2341 */     return results;
/*      */   }
/*      */   
/* 2344 */   public static Map<String, MailSystemCO> MailSystems = new HashMap<>();
/*      */   public static List<MailSystemCO> findMailSystems(Predicate<MailSystemCO> pre) {
/* 2346 */     List<MailSystemCO> results = new ArrayList<>();
/* 2347 */     for (MailSystemCO t : MailSystems.values()) {
/* 2348 */       if (pre.test(t)) {
/* 2349 */         results.add(t);
/*      */       }
/*      */     } 
/* 2352 */     return results;
/*      */   }
/*      */   
/* 2355 */   public static Map<Integer, DungeonMonsterCO> DungeonMonsters = new HashMap<>();
/*      */   public static List<DungeonMonsterCO> findDungeonMonsters(Predicate<DungeonMonsterCO> pre) {
/* 2357 */     List<DungeonMonsterCO> results = new ArrayList<>();
/* 2358 */     for (DungeonMonsterCO t : DungeonMonsters.values()) {
/* 2359 */       if (pre.test(t)) {
/* 2360 */         results.add(t);
/*      */       }
/*      */     } 
/* 2363 */     return results;
/*      */   }
/*      */   
/* 2366 */   public static Map<Integer, DungeonMapCO> DungeonMaps = new HashMap<>();
/*      */   public static List<DungeonMapCO> findDungeonMaps(Predicate<DungeonMapCO> pre) {
/* 2368 */     List<DungeonMapCO> results = new ArrayList<>();
/* 2369 */     for (DungeonMapCO t : DungeonMaps.values()) {
/* 2370 */       if (pre.test(t)) {
/* 2371 */         results.add(t);
/*      */       }
/*      */     } 
/* 2374 */     return results;
/*      */   }
/*      */   
/* 2377 */   public static Map<Integer, GameMapCO> GameMaps = new HashMap<>();
/*      */   public static List<GameMapCO> findGameMaps(Predicate<GameMapCO> pre) {
/* 2379 */     List<GameMapCO> results = new ArrayList<>();
/* 2380 */     for (GameMapCO t : GameMaps.values()) {
/* 2381 */       if (pre.test(t)) {
/* 2382 */         results.add(t);
/*      */       }
/*      */     } 
/* 2385 */     return results;
/*      */   }
/*      */   
/* 2388 */   public static Map<Integer, NormalMapCO> NormalMaps = new HashMap<>();
/*      */   public static List<NormalMapCO> findNormalMaps(Predicate<NormalMapCO> pre) {
/* 2390 */     List<NormalMapCO> results = new ArrayList<>();
/* 2391 */     for (NormalMapCO t : NormalMaps.values()) {
/* 2392 */       if (pre.test(t)) {
/* 2393 */         results.add(t);
/*      */       }
/*      */     } 
/* 2396 */     return results;
/*      */   }
/*      */   
/* 2399 */   public static Map<Integer, ResurrectionCO> Resurrections = new HashMap<>();
/*      */   public static List<ResurrectionCO> findResurrections(Predicate<ResurrectionCO> pre) {
/* 2401 */     List<ResurrectionCO> results = new ArrayList<>();
/* 2402 */     for (ResurrectionCO t : Resurrections.values()) {
/* 2403 */       if (pre.test(t)) {
/* 2404 */         results.add(t);
/*      */       }
/*      */     } 
/* 2407 */     return results;
/*      */   }
/*      */   
/* 2410 */   public static Map<Integer, WorldZoneCO> WorldZones = new HashMap<>();
/*      */   public static List<WorldZoneCO> findWorldZones(Predicate<WorldZoneCO> pre) {
/* 2412 */     List<WorldZoneCO> results = new ArrayList<>();
/* 2413 */     for (WorldZoneCO t : WorldZones.values()) {
/* 2414 */       if (pre.test(t)) {
/* 2415 */         results.add(t);
/*      */       }
/*      */     } 
/* 2418 */     return results;
/*      */   }
/*      */   
/* 2421 */   public static Map<Integer, MedalListExt> MedalLists = new HashMap<>();
/*      */   public static List<MedalListExt> findMedalLists(Predicate<MedalListExt> pre) {
/* 2423 */     List<MedalListExt> results = new ArrayList<>();
/* 2424 */     for (MedalListExt t : MedalLists.values()) {
/* 2425 */       if (pre.test(t)) {
/* 2426 */         results.add(t);
/*      */       }
/*      */     } 
/* 2429 */     return results;
/*      */   }
/*      */   
/* 2432 */   public static Map<Integer, DemonTowerCO> DemonTowers = new HashMap<>();
/*      */   public static List<DemonTowerCO> findDemonTowers(Predicate<DemonTowerCO> pre) {
/* 2434 */     List<DemonTowerCO> results = new ArrayList<>();
/* 2435 */     for (DemonTowerCO t : DemonTowers.values()) {
/* 2436 */       if (pre.test(t)) {
/* 2437 */         results.add(t);
/*      */       }
/*      */     } 
/* 2440 */     return results;
/*      */   }
/*      */   
/* 2443 */   public static Map<Integer, Dungeon_EliteCO> Dungeon_Elites = new HashMap<>();
/*      */   public static List<Dungeon_EliteCO> findDungeon_Elites(Predicate<Dungeon_EliteCO> pre) {
/* 2445 */     List<Dungeon_EliteCO> results = new ArrayList<>();
/* 2446 */     for (Dungeon_EliteCO t : Dungeon_Elites.values()) {
/* 2447 */       if (pre.test(t)) {
/* 2448 */         results.add(t);
/*      */       }
/*      */     } 
/* 2451 */     return results;
/*      */   }
/*      */   
/* 2454 */   public static Map<Integer, Dungeon_HeroCO> Dungeon_Heros = new HashMap<>();
/*      */   public static List<Dungeon_HeroCO> findDungeon_Heros(Predicate<Dungeon_HeroCO> pre) {
/* 2456 */     List<Dungeon_HeroCO> results = new ArrayList<>();
/* 2457 */     for (Dungeon_HeroCO t : Dungeon_Heros.values()) {
/* 2458 */       if (pre.test(t)) {
/* 2459 */         results.add(t);
/*      */       }
/*      */     } 
/* 2462 */     return results;
/*      */   }
/*      */   
/* 2465 */   public static Map<Integer, Dungeon_NormalCO> Dungeon_Normals = new HashMap<>();
/*      */   public static List<Dungeon_NormalCO> findDungeon_Normals(Predicate<Dungeon_NormalCO> pre) {
/* 2467 */     List<Dungeon_NormalCO> results = new ArrayList<>();
/* 2468 */     for (Dungeon_NormalCO t : Dungeon_Normals.values()) {
/* 2469 */       if (pre.test(t)) {
/* 2470 */         results.add(t);
/*      */       }
/*      */     } 
/* 2473 */     return results;
/*      */   }
/*      */   
/* 2476 */   public static Map<Integer, DungeonCO> Dungeons = new HashMap<>();
/*      */   public static List<DungeonCO> findDungeons(Predicate<DungeonCO> pre) {
/* 2478 */     List<DungeonCO> results = new ArrayList<>();
/* 2479 */     for (DungeonCO t : Dungeons.values()) {
/* 2480 */       if (pre.test(t)) {
/* 2481 */         results.add(t);
/*      */       }
/*      */     } 
/* 2484 */     return results;
/*      */   }
/*      */   
/* 2487 */   public static Map<Integer, Normal_WorldCO> Normal_Worlds = new HashMap<>();
/*      */   public static List<Normal_WorldCO> findNormal_Worlds(Predicate<Normal_WorldCO> pre) {
/* 2489 */     List<Normal_WorldCO> results = new ArrayList<>();
/* 2490 */     for (Normal_WorldCO t : Normal_Worlds.values()) {
/* 2491 */       if (pre.test(t)) {
/* 2492 */         results.add(t);
/*      */       }
/*      */     } 
/* 2495 */     return results;
/*      */   }
/*      */   
/* 2498 */   public static Map<Integer, DungeonMonRatioCO> DungeonMonRatios = new HashMap<>();
/*      */   public static List<DungeonMonRatioCO> findDungeonMonRatios(Predicate<DungeonMonRatioCO> pre) {
/* 2500 */     List<DungeonMonRatioCO> results = new ArrayList<>();
/* 2501 */     for (DungeonMonRatioCO t : DungeonMonRatios.values()) {
/* 2502 */       if (pre.test(t)) {
/* 2503 */         results.add(t);
/*      */       }
/*      */     } 
/* 2506 */     return results;
/*      */   }
/*      */   
/* 2509 */   public static Map<Integer, GuildBossRatioCO> GuildBossRatios = new HashMap<>();
/*      */   public static List<GuildBossRatioCO> findGuildBossRatios(Predicate<GuildBossRatioCO> pre) {
/* 2511 */     List<GuildBossRatioCO> results = new ArrayList<>();
/* 2512 */     for (GuildBossRatioCO t : GuildBossRatios.values()) {
/* 2513 */       if (pre.test(t)) {
/* 2514 */         results.add(t);
/*      */       }
/*      */     } 
/* 2517 */     return results;
/*      */   }
/*      */   
/* 2520 */   public static Map<String, MonDataConfigCO> MonDataConfigs = new HashMap<>();
/*      */   public static List<MonDataConfigCO> findMonDataConfigs(Predicate<MonDataConfigCO> pre) {
/* 2522 */     List<MonDataConfigCO> results = new ArrayList<>();
/* 2523 */     for (MonDataConfigCO t : MonDataConfigs.values()) {
/* 2524 */       if (pre.test(t)) {
/* 2525 */         results.add(t);
/*      */       }
/*      */     } 
/* 2528 */     return results;
/*      */   }
/*      */   
/* 2531 */   public static Map<Integer, MultipleMonCO> MultipleMons = new HashMap<>();
/*      */   public static List<MultipleMonCO> findMultipleMons(Predicate<MultipleMonCO> pre) {
/* 2533 */     List<MultipleMonCO> results = new ArrayList<>();
/* 2534 */     for (MultipleMonCO t : MultipleMons.values()) {
/* 2535 */       if (pre.test(t)) {
/* 2536 */         results.add(t);
/*      */       }
/*      */     } 
/* 2539 */     return results;
/*      */   }
/*      */   
/* 2542 */   public static Map<Integer, OrigDataCO> OrigDatas = new HashMap<>();
/*      */   public static List<OrigDataCO> findOrigDatas(Predicate<OrigDataCO> pre) {
/* 2544 */     List<OrigDataCO> results = new ArrayList<>();
/* 2545 */     for (OrigDataCO t : OrigDatas.values()) {
/* 2546 */       if (pre.test(t)) {
/* 2547 */         results.add(t);
/*      */       }
/*      */     } 
/* 2550 */     return results;
/*      */   }
/*      */   
/* 2553 */   public static Map<Integer, SingleMonCO> SingleMons = new HashMap<>();
/*      */   public static List<SingleMonCO> findSingleMons(Predicate<SingleMonCO> pre) {
/* 2555 */     List<SingleMonCO> results = new ArrayList<>();
/* 2556 */     for (SingleMonCO t : SingleMons.values()) {
/* 2557 */       if (pre.test(t)) {
/* 2558 */         results.add(t);
/*      */       }
/*      */     } 
/* 2561 */     return results;
/*      */   }
/*      */   
/* 2564 */   public static Map<Integer, TowerMonRatioCO> TowerMonRatios = new HashMap<>();
/*      */   public static List<TowerMonRatioCO> findTowerMonRatios(Predicate<TowerMonRatioCO> pre) {
/* 2566 */     List<TowerMonRatioCO> results = new ArrayList<>();
/* 2567 */     for (TowerMonRatioCO t : TowerMonRatios.values()) {
/* 2568 */       if (pre.test(t)) {
/* 2569 */         results.add(t);
/*      */       }
/*      */     } 
/* 2572 */     return results;
/*      */   }
/*      */   
/* 2575 */   public static Map<Integer, UserDefineConfigCO> UserDefineConfigs = new HashMap<>();
/*      */   public static List<UserDefineConfigCO> findUserDefineConfigs(Predicate<UserDefineConfigCO> pre) {
/* 2577 */     List<UserDefineConfigCO> results = new ArrayList<>();
/* 2578 */     for (UserDefineConfigCO t : UserDefineConfigs.values()) {
/* 2579 */       if (pre.test(t)) {
/* 2580 */         results.add(t);
/*      */       }
/*      */     } 
/* 2583 */     return results;
/*      */   }
/*      */   
/* 2586 */   public static Map<Integer, MonsterRefreshExt> MonsterRefreshs = new HashMap<>();
/*      */   public static List<MonsterRefreshExt> findMonsterRefreshs(Predicate<MonsterRefreshExt> pre) {
/* 2588 */     List<MonsterRefreshExt> results = new ArrayList<>();
/* 2589 */     for (MonsterRefreshExt t : MonsterRefreshs.values()) {
/* 2590 */       if (pre.test(t)) {
/* 2591 */         results.add(t);
/*      */       }
/*      */     } 
/* 2594 */     return results;
/*      */   }
/*      */   
/* 2597 */   public static Map<Integer, TypeNameCO> TypeNames = new HashMap<>();
/*      */   public static List<TypeNameCO> findTypeNames(Predicate<TypeNameCO> pre) {
/* 2599 */     List<TypeNameCO> results = new ArrayList<>();
/* 2600 */     for (TypeNameCO t : TypeNames.values()) {
/* 2601 */       if (pre.test(t)) {
/* 2602 */         results.add(t);
/*      */       }
/*      */     } 
/* 2605 */     return results;
/*      */   }
/*      */   
/* 2608 */   public static Map<Integer, NpcListExt> NpcLists = new HashMap<>();
/*      */   public static List<NpcListExt> findNpcLists(Predicate<NpcListExt> pre) {
/* 2610 */     List<NpcListExt> results = new ArrayList<>();
/* 2611 */     for (NpcListExt t : NpcLists.values()) {
/* 2612 */       if (pre.test(t)) {
/* 2613 */         results.add(t);
/*      */       }
/*      */     } 
/* 2616 */     return results;
/*      */   }
/*      */   
/* 2619 */   public static Map<Integer, SkillSlotCO> SkillSlots = new HashMap<>();
/*      */   public static List<SkillSlotCO> findSkillSlots(Predicate<SkillSlotCO> pre) {
/* 2621 */     List<SkillSlotCO> results = new ArrayList<>();
/* 2622 */     for (SkillSlotCO t : SkillSlots.values()) {
/* 2623 */       if (pre.test(t)) {
/* 2624 */         results.add(t);
/*      */       }
/*      */     } 
/* 2627 */     return results;
/*      */   }
/*      */   
/* 2630 */   public static Map<Integer, CardCO> Cards = new HashMap<>();
/*      */   public static List<CardCO> findCards(Predicate<CardCO> pre) {
/* 2632 */     List<CardCO> results = new ArrayList<>();
/* 2633 */     for (CardCO t : Cards.values()) {
/* 2634 */       if (pre.test(t)) {
/* 2635 */         results.add(t);
/*      */       }
/*      */     } 
/* 2638 */     return results;
/*      */   }
/*      */   
/* 2641 */   public static Map<Integer, PayCO> Pays = new HashMap<>();
/*      */   public static List<PayCO> findPays(Predicate<PayCO> pre) {
/* 2643 */     List<PayCO> results = new ArrayList<>();
/* 2644 */     for (PayCO t : Pays.values()) {
/* 2645 */       if (pre.test(t)) {
/* 2646 */         results.add(t);
/*      */       }
/*      */     } 
/* 2649 */     return results;
/*      */   }
/*      */   
/* 2652 */   public static Map<Integer, PayRewardExt> PayRewards = new HashMap<>();
/*      */   public static List<PayRewardExt> findPayRewards(Predicate<PayRewardExt> pre) {
/* 2654 */     List<PayRewardExt> results = new ArrayList<>();
/* 2655 */     for (PayRewardExt t : PayRewards.values()) {
/* 2656 */       if (pre.test(t)) {
/* 2657 */         results.add(t);
/*      */       }
/*      */     } 
/* 2660 */     return results;
/*      */   }
/*      */   
/* 2663 */   public static Map<Integer, DailyPayExt> DailyPays = new HashMap<>();
/*      */   public static List<DailyPayExt> findDailyPays(Predicate<DailyPayExt> pre) {
/* 2665 */     List<DailyPayExt> results = new ArrayList<>();
/* 2666 */     for (DailyPayExt t : DailyPays.values()) {
/* 2667 */       if (pre.test(t)) {
/* 2668 */         results.add(t);
/*      */       }
/*      */     } 
/* 2671 */     return results;
/*      */   }
/*      */   
/* 2674 */   public static Map<Integer, FirstPayExt> FirstPays = new HashMap<>();
/*      */   public static List<FirstPayExt> findFirstPays(Predicate<FirstPayExt> pre) {
/* 2676 */     List<FirstPayExt> results = new ArrayList<>();
/* 2677 */     for (FirstPayExt t : FirstPays.values()) {
/* 2678 */       if (pre.test(t)) {
/* 2679 */         results.add(t);
/*      */       }
/*      */     } 
/* 2682 */     return results;
/*      */   }
/*      */   
/* 2685 */   public static Map<Integer, TotalPayExt> TotalPays = new HashMap<>();
/*      */   public static List<TotalPayExt> findTotalPays(Predicate<TotalPayExt> pre) {
/* 2687 */     List<TotalPayExt> results = new ArrayList<>();
/* 2688 */     for (TotalPayExt t : TotalPays.values()) {
/* 2689 */       if (pre.test(t)) {
/* 2690 */         results.add(t);
/*      */       }
/*      */     } 
/* 2693 */     return results;
/*      */   }
/*      */   
/* 2696 */   public static Map<Integer, BaseDataExt> BaseDatas = new HashMap<>();
/*      */   public static List<BaseDataExt> findBaseDatas(Predicate<BaseDataExt> pre) {
/* 2698 */     List<BaseDataExt> results = new ArrayList<>();
/* 2699 */     for (BaseDataExt t : BaseDatas.values()) {
/* 2700 */       if (pre.test(t)) {
/* 2701 */         results.add(t);
/*      */       }
/*      */     } 
/* 2704 */     return results;
/*      */   }
/*      */   
/* 2707 */   public static Map<Integer, MasterPropExt> MasterProps = new HashMap<>();
/*      */   public static List<MasterPropExt> findMasterProps(Predicate<MasterPropExt> pre) {
/* 2709 */     List<MasterPropExt> results = new ArrayList<>();
/* 2710 */     for (MasterPropExt t : MasterProps.values()) {
/* 2711 */       if (pre.test(t)) {
/* 2712 */         results.add(t);
/*      */       }
/*      */     } 
/* 2715 */     return results;
/*      */   }
/*      */   
/* 2718 */   public static Map<Integer, MasterUpgradePropExt> MasterUpgradeProps = new HashMap<>();
/*      */   public static List<MasterUpgradePropExt> findMasterUpgradeProps(Predicate<MasterUpgradePropExt> pre) {
/* 2720 */     List<MasterUpgradePropExt> results = new ArrayList<>();
/* 2721 */     for (MasterUpgradePropExt t : MasterUpgradeProps.values()) {
/* 2722 */       if (pre.test(t)) {
/* 2723 */         results.add(t);
/*      */       }
/*      */     } 
/* 2726 */     return results;
/*      */   }
/*      */   
/* 2729 */   public static Map<Integer, PetAssociateExt> PetAssociates = new HashMap<>();
/*      */   public static List<PetAssociateExt> findPetAssociates(Predicate<PetAssociateExt> pre) {
/* 2731 */     List<PetAssociateExt> results = new ArrayList<>();
/* 2732 */     for (PetAssociateExt t : PetAssociates.values()) {
/* 2733 */       if (pre.test(t)) {
/* 2734 */         results.add(t);
/*      */       }
/*      */     } 
/* 2737 */     return results;
/*      */   }
/*      */   
/* 2740 */   public static Map<String, PetConfigExt> PetConfigs = new HashMap<>();
/*      */   public static List<PetConfigExt> findPetConfigs(Predicate<PetConfigExt> pre) {
/* 2742 */     List<PetConfigExt> results = new ArrayList<>();
/* 2743 */     for (PetConfigExt t : PetConfigs.values()) {
/* 2744 */       if (pre.test(t)) {
/* 2745 */         results.add(t);
/*      */       }
/*      */     } 
/* 2748 */     return results;
/*      */   }
/*      */   
/* 2751 */   public static Map<Integer, PetExpLevelCO> PetExpLevels = new HashMap<>();
/*      */   public static List<PetExpLevelCO> findPetExpLevels(Predicate<PetExpLevelCO> pre) {
/* 2753 */     List<PetExpLevelCO> results = new ArrayList<>();
/* 2754 */     for (PetExpLevelCO t : PetExpLevels.values()) {
/* 2755 */       if (pre.test(t)) {
/* 2756 */         results.add(t);
/*      */       }
/*      */     } 
/* 2759 */     return results;
/*      */   }
/*      */   
/* 2762 */   public static Map<Integer, PetUpgradeExt> PetUpgrades = new HashMap<>();
/*      */   public static List<PetUpgradeExt> findPetUpgrades(Predicate<PetUpgradeExt> pre) {
/* 2764 */     List<PetUpgradeExt> results = new ArrayList<>();
/* 2765 */     for (PetUpgradeExt t : PetUpgrades.values()) {
/* 2766 */       if (pre.test(t)) {
/* 2767 */         results.add(t);
/*      */       }
/*      */     } 
/* 2770 */     return results;
/*      */   }
/*      */   
/* 2773 */   public static Map<Integer, BranchLineCO> BranchLines = new HashMap<>();
/*      */   public static List<BranchLineCO> findBranchLines(Predicate<BranchLineCO> pre) {
/* 2775 */     List<BranchLineCO> results = new ArrayList<>();
/* 2776 */     for (BranchLineCO t : BranchLines.values()) {
/* 2777 */       if (pre.test(t)) {
/* 2778 */         results.add(t);
/*      */       }
/*      */     } 
/* 2781 */     return results;
/*      */   }
/*      */   
/* 2784 */   public static Map<Integer, CircleCO> Circles = new HashMap<>();
/*      */   public static List<CircleCO> findCircles(Predicate<CircleCO> pre) {
/* 2786 */     List<CircleCO> results = new ArrayList<>();
/* 2787 */     for (CircleCO t : Circles.values()) {
/* 2788 */       if (pre.test(t)) {
/* 2789 */         results.add(t);
/*      */       }
/*      */     } 
/* 2792 */     return results;
/*      */   }
/*      */   
/* 2795 */   public static Map<Integer, CircleChoiceCO> CircleChoices = new HashMap<>();
/*      */   public static List<CircleChoiceCO> findCircleChoices(Predicate<CircleChoiceCO> pre) {
/* 2797 */     List<CircleChoiceCO> results = new ArrayList<>();
/* 2798 */     for (CircleChoiceCO t : CircleChoices.values()) {
/* 2799 */       if (pre.test(t)) {
/* 2800 */         results.add(t);
/*      */       }
/*      */     } 
/* 2803 */     return results;
/*      */   }
/*      */   
/* 2806 */   public static Map<Integer, CircleRewardCO> CircleRewards = new HashMap<>();
/*      */   public static List<CircleRewardCO> findCircleRewards(Predicate<CircleRewardCO> pre) {
/* 2808 */     List<CircleRewardCO> results = new ArrayList<>();
/* 2809 */     for (CircleRewardCO t : CircleRewards.values()) {
/* 2810 */       if (pre.test(t)) {
/* 2811 */         results.add(t);
/*      */       }
/*      */     } 
/* 2814 */     return results;
/*      */   }
/*      */   
/* 2817 */   public static Map<Integer, CircleSceneCO> CircleScenes = new HashMap<>();
/*      */   public static List<CircleSceneCO> findCircleScenes(Predicate<CircleSceneCO> pre) {
/* 2819 */     List<CircleSceneCO> results = new ArrayList<>();
/* 2820 */     for (CircleSceneCO t : CircleScenes.values()) {
/* 2821 */       if (pre.test(t)) {
/* 2822 */         results.add(t);
/*      */       }
/*      */     } 
/* 2825 */     return results;
/*      */   }
/*      */   
/* 2828 */   public static Map<Integer, DailyCO> Dailys = new HashMap<>();
/*      */   public static List<DailyCO> findDailys(Predicate<DailyCO> pre) {
/* 2830 */     List<DailyCO> results = new ArrayList<>();
/* 2831 */     for (DailyCO t : Dailys.values()) {
/* 2832 */       if (pre.test(t)) {
/* 2833 */         results.add(t);
/*      */       }
/*      */     } 
/* 2836 */     return results;
/*      */   }
/*      */   
/* 2839 */   public static Map<Integer, DailyReduceCO> DailyReduces = new HashMap<>();
/*      */   public static List<DailyReduceCO> findDailyReduces(Predicate<DailyReduceCO> pre) {
/* 2841 */     List<DailyReduceCO> results = new ArrayList<>();
/* 2842 */     for (DailyReduceCO t : DailyReduces.values()) {
/* 2843 */       if (pre.test(t)) {
/* 2844 */         results.add(t);
/*      */       }
/*      */     } 
/* 2847 */     return results;
/*      */   }
/*      */   
/* 2850 */   public static Map<Integer, DailyRewardCO> DailyRewards = new HashMap<>();
/*      */   public static List<DailyRewardCO> findDailyRewards(Predicate<DailyRewardCO> pre) {
/* 2852 */     List<DailyRewardCO> results = new ArrayList<>();
/* 2853 */     for (DailyRewardCO t : DailyRewards.values()) {
/* 2854 */       if (pre.test(t)) {
/* 2855 */         results.add(t);
/*      */       }
/*      */     } 
/* 2858 */     return results;
/*      */   }
/*      */   
/* 2861 */   public static Map<Integer, MainLineCO> MainLines = new HashMap<>();
/*      */   public static List<MainLineCO> findMainLines(Predicate<MainLineCO> pre) {
/* 2863 */     List<MainLineCO> results = new ArrayList<>();
/* 2864 */     for (MainLineCO t : MainLines.values()) {
/* 2865 */       if (pre.test(t)) {
/* 2866 */         results.add(t);
/*      */       }
/*      */     } 
/* 2869 */     return results;
/*      */   }
/*      */   
/* 2872 */   public static Map<Integer, TaskChestCO> TaskChests = new HashMap<>();
/*      */   public static List<TaskChestCO> findTaskChests(Predicate<TaskChestCO> pre) {
/* 2874 */     List<TaskChestCO> results = new ArrayList<>();
/* 2875 */     for (TaskChestCO t : TaskChests.values()) {
/* 2876 */       if (pre.test(t)) {
/* 2877 */         results.add(t);
/*      */       }
/*      */     } 
/* 2880 */     return results;
/*      */   }
/*      */   
/* 2883 */   public static Map<Integer, TreasureCO> Treasures = new HashMap<>();
/*      */   public static List<TreasureCO> findTreasures(Predicate<TreasureCO> pre) {
/* 2885 */     List<TreasureCO> results = new ArrayList<>();
/* 2886 */     for (TreasureCO t : Treasures.values()) {
/* 2887 */       if (pre.test(t)) {
/* 2888 */         results.add(t);
/*      */       }
/*      */     } 
/* 2891 */     return results;
/*      */   }
/*      */   
/* 2894 */   public static Map<Integer, WayTreasureExt> WayTreasures = new HashMap<>();
/*      */   public static List<WayTreasureExt> findWayTreasures(Predicate<WayTreasureExt> pre) {
/* 2896 */     List<WayTreasureExt> results = new ArrayList<>();
/* 2897 */     for (WayTreasureExt t : WayTreasures.values()) {
/* 2898 */       if (pre.test(t)) {
/* 2899 */         results.add(t);
/*      */       }
/*      */     } 
/* 2902 */     return results;
/*      */   }
/*      */   
/* 2905 */   public static Map<Integer, ConsumeCO> Consumes = new HashMap<>();
/*      */   public static List<ConsumeCO> findConsumes(Predicate<ConsumeCO> pre) {
/* 2907 */     List<ConsumeCO> results = new ArrayList<>();
/* 2908 */     for (ConsumeCO t : Consumes.values()) {
/* 2909 */       if (pre.test(t)) {
/* 2910 */         results.add(t);
/*      */       }
/*      */     } 
/* 2913 */     return results;
/*      */   }
/*      */   
/* 2916 */   public static Map<Integer, GetRedMoneyCO> GetRedMoneys = new HashMap<>();
/*      */   public static List<GetRedMoneyCO> findGetRedMoneys(Predicate<GetRedMoneyCO> pre) {
/* 2918 */     List<GetRedMoneyCO> results = new ArrayList<>();
/* 2919 */     for (GetRedMoneyCO t : GetRedMoneys.values()) {
/* 2920 */       if (pre.test(t)) {
/* 2921 */         results.add(t);
/*      */       }
/*      */     } 
/* 2924 */     return results;
/*      */   }
/*      */   
/* 2927 */   public static Map<Integer, RedPackageCO> RedPackages = new HashMap<>();
/*      */   public static List<RedPackageCO> findRedPackages(Predicate<RedPackageCO> pre) {
/* 2929 */     List<RedPackageCO> results = new ArrayList<>();
/* 2930 */     for (RedPackageCO t : RedPackages.values()) {
/* 2931 */       if (pre.test(t)) {
/* 2932 */         results.add(t);
/*      */       }
/*      */     } 
/* 2935 */     return results;
/*      */   }
/*      */   
/* 2938 */   public static Map<Integer, RideListExt> RideLists = new HashMap<>();
/*      */   public static List<RideListExt> findRideLists(Predicate<RideListExt> pre) {
/* 2940 */     List<RideListExt> results = new ArrayList<>();
/* 2941 */     for (RideListExt t : RideLists.values()) {
/* 2942 */       if (pre.test(t)) {
/* 2943 */         results.add(t);
/*      */       }
/*      */     } 
/* 2946 */     return results;
/*      */   }
/*      */   
/* 2949 */   public static Map<Integer, SkinListExt> SkinLists = new HashMap<>();
/*      */   public static List<SkinListExt> findSkinLists(Predicate<SkinListExt> pre) {
/* 2951 */     List<SkinListExt> results = new ArrayList<>();
/* 2952 */     for (SkinListExt t : SkinLists.values()) {
/* 2953 */       if (pre.test(t)) {
/* 2954 */         results.add(t);
/*      */       }
/*      */     } 
/* 2957 */     return results;
/*      */   }
/*      */   
/* 2960 */   public static Map<Integer, AttributeExt> Attributes = new HashMap<>();
/*      */   public static List<AttributeExt> findAttributes(Predicate<AttributeExt> pre) {
/* 2962 */     List<AttributeExt> results = new ArrayList<>();
/* 2963 */     for (AttributeExt t : Attributes.values()) {
/* 2964 */       if (pre.test(t)) {
/* 2965 */         results.add(t);
/*      */       }
/*      */     } 
/* 2968 */     return results;
/*      */   }
/*      */   
/* 2971 */   public static Map<Integer, BuffSkillCO> BuffSkills = new HashMap<>();
/*      */   public static List<BuffSkillCO> findBuffSkills(Predicate<BuffSkillCO> pre) {
/* 2973 */     List<BuffSkillCO> results = new ArrayList<>();
/* 2974 */     for (BuffSkillCO t : BuffSkills.values()) {
/* 2975 */       if (pre.test(t)) {
/* 2976 */         results.add(t);
/*      */       }
/*      */     } 
/* 2979 */     return results;
/*      */   }
/*      */   
/* 2982 */   public static Map<Integer, CharacterExt> Characters = new HashMap<>();
/*      */   public static List<CharacterExt> findCharacters(Predicate<CharacterExt> pre) {
/* 2984 */     List<CharacterExt> results = new ArrayList<>();
/* 2985 */     for (CharacterExt t : Characters.values()) {
/* 2986 */       if (pre.test(t)) {
/* 2987 */         results.add(t);
/*      */       }
/*      */     } 
/* 2990 */     return results;
/*      */   }
/*      */   
/* 2993 */   public static Map<Integer, CharacterLevelCO> CharacterLevels = new HashMap<>();
/*      */   public static List<CharacterLevelCO> findCharacterLevels(Predicate<CharacterLevelCO> pre) {
/* 2995 */     List<CharacterLevelCO> results = new ArrayList<>();
/* 2996 */     for (CharacterLevelCO t : CharacterLevels.values()) {
/* 2997 */       if (pre.test(t)) {
/* 2998 */         results.add(t);
/*      */       }
/*      */     } 
/* 3001 */     return results;
/*      */   }
/*      */   
/* 3004 */   public static Map<Integer, RankListExt> RankLists = new HashMap<>();
/*      */   public static List<RankListExt> findRankLists(Predicate<RankListExt> pre) {
/* 3006 */     List<RankListExt> results = new ArrayList<>();
/* 3007 */     for (RankListExt t : RankLists.values()) {
/* 3008 */       if (pre.test(t)) {
/* 3009 */         results.add(t);
/*      */       }
/*      */     } 
/* 3012 */     return results;
/*      */   }
/*      */   
/* 3015 */   public static Map<Integer, RankSortCO> RankSorts = new HashMap<>();
/*      */   public static List<RankSortCO> findRankSorts(Predicate<RankSortCO> pre) {
/* 3017 */     List<RankSortCO> results = new ArrayList<>();
/* 3018 */     for (RankSortCO t : RankSorts.values()) {
/* 3019 */       if (pre.test(t)) {
/* 3020 */         results.add(t);
/*      */       }
/*      */     } 
/* 3023 */     return results;
/*      */   }
/*      */   
/* 3026 */   public static Map<Integer, UpLevelEventCO> UpLevelEvents = new HashMap<>();
/*      */   public static List<UpLevelEventCO> findUpLevelEvents(Predicate<UpLevelEventCO> pre) {
/* 3028 */     List<UpLevelEventCO> results = new ArrayList<>();
/* 3029 */     for (UpLevelEventCO t : UpLevelEvents.values()) {
/* 3030 */       if (pre.test(t)) {
/* 3031 */         results.add(t);
/*      */       }
/*      */     } 
/* 3034 */     return results;
/*      */   }
/*      */   
/* 3037 */   public static Map<Integer, UpLevelExpExt> UpLevelExps = new HashMap<>();
/*      */   public static List<UpLevelExpExt> findUpLevelExps(Predicate<UpLevelExpExt> pre) {
/* 3039 */     List<UpLevelExpExt> results = new ArrayList<>();
/* 3040 */     for (UpLevelExpExt t : UpLevelExps.values()) {
/* 3041 */       if (pre.test(t)) {
/* 3042 */         results.add(t);
/*      */       }
/*      */     } 
/* 3045 */     return results;
/*      */   }
/*      */   
/* 3048 */   public static Map<String, PrefixCO> Prefixs = new HashMap<>();
/*      */   public static List<PrefixCO> findPrefixs(Predicate<PrefixCO> pre) {
/* 3050 */     List<PrefixCO> results = new ArrayList<>();
/* 3051 */     for (PrefixCO t : Prefixs.values()) {
/* 3052 */       if (pre.test(t)) {
/* 3053 */         results.add(t);
/*      */       }
/*      */     } 
/* 3056 */     return results;
/*      */   }
/*      */   
/* 3059 */   public static Map<String, SuffixCO> Suffixs = new HashMap<>();
/*      */   public static List<SuffixCO> findSuffixs(Predicate<SuffixCO> pre) {
/* 3061 */     List<SuffixCO> results = new ArrayList<>();
/* 3062 */     for (SuffixCO t : Suffixs.values()) {
/* 3063 */       if (pre.test(t)) {
/* 3064 */         results.add(t);
/*      */       }
/*      */     } 
/* 3067 */     return results;
/*      */   }
/*      */   
/* 3070 */   public static Map<Integer, FarmLandCO> FarmLands = new HashMap<>();
/*      */   public static List<FarmLandCO> findFarmLands(Predicate<FarmLandCO> pre) {
/* 3072 */     List<FarmLandCO> results = new ArrayList<>();
/* 3073 */     for (FarmLandCO t : FarmLands.values()) {
/* 3074 */       if (pre.test(t)) {
/* 3075 */         results.add(t);
/*      */       }
/*      */     } 
/* 3078 */     return results;
/*      */   }
/*      */   
/* 3081 */   public static Map<Integer, FarmRecordCO> FarmRecords = new HashMap<>();
/*      */   public static List<FarmRecordCO> findFarmRecords(Predicate<FarmRecordCO> pre) {
/* 3083 */     List<FarmRecordCO> results = new ArrayList<>();
/* 3084 */     for (FarmRecordCO t : FarmRecords.values()) {
/* 3085 */       if (pre.test(t)) {
/* 3086 */         results.add(t);
/*      */       }
/*      */     } 
/* 3089 */     return results;
/*      */   }
/*      */   
/* 3092 */   public static Map<Integer, SeedCO> Seeds = new HashMap<>();
/*      */   public static List<SeedCO> findSeeds(Predicate<SeedCO> pre) {
/* 3094 */     List<SeedCO> results = new ArrayList<>();
/* 3095 */     for (SeedCO t : Seeds.values()) {
/* 3096 */       if (pre.test(t)) {
/* 3097 */         results.add(t);
/*      */       }
/*      */     } 
/* 3100 */     return results;
/*      */   }
/*      */   
/* 3103 */   public static Map<Integer, SeedTimeCO> SeedTimes = new HashMap<>();
/*      */   public static List<SeedTimeCO> findSeedTimes(Predicate<SeedTimeCO> pre) {
/* 3105 */     List<SeedTimeCO> results = new ArrayList<>();
/* 3106 */     for (SeedTimeCO t : SeedTimes.values()) {
/* 3107 */       if (pre.test(t)) {
/* 3108 */         results.add(t);
/*      */       }
/*      */     } 
/* 3111 */     return results;
/*      */   }
/*      */   
/* 3114 */   public static Map<Integer, AccumulateExt> Accumulates = new HashMap<>();
/*      */   public static List<AccumulateExt> findAccumulates(Predicate<AccumulateExt> pre) {
/* 3116 */     List<AccumulateExt> results = new ArrayList<>();
/* 3117 */     for (AccumulateExt t : Accumulates.values()) {
/* 3118 */       if (pre.test(t)) {
/* 3119 */         results.add(t);
/*      */       }
/*      */     } 
/* 3122 */     return results;
/*      */   }
/*      */   
/* 3125 */   public static Map<Integer, LuxurySignExt> LuxurySigns = new HashMap<>();
/*      */   public static List<LuxurySignExt> findLuxurySigns(Predicate<LuxurySignExt> pre) {
/* 3127 */     List<LuxurySignExt> results = new ArrayList<>();
/* 3128 */     for (LuxurySignExt t : LuxurySigns.values()) {
/* 3129 */       if (pre.test(t)) {
/* 3130 */         results.add(t);
/*      */       }
/*      */     } 
/* 3133 */     return results;
/*      */   }
/*      */   
/* 3136 */   public static Map<Integer, NormalSignExt> NormalSigns = new HashMap<>();
/*      */   public static List<NormalSignExt> findNormalSigns(Predicate<NormalSignExt> pre) {
/* 3138 */     List<NormalSignExt> results = new ArrayList<>();
/* 3139 */     for (NormalSignExt t : NormalSigns.values()) {
/* 3140 */       if (pre.test(t)) {
/* 3141 */         results.add(t);
/*      */       }
/*      */     } 
/* 3144 */     return results;
/*      */   }
/*      */   
/* 3147 */   public static Map<Integer, MonsterSkillValueCO> MonsterSkillValues = new HashMap<>();
/*      */   public static List<MonsterSkillValueCO> findMonsterSkillValues(Predicate<MonsterSkillValueCO> pre) {
/* 3149 */     List<MonsterSkillValueCO> results = new ArrayList<>();
/* 3150 */     for (MonsterSkillValueCO t : MonsterSkillValues.values()) {
/* 3151 */       if (pre.test(t)) {
/* 3152 */         results.add(t);
/*      */       }
/*      */     } 
/* 3155 */     return results;
/*      */   }
/*      */   
/* 3158 */   public static Map<Integer, PassiveSkillExt> PassiveSkills = new HashMap<>();
/*      */   public static List<PassiveSkillExt> findPassiveSkills(Predicate<PassiveSkillExt> pre) {
/* 3160 */     List<PassiveSkillExt> results = new ArrayList<>();
/* 3161 */     for (PassiveSkillExt t : PassiveSkills.values()) {
/* 3162 */       if (pre.test(t)) {
/* 3163 */         results.add(t);
/*      */       }
/*      */     } 
/* 3166 */     return results;
/*      */   }
/*      */   
/* 3169 */   public static Map<Integer, PetSkillExt> PetSkills = new HashMap<>();
/*      */   public static List<PetSkillExt> findPetSkills(Predicate<PetSkillExt> pre) {
/* 3171 */     List<PetSkillExt> results = new ArrayList<>();
/* 3172 */     for (PetSkillExt t : PetSkills.values()) {
/* 3173 */       if (pre.test(t)) {
/* 3174 */         results.add(t);
/*      */       }
/*      */     } 
/* 3177 */     return results;
/*      */   }
/*      */   
/* 3180 */   public static Map<Integer, SkillDataExt> SkillDatas = new HashMap<>();
/*      */   public static List<SkillDataExt> findSkillDatas(Predicate<SkillDataExt> pre) {
/* 3182 */     List<SkillDataExt> results = new ArrayList<>();
/* 3183 */     for (SkillDataExt t : SkillDatas.values()) {
/* 3184 */       if (pre.test(t)) {
/* 3185 */         results.add(t);
/*      */       }
/*      */     } 
/* 3188 */     return results;
/*      */   }
/*      */   
/* 3191 */   public static Map<Integer, SkillValueExt> SkillValues = new HashMap<>();
/*      */   public static List<SkillValueExt> findSkillValues(Predicate<SkillValueExt> pre) {
/* 3193 */     List<SkillValueExt> results = new ArrayList<>();
/* 3194 */     for (SkillValueExt t : SkillValues.values()) {
/* 3195 */       if (pre.test(t)) {
/* 3196 */         results.add(t);
/*      */       }
/*      */     } 
/* 3199 */     return results;
/*      */   }
/*      */   
/* 3202 */   public static Map<Integer, TalentGroupCO> TalentGroups = new HashMap<>();
/*      */   public static List<TalentGroupCO> findTalentGroups(Predicate<TalentGroupCO> pre) {
/* 3204 */     List<TalentGroupCO> results = new ArrayList<>();
/* 3205 */     for (TalentGroupCO t : TalentGroups.values()) {
/* 3206 */       if (pre.test(t)) {
/* 3207 */         results.add(t);
/*      */       }
/*      */     } 
/* 3210 */     return results;
/*      */   }
/*      */   
/* 3213 */   public static Map<String, AllyConfigCO> AllyConfigs = new HashMap<>();
/*      */   public static List<AllyConfigCO> findAllyConfigs(Predicate<AllyConfigCO> pre) {
/* 3215 */     List<AllyConfigCO> results = new ArrayList<>();
/* 3216 */     for (AllyConfigCO t : AllyConfigs.values()) {
/* 3217 */       if (pre.test(t)) {
/* 3218 */         results.add(t);
/*      */       }
/*      */     } 
/* 3221 */     return results;
/*      */   }
/*      */   
/* 3224 */   public static Map<Integer, TeamPropExt> TeamProps = new HashMap<>();
/*      */   public static List<TeamPropExt> findTeamProps(Predicate<TeamPropExt> pre) {
/* 3226 */     List<TeamPropExt> results = new ArrayList<>();
/* 3227 */     for (TeamPropExt t : TeamProps.values()) {
/* 3228 */       if (pre.test(t)) {
/* 3229 */         results.add(t);
/*      */       }
/*      */     } 
/* 3232 */     return results;
/*      */   }
/*      */   
/* 3235 */   public static Map<String, AllyNameCO> AllyNames = new HashMap<>();
/*      */   public static List<AllyNameCO> findAllyNames(Predicate<AllyNameCO> pre) {
/* 3237 */     List<AllyNameCO> results = new ArrayList<>();
/* 3238 */     for (AllyNameCO t : AllyNames.values()) {
/* 3239 */       if (pre.test(t)) {
/* 3240 */         results.add(t);
/*      */       }
/*      */     } 
/* 3243 */     return results;
/*      */   }
/*      */   
/* 3246 */   public static Map<Integer, SocialFriendCO> SocialFriends = new HashMap<>();
/*      */   public static List<SocialFriendCO> findSocialFriends(Predicate<SocialFriendCO> pre) {
/* 3248 */     List<SocialFriendCO> results = new ArrayList<>();
/* 3249 */     for (SocialFriendCO t : SocialFriends.values()) {
/* 3250 */       if (pre.test(t)) {
/* 3251 */         results.add(t);
/*      */       }
/*      */     } 
/* 3254 */     return results;
/*      */   }
/*      */   
/* 3257 */   public static Map<Integer, SocialMessageCO> SocialMessages = new HashMap<>();
/*      */   public static List<SocialMessageCO> findSocialMessages(Predicate<SocialMessageCO> pre) {
/* 3259 */     List<SocialMessageCO> results = new ArrayList<>();
/* 3260 */     for (SocialMessageCO t : SocialMessages.values()) {
/* 3261 */       if (pre.test(t)) {
/* 3262 */         results.add(t);
/*      */       }
/*      */     } 
/* 3265 */     return results;
/*      */   }
/*      */   
/* 3268 */   public static Map<Integer, SShopCO> SShops = new HashMap<>();
/*      */   public static List<SShopCO> findSShops(Predicate<SShopCO> pre) {
/* 3270 */     List<SShopCO> results = new ArrayList<>();
/* 3271 */     for (SShopCO t : SShops.values()) {
/* 3272 */       if (pre.test(t)) {
/* 3273 */         results.add(t);
/*      */       }
/*      */     } 
/* 3276 */     return results;
/*      */   }
/*      */   
/* 3279 */   public static Map<Integer, TeamTargetExt> TeamTargets = new HashMap<>();
/*      */   public static List<TeamTargetExt> findTeamTargets(Predicate<TeamTargetExt> pre) {
/* 3281 */     List<TeamTargetExt> results = new ArrayList<>();
/* 3282 */     for (TeamTargetExt t : TeamTargets.values()) {
/* 3283 */       if (pre.test(t)) {
/* 3284 */         results.add(t);
/*      */       }
/*      */     } 
/* 3287 */     return results;
/*      */   }
/*      */   
/* 3290 */   public static Map<Integer, SoloMonsterCO> SoloMonsters = new HashMap<>();
/*      */   public static List<SoloMonsterCO> findSoloMonsters(Predicate<SoloMonsterCO> pre) {
/* 3292 */     List<SoloMonsterCO> results = new ArrayList<>();
/* 3293 */     for (SoloMonsterCO t : SoloMonsters.values()) {
/* 3294 */       if (pre.test(t)) {
/* 3295 */         results.add(t);
/*      */       }
/*      */     } 
/* 3298 */     return results;
/*      */   }
/*      */   
/* 3301 */   public static Map<Integer, SoloNewsCO> SoloNewss = new HashMap<>();
/*      */   public static List<SoloNewsCO> findSoloNewss(Predicate<SoloNewsCO> pre) {
/* 3303 */     List<SoloNewsCO> results = new ArrayList<>();
/* 3304 */     for (SoloNewsCO t : SoloNewss.values()) {
/* 3305 */       if (pre.test(t)) {
/* 3306 */         results.add(t);
/*      */       }
/*      */     } 
/* 3309 */     return results;
/*      */   }
/*      */   
/* 3312 */   public static Map<Integer, SoloRankExt> SoloRanks = new HashMap<>();
/*      */   public static List<SoloRankExt> findSoloRanks(Predicate<SoloRankExt> pre) {
/* 3314 */     List<SoloRankExt> results = new ArrayList<>();
/* 3315 */     for (SoloRankExt t : SoloRanks.values()) {
/* 3316 */       if (pre.test(t)) {
/* 3317 */         results.add(t);
/*      */       }
/*      */     } 
/* 3320 */     return results;
/*      */   }
/*      */   
/* 3323 */   public static Map<Integer, SoloRankSeasonRewardExt> SoloRankSeasonRewards = new HashMap<>();
/*      */   public static List<SoloRankSeasonRewardExt> findSoloRankSeasonRewards(Predicate<SoloRankSeasonRewardExt> pre) {
/* 3325 */     List<SoloRankSeasonRewardExt> results = new ArrayList<>();
/* 3326 */     for (SoloRankSeasonRewardExt t : SoloRankSeasonRewards.values()) {
/* 3327 */       if (pre.test(t)) {
/* 3328 */         results.add(t);
/*      */       }
/*      */     } 
/* 3331 */     return results;
/*      */   }
/*      */   
/* 3334 */   public static Map<Integer, TransportExt> Transports = new HashMap<>();
/*      */   public static List<TransportExt> findTransports(Predicate<TransportExt> pre) {
/* 3336 */     List<TransportExt> results = new ArrayList<>();
/* 3337 */     for (TransportExt t : Transports.values()) {
/* 3338 */       if (pre.test(t)) {
/* 3339 */         results.add(t);
/*      */       }
/*      */     } 
/* 3342 */     return results;
/*      */   }
/*      */   
/* 3345 */   public static Map<Integer, VipCO> Vips = new HashMap<>();
/*      */   public static List<VipCO> findVips(Predicate<VipCO> pre) {
/* 3347 */     List<VipCO> results = new ArrayList<>();
/* 3348 */     for (VipCO t : Vips.values()) {
/* 3349 */       if (pre.test(t)) {
/* 3350 */         results.add(t);
/*      */       }
/*      */     } 
/* 3353 */     return results;
/*      */   }
/*      */   
/* 3356 */   public static Map<Integer, WingsListExt> WingsLists = new HashMap<>();
/*      */   public static List<WingsListExt> findWingsLists(Predicate<WingsListExt> pre) {
/* 3358 */     List<WingsListExt> results = new ArrayList<>();
/* 3359 */     for (WingsListExt t : WingsLists.values()) {
/* 3360 */       if (pre.test(t)) {
/* 3361 */         results.add(t);
/*      */       }
/*      */     } 
/* 3364 */     return results;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\GameData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */