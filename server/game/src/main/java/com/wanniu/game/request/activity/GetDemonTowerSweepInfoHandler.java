/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.DemonTowerManager;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import pomelo.area.DemonTowerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.demonTowerHandler.getDemonTowerSweepInfoRequest")
/*    */ public class GetDemonTowerSweepInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 25 */           WNPlayer player = (WNPlayer)GetDemonTowerSweepInfoHandler.this.pak.getPlayer();
/*    */           
/* 27 */           DemonTowerManager manager = player.demonTowerManager;
/*    */           
/* 29 */           DemonTowerHandler.GetDemonTowerSweepInfoResponse.Builder res = DemonTowerHandler.GetDemonTowerSweepInfoResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 35 */           HashMap<String, Integer> rewardMap = player.demonTowerManager.ComputeSweepRewards();
/* 36 */           if (rewardMap != null)
/*    */           {
/* 38 */             for (String code : rewardMap.keySet()) {
/*    */               
/* 40 */               DemonTowerHandler.DemontTowerRewardItem.Builder itemBuilder = DemonTowerHandler.DemontTowerRewardItem.newBuilder();
/* 41 */               itemBuilder.setCode(code);
/* 42 */               itemBuilder.setValue(((Integer)rewardMap.get(code)).intValue());
/* 43 */               res.addItemView(itemBuilder.build());
/*    */             } 
/*    */           }
/*    */ 
/*    */           
/* 48 */           boolean isSweeping = !(manager.po.sweepEndTime == null);
/* 49 */           if (!isSweeping) {
/* 50 */             res.setSweepTime(GlobalConfig.SweepTime * (manager.po.maxFloor - 1));
/*    */           } else {
/* 52 */             res.setSweepTime(manager.GetSecondToEndTime());
/* 53 */           }  res.setDiamondCost(GlobalConfig.SweepPrice);
/* 54 */           res.setFloor(manager.po.maxFloor);
/* 55 */           res.setIsSweeping(isSweeping);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 61 */           res.setS2CCode(200);
/* 62 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\GetDemonTowerSweepInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */