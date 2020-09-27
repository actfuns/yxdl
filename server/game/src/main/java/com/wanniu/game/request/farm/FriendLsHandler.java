/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.FarmPO;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FriendHandler;
/*    */ import pomelo.farm.Farm;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.friendLsRequest")
/*    */ public class FriendLsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     FarmHandler.FriendLsRequest msg = FarmHandler.FriendLsRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FarmHandler.FriendLsResponse.Builder res = FarmHandler.FriendLsResponse.newBuilder();
/* 28 */           FarmMgr farmMgr = player.getFarmMgr();
/* 29 */           FarmPO farmPO = farmMgr.myPO;
/*    */ 
/*    */           
/* 32 */           List<FriendHandler.PlayerInfo> playerFriendInfos = player.friendManager.getAllFriends();
/*    */           
/* 34 */           for (FriendHandler.PlayerInfo friendInfo : playerFriendInfos) {
/*    */ 
/*    */             
/* 37 */             Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
/* 38 */             playerSummaryBuilder.setPlayerId(friendInfo.getId());
/* 39 */             playerSummaryBuilder.setRoleName(friendInfo.getName());
/* 40 */             playerSummaryBuilder.setLv(friendInfo.getLevel());
/* 41 */             playerSummaryBuilder.setFarmLv(farmPO.lv);
/* 42 */             playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(friendInfo.getId()));
/* 43 */             playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(friendInfo.getId()));
/*    */             
/* 45 */             res.addPlayerSummary(playerSummaryBuilder.build());
/*    */           } 
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
/* 62 */           res.setS2CCode(200);
/* 63 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\FriendLsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */