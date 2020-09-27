/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
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
/*    */ @GClientEvent("area.playerHandler.getPlayerPositionRequest")
/*    */ public class GetPlayerPositionHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     PlayerHandler.GetPlayerPositionRequest req = PlayerHandler.GetPlayerPositionRequest.parseFrom(this.pak.getRemaingBytes());
/* 29 */     String playerId = req.getS2CPlayerId();
/*    */     
/* 31 */     if (StringUtil.isEmpty(playerId)) {
/* 32 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 35 */     if (!PlayerUtil.isOnline(playerId)) {
/* 36 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
/*    */     }
/*    */     
/* 39 */     final JSONObject playerNowData = PlayerUtil.getPlayerNowPosition(playerId);
/* 40 */     if (playerNowData == null) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
/*    */     }
/*    */     
/* 44 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 47 */           PlayerHandler.GetPlayerPositionResponse.Builder res = PlayerHandler.GetPlayerPositionResponse.newBuilder();
/*    */           
/* 49 */           res.setS2CCode(200);
/* 50 */           res.setS2CAreaId(playerNowData.getIntValue("areaId"));
/* 51 */           res.setS2CTemplateID(playerNowData.getIntValue("templateID"));
/* 52 */           res.setS2CInstanceId(playerNowData.getString("instanceId"));
/* 53 */           res.setS2CTargetX(playerNowData.getIntValue("x"));
/* 54 */           res.setS2CTargetY(playerNowData.getIntValue("y"));
/*    */           
/* 56 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\GetPlayerPositionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */