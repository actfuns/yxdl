/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.getShopItemListRequest")
/*    */ public class GetShopItemListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse()
/*    */       {
/*    */ 
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 23 */           FriendHandler.GetShopItemListResponse.Builder res = FriendHandler.GetShopItemListResponse.newBuilder();
/* 24 */           res.setS2CCode(200);
/*    */           
/* 26 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\GetShopItemListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */