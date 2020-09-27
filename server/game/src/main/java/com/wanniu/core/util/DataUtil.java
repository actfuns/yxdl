/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataUtil
/*     */ {
/*  19 */   public static Map<String, String> Classes = new HashMap<>();
/*     */   
/*  21 */   public static Map<String, String> superClasses = new HashMap<>();
/*     */   
/*  23 */   public static String extendClass = "Ext";
/*  24 */   public static String pakName = "Ext";
/*     */ 
/*     */   
/*     */   public static void addExtClass(String pakName) {
/*  28 */     DataUtil.pakName = pakName;
/*  29 */     File file = new File(DIR + File.separator + "ext" + File.separator);
/*  30 */     if (file.exists() && file.isDirectory()) {
/*  31 */       for (String f : file.list()) {
/*  32 */         String name = f.substring(0, f.indexOf(".java"));
/*  33 */         Classes.put(name, pakName + ".ext." + name);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getClassName(String name) {
/*  39 */     if (name.indexOf(File.separator) >= 0) {
/*  40 */       name = name.substring(name.lastIndexOf(File.separator) + 1);
/*     */     }
/*  42 */     StringBuilder builder = new StringBuilder();
/*  43 */     builder.append(Character.toUpperCase(name.charAt(0)));
/*  44 */     for (int i = 1; i < name.length() && 
/*  45 */       name.charAt(i) != '.'; i++) {
/*  46 */       if (name.charAt(i) == '-') {
/*  47 */         builder.append("_");
/*     */       
/*     */       }
/*  50 */       else if (name.charAt(i) == '_') {
/*  51 */         if (name.charAt(i + 1) != '.') {
/*  52 */           builder.append(Character.toUpperCase(name.charAt(i + 1)));
/*  53 */           i++;
/*     */         } 
/*     */       } else {
/*  56 */         builder.append(name.charAt(i));
/*     */       } 
/*     */     } 
/*  59 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public static String getFieldName(String name) {
/*  63 */     if (name.length() < 1) return null; 
/*  64 */     name = name.trim();
/*  65 */     StringBuilder builder = new StringBuilder();
/*  66 */     builder.append(Character.toLowerCase(name.charAt(0)));
/*  67 */     for (int i = 1; i < name.length(); i++) {
/*  68 */       if (name.charAt(i) != ' ')
/*  69 */         if (name.charAt(i) == '-') {
/*  70 */           builder.append("_");
/*     */         
/*     */         }
/*  73 */         else if (name.charAt(i) == '_') {
/*  74 */           if (name.length() > i + 1) {
/*  75 */             builder.append("_").append(Character.toLowerCase(name.charAt(i + 1)));
/*  76 */             i++;
/*     */           } 
/*     */         } else {
/*  79 */           builder.append(name.charAt(i));
/*     */         }  
/*     */     } 
/*  82 */     String field = builder.toString();
/*  83 */     if ("long".equals(field)) {
/*  84 */       field = "long_v";
/*  85 */     } else if ("goto".equals(field)) {
/*  86 */       field = "goto_v";
/*  87 */     } else if ("default".equals(field)) {
/*  88 */       field = "default_v";
/*  89 */     } else if ("new".equals(field)) {
/*  90 */       field = "new_v";
/*  91 */     } else if ("try".equals(field)) {
/*  92 */       field = "try_v";
/*  93 */     } else if ("final".equals(field)) {
/*  94 */       field = "final_v";
/*     */     } 
/*  96 */     return field;
/*     */   }
/*     */   
/*  99 */   private static String DIR = "/";
/*     */   
/*     */   public static void setDir(String path) {
/* 102 */     File toDir = new File(path);
/* 103 */     toDir.mkdirs();
/* 104 */     DIR = toDir.getAbsolutePath() + File.separator;
/*     */   }
/*     */   
/*     */   private static String type(Object type) {
/* 108 */     if ("NUMBER".equals(type))
/* 109 */       return "int"; 
/* 110 */     if ("STRING".equals(type))
/* 111 */       return "String"; 
/* 112 */     if ("FLOAT".equals(type)) {
/* 113 */       return "float";
/*     */     }
/* 115 */     Out.error(new Object[] { " undefine type : ", type });
/*     */     
/* 117 */     return "Object";
/*     */   }
/*     */   
/* 120 */   private static Map<String, String> DataNames = new HashMap<>(); private static StringBuilder BaseBuilder;
/*     */   
/*     */   public static void writeClass(File file) {
/*     */     try {
/* 124 */       if (BaseBuilder == null) {
/* 125 */         BaseBuilder = new StringBuilder();
/* 126 */         BaseBuilder.append("package ").append(pakName).append("; \n\n");
/* 127 */         for (String fullName : Classes.values()) {
/* 128 */           BaseBuilder.append("import " + fullName + ";\n");
/*     */         }
/* 130 */         BaseBuilder.append("import java.util.Map; \n");
/* 131 */         BaseBuilder.append("import java.util.HashMap; \n\n");
/* 132 */         BaseBuilder.append("import java.util.function.Predicate; \n\n");
/* 133 */         BaseBuilder.append("import java.util.List; \n\n");
/* 134 */         BaseBuilder.append("import java.util.ArrayList; \n\n");
/* 135 */         BaseBuilder.append("/** 游戏-策划配置 */\n");
/* 136 */         BaseBuilder.append("public final class GameData { \n\n");
/*     */       } 
/* 138 */       StringBuilder builder = new StringBuilder();
/* 139 */       builder.append("package ").append(pakName).append("; \n\n");
/* 140 */       String baseName = getClassName(file.getName());
/* 141 */       String clsName = baseName + "CO";
/* 142 */       if (DataNames.containsKey(clsName)) {
/* 143 */         Out.error(new Object[] { baseName, " 表名冲突：\n", file.getAbsolutePath(), "\n", DataNames.get(clsName) });
/*     */         return;
/*     */       } 
/* 146 */       DataNames.put(clsName, file.getAbsolutePath());
/* 147 */       builder.append("public class ").append(clsName);
/* 148 */       if (superClasses.containsKey(clsName)) {
/* 149 */         builder.append(" extends ").append(superClasses.get(clsName));
/*     */       }
/* 151 */       builder.append(" { \n\n");
/*     */       
/* 153 */       JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
/* 154 */       if (doc.size() < 3) {
/* 155 */         Out.error(new Object[] { "空数据：", file.getAbsolutePath() });
/*     */         return;
/*     */       } 
/* 158 */       JSONArray descs = (JSONArray)doc.get(0);
/* 159 */       JSONArray keys = (JSONArray)doc.get(1);
/* 160 */       JSONArray types = (JSONArray)doc.get(2);
/* 161 */       String k_type = type(types.get(0));
/* 162 */       if (!superClasses.containsKey(clsName)) {
/* 163 */         for (int i = 0; i < keys.size(); i++) {
/* 164 */           String field = getFieldName(keys.get(i).toString());
/* 165 */           if (field == null) {
/* 166 */             Out.warn(new Object[] { "空列：", file.getAbsolutePath() });
/*     */           } else {
/*     */             
/* 169 */             builder.append("\t/** ").append(descs.get(i)).append(" */\n");
/* 170 */             builder.append("\tpublic ").append(type(types.get(i)));
/* 171 */             builder.append(" ").append(field).append(";\n");
/*     */           } 
/* 173 */         }  builder.append(String.format("\n\t/** 主键 */\n\tpublic %s getKey() {\n\t\treturn this.%s; \n\t}\n", new Object[] { k_type, 
/* 174 */                 getFieldName(keys.get(0).toString()) }));
/*     */         
/* 176 */         builder.append("\n\t/** 构造属性 */\n\tpublic void initProperty() { }\n");
/*     */       } 
/*     */       
/* 179 */       builder.append("\n\t/** 构造前置属性 */\n\tpublic void beforeProperty() { }\n");
/*     */       
/* 181 */       builder.append("\n}");
/*     */       
/* 183 */       String keyName = clsName;
/* 184 */       String classNameExt = baseName + extendClass;
/* 185 */       if (Classes.containsKey(classNameExt)) {
/* 186 */         keyName = classNameExt;
/*     */       }
/*     */       
/* 189 */       if (k_type.equals("int")) {
/* 190 */         k_type = "Integer";
/*     */       }
/* 192 */       BaseBuilder.append(String.format("\tpublic static Map<%s, %s> %ss = new HashMap<%s, %s>();\n", new Object[] { k_type, keyName, baseName, k_type, keyName }));
/*     */ 
/*     */ 
/*     */       
/* 196 */       BaseBuilder.append("\t");
/* 197 */       BaseBuilder.append("public static List<" + keyName + "> find" + baseName + "s(Predicate<" + keyName + "> pre) {\n");
/* 198 */       BaseBuilder.append("\t\tList<" + keyName + "> results = new ArrayList<>();\n");
/* 199 */       BaseBuilder.append("\t\tfor(" + keyName + " t : " + baseName + "s.values()) {\n");
/* 200 */       BaseBuilder.append("\t\t\tif(pre.test(t)) {\n");
/* 201 */       BaseBuilder.append("\t\t\t\tresults.add(t);\n");
/* 202 */       BaseBuilder.append("\t\t\t}\n\t\t}\n");
/* 203 */       BaseBuilder.append("\t\treturn results;\n");
/* 204 */       BaseBuilder.append("\t}\r\n\n");
/*     */       
/* 206 */       BaseBuilder.append("");
/* 207 */       clsName = clsName + ".java";
/* 208 */       Out.info(new Object[] { "生成：", clsName });
/* 209 */       FileUtil.write(new File(DIR + clsName), builder.toString());
/* 210 */     } catch (Exception e) {
/* 211 */       Out.error(new Object[] { e });
/* 212 */       Out.error(new Object[] { file.getAbsolutePath() });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void writeGameData() {
/* 217 */     if (BaseBuilder != null) {
/* 218 */       BaseBuilder.append("\n}");
/* 219 */       FileUtil.write(new File(DIR + "GameData.java"), BaseBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 224 */   private static Map<String, Map> Datas = new HashMap<>();
/*     */   
/*     */   public static void loadData(File file) {
/* 227 */     String fieldName = null;
/* 228 */     int row = 0;
/* 229 */     int col = 0;
/*     */     try {
/* 231 */       String name = getClassName(file.getName());
/* 232 */       String className = pakName + "." + name + "CO";
/* 233 */       String classNameExt = name + extendClass;
/* 234 */       if (Classes.containsKey(classNameExt)) {
/* 235 */         className = Classes.get(classNameExt);
/*     */       }
/* 237 */       String dataName = name + "s";
/* 238 */       JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
/* 239 */       if (doc.size() < 3) {
/* 240 */         Out.debug(new Object[] { file.getAbsolutePath(), " json doc row < 3" });
/*     */         
/*     */         return;
/*     */       } 
/* 244 */       Map<Object, Object> data = (Map)ClassUtil.getStaticProperty(Class.forName(pakName + ".GameData"), dataName);
/* 245 */       if (!Datas.containsKey(dataName)) {
/* 246 */         Datas.put(dataName, data);
/*     */       } else {
/* 248 */         Out.error(new Object[] { dataName, " 数据表名冲突 -> ", file.getAbsolutePath() });
/*     */         return;
/*     */       } 
/* 251 */       JSONArray keys = (JSONArray)doc.get(1);
/* 252 */       Class<?> clz = null;
/*     */       
/*     */       try {
/* 255 */         clz = Class.forName(pakName + ".ext." + classNameExt);
/* 256 */       } catch (Exception e) {
/* 257 */         clz = Class.forName(className);
/*     */       } 
/* 259 */       Object owner = null;
/* 260 */       Field field = null;
/* 261 */       Map<String, Field> fields = new HashMap<>();
/* 262 */       for (int i = 3; i < doc.size(); i++) {
/* 263 */         row = i;
/* 264 */         owner = clz.newInstance();
/* 265 */         JSONArray values = (JSONArray)doc.get(i);
/* 266 */         for (int k = 0; k < keys.size(); k++) {
/* 267 */           col = k;
/* 268 */           fieldName = getFieldName(keys.get(k).toString());
/* 269 */           if (fieldName == null) {
/* 270 */             Out.debug(new Object[] { file.getAbsolutePath(), " ", keys.get(k), " 没有这个字段名" });
/*     */           } else {
/*     */             
/* 273 */             Object o = values.get(k);
/* 274 */             field = fields.get(fieldName);
/* 275 */             if (field == null) {
/* 276 */               field = ClassUtil.getDeclaredField(owner, fieldName);
/* 277 */               fields.put(fieldName, field);
/*     */             } 
/* 279 */             if (field == null) {
/* 280 */               Out.warn(new Object[] { className, " not exists ", fieldName });
/*     */             } else {
/*     */               
/* 283 */               String typeName = field.getType().getSimpleName();
/* 284 */               if ("int".equals(typeName))
/* 285 */               { field.set(owner, Integer.valueOf(((Number)o).intValue())); }
/* 286 */               else if ("float".equals(typeName))
/* 287 */               { field.set(owner, Float.valueOf(((Number)o).floatValue())); }
/*     */               else
/* 289 */               { field.set(owner, o); } 
/*     */             } 
/*     */           } 
/* 292 */         }  Object key = ClassUtil.invokeMethod(owner, "getKey", new Object[0]);
/* 293 */         data.put(key, owner);
/*     */       } 
/* 295 */       fields.clear();
/* 296 */       Out.info(new Object[] { "加载：", dataName, " - ", Integer.valueOf(data.size()) });
/* 297 */     } catch (Exception e) {
/* 298 */       Out.error(new Object[] { e });
/* 299 */       Out.error(new Object[] { file.getAbsolutePath(), " : ", fieldName, "&row=", Integer.valueOf(row), " col=", Integer.valueOf(col) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reloadData(File file) {
/* 306 */     String fieldName = null;
/* 307 */     int row = 0;
/* 308 */     int col = 0;
/*     */     try {
/* 310 */       String name = getClassName(file.getName());
/* 311 */       String className = pakName + "." + name + "CO";
/* 312 */       String classNameExt = name + extendClass;
/* 313 */       if (Classes.containsKey(classNameExt)) {
/* 314 */         className = Classes.get(classNameExt);
/*     */       }
/* 316 */       String dataName = name + "s";
/* 317 */       JSONArray doc = JSONArray.parseArray(FileUtil.readText(file));
/* 318 */       if (doc.size() < 3) {
/* 319 */         Out.debug(new Object[] { file.getAbsolutePath(), " json doc row < 3" });
/*     */         
/*     */         return;
/*     */       } 
/* 323 */       Map<Object, Object> data = (Map)ClassUtil.getStaticProperty(Class.forName(pakName + ".GameData"), dataName);
/* 324 */       Datas.put(dataName, data);
/*     */       
/* 326 */       JSONArray keys = (JSONArray)doc.get(1);
/* 327 */       Class<?> clz = null;
/*     */       
/*     */       try {
/* 330 */         clz = Class.forName(pakName + ".ext." + classNameExt);
/* 331 */       } catch (Exception e) {
/* 332 */         clz = Class.forName(className);
/*     */       } 
/* 334 */       Object owner = null;
/* 335 */       Field field = null;
/* 336 */       Map<String, Field> fields = new HashMap<>();
/* 337 */       for (int i = 3; i < doc.size(); i++) {
/* 338 */         row = i;
/* 339 */         owner = clz.newInstance();
/* 340 */         JSONArray values = (JSONArray)doc.get(i);
/* 341 */         for (int k = 0; k < keys.size(); k++) {
/* 342 */           col = k;
/* 343 */           fieldName = getFieldName(keys.get(k).toString());
/* 344 */           if (fieldName == null) {
/* 345 */             Out.debug(new Object[] { file.getAbsolutePath(), " ", keys.get(k), " 没有这个字段名" });
/*     */           } else {
/*     */             
/* 348 */             Object o = values.get(k);
/* 349 */             field = fields.get(fieldName);
/* 350 */             if (field == null) {
/* 351 */               field = ClassUtil.getDeclaredField(owner, fieldName);
/* 352 */               fields.put(fieldName, field);
/*     */             } 
/* 354 */             if (field == null) {
/* 355 */               Out.warn(new Object[] { className, " not exists ", fieldName });
/*     */             } else {
/*     */               
/* 358 */               String typeName = field.getType().getSimpleName();
/* 359 */               if ("int".equals(typeName))
/* 360 */               { field.set(owner, Integer.valueOf(((Number)o).intValue())); }
/* 361 */               else if ("float".equals(typeName))
/* 362 */               { field.set(owner, Float.valueOf(((Number)o).floatValue())); }
/*     */               else
/* 364 */               { field.set(owner, o); } 
/*     */             } 
/*     */           } 
/* 367 */         }  Object key = ClassUtil.invokeMethod(owner, "getKey", new Object[0]);
/* 368 */         data.put(key, owner);
/*     */       } 
/* 370 */       fields.clear();
/* 371 */       Out.info(new Object[] { "重新加载：", dataName, " - ", Integer.valueOf(data.size()) });
/* 372 */     } catch (Exception e) {
/* 373 */       Out.error(new Object[] { e });
/* 374 */       Out.error(new Object[] { file.getAbsolutePath(), " : ", fieldName, "&row=", Integer.valueOf(row), " col=", Integer.valueOf(col) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void initProperty(String methodName) {
/* 380 */     for (Map.Entry<String, Map> entry : Datas.entrySet()) {
/*     */       try {
/* 382 */         long starTime = System.currentTimeMillis();
/* 383 */         Method method = null;
/* 384 */         for (Object o : ((Map)entry.getValue()).values()) {
/* 385 */           if (method == null) {
/* 386 */             Class<?> ownerClass = o.getClass();
/* 387 */             method = ownerClass.getMethod(methodName, new Class[0]);
/*     */           } 
/* 389 */           method.invoke(o, new Object[0]);
/*     */         } 
/* 391 */         long useTime = System.currentTimeMillis() - starTime;
/* 392 */         if (useTime > 0L) {
/* 393 */           Out.info(new Object[] { methodName, " - ", entry.getKey(), " use \t", Long.valueOf(useTime) });
/*     */         }
/* 395 */       } catch (Exception e) {
/* 396 */         Out.error(new Object[] { "DataUtil initProperty", e });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void initProperty() {
/* 402 */     initProperty("beforeProperty");
/* 403 */     initProperty("initProperty");
/* 404 */     Datas.clear();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\DataUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */