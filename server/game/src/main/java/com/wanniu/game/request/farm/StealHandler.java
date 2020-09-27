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
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.stealRequest")
/*    */ public class StealHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     FarmHandler.StealRequest msg = FarmHandler.StealRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final int blockId = msg.getBlockId();
/* 22 */     final String friendId = msg.getFriendId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FarmMgr farmMgr = player.getFarmMgr();
/* 27 */           FarmHandler.StealResponse.Builder res = farmMgr.steal(blockId, friendId);
/*    */ 
/*    */           
/* 30 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\StealHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */