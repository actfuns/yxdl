/*    */ package com.wanniu.core;
/*    */ 
/*    */ import java.util.concurrent.CountDownLatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLock
/*    */ {
/*    */   private CountDownLatch counter;
/*    */   private String json;
/*    */   
/*    */   public GLock(CountDownLatch counter) {
/* 17 */     this.counter = counter;
/*    */   }
/*    */   
/*    */   public CountDownLatch getCounter() {
/* 21 */     return this.counter;
/*    */   }
/*    */   
/*    */   public void countDown() {
/* 25 */     this.counter.countDown();
/*    */   }
/*    */   
/*    */   public String getJson() {
/* 29 */     return this.json;
/*    */   }
/*    */   
/*    */   public void setJson(String json) {
/* 33 */     this.json = json;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GLock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */