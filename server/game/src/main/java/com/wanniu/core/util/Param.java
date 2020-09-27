package com.wanniu.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Param {
    private static final String KEY_SINGLE = "KEY_SINGLE_PARAM";
    public final Map<String, Object> datas = new HashMap<>();


    public Param() {
        this(new Object[0]);
    }


    public Param(Object... params) {
        if (params == null || params.length == 0) {
            return;
        }


        if (params.length == 1) {
            put("KEY_SINGLE_PARAM", params[0]);
        } else {
            int len = params.length;
            for (int i = 0; i < len; i += 2) {
                String key = (String) params[i];
                Object val = params[i + 1];

                put(key, val);
            }
        }
    }


    public Param put(String key, Object value) {
        this.datas.put(key, value);
        return this;
    }


    public <K> K get() {
        return get("KEY_SINGLE_PARAM");
    }


    public <K> K get(String key) {
        return (K) this.datas.get(key);
    }


    public boolean isContains(String key) {
        return this.datas.containsKey(key);
    }


    public <K> K get(String key, K defaultValue) {
        Object val = this.datas.get(key);
        return (val == null) ? defaultValue : (K) val;
    }


    public boolean getBoolean() {
        return ((Boolean) get()).booleanValue();
    }


    public boolean getBoolean(String key) {
        return ((Boolean) get(key)).booleanValue();
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        return ((Boolean) get(key, Boolean.valueOf(defaultValue))).booleanValue();
    }


    public int getInt() {
        return ((Integer) get()).intValue();
    }


    public int getInt(String key) {
        return ((Integer) get(key)).intValue();
    }


    public int getInt(String key, int defaultValue) {
        return ((Integer) get(key, Integer.valueOf(defaultValue))).intValue();
    }


    public long getLong() {
        return ((Long) get()).longValue();
    }


    public long getLong(String key) {
        return ((Long) get(key)).longValue();
    }


    public long getLong(String key, long defaultValue) {
        return ((Long) get(key, Long.valueOf(defaultValue))).longValue();
    }


    public String getString() {
        return get();
    }


    public String getString(String key) {
        return get(key);
    }


    public String getString(String key, String defaultValue) {
        return get(key, defaultValue);
    }


    public int size() {
        return this.datas.size();
    }


    public boolean containsKey(String key) {
        return this.datas.containsKey(key);
    }


    public Object[] toArray() {
        Object[] arr;
        if (this.datas.isEmpty()) {
            arr = new Object[0];
        } else if (this.datas.size() == 1 && this.datas.containsKey("KEY_SINGLE_PARAM")) {
            arr = new Object[]{this.datas.get("KEY_SINGLE_PARAM")};
        } else {

            arr = new Object[this.datas.size() * 2];

            int index = 0;
            for (Map.Entry<String, Object> e : this.datas.entrySet()) {
                arr[index++] = e.getKey();
                arr[index++] = e.getValue();
            }
        }

        return arr;
    }


    public Set<String> keySet() {
        return this.datas.keySet();
    }


    public Set<Map.Entry<String, Object>> entrySet() {
        return this.datas.entrySet();
    }


    public String toString() {
        return this.datas.toString();
    }
}


