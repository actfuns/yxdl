package com.wanniu.game.player;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GGame;
import com.wanniu.core.XLang;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.login.AuthServer;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.attendance.PlayerAttendance;
import com.wanniu.game.bag.BagPO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.BranchLineCO;
import com.wanniu.game.data.CharacterCO;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MainLineCO;
import com.wanniu.game.data.PrefixCO;
import com.wanniu.game.data.SuffixCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.data.ext.EquipSockExt;
import com.wanniu.game.data.ext.OlGiftExt;
import com.wanniu.game.data.ext.TransportExt;
import com.wanniu.game.data.ext.UpLevelExpExt;
import com.wanniu.game.equip.EquipUtil;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.fashion.FashionUtil;
import com.wanniu.game.five2Five.Five2FiveService;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.MedalPO;
import com.wanniu.game.mount.MountCenter;
import com.wanniu.game.mount.MountUtil;
import com.wanniu.game.onlineGift.OlGiftConfig;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.player.po.AvatarObj;
import com.wanniu.game.playerSkill.SkillManager;
import com.wanniu.game.poes.AchievementDataPO;
import com.wanniu.game.poes.ActivityDataPO;
import com.wanniu.game.poes.ArenaDataPO;
import com.wanniu.game.poes.AttendancePO;
import com.wanniu.game.poes.BagsPO;
import com.wanniu.game.poes.DailyActivityPO;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.poes.FunctionOpenPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.HookSetPO;
import com.wanniu.game.poes.LeaderBoardPlayerPO;
import com.wanniu.game.poes.MountPO;
import com.wanniu.game.poes.OnlineDataPO;
import com.wanniu.game.poes.PlayerAttachPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerChouRenPO;
import com.wanniu.game.poes.PlayerConsignmentItemsPO;
import com.wanniu.game.poes.PlayerFriendsPO;
import com.wanniu.game.poes.PlayerMailDataPO;
import com.wanniu.game.poes.PlayerPKDataPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.PlayerPetsNewPO;
import com.wanniu.game.poes.PlayerTempPO;
import com.wanniu.game.poes.ShopMallPO;
import com.wanniu.game.poes.SkillsPO;
import com.wanniu.game.poes.SoloDataPO;
import com.wanniu.game.poes.TaskListPO;
import com.wanniu.game.poes.TitlePO;
import com.wanniu.game.poes.VipPO;
import com.wanniu.game.sysSet.SysSetFlag;
import com.wanniu.game.task.LoopResult;
import com.wanniu.game.task.TaskData;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.xianyuan.XianYuanService;
import com.wanniu.redis.PlayerPOManager;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.TeamHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


public class PlayerUtil {
    public static int maxClassID = 0;
    public static int maxUpOrder = 0;

    static {
        Map<Integer, UpLevelExpExt> map = GameData.UpLevelExps;
        for (UpLevelExpExt prop : map.values()) {
            if (prop.classID > maxClassID && prop.isValid == 1)
                maxClassID = prop.classID;
            if (prop.upOrder > maxUpOrder && prop.isValid == 1) {
                maxUpOrder = prop.upOrder;
            }
        }
    }


    public static JSONObject getPlayerPosition(WNPlayer player) {
        String res = player.getXmdsManager().getPlayerData(player.getId(), false);
        return StringUtil.isEmpty(res) ? Utils.toJSON(new Object[]{"x", Integer.valueOf(0), "y", Integer.valueOf(0)}) : JSON.parseObject(res);
    }


    public static final boolean isOnline(String playerId) {
        return GWorld.getInstance().isOnline(playerId);
    }


    public static boolean isLocal(String rid) {
        return GWorld.getInstance().isLocal(rid);
    }


    public static String sendSysMessageToPlayer(String message, String playerId) {
        return sendSysMessageToPlayer(message, playerId, Const.TipsType.NORMAL);
    }

    public static String sendSysMessageToPlayer(String message, String playerId, Const.TipsType type) {
        WNPlayer player = GWorld.getInstance().getPlayer(playerId);
        if (player != null) {
            player.sendSysTip(message, type);
        }


        return null;
    }


    public static final String handleGMChat(WNPlayer player, Map<String, Object> _data) {
        String operate = (String) _data.get("operate");
        if (operate.equals("add")) {
            String itemCode = (String) _data.get("itemCode");
            if (ItemConfig.getInstance().getItemPropByName(itemCode) != null) {
                itemCode = (ItemConfig.getInstance().getItemPropByName(itemCode)).code;
            }
            int num = ((Integer) _data.get("num")).intValue();
            if (player.bag.testAddCodeItem(itemCode, num)) {
                player.bag.addCodeItem(itemCode, num, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.gm, null);
            }
        } else if (operate.equals("addRank")) {
            int id = ((Integer) _data.get("id")).intValue();
            player.titleManager.onAwardRank(id);
        } else if (operate.equals("addPetExp")) {
            player.petNewManager.addExp(Integer.parseInt((String) _data.get("petId")), Integer.parseInt((String) _data.get("num")));
        } else if (operate.equalsIgnoreCase("finishTask")) {
            player.taskManager.gmFinishTask(((Integer) _data.get("id")).intValue());
        } else if (operate.equalsIgnoreCase("acceptTask")) {
            player.taskManager.gmAcceptTask(((Integer) _data.get("id")).intValue());
        } else if (operate.equals("finishTaskTarget")) {
            player.taskManager.gmfinishTaskTarget(((Integer) _data.get("id")).intValue());
        } else if (operate.equalsIgnoreCase("newTask")) {
            player.taskManager.gmNewTask(((Integer) _data.get("id")).intValue());
        } else if (operate.equalsIgnoreCase("discardTask")) {
            player.taskManager.gmDiscardTaskByID(((Integer) _data.get("id")).intValue());
        } else if (operate.equals("prepaid")) {
            player.prepaidManager.onPrepaidChargeByMoney(((Integer) _data.get("money")).intValue());
        } else if (operate.equals("openFunc")) {
            player.functionOpenManager.gmOpenFunction(((Integer) _data.get("functionID")).intValue());
        } else if (operate.equals("guildAdd")) {
            if (_data.get("moneyName").equals("contribution")) {
                player.guildManager.addContribution(((Integer) _data.get("num")).intValue(), Const.GOODS_CHANGE_TYPE.gm);
            } else {
                GuildService.gmAddGuildMoney(player.getId(), (String) _data.get("moneyName"), ((Integer) _data.get("num")).intValue());
            }
        } else if (operate.equals("tp")) {
            AreaUtil.dispatchByAreaId(player, ((Integer) _data.get("mapID")).intValue(), null);
        } else if (operate.equals("guildFundAdd")) {
            GuildPO guildPo = player.guildManager.guild;
            if (null != guildPo) {
                int _num = ((Integer) _data.get("num")).intValue();
                guildPo.fund += _num;
                guildPo.sumFund += _num;
                GuildServiceCenter.getInstance().refreshGuildTopInfo(guildPo.id);
                GuildServiceCenter.getInstance().saveGuild(guildPo);
            }
        } else if (operate.equals("guildExpAdd")) {
            GuildPO guildPo = player.guildManager.guild;
            if (null != guildPo) {
                guildPo.exp += ((Integer) _data.get("num")).intValue();
                GuildServiceCenter.getInstance().saveGuild(guildPo);
            }
        }
        return null;
    }


    public static WNPlayer findPlayer(String playerId) {
        if (StringUtil.isEmpty(playerId)) {
            Out.error(new Object[]{"playerId is nil"});
            (new Exception()).printStackTrace();
            return null;
        }
        WNPlayer player = getOnlinePlayer(playerId);
        if (player != null) {
            return player;
        }


        return player;
    }


    public static WNPlayer getOnlinePlayer(String playerId) {
        if (StringUtil.isEmpty(playerId)) {
            Out.error(new Object[]{"playerId is null"});
            (new Exception()).printStackTrace();
            return null;
        }
        return GWorld.getInstance().getPlayer(playerId);
    }

    public static WNPlayer getOnlinePlayerByUid(String uid) {
        return (WNPlayer) GGame.getInstance().getPlayerByUid(uid);
    }

    public static PlayerPO getPlayerBaseData(String playerId) {
        WNPlayer player = findPlayer(playerId);

        if (null != player) {
            return player.getPlayer();
        }

        try {
            return PlayerDao.getPlayerDataById(playerId);
        } catch (Exception e) {
            Out.error(new Object[]{e});
            return null;
        }
    }


    public static boolean isPlayerOpenedFunction(String playerId, String funcName) {
        int defState = FunctionOpenUtil.getDefaultOpenState(funcName);
        if (defState == -1) {
            return false;
        }
        if (defState == 1) {
            return true;
        }
        FunctionOpenPO db = (FunctionOpenPO) PlayerPOManager.findPO(ConstsTR.player_func_openTR, playerId, FunctionOpenPO.class);
        if (db == null) {
            return false;
        }
        if (db.openMap == null || !db.openMap.containsKey(funcName)) {
            return false;
        }

        return true;
    }


    public static TeamHandler.Player.Builder transToJson4TeamMemberSimple(WNPlayer player) {
        PlayerPO playerData = player.getPlayer();
        TeamHandler.Player.Builder data = TeamHandler.Player.newBuilder();
        data.setId(playerData.id);
        data.setName(playerData.name);
        data.setPro(playerData.pro);
        data.setLevel(playerData.level);
        data.setUpLevel(playerData.upLevel);
        String guildName = player.guildManager.getGuildName();
        data.setGuildName(StringUtil.isEmpty(guildName) ? LangService.getValue("TEAM_NO_GUILD") : guildName);
        return data;
    }


    public static PlayerOuterClass.PlayerBasic transToJson4BasicByBlob(AllBlobPO playerData) {
        PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
        data.setId(playerData.player.id);
        data.setName(playerData.player.name);
        data.setLevel(playerData.player.level);
        data.setPro(playerData.player.pro);
        data.setUpLevel(playerData.player.upLevel);

        if (playerData.playerBase.equipGrids == null) {
            playerData.playerBase.equipGrids = new HashMap<>();
        }

        data.addAllAvatars(getBattlerServerAvatar4Login(playerData.player.pro, playerData.playerBase));
        return data.build();
    }

    public static PlayerOuterClass.PlayerBasic transToJson4Basic(WNPlayer playerData) {
        PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
        data.setId(playerData.player.id);
        data.setName(playerData.player.name);
        data.setLevel(playerData.player.level);
        data.setPro(playerData.player.pro);
        data.setUpLevel(playerData.player.upLevel);

        if (playerData.playerBasePO.equipGrids == null) {
            playerData.playerBasePO.equipGrids = new HashMap<>();
        }

        data.addAllAvatars(getBattlerServerAvatar4Login(playerData.player.pro, playerData.playerBasePO));
        return data.build();
    }

    public static PlayerOuterClass.PlayerBasic playerBasicData(PlayerPO playerData) {
        Out.debug(new Object[]{PlayerUtil.class, "playerBasicData:::", playerData.id});
        PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
        data.setId(playerData.id);
        data.setName(playerData.name);
        data.setLevel(playerData.level);
        data.setPro(playerData.pro);
        data.setUpLevel(playerData.upLevel);
        return data.build();
    }


    public static List<Common.Avatar> getBattleServerAvatar(int pro) {
        CharacterCO basicProp = (CharacterCO) GameData.Characters.get(Integer.valueOf(pro));
        List<Common.Avatar> avatars = new ArrayList<>();
        Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
        avatar.setEffectType(0);
        avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);
        avatar.setFileName(basicProp.model);
        avatars.add(avatar.build());
        return avatars;
    }


    public static List<Common.Avatar> getBattlerServerAvatar(String playerId) {
        List<Common.Avatar> avatars = new ArrayList<>();
        PlayerPO playerPO = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
        if (playerPO == null) {
            Out.error(new Object[]{"getBattlerServerAvatarxxxxxxxxxxxxxxx-->>", playerId});
            return avatars;
        }
        PlayerBasePO playerBasePO = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);


        MountPO mountPO = playerPO.openMount ? MountCenter.getInstance().findMount(playerId) : null;

        List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(playerPO.pro, playerBasePO, false);
        avatars.addAll(equipAvatars);
        avatars.addAll(MountUtil.getCurMountAvatarInfo(mountPO));

        List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
        Map<Integer, Common.Avatar> targetMap = new HashMap<>();
        for (Common.Avatar avatar : avatars) {
            targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
        }
        for (Common.Avatar fashionAvatar : fashionAvatars) {
            int tag = fashionAvatar.getTag();
            if (targetMap.containsKey(Integer.valueOf(tag))) {

                Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
                avatarBuilderNew.setTag(tag);
                avatarBuilderNew.setFileName(fashionAvatar.getFileName());
                avatarBuilderNew.setEffectType(((Common.Avatar) targetMap.get(Integer.valueOf(tag))).getEffectType());
                targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build());
                continue;
            }
            targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
        }

        List<Common.Avatar> targetList = new LinkedList<>();
        for (Common.Avatar avatar : targetMap.values()) {
            targetList.add(avatar);
        }
        return targetList;
    }


    public static List<Common.Avatar> getBattlerServerAvatar(WNPlayer source, boolean changeModel) {
        List<Common.Avatar> avatars = new ArrayList<>();


        if (StringUtil.isNotEmpty(source.playerBasePO.model) && changeModel) {
            Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
            avatar.setEffectType(0);
            avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);
            avatar.setFileName(source.playerBasePO.model);
            avatars.add(avatar.build());
            return avatars;
        }


        List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(source.player.pro, source.playerBasePO, changeModel);
        avatars.addAll(equipAvatars);

        if (!changeModel || StringUtil.isEmpty(source.playerBasePO.model)) {
            avatars.addAll(MountUtil.getCurMountAvatarInfo(source.mountManager.mount));
        }

        List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(source.playerBasePO);
        Map<Integer, Common.Avatar> targetMap = new HashMap<>();
        for (Common.Avatar avatar : avatars) {
            targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
        }
        for (Common.Avatar fashionAvatar : fashionAvatars) {
            int tag = fashionAvatar.getTag();
            if (targetMap.containsKey(Integer.valueOf(tag))) {

                Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
                avatarBuilderNew.setTag(tag);
                avatarBuilderNew.setFileName(fashionAvatar.getFileName());
                avatarBuilderNew.setEffectType(((Common.Avatar) targetMap.get(Integer.valueOf(tag))).getEffectType());
                targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build());
                continue;
            }
            targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
        }

        List<Common.Avatar> targetList = new LinkedList<>();
        for (Common.Avatar avatar : targetMap.values()) {
            targetList.add(avatar);
        }
        return targetList;
    }

    public static List<Common.Avatar> getBattlerServerAvatar(PlayerPO player) {
        List<Common.Avatar> avatars = new ArrayList<>();
        PlayerBasePO playerBasePO = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, player.id, PlayerBasePO.class);
        List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(player.pro, playerBasePO, false);
        avatars.addAll(equipAvatars);

        List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
        Map<Integer, Common.Avatar> targetMap = new HashMap<>();
        for (Common.Avatar avatar : avatars) {
            targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
        }
        for (Common.Avatar fashionAvatar : fashionAvatars) {
            int tag = fashionAvatar.getTag();
            if (targetMap.containsKey(Integer.valueOf(tag))) {

                Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
                avatarBuilderNew.setTag(tag);
                avatarBuilderNew.setFileName(fashionAvatar.getFileName());
                avatarBuilderNew.setEffectType(((Common.Avatar) targetMap.get(Integer.valueOf(tag))).getEffectType());
                targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build());
                continue;
            }
            targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
        }

        List<Common.Avatar> targetList = new LinkedList<>();
        for (Common.Avatar avatar : targetMap.values()) {
            targetList.add(avatar);
        }
        return targetList;
    }


    public static List<Common.Avatar> getBattlerServerAvatar4Login(int pro, PlayerBasePO playerBasePO) {
        List<Common.Avatar> avatars = new ArrayList<>();

        List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(pro, playerBasePO, false);
        avatars.addAll(equipAvatars);

        List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
        Map<Integer, Common.Avatar> targetMap = new HashMap<>();
        for (Common.Avatar avatar : avatars) {
            targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
        }
        for (Common.Avatar fashionAvatar : fashionAvatars) {
            int tag = fashionAvatar.getTag();
            if (targetMap.containsKey(Integer.valueOf(tag))) {

                Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
                avatarBuilderNew.setTag(tag);
                avatarBuilderNew.setFileName(fashionAvatar.getFileName());
                avatarBuilderNew.setEffectType(((Common.Avatar) targetMap.get(Integer.valueOf(tag))).getEffectType());
                targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build());
                continue;
            }
            targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
        }

        List<Common.Avatar> targetList = new LinkedList<>();
        for (Common.Avatar avatar : targetMap.values()) {
            targetList.add(avatar);
        }
        return targetList;
    }

    public static List<AvatarObj> getBattlerServerAvatarObj(WNPlayer source) {
        List<Common.Avatar> list = getBattlerServerAvatar(source, true);
        List<AvatarObj> list_new = new ArrayList<>();
        for (Common.Avatar avatar : list) {
            list_new.add(new AvatarObj(avatar.getTag(), avatar.getFileName(), avatar.getEffectType()));
        }
        return list_new;
    }


    public static JSONObject getPlayerNowPosition(String playerId) {
        WNPlayer player = getOnlinePlayer(playerId);
        if (player != null) {
            return getPlayerPosition(player);
        }
        return null;
    }


    public static long[] getLevelByExp(long exp, int nowLevel, int curMaxLv) {
        int level = nowLevel;
        long curExp = exp;
        for (int i = nowLevel; i < curMaxLv; i++) {
            CharacterLevelCO prop = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(i));
            int needExp = prop.experience;
            if (curExp < needExp) {
                break;
            }
            curExp -= needExp;
            level++;
            if (level == GlobalConfig.Role_LevelLimit) {
                break;
            }
        }


        return new long[]{curExp, level};
    }


    public static int calExpLv(long exp, int nowLevel) {
        int level = nowLevel;
        long curExp = exp;
        for (int i = nowLevel; i <= GlobalConfig.Role_LevelLimit; i++) {
            CharacterLevelCO prop = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(i));
            int needExp = prop.experience;
            if (curExp < needExp) {
                break;
            }
            curExp -= needExp;
            level++;
        }
        return level;
    }


    public static boolean transPortById(WNPlayer player, int id) {
        TransportExt transportProp = (TransportExt) GameData.Transports.get(Integer.valueOf(id));
        if (transportProp == null) {
            return false;
        }
        boolean flag = false;
        int transMod = transportProp.transMod;
        String modValue = transportProp.modValue;
        if (transMod == Const.TRANSPORT_CONDITION.NOTHING.value) {
            flag = true;
        } else if (transMod == Const.TRANSPORT_CONDITION.ACCEPT_TASK.value) {
            if (player.taskManager.isTaskDoing(Integer.parseInt(modValue))) {
                flag = true;
            }
        } else if (transMod == Const.TRANSPORT_CONDITION.FINISH_TASK.value) {
            if (player.taskManager.isFinishTask(Integer.parseInt(modValue))) {
                flag = true;
            }
        } else if (transMod == Const.TRANSPORT_CONDITION.HAS_ITEM.value) {
            if (player.getWnBag().findItemNumByCode(modValue) > 0) {
                flag = true;
            }
        } else if (transMod == Const.TRANSPORT_CONDITION.CONSUME_ITEM.value) {
            int itemNumber = transportProp.needNumber;
            if (player.getWnBag().findItemNumByCode(modValue) > itemNumber) {
                player.getWnBag().discardItem(modValue, 0, null);


                flag = true;
            }
        }

        if (flag) {
            int areaId = transportProp.targetMap;
            Map<String, Integer> targetPoint = transportProp.targetPoint_;
            if (targetPoint != null && targetPoint.size() > 0) {
                AreaUtil.enterArea(player, areaId, ((Integer) targetPoint.get("targetX")).intValue(), ((Integer) targetPoint.get("targetY")).intValue());
            } else {
                AreaUtil.enterArea(player, areaId, 0.0F, 0.0F);
            }
            return true;
        }
        return false;
    }

    public static boolean isRobot(PlayerPO player) {
        return (GWorld.ROBOT && player.uid.startsWith("robot") && !player.uid.endsWith("hoolai"));
    }


    public static AllBlobPO createPlayer(String playerId, String uid, String name, int pro, int logicServerId) {
        AllBlobPO allBlobData = new AllBlobPO();
        PlayerPO player = createPlayerPO(playerId, uid, name, pro, logicServerId);
        allBlobData.player = player;
        PlayerPOManager.put(ConstsTR.playerTR, playerId, (GEntity) player);

        allBlobData.playerBase = createBaseData(playerId);

        allBlobData.playerTemp = createTempData(playerId);

        PlayerAttachPO playerAttachPO = new PlayerAttachPO();
        allBlobData.playerAttachPO = playerAttachPO;
        playerAttachPO.firstKillMonsterIds = new ArrayList();

        createShopMall(playerId);

        allBlobData.tasks = createTasks(playerId, 1);

        BagsPO bagsPO = new BagsPO(createBag(), createWareHouse(), createRecycle());
        PlayerPOManager.put(ConstsTR.bagTR, playerId, (GEntity) bagsPO);

        SkillsPO skills = createSkills(pro, 1);
        PlayerPOManager.put(ConstsTR.skillTR, playerId, (GEntity) skills);

        playerAttachPO.sysSet = createSysSetManager();

        allBlobData.hookSetData = createHookSetManager(playerId);

        createActivityManager(playerId);

        PlayerPOManager.put(ConstsTR.player_fightlevelTR, playerId, (GEntity) new FightLevelsPO());

        createAttendance(playerId);

        createTitle(playerId);

        createConsignment(playerId);

        createOnlineData(playerId, Const.ONLINE_GIFT_TYPE.FIRST_DAY, player.upLevel, player.level);

        PlayerPOManager.put(ConstsTR.mailTR, playerId, (GEntity) new PlayerMailDataPO());

        PlayerPOManager.put(ConstsTR.player_dailyTR, playerId, (GEntity) new DailyActivityPO());

        PlayerPOManager.put(ConstsTR.player_func_openTR, playerId, (GEntity) new FunctionOpenPO());

        PlayerPOManager.put(ConstsTR.pkRuleTR, playerId, (GEntity) new PlayerPKDataPO());

        PlayerPOManager.put(ConstsTR.player_arena_dataTR, playerId, (GEntity) new ArenaDataPO());

        PlayerPOManager.put(ConstsTR.player_leaderboardTR, playerId, (GEntity) new LeaderBoardPlayerPO());

        PlayerPOManager.put(ConstsTR.player_friendsTR, playerId, (GEntity) new PlayerFriendsPO());

        playerAttachPO.sceneProgress = new HashMap<>();
        playerAttachPO.vipData = new VipPO();

        allBlobData.chouRens = new PlayerChouRenPO();
        PlayerPOManager.put(ConstsTR.player_chourenTR, playerId, (GEntity) allBlobData.chouRens);

        allBlobData.achievements = new AchievementDataPO();
        allBlobData.achievements.achievements = new HashMap<>();
        playerAttachPO.medal = new MedalPO();
        PlayerPOManager.put(ConstsTR.achievementTR, playerId, (GEntity) allBlobData.achievements);

        PlayerPOManager.put(ConstsTR.playerPetTR, playerId, (GEntity) new PlayerPetsNewPO());

        PlayerPOManager.put(ConstsTR.player_solo_dataTR, playerId, (GEntity) new SoloDataPO(playerId));

        allBlobData.five2FivePo = Five2FiveService.getInstance().createFive2FivePO(playerId);
        PlayerPOManager.put(ConstsTR.five2FiveTR, playerId, (GEntity) allBlobData.five2FivePo);


        allBlobData.xianYuan = XianYuanService.getInstance().createXianYuan(playerId);
        PlayerPOManager.put(ConstsTR.xianYuanTR, playerId, (GEntity) allBlobData.xianYuan);

        CharacterExt characterProp = (CharacterExt) GameData.Characters.get(Integer.valueOf(pro));

        List<CharacterExt.InitItem> initItems = characterProp.initItems;
        int index = 1;
        for (int i = 0; i < initItems.size(); i++) {
            CharacterExt.InitItem itemData = initItems.get(i);
            DItemEquipBase itemProp = ItemUtil.getPropByCode(itemData.itemCode);
            if (itemProp != null) {
                List<NormalItem> items = ItemUtil.createItemsByItemCode(itemData.itemCode, itemData.itemNum);
                for (int j = 0; j < items.size(); j++) {
                    if (index <= bagsPO.bagData.bagGridCount) {
                        NormalItem item = items.get(j);
                        bagsPO.bagData.bagGrids.put(Integer.valueOf(index), item.itemDb);
                        index++;
                    }
                }
            } else {
                Out.warn(new Object[]{"角色初始化添加物品失败 player pro:", Integer.valueOf(pro), "itemCode:", itemData.itemCode});
            }
        }


        allBlobData.playerBase.equipGrids = new HashMap<>();
        List<String> equips = isRobot(player) ? Arrays.<String>asList(new String[]{"lweap1-test", "lclot1-test"}) : characterProp.initEquips;
        for (String code : equips) {

            NormalEquip equip = ItemUtil.createItemsByItemCode(code, 1).get(0);
            equip.setBind(1);
            allBlobData.playerBase.equipGrids.put(Integer.valueOf(equip.prop.itemSecondType), equip.itemDb);
        }

        PlayerPOManager.put(ConstsTR.bagTR, playerId, (GEntity) bagsPO);
        PlayerPOManager.put(ConstsTR.playerAttachTR, playerId, (GEntity) playerAttachPO);
        PlayerPOManager.put(ConstsTR.playerBaseTR, playerId, (GEntity) allBlobData.playerBase);


        PlayerPOManager.sync(playerId);
        return allBlobData;
    }

    public static OnlineDataPO createOnlineData(String playerId, Const.ONLINE_GIFT_TYPE giftType, int upLevel, int level) {
        OnlineDataPO onlineData = new OnlineDataPO();
        PlayerPOManager.put(ConstsTR.onlineGiftTR, playerId, (GEntity) onlineData);
        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(giftType.getValue(), upLevel, level);
        for (int i = 0; i < propList.size(); i++) {
            onlineData.rewardState.put(Integer.valueOf(((OlGiftExt) propList.get(i)).giftId), Integer.valueOf(PlayerAttendance.GiftState.NO_RECEIVE.getValue()));
        }
        return onlineData;
    }

    public static void createConsignment(String playerId) {
        PlayerConsignmentItemsPO po = new PlayerConsignmentItemsPO();
        PlayerPOManager.put(ConstsTR.player_consignmentTR, playerId, (GEntity) po);
    }

    public static void createTitle(String playerId) {
        TitlePO titlePO = new TitlePO();
        titlePO.awardRanks = new HashMap<>();
        titlePO.selectedRankId = 0;
        PlayerPOManager.put(ConstsTR.playerTitleTR, playerId, (GEntity) titlePO);
    }

    public static PlayerPO createPlayerPO(String playerId, String uid, String name, int pro, int logicServerId) {
        PlayerPO player = new PlayerPO();
        player.id = playerId;
        player.uid = uid;
        player.name = name;
        player.logicServerId = logicServerId;
        player.isDelete = 0;
        player.level = 1;
        player.exp = 0L;
        player.prestige = 0;
        player.pro = pro;

        player.gold = 0;
        player.ticket = 0;
        player.diamond = 0;
        player.totalCostDiamond = 0;

        player.friendly = 0;

        player.consumePoint = 0;
        player.charm = 100;
        player.pawnGold = 0;
        player.guildpoint = 0;
        player.treasurePoint = 0;
        player.vip = Const.VipType.none.value;
        Date date = new Date();
        player.isAcceptAutoTeam = GlobalConfig.TeamAutoInvite;
        player.createTime = date;
        player.loginTime = date;
        player.logoutTime = date;
        player.refreshTime = date;
        player.fightPower = 0;


        return player;
    }

    public static PlayerTempPO createTempData(String playerId) {
        PlayerTempPO tempData = new PlayerTempPO();
        tempData.historyAreaId = GlobalConfig.motherland;
        tempData.historyX = 0.0F;
        tempData.historyY = 0.0F;
        tempData.bornAreaId = GlobalConfig.motherland;
        tempData.bornX = 0.0F;
        tempData.bornY = 0.0F;
        tempData.x = 0.0F;
        tempData.y = 0.0F;
        tempData.hp = 999999;
        tempData.mp = 999999;
        tempData.areaId = GlobalConfig.motherland;

        PlayerPOManager.put(ConstsTR.playerTempTR, playerId, (GEntity) tempData);

        return tempData;
    }


    public static PlayerBasePO createBaseData(String playerId) {
        PlayerBasePO playerBasePO = new PlayerBasePO();
        playerBasePO.equipGrids = new HashMap<>();
        playerBasePO.strengthPos = new HashMap<>();

        int gridsCount = (Const.EquipType.values()).length;
        for (int i = 1; i <= gridsCount; i++) {
            EquipSockExt sockCO = (EquipSockExt) GameData.EquipSocks.get(Integer.valueOf(i));
            playerBasePO.equipGrids.put(Integer.valueOf(i), null);
            PlayerBasePO.EquipStrengthPos pos = new PlayerBasePO.EquipStrengthPos();
            pos.enSection = 0;
            pos.enLevel = 0;
            pos.socks = 0;
            pos.gems = new HashMap<>();
            for (int j = 1; j <= sockCO.sockOpenLevel.size(); j++) {


                if (1 >= ((Integer) sockCO.sockOpenLevel.get(Integer.valueOf(j))).intValue()) {
                    pos.socks++;
                }
            }
            playerBasePO.strengthPos.put(Integer.valueOf(i), pos);
        }
        return playerBasePO;
    }

    private static ShopMallPO createShopMall(String playerId) {
        Map<Integer, Map<Integer, Boolean>> seenTab = new HashMap<>();
        seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()), new HashMap<>());
        seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()), new HashMap<>());

        ShopMallPO shopMall = new ShopMallPO(seenTab);

        PlayerPOManager.put(ConstsTR.shopMallTR, playerId, (GEntity) shopMall);

        return shopMall;
    }

    private static ActivityDataPO createActivityManager(String playerId) {
        ActivityDataPO activityData = new ActivityDataPO();

        activityData.activityRewardRecorder = new HashMap<>();

        activityData.activityInfo = new HashMap<>();

        activityData.luckyAwardContainer = new ArrayList();
        activityData.drawedContainer = new HashMap<>();
        activityData.refreshTime = new Date();
        activityData.buffTimes = 1;

        PlayerPOManager.put(ConstsTR.activityTR, playerId, (GEntity) activityData);

        return activityData;
    }

    private static int createSysSetManager() {
        int ret = 1;
        ret |= SysSetFlag.recvMailSet.getValue();
        ret |= SysSetFlag.teamInviteSet.getValue();
        ret |= SysSetFlag.recvStrangerMsgSet.getValue();
        ret |= SysSetFlag.recvAddFriendSet.getValue();
        return ret;
    }

    public static HookSetPO createHookSetManager(String playerId) {
        HookSetPO hootSet = new HookSetPO(playerId);
        hootSet.hpPercent = GlobalConfig.Auto_HP_Percent;
        hootSet.mpPercent = GlobalConfig.Auto_MP_Percent;
        hootSet.hpItemCode = GlobalConfig.Auto_HP_Item;
        hootSet.mpItemCode = GlobalConfig.Auto_MP_Item;
        hootSet.pkSet = GlobalConfig.Auto_PK_Reaction;
        hootSet.meltQcolor.add(Integer.valueOf(GlobalConfig.Auto_Eqip_Qcolor));
        hootSet.autoBuyHpItem = 1;
        hootSet.autoBuyMpItem = 0;
        hootSet.fieldMaphook = 0;
        hootSet.areaMaphook = 0;

        PlayerPOManager.put(ConstsTR.hookSetTR, playerId, (GEntity) hootSet);

        return hootSet;
    }

    public static AttendancePO createAttendance(String playerId) {
        AttendancePO sign = new AttendancePO();

        sign.stage = 1;
        sign.lastSignTime = DateUtil.getZeroDate();
        sign.signMap = new HashMap<>();
        sign.cumulativeMap = new HashMap<>();
        sign.lastLuxuryTime = DateUtil.getZeroDate();
        sign.luxuryState = PlayerAttendance.GiftState.NO_RECEIVE.getValue();

        PlayerPOManager.put(ConstsTR.player_signTR, playerId, (GEntity) sign);
        return sign;
    }

    public static TaskListPO createTasks(String playerId, int level) {
        TaskListPO tasks = new TaskListPO();
        tasks.normalTasks = new HashMap<>();
        tasks.dailyTasks = new HashMap<>();
        tasks.treasureTasks = new HashMap<>();
        tasks.finishedNormalTasks = new HashMap<>();
        tasks.finishedDailyTasks = new HashMap<>();
        tasks.finishedTreasureTasks = new HashMap<>();
        tasks.loopResult = new LoopResult();

        for (MainLineCO main : GameData.MainLines.values()) {
            if (main.before.equals("0")) {

                TaskData task = TaskUtils.createTask((TaskBase) main);
                tasks.normalTasks.put(Integer.valueOf(task.db.templateId), task.toJson4Serialize());

                break;
            }
        }
        for (BranchLineCO branch : GameData.BranchLines.values()) {
            if (branch.before.equals("0") && branch.level <= level) {

                TaskData task = TaskUtils.createTask((TaskBase) branch);
                tasks.normalTasks.put(Integer.valueOf(task.db.templateId), task.toJson4Serialize());
            }
        }

        PlayerPOManager.put(ConstsTR.taskTR, playerId, (GEntity) tasks);
        return tasks;
    }

    private static SkillsPO createSkills(int pro, int initLevel) {
        SkillsPO skills = SkillManager.initNewPlayerSkills(pro, initLevel);
        skills.skillKeys = createSkillKeys(pro);
        return skills;
    }

    private static Map<Integer, Integer> createSkillKeys(int pro) {
        Map<Integer, Integer> allSkillKeys = new HashMap<>();
        for (int j = 0; j < 11; j++) {
            allSkillKeys.put(Integer.valueOf(j), Integer.valueOf(-1));
        }
        Out.debug(new Object[]{PlayerUtil.class, "createSkillKeys: ", allSkillKeys});
        return allSkillKeys;
    }

    public static BagPO createBag() {
        BagPO data = new BagPO();
        data.bagGrids = new HashMap<>();
        data.bagGridCount = GlobalConfig.Package_DefaultSize;
        return data;
    }

    public static BagPO createWareHouse() {
        BagPO data = new BagPO();
        data.bagGrids = new HashMap<>();
        data.bagGridCount = GlobalConfig.PersonalWarehouse_DefaultSize;
        return data;
    }

    public static BagPO createRecycle() {
        BagPO data = new BagPO();
        data.bagGrids = new HashMap<>();
        data.bagGridCount = GlobalConfig.Package_MaxSize;
        return data;
    }

    public static String getRandomName(int pro) {
        String firstName = getFirstName();
        if (firstName.length() <= 0) {
            return null;
        }

        String lastName = getLastName(pro);

        if (lastName.length() <= 0) {
            return null;
        }


        if (GWorld.__SERVER_LANG == XLang.VN) {
            return firstName + " " + lastName;
        }

        return firstName + lastName;
    }

    public static String getFirstName() {
        List<PrefixCO> first_list = (PlayerConfig.getInstance()).randomname_prefix;
        if (first_list.size() <= 0) {
            return "";
        }
        int rndIndex = Utils.random(0, first_list.size() - 1);
        return ((PrefixCO) first_list.get(rndIndex)).prefix;
    }

    private static int _getSexByPro(int pro) {
        if (pro == Const.PlayerPro.CANG_LANG.value || pro == Const.PlayerPro.YI_XIAN.value || pro == Const.PlayerPro.SHEN_JIAN.value || pro == Const.PlayerPro.COMMON.value) {
            return 1;
        }
        return 0;
    }

    public static String getLastName(int pro) {
        List<SuffixCO> lastWomanList = (PlayerConfig.getInstance()).randomname_suffix.get(Integer.valueOf(0));
        List<SuffixCO> lastManList = (PlayerConfig.getInstance()).randomname_suffix.get(Integer.valueOf(1));

        int sex = _getSexByPro(pro);
        List<SuffixCO> last_list = null;
        if (sex == 0) {
            last_list = lastWomanList;
        } else {
            last_list = lastManList;
        }

        if (last_list == null || last_list.size() <= 0) {
            return "";
        }

        int rndIndex = Utils.random(0, last_list.size() - 1);
        return ((SuffixCO) last_list.get(rndIndex)).suffix;
    }

    public static void onFishItem(WNPlayer player, String tc, String extendTc) {
        Out.debug(new Object[]{PlayerUtil.class, "onFishItem tc:", tc, "  extendTc:", extendTc});
        List<NormalItem> items = ItemUtil.createItemsByTcCode(tc);
        Out.debug(new Object[]{PlayerUtil.class, "onFishItem:" + tc});
        List<NormalItem> extendItems = null;
        if (StringUtil.isNotEmpty(extendTc)) {
            extendItems = ItemUtil.createItemsByTcCode(extendTc);
            items.addAll(extendItems);
        }

        Out.debug(new Object[]{PlayerUtil.class, "onFishItem 2222:", Integer.valueOf(items.size())});
        if (items.size() <= 0) {
            player.sendSysTip(LangService.getValue("FISH_FAILED"), Const.TipsType.BLACK);


            return;
        }


        if (!player.bag.testEmptyGridLarge(ItemUtil.getPackUpItemsNum(items))) {
            return;
        }


        if (extendItems != null) {
            for (NormalItem dropItem : extendItems) {
                player.taskManager.dealTaskEvent(Const.TaskType.FISH, dropItem.itemDb.code, dropItem.itemDb.groupCount);
            }
        }

        player.bag.addEntityItems(items, Const.GOODS_CHANGE_TYPE.fish, null);
        List<ItemOuterClass.MiniItem> miniItem = new ArrayList<>();

        for (NormalItem v : items) {
            miniItem.add(ItemUtil.getMiniItemData(v.itemDb.code, v.itemDb.groupCount, Const.ForceType.getE(v.getBind())).build());
        }


        player.onFishItem(miniItem);
    }


    public static String getColorPlayerNameByPro(int pro, String playerName) {
        return playerName;
    }


    public static final String getUpLevelName(int upLevel, int pro) {
        String name = "";
        UpLevelExpExt prop = PlayerConfig.getInstance().findupLevelExpPropsByUpLevelAndPro(upLevel, pro);
        if (prop == null) {
            return name;
        }
        int qColor = prop.qcolor;

        String colorInfo = LangService.getValue("WHITE");
        if (qColor == 1) {
            colorInfo = LangService.getValue("GREEN");
        } else if (qColor == 2) {
            colorInfo = LangService.getValue("BLUE");
        } else if (qColor == 3) {
            colorInfo = LangService.getValue("PURPLE");
        } else if (qColor == 4) {
            colorInfo = LangService.getValue("ORANGE");
        } else if (qColor == 5) {
            colorInfo = LangService.getValue("RED");
        }
        colorInfo = colorInfo.replace("{a}", prop.uPName);
        return colorInfo;
    }


    public static String getFullColorName(WNPlayer player) {
        StringBuilder name = new StringBuilder(getColorPlayerNameByPro(player.getPro(), player.getName()));
        name.append("(");
        String whiteColorInfo = LangService.getValue("WHITE");
        String pro = "";
        CharacterCO character = (CharacterCO) GameData.Characters.get(Integer.valueOf(player.getPro()));
        if (character != null) {
            pro = character.proName + ", ";
        }
        name.append(whiteColorInfo.replace("{a}", pro + player.getLevel() + "级"));

        name.append(")");
        return name.toString();
    }

    public static int initCurMaxLv(PlayerPO baseData) {
        return GlobalConfig.Role_LevelLimit;
    }


    public static Collection<GPlayer> getAllOnlinePlayer() {
        return GWorld.getInstance().getOnlinePlayers().values();
    }

    public static void bi(Class<?> clazz, Const.BiLogType logType, WNPlayer player, Object... args) {
        if (player == null) {
            Out.error(new Object[]{logType.desc, " player is null"});
            return;
        }
        bi(clazz, logType, player.player, args);
    }


    public static void bi(Class<?> clazz, Const.BiLogType logType, PlayerPO player, Object... args) {
        if (!GWorld.ROBOT) {
            StringBuilder builder = new StringBuilder();
            builder.append(player.uid).append(", ").append(player.id).append(", ");
            builder.append(player.name).append(", ").append(player.logicServerId).append(", ");
            builder.append(player.pro).append(", ").append(player.level).append(",");
            builder.append(player.upLevel).append(", ").append(player.vip).append(", ");
            builder.append(player.fightPower).append(", ").append(player.gold).append(", ");
            builder.append(player.diamond).append(", ").append(player.ticket);
            for (Object arg : args) {
                builder.append(", ").append(arg);
            }
            Out.info(new Object[]{clazz.getName(), "::", logType.desc, "::, ", builder});
        }
    }

    public static void logWarnIfPlayerNull(Packet packet) {
        if (packet == null) {
            Out.warn(new Object[]{"发现PlayerNUll.啥信息都没!"});
            return;
        }
        Channel c = packet.getSession();
        if (c == null) {
            Out.warn(new Object[]{"发现PlayerNUll.只有包信息!"});
            return;
        }
        Out.warn(new Object[]{"发现PlayerNUll.", c.remoteAddress()});
    }

    public static void addLoginServer(String uid, int sid, int count) {
        String playerServers = AuthServer.get("/player/servers/" + uid);
        JSONArray loginServers = null;
        if (StringUtil.isNotEmpty(playerServers)) {
            loginServers = JSON.parseArray(playerServers);
        } else {
            loginServers = new JSONArray();
        }
        for (int i = loginServers.size() - 1; i >= 0; i--) {
            JSONObject jSONObject = loginServers.getJSONObject(i);
            if (jSONObject.getIntValue("sid") == sid) {
                if (jSONObject.getIntValue("count") == count) {
                    return;
                }
                if (count == 0) {
                    loginServers.remove(i);
                } else {
                    jSONObject.put("count", Integer.valueOf(count));
                }
                AuthServer.put("/player/servers/" + uid, loginServers.toJSONString());
                return;
            }
        }
        JSONObject json = new JSONObject();
        json.put("sid", Integer.valueOf(sid));
        json.put("count", Integer.valueOf(count));
        loginServers.add(json);
        AuthServer.put("/player/servers/" + uid, loginServers.toJSONString());
    }
}


