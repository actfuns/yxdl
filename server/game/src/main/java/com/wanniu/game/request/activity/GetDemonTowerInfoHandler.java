/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.DemonTowerManager;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.DropListExt;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.Common;
/*    */ import pomelo.area.DemonTowerHandler;
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
/*    */ @GClientEvent("area.demonTowerHandler.getDemonTowerInfoRequest")
/*    */ public class GetDemonTowerInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     final DemonTowerHandler.GetDemonTowerInfoRequest req = DemonTowerHandler.GetDemonTowerInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 35 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 37 */           WNPlayer player = (WNPlayer)GetDemonTowerInfoHandler.this.pak.getPlayer();
/* 38 */           int floorId = req.getFloorId();
/* 39 */           DemonTowerManager manager = player.demonTowerManager;
/*    */           
/* 41 */           DemonTowerHandler.GetDemonTowerInfoResponse.Builder res = DemonTowerHandler.GetDemonTowerInfoResponse.newBuilder();
/* 42 */           if (floorId == 0) {
/* 43 */             floorId = Math.min(manager.po.maxFloor, GameData.DropLists.size());
/*    */           }
/*    */ 
/*    */           
/* 47 */           res.setMaxFloor(Math.min(manager.po.maxFloor, GameData.DropLists.size()));
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
/* 58 */           Common.DemonTowerFloorInfo.Builder floorInfoBuilder = manager.getFloorInfoBuilder(floorId);
/*    */           
/* 60 */           res.setDemonTowerFloorInfo(floorInfoBuilder);
/*    */           
/* 62 */           DropListExt dropListExt = (DropListExt)GameData.DropLists.get(Integer.valueOf(floorId));
/* 63 */           res.setFcValue(dropListExt.fcValue);
/* 64 */           res.setSweepCountLeft(manager.po.sweepCountLeft);
/* 65 */           res.setSweepCountMax(GlobalConfig.ResetNum);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 73 */           res.setS2CCode(200);
/* 74 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\GetDemonTowerInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */