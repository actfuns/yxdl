package com.wanniu.game.data.ext;

import com.wanniu.game.data.WayTreasureCO;

import java.util.ArrayList;
import java.util.List;


public class WayTreasureExt
        extends WayTreasureCO {
    public List<Integer> doScenes;
    public List<List<Integer>> doPoints;
    public List<Integer> monsterIds;

    public void initProperty() {
        this.doScenes = new ArrayList<>();
        this.doPoints = new ArrayList<>();
        this.monsterIds = new ArrayList<>();

        String[] temp = this.doScene.split("\\|");
        for (String scene : temp) {
            this.doScenes.add(Integer.valueOf(Integer.parseInt(scene)));
        }

        temp = this.doPoint.split("\\|");
        for (String points : temp) {
            String[] ps = points.split(":");
            List<Integer> list_points = new ArrayList<>();
            for (String p : ps) {
                list_points.add(Integer.valueOf(Integer.parseInt(p)));
            }
            this.doPoints.add(list_points);
        }

        temp = this.monsterID.split(":");
        for (String m : temp)
            this.monsterIds.add(Integer.valueOf(Integer.parseInt(m)));
    }
}


