package com.wanniu.core.game;

import com.wanniu.core.logfs.Out;

import java.util.HashMap;
import java.util.Map;


public final class LangService {
    private static final Map<String, String> __LANGS = new HashMap<>();


    public static String put(String key, String value) {
        if (__LANGS.containsKey(key)) {
            Out.warn(new Object[]{"语言包重复配置:", key});
        }
        return __LANGS.put(key, value);
    }


    public static String getValue(String key) {
        return __LANGS.getOrDefault(key, key);
    }


    public static String format(String key, Object... o) {
        return String.format(getValue(key), o);
    }
}


