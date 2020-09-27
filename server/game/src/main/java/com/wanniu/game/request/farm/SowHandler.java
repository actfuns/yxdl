/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.PlantingCO;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.item.ItemConfig;
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
/*    */ @GClientEvent("farm.farmHandler.sowRequest")
/*    */ public class SowHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 27 */     FarmHandler.SowRequest msg = FarmHandler.SowRequest.parseFrom(this.pak.getRemaingBytes());
/* 28 */     final int blockId = msg.getBlockId();
/* 29 */     final String seedCode = msg.getSeedCode();
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           FarmHandler.SowResponse.Builder res = FarmHandler.SowResponse.newBuilder();
/* 34 */           FarmMgr farmMgr = player.getFarmMgr();
/* 35 */           FarmPO farmPO = farmMgr.myPO;
/*    */           
/* 37 */           FarmMgr.Block block = (FarmMgr.Block)farmPO.blockMap.get(Integer.valueOf(blockId));
/*    */ 
/*    */           
/* 40 */           if (block.blockState != FarmMgr.BLOCK_STATE.OPENED) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("FARM_BLOCK_CANNOT_SOW"));
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 48 */           PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/* 49 */           if (farmPO.lv < plantingCO.plantLevel) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(LangService.getValue("FARM_NOT_ENOUGH_LV"));
/* 52 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 56 */           int seedNum = player.bag.findItemNumByCode(seedCode);
/*    */ 
/*    */           
/* 59 */           if (seedNum < 1) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("FARM_NO_SEED"));
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 66 */           boolean sowRes = farmMgr.sow(blockId, seedCode);
/*    */           
/* 68 */           if (sowRes) {
/* 69 */             res.setS2CCode(200);
/*    */           } else {
/* 71 */             Out.error(new Object[] { "不会走到这里" });
/* 72 */             res.setS2CCode(500);
/*    */             
/*    */             return;
/*    */           } 
/* 76 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\SowHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */