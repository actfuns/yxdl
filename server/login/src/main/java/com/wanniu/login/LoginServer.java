package com.wanniu.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GServer;
import com.wanniu.core.GSystem;
import com.wanniu.core.game.protocol.PomeloHeader;
import com.wanniu.core.game.protocol.PomeloPacket;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.GCache;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.login.vo.AppVO;
import com.wanniu.login.vo.AreaVO;
import com.wanniu.login.vo.ServerLoad;
import com.wanniu.login.vo.ServerShow;
import com.wanniu.login.vo.ServerVO;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginServer
        extends GServer {
    public static Map<Integer, AppVO> Apps = new ConcurrentHashMap<>();

    static {
        instance = new LoginServer();
    }

    public static LoginServer getInstance() {
        return (LoginServer) instance;
    }


    public void start() {
        super.start();
        GSystem.addFixedRateJob(new Runnable() {
            public void run() {
                long currTime = System.currentTimeMillis();
                for (AppVO app : LoginServer.Apps.values()) {
                    for (ServerVO server : app.allServers.values()) {
                        if (server.load != ServerLoad.MAINTAIN.value && currTime - server.pingtime > 61000L) {
                            server.setLoad(ServerLoad.MAINTAIN.value);
                            Out.warn(new Object[]{server.name, " last ping [", DateUtil.format(new Date(server.pingtime), "yyyy-MM-dd HH:mm:ss.SSS"), "] 变为维护状态了！"});
                        }
                    }
                }
            }
        }, 15000L, 30000L);
    }

    public void distatcher(JSONObject json) {
        ServerVO server;
        int areaId, show, onlineCount, appId = json.getIntValue("appId");
        int logicServerId = json.containsKey("logicServerId") ? json.getIntValue("logicServerId") : 0;
        AppVO app = getApp(appId);
        if (app == null) {
            app = new AppVO(appId);
            Apps.put(Integer.valueOf(appId), app);
            List<String> servers = GCache.hvals("/serverlist/" + appId);
            if (servers != null) {
                for (String str : servers) {
                    try {
                        app.addServer((ServerVO) JSON.parseObject(str, ServerVO.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int type = json.getIntValue("type");
        if (type != 259) {
            Out.info(new Object[]{String.format("Message. Msg(%s): %s", new Object[]{Integer.toHexString(json.getInteger("type").intValue()), json.toJSONString()})});
        }
        switch (type) {
            case 257:
                server = app.get(logicServerId);
                areaId = json.containsKey("areaId") ? json.getIntValue("areaId") : 0;
                if (server != null && server.areaId != areaId) {
                    app.remove(logicServerId);
                }
                if (server == null) {
                    server = new ServerVO();
                }
                server.appId = appId;
                server.areaId = areaId;
                server.logicServerId = logicServerId;
                server.name = json.getString("name");
                server.host = json.getString("host");
                server.port = json.getIntValue("port");
                if (json.containsKey("olLimit")) {
                    server.olLimit = json.getIntValue("olLimit");
                }
                if (json.containsKey("recommend")) {
                    server.isRecommend = json.getBooleanValue("recommend");
                }
                if (json.containsKey("new")) {
                    server.isNew = json.getBooleanValue("new");
                }
                if (json.containsKey("hot")) {
                    server.isHot = json.getBooleanValue("hot");
                }
                if (json.containsKey("show")) {
                    server.setShow(json.getIntValue("show"));
                }
                server.setOlCount(server.olCount);
                server.setLoad(Math.max(server.load, ServerLoad.SMOOTH.value));
                app.addServer(server);
                GCache.hset("/serverlist/" + appId, String.valueOf(server.logicServerId), JSON.toJSONString(server));
                Out.info(new Object[]{"游戏服接入：", server});
                return;

            case 258:
                server = app.get(logicServerId);
                if (server == null)
                    return;
                show = json.containsKey("show") ? json.getIntValue("show") : ServerShow.OUTER.value;
                server.setShow(show);
                return;

            case 259:
                server = app.get(logicServerId);
                if (server == null)
                    return;
                onlineCount = json.getIntValue("load");
                server.setOlCount(onlineCount);
                return;

            case 260:
                server = app.get(logicServerId);
                server.areaId = json.getIntValue("areaId");
                app.changeArea(server);
                return;

            case 261:
                app.addArea(json.getIntValue("areaId"), json.getString("areaName"));
                return;

            case 262:
                app.removeArea(json.getIntValue("areaId"));
                return;

            case 263:
                app.remove(logicServerId);
                return;

            case 264:
                server = app.get(logicServerId);
                if (server == null)
                    return;
                server.host = json.getString("ip");
                server.port = json.getIntValue("port");
                return;
        }

        Out.warn(new Object[]{"未定义的类型：0x", Integer.toHexString(json.getIntValue("type")), json.toJSONString()});
    }


    public AppVO getApp(int appId) {
        AppVO app = Apps.get(Integer.valueOf(appId));
        if (app == null) {
            Map<String, String> areas = GCache.hgetAll("/arealist/" + appId);
            if (areas != null) {
                app = new AppVO(appId);
                for (Map.Entry<String, String> entry : areas.entrySet()) {
                    app.addArea(new AreaVO(Integer.valueOf(entry.getKey()).intValue(), entry.getValue()));
                }
                List<String> servers = GCache.hvals("/serverlist/" + appId);
                if (servers != null) {
                    for (String server : servers) {
                        try {
                            app.addServer((ServerVO) JSON.parseObject(server, ServerVO.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                Apps.put(Integer.valueOf(appId), app);
            }
        }
        return app;
    }

    public void addPacket(Packet packet) {
        PomeloPacket pak = (PomeloPacket) packet;
        PomeloHeader header = pak.getHeader();
        putGlobalRoute(header.route_s, packet);
    }

    public void registerHandler(NetHandler handler) {
        super.registerHandler(handler);
    }

    public boolean isWhiteList(String ip, String uid) {
        try {
            if (ip.startsWith("192.168.1.")) {
                return true;
            }
            String ltime = GCache.hget("/server/whitelist/ip", ip);
            if (StringUtil.isEmpty(ltime)) {
                ltime = GCache.hget("/server/whitelist/uid", uid);
            }
            if (StringUtil.isEmpty(ltime)) {
                return false;
            }
            long time = Long.parseLong(ltime);
            if (time > 0L && System.currentTimeMillis() > time) {
                return false;
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
            return false;
        }
        return true;
    }

    public boolean isBlackList(String ip, String uid) {
        String ltime = GCache.hget("/server/blacklist/uid", uid);
        if (StringUtil.isEmpty(ltime)) {
            ltime = GCache.hget("/server/blacklist/ip", ip);
        }
        if (StringUtil.isNotEmpty(ltime)) {
            long time = Long.parseLong(ltime);
            if (time == 0L || System.currentTimeMillis() < time) {
                return true;
            }
        }
        return false;
    }

    public boolean isBlackIp(String ip) {
        String ltime = GCache.hget("/server/blacklist/ip", ip);
        if (StringUtil.isNotEmpty(ltime)) {
            long time = Long.parseLong(ltime);
            if (time == 0L || System.currentTimeMillis() < time) {
                return true;
            }
        }
        return false;
    }
}


