/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.ChouRenManager;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendGetAllFriendsRequest")
/*    */ public class FriendGetAllFriendsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendManager friendManager = player.getFriendManager();
/* 27 */           FriendHandler.FriendGetAllFriendsResponse.Builder res = FriendHandler.FriendGetAllFriendsResponse.newBuilder();
/* 28 */           List<FriendHandler.PlayerInfo> friendList = friendManager.getAllFriends();
/* 29 */           int concernNumber = 0;
/* 30 */           for (int i = 0; i < friendList.size(); i++) {
/* 31 */             if (1 == ((FriendHandler.PlayerInfo)friendList.get(i)).getIsConcerned()) {
/* 32 */               concernNumber++;
/*    */             }
/*    */           } 
/* 35 */           res.setS2CCode(200);
/* 36 */           res.addAllFriends(friendList);
/* 37 */           res.setConcernNum(concernNumber);
/* 38 */           res.setAllConcernNum(GlobalConfig.Social_FocusNum);
/* 39 */           res.setFriendsNumMax(GlobalConfig.Social_MaxFriendNum);
/*    */           
/* 41 */           ChouRenManager chouRenManager = player.getChouRenManager();
/* 42 */           List<FriendHandler.PlayerInfo> chouRenList = chouRenManager.getAllChouRens();
/* 43 */           res.addAllChouRens(chouRenList);
/* 44 */           res.setChouRensNumMax(GlobalConfig.Social_MaxEnemyNum);
/*    */           
/* 46 */           List<FriendHandler.PlayerInfo> blackList = friendManager.getAllBlackList();
/* 47 */           res.addAllBlackList(blackList);
/* 48 */           res.setBlackListNumMax(GlobalConfig.Social_MaxBlacklistNum);
/* 49 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendGetAllFriendsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */