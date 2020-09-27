package com.wanniu.game.player;


import Xmds.GetPlayerData;
import Xmds.RefreshPlayerPropertyChange;
import Xmds.SkillDataICE;
import Xmds.XmdsManagerPrx;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.StringUtil;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.game.GWorld;
import com.wanniu.game.achievement.AchievementManager;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.activity.DemonTowerManager;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.DropManager;
import com.wanniu.game.area.PlayerRemote;
import com.wanniu.game.area.SceneProgressManager;
import com.wanniu.game.arena.ArenaManager;
import com.wanniu.game.attendance.PlayerAttendance;
import com.wanniu.game.auction.AuctionManager;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.blood.BloodManager;
import com.wanniu.game.buffer.BufferManager;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.consignmentShop.ConsignmentManager;
import com.wanniu.game.consignmentShop.ConsignmentUtil;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.data.CharacterCO;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.EventCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.fashion.FashionManager;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.five2Five.Five2FiveManager;
import com.wanniu.game.flee.FleeManager;
import com.wanniu.game.friend.ChouRenManager;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.friend.FriendsCenter;
import com.wanniu.game.functionOpen.FunctionOpenManager;
import com.wanniu.game.guild.GuildManager;
import com.wanniu.game.guild.dao.FindPlayerGuildDao;
import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankManager;
import com.wanniu.game.guild.guildBoss.GuildBossManager;
import com.wanniu.game.guild.guildFort.GuildFortManager;
import com.wanniu.game.hookSet.HookSetManager;
import com.wanniu.game.illusion.IllusionManager;
import com.wanniu.game.interact.PlayerInteract;
import com.wanniu.game.intergalmall.IntergalMallManager;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.leaderBoard.LeaderBoardManager;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.game.mail.MailManager;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.message.PlayerMessages;
import com.wanniu.game.money.MoneyManager;
import com.wanniu.game.mount.MountCenter;
import com.wanniu.game.mount.MountManager;
import com.wanniu.game.onlineGift.OnlineGiftManager;
import com.wanniu.game.petNew.PetCenter;
import com.wanniu.game.petNew.PetManager;
import com.wanniu.game.petNew.PetNew;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.player.po.AvatarObj;
import com.wanniu.game.playerData.PlayerBaseDataManager;
import com.wanniu.game.playerData.PlayerBtlDataManager;
import com.wanniu.game.playerSkill.SkillManager;
import com.wanniu.game.playerSkillKey.SkillKeyManager;
import com.wanniu.game.poes.ActivityDataPO;
import com.wanniu.game.poes.AttendancePO;
import com.wanniu.game.poes.BagsPO;
import com.wanniu.game.poes.DailyActivityPO;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.poes.FunctionOpenPO;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.IllusionPO;
import com.wanniu.game.poes.MonsterDropPO;
import com.wanniu.game.poes.MountPO;
import com.wanniu.game.poes.OnlineDataPO;
import com.wanniu.game.poes.PlayerAttachPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerConsignmentItemsPO;
import com.wanniu.game.poes.PlayerPKDataPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.PlayerPetsNewPO;
import com.wanniu.game.poes.PlayerTempPO;
import com.wanniu.game.poes.ShopMallPO;
import com.wanniu.game.poes.SkillsPO;
import com.wanniu.game.poes.TitlePO;
import com.wanniu.game.prepaid.PrepaidManager;
import com.wanniu.game.rank.RankManager;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.rank.TitleManager;
import com.wanniu.game.recent.RecentChatCenter;
import com.wanniu.game.recent.RecentChatMgr;
import com.wanniu.game.request.task.TaskMessages;
import com.wanniu.game.revelry.RevelryManager;
import com.wanniu.game.rich.RichManager;
import com.wanniu.game.sale.SaleManager;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.shopMall.ShopMallManager;
import com.wanniu.game.solo.SoloManager;
import com.wanniu.game.sysSet.SysSetInfo;
import com.wanniu.game.task.PlayerTasks;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskQueue;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamManager;
import com.wanniu.game.team.TeamService;
import com.wanniu.game.util.RobotUtil;
import com.wanniu.game.vip.VipManager;
import com.wanniu.game.xianyuan.XianYuanService;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.GlobalDao;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import pomelo.Common;
import pomelo.area.FunctionHandler;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


public class WNPlayer
        extends GPlayer {
    public Map<Const.ManagerType, ModuleManager> allManagers = new HashMap<>();

    public AllBlobPO allBlobData;

    public PlayerPO player;

    public PlayerBasePO playerBasePO;

    public PlayerAttachPO playerAttachPO;

    public PlayerTempPO playerTempData;

    public CharacterCO basicProp;

    public WNBag bag;

    public WNBag recycle;

    public WNBag wareHouse;

    public PlayerBaseDataManager baseDataManager;

    public PlayerBtlDataManager btlDataManager;

    public EquipManager equipManager;

    public FashionManager fashionManager;

    public BloodManager bloodManager;

    public OnlineGiftManager onlineGiftManager;

    public MailManager mailManager;

    public FightLevelManager fightLevelManager;

    public DropManager dropManager;

    public SysSetInfo sysSetManager;

    public VipManager vipManager;

    public PkRuleManager pkRuleManager;

    public BufferManager bufferManager;

    public SceneProgressManager sceneProgressManager;

    public PlayerAttendance playerAttendance;

    public ShopMallManager shopMallManager;

    public IntergalMallManager intergalMallManager;

    public GuildBossAreaHurtRankManager guildBossAreaHurtRankManager;

    public AchievementManager achievementManager;

    public ArenaManager arenaManager;

    public GuildBossManager guildBossManager;

    public GuildFortManager guildFortManager;

    public SoloManager soloManager;

    public LeaderBoardManager leaderBoardManager;

    public Five2FiveManager five2FiveManager;

    public AuctionManager auctionManager;

    public HookSetManager hookSetManager;

    public TitleManager titleManager;

    public MountManager mountManager;

    public FunctionOpenManager functionOpenManager;

    public PlayerTasks taskManager;

    public PlayerMessages messageManager;

    public PetManager petNewManager;

    public SkillManager skillManager;

    public SkillKeyManager skillKeyManager;

    public DailyActivityMgr dailyActivityMgr;

    public FarmMgr farmMgr;

    public ConsignmentManager consignmentManager;

    public SaleManager saleManager;

    public PrepaidManager prepaidManager;

    public ActivityManager activityManager;

    public DemonTowerManager demonTowerManager;
    public FriendManager friendManager;
    public ChouRenManager chouRenManager;
    public IllusionManager illusionManager;
    public GuildManager guildManager;
    public TeamManager teamManager;
    public FleeManager fleeManager;
    public MoneyManager moneyManager;
    public RankManager rankManager;
    public RichManager richManager;
    public SevenGoalManager sevenGoalManager;
    public int bornType = Const.BORN_TYPE.NORMAL.value;
    public int enterState = Const.ENTER_STATE.online.value;
    public Map<Integer, Long> chatTime;
    public Area area;
    private int force;
    private boolean todayLogined;
    public List<String> chatLog;
    private String battleServerId;
    private long lastChangeTime;
    private PlayerInteract interactManager;
    private ReliveManager reliveManager;
    public Map<String, WNPlayer> teamMembers;

    public List<String> getChatLog() {
        return this.chatLog;
    }

    public void setChatLog(List<String> chatLog) {
        this.chatLog = chatLog;
    }


    public void receive(String route, GeneratedMessage msg) {
        write((Message) new MessagePush(route, msg));
    }

    public HookSetManager getHookSet() {
        if (this.hookSetManager == null) {
            this.hookSetManager = new HookSetManager(this, this.allBlobData.hookSetData);
        }
        return this.hookSetManager;
    }


    public String getId() {
        return this.player.id;
    }

    public int getLogicServerId() {
        return this.player.logicServerId;
    }

    public int getAcrossServerId() {
        return GWorld.__ACROSS_SERVER_ID;
    }

    public String getInstanceId() {
        return this.area.instanceId;
    }

    public int getAreaId() {
        return this.area.areaId;
    }

    public int getLineIndex() {
        return this.area.lineIndex;
    }

    public int getSceneType() {
        return this.area.sceneType;
    }

    public String getSceneName() {
        return this.area.getSceneName();
    }


    public String getUid() {
        return this.player.uid;
    }


    public String getName() {
        return this.player.name;
    }

    public int getLevel() {
        return this.player.level;
    }

    public long getExp() {
        return this.player.exp;
    }

    public int getPro() {
        return this.player.pro;
    }

    public int getUpLevel() {
        return this.player.upLevel;
    }

    public int getUpOrder() {
        return this.player.upOrder;
    }

    public int getFightPower() {
        return this.player.fightPower;
    }

    public PlayerPO getPlayer() {
        return this.player;
    }

    public PlayerBasePO getPlayerAttach() {
        return this.playerBasePO;
    }

    public PlayerTempPO getPlayerTempData() {
        return this.playerTempData;
    }

    public void setPlayerTempData(PlayerTempPO playerTempData) {
        this.playerTempData = playerTempData;
    }

    public WNBag getWnBag() {
        return this.bag;
    }

    public void setWnBag(WNBag wnBag) {
        this.bag = wnBag;
    }

    public PlayerTasks getPlayerTasks() {
        return this.taskManager;
    }

    public void setPlayerTasks(PlayerTasks playerTasks) {
        this.taskManager = playerTasks;
    }

    public FriendManager getFriendManager() {
        return this.friendManager;
    }

    public FarmMgr getFarmMgr() {
        return this.farmMgr;
    }

    public RecentChatMgr getRecentChatMgr() {
        return RecentChatCenter.getInstance().getRecentChatMgr(getId());
    }

    public void setFriendManager(FriendManager friendManager) {
        this.friendManager = friendManager;
    }

    public ChouRenManager getChouRenManager() {
        return this.chouRenManager;
    }

    public void setChouRenManager(ChouRenManager chouRenManager) {
        this.chouRenManager = chouRenManager;
    }

    public TeamManager getTeamManager() {
        return this.teamManager;
    }

    public void setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    public IntergalMallManager getIntergalMallManager() {
        if (this.intergalMallManager == null) {
            this.intergalMallManager = new IntergalMallManager(this);
        }
        return this.intergalMallManager;
    }


    public void sync() {
        update();
        PlayerPOManager.sync(getId());
    }

    public Date getLogoutTime() {
        return this.player.logoutTime;
    }

    public void setLogoutTime(Date date) {
        this.baseDataManager.setLogoutTime(date);
    }


    public void onLogout(boolean self) {
        Out.debug(new Object[]{"---------------------logout begin----------------------- uid : ", getUid()});
        long startTime = System.nanoTime();

        Area area = getArea();
        if (area != null) {
            try {
                if (area.isNormal() && area.hasPlayer(getId())) {
                    GetPlayerData result = area.getPlayerData(getId());
                    if (result != null) {
                        syncNowData(area.areaId, area.instanceId, result);
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            } finally {
                try {
                    this.recycle.removeAllItems();
                    PlayerRemote.syncPlayerDataOffline(this, area);
                    area.onPlayerLogout(this);
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        }

        TeamService.onLogout(this);

        GWorld.getInstance().ansycExec(() -> {
            JSONObject players = new JSONObject();

            List<String> list_ids = PlayerDao.getPlayerIdsByUid(getUid(), getLogicServerId());

            for (String playerId : list_ids) {
                PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);

                if (baseData != null) {
                    JSONObject player = new JSONObject();

                    player.put("lv", Integer.valueOf(baseData.level));
                    player.put("name", baseData.name);
                    player.put("pro", Integer.valueOf(baseData.pro));
                    player.put("time", Long.valueOf(baseData.logoutTime.getTime()));
                    players.put(playerId, player);
                }
            }
            GlobalDao.hset(String.valueOf(getLogicServerId()), getUid(), players.toJSONString());
            if (players.size() != list_ids.size()) {
                list_ids.clear();
                for (String playerId : players.keySet()) {
                    list_ids.add(playerId);
                }
                PlayerDao.updatePlayerIds(getUid(), getLogicServerId(), list_ids);
            }
            PlayerUtil.addLoginServer(getUid(), getLogicServerId(), players.size());
        });
        float useTime = (float) (System.nanoTime() - startTime) / 1000000.0F;
        Out.info(new Object[]{"角色退出游戏 uid=", getUid(), ",playerId=", getId(), ",name=", getName(), ",useTime=", Float.valueOf(useTime), " ms"});
        BILogService.getInstance().ansycReportLogout(this);
    }


    public void onReady() {
        this.functionOpenManager.checkFunctoinAward();
    }


    public void onLogin() {
        this.baseDataManager.setLoginTime(new Date());


        WNNotifyManager.getInstance().pushPlayerBattleData(this);


        refreshNewDay();


        this.functionOpenManager.init();

        this.achievementManager.playerLevelChange(this.player.level);

        this.teamManager.loginFlag = this.teamManager.isInTeam();
        this.onlineGiftManager.onLogin();


        this.taskManager.onLogin();


        this.activityManager.onLogin();

        this.dailyActivityMgr.onLogin();

        this.shopMallManager.onLogin();


        this.guildManager.onLogin();

        this.equipManager.onLogin();

        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.AFTER_LOGIN);
        }


        if (!this.todayLogined) {
            this.todayLogined = true;
            updateSuperScript(Const.SUPERSCRIPT_TYPE.INTERGAL_MALL, 1);
        }


        RevelryManager.getInstance().onLogin(this);


        RechargeActivityService.getInstance().onLogin(this);
    }

    public WNPlayer(AllBlobPO allBlobData) {
        this.battleServerId = GWorld.__CS_NODE.getNodeId();
        _init(allBlobData);
    }

    public WNPlayer(PlayerPO player) {
        this.battleServerId = GWorld.__CS_NODE.getNodeId();
        this.player = player;
    }

    public WNPlayer() {
        this.battleServerId = GWorld.__CS_NODE.getNodeId();
    }

    public void setBattleServerId(String battleServerId) {
        if (!this.battleServerId.equals(battleServerId)) {
            this.battleServerId = battleServerId;
            bindBattleServer(battleServerId);
        }
    }


    public String getBattleServerId() {
        return this.battleServerId;
    }

    public JSONObject toJSON4EnterScene(Area area) {
        if (!AreaUtil.canRideMount(this.area.areaId)) {
            this.mountManager.unMountData();
        }
        JSONObject data = new JSONObject();
        data.put("effects", _getBattlerServerEffect());
        data.put("skills", this.skillManager.toJson4BattleServer());
        data.put("tasks", _getBattleServerTask());
        data.put("flags", _getBattleServerTaskFlag());
        data.put("playerEntered", Boolean.valueOf(area.hasPlayerEntered));
        data.put("avatars", PlayerUtil.getBattlerServerAvatarObj(this));
        data.put("basic", _getBattlerServerBasic());
        data.put("connectServerId", getBattleServerId());
        data.put("uid", getId());
        data.put("unitTemplateID", Integer.valueOf(this.player.pro));
        data.put("force", Integer.valueOf(this.force));
        data.put("robot", Boolean.valueOf(isRobot()));
        if (this.enterState == Const.ENTER_STATE.changeArea.value) {
            recoverHPAndMP();
        }
        Map<String, Number> tempData = new HashMap<>();
        if (this.playerTempData.hp == 0) {
            float x = 0.0F, y = 0.0F, direction = 0.0F;
            if (area.areaId == this.playerTempData.historyAreaId) {
                x = this.playerTempData.historyX;
                y = this.playerTempData.historyY;
                direction = this.playerTempData.historyDirection;
            }
            tempData.put("x", Float.valueOf(x));
            tempData.put("y", Float.valueOf(y));
            tempData.put("direction", Float.valueOf(direction));
            tempData.put("hp", (Number) this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP));
            tempData.put("mp", Integer.valueOf(this.playerTempData.mp));
        } else {
            tempData.put("x", Float.valueOf(this.playerTempData.x));
            tempData.put("y", Float.valueOf(this.playerTempData.y));
            tempData.put("direction", Float.valueOf(this.playerTempData.direction));
            tempData.put("hp", Integer.valueOf(this.playerTempData.hp));
            tempData.put("mp", Integer.valueOf(this.playerTempData.mp));
        }
        data.put("tempData", tempData);

        data.put("pkInfo", this.pkRuleManager.getPkDataToBattleJson());
        Map<String, Object> petBase = this.petNewManager.getBattlerServerPetBase();
        data.put("petBase", petBase);
        if (petBase.get("Model").equals("")) {
            data.put("addTestPetData", Integer.valueOf(0));
        } else {
            data.put("addTestPetData", Integer.valueOf(1));
            data.put("petEffect", this.petNewManager.getBattlerServerPetEffect());
            data.put("petSkill", this.petNewManager.getBattlerServerPetSkill());
            data.put("petMode", Integer.valueOf(this.petNewManager.getPkDataToBattleJson()));
        }
        Map<String, Integer> sceneData = new HashMap<>();
        sceneData.put("allowAutoGuard", Integer.valueOf(0));
        MapBase sceneProp = AreaDataConfig.getInstance().get(area.areaId);
        int autoFight = sceneProp.autoFight;
        if (autoFight == 0) {
            sceneData.put("allowAutoGuard", Integer.valueOf(1));
        } else if (autoFight == 1 || autoFight == 3) {
            sceneData.put("allowAutoGuard", Integer.valueOf(0));
        } else if (autoFight == 2 && (
                area.getSceneType() == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) && area.prop.dungeonTab != 4) {


            sceneData.put("allowAutoGuard", Integer.valueOf(1));
        }


        data.put("sceneData", sceneData);
        Out.debug(new Object[]{"enterscenedata:", data});
        return data;
    }

    private void registManager(ModuleManager manager) {
        if (manager.getManagerType() == null) {
            Out.error(new Object[]{"manager.getManagerType()为空"});
        }
        this.allManagers.put(manager.getManagerType(), manager);
    }


    private void _init(AllBlobPO allBlobData) {
        this.allBlobData = allBlobData;
        this.player = allBlobData.player;
        this.basicProp = (CharacterCO) GameData.Characters.get(Integer.valueOf(this.player.pro));

        this.playerBasePO = allBlobData.playerBase;
        this.playerTempData = allBlobData.playerTemp;
        this.playerAttachPO = allBlobData.playerAttachPO;

        this.baseDataManager = new PlayerBaseDataManager(this, this.player);
        registManager((ModuleManager) this.baseDataManager);

        SkillsPO skillDb = (SkillsPO) PlayerPOManager.findPO(ConstsTR.skillTR, getId(), SkillsPO.class);
        this.skillManager = new SkillManager(this, skillDb);
        registManager((ModuleManager) this.skillManager);
        this.skillKeyManager = new SkillKeyManager(this, skillDb);
        registManager((ModuleManager) this.skillKeyManager);
        this.sysSetManager = new SysSetInfo(this);
        this.hookSetManager = new HookSetManager(this, allBlobData.hookSetData);
        this.vipManager = new VipManager(this, this.playerAttachPO.vipData);
        registManager((ModuleManager) this.vipManager);

        this.messageManager = new PlayerMessages(this);
        this.sceneProgressManager = new SceneProgressManager(this.playerAttachPO.sceneProgress);
        this.chouRenManager = new ChouRenManager(this, allBlobData.chouRens);

        this.achievementManager = new AchievementManager(this, allBlobData.achievements);
        this.guildBossAreaHurtRankManager = new GuildBossAreaHurtRankManager(this);
        TitlePO titlePo = (TitlePO) PlayerPOManager.findPO(ConstsTR.playerTitleTR, getId(), TitlePO.class);
        this.titleManager = new TitleManager(this, titlePo);
        PlayerPetsNewPO petsPo = PetCenter.getInstance().findPet(getId());
        this.petNewManager = new PetManager(this, petsPo);
        registManager((ModuleManager) this.petNewManager);

        this.soloManager = new SoloManager(this);
        this.guildManager = new GuildManager(this, FindPlayerGuildDao.getPlayerGuildPOById(this.player.id));
        this.saleManager = new SaleManager(this);
        this.arenaManager = new ArenaManager(this);
        this.guildBossManager = new GuildBossManager(this);
        this.guildFortManager = new GuildFortManager(this);
        registManager((ModuleManager) this.guildFortManager);
        registManager((ModuleManager) this.guildBossManager);
        this.leaderBoardManager = new LeaderBoardManager(this);

        BagsPO bags = (BagsPO) PlayerPOManager.findPO(ConstsTR.bagTR, getId(), BagsPO.class);
        this.bag = new WNBag(this, Const.BAG_TYPE.BAG, bags.bagData, bags);
        this.recycle = new WNBag(this, Const.BAG_TYPE.RECYCLE, bags.recycleData, bags);
        this.wareHouse = new WNBag(this, Const.BAG_TYPE.WAREHOUSE, bags.wareHouseData, bags);


        if ((getPlayerAttach()).equipGrids == null) {
            (getPlayerAttach()).equipGrids = new HashMap<>();
        }
        this.equipManager = new EquipManager(this, this.playerBasePO.equipGrids, this.playerBasePO.strengthPos);

        this.fashionManager = new FashionManager(this);
        registManager((ModuleManager) this.fashionManager);

        this.bloodManager = new BloodManager(this);
        registManager((ModuleManager) this.bloodManager);

        FunctionOpenPO functionOpen = (FunctionOpenPO) PlayerPOManager.findPO(ConstsTR.player_func_openTR, getId(), FunctionOpenPO.class);
        this.functionOpenManager = new FunctionOpenManager(this, functionOpen);

        this.pkRuleManager = new PkRuleManager(this, (PlayerPKDataPO) PlayerPOManager.findPO(ConstsTR.pkRuleTR, getId(), PlayerPKDataPO.class));

        this.dailyActivityMgr = new DailyActivityMgr(this.player.id, (DailyActivityPO) PlayerPOManager.findPO(ConstsTR.player_dailyTR, this.player.id, DailyActivityPO.class));

        this.bufferManager = new BufferManager(this);

        this.mailManager = MailCenter.getInstance().findPlayerMails(getId());
        registManager((ModuleManager) this.mailManager);
        AttendancePO attendanceDb = (AttendancePO) PlayerPOManager.findPO(ConstsTR.player_signTR, getId(), AttendancePO.class);
        this.playerAttendance = new PlayerAttendance(this, attendanceDb);

        ShopMallPO shopMallDB = (ShopMallPO) PlayerPOManager.findPO(ConstsTR.shopMallTR, getId(), ShopMallPO.class);
        this.shopMallManager = new ShopMallManager(this, shopMallDB);

        MountPO mountPo = this.player.openMount ? MountCenter.getInstance().findMount(getId()) : null;
        this.mountManager = new MountManager(this, mountPo);
        registManager((ModuleManager) this.mountManager);

        PlayerConsignmentItemsPO consignmentDB = (PlayerConsignmentItemsPO) PlayerPOManager.findPO(ConstsTR.player_consignmentTR, getId(), PlayerConsignmentItemsPO.class);
        this.consignmentManager = new ConsignmentManager(this, consignmentDB);

        this.teamManager = new TeamManager(this);

        setPlayerTasks(new PlayerTasks(this, allBlobData.tasks));

        this.prepaidManager = new PrepaidManager(getId());
        registManager((ModuleManager) this.prepaidManager);

        ActivityDataPO adp = (ActivityDataPO) PlayerPOManager.findPO(ConstsTR.activityTR, (getPlayer()).id, ActivityDataPO.class);
        this.activityManager = new ActivityManager(this, adp);
        registManager((ModuleManager) this.activityManager);

        this.auctionManager = new AuctionManager(this);
        registManager((ModuleManager) this.auctionManager);

        this.demonTowerManager = new DemonTowerManager(this);


        OnlineDataPO onlineData = (OnlineDataPO) PlayerPOManager.findPO(ConstsTR.onlineGiftTR, getId(), OnlineDataPO.class);
        this.onlineGiftManager = new OnlineGiftManager(this, onlineData);

        this.fightLevelManager = new FightLevelManager(this, (FightLevelsPO) PlayerPOManager.findPO(ConstsTR.player_fightlevelTR, getId(), FightLevelsPO.class));

        this.dropManager = new DropManager(this, (MonsterDropPO) PlayerPOManager.findPO(ConstsTR.monster_drop_infoTR, getId(), MonsterDropPO.class));

        this.friendManager = FriendsCenter.getInstance().getFriendsMgr(getId());
        this.illusionManager = new IllusionManager(this, (IllusionPO) GameDao.get(this.player.id, "player_illusion", IllusionPO.class));
        this.five2FiveManager = new Five2FiveManager(this);
        registManager((ModuleManager) this.five2FiveManager);

        this.btlDataManager = new PlayerBtlDataManager(this);
        registManager((ModuleManager) this.btlDataManager);

        this.fleeManager = new FleeManager(this);
        this.moneyManager = new MoneyManager(this);


        this.farmMgr = new FarmMgr(this);

        calFightPower();


        this.rankManager = new RankManager(this);

        this.richManager = new RichManager(this);
        registManager((ModuleManager) this.richManager);

        this.sevenGoalManager = new SevenGoalManager(this);
        registManager((ModuleManager) this.sevenGoalManager);
        init();
    }

    private void init() {
        this.demonTowerManager.init();

        this.richManager.init();

        this.dailyActivityMgr.init(this.richManager, this.sevenGoalManager);

        this.petNewManager.init();
    }

    public void refreshNewDay() {
        Date now = new Date();
        if (DateUtils.isSameDay(DateUtils.addHours(now, -5), DateUtils.addHours(this.player.refreshTime, -5))) {
            return;
        }

        Out.info(new Object[]{"refreshNewDay playerId:", getId(), ",", this.player.name});
        this.player.refreshTime = now;

        this.todayLogined = false;


        this.playerTempData.sendMailItemNum = 0;
        this.moneyManager.refreshNewDay();


        this.taskManager.refreshNewDay();

        this.playerAttendance.refreshNewDay();

        this.onlineGiftManager.refreshNewDay();

        this.chouRenManager.refreshNewDay();

        this.titleManager.refreshNewDay();
        this.messageManager.refreshNewDay();


        this.arenaManager.refreshNewDay();

        this.soloManager.refreshNewDay();
        this.shopMallManager.refreshNewDay();


        this.illusionManager.refreshNewDay();


        this.activityManager.refreshNewDay();

        this.dailyActivityMgr.refreshNewDay();


        if (this.intergalMallManager != null) {
            this.intergalMallManager.refreshNewDay();
        }


        this.guildManager.refreshNewDay();


        this.consignmentManager.refreshNewDay();

        this.fightLevelManager.refreshNewDay();


        this.dropManager.refreshNewDay();


        this.farmMgr.refreshNewDay();


        this.demonTowerManager.UpdateSweepCount();
        this.demonTowerManager.refreshNewDay();


        if (this.reliveManager != null) {
            this.reliveManager.refreshNewDay();
        }
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.REFRESH_NEWDAY);
        }

        XianYuanService.getInstance().refreshNewDay(this.allBlobData.xianYuan);

        this.playerAttachPO.KillBossCount = 0;


        this.equipManager.refreshNewDay();

        this.richManager.checkData();
    }


    public void initBornData() {
        if (this.bornType == Const.BORN_TYPE.HISTORY.value) {
            this.playerTempData.areaId = this.playerTempData.historyAreaId;
            this.playerTempData.x = this.playerTempData.historyX;
            this.playerTempData.y = this.playerTempData.historyY;
        } else if (this.bornType == Const.BORN_TYPE.BORN.value) {
            this.playerTempData.areaId = this.playerTempData.bornAreaId;
            this.playerTempData.x = this.playerTempData.bornX;
            this.playerTempData.y = this.playerTempData.bornY;
        }
    }


    public void initAndCalAllInflu(Collection<String> allyIds) {
        initBornData();
        CharacterCO basicData = (CharacterCO) GameData.Characters.get(Integer.valueOf(this.player.pro));
        if (basicData == null) {
            String msg = "there is no data of pro: " + this.player.pro + " in characterProps ";
            throw new RuntimeException(msg);
        }

        this.basicProp = basicData;

        CharacterLevelCO levelData = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(this.player.level));
        if (levelData == null) {
            Out.error(new Object[]{"there is no data of level: ", Integer.valueOf(this.player.level), " in characterLevelProps "});
        }

        this.player.needExp = levelData.experience;

        calFightPower();
    }

    public boolean setClientCustomConfig(String key, String value, boolean push) {
        if (this.playerAttachPO.config == null) {
            this.playerAttachPO.config = new HashMap<>();
        }
        int len = this.playerAttachPO.config.size();

        if (len >= 300) {
            return false;
        }
        if (!StringUtil.isEmpty(value)) {
            this.playerAttachPO.config.put(key, value);
        } else {
            this.playerAttachPO.config.remove(key);
        }
        if (push) {
            PlayerHandler.ClientConfigPush.Builder data = PlayerHandler.ClientConfigPush.newBuilder();
            data.setS2CKey(key);
            data.setS2CValue(value);
            receive("area.playerPush.clientConfigPush", (GeneratedMessage) data.build());
        }
        return true;
    }


    public void calFightPower() {
        int old = this.player.fightPower;
        this.player.fightPower = CommonUtil.calPlayerFightPower(this.btlDataManager.fightPowerInflus, this.player.pro);


        this.player.fightPower += this.skillManager.getSkillsPower();

        if (this.player.fightPower > this.player.maxFightPower) {
            this.player.maxFightPower = this.player.fightPower;
            Out.info(new Object[]{"战力提升 playerId=", getId(), ",name=", getName(), ", fightPower=", Integer.valueOf(this.player.fightPower)});
        }

        if (this.rankManager != null) {
            this.rankManager.onEvent(RankType.FIGHTPOWER, new Object[]{Integer.valueOf(this.player.fightPower)});
        }
        if (this.sevenGoalManager != null) {
            this.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.FIGHTPOWER_TO, new Object[]{Integer.valueOf(this.player.fightPower)});
        }

        this.activityManager.updateDeskRedPoint();
        if (old < this.player.fightPower) {
            BILogService.getInstance().recordNum(this, Const.BiLogType.FightPower, (this.player.fightPower - old), null);
        }
        this.achievementManager.playerPowerChange(this.player.fightPower);
        this.baseDataManager.updateFightTime(new Date());
    }


    public Map<String, Object> _getBattlerServerBasic() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", getName());
        data.put("camp", Integer.valueOf(Const.AreaCamp.Neutral.value));
        data.put("guildId", this.guildManager.getGuildId());
        data.put("guildName", this.guildManager.getGuildName());
        data.put("guildIcon", this.guildManager.getGuildIcon());
        data.put("pro", Integer.valueOf(this.player.pro));
        data.put("serverId", Integer.valueOf(getLogicServerId()));
        data.put("titleId", Integer.valueOf(this.titleManager.getTitleId()));
        data.put("level", Integer.valueOf(this.player.level));
        data.put("vip", Integer.valueOf(this.player.vip));
        data.put("upLevel", Integer.valueOf(this.player.upLevel));
        data.put("beReward", Integer.valueOf(0));
        return data;
    }


    public JSONArray _getBattleServerTask() {
        return this.taskManager.toJson4BattleServer();
    }

    public List<Object[]> _getBattleServerTaskFlag() {
        return this.sceneProgressManager.toJson4BattleServer();
    }


    public Map<String, Number> _getBattlerServerEffect() {
        return this.btlDataManager._getBattlerServerEffect();
    }


    public void refreshBattlerServerBasic() {
        String basic = JSON.toJSONString(_getBattlerServerBasic());
        getXmdsManager().refreshPlayerBasicData(getId(), basic);
    }


    public void refreshPlayerRemainBagCountData(int remainCount) {
        getXmdsManager().refreshPlayerRemainBagCountData(getId(), remainCount);
    }


    public void refreshPlayerRemainTeamBagCountData(int remainCount) {
        if (remainCount <= 3) {
            getXmdsManager().refreshPlayerRemainTeamBagCountData(getId(), remainCount);
        }
    }


    public void refreshBattlerServerEffect(boolean isHpMpValid) {
        Map<String, Number> effects = _getBattlerServerEffect();
        if (!isHpMpValid) {
            effects.put("HP", Integer.valueOf(-1));
            effects.put("MP", Integer.valueOf(-1));
        }
        String str = JSON.toJSONString(effects);
        getXmdsManager().refreshPlayerBattleEffect(getId(), str);
    }


    public void refreshBattlerServerSkill(int type, List<Integer> skillIds) {
        if (!this.area.hasPlayer(getId()))
            return;
        String _skillData = getXmdsManager().getPlayerSkillCDTime(getId());
        List<SkillDataICE> skillData = (List<SkillDataICE>) JSON.parseObject(_skillData, new TypeReference<List<SkillDataICE>>() {
        }, new com.alibaba.fastjson.parser.Feature[0]);
        this.skillManager.syncBattleSkillTime(skillData);
        List<SkillManager.SkillInfo> data = null;
        if (type == Const.SkillHandleType.ALL.getValue()) {
            data = this.skillManager.toJson4BattleServer();
        } else if (type == Const.SkillHandleType.CHANGE.getValue() || type == Const.SkillHandleType.ADD.getValue() || type == Const.SkillHandleType.DELETE.getValue()) {
            data = this.skillManager.toJson4UpdateBattleServer(type, skillIds);
        }
        if (data != null && data.size() > 0) {
            getXmdsManager().refreshPlayerSkill(getId(), type, JSON.toJSONString(data));
        } else {
            Out.debug(new Object[]{"send to battle server skill change data is null,it is not influence"});
        }
    }


    public void refreshBattlerServerAvatar() {
        List<AvatarObj> list = PlayerUtil.getBattlerServerAvatarObj(this);
        Map<String, List<AvatarObj>> avatars = new HashMap<>();
        avatars.put("avatars", list);
        String avatars_str = JSON.toJSONString(avatars);
        Out.debug(new Object[]{"refreshBattlerServerAvatar:", avatars_str});
        getXmdsManager().refreshPlayerAvatar(getId(), avatars_str);
    }


    public void refreshPlayerPropertyChange(RefreshPlayerPropertyChange data) {
        Out.debug(new Object[]{"refreshPlayerPropertyChange :", data});
        getXmdsManager().refreshPlayerPropertyChange(getId(), JSON.toJSONString(data));
    }

    public void refreshPlayerPetPropertyChange(RefreshPlayerPropertyChange data) {
        Out.debug(new Object[]{"refreshPlayerPetPropertyChange :", data});
        getXmdsManager().refreshPlayerPetPropertyChange(getId(), JSON.toJSONString(data));
    }

    public void changePlayerPkValue(int value) {
        getXmdsManager().refreshPlayerPKValue(getId(), value);
    }


    public void setForce(int force) {
        this.force = force;
    }

    public int getForce() {
        return this.force;
    }


    public void syncBornData(float bornX, float bornY, int bornAreaId) {
        this.playerTempData.bornX = bornX;
        this.playerTempData.bornY = bornY;
        this.playerTempData.bornAreaId = bornAreaId;
    }


    public void syncHistoryData(int areaId, String instanceId, GetPlayerData data) {
        this.playerTempData.historyAreaId = areaId;
        this.playerTempData.historyX = data.x;
        this.playerTempData.historyY = data.y;
        this.playerTempData.historyDirection = data.direction;
        Out.debug(new Object[]{getName(), ">>>>>>>>>>>>>history areaId:", Integer.valueOf(areaId), ">>>historyX:", Float.valueOf(data.x), ">>>historyY:", Float.valueOf(data.y)});

        this.pkRuleManager.setHistoryPkModel();
    }


    public void syncNowData(int areaId, String instanceId, GetPlayerData data) {
        this.playerTempData.x = data.x;
        this.playerTempData.y = data.y;
        this.playerTempData.direction = data.direction;
        this.playerTempData.hp = data.hp;
        this.playerTempData.mp = data.mp;
        this.playerTempData.areaId = areaId;

        this.pkRuleManager.pkData.pkModel = data.pkMode;
        this.pkRuleManager.pkData.pkValue = data.pkValue;
        this.pkRuleManager.pkData.pkLevel = data.pkLevel;

        this.skillManager.syncBattleSkillTime(Arrays.asList(data.skillData));
    }


    public long getLastChangeAreaTime() {
        return this.lastChangeTime;
    }


    public void setArea(Area area) {
        if (this.area != null && GWorld.APP_TIME - this.lastChangeTime < 1000L) {
            Out.warn(new Object[]{getName(), " : ", this.area.getSceneName(), "-", this.area.instanceId, " to ", area.getSceneName(), "-", area.instanceId, " use ", Long.valueOf(GWorld.APP_TIME - this.lastChangeTime), "ms use ", JSON.toJSONString(this.playerTempData)});
        }

        this.area = area;
        setBattleServerId(area.getServerId());


        Out.debug(new Object[]{"set player area data: ", area});
        this.lastChangeTime = GWorld.APP_TIME;
    }


    public void addPrestige(int prestige) {
        addPrestige(prestige, (Const.GOODS_CHANGE_TYPE) null);
    }


    public void addPrestige(int prestige, Const.GOODS_CHANGE_TYPE from) {
        this.baseDataManager.addPrestige(prestige, from);
    }


    public void onUpgrade() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.UPGRADE);
        }


        this.functionOpenManager.onUpgradeLevelOrVip();


        this.equipManager.OnPlayerLevelUp();


        this.skillManager.updateSuperScript();


        this.teamManager.onPlayerUpgrade();


        this.achievementManager.playerLevelChange(this.player.level);
        WNNotifyManager.getInstance().levelChange(this, this.player.level);
        this.activityManager.updateDeskRedPoint();


        calFightPower();

        this.playerTempData.hp = ((Integer) this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
        pushAndRefreshEffect(true);
        refreshBattlerServerBasic();
        pushDynamicData(Utils.ofMap(new Object[]{"level", Integer.valueOf(this.player.level), "exp", Long.valueOf(this.player.exp), "needExp", Integer.valueOf(this.player.needExp), "fightPower", Integer.valueOf(this.player.fightPower)}));


        this.equipManager.updateEquipScript(null);

        this.equipManager.updateStrengthScript(null);

        this.equipManager.updateMakeScript(null);

        this.baseDataManager.updateLvChangeTime(new Date());

        if (getLevel() >= 10) {
            sync();
            RobotUtil.cloneRobot(this);
        }

        this.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.LEVEL_TO, new Object[]{Integer.valueOf(getLevel())});
    }

    public void addExp(int exp, Const.GOODS_CHANGE_TYPE from) {
        addExp(exp, from, 0);
    }

    public void addUpExp(int value, Const.GOODS_CHANGE_TYPE from) {
        this.baseDataManager.addClassExp(value, from);
    }


    public void addExp(int exp, Const.GOODS_CHANGE_TYPE from, int teamExp) {
        this.baseDataManager.addExp(exp, from, teamExp);
    }


    public void recoverHPAndMP() {
        this.playerTempData.hp = ((Integer) this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
    }

    public void customTip(Const.CUSTOMTIPTYPE type, int num) {
        String strType = "";
        switch (type) {
            case GOLD:
                strType = "GAIN_GOLDS";
                break;
            case TICKET:
                strType = "GAIN_CASH";
                break;
            case DIAMOND:
                strType = "GAIN_DIAMOND";
                break;
            case EXP:
                strType = "GAIN_EXP";
                break;
            case PRESTIGE:
                strType = "GAIN_PRESTIGE";
                break;
        }


        if (StringUtil.isEmpty(strType)) {
            return;
        }
        String addStr = LangService.format(strType, new Object[]{Integer.valueOf(num)});
        sendSysTip(addStr, Const.TipsType.NEWTYPE);
    }


    public boolean addGuildPoint(int num) {
        return this.baseDataManager.addGuildPoint(num);
    }


    public void setPetPkModel(int model) {
        this.petNewManager.changePetPkModel(model);
    }


    public void setIsAcceptAutoTeam(int isAcceptAutoTeam) {
        this.player.isAcceptAutoTeam = isAcceptAutoTeam;
    }


    public void setEnterState(int enterState) {
        this.enterState = enterState;
    }


    public void setBornType(Const.BORN_TYPE bornType) {
        this.bornType = bornType.value;
    }


    public void setBornType(Const.BORN_TYPE bornType, int areaId) {
        this.bornType = bornType.value;
        Out.debug(new Object[]{"setBornType bornType:", bornType, " tempData:", Integer.valueOf(this.playerTempData.areaId)});
        if (this.bornType == Const.BORN_TYPE.HISTORY.value) {
            this.playerTempData.areaId = this.playerTempData.historyAreaId;
            this.playerTempData.x = this.playerTempData.historyX;
            this.playerTempData.y = this.playerTempData.historyY;
        } else if (this.bornType == Const.BORN_TYPE.BORN.value) {
            this.playerTempData.bornAreaId = this.playerTempData.areaId = areaId;
            this.playerTempData.x = this.playerTempData.bornX = 0.0F;
            this.playerTempData.y = this.playerTempData.bornY = 0.0F;
        }
    }


    public boolean onMessage(int operate, MessageData message) {
        boolean result = true;
        Out.debug(new Object[]{"player onMessage:", message});
        MessageUtil.deleteSendedPlayerMessage(message);
        if (message.messageType == Const.MESSAGE_TYPE.mail_receive.getValue()) {
            result = this.mailManager.onMessage(operate, message);
        } else if (message.messageType == Const.MESSAGE_TYPE.daily_task_times.getValue()) {
            result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.daily_task_times, operate, message);
        } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_addfriend.getValue()) {
            result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_addfriend, operate, message);
        } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_member_leave.getValue()) {
            result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_member_leave, operate, message);
        } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_times.getValue()) {
            result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_times, operate, message);
        } else if (message.messageType == Const.MESSAGE_TYPE.consignment_publish.getValue()) {
            result = ConsignmentUtil.onMessage(this, Const.MESSAGE_TYPE.consignment_publish, operate, message);
        }
        this.messageManager.deleteReceivedMessage(message.messageType, message.id);
        return result;
    }

    public boolean onSaveRebirth(TaskEvent event) {
        if (event.type == Const.EventType.rebirth.getValue()) {

            Area area = getArea();
            if (!area.canRebirth(getId())) {
                return true;
            }
            String name = event.params[1].toString();
            WNNotifyManager.getInstance().pushRebirth(this, name);
            return true;
        }
        return false;
    }


    public void onBatterServerSceneEvent(String eventId) {
        Out.debug(new Object[]{"onBatterServerSceneEvent eventId:", eventId});
        EventCO eventProp = (EventCO) GameData.Events.get(eventId);
        if (eventProp != null && eventProp.eventType == 1) {
            int toAreaId = Integer.parseInt(eventProp.eventData1);
            AreaUtil.enterArea(this, toAreaId, 0.0F, 0.0F);
        }
    }

    public void onEvent(TaskEvent event) {
        event.player = this;
        TaskQueue.put(event);
    }


    public GuildMemberPO toJSON4GuildMember() {
        GuildMemberPO data = new GuildMemberPO();
        data.playerId = getId();
        data.name = getName();
        data.pro = (getPlayer()).pro;
        return data;
    }


    public void pushEffectData() {
        Map<String, Object> data = new HashMap<>();
        data.put("fightPower", Integer.valueOf(this.player.fightPower));
        WNNotifyManager.getInstance().pushEffectData(this, data);
    }

    public void pushDynamicData(String key, Object value) {
        WNNotifyManager.getInstance().pushPlayerDynamic(this, Utils.ofMap(new Object[]{key, value}));
    }


    public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin) {
        pushDynamicData(key, value, origin, (List<Common.KeyValueStruct>) null);
    }


    public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
        Common.PropertyStruct.Builder data = Common.PropertyStruct.newBuilder();
        data.setKey(key);
        data.setValue(String.valueOf(value));
        if (origin != null) {
            data.setSource(origin.getValue());
        }
        data.setType(1);
        if (itemChange != null) {
            data.addAllItems(itemChange);
        }
        WNNotifyManager.getInstance().pushPlayerDynamic(this, data.build());
    }


    public void pushDynamicData(Map<String, Object> atts) {
        WNNotifyManager.getInstance().pushPlayerDynamic(this, atts);
    }


    public void pushAndRefreshEffect(boolean isHpMpValid) {
        refreshBattlerServerEffect(isHpMpValid);
        pushEffectData();
    }


    public void sendSysTip(String content) {
        sendSysTip(content, Const.TipsType.NORMAL);
    }


    public void sendSysTip(String content, Const.TipsType type) {
        MessageUtil.sendSysTip(this, content, type);
    }


    public void nofitySuperScript() {
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();

        List<PlayerHandler.SuperScriptType> s2c_data = new ArrayList<>();
        for (ModuleManager manager : this.allManagers.values()) {
            List<PlayerHandler.SuperScriptType> list = manager.getSuperScript();
            if (list != null) {
                s2c_data.addAll(list);
            }
        }


        s2c_data.addAll(this.mailManager.getSuperScript());
        s2c_data.addAll(this.soloManager.getSuperScript());
        s2c_data.addAll(this.arenaManager.getSuperScript());
        s2c_data.addAll(this.shopMallManager.getSuperScript());
        s2c_data.addAll(this.achievementManager.getSuperScript());
        s2c_data.addAll(this.mountManager.getSuperScript());
        s2c_data.addAll(this.equipManager.getSuperScript());

        data.addAllS2CData(s2c_data);

        receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
    }


    public List<PlayerHandler.SuperScriptType> getItemChangeScript() {
        List<PlayerHandler.SuperScriptType> s2c_data = new ArrayList<>();


        Out.debug(new Object[]{"itemChangeScript data:", s2c_data});
        return s2c_data;
    }


    public void updateSuperScript(Const.SUPERSCRIPT_TYPE type, int number) {
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();

        PlayerHandler.SuperScriptType.Builder scriptType = PlayerHandler.SuperScriptType.newBuilder();
        scriptType.setType(type.getValue());
        scriptType.setNumber(number);
        data.addS2CData(scriptType);

        receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
    }


    public void updateSuperScriptList(List<PlayerHandler.SuperScriptType> scriptList) {
        if (scriptList == null || scriptList.isEmpty()) {
            return;
        }
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
        data.addAllS2CData(scriptList);
        receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
    }


    public void puchFuncGoToTicketNotEnough() {
        onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.TICKET_NOT_ENOUGH, (String) null, (String) null, (FunctionHandler.TipsParam) null);
    }

    public void puchFuncGoToPickItem() {
        onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.PICK_ITEM, (String) null, (String) null, (FunctionHandler.TipsParam) null);
    }


    public void onFunctionGoTo(Const.FUNCTION_GOTO_TYPE funGoId, String itemCode, String id, FunctionHandler.TipsParam tipsParam) {
        FunctionHandler.FunctionGoToPush.Builder args = FunctionHandler.FunctionGoToPush.newBuilder();
        args.setS2CFunGoId(funGoId.getValue());
        if (!StringUtil.isEmpty(itemCode)) {
            args.setS2CItemCode(itemCode);
        }
        if (!StringUtil.isEmpty(id)) {
            args.setS2CId(id);
        }
        if (tipsParam != null) {
            args.setS2CParam(tipsParam);
        }

        WNNotifyManager.getInstance().pushFunctionGoTo(this, args);
    }


    public void onEndEnterScene() {
        this.mountManager.pushToClientMountsFlag();
        getXmdsManager().playerReady(getId());

        Area area = getArea();
        Area.Actor actor = area.getActor(getId());
        if (actor != null) {
            if (actor.ready && !inPvP())
                return;
            actor.ready = true;
        }


        TeamService.changeTeamArea(this);
        area.onEndEnterScene(this);

        RobotUtil.onRobotReplyHP(this);
        Out.debug(new Object[]{this.battleServerId, " onEndEnterScene : ", area});
    }


    public void onFishItem(List<ItemOuterClass.MiniItem> item) {
        WNNotifyManager.getInstance().pushFishItem(this, item);
    }


    public void sendLeaveWord() {
    }


    public boolean canTalkWithNpc(int templateId, int npcId) {
        return true;
    }

    public PlayerOuterClass.LookUpPlayer getFightData() {
        PlayerOuterClass.LookUpPlayer.Builder data = PlayerOuterClass.LookUpPlayer.newBuilder();
        data.setName(this.player.name);
        data.setLevel(this.player.level);
        data.setUpLevel(this.player.upLevel);
        data.setUpOrder(this.player.upOrder);
        data.setPro(this.player.pro);
        data.setFightPower(this.player.fightPower);
        data.addAllAttrs(this.btlDataManager._getPlayerAttr());
        return data.build();
    }

    public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3) {
        pushChatSystemMessage(type, value1, value2, value3, (Const.GOODS_CHANGE_TYPE) null);
    }

    public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3, Const.GOODS_CHANGE_TYPE from) {
        String str = "";
        if (type == Const.SYS_CHAT_TYPE.ITEM) {
            String strQt = ItemUtil.getColorItemNameByQcolor(((Integer) value2).intValue(), value1);
            if (from != null && from == Const.GOODS_CHANGE_TYPE.shop) {
                str = LangService.format("ITEM_GET_BUY", new Object[]{value3, strQt});
            } else {
                str = LangService.format("ITEM_GET", new Object[]{value3, strQt});
            }
        } else if (type == Const.SYS_CHAT_TYPE.EXP) {
            if (value2 != null && StringUtil.isNotEmpty(String.valueOf(value2))) {
                str = LangService.format("GAIN_EXP_CHAT_WORLDLEVEL", new Object[]{value1, value2});
            } else {
                str = LangService.format("GAIN_EXP_CHAT", new Object[]{value1});
            }
        } else if (type == Const.SYS_CHAT_TYPE.CLASS_EXP) {
            str = LangService.format("GAIN_CLASS_EXP_CHAT", new Object[]{value1});
        } else if (type == Const.SYS_CHAT_TYPE.TEAM_EXP) {
            str = LangService.format("GAIN_TEAM_EXP", new Object[]{value1, value2});
        } else if (type == Const.SYS_CHAT_TYPE.COIN) {
            str = LangService.format("GAIN_GOLDS_CHAT", new Object[]{value1});
        } else if (type == Const.SYS_CHAT_TYPE.TRADE &&
                value2 != null) {
            String str1 = "";

            List<WNBag.TradeMessageItemData> list = (List<WNBag.TradeMessageItemData>) value2;
            for (WNBag.TradeMessageItemData item : list) {
                str1 = str1 + ItemUtil.getColorItemNameByQcolor(item.qt, item.name) + "*" + item.num + ", ";
            }
            if (str1 != "") {
                if (value1 != null) {
                    str = LangService.getValue("TRADE_GET");
                } else {
                    str = LangService.getValue("TRADE_LOST");
                }
                str1 = str1.substring(0, str1.length() - 2);
                str = str.replace("{tradeItem}", str1);
            }
        }


        if (!StringUtil.isEmpty(str)) {
            MessageUtil.sendSysChat(this, str);
        }
    }


    public void update() {
        this.bag.update();
        this.wareHouse.update();
        GameDao.update(getId(), ConstsTR.playerBtlData.value, this.btlDataManager.finalInflus);

        if (this.reliveManager != null) {
            GameDao.update(ConstsTR.DAILY_RELIVE.value, getId(), this.reliveManager);
        }
        if (this.intergalMallManager != null) {
            GameDao.update(ConstsTR.intergalMallTR.value, getId(), this.intergalMallManager.intergalMallPO);
        }
        GameDao.update(this.player.id, "player_illusion", this.illusionManager.illusionPO);
    }

    public ZoneManagerPrx getZoneManager() {
        return CSharpClient.getZoneManager(getBattleServerId());
    }

    public XmdsManagerPrx getXmdsManager() {
        return CSharpClient.getXmdsManager(getBattleServerId());
    }

    public Area getArea() {
        return this.area;
    }

    public boolean inPvP() {
        return (getSceneType() == Const.SCENE_TYPE.ARENA.getValue() || getSceneType() == Const.SCENE_TYPE.FIVE2FIVE.getValue() || getSceneType() == Const.SCENE_TYPE.SIN_COM.getValue());
    }


    public void onClassUpgrade() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.CLASS_UPGRADE);
        }

        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }


    public void onMountPropChange() {
        this.btlDataManager.onMountPropChange();
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }


    public void onExchangeProparty() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.EXCHANGE_PROPARTY);
        }

        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }

    public void onPlayerSkillUpgrade() {
        updateFightPowerPoint();
    }

    public void onTalentPassiveSkillUpgrade() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.UPGRADE_TALENT_PASSIVE_SKILL);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }

    public void onEquipChange(Const.GOODS_CHANGE_TYPE from) {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.EQUIPMENT_CHANGE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint(from);
    }


    public void onFashionChange() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.FASHION_CHANGE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.Fashion);
    }


    public void onBloodChange() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.BLOOD);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.blood);
    }


    public void onArmourActive() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.ARMOUR_ACTIVE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }

    public void onPetPropChange() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.PET_PROP_CHANGE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }

    public void onGuildBlessChange() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.GUILD_BLESS_CHANGE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }


    public void updatePlayerGuildTechAttrs() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.GUILD_TECH_CHANGE);
        }
        refreshBattlerServerEffect(false);
        updateFightPowerPoint();
    }

    private void updateFightPowerPoint() {
        updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.def);
    }

    private void updateFightPowerPoint(Const.GOODS_CHANGE_TYPE from) {
        calFightPower();
        pushDynamicData("fightPower", Integer.valueOf(this.player.fightPower), from);
    }


    public void updateTitleAttrs() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.TITLE_CHANGE);
        }
        refreshBattlerServerEffect(false);
    }


    public PlayerInteract getInteractManager() {
        if (this.interactManager == null) {
            this.interactManager = new PlayerInteract(this);
        }
        return this.interactManager;
    }


    public ReliveManager getReliveManager() {
        if (this.reliveManager == null) {
            String dailyRelive = GCache.hget(ConstsTR.DAILY_RELIVE.value, getId());
            this.reliveManager = StringUtil.isNotEmpty(dailyRelive) ? (ReliveManager) JSON.parseObject(dailyRelive, ReliveManager.class) : new ReliveManager();
        }
        return this.reliveManager;
    }

    public void free() {
        update();
        PlayerPOManager.clearOfflinePO(getId());
    }


    public void onPay() {
        for (ModuleManager manager : this.allManagers.values()) {
            manager.onPlayerEvent(Const.PlayerEventType.PAY);
        }
    }


    public void kick(Const.KickReason reason) {
        try {
            PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
            data.setS2CReasonType(reason.value);
            this.session.write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage) data.build())).getContent()).await(2000L);
        } catch (InterruptedException interruptedException) {
        }
        this.session.close();
        doLogout(false);
    }

    public boolean isRobot() {
        return PlayerUtil.isRobot(this.player);
    }

    public boolean isProxy() {
        return false;
    }

    public boolean isRomote() {
        if (this.teamManager.acrossTargetId > 0) {
            return true;
        }
        TeamData team = this.teamManager.getTeam();
        return (team != null && !team.local);
    }

    public void changeArea(AreaData areaData) {
        AreaUtil.changeArea(this, areaData);
    }

    public PetNew getFightingPet() {
        return this.petNewManager.getFightingPet();
    }


    public Set<String> getTeamMembers() {
        if (this.teamMembers != null)
            return this.teamMembers.keySet();
        Map<String, TeamData.TeamMemberData> teamMembers = this.teamManager.getTeamMembers();
        if (teamMembers != null) {
            return teamMembers.keySet();
        }
        return null;
    }

    public void finishFightLevel(int currHard, int templateID) {
    }

    public void onProxyEvent(int type, ProxyEventCB event) {
    }

    public int getGuildExdExp() {
        return this.guildManager.calAllInfluence().containsKey("ExdExp") ? ((Integer) this.guildManager.calAllInfluence().get("ExdExp")).intValue() : 0;
    }

    public int getGuildExdGold() {
        return this.guildManager.calAllInfluence().containsKey("ExdGold") ? ((Integer) this.guildManager.calAllInfluence().get("ExdGold")).intValue() : 0;
    }

    public int getBtlExdGold() {
        return this.btlDataManager.allInflus.containsKey(Const.PlayerBtlData.ExdGold) ? ((Integer) this.btlDataManager.allInflus.get(Const.PlayerBtlData.ExdGold)).intValue() : 0;
    }

    public int processXianYuanGet(int from) {
        int addNum = XianYuanService.getInstance().processXianYuanGet(from, this.allBlobData.xianYuan);
        if (addNum > 0) {
            this.moneyManager.addXianYuan(addNum, from);
        }
        return addNum;
    }
}


