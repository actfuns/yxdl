/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.ExchangeMallCO;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExchangeMallExt
/*    */   extends ExchangeMallCO
/*    */ {
/*    */   public Map<String, Integer> exchangeNeedMap;
/*    */   public Date startTime;
/*    */   public Date endTime;
/*    */   
/*    */   public void initProperty() {
/* 30 */     this.exchangeNeedMap = new HashMap<>();
/*    */     
/* 32 */     String[] strs1 = this.exchangeNeed.split(";");
/* 33 */     for (String strItem : strs1) {
/*    */       
/* 35 */       String[] strs2 = strItem.split(":");
/* 36 */       this.exchangeNeedMap.put(strs2[0], Integer.valueOf(Integer.parseInt(strs2[1])));
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 41 */     String periodStart = this.periodStart;
/* 42 */     if (StringUtil.isNotEmpty(periodStart)) {
/* 43 */       this.startTime = DateUtil.format(periodStart);
/*    */     }
/*    */     
/* 46 */     String periodEnd = this.periodStart;
/* 47 */     if (StringUtil.isNotEmpty(periodEnd))
/* 48 */       this.endTime = DateUtil.format(periodEnd); 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ExchangeMallExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */