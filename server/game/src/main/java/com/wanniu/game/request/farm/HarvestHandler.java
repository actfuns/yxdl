/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.harvestRequest")
/*    */ public class HarvestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     FarmHandler.HarvestRequest msg = FarmHandler.HarvestRequest.parseFrom(this.pak.getRemaingBytes());
/* 20 */     final int blockId = msg.getBlockId();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           FarmMgr farmMgr = player.getFarmMgr();
/* 25 */           FarmHandler.HarvestResponse.Builder res = farmMgr.harvest(blockId);
/*    */           
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\HarvestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */