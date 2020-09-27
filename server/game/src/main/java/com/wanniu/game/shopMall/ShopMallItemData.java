/*    */ package com.wanniu.game.shopMall;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import pomelo.area.ShopMallHandler;
/*    */ 
/*    */ public class ShopMallItemData
/*    */ {
/*  8 */   public String id = "";
/*  9 */   public String code = "";
/*    */   
/*    */   public int groupCount;
/*    */   
/*    */   public int consumeScore;
/*    */   
/*    */   public int isSellOut;
/*    */   
/*    */   public int bindType;
/*    */   public int isSold;
/*    */   
/*    */   public final ShopMallHandler.MallScoreItem createMallScoreItem() {
/* 21 */     ShopMallHandler.MallScoreItem.Builder builder = ShopMallHandler.MallScoreItem.newBuilder();
/* 22 */     builder.setId(this.id);
/* 23 */     builder.setCode(this.code);
/* 24 */     builder.setGroupCount(this.groupCount);
/* 25 */     builder.setConsumeScore(this.consumeScore);
/* 26 */     builder.setIsSellOut(this.isSellOut);
/* 27 */     builder.setBindType(this.bindType);
/* 28 */     return builder.build();
/*    */   }
/*    */   
/*    */   public final String toJsonString() {
/* 32 */     return JSON.toJSONString(this);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\shopMall\ShopMallItemData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */