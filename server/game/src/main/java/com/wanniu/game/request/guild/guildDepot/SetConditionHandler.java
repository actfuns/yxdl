/*    */ package com.wanniu.game.request.guild.guildDepot;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.guidDepot.GuildCond;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildDepotHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildDepotHandler.setConditionRequest")
/*    */ public class SetConditionHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     final GuildDepotHandler.SetConditionRequest req = GuildDepotHandler.SetConditionRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildDepotHandler.SetConditionResponse.Builder res = GuildDepotHandler.SetConditionResponse.newBuilder();
/*    */           
/* 30 */           int useLevel = req.getUseLevel();
/* 31 */           int useUpLevel = req.getUseUpLevel();
/* 32 */           int useJob = req.getUseJob();
/* 33 */           int minLevel = req.getMinLevel();
/* 34 */           int minUpLevel = req.getMinUpLevel();
/* 35 */           int minqColor = req.getMinqColor();
/* 36 */           int maxLevel = req.getMaxLevel();
/* 37 */           int maxUpLevel = req.getMaxUpLevel();
/* 38 */           int maxqColor = req.getMaxqColor();
/*    */           
/* 40 */           GuildDepotCondition cond = new GuildDepotCondition();
/* 41 */           cond.useCond = new GuildCond(useLevel, useUpLevel, useJob, 0);
/* 42 */           cond.minCond = new GuildCond(minLevel, minUpLevel, 0, minqColor);
/* 43 */           cond.maxCond = new GuildCond(maxLevel, maxUpLevel, 0, maxqColor);
/*    */           
/* 45 */           GuildResult resData = player.guildManager.setDepotCondition(cond);
/* 46 */           int result = resData.result;
/* 47 */           if (result == 0) {
/* 48 */             res.setS2CCode(200);
/*    */             
/* 50 */             GuildDepotHandler.DepotCondition condition = GuildCommonUtil.toHandlerDepot(resData.newCondition);
/* 51 */             res.setS2CCondition(condition);
/* 52 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 54 */           if (result == -1) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 57 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 59 */           if (result == -2) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("DEPOT_QUALITY_CONDITION_INVALID"));
/* 62 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 64 */           if (result == 1) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 67 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 69 */           if (result == 2) {
/* 70 */             res.setS2CCode(500);
/* 71 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 72 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 74 */           if (result == 3) {
/* 75 */             res.setS2CCode(500);
/* 76 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
/* 77 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 80 */           res.setS2CCode(500);
/* 81 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 82 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildDepot\SetConditionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */