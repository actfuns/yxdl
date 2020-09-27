/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.kickMemberRequest")
/*    */ public class KickMemberHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     final GuildHandler.KickMemberRequest req = GuildHandler.KickMemberRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildHandler.KickMemberResponse.Builder res = GuildHandler.KickMemberResponse.newBuilder();
/* 29 */           String kickId = req.getMemberId();
/* 30 */           WNPlayer kickPlayer = PlayerUtil.getOnlinePlayer(kickId);
/*    */           
/* 32 */           if (null != kickPlayer) {
/* 33 */             int areaType = AreaUtil.getAreaType(kickPlayer.getAreaId());
/* 34 */             if (areaType == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
/* 35 */               res.setS2CCode(500);
/* 36 */               res.setS2CMsg(LangService.getValue("IN_GDUNGEON_KICK"));
/* 37 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/*    */           } 
/* 42 */           GuildResult resData = player.guildManager.kickMember(kickId);
/* 43 */           int result = resData.result;
/* 44 */           if (result == 0) {
/* 45 */             res.setS2CCode(200);
/* 46 */             res.setS2CLeftKickNum(resData.leftKickNum);
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 50 */           if (result == -1) {
/* 51 */             res.setS2CCode(500);
/* 52 */             if (StringUtil.isNotEmpty(resData.des)) {
/* 53 */               res.setS2CMsg(resData.des);
/*    */             } else {
/* 55 */               res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/*    */             } 
/* 57 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 59 */           if (result == -2) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 62 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 64 */           if (result == -3) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("GUILD_MEMBER_NOT_EXIST"));
/* 67 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 69 */           if (result == -4) {
/* 70 */             res.setS2CCode(500);
/* 71 */             res.setS2CMsg(LangService.getValue("GUILD_KICK_JOB_TOO_LOW"));
/* 72 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 74 */           if (result == -5) {
/* 75 */             res.setS2CCode(500);
/* 76 */             res.setS2CMsg(LangService.getValue("GUILD_JOIN_TIME_TOO_SHORT"));
/* 77 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 79 */           if (result == -6) {
/* 80 */             res.setS2CCode(500);
/* 81 */             res.setS2CMsg(LangService.getValue("GUILD_KICK_NUM_NOT_ENOUGH"));
/* 82 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 85 */           res.setS2CCode(500);
/* 86 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 87 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\KickMemberHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */