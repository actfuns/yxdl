/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.DemonTowerManager;
/*    */ import com.wanniu.game.area.AreaData;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.area.DemonTower;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.DropListExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.DemonTowerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.demonTowerHandler.startDemonTowerRequest")
/*    */ public class StartDemonTowerHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     final DemonTowerHandler.StartDemonTowerRequest req = DemonTowerHandler.StartDemonTowerRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 34 */           WNPlayer player = (WNPlayer)StartDemonTowerHandler.this.pak.getPlayer();
/* 35 */           int floorId = req.getFloorId();
/* 36 */           DemonTowerManager manager = player.demonTowerManager;
/* 37 */           Out.error(new Object[] { Integer.valueOf(floorId) });
/* 38 */           if (floorId == 0) {
/* 39 */             floorId = Math.min(manager.po.maxFloor, GameData.DropLists.size());
/*    */           }
/* 41 */           DemonTowerHandler.StartDemonTowerResponse.Builder res = DemonTowerHandler.StartDemonTowerResponse.newBuilder();
/*    */           
/* 43 */           if (!GameData.DropLists.containsKey(Integer.valueOf(floorId))) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 46 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 50 */           if (floorId > player.demonTowerManager.po.maxFloor) {
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_NOT_OPEN"));
/* 53 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 57 */           if (manager.po.sweepEndTime != null) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_IS_SWEEPING"));
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 64 */           if (manager.po.maxFloor >= GameData.DropLists.size()) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("DEMON_TOWER_IN_TOP"));
/* 67 */             this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */ 
/*    */             
/*    */             return;
/*    */           } 
/*    */ 
/*    */           
/* 75 */           DropListExt dropListExt = (DropListExt)GameData.DropLists.get(Integer.valueOf(floorId));
/* 76 */           if (dropListExt == null) {
/* 77 */             Out.error(new Object[] { "参数错误" });
/*    */             return;
/*    */           } 
/* 80 */           int mapId = dropListExt.mapId;
/* 81 */           DemonTower area = (DemonTower)AreaUtil.createArea(player, Utils.toJSON(new Object[] { "logicServerId", 
/* 82 */                   Integer.valueOf(player.getLogicServerId()), "areaId", Integer.valueOf(mapId), "lv", Integer.valueOf(floorId) }));
/* 83 */           AreaData areaData = new AreaData(area.areaId, area.instanceId);
/* 84 */           AreaUtil.changeArea(player, areaData);
/*    */ 
/*    */           
/* 87 */           res.setS2CCode(200);
/* 88 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\StartDemonTowerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */