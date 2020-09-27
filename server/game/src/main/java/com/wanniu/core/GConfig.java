/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.FileUtil;
/*     */ import com.wanniu.core.util.PropertiesUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
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
/*     */   private boolean isEnablePay;
/*     */   private boolean isEnableDB;
/*     */   private boolean isEnableProxy;
/*     */   private boolean inited;
/*  29 */   private static GConfig instance = new GConfig();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private Map<String, String> configs = new HashMap<>();
/*     */ 
/*     */   
/*     */   private static final String __0x__ = "0x";
/*     */ 
/*     */   
/*     */   public static GConfig getInstance() {
/*  45 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void init(boolean isOnlyConfigLog4j) {
/*  54 */     if (!this.inited) {
/*  55 */       this.inited = true;
/*  56 */       LinkedList<String> exts = new LinkedList<>();
/*     */       
/*  58 */       File confServer = new File("conf/server.conf");
/*     */       
/*  60 */       if (confServer.exists()) {
/*  61 */         System.out.println("存在");
/*     */       } else {
/*  63 */         System.err.println("不存在");
/*     */       } 
/*  65 */       build(exts, confServer);
/*  66 */       while (!exts.isEmpty()) {
/*  67 */         String properties = exts.poll();
/*     */         
/*  69 */         confServer = new File(properties);
/*     */ 
/*     */         
/*  72 */         if (!confServer.exists()) {
/*  73 */           System.err.println("缺少配置文件：" + properties);
/*  74 */           System.exit(0);
/*     */         } 
/*  76 */         if (properties.endsWith("properties")) {
/*  77 */           load(confServer);
/*     */         } else {
/*  79 */           build(exts, confServer);
/*     */         } 
/*  81 */         System.out.format("加载扩展配置：%s\n", new Object[] { confServer.getAbsolutePath() });
/*     */       } 
/*  83 */       this.isEnableProxy = getBoolean("server.proxy.enable");
/*  84 */       this.isEnableDB = getBoolean("server.db.enable");
/*  85 */       this.isEnablePay = getBoolean("server.pay.enable");
/*  86 */       Out.info(new Object[] { "已加载系统参数 -> ", Integer.valueOf(this.configs.size()) });
/*     */     } 
/*  88 */     GSystem.open(isOnlyConfigLog4j);
/*     */   }
/*     */   
/*     */   private void build(LinkedList<String> exts, File confServer) {
/*  92 */     if (confServer != null && confServer.exists() && confServer.isFile()) {
/*  93 */       List<String> confs = FileUtil.readLines(confServer);
/*  94 */       for (String conf : confs) {
/*  95 */         String cs = conf.trim();
/*  96 */         if (cs.length() == 0 || cs.startsWith("#")) {
/*     */           continue;
/*     */         }
/*  99 */         int index = conf.indexOf("=");
/* 100 */         if (index > 0) {
/* 101 */           String key = conf.substring(0, index).trim();
/* 102 */           String value = conf.substring(index + 1).trim();
/* 103 */           if (key.equals("include") && !exts.contains(value)) {
/* 104 */             exts.add(value);
/*     */             continue;
/*     */           } 
/* 107 */           if (this.configs.containsKey(key)) {
/* 108 */             System.err.format("%s -> 配置重复，已使用%s中的配置!\n", new Object[] { key, confServer.getName() });
/*     */           }
/* 110 */           this.configs.put(key, value);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reinit(boolean isOnlyConfigLog4j) {
/* 120 */     this.configs.clear();
/* 121 */     this.inited = false;
/* 122 */     init(isOnlyConfigLog4j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void load(File configFile) {
/* 131 */     Map<String, String> confs = PropertiesUtil.loadProperties(configFile);
/* 132 */     for (Map.Entry<String, String> entry : confs.entrySet()) {
/* 133 */       if (!this.configs.containsKey(entry.getKey())) {
/* 134 */         this.configs.put(entry.getKey(), entry.getValue()); continue;
/*     */       } 
/* 136 */       Out.warn(new Object[] { entry.getKey(), " -> 配置重复,game.properties中的配置无效!" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGamePubHost() {
/* 145 */     return exists("game.pubhost") ? get("game.pubhost") : getGameHost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGameHost() {
/* 152 */     return get("game.host");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGamePort() {
/* 159 */     return getInt("game.port");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableGm() {
/* 166 */     return getBoolean("server.gm.enable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableProxy() {
/* 173 */     return this.isEnableProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableDB() {
/* 180 */     return this.isEnableDB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnablePay() {
/* 187 */     return this.isEnablePay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDBHost() {
/* 194 */     return get("server.db.host");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDBPort() {
/* 201 */     return getInt("server.db.port");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlayerLimit() {
/* 208 */     return getInt("game.player.limit", 2000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAutoSaveDelay() {
/* 215 */     return getInt("auto.save.delay", 555);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAutoSaveInterval() {
/* 222 */     return getInt("auto.save.interval", 555);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAppID() {
/* 229 */     return getInt("game.appid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGameID() {
/* 236 */     return getInt("game.id");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGameLang() {
/* 243 */     return get("game.lang");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(String key, String value) {
/* 250 */     this.configs.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key) {
/* 257 */     return this.configs.get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exists(String key) {
/* 264 */     return this.configs.containsKey(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key, String def) {
/* 271 */     return this.configs.containsKey(key) ? this.configs.get(key) : def;
/*     */   }
/*     */   
/*     */   public long getLong(String key) {
/* 275 */     String value = this.configs.get(key);
/* 276 */     if (value.startsWith("0x")) {
/* 277 */       return Long.parseLong(value.replace("0x", ""), 16);
/*     */     }
/* 279 */     return Long.parseLong(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key) {
/* 283 */     String value = this.configs.get(key);
/* 284 */     if (value.startsWith("0x")) {
/* 285 */       return Integer.parseInt(value.replace("0x", ""), 16);
/*     */     }
/* 287 */     return Integer.parseInt(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key, int def) {
/* 291 */     return this.configs.containsKey(key) ? getInt(key) : def;
/*     */   }
/*     */   
/*     */   public byte getByte(String key) {
/* 295 */     return Byte.parseByte(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public short getShort(String key) {
/* 299 */     String value = this.configs.get(key);
/* 300 */     if (value.startsWith("0x")) {
/* 301 */       return Short.parseShort(value.replace("0x", ""), 16);
/*     */     }
/* 303 */     return Short.parseShort(value);
/*     */   }
/*     */   
/*     */   public short getShort(String key, short def) {
/* 307 */     return this.configs.containsKey(key) ? getShort(key) : def;
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key) {
/* 311 */     return Boolean.parseBoolean(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key, boolean def) {
/* 315 */     return this.configs.containsKey(key) ? getBoolean(key) : def;
/*     */   }
/*     */   
/*     */   public Set<Integer> getSet(String key) {
/* 319 */     Set<Integer> result = new HashSet<>();
/* 320 */     String sidList = this.configs.getOrDefault(key, "");
/* 321 */     if (StringUtil.isNotEmpty(sidList)) {
/* 322 */       for (String sid : sidList.split(",")) {
/* 323 */         result.add(Integer.valueOf(Integer.parseInt(sid)));
/*     */       }
/*     */     }
/* 326 */     if (result.isEmpty()) {
/* 327 */       result.add(Integer.valueOf(getGameID()));
/*     */     }
/* 329 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */