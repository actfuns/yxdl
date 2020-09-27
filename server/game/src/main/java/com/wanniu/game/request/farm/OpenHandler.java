/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.GetLandCO;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.FarmPO;
/*    */ import java.io.IOException;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.openRequest")
/*    */ public class OpenHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 27 */     FarmHandler.OpenRequest msg = FarmHandler.OpenRequest.parseFrom(this.pak.getRemaingBytes());
/* 28 */     final int blockId = msg.getBlockId();
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           FarmHandler.OpenResponse.Builder res = FarmHandler.OpenResponse.newBuilder();
/* 33 */           FarmMgr farmMgr = player.getFarmMgr();
/* 34 */           FarmPO farmPO = farmMgr.myPO;
/*    */           
/* 36 */           GetLandCO getLandCO = (GetLandCO)GameData.GetLands.get(Integer.valueOf(blockId));
/* 37 */           FarmMgr.Block block = (FarmMgr.Block)farmPO.blockMap.get(Integer.valueOf(blockId));
/*    */ 
/*    */           
/* 40 */           if (getLandCO.getType != FarmMgr.OPEN_BLOCK.DIAMOND.value) {
/*    */             
/* 42 */             res.setS2CCode(500);
/* 43 */             res.setS2CMsg(LangService.getValue("FARM_NO_NEED_TO_OPEN"));
/* 44 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 49 */           if (!player.moneyManager.enoughDiamond(getLandCO.value)) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(String.format(LangService.getValue("FARM_DIAMOND_NEED"), new Object[] { Integer.valueOf(getLandCO.value) }));
/* 52 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 57 */           if (block.blockState != FarmMgr.BLOCK_STATE.CLOSED) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("FARM_BLOCK_OPENED"));
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 64 */           boolean openRes = farmMgr.open(blockId);
/*    */           
/* 66 */           if (openRes) {
/* 67 */             res.setS2CCode(200);
/*    */           } else {
/*    */             
/* 70 */             Out.error(new Object[] { "不会走到这里" });
/* 71 */             res.setS2CCode(500);
/*    */             
/*    */             return;
/*    */           } 
/* 75 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\OpenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */