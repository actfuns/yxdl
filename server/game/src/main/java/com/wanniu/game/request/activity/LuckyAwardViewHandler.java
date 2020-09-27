/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.area.ActivityHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.luckyAwardViewRequest")
/*    */ public class LuckyAwardViewHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           WNPlayer player = (WNPlayer)LuckyAwardViewHandler.this.pak.getPlayer();
/* 22 */           ActivityHandler.LuckyAwardViewResponse.Builder res = ActivityHandler.LuckyAwardViewResponse.newBuilder();
/* 23 */           ArrayList<ItemOuterClass.MiniItem> data = player.activityManager.luckyAwardView();
/* 24 */           res.setS2CCode(200);
/* 25 */           res.addAllS2CData(data);
/* 26 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\LuckyAwardViewHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */