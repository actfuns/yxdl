/*    */ package com.wanniu.core.game.request;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GameHandler
/*    */   extends NetHandler
/*    */ {
/*    */   public static class Watcher
/*    */   {
/*    */     public String handlerName;
/*    */     public int upcount;
/*    */     public int downcount;
/*    */     public long upbytes;
/*    */     public long downbytes;
/*    */     public int useTime;
/*    */     public long beginTime;
/*    */     
/*    */     public void begin(int byteCount) {
/* 26 */       if (GGame.MONITOR) {
/* 27 */         this.upbytes += byteCount;
/* 28 */         this.upbytes += 4L;
/* 29 */         this.upcount++;
/* 30 */         this.beginTime = System.currentTimeMillis();
/*    */       } 
/*    */     }
/*    */     
/*    */     public void end(int byteCount) {
/* 35 */       if (GGame.MONITOR) {
/* 36 */         this.downbytes += byteCount;
/* 37 */         this.downcount++;
/* 38 */         this.useTime = (int)(this.useTime + System.currentTimeMillis() - this.beginTime);
/*    */       } 
/*    */     }
/*    */     
/*    */     public float avgtime() {
/* 43 */       if (this.upcount == 0) return this.upcount; 
/* 44 */       return this.useTime / this.upcount;
/*    */     }
/*    */     
/*    */     public void echo() {
/* 48 */       if (this.upcount != 0)
/*    */       {
/*    */         
/* 51 */         System.out.println(toString());
/*    */       }
/*    */     }
/*    */     
/*    */     public String toString() {
/* 56 */       StringBuilder builder = new StringBuilder();
/* 57 */       builder.append("\t").append(this.handlerName).append(" : { up:").append(this.upcount).append("/").append(this.upbytes).append(" , down:")
/* 58 */         .append(this.downcount).append("/").append(this.downbytes).append(", avg:").append(avgtime()).append("/").append(this.useTime).append(" }");
/* 59 */       return builder.toString();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 64 */   public final Watcher watcher = new Watcher();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\request\GameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */