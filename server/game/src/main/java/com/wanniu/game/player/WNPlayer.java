/*      */ package com.wanniu.game.player;
/*      */ 
/*      */

/*      */ import Xmds.GetPlayerData;
/*      */ import Xmds.RefreshPlayerPropertyChange;
/*      */ import Xmds.SkillDataICE;
/*      */ import Xmds.XmdsManagerPrx;
/*      */ import com.alibaba.fastjson.JSON;
/*      */ import com.alibaba.fastjson.JSONArray;
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.alibaba.fastjson.TypeReference;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.db.GCache;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GPlayer;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.tcp.protocol.Message;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.csharp.CSharpClient;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.achievement.AchievementManager;
/*      */ import com.wanniu.game.activity.ActivityManager;
/*      */ import com.wanniu.game.activity.DemonTowerManager;
/*      */ import com.wanniu.game.activity.RechargeActivityService;
/*      */ import com.wanniu.game.area.Area;
/*      */ import com.wanniu.game.area.AreaData;
/*      */ import com.wanniu.game.area.AreaDataConfig;
/*      */ import com.wanniu.game.area.AreaUtil;
/*      */ import com.wanniu.game.area.DropManager;
/*      */ import com.wanniu.game.area.PlayerRemote;
/*      */ import com.wanniu.game.area.SceneProgressManager;
/*      */ import com.wanniu.game.arena.ArenaManager;
/*      */ import com.wanniu.game.attendance.PlayerAttendance;
/*      */ import com.wanniu.game.auction.AuctionManager;
/*      */ import com.wanniu.game.bag.WNBag;
/*      */ import com.wanniu.game.blood.BloodManager;
/*      */ import com.wanniu.game.buffer.BufferManager;
/*      */ import com.wanniu.game.common.CommonUtil;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.ModuleManager;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.common.msg.MessagePush;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.common.msg.WNNotifyManager;
/*      */ import com.wanniu.game.consignmentShop.ConsignmentManager;
/*      */ import com.wanniu.game.consignmentShop.ConsignmentUtil;
/*      */ import com.wanniu.game.daily.DailyActivityMgr;
/*      */ import com.wanniu.game.data.CharacterCO;
/*      */ import com.wanniu.game.data.CharacterLevelCO;
/*      */ import com.wanniu.game.data.EventCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.base.MapBase;
/*      */ import com.wanniu.game.equip.EquipManager;
/*      */ import com.wanniu.game.farm.FarmMgr;
/*      */ import com.wanniu.game.fashion.FashionManager;
/*      */ import com.wanniu.game.fightLevel.FightLevelManager;
/*      */ import com.wanniu.game.five2Five.Five2FiveManager;
/*      */ import com.wanniu.game.flee.FleeManager;
/*      */ import com.wanniu.game.friend.ChouRenManager;
/*      */ import com.wanniu.game.friend.FriendManager;
/*      */ import com.wanniu.game.friend.FriendsCenter;
/*      */ import com.wanniu.game.functionOpen.FunctionOpenManager;
/*      */ import com.wanniu.game.guild.GuildManager;
/*      */ import com.wanniu.game.guild.dao.FindPlayerGuildDao;
/*      */ import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankManager;
/*      */ import com.wanniu.game.guild.guildBoss.GuildBossManager;
/*      */ import com.wanniu.game.guild.guildFort.GuildFortManager;
/*      */ import com.wanniu.game.hookSet.HookSetManager;
/*      */ import com.wanniu.game.illusion.IllusionManager;
/*      */ import com.wanniu.game.interact.PlayerInteract;
/*      */ import com.wanniu.game.intergalmall.IntergalMallManager;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.leaderBoard.LeaderBoardManager;
/*      */ import com.wanniu.game.mail.MailCenter;
/*      */ import com.wanniu.game.mail.MailManager;
/*      */ import com.wanniu.game.message.MessageData;
/*      */ import com.wanniu.game.message.PlayerMessages;
/*      */ import com.wanniu.game.money.MoneyManager;
/*      */ import com.wanniu.game.mount.MountCenter;
/*      */ import com.wanniu.game.mount.MountManager;
/*      */ import com.wanniu.game.onlineGift.OnlineGiftManager;
/*      */ import com.wanniu.game.petNew.PetCenter;
/*      */ import com.wanniu.game.petNew.PetManager;
/*      */ import com.wanniu.game.petNew.PetNew;
/*      */ import com.wanniu.game.player.po.AllBlobPO;
/*      */ import com.wanniu.game.player.po.AvatarObj;
/*      */ import com.wanniu.game.playerData.PlayerBaseDataManager;
/*      */ import com.wanniu.game.playerData.PlayerBtlDataManager;
/*      */ import com.wanniu.game.playerSkill.SkillManager;
/*      */ import com.wanniu.game.playerSkillKey.SkillKeyManager;
/*      */ import com.wanniu.game.poes.ActivityDataPO;
/*      */ import com.wanniu.game.poes.AttendancePO;
/*      */ import com.wanniu.game.poes.BagsPO;
/*      */ import com.wanniu.game.poes.DailyActivityPO;
/*      */ import com.wanniu.game.poes.FightLevelsPO;
/*      */ import com.wanniu.game.poes.FunctionOpenPO;
/*      */ import com.wanniu.game.poes.GuildMemberPO;
/*      */ import com.wanniu.game.poes.IllusionPO;
/*      */ import com.wanniu.game.poes.MonsterDropPO;
/*      */ import com.wanniu.game.poes.MountPO;
/*      */ import com.wanniu.game.poes.OnlineDataPO;
/*      */ import com.wanniu.game.poes.PlayerAttachPO;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.poes.PlayerConsignmentItemsPO;
/*      */ import com.wanniu.game.poes.PlayerPKDataPO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.poes.PlayerPetsNewPO;
/*      */ import com.wanniu.game.poes.PlayerTempPO;
/*      */ import com.wanniu.game.poes.ShopMallPO;
/*      */ import com.wanniu.game.poes.SkillsPO;
/*      */ import com.wanniu.game.poes.TitlePO;
/*      */ import com.wanniu.game.prepaid.PrepaidManager;
/*      */ import com.wanniu.game.rank.RankManager;
/*      */ import com.wanniu.game.rank.RankType;
/*      */ import com.wanniu.game.rank.TitleManager;
/*      */ import com.wanniu.game.recent.RecentChatCenter;
/*      */ import com.wanniu.game.recent.RecentChatMgr;
/*      */ import com.wanniu.game.request.task.TaskMessages;
/*      */ import com.wanniu.game.revelry.RevelryManager;
/*      */ import com.wanniu.game.rich.RichManager;
/*      */ import com.wanniu.game.sale.SaleManager;
/*      */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*      */ import com.wanniu.game.shopMall.ShopMallManager;
/*      */ import com.wanniu.game.solo.SoloManager;
/*      */ import com.wanniu.game.sysSet.SysSetInfo;
/*      */ import com.wanniu.game.task.PlayerTasks;
/*      */ import com.wanniu.game.task.TaskEvent;
/*      */ import com.wanniu.game.task.TaskQueue;
/*      */ import com.wanniu.game.team.TeamData;
/*      */ import com.wanniu.game.team.TeamManager;
/*      */ import com.wanniu.game.team.TeamService;
/*      */ import com.wanniu.game.util.RobotUtil;
/*      */ import com.wanniu.game.vip.VipManager;
/*      */ import com.wanniu.game.xianyuan.XianYuanService;
/*      */ import com.wanniu.redis.GameDao;
/*      */ import com.wanniu.redis.GlobalDao;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.time.DateUtils;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.FunctionHandler;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ import pomelo.player.PlayerOuterClass;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class WNPlayer
/*      */   extends GPlayer
/*      */ {
/*  184 */   public Map<Const.ManagerType, ModuleManager> allManagers = new HashMap<>();
/*      */   
/*      */   public AllBlobPO allBlobData;
/*      */   
/*      */   public PlayerPO player;
/*      */   
/*      */   public PlayerBasePO playerBasePO;
/*      */   
/*      */   public PlayerAttachPO playerAttachPO;
/*      */   
/*      */   public PlayerTempPO playerTempData;
/*      */   
/*      */   public CharacterCO basicProp;
/*      */   
/*      */   public WNBag bag;
/*      */   
/*      */   public WNBag recycle;
/*      */   
/*      */   public WNBag wareHouse;
/*      */   
/*      */   public PlayerBaseDataManager baseDataManager;
/*      */   
/*      */   public PlayerBtlDataManager btlDataManager;
/*      */   
/*      */   public EquipManager equipManager;
/*      */   
/*      */   public FashionManager fashionManager;
/*      */   
/*      */   public BloodManager bloodManager;
/*      */   
/*      */   public OnlineGiftManager onlineGiftManager;
/*      */   
/*      */   public MailManager mailManager;
/*      */   
/*      */   public FightLevelManager fightLevelManager;
/*      */   
/*      */   public DropManager dropManager;
/*      */   
/*      */   public SysSetInfo sysSetManager;
/*      */   
/*      */   public VipManager vipManager;
/*      */   
/*      */   public PkRuleManager pkRuleManager;
/*      */   
/*      */   public BufferManager bufferManager;
/*      */   
/*      */   public SceneProgressManager sceneProgressManager;
/*      */   
/*      */   public PlayerAttendance playerAttendance;
/*      */   
/*      */   public ShopMallManager shopMallManager;
/*      */   
/*      */   public IntergalMallManager intergalMallManager;
/*      */   
/*      */   public GuildBossAreaHurtRankManager guildBossAreaHurtRankManager;
/*      */   
/*      */   public AchievementManager achievementManager;
/*      */   
/*      */   public ArenaManager arenaManager;
/*      */   
/*      */   public GuildBossManager guildBossManager;
/*      */   
/*      */   public GuildFortManager guildFortManager;
/*      */   
/*      */   public SoloManager soloManager;
/*      */   
/*      */   public LeaderBoardManager leaderBoardManager;
/*      */   
/*      */   public Five2FiveManager five2FiveManager;
/*      */   
/*      */   public AuctionManager auctionManager;
/*      */   
/*      */   public HookSetManager hookSetManager;
/*      */   
/*      */   public TitleManager titleManager;
/*      */   
/*      */   public MountManager mountManager;
/*      */   
/*      */   public FunctionOpenManager functionOpenManager;
/*      */   
/*      */   public PlayerTasks taskManager;
/*      */   
/*      */   public PlayerMessages messageManager;
/*      */   
/*      */   public PetManager petNewManager;
/*      */   
/*      */   public SkillManager skillManager;
/*      */   
/*      */   public SkillKeyManager skillKeyManager;
/*      */   
/*      */   public DailyActivityMgr dailyActivityMgr;
/*      */   
/*      */   public FarmMgr farmMgr;
/*      */   
/*      */   public ConsignmentManager consignmentManager;
/*      */   
/*      */   public SaleManager saleManager;
/*      */   
/*      */   public PrepaidManager prepaidManager;
/*      */   
/*      */   public ActivityManager activityManager;
/*      */   
/*      */   public DemonTowerManager demonTowerManager;
/*      */   public FriendManager friendManager;
/*      */   public ChouRenManager chouRenManager;
/*      */   public IllusionManager illusionManager;
/*      */   public GuildManager guildManager;
/*      */   public TeamManager teamManager;
/*      */   public FleeManager fleeManager;
/*      */   public MoneyManager moneyManager;
/*      */   public RankManager rankManager;
/*      */   public RichManager richManager;
/*      */   public SevenGoalManager sevenGoalManager;
/*  297 */   public int bornType = Const.BORN_TYPE.NORMAL.value;
/*  298 */   public int enterState = Const.ENTER_STATE.online.value; public Map<Integer, Long> chatTime; public Area area; private int force; private boolean todayLogined;
/*      */   public List<String> chatLog;
/*      */   private String battleServerId;
/*      */   private long lastChangeTime;
/*      */   private PlayerInteract interactManager;
/*      */   private ReliveManager reliveManager;
/*      */   public Map<String, WNPlayer> teamMembers;
/*      */   
/*      */   public List<String> getChatLog() {
/*  307 */     return this.chatLog;
/*      */   }
/*      */   
/*      */   public void setChatLog(List<String> chatLog) {
/*  311 */     this.chatLog = chatLog;
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
/*      */   public void receive(String route, GeneratedMessage msg) {
/*  333 */     write((Message)new MessagePush(route, msg));
/*      */   }
/*      */   
/*      */   public HookSetManager getHookSet() {
/*  337 */     if (this.hookSetManager == null) {
/*  338 */       this.hookSetManager = new HookSetManager(this, this.allBlobData.hookSetData);
/*      */     }
/*  340 */     return this.hookSetManager;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getId() {
/*  345 */     return this.player.id;
/*      */   }
/*      */   
/*      */   public int getLogicServerId() {
/*  349 */     return this.player.logicServerId;
/*      */   }
/*      */   
/*      */   public int getAcrossServerId() {
/*  353 */     return GWorld.__ACROSS_SERVER_ID;
/*      */   }
/*      */   
/*      */   public String getInstanceId() {
/*  357 */     return this.area.instanceId;
/*      */   }
/*      */   
/*      */   public int getAreaId() {
/*  361 */     return this.area.areaId;
/*      */   }
/*      */   
/*      */   public int getLineIndex() {
/*  365 */     return this.area.lineIndex;
/*      */   }
/*      */   
/*      */   public int getSceneType() {
/*  369 */     return this.area.sceneType;
/*      */   }
/*      */   
/*      */   public String getSceneName() {
/*  373 */     return this.area.getSceneName();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUid() {
/*  378 */     return this.player.uid;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getName() {
/*  383 */     return this.player.name;
/*      */   }
/*      */   
/*      */   public int getLevel() {
/*  387 */     return this.player.level;
/*      */   }
/*      */   
/*      */   public long getExp() {
/*  391 */     return this.player.exp;
/*      */   }
/*      */   
/*      */   public int getPro() {
/*  395 */     return this.player.pro;
/*      */   }
/*      */   
/*      */   public int getUpLevel() {
/*  399 */     return this.player.upLevel;
/*      */   }
/*      */   
/*      */   public int getUpOrder() {
/*  403 */     return this.player.upOrder;
/*      */   }
/*      */   
/*      */   public int getFightPower() {
/*  407 */     return this.player.fightPower;
/*      */   }
/*      */   
/*      */   public PlayerPO getPlayer() {
/*  411 */     return this.player;
/*      */   }
/*      */   
/*      */   public PlayerBasePO getPlayerAttach() {
/*  415 */     return this.playerBasePO;
/*      */   }
/*      */   
/*      */   public PlayerTempPO getPlayerTempData() {
/*  419 */     return this.playerTempData;
/*      */   }
/*      */   
/*      */   public void setPlayerTempData(PlayerTempPO playerTempData) {
/*  423 */     this.playerTempData = playerTempData;
/*      */   }
/*      */   
/*      */   public WNBag getWnBag() {
/*  427 */     return this.bag;
/*      */   }
/*      */   
/*      */   public void setWnBag(WNBag wnBag) {
/*  431 */     this.bag = wnBag;
/*      */   }
/*      */   
/*      */   public PlayerTasks getPlayerTasks() {
/*  435 */     return this.taskManager;
/*      */   }
/*      */   
/*      */   public void setPlayerTasks(PlayerTasks playerTasks) {
/*  439 */     this.taskManager = playerTasks;
/*      */   }
/*      */   
/*      */   public FriendManager getFriendManager() {
/*  443 */     return this.friendManager;
/*      */   }
/*      */   
/*      */   public FarmMgr getFarmMgr() {
/*  447 */     return this.farmMgr;
/*      */   }
/*      */   
/*      */   public RecentChatMgr getRecentChatMgr() {
/*  451 */     return RecentChatCenter.getInstance().getRecentChatMgr(getId());
/*      */   }
/*      */   
/*      */   public void setFriendManager(FriendManager friendManager) {
/*  455 */     this.friendManager = friendManager;
/*      */   }
/*      */   
/*      */   public ChouRenManager getChouRenManager() {
/*  459 */     return this.chouRenManager;
/*      */   }
/*      */   
/*      */   public void setChouRenManager(ChouRenManager chouRenManager) {
/*  463 */     this.chouRenManager = chouRenManager;
/*      */   }
/*      */   
/*      */   public TeamManager getTeamManager() {
/*  467 */     return this.teamManager;
/*      */   }
/*      */   
/*      */   public void setTeamManager(TeamManager teamManager) {
/*  471 */     this.teamManager = teamManager;
/*      */   }
/*      */   
/*      */   public IntergalMallManager getIntergalMallManager() {
/*  475 */     if (this.intergalMallManager == null) {
/*  476 */       this.intergalMallManager = new IntergalMallManager(this);
/*      */     }
/*  478 */     return this.intergalMallManager;
/*      */   }
/*      */ 
/*      */   
/*      */   public void sync() {
/*  483 */     update();
/*  484 */     PlayerPOManager.sync(getId());
/*      */   }
/*      */   
/*      */   public Date getLogoutTime() {
/*  488 */     return this.player.logoutTime;
/*      */   }
/*      */   
/*      */   public void setLogoutTime(Date date) {
/*  492 */     this.baseDataManager.setLogoutTime(date);
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLogout(boolean self) {
/*  497 */     Out.debug(new Object[] { "---------------------logout begin----------------------- uid : ", getUid() });
/*  498 */     long startTime = System.nanoTime();
/*      */     
/*  500 */     Area area = getArea();
/*  501 */     if (area != null) {
/*      */       try {
/*  503 */         if (area.isNormal() && area.hasPlayer(getId())) {
/*  504 */           GetPlayerData result = area.getPlayerData(getId());
/*  505 */           if (result != null) {
/*  506 */             syncNowData(area.areaId, area.instanceId, result);
/*      */           }
/*      */         } 
/*  509 */       } catch (Exception e) {
/*  510 */         Out.error(new Object[] { e });
/*      */       } finally {
/*      */         try {
/*  513 */           this.recycle.removeAllItems();
/*  514 */           PlayerRemote.syncPlayerDataOffline(this, area);
/*  515 */           area.onPlayerLogout(this);
/*  516 */         } catch (Exception e) {
/*  517 */           Out.error(new Object[] { e });
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  522 */     TeamService.onLogout(this);
/*      */     
/*  524 */     GWorld.getInstance().ansycExec(() -> {
/*      */           JSONObject players = new JSONObject();
/*      */           
/*      */           List<String> list_ids = PlayerDao.getPlayerIdsByUid(getUid(), getLogicServerId());
/*      */           
/*      */           for (String playerId : list_ids) {
/*      */             PlayerPO baseData = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*      */             
/*      */             if (baseData != null) {
/*      */               JSONObject player = new JSONObject();
/*      */               
/*      */               player.put("lv", Integer.valueOf(baseData.level));
/*      */               player.put("name", baseData.name);
/*      */               player.put("pro", Integer.valueOf(baseData.pro));
/*      */               player.put("time", Long.valueOf(baseData.logoutTime.getTime()));
/*      */               players.put(playerId, player);
/*      */             } 
/*      */           } 
/*      */           GlobalDao.hset(String.valueOf(getLogicServerId()), getUid(), players.toJSONString());
/*      */           if (players.size() != list_ids.size()) {
/*      */             list_ids.clear();
/*      */             for (String playerId : players.keySet()) {
/*      */               list_ids.add(playerId);
/*      */             }
/*      */             PlayerDao.updatePlayerIds(getUid(), getLogicServerId(), list_ids);
/*      */           } 
/*      */           PlayerUtil.addLoginServer(getUid(), getLogicServerId(), players.size());
/*      */         });
/*  552 */     float useTime = (float)(System.nanoTime() - startTime) / 1000000.0F;
/*  553 */     Out.info(new Object[] { "角色退出游戏 uid=", getUid(), ",playerId=", getId(), ",name=", getName(), ",useTime=", Float.valueOf(useTime), " ms" });
/*  554 */     BILogService.getInstance().ansycReportLogout(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onReady() {
/*  561 */     this.functionOpenManager.checkFunctoinAward();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLogin() {
/*  572 */     this.baseDataManager.setLoginTime(new Date());
/*      */ 
/*      */     
/*  575 */     WNNotifyManager.getInstance().pushPlayerBattleData(this);
/*      */ 
/*      */     
/*  578 */     refreshNewDay();
/*      */ 
/*      */ 
/*      */     
/*  582 */     this.functionOpenManager.init();
/*      */     
/*  584 */     this.achievementManager.playerLevelChange(this.player.level);
/*      */     
/*  586 */     this.teamManager.loginFlag = this.teamManager.isInTeam();
/*  587 */     this.onlineGiftManager.onLogin();
/*      */ 
/*      */     
/*  590 */     this.taskManager.onLogin();
/*      */ 
/*      */     
/*  593 */     this.activityManager.onLogin();
/*      */     
/*  595 */     this.dailyActivityMgr.onLogin();
/*      */     
/*  597 */     this.shopMallManager.onLogin();
/*      */ 
/*      */     
/*  600 */     this.guildManager.onLogin();
/*      */     
/*  602 */     this.equipManager.onLogin();
/*      */     
/*  604 */     for (ModuleManager manager : this.allManagers.values()) {
/*  605 */       manager.onPlayerEvent(Const.PlayerEventType.AFTER_LOGIN);
/*      */     }
/*      */ 
/*      */     
/*  609 */     if (!this.todayLogined) {
/*  610 */       this.todayLogined = true;
/*  611 */       updateSuperScript(Const.SUPERSCRIPT_TYPE.INTERGAL_MALL, 1);
/*      */     } 
/*      */ 
/*      */     
/*  615 */     RevelryManager.getInstance().onLogin(this);
/*      */ 
/*      */     
/*  618 */     RechargeActivityService.getInstance().onLogin(this);
/*      */   }
/*      */   
/*  621 */   public WNPlayer(AllBlobPO allBlobData) { this.battleServerId = GWorld.__CS_NODE.getNodeId(); _init(allBlobData); } public WNPlayer(PlayerPO player) { this.battleServerId = GWorld.__CS_NODE.getNodeId(); this.player = player; } public WNPlayer() { this.battleServerId = GWorld.__CS_NODE.getNodeId(); }
/*      */   
/*      */   public void setBattleServerId(String battleServerId) {
/*  624 */     if (!this.battleServerId.equals(battleServerId)) {
/*  625 */       this.battleServerId = battleServerId;
/*  626 */       bindBattleServer(battleServerId);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getBattleServerId() {
/*  632 */     return this.battleServerId;
/*      */   }
/*      */   
/*      */   public JSONObject toJSON4EnterScene(Area area) {
/*  636 */     if (!AreaUtil.canRideMount(this.area.areaId)) {
/*  637 */       this.mountManager.unMountData();
/*      */     }
/*  639 */     JSONObject data = new JSONObject();
/*  640 */     data.put("effects", _getBattlerServerEffect());
/*  641 */     data.put("skills", this.skillManager.toJson4BattleServer());
/*  642 */     data.put("tasks", _getBattleServerTask());
/*  643 */     data.put("flags", _getBattleServerTaskFlag());
/*  644 */     data.put("playerEntered", Boolean.valueOf(area.hasPlayerEntered));
/*  645 */     data.put("avatars", PlayerUtil.getBattlerServerAvatarObj(this));
/*  646 */     data.put("basic", _getBattlerServerBasic());
/*  647 */     data.put("connectServerId", getBattleServerId());
/*  648 */     data.put("uid", getId());
/*  649 */     data.put("unitTemplateID", Integer.valueOf(this.player.pro));
/*  650 */     data.put("force", Integer.valueOf(this.force));
/*  651 */     data.put("robot", Boolean.valueOf(isRobot()));
/*  652 */     if (this.enterState == Const.ENTER_STATE.changeArea.value)
/*      */     {
/*  654 */       recoverHPAndMP();
/*      */     }
/*  656 */     Map<String, Number> tempData = new HashMap<>();
/*  657 */     if (this.playerTempData.hp == 0) {
/*  658 */       float x = 0.0F, y = 0.0F, direction = 0.0F;
/*  659 */       if (area.areaId == this.playerTempData.historyAreaId) {
/*  660 */         x = this.playerTempData.historyX;
/*  661 */         y = this.playerTempData.historyY;
/*  662 */         direction = this.playerTempData.historyDirection;
/*      */       } 
/*  664 */       tempData.put("x", Float.valueOf(x));
/*  665 */       tempData.put("y", Float.valueOf(y));
/*  666 */       tempData.put("direction", Float.valueOf(direction));
/*  667 */       tempData.put("hp", (Number)this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP));
/*  668 */       tempData.put("mp", Integer.valueOf(this.playerTempData.mp));
/*      */     } else {
/*  670 */       tempData.put("x", Float.valueOf(this.playerTempData.x));
/*  671 */       tempData.put("y", Float.valueOf(this.playerTempData.y));
/*  672 */       tempData.put("direction", Float.valueOf(this.playerTempData.direction));
/*  673 */       tempData.put("hp", Integer.valueOf(this.playerTempData.hp));
/*  674 */       tempData.put("mp", Integer.valueOf(this.playerTempData.mp));
/*      */     } 
/*  676 */     data.put("tempData", tempData);
/*      */     
/*  678 */     data.put("pkInfo", this.pkRuleManager.getPkDataToBattleJson());
/*  679 */     Map<String, Object> petBase = this.petNewManager.getBattlerServerPetBase();
/*  680 */     data.put("petBase", petBase);
/*  681 */     if (petBase.get("Model").equals("")) {
/*  682 */       data.put("addTestPetData", Integer.valueOf(0));
/*      */     } else {
/*  684 */       data.put("addTestPetData", Integer.valueOf(1));
/*  685 */       data.put("petEffect", this.petNewManager.getBattlerServerPetEffect());
/*  686 */       data.put("petSkill", this.petNewManager.getBattlerServerPetSkill());
/*  687 */       data.put("petMode", Integer.valueOf(this.petNewManager.getPkDataToBattleJson()));
/*      */     } 
/*  689 */     Map<String, Integer> sceneData = new HashMap<>();
/*  690 */     sceneData.put("allowAutoGuard", Integer.valueOf(0));
/*  691 */     MapBase sceneProp = AreaDataConfig.getInstance().get(area.areaId);
/*  692 */     int autoFight = sceneProp.autoFight;
/*  693 */     if (autoFight == 0) {
/*  694 */       sceneData.put("allowAutoGuard", Integer.valueOf(1));
/*  695 */     } else if (autoFight == 1 || autoFight == 3) {
/*  696 */       sceneData.put("allowAutoGuard", Integer.valueOf(0));
/*  697 */     } else if (autoFight == 2 && (
/*  698 */       area.getSceneType() == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) && area.prop.dungeonTab != 4) {
/*      */ 
/*      */       
/*  701 */       sceneData.put("allowAutoGuard", Integer.valueOf(1));
/*      */     } 
/*      */ 
/*      */     
/*  705 */     data.put("sceneData", sceneData);
/*  706 */     Out.debug(new Object[] { "enterscenedata:", data });
/*  707 */     return data;
/*      */   }
/*      */   
/*      */   private void registManager(ModuleManager manager) {
/*  711 */     if (manager.getManagerType() == null) {
/*  712 */       Out.error(new Object[] { "manager.getManagerType()为空" });
/*      */     }
/*  714 */     this.allManagers.put(manager.getManagerType(), manager);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void _init(AllBlobPO allBlobData) {
/*  725 */     this.allBlobData = allBlobData;
/*  726 */     this.player = allBlobData.player;
/*  727 */     this.basicProp = (CharacterCO)GameData.Characters.get(Integer.valueOf(this.player.pro));
/*      */     
/*  729 */     this.playerBasePO = allBlobData.playerBase;
/*  730 */     this.playerTempData = allBlobData.playerTemp;
/*  731 */     this.playerAttachPO = allBlobData.playerAttachPO;
/*      */     
/*  733 */     this.baseDataManager = new PlayerBaseDataManager(this, this.player);
/*  734 */     registManager((ModuleManager)this.baseDataManager);
/*      */     
/*  736 */     SkillsPO skillDb = (SkillsPO)PlayerPOManager.findPO(ConstsTR.skillTR, getId(), SkillsPO.class);
/*  737 */     this.skillManager = new SkillManager(this, skillDb);
/*  738 */     registManager((ModuleManager)this.skillManager);
/*  739 */     this.skillKeyManager = new SkillKeyManager(this, skillDb);
/*  740 */     registManager((ModuleManager)this.skillKeyManager);
/*  741 */     this.sysSetManager = new SysSetInfo(this);
/*  742 */     this.hookSetManager = new HookSetManager(this, allBlobData.hookSetData);
/*  743 */     this.vipManager = new VipManager(this, this.playerAttachPO.vipData);
/*  744 */     registManager((ModuleManager)this.vipManager);
/*      */     
/*  746 */     this.messageManager = new PlayerMessages(this);
/*  747 */     this.sceneProgressManager = new SceneProgressManager(this.playerAttachPO.sceneProgress);
/*  748 */     this.chouRenManager = new ChouRenManager(this, allBlobData.chouRens);
/*      */     
/*  750 */     this.achievementManager = new AchievementManager(this, allBlobData.achievements);
/*  751 */     this.guildBossAreaHurtRankManager = new GuildBossAreaHurtRankManager(this);
/*  752 */     TitlePO titlePo = (TitlePO)PlayerPOManager.findPO(ConstsTR.playerTitleTR, getId(), TitlePO.class);
/*  753 */     this.titleManager = new TitleManager(this, titlePo);
/*  754 */     PlayerPetsNewPO petsPo = PetCenter.getInstance().findPet(getId());
/*  755 */     this.petNewManager = new PetManager(this, petsPo);
/*  756 */     registManager((ModuleManager)this.petNewManager);
/*      */     
/*  758 */     this.soloManager = new SoloManager(this);
/*  759 */     this.guildManager = new GuildManager(this, FindPlayerGuildDao.getPlayerGuildPOById(this.player.id));
/*  760 */     this.saleManager = new SaleManager(this);
/*  761 */     this.arenaManager = new ArenaManager(this);
/*  762 */     this.guildBossManager = new GuildBossManager(this);
/*  763 */     this.guildFortManager = new GuildFortManager(this);
/*  764 */     registManager((ModuleManager)this.guildFortManager);
/*  765 */     registManager((ModuleManager)this.guildBossManager);
/*  766 */     this.leaderBoardManager = new LeaderBoardManager(this);
/*      */     
/*  768 */     BagsPO bags = (BagsPO)PlayerPOManager.findPO(ConstsTR.bagTR, getId(), BagsPO.class);
/*  769 */     this.bag = new WNBag(this, Const.BAG_TYPE.BAG, bags.bagData, bags);
/*  770 */     this.recycle = new WNBag(this, Const.BAG_TYPE.RECYCLE, bags.recycleData, bags);
/*  771 */     this.wareHouse = new WNBag(this, Const.BAG_TYPE.WAREHOUSE, bags.wareHouseData, bags);
/*      */ 
/*      */     
/*  774 */     if ((getPlayerAttach()).equipGrids == null) {
/*  775 */       (getPlayerAttach()).equipGrids = new HashMap<>();
/*      */     }
/*  777 */     this.equipManager = new EquipManager(this, this.playerBasePO.equipGrids, this.playerBasePO.strengthPos);
/*      */     
/*  779 */     this.fashionManager = new FashionManager(this);
/*  780 */     registManager((ModuleManager)this.fashionManager);
/*      */     
/*  782 */     this.bloodManager = new BloodManager(this);
/*  783 */     registManager((ModuleManager)this.bloodManager);
/*      */     
/*  785 */     FunctionOpenPO functionOpen = (FunctionOpenPO)PlayerPOManager.findPO(ConstsTR.player_func_openTR, getId(), FunctionOpenPO.class);
/*  786 */     this.functionOpenManager = new FunctionOpenManager(this, functionOpen);
/*      */     
/*  788 */     this.pkRuleManager = new PkRuleManager(this, (PlayerPKDataPO)PlayerPOManager.findPO(ConstsTR.pkRuleTR, getId(), PlayerPKDataPO.class));
/*      */     
/*  790 */     this.dailyActivityMgr = new DailyActivityMgr(this.player.id, (DailyActivityPO)PlayerPOManager.findPO(ConstsTR.player_dailyTR, this.player.id, DailyActivityPO.class));
/*      */     
/*  792 */     this.bufferManager = new BufferManager(this);
/*      */     
/*  794 */     this.mailManager = MailCenter.getInstance().findPlayerMails(getId());
/*  795 */     registManager((ModuleManager)this.mailManager);
/*  796 */     AttendancePO attendanceDb = (AttendancePO)PlayerPOManager.findPO(ConstsTR.player_signTR, getId(), AttendancePO.class);
/*  797 */     this.playerAttendance = new PlayerAttendance(this, attendanceDb);
/*      */     
/*  799 */     ShopMallPO shopMallDB = (ShopMallPO)PlayerPOManager.findPO(ConstsTR.shopMallTR, getId(), ShopMallPO.class);
/*  800 */     this.shopMallManager = new ShopMallManager(this, shopMallDB);
/*      */     
/*  802 */     MountPO mountPo = this.player.openMount ? MountCenter.getInstance().findMount(getId()) : null;
/*  803 */     this.mountManager = new MountManager(this, mountPo);
/*  804 */     registManager((ModuleManager)this.mountManager);
/*      */     
/*  806 */     PlayerConsignmentItemsPO consignmentDB = (PlayerConsignmentItemsPO)PlayerPOManager.findPO(ConstsTR.player_consignmentTR, getId(), PlayerConsignmentItemsPO.class);
/*  807 */     this.consignmentManager = new ConsignmentManager(this, consignmentDB);
/*      */     
/*  809 */     this.teamManager = new TeamManager(this);
/*      */     
/*  811 */     setPlayerTasks(new PlayerTasks(this, allBlobData.tasks));
/*      */     
/*  813 */     this.prepaidManager = new PrepaidManager(getId());
/*  814 */     registManager((ModuleManager)this.prepaidManager);
/*      */     
/*  816 */     ActivityDataPO adp = (ActivityDataPO)PlayerPOManager.findPO(ConstsTR.activityTR, (getPlayer()).id, ActivityDataPO.class);
/*  817 */     this.activityManager = new ActivityManager(this, adp);
/*  818 */     registManager((ModuleManager)this.activityManager);
/*      */     
/*  820 */     this.auctionManager = new AuctionManager(this);
/*  821 */     registManager((ModuleManager)this.auctionManager);
/*      */     
/*  823 */     this.demonTowerManager = new DemonTowerManager(this);
/*      */ 
/*      */     
/*  826 */     OnlineDataPO onlineData = (OnlineDataPO)PlayerPOManager.findPO(ConstsTR.onlineGiftTR, getId(), OnlineDataPO.class);
/*  827 */     this.onlineGiftManager = new OnlineGiftManager(this, onlineData);
/*      */     
/*  829 */     this.fightLevelManager = new FightLevelManager(this, (FightLevelsPO)PlayerPOManager.findPO(ConstsTR.player_fightlevelTR, getId(), FightLevelsPO.class));
/*      */     
/*  831 */     this.dropManager = new DropManager(this, (MonsterDropPO)PlayerPOManager.findPO(ConstsTR.monster_drop_infoTR, getId(), MonsterDropPO.class));
/*      */     
/*  833 */     this.friendManager = FriendsCenter.getInstance().getFriendsMgr(getId());
/*  834 */     this.illusionManager = new IllusionManager(this, (IllusionPO)GameDao.get(this.player.id, "player_illusion", IllusionPO.class));
/*  835 */     this.five2FiveManager = new Five2FiveManager(this);
/*  836 */     registManager((ModuleManager)this.five2FiveManager);
/*      */     
/*  838 */     this.btlDataManager = new PlayerBtlDataManager(this);
/*  839 */     registManager((ModuleManager)this.btlDataManager);
/*      */     
/*  841 */     this.fleeManager = new FleeManager(this);
/*  842 */     this.moneyManager = new MoneyManager(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  849 */     this.farmMgr = new FarmMgr(this);
/*      */     
/*  851 */     calFightPower();
/*      */ 
/*      */     
/*  854 */     this.rankManager = new RankManager(this);
/*      */     
/*  856 */     this.richManager = new RichManager(this);
/*  857 */     registManager((ModuleManager)this.richManager);
/*      */     
/*  859 */     this.sevenGoalManager = new SevenGoalManager(this);
/*  860 */     registManager((ModuleManager)this.sevenGoalManager);
/*  861 */     init();
/*      */   }
/*      */   
/*      */   private void init() {
/*  865 */     this.demonTowerManager.init();
/*      */     
/*  867 */     this.richManager.init();
/*      */     
/*  869 */     this.dailyActivityMgr.init(this.richManager, this.sevenGoalManager);
/*      */     
/*  871 */     this.petNewManager.init();
/*      */   }
/*      */   
/*      */   public void refreshNewDay() {
/*  875 */     Date now = new Date();
/*  876 */     if (DateUtils.isSameDay(DateUtils.addHours(now, -5), DateUtils.addHours(this.player.refreshTime, -5))) {
/*      */       return;
/*      */     }
/*      */     
/*  880 */     Out.info(new Object[] { "refreshNewDay playerId:", getId(), ",", this.player.name });
/*  881 */     this.player.refreshTime = now;
/*      */     
/*  883 */     this.todayLogined = false;
/*      */ 
/*      */     
/*  886 */     this.playerTempData.sendMailItemNum = 0;
/*  887 */     this.moneyManager.refreshNewDay();
/*      */ 
/*      */     
/*  890 */     this.taskManager.refreshNewDay();
/*      */     
/*  892 */     this.playerAttendance.refreshNewDay();
/*      */     
/*  894 */     this.onlineGiftManager.refreshNewDay();
/*      */     
/*  896 */     this.chouRenManager.refreshNewDay();
/*      */     
/*  898 */     this.titleManager.refreshNewDay();
/*  899 */     this.messageManager.refreshNewDay();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  904 */     this.arenaManager.refreshNewDay();
/*      */     
/*  906 */     this.soloManager.refreshNewDay();
/*  907 */     this.shopMallManager.refreshNewDay();
/*      */ 
/*      */ 
/*      */     
/*  911 */     this.illusionManager.refreshNewDay();
/*      */ 
/*      */     
/*  914 */     this.activityManager.refreshNewDay();
/*      */     
/*  916 */     this.dailyActivityMgr.refreshNewDay();
/*      */ 
/*      */     
/*  919 */     if (this.intergalMallManager != null) {
/*  920 */       this.intergalMallManager.refreshNewDay();
/*      */     }
/*      */ 
/*      */     
/*  924 */     this.guildManager.refreshNewDay();
/*      */ 
/*      */     
/*  927 */     this.consignmentManager.refreshNewDay();
/*      */     
/*  929 */     this.fightLevelManager.refreshNewDay();
/*      */ 
/*      */     
/*  932 */     this.dropManager.refreshNewDay();
/*      */ 
/*      */     
/*  935 */     this.farmMgr.refreshNewDay();
/*      */ 
/*      */     
/*  938 */     this.demonTowerManager.UpdateSweepCount();
/*  939 */     this.demonTowerManager.refreshNewDay();
/*      */ 
/*      */     
/*  942 */     if (this.reliveManager != null) {
/*  943 */       this.reliveManager.refreshNewDay();
/*      */     }
/*  945 */     for (ModuleManager manager : this.allManagers.values()) {
/*  946 */       manager.onPlayerEvent(Const.PlayerEventType.REFRESH_NEWDAY);
/*      */     }
/*      */     
/*  949 */     XianYuanService.getInstance().refreshNewDay(this.allBlobData.xianYuan);
/*      */     
/*  951 */     this.playerAttachPO.KillBossCount = 0;
/*      */ 
/*      */     
/*  954 */     this.equipManager.refreshNewDay();
/*      */     
/*  956 */     this.richManager.checkData();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initBornData() {
/*  963 */     if (this.bornType == Const.BORN_TYPE.HISTORY.value) {
/*  964 */       this.playerTempData.areaId = this.playerTempData.historyAreaId;
/*  965 */       this.playerTempData.x = this.playerTempData.historyX;
/*  966 */       this.playerTempData.y = this.playerTempData.historyY;
/*  967 */     } else if (this.bornType == Const.BORN_TYPE.BORN.value) {
/*  968 */       this.playerTempData.areaId = this.playerTempData.bornAreaId;
/*  969 */       this.playerTempData.x = this.playerTempData.bornX;
/*  970 */       this.playerTempData.y = this.playerTempData.bornY;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initAndCalAllInflu(Collection<String> allyIds) {
/*  978 */     initBornData();
/*  979 */     CharacterCO basicData = (CharacterCO)GameData.Characters.get(Integer.valueOf(this.player.pro));
/*  980 */     if (basicData == null) {
/*  981 */       String msg = "there is no data of pro: " + this.player.pro + " in characterProps ";
/*  982 */       throw new RuntimeException(msg);
/*      */     } 
/*      */     
/*  985 */     this.basicProp = basicData;
/*      */     
/*  987 */     CharacterLevelCO levelData = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(this.player.level));
/*  988 */     if (levelData == null) {
/*  989 */       Out.error(new Object[] { "there is no data of level: ", Integer.valueOf(this.player.level), " in characterLevelProps " });
/*      */     }
/*      */     
/*  992 */     this.player.needExp = levelData.experience;
/*      */     
/*  994 */     calFightPower();
/*      */   }
/*      */   
/*      */   public boolean setClientCustomConfig(String key, String value, boolean push) {
/*  998 */     if (this.playerAttachPO.config == null) {
/*  999 */       this.playerAttachPO.config = new HashMap<>();
/*      */     }
/* 1001 */     int len = this.playerAttachPO.config.size();
/*      */     
/* 1003 */     if (len >= 300) {
/* 1004 */       return false;
/*      */     }
/* 1006 */     if (!StringUtil.isEmpty(value)) {
/* 1007 */       this.playerAttachPO.config.put(key, value);
/*      */     } else {
/* 1009 */       this.playerAttachPO.config.remove(key);
/*      */     } 
/* 1011 */     if (push) {
/* 1012 */       PlayerHandler.ClientConfigPush.Builder data = PlayerHandler.ClientConfigPush.newBuilder();
/* 1013 */       data.setS2CKey(key);
/* 1014 */       data.setS2CValue(value);
/* 1015 */       receive("area.playerPush.clientConfigPush", (GeneratedMessage)data.build());
/*      */     } 
/* 1017 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void calFightPower() {
/* 1024 */     int old = this.player.fightPower;
/* 1025 */     this.player.fightPower = CommonUtil.calPlayerFightPower(this.btlDataManager.fightPowerInflus, this.player.pro);
/*      */ 
/*      */     
/* 1028 */     this.player.fightPower += this.skillManager.getSkillsPower();
/*      */     
/* 1030 */     if (this.player.fightPower > this.player.maxFightPower) {
/* 1031 */       this.player.maxFightPower = this.player.fightPower;
/* 1032 */       Out.info(new Object[] { "战力提升 playerId=", getId(), ",name=", getName(), ", fightPower=", Integer.valueOf(this.player.fightPower) });
/*      */     } 
/*      */     
/* 1035 */     if (this.rankManager != null) {
/* 1036 */       this.rankManager.onEvent(RankType.FIGHTPOWER, new Object[] { Integer.valueOf(this.player.fightPower) });
/*      */     }
/* 1038 */     if (this.sevenGoalManager != null) {
/* 1039 */       this.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.FIGHTPOWER_TO, new Object[] { Integer.valueOf(this.player.fightPower) });
/*      */     }
/*      */     
/* 1042 */     this.activityManager.updateDeskRedPoint();
/* 1043 */     if (old < this.player.fightPower)
/*      */     {
/* 1045 */       BILogService.getInstance().recordNum(this, Const.BiLogType.FightPower, (this.player.fightPower - old), null);
/*      */     }
/* 1047 */     this.achievementManager.playerPowerChange(this.player.fightPower);
/* 1048 */     this.baseDataManager.updateFightTime(new Date());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, Object> _getBattlerServerBasic() {
/* 1055 */     Map<String, Object> data = new HashMap<>();
/* 1056 */     data.put("name", getName());
/* 1057 */     data.put("camp", Integer.valueOf(Const.AreaCamp.Neutral.value));
/* 1058 */     data.put("guildId", this.guildManager.getGuildId());
/* 1059 */     data.put("guildName", this.guildManager.getGuildName());
/* 1060 */     data.put("guildIcon", this.guildManager.getGuildIcon());
/* 1061 */     data.put("pro", Integer.valueOf(this.player.pro));
/* 1062 */     data.put("serverId", Integer.valueOf(getLogicServerId()));
/* 1063 */     data.put("titleId", Integer.valueOf(this.titleManager.getTitleId()));
/* 1064 */     data.put("level", Integer.valueOf(this.player.level));
/* 1065 */     data.put("vip", Integer.valueOf(this.player.vip));
/* 1066 */     data.put("upLevel", Integer.valueOf(this.player.upLevel));
/* 1067 */     data.put("beReward", Integer.valueOf(0));
/* 1068 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONArray _getBattleServerTask() {
/* 1077 */     return this.taskManager.toJson4BattleServer();
/*      */   }
/*      */   
/*      */   public List<Object[]> _getBattleServerTaskFlag() {
/* 1081 */     return this.sceneProgressManager.toJson4BattleServer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, Number> _getBattlerServerEffect() {
/* 1088 */     return this.btlDataManager._getBattlerServerEffect();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshBattlerServerBasic() {
/* 1095 */     String basic = JSON.toJSONString(_getBattlerServerBasic());
/* 1096 */     getXmdsManager().refreshPlayerBasicData(getId(), basic);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainBagCountData(int remainCount) {
/* 1103 */     getXmdsManager().refreshPlayerRemainBagCountData(getId(), remainCount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerRemainTeamBagCountData(int remainCount) {
/* 1110 */     if (remainCount <= 3) {
/* 1111 */       getXmdsManager().refreshPlayerRemainTeamBagCountData(getId(), remainCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshBattlerServerEffect(boolean isHpMpValid) {
/* 1119 */     Map<String, Number> effects = _getBattlerServerEffect();
/* 1120 */     if (!isHpMpValid) {
/* 1121 */       effects.put("HP", Integer.valueOf(-1));
/* 1122 */       effects.put("MP", Integer.valueOf(-1));
/*      */     } 
/* 1124 */     String str = JSON.toJSONString(effects);
/* 1125 */     getXmdsManager().refreshPlayerBattleEffect(getId(), str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshBattlerServerSkill(int type, List<Integer> skillIds) {
/* 1132 */     if (!this.area.hasPlayer(getId()))
/*      */       return; 
/* 1134 */     String _skillData = getXmdsManager().getPlayerSkillCDTime(getId());
/* 1135 */     List<SkillDataICE> skillData = (List<SkillDataICE>)JSON.parseObject(_skillData, new TypeReference<List<SkillDataICE>>() {  }, new com.alibaba.fastjson.parser.Feature[0]);
/* 1136 */     this.skillManager.syncBattleSkillTime(skillData);
/* 1137 */     List<SkillManager.SkillInfo> data = null;
/* 1138 */     if (type == Const.SkillHandleType.ALL.getValue()) {
/* 1139 */       data = this.skillManager.toJson4BattleServer();
/* 1140 */     } else if (type == Const.SkillHandleType.CHANGE.getValue() || type == Const.SkillHandleType.ADD.getValue() || type == Const.SkillHandleType.DELETE.getValue()) {
/* 1141 */       data = this.skillManager.toJson4UpdateBattleServer(type, skillIds);
/*      */     } 
/* 1143 */     if (data != null && data.size() > 0) {
/* 1144 */       getXmdsManager().refreshPlayerSkill(getId(), type, JSON.toJSONString(data));
/*      */     } else {
/* 1146 */       Out.debug(new Object[] { "send to battle server skill change data is null,it is not influence" });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshBattlerServerAvatar() {
/* 1154 */     List<AvatarObj> list = PlayerUtil.getBattlerServerAvatarObj(this);
/* 1155 */     Map<String, List<AvatarObj>> avatars = new HashMap<>();
/* 1156 */     avatars.put("avatars", list);
/* 1157 */     String avatars_str = JSON.toJSONString(avatars);
/* 1158 */     Out.debug(new Object[] { "refreshBattlerServerAvatar:", avatars_str });
/* 1159 */     getXmdsManager().refreshPlayerAvatar(getId(), avatars_str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshPlayerPropertyChange(RefreshPlayerPropertyChange data) {
/* 1168 */     Out.debug(new Object[] { "refreshPlayerPropertyChange :", data });
/* 1169 */     getXmdsManager().refreshPlayerPropertyChange(getId(), JSON.toJSONString(data));
/*      */   }
/*      */   
/*      */   public void refreshPlayerPetPropertyChange(RefreshPlayerPropertyChange data) {
/* 1173 */     Out.debug(new Object[] { "refreshPlayerPetPropertyChange :", data });
/* 1174 */     getXmdsManager().refreshPlayerPetPropertyChange(getId(), JSON.toJSONString(data));
/*      */   }
/*      */   
/*      */   public void changePlayerPkValue(int value) {
/* 1178 */     getXmdsManager().refreshPlayerPKValue(getId(), value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForce(int force) {
/* 1185 */     this.force = force;
/*      */   }
/*      */   
/*      */   public int getForce() {
/* 1189 */     return this.force;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void syncBornData(float bornX, float bornY, int bornAreaId) {
/* 1196 */     this.playerTempData.bornX = bornX;
/* 1197 */     this.playerTempData.bornY = bornY;
/* 1198 */     this.playerTempData.bornAreaId = bornAreaId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void syncHistoryData(int areaId, String instanceId, GetPlayerData data) {
/* 1205 */     this.playerTempData.historyAreaId = areaId;
/* 1206 */     this.playerTempData.historyX = data.x;
/* 1207 */     this.playerTempData.historyY = data.y;
/* 1208 */     this.playerTempData.historyDirection = data.direction;
/* 1209 */     Out.debug(new Object[] { getName(), ">>>>>>>>>>>>>history areaId:", Integer.valueOf(areaId), ">>>historyX:", Float.valueOf(data.x), ">>>historyY:", Float.valueOf(data.y) });
/*      */     
/* 1211 */     this.pkRuleManager.setHistoryPkModel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void syncNowData(int areaId, String instanceId, GetPlayerData data) {
/* 1218 */     this.playerTempData.x = data.x;
/* 1219 */     this.playerTempData.y = data.y;
/* 1220 */     this.playerTempData.direction = data.direction;
/* 1221 */     this.playerTempData.hp = data.hp;
/* 1222 */     this.playerTempData.mp = data.mp;
/* 1223 */     this.playerTempData.areaId = areaId;
/*      */     
/* 1225 */     this.pkRuleManager.pkData.pkModel = data.pkMode;
/* 1226 */     this.pkRuleManager.pkData.pkValue = data.pkValue;
/* 1227 */     this.pkRuleManager.pkData.pkLevel = data.pkLevel;
/*      */     
/* 1229 */     this.skillManager.syncBattleSkillTime(Arrays.asList(data.skillData));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLastChangeAreaTime() {
/* 1238 */     return this.lastChangeTime;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setArea(Area area) {
/* 1246 */     if (this.area != null && GWorld.APP_TIME - this.lastChangeTime < 1000L) {
/* 1247 */       Out.warn(new Object[] { getName(), " : ", this.area.getSceneName(), "-", this.area.instanceId, " to ", area.getSceneName(), "-", area.instanceId, " use ", Long.valueOf(GWorld.APP_TIME - this.lastChangeTime), "ms use ", JSON.toJSONString(this.playerTempData) });
/*      */     }
/*      */     
/* 1250 */     this.area = area;
/* 1251 */     setBattleServerId(area.getServerId());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1256 */     Out.debug(new Object[] { "set player area data: ", area });
/* 1257 */     this.lastChangeTime = GWorld.APP_TIME;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addPrestige(int prestige) {
/* 1262 */     addPrestige(prestige, (Const.GOODS_CHANGE_TYPE)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public void addPrestige(int prestige, Const.GOODS_CHANGE_TYPE from) {
/* 1267 */     this.baseDataManager.addPrestige(prestige, from);
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
/*      */   public void onUpgrade() {
/* 1283 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1284 */       manager.onPlayerEvent(Const.PlayerEventType.UPGRADE);
/*      */     }
/*      */ 
/*      */     
/* 1288 */     this.functionOpenManager.onUpgradeLevelOrVip();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1293 */     this.equipManager.OnPlayerLevelUp();
/*      */ 
/*      */ 
/*      */     
/* 1297 */     this.skillManager.updateSuperScript();
/*      */ 
/*      */     
/* 1300 */     this.teamManager.onPlayerUpgrade();
/*      */ 
/*      */     
/* 1303 */     this.achievementManager.playerLevelChange(this.player.level);
/* 1304 */     WNNotifyManager.getInstance().levelChange(this, this.player.level);
/* 1305 */     this.activityManager.updateDeskRedPoint();
/*      */ 
/*      */     
/* 1308 */     calFightPower();
/*      */     
/* 1310 */     this.playerTempData.hp = ((Integer)this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
/* 1311 */     pushAndRefreshEffect(true);
/* 1312 */     refreshBattlerServerBasic();
/* 1313 */     pushDynamicData(Utils.ofMap(new Object[] { "level", Integer.valueOf(this.player.level), "exp", Long.valueOf(this.player.exp), "needExp", Integer.valueOf(this.player.needExp), "fightPower", Integer.valueOf(this.player.fightPower) }));
/*      */ 
/*      */     
/* 1316 */     this.equipManager.updateEquipScript(null);
/*      */     
/* 1318 */     this.equipManager.updateStrengthScript(null);
/*      */     
/* 1320 */     this.equipManager.updateMakeScript(null);
/*      */     
/* 1322 */     this.baseDataManager.updateLvChangeTime(new Date());
/*      */     
/* 1324 */     if (getLevel() >= 10) {
/* 1325 */       sync();
/* 1326 */       RobotUtil.cloneRobot(this);
/*      */     } 
/*      */     
/* 1329 */     this.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.LEVEL_TO, new Object[] { Integer.valueOf(getLevel()) });
/*      */   }
/*      */   
/*      */   public void addExp(int exp, Const.GOODS_CHANGE_TYPE from) {
/* 1333 */     addExp(exp, from, 0);
/*      */   }
/*      */   
/*      */   public void addUpExp(int value, Const.GOODS_CHANGE_TYPE from) {
/* 1337 */     this.baseDataManager.addClassExp(value, from);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addExp(int exp, Const.GOODS_CHANGE_TYPE from, int teamExp) {
/* 1344 */     this.baseDataManager.addExp(exp, from, teamExp);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void recoverHPAndMP() {
/* 1351 */     this.playerTempData.hp = ((Integer)this.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
/*      */   }
/*      */   
/*      */   public void customTip(Const.CUSTOMTIPTYPE type, int num) {
/* 1355 */     String strType = "";
/* 1356 */     switch (type) {
/*      */       case GOLD:
/* 1358 */         strType = "GAIN_GOLDS";
/*      */         break;
/*      */       case TICKET:
/* 1361 */         strType = "GAIN_CASH";
/*      */         break;
/*      */       case DIAMOND:
/* 1364 */         strType = "GAIN_DIAMOND";
/*      */         break;
/*      */       case EXP:
/* 1367 */         strType = "GAIN_EXP";
/*      */         break;
/*      */       case PRESTIGE:
/* 1370 */         strType = "GAIN_PRESTIGE";
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/* 1375 */     if (StringUtil.isEmpty(strType)) {
/*      */       return;
/*      */     }
/* 1378 */     String addStr = LangService.format(strType, new Object[] { Integer.valueOf(num) });
/* 1379 */     sendSysTip(addStr, Const.TipsType.NEWTYPE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addGuildPoint(int num) {
/* 1386 */     return this.baseDataManager.addGuildPoint(num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPetPkModel(int model) {
/* 1393 */     this.petNewManager.changePetPkModel(model);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIsAcceptAutoTeam(int isAcceptAutoTeam) {
/* 1401 */     this.player.isAcceptAutoTeam = isAcceptAutoTeam;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnterState(int enterState) {
/* 1408 */     this.enterState = enterState;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBornType(Const.BORN_TYPE bornType) {
/* 1415 */     this.bornType = bornType.value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBornType(Const.BORN_TYPE bornType, int areaId) {
/* 1422 */     this.bornType = bornType.value;
/* 1423 */     Out.debug(new Object[] { "setBornType bornType:", bornType, " tempData:", Integer.valueOf(this.playerTempData.areaId) });
/* 1424 */     if (this.bornType == Const.BORN_TYPE.HISTORY.value) {
/* 1425 */       this.playerTempData.areaId = this.playerTempData.historyAreaId;
/* 1426 */       this.playerTempData.x = this.playerTempData.historyX;
/* 1427 */       this.playerTempData.y = this.playerTempData.historyY;
/* 1428 */     } else if (this.bornType == Const.BORN_TYPE.BORN.value) {
/* 1429 */       this.playerTempData.bornAreaId = this.playerTempData.areaId = areaId;
/* 1430 */       this.playerTempData.x = this.playerTempData.bornX = 0.0F;
/* 1431 */       this.playerTempData.y = this.playerTempData.bornY = 0.0F;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean onMessage(int operate, MessageData message) {
/* 1440 */     boolean result = true;
/* 1441 */     Out.debug(new Object[] { "player onMessage:", message });
/* 1442 */     MessageUtil.deleteSendedPlayerMessage(message);
/* 1443 */     if (message.messageType == Const.MESSAGE_TYPE.mail_receive.getValue()) {
/* 1444 */       result = this.mailManager.onMessage(operate, message);
/* 1445 */     } else if (message.messageType == Const.MESSAGE_TYPE.daily_task_times.getValue()) {
/* 1446 */       result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.daily_task_times, operate, message);
/* 1447 */     } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_addfriend.getValue()) {
/* 1448 */       result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_addfriend, operate, message);
/* 1449 */     } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_member_leave.getValue()) {
/* 1450 */       result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_member_leave, operate, message);
/* 1451 */     } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_times.getValue()) {
/* 1452 */       result = TaskMessages.onMessage(this, Const.MESSAGE_TYPE.loop_task_times, operate, message);
/* 1453 */     } else if (message.messageType == Const.MESSAGE_TYPE.consignment_publish.getValue()) {
/* 1454 */       result = ConsignmentUtil.onMessage(this, Const.MESSAGE_TYPE.consignment_publish, operate, message);
/*      */     } 
/* 1456 */     this.messageManager.deleteReceivedMessage(message.messageType, message.id);
/* 1457 */     return result;
/*      */   }
/*      */   
/*      */   public boolean onSaveRebirth(TaskEvent event) {
/* 1461 */     if (event.type == Const.EventType.rebirth.getValue()) {
/*      */       
/* 1463 */       Area area = getArea();
/* 1464 */       if (!area.canRebirth(getId())) {
/* 1465 */         return true;
/*      */       }
/* 1467 */       String name = event.params[1].toString();
/* 1468 */       WNNotifyManager.getInstance().pushRebirth(this, name);
/* 1469 */       return true;
/*      */     } 
/* 1471 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onBatterServerSceneEvent(String eventId) {
/* 1478 */     Out.debug(new Object[] { "onBatterServerSceneEvent eventId:", eventId });
/* 1479 */     EventCO eventProp = (EventCO)GameData.Events.get(eventId);
/* 1480 */     if (eventProp != null && eventProp.eventType == 1) {
/* 1481 */       int toAreaId = Integer.parseInt(eventProp.eventData1);
/* 1482 */       AreaUtil.enterArea(this, toAreaId, 0.0F, 0.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onEvent(TaskEvent event) {
/* 1487 */     event.player = this;
/* 1488 */     TaskQueue.put(event);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GuildMemberPO toJSON4GuildMember() {
/* 1496 */     GuildMemberPO data = new GuildMemberPO();
/* 1497 */     data.playerId = getId();
/* 1498 */     data.name = getName();
/* 1499 */     data.pro = (getPlayer()).pro;
/* 1500 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushEffectData() {
/* 1507 */     Map<String, Object> data = new HashMap<>();
/* 1508 */     data.put("fightPower", Integer.valueOf(this.player.fightPower));
/* 1509 */     WNNotifyManager.getInstance().pushEffectData(this, data);
/*      */   }
/*      */   
/*      */   public void pushDynamicData(String key, Object value) {
/* 1513 */     WNNotifyManager.getInstance().pushPlayerDynamic(this, Utils.ofMap(new Object[] { key, value }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin) {
/* 1520 */     pushDynamicData(key, value, origin, (List<Common.KeyValueStruct>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushDynamicData(String key, Object value, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
/* 1527 */     Common.PropertyStruct.Builder data = Common.PropertyStruct.newBuilder();
/* 1528 */     data.setKey(key);
/* 1529 */     data.setValue(String.valueOf(value));
/* 1530 */     if (origin != null) {
/* 1531 */       data.setSource(origin.getValue());
/*      */     }
/* 1533 */     data.setType(1);
/* 1534 */     if (itemChange != null) {
/* 1535 */       data.addAllItems(itemChange);
/*      */     }
/* 1537 */     WNNotifyManager.getInstance().pushPlayerDynamic(this, data.build());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushDynamicData(Map<String, Object> atts) {
/* 1546 */     WNNotifyManager.getInstance().pushPlayerDynamic(this, atts);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushAndRefreshEffect(boolean isHpMpValid) {
/* 1553 */     refreshBattlerServerEffect(isHpMpValid);
/* 1554 */     pushEffectData();
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendSysTip(String content) {
/* 1559 */     sendSysTip(content, Const.TipsType.NORMAL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendSysTip(String content, Const.TipsType type) {
/* 1566 */     MessageUtil.sendSysTip(this, content, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void nofitySuperScript() {
/* 1573 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/*      */     
/* 1575 */     List<PlayerHandler.SuperScriptType> s2c_data = new ArrayList<>();
/* 1576 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1577 */       List<PlayerHandler.SuperScriptType> list = manager.getSuperScript();
/* 1578 */       if (list != null) {
/* 1579 */         s2c_data.addAll(list);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1584 */     s2c_data.addAll(this.mailManager.getSuperScript());
/* 1585 */     s2c_data.addAll(this.soloManager.getSuperScript());
/* 1586 */     s2c_data.addAll(this.arenaManager.getSuperScript());
/* 1587 */     s2c_data.addAll(this.shopMallManager.getSuperScript());
/* 1588 */     s2c_data.addAll(this.achievementManager.getSuperScript());
/* 1589 */     s2c_data.addAll(this.mountManager.getSuperScript());
/* 1590 */     s2c_data.addAll(this.equipManager.getSuperScript());
/*      */     
/* 1592 */     data.addAllS2CData(s2c_data);
/*      */     
/* 1594 */     receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getItemChangeScript() {
/* 1601 */     List<PlayerHandler.SuperScriptType> s2c_data = new ArrayList<>();
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
/* 1613 */     Out.debug(new Object[] { "itemChangeScript data:", s2c_data });
/* 1614 */     return s2c_data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSuperScript(Const.SUPERSCRIPT_TYPE type, int number) {
/* 1624 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/*      */     
/* 1626 */     PlayerHandler.SuperScriptType.Builder scriptType = PlayerHandler.SuperScriptType.newBuilder();
/* 1627 */     scriptType.setType(type.getValue());
/* 1628 */     scriptType.setNumber(number);
/* 1629 */     data.addS2CData(scriptType);
/*      */     
/* 1631 */     receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSuperScriptList(List<PlayerHandler.SuperScriptType> scriptList) {
/* 1641 */     if (scriptList == null || scriptList.isEmpty()) {
/*      */       return;
/*      */     }
/* 1644 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/* 1645 */     data.addAllS2CData(scriptList);
/* 1646 */     receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void puchFuncGoToTicketNotEnough() {
/* 1653 */     onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.TICKET_NOT_ENOUGH, (String)null, (String)null, (FunctionHandler.TipsParam)null);
/*      */   }
/*      */   
/*      */   public void puchFuncGoToPickItem() {
/* 1657 */     onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.PICK_ITEM, (String)null, (String)null, (FunctionHandler.TipsParam)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFunctionGoTo(Const.FUNCTION_GOTO_TYPE funGoId, String itemCode, String id, FunctionHandler.TipsParam tipsParam) {
/* 1664 */     FunctionHandler.FunctionGoToPush.Builder args = FunctionHandler.FunctionGoToPush.newBuilder();
/* 1665 */     args.setS2CFunGoId(funGoId.getValue());
/* 1666 */     if (!StringUtil.isEmpty(itemCode)) {
/* 1667 */       args.setS2CItemCode(itemCode);
/*      */     }
/* 1669 */     if (!StringUtil.isEmpty(id)) {
/* 1670 */       args.setS2CId(id);
/*      */     }
/* 1672 */     if (tipsParam != null) {
/* 1673 */       args.setS2CParam(tipsParam);
/*      */     }
/*      */     
/* 1676 */     WNNotifyManager.getInstance().pushFunctionGoTo(this, args);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEndEnterScene() {
/* 1683 */     this.mountManager.pushToClientMountsFlag();
/* 1684 */     getXmdsManager().playerReady(getId());
/*      */     
/* 1686 */     Area area = getArea();
/* 1687 */     Area.Actor actor = area.getActor(getId());
/* 1688 */     if (actor != null) {
/* 1689 */       if (actor.ready && !inPvP())
/*      */         return; 
/* 1691 */       actor.ready = true;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1699 */     TeamService.changeTeamArea(this);
/* 1700 */     area.onEndEnterScene(this);
/*      */     
/* 1702 */     RobotUtil.onRobotReplyHP(this);
/* 1703 */     Out.debug(new Object[] { this.battleServerId, " onEndEnterScene : ", area });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFishItem(List<ItemOuterClass.MiniItem> item) {
/* 1710 */     WNNotifyManager.getInstance().pushFishItem(this, item);
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
/*      */   public void sendLeaveWord() {}
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
/*      */   public boolean canTalkWithNpc(int templateId, int npcId) {
/* 1736 */     return true;
/*      */   }
/*      */   
/*      */   public PlayerOuterClass.LookUpPlayer getFightData() {
/* 1740 */     PlayerOuterClass.LookUpPlayer.Builder data = PlayerOuterClass.LookUpPlayer.newBuilder();
/* 1741 */     data.setName(this.player.name);
/* 1742 */     data.setLevel(this.player.level);
/* 1743 */     data.setUpLevel(this.player.upLevel);
/* 1744 */     data.setUpOrder(this.player.upOrder);
/* 1745 */     data.setPro(this.player.pro);
/* 1746 */     data.setFightPower(this.player.fightPower);
/* 1747 */     data.addAllAttrs(this.btlDataManager._getPlayerAttr());
/* 1748 */     return data.build();
/*      */   }
/*      */   
/*      */   public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3) {
/* 1752 */     pushChatSystemMessage(type, value1, value2, value3, (Const.GOODS_CHANGE_TYPE)null);
/*      */   }
/*      */   
/*      */   public void pushChatSystemMessage(Const.SYS_CHAT_TYPE type, String value1, Object value2, String value3, Const.GOODS_CHANGE_TYPE from) {
/* 1756 */     String str = "";
/* 1757 */     if (type == Const.SYS_CHAT_TYPE.ITEM) {
/* 1758 */       String strQt = ItemUtil.getColorItemNameByQcolor(((Integer)value2).intValue(), value1);
/* 1759 */       if (from != null && from == Const.GOODS_CHANGE_TYPE.shop) {
/* 1760 */         str = LangService.format("ITEM_GET_BUY", new Object[] { value3, strQt });
/*      */       } else {
/* 1762 */         str = LangService.format("ITEM_GET", new Object[] { value3, strQt });
/*      */       } 
/* 1764 */     } else if (type == Const.SYS_CHAT_TYPE.EXP) {
/* 1765 */       if (value2 != null && StringUtil.isNotEmpty(String.valueOf(value2))) {
/* 1766 */         str = LangService.format("GAIN_EXP_CHAT_WORLDLEVEL", new Object[] { value1, value2 });
/*      */       } else {
/* 1768 */         str = LangService.format("GAIN_EXP_CHAT", new Object[] { value1 });
/*      */       } 
/* 1770 */     } else if (type == Const.SYS_CHAT_TYPE.CLASS_EXP) {
/* 1771 */       str = LangService.format("GAIN_CLASS_EXP_CHAT", new Object[] { value1 });
/* 1772 */     } else if (type == Const.SYS_CHAT_TYPE.TEAM_EXP) {
/* 1773 */       str = LangService.format("GAIN_TEAM_EXP", new Object[] { value1, value2 });
/* 1774 */     } else if (type == Const.SYS_CHAT_TYPE.COIN) {
/* 1775 */       str = LangService.format("GAIN_GOLDS_CHAT", new Object[] { value1 });
/* 1776 */     } else if (type == Const.SYS_CHAT_TYPE.TRADE && 
/* 1777 */       value2 != null) {
/* 1778 */       String str1 = "";
/*      */       
/* 1780 */       List<WNBag.TradeMessageItemData> list = (List<WNBag.TradeMessageItemData>)value2;
/* 1781 */       for (WNBag.TradeMessageItemData item : list) {
/* 1782 */         str1 = str1 + ItemUtil.getColorItemNameByQcolor(item.qt, item.name) + "*" + item.num + ", ";
/*      */       }
/* 1784 */       if (str1 != "") {
/* 1785 */         if (value1 != null) {
/* 1786 */           str = LangService.getValue("TRADE_GET");
/*      */         } else {
/* 1788 */           str = LangService.getValue("TRADE_LOST");
/*      */         } 
/* 1790 */         str1 = str1.substring(0, str1.length() - 2);
/* 1791 */         str = str.replace("{tradeItem}", str1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1796 */     if (!StringUtil.isEmpty(str)) {
/* 1797 */       MessageUtil.sendSysChat(this, str);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void update() {
/* 1806 */     this.bag.update();
/* 1807 */     this.wareHouse.update();
/* 1808 */     GameDao.update(getId(), ConstsTR.playerBtlData.value, this.btlDataManager.finalInflus);
/*      */     
/* 1810 */     if (this.reliveManager != null) {
/* 1811 */       GameDao.update(ConstsTR.DAILY_RELIVE.value, getId(), this.reliveManager);
/*      */     }
/* 1813 */     if (this.intergalMallManager != null) {
/* 1814 */       GameDao.update(ConstsTR.intergalMallTR.value, getId(), this.intergalMallManager.intergalMallPO);
/*      */     }
/* 1816 */     GameDao.update(this.player.id, "player_illusion", this.illusionManager.illusionPO);
/*      */   }
/*      */   
/*      */   public ZoneManagerPrx getZoneManager() {
/* 1820 */     return CSharpClient.getZoneManager(getBattleServerId());
/*      */   }
/*      */   
/*      */   public XmdsManagerPrx getXmdsManager() {
/* 1824 */     return CSharpClient.getXmdsManager(getBattleServerId());
/*      */   }
/*      */   
/*      */   public Area getArea() {
/* 1828 */     return this.area;
/*      */   }
/*      */   
/*      */   public boolean inPvP() {
/* 1832 */     return (getSceneType() == Const.SCENE_TYPE.ARENA.getValue() || getSceneType() == Const.SCENE_TYPE.FIVE2FIVE.getValue() || getSceneType() == Const.SCENE_TYPE.SIN_COM.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onClassUpgrade() {
/* 1839 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1840 */       manager.onPlayerEvent(Const.PlayerEventType.CLASS_UPGRADE);
/*      */     }
/*      */     
/* 1843 */     refreshBattlerServerEffect(false);
/* 1844 */     updateFightPowerPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onMountPropChange() {
/* 1851 */     this.btlDataManager.onMountPropChange();
/* 1852 */     refreshBattlerServerEffect(false);
/* 1853 */     updateFightPowerPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onExchangeProparty() {
/* 1860 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1861 */       manager.onPlayerEvent(Const.PlayerEventType.EXCHANGE_PROPARTY);
/*      */     }
/*      */     
/* 1864 */     refreshBattlerServerEffect(false);
/* 1865 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   public void onPlayerSkillUpgrade() {
/* 1869 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   public void onTalentPassiveSkillUpgrade() {
/* 1873 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1874 */       manager.onPlayerEvent(Const.PlayerEventType.UPGRADE_TALENT_PASSIVE_SKILL);
/*      */     }
/* 1876 */     refreshBattlerServerEffect(false);
/* 1877 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   public void onEquipChange(Const.GOODS_CHANGE_TYPE from) {
/* 1881 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1882 */       manager.onPlayerEvent(Const.PlayerEventType.EQUIPMENT_CHANGE);
/*      */     }
/* 1884 */     refreshBattlerServerEffect(false);
/* 1885 */     updateFightPowerPoint(from);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFashionChange() {
/* 1892 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1893 */       manager.onPlayerEvent(Const.PlayerEventType.FASHION_CHANGE);
/*      */     }
/* 1895 */     refreshBattlerServerEffect(false);
/* 1896 */     updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.Fashion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onBloodChange() {
/* 1903 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1904 */       manager.onPlayerEvent(Const.PlayerEventType.BLOOD);
/*      */     }
/* 1906 */     refreshBattlerServerEffect(false);
/* 1907 */     updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.blood);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onArmourActive() {
/* 1914 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1915 */       manager.onPlayerEvent(Const.PlayerEventType.ARMOUR_ACTIVE);
/*      */     }
/* 1917 */     refreshBattlerServerEffect(false);
/* 1918 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   public void onPetPropChange() {
/* 1922 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1923 */       manager.onPlayerEvent(Const.PlayerEventType.PET_PROP_CHANGE);
/*      */     }
/* 1925 */     refreshBattlerServerEffect(false);
/* 1926 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   public void onGuildBlessChange() {
/* 1930 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1931 */       manager.onPlayerEvent(Const.PlayerEventType.GUILD_BLESS_CHANGE);
/*      */     }
/* 1933 */     refreshBattlerServerEffect(false);
/* 1934 */     updateFightPowerPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updatePlayerGuildTechAttrs() {
/* 1941 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1942 */       manager.onPlayerEvent(Const.PlayerEventType.GUILD_TECH_CHANGE);
/*      */     }
/* 1944 */     refreshBattlerServerEffect(false);
/* 1945 */     updateFightPowerPoint();
/*      */   }
/*      */   
/*      */   private void updateFightPowerPoint() {
/* 1949 */     updateFightPowerPoint(Const.GOODS_CHANGE_TYPE.def);
/*      */   }
/*      */   
/*      */   private void updateFightPowerPoint(Const.GOODS_CHANGE_TYPE from) {
/* 1953 */     calFightPower();
/* 1954 */     pushDynamicData("fightPower", Integer.valueOf(this.player.fightPower), from);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateTitleAttrs() {
/* 1961 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1962 */       manager.onPlayerEvent(Const.PlayerEventType.TITLE_CHANGE);
/*      */     }
/* 1964 */     refreshBattlerServerEffect(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public PlayerInteract getInteractManager() {
/* 1970 */     if (this.interactManager == null) {
/* 1971 */       this.interactManager = new PlayerInteract(this);
/*      */     }
/* 1973 */     return this.interactManager;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ReliveManager getReliveManager() {
/* 1979 */     if (this.reliveManager == null) {
/* 1980 */       String dailyRelive = GCache.hget(ConstsTR.DAILY_RELIVE.value, getId());
/* 1981 */       this.reliveManager = StringUtil.isNotEmpty(dailyRelive) ? (ReliveManager)JSON.parseObject(dailyRelive, ReliveManager.class) : new ReliveManager();
/*      */     } 
/* 1983 */     return this.reliveManager;
/*      */   }
/*      */   
/*      */   public void free() {
/* 1987 */     update();
/* 1988 */     PlayerPOManager.clearOfflinePO(getId());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPay() {
/* 1995 */     for (ModuleManager manager : this.allManagers.values()) {
/* 1996 */       manager.onPlayerEvent(Const.PlayerEventType.PAY);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void kick(Const.KickReason reason) {
/*      */     try {
/* 2005 */       PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
/* 2006 */       data.setS2CReasonType(reason.value);
/* 2007 */       this.session.write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage)data.build())).getContent()).await(2000L);
/* 2008 */     } catch (InterruptedException interruptedException) {}
/* 2009 */     this.session.close();
/* 2010 */     doLogout(false);
/*      */   }
/*      */   
/*      */   public boolean isRobot() {
/* 2014 */     return PlayerUtil.isRobot(this.player);
/*      */   }
/*      */   
/*      */   public boolean isProxy() {
/* 2018 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isRomote() {
/* 2022 */     if (this.teamManager.acrossTargetId > 0) {
/* 2023 */       return true;
/*      */     }
/* 2025 */     TeamData team = this.teamManager.getTeam();
/* 2026 */     return (team != null && !team.local);
/*      */   }
/*      */   
/*      */   public void changeArea(AreaData areaData) {
/* 2030 */     AreaUtil.changeArea(this, areaData);
/*      */   }
/*      */   
/*      */   public PetNew getFightingPet() {
/* 2034 */     return this.petNewManager.getFightingPet();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getTeamMembers() {
/* 2040 */     if (this.teamMembers != null)
/* 2041 */       return this.teamMembers.keySet(); 
/* 2042 */     Map<String, TeamData.TeamMemberData> teamMembers = this.teamManager.getTeamMembers();
/* 2043 */     if (teamMembers != null) {
/* 2044 */       return teamMembers.keySet();
/*      */     }
/* 2046 */     return null;
/*      */   }
/*      */   
/*      */   public void finishFightLevel(int currHard, int templateID) {}
/*      */   
/*      */   public void onProxyEvent(int type, ProxyEventCB event) {}
/*      */   
/*      */   public int getGuildExdExp() {
/* 2054 */     return this.guildManager.calAllInfluence().containsKey("ExdExp") ? ((Integer)this.guildManager.calAllInfluence().get("ExdExp")).intValue() : 0;
/*      */   }
/*      */   
/*      */   public int getGuildExdGold() {
/* 2058 */     return this.guildManager.calAllInfluence().containsKey("ExdGold") ? ((Integer)this.guildManager.calAllInfluence().get("ExdGold")).intValue() : 0;
/*      */   }
/*      */   
/*      */   public int getBtlExdGold() {
/* 2062 */     return this.btlDataManager.allInflus.containsKey(Const.PlayerBtlData.ExdGold) ? ((Integer)this.btlDataManager.allInflus.get(Const.PlayerBtlData.ExdGold)).intValue() : 0;
/*      */   }
/*      */   
/*      */   public int processXianYuanGet(int from) {
/* 2066 */     int addNum = XianYuanService.getInstance().processXianYuanGet(from, this.allBlobData.xianYuan);
/* 2067 */     if (addNum > 0) {
/* 2068 */       this.moneyManager.addXianYuan(addNum, from);
/*      */     }
/* 2070 */     return addNum;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\WNPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */