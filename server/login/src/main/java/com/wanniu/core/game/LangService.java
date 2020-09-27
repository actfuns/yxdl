package com.wanniu.core.game;

import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class LangService {
    private static final Map<String, String> __LANGS = new HashMap<>();


    public static Map<String, String> build(Class<?> clz) {
        return build(String.valueOf(clz.getSimpleName()) + ".txt");
    }


    public static Map<String, String> build(String file) {
        return build(new File(String.valueOf(GGlobal.DIR_LANGUAGE) + file));
    }


    public static Map<String, String> build(File file) {
        Map<String, String> maps = new HashMap<>();
        List<String> langs = FileUtil.readLines(file);
        for (String lang : langs) {
            String text = lang.trim();
            if (text.startsWith("#") || text.length() == 0)
                continue;
            int index = text.indexOf("=");
            if (index > 0) {
                String key = text.substring(0, index);
                String value = text.substring(index + 1);
                if (value.length() > 0) {
                    maps.put(key, value);
                }
            }
        }
        return maps;
    }

    private static void init(boolean reinit) {
        File language = new File(GGlobal.DIR_LANGUAGE);
        if (language.exists() && language.isDirectory()) {
            File[] langs = language.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    if (file.isFile()) return true;
                    return false;
                }
            });
            Map<String, String> msgs = null;
            byte b;
            int i;
            File[] arrayOfFile1;
            for (i = (arrayOfFile1 = langs).length, b = 0; b < i; ) {
                File file = arrayOfFile1[b];
                msgs = build(file);
                for (Map.Entry<String, String> entry : msgs.entrySet()) {
                    if (__LANGS.containsKey(entry.getKey()) && !reinit) {
                        Out.error(new Object[]{String.format("当前包 (%s) ： [%s]  -> %s，已经存在值：%s", new Object[]{file.getName(), entry.getKey(), entry.getValue(), __LANGS.get(entry.getKey())})});
                    }
                    __LANGS.put(entry.getKey(), entry.getValue());
                }
                Out.info(new Object[]{String.format("加载语言包文件 -> %s\t\t[%d / %d]", new Object[]{file.getName(), Integer.valueOf(msgs.size()), Integer.valueOf(__LANGS.size())})});
                b++;
            }

        }
    }

    public static void init() {
        init(false);
    }


    public static void reinit() {
        init(true);
    }


    public static String put(String key, String value) {
        return __LANGS.put(key, value);
    }


    public static String getValue(String key) {
        return __LANGS.get(key);
    }
}


