package com.wanniu.core;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.FileUtil;
import com.wanniu.core.util.PropertiesUtil;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public final class GConfig {
    private boolean inited;
    private static GConfig instance = new GConfig();


    private Map<String, String> configs = new HashMap<>();


    private static final String __0x__ = "0x";


    public static GConfig getInstance() {
        return instance;
    }


    public synchronized void init() {
        if (!this.inited) {
            this.inited = true;
            LinkedList<String> exts = new LinkedList<>();
            File confServer = new File("conf/server.conf");
            build(exts, confServer);
            while (!exts.isEmpty()) {
                String properties = exts.poll();
                confServer = new File(properties);
                if (properties.endsWith("properties")) {
                    load(confServer);
                } else {
                    build(exts, confServer);
                }
                System.out.format("加载扩展配置：%s\n", new Object[]{confServer.getAbsolutePath()});
            }
            Out.info(new Object[]{"已加载系统参数 -> " + this.configs.size()});
        }
        GSystem.open();
    }

    private void build(LinkedList<String> exts, File confServer) {
        if (confServer != null && confServer.exists() && confServer.isFile()) {
            List<String> confs = FileUtil.readLines(confServer);
            for (String conf : confs) {
                String cs = conf.trim();
                if (cs.length() == 0 || cs.startsWith("#")) {
                    continue;
                }
                int index = conf.indexOf("=");
                if (index > 0) {
                    String key = conf.substring(0, index).trim();
                    String value = conf.substring(index + 1).trim();
                    if (key.equals("include") && !exts.contains(value)) {
                        exts.add(value);
                        continue;
                    }
                    if (!this.configs.containsKey(key)) {
                        this.configs.put(key, value);
                        continue;
                    }
                    System.err.format("%s -> 配置重复，%s中的配置无效!\n", new Object[]{key, confServer.getName()});
                }
            }
        }
    }


    public synchronized void reinit() {
        this.configs.clear();
        this.inited = false;
        init();
    }


    private void load(File configFile) {
        Map<String, String> confs = PropertiesUtil.loadProperties(configFile);
        for (Map.Entry<String, String> entry : confs.entrySet()) {
            if (!this.configs.containsKey(entry.getKey())) {
                this.configs.put(entry.getKey(), entry.getValue());
                continue;
            }
            Out.warn(new Object[]{String.valueOf(entry.getKey()) + " -> 配置重复,game.properties中的配置无效!"});
        }
    }


    public String getLoginHost() {
        return get("server.host");
    }


    public int getLoginPort() {
        return getInt("server.port");
    }


    public boolean isEnableBI() {
        return getBoolean("server.bi.enable");
    }


    public int getServerID() {
        return getInt("server.id");
    }


    public String getServerLang() {
        return get("server.lang");
    }


    public void put(String key, String value) {
        this.configs.put(key, value);
    }


    public String get(String key) {
        return this.configs.get(key);
    }


    public String get(String key, String def) {
        return this.configs.containsKey(key) ? this.configs.get(key) : def;
    }

    public long getLong(String key) {
        String value = this.configs.get(key);
        if (value.startsWith("0x")) {
            return Long.parseLong(value.replace("0x", ""), 16);
        }
        return Long.parseLong(value);
    }

    public int getInt(String key) {
        String value = this.configs.get(key);
        if (value.startsWith("0x")) {
            return Integer.parseInt(value.replace("0x", ""), 16);
        }
        return Integer.parseInt(value);
    }

    public int getInt(String key, int def) {
        return this.configs.containsKey(key) ? getInt(key) : def;
    }

    public byte getByte(String key) {
        return Byte.parseByte(this.configs.get(key));
    }

    public short getShort(String key) {
        String value = this.configs.get(key);
        if (value.startsWith("0x")) {
            return Short.parseShort(value.replace("0x", ""), 16);
        }
        return Short.parseShort(value);
    }

    public short getShort(String key, short def) {
        return this.configs.containsKey(key) ? getShort(key) : def;
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(this.configs.get(key));
    }

    public boolean getBoolean(String key, boolean def) {
        return this.configs.containsKey(key) ? getBoolean(key) : def;
    }
}


