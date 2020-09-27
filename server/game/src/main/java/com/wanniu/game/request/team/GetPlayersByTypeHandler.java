/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ @GClientEvent("area.teamHandler.getPlayersByTypeRequest")
/*    */ public class GetPlayersByTypeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 35 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 36 */     TeamHandler.GetPlayersByTypeRequest msg = TeamHandler.GetPlayersByTypeRequest.parseFrom(this.pak.getRemaingBytes());
/* 37 */     final int c2s_type = msg.getC2SType();
/* 38 */     Out.debug(new Object[] { "getPlayersByTypeRequest c2s_type::", Integer.valueOf(c2s_type) });
/*    */     
/* 40 */     if (c2s_type < 1 || c2s_type > 4) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 44 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 47 */           TeamHandler.GetPlayersByTypeResponse.Builder res = TeamHandler.GetPlayersByTypeResponse.newBuilder();
/*    */           
/* 49 */           Collection<String> playerIds = null;
/*    */           
/* 51 */           if (c2s_type == 1) {
/* 52 */             playerIds = player.getFriendManager().getAllFriendId();
/* 53 */           } else if (c2s_type == 2) {
/* 54 */             playerIds = DaoYouService.getInstance().getDaoYouMemPlayerId(player.getId());
/* 55 */           } else if (c2s_type == 3) {
/* 56 */             playerIds = GuildUtil.getGuildMemberIdList(player.guildManager.getGuildId());
/*    */           } else {
/* 58 */             Area area = player.getArea();
/* 59 */             playerIds = area.actors.keySet();
/*    */           } 
/*    */           
/* 62 */           if (playerIds == null) {
/* 63 */             playerIds = new ArrayList<>(0);
/*    */           }
/*    */           
/* 66 */           List<String> finalPlayerIds = new ArrayList<>(playerIds.size());
/* 67 */           for (String rid : playerIds) {
/* 68 */             if (!TeamUtil.isInTeam(rid) && PlayerUtil.isOnline(rid) && !player.getId().equals(rid)) {
/* 69 */               finalPlayerIds.add(rid);
/*    */             }
/*    */           } 
/*    */           
/* 73 */           int maxViewCount = GlobalConfig.TeamViewMAX;
/* 74 */           if (finalPlayerIds.size() > maxViewCount) {
/* 75 */             Collections.shuffle(finalPlayerIds);
/*    */           } else {
/* 77 */             maxViewCount = finalPlayerIds.size();
/*    */           } 
/*    */           
/* 80 */           for (int i = 0; i < maxViewCount; i++) {
/* 81 */             String playerId = finalPlayerIds.get(i);
/* 82 */             TeamHandler.Player.Builder playerTeamData = PlayerUtil.transToJson4TeamMemberSimple(PlayerUtil.findPlayer(playerId));
/* 83 */             if (TeamUtil.isHasInvitedPlayer(player, playerId)) {
/* 84 */               playerTeamData.setIsInvited(1);
/*    */             } else {
/* 86 */               playerTeamData.setIsInvited(0);
/*    */             } 
/* 88 */             res.addS2CPlayers(playerTeamData.build());
/*    */           } 
/*    */           
/* 91 */           res.setS2CCode(200);
/* 92 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 98 */     return 774;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GetPlayersByTypeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */