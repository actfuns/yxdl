/*     */ package com.wanniu.game.consignmentShop;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.db.ModifyDataType;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ public class ConsignmentDataManager
/*     */ {
/*     */   private Date refreshTime;
/*     */   private Map<String, List<ConsignmentItemsPO>> cache;
/*     */   private Map<String, Date> cacheTime;
/*  27 */   public Map<String, ConsignmentItemsPO> items = new ConcurrentHashMap<>();
/*     */   
/*     */   public ConsignmentDataManager() {
/*  30 */     this.refreshTime = new Date();
/*  31 */     this.cache = new HashMap<>();
/*  32 */     this.cacheTime = new HashMap<>();
/*     */     
/*  34 */     ConstsTR tr = ConstsTR.consignment_itemsTR;
/*  35 */     long start = System.currentTimeMillis();
/*  36 */     Map<String, String> result = GCache.hgetAll(tr.value);
/*  37 */     Out.info(new Object[] { "加载寄卖行耗时:", Long.valueOf(System.currentTimeMillis() - start) });
/*  38 */     if (result != null) {
/*  39 */       for (String id : result.keySet()) {
/*  40 */         ConsignmentItemsPO item = (ConsignmentItemsPO)JSON.parseObject(result.get(id), ConsignmentItemsPO.class);
/*  41 */         if (item.consignmentTime <= System.currentTimeMillis()) {
/*  42 */           GCache.hremove(tr.value, id);
/*  43 */           GameDao.delToDB(tr, id);
/*     */ 
/*     */           
/*  46 */           ConsignmentUtil.timeOutMail(item);
/*     */           continue;
/*     */         } 
/*  49 */         this.items.put(id, item);
/*     */       } 
/*     */     } else {
/*  52 */       List<ConsignmentItemsPO> list = GameDao.findFromDB(tr, null, ConsignmentItemsPO.class);
/*  53 */       for (ConsignmentItemsPO item : list) {
/*  54 */         if (item.consignmentTime <= System.currentTimeMillis()) {
/*     */           
/*  56 */           GameDao.delToDB(tr, item.id);
/*     */ 
/*     */           
/*  59 */           ConsignmentUtil.timeOutMail(item);
/*     */           continue;
/*     */         } 
/*  62 */         this.items.put(item.id, item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ConsignmentItemsPO findById(String id) {
/*  68 */     return this.items.get(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ConsignmentItemsPO> findByPlayerId(String playerId) {
/*  75 */     List<ConsignmentItemsPO> list = new ArrayList<>();
/*  76 */     for (ConsignmentItemsPO item : this.items.values()) {
/*  77 */       if (item.consignmentPlayerId.equals(playerId)) {
/*  78 */         list.add(item);
/*     */       }
/*     */     } 
/*  81 */     return list;
/*     */   }
/*     */   
/*     */   public boolean insert(ConsignmentItemsPO item) {
/*  85 */     ConsignmentItemsPO cItem = this.items.get(item.id);
/*  86 */     if (cItem == null) {
/*  87 */       this.items.put(item.id, item);
/*  88 */       this.refreshTime = new Date();
/*  89 */       return true;
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public boolean remove(String id) {
/*  95 */     ConsignmentItemsPO cItem = this.items.get(id);
/*  96 */     if (cItem == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     this.items.remove(id);
/* 100 */     GCache.hremove(ConstsTR.consignment_itemsTR.value, id);
/* 101 */     GameDao.delToDB(ConstsTR.consignment_itemsTR, id);
/*     */     
/* 103 */     this.refreshTime = new Date();
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConsignmentItems() {
/* 113 */     for (String id : this.items.keySet()) {
/*     */       
/* 115 */       GameDao.update(ConstsTR.consignment_itemsTR.value, id, this.items.get(id));
/*     */       
/* 117 */       GameDao.updateToDB(ConstsTR.consignment_itemsTR, id, ModifyDataType.MAP);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isNeedRefresh(String type) {
/* 122 */     Date cTime = this.cacheTime.get(type);
/* 123 */     if (cTime == null || cTime.getTime() <= this.refreshTime.getTime()) {
/* 124 */       return true;
/*     */     }
/*     */     
/* 127 */     return false;
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
/*     */   public static String getCacheType(int itemSecondType, int pro, int qcolor, int order, String itemType, int level) {
/* 139 */     return new String(itemSecondType + ":" + itemType + ":" + pro + qcolor + order + level);
/*     */   }
/*     */   
/*     */   public void refreshCache(int itemSecondType, int pro, int qcolor, int order, String itemType, int level) {
/* 143 */     Map<String, Object> query = new HashMap<>();
/* 144 */     if (itemSecondType != -1) {
/* 145 */       query.put("itemSeondType", Integer.valueOf(itemSecondType));
/*     */     }
/* 147 */     if (pro != -1) {
/* 148 */       query.put("pro", Integer.valueOf(pro));
/*     */     }
/*     */     
/* 151 */     if (qcolor != -1) {
/* 152 */       query.put("qColor", Integer.valueOf(qcolor));
/*     */     }
/*     */     
/* 155 */     if (StringUtil.isNotEmpty(itemType)) {
/* 156 */       String[] types = itemType.split(",");
/* 157 */       ArrayList<Integer> list = new ArrayList<>();
/* 158 */       if (types.length == 1) {
/* 159 */         list.add(Integer.valueOf(Integer.parseInt(types[0])));
/*     */       } else {
/* 161 */         for (String str : types) {
/* 162 */           list.add(Integer.valueOf(Integer.parseInt(str)));
/*     */         }
/*     */       } 
/* 165 */       query.put("itemType", list);
/*     */     } 
/*     */     
/* 168 */     if (level != 0 && level != -1) {
/* 169 */       query.put("levelReq", Integer.valueOf(level));
/*     */     }
/*     */     
/* 172 */     Out.debug(new Object[] { "query:", query });
/* 173 */     Out.debug(new Object[] { "order:", Integer.valueOf(order) });
/* 174 */     List<ConsignmentItemsPO> data = find(query, order);
/* 175 */     String type = getCacheType(itemSecondType, pro, qcolor, order, itemType, level);
/* 176 */     this.cache.put(type, data);
/* 177 */     this.cacheTime.put(type, new Date());
/*     */     
/* 179 */     Out.debug(new Object[] { "type " + type + " cache:", this.cache });
/*     */   }
/*     */   
/*     */   public List<ConsignmentItemsPO> getCache(String type) {
/* 183 */     List<ConsignmentItemsPO> list = this.cache.get(type);
/* 184 */     List<ConsignmentItemsPO> result = new ArrayList<>();
/* 185 */     long now = System.currentTimeMillis();
/* 186 */     for (ConsignmentItemsPO item : list) {
/*     */       
/* 188 */       if (item.consignmentTime - ConsignmentUtil.sellTime() > now) {
/*     */         continue;
/*     */       }
/*     */       
/* 192 */       if (item.consignmentTime < now) {
/*     */         continue;
/*     */       }
/* 195 */       result.add(item);
/*     */     } 
/* 197 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ConsignmentItemsPO> data(int order) {
/* 204 */     long now = System.currentTimeMillis();
/* 205 */     List<ConsignmentItemsPO> list = new ArrayList<>();
/* 206 */     for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 207 */       ConsignmentItemsPO item = node.getValue();
/*     */       
/* 209 */       if (item.consignmentTime - ConsignmentUtil.sellTime() > now) {
/*     */         continue;
/*     */       }
/*     */       
/* 213 */       if (item.consignmentTime < now) {
/*     */         continue;
/*     */       }
/* 216 */       list.add(node.getValue());
/*     */     } 
/* 218 */     list.sort(comparator(order));
/* 219 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Comparator<ConsignmentItemsPO> comparator(final int order) {
/* 227 */     Comparator<ConsignmentItemsPO> comparator = new Comparator<ConsignmentItemsPO>()
/*     */       {
/*     */         public int compare(ConsignmentItemsPO o1, ConsignmentItemsPO o2) {
/* 230 */           if (order == Const.ConsignmentOrderType.TIME_ASC.getValue())
/* 231 */             return (int)(o1.consignmentTime - o2.consignmentTime); 
/* 232 */           if (order == Const.ConsignmentOrderType.TIME_DES.getValue())
/* 233 */             return (int)(o2.consignmentTime - o1.consignmentTime); 
/* 234 */           if (order == Const.ConsignmentOrderType.PRICE_ASC.getValue())
/* 235 */             return o1.consignmentPrice - o2.consignmentPrice; 
/* 236 */           if (order == Const.ConsignmentOrderType.PRICE_DES.getValue())
/* 237 */             return o2.consignmentPrice - o1.consignmentPrice; 
/* 238 */           if (order == Const.ConsignmentOrderType.LEVEL_ASC.getValue())
/* 239 */             return o1.level - o2.level; 
/* 240 */           if (order == Const.ConsignmentOrderType.LEVEL_DES.getValue()) {
/* 241 */             return o2.level - o1.level;
/*     */           }
/* 243 */           return 0;
/*     */         }
/*     */       };
/* 246 */     return comparator;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ConsignmentItemsPO> findByItemSeondType(int itemSecondType, List<ConsignmentItemsPO> list) {
/* 261 */     List<ConsignmentItemsPO> retList = new ArrayList<>();
/* 262 */     if (list == null) {
/* 263 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 264 */         ConsignmentItemsPO item = node.getValue();
/* 265 */         if (item.itemSecondType == itemSecondType) {
/* 266 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } else {
/* 270 */       for (ConsignmentItemsPO item : list) {
/* 271 */         if (item.itemSecondType == itemSecondType) {
/* 272 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } 
/* 276 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> findByItemId(String id, List<ConsignmentItemsPO> list) {
/* 280 */     List<ConsignmentItemsPO> retList = new ArrayList<>();
/* 281 */     if (list == null) {
/* 282 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 283 */         ConsignmentItemsPO item = node.getValue();
/* 284 */         if (item.id.equals(id)) {
/* 285 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } else {
/* 289 */       for (ConsignmentItemsPO item : list) {
/* 290 */         if (item.id.equals(id)) {
/* 291 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } 
/* 295 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> findByPro(int pro, List<ConsignmentItemsPO> list) {
/* 299 */     ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
/* 300 */     if (list == null) {
/* 301 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 302 */         ConsignmentItemsPO item = node.getValue();
/* 303 */         if (item.pro == pro) {
/* 304 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } else {
/* 308 */       for (ConsignmentItemsPO item : list) {
/* 309 */         if (item.pro == pro) {
/* 310 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } 
/* 314 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> findByQColor(int qColor, List<ConsignmentItemsPO> list) {
/* 318 */     ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
/* 319 */     if (list == null) {
/* 320 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 321 */         ConsignmentItemsPO item = node.getValue();
/* 322 */         if ((ItemUtil.getPropByCode(item.db.code)).qcolor == qColor) {
/* 323 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } else {
/* 327 */       for (ConsignmentItemsPO item : list) {
/* 328 */         if ((ItemUtil.getPropByCode(item.db.code)).qcolor == qColor) {
/* 329 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } 
/* 333 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> findByReqLevel(int level, List<ConsignmentItemsPO> list) {
/* 337 */     List<ConsignmentItemsPO> retList = new ArrayList<>();
/* 338 */     if (list == null) {
/* 339 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 340 */         ConsignmentItemsPO item = node.getValue();
/* 341 */         if (item.level == level) {
/* 342 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } else {
/* 346 */       for (ConsignmentItemsPO item : list) {
/* 347 */         if ((ItemUtil.getPropByCode(item.db.code)).levelReq == level) {
/* 348 */           retList.add(item);
/*     */         }
/*     */       } 
/*     */     } 
/* 352 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> findByItemType(List<Integer> itemType, List<ConsignmentItemsPO> list) {
/* 356 */     ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
/* 357 */     if (list == null) {
/* 358 */       for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
/* 359 */         ConsignmentItemsPO item = node.getValue();
/* 360 */         for (Integer value : itemType) {
/* 361 */           if (item.itemType == value.intValue()) {
/* 362 */             retList.add(item);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 367 */       for (ConsignmentItemsPO item : list) {
/* 368 */         for (Integer value : itemType) {
/* 369 */           if (item.itemType == value.intValue()) {
/* 370 */             retList.add(item);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 375 */     return retList;
/*     */   }
/*     */   
/*     */   private List<ConsignmentItemsPO> find(Map<String, Object> types, int order) {
/* 379 */     List<ConsignmentItemsPO> list = null;
/* 380 */     for (Map.Entry<String, Object> node : types.entrySet()) {
/* 381 */       String key = node.getKey();
/* 382 */       if (key.equals("id")) {
/* 383 */         String value = String.valueOf(node.getValue());
/* 384 */         list = findByItemId(value, list);
/*     */       } 
/* 386 */       if (key.equals("itemSeondType")) {
/* 387 */         int value = ((Integer)node.getValue()).intValue();
/* 388 */         list = findByItemSeondType(value, list); continue;
/* 389 */       }  if (key.equals("pro")) {
/* 390 */         int value = ((Integer)node.getValue()).intValue();
/* 391 */         list = findByPro(value, list); continue;
/* 392 */       }  if (key.equals("qColor")) {
/* 393 */         int value = ((Integer)node.getValue()).intValue();
/* 394 */         list = findByQColor(value, list); continue;
/* 395 */       }  if (key.equals("itemType")) {
/* 396 */         List<Integer> value = (List<Integer>)node.getValue();
/* 397 */         list = findByItemType(value, list); continue;
/* 398 */       }  if (key.equals("levelReq")) {
/* 399 */         int value = ((Integer)node.getValue()).intValue();
/* 400 */         list = findByReqLevel(value, list);
/*     */       } 
/*     */     } 
/* 403 */     list.sort(comparator(order));
/* 404 */     return list;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\consignmentShop\ConsignmentDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */