/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.DemonTowerManager;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.DemonTowerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.demonTowerHandler.finishSweepDemonTowerRequest")
/*    */ public class FinishSweepDemonTowerHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 26 */           WNPlayer player = (WNPlayer)FinishSweepDemonTowerHandler.this.pak.getPlayer();
/*    */           
/* 28 */           DemonTowerManager manager = player.demonTowerManager;
/*    */           
/* 30 */           DemonTowerHandler.FinishSweepDemonTowerResponse.Builder res = DemonTowerHandler.FinishSweepDemonTowerResponse.newBuilder();
/*    */ 
/*    */ 
/*    */           
/* 34 */           if (player.moneyManager.getDiamond() < GlobalConfig.SweepPrice) {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_DIAMOND"));
/* 38 */             this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 44 */           if (manager.po.sweepEndTime == null) {
/*    */             
/* 46 */             if (manager.getSweepCountLeft() <= 0) {
/*    */               
/* 48 */               res.setS2CCode(500);
/* 49 */               res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_ENOUGH_SWEEP_COUNT"));
/* 50 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/* 54 */             player.moneyManager.costDiamond(GlobalConfig.SweepPrice, Const.GOODS_CHANGE_TYPE.DemonTower);
/* 55 */             manager.po.sweepCountLeft--;
/* 56 */             manager.FinishSweep();
/*    */           
/*    */           }
/*    */           else {
/*    */ 
/*    */             
/* 62 */             player.moneyManager.costDiamond(GlobalConfig.SweepPrice, Const.GOODS_CHANGE_TYPE.DemonTower);
/* 63 */             manager.FinishSweepWhenSpeeping();
/*    */           } 
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
/* 77 */           res.setS2CCode(200);
/* 78 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\FinishSweepDemonTowerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */