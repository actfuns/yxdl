/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.agreeOrRefuseInviteRequest")
/*    */ public class AgreeOrRefuseInviteHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     GuildHandler.AgreeOrRefuseInviteRequest req = GuildHandler.AgreeOrRefuseInviteRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final int isAgree = req.getC2SIsAgree();
/* 27 */     final String playerId = req.getC2SInviteId();
/* 28 */     final String guildId = req.getC2SGuildId();
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           GuildHandler.AgreeOrRefuseInviteResponse.Builder res = GuildHandler.AgreeOrRefuseInviteResponse.newBuilder();
/* 34 */           if (null == player) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 41 */           if (0 == isAgree) {
/* 42 */             String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
/* 43 */             HashMap<String, String> map = new HashMap<>();
/* 44 */             map.put("rolename", playerName);
/* 45 */             GuildCommonUtil.sendMailSystenType(playerId, "Guild_invite_refused", map);
/* 46 */             res.setS2CCode(200);
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 51 */           GuildResult resData = player.guildManager.joinGuild(guildId);
/* 52 */           int result = resData.result;
/* 53 */           if (result == 0) {
/*    */             
/* 55 */             String playerName = PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName());
/* 56 */             TreeMap<String, String> map1 = new TreeMap<>();
/* 57 */             map1.put("rolename", playerName);
/* 58 */             GuildCommonUtil.sendMailSystenType(playerId, "Guild_invite_agreed", map1);
/* 59 */             res.setS2CCode(200);
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 64 */           res.setS2CCode(500);
/* 65 */           String errMsg = GuildCommonUtil.getJoinGuildErrorMsg(resData);
/* 66 */           res.setS2CMsg(errMsg);
/* 67 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\AgreeOrRefuseInviteHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */