/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.area.AreaData;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.leaveDungeonRequest")
/*    */ public class LeaveDungeonHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 27 */     final Area area = player.getArea();
/*    */     
/* 29 */     if (area == null) {
/* 30 */       AreaUtil.dispatchByAreaId(player, new AreaData(player.playerTempData.historyAreaId, player.playerTempData.historyX, player.playerTempData.historyY), null);
/*    */ 
/*    */ 
/*    */       
/* 34 */       Out.warn(new Object[] { "chuxianle1!!!playerId=", player.getId(), "area null" });
/* 35 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     } 
/* 37 */     if (area.sceneType == Const.SCENE_TYPE.NORMAL.getValue()) {
/* 38 */       Out.warn(new Object[] { "chuxianle2!!!playerId=", player.getId(), "areaId=", Integer.valueOf(area.areaId), ",instanceId=", area.instanceId });
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     } 
/*    */     
/* 42 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 45 */           FightLevelHandler.LeaveDungeonResponse.Builder res = FightLevelHandler.LeaveDungeonResponse.newBuilder();
/* 46 */           String data = null;
/* 47 */           if (area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue()) {
/* 48 */             player.guildFortManager.handleLeaveArea(area.areaId);
/*    */           }
/*    */           
/* 51 */           if (area.hasHighQualityItem()) {
/* 52 */             player.puchFuncGoToPickItem();
/* 53 */             res.setS2CCode(200);
/* 54 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 57 */           data = player.fightLevelManager.leaveDungeon(player, area);
/*    */           
/* 59 */           if (data == null) {
/* 60 */             res.setS2CCode(200);
/*    */           } else {
/* 62 */             res.setS2CCode(500);
/* 63 */             res.setS2CMsg(data);
/*    */           } 
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\LeaveDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */