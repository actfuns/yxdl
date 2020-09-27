/*    */ package com.wanniu.game.five2Five;
/*    */ 
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Five2FiveTeamApplyVo
/*    */ {
/*    */   public Date joinTime;
/*    */   public Map<String, TeamData.TeamMemberData> teamMembers;
/*    */   public String teamId;
/*    */   
/*    */   public Five2FiveTeamApplyVo(Map<String, TeamData.TeamMemberData> teamMembers, String teamId) {
/* 21 */     this.teamMembers = new HashMap<>();
/* 22 */     this.teamMembers.putAll(teamMembers);
/* 23 */     this.teamId = teamId;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveTeamApplyVo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */