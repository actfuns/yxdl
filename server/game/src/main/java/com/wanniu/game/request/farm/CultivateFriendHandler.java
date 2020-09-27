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
/*    */ @GClientEvent("farm.farmHandler.cultivateFriendRequest")
/*    */ public class CultivateFriendHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     FarmHandler.CultivateFriendRequest msg = FarmHandler.CultivateFriendRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String friendId = msg.getFriendId();
/* 22 */     final int blockId = msg.getBlockId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FarmMgr farmMgr = player.getFarmMgr();
/* 27 */           FarmHandler.CultivateFriendResponse.Builder res = farmMgr.cultivateFriend(blockId, friendId);
/*    */ 
/*    */           
/* 30 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\CultivateFriendHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */