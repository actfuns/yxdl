/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.FarmPO;
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import pomelo.area.FriendHandler;
/*    */ import pomelo.farm.Farm;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.friendFarmInfoRequest")
/*    */ public class FriendFarmInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     FarmHandler.FriendFarmInfoRequest msg = FarmHandler.FriendFarmInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final String friendId = msg.getPlayerId();
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           FarmHandler.FriendFarmInfoResponse.Builder res = FarmHandler.FriendFarmInfoResponse.newBuilder();
/* 30 */           FarmMgr farmMgr = player.getFarmMgr();
/* 31 */           FarmPO farmPO = farmMgr.myPO;
/*    */ 
/*    */ 
/*    */           
/* 35 */           FriendHandler.PlayerInfo playerFriendInfo = null;
/* 36 */           for (FriendHandler.PlayerInfo tempInfo : player.friendManager.getAllFriends()) {
/* 37 */             if (tempInfo.getId().equals(friendId))
/* 38 */               playerFriendInfo = tempInfo; 
/*    */           } 
/* 40 */           if (playerFriendInfo == null) {
/*    */             
/* 42 */             res.setS2CCode(500);
/* 43 */             res.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));
/*    */           } 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 49 */           Farm.PlayerInfo.Builder playerInfoBuilder = Farm.PlayerInfo.newBuilder();
/*    */ 
/*    */           
/* 52 */           playerInfoBuilder.setPlayerId(playerFriendInfo.getId());
/*    */ 
/*    */           
/* 55 */           Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
/* 56 */           playerSummaryBuilder.setPlayerId(playerFriendInfo.getId());
/* 57 */           playerSummaryBuilder.setRoleName(playerFriendInfo.getName());
/* 58 */           playerSummaryBuilder.setLv(playerFriendInfo.getLevel());
/* 59 */           playerSummaryBuilder.setFarmLv(farmPO.lv);
/* 60 */           playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(playerFriendInfo.getId()));
/* 61 */           playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(playerFriendInfo.getId()));
/* 62 */           playerInfoBuilder.setPlayerSummary(playerSummaryBuilder.build());
/*    */ 
/*    */           
/* 65 */           for (FarmMgr.Block farmMgrBlock : farmPO.blockMap.values()) {
/* 66 */             Farm.Block.Builder blockBuilder = Farm.Block.newBuilder();
/* 67 */             blockBuilder.setBlockId(farmMgrBlock.blockId);
/* 68 */             blockBuilder.setBlockState(farmMgrBlock.blockState.value);
/* 69 */             blockBuilder.setSeedCode(farmMgrBlock.seedCode);
/* 70 */             blockBuilder.setSeedState(farmMgrBlock.seedState.value);
/* 71 */             blockBuilder.setCultivateType(farmMgrBlock.cultivateType.value);
/* 72 */             blockBuilder.setHarvestTime(FarmMgr.evaluateHarvestTime(farmPO.playerId, farmMgrBlock.blockId).getTime());
/* 73 */             Date protectionEndTime = FarmMgr.getProtectEndTime(farmPO.playerId, farmMgrBlock.blockId);
/* 74 */             if (protectionEndTime != null)
/* 75 */               blockBuilder.setProtectEndTime(protectionEndTime.getTime()); 
/* 76 */             playerInfoBuilder.addBlockLs(blockBuilder.build());
/*    */           } 
/*    */           
/* 79 */           Farm.PlayerInfo handlerPlayerInfo = playerInfoBuilder.build();
/* 80 */           res.setPlayerInfo(handlerPlayerInfo);
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
/* 95 */           res.setS2CCode(200);
/* 96 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\FriendFarmInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */