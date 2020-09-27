package com.wanniu.game.money;

import com.wanniu.game.item.VirtualItemType;

import java.util.EnumMap;


public class CostResult {
    private final boolean success;
    private final EnumMap<VirtualItemType, Integer> values = new EnumMap<>(VirtualItemType.class);

    public CostResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getValue(VirtualItemType type) {
        return ((Integer) this.values.getOrDefault(type, Integer.valueOf(0))).intValue();
    }

    public CostResult addValue(VirtualItemType type, int value) {
        this.values.put(type, Integer.valueOf(value));
        return this;
    }
}


