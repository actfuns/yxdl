/*    */ package com.wanniu.game.five2Five;
/*    */ 
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Five2FiveTeamFilter
/*    */   implements TeamFilter
/*    */ {
/*    */   private int teamMaxNumber;
/* 14 */   private int targetId = GlobalConfig.Group_Team;
/*    */   
/*    */   public Five2FiveTeamFilter(int filterLogicServerId, int teamMaxNumber) {
/* 17 */     this.teamMaxNumber = teamMaxNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean filter(TeamData team) {
/* 22 */     return (team.isAutoTeam && team.targetId == this.targetId && team.memberCount() < this.teamMaxNumber);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveTeamFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */