/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.upgradeClassRequest")
/*    */ public class UpgradeClassHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 20 */           WNPlayer player = (WNPlayer)UpgradeClassHandler.this.pak.getPlayer();
/* 21 */           PlayerHandler.UpgradeClassResponse.Builder res = PlayerHandler.UpgradeClassResponse.newBuilder();
/* 22 */           res.setS2CCode(200);
/* 23 */           String result = null;
/* 24 */           if (player != null)
/* 25 */             result = player.baseDataManager.upgradeClass(); 
/* 26 */           if (result != null) {
/* 27 */             res.setS2CCode(500);
/* 28 */             res.setS2CMsg(result);
/*    */           } 
/* 30 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\UpgradeClassHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */