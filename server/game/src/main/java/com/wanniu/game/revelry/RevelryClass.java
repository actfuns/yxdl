package com.wanniu.game.revelry;

import java.util.Map;
import java.util.TreeMap;


public class RevelryClass {
    private final String name;
    private final Map<String, RevelryToday> todays = new TreeMap<>();

    public RevelryClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, RevelryToday> getTodays() {
        return this.todays;
    }
}


