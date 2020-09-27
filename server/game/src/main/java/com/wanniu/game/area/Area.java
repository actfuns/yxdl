/*      */ package com.wanniu.game.area;
/*      */ 
/*      */

/*      */ import Xmds.FinishPickItem;
/*      */ import Xmds.GetPlayerData;
/*      */ import Xmds.XmdsManagerPrx;
/*      */ import com.alibaba.fastjson.JSON;
/*      */ import com.alibaba.fastjson.JSONArray;
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GPlayer;
/*      */ import com.wanniu.core.game.protocol.PomeloPush;
/*      */ import com.wanniu.core.logfs.Out;
/*      */
/*      */ import com.wanniu.core.tcp.protocol.Message;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.csharp.CSharpClient;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.chat.ChannelUtil;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.common.msg.MessagePush;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.common.msg.WNNotifyManager;
/*      */ import com.wanniu.game.daoyou.DaoYouService;
/*      */ import com.wanniu.game.data.CharacterLevelCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.MeltConfigCO;
/*      */ import com.wanniu.game.data.MonsterRefreshCO;
/*      */ import com.wanniu.game.data.ResurrectionCO;
/*      */ import com.wanniu.game.data.base.DItemEquipBase;
/*      */ import com.wanniu.game.data.base.MapBase;
/*      */ import com.wanniu.game.data.base.MonsterBase;
/*      */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*      */ import com.wanniu.game.data.ext.PetConfigExt;
/*      */ import com.wanniu.game.data.ext.RandomBoxExt;
/*      */ import com.wanniu.game.equip.NormalEquip;
/*      */ import com.wanniu.game.item.ItemConfig;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.VirtualItem;
/*      */ import com.wanniu.game.item.data.ItemToBtlServerData;
/*      */ import com.wanniu.game.item.po.ItemSpeData;
/*      */ import com.wanniu.game.mail.MailUtil;
/*      */ import com.wanniu.game.mail.data.MailData;
/*      */ import com.wanniu.game.mail.data.MailSysData;
/*      */ import com.wanniu.game.monster.MonsterConfig;
/*      */ import com.wanniu.game.petNew.PetNew;
/*      */ import com.wanniu.game.player.BILogService;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.DaoYouPO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.poes.PlayerTempPO;
/*      */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*      */ import com.wanniu.game.task.TaskEvent;
/*      */ import com.wanniu.game.team.TeamData;
/*      */ import com.wanniu.game.team.TeamService;
/*      */ import com.wanniu.game.team.TeamUtil;
/*      */ import com.wanniu.game.util.RobotUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentSkipListSet;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import pomelo.area.BattleHandler;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.chat.ChatHandler;
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
/*      */ public class Area
/*      */ {
/*      */   public boolean bsClose;
/*      */   protected String serverId;
/*      */   public byte[] npcDatas;
/*      */   public int logicServerId;
/*      */   public int areaId;
/*      */   public String instanceId;
/*      */   
/*      */   public enum ReliveBtn
/*      */   {
/*  107 */     UN_SHOW(0), SHOW_CLICK(1), SHOW_UN_CLICK(2);
/*      */     public int value;
/*      */     
/*      */     ReliveBtn(int value) {
/*  111 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ReliveUP {
/*  116 */     OK(1),
/*  117 */     NO(0);
/*      */     public int value;
/*      */     
/*      */     ReliveUP(int value) {
/*  121 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ReliveOP {
/*  126 */     FIELD(0),
/*  127 */     RELIVE(1),
/*  128 */     LEAVE(2);
/*      */     public int value;
/*      */     
/*      */     ReliveOP(int value) {
/*  132 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum ReliveCB {
/*  137 */     ICON(0), RELIVE(1), LEAVE(2);
/*      */     public int value;
/*      */     
/*      */     ReliveCB(int value) {
/*  141 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum ReliveType
/*      */   {
/*  150 */     CITY(0),
/*      */     
/*  152 */     NOW(1),
/*      */     
/*  154 */     BORN(2),
/*      */     
/*  156 */     PLACE(3),
/*      */     
/*  158 */     SKILL(4),
/*      */     
/*  160 */     RANDOM(5);
/*      */     public final int value;
/*      */     
/*      */     ReliveType(int value) {
/*  164 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Actor
/*      */   {
/*      */     public int rebornNum;
/*      */     
/*      */     public boolean leave;
/*      */     
/*      */     public boolean ready;
/*      */     public boolean alive = true;
/*      */     public long reliveCoolTime;
/*      */     public boolean profitable = true;
/*      */     public Map<String, Integer> historyVirtualItems;
/*      */     public List<NormalItem> historyItems;
/*  181 */     public List<String> buffers = new ArrayList<>();
/*      */     
/*      */     public void relive() {
/*  184 */       this.rebornNum++;
/*  185 */       this.alive = true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class AreaItem
/*      */   {
/*      */     public NormalItem item;
/*      */     public Map<String, WNPlayer> bindPlayers;
/*      */     public long createTime;
/*      */     public int monsterId;
/*      */     public WNPlayer dropPlayer;
/*      */     public float dropX;
/*      */     public float dropY;
/*      */     
/*      */     public AreaItem(NormalItem item) {
/*  201 */       this.item = item;
/*  202 */       this.createTime = System.currentTimeMillis();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isFull() {
/*  207 */     return (this.isClose || this.bsClose || this.actors.size() >= this.fullCount);
/*      */   }
/*      */   
/*      */   public boolean isFull(int addCount) {
/*  211 */     return (this.isClose || this.bsClose || this.actors.size() + addCount > this.fullCount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  217 */   public int lineIndex = 1;
/*      */   
/*      */   public boolean hasPlayerEntered;
/*      */   
/*      */   public Map<String, Actor> actors;
/*      */   
/*      */   public long emptyTime;
/*      */   
/*      */   public MapBase prop;
/*      */   
/*      */   public int sceneType;
/*      */   
/*      */   public int lifeTime;
/*      */   public Map<String, AreaItem> items;
/*      */   public Set<Integer> aliveBoss;
/*      */   public Set<String> diePlayers;
/*      */   public int fullCount;
/*      */   public int maxCount;
/*      */   protected boolean isClose;
/*      */   
/*      */   public boolean isClose() {
/*  238 */     return this.isClose;
/*      */   }
/*      */   
/*      */   public boolean isPlayerClose(WNPlayer player) {
/*  242 */     return this.isClose;
/*      */   }
/*      */   
/*      */   public String getSceneName() {
/*  246 */     return this.prop.name;
/*      */   }
/*      */   
/*  249 */   protected Future<?> timer_SceneEndTime = null;
/*      */   
/*  251 */   public final Map<Integer, RandomBoxExt.Point> tcPoints = new ConcurrentHashMap<>();
/*      */ 
/*      */ 
/*      */   
/*      */   private ScheduledFuture<?> robotDisponseJob;
/*      */ 
/*      */   
/*      */   protected Boolean isDispose;
/*      */ 
/*      */   
/*      */   protected ScheduledFuture<?> closeFuture;
/*      */ 
/*      */   
/*      */   private Map<String, PointItem> pointItems;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNewPoint(RandomBoxExt.Point point) {
/*  269 */     for (RandomBoxExt.Point p : this.tcPoints.values()) {
/*  270 */       if (point.distance(p) < 1.0D)
/*      */       {
/*  272 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  276 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void newRandomBox(RandomBoxExt box) {
/*  283 */     GWorld.getInstance().ansycExec(() -> {
/*      */           RandomBoxExt.Point point = box.randomPoint();
/*      */           int flag = 0;
/*      */           while (flag++ < 50 && !isNewPoint(point)) {
/*      */             point = box.randomPoint();
/*      */           }
/*      */           float direction = (float)(RandomUtil.getFloat() * Math.PI * 2.0D);
/*      */           int objId = getXmdsManager().addUnit(this.instanceId, box.iD, Utils.toJSONString(new Object[] { "force", Integer.valueOf(Const.AreaForce.FORCEA.value), "name", box.name, "x", Float.valueOf(point.x), "y", Float.valueOf(point.y), "direction", Float.valueOf(direction) }));
/*      */           this.tcPoints.put(Integer.valueOf(objId), point);
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void bindBattleServer(WNPlayer player) {
/*  298 */     this.serverId = player.getBattleServerId();
/*  299 */     Out.debug(new Object[] { "bindBattleServer ", this.serverId });
/*      */     
/*  301 */     if (!isNormal()) {
/*  302 */       Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/*  303 */       if (members != null) {
/*  304 */         for (TeamData.TeamMemberData member : members.values()) {
/*  305 */           WNPlayer mPlayer = member.getPlayer();
/*  306 */           if (mPlayer != null) {
/*  307 */             onDailyActivity(mPlayer);
/*      */           }
/*      */         } 
/*      */       } else {
/*  311 */         onDailyActivity(player);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  317 */     List<MonsterRefreshExt> props = GameData.findMonsterRefreshs(t -> (t.mapID == this.areaId));
/*      */ 
/*      */     
/*  320 */     List<Integer> data = new ArrayList<>(props.size());
/*  321 */     if (props.size() > 0) {
/*  322 */       for (MonsterRefreshExt refreshExt : props) {
/*  323 */         Date bornBeginTime = AreaUtil.formatToday(refreshExt.rebornBeginTime);
/*  324 */         Date bornEndTime = AreaUtil.formatToday(refreshExt.rebornEndTime);
/*  325 */         long now = System.currentTimeMillis();
/*  326 */         if (bornBeginTime.getTime() <= now && bornEndTime.getTime() > now) {
/*  327 */           data.add(Integer.valueOf(refreshExt.iD));
/*      */         }
/*      */       } 
/*      */     }
/*  331 */     createMonster(data, true);
/*      */ 
/*      */     
/*  334 */     GameData.RandomBoxs.forEach((k, v) -> {
/*      */           if (v.startScene == this.areaId) {
/*      */             for (int i = 0; i < v.quantity; i++) {
/*      */               newRandomBox(v);
/*      */             }
/*      */           }
/*      */         });
/*      */     
/*  342 */     if (PlayerUtil.isRobot(player.player) && 
/*  343 */       this.robotDisponseJob == null) {
/*  344 */       this.robotDisponseJob = JobFactory.addDelayJob(() -> dispose(), 120000L);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ZoneManagerPrx getZoneManager() {
/*  352 */     return CSharpClient.getZoneManager(this.serverId);
/*      */   }
/*      */   
/*      */   public XmdsManagerPrx getXmdsManager() {
/*  356 */     return CSharpClient.getXmdsManager(this.serverId);
/*      */   }
/*      */   
/*      */   public String getServerId() {
/*  360 */     return this.serverId;
/*      */   }
/*      */   
/*      */   protected void init() {
/*  364 */     this.hasPlayerEntered = false;
/*  365 */     this.actors = new ConcurrentHashMap<>();
/*  366 */     this.emptyTime = GWorld.APP_TIME;
/*  367 */     this.sceneType = this.prop.type;
/*  368 */     this.lifeTime = this.prop.lifeTime * 1000;
/*      */     
/*  370 */     this.items = new ConcurrentHashMap<>();
/*  371 */     this.aliveBoss = new ConcurrentSkipListSet<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSceneType() {
/*  378 */     return this.sceneType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  385 */     return (getPlayerNum() <= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNormal() {
/*  392 */     return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || this.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPKDrop() {
/*  399 */     return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || this.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean needTeamConfirm(int type) {
/*  408 */     return (type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || type == Const.SCENE_TYPE.LOOP.getValue() || type == Const.SCENE_TYPE.DEMON_TOWER.getValue() || type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue() || type == Const.SCENE_TYPE.ILLUSION_2.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isOpenJoinTeamArea() {
/*  417 */     return (isNormal() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean noCloseIfNoPlayer() {
/*  426 */     return (this.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void resetEmptyTime() {
/*  433 */     if (isEmpty()) {
/*  434 */       this.emptyTime = GWorld.APP_TIME;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isValid() {
/*  442 */     return (!isEmpty() || GWorld.APP_TIME - this.emptyTime <= this.lifeTime);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean needSendKillMail() {
/*  449 */     return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canCloseNoPlayer() {
/*  456 */     if (isEmpty()) {
/*  457 */       return true;
/*      */     }
/*  459 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onSceneEndTime() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDisponseLeave(WNPlayer player) {
/*  473 */     Out.info(new Object[] { player.getName(), " leave disponse area ", this.prop.name });
/*  474 */     PlayerTempPO temp = player.getPlayerTempData();
/*  475 */     AreaUtil.dispatchByAreaId(player, new AreaData(temp.historyAreaId, temp.historyX, temp.historyY), (Map<String, Object>)null);
/*      */   }
/*      */   
/*  478 */   public Area(JSONObject opts) { this.isDispose = Boolean.valueOf(false);
/*      */     Out.debug(new Object[] { "create area opts:", opts });
/*      */     this.logicServerId = opts.containsKey("logicServerId") ? opts.getIntValue("logicServerId") : 0;
/*      */     this.areaId = opts.getIntValue("areaId");
/*      */     this.instanceId = opts.getString("instanceId");
/*      */     this.prop = AreaDataConfig.getInstance().get(this.areaId);
/*  484 */     init(); } public void dispose() { dispose(false); }
/*      */ 
/*      */   
/*      */   public void dispose(boolean processExit) {
/*  488 */     synchronized (this.isDispose) {
/*  489 */       if (this.isDispose.booleanValue())
/*      */         return; 
/*  491 */       this.isDispose = Boolean.valueOf(true);
/*      */     } 
/*  493 */     this.isClose = true;
/*      */     
/*      */     try {
/*  496 */       if (this.timer_SceneEndTime != null) {
/*  497 */         this.timer_SceneEndTime.cancel(true);
/*  498 */         this.timer_SceneEndTime = null;
/*      */       } 
/*      */       
/*  501 */       if (!processExit) {
/*  502 */         for (Map.Entry<String, Actor> entry : this.actors.entrySet()) {
/*  503 */           String playerId = entry.getKey();
/*  504 */           WNPlayer player = getPlayer(playerId);
/*  505 */           if (player != null && player.getArea() == this && !player.isProxy()) {
/*  506 */             onDisponseLeave(player);
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  511 */       this.actors.clear();
/*  512 */     } catch (Exception e) {
/*  513 */       Out.error(new Object[] { e });
/*      */     } finally {
/*  515 */       Out.info(new Object[] { "destroyZone areaid:", this.prop.name, " - ", Integer.valueOf(this.areaId), "  instanceId:", this.instanceId });
/*      */       
/*  517 */       getZoneManager().destroyZoneRequest(this.instanceId);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForce(WNPlayer player) {
/*  525 */     player.setForce(Const.AreaForce.FORCEA.value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean autoMelt(WNPlayer player, NormalEquip equip) {
/*  533 */     if (!equip.isEquip() || equip.prop.noMelt == 1) {
/*  534 */       return false;
/*      */     }
/*  536 */     MeltConfigCO prop = ItemUtil.getMeltProp(equip.prop.meltLevel, equip.getQColor());
/*  537 */     if (prop == null) {
/*  538 */       return false;
/*      */     }
/*  540 */     if (player.isProxy())
/*      */     {
/*  542 */       return false;
/*      */     }
/*      */     
/*  545 */     List<Integer> meltColor = player.hookSetManager.getMeltQcolor();
/*  546 */     if (!meltColor.contains(Integer.valueOf(equip.prop.qcolor))) {
/*  547 */       return false;
/*      */     }
/*  549 */     List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(prop.tcCode);
/*  550 */     List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);
/*      */ 
/*      */     
/*  553 */     if (!player.getWnBag().testEmptyGridLarge(ItemUtil.getPackUpItemsNum(addItems))) {
/*  554 */       return false;
/*      */     }
/*      */     
/*  557 */     if (prop.costGold > 0 && !player.moneyManager.costGold(prop.costGold, Const.GOODS_CHANGE_TYPE.melt)) {
/*  558 */       player.sendSysTip(LangService.getValue("GOLD_NOT_ENOUGH"));
/*  559 */       return false;
/*      */     } 
/*      */     
/*  562 */     Map<Integer, Object> currencyList = new HashMap<>();
/*  563 */     currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(prop.costGold));
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
/*  581 */     player.getWnBag().addEntityItems(addItems, Const.GOODS_CHANGE_TYPE.AUTO_MELT, currencyList);
/*      */ 
/*      */     
/*  584 */     BILogService.getInstance().ansycReportMeltCultivate(player.getPlayer(), addItems);
/*      */     
/*  586 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canPickInterActiveItem(WNPlayer player, String itemCode, int itemNum) {
/*  597 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onInterActiveItem(WNPlayer player, int objId, int itemId) {
/*  608 */     RandomBoxExt.Point point = this.tcPoints.remove(Integer.valueOf(objId));
/*  609 */     if (point != null) {
/*  610 */       Out.debug(new Object[] { "interActiveItem : ", point });
/*      */     }
/*  612 */     RandomBoxExt box = (RandomBoxExt)GameData.RandomBoxs.get(Integer.valueOf(itemId));
/*  613 */     if (StringUtil.isNotEmpty(box.tc)) {
/*  614 */       boxNormalTC(player, box.tc, (int)point.x, (int)point.y);
/*      */     }
/*      */     
/*  617 */     if (StringUtil.isNotEmpty(box.teamTc)) {
/*  618 */       boxTeamTC(player, box.teamTc);
/*      */     }
/*  620 */     if (StringUtil.isNotEmpty(box.personTc)) {
/*  621 */       List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(box.personTc);
/*  622 */       if (dropItems != null && !dropItems.isEmpty()) {
/*  623 */         List<NormalItem> trueAdd = new ArrayList<>();
/*  624 */         for (NormalItem item : dropItems) {
/*  625 */           if (canPickInterActiveItem(player, item.itemCode(), item.getNum())) {
/*  626 */             trueAdd.add(item);
/*      */           }
/*      */         } 
/*  629 */         if (!trueAdd.isEmpty()) {
/*  630 */           player.bag.addCodeItemMail(trueAdd, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.random_box, "Bag_full_common");
/*      */         }
/*      */       } 
/*      */     } 
/*  634 */     CharacterLevelCO prop = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(player.getLevel()));
/*  635 */     int playerLevelUpExp = prop.experience;
/*  636 */     int exp = Math.round((playerLevelUpExp * box.expRatio) / 10000.0F);
/*  637 */     if (exp > 0)
/*  638 */       player.addExp(exp, Const.GOODS_CHANGE_TYPE.random_box); 
/*  639 */     int upexp = Math.round(((player.getLevel() - 1) * box.upExpRatio) / 10000.0F);
/*  640 */     if (upexp > 0)
/*  641 */       player.addUpExp(upexp, Const.GOODS_CHANGE_TYPE.random_box); 
/*  642 */     int gold = Math.round(((player.getLevel() - 1) * box.goldPerMonLv) / 10000.0F);
/*  643 */     if (gold > 0) {
/*  644 */       player.moneyManager.addGold(gold, Const.GOODS_CHANGE_TYPE.random_box);
/*      */     }
/*  646 */     if (box.startScene == this.areaId && StringUtil.isNotEmpty(box.startPoint)) {
/*  647 */       JobFactory.addDelayJob(() -> newRandomBox(box), (box.refreshTime * 1000));
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
/*      */   public void onKillBoss(String playerId) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onBattleReport(List<DamageHealVO> datas) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
/*  681 */     AreaItem areaItem = this.items.get(itemId);
/*  682 */     if (areaItem != null && (areaItem.bindPlayers == null || areaItem.bindPlayers.containsKey(playerId) || System.currentTimeMillis() - areaItem.createTime > GlobalConfig.itemdrop_lock_lifeTime)) {
/*  683 */       Actor actor = getActor(playerId);
/*  684 */       if (actor == null || !actor.profitable) {
/*  685 */         Out.debug(new Object[] { playerId, "当前不可拾取", itemId });
/*  686 */         return null;
/*      */       } 
/*  688 */       WNPlayer player = getPlayer(playerId);
/*      */       
/*  690 */       this.items.remove(itemId);
/*  691 */       Out.debug(new Object[] { getClass(), player.getName(), " onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard) });
/*  692 */       int groupCount = areaItem.item.itemDb.groupCount;
/*  693 */       onFreedomPickItem(player, areaItem.item, isGuard);
/*  694 */       areaItem.item.setGroup(groupCount);
/*  695 */       if (areaItem.dropPlayer != null) {
/*  696 */         onPickPlayerDropItem(player, areaItem);
/*      */       } else {
/*  698 */         onPickMonsterDropItem(player, areaItem);
/*      */       } 
/*  700 */       return areaItem;
/*      */     } 
/*  702 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onFreedomPickItem(WNPlayer player, NormalItem item, boolean isGuard) {
/*  709 */     if (player.isProxy()) {
/*  710 */       player.onProxyEvent(13, body -> {
/*      */             body.writeString(Utils.serialize(item.itemDb));
/*      */             body.writeBoolean(isGuard);
/*      */           });
/*      */       return;
/*      */     } 
/*  716 */     Out.debug(new Object[] { "onFreedomPickItem playerId:", player.getName(), "itemId:", item.itemDb.id, " isbind:", Boolean.valueOf(item.isBinding()) });
/*  717 */     boolean canAutoMelt = (isGuard && item.isEquip()) ? autoMelt(player, (NormalEquip)item) : false;
/*  718 */     if (!canAutoMelt) {
/*      */       
/*  720 */       if (!player.getWnBag().testEmptyGridLarge(1)) {
/*      */         return;
/*      */       }
/*      */       
/*  724 */       boolean isSilient = isGuard;
/*  725 */       player.getWnBag().addEntityItem(item, Const.GOODS_CHANGE_TYPE.monsterdrop, null, false, isSilient);
/*  726 */       FinishPickItem data = item.toJSON4PickItemBatterServer();
/*      */       
/*  728 */       if (isGuard) {
/*  729 */         player.getWnBag().testEmptyGridLarge(1);
/*      */       }
/*  731 */       Out.debug(new Object[] { getClass(), "onFinishPickItem:", data });
/*  732 */       getXmdsManager().onFinishPickItem(player.getId(), JSON.toJSONString(data));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onPickPlayerDropItem(WNPlayer player, AreaItem itemInfo) {
/*  741 */     WNPlayer dropPlayer = itemInfo.dropPlayer;
/*  742 */     if (dropPlayer != null && itemInfo.item.prop.qcolor >= Const.ItemQuality.PURPLE.getValue()) {
/*  743 */       NormalItem item = itemInfo.item;
/*  744 */       float dropX = itemInfo.dropX;
/*  745 */       float dropY = itemInfo.dropY;
/*  746 */       Out.debug(new Object[] { getClass(), "玩家 ", player.getName(), "拾起了物品", item.itemDb.id });
/*  747 */       Map<String, Object> datatmp = new HashMap<>(6);
/*  748 */       Map<String, Object> data = new HashMap<>(6);
/*      */       
/*  750 */       datatmp.put("MsgType", Integer.valueOf(3));
/*  751 */       datatmp.put("s2c_playerId", player.getId());
/*  752 */       datatmp.put("s2c_name", player.getName());
/*  753 */       datatmp.put("s2c_level", Integer.valueOf(player.getLevel()));
/*  754 */       datatmp.put("s2c_pro", Integer.valueOf(player.getPro()));
/*      */       
/*  756 */       String str1 = LangService.getValue("GREEN_LINK") + "在";
/*  757 */       str1 = str1.replace("{b}", JSON.toJSONString(datatmp));
/*  758 */       str1 = str1.replace("{a}", player.getName());
/*  759 */       datatmp.clear();
/*  760 */       datatmp.put("MsgType", Integer.valueOf(6));
/*  761 */       data.put("areaId", Integer.valueOf(this.areaId));
/*  762 */       data.put("targetX", Float.valueOf(dropX));
/*  763 */       data.put("targetY", Float.valueOf(dropY));
/*  764 */       datatmp.put("data", data);
/*      */       
/*  766 */       String str2 = LangService.getValue("GREEN_LINK") + "拾起了";
/*  767 */       str2 = str2.replace("{b}", JSON.toJSONString(datatmp));
/*  768 */       str2 = str2.replace("{a}", this.prop.name + "(" + dropX + "," + dropY + ")");
/*      */       
/*  770 */       datatmp.clear();
/*  771 */       datatmp.put("MsgType", Integer.valueOf(3));
/*  772 */       datatmp.put("s2c_playerId", dropPlayer.getId());
/*  773 */       datatmp.put("s2c_name", dropPlayer.getName());
/*  774 */       datatmp.put("s2c_level", Integer.valueOf(dropPlayer.getLevel()));
/*  775 */       datatmp.put("s2c_pro", Integer.valueOf(dropPlayer.getPro()));
/*      */       
/*  777 */       String str3 = LangService.getValue("GREEN_LINK") + "的";
/*  778 */       str3 = str3.replace("{b}", JSON.toJSONString(datatmp));
/*  779 */       str3 = str3.replace("{a}", dropPlayer.getName());
/*      */       
/*  781 */       datatmp.clear();
/*  782 */       datatmp.put("MsgType", Integer.valueOf(1));
/*  783 */       datatmp.put("Id", item.itemDb.id);
/*  784 */       datatmp.put("PlayerId", dropPlayer.getId());
/*  785 */       datatmp.put("Name", item.prop.name);
/*  786 */       datatmp.put("Quality", Integer.valueOf(item.itemDb.groupCount));
/*  787 */       datatmp.put("TemplateId", item.itemDb.code);
/*      */       
/*  789 */       String str4 = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
/*  790 */       str4 = str4.replace("{b}", JSON.toJSONString(datatmp));
/*  791 */       str4 = str4.replace("{a}", item.prop.name + "×" + item.itemDb.groupCount);
/*      */       
/*  793 */       String content = str1 + str2 + str3 + str4;
/*  794 */       ChatHandler.OnChatPush.Builder msg = MessageUtil.createChatMsg(player, content, Const.CHAT_SCOPE.SYSTEM, (item.prop.qcolor >= Const.ItemQuality.ORANGE.getValue()) ? Const.TipsType.BLACK : Const.TipsType.NORMAL);
/*  795 */       GWorld.getInstance().broadcast((Message)new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage)msg.build()), this.logicServerId);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onPickMonsterDropItem(WNPlayer player, AreaItem itemInfo) {
/*  803 */     int pickItemQcolor = GlobalConfig.World_Boss_Pick_ItemQcolor;
/*  804 */     if (itemInfo.monsterId != 0 && itemInfo.item.prop.qcolor >= pickItemQcolor) {
/*  805 */       MonsterBase monsterProp = MonsterConfig.getInstance().get(itemInfo.monsterId);
/*  806 */       if (monsterProp != null) {
/*  807 */         NormalItem item = itemInfo.item;
/*  808 */         int index = Utils.random(1, 3);
/*  809 */         String content = LangService.getValue("MONSTER_BOSS_PICK_ITEM_MESSAGE" + index);
/*  810 */         content = content.replace("{mapName}", getSceneName());
/*  811 */         String strData = MessageUtil.getPlayerNameColor(player.getName(), player.getPro());
/*  812 */         content = content.replace("{playerName}", strData);
/*  813 */         String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
/*  814 */         content = content.replace("{monsterName}", monsterName);
/*  815 */         Map<String, Object> datatmp = new HashMap<>();
/*  816 */         datatmp.put("MsgType", Integer.valueOf(1));
/*  817 */         datatmp.put("Id", item.itemDb.id);
/*  818 */         datatmp.put("Name", item.prop.name);
/*  819 */         datatmp.put("Quality", Integer.valueOf(item.itemDb.groupCount));
/*  820 */         datatmp.put("TemplateId", item.itemDb.code);
/*  821 */         String strItem = LangService.getValue(MessageUtil.getColorLink(item.getQLevel()));
/*  822 */         strItem = strItem.replace("{b}", JSON.toJSONString(datatmp));
/*  823 */         strItem = strItem.replace("{a}", item.prop.name + "×" + item.itemDb.groupCount);
/*      */         
/*  825 */         content = content.replace("{item}", strItem);
/*      */         
/*  827 */         String finalcontent = content;
/*  828 */         GWorld.getInstance().ansycExec(() -> {
/*      */               if (item.prop.qcolor >= Const.ItemQuality.GREEN.getValue()) {
/*      */                 for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*      */                   ((WNPlayer)p).sendSysTip(finalcontent, Const.TipsType.ROLL);
/*      */                 }
/*      */                 MessageUtil.sendRollChat(GWorld.__SERVER_ID, finalcontent, Const.CHAT_SCOPE.SYSTEM);
/*      */               } 
/*      */             });
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onGameOver(JSONObject event) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addUnitsToArea(List<MonsterUnit> data) {
/*  853 */     if (data.size() > 0) {
/*  854 */       GWorld.getInstance().ansycExec(() -> getXmdsManager().addUnits(this.instanceId, JSON.toJSONString(data)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void createMonster(List<Integer> data, boolean bInit) {
/*  864 */     if (data.size() == 0) {
/*      */       return;
/*      */     }
/*  867 */     List<MonsterUnit> monsterData = new ArrayList<>();
/*  868 */     synchronized (this.aliveBoss) {
/*  869 */       for (Iterator<Integer> iterator = data.iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/*  870 */         GameData.MonsterRefreshs.values().forEach(co -> {
/*      */               if (co.iD == id && co.mapID == this.areaId) {
/*      */                 MonsterUnit md = new MonsterUnit();
/*      */                 
/*      */                 md.id = co.monsterID;
/*      */                 
/*      */                 md.force = Const.AreaForce.MONSTER.value;
/*      */                 
/*      */                 md.flag = co.getRefreshPoint();
/*      */                 md.autoGuard = true;
/*      */                 md.unique = true;
/*      */                 monsterData.add(md);
/*      */                 if (!this.aliveBoss.contains(Integer.valueOf(id))) {
/*      */                   this.aliveBoss.add(Integer.valueOf(id));
/*      */                 }
/*      */                 Out.info(new Object[] { "addUnitsToArea:", this.prop.name, ",", Integer.valueOf(this.areaId), ",", Integer.valueOf(co.monsterID), ",", co.getRefreshPoint() });
/*      */               } 
/*      */             }); }
/*      */     
/*      */     } 
/*  890 */     if (monsterData.size() > 0) {
/*  891 */       addUnitsToArea(monsterData);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void isSpecialItem(WNPlayer player, NormalItem item) {
/*  897 */     if (item.prop.qcolor >= Const.ItemQuality.ORANGE.getValue()) {
/*  898 */       String link = ChannelUtil.setItemInfo(item);
/*  899 */       String key = MessageUtil.getColorLink(item.prop.qcolor);
/*  900 */       String str = LangService.getValue(key);
/*  901 */       str = str.replace("{b}", link);
/*  902 */       str = str.replace("{a}", item.prop.name);
/*      */       
/*  904 */       String playerName = MessageUtil.getPlayerNameColor(player.getName(), player.player.pro);
/*  905 */       String final_str = playerName + "获得" + str;
/*      */       
/*  907 */       DaoYouPO daoYou = DaoYouService.getInstance().getDaoYou(player.getId());
/*  908 */       if (daoYou != null) {
/*  909 */         DaoYouService.getInstance().addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), "", daoYou, final_str, new Object[0]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUseTC() {
/*  918 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAliveBoss(Integer monsterId, String refreshPoint) {
/*  925 */     List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t -> 
/*  926 */         (t.monsterID == monsterId.intValue() && t.mapID == this.areaId && t.containsRefreshPoint(refreshPoint)));
/*      */ 
/*      */     
/*  929 */     if (!refreshProps.isEmpty()) {
/*  930 */       MonsterRefreshCO refresh = (MonsterRefreshCO)refreshProps.get(0);
/*  931 */       if (this.aliveBoss.remove(Integer.valueOf(refresh.iD))) {
/*  932 */         Out.debug(new Object[] { "成功移除还活着的BOSS, monsterId=", monsterId });
/*      */       }
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
/*      */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
/*  946 */     Out.debug(new Object[] { player.getName(), " kill ", Integer.valueOf(monsterId) });
/*  947 */     MonsterBase monsterProp = MonsterConfig.getInstance().get(monsterId);
/*  948 */     if (monsterProp == null) {
/*  949 */       Out.warn(new Object[] { "onMonsterDead can not get prop from monsterProps:", Integer.valueOf(monsterId) });
/*      */       
/*      */       return;
/*      */     } 
/*  953 */     CharacterLevelCO charactorProp = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(player.getLevel()));
/*  954 */     int playerLevelUpExp = charactorProp.experience;
/*      */     
/*  956 */     List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t -> 
/*  957 */         (t.monsterID == monsterId && t.mapID == this.areaId && t.containsRefreshPoint(refreshPoint)));
/*      */ 
/*      */     
/*  960 */     List<NormalItem> list_announce_item = new ArrayList<>();
/*      */ 
/*      */     
/*  963 */     Map<String, WNPlayer> sharedDropPlayers = new HashMap<>(5);
/*  964 */     Map<String, WNPlayer> sharedExpPlayers = new HashMap<>(5);
/*  965 */     boolean canFightLevelDrop = player.fightLevelManager.canDrop(monsterId, this);
/*  966 */     boolean canNormapDrop = player.dropManager.canDrop(monsterId, this);
/*  967 */     if (canFightLevelDrop && canNormapDrop) {
/*  968 */       sharedDropPlayers.put(player.getId(), player);
/*  969 */       sharedExpPlayers.put(player.getId(), player);
/*  970 */     } else if (canFightLevelDrop) {
/*  971 */       sharedExpPlayers.put(player.getId(), player);
/*      */     } 
/*      */     
/*  974 */     int teamExpAdd = 0;
/*  975 */     if (teamSharedIdList != null) {
/*  976 */       teamExpAdd = TeamUtil.getTeamExpAdd(teamSharedIdList.size());
/*  977 */       teamSharedIdList.forEach(teamSharedId -> {
/*      */             Actor actor = getActor((String)teamSharedId);
/*      */             if (actor != null && actor.profitable) {
/*      */               WNPlayer bindPlayer = getPlayer((String)teamSharedId);
/*      */               if (bindPlayer != null) {
/*      */                 boolean canFightLevelDropOther = bindPlayer.fightLevelManager.canDrop(monsterId, this);
/*      */                 boolean canNormapDropOther = bindPlayer.dropManager.canDrop(monsterId, this);
/*      */                 if (canFightLevelDropOther && canNormapDropOther) {
/*      */                   sharedDropPlayers.put(bindPlayer.getId(), bindPlayer);
/*      */                   sharedExpPlayers.put(bindPlayer.getId(), bindPlayer);
/*      */                 } else if (canFightLevelDropOther) {
/*      */                   sharedExpPlayers.put(bindPlayer.getId(), bindPlayer);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           });
/*      */     } 
/*  994 */     if (sharedExpPlayers.size() > 0) {
/*  995 */       addExp(player, sharedExpPlayers.values(), attackType, monsterProp, level, teamExpAdd);
/*      */     }
/*      */     
/*  998 */     if (!isUseTC()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1003 */     Map<String, WNPlayer> bindPlayers = new HashMap<>(5);
/* 1004 */     if (player.fightLevelManager.canDrop(monsterId, this) && player.dropManager.canDrop(monsterId, this)) {
/* 1005 */       bindPlayers.put(player.getId(), player);
/*      */     }
/*      */     
/* 1008 */     if (monsterProp.type >= 4 && isNormal()) {
/* 1009 */       BILogService.getInstance().ansycReportKillBoss(player.getPlayer(), this.sceneType, monsterId);
/* 1010 */       player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.AREA_BOSS_KILL_COUNT, new Object[0]);
/*      */     } 
/*      */     
/* 1013 */     Collection<String> teamMembers = player.getTeamMembers();
/* 1014 */     if (teamMembers != null) {
/* 1015 */       teamExpAdd = TeamUtil.getTeamExpAdd(teamMembers.size());
/* 1016 */       for (String playerId : teamMembers) {
/* 1017 */         Actor actor = getActor(playerId);
/*      */         
/* 1019 */         if (actor == null || !actor.profitable)
/*      */           continue; 
/* 1021 */         WNPlayer bindPlayer = getPlayer(playerId);
/* 1022 */         if (bindPlayer != null && bindPlayer != player && bindPlayer.fightLevelManager.canDrop(monsterId, this) && bindPlayer.dropManager.canDrop(monsterId, this)) {
/* 1023 */           bindPlayers.put(bindPlayer.getId(), bindPlayer);
/*      */           
/* 1025 */           if (monsterProp.type >= 4 && isNormal()) {
/* 1026 */             BILogService.getInstance().ansycReportKillBoss(bindPlayer.getPlayer(), this.sceneType, monsterId);
/* 1027 */             bindPlayer.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.AREA_BOSS_KILL_COUNT, new Object[0]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1034 */     if (atkAssistantList != null) {
/* 1035 */       for (Object o : atkAssistantList) {
/* 1036 */         String playerId = (String)o;
/* 1037 */         if ((teamMembers != null && teamMembers.contains(playerId)) || playerId.equals(player.player.id)) {
/*      */           continue;
/*      */         }
/* 1040 */         WNPlayer bindPlayer = getPlayer(playerId);
/* 1041 */         if (bindPlayer == null || bindPlayer.area == null) {
/*      */           continue;
/*      */         }
/* 1044 */         if (bindPlayer.area.areaId == this.areaId) {
/* 1045 */           bindPlayer.dropManager.sendJoinReward(monsterId, monsterProp.name, refreshProps);
/*      */           
/* 1047 */           if (monsterProp.type >= 4 && isNormal()) {
/* 1048 */             BILogService.getInstance().ansycReportKillBoss(bindPlayer.getPlayer(), this.sceneType, monsterId);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1054 */     if (bindPlayers.size() == 0 && sharedDropPlayers.size() == 0) {
/*      */       return;
/*      */     }
/*      */     
/* 1058 */     List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
/*      */ 
/*      */     
/* 1061 */     Map<Integer, String> tcMap = monsterProp.firstTcMap;
/* 1062 */     String tcCode = tcMap.get(Integer.valueOf(player.getPro()));
/* 1063 */     if (StringUtil.isNotEmpty(tcCode)) {
/* 1064 */       List<Integer> firstKillMonsterIds = player.playerAttachPO.firstKillMonsterIds;
/* 1065 */       if (firstKillMonsterIds.contains(Integer.valueOf(monsterId))) {
/* 1066 */         tcCode = monsterProp.tc;
/*      */       } else {
/* 1068 */         player.playerAttachPO.addFirstMonsterId(monsterId);
/*      */       } 
/*      */     } else {
/* 1071 */       tcCode = monsterProp.tc;
/*      */     } 
/*      */     
/* 1074 */     boolean over = false;
/* 1075 */     boolean isTeamTc = false;
/*      */     while (true) {
/* 1077 */       if (StringUtil.isNotEmpty(tcCode)) {
/* 1078 */         List<NormalItem> dropItems = ItemUtil.createItemsByRealTC(tcCode, player.getLevel());
/* 1079 */         if (refreshProps.size() > 0) {
/* 1080 */           list_announce_item.addAll(dropItems);
/*      */         }
/* 1082 */         if (this.pointItems == null) {
/* 1083 */           this.pointItems = new HashMap<>();
/*      */         }
/* 1085 */         for (NormalItem dropItem : dropItems) {
/* 1086 */           if (dropItem.isVirtQuest()) {
/* 1087 */             for (WNPlayer belongPlayer : bindPlayers.values()) {
/* 1088 */               Actor actor = getActor(belongPlayer.getId());
/* 1089 */               if (actor == null || !actor.profitable) {
/*      */                 continue;
/*      */               }
/* 1092 */               belongPlayer.onEvent(new TaskEvent(Const.EventType.collect, new Object[] { dropItem.itemDb.code, Integer.valueOf(dropItem.itemDb.groupCount) }));
/*      */             }  continue;
/* 1094 */           }  if (dropItem.isVirtual()) {
/* 1095 */             VirtualItem virItem = (VirtualItem)dropItem;
/* 1096 */             if ("gold".equals(dropItem.itemDb.code)) {
/* 1097 */               virItem.dropResetWorth(level, monsterProp.goldPerMonLv, bindPlayers.size());
/* 1098 */             } else if ("exp".equals(dropItem.itemDb.code)) {
/* 1099 */               virItem.dropResetWorth(level, monsterProp.expRatio, playerLevelUpExp);
/*      */             } 
/* 1101 */             int originWorth = virItem.getWorth();
/* 1102 */             for (WNPlayer belongPlayer : bindPlayers.values()) {
/* 1103 */               Actor actor = getActor(belongPlayer.getId());
/* 1104 */               if (actor == null || !actor.profitable) {
/*      */                 continue;
/*      */               }
/* 1107 */               if ("gold".equals(dropItem.itemDb.code)) {
/* 1108 */                 int extGold = belongPlayer.getBtlExdGold();
/* 1109 */                 extGold += belongPlayer.getGuildExdGold();
/* 1110 */                 virItem.addWorth(originWorth * extGold / 10000);
/* 1111 */                 virItem.addWorth((int)(virItem.getWorth() * belongPlayer.vipManager.getExtGoldRatio()));
/* 1112 */               } else if ("exp".equals(dropItem.itemDb.code)) {
/*      */                 
/* 1114 */                 int exdExp = belongPlayer.bufferManager.getBuffAttrValue("ExdExp");
/*      */                 
/* 1116 */                 exdExp += belongPlayer.getGuildExdExp();
/*      */                 
/* 1118 */                 virItem.addWorth(originWorth * exdExp / 10000);
/*      */               } 
/*      */               
/* 1121 */               if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
/* 1122 */                 virItem.setWorth(belongPlayer.illusionManager.addAward(dropItem.itemDb.code, virItem.getWorth()));
/*      */               }
/* 1124 */               addVirtureItem(belongPlayer, dropItem, Const.GOODS_CHANGE_TYPE.monsterdrop);
/* 1125 */               virItem.setWorth(originWorth);
/*      */             }  continue;
/*      */           } 
/* 1128 */           Set<String> team = player.getTeamMembers();
/* 1129 */           if (isTeamTc && team != null && getCurAreaMember(player) > 1 && dropItem.getQLevel() >= GlobalConfig.Dis_Roll_quality) {
/*      */             
/* 1131 */             PointItem pointItem = new PointItem(dropItem.itemCode(), dropItem.getNum(), getSceneType());
/* 1132 */             pointItem.bindTeam(player);
/* 1133 */             this.pointItems.put(pointItem.id, pointItem);
/* 1134 */             Out.debug(new Object[] { "======================pointItem add ", pointItem.id, " :", pointItem.itemCode }); continue;
/*      */           } 
/* 1136 */           AreaItem areaItem = new AreaItem(dropItem);
/* 1137 */           areaItem.bindPlayers = bindPlayers;
/* 1138 */           areaItem.monsterId = monsterId;
/*      */ 
/*      */           
/* 1141 */           this.items.put(dropItem.itemDb.id, areaItem);
/* 1142 */           itemsPayLoad.add(dropItem.toJSON4BatterServer(bindPlayers.keySet(), Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, false));
/*      */         } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1178 */         sendThrowPointItemListPush(player, monsterId);
/*      */       } 
/* 1180 */       if (over)
/*      */         break; 
/* 1182 */       tcCode = monsterProp.teamTc;
/* 1183 */       isTeamTc = true;
/* 1184 */       over = true;
/*      */     } 
/*      */     
/* 1187 */     tcCode = (String)monsterProp.personTcMap.get(Integer.valueOf(player.getPro()));
/* 1188 */     if (StringUtil.isNotEmpty(tcCode)) {
/* 1189 */       Set<String> team = player.getTeamMembers();
/* 1190 */       for (Map.Entry<String, Actor> entry : this.actors.entrySet()) {
/* 1191 */         if (!((Actor)entry.getValue()).profitable) {
/*      */           continue;
/*      */         }
/* 1194 */         WNPlayer member = getPlayer(entry.getKey());
/* 1195 */         if (((team == null || member == null || !team.contains(member.getId())) && member != player) || 
/* 1196 */           !member.fightLevelManager.canDrop(monsterId, this) || !member.dropManager.canDrop(monsterId, this)) {
/*      */           continue;
/*      */         }
/* 1199 */         List<NormalItem> dropItems = ItemUtil.createItemsByRealTC(tcCode, player.getLevel());
/* 1200 */         if (refreshProps.size() > 0) {
/* 1201 */           list_announce_item.addAll(dropItems);
/*      */         }
/* 1203 */         BattleHandler.ItemDropPush.Builder push = BattleHandler.ItemDropPush.newBuilder();
/* 1204 */         for (NormalItem dropItem : dropItems) {
/* 1205 */           if (dropItem.isVirtQuest()) {
/* 1206 */             member.onEvent(new TaskEvent(Const.EventType.collect, new Object[] { dropItem.itemDb.code, Integer.valueOf(dropItem.itemDb.groupCount) })); continue;
/* 1207 */           }  if (dropItem.isVirtual()) {
/* 1208 */             VirtualItem virItem = (VirtualItem)dropItem;
/* 1209 */             if ("gold".equals(dropItem.itemDb.code)) {
/* 1210 */               virItem.dropResetWorth(level, monsterProp.goldPerMonLv, bindPlayers.size());
/* 1211 */               int extGold = member.getBtlExdGold();
/* 1212 */               extGold += member.getGuildExdGold();
/* 1213 */               virItem.addWorth((int)Math.floor((dropItem.getWorth() * extGold / 10000)));
/* 1214 */               virItem.addWorth((int)(virItem.getWorth() * member.vipManager.getExtGoldRatio()));
/* 1215 */             } else if ("exp".equals(dropItem.itemDb.code)) {
/* 1216 */               virItem.dropResetWorth(level, monsterProp.expRatio, playerLevelUpExp);
/* 1217 */               int exdExp = member.bufferManager.getBuffAttrValue("ExdExp");
/* 1218 */               exdExp += member.getGuildExdExp();
/* 1219 */               virItem.addWorth((int)Math.floor((dropItem.getWorth() * exdExp / 10000)));
/*      */             } 
/*      */             
/* 1222 */             if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
/* 1223 */               virItem.setWorth(member.illusionManager.addAward(dropItem.itemDb.code, virItem.getWorth()));
/*      */             }
/* 1225 */             addVirtureItem(member, dropItem, Const.GOODS_CHANGE_TYPE.monsterdrop); continue;
/*      */           } 
/* 1227 */           BattleHandler.ItemDrop.Builder item = dropItem.toProto4Client();
/* 1228 */           item.setLifeTime(1000);
/* 1229 */           push.addItems(item);
/* 1230 */           boolean canAutoMelt = dropItem.isEquip() ? autoMelt(member, (NormalEquip)dropItem) : false;
/* 1231 */           if (!canAutoMelt) {
/* 1232 */             if (!member.bag.testAddCodeItem(dropItem.itemCode(), dropItem.getNum())) {
/* 1233 */               if (member.playerTempData.sendMailItemNum < 50) {
/* 1234 */                 member.playerTempData.sendMailItemNum++;
/* 1235 */                 boolean bool = member.illusionManager.addItemNum(this, dropItem.itemCode(), dropItem.getNum());
/* 1236 */                 if (bool) {
/* 1237 */                   member.bag.addEntityItemMail(dropItem, Const.GOODS_CHANGE_TYPE.fight_level, "Bag_full_common");
/*      */                 }
/*      */               } 
/*      */               
/*      */               continue;
/*      */             } 
/* 1243 */             boolean canDrop = member.illusionManager.addItemNum(this, dropItem.itemCode(), dropItem.getNum());
/* 1244 */             if (canDrop) {
/* 1245 */               member.bag.addEntityItemMail(dropItem, Const.GOODS_CHANGE_TYPE.fight_level, "Bag_full_common");
/*      */             }
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1253 */         if (push.getItemsCount() > 0) {
/* 1254 */           push.setX(Math.round(x * 100.0F));
/* 1255 */           push.setY(Math.round(y * 100.0F));
/* 1256 */           member.receive("area.battlePush.itemDropPush", (GeneratedMessage)push.build());
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1263 */     for (WNPlayer p : sharedDropPlayers.values()) {
/* 1264 */       p.fightLevelManager.onBossDead(monsterId, this);
/*      */     }
/* 1266 */     if (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue()) {
/* 1267 */       for (WNPlayer p : sharedDropPlayers.values()) {
/* 1268 */         p.dropManager.onBossDead(monsterId);
/*      */       }
/*      */     }
/*      */     
/* 1272 */     if (refreshProps.size() > 0) {
/* 1273 */       MonsterRefreshCO refresh = (MonsterRefreshCO)refreshProps.get(0);
/*      */       
/* 1275 */       for (String playerId : this.actors.keySet()) {
/* 1276 */         WNPlayer _player = getPlayer(playerId);
/*      */         
/* 1278 */         if (_player != null && refresh.useType == 1) {
/*      */           
/* 1280 */           _player.dailyActivityMgr.onEvent(Const.DailyType.ILLSION_BOSS, "0", 1);
/*      */           
/* 1282 */           _player.achievementManager.onKillBoss(1);
/*      */         } 
/*      */       } 
/* 1285 */       List<NormalItem> list_announce_temp = new ArrayList<>();
/* 1286 */       for (NormalItem item : list_announce_item) {
/* 1287 */         if (item.isVirtQuest()) {
/*      */           continue;
/*      */         }
/* 1290 */         if (item.getQLevel() < Const.ItemQuality.PURPLE.getValue()) {
/*      */           continue;
/*      */         }
/* 1293 */         list_announce_temp.add(item);
/*      */       } 
/* 1295 */       if (refresh.msgSend > 0 && list_announce_temp.size() > 0) {
/* 1296 */         String msg = null;
/* 1297 */         StringBuffer str_item = new StringBuffer();
/* 1298 */         int count = 0;
/* 1299 */         for (NormalItem item : list_announce_temp) {
/* 1300 */           count++;
/* 1301 */           str_item.append(ChannelUtil.getChatLinkItem(item));
/* 1302 */           str_item.append("*" + item.getNum());
/* 1303 */           if (count < list_announce_temp.size()) {
/* 1304 */             str_item.append("、 ");
/*      */           }
/*      */         } 
/* 1307 */         if (bindPlayers.size() > 1) {
/* 1308 */           msg = LangService.getValue("MONSTER_BOSS_KILLED_TEAM");
/* 1309 */           StringBuffer playerName = new StringBuffer();
/* 1310 */           count = 0;
/* 1311 */           for (WNPlayer p : bindPlayers.values()) {
/* 1312 */             count++;
/* 1313 */             if (p == null)
/*      */               continue; 
/* 1315 */             playerName.append(MessageUtil.getPlayerNameColor(p.getName(), p.getPro()));
/* 1316 */             if (count < bindPlayers.size()) {
/* 1317 */               playerName.append("、 ");
/*      */             }
/*      */           } 
/* 1320 */           msg = msg.replace("{0}", playerName.toString());
/* 1321 */           MapBase areaProp = AreaUtil.getAreaProp(this.areaId);
/* 1322 */           msg = msg.replace("{1}", areaProp.name);
/* 1323 */           String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
/* 1324 */           msg = msg.replace("{2}", monsterName);
/* 1325 */           msg = msg.replace("{3}", str_item.toString());
/*      */         } else {
/* 1327 */           msg = LangService.getValue("MONSTER_BOSS_KILLED_ONE");
/* 1328 */           String strData = MessageUtil.getPlayerNameColor(player.getName(), player.getPro());
/* 1329 */           msg = msg.replace("{0}", strData);
/* 1330 */           MapBase areaProp = AreaUtil.getAreaProp(this.areaId);
/* 1331 */           msg = msg.replace("{1}", areaProp.name);
/* 1332 */           String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
/* 1333 */           msg = msg.replace("{2}", monsterName);
/* 1334 */           msg = msg.replace("{3}", str_item.toString());
/*      */         } 
/*      */         
/* 1337 */         ChatHandler.OnChatPush.Builder chat = MessageUtil.createChatMsg(player, msg, Const.CHAT_SCOPE.SYSTEM, Const.TipsType.NORMAL);
/* 1338 */         GWorld.getInstance().broadcast((Message)new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage)chat.build()), this.logicServerId);
/*      */       } 
/*      */     } 
/*      */     
/* 1342 */     if (itemsPayLoad.size() > 0) {
/*      */       
/* 1344 */       String data = Utils.toJSON(new Object[] { "pos", Utils.ofMap(new Object[] { "x", Float.valueOf(x), "y", Float.valueOf(y) }), "items", itemsPayLoad }).toJSONString();
/* 1345 */       Out.debug(new Object[] { "onMonsterDead drops :", data });
/* 1346 */       getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void benifitTreasure(String playerId, int monsterId) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean benifitable(String playerId, int monsterId) {
/* 1361 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void boxTeamTC(WNPlayer player, String tc) {
/* 1368 */     if (this.pointItems == null) {
/* 1369 */       this.pointItems = new HashMap<>();
/*      */     }
/* 1371 */     List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(tc);
/* 1372 */     for (NormalItem dropItem : dropItems) {
/* 1373 */       if (getCurAreaMember(player) > 1 && dropItem.getQLevel() >= GlobalConfig.Dis_Roll_quality) {
/* 1374 */         PointItem pointItem = new PointItem(dropItem.itemCode(), dropItem.getNum(), getSceneType());
/* 1375 */         pointItem.bindTeam(player);
/* 1376 */         this.pointItems.put(pointItem.id, pointItem); continue;
/*      */       } 
/* 1378 */       player.bag.addCodeItemMail(dropItem.itemCode(), dropItem.getNum(), null, Const.GOODS_CHANGE_TYPE.random_box, "Bag_full_common");
/*      */     } 
/*      */ 
/*      */     
/* 1382 */     sendThrowPointItemListPush(player, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void boxNormalTC(WNPlayer player, String tc, int x, int y) {
/* 1389 */     List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
/*      */     
/* 1391 */     Map<String, WNPlayer> bindPlayers = new HashMap<>(5);
/*      */     
/* 1393 */     for (String playerId : this.actors.keySet()) {
/* 1394 */       WNPlayer actor = getPlayer(playerId);
/* 1395 */       if (actor != null) {
/* 1396 */         bindPlayers.put(playerId, actor);
/*      */       }
/*      */     } 
/*      */     
/* 1400 */     List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(tc);
/* 1401 */     for (NormalItem dropItem : dropItems) {
/* 1402 */       AreaItem areaItem = new AreaItem(dropItem);
/* 1403 */       areaItem.bindPlayers = bindPlayers;
/* 1404 */       areaItem.monsterId = 0;
/* 1405 */       this.items.put(dropItem.itemDb.id, areaItem);
/* 1406 */       itemsPayLoad.add(dropItem.toJSON4BatterServer(bindPlayers.keySet(), Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, false));
/*      */     } 
/* 1408 */     if (itemsPayLoad.size() > 0) {
/*      */       
/* 1410 */       String data = Utils.toJSON(new Object[] { "pos", Utils.ofMap(new Object[] { "x", Integer.valueOf(x), "y", Integer.valueOf(y) }), "items", itemsPayLoad }).toJSONString();
/* 1411 */       Out.debug(new Object[] { "onMonsterDead drops :", data });
/* 1412 */       getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getCurAreaMember(WNPlayer player) {
/* 1420 */     if (player == null)
/* 1421 */       return 0; 
/* 1422 */     Set<String> team = player.getTeamMembers();
/* 1423 */     if (team == null)
/* 1424 */       return 0; 
/* 1425 */     int currentMember = 0;
/* 1426 */     for (String playerId : team) {
/* 1427 */       WNPlayer mPlayer = getPlayer(playerId);
/* 1428 */       if (mPlayer != null && mPlayer.getArea() == this) {
/* 1429 */         currentMember++;
/*      */       }
/*      */     } 
/* 1432 */     return currentMember;
/*      */   }
/*      */   
/*      */   protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) {
/* 1436 */     player.getWnBag().addEntityItem(dropItem, type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String reliveData(ReliveType type) {
/* 1443 */     return Utils.toJSONString(new Object[] { "type", Integer.valueOf(type.value), "qty", Integer.valueOf(0), "itemType", "diamond", "hp", Integer.valueOf(0), "mp", Integer.valueOf(0) });
/*      */   }
/*      */   
/*      */   public void recordDie(String playerId) {
/* 1447 */     if (isNormal())
/*      */       return; 
/* 1449 */     if (this.diePlayers == null) {
/* 1450 */       this.diePlayers = new ConcurrentSkipListSet<>();
/*      */     }
/* 1452 */     this.diePlayers.add(playerId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PlayerHandler.ReliveResponse.Builder relive(String playerId, ReliveType reliveType) {
/* 1459 */     PlayerHandler.ReliveResponse.Builder res = PlayerHandler.ReliveResponse.newBuilder();
/* 1460 */     Actor actor = getActor(playerId);
/* 1461 */     WNPlayer player = getPlayer(playerId);
/* 1462 */     if (actor == null || player == null) {
/*      */       
/* 1464 */       res.setS2CCode(500);
/* 1465 */       res.setS2CMsg(LangService.getValue("REVIVE_NOT_FIND_PLAYER"));
/* 1466 */       return res;
/*      */     } 
/*      */     
/* 1469 */     if (this.prop.revivedMapID != 0) {
/* 1470 */       AreaUtil.dispatchByAreaId(player, new AreaData(this.prop.revivedMapID, 0.0F, 0.0F), (Map<String, Object>)null);
/*      */     }
/* 1472 */     else if (reliveType == ReliveType.CITY) {
/* 1473 */       player.fightLevelManager.leaveDungeon(player, this);
/* 1474 */       if (isEmpty()) {
/* 1475 */         addCloseFuture();
/*      */       }
/*      */     } else {
/* 1478 */       Out.debug(new Object[] { "复活：", reliveType });
/*      */       
/* 1480 */       getXmdsManager().revivePlayer(playerId, reliveData(reliveType));
/*      */     } 
/*      */     
/* 1483 */     actor.relive();
/* 1484 */     if (this.diePlayers != null && this.diePlayers.contains(playerId)) {
/* 1485 */       this.diePlayers.remove(playerId);
/*      */     }
/* 1487 */     res.setS2CCode(200);
/* 1488 */     return res;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPlayerNum() {
/* 1495 */     return this.actors.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WNPlayer getPlayer(String playerId) {
/* 1502 */     return PlayerUtil.getOnlinePlayer(playerId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Actor getActor(String playerId) {
/* 1509 */     return this.actors.get(playerId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAllActorDie() {
/* 1516 */     for (Actor actor : this.actors.values()) {
/* 1517 */       if (actor.alive) {
/* 1518 */         return false;
/*      */       }
/*      */     } 
/* 1521 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerEntered(WNPlayer player) {
/* 1530 */     player.titleManager.checkInvalidRanks(true);
/*      */ 
/*      */     
/* 1533 */     player.taskManager.dealTaskEvent(Const.TaskType.reachPos, String.valueOf(this.areaId), 1);
/* 1534 */     if ((this.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || this.sceneType == Const.SCENE_TYPE.LOOP.getValue() || this.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue()) && 
/* 1535 */       player.isRobot()) {
/* 1536 */       JobFactory.addDelayJob(() -> onPlayerAutoBattle(player, true), 2000L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1542 */     player.activityManager.CheckLimitTimeGiftList();
/*      */ 
/*      */     
/* 1545 */     if (!isNormal()) {
/* 1546 */       BILogService.getInstance().ansycReportEnteredArea(player.getPlayer(), this.sceneType, this.areaId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerLeaved(WNPlayer player) {
/* 1554 */     Out.debug(new Object[] { player.getName(), " onPlayerLeaved: ", this.prop.name });
/* 1555 */     if (!isNormal() && !noCloseIfNoPlayer() && isEmpty() && this.closeFuture == null) {
/* 1556 */       addCloseFuture(66);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toJSON4EnterScene(WNPlayer player) {
/* 1564 */     return player.toJSON4EnterScene(this).toJSONString();
/*      */   }
/*      */   
/*      */   public void putActor(String playerId) {
/* 1568 */     this.actors.put(playerId, new Actor());
/*      */   }
/*      */   
/*      */   public void removeActor(String playerId) {
/* 1572 */     this.actors.remove(playerId);
/* 1573 */     if (!isNormal() && isAllActorDie()) {
/* 1574 */       AreaEvent.gameOverEventB2R(this, Utils.toJSON(new Object[] { "force", Integer.valueOf(-1) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addPlayer(WNPlayer player) {
/* 1582 */     String playerId = player.getId();
/* 1583 */     setForce(player);
/* 1584 */     player.setArea(this);
/* 1585 */     Out.debug(new Object[] { player.getName(), "addPlayer begin enter scene id:", this.instanceId, " - ", this.prop.name, Integer.valueOf(this.lineIndex) });
/*      */     try {
/* 1587 */       if (!this.actors.containsKey(playerId)) {
/* 1588 */         this.hasPlayerEntered = true;
/* 1589 */         this.actors.put(playerId, new Actor());
/*      */       } 
/* 1591 */       removeCloseFuture();
/* 1592 */       if (player.isRobot()) {
/* 1593 */         playerEnterRequest(player);
/* 1594 */         JobFactory.addDelayJob(() -> player.onEndEnterScene(), 
/*      */             
/* 1596 */             Utils.getSecMills(3, 5));
/*      */       } 
/* 1598 */     } catch (Exception error) {
/* 1599 */       Out.error(new Object[] { "c# enter scene id: ", this.instanceId, " - ", this.prop.name, " error : ", error });
/* 1600 */       throw error;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JSONObject getBornPlace(int templateID) {
/* 1608 */     JSONObject data = Utils.toJSON(new Object[] { "x", Integer.valueOf(0), "y", Integer.valueOf(0) });
/* 1609 */     String result = getXmdsManager().getBornPlace(this.instanceId, templateID);
/* 1610 */     if (StringUtil.isNotEmpty(result)) {
/* 1611 */       data = JSON.parseObject(result);
/*      */     }
/* 1613 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetPlayerData getPlayerData(String playerId) {
/* 1621 */     String result = getXmdsManager().getPlayerData(playerId, true);
/* 1622 */     return StringUtil.isEmpty(result) ? null : (GetPlayerData)JSON.parseObject(result, GetPlayerData.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void syncPlayerHistoryData(WNPlayer player) {
/* 1629 */     if (isNormal()) {
/* 1630 */       GetPlayerData result = getPlayerData(player.getId());
/* 1631 */       if (result != null) {
/* 1632 */         Out.debug(new Object[] { this.instanceId, " syncPlayerHistoryData:", player.getName(), " x:", Float.valueOf(result.x), ", y:", Float.valueOf(result.y) });
/* 1633 */         player.syncNowData(this.areaId, this.instanceId, result);
/* 1634 */         player.syncHistoryData(this.areaId, this.instanceId, result);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePlayer(WNPlayer player, boolean keepObject) {
/* 1643 */     Out.debug(new Object[] { this.instanceId, " - ", this.prop.name, " removePlayer player :", player.getName() });
/* 1644 */     String playerId = player.getId();
/* 1645 */     Actor actor = getActor(playerId);
/* 1646 */     if (actor != null) {
/* 1647 */       playerLeaveRequest(player, keepObject);
/* 1648 */       this.actors.remove(playerId);
/* 1649 */       onPlayerLeaved(player);
/* 1650 */       resetEmptyTime();
/* 1651 */       RobotUtil.onRobotLeaderQuit(this, player);
/*      */     } 
/* 1653 */     if (!isNormal() && isAllActorDie() && !noCloseIfNoPlayer()) {
/* 1654 */       AreaEvent.gameOverEventB2R(this, Utils.toJSON(new Object[] { "force", Integer.valueOf(-1) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void pushRelive(WNPlayer player) {
/* 1662 */     if (player != null) {
/* 1663 */       PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(player);
/* 1664 */       WNNotifyManager.getInstance().pushRelive(player, data.build());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] onPKPlayerDeadDrop(WNPlayer deadPlayer, WNPlayer hitPlayer, int pkValue, float x, float y) {
/* 1672 */     Object[] result = new Object[2];
/* 1673 */     if (deadPlayer == null || hitPlayer == null || deadPlayer.isProxy()) {
/* 1674 */       return result;
/*      */     }
/* 1676 */     List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
/* 1677 */     List<NormalItem> items = deadPlayer.pkRuleManager.dropItemByKilled(pkValue, this);
/* 1678 */     Out.debug(new Object[] { getClass(), " onPlayerDeadByPlayer items:", Integer.valueOf(items.size()) });
/* 1679 */     for (NormalItem dropItem : items) {
/* 1680 */       dropItem.itemDb.gotTime = new Date();
/* 1681 */       AreaItem areaItem = new AreaItem(dropItem);
/* 1682 */       areaItem.dropPlayer = deadPlayer;
/* 1683 */       areaItem.dropX = x;
/* 1684 */       areaItem.dropY = y;
/* 1685 */       this.items.put(dropItem.itemDb.id, areaItem);
/* 1686 */       List<String> list_pids = new ArrayList<>();
/* 1687 */       if (hitPlayer != null) {
/* 1688 */         list_pids.add(hitPlayer.getId());
/*      */       }
/* 1690 */       list_pids.add(deadPlayer.getId());
/* 1691 */       ItemToBtlServerData itemData = dropItem.toJSON4BatterServer(list_pids, Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, true);
/* 1692 */       itemsPayLoad.add(itemData);
/*      */       
/* 1694 */       if (dropItem.getQLevel() >= Const.ItemQuality.ORANGE.getValue()) {
/* 1695 */         StringBuffer sb = new StringBuffer();
/* 1696 */         if (dropItem instanceof NormalEquip && dropItem.itemDb.speData != null) {
/* 1697 */           ItemSpeData speData = dropItem.itemDb.speData;
/* 1698 */           if (speData != null) {
/* 1699 */             sb.append(speData.baseAtts.toString());
/* 1700 */             if (speData.extAtts != null) {
/* 1701 */               sb.append("|||").append(speData.extAtts.toString());
/*      */             }
/* 1703 */             if (speData.legendAtts != null) {
/* 1704 */               sb.append("|||").append(speData.legendAtts.toString());
/*      */             }
/*      */           } 
/*      */         } 
/* 1708 */         PlayerUtil.bi(getClass(), Const.BiLogType.Pk, hitPlayer, new Object[] { deadPlayer.getId(), deadPlayer.getName(), dropItem.itemDb.id, dropItem.itemDb.code, sb.toString() });
/*      */       } 
/*      */     } 
/* 1711 */     if (itemsPayLoad.size() > 0) {
/*      */       
/* 1713 */       String data = Utils.toJSON(new Object[] { "pos", Utils.ofMap(new Object[] { "x", Float.valueOf(x), "y", Float.valueOf(y) }), "items", itemsPayLoad }).toJSONString();
/* 1714 */       Out.debug(new Object[] { getClass(), " onPlayerDeadByPlayer:", data });
/* 1715 */       getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
/*      */     } 
/*      */     
/* 1718 */     result[0] = itemsPayLoad;
/* 1719 */     result[1] = items;
/*      */     
/* 1721 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
/* 1728 */     pushRelive(player);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
/* 1735 */     if (deadPlayer == null || hitPlayer == null) {
/*      */       return;
/*      */     }
/* 1738 */     Out.info(new Object[] { "玩家击杀玩家 Attack=", hitPlayer.getId(), "(", hitPlayer.getName(), "),Dead=", deadPlayer.getId(), "(", deadPlayer.getName(), ")" });
/* 1739 */     pushRelive(deadPlayer);
/* 1740 */     hitPlayer.onEvent(new TaskEvent(Const.TaskType.KILL_PLAYER, new Object[] { String.valueOf(deadPlayer.getPro()), Integer.valueOf(1) }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addExp(WNPlayer player, Collection<WNPlayer> belongPlayers, int attackType, MonsterBase monsterProp, int monsterLevel, int teamExpAdd) {
/* 1747 */     int levelLimit = GlobalConfig.Exp_Monster_LevelLimit;
/* 1748 */     PetNew pet = player.getFightingPet();
/* 1749 */     if (pet != null && Math.abs(pet.po.level - monsterLevel) <= levelLimit) {
/* 1750 */       if (attackType == 1) {
/* 1751 */         int exp = monsterProp.baseExp * 2 * monsterLevel / (pet.po.level + monsterLevel);
/* 1752 */         if (exp < 1)
/* 1753 */           exp = 1; 
/* 1754 */         pet.addExp(exp, true);
/*      */       } else {
/* 1756 */         int ratioMaster = Integer.valueOf(((PetConfigExt)GameData.PetConfigs.get("PetExp.Percent.KillByMaster")).paramValue).intValue();
/* 1757 */         int exp = monsterProp.baseExp * ratioMaster / 100 * 2 * monsterLevel / (pet.po.level + monsterLevel);
/* 1758 */         if (exp < 1)
/* 1759 */           exp = 1; 
/* 1760 */         pet.addExp(exp, true);
/*      */       } 
/*      */     }
/* 1763 */     if (Math.abs(player.getLevel() - monsterLevel) > levelLimit) {
/* 1764 */       int exp = 1;
/*      */       
/* 1766 */       int exdExp = player.bufferManager.getBuffAttrValue("ExdExp");
/*      */       
/* 1768 */       exdExp += player.getGuildExdExp();
/* 1769 */       exp += exp * exdExp / 10000;
/*      */ 
/*      */       
/* 1772 */       if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
/* 1773 */         exp = player.illusionManager.addAward("exp", exp);
/*      */       }
/*      */       
/* 1776 */       List<NormalItem> expItems = ItemUtil.createItemsByItemCode("exp", exp);
/* 1777 */       for (NormalItem item : expItems) {
/* 1778 */         addVirtureItem(player, item, Const.GOODS_CHANGE_TYPE.monsterdrop);
/*      */       }
/*      */     } 
/* 1781 */     for (WNPlayer belongPlayer : belongPlayers) {
/* 1782 */       if (belongPlayer == null)
/*      */         continue; 
/* 1784 */       int levelDiff = Math.abs(belongPlayer.getLevel() - monsterLevel);
/* 1785 */       if (levelDiff > levelLimit)
/*      */         continue; 
/* 1787 */       int exp = monsterProp.baseExp * 2 * monsterLevel / (belongPlayer.getLevel() + monsterLevel);
/*      */       
/* 1789 */       int teamExp = 0;
/* 1790 */       if (teamExpAdd > 0) {
/* 1791 */         teamExp = exp * (10000 + teamExpAdd) / 10000;
/* 1792 */         if (teamExp < 0) {
/* 1793 */           teamExp = 0;
/*      */         }
/*      */       } 
/* 1796 */       exp = (int)(exp * (1.0F + belongPlayer.vipManager.getVipExpRatio()));
/*      */       
/* 1798 */       exp += teamExp;
/*      */       
/* 1800 */       if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
/* 1801 */         exp = belongPlayer.illusionManager.addAward("exp", exp);
/*      */       }
/* 1803 */       List<NormalItem> expItems = ItemUtil.createItemsByItemCode("exp", exp);
/* 1804 */       for (NormalItem item : expItems) {
/* 1805 */         addVirtureItem(belongPlayer, item, Const.GOODS_CHANGE_TYPE.monsterdrop);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPlayer(String playerId) {
/* 1813 */     return this.actors.containsKey(playerId);
/*      */   }
/*      */   
/*      */   public boolean isAllRobot() {
/* 1817 */     for (String playerId : this.actors.keySet()) {
/* 1818 */       TeamData.TeamMemberData teamMember = TeamService.getTeamMember(playerId);
/* 1819 */       if (teamMember == null || !teamMember.robot) {
/* 1820 */         return false;
/*      */       }
/*      */     } 
/* 1823 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasHighQualityItem() {
/* 1830 */     for (AreaItem itemInfo : this.items.values()) {
/* 1831 */       if (itemInfo.item.prop.qcolor >= GlobalConfig.Leave_Notice_Quality) {
/* 1832 */         return true;
/*      */       }
/*      */     } 
/* 1835 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canRebirth(String playerId) {
/* 1842 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void receive(String route, GeneratedMessage msg) {
/* 1849 */     receive((PomeloPush)new MessagePush(route, msg));
/*      */   }
/*      */   
/*      */   public void receive(PomeloPush push) {
/* 1853 */     for (String rid : this.actors.keySet()) {
/* 1854 */       WNPlayer player = getPlayer(rid);
/* 1855 */       if (player != null) {
/* 1856 */         player.receive((Message)push);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isKeepObject() {
/* 1865 */     return !isOpenJoinTeam();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isOpenJoinTeam() {
/* 1872 */     return isOpenJoinTeamArea();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerLogin(WNPlayer player) {
/* 1879 */     player.nofitySuperScript();
/* 1880 */     if (!isNormal() && (this.diePlayers == null || !this.diePlayers.contains(player.getId()))) {
/* 1881 */       onPlayerAutoBattle(player, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerLogout(WNPlayer player) {
/* 1889 */     if (player.getTeamManager().getTeamMember() != null) {
/* 1890 */       (player.getTeamManager().getTeamMember()).follow = false;
/*      */     }
/*      */     
/* 1893 */     boolean keepObject = isKeepObject();
/* 1894 */     if (keepObject && !isClose() && 
/* 1895 */       !player.getTeamManager().isFollowLeader())
/*      */     {
/* 1897 */       onPlayerAutoBattle(player, true);
/*      */     }
/*      */     
/* 1900 */     Actor actor = getActor(player.getId());
/* 1901 */     if (actor != null) {
/* 1902 */       if (!actor.alive) {
/* 1903 */         recordDie(player.getId());
/*      */       }
/* 1905 */       removePlayer(player, keepObject);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void onPlayerAutoBattle(WNPlayer player, boolean enable) {
/* 1910 */     if (!isClose()) {
/* 1911 */       String playerId = player.getId();
/*      */       
/* 1913 */       getXmdsManager().autoBattle(this.instanceId, playerId, enable);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected PlayerHandler.PlayerRelivePush.Builder newPlayerRelivePush(WNPlayer player) {
/* 1918 */     return newPlayerRelivePush(player, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected PlayerHandler.PlayerRelivePush.Builder newPlayerRelivePush(WNPlayer player, boolean showBtn) {
/* 1925 */     ResurrectionCO resurrection = (ResurrectionCO)GameData.Resurrections.get(Integer.valueOf(this.areaId));
/*      */     
/* 1927 */     PlayerHandler.PlayerRelivePush.Builder data = PlayerHandler.PlayerRelivePush.newBuilder();
/* 1928 */     data.setBtn(showBtn ? ReliveBtn.SHOW_CLICK.value : ReliveBtn.UN_SHOW.value);
/*      */     
/* 1930 */     data.setCountDown(GlobalConfig.Group_Resurrection);
/* 1931 */     data.setCbType(ReliveCB.RELIVE.value);
/* 1932 */     data.setType(isNormal() ? ReliveOP.FIELD.value : ReliveOP.RELIVE.value);
/* 1933 */     data.setOp(isNormal() ? ReliveUP.OK.value : ReliveUP.NO.value);
/* 1934 */     int totalReliveNum = 3 + player.vipManager.getReliveNum();
/* 1935 */     int nowReliveNum = totalReliveNum - (player.getReliveManager()).nowReliveNum;
/* 1936 */     int cost = 5;
/* 1937 */     if (resurrection != null) {
/* 1938 */       if (resurrection.backResurrect != 1) {
/* 1939 */         data.setCbType(ReliveCB.RELIVE.value);
/* 1940 */         data.setType(ReliveOP.FIELD.value);
/* 1941 */         data.setOp(ReliveUP.NO.value);
/* 1942 */       } else if (!isNormal()) {
/* 1943 */         data.setCbType(ReliveCB.LEAVE.value);
/* 1944 */         data.setOp(ReliveUP.OK.value);
/* 1945 */         data.setType(ReliveOP.LEAVE.value);
/*      */       } 
/* 1947 */       cost = resurrection.cost;
/* 1948 */       if (!isNormal() && resurrection.resurrectNum > 0) {
/* 1949 */         int currCount = resurrection.resurrectNum - player.getReliveManager().getReliveCount(this.areaId);
/* 1950 */         if (currCount > 0) {
/* 1951 */           data.setType(ReliveOP.RELIVE.value);
/* 1952 */           data.setCbType(ReliveCB.RELIVE.value);
/* 1953 */           data.setOp(ReliveUP.NO.value);
/*      */         } 
/* 1955 */         data.setCurrCount(currCount);
/* 1956 */         data.setTotalCount(resurrection.resurrectNum);
/*      */       } 
/* 1958 */       data.setCountDown(resurrection.autoResurrectTime);
/* 1959 */       data.setCooltime(resurrection.resurrectCD);
/* 1960 */       if (resurrection.lieDown == 1) {
/* 1961 */         data.setCbType(ReliveCB.ICON.value);
/*      */       }
/* 1963 */       if (resurrection.freeResurrect > 0) {
/* 1964 */         nowReliveNum = 0;
/*      */       }
/*      */     } 
/* 1967 */     if (nowReliveNum > 0) {
/* 1968 */       (player.getReliveManager()).payCost = 0;
/* 1969 */       data.setPayConfirm(0);
/* 1970 */       data.setCostStr(LangService.format("RELIVE_FREE", new Object[] { Integer.valueOf(nowReliveNum), Integer.valueOf(totalReliveNum) }));
/*      */     } else {
/* 1972 */       if (-nowReliveNum > 0) {
/* 1973 */         cost = -nowReliveNum * cost;
/* 1974 */         cost = Math.min(cost, 50);
/*      */       } 
/* 1976 */       (player.getReliveManager()).payCost = cost;
/* 1977 */       data.setPayConfirm((player.getReliveManager()).payConfirm);
/* 1978 */       data.setCostStr(LangService.format("RELIVE_DIAMOND", new Object[] { Integer.valueOf(cost) }));
/*      */     } 
/* 1980 */     if (showBtn) {
/* 1981 */       data.setBtnSafe(1);
/* 1982 */       data.setBtnCity(1);
/* 1983 */       data.setBtnCurr((getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) ? 0 : 1);
/*      */     } 
/* 1985 */     return data;
/*      */   }
/*      */   
/*      */   public boolean onCleanItem(AreaItem areaItem) {
/* 1989 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ReliveType getReliveType() {
/* 1996 */     return ReliveType.BORN;
/*      */   }
/*      */   
/*      */   public void onRobotQuit(int second) {
/* 2000 */     for (String playerId : this.actors.keySet()) {
/* 2001 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 2002 */       if (player != null && player.isRobot()) {
/* 2003 */         JobFactory.addDelayJob(() -> player.fightLevelManager.leaveDungeon(player, this), (
/*      */             
/* 2005 */             Utils.getSecMills(3, second) / 2));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCloseFuture() {
/* 2016 */     addCloseFuture(this.prop.timeCount);
/*      */   }
/*      */   
/*      */   protected void addCloseFuture(int second) {
/*      */     try {
/* 2021 */       if (this.closeFuture != null && !this.closeFuture.isDone()) {
/* 2022 */         Out.info(new Object[] { getClass(), " more addCloseFuture!!!" });
/* 2023 */         this.closeFuture.cancel(true);
/*      */       } 
/* 2025 */       onRobotQuit(second);
/*      */     } finally {
/* 2027 */       this.closeFuture = JobFactory.addDelayJob(() -> { if (this.robotDisponseJob != null) { this.robotDisponseJob.cancel(true); this.robotDisponseJob = null; }  AreaUtil.closeArea(this.instanceId); }((second + 5) * 1000));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeCloseFuture() {
/* 2038 */     if (this.closeFuture != null) {
/* 2039 */       this.closeFuture.cancel(true);
/* 2040 */       this.closeFuture = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDailyActivity(WNPlayer player) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEndEnterScene(WNPlayer player) {
/* 2054 */     if (this.diePlayers != null && this.diePlayers.contains(player.getId())) {
/* 2055 */       pushRelive(player);
/*      */     }
/* 2057 */     Out.info(new Object[] { "player true enter scene:sceneId=", Integer.valueOf(this.areaId), "instanceId:", this.instanceId, ",playerId=", player.getId() });
/*      */   }
/*      */   
/*      */   public void onUnitDead(JSONObject msg) {
/* 2061 */     AreaEvent.unitDead(this, msg);
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
/*      */   public void eatOrLostBuffer(WNPlayer player, String paramType, String paramData) {
/* 2075 */     String tips = "";
/* 2076 */     Map<String, Actor> actors = this.actors;
/* 2077 */     if (paramType.equals("GetBuff")) {
/* 2078 */       Actor actor = actors.get(player.getId());
/* 2079 */       if (actor != null) {
/* 2080 */         actor.buffers.add(paramData);
/*      */       }
/* 2082 */       if (Integer.parseInt(paramData) == Const.Arena.ARENA_TIANSHEN.value) {
/* 2083 */         tips = LangService.format("ARENA_TIANSHEN_BUFF", new Object[] { player.getName() });
/* 2084 */         for (String tempPlayerId : actors.keySet()) {
/* 2085 */           WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
/* 2086 */           if (tempPlayer != null) {
/* 2087 */             MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
/*      */           }
/*      */         } 
/* 2090 */       } else if (Integer.parseInt(paramData) == Const.Arena.ARENA_GREEDY.value) {
/* 2091 */         tips = LangService.getValue("ARENA_GREEDY_BUFF");
/* 2092 */         MessageUtil.sendSysTip(player, tips, Const.TipsType.NORMAL);
/* 2093 */       } else if (Integer.parseInt(paramData) == Const.Arena.FIGHT_POWER_UP.value) {
/* 2094 */         tips = LangService.getValue("BUFF_FIGHT_UP");
/* 2095 */         MessageUtil.sendSysTip(player, tips, Const.TipsType.NORMAL);
/*      */       } 
/* 2097 */     } else if (paramType.equals("LoseBuff")) {
/* 2098 */       Actor actor = actors.get(player.getId());
/* 2099 */       if (actor != null) {
/* 2100 */         actor.buffers.remove(paramData);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private class PointItem
/*      */   {
/*      */     String id;
/*      */     
/*      */     String itemCode;
/*      */     
/*      */     int num;
/*      */     
/*      */     boolean send2client;
/*      */     
/*      */     boolean get;
/*      */     Map<String, Integer> points;
/*      */     Set<String> bindPlayers;
/*      */     ScheduledFuture<?> schResult;
/*      */     int sceneTypeValue;
/*      */     
/*      */     PointItem(String itemCode, int num, int sceneTypeValue) {
/* 2123 */       this.itemCode = itemCode;
/* 2124 */       this.id = UUID.randomUUID().toString();
/* 2125 */       this.num = num;
/* 2126 */       this.sceneTypeValue = sceneTypeValue;
/*      */     }
/*      */     
/*      */     public void bindTeam(WNPlayer player) {
/* 2130 */       Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/* 2131 */       this.bindPlayers = new HashSet<>((members == null) ? 1 : members.size());
/* 2132 */       this.points = new HashMap<>((members == null) ? 1 : members.size());
/* 2133 */       if (members != null) {
/* 2134 */         this.bindPlayers.addAll(members.keySet());
/*      */       } else {
/* 2136 */         this.bindPlayers.add(player.getId());
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void sendThrowPointItemListPush(WNPlayer player, int bossId) {
/* 2145 */     if (this.pointItems.size() > 0) {
/* 2146 */       int time = 30;
/* 2147 */       BattleHandler.ThrowPointItemListPush.Builder builder = BattleHandler.ThrowPointItemListPush.newBuilder();
/* 2148 */       builder.setS2CCode(200);
/* 2149 */       builder.setTime(time);
/* 2150 */       for (PointItem pointItem : this.pointItems.values()) {
/* 2151 */         if (!pointItem.send2client) {
/* 2152 */           BattleHandler.PointItemView.Builder view = BattleHandler.PointItemView.newBuilder();
/* 2153 */           view.setId(pointItem.id);
/* 2154 */           view.setItemCode(pointItem.itemCode);
/* 2155 */           view.setNum(pointItem.num);
/* 2156 */           builder.addItems(view);
/*      */           
/* 2158 */           pointItem.send2client = true;
/*      */         } 
/*      */       } 
/* 2161 */       MessagePush list = null;
/* 2162 */       if (builder.getItemsCount() > 0) {
/* 2163 */         list = new MessagePush("area.battlePush.throwPointItemListPush", (GeneratedMessage)builder.build());
/*      */       }
/* 2165 */       Set<String> team = player.getTeamMembers();
/* 2166 */       Set<String> toThrowPointResultTeam = new HashSet<>();
/*      */       
/* 2168 */       for (Map.Entry<String, Actor> actorEntry : this.actors.entrySet()) {
/* 2169 */         String teamPlayerId = actorEntry.getKey();
/* 2170 */         Actor actor = actorEntry.getValue();
/* 2171 */         WNPlayer teamPlayer = getPlayer(teamPlayerId);
/* 2172 */         if (teamPlayer != null && actor.profitable && teamPlayer.fightLevelManager.canDrop(bossId, this) && teamPlayer.dropManager.canDrop(bossId, this) && list != null && team != null && team.contains(teamPlayerId)) {
/* 2173 */           teamPlayer.receive((Message)list);
/* 2174 */           toThrowPointResultTeam.add(teamPlayerId);
/*      */         } 
/*      */       } 
/*      */       
/* 2178 */       for (PointItem item : this.pointItems.values()) {
/* 2179 */         if (team != null && toThrowPointResultTeam.size() > 0 && item.schResult == null) {
/* 2180 */           item.schResult = JobFactory.addDelayJob(() -> { Out.debug(new Object[] { "throw point timeout!!!" }, ); throwPointResult(item, item.id, toThrowPointResultTeam); }(time * 1000));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onRobotThrowPoint(WNPlayer player) {
/* 2190 */     for (Iterator<PointItem> iterator = this.pointItems.values().iterator(); iterator.hasNext(); ) { PointItem pointItem = iterator.next();
/* 2191 */       if (pointItem.bindPlayers.contains(player.getId())) {
/* 2192 */         JobFactory.addDelayJob(() -> randomPoint(player, pointItem.id), 
/*      */             
/* 2194 */             Utils.getSecMills(1, 5));
/*      */       } }
/*      */   
/*      */   }
/*      */   
/*      */   public int randomPoint(WNPlayer player, String id) {
/* 2200 */     if (this.pointItems == null || !this.pointItems.containsKey(id))
/* 2201 */       return 0; 
/* 2202 */     PointItem item = this.pointItems.get(id);
/* 2203 */     Map<String, Integer> points = item.points;
/* 2204 */     if (item.get || points.containsKey(player.getId()))
/* 2205 */       return 0; 
/* 2206 */     int point = RandomUtil.getInt(100);
/*      */     
/* 2208 */     for (Iterator<Integer> iterator = points.values().iterator(); iterator.hasNext(); ) { int p = ((Integer)iterator.next()).intValue();
/* 2209 */       if (p == point) {
/* 2210 */         if (point < 50) {
/* 2211 */           point += RandomUtil.getInt(3); break;
/*      */         } 
/* 2213 */         point -= RandomUtil.getInt(3);
/*      */         
/*      */         break;
/*      */       }  }
/*      */ 
/*      */     
/* 2219 */     points.put(player.getId(), Integer.valueOf(point));
/* 2220 */     if (points.size() >= getPlayerNum()) {
/* 2221 */       if (item.schResult != null) {
/* 2222 */         item.schResult.cancel(true);
/* 2223 */         item.schResult = null;
/*      */       } 
/* 2225 */       throwPointResult(item, id, (player != null) ? player.getTeamMembers() : null);
/*      */     } 
/* 2227 */     return point;
/*      */   }
/*      */ 
/*      */   
/*      */   private void throwPointResult(PointItem item, String pointId, Set<String> team) {
/* 2232 */     synchronized (item) {
/* 2233 */       if (item.get)
/*      */         return; 
/* 2235 */       item.get = true;
/*      */     } 
/* 2237 */     StringBuilder content = new StringBuilder();
/* 2238 */     DItemEquipBase equip = ItemConfig.getInstance().getItemProp(item.itemCode);
/*      */     
/* 2240 */     String equipNmae = ItemUtil.getColorItemNameByQcolor(equip.qcolor, equip.name);
/* 2241 */     Map<String, Integer> points = item.points;
/* 2242 */     String rid = null;
/* 2243 */     int tmpPoint = 0;
/*      */ 
/*      */     
/* 2246 */     boolean hasProFit = false;
/* 2247 */     for (String playerId : item.bindPlayers) {
/* 2248 */       PlayerPO playerPO = PlayerUtil.getPlayerBaseData(playerId);
/* 2249 */       if (playerPO.pro == equip.Pro && points.containsKey(playerId)) {
/* 2250 */         hasProFit = true;
/*      */       }
/*      */     } 
/*      */     
/* 2254 */     for (String playerId : item.bindPlayers) {
/* 2255 */       PlayerPO playerPO = PlayerUtil.getPlayerBaseData(playerId);
/* 2256 */       if (points.containsKey(playerId)) {
/* 2257 */         int point = ((Integer)points.get(playerId)).intValue();
/* 2258 */         content.append(LangService.format("TEAM_THROW_POINT", new Object[] { Integer.valueOf(point), playerPO.name })).append("<br/>");
/* 2259 */         if (point > tmpPoint) {
/* 2260 */           if (!hasProFit) {
/* 2261 */             rid = playerId;
/* 2262 */             tmpPoint = point; continue;
/*      */           } 
/* 2264 */           if (playerPO.pro == equip.Pro) {
/* 2265 */             rid = playerId;
/* 2266 */             tmpPoint = point;
/*      */           } 
/*      */         } 
/*      */         continue;
/*      */       } 
/* 2271 */       content.append(LangService.format("TEAM_UNTHROW_POINT", new Object[] { playerPO.name })).append("<br/>");
/*      */     } 
/*      */ 
/*      */     
/* 2275 */     WNPlayer member = (rid == null) ? null : getPlayer(rid);
/* 2276 */     if (member == null) {
/* 2277 */       List<String> list_profitable = new ArrayList<>();
/*      */       
/* 2279 */       for (String _pId : this.actors.keySet()) {
/* 2280 */         WNPlayer _player = getPlayer(_pId);
/* 2281 */         if (this.actors.get(_pId) != null && ((Actor)this.actors.get(_pId)).profitable && _player != null && team.contains(_pId))
/*      */         {
/* 2283 */           list_profitable.add(_pId);
/*      */         }
/*      */       } 
/* 2286 */       if (list_profitable.size() > 0) {
/* 2287 */         int idx = RandomUtil.getIndex(list_profitable.size());
/* 2288 */         member = getPlayer(list_profitable.get(idx));
/*      */       } 
/*      */     } 
/* 2291 */     if (member != null) {
/* 2292 */       BattleHandler.ThrowPointResultPush push = BattleHandler.ThrowPointResultPush.newBuilder().setS2CCode(200).setId(item.id).setName((member == null) ? "" : member.getName()).setItemCode(item.itemCode).setPoint(tmpPoint).setNum(item.num).build();
/*      */       
/* 2294 */       WNPlayer player = member;
/* 2295 */       JobFactory.addDelayJob(() -> { String itemLink = null; NormalItem newEquip = null; if (player != null) { player.illusionManager.addItemNum(this, item.itemCode, 1); if (player.getWnBag().testAddCodeItem(item.itemCode, 1, null, false)) { newEquip = ItemUtil.createItemsByItemCode(item.itemCode, 1).get(0); itemLink = ChannelUtil.getChatLinkItem(newEquip); player.getWnBag().addEntityItem(newEquip, Const.GOODS_CHANGE_TYPE.RollPoint, null, false, false); } else { MailSysData mailData = new MailSysData("Bag_full_common"); mailData.attachments = new ArrayList(); MailData.Attachment attachment = new MailData.Attachment(); attachment.itemCode = item.itemCode; attachment.itemNum = 1; mailData.attachments.add(attachment); MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.RollPoint); }  }  if (itemLink != null) { String title = LangService.format("TEAM_THROW_RESULT", new Object[] { equipNmae }) + "<br/>"; content.insert(0, title); if (item != null) if (newEquip.isEquip()) { content.append(LangService.format("TEAM_THROW_WIN_EQUIP", new Object[] { player.getName(), Integer.valueOf(1), "" })).append(itemLink); } else { content.append(LangService.format("TEAM_THROW_WIN", new Object[] { player.getName(), Integer.valueOf(item.num), "" })).append(itemLink); }   } else { String title = LangService.format("TEAM_THROW_RESULT", new Object[] { equipNmae }) + "<br/>"; content.insert(0, title); content.append(LangService.format("TEAM_THROW_WIN_EQUIP", new Object[] { player.getName(), Integer.valueOf(1), equipNmae })); }  for (String playerId : item.bindPlayers) { WNPlayer actor = getPlayer(playerId); if (actor != null) { actor.receive("area.battlePush.throwPointResultPush", (GeneratedMessage)push); MessageUtil.sendChatMsgAsyn(actor, content.toString(), Const.CHAT_SCOPE.TEAM, Const.TipsType.NORMAL); Out.debug(new Object[] { "==============", content }); }  }  }0L);
/*      */     } 
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
/* 2347 */     this.pointItems.remove(pointId);
/* 2348 */     Out.debug(new Object[] { "===============pointId removed:", pointId });
/*      */   }
/*      */   
/*      */   public void playerEnterRequest(WNPlayer player) {
/* 2352 */     playerEnterRequest(player, toJSON4EnterScene(player));
/*      */   }
/*      */   
/*      */   public void playerEnterRequest(WNPlayer player, String enterSceneData) {
/* 2356 */     getZoneManager().playerEnterRequest(player.getId(), this.instanceId, enterSceneData);
/* 2357 */     Out.debug(new Object[] { "playerEnterRequest====================", player.getName(), "-", this.instanceId, "-", this.prop.name });
/*      */   }
/*      */   
/*      */   public void playerLeaveRequest(WNPlayer player, boolean keepObject) {
/* 2361 */     getZoneManager().playerLeaveRequest(player.getId(), this.instanceId, keepObject);
/* 2362 */     Out.debug(new Object[] { "playerLeaveRequest--------------------", player.getName(), "-", this.instanceId, "-", (player.getArea()).prop.name });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onReady(WNPlayer player) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AreaData getAreaData() {
/* 2376 */     System.err.println("instanceId=" + this.instanceId);
/* 2377 */     return new AreaData(this.areaId, this.instanceId);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 2382 */     return this.serverId + " :: " + this.prop.name + " : " + this.instanceId + " : " + this.actors.size();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\Area.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */