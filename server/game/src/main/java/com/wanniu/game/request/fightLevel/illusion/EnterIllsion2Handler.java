/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.enterLllsion2Request")
/*    */ public class EnterIllsion2Handler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 26 */     if (!isInOpenTime(player)) {
/* 27 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("FIVE_2_FIVE_NOT_IN_TIME"));
/*    */     }
/*    */     
/* 30 */     Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/* 31 */     if (members != null && !members.isEmpty() && 
/* 32 */       !player.getTeamManager().isTeamLeader()) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DUNGEON_GUILDBOSS_NOT_TEAM_LEADER"));
/*    */     }
/*    */ 
/*    */     
/* 37 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 40 */           FightLevelHandler.EnterLllsion2Response.Builder res = FightLevelHandler.EnterLllsion2Response.newBuilder();
/*    */           
/* 42 */           AreaUtil.enterArea(player, 53001);
/*    */           
/* 44 */           res.setS2CCode(200);
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isInOpenTime(WNPlayer player) {
/* 54 */     return (player.dailyActivityMgr.calIllusion2ScriptNum() == 2);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\EnterIllsion2Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */