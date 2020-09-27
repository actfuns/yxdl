/*    */ package com.wanniu.game.social;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SocialFriendCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class SocialFriendProps
/*    */ {
/*    */   public static SocialFriendCO findByID(int id) {
/* 12 */     Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
/* 13 */     for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
/* 14 */       SocialFriendCO friend = node.getValue();
/* 15 */       if (friend.iD == id) {
/* 16 */         return friend;
/*    */       }
/*    */     } 
/* 19 */     return null;
/*    */   }
/*    */   
/*    */   public static SocialFriendCO findByMSocialAction(int action) {
/* 23 */     Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
/* 24 */     for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
/* 25 */       SocialFriendCO friend = node.getValue();
/* 26 */       if (friend.mSocialAction == action) {
/* 27 */         return friend;
/*    */       }
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   public static ArrayList<SocialFriendCO> find(String key, Object value) {
/* 34 */     ArrayList<SocialFriendCO> list = new ArrayList<>();
/* 35 */     Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
/* 36 */     for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
/* 37 */       SocialFriendCO friend = node.getValue();
/* 38 */       if (key.equals("iD")) {
/* 39 */         if (friend.iD == ((Integer)value).intValue())
/* 40 */           list.add(friend);  continue;
/*    */       } 
/* 42 */       if (key.equals("mSocialAction")) {
/* 43 */         if (friend.mSocialAction == ((Integer)value).intValue())
/* 44 */           list.add(friend);  continue;
/*    */       } 
/* 46 */       if (key.equals("favorNum")) {
/* 47 */         if (friend.favorNum == ((Integer)value).intValue())
/* 48 */           list.add(friend);  continue;
/*    */       } 
/* 50 */       if (key.equals("friendshipNum")) {
/* 51 */         if (friend.friendshipNum == ((Integer)value).intValue())
/* 52 */           list.add(friend);  continue;
/*    */       } 
/* 54 */       if (key.equals("killNum") && 
/* 55 */         friend.killNum == ((Integer)value).intValue()) {
/* 56 */         list.add(friend);
/*    */       }
/*    */     } 
/*    */     
/* 60 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\social\SocialFriendProps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */