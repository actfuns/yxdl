/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamService;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.followLeaderRequest")
/*    */ public class FollowLeaderHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     return request((WNPlayer)this.pak.getPlayer());
/*    */   }
/*    */ 
/*    */   
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 32 */     TeamHandler.FollowLeaderRequest req = TeamHandler.FollowLeaderRequest.parseFrom(this.pak.getRemaingBytes());
/* 33 */     boolean follow = (req.getFollow() == 1);
/* 34 */     TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 35 */     if (teamMember != null && follow) {
/* 36 */       TeamData team = player.getTeamManager().getTeam();
/* 37 */       if (team == null || team.islock()) {
/* 38 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_LOCKED"));
/*    */       }
/* 40 */       WNPlayer leander = PlayerUtil.getOnlinePlayer(team.leaderId);
/* 41 */       if (!player.getInstanceId().equals(leander.getInstanceId()) && !leander.getArea().isOpenJoinTeam()) {
/* 42 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_BATTLE_FOLLOW"));
/*    */       }
/*    */     } 
/* 45 */     Out.debug(new Object[] { "team follow : ", Boolean.valueOf(follow) });
/* 46 */     String res = TeamService.followLeader(player, follow);
/* 47 */     if (res != null) {
/* 48 */       return (PomeloResponse)new ErrorResponse(res);
/*    */     }
/* 50 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 53 */           TeamHandler.FollowLeaderResponse.Builder res = TeamHandler.FollowLeaderResponse.newBuilder();
/* 54 */           res.setS2CCode(200);
/* 55 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\FollowLeaderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */