/*    */ package com.wanniu.game.vip;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import pomelo.area.VipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class VipData
/*    */ {
/*    */   public final List<VipHandler.VipGetGiftData> getGift;
/*    */   public final List<VipHandler.VipBuyGiftData> buyGift;
/*    */   public final String vipTime;
/*    */   
/*    */   public VipData(Date date) {
/* 19 */     this.getGift = new ArrayList<>();
/* 20 */     this.buyGift = new ArrayList<>();
/* 21 */     this.vipTime = String.valueOf((date != null) ? date.getTime() : System.currentTimeMillis());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\vip\VipData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */