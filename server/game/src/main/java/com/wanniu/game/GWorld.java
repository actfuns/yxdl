package com.wanniu.game;

import cn.qeng.common.login.TokenInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.message.BroadcastMessage;
import com.wanniu.core.game.protocol.PomeloHeader;
import com.wanniu.core.game.protocol.PomeloPacket;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.gm.GMClient;
import com.wanniu.core.gm.request.GMHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.login.AuthServer;
import com.wanniu.core.pay.PayClient;
import com.wanniu.core.pay.request.PayHandler;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.DateUtils;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.csharp.protocol.CSharpMessage;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.area.AreaMap;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.auction.AuctionDataManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.guildFort.GuildFortCenter;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.ProxyUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.WNProxy;
import com.wanniu.game.player.WNRobot;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.request.entry.LoginQueue;
import com.wanniu.game.request.prepaid.PaySuccessHandler;
import com.wanniu.game.revelry.RevelryManager;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMRequest;
import com.wanniu.gm.handler.GMBaseHandler;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.time.DateUtils;
import pomelo.area.PlayerHandler;


public class GWorld
        extends GGame {
    public static LocalDate OPEN_SERVER_DATE;
    public static int __ACROSS_SERVER_ID = __SERVER_ID;

    public static boolean __NEW = GConfig.getInstance().getBoolean("game.new", false);
    public static boolean __RECOMMEND = GConfig.getInstance().getBoolean("game.recommend", false);
    public static boolean __HOT = GConfig.getInstance().getBoolean("game.hot", false);

    public static int __AREA_ID = GConfig.getInstance().getInt("game.areaId", 0);

    public static String __SERVER_NAME = GConfig.getInstance().get("game.name");

    public static int __PLAYER_LIMIT = GConfig.getInstance().getInt("game.limit", 1000);

    public static int __SHOW = 2;


    public static LocalDateTime __EXTERNAL_TIME = LocalDateTime.now();

    public static boolean ROBOT = GConfig.getInstance().getBoolean("game.tool.debug", false);


    public static Set<Integer> sids = GConfig.getInstance().getSet("game.sid.list");

    public static boolean ROBOTS = true;

    public static final Map<String, WNRobot> Robots = new ConcurrentHashMap<>();
    public static final Map<String, WNProxy> Proxys = new ConcurrentHashMap<>();

    public static int ROBOT_MAX_LEVEL = 39;


    public void setOlAvgTime() {
    }


    static {
        instance = new GWorld();
    }

    public static GWorld getInstance() {
        return (GWorld) instance;
    }

    public boolean isOnline(String rid) {
        return (this.onlinePlayers.containsKey(rid) || Robots.containsKey(rid) || Proxys.containsKey(rid));
    }

    public boolean isLocal(String rid) {
        return (this.onlinePlayers.containsKey(rid) || this.waitPlayers.containsKey(rid) || Robots.containsKey(rid));
    }

    public WNPlayer getPlayer(String rid) {
        WNProxy wNProxy;
        WNPlayer player = (WNPlayer) super.getPlayer(rid);
        if (player == null) {
            WNRobot wNRobot = getRobot(rid);
            if (wNRobot == null) {
                wNProxy = getProxy(rid);
            }
        }
        return (WNPlayer) wNProxy;
    }

    public static WNRobot getRobot(String rid) {
        return Robots.get(rid);
    }

    public static WNProxy getProxy(String rid) {
        return Proxys.get(rid);
    }

    public PomeloResponse getErrResponse(Exception e) {
        Out.error(new Object[]{"处理逻辑异常.", e});
        return (PomeloResponse) new ErrorResponse(e.getMessage());
    }

    public void addPacket(Packet packet) {
        PomeloPacket pak = (PomeloPacket) packet;
        PomeloHeader header = pak.getHeader();
        if ("area.playerHandler.battleEventNotify".equals(header.route_s)) {
            CSharpClient.getInstance().dispatch(new CSharpMessage(pak));
        } else {
            putGlobalRoute(header.route_s, packet);
        }
    }

    public void broadcast(Message msg, int logicServerId) {
        broadcast(msg);
    }

    public void addClassByAnnotation(Class<?> clz) throws Exception {
        super.addClassByAnnotation(clz);
        if (clz.isAnnotationPresent((Class) GMEvent.class)) {
            GMRequest.addHandler((GMBaseHandler) clz.newInstance());
        } else if (clz.getSuperclass() == GMHandler.class) {
            GMClient.getInstance().registerHandler((GMHandler) clz.newInstance());
        }
    }


    protected String searchPath() {
        return super.searchPath() + ";" + GMRequest.class.getPackage().getName();
    }


    public void battleServerClose(String serverId) {
        AreaMap areas = AreaManager.getInstance().getAreaMap();
        for (Area area : areas.values()) {
            if (area.getServerId().equals(serverId)) {
                area.bsClose = true;
                AreaManager.getInstance().closeArea(area.instanceId);
                Out.info(new Object[]{serverId, " 战斗服关闭  : ", area.instanceId, " : ", Integer.valueOf(area.areaId), " : ", area.prop.name});
            }
        }
    }


    public void battleServerStart(String serverId) {
        AreaMap areas = AreaManager.getInstance().getAreaMap();
        for (Area area : areas.values()) {
            if (area.getServerId().equals(serverId)) {


                areas.remove(area.instanceId);
            }
        }
    }


    public void battleServerEvent(String eventType, String msg) {
        Out.debug(new Object[]{eventType, " : ", msg});
        switch (eventType) {
            case "areaEvent":
            case "zoneEvent":
                AreaManager.getInstance().areaBattleServerEvent(JSON.parseObject(msg));
                return;

            case "playerEvent":
                AreaManager.getInstance().playerBattleServerEvent(JSON.parseObject(msg));
                return;

            case "taskEvent":
                AreaManager.getInstance().taskBattleServerEvent(JSON.parseObject(msg));
                return;
        }
    }


    private JSONObject newServerJSON() {
        JSONObject json = new JSONObject();
        json.put("appId", Integer.valueOf(__APP_ID));
        json.put("logicServerId", Integer.valueOf(__SERVER_ID));
        json.put("acrossServerId", Integer.valueOf(__ACROSS_SERVER_ID));
        return json;
    }

    private void updateLoginState(int load) {
        JSONObject json = newServerJSON();
        json.put("type", Integer.valueOf(259));
        json.put("logicServerId", Integer.valueOf(__SERVER_ID));
        json.put("load", Integer.valueOf(load));
        AuthServer.publish(json);
    }


    public void onAfterStart() {
        super.onAfterStart();
        afterGame();
        if (!GConfig.getInstance().isEnableGm()) {
            syncServerInfo();
        }
    }

    public void syncServerInfo() {
        JSONObject json = newServerJSON();
        json.put("type", Integer.valueOf(257));
        json.put("proto", "game");
        json.put("name", __SERVER_NAME);
        json.put("areaId", Integer.valueOf(__AREA_ID));
        json.put("recommend", Boolean.valueOf(__RECOMMEND));
        json.put("new", Boolean.valueOf(__NEW));
        json.put("hot", Boolean.valueOf(__HOT));
        json.put("olLimit", Integer.valueOf(__PLAYER_LIMIT));
        json.put("show", Integer.valueOf(__SHOW));
        json.put("host", GConfig.getInstance().getGamePubHost());
        json.put("port", Integer.valueOf(GConfig.getInstance().getGamePort()));
        json.put("sidList", sids);
        AuthServer.publish(json);
    }


    private void afterGame() {
        PayClient.getInstance().registerHandler((PayHandler) new PaySuccessHandler());

        AreaManager.getInstance().init();


        JobFactory.addFixedRateJob(() -> {
            int onlineCount = getOnlineCount();
            updateLoginState(onlineCount);
            Out.info(new Object[]{"在线人数 : ", Integer.valueOf(this.onlinePlayers.size()), "/", Integer.valueOf(onlineCount), " - ", Integer.valueOf(this.waitPlayers.size())}, );
            LogReportService.getInstance().ansycReportOnline(this.onlinePlayers.size(), Robots.size());
        } 60000L, 60000L);


        JobFactory.addFixedRateJob(() -> BILogService.getInstance().ansycReportOnline(this.onlinePlayers.size()), 60000L, 300000L);
    }


    public void onCloseGame() {
        super.onCloseGame();
        updateLoginState(-1);
        AreaManager.getInstance().onCloseGame();
        PlayerPOManager.onCloseGame();
        GuildFortCenter.getInstance().onCloseGame();
        GuildDao.onCloseGame();
        ConsignmentLineService.getInstance().onCloseGame();
        AuctionDataManager.getInstance().onCloseGame();


        disponseRobots();
    }

    private void disponseRobots() {
        for (WNRobot robot : Robots.values()) {
            GameDao.freeName(robot.getName());
            GCache.expire(robot.getId(), 300);
            Out.info(new Object[]{"停机维护时，回收机器人资源 robotId=", robot.getId(), ",robotName=", robot.getName()});
        }
    }


    protected BroadcastMessage stopMessage() {
        return new BroadcastMessage() {
            protected void write() throws IOException {
                PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
                data.setS2CReasonType(Const.KickReason.SERVER_SHUT_DOWN.value);
                this.body.writeBytes(data.build().toByteArray());
            }


            public String getRoute() {
                return "area.playerPush.kickPlayerPush";
            }
        };
    }

    public void onRemoveWaitPlayer(GPlayer player) {
        WNPlayer wnPlayer = (WNPlayer) player;
        if (wnPlayer.soloManager.isBusy() || wnPlayer.arenaManager.isInArena()) {
            return;
        }

        Area area = wnPlayer.getArea();

        if (area != null && !area.isClose() && !area.isNormal()) {
            return;
        }

        super.onRemoveWaitPlayer(player);
    }

    public void onSessionClose(Channel channel) {
        LoginQueue.remove(channel);

        String token = (String) channel.attr(GGlobal.__KEY_TOKEN).get();
        if (token != null) {
            String uid = (String) channel.attr(GGlobal.__KEY_USER_ID).get();
            int second = 300;
            Attribute<Boolean> timeout = channel.attr(GGlobal.__KEY_SESSION_TIMEOUT);
            if (timeout.get() != null && ((Boolean) timeout.get()).booleanValue()) {
                second = 5400;
            }


            TokenInfo tokenInfo = (TokenInfo) channel.attr(GGlobal.__KEY_TOKEN_INFO).get();
            AuthServer.put(token, JSON.toJSONString(tokenInfo), second);
            Out.info(new Object[]{"Session关闭，重写Token uid=", uid, ",token=", token, ",second=", Integer.valueOf(second)});
        }
    }

    public void onAcrossReceive(Packet pak) {
        Out.debug(new Object[]{"onAcrossReceive :: ", pak.getHeader().getTypeHexString(), " : ", Integer.valueOf(pak.remaing())});
        if (pak.getPacketType() == 1026) {
            ProxyUtil.onAcrossPlayerEvent(pak);
        } else if (pak.getPacketType() == 1267) {
            String playerId = pak.getString();
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null) {
                Channel channel = player.getSession();
                channel.writeAndFlush(pak.getBody());
            }
        } else if (pak.getPacketType() == 1265) {
            ProxyUtil.onAcrossTeamEvent(pak);
        } else if (pak.getPacketType() == 1266) {
            ProxyUtil.onAcrossChangeArea(pak);
        } else if (pak.getPacketType() == 1025) {
            String playerId = pak.getString();
            WNProxy proxy = Proxys.get(playerId);
            if (proxy != null) {
                proxy.from(pak);
            }
        } else {
            super.onAcrossReceive(pak);
        }
    }

    public void closeArea(String instanceId) {
        AreaUtil.closeArea(instanceId);
    }

    public void onPlayerDie(String instanceId, String diePlayerId, String hitPlayerId) {
        Area area = AreaUtil.getArea(instanceId);
        if (area != null) {
            WNPlayer player = getPlayer(diePlayerId);
            area.pushRelive(player);
        }
    }


    public int getOnlineCount() {
        return this.onlinePlayers.size() + Robots.size();
    }


    public static void resetOpenServerDate(LocalDate newOpenDate) {
        if (OPEN_SERVER_DATE == null || !newOpenDate.isEqual(OPEN_SERVER_DATE)) {
            Out.info(new Object[]{"重置开服日期:", newOpenDate.format(DateUtils.F_YYYYMMDD)});
            OPEN_SERVER_DATE = newOpenDate;
            RevelryManager.getInstance().onResetOpenServerDate(OPEN_SERVER_DATE);
        }
    }

    public static void resetExternalTime(String externalTime) {
        LocalDateTime time = LocalDateTime.parse(externalTime, DateUtils.F_YYYYMMDDHHMMSS);
        if (!time.isEqual(__EXTERNAL_TIME)) {
            __EXTERNAL_TIME = time;
            Out.info(new Object[]{"重置对外时间:", externalTime});
        }
    }

    public int max_error_count = 3;


    public void handleCopyPacket(GPlayer player, Integer count, PomeloHeader header) {
        if (count.intValue() >= this.max_error_count) {
            Out.info(new Object[]{"复制封包次数超出了上限,准备T人... playerId=", player.getId(), " count=", count});

            if (player instanceof WNPlayer) {
                PlayerPO po = PlayerUtil.getPlayerBaseData(player.getId());
                po.freezeTime = DateUtils.addMinutes(new Date(), 5);
                po.freezeReason = "网络波动";

                LogReportService.getInstance().ansycReportPacketMonitor(po, count, header.getType(), header.route_s);
            }
            player.getSession().close();
        }
    }
}


