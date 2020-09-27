/*    */ package com.wanniu.game.sysSet;
/*    */ 
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.SysSetHandler;
/*    */ import pomelo.player.PlayerOuterClass;
/*    */ 
/*    */ public class SysSetInfo
/*    */ {
/*    */   private final WNPlayer player;
/*    */   
/*    */   public SysSetInfo(WNPlayer player) {
/* 12 */     this.player = player;
/*    */   }
/*    */   
/*    */   public boolean isPermission(SysSetFlag setFlag) {
/* 16 */     return ((this.player.playerAttachPO.sysSet & setFlag.getValue()) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRecvMail() {
/* 21 */     return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvMailSet.getValue()) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canTeamInvite() {
/* 26 */     return ((this.player.playerAttachPO.sysSet & SysSetFlag.teamInviteSet.getValue()) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRecvStrangerMsg() {
/* 31 */     return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvStrangerMsgSet.getValue()) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRecvAddFriend() {
/* 36 */     return ((this.player.playerAttachPO.sysSet & SysSetFlag.recvAddFriendSet.getValue()) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void changeSet(SysSetHandler.SetData setData) {
/* 41 */     int oldFlag = this.player.playerAttachPO.sysSet;
/* 42 */     int newFlag = converToFlag(setData);
/* 43 */     if (newFlag == oldFlag) {
/*    */       return;
/*    */     }
/* 46 */     this.player.playerAttachPO.sysSet = newFlag;
/*    */   }
/*    */ 
/*    */   
/*    */   public int converToFlag(SysSetHandler.SetData setData) {
/* 51 */     int ret = 0;
/* 52 */     if (setData.getRecvMailSet() > 0) {
/* 53 */       ret |= SysSetFlag.recvMailSet.getValue();
/*    */     }
/* 55 */     if (setData.getTeamInviteSet() > 0) {
/* 56 */       ret |= SysSetFlag.teamInviteSet.getValue();
/*    */     }
/* 58 */     if (setData.getRecvStrangerMsgSet() > 0) {
/* 59 */       ret |= SysSetFlag.recvStrangerMsgSet.getValue();
/*    */     }
/* 61 */     if (setData.getRecvAddFriendSet() > 0) {
/* 62 */       ret |= SysSetFlag.recvAddFriendSet.getValue();
/*    */     }
/* 64 */     return ret;
/*    */   }
/*    */   
/*    */   public SysSetHandler.SetData getSetData() {
/* 68 */     SysSetHandler.SetData.Builder ret = SysSetHandler.SetData.newBuilder();
/* 69 */     ret.setRecvMailSet(canRecvMail() ? 1 : 0);
/* 70 */     ret.setTeamInviteSet(canTeamInvite() ? 1 : 0);
/* 71 */     ret.setRecvStrangerMsgSet(canRecvStrangerMsg() ? 1 : 0);
/* 72 */     ret.setRecvAddFriendSet(canRecvAddFriend() ? 1 : 0);
/* 73 */     return ret.build();
/*    */   }
/*    */   
/*    */   public PlayerOuterClass.SetData toJson4Payload() {
/* 77 */     PlayerOuterClass.SetData.Builder data = PlayerOuterClass.SetData.newBuilder();
/* 78 */     data.setRecvMailSet(canRecvMail() ? 1 : 0);
/* 79 */     data.setTeamInviteSet(canTeamInvite() ? 1 : 0);
/* 80 */     data.setRecvStrangerMsgSet(canRecvStrangerMsg() ? 1 : 0);
/* 81 */     data.setRecvAddFriendSet(canRecvAddFriend() ? 1 : 0);
/* 82 */     return data.build();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\sysSet\SysSetInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */