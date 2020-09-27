/*    */ package com.wanniu.game.solo.vo;
/*    */ public class ResultVO {
/*    */   private Map<KEY, Integer> otherResult;
/*    */   public boolean result;
/*    */   public String info;
/*    */   
/*    */   public enum KEY {
/*  8 */     HAS_REWARD("hasReward"), AVG_MATCHTIME("avgMatchTime"), START_JOINTIME("startJoinTime");
/*    */     private String key;
/*    */     
/*    */     KEY(String key) {
/* 12 */       this.key = key;
/*    */     }
/*    */     
/*    */     public String getValue() {
/* 16 */       return this.key;
/*    */     }
/*    */   }
/*    */   
/*    */   public ResultVO() {
/* 21 */     this(true);
/*    */   }
/*    */   
/*    */   public ResultVO(boolean defResult) {
/* 25 */     this(defResult, "");
/*    */   }
/*    */   
/*    */   public ResultVO(boolean defResult, String defInfo) {
/* 29 */     this.result = defResult;
/* 30 */     this.info = defInfo;
/* 31 */     this.otherResult = new HashMap<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(KEY key, Integer value) {
/* 39 */     this.otherResult.put(key, value);
/*    */   }
/*    */   
/*    */   public Integer get(KEY key) {
/* 43 */     return this.otherResult.get(key);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\vo\ResultVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */