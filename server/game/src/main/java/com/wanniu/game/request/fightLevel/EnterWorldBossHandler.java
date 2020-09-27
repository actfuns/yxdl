/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.player.GlobalConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.enterWorldBossRequest")
/*    */ public class EnterWorldBossHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 27 */     FightLevelHandler.EnterWorldBossRequest req = FightLevelHandler.EnterWorldBossRequest.parseFrom(this.pak.getRemaingBytes());
/* 28 */     final int areaId = req.getS2CAreaId();
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           FightLevelHandler.EnterWorldBossResponse.Builder res = FightLevelHandler.EnterWorldBossResponse.newBuilder();
/*    */           
/* 35 */           Area area = player.getArea();
/*    */           
/* 37 */           if (area.areaId == areaId) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("MAP_IN_MPA"));
/* 40 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 43 */           if (AreaUtil.needCreateArea(area.areaId)) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON"));
/* 46 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 50 */           if (areaId == GlobalConfig.World_Boss_NewScene) {
/*    */             
/* 52 */             int newMapLevel = GlobalConfig.World_Boss_NewScene_Close;
/*    */             
/* 54 */             int questId = GlobalConfig.World_Boss_NweScene_Quest;
/*    */             
/* 56 */             if (player.player.level >= newMapLevel && player.taskManager.isCompleteTaskByID(questId)) {
/*    */               
/* 58 */               res.setS2CCode(500);
/* 59 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 60 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } 
/*    */           } 
/*    */           
/* 64 */           Area newArea = AreaUtil.enterArea(player, areaId);
/* 65 */           if (newArea != null) {
/* 66 */             res.setS2CCode(200);
/*    */           } else {
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg("");
/* 70 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */           
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\EnterWorldBossHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */