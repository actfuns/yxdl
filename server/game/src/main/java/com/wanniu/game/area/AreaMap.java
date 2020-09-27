package com.wanniu.game.area;

import com.wanniu.game.GWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AreaMap
        extends ConcurrentHashMap<String, Area> {
    private static final long serialVersionUID = 1L;
    private Map<String, Map<String, Area>> Areas = new ConcurrentHashMap<>();

    private String getKey(int logicServerId, int areaId) {
        return GWorld.__SERVER_ID + ":" + areaId;
    }

    private String getKey(Area area) {
        return GWorld.__SERVER_ID + ":" + area.areaId;
    }


    public Area put(String key, Area area) {
        Map<String, Area> areas = this.Areas.get(getKey(area));
        int line = 1;
        if (areas == null) {
            areas = new ConcurrentHashMap<>();
            this.Areas.put(getKey(area), areas);
        }
        boolean find = false;
        while (true) {
            find = false;
            for (Area a : areas.values()) {
                if (a.lineIndex == line) {
                    line++;
                    find = true;
                }
            }
            if (!find) {
                area.lineIndex = line;
                areas.put(key, area);
                return super.put(key, area);
            }
        }
    }

    public Area remove(Object key) {
        Area area = super.remove(key);
        if (area != null) {
            Map<String, Area> areas = this.Areas.get(getKey(area));
            if (areas != null) {
                areas.remove(key);
            }
        }
        return area;
    }

    public Area dispactch(int areaId, int logicServerId, int addCount) {
        Map<String, Area> areas = this.Areas.get(getKey(logicServerId, areaId));
        if (areas != null) {
            for (Area area : areas.values()) {
                if (!area.isFull(addCount)) {
                    return area;
                }
            }
        }
        return null;
    }

    public List<Area> getAreas(int areaId, int logicServerId) {
        List<Area> list = new ArrayList<>();
        Map<String, Area> areas = this.Areas.get(getKey(logicServerId, areaId));
        if (areas != null) {
            list.addAll(areas.values());
        }
        return list;
    }
}


