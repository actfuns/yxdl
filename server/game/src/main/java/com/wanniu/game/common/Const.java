package com.wanniu.game.common;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;

import java.util.List;


public class Const {
    public static final int LOOP_TASK_ROUND_COUNT = 5;
    public static final long LOOP_TASK_ROBOT_WAIT_LEAVE_TIME = 300000L;
    public static final int LOOP_TASK_TEAM_MEMBER_COUNT = 3;
    public static final int LOOP_LEADER_ADD = 10;
    public static final int DAILY_TASK_ROUND_COUNT = 10;
    public static final int DAILY_TASK_DAY_COUNT = 20;
    public static final int LOOP_DUNGEON_REVIVE_TIME = 5;
    public static final int LOOP_SPECIAL_AREA_ID = 8888;
    public static final long RESOURCE_COUNTDOWN = 300000L;
    public static final int RELIVE_DIAMOND = 5;
    public static final int RELIVE_NUM = 3;
    public static final int FB_PRODUCE_COUNT = 3;
    public static final int AUTO_PICKUP_LIMIT = 50;
    public static final int REFRSH_NEW_DAY_TIME = 5;
    public static final int FASHION_FOREVER = -1;
    public static final int DAY_BY_MILLISECOND = 86400000;

    public static class NUMBER_MAX {
        public static final long INT_BIG = 9223372036854775807L;
        public static final int INT = 2147483647;
        public static final short INT_SMALL = 32767;
        public static final int SAME_SCREEN_NUM = 30;
        public static final int GUILD_FINISHED_MAX = 3;
    }

    public static class CODE {
        public static final int OK = 200;
        public static final int FAIL = 500;
        public static final int KICK = 400;
    }

    public enum SUPERSCRIPT_TYPE {
        MAIL(100),
        ACTIVITY_CENTER(300),
        FLAG_ACTIVITY_ACIVITY(301),
        FLAG_ACTIVITY_BOSS(302),
        FLAG_ACTIVITY_FATE(303),
        MASTERY_ACTIVE(400),
        MASTERY_RING(401),
        SHOPMALL(500),
        ATTRIBUTE(600),
        GUILD(800),
        GUILD_PRAY(801),
        GUILD_BOSS(802),
        GUILD_BOSS2(803),
        GUILDFORT_INBID(804),
        GUILDFORT_INBATTLE(805),
        GUILDFORT_INAWARD(806),
        GUILD_AUCTION(810),
        WORLD_AUCTION(811),
        ALLY(900),
        ALLY_BLESS(901),
        ALLY_REBATE(902),
        JJC_ENTER(1000),
        JJC_REWARD(1001),
        SOLO(1100),
        SOLO_REWARD(1102),
        MEDAL(1200),
        MOUNT(1300),
        ALLY_FIGHT(1400),
        VIP(1500), WING(1600),
        SKILL(1700),
        CROSS_SERVER(1800),
        PET(1900),
        DUNGEON(2000),
        DUNGEON_NORMAL(2001),
        DUNGEON_ELITE(2002),
        DUNGEON_HERO(2003),
        VITALITY(2100),

        FIRSTPAY_GIFT(2300),
        DAILYPAY_GIFT(2400),
        EQUIP_LEVEL_UP(2500),
        EQUIP_COLOR_UP(2600),
        BOSS_HOME(2800),
        WORLD_LEVEL(2900),
        TREASURE(3000),
        FLAG_OFFLINE(3100),

        FLAG_WELFARE(3200),
        FLAG_WELFARE_SIGN(3201),
        FLAG_WELFARE_ONLINE_GIFT(3202),
        FLAG_WELFARE_ROLE_LV_GIFT(3203),
        FLAG_WELFARE_ROLE_FC_GIFT(3204),
        FLAG_WELFARE_EXCHANGE(3205),
        OPEN_SERVER_DAY(3206),
        TOTAL_CONSUME(3207),
        TOTAL_PAY(3208),
        FUNDS(3209),
        GAME_NOTICE(3210),
        LUCKY_DRAW(3211),
        SUPER_PACKAGE(3212),
        RECOVERY(3213),
        DAILY_RECHARGE(3214),
        SPRING_DRAW(3215),
        SINGLE_RECHARGE(3216),
        REVELRY_RECHARGE(3217),

        CONTINUOUS_RECHARGE(3251),
        RICH(3252),
        SEVEN_GOAL(3253),

        FIVE_2_FIVE_REWARD(3300),
        FIVE_2_FIVE(3301),
        GROWUP_TARGET(3400),
        GROWUP_TARGET_1(3401),
        GROWUP_TARGET_2(3402),
        GROWUP_TARGET_3(3403), GROWUP_TARGET_4(3404), GROWUP_TARGET_5(3405), GROWUP_TARGET_6(3406), GROWUP_TARGET_7(3407), GROWUP_TARGET_8(3408), GROWUP_TARGET_9(3409), GROWUP_TARGET_10(3410), GROWUP_TOTAL(3499),
        WORKING(3500),
        REBORN(3501),

        REBUILD(3503),
        MAKE(3504),
        KAIGUANG(3505),
        UPLEVEL(3506),


        EQUIP_STRENGTH(3601),
        EQUIP_FILL_GEM(3602),
        EQUIP_EQUIP(3603),
        FLAG_FASHION(3604),
        INTERGAL_MALL(3700),
        DEMON_INVADE_ACTIVED(4001),
        FIVE_MOUNTAIN_ACTIVED(4002),
        SOLO_ACTIVED(4003),
        TRIAL_ACTIVIED(4004),
        ILLUSION2(4005),

        FARM_CULTIVATE(5001),
        FARM_FRIEND(5002),

        ACTIVITY_REVELRY(6001),

        LIMIT_TIME_GIFT(7001),

        MIN(0);
        private final int value;

        SUPERSCRIPT_TYPE(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }

        public static SUPERSCRIPT_TYPE getType(int value) {
            for (SUPERSCRIPT_TYPE superscript_type : values()) {
                if (superscript_type.value == value) {
                    return superscript_type;
                }
            }
            return null;
        }
    }

    public static class PLAYER {
        public static final int initLevel = 1;
        public static final int initExp = 0;
        public static final int initSp = 5000;
        public static final int initGold = 0;
        public static final int initTicket = 0;
        public static final int initPrimaryDiamond = 0;
        public static final int initDiamond = 0;
        public static final int initEnergy = 1000;
        public static final int initFriendly = 0;
        public static final int initSolopoint = 0;
        public static final int initVip = 0;
        public static final int initHp = 999999;
        public static final int initMp = 999999;
        public static final int initPrestige = 0;
        public static final int initCharm = 100;
        public static final float initSpeed = 5.6F;
        public static final int maxNum = 5;
    }

    public enum FUNCTION_GOTO_TYPE {
        PREPAID(1),
        CONSIGNMENT(2),
        DIAMONDSHOP(6),
        JIANDINGSHOP(7),
        MATERIAL(8),
        LOUD_NOT_ENOUGH(9),
        TICKET_NOT_ENOUGH(10),
        REWARDPK_NOT_ENOUGH(11), XUESHI_NOT_ENOUGH(13), PICK_ITEM(14),
        TREASURE_NOT_ENOUGH(19),
        ACHIEVEMENT_GOLD_NOT_ENOUGH(22),
        SUMMON_ITEM_NOT_ENOUGH(23);

        private final int value;

        FUNCTION_GOTO_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum TRANSPORT_CONDITION {
        NOTHING(0), ACCEPT_TASK(1), FINISH_TASK(2), HAS_ITEM(3), CONSUME_ITEM(4);

        public final int value;

        TRANSPORT_CONDITION(int value) {
            this.value = value;
        }
    }

    public enum BORN_TYPE {
        HISTORY(0), NORMAL(1), BORN(2);

        public final int value;

        BORN_TYPE(int value) {
            this.value = value;
        }
    }

    public enum ENTER_STATE {
        changeArea(1),
        online(2);

        public final int value;

        ENTER_STATE(int value) {
            this.value = value;
        }
    }

    public enum PlayerDataType {
        POSITION(1);
        public final int value;

        PlayerDataType(int value) {
            this.value = value;
        }
    }


    public enum EventType {
        killMonster(1), interActiveNpc(2), interActiveItem(3), collect(4), escort(5), guard(6), killBossCount(72), consumeItem(10007), changeSceneProgress(10008), changeArea(10009), summonMount(10010), rebirth(10011), addUnit(10012),
        loopTransform(10013), hurtRank(10014), hurtRank_sort(10015), statics_ranks(10016), over_statics_ranks(10017);

        private final int value;

        EventType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum TaskState {
        COMPLETED(2), COMPLETED_NOT_DELIVERY(1), NOT_COMPLETED(0), NOT_START(-1), DELETE(-2), FIAL(-3);

        private final int value;

        TaskState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public static class TaskKind {
        public static final int MAIN = 0;

        public static final int BRANCH = 1;

        public static final int DAILY = 2;

        public static final int LOOP = 3;

        public static final int TREASURE = 8;
    }

    public enum TaskType {
        KILL_MONSTER(1),
        INTERACT_NPC(2),
        interActiveItem(3),
        collect(4),
        escort(5),
        guard(6),
        reachPos(7),
        GET_RIDESKIN(8),
        TRAIN_RIDE(9),
        TRAIN_EQUIP(10),
        FILL_GEM(11),
        FINISH_CLONESCENE(12),
        SINCOM(13),
        EQUIP_INHERIT(14),
        FISH(15),
        KILL_PLAYER(16),
        COMBINE_GEM(17),
        TRAIN_WING(18),
        GET_ITEM(19),
        DISCARD_ITEM(20),
        GET_RING(21),
        GET_WING(22),
        ADD_GUILD(23),
        GUILD_DONATE(24),
        GOT(25),
        FIENDS(26),
        STEAL(27),
        CHAIN_SOUL(28),
        GRAD_PET(29),
        TREASURE_HUNT(30),
        GETMEDAL(31),
        LEVEL_UP(32),
        OPEN_SONSIGMENT(33),
        SKILL_UP(34),
        ADD_FRIEND(35),
        CONCERN_FRIEND(36),
        EXCHANGE_FRIEND_REWARD(37),
        JOIN_LEAGUE(38),
        JOIN_LEAGUE_WAR(39),
        GUILD_TECH_UP(40),
        GUILD_CONTRIBUTE(41),
        GUILD_PRAY(42),
        JOIN_GUILD_INSTANCE(43),
        EQUIP_MELT(44),
        JOAN_ARENA(45),
        FRIEND_NUM(46),
        PET_TRAIN(47),
        USERUP_LEVEL(48),
        ENCHANT_EQUIP(49),
        EARN_NECK(50),
        JOIN_SOLO(51),
        FINISH_DAILY_TASK(52),
        FUNC_DESK(53),
        TAKE_EQUIP_Qt(54),
        MOUNT_UPLEVEL(55),
        WING_UPLEVEL(56),
        JOIN_DAOYOU(57),
        EQUIP_REBORN(58),
        EQUIP_REBUILD(59),
        EQUIP_REFINE(60),
        ROLE_UPGRADE(61),
        EQUIP_MAKE(62),
        TRAIN_EQUIP_ALL(63),

        FINISH_LOOP_TASK(65),
        ACCEPT_DAILY_LOOP(66),
        ACTIVITY_NUM(67),
        ACCEPT_DAILY(68),

        FIND_TREASURE(70),
        FINISH_DUNGEONS_COUNT(71),
        KILL_BOSS_COUNT(72);

        private final int value;

        TaskType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum TipsType {
        NORMAL(0),
        BLACK(1),
        LEFTDWON(2),
        NO_BG(3),
        ROLL(4),
        NEWTYPE(5),
        BOTTOM(6);

        private final int value;

        TipsType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum Profession {
        all(0), canglang(1), yujian(2), yixian(3), shenjian(4), linghu(5);

        private final int value;

        Profession(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailType {
        MAIL_PLAYER_TYPE(1), MAIL_SYSTEM_TYPE(2), MAIL_GM_TYPE(3);

        private final int value;

        MailType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailSysParam {
        MAIL_TIME_LIMIT_1(30000000), MAIL_TIME_LIMIT_2(70000000), MAIL_MAX_NUM(100), MAIL_MAX_WORD(2000);

        private final int value;

        MailSysParam(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailReadDeal {
        MAIL_READ_NULL(1), MAIL_READ_DEL(2);

        private final int value;

        MailReadDeal(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailState {
        MAIL_STATE_NULL(1), MAIL_STATE_READ(2), MAIL_STATE_ATTACH_RECEIVE(3);

        private final int value;

        MailState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailAttach {
        MAIL_ATTACH_NULL(1), MAIL_ATTACH_CARRY(2);

        private final int value;

        MailAttach(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MailStaus {
        MAIL_UNREAD(0), MAIL_UNRECEIVE(1);

        private final int value;

        MailStaus(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public static class MailAttachments {
        public List<String> mailIds;


        public int code;
    }


    public enum MESSAGE_TYPE {
        mail_receive(1), team_invite(2), team_apply(3), friend_invite(4), daoyou_invite(7), guild_apply(8),
        guild_invite(9),
        daily_task_times(10),
        loop_task_addfriend(11),
        loop_task_member_leave(12),
        loop_task_times(13),
        upLevel_up(14),
        redpacket(17),


        consignment_publish(200);

        private final int value;

        MESSAGE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum AreaForce {
        MONSTER(1), FORCEA(2), FORCEB(3);

        public final int value;

        AreaForce(int value) {
            this.value = value;
        }
    }

    public enum AreaCamp {
        Neutral(1), RongYao(2), TieXue(3);

        public final int value;

        AreaCamp(int value) {
            this.value = value;
        }
    }

    public enum FightLevelCond {
        TIME(1), REBORNTIME(2), KILL_MONSTER_NUM(3), GUARD_NPC_HP_PRE(4), GUARD_NPC_NUM(5), COLLECTION_ITEM_NUM(6);

        public final int value;

        FightLevelCond(int value) {
            this.value = value;
        }
    }

    public enum FightLevelCondModel {
        MORE(1), LESS(2);

        public final int value;

        FightLevelCondModel(int value) {
            this.value = value;
        }
    }


    public enum SCENE_TYPE {
        NORMAL(1),

        FIGHT_LEVEL(2),

        SIN_COM(3), ARENA(4), CROSS_SERVER(5), ALLY_FIGHT(6),
        GUILD_DUNGEON(7), WORLD_BOSS(8),

        ILLUSION(9),

        FIVE2FIVE(10),

        DEMON_TOWER(11), RESOURCE_DUNGEON(12),
        LOOP(13),
        GUILD_BOSS(14),
        ILLUSION_2(15),
        FIGHT_LEVEL_ULTRA(16),
        GUILD_FORT_PVE(17),
        GUILD_FORT_PVP(18);

        private final int value;


        SCENE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EquipPos {
        BODY(1), BAG(2);

        public final int value;

        EquipPos(int value) {
            this.value = value;
        }
    }

    public enum ACHIEVEMENT_TYPE {
        ACHIEVEMENT_TYPE_ALL(1), ACHIEVEMENT_TYPE_MAIN(2), ACHIEVEMENT_TYPE_SUB(3), ACHIEVEMENT_TYPE_ELEMENT(4);
        public final int value;

        ACHIEVEMENT_TYPE(int value) {
            this.value = value;
        }
    }

    public enum ACHIEVEMENT_AWARD_TYPE {
        ACHIEVEMENT_AWARD_TYPE_ITEM(1), ACHIEVEMENT_AWARD_TYPE_TITLE(2);
        public final int value;

        ACHIEVEMENT_AWARD_TYPE(int value) {
            this.value = value;
        }
    }

    public enum ACHIEVEMENT_CONDITION_TYPE {
        DEFAULT(-1), PLAYER_LEVEL(1), PLAYER_RANK(2), PLAYER_POWER_POINT(3), KILL_NPC(4), EQUIPMENT_ENHANCE(5), PLACE_ARRIVED(6), FINISH_TASK(7), FINISH_TASK_NUM(8),
        FINISH_DAILY_TASK(12), GET_GOLD(13), GET_DIAMOND_IN_CONSIGNMENT(15), GET_MAGIC_RING(18), GET_MEDAL(19), GET_NECKLACE(20), GET_EQUIPMENT(21), EQUIPMENT_ENCHANT(25), GET_PET(26), GET_QUALITY_PET(27), PET_LEVEL(28), PET_UPGRADE_LEVEL(29), PET_TRANSFORM_LEVEL(30), RIDE_DEVELOPMENT(31), WING_LEVEL(32), GEM_COMBINE(33),

        FISH_ITEM(35), SKILL_LEVEL(36), DUNGEON_PASSED(37), SOLO_WIN(38), SOLO_RANK(39), ARENA_RANK(41), ARENA_KILL_PLAYER(42), ARENA_SCORE(43), ALLY_GOLD(44), ALLY_KILL_PLAYER(45), FRIENDS_NUM(51), RANK(52),

        ILLUSION_TIME(101),
        KILL_BOSS(102),
        PASS_DEMONTOWER(103),
        WORLD_SPEAK_TIME(104),
        GEM_FILL_TOTAL_LEVEL(105),
        EQUIP_POS_LEVEL(106),
        EQUIP_MAKE_TIMES(107),
        EQUIP_REBORN_TIMES(108),
        EQUIP_REFINE_TIMES(109),
        EQUIP_REBUILD_TIMES(110),
        FIVE_VS_FIVE_TIMES(111),
        AREANA_TIMES(112),
        SOLO_TIMES(113),
        DEMONTOWER_TIMES(114),
        WORLD_LEVEL_TIMES(115),
        MOUNT_COUNT(116),
        XIANYUAN_COUNT(117),
        FINISH_LOOP_TASK(118);

        public final int value;


        ACHIEVEMENT_CONDITION_TYPE(int value) {
            this.value = value;
        }
    }

    public enum ACHIEVEMENT_QUALITY_TYPE {
        WHITE(0), GREEN(1), BLUE(2), PURPLE(3), ORANGE(4), RED(5);
        public final int value;

        ACHIEVEMENT_QUALITY_TYPE(int value) {
            this.value = value;
        }
    }

    public enum BAG_TYPE {
        BAG(1),
        WAREHOUSE(2),
        ACCOUNT_WAREHOUSE(3),
        RECYCLE(4);

        private int value;

        BAG_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static BAG_TYPE getE(int value) {
            for (BAG_TYPE type : values()) {
                if (type.value == value) {
                    return type;
                }
            }
            return null;
        }
    }


    public static class Bag {
        public static final int BAG_INIT_GRIDCOUNT = 5;

        public static final int BAG_MAX_GRIDCOUNT = 100;

        public static final int BAG_GRID_OPEN_TIME = 60000;
        public static final int BAG_GRID_PACKUP_TIME = 5000;
        public static final int BAG_GRID_GOLD = 100;
    }

    public enum Time {
        Day(86400000), Hour(3600000), Minute(60000), Second(1000);
        private int value;

        Time(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum BindType {
        UN_BIND(0),
        BIND(1),
        EQUIP_BIND(2),
        BIND_AFTER_GET(3),
        EQUIP_BIND_AFTER_GET(4);

        private int value;

        BindType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum ForceType {
        DEFAULT(0),
        BIND(1),
        UN_BIND(2);

        private int value;

        ForceType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static ForceType getE(int value) {
            for (ForceType e : values()) {
                if (value == e.getValue()) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum ITEM_CODE {
        TICKET("cash"), TREASURE_POINT("treasurespoint"), XIAN_YUAN("xianyuan"), Changename("changename"),


        DUNGEONPROFIT("dungeonprofit");

        public String value;

        ITEM_CODE(String value) {
            this.value = value;
        }
    }


    public enum ItemType {
        Weapon(1), Armor(2), Oranament(3), RideEquip(4), Bijou(5), Mate(6), Misc(7), Chest(8), Potion(9), Quest(10), Virtual(11);

        private int value;

        ItemType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static ItemType getE(int value) {
            for (ItemType e : values()) {
                if (value == e.getValue()) {
                    return e;
                }
            }
            return null;
        }

        public static int getV(String s) {
            for (ItemType e : values()) {
                if (e.toString().equals(s)) {
                    return e.getValue();
                }
            }
            throw new RuntimeException("物品类型没找到:" + s);
        }
    }

    public enum ItemSecondType {
        ZHU_SHOU(1, "武器"), TOU_BU(2, "头部"),
        SHANG_YI(3, "上衣"), TUI_BU(4, "腿部"), YAO_BU(5, "肩部"), SHOU_TAO(6, "护腕"), XIE_ZI(7, "鞋子"), XIANG_LIAN(8, "项链"), JIE_ZI(9, "戒指"), HU_SHENG_FU(10, "护身符"), rideSoul(21, "rideSoul", "坐骑装备"), rideShield(22, "rideShield", "坐骑装备"), rideSpirit(23, "rideSpirit", "坐骑装备"), rideHeart(24, "rideHeart", "坐骑装备"), gem(201, "gem", "宝石"), mate(202, "mate", "材料"), rideItem(203, "rideItem", "材料"), petItem(204, "petItem", "材料"), fashionItem(205, "fashionItem", "材料"), chest(301, "chest", "宝箱"), hpot(401, "hpot", "药剂"),
        rank(402, "rank", "称号"), virtQuest(501, "virtQuest", "任务物品"), realQuest(502, "realQuest", "任务物品"), misc(999, "misc", "杂物"), virtual(1000, "virtual", "虚拟物品"), soul(998, "soul", "魂魄");

        private String key;
        private int value;
        String desc;

        ItemSecondType(int value, String key) {
            this.value = value;
            this.key = key;
        }

        ItemSecondType(int value, String key, String desc) {
            this.value = value;
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public static int getV(String s) {
            for (ItemSecondType e : values()) {
                if (e.key.equals(s)) {
                    return e.getValue();
                }
            }
            throw new RuntimeException("未找到的装备类型:" + s);
        }
    }


    public enum EquipType {
        MAIN_HAND(1), HEAD(2), CLOTH(3), LEG(4),
        SHOULDER(5),
        GLOVES(6),
        SHOES(7),
        NECKLACE(8),
        RING(9),
        CHARM(10);

        private int value;

        EquipType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ItemQuality {
        WHITE(0),
        BLUE(1),
        PURPLE(2),
        ORANGE(3),
        GREEN(4),
        RED(5);

        private int value;

        ItemQuality(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static ItemQuality getE(int value) {
            for (ItemQuality e : values()) {
                if (e.value == value) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum GOODS_CHANGE_TYPE {
        random_box(81, "随机宝箱"),


        TX(999, "提现"),
        def(0, "默认"),
        gm(1, "GM命令"),
        shop(9, "商城购买"),
        use(15, "物品使用"),
        mail(18, "邮件"),
        DAOYOU(73, "道友返利"),
        CDK(85, "CDK兑换"),
        ONLINE_GIFT(86, "领取在线奖励"),
        AUTO_MELT(87, "自动熔炼"),
        AUCTION(110, "仙盟竞拍"),
        GMT(111, "GM工具（WEB后台）"),
        REVELRY_EXCHANGE(117, "开服冲榜兑换"),


        AUCTION_BONUS(201, "竞拍分红"),
        AUCTION_RESTITUTION(202, "竞拍失败归还竞价"),
        CHARGE(203, "充值"),
        SUPER_PACKAGE(204, "超值礼包"),
        FIRST_CHARGE(205, "首充奖励"),
        CUMULATIVE_CHARGE(206, "累充奖励"),
        VIPBUY(207, "购买月卡"),
        PAY_REBATE(208, "封测充值返利"),
        RECEIVE_FUNDS(209, "开服基金奖励"),
        REVELRY(210, "开服冲榜奖励"),
        GUILD_BOSS(211, "仙盟BOSS奖励"),

        ACTIVITY_SEVENDAY(212, "福利-开服狂欢"),
        ACTIVITY_TOTAL_PAY(213, "福利-累计充值"),
        ACTIVITY_TOTAL_CONSUME(214, "福利-累计消费"),
        ACTIVITY_LEVEL(215, "福利-等级礼包"),
        ACTIVITY_FIGHT_POEWR(216, "福利-战力礼包"),

        CONSIGNMENT_TIMEOUT(217, "拍卖超时退还"),
        CONSIGNMENT_SELL(218, "拍卖出售"),
        CONSIGNMENT_REMOVE(219, "拍卖下架"),

        DailyRecharge(220, "每日充值"),
        ActivityDraw(221, "活动抽奖"),
        ActivityDrawSpring(222, "新春抽奖"),
        LimitTimeGift(223, "限时礼包"),
        DemonTower(224, "镇妖塔"),
        Fashion(226, "时装"),

        WORLD_LEVEL(227, "世界等级"),
        KILL_PLAYER(228, "击杀玩家"),
        smriti_equip(229, "继承装备"),
        task_submit(230, "提交任务"),
        move(231, "转移物品"),

        guild_store(232, "工会仓库"),
        guild_tech(233, "公会修行"),
        guild_bless(234, "公会祈福"),
        guild_bless_award(235, "公会祈福奖励"),
        guild_donate(236, "公会捐献"),
        guild_mail(237, "仙盟发的邮件"),
        guild_create(238, "创建仙盟"),
        guild_upgrade_bless_level(239, "提升仙盟祝福等级"),
        guild_upgrade_depot_level(240, "提升仙盟存储等级"),
        guild_upgrade_level(241, "提升仙盟等级"),
        guild_buy_tech_product(242, "购买仙盟科技产品"),
        guild_upgrade_tech_level(243, "提升仙盟科技等级"),
        guildfort_daily_award(244, "仙盟据点战日常奖励"),

        resource_dungeon_sweep(250, "资源副本扫荡"),
        recovered(253, "资源找回"),

        equip(254, "穿装备"),
        saveRebuid(255, "保存重铸"),
        saveReborn(256, "保存洗练"),

        resource_dungeon_buy_times(257, "资源副本购买次数"),
        resource_dungeon_award(258, "资源副本领取奖励"),
        resource_dungeon_cost_diamond(259, "资源副本扣除元宝"),

        FUNCTION_OPEN(260, "领取功能开放奖励"),
        relive(261, "复活"),

        intergalmall(262, "积分商城"),
        five2five(263, "5v5"),

        fight_level(264, "副本"),
        RollPoint(265, "roll点"),

        Rebuild(266, "重铸"),
        SeniorRebuild(267, "高级重铸"),
        Reborn(268, "洗练"),
        Refine(269, "精炼"),

        leaderBoard(270, "世界等级膜拜"),

        interact(271, "交互"),

        inherit(272, "继承"),

        openbag(273, "开背包格子"),

        guildchangename(274, "公会改名"),

        chat(275, "聊天"),

        transport(276, "传送"),

        consume(277, "消费"),

        buy(278, "个人商店"),

        skill(279, "升级技能"),

        pet(280, "宠物培养"),
        petChangeName(281, "宠物改名"),
        petCost(282, "使用宠物道具"),

        monsterdrop(283, "怪物掉落"),
        achieve(284, "成就"),

        task(285, "任务"),
        solo(286, "问道"),

        trade(287, "出售"),


        compound(288, "合成"),

        arena(289, "竞技场"),
        sign(290, "签到"),
        exchange(291, "兑换"),
        melt(292, "熔炼"),
        clear_when_logout(293, "出售"),
        fish(294, "钓鱼"),
        hitUser(295, "PK"),
        daily_activity(296, "活跃度礼包"),

        equipMake(297, "装备制作"),
        equipLevelUp(298, "装备升级（等级）"),
        equipColorUp(299, "装备升品（品质）"),
        equipmosaic(300, "装备镶嵌"),
        equipstrengh(301, "装备强化"),
        dailypay_gift(302, "月卡奖励"),

        flee(303, "五岳一战"),
        BOSS_ASSISTS(304, "野外Boss助攻"),

        CombineCompensate(305, "合服补偿"),
        blood(306, "血脉"),
        EXCHANGE_PROPARTY(307, "属性兑换"),
        RedPacket(308, "红包"),
        Rich(309, "大富翁"),
        SevenGoal(310, "七日目标"),
        ContinuousRecharge(311, "连续充值"),
        SingleRecharge(312, "单笔充值"),
        RevelryRecharge(313, "冲榜累充"),


        BUY_FUNDS(401, "购买开服基金"),
        BOSS_GUILD_INSPIRE(402, "仙盟BOSS鼓舞"),
        CONSIGNMENT_ADD(403, "拍卖上架"),
        CONSIGNMENT_BUY(404, "拍卖购买"),
        CONSIGNMENT_PUBLIC(405, "拍卖宣传"),

        FarmChange(1001, "果园兑换"),
        FarmHarvest(1002, "果园收获"),
        FarmOpen(1003, "果园开启地块"),
        FarmSow(1004, "果园播种"),
        FarmSteal(1005, "果园偷取");

        public int value;

        private final String desc;

        GOODS_CHANGE_TYPE(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public int getValue() {
            return this.value;
        }

        public String getDesc() {
            return this.desc;
        }

        public static GOODS_CHANGE_TYPE getE(int value) {
            for (GOODS_CHANGE_TYPE e : values()) {
                if (e.value == value) {
                    return e;
                }
            }
            return null;
        }
    }


    public enum CurrencyType {
        NONE(0),
        DIAMOND(1),
        COIN(2),
        TICKET(3),
        OTHER(4);
        private int value;

        CurrencyType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SYS_SET {
        OFF(0), ON(1);

        private int value;

        SYS_SET(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum FunctionType {
        MAINLIND("Mainline"),
        BRANCH("Branch"),
        DAILY("Daily"),
        MAIL("Mail"),
        CHAT("Chat"),
        WAREHOUSE("Warehouse"),
        PICK("Pick"),
        MAP("Map"),
        SIGN("Sign"),
        ONLINE_GIFT("Olgift"),
        AUTO_FIGHT("HangUP"),
        AUTO_FIGHT_SET("HangUPSet"),
        BAG("Bag"),
        CURRENCY("Currency"),
        ATTRIBUTE("Character"),
        TEAM("Team"),
        DAILY_PLAY("DailyPlay"),
        EXCHANGE("Change"),
        APPRAISAL("Appraisal"),
        ACHIEVEMENT("Achievement"),
        UP("Up"),
        MALL("Mall"),
        ACTIVITY("Activity"),
        PAY("Pay"),
        RANK("Rank"),
        FRIEND("Social"),
        SYSTEM_SETTING("SysSetting"),
        RIDING("Riding"),
        SKILL("Skill"),
        TITLE2("Title2"),
        MOUNT("Ride"),
        SOLO("Solo"),
        SetNew("SetNew"),
        STRENGTHEN("Strengthen"),
        REWORK("Reworking"),
        SMELTING("Smelting"),
        PET("Pet"),
        MAGIC_RING("MagicRing"),
        WING("Wings"),
        MEDAL("Title"),
        GUILD("Guild"),
        FB("FB"),
        DaoYou("Ally"),
        JJC("JJC"),
        CONSIGNMENT("Consignment"),
        SERVERS("Servers"),
        ALLY_BATTLE("AllyBattle"),
        REWORKING_UP("ReworkingUp"),
        Make("Make"),
        TOWER("Tower"),
        GUILD_BATTLE("GuildBattle"),
        FASHION("Fashion"),
        BOSS_HOME("BossHome"),
        EQUIP_LV_UP("EquipLvUp"),
        REFINE("Refine"),
        COMBINE("Combine"),
        TARGET("Target"),
        FIRST_PAY("FirstPay"),
        DAILY_PAY("DailyPay"),
        Rebuild("Rebuild"),
        Reborn("Reborn"),
        WORLD_EXP("WorldExp"),
        XIAN_YUAN("XianYuan"),
        FIVE_2_FIVE("5v5"),
        LoopTask("oneDragon"),
        teacher("teacher"), Inherit("Inherit"),
        BloodLineage("BloodLineage");
        private String value;

        FunctionType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum MOUNT_SKIN_STATE {
        notactive(1), notuse(2), useing(3);

        private int value;

        MOUNT_SKIN_STATE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MOUNT_RIDING_STATE {
        off(0), on(1);

        private int value;

        MOUNT_RIDING_STATE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static MOUNT_RIDING_STATE getValue(int value) {
            for (MOUNT_RIDING_STATE mrs : values()) {
                if (mrs.getValue() == value) {
                    return mrs;
                }
            }
            return off;
        }
    }


    public static class IntergalMallType {
        public static final int SundryShop = 1;

        public static final int MallShop = 2;

        public static final int FateShop = 3;

        public static final int AthleticShop = 4;

        public static final int GuildShop = 5;
    }


    public enum SHOP_MALL_CONSUME_TYPE {
        DIAMOND(1), TICKET(2), ITEMCHANGE(3);
        private int value;

        SHOP_MALL_CONSUME_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static SHOP_MALL_CONSUME_TYPE getType(int value) {
            for (SHOP_MALL_CONSUME_TYPE shMall_CONSUME_TYPE : values()) {
                if (shMall_CONSUME_TYPE.value == value) {
                    return shMall_CONSUME_TYPE;
                }
            }
            return null;
        }
    }

    public enum SHOP_MALL_SERVER_LIMIT {
        GLOBAL(1), SELF(0);
        private int value;

        SHOP_MALL_SERVER_LIMIT(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SHOP_MALL_SCOREITEM_POSITION {
        FIRST(1), SECOND(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
        private int value;

        SHOP_MALL_SCOREITEM_POSITION(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SHOP_MALL_ITEM_TYPE {
        DIAMOND_LIMIT(101), TICKET_LIMIT(201), ITEM_LIMIT(301);
        private int value;

        SHOP_MALL_ITEM_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static SHOP_MALL_ITEM_TYPE getType(int value) {
            for (SHOP_MALL_ITEM_TYPE sMall_ITEM_TYPE : values()) {
                if (sMall_ITEM_TYPE.value == value) {
                    return sMall_ITEM_TYPE;
                }
            }
            return null;
        }
    }

    public enum ONLINE_GIFT {
        INIT_ID(1001), END_ID(0);

        private int value;

        ONLINE_GIFT(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ONLINE_GIFT_TYPE {
        NORMAL(0), FIRST_DAY(1);
        private int value;

        ONLINE_GIFT_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EVENT_GIFT_STATE {
        NOT_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2);
        private int value;

        EVENT_GIFT_STATE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EVENT_GIFT_REQUIRE_TYPE {
        LV(1), FIGHT_POWER(2);
        private int value;

        EVENT_GIFT_REQUIRE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EVENT_GIFT_PROP_TYPE {
        ONE("event_template1"), TWO("event_template2");
        private String value;

        EVENT_GIFT_PROP_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum PropertyChangeType {
        HP(0), MP(1), HPAndMP(2), NPC(3);

        public final int value;

        PropertyChangeType(int value) {
            this.value = value;
        }
    }

    public enum ValueType {
        Value(0), Percent(1);

        public final int value;

        ValueType(int value) {
            this.value = value;
        }
    }

    public enum CUSTOMTIPTYPE {
        GOLD(1), TICKET(2), DIAMOND(3), EXP(4), PRESTIGE(5);

        private int value;

        CUSTOMTIPTYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CHAT_SCOPE {
        WORLD(1),
        GUILD(2),
        TEAM(3),
        PRIVATE(4),
        ZONE(5),
        DAOYOU(6),
        SYSTEM(7),
        HORM(8),
        TEAM_CALL(9);

        private final int value;

        CHAT_SCOPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SYS_CHAT_TYPE {
        EXP(1), COIN(2), ITEM(3), TRADE(4), TEAM_EXP(5), CLASS_EXP(6);

        private int value;

        SYS_CHAT_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum COMMONPROPERTYUP {
        WING(1), MOUNT(2);
        private int value;

        COMMONPROPERTYUP(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum PlayerPro {
        ALL("ALL", 0), COMMON("通用", 0), CANG_LANG("苍狼", 1), YU_JIAN("御剑", 2), YI_XIAN("逸仙", 3), SHEN_JIAN("神箭", 4), LI_NHU("灵狐", 5);

        public final int value;
        public final String key;

        PlayerPro(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public static PlayerPro Enum(int value) {
            for (PlayerPro e : values()) {
                if (value == e.value) {
                    return e;
                }
            }
            Out.error(new Object[]{"PlayerPro undefine v : ", Integer.valueOf(value)});
            return null;
        }

        public static int Value(String s) {
            if (StringUtil.isEmpty(s)) {
                return 0;
            }
            for (PlayerPro e : values()) {
                if (e.key.equals(s)) {
                    return e.value;
                }
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(PlayerPro.Value("灵狐"));
    }

    public enum TEAM_DISTRIBUTE_TYPE {
        FREEDOM(1),

        GRAB(3);

        public final int value;

        TEAM_DISTRIBUTE_TYPE(int value) {
            this.value = value;
        }
    }

    public enum TEAM_DISTRIBUTE_TYPE_DES {
        FREEDOM("自由拾取"), DISTRIBUTE("队长分配"), GRAB("摇色子");

        public final String value;

        TEAM_DISTRIBUTE_TYPE_DES(String value) {
            this.value = value;
        }
    }

    public enum EQUIP_QCOLOR {
        WHITE(0), BLUE(1), PURPLE(2), ORANGE(3), GREEN(4);

        public final int value;

        EQUIP_QCOLOR(int value) {
            this.value = value;
        }
    }

    public enum TEAM_DISTRIBUTE_ITEM_QCOLOR_DES {
        BLUE("蓝色"), PURPLE("紫色"), ORANGE("橙色");

        public final String value;

        TEAM_DISTRIBUTE_ITEM_QCOLOR_DES(String value) {
            this.value = value;
        }
    }

    public enum TEAM_GRAB_ITEM_TYPE {
        GIVE_UP(1),
        RANDOM(2),
        WANT(3);

        public final int value;

        TEAM_GRAB_ITEM_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static TEAM_GRAB_ITEM_TYPE getE(int value) {
            for (TEAM_GRAB_ITEM_TYPE e : values()) {
                if (value == e.getValue()) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum RankSeasonType {
        NO_SEASON(-1),
        LAST_SEASON(0),
        CUR_SEASON(1);
        public final int value;

        RankSeasonType(int value) {
            this.value = value;
        }
    }

    public enum UpdateType {
        INTERVAL_TIME(0),
        REAL_TIME(1);

        public final int value;

        UpdateType(int value) {
            this.value = value;
        }
    }

    public enum LeaderBoardType {
        FIGHTPOWER_ALL_rankTR(101),
        FIGHTPOWER_1_rankTR(102),

        FIGHTPOWER_3_rankTR(104),

        FIGHTPOWER_5_rankTR(106),
        LEVEL_rankTR(200),
        GUILD_LEVEL_rankTR(300),
        GUILD_WAR_rankTR(400),
        RIDE_rankTR(500),
        PET_rankTR(600),
        XIANYUAN_rankTR(700),
        HP_rankTR(800),
        PHY_rankTR(801),
        MAGIC_rankTR(802),
        PVP_5V5_rankTR(1003),
        DAOYOU_rankTR(2005),
        FLEE_rankTR(900),


        SOLO_SCORE_seasonRankTR(2006),
        ARENA_SCORE_rankTR(2007),
        ARENA_SCOREALL_seasonRankTR(2009),
        DEMON_TOWER_rankTR(2100),
        MIN(0);

        public final int value;

        LeaderBoardType(int value) {
            this.value = value;
        }

        public static LeaderBoardType getE(int value) {
            for (LeaderBoardType e : values()) {
                if (e.value == value) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum PkModel {
        Peace(0), Justice(1), Force(2), Guild(3), Team(4), Server(5), All(6);

        public final int value;

        PkModel(int value) {
            this.value = value;
        }
    }

    public enum OrderType {
        A(1), Asc(1), D(2), Desc(2);

        public final int value;

        OrderType(int value) {
            this.value = value;
        }

        public static OrderType getE(String name) {
            for (OrderType e : values()) {
                if (e.name().equals(name)) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum TaskOpenWay {
        None(0), DailyOpenInTime(1),
        WeekOpenInTime(2),
        OpenInTime(3),
        FestivalOpenInTime(4);
        private final int value;

        TaskOpenWay(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum FASHION_BUY_TYPE {
        DIAMOND(1), COIN(2), ITEM(3);
        private final int value;

        FASHION_BUY_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum FASHION_TYPE {
        WEPON(1), CLOTH(2), WING(3);

        public final int value;

        FASHION_TYPE(int value) {
            this.value = value;
        }
    }


    public static class Position {
        public int x;


        public int y;


        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public enum AVATAR_TYPE {
        NODE(0), R_HAND_WEAPON(1), R_HAND_BUFF(2), L_HAND_WEAPON(3), L_HAND_BUFF(4), HEAD_EQUIPMENT(5), HEAD_BUFF(6), CHEST_EQUIPMENT(7), CHEST_BUFF(8), REAR_EQUIPMENT(9),
        REAR_BUFF(10), FOOT_EQUIPMENT(11), FOOT_BUFF(12), TAIL_EQUIPMENT(13), TAIL_BUFF(14), AVATAR_BODY(15), RIDE_EQUIPMENT(16);

        public final int value;


        AVATAR_TYPE(int value) {
            this.value = value;
        }
    }

    public enum DungeonType {
        CAN_INVITE(1), INVITIED(2), REFUSED(3);

        public final int value;

        DungeonType(int value) {
            this.value = value;
        }
    }

    public enum HandsUpState {
        ACCEPT(1), REFUSE(2), WAITING(3);

        public final int value;

        HandsUpState(int value) {
            this.value = value;
        }
    }

    public enum OpenRuleType {
        EVERY_DAY(1), EVERY_WEEK(2);
        private final int value;

        OpenRuleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum HardModel {
        NORMAL(1),
        ELITE(2),
        HERO(3);

        public final int value;

        HardModel(int value) {
            this.value = value;
        }
    }

    public enum MESSAGE {
        MAX_COUNT(50);
        private final int value;

        MESSAGE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum MESSAGE_OPERATE {
        TYPE_ACCEPT(1), TYPE_REFUSE(2);
        private final int value;

        MESSAGE_OPERATE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SkillType {
        PASSIVE(0), ACTIVE(1), STRENGTHEN_TALENT(2), NORMAL(3), BATTLE_PASSIVE(4), EFFECT_PASSIVE(5), PET_PASSIVE(6);
        private final int value;

        SkillType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum SkillHandleType {
        ALL(0), CHANGE(1), ADD(2), DELETE(3);
        private final int value;

        SkillHandleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum GOTO_TYPE {
        SALE_SHOP(1),
        PICK_ITEM(2);

        public final int value;

        GOTO_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum KickReason {
        NEW_LOGIN(1),
        SERVER_SHUT_DOWN(2),
        LOGIC_ERROR(3),
        GM_KICK(4);

        public final int value;

        KickReason(int value) {
            this.value = value;
        }
    }

    public enum ConsignmentOrderType {
        TIME_DES(0), TIME_ASC(1), PRICE_ASC(2), PRICE_DES(3), LEVEL_ASC(4), LEVEL_DES(5);
        private final int value;

        ConsignmentOrderType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum InteractType {
        FRIEND(1), UNFRIEND(2);
        private final int value;

        InteractType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public enum FriendMessageType {
        TYPE_INVITE(1), TYPE_CONCERN(2);
        private final int value;

        FriendMessageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum OfflineMessageType {
        SEND_MAIL(1), FRIEND(2), PREPAID(3);
        private final int value;

        OfflineMessageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RemoveFriendType {
        FRIEND(1), FRIEND_MESSAGE(2), FRIEND_APPLY(3), BLACK_LIST(4), FRIEND_RECORD(5), CHOU_REN(6);
        private final int value;

        RemoveFriendType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum PlayerStatus {
        online(1), faraway(2), offline(3);
        private final int value;

        PlayerStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ALLY_CHAT_TYPE {
        NOTIFY(1), LEAVE_WORD(2), SYS(3);

        ALLY_CHAT_TYPE(int value) {
            this.vaule = value;
        }

        private final int vaule;

        public int getVaule() {
            return this.vaule;
        }
    }

    public enum VitalityID {
        ALLY_FIGHT(3), ARENA(4);

        VitalityID(int value) {
            this.vaule = value;
        }

        private final int vaule;

        public int getVaule() {
            return this.vaule;
        }
    }

    public enum ALLY_FIGHT_PUSH_TYPE {
        JOIN(1),
        ENTER(2);

        ALLY_FIGHT_PUSH_TYPE(int value) {
            this.vaule = value;
        }

        private final int vaule;

        public int getVaule() {
            return this.vaule;
        }
    }

    public enum RecommendPlayFunType {
        DUNGEON(1), GUILD_DUNGEON(4), SOUL_DAILY_TASK(7), SOLO(13);

        RecommendPlayFunType(int value) {
            this.vaule = value;
        }

        private final int vaule;

        public int getVaule() {
            return this.vaule;
        }
    }

    public enum GuildBuilding {
        GUILD(1),
        BLESS(2),
        DEPOT(3),
        COPY(4),
        TECH(5);
        private final int value;

        GuildBuilding(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }

    public enum GuildMode {
        AUTO_MODE(1), CHECK_MODE(2);
        private final int value;

        GuildMode(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }

    public enum GuildJob {
        PRESIDENT(1), VICE_PRESIDENT(2), ELDER(3), ELITE(4), MEMBER(5);
        private final int value;

        GuildJob(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }

    public enum LuckyDrawType {
        EXCELLENT_ITEM(1), NORMAL_ITEM(2), BUFF_ITEM(3), RECOMMEND_ITEM(4), VIEW_ITEM(5);

        LuckyDrawType(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return this.value;
        }
    }

    public enum ActivityRewardType {
        FIRST_PAY(1), SECOND_PAY(2),


        TOTAL_PAY(3), TOTAL_CONSUME(4), LEVEL(5), FIGHT_POEWR(6), FOUNDATION(7), INVITE_FRIEND(8), INVITE_CODE(9), GAME_NOTICE(10), LUCKY_REWARD(13), OPEN_SEVEN_DAY(14), HAOLI_CHANGE(15), SIGN(16), ONLINE_GIFT(17), LUCK_DRAW(18), SUPER_PACKAGE(19), RECOVERY(20), DAILY_RECHARGE(21),


        SINGLE_RECHARGE(23), SPRING_DRAW(25),


        REVELRY_RECHARGE(26);

        ActivityRewardType(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return this.value;
        }
    }


    public enum HAOLI_CHANGE_STATE {
        CANNOT_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2);

        HAOLI_CHANGE_STATE(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return this.value;
        }
    }

    public enum NotifyType {
        GUILD_REFRESH(0),
        GUILD_PUSH_START(1),
        GUILD_JOIN_PUSH(1),
        GUILD_EXIT_PUSH(2),
        GUILD_JOB_CHANGE(3),
        GUILD_CHANGE_NAME(4),

        DEPOT_PUSH_START(10),
        DEPOT_DEPOSIT_PUSH(10),
        DEPOT_REMOVE_PUSH(11),
        DEPOT_UPGRADE_PUSH(12),
        DEPOT_CONDITION_PUSH(13),

        BLESS_PUSH_START(20),
        BLESS_FINISH_PUSH(20),
        BLESS_NEW_DAY_PUSH(21),

        SHOP_PUSH_START(30),
        SHOP_NEW_DAY_PUSH(30),

        TECH_PUSH_START(40),
        TECH_NEW_DAY_PUSH(40),
        TECH_LEVEL_PUSH(41),
        TECH_BUFF_LEVEL_PUSH(42),
        GUILD_DUNGEON_OPEN(43),
        GUILD_DUNGEON_PASS(44), GUILD_DUNGEON_PLAYER_NUM(45), GUILD_DUNGEON_OPEN_CHAT(46);
        public final int value;

        NotifyType(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }

    public enum VitalityType {
        EXP_FARM(1),
        SOLO(2),
        ALLY_FIGHT(3),
        ARENA(4),
        GUILD_DUNGEON(5),
        TEAM_DUNGEON(6),
        WORLD_BOSS(7),
        VIP_BOSS(8),
        DAILY_TASK(9),
        HORSE_DUNGEON(10),
        WING_DUNGEON(11),
        EQUIP_STRENGTHEN(12),
        FILL_GEM(13),
        EQUIP_ENCHANT(14);

        public final int value;

        VitalityType(int value) {
            this.value = value;
        }
    }

    public enum DailyType {
        DEFAULT(0), DEMON_TOWER(1),
        ILLUSION(2),
        DUNGEON(3),
        DAILY_TASK(4),
        LOOP_TASK(5),
        WORLD_LEVEL(6),
        SOLO(7),
        ARENA(8),
        PVP_5V5(9),
        RESOURCE_CHALLENGE(10),
        RESOURCE_WATCH_PET(11),
        RESOURCE_FARM(12),
        ILLSION_BOSS(13),

        ILLUSION2(14),

        RED_PACKET(15),

        DAILY_MAX(99999);

        public final int value;

        DailyType(int value) {
            this.value = value;
        }
    }

    public enum GuildRecord {
        JOIN(1),
        EXIT(2),
        KICK(3),
        UPGRADE(4),
        JOB(5),
        OFFICE_NAME(6),
        IMPEACH(7),
        IMPEACH_TIMEOUT(8),
        TRANSFER_IMPEACH_BECOME_INVALID(9),
        ONLINE_IMPEACH_BECOME_INVALID(9),
        DEPOSIT_EQUIP(10),
        TAKE_OUT_EQUIP(11),
        DELETE_EQUIP(12),
        BLESS_USE_ITEM(13),
        UPGRADE_BUILDING(14),
        GUILD_NAME(15),
        OPEN_GUILD_DUNGEON(16),
        GUILD_DUNGEON_PASS(17),
        TRANSFER_PRESIDENT(18),
        CREATE_GUILD(19),

        MAX(99999);
        public final int value;

        GuildRecord(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }

    public enum ACTIVITY_CENTER_TYPE {
        LEVEL_GIFT(5), INVITE_CODE(9), NOTICE(10);

        ACTIVITY_CENTER_TYPE(int value) {
            this.value = value;
        }

        public final int value;

        public int getValue() {
            return this.value;
        }
    }

    public enum PrepaidType {
        PREPAID_REQUEST(1), WP_PREPAID_REQUEST(2);

        PrepaidType(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return this.value;
        }
    }

    public enum PlayerBtlData {
        MaxHP(1, "生命"), HPPer(2, "生命%"), Attack(3, "攻击"), AttackPer(4, "攻击%"), Phy(5, "物攻"), PhyPer(6, "物攻%"), Mag(7, "魔攻"), MagPer(8, "魔攻%"), Hit(9, "命中"), HitPer(10, "命中%"), HitRate(11, "命中率"), Dodge(12, "闪避"), DodgePer(13, "闪避%"), DodgeRate(14, "闪避率"), Crit(15, "暴击"), CritPer(16, "暴击%"), CritRate(17, "暴击率"), ResCrit(18, "抗暴"), ResCritPer(19, "抗暴%"), ResCritRate(20, "抗暴率"), CritDamage(21, "暴击伤害%"), CritDamageRes(22, "暴伤抵御%"), Def(23, "防御"), DefPer(24, "防御%"), Ac(25, "物防"), AcPer(26, "物防%"),
        PhyDamageReduce(27, "受到物伤减少%"), Resist(28, "魔防"), ResistPer(29, "魔防%"), MagicDamageReduce(30, "受到魔伤减少%"), IgnoreAc(31, "无视敌人物防"), IgnoreResist(32, "无视敌人魔防"), IgnoreAcPer(33, "无视敌人物防%"), IgnoreResistPer(34, "无视敌人魔防%"), IncAllDamage(35, "所有伤害增加%"), AllDamageReduce(36, "受到伤害减免%"), HitLeechHP(37, "命中回复生命"), CtrlTimeReduce(38, "被控时间减少%"), SkillCD(39, "技能冷却减少%"), HPRegen(40, "生命恢复"), ExdGold(41, "银两掉落"), ExdExp(42, "杀怪经验"), HPRecover(43, "恢复生命"),
        HPRecoverPer(44, "恢复生命%"), HealEffect(45, "治疗效果"), HealedEffect(46, "被治疗效果"), RunSpeed(47, "移动速度"), Stun(48, "眩晕成功率"), Freeze(49, "冻结成功率"), Silence(50, "禁魔成功率"), Durance(51, "禁锢成功率"), Taunt(52, "嘲讽成功率"), SlowDown(53, "减速成功率"), ResStun(54, "眩晕抵抗"), ResFreeze(55, "冻结抵抗"), ResSilence(56, "禁魔抵抗"), ResDurance(57, "禁锢抵抗"), ResTaunt(58, "嘲讽抵抗"), ResSlowDown(59, "减速抵抗"), AllCtrl(60, "控制成功率"), AllResCtrl(61, "控制抵抗"), SkillDamage(62, "技能加成%"), HateRatio(63, "仇恨值");
        public final int id;

        PlayerBtlData(int id, String chName) {
            this.id = id;
            this.chName = chName;
        }


        public final String chName;

        public static PlayerBtlData getE(String chName) {
            for (PlayerBtlData pd : values()) {
                if (pd.chName.equals(chName))
                    return pd;
            }
            return null;
        }

        public static PlayerBtlData getE(int id) {
            for (PlayerBtlData pd : values()) {
                if (pd.id == id)
                    return pd;
            }
            return null;
        }

        public static PlayerBtlData getEByKey(String key) {
            for (PlayerBtlData pd : values()) {
                if (pd.name().equals(key))
                    return pd;
            }
            return null;
        }
    }

    public enum DaoYou {
        DaoYouNameMaxLength(7), DaoYouNameMinLength(1), DaoYouKickDaoYouMail(20215), DaoYouLeaveMessageMaxLength(20), DaoYouNoticeMaxLength(20), DaoYouEditNameInterval(7), DaoYouRebateMail(20214), DaoYouMessageTypeSystem(1), DaoYouMessageTypeLeave(2);
        private final int value;

        DaoYou(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum TimeState {
        TIME_NOT_UP(0), TIME_UP(1), TIME_OVER(2);

        private final int value;

        TimeState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum VipType {
        none(0), month(1), forever(2), sb_double(3);
        public final int value;

        VipType(int value) {
            this.value = value;
        }

        public static VipType getE(int value) {
            for (VipType vt : values()) {
                if (vt.value == value)
                    return vt;
            }
            return null;
        }
    }

    public enum Five2Five {
        five2five_choice_giveup(1), five2five_choice_ready(2), five2five_choice_type_agree(1), five2five_choice_type_ready(2), five2five_thread_delay_time(3000);
        public final int value;

        Five2Five(int value) {
            this.value = value;
        }
    }

    public enum PlayerEventType {
        UPGRADE,
        CLASS_UPGRADE,
        EQUIPMENT_CHANGE, REFRESH_NEWDAY, AFTER_LOGIN,
        OFFLINE, PET_CHANGE,
        PET_PROP_CHANGE,
        GUILD_BLESS_CHANGE,
        GUILD_TECH_CHANGE,
        TITLE_CHANGE,
        PAY,
        FASHION_CHANGE,
        UPGRADE_TALENT_PASSIVE_SKILL,
        ARMOUR_ACTIVE,
        EXCHANGE_PROPARTY,
        BLOOD;
    }

    public enum ManagerType {
        BASE_DATA, BTL_DATA, SKILL, SKILL_KEY, MOUNT, PET, VIP, MAIL, PREPAID, FIST_PAY, FIVE_2_FIVE, MONSTER_DROP, GUILD_BOSS, AUCTION, FARM, ACTIVITY, FASHION, BLOOD, GUILD_FORT, RICH, SEVEN_GOAL;
    }

    public enum Arena {
        ARENA_GREEDY(1033),
        ARENA_TIANSHEN(1031),
        FIGHT_POWER_UP(510023);
        public int value;

        Arena(int value) {
            this.value = value;
        }
    }

    public enum AffixType {
        normal(0),
        legend(1);

        public int value;

        AffixType(int value) {
            this.value = value;
        }
    }


    public enum DungeonHardModel {
        Normal(1, "简单", "00d0ff"), NightMare(2, "普通", "ffae00"), Hell(3, "困难", "ed2a0a");
        public String color;
        public String desc;
        public int value;

        DungeonHardModel(int value, String desc, String color) {
            this.value = value;
            this.desc = desc;
            this.color = color;
        }

        public static DungeonHardModel getE(int value) {
            for (DungeonHardModel dhm : values()) {
                if (dhm.value == value)
                    return dhm;
            }
            return null;
        }
    }

    public enum BiLogType {
        Smelt("熔炼"), Sale("出售"), Gold("银两"), Gold_Total("银两_总变更"), Cash("绑元"), Cash_Total("绑元_总变更"), Diamond("元宝"), Diamond_Total("元宝_总变更"), Exp("经验"), Exp_Total("经验_总变更"), FightPower("战力"), FightPower_Total("战力_总变更"), Consignment("寄卖"), Consignment_Total("寄卖_总变更"), Regist("注册"), Gift("礼包"), Gift_Total("礼包_总变更"), Pk("PK"), Charge("充值"), Charge_First("充值_首充"), Mail("邮件"), DiamondChange("元宝详细"), CashChange("绑元详细");

        public String desc;

        BiLogType(String desc) {
            this.desc = desc;
        }

        public static BiLogType get(String key) {
            for (BiLogType blt : values()) {
                if (blt.name().equals(key)) {
                    return blt;
                }
            }
            return null;
        }
    }

    public static String raffletickets = "raffletickets";
}


