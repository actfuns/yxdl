/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.alibaba.fastjson.serializer.ObjectSerializer;
/*     */ import com.alibaba.fastjson.serializer.SerializeConfig;
/*     */ import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.FourProp;
/*     */ import com.wanniu.game.data.ext.AffixExt;
/*     */ import com.wanniu.game.equip.RepeatKeyMap;
/*     */ import com.wanniu.game.item.data.AttsObj;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Utils
/*     */ {
/*  36 */   private static SerializeConfig mapping = new SerializeConfig();
/*     */ 
/*     */   
/*  39 */   private static String dateFormat = "yyyy-MM-dd HH:mm:ss"; static {
/*  40 */     mapping.put(Date.class, (ObjectSerializer)new SimpleDateFormatSerializer(dateFormat));
/*     */   }
/*     */   
/*     */   public static boolean randomPercent(int per) {
/*  44 */     int ran = random(1, 100);
/*  45 */     return (ran >= 1 && ran <= per);
/*     */   }
/*     */   
/*     */   public static int getIndexByRareByList(List<Integer> rareArray) {
/*  49 */     if (rareArray == null || rareArray.size() == 0) {
/*  50 */       return 0;
/*     */     }
/*  52 */     int[] array = new int[rareArray.size()];
/*  53 */     for (int i = 0; i < rareArray.size(); i++) {
/*  54 */       array[i] = ((Integer)rareArray.get(i)).intValue();
/*     */     }
/*  56 */     return getIndexByRare(array);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getIndexByRare(int[] rareArray) {
/*  63 */     if (rareArray == null || rareArray.length == 0) {
/*  64 */       return 0;
/*     */     }
/*  66 */     int result = 0;
/*  67 */     int rares = 0;
/*  68 */     for (int rare : rareArray) {
/*  69 */       rares += rare;
/*     */     }
/*  71 */     int ranRare = random(0, rares);
/*  72 */     int maxRare = 0;
/*  73 */     for (int i = 0; i < rareArray.length; i++) {
/*  74 */       int rare = rareArray[i];
/*  75 */       maxRare += rare;
/*  76 */       if (ranRare <= maxRare) {
/*  77 */         result = i;
/*     */         break;
/*     */       } 
/*     */     } 
/*  81 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int random(int min, int max) {
/*  88 */     return RandomUtil.getInt(min, max);
/*     */   }
/*     */   
/*     */   public static final Map<String, Integer> splitItems(String itemStr, String separator1, String separator2) {
/*  92 */     Map<String, Integer> ret = new TreeMap<>();
/*  93 */     itemStr = itemStr.trim();
/*  94 */     if (itemStr != null && itemStr.length() > 0) {
/*  95 */       String[] items = itemStr.trim().split(separator1);
/*  96 */       for (String item : items) {
/*  97 */         String[] tmp = item.split(separator2);
/*  98 */         if (tmp.length > 1) {
/*  99 */           ret.put(tmp[0], Integer.valueOf(Integer.parseInt(tmp[1])));
/*     */         } else {
/* 101 */           ret.put(tmp[0], Integer.valueOf(1));
/*     */         } 
/*     */       } 
/*     */     } 
/* 105 */     return ret;
/*     */   }
/*     */   
/*     */   public static final List<Map<String, Object>> splitItems2(String itemStr, String separator1, String separator2) {
/* 109 */     List<Map<String, Object>> ret = new ArrayList<>();
/* 110 */     itemStr = itemStr.trim();
/* 111 */     if (itemStr != null && itemStr.length() > 0) {
/* 112 */       String[] items = itemStr.trim().split(separator1);
/* 113 */       for (String item : items) {
/* 114 */         String[] tmp = item.split(separator2);
/*     */         
/* 116 */         Map<String, Object> map = new HashMap<>();
/* 117 */         map.put("itemCode", tmp[0]);
/* 118 */         map.put("itemNum", Integer.valueOf((tmp.length > 1) ? Integer.parseInt(tmp[1]) : 1));
/* 119 */         map.put("forceType", (tmp.length > 2) ? Const.ForceType.getE(Integer.parseInt(tmp[1])) : Const.ForceType.DEFAULT);
/* 120 */         ret.add(map);
/*     */       } 
/*     */     } 
/* 123 */     return ret;
/*     */   }
/*     */   
/*     */   public static final int[] listToArray(List<Integer> list) {
/* 127 */     int[] ret = new int[list.size()];
/* 128 */     for (int i = list.size() - 1; i >= 0; i--) {
/* 129 */       ret[i] = ((Integer)list.get(i)).intValue();
/*     */     }
/* 131 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getZeroDate() {
/* 140 */     Date date = new Date();
/* 141 */     Calendar c = Calendar.getInstance();
/* 142 */     c.setTime(date);
/* 143 */     c.set(11, 0);
/* 144 */     c.set(12, 0);
/* 145 */     c.set(13, 0);
/* 146 */     c.set(14, 0);
/*     */     
/* 148 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T clone(T t) {
/* 156 */     T newObj = null;
/*     */     try {
/* 158 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 159 */       ObjectOutputStream oos = new ObjectOutputStream(baos);
/* 160 */       oos.writeObject(t);
/*     */ 
/*     */       
/* 163 */       ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
/* 164 */       ObjectInputStream ois = new ObjectInputStream(bais);
/* 165 */       newObj = (T)ois.readObject();
/* 166 */     } catch (Exception e) {
/* 167 */       Out.error(new Object[] { e });
/*     */     } 
/* 169 */     return newObj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deepCopyAffix(Map<String, Integer> data, Map<Integer, Integer> source, int qcolor) {
/* 178 */     if (source == null) {
/*     */       return;
/*     */     }
/* 181 */     for (Map.Entry<Integer, Integer> entry : source.entrySet()) {
/* 182 */       AffixExt affix = (AffixExt)GameData.Affixs.get(entry.getKey());
/* 183 */       if (affix == null) {
/* 184 */         Out.warn(new Object[] { "key=" + entry.getKey() + " val=" + entry.getValue() });
/*     */         continue;
/*     */       } 
/* 187 */       FourProp pair = (FourProp)affix.props.get(Integer.valueOf(qcolor));
/* 188 */       if (pair == null) {
/*     */         continue;
/*     */       }
/* 191 */       if (data.get(pair.prop) != null && ((Integer)data.get(pair.prop)).intValue() > 0) {
/* 192 */         data.put(pair.prop, Integer.valueOf(((Integer)data.get(pair.prop)).intValue() + ((Integer)entry.getValue()).intValue())); continue;
/*     */       } 
/* 194 */       data.put(pair.prop, entry.getValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deepCopyAffix(Map<String, Integer> data, RepeatKeyMap<Integer, Integer> source, int qcolor) {
/* 205 */     if (source == null) {
/*     */       return;
/*     */     }
/* 208 */     for (RepeatKeyMap.Pair<Integer, Integer> entry : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)source.entrySet()) {
/* 209 */       AffixExt affix = (AffixExt)GameData.Affixs.get(entry.k);
/* 210 */       if (affix == null) {
/* 211 */         Out.warn(new Object[] { "key=" + entry.k + " val=" + entry.v });
/*     */         continue;
/*     */       } 
/* 214 */       FourProp pair = (FourProp)affix.props.get(Integer.valueOf(qcolor));
/* 215 */       if (pair == null) {
/*     */         continue;
/*     */       }
/* 218 */       if (data.get(pair.prop) != null && ((Integer)data.get(pair.prop)).intValue() > 0) {
/* 219 */         data.put(pair.prop, Integer.valueOf(((Integer)data.get(pair.prop)).intValue() + ((Integer)entry.v).intValue())); continue;
/*     */       } 
/* 221 */       data.put(pair.prop, entry.v);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deepCopy(Map<String, Integer> data, Map<String, Integer> source) {
/* 230 */     if (source == null) {
/*     */       return;
/*     */     }
/* 233 */     for (Map.Entry<String, Integer> entry : source.entrySet()) {
/* 234 */       if (data.get(entry.getKey()) != null && ((Integer)data.get(entry.getKey())).intValue() > 0) {
/* 235 */         data.put(entry.getKey(), Integer.valueOf(((Integer)data.get(entry.getKey())).intValue() + ((Integer)entry.getValue()).intValue())); continue;
/*     */       } 
/* 237 */       data.put(entry.getKey(), entry.getValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void deepCopy(Map<String, Integer> data, List<AttsObj> source) {
/* 246 */     for (AttsObj entry : source) {
/* 247 */       if (data.get(entry.key) != null && ((Integer)data.get(entry.key)).intValue() > 0) {
/* 248 */         data.put(entry.key, Integer.valueOf(((Integer)data.get(entry.key)).intValue() + entry.value)); continue;
/*     */       } 
/* 250 */       data.put(entry.key, Integer.valueOf(entry.value));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deepCopy(Map<String, Integer> data, AttsObj source) {
/* 256 */     if (source == null) {
/*     */       return;
/*     */     }
/* 259 */     if (data.get(source.key) != null && ((Integer)data.get(source.key)).intValue() > 0) {
/* 260 */       data.put(source.key, Integer.valueOf(((Integer)data.get(source.key)).intValue() + source.value));
/*     */     } else {
/* 262 */       data.put(source.key, Integer.valueOf(source.value));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Date getTodayTimeFromString(String stringTime, String separator) {
/* 267 */     String separatorStr = ":";
/* 268 */     if (separator != null) {
/* 269 */       separatorStr = separator;
/*     */     }
/* 271 */     String[] numbers = stringTime.split(separatorStr);
/* 272 */     Date date = new Date();
/* 273 */     Calendar c = Calendar.getInstance();
/* 274 */     c.setTime(date);
/* 275 */     if (numbers.length == 3) {
/* 276 */       c.set(11, Integer.parseInt(numbers[0]));
/* 277 */       c.set(12, Integer.parseInt(numbers[1]));
/* 278 */       c.set(13, Integer.parseInt(numbers[2]));
/*     */     } 
/* 280 */     return c.getTime();
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
/*     */   public static <K, V> Map<K, V> ofMap(Object... params) {
/* 292 */     LinkedHashMap<K, V> result = new LinkedHashMap<>();
/*     */ 
/*     */     
/* 295 */     if (params == null || params.length == 0) {
/* 296 */       return result;
/*     */     }
/*     */ 
/*     */     
/* 300 */     int len = params.length;
/* 301 */     for (int i = 0; i < len; i += 2) {
/* 302 */       K key = (K)params[i];
/* 303 */       V val = (V)params[i + 1];
/*     */       
/* 305 */       result.put(key, val);
/*     */     } 
/*     */     
/* 308 */     return result;
/*     */   }
/*     */   
/*     */   public static String toJSONString(Object... params) {
/* 312 */     JSONObject json = toJSON(params);
/* 313 */     return json.toJSONString();
/*     */   }
/*     */   
/*     */   public static JSONObject toJSON(Object... params) {
/* 317 */     JSONObject json = new JSONObject(params.length / 2);
/*     */     
/* 319 */     if (params != null)
/*     */     {
/* 321 */       for (int i = 0, len = params.length; i < len; i += 2) {
/* 322 */         json.put(params[i].toString(), params[i + 1]);
/*     */       }
/*     */     }
/* 325 */     return json;
/*     */   }
/*     */   
/*     */   public static String serialize(Object obj) {
/* 329 */     return JSON.toJSONString(obj, mapping, new com.alibaba.fastjson.serializer.SerializerFeature[0]);
/*     */   }
/*     */   
/*     */   public static <T> T deserialize(String buf, Class<T> clazz) {
/* 333 */     return (T)JSON.parseObject(buf, clazz);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] longToByte(long number) {
/* 338 */     long temp = number;
/* 339 */     byte[] b = new byte[8];
/* 340 */     for (int i = 0; i < b.length; i++) {
/* 341 */       b[i] = (new Long(temp & 0xFFL)).byteValue();
/* 342 */       temp >>= 8L;
/*     */     } 
/* 344 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long byteToLong(byte[] b) {
/* 349 */     long s = 0L;
/* 350 */     long s0 = (b[0] & 0xFF);
/* 351 */     long s1 = (b[1] & 0xFF);
/* 352 */     long s2 = (b[2] & 0xFF);
/* 353 */     long s3 = (b[3] & 0xFF);
/* 354 */     long s4 = (b[4] & 0xFF);
/* 355 */     long s5 = (b[5] & 0xFF);
/* 356 */     long s6 = (b[6] & 0xFF);
/* 357 */     long s7 = (b[7] & 0xFF);
/*     */ 
/*     */     
/* 360 */     s1 <<= 8L;
/* 361 */     s2 <<= 16L;
/* 362 */     s3 <<= 24L;
/* 363 */     s4 <<= 32L;
/* 364 */     s5 <<= 40L;
/* 365 */     s6 <<= 48L;
/* 366 */     s7 <<= 56L;
/* 367 */     s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
/* 368 */     return s;
/*     */   }
/*     */   
/*     */   public static int getStackLineNumber() {
/* 372 */     return Thread.currentThread().getStackTrace()[0].getLineNumber();
/*     */   }
/*     */   
/*     */   public static int getSecMills(int min, int max) {
/* 376 */     return RandomUtil.getInt(min, max) * 1000;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */