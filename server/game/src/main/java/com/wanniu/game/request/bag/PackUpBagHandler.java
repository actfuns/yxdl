/*     */ package com.wanniu.game.request.bag;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.bag.BagUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.ItemIdConfigExt;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import pomelo.area.BagHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.bagHandler.packUpBagRequest")
/*     */ public class PackUpBagHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  33 */     BagHandler.PackUpBagRequest req = BagHandler.PackUpBagRequest.parseFrom(this.pak.getRemaingBytes());
/*  34 */     final int _type = req.getC2SType();
/*  35 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  37 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  40 */           BagHandler.PackUpBagResponse.Builder res = BagHandler.PackUpBagResponse.newBuilder();
/*     */ 
/*     */           
/*  43 */           WNBag store = BagUtil.getStoreByType(player, _type);
/*  44 */           if (store == null) {
/*  45 */             res.setS2CCode(500);
/*  46 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  47 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  52 */           if (!store.canPackUp()) {
/*  53 */             res.setS2CCode(500);
/*  54 */             res.setS2CMsg(LangService.getValue("BAG_PACKUP_CDTIME"));
/*  55 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  59 */           PackUpBagHandler.this.packUpBag(store);
/*     */           
/*  61 */           res.setS2CCode(200);
/*  62 */           res.setS2CType(_type);
/*  63 */           res.addAllS2CBagGrids(store.getGrids4PayLoad());
/*  64 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void packUpBag(WNBag bag) {
/*  70 */     bag.bagGridPackUpTime = System.currentTimeMillis();
/*     */ 
/*     */     
/*  73 */     List<NormalItem> data = bag._packUpStackNum();
/*  74 */     Collections.sort(data, new Comparator<NormalItem>()
/*     */         {
/*     */           public int compare(NormalItem left, NormalItem right) {
/*  77 */             if (left.prop == null) {
/*  78 */               Out.error(new Object[] { "Item compare prop error, code:", left.itemDb.code, ", left.prop:", left.prop });
/*     */             }
/*     */ 
/*     */             
/*  82 */             int flag = 0;
/*     */             
/*  84 */             ItemIdConfigExt itemidconfig_l = (ItemIdConfigExt)GameData.ItemIdConfigs.get(left.prop.type);
/*  85 */             ItemIdConfigExt itemidconfig_r = (ItemIdConfigExt)GameData.ItemIdConfigs.get(right.prop.type);
/*  86 */             if (itemidconfig_l.order == itemidconfig_r.order) {
/*  87 */               if (left.prop.qcolor == right.prop.qcolor) {
/*  88 */                 if (left.itemDb.gotTime.getTime() == right.itemDb.gotTime.getTime()) {
/*  89 */                   flag = 0;
/*  90 */                 } else if (left.itemDb.gotTime.getTime() < right.itemDb.gotTime.getTime()) {
/*  91 */                   flag = -1;
/*     */                 } else {
/*  93 */                   flag = 1;
/*     */                 } 
/*  95 */               } else if (left.prop.qcolor < right.prop.qcolor) {
/*  96 */                 flag = 1;
/*     */               } else {
/*  98 */                 flag = -1;
/*     */               } 
/* 100 */             } else if (itemidconfig_l.order < itemidconfig_r.order) {
/* 101 */               flag = -1;
/*     */             } else {
/* 103 */               flag = 1;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 110 */             return flag;
/*     */           }
/*     */         });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     bag.bagGrids.clear();
/* 141 */     for (int i = 0; i < data.size(); i++) {
/* 142 */       bag.bagGrids.put(Integer.valueOf(i + 1), data.get(i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     bag.usedGridCount = data.size();
/* 153 */     bag._gridNumChangePush(true);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\bag\PackUpBagHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */