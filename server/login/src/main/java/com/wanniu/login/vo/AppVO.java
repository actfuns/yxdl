package com.wanniu.login.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GServer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.GCache;
import com.wanniu.core.redis.GlobalDao;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.login.LoginServer;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppVO {
    public Map<Integer, ServerVO> allServers = new ConcurrentHashMap<>();

    public Map<Integer, AreaVO> areas = new ConcurrentHashMap<>();

    public int appId;

    public AppVO(int appId) {
        this.appId = appId;
    }

    public void addArea(int areaId, String name) {
        AreaVO area = getArea(areaId);
        area.areaName = name;
        GCache.hset("/arealist/" + this.appId, String.valueOf(areaId), name);
    }

    public void addArea(AreaVO area) {
        this.areas.put(Integer.valueOf(area.areaId), area);
    }

    public void removeArea(int areaId) {
        AreaVO area = this.areas.remove(Integer.valueOf(areaId));
        if (area != null) {
            for (Iterator<Integer> iterator = area.areaServers.keySet().iterator(); iterator.hasNext(); ) {
                int logicServerId = ((Integer) iterator.next()).intValue();
                this.allServers.remove(Integer.valueOf(logicServerId));
                GCache.hremove("/serverlist/" + this.appId, String.valueOf(logicServerId));
            }

            GCache.hremove("/arealist/" + this.appId, String.valueOf(areaId));
        }
    }

    public AreaVO getArea(int areaId) {
        AreaVO area = this.areas.get(Integer.valueOf(areaId));
        if (area == null) {
            String name = GCache.hget("/arealist/" + this.appId, String.valueOf(areaId));
            if (name != null) {
                area = new AreaVO(areaId);
                area.appId = this.appId;
                area.areaName = name;
                this.areas.put(Integer.valueOf(area.areaId), area);
            }
            if (area == null) {
                area = new AreaVO(areaId);
                this.areas.put(Integer.valueOf(areaId), area);
            }
        }
        return area;
    }

    public void addServer(ServerVO server) {
        ServerVO oldServer = this.allServers.get(Integer.valueOf(server.logicServerId));
        if (oldServer != null) {
            AreaVO areaVO = getArea(oldServer.areaId);
            if (areaVO.areaId != server.areaId) {
                areaVO.remove(server.logicServerId);
            }
        }
        AreaVO area = getArea(server.areaId);
        area.add(server);
        this.allServers.put(Integer.valueOf(server.logicServerId), server);
    }

    public void remove(int logicServerId) {
        ServerVO server = get(logicServerId);
        if (server != null) {
            AreaVO area = this.areas.get(Integer.valueOf(server.areaId));
            if (area != null) {
                area.remove(logicServerId);
            }
            this.allServers.remove(Integer.valueOf(logicServerId));
        }
        GCache.hremove("/serverlist/" + this.appId, String.valueOf(logicServerId));
    }

    public ServerVO get(int logicServerId) {
        return this.allServers.get(Integer.valueOf(logicServerId));
    }

    public void changeArea(ServerVO server) {
        this.areas.remove(Integer.valueOf(server.areaId));
        addServer(server);
    }


    public JSONArray getServerList(Map<Integer, Integer> histories, Packet pak) {
        String ip = pak.getIp();
        String uid = pak.getUid();
        Out.info(new Object[]{uid, " login at : ", ip});
        JSONArray arr = new JSONArray();
        for (AreaVO area : this.areas.values()) {
            JSONObject json = new JSONObject();
            JSONArray areaServers = new JSONArray();
            for (ServerVO server : area.areaServers.values()) {
                if (server.show > 0) {
                    JSONArray show = server.toShowJSON();
                    if (server.show == ServerShow.INNER.value && !LoginServer.getInstance().isWhiteList(ip, uid)) {
                        show.set(4, Integer.valueOf(ServerLoad.MAINTAIN.value));
                    }
                    int roleCount = histories.containsKey(Integer.valueOf(server.logicServerId)) ? ((Integer) histories.get(Integer.valueOf(server.logicServerId))).intValue() : 0;
                    show.add(Integer.valueOf(roleCount));
                    if (roleCount > 0) {
                        JSONArray players = new JSONArray();
                        String s_players = GlobalDao.hget(String.valueOf(server.logicServerId), uid);
                        if (StringUtil.isNotEmpty(s_players)) {
                            JSONObject jsPlayers = JSON.parseObject(s_players);
                            for (String rid : jsPlayers.keySet()) {
                                players.add(jsPlayers.getJSONObject(rid));
                            }
                            Collections.sort((List<?>) players, new Comparator() {
                                public int compare(Object o1, Object o2) {
                                    Long t1 = ((JSONObject) o1).getLong("time");
                                    Long t2 = ((JSONObject) o2).getLong("time");
                                    if (t1 == t2) return 0;
                                    if (t1 == null) return 1;
                                    if (t2 == null) return -1;
                                    return -t1.compareTo(t2);
                                }
                            });
                        }
                        show.add(players);
                    }
                    areaServers.add(show);
                }
            }
            json.put(area.areaName, areaServers);
            arr.add(json);
        }
        if (pak.getSession().isActive()) {
            GServer.getInstance().addLoginSession(pak.getSession());
        }
        return arr;
    }
}


