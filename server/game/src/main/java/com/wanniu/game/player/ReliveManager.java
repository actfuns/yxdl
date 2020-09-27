package com.wanniu.game.player;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ResurrectionCO;

import java.util.HashMap;
import java.util.Map;


public class ReliveManager {
    public int payCost;
    public int payConfirm = 1;
    public int nowReliveNum;
    public Map<Integer, Integer> reliveHistory = new HashMap<>();

    public void addRelive(int areaId) {
        this.reliveHistory.put(Integer.valueOf(areaId), Integer.valueOf(getReliveCount(areaId) + 1));
    }

    public int getReliveCount(int areaId) {
        return this.reliveHistory.containsKey(Integer.valueOf(areaId)) ? ((Integer) this.reliveHistory.get(Integer.valueOf(areaId))).intValue() : 0;
    }

    public int getReliveTotal(int areaId) {
        ResurrectionCO resurrection = (ResurrectionCO) GameData.Resurrections.get(Integer.valueOf(areaId));
        return (resurrection != null) ? resurrection.resurrectNum : 0;
    }

    public void refreshNewDay() {
        this.nowReliveNum = 0;
        this.reliveHistory.clear();
    }
}


