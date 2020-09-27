package com.wanniu.login.vo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AreaVO {
    public int appId;
    public int areaId;
    public String areaName = "NEW";

    public Map<Integer, ServerVO> areaServers = new ConcurrentHashMap<>();

    public AreaVO(int areaId) {
        this.areaId = areaId;
        this.areaName = String.valueOf(this.areaName) + this.areaId;
    }

    public AreaVO(int areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public void add(ServerVO server) {
        String name = server.name;
        for (ServerVO s : this.areaServers.values()) {
            if (s.name.equals(name) && s.logicServerId != server.logicServerId) {
                s.name = String.valueOf(name) + s.logicServerId;
                server.name = String.valueOf(name) + server.logicServerId;
            }
        }
        this.areaServers.put(Integer.valueOf(server.logicServerId), server);
    }

    public void remove(int logicServerId) {
        this.areaServers.remove(Integer.valueOf(logicServerId));
    }

    public String toString() {
        return String.valueOf(this.appId) + ":" + this.areaId + "-" + this.areaName;
    }
}


