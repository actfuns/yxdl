/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.google.protobuf.GeneratedMessage;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.TreasureClassExt;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.item.NormalItem;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.PlayerHandler;
/*    */ import pomelo.item.ItemOuterClass;
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
/*    */ @GClientEvent("area.playerHandler.getSimulateDropByTcRequest")
/*    */ public class GetSimulateDropByTcHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 35 */     if (!GWorld.DEBUG) {
/* 36 */       this.pak.getSession().close();
/* 37 */       return null;
/*    */     } 
/*    */     
/* 40 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 42 */     PlayerHandler.SimulateDropByTcRequest req = PlayerHandler.SimulateDropByTcRequest.parseFrom(this.pak.getRemaingBytes());
/* 43 */     String tcCode = req.getC2STcCode();
/* 44 */     int tcCount = req.getC2STcCount();
/* 45 */     int tcLevel = req.getC2STcLevel();
/*    */     
/* 47 */     if (tcCount > 10000) {
/* 48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SIMULATE_TOO_LARGE"));
/*    */     }
/* 50 */     TreasureClassExt prop = (TreasureClassExt)GameData.TreasureClasss.get(tcCode);
/* 51 */     if (prop == null) {
/* 52 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SIMULATE_PROP_FIND"));
/*    */     }
/* 54 */     if (prop.tcLevel < tcLevel) {
/* 55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SIMULATE_LEVEL_LOW"));
/*    */     }
/*    */     
/* 58 */     final PlayerHandler.SimulateDropByTcResponse.Builder res = PlayerHandler.SimulateDropByTcResponse.newBuilder();
/* 59 */     int runCount = 0;
/* 60 */     for (int i = 0; i < tcCount; i++) {
/* 61 */       List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(tcCode);
/* 62 */       if (tcItems.size() > 0) {
/* 63 */         runCount++;
/* 64 */         PlayerHandler.SimulateDataPush.Builder data = PlayerHandler.SimulateDataPush.newBuilder();
/* 65 */         tcItems.forEach(v -> {
/*    */               if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
/*    */                 ItemOuterClass.MiniItem.Builder propTmp = ItemUtil.getMiniItemData(v.itemCode(), v.getWorth());
/*    */                 
/*    */                 data.addS2CItems(propTmp);
/*    */               } else {
/*    */                 ItemOuterClass.MiniItem.Builder propTmp = ItemUtil.getMiniItemData(v.itemCode(), v.getNum());
/*    */                 data.addS2CItems(propTmp);
/*    */               } 
/*    */             });
/* 75 */         player.receive("area.playerPush.simulateDropPush", (GeneratedMessage)data.build());
/*    */       } 
/*    */     } 
/*    */     
/* 79 */     res.setS2CRunNum(runCount);
/* 80 */     res.setS2CSuccPer(runCount / tcCount * 100);
/*    */     
/* 82 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 85 */           res.setS2CCode(200);
/* 86 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\GetSimulateDropByTcHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */