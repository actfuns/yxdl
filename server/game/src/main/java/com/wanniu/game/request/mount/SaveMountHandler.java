/*    */ package com.wanniu.game.request.mount;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MountHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mountHandler.saveMountRequest")
/*    */ public class SaveMountHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     MountHandler.SaveMountRequest req = MountHandler.SaveMountRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     GPlayer player = this.pak.getPlayer();
/* 24 */     WNPlayer wPlayer = (WNPlayer)player;
/* 25 */     int skinId = req.getC2SSkinId();
/* 26 */     int mountId = req.getC2SMountId();
/* 27 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {}
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\SaveMountHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */