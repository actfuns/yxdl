package com.wanniu.game.area;


import Xmds.FinishPickItem;
import Xmds.GetPlayerData;
import Xmds.XmdsManagerPrx;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;

import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.game.GWorld;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MeltConfigCO;
import com.wanniu.game.data.MonsterRefreshCO;
import com.wanniu.game.data.ResurrectionCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.data.ext.PetConfigExt;
import com.wanniu.game.data.ext.RandomBoxExt;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.VirtualItem;
import com.wanniu.game.item.data.ItemToBtlServerData;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.petNew.PetNew;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DaoYouPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.PlayerTempPO;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;
import com.wanniu.game.team.TeamUtil;
import com.wanniu.game.util.RobotUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.BattleHandler;
import pomelo.area.PlayerHandler;
import pomelo.chat.ChatHandler;


public class Area {
    public boolean bsClose;
    protected String serverId;
    public byte[] npcDatas;
    public int logicServerId;
    public int areaId;
    public String instanceId;

    public enum ReliveBtn {
        UN_SHOW(0), SHOW_CLICK(1), SHOW_UN_CLICK(2);
        public int value;

        ReliveBtn(int value) {
            this.value = value;
        }
    }

    public enum ReliveUP {
        OK(1),
        NO(0);
        public int value;

        ReliveUP(int value) {
            this.value = value;
        }
    }

    public enum ReliveOP {
        FIELD(0),
        RELIVE(1),
        LEAVE(2);
        public int value;

        ReliveOP(int value) {
            this.value = value;
        }
    }

    public enum ReliveCB {
        ICON(0), RELIVE(1), LEAVE(2);
        public int value;

        ReliveCB(int value) {
            this.value = value;
        }
    }


    public enum ReliveType {
        CITY(0),

        NOW(1),

        BORN(2),

        PLACE(3),

        SKILL(4),

        RANDOM(5);
        public final int value;

        ReliveType(int value) {
            this.value = value;
        }
    }


    public static class Actor {
        public int rebornNum;

        public boolean leave;

        public boolean ready;
        public boolean alive = true;
        public long reliveCoolTime;
        public boolean profitable = true;
        public Map<String, Integer> historyVirtualItems;
        public List<NormalItem> historyItems;
        public List<String> buffers = new ArrayList<>();

        public void relive() {
            this.rebornNum++;
            this.alive = true;
        }
    }


    public static class AreaItem {
        public NormalItem item;
        public Map<String, WNPlayer> bindPlayers;
        public long createTime;
        public int monsterId;
        public WNPlayer dropPlayer;
        public float dropX;
        public float dropY;

        public AreaItem(NormalItem item) {
            this.item = item;
            this.createTime = System.currentTimeMillis();
        }
    }

    public boolean isFull() {
        return (this.isClose || this.bsClose || this.actors.size() >= this.fullCount);
    }

    public boolean isFull(int addCount) {
        return (this.isClose || this.bsClose || this.actors.size() + addCount > this.fullCount);
    }


    public int lineIndex = 1;

    public boolean hasPlayerEntered;

    public Map<String, Actor> actors;

    public long emptyTime;

    public MapBase prop;

    public int sceneType;

    public int lifeTime;
    public Map<String, AreaItem> items;
    public Set<Integer> aliveBoss;
    public Set<String> diePlayers;
    public int fullCount;
    public int maxCount;
    protected boolean isClose;

    public boolean isClose() {
        return this.isClose;
    }

    public boolean isPlayerClose(WNPlayer player) {
        return this.isClose;
    }

    public String getSceneName() {
        return this.prop.name;
    }

    protected Future<?> timer_SceneEndTime = null;

    public final Map<Integer, RandomBoxExt.Point> tcPoints = new ConcurrentHashMap<>();


    private ScheduledFuture<?> robotDisponseJob;


    protected Boolean isDispose;


    protected ScheduledFuture<?> closeFuture;


    private Map<String, PointItem> pointItems;


    public boolean isNewPoint(RandomBoxExt.Point point) {
        for (RandomBoxExt.Point p : this.tcPoints.values()) {
            if (point.distance(p) < 1.0D) {
                return false;
            }
        }

        return true;
    }


    public void newRandomBox(RandomBoxExt box) {
        GWorld.getInstance().ansycExec(() -> {
            RandomBoxExt.Point point = box.randomPoint();
            int flag = 0;
            while (flag++ < 50 && !isNewPoint(point)) {
                point = box.randomPoint();
            }
            float direction = (float) (RandomUtil.getFloat() * Math.PI * 2.0D);
            int objId = getXmdsManager().addUnit(this.instanceId, box.iD, Utils.toJSONString(new Object[]{"force", Integer.valueOf(Const.AreaForce.FORCEA.value), "name", box.name, "x", Float.valueOf(point.x), "y", Float.valueOf(point.y), "direction", Float.valueOf(direction)}));
            this.tcPoints.put(Integer.valueOf(objId), point);
        });
    }


    public void bindBattleServer(WNPlayer player) {
        this.serverId = player.getBattleServerId();
        Out.debug(new Object[]{"bindBattleServer ", this.serverId});

        if (!isNormal()) {
            Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
            if (members != null) {
                for (TeamData.TeamMemberData member : members.values()) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer != null) {
                        onDailyActivity(mPlayer);
                    }
                }
            } else {
                onDailyActivity(player);
            }
        }


        List<MonsterRefreshExt> props = GameData.findMonsterRefreshs(t -> (t.mapID == this.areaId));


        List<Integer> data = new ArrayList<>(props.size());
        if (props.size() > 0) {
            for (MonsterRefreshExt refreshExt : props) {
                Date bornBeginTime = AreaUtil.formatToday(refreshExt.rebornBeginTime);
                Date bornEndTime = AreaUtil.formatToday(refreshExt.rebornEndTime);
                long now = System.currentTimeMillis();
                if (bornBeginTime.getTime() <= now && bornEndTime.getTime() > now) {
                    data.add(Integer.valueOf(refreshExt.iD));
                }
            }
        }
        createMonster(data, true);


        GameData.RandomBoxs.forEach((k, v) -> {
            if (v.startScene == this.areaId) {
                for (int i = 0; i < v.quantity; i++) {
                    newRandomBox(v);
                }
            }
        });

        if (PlayerUtil.isRobot(player.player) &&
                this.robotDisponseJob == null) {
            this.robotDisponseJob = JobFactory.addDelayJob(() -> dispose(), 120000L);
        }
    }


    public ZoneManagerPrx getZoneManager() {
        return CSharpClient.getZoneManager(this.serverId);
    }

    public XmdsManagerPrx getXmdsManager() {
        return CSharpClient.getXmdsManager(this.serverId);
    }

    public String getServerId() {
        return this.serverId;
    }

    protected void init() {
        this.hasPlayerEntered = false;
        this.actors = new ConcurrentHashMap<>();
        this.emptyTime = GWorld.APP_TIME;
        this.sceneType = this.prop.type;
        this.lifeTime = this.prop.lifeTime * 1000;

        this.items = new ConcurrentHashMap<>();
        this.aliveBoss = new ConcurrentSkipListSet<>();
    }


    public int getSceneType() {
        return this.sceneType;
    }


    public boolean isEmpty() {
        return (getPlayerNum() <= 0);
    }


    public boolean isNormal() {
        return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || this.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
    }


    public boolean isPKDrop() {
        return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || this.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
    }


    public boolean needTeamConfirm(int type) {
        return (type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || type == Const.SCENE_TYPE.LOOP.getValue() || type == Const.SCENE_TYPE.DEMON_TOWER.getValue() || type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue() || type == Const.SCENE_TYPE.ILLUSION_2.getValue());
    }


    public boolean isOpenJoinTeamArea() {
        return (isNormal() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
    }


    protected boolean noCloseIfNoPlayer() {
        return (this.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
    }


    public void resetEmptyTime() {
        if (isEmpty()) {
            this.emptyTime = GWorld.APP_TIME;
        }
    }


    public boolean isValid() {
        return (!isEmpty() || GWorld.APP_TIME - this.emptyTime <= this.lifeTime);
    }


    public boolean needSendKillMail() {
        return (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue() || this.sceneType == Const.SCENE_TYPE.ILLUSION_2.getValue());
    }


    public boolean canCloseNoPlayer() {
        if (isEmpty()) {
            return true;
        }
        return false;
    }


    public void onSceneEndTime() {
    }


    protected void onDisponseLeave(WNPlayer player) {
        Out.info(new Object[]{player.getName(), " leave disponse area ", this.prop.name});
        PlayerTempPO temp = player.getPlayerTempData();
        AreaUtil.dispatchByAreaId(player, new AreaData(temp.historyAreaId, temp.historyX, temp.historyY), (Map<String, Object>) null);
    }

    public Area(JSONObject opts) {
        this.isDispose = Boolean.valueOf(false);
        Out.debug(new Object[]{"create area opts:", opts});
        this.logicServerId = opts.containsKey("logicServerId") ? opts.getIntValue("logicServerId") : 0;
        this.areaId = opts.getIntValue("areaId");
        this.instanceId = opts.getString("instanceId");
        this.prop = AreaDataConfig.getInstance().get(this.areaId);
        init();
    }

    public void dispose() {
        dispose(false);
    }


    public void dispose(boolean processExit) {
        synchronized (this.isDispose) {
            if (this.isDispose.booleanValue())
                return;
            this.isDispose = Boolean.valueOf(true);
        }
        this.isClose = true;

        try {
            if (this.timer_SceneEndTime != null) {
                this.timer_SceneEndTime.cancel(true);
                this.timer_SceneEndTime = null;
            }

            if (!processExit) {
                for (Map.Entry<String, Actor> entry : this.actors.entrySet()) {
                    String playerId = entry.getKey();
                    WNPlayer player = getPlayer(playerId);
                    if (player != null && player.getArea() == this && !player.isProxy()) {
                        onDisponseLeave(player);
                    }
                }
            }

            this.actors.clear();
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            Out.info(new Object[]{"destroyZone areaid:", this.prop.name, " - ", Integer.valueOf(this.areaId), "  instanceId:", this.instanceId});

            getZoneManager().destroyZoneRequest(this.instanceId);
        }
    }


    public void setForce(WNPlayer player) {
        player.setForce(Const.AreaForce.FORCEA.value);
    }


    public boolean autoMelt(WNPlayer player, NormalEquip equip) {
        if (!equip.isEquip() || equip.prop.noMelt == 1) {
            return false;
        }
        MeltConfigCO prop = ItemUtil.getMeltProp(equip.prop.meltLevel, equip.getQColor());
        if (prop == null) {
            return false;
        }
        if (player.isProxy()) {
            return false;
        }

        List<Integer> meltColor = player.hookSetManager.getMeltQcolor();
        if (!meltColor.contains(Integer.valueOf(equip.prop.qcolor))) {
            return false;
        }
        List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(prop.tcCode);
        List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);


        if (!player.getWnBag().testEmptyGridLarge(ItemUtil.getPackUpItemsNum(addItems))) {
            return false;
        }

        if (prop.costGold > 0 && !player.moneyManager.costGold(prop.costGold, Const.GOODS_CHANGE_TYPE.melt)) {
            player.sendSysTip(LangService.getValue("GOLD_NOT_ENOUGH"));
            return false;
        }

        Map<Integer, Object> currencyList = new HashMap<>();
        currencyList.put(Integer.valueOf(Const.CurrencyType.COIN.getValue()), Integer.valueOf(prop.costGold));


        player.getWnBag().addEntityItems(addItems, Const.GOODS_CHANGE_TYPE.AUTO_MELT, currencyList);


        BILogService.getInstance().ansycReportMeltCultivate(player.getPlayer(), addItems);

        return true;
    }


    protected boolean canPickInterActiveItem(WNPlayer player, String itemCode, int itemNum) {
        return true;
    }


    public void onInterActiveItem(WNPlayer player, int objId, int itemId) {
        RandomBoxExt.Point point = this.tcPoints.remove(Integer.valueOf(objId));
        if (point != null) {
            Out.debug(new Object[]{"interActiveItem : ", point});
        }
        RandomBoxExt box = (RandomBoxExt) GameData.RandomBoxs.get(Integer.valueOf(itemId));
        if (StringUtil.isNotEmpty(box.tc)) {
            boxNormalTC(player, box.tc, (int) point.x, (int) point.y);
        }

        if (StringUtil.isNotEmpty(box.teamTc)) {
            boxTeamTC(player, box.teamTc);
        }
        if (StringUtil.isNotEmpty(box.personTc)) {
            List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(box.personTc);
            if (dropItems != null && !dropItems.isEmpty()) {
                List<NormalItem> trueAdd = new ArrayList<>();
                for (NormalItem item : dropItems) {
                    if (canPickInterActiveItem(player, item.itemCode(), item.getNum())) {
                        trueAdd.add(item);
                    }
                }
                if (!trueAdd.isEmpty()) {
                    player.bag.addCodeItemMail(trueAdd, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.random_box, "Bag_full_common");
                }
            }
        }
        CharacterLevelCO prop = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(player.getLevel()));
        int playerLevelUpExp = prop.experience;
        int exp = Math.round((playerLevelUpExp * box.expRatio) / 10000.0F);
        if (exp > 0)
            player.addExp(exp, Const.GOODS_CHANGE_TYPE.random_box);
        int upexp = Math.round(((player.getLevel() - 1) * box.upExpRatio) / 10000.0F);
        if (upexp > 0)
            player.addUpExp(upexp, Const.GOODS_CHANGE_TYPE.random_box);
        int gold = Math.round(((player.getLevel() - 1) * box.goldPerMonLv) / 10000.0F);
        if (gold > 0) {
            player.moneyManager.addGold(gold, Const.GOODS_CHANGE_TYPE.random_box);
        }
        if (box.startScene == this.areaId && StringUtil.isNotEmpty(box.startPoint)) {
            JobFactory.addDelayJob(() -> newRandomBox(box), (box.refreshTime * 1000));
        }
    }


    public void onKillBoss(String playerId) {
    }


    public void onBattleReport(List<DamageHealVO> datas) {
    }


    public AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        AreaItem areaItem = this.items.get(itemId);
        if (areaItem != null && (areaItem.bindPlayers == null || areaItem.bindPlayers.containsKey(playerId) || System.currentTimeMillis() - areaItem.createTime > GlobalConfig.itemdrop_lock_lifeTime)) {
            Actor actor = getActor(playerId);
            if (actor == null || !actor.profitable) {
                Out.debug(new Object[]{playerId, "当前不可拾取", itemId});
                return null;
            }
            WNPlayer player = getPlayer(playerId);

            this.items.remove(itemId);
            Out.debug(new Object[]{getClass(), player.getName(), " onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard)});
            int groupCount = areaItem.item.itemDb.groupCount;
            onFreedomPickItem(player, areaItem.item, isGuard);
            areaItem.item.setGroup(groupCount);
            if (areaItem.dropPlayer != null) {
                onPickPlayerDropItem(player, areaItem);
            } else {
                onPickMonsterDropItem(player, areaItem);
            }
            return areaItem;
        }
        return null;
    }


    public void onFreedomPickItem(WNPlayer player, NormalItem item, boolean isGuard) {
        if (player.isProxy()) {
            player.onProxyEvent(13, body -> {
                body.writeString(Utils.serialize(item.itemDb));
                body.writeBoolean(isGuard);
            });
            return;
        }
        Out.debug(new Object[]{"onFreedomPickItem playerId:", player.getName(), "itemId:", item.itemDb.id, " isbind:", Boolean.valueOf(item.isBinding())});
        boolean canAutoMelt = (isGuard && item.isEquip()) ? autoMelt(player, (NormalEquip) item) : false;
        if (!canAutoMelt) {

            if (!player.getWnBag().testEmptyGridLarge(1)) {
                return;
            }

            boolean isSilient = isGuard;
            player.getWnBag().addEntityItem(item, Const.GOODS_CHANGE_TYPE.monsterdrop, null, false, isSilient);
            FinishPickItem data = item.toJSON4PickItemBatterServer();

            if (isGuard) {
                player.getWnBag().testEmptyGridLarge(1);
            }
            Out.debug(new Object[]{getClass(), "onFinishPickItem:", data});
            getXmdsManager().onFinishPickItem(player.getId(), JSON.toJSONString(data));
        }
    }


    protected void onPickPlayerDropItem(WNPlayer player, AreaItem itemInfo) {
        WNPlayer dropPlayer = itemInfo.dropPlayer;
        if (dropPlayer != null && itemInfo.item.prop.qcolor >= Const.ItemQuality.PURPLE.getValue()) {
            NormalItem item = itemInfo.item;
            float dropX = itemInfo.dropX;
            float dropY = itemInfo.dropY;
            Out.debug(new Object[]{getClass(), "玩家 ", player.getName(), "拾起了物品", item.itemDb.id});
            Map<String, Object> datatmp = new HashMap<>(6);
            Map<String, Object> data = new HashMap<>(6);

            datatmp.put("MsgType", Integer.valueOf(3));
            datatmp.put("s2c_playerId", player.getId());
            datatmp.put("s2c_name", player.getName());
            datatmp.put("s2c_level", Integer.valueOf(player.getLevel()));
            datatmp.put("s2c_pro", Integer.valueOf(player.getPro()));

            String str1 = LangService.getValue("GREEN_LINK") + "在";
            str1 = str1.replace("{b}", JSON.toJSONString(datatmp));
            str1 = str1.replace("{a}", player.getName());
            datatmp.clear();
            datatmp.put("MsgType", Integer.valueOf(6));
            data.put("areaId", Integer.valueOf(this.areaId));
            data.put("targetX", Float.valueOf(dropX));
            data.put("targetY", Float.valueOf(dropY));
            datatmp.put("data", data);

            String str2 = LangService.getValue("GREEN_LINK") + "拾起了";
            str2 = str2.replace("{b}", JSON.toJSONString(datatmp));
            str2 = str2.replace("{a}", this.prop.name + "(" + dropX + "," + dropY + ")");

            datatmp.clear();
            datatmp.put("MsgType", Integer.valueOf(3));
            datatmp.put("s2c_playerId", dropPlayer.getId());
            datatmp.put("s2c_name", dropPlayer.getName());
            datatmp.put("s2c_level", Integer.valueOf(dropPlayer.getLevel()));
            datatmp.put("s2c_pro", Integer.valueOf(dropPlayer.getPro()));

            String str3 = LangService.getValue("GREEN_LINK") + "的";
            str3 = str3.replace("{b}", JSON.toJSONString(datatmp));
            str3 = str3.replace("{a}", dropPlayer.getName());

            datatmp.clear();
            datatmp.put("MsgType", Integer.valueOf(1));
            datatmp.put("Id", item.itemDb.id);
            datatmp.put("PlayerId", dropPlayer.getId());
            datatmp.put("Name", item.prop.name);
            datatmp.put("Quality", Integer.valueOf(item.itemDb.groupCount));
            datatmp.put("TemplateId", item.itemDb.code);

            String str4 = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
            str4 = str4.replace("{b}", JSON.toJSONString(datatmp));
            str4 = str4.replace("{a}", item.prop.name + "×" + item.itemDb.groupCount);

            String content = str1 + str2 + str3 + str4;
            ChatHandler.OnChatPush.Builder msg = MessageUtil.createChatMsg(player, content, Const.CHAT_SCOPE.SYSTEM, (item.prop.qcolor >= Const.ItemQuality.ORANGE.getValue()) ? Const.TipsType.BLACK : Const.TipsType.NORMAL);
            GWorld.getInstance().broadcast((Message) new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage) msg.build()), this.logicServerId);
        }
    }


    protected void onPickMonsterDropItem(WNPlayer player, AreaItem itemInfo) {
        int pickItemQcolor = GlobalConfig.World_Boss_Pick_ItemQcolor;
        if (itemInfo.monsterId != 0 && itemInfo.item.prop.qcolor >= pickItemQcolor) {
            MonsterBase monsterProp = MonsterConfig.getInstance().get(itemInfo.monsterId);
            if (monsterProp != null) {
                NormalItem item = itemInfo.item;
                int index = Utils.random(1, 3);
                String content = LangService.getValue("MONSTER_BOSS_PICK_ITEM_MESSAGE" + index);
                content = content.replace("{mapName}", getSceneName());
                String strData = MessageUtil.getPlayerNameColor(player.getName(), player.getPro());
                content = content.replace("{playerName}", strData);
                String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
                content = content.replace("{monsterName}", monsterName);
                Map<String, Object> datatmp = new HashMap<>();
                datatmp.put("MsgType", Integer.valueOf(1));
                datatmp.put("Id", item.itemDb.id);
                datatmp.put("Name", item.prop.name);
                datatmp.put("Quality", Integer.valueOf(item.itemDb.groupCount));
                datatmp.put("TemplateId", item.itemDb.code);
                String strItem = LangService.getValue(MessageUtil.getColorLink(item.getQLevel()));
                strItem = strItem.replace("{b}", JSON.toJSONString(datatmp));
                strItem = strItem.replace("{a}", item.prop.name + "×" + item.itemDb.groupCount);

                content = content.replace("{item}", strItem);

                String finalcontent = content;
                GWorld.getInstance().ansycExec(() -> {
                    if (item.prop.qcolor >= Const.ItemQuality.GREEN.getValue()) {
                        for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                            ((WNPlayer) p).sendSysTip(finalcontent, Const.TipsType.ROLL);
                        }
                        MessageUtil.sendRollChat(GWorld.__SERVER_ID, finalcontent, Const.CHAT_SCOPE.SYSTEM);
                    }
                });
            }
        }
    }


    public void onGameOver(JSONObject event) {
    }


    public void addUnitsToArea(List<MonsterUnit> data) {
        if (data.size() > 0) {
            GWorld.getInstance().ansycExec(() -> getXmdsManager().addUnits(this.instanceId, JSON.toJSONString(data)));
        }
    }


    public void createMonster(List<Integer> data, boolean bInit) {
        if (data.size() == 0) {
            return;
        }
        List<MonsterUnit> monsterData = new ArrayList<>();
        synchronized (this.aliveBoss) {
            for (Iterator<Integer> iterator = data.iterator(); iterator.hasNext(); ) {
                int id = ((Integer) iterator.next()).intValue();
                GameData.MonsterRefreshs.values().forEach(co -> {
                    if (co.iD == id && co.mapID == this.areaId) {
                        MonsterUnit md = new MonsterUnit();

                        md.id = co.monsterID;

                        md.force = Const.AreaForce.MONSTER.value;

                        md.flag = co.getRefreshPoint();
                        md.autoGuard = true;
                        md.unique = true;
                        monsterData.add(md);
                        if (!this.aliveBoss.contains(Integer.valueOf(id))) {
                            this.aliveBoss.add(Integer.valueOf(id));
                        }
                        Out.info(new Object[]{"addUnitsToArea:", this.prop.name, ",", Integer.valueOf(this.areaId), ",", Integer.valueOf(co.monsterID), ",", co.getRefreshPoint()});
                    }
                });
            }

        }
        if (monsterData.size() > 0) {
            addUnitsToArea(monsterData);
        }
    }


    public void isSpecialItem(WNPlayer player, NormalItem item) {
        if (item.prop.qcolor >= Const.ItemQuality.ORANGE.getValue()) {
            String link = ChannelUtil.setItemInfo(item);
            String key = MessageUtil.getColorLink(item.prop.qcolor);
            String str = LangService.getValue(key);
            str = str.replace("{b}", link);
            str = str.replace("{a}", item.prop.name);

            String playerName = MessageUtil.getPlayerNameColor(player.getName(), player.player.pro);
            String final_str = playerName + "获得" + str;

            DaoYouPO daoYou = DaoYouService.getInstance().getDaoYou(player.getId());
            if (daoYou != null) {
                DaoYouService.getInstance().addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), "", daoYou, final_str, new Object[0]);
            }
        }
    }


    public boolean isUseTC() {
        return true;
    }


    public void removeAliveBoss(Integer monsterId, String refreshPoint) {
        List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t ->
                (t.monsterID == monsterId.intValue() && t.mapID == this.areaId && t.containsRefreshPoint(refreshPoint)));


        if (!refreshProps.isEmpty()) {
            MonsterRefreshCO refresh = (MonsterRefreshCO) refreshProps.get(0);
            if (this.aliveBoss.remove(Integer.valueOf(refresh.iD))) {
                Out.debug(new Object[]{"成功移除还活着的BOSS, monsterId=", monsterId});
            }
        }
    }


    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        Out.debug(new Object[]{player.getName(), " kill ", Integer.valueOf(monsterId)});
        MonsterBase monsterProp = MonsterConfig.getInstance().get(monsterId);
        if (monsterProp == null) {
            Out.warn(new Object[]{"onMonsterDead can not get prop from monsterProps:", Integer.valueOf(monsterId)});

            return;
        }
        CharacterLevelCO charactorProp = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(player.getLevel()));
        int playerLevelUpExp = charactorProp.experience;

        List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t ->
                (t.monsterID == monsterId && t.mapID == this.areaId && t.containsRefreshPoint(refreshPoint)));


        List<NormalItem> list_announce_item = new ArrayList<>();


        Map<String, WNPlayer> sharedDropPlayers = new HashMap<>(5);
        Map<String, WNPlayer> sharedExpPlayers = new HashMap<>(5);
        boolean canFightLevelDrop = player.fightLevelManager.canDrop(monsterId, this);
        boolean canNormapDrop = player.dropManager.canDrop(monsterId, this);
        if (canFightLevelDrop && canNormapDrop) {
            sharedDropPlayers.put(player.getId(), player);
            sharedExpPlayers.put(player.getId(), player);
        } else if (canFightLevelDrop) {
            sharedExpPlayers.put(player.getId(), player);
        }

        int teamExpAdd = 0;
        if (teamSharedIdList != null) {
            teamExpAdd = TeamUtil.getTeamExpAdd(teamSharedIdList.size());
            teamSharedIdList.forEach(teamSharedId -> {
                Actor actor = getActor((String) teamSharedId);
                if (actor != null && actor.profitable) {
                    WNPlayer bindPlayer = getPlayer((String) teamSharedId);
                    if (bindPlayer != null) {
                        boolean canFightLevelDropOther = bindPlayer.fightLevelManager.canDrop(monsterId, this);
                        boolean canNormapDropOther = bindPlayer.dropManager.canDrop(monsterId, this);
                        if (canFightLevelDropOther && canNormapDropOther) {
                            sharedDropPlayers.put(bindPlayer.getId(), bindPlayer);
                            sharedExpPlayers.put(bindPlayer.getId(), bindPlayer);
                        } else if (canFightLevelDropOther) {
                            sharedExpPlayers.put(bindPlayer.getId(), bindPlayer);
                        }
                    }
                }
            });
        }
        if (sharedExpPlayers.size() > 0) {
            addExp(player, sharedExpPlayers.values(), attackType, monsterProp, level, teamExpAdd);
        }

        if (!isUseTC()) {
            return;
        }


        Map<String, WNPlayer> bindPlayers = new HashMap<>(5);
        if (player.fightLevelManager.canDrop(monsterId, this) && player.dropManager.canDrop(monsterId, this)) {
            bindPlayers.put(player.getId(), player);
        }

        if (monsterProp.type >= 4 && isNormal()) {
            BILogService.getInstance().ansycReportKillBoss(player.getPlayer(), this.sceneType, monsterId);
            player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.AREA_BOSS_KILL_COUNT, new Object[0]);
        }

        Collection<String> teamMembers = player.getTeamMembers();
        if (teamMembers != null) {
            teamExpAdd = TeamUtil.getTeamExpAdd(teamMembers.size());
            for (String playerId : teamMembers) {
                Actor actor = getActor(playerId);

                if (actor == null || !actor.profitable)
                    continue;
                WNPlayer bindPlayer = getPlayer(playerId);
                if (bindPlayer != null && bindPlayer != player && bindPlayer.fightLevelManager.canDrop(monsterId, this) && bindPlayer.dropManager.canDrop(monsterId, this)) {
                    bindPlayers.put(bindPlayer.getId(), bindPlayer);

                    if (monsterProp.type >= 4 && isNormal()) {
                        BILogService.getInstance().ansycReportKillBoss(bindPlayer.getPlayer(), this.sceneType, monsterId);
                        bindPlayer.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.AREA_BOSS_KILL_COUNT, new Object[0]);
                    }
                }
            }
        }


        if (atkAssistantList != null) {
            for (Object o : atkAssistantList) {
                String playerId = (String) o;
                if ((teamMembers != null && teamMembers.contains(playerId)) || playerId.equals(player.player.id)) {
                    continue;
                }
                WNPlayer bindPlayer = getPlayer(playerId);
                if (bindPlayer == null || bindPlayer.area == null) {
                    continue;
                }
                if (bindPlayer.area.areaId == this.areaId) {
                    bindPlayer.dropManager.sendJoinReward(monsterId, monsterProp.name, refreshProps);

                    if (monsterProp.type >= 4 && isNormal()) {
                        BILogService.getInstance().ansycReportKillBoss(bindPlayer.getPlayer(), this.sceneType, monsterId);
                    }
                }
            }
        }

        if (bindPlayers.size() == 0 && sharedDropPlayers.size() == 0) {
            return;
        }

        List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();


        Map<Integer, String> tcMap = monsterProp.firstTcMap;
        String tcCode = tcMap.get(Integer.valueOf(player.getPro()));
        if (StringUtil.isNotEmpty(tcCode)) {
            List<Integer> firstKillMonsterIds = player.playerAttachPO.firstKillMonsterIds;
            if (firstKillMonsterIds.contains(Integer.valueOf(monsterId))) {
                tcCode = monsterProp.tc;
            } else {
                player.playerAttachPO.addFirstMonsterId(monsterId);
            }
        } else {
            tcCode = monsterProp.tc;
        }

        boolean over = false;
        boolean isTeamTc = false;
        while (true) {
            if (StringUtil.isNotEmpty(tcCode)) {
                List<NormalItem> dropItems = ItemUtil.createItemsByRealTC(tcCode, player.getLevel());
                if (refreshProps.size() > 0) {
                    list_announce_item.addAll(dropItems);
                }
                if (this.pointItems == null) {
                    this.pointItems = new HashMap<>();
                }
                for (NormalItem dropItem : dropItems) {
                    if (dropItem.isVirtQuest()) {
                        for (WNPlayer belongPlayer : bindPlayers.values()) {
                            Actor actor = getActor(belongPlayer.getId());
                            if (actor == null || !actor.profitable) {
                                continue;
                            }
                            belongPlayer.onEvent(new TaskEvent(Const.EventType.collect, new Object[]{dropItem.itemDb.code, Integer.valueOf(dropItem.itemDb.groupCount)}));
                        }
                        continue;
                    }
                    if (dropItem.isVirtual()) {
                        VirtualItem virItem = (VirtualItem) dropItem;
                        if ("gold".equals(dropItem.itemDb.code)) {
                            virItem.dropResetWorth(level, monsterProp.goldPerMonLv, bindPlayers.size());
                        } else if ("exp".equals(dropItem.itemDb.code)) {
                            virItem.dropResetWorth(level, monsterProp.expRatio, playerLevelUpExp);
                        }
                        int originWorth = virItem.getWorth();
                        for (WNPlayer belongPlayer : bindPlayers.values()) {
                            Actor actor = getActor(belongPlayer.getId());
                            if (actor == null || !actor.profitable) {
                                continue;
                            }
                            if ("gold".equals(dropItem.itemDb.code)) {
                                int extGold = belongPlayer.getBtlExdGold();
                                extGold += belongPlayer.getGuildExdGold();
                                virItem.addWorth(originWorth * extGold / 10000);
                                virItem.addWorth((int) (virItem.getWorth() * belongPlayer.vipManager.getExtGoldRatio()));
                            } else if ("exp".equals(dropItem.itemDb.code)) {

                                int exdExp = belongPlayer.bufferManager.getBuffAttrValue("ExdExp");

                                exdExp += belongPlayer.getGuildExdExp();

                                virItem.addWorth(originWorth * exdExp / 10000);
                            }

                            if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
                                virItem.setWorth(belongPlayer.illusionManager.addAward(dropItem.itemDb.code, virItem.getWorth()));
                            }
                            addVirtureItem(belongPlayer, dropItem, Const.GOODS_CHANGE_TYPE.monsterdrop);
                            virItem.setWorth(originWorth);
                        }
                        continue;
                    }
                    Set<String> team = player.getTeamMembers();
                    if (isTeamTc && team != null && getCurAreaMember(player) > 1 && dropItem.getQLevel() >= GlobalConfig.Dis_Roll_quality) {

                        PointItem pointItem = new PointItem(dropItem.itemCode(), dropItem.getNum(), getSceneType());
                        pointItem.bindTeam(player);
                        this.pointItems.put(pointItem.id, pointItem);
                        Out.debug(new Object[]{"======================pointItem add ", pointItem.id, " :", pointItem.itemCode});
                        continue;
                    }
                    AreaItem areaItem = new AreaItem(dropItem);
                    areaItem.bindPlayers = bindPlayers;
                    areaItem.monsterId = monsterId;


                    this.items.put(dropItem.itemDb.id, areaItem);
                    itemsPayLoad.add(dropItem.toJSON4BatterServer(bindPlayers.keySet(), Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, false));
                }


                sendThrowPointItemListPush(player, monsterId);
            }
            if (over)
                break;
            tcCode = monsterProp.teamTc;
            isTeamTc = true;
            over = true;
        }

        tcCode = (String) monsterProp.personTcMap.get(Integer.valueOf(player.getPro()));
        if (StringUtil.isNotEmpty(tcCode)) {
            Set<String> team = player.getTeamMembers();
            for (Map.Entry<String, Actor> entry : this.actors.entrySet()) {
                if (!((Actor) entry.getValue()).profitable) {
                    continue;
                }
                WNPlayer member = getPlayer(entry.getKey());
                if (((team == null || member == null || !team.contains(member.getId())) && member != player) ||
                        !member.fightLevelManager.canDrop(monsterId, this) || !member.dropManager.canDrop(monsterId, this)) {
                    continue;
                }
                List<NormalItem> dropItems = ItemUtil.createItemsByRealTC(tcCode, player.getLevel());
                if (refreshProps.size() > 0) {
                    list_announce_item.addAll(dropItems);
                }
                BattleHandler.ItemDropPush.Builder push = BattleHandler.ItemDropPush.newBuilder();
                for (NormalItem dropItem : dropItems) {
                    if (dropItem.isVirtQuest()) {
                        member.onEvent(new TaskEvent(Const.EventType.collect, new Object[]{dropItem.itemDb.code, Integer.valueOf(dropItem.itemDb.groupCount)}));
                        continue;
                    }
                    if (dropItem.isVirtual()) {
                        VirtualItem virItem = (VirtualItem) dropItem;
                        if ("gold".equals(dropItem.itemDb.code)) {
                            virItem.dropResetWorth(level, monsterProp.goldPerMonLv, bindPlayers.size());
                            int extGold = member.getBtlExdGold();
                            extGold += member.getGuildExdGold();
                            virItem.addWorth((int) Math.floor((dropItem.getWorth() * extGold / 10000)));
                            virItem.addWorth((int) (virItem.getWorth() * member.vipManager.getExtGoldRatio()));
                        } else if ("exp".equals(dropItem.itemDb.code)) {
                            virItem.dropResetWorth(level, monsterProp.expRatio, playerLevelUpExp);
                            int exdExp = member.bufferManager.getBuffAttrValue("ExdExp");
                            exdExp += member.getGuildExdExp();
                            virItem.addWorth((int) Math.floor((dropItem.getWorth() * exdExp / 10000)));
                        }

                        if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
                            virItem.setWorth(member.illusionManager.addAward(dropItem.itemDb.code, virItem.getWorth()));
                        }
                        addVirtureItem(member, dropItem, Const.GOODS_CHANGE_TYPE.monsterdrop);
                        continue;
                    }
                    BattleHandler.ItemDrop.Builder item = dropItem.toProto4Client();
                    item.setLifeTime(1000);
                    push.addItems(item);
                    boolean canAutoMelt = dropItem.isEquip() ? autoMelt(member, (NormalEquip) dropItem) : false;
                    if (!canAutoMelt) {
                        if (!member.bag.testAddCodeItem(dropItem.itemCode(), dropItem.getNum())) {
                            if (member.playerTempData.sendMailItemNum < 50) {
                                member.playerTempData.sendMailItemNum++;
                                boolean bool = member.illusionManager.addItemNum(this, dropItem.itemCode(), dropItem.getNum());
                                if (bool) {
                                    member.bag.addEntityItemMail(dropItem, Const.GOODS_CHANGE_TYPE.fight_level, "Bag_full_common");
                                }
                            }

                            continue;
                        }
                        boolean canDrop = member.illusionManager.addItemNum(this, dropItem.itemCode(), dropItem.getNum());
                        if (canDrop) {
                            member.bag.addEntityItemMail(dropItem, Const.GOODS_CHANGE_TYPE.fight_level, "Bag_full_common");
                        }
                    }
                }


                if (push.getItemsCount() > 0) {
                    push.setX(Math.round(x * 100.0F));
                    push.setY(Math.round(y * 100.0F));
                    member.receive("area.battlePush.itemDropPush", (GeneratedMessage) push.build());
                }
            }
        }


        for (WNPlayer p : sharedDropPlayers.values()) {
            p.fightLevelManager.onBossDead(monsterId, this);
        }
        if (this.sceneType == Const.SCENE_TYPE.NORMAL.getValue()) {
            for (WNPlayer p : sharedDropPlayers.values()) {
                p.dropManager.onBossDead(monsterId);
            }
        }

        if (refreshProps.size() > 0) {
            MonsterRefreshCO refresh = (MonsterRefreshCO) refreshProps.get(0);

            for (String playerId : this.actors.keySet()) {
                WNPlayer _player = getPlayer(playerId);

                if (_player != null && refresh.useType == 1) {

                    _player.dailyActivityMgr.onEvent(Const.DailyType.ILLSION_BOSS, "0", 1);

                    _player.achievementManager.onKillBoss(1);
                }
            }
            List<NormalItem> list_announce_temp = new ArrayList<>();
            for (NormalItem item : list_announce_item) {
                if (item.isVirtQuest()) {
                    continue;
                }
                if (item.getQLevel() < Const.ItemQuality.PURPLE.getValue()) {
                    continue;
                }
                list_announce_temp.add(item);
            }
            if (refresh.msgSend > 0 && list_announce_temp.size() > 0) {
                String msg = null;
                StringBuffer str_item = new StringBuffer();
                int count = 0;
                for (NormalItem item : list_announce_temp) {
                    count++;
                    str_item.append(ChannelUtil.getChatLinkItem(item));
                    str_item.append("*" + item.getNum());
                    if (count < list_announce_temp.size()) {
                        str_item.append("、 ");
                    }
                }
                if (bindPlayers.size() > 1) {
                    msg = LangService.getValue("MONSTER_BOSS_KILLED_TEAM");
                    StringBuffer playerName = new StringBuffer();
                    count = 0;
                    for (WNPlayer p : bindPlayers.values()) {
                        count++;
                        if (p == null)
                            continue;
                        playerName.append(MessageUtil.getPlayerNameColor(p.getName(), p.getPro()));
                        if (count < bindPlayers.size()) {
                            playerName.append("、 ");
                        }
                    }
                    msg = msg.replace("{0}", playerName.toString());
                    MapBase areaProp = AreaUtil.getAreaProp(this.areaId);
                    msg = msg.replace("{1}", areaProp.name);
                    String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
                    msg = msg.replace("{2}", monsterName);
                    msg = msg.replace("{3}", str_item.toString());
                } else {
                    msg = LangService.getValue("MONSTER_BOSS_KILLED_ONE");
                    String strData = MessageUtil.getPlayerNameColor(player.getName(), player.getPro());
                    msg = msg.replace("{0}", strData);
                    MapBase areaProp = AreaUtil.getAreaProp(this.areaId);
                    msg = msg.replace("{1}", areaProp.name);
                    String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
                    msg = msg.replace("{2}", monsterName);
                    msg = msg.replace("{3}", str_item.toString());
                }

                ChatHandler.OnChatPush.Builder chat = MessageUtil.createChatMsg(player, msg, Const.CHAT_SCOPE.SYSTEM, Const.TipsType.NORMAL);
                GWorld.getInstance().broadcast((Message) new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage) chat.build()), this.logicServerId);
            }
        }

        if (itemsPayLoad.size() > 0) {

            String data = Utils.toJSON(new Object[]{"pos", Utils.ofMap(new Object[]{"x", Float.valueOf(x), "y", Float.valueOf(y)}), "items", itemsPayLoad}).toJSONString();
            Out.debug(new Object[]{"onMonsterDead drops :", data});
            getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
        }
    }


    public void benifitTreasure(String playerId, int monsterId) {
    }


    public boolean benifitable(String playerId, int monsterId) {
        return true;
    }


    public void boxTeamTC(WNPlayer player, String tc) {
        if (this.pointItems == null) {
            this.pointItems = new HashMap<>();
        }
        List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(tc);
        for (NormalItem dropItem : dropItems) {
            if (getCurAreaMember(player) > 1 && dropItem.getQLevel() >= GlobalConfig.Dis_Roll_quality) {
                PointItem pointItem = new PointItem(dropItem.itemCode(), dropItem.getNum(), getSceneType());
                pointItem.bindTeam(player);
                this.pointItems.put(pointItem.id, pointItem);
                continue;
            }
            player.bag.addCodeItemMail(dropItem.itemCode(), dropItem.getNum(), null, Const.GOODS_CHANGE_TYPE.random_box, "Bag_full_common");
        }


        sendThrowPointItemListPush(player, 0);
    }


    public void boxNormalTC(WNPlayer player, String tc, int x, int y) {
        List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();

        Map<String, WNPlayer> bindPlayers = new HashMap<>(5);

        for (String playerId : this.actors.keySet()) {
            WNPlayer actor = getPlayer(playerId);
            if (actor != null) {
                bindPlayers.put(playerId, actor);
            }
        }

        List<NormalItem> dropItems = ItemUtil.createItemsByTcCode(tc);
        for (NormalItem dropItem : dropItems) {
            AreaItem areaItem = new AreaItem(dropItem);
            areaItem.bindPlayers = bindPlayers;
            areaItem.monsterId = 0;
            this.items.put(dropItem.itemDb.id, areaItem);
            itemsPayLoad.add(dropItem.toJSON4BatterServer(bindPlayers.keySet(), Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, false));
        }
        if (itemsPayLoad.size() > 0) {

            String data = Utils.toJSON(new Object[]{"pos", Utils.ofMap(new Object[]{"x", Integer.valueOf(x), "y", Integer.valueOf(y)}), "items", itemsPayLoad}).toJSONString();
            Out.debug(new Object[]{"onMonsterDead drops :", data});
            getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
        }
    }


    private int getCurAreaMember(WNPlayer player) {
        if (player == null)
            return 0;
        Set<String> team = player.getTeamMembers();
        if (team == null)
            return 0;
        int currentMember = 0;
        for (String playerId : team) {
            WNPlayer mPlayer = getPlayer(playerId);
            if (mPlayer != null && mPlayer.getArea() == this) {
                currentMember++;
            }
        }
        return currentMember;
    }

    protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) {
        player.getWnBag().addEntityItem(dropItem, type);
    }


    public String reliveData(ReliveType type) {
        return Utils.toJSONString(new Object[]{"type", Integer.valueOf(type.value), "qty", Integer.valueOf(0), "itemType", "diamond", "hp", Integer.valueOf(0), "mp", Integer.valueOf(0)});
    }

    public void recordDie(String playerId) {
        if (isNormal())
            return;
        if (this.diePlayers == null) {
            this.diePlayers = new ConcurrentSkipListSet<>();
        }
        this.diePlayers.add(playerId);
    }


    public PlayerHandler.ReliveResponse.Builder relive(String playerId, ReliveType reliveType) {
        PlayerHandler.ReliveResponse.Builder res = PlayerHandler.ReliveResponse.newBuilder();
        Actor actor = getActor(playerId);
        WNPlayer player = getPlayer(playerId);
        if (actor == null || player == null) {

            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("REVIVE_NOT_FIND_PLAYER"));
            return res;
        }

        if (this.prop.revivedMapID != 0) {
            AreaUtil.dispatchByAreaId(player, new AreaData(this.prop.revivedMapID, 0.0F, 0.0F), (Map<String, Object>) null);
        } else if (reliveType == ReliveType.CITY) {
            player.fightLevelManager.leaveDungeon(player, this);
            if (isEmpty()) {
                addCloseFuture();
            }
        } else {
            Out.debug(new Object[]{"复活：", reliveType});

            getXmdsManager().revivePlayer(playerId, reliveData(reliveType));
        }

        actor.relive();
        if (this.diePlayers != null && this.diePlayers.contains(playerId)) {
            this.diePlayers.remove(playerId);
        }
        res.setS2CCode(200);
        return res;
    }


    public int getPlayerNum() {
        return this.actors.size();
    }


    public WNPlayer getPlayer(String playerId) {
        return PlayerUtil.getOnlinePlayer(playerId);
    }


    public Actor getActor(String playerId) {
        return this.actors.get(playerId);
    }


    public boolean isAllActorDie() {
        for (Actor actor : this.actors.values()) {
            if (actor.alive) {
                return false;
            }
        }
        return true;
    }


    public void onPlayerEntered(WNPlayer player) {
        player.titleManager.checkInvalidRanks(true);


        player.taskManager.dealTaskEvent(Const.TaskType.reachPos, String.valueOf(this.areaId), 1);
        if ((this.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || this.sceneType == Const.SCENE_TYPE.LOOP.getValue() || this.sceneType == Const.SCENE_TYPE.GUILD_BOSS.getValue()) &&
                player.isRobot()) {
            JobFactory.addDelayJob(() -> onPlayerAutoBattle(player, true), 2000L);
        }


        player.activityManager.CheckLimitTimeGiftList();


        if (!isNormal()) {
            BILogService.getInstance().ansycReportEnteredArea(player.getPlayer(), this.sceneType, this.areaId);
        }
    }


    public void onPlayerLeaved(WNPlayer player) {
        Out.debug(new Object[]{player.getName(), " onPlayerLeaved: ", this.prop.name});
        if (!isNormal() && !noCloseIfNoPlayer() && isEmpty() && this.closeFuture == null) {
            addCloseFuture(66);
        }
    }


    public String toJSON4EnterScene(WNPlayer player) {
        return player.toJSON4EnterScene(this).toJSONString();
    }

    public void putActor(String playerId) {
        this.actors.put(playerId, new Actor());
    }

    public void removeActor(String playerId) {
        this.actors.remove(playerId);
        if (!isNormal() && isAllActorDie()) {
            AreaEvent.gameOverEventB2R(this, Utils.toJSON(new Object[]{"force", Integer.valueOf(-1)}));
        }
    }


    public void addPlayer(WNPlayer player) {
        String playerId = player.getId();
        setForce(player);
        player.setArea(this);
        Out.debug(new Object[]{player.getName(), "addPlayer begin enter scene id:", this.instanceId, " - ", this.prop.name, Integer.valueOf(this.lineIndex)});
        try {
            if (!this.actors.containsKey(playerId)) {
                this.hasPlayerEntered = true;
                this.actors.put(playerId, new Actor());
            }
            removeCloseFuture();
            if (player.isRobot()) {
                playerEnterRequest(player);
                JobFactory.addDelayJob(() -> player.onEndEnterScene(),

                        Utils.getSecMills(3, 5));
            }
        } catch (Exception error) {
            Out.error(new Object[]{"c# enter scene id: ", this.instanceId, " - ", this.prop.name, " error : ", error});
            throw error;
        }
    }


    public JSONObject getBornPlace(int templateID) {
        JSONObject data = Utils.toJSON(new Object[]{"x", Integer.valueOf(0), "y", Integer.valueOf(0)});
        String result = getXmdsManager().getBornPlace(this.instanceId, templateID);
        if (StringUtil.isNotEmpty(result)) {
            data = JSON.parseObject(result);
        }
        return data;
    }


    public GetPlayerData getPlayerData(String playerId) {
        String result = getXmdsManager().getPlayerData(playerId, true);
        return StringUtil.isEmpty(result) ? null : (GetPlayerData) JSON.parseObject(result, GetPlayerData.class);
    }


    public void syncPlayerHistoryData(WNPlayer player) {
        if (isNormal()) {
            GetPlayerData result = getPlayerData(player.getId());
            if (result != null) {
                Out.debug(new Object[]{this.instanceId, " syncPlayerHistoryData:", player.getName(), " x:", Float.valueOf(result.x), ", y:", Float.valueOf(result.y)});
                player.syncNowData(this.areaId, this.instanceId, result);
                player.syncHistoryData(this.areaId, this.instanceId, result);
            }
        }
    }


    public void removePlayer(WNPlayer player, boolean keepObject) {
        Out.debug(new Object[]{this.instanceId, " - ", this.prop.name, " removePlayer player :", player.getName()});
        String playerId = player.getId();
        Actor actor = getActor(playerId);
        if (actor != null) {
            playerLeaveRequest(player, keepObject);
            this.actors.remove(playerId);
            onPlayerLeaved(player);
            resetEmptyTime();
            RobotUtil.onRobotLeaderQuit(this, player);
        }
        if (!isNormal() && isAllActorDie() && !noCloseIfNoPlayer()) {
            AreaEvent.gameOverEventB2R(this, Utils.toJSON(new Object[]{"force", Integer.valueOf(-1)}));
        }
    }


    public void pushRelive(WNPlayer player) {
        if (player != null) {
            PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(player);
            WNNotifyManager.getInstance().pushRelive(player, data.build());
        }
    }


    public Object[] onPKPlayerDeadDrop(WNPlayer deadPlayer, WNPlayer hitPlayer, int pkValue, float x, float y) {
        Object[] result = new Object[2];
        if (deadPlayer == null || hitPlayer == null || deadPlayer.isProxy()) {
            return result;
        }
        List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
        List<NormalItem> items = deadPlayer.pkRuleManager.dropItemByKilled(pkValue, this);
        Out.debug(new Object[]{getClass(), " onPlayerDeadByPlayer items:", Integer.valueOf(items.size())});
        for (NormalItem dropItem : items) {
            dropItem.itemDb.gotTime = new Date();
            AreaItem areaItem = new AreaItem(dropItem);
            areaItem.dropPlayer = deadPlayer;
            areaItem.dropX = x;
            areaItem.dropY = y;
            this.items.put(dropItem.itemDb.id, areaItem);
            List<String> list_pids = new ArrayList<>();
            if (hitPlayer != null) {
                list_pids.add(hitPlayer.getId());
            }
            list_pids.add(deadPlayer.getId());
            ItemToBtlServerData itemData = dropItem.toJSON4BatterServer(list_pids, Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, true);
            itemsPayLoad.add(itemData);

            if (dropItem.getQLevel() >= Const.ItemQuality.ORANGE.getValue()) {
                StringBuffer sb = new StringBuffer();
                if (dropItem instanceof NormalEquip && dropItem.itemDb.speData != null) {
                    ItemSpeData speData = dropItem.itemDb.speData;
                    if (speData != null) {
                        sb.append(speData.baseAtts.toString());
                        if (speData.extAtts != null) {
                            sb.append("|||").append(speData.extAtts.toString());
                        }
                        if (speData.legendAtts != null) {
                            sb.append("|||").append(speData.legendAtts.toString());
                        }
                    }
                }
                PlayerUtil.bi(getClass(), Const.BiLogType.Pk, hitPlayer, new Object[]{deadPlayer.getId(), deadPlayer.getName(), dropItem.itemDb.id, dropItem.itemDb.code, sb.toString()});
            }
        }
        if (itemsPayLoad.size() > 0) {

            String data = Utils.toJSON(new Object[]{"pos", Utils.ofMap(new Object[]{"x", Float.valueOf(x), "y", Float.valueOf(y)}), "items", itemsPayLoad}).toJSONString();
            Out.debug(new Object[]{getClass(), " onPlayerDeadByPlayer:", data});
            getXmdsManager().onMonsterDiedDrops(this.instanceId, data);
        }

        result[0] = itemsPayLoad;
        result[1] = items;

        return result;
    }


    public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
        pushRelive(player);
    }


    public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
        if (deadPlayer == null || hitPlayer == null) {
            return;
        }
        Out.info(new Object[]{"玩家击杀玩家 Attack=", hitPlayer.getId(), "(", hitPlayer.getName(), "),Dead=", deadPlayer.getId(), "(", deadPlayer.getName(), ")"});
        pushRelive(deadPlayer);
        hitPlayer.onEvent(new TaskEvent(Const.TaskType.KILL_PLAYER, new Object[]{String.valueOf(deadPlayer.getPro()), Integer.valueOf(1)}));
    }


    protected void addExp(WNPlayer player, Collection<WNPlayer> belongPlayers, int attackType, MonsterBase monsterProp, int monsterLevel, int teamExpAdd) {
        int levelLimit = GlobalConfig.Exp_Monster_LevelLimit;
        PetNew pet = player.getFightingPet();
        if (pet != null && Math.abs(pet.po.level - monsterLevel) <= levelLimit) {
            if (attackType == 1) {
                int exp = monsterProp.baseExp * 2 * monsterLevel / (pet.po.level + monsterLevel);
                if (exp < 1)
                    exp = 1;
                pet.addExp(exp, true);
            } else {
                int ratioMaster = Integer.valueOf(((PetConfigExt) GameData.PetConfigs.get("PetExp.Percent.KillByMaster")).paramValue).intValue();
                int exp = monsterProp.baseExp * ratioMaster / 100 * 2 * monsterLevel / (pet.po.level + monsterLevel);
                if (exp < 1)
                    exp = 1;
                pet.addExp(exp, true);
            }
        }
        if (Math.abs(player.getLevel() - monsterLevel) > levelLimit) {
            int exp = 1;

            int exdExp = player.bufferManager.getBuffAttrValue("ExdExp");

            exdExp += player.getGuildExdExp();
            exp += exp * exdExp / 10000;


            if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
                exp = player.illusionManager.addAward("exp", exp);
            }

            List<NormalItem> expItems = ItemUtil.createItemsByItemCode("exp", exp);
            for (NormalItem item : expItems) {
                addVirtureItem(player, item, Const.GOODS_CHANGE_TYPE.monsterdrop);
            }
        }
        for (WNPlayer belongPlayer : belongPlayers) {
            if (belongPlayer == null)
                continue;
            int levelDiff = Math.abs(belongPlayer.getLevel() - monsterLevel);
            if (levelDiff > levelLimit)
                continue;
            int exp = monsterProp.baseExp * 2 * monsterLevel / (belongPlayer.getLevel() + monsterLevel);

            int teamExp = 0;
            if (teamExpAdd > 0) {
                teamExp = exp * (10000 + teamExpAdd) / 10000;
                if (teamExp < 0) {
                    teamExp = 0;
                }
            }
            exp = (int) (exp * (1.0F + belongPlayer.vipManager.getVipExpRatio()));

            exp += teamExp;

            if (this.sceneType == Const.SCENE_TYPE.ILLUSION.getValue()) {
                exp = belongPlayer.illusionManager.addAward("exp", exp);
            }
            List<NormalItem> expItems = ItemUtil.createItemsByItemCode("exp", exp);
            for (NormalItem item : expItems) {
                addVirtureItem(belongPlayer, item, Const.GOODS_CHANGE_TYPE.monsterdrop);
            }
        }
    }


    public boolean hasPlayer(String playerId) {
        return this.actors.containsKey(playerId);
    }

    public boolean isAllRobot() {
        for (String playerId : this.actors.keySet()) {
            TeamData.TeamMemberData teamMember = TeamService.getTeamMember(playerId);
            if (teamMember == null || !teamMember.robot) {
                return false;
            }
        }
        return true;
    }


    public boolean hasHighQualityItem() {
        for (AreaItem itemInfo : this.items.values()) {
            if (itemInfo.item.prop.qcolor >= GlobalConfig.Leave_Notice_Quality) {
                return true;
            }
        }
        return false;
    }


    public boolean canRebirth(String playerId) {
        return true;
    }


    public void receive(String route, GeneratedMessage msg) {
        receive((PomeloPush) new MessagePush(route, msg));
    }

    public void receive(PomeloPush push) {
        for (String rid : this.actors.keySet()) {
            WNPlayer player = getPlayer(rid);
            if (player != null) {
                player.receive((Message) push);
            }
        }
    }


    public boolean isKeepObject() {
        return !isOpenJoinTeam();
    }


    public boolean isOpenJoinTeam() {
        return isOpenJoinTeamArea();
    }


    public void onPlayerLogin(WNPlayer player) {
        player.nofitySuperScript();
        if (!isNormal() && (this.diePlayers == null || !this.diePlayers.contains(player.getId()))) {
            onPlayerAutoBattle(player, true);
        }
    }


    public void onPlayerLogout(WNPlayer player) {
        if (player.getTeamManager().getTeamMember() != null) {
            (player.getTeamManager().getTeamMember()).follow = false;
        }

        boolean keepObject = isKeepObject();
        if (keepObject && !isClose() &&
                !player.getTeamManager().isFollowLeader()) {
            onPlayerAutoBattle(player, true);
        }

        Actor actor = getActor(player.getId());
        if (actor != null) {
            if (!actor.alive) {
                recordDie(player.getId());
            }
            removePlayer(player, keepObject);
        }
    }

    public void onPlayerAutoBattle(WNPlayer player, boolean enable) {
        if (!isClose()) {
            String playerId = player.getId();

            getXmdsManager().autoBattle(this.instanceId, playerId, enable);
        }
    }

    protected PlayerHandler.PlayerRelivePush.Builder newPlayerRelivePush(WNPlayer player) {
        return newPlayerRelivePush(player, true);
    }


    protected PlayerHandler.PlayerRelivePush.Builder newPlayerRelivePush(WNPlayer player, boolean showBtn) {
        ResurrectionCO resurrection = (ResurrectionCO) GameData.Resurrections.get(Integer.valueOf(this.areaId));

        PlayerHandler.PlayerRelivePush.Builder data = PlayerHandler.PlayerRelivePush.newBuilder();
        data.setBtn(showBtn ? ReliveBtn.SHOW_CLICK.value : ReliveBtn.UN_SHOW.value);

        data.setCountDown(GlobalConfig.Group_Resurrection);
        data.setCbType(ReliveCB.RELIVE.value);
        data.setType(isNormal() ? ReliveOP.FIELD.value : ReliveOP.RELIVE.value);
        data.setOp(isNormal() ? ReliveUP.OK.value : ReliveUP.NO.value);
        int totalReliveNum = 3 + player.vipManager.getReliveNum();
        int nowReliveNum = totalReliveNum - (player.getReliveManager()).nowReliveNum;
        int cost = 5;
        if (resurrection != null) {
            if (resurrection.backResurrect != 1) {
                data.setCbType(ReliveCB.RELIVE.value);
                data.setType(ReliveOP.FIELD.value);
                data.setOp(ReliveUP.NO.value);
            } else if (!isNormal()) {
                data.setCbType(ReliveCB.LEAVE.value);
                data.setOp(ReliveUP.OK.value);
                data.setType(ReliveOP.LEAVE.value);
            }
            cost = resurrection.cost;
            if (!isNormal() && resurrection.resurrectNum > 0) {
                int currCount = resurrection.resurrectNum - player.getReliveManager().getReliveCount(this.areaId);
                if (currCount > 0) {
                    data.setType(ReliveOP.RELIVE.value);
                    data.setCbType(ReliveCB.RELIVE.value);
                    data.setOp(ReliveUP.NO.value);
                }
                data.setCurrCount(currCount);
                data.setTotalCount(resurrection.resurrectNum);
            }
            data.setCountDown(resurrection.autoResurrectTime);
            data.setCooltime(resurrection.resurrectCD);
            if (resurrection.lieDown == 1) {
                data.setCbType(ReliveCB.ICON.value);
            }
            if (resurrection.freeResurrect > 0) {
                nowReliveNum = 0;
            }
        }
        if (nowReliveNum > 0) {
            (player.getReliveManager()).payCost = 0;
            data.setPayConfirm(0);
            data.setCostStr(LangService.format("RELIVE_FREE", new Object[]{Integer.valueOf(nowReliveNum), Integer.valueOf(totalReliveNum)}));
        } else {
            if (-nowReliveNum > 0) {
                cost = -nowReliveNum * cost;
                cost = Math.min(cost, 50);
            }
            (player.getReliveManager()).payCost = cost;
            data.setPayConfirm((player.getReliveManager()).payConfirm);
            data.setCostStr(LangService.format("RELIVE_DIAMOND", new Object[]{Integer.valueOf(cost)}));
        }
        if (showBtn) {
            data.setBtnSafe(1);
            data.setBtnCity(1);
            data.setBtnCurr((getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) ? 0 : 1);
        }
        return data;
    }

    public boolean onCleanItem(AreaItem areaItem) {
        return true;
    }


    public ReliveType getReliveType() {
        return ReliveType.BORN;
    }

    public void onRobotQuit(int second) {
        for (String playerId : this.actors.keySet()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null && player.isRobot()) {
                JobFactory.addDelayJob(() -> player.fightLevelManager.leaveDungeon(player, this), (

                        Utils.getSecMills(3, second) / 2));
            }
        }
    }


    public void addCloseFuture() {
        addCloseFuture(this.prop.timeCount);
    }

    protected void addCloseFuture(int second) {
        try {
            if (this.closeFuture != null && !this.closeFuture.isDone()) {
                Out.info(new Object[]{getClass(), " more addCloseFuture!!!"});
                this.closeFuture.cancel(true);
            }
            onRobotQuit(second);
        } finally {
            this.closeFuture = JobFactory.addDelayJob(() -> {
                if (this.robotDisponseJob != null) {
                    this.robotDisponseJob.cancel(true);
                    this.robotDisponseJob = null;
                }
                AreaUtil.closeArea(this.instanceId);
            } ((second + 5) * 1000));
        }
    }


    public void removeCloseFuture() {
        if (this.closeFuture != null) {
            this.closeFuture.cancel(true);
            this.closeFuture = null;
        }
    }


    protected void onDailyActivity(WNPlayer player) {
    }


    public void onEndEnterScene(WNPlayer player) {
        if (this.diePlayers != null && this.diePlayers.contains(player.getId())) {
            pushRelive(player);
        }
        Out.info(new Object[]{"player true enter scene:sceneId=", Integer.valueOf(this.areaId), "instanceId:", this.instanceId, ",playerId=", player.getId()});
    }

    public void onUnitDead(JSONObject msg) {
        AreaEvent.unitDead(this, msg);
    }


    public void eatOrLostBuffer(WNPlayer player, String paramType, String paramData) {
        String tips = "";
        Map<String, Actor> actors = this.actors;
        if (paramType.equals("GetBuff")) {
            Actor actor = actors.get(player.getId());
            if (actor != null) {
                actor.buffers.add(paramData);
            }
            if (Integer.parseInt(paramData) == Const.Arena.ARENA_TIANSHEN.value) {
                tips = LangService.format("ARENA_TIANSHEN_BUFF", new Object[]{player.getName()});
                for (String tempPlayerId : actors.keySet()) {
                    WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
                    if (tempPlayer != null) {
                        MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
                    }
                }
            } else if (Integer.parseInt(paramData) == Const.Arena.ARENA_GREEDY.value) {
                tips = LangService.getValue("ARENA_GREEDY_BUFF");
                MessageUtil.sendSysTip(player, tips, Const.TipsType.NORMAL);
            } else if (Integer.parseInt(paramData) == Const.Arena.FIGHT_POWER_UP.value) {
                tips = LangService.getValue("BUFF_FIGHT_UP");
                MessageUtil.sendSysTip(player, tips, Const.TipsType.NORMAL);
            }
        } else if (paramType.equals("LoseBuff")) {
            Actor actor = actors.get(player.getId());
            if (actor != null) {
                actor.buffers.remove(paramData);
            }
        }
    }


    private class PointItem {
        String id;

        String itemCode;

        int num;

        boolean send2client;

        boolean get;
        Map<String, Integer> points;
        Set<String> bindPlayers;
        ScheduledFuture<?> schResult;
        int sceneTypeValue;

        PointItem(String itemCode, int num, int sceneTypeValue) {
            this.itemCode = itemCode;
            this.id = UUID.randomUUID().toString();
            this.num = num;
            this.sceneTypeValue = sceneTypeValue;
        }

        public void bindTeam(WNPlayer player) {
            Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
            this.bindPlayers = new HashSet<>((members == null) ? 1 : members.size());
            this.points = new HashMap<>((members == null) ? 1 : members.size());
            if (members != null) {
                this.bindPlayers.addAll(members.keySet());
            } else {
                this.bindPlayers.add(player.getId());
            }
        }
    }


    private void sendThrowPointItemListPush(WNPlayer player, int bossId) {
        if (this.pointItems.size() > 0) {
            int time = 30;
            BattleHandler.ThrowPointItemListPush.Builder builder = BattleHandler.ThrowPointItemListPush.newBuilder();
            builder.setS2CCode(200);
            builder.setTime(time);
            for (PointItem pointItem : this.pointItems.values()) {
                if (!pointItem.send2client) {
                    BattleHandler.PointItemView.Builder view = BattleHandler.PointItemView.newBuilder();
                    view.setId(pointItem.id);
                    view.setItemCode(pointItem.itemCode);
                    view.setNum(pointItem.num);
                    builder.addItems(view);

                    pointItem.send2client = true;
                }
            }
            MessagePush list = null;
            if (builder.getItemsCount() > 0) {
                list = new MessagePush("area.battlePush.throwPointItemListPush", (GeneratedMessage) builder.build());
            }
            Set<String> team = player.getTeamMembers();
            Set<String> toThrowPointResultTeam = new HashSet<>();

            for (Map.Entry<String, Actor> actorEntry : this.actors.entrySet()) {
                String teamPlayerId = actorEntry.getKey();
                Actor actor = actorEntry.getValue();
                WNPlayer teamPlayer = getPlayer(teamPlayerId);
                if (teamPlayer != null && actor.profitable && teamPlayer.fightLevelManager.canDrop(bossId, this) && teamPlayer.dropManager.canDrop(bossId, this) && list != null && team != null && team.contains(teamPlayerId)) {
                    teamPlayer.receive((Message) list);
                    toThrowPointResultTeam.add(teamPlayerId);
                }
            }

            for (PointItem item : this.pointItems.values()) {
                if (team != null && toThrowPointResultTeam.size() > 0 && item.schResult == null) {
                    item.schResult = JobFactory.addDelayJob(() -> {
                        Out.debug(new Object[]{"throw point timeout!!!"}, );
                        throwPointResult(item, item.id, toThrowPointResultTeam);
                    } (time * 1000));
                }
            }
        }
    }


    public void onRobotThrowPoint(WNPlayer player) {
        for (Iterator<PointItem> iterator = this.pointItems.values().iterator(); iterator.hasNext(); ) {
            PointItem pointItem = iterator.next();
            if (pointItem.bindPlayers.contains(player.getId())) {
                JobFactory.addDelayJob(() -> randomPoint(player, pointItem.id),

                        Utils.getSecMills(1, 5));
            }
        }

    }

    public int randomPoint(WNPlayer player, String id) {
        if (this.pointItems == null || !this.pointItems.containsKey(id))
            return 0;
        PointItem item = this.pointItems.get(id);
        Map<String, Integer> points = item.points;
        if (item.get || points.containsKey(player.getId()))
            return 0;
        int point = RandomUtil.getInt(100);

        for (Iterator<Integer> iterator = points.values().iterator(); iterator.hasNext(); ) {
            int p = ((Integer) iterator.next()).intValue();
            if (p == point) {
                if (point < 50) {
                    point += RandomUtil.getInt(3);
                    break;
                }
                point -= RandomUtil.getInt(3);

                break;
            }
        }


        points.put(player.getId(), Integer.valueOf(point));
        if (points.size() >= getPlayerNum()) {
            if (item.schResult != null) {
                item.schResult.cancel(true);
                item.schResult = null;
            }
            throwPointResult(item, id, (player != null) ? player.getTeamMembers() : null);
        }
        return point;
    }


    private void throwPointResult(PointItem item, String pointId, Set<String> team) {
        synchronized (item) {
            if (item.get)
                return;
            item.get = true;
        }
        StringBuilder content = new StringBuilder();
        DItemEquipBase equip = ItemConfig.getInstance().getItemProp(item.itemCode);

        String equipNmae = ItemUtil.getColorItemNameByQcolor(equip.qcolor, equip.name);
        Map<String, Integer> points = item.points;
        String rid = null;
        int tmpPoint = 0;


        boolean hasProFit = false;
        for (String playerId : item.bindPlayers) {
            PlayerPO playerPO = PlayerUtil.getPlayerBaseData(playerId);
            if (playerPO.pro == equip.Pro && points.containsKey(playerId)) {
                hasProFit = true;
            }
        }

        for (String playerId : item.bindPlayers) {
            PlayerPO playerPO = PlayerUtil.getPlayerBaseData(playerId);
            if (points.containsKey(playerId)) {
                int point = ((Integer) points.get(playerId)).intValue();
                content.append(LangService.format("TEAM_THROW_POINT", new Object[]{Integer.valueOf(point), playerPO.name})).append("<br/>");
                if (point > tmpPoint) {
                    if (!hasProFit) {
                        rid = playerId;
                        tmpPoint = point;
                        continue;
                    }
                    if (playerPO.pro == equip.Pro) {
                        rid = playerId;
                        tmpPoint = point;
                    }
                }
                continue;
            }
            content.append(LangService.format("TEAM_UNTHROW_POINT", new Object[]{playerPO.name})).append("<br/>");
        }


        WNPlayer member = (rid == null) ? null : getPlayer(rid);
        if (member == null) {
            List<String> list_profitable = new ArrayList<>();

            for (String _pId : this.actors.keySet()) {
                WNPlayer _player = getPlayer(_pId);
                if (this.actors.get(_pId) != null && ((Actor) this.actors.get(_pId)).profitable && _player != null && team.contains(_pId)) {
                    list_profitable.add(_pId);
                }
            }
            if (list_profitable.size() > 0) {
                int idx = RandomUtil.getIndex(list_profitable.size());
                member = getPlayer(list_profitable.get(idx));
            }
        }
        if (member != null) {
            BattleHandler.ThrowPointResultPush push = BattleHandler.ThrowPointResultPush.newBuilder().setS2CCode(200).setId(item.id).setName((member == null) ? "" : member.getName()).setItemCode(item.itemCode).setPoint(tmpPoint).setNum(item.num).build();

            WNPlayer player = member;
            JobFactory.addDelayJob(() -> {
                String itemLink = null;
                NormalItem newEquip = null;
                if (player != null) {
                    player.illusionManager.addItemNum(this, item.itemCode, 1);
                    if (player.getWnBag().testAddCodeItem(item.itemCode, 1, null, false)) {
                        newEquip = ItemUtil.createItemsByItemCode(item.itemCode, 1).get(0);
                        itemLink = ChannelUtil.getChatLinkItem(newEquip);
                        player.getWnBag().addEntityItem(newEquip, Const.GOODS_CHANGE_TYPE.RollPoint, null, false, false);
                    } else {
                        MailSysData mailData = new MailSysData("Bag_full_common");
                        mailData.attachments = new ArrayList();
                        MailData.Attachment attachment = new MailData.Attachment();
                        attachment.itemCode = item.itemCode;
                        attachment.itemNum = 1;
                        mailData.attachments.add(attachment);
                        MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.RollPoint);
                    }
                }
                if (itemLink != null) {
                    String title = LangService.format("TEAM_THROW_RESULT", new Object[]{equipNmae}) + "<br/>";
                    content.insert(0, title);
                    if (item != null) if (newEquip.isEquip()) {
                        content.append(LangService.format("TEAM_THROW_WIN_EQUIP", new Object[]{player.getName(), Integer.valueOf(1), ""})).append(itemLink);
                    } else {
                        content.append(LangService.format("TEAM_THROW_WIN", new Object[]{player.getName(), Integer.valueOf(item.num), ""})).append(itemLink);
                    }
                } else {
                    String title = LangService.format("TEAM_THROW_RESULT", new Object[]{equipNmae}) + "<br/>";
                    content.insert(0, title);
                    content.append(LangService.format("TEAM_THROW_WIN_EQUIP", new Object[]{player.getName(), Integer.valueOf(1), equipNmae}));
                }
                for (String playerId : item.bindPlayers) {
                    WNPlayer actor = getPlayer(playerId);
                    if (actor != null) {
                        actor.receive("area.battlePush.throwPointResultPush", (GeneratedMessage) push);
                        MessageUtil.sendChatMsgAsyn(actor, content.toString(), Const.CHAT_SCOPE.TEAM, Const.TipsType.NORMAL);
                        Out.debug(new Object[]{"==============", content});
                    }
                }
            } 0L);
        }


        this.pointItems.remove(pointId);
        Out.debug(new Object[]{"===============pointId removed:", pointId});
    }

    public void playerEnterRequest(WNPlayer player) {
        playerEnterRequest(player, toJSON4EnterScene(player));
    }

    public void playerEnterRequest(WNPlayer player, String enterSceneData) {
        getZoneManager().playerEnterRequest(player.getId(), this.instanceId, enterSceneData);
        Out.debug(new Object[]{"playerEnterRequest====================", player.getName(), "-", this.instanceId, "-", this.prop.name});
    }

    public void playerLeaveRequest(WNPlayer player, boolean keepObject) {
        getZoneManager().playerLeaveRequest(player.getId(), this.instanceId, keepObject);
        Out.debug(new Object[]{"playerLeaveRequest--------------------", player.getName(), "-", this.instanceId, "-", (player.getArea()).prop.name});
    }


    public void onReady(WNPlayer player) {
    }


    public AreaData getAreaData() {
        System.err.println("instanceId=" + this.instanceId);
        return new AreaData(this.areaId, this.instanceId);
    }


    public String toString() {
        return this.serverId + " :: " + this.prop.name + " : " + this.instanceId + " : " + this.actors.size();
    }
}


