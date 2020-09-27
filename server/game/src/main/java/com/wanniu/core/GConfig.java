package com.wanniu.core;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.FileUtil;
import com.wanniu.core.util.PropertiesUtil;
import com.wanniu.core.util.StringUtil;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public final class GConfig {
    private boolean isEnablePay;
    private boolean isEnableDB;
    private boolean isEnableProxy;
    private boolean inited;
    private static GConfig instance = new GConfig();


    private Map<String, String> configs = new HashMap<>();


    private static final String __0x__ = "0x";


    public static GConfig getInstance() {
        return instance;
    }


    public synchronized void init(boolean isOnlyConfigLog4j) {
        if (!this.inited) {
            this.inited = true;
            LinkedList<String> exts = new LinkedList<>();

            File confServer = new File("conf/server.conf");

            if (confServer.exists()) {
                System.out.println("存在");
            } else {
                System.err.println("不存在");
            }
            build(exts, confServer);
            while (!exts.isEmpty()) {
                String properties = exts.poll();

                confServer = new File(properties);


                if (!confServer.exists()) {
                    System.err.println("缺少配置文件：" + properties);
                    System.exit(0);
                }
                if (properties.endsWith("properties")) {
                    load(confServer);
                } else {
                    build(exts, confServer);
                }
                System.out.format("加载扩展配置：%s\n", new Object[]{confServer.getAbsolutePath()});
            }
            this.isEnableProxy = getBoolean("server.proxy.enable");
            this.isEnableDB = getBoolean("server.db.enable");
            this.isEnablePay = getBoolean("server.pay.enable");
            Out.info(new Object[]{"已加载系统参数 -> ", Integer.valueOf(this.configs.size())});
        }
        GSystem.open(isOnlyConfigLog4j);
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
                    if (this.configs.containsKey(key)) {
                        System.err.format("%s -> 配置重复，已使用%s中的配置!\n", new Object[]{key, confServer.getName()});
                    }
                    this.configs.put(key, value);
                }
            }
        }
    }


    public synchronized void reinit(boolean isOnlyConfigLog4j) {
        this.configs.clear();
        this.inited = false;
        init(isOnlyConfigLog4j);
    }


    private void load(File configFile) {
        Map<String, String> confs = PropertiesUtil.loadProperties(configFile);
        for (Map.Entry<String, String> entry : confs.entrySet()) {
            if (!this.configs.containsKey(entry.getKey())) {
                this.configs.put(entry.getKey(), entry.getValue());
                continue;
            }
            Out.warn(new Object[]{entry.getKey(), " -> 配置重复,game.properties中的配置无效!"});
        }
    }


    public String getGamePubHost() {
        return exists("game.pubhost") ? get("game.pubhost") : getGameHost();
    }


    public String getGameHost() {
        return get("game.host");
    }


    public int getGamePort() {
        return getInt("game.port");
    }


    public boolean isEnableGm() {
        return getBoolean("server.gm.enable");
    }


    public boolean isEnableProxy() {
        return this.isEnableProxy;
    }


    public boolean isEnableDB() {
        return this.isEnableDB;
    }


    public boolean isEnablePay() {
        return this.isEnablePay;
    }


    public String getDBHost() {
        return get("server.db.host");
    }


    public int getDBPort() {
        return getInt("server.db.port");
    }


    public int getPlayerLimit() {
        return getInt("game.player.limit", 2000);
    }


    public int getAutoSaveDelay() {
        return getInt("auto.save.delay", 555);
    }


    public int getAutoSaveInterval() {
        return getInt("auto.save.interval", 555);
    }


    public int getAppID() {
        return getInt("game.appid");
    }


    public int getGameID() {
        return getInt("game.id");
    }


    public String getGameLang() {
        return get("game.lang");
    }


    public void put(String key, String value) {
        this.configs.put(key, value);
    }


    public String get(String key) {
        return this.configs.get(key);
    }


    public boolean exists(String key) {
        return this.configs.containsKey(key);
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

    public Set<Integer> getSet(String key) {
        Set<Integer> result = new HashSet<>();
        String sidList = this.configs.getOrDefault(key, "");
        if (StringUtil.isNotEmpty(sidList)) {
            for (String sid : sidList.split(",")) {
                result.add(Integer.valueOf(Integer.parseInt(sid)));
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(getGameID()));
        }
        return result;
    }
}


