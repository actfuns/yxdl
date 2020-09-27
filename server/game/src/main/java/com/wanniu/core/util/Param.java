/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ public class Param
/*     */ {
/*     */   private static final String KEY_SINGLE = "KEY_SINGLE_PARAM";
/*  20 */   public final Map<String, Object> datas = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param() {
/*  26 */     this(new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param(Object... params) {
/*  36 */     if (params == null || params.length == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  41 */     if (params.length == 1) {
/*  42 */       put("KEY_SINGLE_PARAM", params[0]);
/*     */     } else {
/*  44 */       int len = params.length;
/*  45 */       for (int i = 0; i < len; i += 2) {
/*  46 */         String key = (String)params[i];
/*  47 */         Object val = params[i + 1];
/*     */         
/*  49 */         put(key, val);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param put(String key, Object value) {
/*  61 */     this.datas.put(key, value);
/*  62 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <K> K get() {
/*  70 */     return get("KEY_SINGLE_PARAM");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <K> K get(String key) {
/*  81 */     return (K)this.datas.get(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContains(String key) {
/*  86 */     return this.datas.containsKey(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <K> K get(String key, K defaultValue) {
/*  98 */     Object val = this.datas.get(key);
/*  99 */     return (val == null) ? defaultValue : (K)val;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean() {
/* 108 */     return ((Boolean)get()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String key) {
/* 117 */     return ((Boolean)get(key)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String key, boolean defaultValue) {
/* 126 */     return ((Boolean)get(key, Boolean.valueOf(defaultValue))).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt() {
/* 135 */     return ((Integer)get()).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt(String key) {
/* 144 */     return ((Integer)get(key)).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt(String key, int defaultValue) {
/* 153 */     return ((Integer)get(key, Integer.valueOf(defaultValue))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong() {
/* 162 */     return ((Long)get()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong(String key) {
/* 171 */     return ((Long)get(key)).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong(String key, long defaultValue) {
/* 180 */     return ((Long)get(key, Long.valueOf(defaultValue))).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 189 */     return get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String key) {
/* 198 */     return get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String key, String defaultValue) {
/* 207 */     return get(key, defaultValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 215 */     return this.datas.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(String key) {
/* 224 */     return this.datas.containsKey(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*     */     Object[] arr;
/* 235 */     if (this.datas.isEmpty()) {
/* 236 */       arr = new Object[0];
/* 237 */     } else if (this.datas.size() == 1 && this.datas.containsKey("KEY_SINGLE_PARAM")) {
/* 238 */       arr = new Object[] { this.datas.get("KEY_SINGLE_PARAM") };
/*     */     } else {
/*     */       
/* 241 */       arr = new Object[this.datas.size() * 2];
/*     */       
/* 243 */       int index = 0;
/* 244 */       for (Map.Entry<String, Object> e : this.datas.entrySet()) {
/* 245 */         arr[index++] = e.getKey();
/* 246 */         arr[index++] = e.getValue();
/*     */       } 
/*     */     } 
/*     */     
/* 250 */     return arr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> keySet() {
/* 258 */     return this.datas.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<String, Object>> entrySet() {
/* 266 */     return this.datas.entrySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 271 */     return this.datas.toString();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\Param.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */