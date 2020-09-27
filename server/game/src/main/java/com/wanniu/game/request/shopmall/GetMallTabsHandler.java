/*    */ package com.wanniu.game.request.shopmall;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.ShopMallHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.shopMallHandler.getMallTabsRequest")
/*    */ public class GetMallTabsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     GPlayer player = this.pak.getPlayer();
/* 22 */     final WNPlayer wPlayer = (WNPlayer)player;
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           ShopMallHandler.GetMallTabsResponse.Builder res = ShopMallHandler.GetMallTabsResponse.newBuilder();
/* 27 */           List<ShopMallHandler.MallTab.Builder> items = wPlayer.shopMallManager.getMallTabs();
/* 28 */           res.setS2CCode(200);
/* 29 */           for (int i = 0; i < items.size(); i++) {
/* 30 */             res.addS2CTabs(((ShopMallHandler.MallTab.Builder)items.get(i)).build());
/*    */           }
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\shopmall\GetMallTabsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */