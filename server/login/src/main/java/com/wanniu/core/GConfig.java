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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GConfig
/*     */ {
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
/*     */   public synchronized void init() {
/*  48 */     if (!this.inited) {
/*  49 */       this.inited = true;
/*  50 */       LinkedList<String> exts = new LinkedList<>();
/*  51 */       File confServer = new File("conf/server.conf");
/*  52 */       build(exts, confServer);
/*  53 */       while (!exts.isEmpty()) {
/*  54 */         String properties = exts.poll();
/*  55 */         confServer = new File(properties);
/*  56 */         if (properties.endsWith("properties")) {
/*  57 */           load(confServer);
/*     */         } else {
/*  59 */           build(exts, confServer);
/*     */         } 
/*  61 */         System.out.format("加载扩展配置：%s\n", new Object[] { confServer.getAbsolutePath() });
/*     */       } 
/*  63 */       Out.info(new Object[] { "已加载系统参数 -> " + this.configs.size() });
/*     */     } 
/*  65 */     GSystem.open();
/*     */   }
/*     */   
/*     */   private void build(LinkedList<String> exts, File confServer) {
/*  69 */     if (confServer != null && confServer.exists() && confServer.isFile()) {
/*  70 */       List<String> confs = FileUtil.readLines(confServer);
/*  71 */       for (String conf : confs) {
/*  72 */         String cs = conf.trim();
/*  73 */         if (cs.length() == 0 || cs.startsWith("#")) {
/*     */           continue;
/*     */         }
/*  76 */         int index = conf.indexOf("=");
/*  77 */         if (index > 0) {
/*  78 */           String key = conf.substring(0, index).trim();
/*  79 */           String value = conf.substring(index + 1).trim();
/*  80 */           if (key.equals("include") && !exts.contains(value)) {
/*  81 */             exts.add(value);
/*     */             continue;
/*     */           } 
/*  84 */           if (!this.configs.containsKey(key)) {
/*  85 */             this.configs.put(key, value); continue;
/*     */           } 
/*  87 */           System.err.format("%s -> 配置重复，%s中的配置无效!\n", new Object[] { key, confServer.getName() });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reinit() {
/*  98 */     this.configs.clear();
/*  99 */     this.inited = false;
/* 100 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void load(File configFile) {
/* 110 */     Map<String, String> confs = PropertiesUtil.loadProperties(configFile);
/* 111 */     for (Map.Entry<String, String> entry : confs.entrySet()) {
/* 112 */       if (!this.configs.containsKey(entry.getKey())) {
/* 113 */         this.configs.put(entry.getKey(), entry.getValue()); continue;
/*     */       } 
/* 115 */       Out.warn(new Object[] { String.valueOf(entry.getKey()) + " -> 配置重复,game.properties中的配置无效!" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoginHost() {
/* 124 */     return get("server.host");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLoginPort() {
/* 131 */     return getInt("server.port");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnableBI() {
/* 138 */     return getBoolean("server.bi.enable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getServerID() {
/* 145 */     return getInt("server.id");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServerLang() {
/* 152 */     return get("server.lang");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(String key, String value) {
/* 159 */     this.configs.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key) {
/* 166 */     return this.configs.get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String key, String def) {
/* 173 */     return this.configs.containsKey(key) ? this.configs.get(key) : def;
/*     */   }
/*     */   
/*     */   public long getLong(String key) {
/* 177 */     String value = this.configs.get(key);
/* 178 */     if (value.startsWith("0x")) {
/* 179 */       return Long.parseLong(value.replace("0x", ""), 16);
/*     */     }
/* 181 */     return Long.parseLong(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key) {
/* 185 */     String value = this.configs.get(key);
/* 186 */     if (value.startsWith("0x")) {
/* 187 */       return Integer.parseInt(value.replace("0x", ""), 16);
/*     */     }
/* 189 */     return Integer.parseInt(value);
/*     */   }
/*     */   
/*     */   public int getInt(String key, int def) {
/* 193 */     return this.configs.containsKey(key) ? getInt(key) : def;
/*     */   }
/*     */   
/*     */   public byte getByte(String key) {
/* 197 */     return Byte.parseByte(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public short getShort(String key) {
/* 201 */     String value = this.configs.get(key);
/* 202 */     if (value.startsWith("0x")) {
/* 203 */       return Short.parseShort(value.replace("0x", ""), 16);
/*     */     }
/* 205 */     return Short.parseShort(value);
/*     */   }
/*     */   
/*     */   public short getShort(String key, short def) {
/* 209 */     return this.configs.containsKey(key) ? getShort(key) : def;
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key) {
/* 213 */     return Boolean.parseBoolean(this.configs.get(key));
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key, boolean def) {
/* 217 */     return this.configs.containsKey(key) ? getBoolean(key) : def;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\GConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */