package com.wanniu.game.player;

import java.util.HashMap;
import java.util.Map;


public class TransportManager {
    public WNPlayer player;
    public Map<Integer, Integer> transportData;

    public TransportManager(WNPlayer player, Map<Integer, Integer> transportData) {
        this.player = player;
        if (transportData == null) {
            transportData = new HashMap<>();
        }

        this.transportData = transportData;
    }

    public void addNum(int id) {
        int num = ((Integer) this.transportData.get(Integer.valueOf(id))).intValue();
        num++;
        this.transportData.put(Integer.valueOf(id), Integer.valueOf(num));
    }

    public int getNum(int id) {
        int num = ((Integer) this.transportData.get(Integer.valueOf(id))).intValue();
        return num;
    }
}


