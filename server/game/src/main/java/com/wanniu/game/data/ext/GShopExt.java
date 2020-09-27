/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.game.data.GShopCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.GuildShopHandler;
/*    */ 
/*    */ public class GShopExt
/*    */   extends GShopCO
/*    */ {
/*    */   public List<GuildShopHandler.ShopMoneyInfo> moneyReqList;
/*    */   
/*    */   public void initProperty() {
/* 16 */     List<GuildShopHandler.ShopMoneyInfo> _moneyReqList = new ArrayList<>();
/* 17 */     for (int i = 1; i <= 3; i++) {
/* 18 */       String typeKey = "type" + i;
/* 19 */       String valueKey = "value" + i;
/*    */       
/*    */       try {
/* 22 */         if (null != ClassUtil.getProperty(this, typeKey) && null != ClassUtil.getProperty(this, valueKey)) {
/* 23 */           GuildShopHandler.ShopMoneyInfo.Builder moneyInfo = GuildShopHandler.ShopMoneyInfo.newBuilder();
/* 24 */           moneyInfo.setType(((Integer)ClassUtil.getProperty(this, typeKey)).intValue());
/* 25 */           moneyInfo.setValue(((Integer)ClassUtil.getProperty(this, valueKey)).intValue());
/* 26 */           _moneyReqList.add(moneyInfo.build());
/*    */         } 
/* 28 */       } catch (Exception e) {
/* 29 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/* 32 */     this.moneyReqList = _moneyReqList;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\GShopExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */