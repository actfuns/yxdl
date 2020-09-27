/*    */ package com.wanniu.game.redpacket;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class RedPacketFetchInfo
/*    */ {
/*    */   public int num;
/*    */   public String fetcherId;
/*    */   public String fetcherName;
/*    */   public Date fetchDate;
/*    */   
/*    */   public RedPacketFetchInfo() {
/* 14 */     this.num = 0;
/* 15 */     this.fetcherId = null;
/* 16 */     this.fetcherName = null;
/* 17 */     this.fetchDate = null;
/*    */   }
/*    */   
/*    */   public RedPacketFetchInfo(int num) {
/* 21 */     this.num = num;
/*    */   }
/*    */   
/*    */   public void SetFetcher(String fetcherId, String fetcherName) {
/* 25 */     this.fetcherId = fetcherId;
/* 26 */     this.fetcherName = fetcherName;
/* 27 */     this.fetchDate = new Date();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\redpacket\RedPacketFetchInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */