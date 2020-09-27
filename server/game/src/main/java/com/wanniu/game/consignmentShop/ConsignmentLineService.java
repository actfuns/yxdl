/*     */ package com.wanniu.game.consignmentShop;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.ConsignmentLineHandler;
/*     */ import pomelo.item.ItemOuterClass;
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
/*     */ public class ConsignmentLineService
/*     */ {
/*     */   private static ConsignmentLineService instance;
/*     */   public static final int ONE_PAGE = 20;
/*     */   public static final int MAX_PAGE = 999;
/*     */   
/*     */   public static ConsignmentLineService getInstance() {
/*  30 */     if (instance == null) {
/*  31 */       synchronized (ConsignmentLineService.class) {
/*  32 */         if (instance == null) {
/*  33 */           instance = new ConsignmentLineService();
/*     */         }
/*     */       } 
/*     */     }
/*  37 */     return instance;
/*     */   }
/*     */   public static final int MAX_SEARCH = 100; private ConsignmentDataManager dataManager;
/*     */   public static class ConsignmentQueryParam {
/*     */     public int pro; public int qColor; public int order; public int itemSecondType; public int page;
/*     */     public String itemType;
/*     */     public int level; }
/*     */   
/*     */   private ConsignmentLineService() {
/*  46 */     this.dataManager = new ConsignmentDataManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(ConsignmentItemsPO item) {
/*  56 */     return this.dataManager.insert(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean insert(ConsignmentItemsPO item) {
/*  66 */     Out.debug(new Object[] { "ConsignmentService insert:", "item:", item });
/*  67 */     boolean ret = this.dataManager.insert(item);
/*  68 */     if (ret) {
/*     */       
/*  70 */       Out.debug(new Object[] { "寄卖行 新增物品 id:", item.id });
/*     */     } else {
/*  72 */       Out.error(new Object[] { "寄卖行新增物品不成功：", item.id });
/*     */     } 
/*     */     
/*  75 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(String id) {
/*  86 */     boolean ret = this.dataManager.remove(id);
/*  87 */     if (ret) {
/*     */       
/*  89 */       Out.debug(new Object[] { "寄卖行 主动删除物品 id:", id });
/*     */     } else {
/*  91 */       Out.error(new Object[] { "寄卖行 要删除的物品不存在:", id });
/*     */     } 
/*  93 */     return ret;
/*     */   }
/*     */   
/*     */   public ConsignmentItemsPO getById(String id) {
/*  97 */     return this.dataManager.findById(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ConsignmentItemsPO> findByPlayerId(String playerId) {
/* 104 */     return this.dataManager.findByPlayerId(playerId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCloseGame() {
/* 113 */     this.dataManager.saveConsignmentItems();
/*     */   }
/*     */   
/*     */   public final ConsignmentLineHandler.ConsignmentListResponse.Builder query(WNPlayer player, int logicServerId, ConsignmentQueryParam opts) {
/* 117 */     int pro = opts.pro;
/* 118 */     int qColor = opts.qColor;
/* 119 */     int order = opts.order;
/* 120 */     int itemSecondType = opts.itemSecondType;
/* 121 */     String itemType = opts.itemType;
/* 122 */     int level = opts.level;
/* 123 */     int page = opts.page;
/*     */     
/* 125 */     if (page > 999) {
/* 126 */       page = 999;
/*     */     }
/*     */     
/* 129 */     ConsignmentLineHandler.ConsignmentListResponse.Builder ret = ConsignmentLineHandler.ConsignmentListResponse.newBuilder();
/* 130 */     List<ItemOuterClass.ConsignmentItem> data = new ArrayList<>();
/*     */ 
/*     */     
/* 133 */     List<ConsignmentItemsPO> result = null;
/*     */     
/* 135 */     if (pro == -1 && qColor == -1 && itemSecondType == -1 && itemType.length() == 0 && (level == 0 || level == -1)) {
/*     */       
/* 137 */       result = this.dataManager.data(order);
/*     */     } else {
/* 139 */       String type = ConsignmentDataManager.getCacheType(itemSecondType, pro, qColor, order, itemType, level);
/* 140 */       if (this.dataManager.isNeedRefresh(type)) {
/* 141 */         this.dataManager.refreshCache(itemSecondType, pro, qColor, order, itemType, level);
/*     */       }
/* 143 */       result = this.dataManager.getCache(type);
/* 144 */       if (result == null) {
/* 145 */         this.dataManager.refreshCache(itemSecondType, pro, qColor, order, itemType, level);
/* 146 */         result = this.dataManager.getCache(type);
/*     */       } 
/*     */     } 
/* 149 */     ret.setS2CTotalPage((result.size() + 20 - 1) / 20);
/* 150 */     int end = page * 20;
/* 151 */     int begin = end - 20;
/* 152 */     if (begin < result.size()) {
/* 153 */       for (int i = begin; i < end && i < result.size(); i++) {
/* 154 */         ConsignmentItemsPO item = result.get(i);
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
/*     */ 
/*     */         
/* 169 */         data.add(ConsignmentUtil.buildConsignmentItem(player, item));
/*     */       } 
/* 171 */       ret.addAllS2CData(data);
/*     */     } 
/* 173 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ArrayList<ItemOuterClass.ConsignmentItem> search(WNPlayer player, int logicServerId, String condition) {
/* 183 */     List<ConsignmentItemsPO> result = this.dataManager.data(Const.ConsignmentOrderType.TIME_DES.getValue());
/*     */     
/* 185 */     ArrayList<ItemOuterClass.ConsignmentItem> ret = new ArrayList<>();
/* 186 */     for (int i = 0, sum = 0; i < result.size() && sum < 100; i++) {
/* 187 */       ConsignmentItemsPO item = result.get(i);
/* 188 */       DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
/* 189 */       if (itemBase.name.indexOf(condition) != -1) {
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
/*     */         
/* 203 */         ret.add(ConsignmentUtil.buildConsignmentItem(player, item));
/* 204 */         sum++;
/*     */       } 
/*     */     } 
/*     */     
/* 208 */     Out.debug(new Object[] { "ConsignmentService search:", ret });
/* 209 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\consignmentShop\ConsignmentLineService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */