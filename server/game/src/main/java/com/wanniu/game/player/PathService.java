package com.wanniu.game.player;

import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.data.base.MapBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class PathService {
    private static PathService instance;
    private Map<Integer, Map<Integer, Integer>> adj = null;
    private Map<Integer, Map<Integer, Integer>> pathMap = null;

    private PathService() {
        Map<Integer, MapBase> allMaps = (AreaDataConfig.getInstance()).allMaps;
        Set<Integer> sceneIds = allMaps.keySet();
        this.adj = new HashMap<>();
        this.pathMap = new HashMap<>();
        for (Iterator<Integer> iterator = sceneIds.iterator(); iterator.hasNext(); ) {
            int id = ((Integer) iterator.next()).intValue();
            this.adj.put(Integer.valueOf(id), new HashMap<>());
        }


        allMaps.values().forEach(prop -> {
            Map<String, Integer> toPath = prop.toPath;

            for (String pointId : toPath.keySet()) {
                addEdge(prop.mapID, ((Integer) toPath.get(pointId)).intValue(), Integer.parseInt(pointId));
            }
        });
        traverse();
    }

    public static PathService getInstance() {
        if (instance == null) {
            instance = new PathService();
        }
        return instance;
    }

    private void addEdge(int fromId, int toId, int pointId) {
        ((Map<Integer, Integer>) this.adj.get(Integer.valueOf(fromId))).put(Integer.valueOf(toId), Integer.valueOf(pointId));
    }

    private void traverse() {
        for (Iterator<Integer> iterator = this.adj.keySet().iterator(); iterator.hasNext(); ) {
            int id = ((Integer) iterator.next()).intValue();
            Map<Integer, Integer> data = _bfs(id);
            this.pathMap.put(Integer.valueOf(id), data);
        }

    }

    private Map<Integer, Integer> _bfs(int fromId) {
        Map<Integer, Boolean> marked = new HashMap<>();
        for (Iterator<Integer> iterator = this.adj.keySet().iterator(); iterator.hasNext(); ) {
            int areaId = ((Integer) iterator.next()).intValue();
            marked.put(Integer.valueOf(areaId), Boolean.valueOf(false));
        }

        Map<Integer, Integer> data = new HashMap<>();
        data.put(Integer.valueOf(fromId), Integer.valueOf(-1));
        marked.put(Integer.valueOf(fromId), Boolean.valueOf(true));
        _bfsUtil(data, marked, fromId);
        return data;
    }

    private void _bfsUtil(Map<Integer, Integer> data, Map<Integer, Boolean> marked, int id) {
        List<Integer> que = new ArrayList<>();
        que.add(Integer.valueOf(id));
        while (que.size() != 0) {
            id = ((Integer) que.remove(0)).intValue();
            if (this.adj.get(Integer.valueOf(id)) != null) {
                for (Iterator<Integer> iterator = ((Map) this.adj.get(Integer.valueOf(id))).keySet().iterator(); iterator.hasNext(); ) {
                    int childId = ((Integer) iterator.next()).intValue();
                    if (marked.get(Integer.valueOf(childId)) == null || !((Boolean) marked.get(Integer.valueOf(childId))).booleanValue()) {
                        data.put(Integer.valueOf(childId), Integer.valueOf(id));
                        marked.put(Integer.valueOf(childId), Boolean.valueOf(true));
                        que.add(Integer.valueOf(childId));
                    }
                }

            }
        }
    }

    public int findPath(int fromId, int toId) {
        List<Integer> result = new ArrayList<>();

        if (this.pathMap.get(Integer.valueOf(fromId)) != null && this.pathMap.get(Integer.valueOf(toId)) != null) {
            Map<Integer, Integer> data = this.pathMap.get(Integer.valueOf(fromId));
            result.add(Integer.valueOf(toId));
            int pid = (data.get(Integer.valueOf(toId)) == null) ? -1 : ((Integer) data.get(Integer.valueOf(toId))).intValue();
            while (pid != -1) {
                result.add(Integer.valueOf(pid));
                pid = ((Integer) data.get(Integer.valueOf(pid))).intValue();
            }
        }

        int pointId = 0;
        if (result.size() >= 2) {
            int secondAreaId = ((Integer) result.get(result.size() - 2)).intValue();
            pointId = ((Integer) ((Map) this.adj.get(Integer.valueOf(fromId))).get(Integer.valueOf(secondAreaId))).intValue();
        }
        return pointId;
    }


    public static int findToAreaByPointId(int areaId, String pointId) {
        MapBase prop = AreaDataConfig.getInstance().get(areaId);
        if (prop != null) {
            Map<String, Integer> toPathData = prop.toPath;
            if (toPathData.containsKey(pointId)) {
                return ((Integer) toPathData.get(pointId)).intValue();
            }
        }
        return 0;
    }


    public static float[] findToAreaXYByPointId(int areaId, String pointId) {
        MapBase prop = AreaDataConfig.getInstance().get(areaId);
        if (prop != null) {
            Map<String, float[]> toPathXY = prop.toPathXY;
            if (toPathXY.containsKey(pointId)) {
                return toPathXY.get(pointId);
            }
        }
        return null;
    }


    public static float[] findToAreaXYByAreaId(int areaId, int toAreaId) {
        MapBase prop = AreaDataConfig.getInstance().get(areaId);
        if (prop != null) {
            Map<Integer, float[]> toPathXY = prop.toAreaXY;
            if (toPathXY.containsKey(Integer.valueOf(toAreaId))) {
                return toPathXY.get(Integer.valueOf(toAreaId));
            }
        }
        return null;
    }
}


