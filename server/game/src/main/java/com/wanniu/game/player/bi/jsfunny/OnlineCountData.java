/*    */ package com.wanniu.game.player.bi.jsfunny;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnlineCountData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 25 */     return "data.OnlineCount";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OnlineCountData(int pcount, int rcount) {
/* 33 */     this.data.put("minute", Integer.valueOf(this.now.getHour() * 60 + this.now.getMinute()));
/* 34 */     this.data.put("pcount", Integer.valueOf(pcount));
/* 35 */     this.data.put("rcount", Integer.valueOf(rcount));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\OnlineCountData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */