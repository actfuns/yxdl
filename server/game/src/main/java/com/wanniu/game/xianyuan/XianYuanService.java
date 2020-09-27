/*     */ package com.wanniu.game.xianyuan;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.game.data.FateCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.XianYuanPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.xianyuan.XianYuanHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XianYuanService
/*     */ {
/*     */   private XianYuanService() {}
/*     */   
/*     */   public static XianYuanService getInstance() {
/*  26 */     return Inner.instance;
/*     */   }
/*     */   
/*     */   private static class Inner {
/*  30 */     private static XianYuanService instance = new XianYuanService();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyXianYuanGetInfo(WNPlayer player, XianYuanHandler.XianYuanResponse.Builder res) {
/*  37 */     XianYuanPO xianYuanPo = player.allBlobData.xianYuan;
/*  38 */     if (xianYuanPo == null) {
/*  39 */       res.setS2CCode(500);
/*  40 */       res.setS2CMsg(LangService.getValue("XIAN_YUAN_NOT_OPEN"));
/*     */       
/*     */       return;
/*     */     } 
/*  44 */     res.setS2CCode(200);
/*  45 */     res.setTotalXianYuan(player.moneyManager.getXianYuan());
/*  46 */     Map<Integer, Integer> reviceNumbers = xianYuanPo.reviceNumbers;
/*  47 */     Map<Integer, FateCO> fates = GameData.Fates;
/*  48 */     List<XianYuanHandler.XianYuanGetInfo> xianYuanGetInfos = new ArrayList<>();
/*  49 */     for (Map.Entry<Integer, FateCO> fate : fates.entrySet()) {
/*  50 */       XianYuanHandler.XianYuanGetInfo.Builder xianYuanGetInfo = XianYuanHandler.XianYuanGetInfo.newBuilder();
/*  51 */       int configId = ((Integer)fate.getKey()).intValue();
/*  52 */       FateCO fc = fate.getValue();
/*  53 */       xianYuanGetInfo.setConfigId(configId);
/*  54 */       int todayRecive = 0;
/*  55 */       if (reviceNumbers != null && reviceNumbers.containsKey(Integer.valueOf(configId))) {
/*  56 */         todayRecive = ((Integer)reviceNumbers.get(Integer.valueOf(configId))).intValue();
/*     */       }
/*  58 */       xianYuanGetInfo.setTodayRecive(todayRecive);
/*  59 */       xianYuanGetInfo.setTodayLimite(fc.numLimit);
/*  60 */       xianYuanGetInfos.add(xianYuanGetInfo.build());
/*     */     } 
/*  62 */     res.addAllXianYuanGetInfo(xianYuanGetInfos);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XianYuanPO createXianYuan(String playerId) {
/*  69 */     XianYuanPO xianYuanPo = new XianYuanPO();
/*  70 */     xianYuanPo.createTime = new Date();
/*  71 */     xianYuanPo.updateTime = new Date();
/*  72 */     return xianYuanPo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int processXianYuanGet(int from, XianYuanPO xianYuanPo) {
/*  81 */     FateCO fate = (FateCO)GameData.Fates.get(Integer.valueOf(from));
/*  82 */     if (fate == null || xianYuanPo == null) {
/*  83 */       return 0;
/*     */     }
/*     */     
/*  86 */     int singleNumber = fate.singleNum;
/*  87 */     int numLimit = fate.numLimit;
/*  88 */     Map<Integer, Integer> reviceNumbers = xianYuanPo.reviceNumbers;
/*  89 */     int todayReciveNum = 0;
/*  90 */     if (reviceNumbers != null) {
/*  91 */       Integer reciveNumber = reviceNumbers.get(Integer.valueOf(from));
/*  92 */       if (reciveNumber != null) {
/*  93 */         todayReciveNum = reciveNumber.intValue();
/*     */       }
/*  95 */       if (todayReciveNum >= numLimit) {
/*  96 */         return 0;
/*     */       }
/*     */       
/*  99 */       if (todayReciveNum + singleNumber > numLimit) {
/* 100 */         return numLimit - todayReciveNum;
/*     */       }
/*     */     } 
/* 103 */     return singleNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay(XianYuanPO xianYuanPo) {
/* 110 */     if (xianYuanPo.reviceNumbers != null)
/* 111 */       xianYuanPo.reviceNumbers.clear(); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\xianyuan\XianYuanService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */