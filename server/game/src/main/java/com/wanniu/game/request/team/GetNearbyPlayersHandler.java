/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.MessageUtil;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.getNearbyPlayersRequest")
/*    */ public class GetNearbyPlayersHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 34 */           TeamHandler.GetNearbyPlayersResponse.Builder res = TeamHandler.GetNearbyPlayersResponse.newBuilder();
/*    */           
/* 36 */           Area area = player.getArea();
/* 37 */           List<TeamHandler.Player> players = new ArrayList<>();
/* 38 */           List<String> playerIds = new ArrayList<>();
/* 39 */           for (String playerId : area.actors.keySet()) {
/* 40 */             WNPlayer actor = PlayerUtil.findPlayer(playerId);
/* 41 */             if (actor != null && actor.getLevel() >= GlobalConfig.Team_Min_Level && 
/* 42 */               !actor.getTeamManager().isInTeam() && !playerId.equals(player.getId())) {
/* 43 */               playerIds.add(playerId);
/*    */             }
/*    */           } 
/*    */           
/* 47 */           int count = playerIds.size();
/* 48 */           if (count > GlobalConfig.TeamViewMAX) {
/* 49 */             count = GlobalConfig.TeamViewMAX;
/* 50 */             Collections.shuffle(playerIds);
/*    */           } 
/*    */           
/* 53 */           for (int i = 0; i < count; i++) {
/* 54 */             String playerId = playerIds.get(i);
/* 55 */             WNPlayer player = PlayerUtil.findPlayer(playerId);
/* 56 */             TeamHandler.Player.Builder playerData = PlayerUtil.transToJson4TeamMemberSimple(player);
/* 57 */             if (TeamUtil.isHasInvitedPlayer(player, playerId)) {
/* 58 */               playerData.setIsInvited(1);
/*    */             } else {
/* 60 */               playerData.setIsInvited(0);
/*    */             } 
/* 62 */             players.add(playerData.build());
/*    */           } 
/*    */           
/* 65 */           res.setS2CCode(200);
/* 66 */           res.addAllS2CPlayers(players);
/* 67 */           res.setS2CMaxCount(MessageUtil.getSendLimit(Const.MESSAGE_TYPE.team_invite.getValue()));
/* 68 */           res.setS2CNowCount(player.messageManager.getSendedMessageLengthByType(Const.MESSAGE_TYPE.team_invite.getValue()));
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 76 */     return 772;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GetNearbyPlayersHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */