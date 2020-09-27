/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.DemonTowerManager;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.DemonTowerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.demonTowerHandler.startToSweepDemonTowerRequest")
/*    */ public class StartToSweepDemonTowerHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     DemonTowerHandler.StartToSweepDemonTowerRequest req = DemonTowerHandler.StartToSweepDemonTowerRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 25 */           WNPlayer player = (WNPlayer)StartToSweepDemonTowerHandler.this.pak.getPlayer();
/*    */           
/* 27 */           DemonTowerManager manager = player.demonTowerManager;
/*    */           
/* 29 */           DemonTowerHandler.StartToSweepDemonTowerResponse.Builder res = DemonTowerHandler.StartToSweepDemonTowerResponse.newBuilder();
/*    */           
/* 31 */           if (manager.po.maxFloor == 1) {
/*    */             
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_CANNOT_SWEEP"));
/* 35 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 39 */           if (manager.po.sweepCountLeft == 0) {
/*    */             
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_SWEEP_COUNT"));
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 47 */           if (manager.po.sweepEndTime != null) {
/*    */             
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_IS_SWEEPING"));
/* 51 */             this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */ 
/*    */ 
/*    */             
/*    */             return;
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 61 */           int sweepTime = GlobalConfig.SweepTime * (manager.po.maxFloor - 1);
/*    */           
/* 63 */           res.setEndTimeStamp(System.currentTimeMillis() + sweepTime);
/*    */ 
/*    */           
/* 66 */           player.demonTowerManager.StartToSweep(sweepTime);
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
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 81 */           res.setS2CCode(200);
/* 82 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\StartToSweepDemonTowerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */