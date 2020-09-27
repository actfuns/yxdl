/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.google.protobuf.GeneratedMessage;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.common.msg.MessagePush;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.summonRequest")
/*    */ public class SummonHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 30 */     TeamData team = player.getTeamManager().getTeam();
/* 31 */     if (team == null) {
/* 32 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */     }
/*    */     
/* 35 */     TeamHandler.SummonRequest msg = TeamHandler.SummonRequest.parseFrom(this.pak.getRemaingBytes());
/* 36 */     String targetId = msg.getC2STeamMemberId();
/*    */     
/* 38 */     Area area = player.getArea();
/* 39 */     String content = LangService.getValue("TEAM_SUMMON_MESSAGE").replace("{1}", area.getSceneName()).replace("{2}", String.valueOf(area.lineIndex));
/* 40 */     TeamHandler.OnSummonTeamPush.Builder data = TeamHandler.OnSummonTeamPush.newBuilder();
/* 41 */     data.setS2CId(team.id);
/* 42 */     data.setS2CContent(content);
/* 43 */     String targetNmae = null;
/* 44 */     MessagePush push = new MessagePush("area.teamPush.onSummonTeamPush", (GeneratedMessage)data.build());
/* 45 */     if (StringUtil.isNotEmpty(targetId)) {
/* 46 */       if (!PlayerUtil.isOnline(targetId)) {
/* 47 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
/*    */       }
/* 49 */       WNPlayer other = PlayerUtil.getOnlinePlayer(targetId);
/* 50 */       if (!other.getArea().isNormal()) {
/* 51 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_TARGET_IN_RAID"));
/*    */       }
/* 53 */       TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
/* 54 */       TeamData.TeamMemberData targetTeamMember = other.getTeamManager().getTeamMember();
/*    */       
/* 56 */       if (selfTeamMember == null || !selfTeamMember.isLeader || targetTeamMember == null || 
/* 57 */         !selfTeamMember.teamId.equals(targetTeamMember.teamId)) {
/* 58 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_SUMMON_NOT_LEADER"));
/*    */       }
/*    */       
/* 61 */       if (player.getInstanceId().equals(other.getInstanceId()) && targetTeamMember.follow) {
/* 62 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_SUMMON_FAIL_TARGET_INSTANCE"));
/*    */       }
/* 64 */       other.receive((Message)push);
/* 65 */       targetNmae = other.getName();
/*    */     } else {
/* 67 */       targetNmae = LangService.getValue("TEAM_MEMBER");
/* 68 */       for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 69 */         if (!member.follow && !member.isLeader) {
/* 70 */           WNPlayer mPlayer = member.getPlayer();
/* 71 */           if (mPlayer != null) {
/* 72 */             mPlayer.receive((Message)push);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 78 */     PlayerUtil.sendSysMessageToPlayer(LangService.format("TEAM_SUMMON_SEND_MESSAGE", new Object[] { targetNmae }), player.getId(), Const.TipsType.BLACK);
/*    */     
/* 80 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 83 */           TeamHandler.SummonResponse.Builder res = TeamHandler.SummonResponse.newBuilder();
/*    */           
/* 85 */           res.setS2CCode(200);
/* 86 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\SummonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */