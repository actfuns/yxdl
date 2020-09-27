/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.FileUtil;
/*     */ import com.wanniu.core.util.PropertiesUtil;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GConfig
/*     */ {
/*     */   private boolean isEnableBI;
/*     */   private boolean isEnableDB;
/*     */   private boolean isEnableProxy;
/*     */   private boolean inited;
/*  25 */   private static GConfig instance = new GConfig();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   private Map<String, String> configs = new HashMap<>();
/*     */ 
/*     */   
/*     */   private static final String __0x__ = "0x";
/*     */ 
/*     */   
/*     */   public static GConfig getInstance() {
/*  41 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void init(boolean isOnlyConfigLog4j) {
/*  49 */     if (!this.inited) {
/*  50 */       this.inited = true;
/*  51 */       LinkedList<String> exts = new LinkedList<>();
/*  52 */       File confServer = new File("conf/server.conf");
/*  53 */       build(exts, confServer);
/*  54 */       while (!exts.isEmpty()) {
/*  55 */         String properties = exts.poll();
/*  56 */         confServer = new File(properties);
/*  57 */         if (properties.endsWith("properties")) {
/*  58 */           load(confServer);
/*     */         } else {
/*  60 */           build(exts, confServer);
/*     */         } 
/*  62 */         System.out.format("加载扩展配置：%s\n", new Object[] { confServer.getAbsolutePath() });
/*     */       } 
/*  64 */       this.isEnableProxy = getBoolean("server.proxy.enable");
/*  65 */       this.isEnableDB = getBoolean("server.db.enable");
/*  66 */       this.isEnableBI = getBoolean("server.bi.enable");
/*  67 */       Out.info(new Object[] { "已加载系统参数 -> " + this.configs.size() });
/*     */     } 
/*  69 */     GSystem.open(isOnlyConfigLog4j);
/*     */   }
/*     */   
/*     */   private void build(LinkedList<String> exts, File confServer) {
/*  73 */     if (confServer != null && confServer.exists() && confServer.isFile()) {
/*  74 */       List<String> confs = FileUtil.readLines(confServer);
/*  75 */       for (String conf : confs) {
/*  76 */         String cs = conf.trim();
/*  77 */         if (cs.length() == 0 || cs.startsWith("#")) {
/*     */           continue;
/*     */         }
/*  80 */         int index = conf.indexOf("=");
/*  81 */         if (index > 0) {
/*  82 */           String key = conf.substring(0, index).trim();
/*  83 */           String value = conf.substring(index + 1).trim();
/*  84 */           if (key.equals("include") && !exts.contains(value)) {
/*  85 */             exts.add(value);
/*     */             continue;
/*     */           } 
/*  88 */           if (this.configs.containsKey(key)) {
/*  89 */             System.err.format("%s -> 配置重复，已使用%s中的配置!\n", new Object[] { key, confServer.getName() });
/*     */           }
/*  91 */           this.configs.put(key, value);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reinit(boolean isOnlyConfigLog4j) {
/* 101 */     this.configs.clear();
/* 102 */     this.inited = false;
/* 103 */     init(isOnlyConfigLog4j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void load(File configFile) {
/* 113 */     Map<String, String> confs = PropertiesUtil.loadProperties(configFile);
/* 114 */     for (Map.Entry<String, String> entry : confs.entrySet()) {
/* 115 */       if (!this.configs.containsKey(entry.getKey())) {
/* 116 */         this.configs.put(entry.getKey(), entry.getValue()); continue;
/*     */       } 
/* 118 */       Out.warn(new Object[] { String.valueOf(entry.getKey()) + " -> 配置重复,game.properties中的配置无效!" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGameHost() {
/* 127 */     return get("game.host");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGamePort() {
/* 134 */     return getInt("game.port");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableGm() {
/* 141 */     return getBoolean("server.gm.enable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableProxy() {
/* 148 */     return this.isEnableProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableDB() {
/* 155 */     return this.isEnableDB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableBI() {
/* 162 */     return this.isEnableBI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnablePay() {
/* 169 */     return getBoolean("server.pay.enable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableLogin() {
/* 176 */     return getBoolean("server.login.enable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDBHost() {
/* 183 */     return get("server.db.host");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDBPort() {
/* 190 */     return getInt("server.db.port");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoginKey() {
/* 197 */     return get("game.login.key");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlayerLimit() {
/* 204 */     return getInt("game.player.limit", 2000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAutoSaveDelay() {
/* 211 */     return getInt("auto.save.delay", 555);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAutoSaveInterval() {
/* 218 */     return getInt("auto.save.interval", 555);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAppID() {
/* 225 */     return getInt("game.appid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGameID() {
/* 232 */     return getInt("game.id");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGameLang() {
/* 239 */     return get("game.lang");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(String key, String value) {
/* 246 */     this.configs.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key) {
/* 253 */     return this.configs.get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exists(String key) {
/* 260 */     return this.configs.containsKey(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key, String def) {
/* 267 */     return this.configs.containsKey(key) ? this.configs.get(key) : def;
/*     */   }
/*     */   
/*     */   public long getLong(String key) {
/* 271 */     String value = this.configs.get(key);
/* 272 */     if (value.startsWith("0x")) {
/* 273 */       return Long.parseLong(value.replace("0x", ""), 16);
/*     */     }
/* 275 */     return Long.parseLong(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key) {
/* 279 */     String value = this.configs.get(key);
/* 280 */     if (value.startsWith("0x")) {
/* 281 */       return Integer.parseInt(value.replace("0x", ""), 16);
/*     */     }
/* 283 */     return Integer.parseInt(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key, int def) {
/* 287 */     return this.configs.containsKey(key) ? getInt(key) : def;
/*     */   }
/*     */   
/*     */   public byte getByte(String key) {
/* 291 */     return Byte.parseByte(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public short getShort(String key) {
/* 295 */     String value = this.configs.get(key);
/* 296 */     if (value.startsWith("0x")) {
/* 297 */       return Short.parseShort(value.replace("0x", ""), 16);
/*     */     }
/* 299 */     return Short.parseShort(value);
/*     */   }
/*     */   
/*     */   public short getShort(String key, short def) {
/* 303 */     return this.configs.containsKey(key) ? getShort(key) : def;
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key) {
/* 307 */     return Boolean.parseBoolean(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key, boolean def) {
/* 311 */     return this.configs.containsKey(key) ? getBoolean(key) : def;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\GConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */