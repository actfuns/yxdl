/*      */ package com.wanniu.game.common;
/*      */ 
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import java.util.List;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Const
/*      */ {
/*      */   public static final int LOOP_TASK_ROUND_COUNT = 5;
/*      */   public static final long LOOP_TASK_ROBOT_WAIT_LEAVE_TIME = 300000L;
/*      */   public static final int LOOP_TASK_TEAM_MEMBER_COUNT = 3;
/*      */   public static final int LOOP_LEADER_ADD = 10;
/*      */   public static final int DAILY_TASK_ROUND_COUNT = 10;
/*      */   public static final int DAILY_TASK_DAY_COUNT = 20;
/*      */   public static final int LOOP_DUNGEON_REVIVE_TIME = 5;
/*      */   public static final int LOOP_SPECIAL_AREA_ID = 8888;
/*      */   public static final long RESOURCE_COUNTDOWN = 300000L;
/*      */   public static final int RELIVE_DIAMOND = 5;
/*      */   public static final int RELIVE_NUM = 3;
/*      */   public static final int FB_PRODUCE_COUNT = 3;
/*      */   public static final int AUTO_PICKUP_LIMIT = 50;
/*      */   public static final int REFRSH_NEW_DAY_TIME = 5;
/*      */   public static final int FASHION_FOREVER = -1;
/*      */   public static final int DAY_BY_MILLISECOND = 86400000;
/*      */   
/*      */   public static class NUMBER_MAX
/*      */   {
/*      */     public static final long INT_BIG = 9223372036854775807L;
/*      */     public static final int INT = 2147483647;
/*      */     public static final short INT_SMALL = 32767;
/*      */     public static final int SAME_SCREEN_NUM = 30;
/*      */     public static final int GUILD_FINISHED_MAX = 3;
/*      */   }
/*      */   
/*      */   public static class CODE
/*      */   {
/*      */     public static final int OK = 200;
/*      */     public static final int FAIL = 500;
/*      */     public static final int KICK = 400;
/*      */   }
/*      */   
/*      */   public enum SUPERSCRIPT_TYPE
/*      */   {
/*   62 */     MAIL(100),
/*   63 */     ACTIVITY_CENTER(300),
/*   64 */     FLAG_ACTIVITY_ACIVITY(301),
/*   65 */     FLAG_ACTIVITY_BOSS(302),
/*   66 */     FLAG_ACTIVITY_FATE(303),
/*   67 */     MASTERY_ACTIVE(400),
/*   68 */     MASTERY_RING(401),
/*   69 */     SHOPMALL(500),
/*   70 */     ATTRIBUTE(600),
/*   71 */     GUILD(800),
/*   72 */     GUILD_PRAY(801),
/*   73 */     GUILD_BOSS(802),
/*   74 */     GUILD_BOSS2(803),
/*   75 */     GUILDFORT_INBID(804),
/*   76 */     GUILDFORT_INBATTLE(805),
/*   77 */     GUILDFORT_INAWARD(806),
/*   78 */     GUILD_AUCTION(810),
/*   79 */     WORLD_AUCTION(811),
/*   80 */     ALLY(900),
/*   81 */     ALLY_BLESS(901),
/*   82 */     ALLY_REBATE(902),
/*   83 */     JJC_ENTER(1000),
/*   84 */     JJC_REWARD(1001),
/*   85 */     SOLO(1100),
/*   86 */     SOLO_REWARD(1102),
/*   87 */     MEDAL(1200),
/*   88 */     MOUNT(1300),
/*   89 */     ALLY_FIGHT(1400),
/*   90 */     VIP(1500), WING(1600),
/*   91 */     SKILL(1700),
/*   92 */     CROSS_SERVER(1800),
/*   93 */     PET(1900),
/*   94 */     DUNGEON(2000),
/*   95 */     DUNGEON_NORMAL(2001),
/*   96 */     DUNGEON_ELITE(2002),
/*   97 */     DUNGEON_HERO(2003),
/*   98 */     VITALITY(2100),
/*      */     
/*  100 */     FIRSTPAY_GIFT(2300),
/*  101 */     DAILYPAY_GIFT(2400),
/*  102 */     EQUIP_LEVEL_UP(2500),
/*  103 */     EQUIP_COLOR_UP(2600),
/*  104 */     BOSS_HOME(2800),
/*  105 */     WORLD_LEVEL(2900),
/*  106 */     TREASURE(3000),
/*  107 */     FLAG_OFFLINE(3100),
/*      */     
/*  109 */     FLAG_WELFARE(3200),
/*  110 */     FLAG_WELFARE_SIGN(3201),
/*  111 */     FLAG_WELFARE_ONLINE_GIFT(3202),
/*  112 */     FLAG_WELFARE_ROLE_LV_GIFT(3203),
/*  113 */     FLAG_WELFARE_ROLE_FC_GIFT(3204),
/*  114 */     FLAG_WELFARE_EXCHANGE(3205),
/*  115 */     OPEN_SERVER_DAY(3206),
/*  116 */     TOTAL_CONSUME(3207),
/*  117 */     TOTAL_PAY(3208),
/*  118 */     FUNDS(3209),
/*  119 */     GAME_NOTICE(3210),
/*  120 */     LUCKY_DRAW(3211),
/*  121 */     SUPER_PACKAGE(3212),
/*  122 */     RECOVERY(3213),
/*  123 */     DAILY_RECHARGE(3214),
/*  124 */     SPRING_DRAW(3215),
/*  125 */     SINGLE_RECHARGE(3216),
/*  126 */     REVELRY_RECHARGE(3217),
/*      */     
/*  128 */     CONTINUOUS_RECHARGE(3251),
/*  129 */     RICH(3252),
/*  130 */     SEVEN_GOAL(3253),
/*      */     
/*  132 */     FIVE_2_FIVE_REWARD(3300),
/*  133 */     FIVE_2_FIVE(3301),
/*  134 */     GROWUP_TARGET(3400),
/*  135 */     GROWUP_TARGET_1(3401),
/*  136 */     GROWUP_TARGET_2(3402),
/*  137 */     GROWUP_TARGET_3(3403), GROWUP_TARGET_4(3404), GROWUP_TARGET_5(3405), GROWUP_TARGET_6(3406), GROWUP_TARGET_7(3407), GROWUP_TARGET_8(3408), GROWUP_TARGET_9(3409), GROWUP_TARGET_10(3410), GROWUP_TOTAL(3499),
/*  138 */     WORKING(3500),
/*  139 */     REBORN(3501),
/*      */     
/*  141 */     REBUILD(3503),
/*  142 */     MAKE(3504),
/*  143 */     KAIGUANG(3505),
/*  144 */     UPLEVEL(3506),
/*      */ 
/*      */     
/*  147 */     EQUIP_STRENGTH(3601),
/*  148 */     EQUIP_FILL_GEM(3602),
/*  149 */     EQUIP_EQUIP(3603),
/*  150 */     FLAG_FASHION(3604),
/*  151 */     INTERGAL_MALL(3700),
/*  152 */     DEMON_INVADE_ACTIVED(4001),
/*  153 */     FIVE_MOUNTAIN_ACTIVED(4002),
/*  154 */     SOLO_ACTIVED(4003),
/*  155 */     TRIAL_ACTIVIED(4004),
/*  156 */     ILLUSION2(4005),
/*      */     
/*  158 */     FARM_CULTIVATE(5001),
/*  159 */     FARM_FRIEND(5002),
/*      */     
/*  161 */     ACTIVITY_REVELRY(6001),
/*      */     
/*  163 */     LIMIT_TIME_GIFT(7001),
/*      */     
/*  165 */     MIN(0); private final int value;
/*      */     
/*      */     SUPERSCRIPT_TYPE(int value) {
/*  168 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/*  174 */       return this.value;
/*      */     }
/*      */     
/*      */     public static SUPERSCRIPT_TYPE getType(int value) {
/*  178 */       for (SUPERSCRIPT_TYPE superscript_type : values()) {
/*  179 */         if (superscript_type.value == value) {
/*  180 */           return superscript_type;
/*      */         }
/*      */       } 
/*  183 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PLAYER
/*      */   {
/*      */     public static final int initLevel = 1;
/*      */     public static final int initExp = 0;
/*      */     public static final int initSp = 5000;
/*      */     public static final int initGold = 0;
/*      */     public static final int initTicket = 0;
/*      */     public static final int initPrimaryDiamond = 0;
/*      */     public static final int initDiamond = 0;
/*      */     public static final int initEnergy = 1000;
/*      */     public static final int initFriendly = 0;
/*      */     public static final int initSolopoint = 0;
/*      */     public static final int initVip = 0;
/*      */     public static final int initHp = 999999;
/*      */     public static final int initMp = 999999;
/*      */     public static final int initPrestige = 0;
/*      */     public static final int initCharm = 100;
/*      */     public static final float initSpeed = 5.6F;
/*      */     public static final int maxNum = 5;
/*      */   }
/*      */   
/*      */   public enum FUNCTION_GOTO_TYPE {
/*  209 */     PREPAID(1),
/*  210 */     CONSIGNMENT(2),
/*  211 */     DIAMONDSHOP(6),
/*  212 */     JIANDINGSHOP(7),
/*  213 */     MATERIAL(8),
/*  214 */     LOUD_NOT_ENOUGH(9),
/*  215 */     TICKET_NOT_ENOUGH(10),
/*  216 */     REWARDPK_NOT_ENOUGH(11), XUESHI_NOT_ENOUGH(13), PICK_ITEM(14),
/*  217 */     TREASURE_NOT_ENOUGH(19),
/*  218 */     ACHIEVEMENT_GOLD_NOT_ENOUGH(22),
/*  219 */     SUMMON_ITEM_NOT_ENOUGH(23);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     FUNCTION_GOTO_TYPE(int value) {
/*  224 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  228 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TRANSPORT_CONDITION {
/*  233 */     NOTHING(0), ACCEPT_TASK(1), FINISH_TASK(2), HAS_ITEM(3), CONSUME_ITEM(4);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     TRANSPORT_CONDITION(int value) {
/*  238 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum BORN_TYPE {
/*  243 */     HISTORY(0), NORMAL(1), BORN(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     BORN_TYPE(int value) {
/*  248 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ENTER_STATE {
/*  253 */     changeArea(1),
/*  254 */     online(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     ENTER_STATE(int value) {
/*  259 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PlayerDataType {
/*  264 */     POSITION(1);
/*      */     public final int value;
/*      */     
/*      */     PlayerDataType(int value) {
/*  268 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum EventType
/*      */   {
/*  276 */     killMonster(1), interActiveNpc(2), interActiveItem(3), collect(4), escort(5), guard(6), killBossCount(72), consumeItem(10007), changeSceneProgress(10008), changeArea(10009), summonMount(10010), rebirth(10011), addUnit(10012),
/*  277 */     loopTransform(10013), hurtRank(10014), hurtRank_sort(10015), statics_ranks(10016), over_statics_ranks(10017);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     EventType(int value) {
/*  282 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  286 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum TaskState
/*      */   {
/*  294 */     COMPLETED(2), COMPLETED_NOT_DELIVERY(1), NOT_COMPLETED(0), NOT_START(-1), DELETE(-2), FIAL(-3);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     TaskState(int value) {
/*  299 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  303 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class TaskKind
/*      */   {
/*      */     public static final int MAIN = 0;
/*      */     
/*      */     public static final int BRANCH = 1;
/*      */     
/*      */     public static final int DAILY = 2;
/*      */     
/*      */     public static final int LOOP = 3;
/*      */     
/*      */     public static final int TREASURE = 8;
/*      */   }
/*      */   
/*      */   public enum TaskType
/*      */   {
/*  323 */     KILL_MONSTER(1),
/*  324 */     INTERACT_NPC(2),
/*  325 */     interActiveItem(3),
/*  326 */     collect(4),
/*  327 */     escort(5),
/*  328 */     guard(6),
/*  329 */     reachPos(7),
/*  330 */     GET_RIDESKIN(8),
/*  331 */     TRAIN_RIDE(9),
/*  332 */     TRAIN_EQUIP(10),
/*  333 */     FILL_GEM(11),
/*  334 */     FINISH_CLONESCENE(12),
/*  335 */     SINCOM(13),
/*  336 */     EQUIP_INHERIT(14),
/*  337 */     FISH(15),
/*  338 */     KILL_PLAYER(16),
/*  339 */     COMBINE_GEM(17),
/*  340 */     TRAIN_WING(18),
/*  341 */     GET_ITEM(19),
/*  342 */     DISCARD_ITEM(20),
/*  343 */     GET_RING(21),
/*  344 */     GET_WING(22),
/*  345 */     ADD_GUILD(23),
/*  346 */     GUILD_DONATE(24),
/*  347 */     GOT(25),
/*  348 */     FIENDS(26),
/*  349 */     STEAL(27),
/*  350 */     CHAIN_SOUL(28),
/*  351 */     GRAD_PET(29),
/*  352 */     TREASURE_HUNT(30),
/*  353 */     GETMEDAL(31),
/*  354 */     LEVEL_UP(32),
/*  355 */     OPEN_SONSIGMENT(33),
/*  356 */     SKILL_UP(34),
/*  357 */     ADD_FRIEND(35),
/*  358 */     CONCERN_FRIEND(36),
/*  359 */     EXCHANGE_FRIEND_REWARD(37),
/*  360 */     JOIN_LEAGUE(38),
/*  361 */     JOIN_LEAGUE_WAR(39),
/*  362 */     GUILD_TECH_UP(40),
/*  363 */     GUILD_CONTRIBUTE(41),
/*  364 */     GUILD_PRAY(42),
/*  365 */     JOIN_GUILD_INSTANCE(43),
/*  366 */     EQUIP_MELT(44),
/*  367 */     JOAN_ARENA(45),
/*  368 */     FRIEND_NUM(46),
/*  369 */     PET_TRAIN(47),
/*  370 */     USERUP_LEVEL(48),
/*  371 */     ENCHANT_EQUIP(49),
/*  372 */     EARN_NECK(50),
/*  373 */     JOIN_SOLO(51),
/*  374 */     FINISH_DAILY_TASK(52),
/*  375 */     FUNC_DESK(53),
/*  376 */     TAKE_EQUIP_Qt(54),
/*  377 */     MOUNT_UPLEVEL(55),
/*  378 */     WING_UPLEVEL(56),
/*  379 */     JOIN_DAOYOU(57),
/*  380 */     EQUIP_REBORN(58),
/*  381 */     EQUIP_REBUILD(59),
/*  382 */     EQUIP_REFINE(60),
/*  383 */     ROLE_UPGRADE(61),
/*  384 */     EQUIP_MAKE(62),
/*  385 */     TRAIN_EQUIP_ALL(63),
/*      */     
/*  387 */     FINISH_LOOP_TASK(65),
/*  388 */     ACCEPT_DAILY_LOOP(66),
/*  389 */     ACTIVITY_NUM(67),
/*  390 */     ACCEPT_DAILY(68),
/*      */     
/*  392 */     FIND_TREASURE(70),
/*  393 */     FINISH_DUNGEONS_COUNT(71),
/*  394 */     KILL_BOSS_COUNT(72);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     TaskType(int value) {
/*  399 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  403 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum TipsType
/*      */   {
/*  411 */     NORMAL(0),
/*  412 */     BLACK(1),
/*  413 */     LEFTDWON(2),
/*  414 */     NO_BG(3),
/*  415 */     ROLL(4),
/*  416 */     NEWTYPE(5),
/*  417 */     BOTTOM(6);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     TipsType(int value) {
/*  422 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  426 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum Profession
/*      */   {
/*  434 */     all(0), canglang(1), yujian(2), yixian(3), shenjian(4), linghu(5);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     Profession(int value) {
/*  439 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  443 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailType {
/*  448 */     MAIL_PLAYER_TYPE(1), MAIL_SYSTEM_TYPE(2), MAIL_GM_TYPE(3);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailType(int value) {
/*  453 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  457 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailSysParam {
/*  462 */     MAIL_TIME_LIMIT_1(30000000), MAIL_TIME_LIMIT_2(70000000), MAIL_MAX_NUM(100), MAIL_MAX_WORD(2000);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailSysParam(int value) {
/*  467 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  471 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailReadDeal {
/*  476 */     MAIL_READ_NULL(1), MAIL_READ_DEL(2);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailReadDeal(int value) {
/*  481 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  485 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailState {
/*  490 */     MAIL_STATE_NULL(1), MAIL_STATE_READ(2), MAIL_STATE_ATTACH_RECEIVE(3);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailState(int value) {
/*  495 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  499 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailAttach {
/*  504 */     MAIL_ATTACH_NULL(1), MAIL_ATTACH_CARRY(2);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailAttach(int value) {
/*  509 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  513 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MailStaus {
/*  518 */     MAIL_UNREAD(0), MAIL_UNRECEIVE(1);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MailStaus(int value) {
/*  523 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  527 */       return this.value;
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
/*      */   public static class MailAttachments
/*      */   {
/*      */     public List<String> mailIds;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int code;
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
/*      */   public enum MESSAGE_TYPE
/*      */   {
/*  598 */     mail_receive(1), team_invite(2), team_apply(3), friend_invite(4), daoyou_invite(7), guild_apply(8),
/*  599 */     guild_invite(9),
/*  600 */     daily_task_times(10),
/*  601 */     loop_task_addfriend(11),
/*  602 */     loop_task_member_leave(12),
/*  603 */     loop_task_times(13),
/*  604 */     upLevel_up(14),
/*  605 */     redpacket(17),
/*      */ 
/*      */     
/*  608 */     consignment_publish(200);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     MESSAGE_TYPE(int value) {
/*  613 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  617 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum AreaForce {
/*  622 */     MONSTER(1), FORCEA(2), FORCEB(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     AreaForce(int value) {
/*  627 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum AreaCamp {
/*  632 */     Neutral(1), RongYao(2), TieXue(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     AreaCamp(int value) {
/*  637 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum FightLevelCond {
/*  642 */     TIME(1), REBORNTIME(2), KILL_MONSTER_NUM(3), GUARD_NPC_HP_PRE(4), GUARD_NPC_NUM(5), COLLECTION_ITEM_NUM(6);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     FightLevelCond(int value) {
/*  647 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum FightLevelCondModel {
/*  652 */     MORE(1), LESS(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     FightLevelCondModel(int value) {
/*  657 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum SCENE_TYPE
/*      */   {
/*  666 */     NORMAL(1),
/*      */     
/*  668 */     FIGHT_LEVEL(2),
/*      */     
/*  670 */     SIN_COM(3), ARENA(4), CROSS_SERVER(5), ALLY_FIGHT(6),
/*  671 */     GUILD_DUNGEON(7), WORLD_BOSS(8),
/*      */     
/*  673 */     ILLUSION(9),
/*      */     
/*  675 */     FIVE2FIVE(10),
/*      */     
/*  677 */     DEMON_TOWER(11), RESOURCE_DUNGEON(12),
/*  678 */     LOOP(13),
/*  679 */     GUILD_BOSS(14),
/*  680 */     ILLUSION_2(15),
/*  681 */     FIGHT_LEVEL_ULTRA(16),
/*  682 */     GUILD_FORT_PVE(17),
/*  683 */     GUILD_FORT_PVP(18);
/*      */     
/*      */     private final int value;
/*      */ 
/*      */     
/*      */     SCENE_TYPE(int value) {
/*  689 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  693 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum EquipPos {
/*  698 */     BODY(1), BAG(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     EquipPos(int value) {
/*  703 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ACHIEVEMENT_TYPE {
/*  708 */     ACHIEVEMENT_TYPE_ALL(1), ACHIEVEMENT_TYPE_MAIN(2), ACHIEVEMENT_TYPE_SUB(3), ACHIEVEMENT_TYPE_ELEMENT(4);
/*      */     public final int value;
/*      */     
/*      */     ACHIEVEMENT_TYPE(int value) {
/*  712 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ACHIEVEMENT_AWARD_TYPE {
/*  717 */     ACHIEVEMENT_AWARD_TYPE_ITEM(1), ACHIEVEMENT_AWARD_TYPE_TITLE(2);
/*      */     public final int value;
/*      */     
/*      */     ACHIEVEMENT_AWARD_TYPE(int value) {
/*  721 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ACHIEVEMENT_CONDITION_TYPE {
/*  726 */     DEFAULT(-1), PLAYER_LEVEL(1), PLAYER_RANK(2), PLAYER_POWER_POINT(3), KILL_NPC(4), EQUIPMENT_ENHANCE(5), PLACE_ARRIVED(6), FINISH_TASK(7), FINISH_TASK_NUM(8),
/*  727 */     FINISH_DAILY_TASK(12), GET_GOLD(13), GET_DIAMOND_IN_CONSIGNMENT(15), GET_MAGIC_RING(18), GET_MEDAL(19), GET_NECKLACE(20), GET_EQUIPMENT(21), EQUIPMENT_ENCHANT(25), GET_PET(26), GET_QUALITY_PET(27), PET_LEVEL(28), PET_UPGRADE_LEVEL(29), PET_TRANSFORM_LEVEL(30), RIDE_DEVELOPMENT(31), WING_LEVEL(32), GEM_COMBINE(33),
/*      */     
/*  729 */     FISH_ITEM(35), SKILL_LEVEL(36), DUNGEON_PASSED(37), SOLO_WIN(38), SOLO_RANK(39), ARENA_RANK(41), ARENA_KILL_PLAYER(42), ARENA_SCORE(43), ALLY_GOLD(44), ALLY_KILL_PLAYER(45), FRIENDS_NUM(51), RANK(52),
/*      */     
/*  731 */     ILLUSION_TIME(101),
/*  732 */     KILL_BOSS(102),
/*  733 */     PASS_DEMONTOWER(103),
/*  734 */     WORLD_SPEAK_TIME(104),
/*  735 */     GEM_FILL_TOTAL_LEVEL(105),
/*  736 */     EQUIP_POS_LEVEL(106),
/*  737 */     EQUIP_MAKE_TIMES(107),
/*  738 */     EQUIP_REBORN_TIMES(108),
/*  739 */     EQUIP_REFINE_TIMES(109),
/*  740 */     EQUIP_REBUILD_TIMES(110),
/*  741 */     FIVE_VS_FIVE_TIMES(111),
/*  742 */     AREANA_TIMES(112),
/*  743 */     SOLO_TIMES(113),
/*  744 */     DEMONTOWER_TIMES(114),
/*  745 */     WORLD_LEVEL_TIMES(115),
/*  746 */     MOUNT_COUNT(116),
/*  747 */     XIANYUAN_COUNT(117),
/*  748 */     FINISH_LOOP_TASK(118);
/*      */     
/*      */     public final int value;
/*      */ 
/*      */     
/*      */     ACHIEVEMENT_CONDITION_TYPE(int value) {
/*  754 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ACHIEVEMENT_QUALITY_TYPE {
/*  759 */     WHITE(0), GREEN(1), BLUE(2), PURPLE(3), ORANGE(4), RED(5);
/*      */     public final int value;
/*      */     
/*      */     ACHIEVEMENT_QUALITY_TYPE(int value) {
/*  763 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum BAG_TYPE
/*      */   {
/*  769 */     BAG(1),
/*  770 */     WAREHOUSE(2),
/*  771 */     ACCOUNT_WAREHOUSE(3),
/*  772 */     RECYCLE(4);
/*      */     
/*      */     private int value;
/*      */     
/*      */     BAG_TYPE(int value) {
/*  777 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  781 */       return this.value;
/*      */     }
/*      */     
/*      */     public static BAG_TYPE getE(int value) {
/*  785 */       for (BAG_TYPE type : values()) {
/*  786 */         if (type.value == value) {
/*  787 */           return type;
/*      */         }
/*      */       } 
/*  790 */       return null;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Bag
/*      */   {
/*      */     public static final int BAG_INIT_GRIDCOUNT = 5;
/*      */     
/*      */     public static final int BAG_MAX_GRIDCOUNT = 100;
/*      */     
/*      */     public static final int BAG_GRID_OPEN_TIME = 60000;
/*      */     public static final int BAG_GRID_PACKUP_TIME = 5000;
/*      */     public static final int BAG_GRID_GOLD = 100;
/*      */   }
/*      */   
/*      */   public enum Time
/*      */   {
/*  808 */     Day(86400000), Hour(3600000), Minute(60000), Second(1000);
/*      */     private int value;
/*      */     
/*      */     Time(int value) {
/*  812 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  816 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum BindType
/*      */   {
/*  824 */     UN_BIND(0),
/*  825 */     BIND(1),
/*  826 */     EQUIP_BIND(2),
/*  827 */     BIND_AFTER_GET(3),
/*  828 */     EQUIP_BIND_AFTER_GET(4);
/*      */     
/*      */     private int value;
/*      */     
/*      */     BindType(int value) {
/*  833 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  837 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum ForceType
/*      */   {
/*  845 */     DEFAULT(0),
/*  846 */     BIND(1),
/*  847 */     UN_BIND(2);
/*      */     
/*      */     private int value;
/*      */     
/*      */     ForceType(int value) {
/*  852 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  856 */       return this.value;
/*      */     }
/*      */     
/*      */     public static ForceType getE(int value) {
/*  860 */       for (ForceType e : values()) {
/*  861 */         if (value == e.getValue()) {
/*  862 */           return e;
/*      */         }
/*      */       } 
/*  865 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ITEM_CODE {
/*  870 */     TICKET("cash"), TREASURE_POINT("treasurespoint"), XIAN_YUAN("xianyuan"), Changename("changename"),
/*      */ 
/*      */ 
/*      */     
/*  874 */     DUNGEONPROFIT("dungeonprofit");
/*      */     
/*      */     public String value;
/*      */     
/*      */     ITEM_CODE(String value) {
/*  879 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum ItemType
/*      */   {
/*  887 */     Weapon(1), Armor(2), Oranament(3), RideEquip(4), Bijou(5), Mate(6), Misc(7), Chest(8), Potion(9), Quest(10), Virtual(11);
/*      */     
/*      */     private int value;
/*      */     
/*      */     ItemType(int value) {
/*  892 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  896 */       return this.value;
/*      */     }
/*      */     
/*      */     public static ItemType getE(int value) {
/*  900 */       for (ItemType e : values()) {
/*  901 */         if (value == e.getValue()) {
/*  902 */           return e;
/*      */         }
/*      */       } 
/*  905 */       return null;
/*      */     }
/*      */     
/*      */     public static int getV(String s) {
/*  909 */       for (ItemType e : values()) {
/*  910 */         if (e.toString().equals(s)) {
/*  911 */           return e.getValue();
/*      */         }
/*      */       } 
/*  914 */       throw new RuntimeException("物品类型没找到:" + s);
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ItemSecondType {
/*  919 */     ZHU_SHOU(1, "武器"), TOU_BU(2, "头部"),
/*  920 */     SHANG_YI(3, "上衣"), TUI_BU(4, "腿部"), YAO_BU(5, "肩部"), SHOU_TAO(6, "护腕"), XIE_ZI(7, "鞋子"), XIANG_LIAN(8, "项链"), JIE_ZI(9, "戒指"), HU_SHENG_FU(10, "护身符"), rideSoul(21, "rideSoul", "坐骑装备"), rideShield(22, "rideShield", "坐骑装备"), rideSpirit(23, "rideSpirit", "坐骑装备"), rideHeart(24, "rideHeart", "坐骑装备"), gem(201, "gem", "宝石"), mate(202, "mate", "材料"), rideItem(203, "rideItem", "材料"), petItem(204, "petItem", "材料"), fashionItem(205, "fashionItem", "材料"), chest(301, "chest", "宝箱"), hpot(401, "hpot", "药剂"),
/*  921 */     rank(402, "rank", "称号"), virtQuest(501, "virtQuest", "任务物品"), realQuest(502, "realQuest", "任务物品"), misc(999, "misc", "杂物"), virtual(1000, "virtual", "虚拟物品"), soul(998, "soul", "魂魄");
/*      */     
/*      */     private String key;
/*      */     private int value;
/*      */     String desc;
/*      */     
/*      */     ItemSecondType(int value, String key) {
/*  928 */       this.value = value;
/*  929 */       this.key = key;
/*      */     }
/*      */     
/*      */     ItemSecondType(int value, String key, String desc) {
/*  933 */       this.value = value;
/*  934 */       this.key = key;
/*  935 */       this.desc = desc;
/*      */     }
/*      */     
/*      */     public String getKey() {
/*  939 */       return this.key;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  943 */       return this.value;
/*      */     }
/*      */     
/*      */     public static int getV(String s) {
/*  947 */       for (ItemSecondType e : values()) {
/*  948 */         if (e.key.equals(s)) {
/*  949 */           return e.getValue();
/*      */         }
/*      */       } 
/*  952 */       throw new RuntimeException("未找到的装备类型:" + s);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum EquipType
/*      */   {
/*  961 */     MAIN_HAND(1), HEAD(2), CLOTH(3), LEG(4),
/*  962 */     SHOULDER(5),
/*  963 */     GLOVES(6),
/*  964 */     SHOES(7),
/*  965 */     NECKLACE(8),
/*  966 */     RING(9),
/*  967 */     CHARM(10);
/*      */     
/*      */     private int value;
/*      */     
/*      */     EquipType(int value) {
/*  972 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  976 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ItemQuality {
/*  981 */     WHITE(0),
/*  982 */     BLUE(1),
/*  983 */     PURPLE(2),
/*  984 */     ORANGE(3),
/*  985 */     GREEN(4),
/*  986 */     RED(5);
/*      */     
/*      */     private int value;
/*      */     
/*      */     ItemQuality(int value) {
/*  991 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/*  995 */       return this.value;
/*      */     }
/*      */     
/*      */     public static ItemQuality getE(int value) {
/*  999 */       for (ItemQuality e : values()) {
/* 1000 */         if (e.value == value) {
/* 1001 */           return e;
/*      */         }
/*      */       } 
/* 1004 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GOODS_CHANGE_TYPE
/*      */   {
/* 1010 */     random_box(81, "随机宝箱"),
/*      */ 
/*      */     
/* 1013 */     TX(999, "提现"),
/* 1014 */     def(0, "默认"),
/* 1015 */     gm(1, "GM命令"),
/* 1016 */     shop(9, "商城购买"),
/* 1017 */     use(15, "物品使用"),
/* 1018 */     mail(18, "邮件"),
/* 1019 */     DAOYOU(73, "道友返利"),
/* 1020 */     CDK(85, "CDK兑换"),
/* 1021 */     ONLINE_GIFT(86, "领取在线奖励"),
/* 1022 */     AUTO_MELT(87, "自动熔炼"),
/* 1023 */     AUCTION(110, "仙盟竞拍"),
/* 1024 */     GMT(111, "GM工具（WEB后台）"),
/* 1025 */     REVELRY_EXCHANGE(117, "开服冲榜兑换"),
/*      */ 
/*      */     
/* 1028 */     AUCTION_BONUS(201, "竞拍分红"),
/* 1029 */     AUCTION_RESTITUTION(202, "竞拍失败归还竞价"),
/* 1030 */     CHARGE(203, "充值"),
/* 1031 */     SUPER_PACKAGE(204, "超值礼包"),
/* 1032 */     FIRST_CHARGE(205, "首充奖励"),
/* 1033 */     CUMULATIVE_CHARGE(206, "累充奖励"),
/* 1034 */     VIPBUY(207, "购买月卡"),
/* 1035 */     PAY_REBATE(208, "封测充值返利"),
/* 1036 */     RECEIVE_FUNDS(209, "开服基金奖励"),
/* 1037 */     REVELRY(210, "开服冲榜奖励"),
/* 1038 */     GUILD_BOSS(211, "仙盟BOSS奖励"),
/*      */     
/* 1040 */     ACTIVITY_SEVENDAY(212, "福利-开服狂欢"),
/* 1041 */     ACTIVITY_TOTAL_PAY(213, "福利-累计充值"),
/* 1042 */     ACTIVITY_TOTAL_CONSUME(214, "福利-累计消费"),
/* 1043 */     ACTIVITY_LEVEL(215, "福利-等级礼包"),
/* 1044 */     ACTIVITY_FIGHT_POEWR(216, "福利-战力礼包"),
/*      */     
/* 1046 */     CONSIGNMENT_TIMEOUT(217, "拍卖超时退还"),
/* 1047 */     CONSIGNMENT_SELL(218, "拍卖出售"),
/* 1048 */     CONSIGNMENT_REMOVE(219, "拍卖下架"),
/*      */     
/* 1050 */     DailyRecharge(220, "每日充值"),
/* 1051 */     ActivityDraw(221, "活动抽奖"),
/* 1052 */     ActivityDrawSpring(222, "新春抽奖"),
/* 1053 */     LimitTimeGift(223, "限时礼包"),
/* 1054 */     DemonTower(224, "镇妖塔"),
/* 1055 */     Fashion(226, "时装"),
/*      */     
/* 1057 */     WORLD_LEVEL(227, "世界等级"),
/* 1058 */     KILL_PLAYER(228, "击杀玩家"),
/* 1059 */     smriti_equip(229, "继承装备"),
/* 1060 */     task_submit(230, "提交任务"),
/* 1061 */     move(231, "转移物品"),
/*      */     
/* 1063 */     guild_store(232, "工会仓库"),
/* 1064 */     guild_tech(233, "公会修行"),
/* 1065 */     guild_bless(234, "公会祈福"),
/* 1066 */     guild_bless_award(235, "公会祈福奖励"),
/* 1067 */     guild_donate(236, "公会捐献"),
/* 1068 */     guild_mail(237, "仙盟发的邮件"),
/* 1069 */     guild_create(238, "创建仙盟"),
/* 1070 */     guild_upgrade_bless_level(239, "提升仙盟祝福等级"),
/* 1071 */     guild_upgrade_depot_level(240, "提升仙盟存储等级"),
/* 1072 */     guild_upgrade_level(241, "提升仙盟等级"),
/* 1073 */     guild_buy_tech_product(242, "购买仙盟科技产品"),
/* 1074 */     guild_upgrade_tech_level(243, "提升仙盟科技等级"),
/* 1075 */     guildfort_daily_award(244, "仙盟据点战日常奖励"),
/*      */     
/* 1077 */     resource_dungeon_sweep(250, "资源副本扫荡"),
/* 1078 */     recovered(253, "资源找回"),
/*      */     
/* 1080 */     equip(254, "穿装备"),
/* 1081 */     saveRebuid(255, "保存重铸"),
/* 1082 */     saveReborn(256, "保存洗练"),
/*      */     
/* 1084 */     resource_dungeon_buy_times(257, "资源副本购买次数"),
/* 1085 */     resource_dungeon_award(258, "资源副本领取奖励"),
/* 1086 */     resource_dungeon_cost_diamond(259, "资源副本扣除元宝"),
/*      */     
/* 1088 */     FUNCTION_OPEN(260, "领取功能开放奖励"),
/* 1089 */     relive(261, "复活"),
/*      */     
/* 1091 */     intergalmall(262, "积分商城"),
/* 1092 */     five2five(263, "5v5"),
/*      */     
/* 1094 */     fight_level(264, "副本"),
/* 1095 */     RollPoint(265, "roll点"),
/*      */     
/* 1097 */     Rebuild(266, "重铸"),
/* 1098 */     SeniorRebuild(267, "高级重铸"),
/* 1099 */     Reborn(268, "洗练"),
/* 1100 */     Refine(269, "精炼"),
/*      */     
/* 1102 */     leaderBoard(270, "世界等级膜拜"),
/*      */     
/* 1104 */     interact(271, "交互"),
/*      */     
/* 1106 */     inherit(272, "继承"),
/*      */     
/* 1108 */     openbag(273, "开背包格子"),
/*      */     
/* 1110 */     guildchangename(274, "公会改名"),
/*      */     
/* 1112 */     chat(275, "聊天"),
/*      */     
/* 1114 */     transport(276, "传送"),
/*      */     
/* 1116 */     consume(277, "消费"),
/*      */     
/* 1118 */     buy(278, "个人商店"),
/*      */     
/* 1120 */     skill(279, "升级技能"),
/*      */     
/* 1122 */     pet(280, "宠物培养"),
/* 1123 */     petChangeName(281, "宠物改名"),
/* 1124 */     petCost(282, "使用宠物道具"),
/*      */     
/* 1126 */     monsterdrop(283, "怪物掉落"),
/* 1127 */     achieve(284, "成就"),
/*      */     
/* 1129 */     task(285, "任务"),
/* 1130 */     solo(286, "问道"),
/*      */     
/* 1132 */     trade(287, "出售"),
/*      */ 
/*      */     
/* 1135 */     compound(288, "合成"),
/*      */     
/* 1137 */     arena(289, "竞技场"),
/* 1138 */     sign(290, "签到"),
/* 1139 */     exchange(291, "兑换"),
/* 1140 */     melt(292, "熔炼"),
/* 1141 */     clear_when_logout(293, "出售"),
/* 1142 */     fish(294, "钓鱼"),
/* 1143 */     hitUser(295, "PK"),
/* 1144 */     daily_activity(296, "活跃度礼包"),
/*      */     
/* 1146 */     equipMake(297, "装备制作"),
/* 1147 */     equipLevelUp(298, "装备升级（等级）"),
/* 1148 */     equipColorUp(299, "装备升品（品质）"),
/* 1149 */     equipmosaic(300, "装备镶嵌"),
/* 1150 */     equipstrengh(301, "装备强化"),
/* 1151 */     dailypay_gift(302, "月卡奖励"),
/*      */     
/* 1153 */     flee(303, "五岳一战"),
/* 1154 */     BOSS_ASSISTS(304, "野外Boss助攻"),
/*      */     
/* 1156 */     CombineCompensate(305, "合服补偿"),
/* 1157 */     blood(306, "血脉"),
/* 1158 */     EXCHANGE_PROPARTY(307, "属性兑换"),
/* 1159 */     RedPacket(308, "红包"),
/* 1160 */     Rich(309, "大富翁"),
/* 1161 */     SevenGoal(310, "七日目标"),
/* 1162 */     ContinuousRecharge(311, "连续充值"),
/* 1163 */     SingleRecharge(312, "单笔充值"),
/* 1164 */     RevelryRecharge(313, "冲榜累充"),
/*      */ 
/*      */     
/* 1167 */     BUY_FUNDS(401, "购买开服基金"),
/* 1168 */     BOSS_GUILD_INSPIRE(402, "仙盟BOSS鼓舞"),
/* 1169 */     CONSIGNMENT_ADD(403, "拍卖上架"),
/* 1170 */     CONSIGNMENT_BUY(404, "拍卖购买"),
/* 1171 */     CONSIGNMENT_PUBLIC(405, "拍卖宣传"),
/*      */     
/* 1173 */     FarmChange(1001, "果园兑换"),
/* 1174 */     FarmHarvest(1002, "果园收获"),
/* 1175 */     FarmOpen(1003, "果园开启地块"),
/* 1176 */     FarmSow(1004, "果园播种"),
/* 1177 */     FarmSteal(1005, "果园偷取");
/*      */     
/*      */     public int value;
/*      */     
/*      */     private final String desc;
/*      */     
/*      */     GOODS_CHANGE_TYPE(int value, String desc) {
/* 1184 */       this.value = value;
/* 1185 */       this.desc = desc;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1189 */       return this.value;
/*      */     }
/*      */     
/*      */     public String getDesc() {
/* 1193 */       return this.desc;
/*      */     }
/*      */     
/*      */     public static GOODS_CHANGE_TYPE getE(int value) {
/* 1197 */       for (GOODS_CHANGE_TYPE e : values()) {
/* 1198 */         if (e.value == value) {
/* 1199 */           return e;
/*      */         }
/*      */       } 
/* 1202 */       return null;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum CurrencyType
/*      */   {
/* 1210 */     NONE(0),
/* 1211 */     DIAMOND(1),
/* 1212 */     COIN(2),
/* 1213 */     TICKET(3),
/* 1214 */     OTHER(4);
/*      */     private int value;
/*      */     
/*      */     CurrencyType(int value) {
/* 1218 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1222 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SYS_SET
/*      */   {
/* 1228 */     OFF(0), ON(1);
/*      */     
/*      */     private int value;
/*      */     
/*      */     SYS_SET(int value) {
/* 1233 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1237 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum FunctionType {
/* 1242 */     MAINLIND("Mainline"),
/* 1243 */     BRANCH("Branch"),
/* 1244 */     DAILY("Daily"),
/* 1245 */     MAIL("Mail"),
/* 1246 */     CHAT("Chat"),
/* 1247 */     WAREHOUSE("Warehouse"),
/* 1248 */     PICK("Pick"),
/* 1249 */     MAP("Map"),
/* 1250 */     SIGN("Sign"),
/* 1251 */     ONLINE_GIFT("Olgift"),
/* 1252 */     AUTO_FIGHT("HangUP"),
/* 1253 */     AUTO_FIGHT_SET("HangUPSet"),
/* 1254 */     BAG("Bag"),
/* 1255 */     CURRENCY("Currency"),
/* 1256 */     ATTRIBUTE("Character"),
/* 1257 */     TEAM("Team"),
/* 1258 */     DAILY_PLAY("DailyPlay"),
/* 1259 */     EXCHANGE("Change"),
/* 1260 */     APPRAISAL("Appraisal"),
/* 1261 */     ACHIEVEMENT("Achievement"),
/* 1262 */     UP("Up"),
/* 1263 */     MALL("Mall"),
/* 1264 */     ACTIVITY("Activity"),
/* 1265 */     PAY("Pay"),
/* 1266 */     RANK("Rank"),
/* 1267 */     FRIEND("Social"),
/* 1268 */     SYSTEM_SETTING("SysSetting"),
/* 1269 */     RIDING("Riding"),
/* 1270 */     SKILL("Skill"),
/* 1271 */     TITLE2("Title2"),
/* 1272 */     MOUNT("Ride"),
/* 1273 */     SOLO("Solo"),
/* 1274 */     SetNew("SetNew"),
/* 1275 */     STRENGTHEN("Strengthen"),
/* 1276 */     REWORK("Reworking"),
/* 1277 */     SMELTING("Smelting"),
/* 1278 */     PET("Pet"),
/* 1279 */     MAGIC_RING("MagicRing"),
/* 1280 */     WING("Wings"),
/* 1281 */     MEDAL("Title"),
/* 1282 */     GUILD("Guild"),
/* 1283 */     FB("FB"),
/* 1284 */     DaoYou("Ally"),
/* 1285 */     JJC("JJC"),
/* 1286 */     CONSIGNMENT("Consignment"),
/* 1287 */     SERVERS("Servers"),
/* 1288 */     ALLY_BATTLE("AllyBattle"),
/* 1289 */     REWORKING_UP("ReworkingUp"),
/* 1290 */     Make("Make"),
/* 1291 */     TOWER("Tower"),
/* 1292 */     GUILD_BATTLE("GuildBattle"),
/* 1293 */     FASHION("Fashion"),
/* 1294 */     BOSS_HOME("BossHome"),
/* 1295 */     EQUIP_LV_UP("EquipLvUp"),
/* 1296 */     REFINE("Refine"),
/* 1297 */     COMBINE("Combine"),
/* 1298 */     TARGET("Target"),
/* 1299 */     FIRST_PAY("FirstPay"),
/* 1300 */     DAILY_PAY("DailyPay"),
/* 1301 */     Rebuild("Rebuild"),
/* 1302 */     Reborn("Reborn"),
/* 1303 */     WORLD_EXP("WorldExp"),
/* 1304 */     XIAN_YUAN("XianYuan"),
/* 1305 */     FIVE_2_FIVE("5v5"),
/* 1306 */     LoopTask("oneDragon"),
/* 1307 */     teacher("teacher"), Inherit("Inherit"),
/* 1308 */     BloodLineage("BloodLineage");
/*      */     private String value;
/*      */     
/*      */     FunctionType(String value) {
/* 1312 */       this.value = value;
/*      */     }
/*      */     
/*      */     public String getValue() {
/* 1316 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MOUNT_SKIN_STATE
/*      */   {
/* 1322 */     notactive(1), notuse(2), useing(3);
/*      */     
/*      */     private int value;
/*      */     
/*      */     MOUNT_SKIN_STATE(int value) {
/* 1327 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1331 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MOUNT_RIDING_STATE
/*      */   {
/* 1337 */     off(0), on(1);
/*      */     
/*      */     private int value;
/*      */     
/*      */     MOUNT_RIDING_STATE(int value) {
/* 1342 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1346 */       return this.value;
/*      */     }
/*      */     
/*      */     public static MOUNT_RIDING_STATE getValue(int value) {
/* 1350 */       for (MOUNT_RIDING_STATE mrs : values()) {
/* 1351 */         if (mrs.getValue() == value) {
/* 1352 */           return mrs;
/*      */         }
/*      */       } 
/* 1355 */       return off;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class IntergalMallType
/*      */   {
/*      */     public static final int SundryShop = 1;
/*      */     
/*      */     public static final int MallShop = 2;
/*      */     
/*      */     public static final int FateShop = 3;
/*      */     
/*      */     public static final int AthleticShop = 4;
/*      */     
/*      */     public static final int GuildShop = 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public enum SHOP_MALL_CONSUME_TYPE
/*      */   {
/* 1376 */     DIAMOND(1), TICKET(2), ITEMCHANGE(3);
/*      */     private int value;
/*      */     
/*      */     SHOP_MALL_CONSUME_TYPE(int value) {
/* 1380 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1384 */       return this.value;
/*      */     }
/*      */     
/*      */     public static SHOP_MALL_CONSUME_TYPE getType(int value) {
/* 1388 */       for (SHOP_MALL_CONSUME_TYPE shMall_CONSUME_TYPE : values()) {
/* 1389 */         if (shMall_CONSUME_TYPE.value == value) {
/* 1390 */           return shMall_CONSUME_TYPE;
/*      */         }
/*      */       } 
/* 1393 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SHOP_MALL_SERVER_LIMIT {
/* 1398 */     GLOBAL(1), SELF(0);
/*      */     private int value;
/*      */     
/*      */     SHOP_MALL_SERVER_LIMIT(int value) {
/* 1402 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1406 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SHOP_MALL_SCOREITEM_POSITION {
/* 1411 */     FIRST(1), SECOND(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
/*      */     private int value;
/*      */     
/*      */     SHOP_MALL_SCOREITEM_POSITION(int value) {
/* 1415 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1419 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SHOP_MALL_ITEM_TYPE {
/* 1424 */     DIAMOND_LIMIT(101), TICKET_LIMIT(201), ITEM_LIMIT(301);
/*      */     private int value;
/*      */     
/*      */     SHOP_MALL_ITEM_TYPE(int value) {
/* 1428 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1432 */       return this.value;
/*      */     }
/*      */     
/*      */     public static SHOP_MALL_ITEM_TYPE getType(int value) {
/* 1436 */       for (SHOP_MALL_ITEM_TYPE sMall_ITEM_TYPE : values()) {
/* 1437 */         if (sMall_ITEM_TYPE.value == value) {
/* 1438 */           return sMall_ITEM_TYPE;
/*      */         }
/*      */       } 
/* 1441 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ONLINE_GIFT {
/* 1446 */     INIT_ID(1001), END_ID(0);
/*      */     
/*      */     private int value;
/*      */     
/*      */     ONLINE_GIFT(int value) {
/* 1451 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1455 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ONLINE_GIFT_TYPE {
/* 1460 */     NORMAL(0), FIRST_DAY(1);
/*      */     private int value;
/*      */     
/*      */     ONLINE_GIFT_TYPE(int value) {
/* 1464 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1468 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum EVENT_GIFT_STATE {
/* 1473 */     NOT_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2);
/*      */     private int value;
/*      */     
/*      */     EVENT_GIFT_STATE(int value) {
/* 1477 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1481 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum EVENT_GIFT_REQUIRE_TYPE {
/* 1486 */     LV(1), FIGHT_POWER(2);
/*      */     private int value;
/*      */     
/*      */     EVENT_GIFT_REQUIRE_TYPE(int value) {
/* 1490 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1494 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum EVENT_GIFT_PROP_TYPE {
/* 1499 */     ONE("event_template1"), TWO("event_template2");
/*      */     private String value;
/*      */     
/*      */     EVENT_GIFT_PROP_TYPE(String value) {
/* 1503 */       this.value = value;
/*      */     }
/*      */     
/*      */     public String getValue() {
/* 1507 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PropertyChangeType {
/* 1512 */     HP(0), MP(1), HPAndMP(2), NPC(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     PropertyChangeType(int value) {
/* 1517 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ValueType {
/* 1522 */     Value(0), Percent(1);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     ValueType(int value) {
/* 1527 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum CUSTOMTIPTYPE {
/* 1532 */     GOLD(1), TICKET(2), DIAMOND(3), EXP(4), PRESTIGE(5);
/*      */     
/*      */     private int value;
/*      */     
/*      */     CUSTOMTIPTYPE(int value) {
/* 1537 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1541 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum CHAT_SCOPE {
/* 1546 */     WORLD(1),
/* 1547 */     GUILD(2),
/* 1548 */     TEAM(3),
/* 1549 */     PRIVATE(4),
/* 1550 */     ZONE(5),
/* 1551 */     DAOYOU(6),
/* 1552 */     SYSTEM(7),
/* 1553 */     HORM(8),
/* 1554 */     TEAM_CALL(9);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     CHAT_SCOPE(int value) {
/* 1559 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1563 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SYS_CHAT_TYPE {
/* 1568 */     EXP(1), COIN(2), ITEM(3), TRADE(4), TEAM_EXP(5), CLASS_EXP(6);
/*      */     
/*      */     private int value;
/*      */     
/*      */     SYS_CHAT_TYPE(int value) {
/* 1573 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1577 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum COMMONPROPERTYUP
/*      */   {
/* 1583 */     WING(1), MOUNT(2);
/*      */     private int value;
/*      */     
/*      */     COMMONPROPERTYUP(int value) {
/* 1587 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1591 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PlayerPro {
/* 1596 */     ALL("ALL", 0), COMMON("通用", 0), CANG_LANG("苍狼", 1), YU_JIAN("御剑", 2), YI_XIAN("逸仙", 3), SHEN_JIAN("神箭", 4), LI_NHU("灵狐", 5);
/*      */     
/*      */     public final int value;
/*      */     public final String key;
/*      */     
/*      */     PlayerPro(String key, int value) {
/* 1602 */       this.key = key;
/* 1603 */       this.value = value;
/*      */     }
/*      */     
/*      */     public static PlayerPro Enum(int value) {
/* 1607 */       for (PlayerPro e : values()) {
/* 1608 */         if (value == e.value) {
/* 1609 */           return e;
/*      */         }
/*      */       } 
/* 1612 */       Out.error(new Object[] { "PlayerPro undefine v : ", Integer.valueOf(value) });
/* 1613 */       return null;
/*      */     }
/*      */     
/*      */     public static int Value(String s) {
/* 1617 */       if (StringUtil.isEmpty(s)) {
/* 1618 */         return 0;
/*      */       }
/* 1620 */       for (PlayerPro e : values()) {
/* 1621 */         if (e.key.equals(s)) {
/* 1622 */           return e.value;
/*      */         }
/*      */       } 
/* 1625 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void main(String[] args) {
/* 1631 */     System.out.println(PlayerPro.Value("灵狐"));
/*      */   }
/*      */   
/*      */   public enum TEAM_DISTRIBUTE_TYPE {
/* 1635 */     FREEDOM(1),
/*      */     
/* 1637 */     GRAB(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     TEAM_DISTRIBUTE_TYPE(int value) {
/* 1642 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TEAM_DISTRIBUTE_TYPE_DES {
/* 1647 */     FREEDOM("自由拾取"), DISTRIBUTE("队长分配"), GRAB("摇色子");
/*      */     
/*      */     public final String value;
/*      */     
/*      */     TEAM_DISTRIBUTE_TYPE_DES(String value) {
/* 1652 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum EQUIP_QCOLOR {
/* 1657 */     WHITE(0), BLUE(1), PURPLE(2), ORANGE(3), GREEN(4);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     EQUIP_QCOLOR(int value) {
/* 1662 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TEAM_DISTRIBUTE_ITEM_QCOLOR_DES {
/* 1667 */     BLUE("蓝色"), PURPLE("紫色"), ORANGE("橙色");
/*      */     
/*      */     public final String value;
/*      */     
/*      */     TEAM_DISTRIBUTE_ITEM_QCOLOR_DES(String value) {
/* 1672 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TEAM_GRAB_ITEM_TYPE {
/* 1677 */     GIVE_UP(1),
/* 1678 */     RANDOM(2),
/* 1679 */     WANT(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     TEAM_GRAB_ITEM_TYPE(int value) {
/* 1684 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1688 */       return this.value;
/*      */     }
/*      */     
/*      */     public static TEAM_GRAB_ITEM_TYPE getE(int value) {
/* 1692 */       for (TEAM_GRAB_ITEM_TYPE e : values()) {
/* 1693 */         if (value == e.getValue()) {
/* 1694 */           return e;
/*      */         }
/*      */       } 
/* 1697 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum RankSeasonType {
/* 1702 */     NO_SEASON(-1),
/* 1703 */     LAST_SEASON(0),
/* 1704 */     CUR_SEASON(1);
/*      */     public final int value;
/*      */     
/*      */     RankSeasonType(int value) {
/* 1708 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum UpdateType {
/* 1713 */     INTERVAL_TIME(0),
/* 1714 */     REAL_TIME(1);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     UpdateType(int value) {
/* 1719 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum LeaderBoardType
/*      */   {
/* 1725 */     FIGHTPOWER_ALL_rankTR(101),
/* 1726 */     FIGHTPOWER_1_rankTR(102),
/*      */     
/* 1728 */     FIGHTPOWER_3_rankTR(104),
/*      */     
/* 1730 */     FIGHTPOWER_5_rankTR(106),
/* 1731 */     LEVEL_rankTR(200),
/* 1732 */     GUILD_LEVEL_rankTR(300),
/* 1733 */     GUILD_WAR_rankTR(400),
/* 1734 */     RIDE_rankTR(500),
/* 1735 */     PET_rankTR(600),
/* 1736 */     XIANYUAN_rankTR(700),
/* 1737 */     HP_rankTR(800),
/* 1738 */     PHY_rankTR(801),
/* 1739 */     MAGIC_rankTR(802),
/* 1740 */     PVP_5V5_rankTR(1003),
/* 1741 */     DAOYOU_rankTR(2005),
/* 1742 */     FLEE_rankTR(900),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1748 */     SOLO_SCORE_seasonRankTR(2006),
/* 1749 */     ARENA_SCORE_rankTR(2007),
/* 1750 */     ARENA_SCOREALL_seasonRankTR(2009),
/* 1751 */     DEMON_TOWER_rankTR(2100),
/* 1752 */     MIN(0);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     LeaderBoardType(int value) {
/* 1757 */       this.value = value;
/*      */     }
/*      */     
/*      */     public static LeaderBoardType getE(int value) {
/* 1761 */       for (LeaderBoardType e : values()) {
/* 1762 */         if (e.value == value) {
/* 1763 */           return e;
/*      */         }
/*      */       } 
/* 1766 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PkModel {
/* 1771 */     Peace(0), Justice(1), Force(2), Guild(3), Team(4), Server(5), All(6);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     PkModel(int value) {
/* 1776 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum OrderType {
/* 1781 */     A(1), Asc(1), D(2), Desc(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     OrderType(int value) {
/* 1786 */       this.value = value;
/*      */     }
/*      */     
/*      */     public static OrderType getE(String name) {
/* 1790 */       for (OrderType e : values()) {
/* 1791 */         if (e.name().equals(name)) {
/* 1792 */           return e;
/*      */         }
/*      */       } 
/* 1795 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TaskOpenWay {
/* 1800 */     None(0), DailyOpenInTime(1),
/* 1801 */     WeekOpenInTime(2),
/* 1802 */     OpenInTime(3),
/* 1803 */     FestivalOpenInTime(4);
/*      */     private final int value;
/*      */     
/*      */     TaskOpenWay(int value) {
/* 1807 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1811 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum FASHION_BUY_TYPE
/*      */   {
/* 1822 */     DIAMOND(1), COIN(2), ITEM(3);
/*      */     private final int value;
/*      */     
/*      */     FASHION_BUY_TYPE(int value) {
/* 1826 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1830 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum FASHION_TYPE
/*      */   {
/* 1838 */     WEPON(1), CLOTH(2), WING(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     FASHION_TYPE(int value) {
/* 1843 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Position
/*      */   {
/*      */     public int x;
/*      */ 
/*      */ 
/*      */     
/*      */     public int y;
/*      */ 
/*      */ 
/*      */     
/*      */     public Position(int x, int y) {
/* 1861 */       this.x = x;
/* 1862 */       this.y = y;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum AVATAR_TYPE {
/* 1867 */     NODE(0), R_HAND_WEAPON(1), R_HAND_BUFF(2), L_HAND_WEAPON(3), L_HAND_BUFF(4), HEAD_EQUIPMENT(5), HEAD_BUFF(6), CHEST_EQUIPMENT(7), CHEST_BUFF(8), REAR_EQUIPMENT(9),
/* 1868 */     REAR_BUFF(10), FOOT_EQUIPMENT(11), FOOT_BUFF(12), TAIL_EQUIPMENT(13), TAIL_BUFF(14), AVATAR_BODY(15), RIDE_EQUIPMENT(16);
/*      */     
/*      */     public final int value;
/*      */ 
/*      */     
/*      */     AVATAR_TYPE(int value) {
/* 1874 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum DungeonType {
/* 1879 */     CAN_INVITE(1), INVITIED(2), REFUSED(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     DungeonType(int value) {
/* 1884 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum HandsUpState
/*      */   {
/* 1890 */     ACCEPT(1), REFUSE(2), WAITING(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     HandsUpState(int value) {
/* 1895 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum OpenRuleType {
/* 1900 */     EVERY_DAY(1), EVERY_WEEK(2);
/*      */     private final int value;
/*      */     
/*      */     OpenRuleType(int value) {
/* 1904 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1908 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum HardModel {
/* 1913 */     NORMAL(1),
/* 1914 */     ELITE(2),
/* 1915 */     HERO(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     HardModel(int value) {
/* 1920 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MESSAGE {
/* 1925 */     MAX_COUNT(50);
/*      */     private final int value;
/*      */     
/*      */     MESSAGE(int value) {
/* 1929 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1933 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum MESSAGE_OPERATE
/*      */   {
/* 1939 */     TYPE_ACCEPT(1), TYPE_REFUSE(2);
/*      */     private final int value;
/*      */     
/*      */     MESSAGE_OPERATE(int value) {
/* 1943 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1947 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SkillType {
/* 1952 */     PASSIVE(0), ACTIVE(1), STRENGTHEN_TALENT(2), NORMAL(3), BATTLE_PASSIVE(4), EFFECT_PASSIVE(5), PET_PASSIVE(6);
/*      */     private final int value;
/*      */     
/*      */     SkillType(int value) {
/* 1956 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1960 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SkillHandleType {
/* 1965 */     ALL(0), CHANGE(1), ADD(2), DELETE(3);
/*      */     private final int value;
/*      */     
/*      */     SkillHandleType(int value) {
/* 1969 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1973 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GOTO_TYPE {
/* 1978 */     SALE_SHOP(1),
/* 1979 */     PICK_ITEM(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     GOTO_TYPE(int value) {
/* 1984 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 1988 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum KickReason {
/* 1993 */     NEW_LOGIN(1),
/* 1994 */     SERVER_SHUT_DOWN(2),
/* 1995 */     LOGIC_ERROR(3),
/* 1996 */     GM_KICK(4);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     KickReason(int value) {
/* 2001 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ConsignmentOrderType {
/* 2006 */     TIME_DES(0), TIME_ASC(1), PRICE_ASC(2), PRICE_DES(3), LEVEL_ASC(4), LEVEL_DES(5);
/*      */     private final int value;
/*      */     
/*      */     ConsignmentOrderType(int value) {
/* 2010 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2014 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum InteractType
/*      */   {
/* 2020 */     FRIEND(1), UNFRIEND(2);
/*      */     private final int value;
/*      */     
/*      */     InteractType(int value) {
/* 2024 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2028 */       return this.value;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public enum FriendMessageType
/*      */   {
/* 2035 */     TYPE_INVITE(1), TYPE_CONCERN(2);
/*      */     private final int value;
/*      */     
/*      */     FriendMessageType(int value) {
/* 2039 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2043 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum OfflineMessageType {
/* 2048 */     SEND_MAIL(1), FRIEND(2), PREPAID(3);
/*      */     private final int value;
/*      */     
/*      */     OfflineMessageType(int value) {
/* 2052 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2056 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum RemoveFriendType {
/* 2061 */     FRIEND(1), FRIEND_MESSAGE(2), FRIEND_APPLY(3), BLACK_LIST(4), FRIEND_RECORD(5), CHOU_REN(6);
/*      */     private final int value;
/*      */     
/*      */     RemoveFriendType(int value) {
/* 2065 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2069 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PlayerStatus {
/* 2074 */     online(1), faraway(2), offline(3);
/*      */     private final int value;
/*      */     
/*      */     PlayerStatus(int value) {
/* 2078 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2082 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ALLY_CHAT_TYPE {
/* 2087 */     NOTIFY(1), LEAVE_WORD(2), SYS(3);
/*      */     ALLY_CHAT_TYPE(int value) {
/* 2089 */       this.vaule = value;
/*      */     }
/*      */     
/*      */     private final int vaule;
/*      */     
/*      */     public int getVaule() {
/* 2095 */       return this.vaule;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum VitalityID {
/* 2100 */     ALLY_FIGHT(3), ARENA(4);
/*      */     VitalityID(int value) {
/* 2102 */       this.vaule = value;
/*      */     }
/*      */     
/*      */     private final int vaule;
/*      */     
/*      */     public int getVaule() {
/* 2108 */       return this.vaule;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ALLY_FIGHT_PUSH_TYPE {
/* 2113 */     JOIN(1),
/* 2114 */     ENTER(2);
/*      */     ALLY_FIGHT_PUSH_TYPE(int value) {
/* 2116 */       this.vaule = value;
/*      */     }
/*      */     
/*      */     private final int vaule;
/*      */     
/*      */     public int getVaule() {
/* 2122 */       return this.vaule;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum RecommendPlayFunType {
/* 2127 */     DUNGEON(1), GUILD_DUNGEON(4), SOUL_DAILY_TASK(7), SOLO(13);
/*      */     RecommendPlayFunType(int value) {
/* 2129 */       this.vaule = value;
/*      */     }
/*      */     
/*      */     private final int vaule;
/*      */     
/*      */     public int getVaule() {
/* 2135 */       return this.vaule;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GuildBuilding {
/* 2140 */     GUILD(1),
/* 2141 */     BLESS(2),
/* 2142 */     DEPOT(3),
/* 2143 */     COPY(4),
/* 2144 */     TECH(5); private final int value;
/*      */     
/*      */     GuildBuilding(int value) {
/* 2147 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/* 2153 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GuildMode {
/* 2158 */     AUTO_MODE(1), CHECK_MODE(2); private final int value;
/*      */     
/*      */     GuildMode(int value) {
/* 2161 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/* 2167 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GuildJob {
/* 2172 */     PRESIDENT(1), VICE_PRESIDENT(2), ELDER(3), ELITE(4), MEMBER(5); private final int value;
/*      */     
/*      */     GuildJob(int value) {
/* 2175 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/* 2181 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum LuckyDrawType {
/* 2186 */     EXCELLENT_ITEM(1), NORMAL_ITEM(2), BUFF_ITEM(3), RECOMMEND_ITEM(4), VIEW_ITEM(5);
/*      */     LuckyDrawType(int value) {
/* 2188 */       this.value = value;
/*      */     }
/*      */     
/*      */     private final int value;
/*      */     
/*      */     public int getValue() {
/* 2194 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ActivityRewardType {
/* 2199 */     FIRST_PAY(1), SECOND_PAY(2),
/*      */ 
/*      */ 
/*      */     
/* 2203 */     TOTAL_PAY(3), TOTAL_CONSUME(4), LEVEL(5), FIGHT_POEWR(6), FOUNDATION(7), INVITE_FRIEND(8), INVITE_CODE(9), GAME_NOTICE(10), LUCKY_REWARD(13), OPEN_SEVEN_DAY(14), HAOLI_CHANGE(15), SIGN(16), ONLINE_GIFT(17), LUCK_DRAW(18), SUPER_PACKAGE(19), RECOVERY(20), DAILY_RECHARGE(21),
/*      */ 
/*      */ 
/*      */     
/* 2207 */     SINGLE_RECHARGE(23), SPRING_DRAW(25),
/*      */ 
/*      */ 
/*      */     
/* 2211 */     REVELRY_RECHARGE(26);
/*      */     ActivityRewardType(int value) {
/* 2213 */       this.value = value;
/*      */     }
/*      */     
/*      */     private final int value;
/*      */     
/*      */     public int getValue() {
/* 2219 */       return this.value;
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
/*      */   public enum HAOLI_CHANGE_STATE
/*      */   {
/* 2233 */     CANNOT_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2);
/*      */     HAOLI_CHANGE_STATE(int value) {
/* 2235 */       this.value = value;
/*      */     }
/*      */     
/*      */     private final int value;
/*      */     
/*      */     public int getValue() {
/* 2241 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum NotifyType
/*      */   {
/* 2247 */     GUILD_REFRESH(0),
/* 2248 */     GUILD_PUSH_START(1),
/* 2249 */     GUILD_JOIN_PUSH(1),
/* 2250 */     GUILD_EXIT_PUSH(2),
/* 2251 */     GUILD_JOB_CHANGE(3),
/* 2252 */     GUILD_CHANGE_NAME(4),
/*      */     
/* 2254 */     DEPOT_PUSH_START(10),
/* 2255 */     DEPOT_DEPOSIT_PUSH(10),
/* 2256 */     DEPOT_REMOVE_PUSH(11),
/* 2257 */     DEPOT_UPGRADE_PUSH(12),
/* 2258 */     DEPOT_CONDITION_PUSH(13),
/*      */     
/* 2260 */     BLESS_PUSH_START(20),
/* 2261 */     BLESS_FINISH_PUSH(20),
/* 2262 */     BLESS_NEW_DAY_PUSH(21),
/*      */     
/* 2264 */     SHOP_PUSH_START(30),
/* 2265 */     SHOP_NEW_DAY_PUSH(30),
/*      */     
/* 2267 */     TECH_PUSH_START(40),
/* 2268 */     TECH_NEW_DAY_PUSH(40),
/* 2269 */     TECH_LEVEL_PUSH(41),
/* 2270 */     TECH_BUFF_LEVEL_PUSH(42),
/* 2271 */     GUILD_DUNGEON_OPEN(43),
/* 2272 */     GUILD_DUNGEON_PASS(44), GUILD_DUNGEON_PLAYER_NUM(45), GUILD_DUNGEON_OPEN_CHAT(46); public final int value;
/*      */     
/*      */     NotifyType(int value) {
/* 2275 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/* 2281 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum VitalityType {
/* 2286 */     EXP_FARM(1),
/* 2287 */     SOLO(2),
/* 2288 */     ALLY_FIGHT(3),
/* 2289 */     ARENA(4),
/* 2290 */     GUILD_DUNGEON(5),
/* 2291 */     TEAM_DUNGEON(6),
/* 2292 */     WORLD_BOSS(7),
/* 2293 */     VIP_BOSS(8),
/* 2294 */     DAILY_TASK(9),
/* 2295 */     HORSE_DUNGEON(10),
/* 2296 */     WING_DUNGEON(11),
/* 2297 */     EQUIP_STRENGTHEN(12),
/* 2298 */     FILL_GEM(13),
/* 2299 */     EQUIP_ENCHANT(14);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     VitalityType(int value) {
/* 2304 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum DailyType
/*      */   {
/* 2310 */     DEFAULT(0), DEMON_TOWER(1),
/* 2311 */     ILLUSION(2),
/* 2312 */     DUNGEON(3),
/* 2313 */     DAILY_TASK(4),
/* 2314 */     LOOP_TASK(5),
/* 2315 */     WORLD_LEVEL(6),
/* 2316 */     SOLO(7),
/* 2317 */     ARENA(8),
/* 2318 */     PVP_5V5(9),
/* 2319 */     RESOURCE_CHALLENGE(10),
/* 2320 */     RESOURCE_WATCH_PET(11),
/* 2321 */     RESOURCE_FARM(12),
/* 2322 */     ILLSION_BOSS(13),
/*      */     
/* 2324 */     ILLUSION2(14),
/*      */     
/* 2326 */     RED_PACKET(15),
/*      */     
/* 2328 */     DAILY_MAX(99999);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     DailyType(int value) {
/* 2333 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum GuildRecord {
/* 2338 */     JOIN(1),
/* 2339 */     EXIT(2),
/* 2340 */     KICK(3),
/* 2341 */     UPGRADE(4),
/* 2342 */     JOB(5),
/* 2343 */     OFFICE_NAME(6),
/* 2344 */     IMPEACH(7),
/* 2345 */     IMPEACH_TIMEOUT(8),
/* 2346 */     TRANSFER_IMPEACH_BECOME_INVALID(9),
/* 2347 */     ONLINE_IMPEACH_BECOME_INVALID(9),
/* 2348 */     DEPOSIT_EQUIP(10),
/* 2349 */     TAKE_OUT_EQUIP(11),
/* 2350 */     DELETE_EQUIP(12),
/* 2351 */     BLESS_USE_ITEM(13),
/* 2352 */     UPGRADE_BUILDING(14),
/* 2353 */     GUILD_NAME(15),
/* 2354 */     OPEN_GUILD_DUNGEON(16),
/* 2355 */     GUILD_DUNGEON_PASS(17),
/* 2356 */     TRANSFER_PRESIDENT(18),
/* 2357 */     CREATE_GUILD(19),
/*      */     
/* 2359 */     MAX(99999); public final int value;
/*      */     
/*      */     GuildRecord(int value) {
/* 2362 */       this.value = value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/* 2368 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ACTIVITY_CENTER_TYPE {
/* 2373 */     LEVEL_GIFT(5), INVITE_CODE(9), NOTICE(10);
/*      */     ACTIVITY_CENTER_TYPE(int value) {
/* 2375 */       this.value = value;
/*      */     }
/*      */     
/*      */     public final int value;
/*      */     
/*      */     public int getValue() {
/* 2381 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PrepaidType
/*      */   {
/* 2387 */     PREPAID_REQUEST(1), WP_PREPAID_REQUEST(2);
/*      */     PrepaidType(int value) {
/* 2389 */       this.value = value;
/*      */     }
/*      */     
/*      */     private final int value;
/*      */     
/*      */     public int getValue() {
/* 2395 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PlayerBtlData {
/* 2400 */     MaxHP(1, "生命"), HPPer(2, "生命%"), Attack(3, "攻击"), AttackPer(4, "攻击%"), Phy(5, "物攻"), PhyPer(6, "物攻%"), Mag(7, "魔攻"), MagPer(8, "魔攻%"), Hit(9, "命中"), HitPer(10, "命中%"), HitRate(11, "命中率"), Dodge(12, "闪避"), DodgePer(13, "闪避%"), DodgeRate(14, "闪避率"), Crit(15, "暴击"), CritPer(16, "暴击%"), CritRate(17, "暴击率"), ResCrit(18, "抗暴"), ResCritPer(19, "抗暴%"), ResCritRate(20, "抗暴率"), CritDamage(21, "暴击伤害%"), CritDamageRes(22, "暴伤抵御%"), Def(23, "防御"), DefPer(24, "防御%"), Ac(25, "物防"), AcPer(26, "物防%"),
/* 2401 */     PhyDamageReduce(27, "受到物伤减少%"), Resist(28, "魔防"), ResistPer(29, "魔防%"), MagicDamageReduce(30, "受到魔伤减少%"), IgnoreAc(31, "无视敌人物防"), IgnoreResist(32, "无视敌人魔防"), IgnoreAcPer(33, "无视敌人物防%"), IgnoreResistPer(34, "无视敌人魔防%"), IncAllDamage(35, "所有伤害增加%"), AllDamageReduce(36, "受到伤害减免%"), HitLeechHP(37, "命中回复生命"), CtrlTimeReduce(38, "被控时间减少%"), SkillCD(39, "技能冷却减少%"), HPRegen(40, "生命恢复"), ExdGold(41, "银两掉落"), ExdExp(42, "杀怪经验"), HPRecover(43, "恢复生命"),
/* 2402 */     HPRecoverPer(44, "恢复生命%"), HealEffect(45, "治疗效果"), HealedEffect(46, "被治疗效果"), RunSpeed(47, "移动速度"), Stun(48, "眩晕成功率"), Freeze(49, "冻结成功率"), Silence(50, "禁魔成功率"), Durance(51, "禁锢成功率"), Taunt(52, "嘲讽成功率"), SlowDown(53, "减速成功率"), ResStun(54, "眩晕抵抗"), ResFreeze(55, "冻结抵抗"), ResSilence(56, "禁魔抵抗"), ResDurance(57, "禁锢抵抗"), ResTaunt(58, "嘲讽抵抗"), ResSlowDown(59, "减速抵抗"), AllCtrl(60, "控制成功率"), AllResCtrl(61, "控制抵抗"), SkillDamage(62, "技能加成%"), HateRatio(63, "仇恨值"); public final int id;
/*      */     
/*      */     PlayerBtlData(int id, String chName) {
/* 2405 */       this.id = id;
/* 2406 */       this.chName = chName;
/*      */     }
/*      */ 
/*      */     
/*      */     public final String chName;
/*      */     
/*      */     public static PlayerBtlData getE(String chName) {
/* 2413 */       for (PlayerBtlData pd : values()) {
/* 2414 */         if (pd.chName.equals(chName))
/* 2415 */           return pd; 
/*      */       } 
/* 2417 */       return null;
/*      */     }
/*      */     
/*      */     public static PlayerBtlData getE(int id) {
/* 2421 */       for (PlayerBtlData pd : values()) {
/* 2422 */         if (pd.id == id)
/* 2423 */           return pd; 
/*      */       } 
/* 2425 */       return null;
/*      */     }
/*      */     
/*      */     public static PlayerBtlData getEByKey(String key) {
/* 2429 */       for (PlayerBtlData pd : values()) {
/* 2430 */         if (pd.name().equals(key))
/* 2431 */           return pd; 
/*      */       } 
/* 2433 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum DaoYou {
/* 2438 */     DaoYouNameMaxLength(7), DaoYouNameMinLength(1), DaoYouKickDaoYouMail(20215), DaoYouLeaveMessageMaxLength(20), DaoYouNoticeMaxLength(20), DaoYouEditNameInterval(7), DaoYouRebateMail(20214), DaoYouMessageTypeSystem(1), DaoYouMessageTypeLeave(2);
/*      */     private final int value;
/*      */     
/*      */     DaoYou(int value) {
/* 2442 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2446 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum TimeState {
/* 2451 */     TIME_NOT_UP(0), TIME_UP(1), TIME_OVER(2);
/*      */     
/*      */     private final int value;
/*      */     
/*      */     TimeState(int value) {
/* 2456 */       this.value = value;
/*      */     }
/*      */     
/*      */     public int getValue() {
/* 2460 */       return this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum VipType {
/* 2465 */     none(0), month(1), forever(2), sb_double(3);
/*      */     public final int value;
/*      */     
/*      */     VipType(int value) {
/* 2469 */       this.value = value;
/*      */     }
/*      */     
/*      */     public static VipType getE(int value) {
/* 2473 */       for (VipType vt : values()) {
/* 2474 */         if (vt.value == value)
/* 2475 */           return vt; 
/*      */       } 
/* 2477 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum Five2Five {
/* 2482 */     five2five_choice_giveup(1), five2five_choice_ready(2), five2five_choice_type_agree(1), five2five_choice_type_ready(2), five2five_thread_delay_time(3000);
/*      */     public final int value;
/*      */     
/*      */     Five2Five(int value) {
/* 2486 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum PlayerEventType {
/* 2491 */     UPGRADE,
/* 2492 */     CLASS_UPGRADE,
/* 2493 */     EQUIPMENT_CHANGE, REFRESH_NEWDAY, AFTER_LOGIN,
/* 2494 */     OFFLINE, PET_CHANGE,
/* 2495 */     PET_PROP_CHANGE,
/* 2496 */     GUILD_BLESS_CHANGE,
/* 2497 */     GUILD_TECH_CHANGE,
/* 2498 */     TITLE_CHANGE,
/* 2499 */     PAY,
/* 2500 */     FASHION_CHANGE,
/* 2501 */     UPGRADE_TALENT_PASSIVE_SKILL,
/* 2502 */     ARMOUR_ACTIVE,
/* 2503 */     EXCHANGE_PROPARTY,
/* 2504 */     BLOOD;
/*      */   }
/*      */   
/*      */   public enum ManagerType {
/* 2508 */     BASE_DATA, BTL_DATA, SKILL, SKILL_KEY, MOUNT, PET, VIP, MAIL, PREPAID, FIST_PAY, FIVE_2_FIVE, MONSTER_DROP, GUILD_BOSS, AUCTION, FARM, ACTIVITY, FASHION, BLOOD, GUILD_FORT, RICH, SEVEN_GOAL;
/*      */   }
/*      */   
/*      */   public enum Arena {
/* 2512 */     ARENA_GREEDY(1033),
/* 2513 */     ARENA_TIANSHEN(1031),
/* 2514 */     FIGHT_POWER_UP(510023);
/*      */     public int value;
/*      */     
/*      */     Arena(int value) {
/* 2518 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum AffixType
/*      */   {
/* 2524 */     normal(0),
/* 2525 */     legend(1);
/*      */     
/*      */     public int value;
/*      */     
/*      */     AffixType(int value) {
/* 2530 */       this.value = value;
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
/*      */   public enum DungeonHardModel
/*      */   {
/* 2543 */     Normal(1, "简单", "00d0ff"), NightMare(2, "普通", "ffae00"), Hell(3, "困难", "ed2a0a");
/*      */     public String color;
/*      */     public String desc;
/*      */     public int value;
/*      */     
/*      */     DungeonHardModel(int value, String desc, String color) {
/* 2549 */       this.value = value;
/* 2550 */       this.desc = desc;
/* 2551 */       this.color = color;
/*      */     }
/*      */     
/*      */     public static DungeonHardModel getE(int value) {
/* 2555 */       for (DungeonHardModel dhm : values()) {
/* 2556 */         if (dhm.value == value)
/* 2557 */           return dhm; 
/*      */       } 
/* 2559 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum BiLogType
/*      */   {
/* 2565 */     Smelt("熔炼"), Sale("出售"), Gold("银两"), Gold_Total("银两_总变更"), Cash("绑元"), Cash_Total("绑元_总变更"), Diamond("元宝"), Diamond_Total("元宝_总变更"), Exp("经验"), Exp_Total("经验_总变更"), FightPower("战力"), FightPower_Total("战力_总变更"), Consignment("寄卖"), Consignment_Total("寄卖_总变更"), Regist("注册"), Gift("礼包"), Gift_Total("礼包_总变更"), Pk("PK"), Charge("充值"), Charge_First("充值_首充"), Mail("邮件"), DiamondChange("元宝详细"), CashChange("绑元详细");
/*      */     
/*      */     public String desc;
/*      */     
/*      */     BiLogType(String desc) {
/* 2570 */       this.desc = desc;
/*      */     }
/*      */     
/*      */     public static BiLogType get(String key) {
/* 2574 */       for (BiLogType blt : values()) {
/* 2575 */         if (blt.name().equals(key)) {
/* 2576 */           return blt;
/*      */         }
/*      */       } 
/* 2579 */       return null;
/*      */     }
/*      */   }
/*      */   
/* 2583 */   public static String raffletickets = "raffletickets";
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\Const.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */