/*    */ package com.wanniu.game.request.item;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.ItemHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.itemHandler.queryItemStatusUpdateNotify")
/*    */ public class QueryItemStatusUpdateNotifyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     WNBag wnBag = player.getWnBag();
/*    */     
/* 24 */     ItemHandler.QueryItemStatusUpdateNotify req = ItemHandler.QueryItemStatusUpdateNotify.parseFrom(this.pak.getRemaingBytes());
/* 25 */     wnBag.ItemStatusUpdate(req.getIndex());
/*    */     
/* 27 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\item\QueryItemStatusUpdateNotifyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */