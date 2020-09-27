/*    */ package com.wanniu.game.request.hookSet;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.HookSetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.hookSetHandler.changeHookSetRequest")
/*    */ public class ChangeHookSetHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     HookSetHandler.ChangeHookSetRequest msg = HookSetHandler.ChangeHookSetRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 24 */     final HookSetHandler.ChangeHookSetResponse.Builder res = HookSetHandler.ChangeHookSetResponse.newBuilder();
/* 25 */     if (player != null) {
/* 26 */       HookSetHandler.HookSetData hsd = msg.getC2SHookSetData();
/* 27 */       List<Integer> colors = hsd.getMeltQcolorList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 35 */       res.setS2CCode(200);
/* 36 */       player.getHookSet().changeHookSet(hsd);
/*    */     } else {
/*    */       
/* 39 */       res.setS2CCode(500);
/*    */     } 
/* 41 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 44 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\hookSet\ChangeHookSetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */