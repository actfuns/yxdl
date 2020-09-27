/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.ChangePkModelRequest")
/*    */ public class ChangePkModelHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 32 */     PlayerHandler.ChangPkModelRequest req = PlayerHandler.ChangPkModelRequest.parseFrom(this.pak.getRemaingBytes());
/* 33 */     final int reqModel = req.getC2SModel();
/*    */ 
/*    */     
/* 36 */     MapBase sceneProp = (player.getArea()).prop;
/* 37 */     if (sceneProp.changePKtype == 0) {
/* 38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("AREA_CANNOT_CHANG_PKMODE"));
/*    */     }
/*    */     
/* 41 */     int levelReq = GlobalConfig.PK_LevelReq;
/*    */     
/* 43 */     if (levelReq > 0 && player.getLevel() < levelReq) {
/* 44 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PK_LEVEL_REQ").replace("{0}", String.valueOf(levelReq)));
/*    */     }
/*    */     
/* 47 */     if (reqModel == Const.PkModel.Team.value && !player.getTeamManager().isInTeam()) {
/* 48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_TEAM"));
/*    */     }
/* 50 */     if (reqModel == Const.PkModel.Guild.value && player.guildManager.guild == null) {
/* 51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("NOTHAVE_GUILD"));
/*    */     }
/*    */     
/* 54 */     if (reqModel != player.pkRuleManager.pkData.pkModel) {
/* 55 */       player.pkRuleManager.pkData.pkModel = reqModel;
/* 56 */       Out.debug(new Object[] { "ChangePkModelRequest: ", Integer.valueOf(reqModel) });
/* 57 */       player.getXmdsManager().refreshPlayerPKMode(player.getId(), reqModel);
/*    */     } 
/*    */     
/* 60 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 63 */           PlayerHandler.ChangPkModelRespone.Builder res = PlayerHandler.ChangPkModelRespone.newBuilder();
/* 64 */           res.setS2CCode(200);
/* 65 */           res.setS2CCurrentModel(reqModel);
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ChangePkModelHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */