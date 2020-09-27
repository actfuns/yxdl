/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ChangeAreaFilter
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     if (player.inPvP()) {
/* 21 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("MAP_IN_FIGHT"));
/*    */     }
/*    */     
/* 24 */     TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 25 */     if (teamMember != null && !teamMember.isLeader && teamMember.follow) {
/* 26 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_FOLLOW_CHANGE_AREA"));
/*    */     }
/*    */     
/* 29 */     return request(player);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;
/*    */   
/*    */   public short getType() {
/* 36 */     return 1281;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ChangeAreaFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */