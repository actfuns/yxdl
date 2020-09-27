/*    */ package com.wanniu.game.request.intergalmall;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.IntergalMallHandler;
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
/*    */ @GClientEvent("area.intergalMallHandler.getMallScoreItemListRequest")
/*    */ public class GetIntergalMallListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     GPlayer player = this.pak.getPlayer();
/* 27 */     final WNPlayer wPlayer = (WNPlayer)player;
/*    */     
/* 29 */     IntergalMallHandler.GetIntergalMallListRequest req = IntergalMallHandler.GetIntergalMallListRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     final int shopType = req.getC2SType();
/*    */     
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           IntergalMallHandler.GetIntergalMallListResponse.Builder res = IntergalMallHandler.GetIntergalMallListResponse.newBuilder();
/*    */           
/* 38 */           List<IntergalMallHandler.IntergalMallTab> tabItems = wPlayer.getIntergalMallManager().getIntergalMallItemList(shopType);
/* 39 */           res.setS2CCode(200);
/* 40 */           res.addAllS2CTabitems(tabItems);
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\intergalmall\GetIntergalMallListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */