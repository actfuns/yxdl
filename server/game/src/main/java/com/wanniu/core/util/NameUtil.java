/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NameUtil
/*     */ {
/*  23 */   public static Random random = new Random();
/*     */ 
/*     */   
/*  26 */   private static List<String> NicknameLib = new ArrayList<>();
/*     */   
/*  28 */   public static final int __COUNT__ = (Locale.getDefault() == Locale.ENGLISH) ? 9 : 6;
/*     */   
/*  30 */   public static final char[] __CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
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
/*     */   public static void loadNickLib() {
/*  42 */     File nickDir = new File(GGlobal.DIR_NICKNAME);
/*  43 */     if (nickDir.exists() && nickDir.isDirectory()) {
/*  44 */       Map<String, Boolean> caches = new HashMap<>();
/*  45 */       File[] langs = nickDir.listFiles(new FileFilter()
/*     */           {
/*     */             public boolean accept(File file) {
/*  48 */               if (file.isFile()) return true; 
/*  49 */               return false;
/*     */             }
/*     */           });
/*  52 */       List<String> nicknames = null;
/*  53 */       for (File file : langs) {
/*  54 */         nicknames = FileUtil.readLines(file);
/*  55 */         for (String nickname : nicknames) {
/*  56 */           nickname = nickname.trim();
/*  57 */           if (nickname.length() > 0 && nickname.length() < __COUNT__) {
/*  58 */             if (caches.containsKey(nickname)) {
/*  59 */               Out.warn(new Object[] { "昵称库 (", file.getName(), ") ->  [", nickname, "]  已经存在！" }); continue;
/*     */             } 
/*  61 */             NicknameLib.add(nickname);
/*  62 */             caches.put(nickname, Boolean.TRUE);
/*     */           } 
/*     */         } 
/*     */         
/*  66 */         Out.info(new Object[] { "加载昵称包文件 -> ", file.getName(), "\t\t[", Integer.valueOf(nicknames.size()), " / ", Integer.valueOf(NicknameLib.size()), "]" });
/*  67 */         caches.clear();
/*     */       } 
/*     */     } else {
/*  70 */       Out.error(new Object[] { "昵称库 (", GGlobal.DIR_NICKNAME, ") 不存在！" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadLib(List<String> excludes) {
/*  79 */     loadNickLib();
/*  80 */     removeAll(excludes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String fromChars() {
/*  87 */     StringBuilder builder = new StringBuilder();
/*  88 */     int amount = 5 + random.nextInt(5);
/*  89 */     for (int i = 0; i < amount; i++) {
/*  90 */       builder.append(__CHARS[random.nextInt(__CHARS.length)]);
/*     */     }
/*  92 */     return builder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String fromLib() {
/*  99 */     if (NicknameLib.size() == 0) return null; 
/* 100 */     synchronized (NicknameLib) {
/* 101 */       return NicknameLib.get(random.nextInt(NicknameLib.size()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void remove(String nickname) {
/* 109 */     synchronized (NicknameLib) {
/* 110 */       NicknameLib.remove(nickname);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeAll(List<String> nicknames) {
/* 118 */     synchronized (NicknameLib) {
/* 119 */       NicknameLib.removeAll(nicknames);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getNickFrom(boolean lib) {
/* 128 */     return lib ? fromLib() : fromChars();
/*     */   }
/*     */ 
/*     */   
/* 132 */   private static List<String> LastnameLib = new ArrayList<>();
/*     */   
/* 134 */   private static List<String> FirstnameLib0 = new ArrayList<>();
/*     */   
/* 136 */   private static List<String> FirstnameLib1 = new ArrayList<>();
/*     */   
/*     */   public static void init() {
/* 139 */     int nickname = GConfig.getInstance().getInt("game.nickname.enable", 0);
/* 140 */     if (nickname == 1) {
/* 141 */       loadNickLib();
/* 142 */     } else if (nickname == 2) {
/* 143 */       loadNameLib();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadNameLib() {
/* 149 */     if (LastnameLib.size() > 0) {
/* 150 */       LastnameLib.clear();
/* 151 */       FirstnameLib0.clear();
/* 152 */       FirstnameLib1.clear();
/*     */     } 
/* 154 */     buildName("lastname.txt", LastnameLib, "百家姓库");
/* 155 */     buildName("firstname_0.txt", FirstnameLib0, "男名字库");
/* 156 */     buildName("firstname_1.txt", FirstnameLib1, "女名字库");
/*     */   }
/*     */   
/*     */   private static void buildName(String name, List<String> names, String log) {
/* 160 */     File file = new File(GGlobal.DIR_NICKNAME + File.separator + "name" + File.separator + name);
/* 161 */     if (file.exists() && file.isFile()) {
/* 162 */       Map<String, Boolean> caches = new HashMap<>();
/* 163 */       List<String> firstnames = FileUtil.readLines(file);
/* 164 */       for (String firstname : firstnames) {
/* 165 */         firstname = firstname.trim();
/* 166 */         if (firstname.length() > 0 && firstname.length() < __COUNT__) {
/* 167 */           if (caches.containsKey(firstname)) {
/* 168 */             Out.warn(new Object[] { log, " (", file.getName(), ") ->  [", firstname, "]  重复存在！" }); continue;
/*     */           } 
/* 170 */           names.add(firstname);
/* 171 */           caches.put(firstname, Boolean.TRUE);
/*     */         } 
/*     */       } 
/*     */       
/* 175 */       Out.info(new Object[] { "加载", log, "文件 -> ", file.getName(), "\t\t[", Integer.valueOf(firstnames.size()), "]" });
/* 176 */       caches.clear();
/*     */     } else {
/* 178 */       Out.error(new Object[] { log, " (", file.getAbsolutePath(), ") 不存在！" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName(boolean man) {
/* 187 */     return (String)LastnameLib.get(random.nextInt(LastnameLib.size())) + (man ? FirstnameLib0
/* 188 */       .get(random.nextInt(FirstnameLib0.size())) : FirstnameLib1
/* 189 */       .get(random.nextInt(FirstnameLib1.size())));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\NameUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */