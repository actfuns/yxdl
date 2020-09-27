/*    */ package com.wanniu.game.sysSet;
/*    */ 
/*    */ public enum SysSetFlag
/*    */ {
/*  5 */   recvMailSet(1), teamInviteSet(2), recvStrangerMsgSet(4), recvAddFriendSet(8);
/*    */   
/*    */   private int value;
/*    */   
/*    */   SysSetFlag(int value) {
/* 10 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 14 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\sysSet\SysSetFlag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */