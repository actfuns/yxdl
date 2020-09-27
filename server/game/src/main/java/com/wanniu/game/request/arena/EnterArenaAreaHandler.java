/*    */ package com.wanniu.game.request.arena;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.solo.SoloRequestFilter;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ArenaHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.arenaHandler.enterArenaAreaRequest")
/*    */ public class EnterArenaAreaHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           ArenaHandler.EnterArenaAreaResponse.Builder res = ArenaHandler.EnterArenaAreaResponse.newBuilder();
/* 27 */           player.arenaManager.handleEnterArenaArea(res);
/* 28 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\arena\EnterArenaAreaHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */