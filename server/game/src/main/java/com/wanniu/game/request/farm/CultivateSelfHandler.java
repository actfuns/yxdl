/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.cultivateSelfRequest")
/*    */ public class CultivateSelfHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FarmHandler.CultivateSelfRequest msg = FarmHandler.CultivateSelfRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int blockId = msg.getBlockId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FarmHandler.CultivateSelfResponse.Builder res = FarmHandler.CultivateSelfResponse.newBuilder();
/* 27 */           FarmMgr farmMgr = player.getFarmMgr();
/*    */           
/* 29 */           boolean cultivateRes = farmMgr.cultivateSelf(blockId);
/* 30 */           if (!cultivateRes) {
/*    */             
/* 32 */             res.setS2CCode(500);
/* 33 */             res.setS2CMsg(LangService.getValue("FARM_CULTIVATE_FAIL"));
/* 34 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 37 */           res.setS2CCode(200);
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\CultivateSelfHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */