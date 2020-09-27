/*     */ package com.wanniu.game.auction;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.AuctionItemPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuctionDataManager
/*     */ {
/*     */   private static AuctionDataManager instance;
/*     */   
/*     */   public static AuctionDataManager getInstance() {
/*  43 */     if (instance == null) {
/*  44 */       synchronized (ConsignmentLineService.class) {
/*  45 */         if (instance == null) {
/*  46 */           instance = new AuctionDataManager();
/*     */         }
/*     */       } 
/*     */     }
/*  50 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*  54 */   public static final Map<String, AuctionItemPO> items = new ConcurrentHashMap<>();
/*     */   
/*     */   public AuctionDataManager() {
/*  57 */     long start = System.currentTimeMillis();
/*  58 */     Map<String, String> result = GCache.hgetAll(ConstsTR.auction_itemsTR.value);
/*  59 */     for (Map.Entry<String, String> e : result.entrySet()) {
/*  60 */       AuctionItemPO item = (AuctionItemPO)JSON.parseObject(e.getValue(), AuctionItemPO.class);
/*     */       
/*  62 */       boolean show = (item.state == 1);
/*  63 */       LocalDateTime now = LocalDateTime.now();
/*     */       
/*  65 */       if (StringUtils.isEmpty(item.guildId)) {
/*  66 */         item.stateOverTime = now.plusMinutes(show ? GlobalConfig.Auction_WorldShowTime : GlobalConfig.Auction_WorldBiddingTime);
/*     */       }
/*     */       else {
/*     */         
/*  70 */         item.stateOverTime = now.plusMinutes(show ? GlobalConfig.Auction_GuildShowTime : GlobalConfig.Auction_GuildBiddingTime);
/*     */       } 
/*     */       
/*  73 */       AuctionService.getInstance().addDelayJob(now, item);
/*     */       
/*  75 */       items.put(e.getKey(), item);
/*     */     } 
/*  77 */     Out.info(new Object[] { "加载竟拍数据耗时:", Long.valueOf(System.currentTimeMillis() - start), " ms" });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCloseGame() {
/*  84 */     for (Map.Entry<String, AuctionItemPO> e : items.entrySet())
/*     */     {
/*  86 */       GameDao.update(ConstsTR.auction_itemsTR.value, e.getKey(), e.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AuctionItemPO> getItemByPredicate(Predicate<? super AuctionItemPO> predicate) {
/*  96 */     return (List<AuctionItemPO>)items.values().stream().filter(predicate).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public boolean hasGuildItem(String guildId) {
/* 100 */     return items.values().stream().filter(v -> guildId.equals(v.guildId)).findFirst().isPresent();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean canEnterWorld(String itemcode) {
/* 105 */     return (items.values().stream().filter(v -> (v.guildId == null && itemcode.equals(v.db.code))).count() < 3L);
/*     */   }
/*     */   
/*     */   public boolean hasWorldItem() {
/* 109 */     return items.values().stream().filter(v -> (v.guildId == null)).findFirst().isPresent();
/*     */   }
/*     */   
/*     */   public AuctionItemPO getAuctionItem(String id) {
/* 113 */     return items.get(id);
/*     */   }
/*     */   
/*     */   public void addAuctionItem(AuctionItemPO aitem) {
/* 117 */     items.put(aitem.id, aitem);
/*     */   }
/*     */   
/*     */   public void removeAuctionItem(String id) {
/* 121 */     items.remove(id);
/* 122 */     GCache.hremove(ConstsTR.auction_itemsTR.value, id);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\auction\AuctionDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */