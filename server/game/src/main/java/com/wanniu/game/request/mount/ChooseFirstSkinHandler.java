/*    */ package com.wanniu.game.request.mount;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MountHandler;
/*    */ 
/*    */ @GClientEvent("area.mountHandler.chooseFirstSkinRequest")
/*    */ public class ChooseFirstSkinHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final MountHandler.ChooseFirstSkinRequest req = MountHandler.ChooseFirstSkinRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 19 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 22 */           WNPlayer player = (WNPlayer)ChooseFirstSkinHandler.this.pak.getPlayer();
/* 23 */           int skinId = req.getC2SSkinId();
/* 24 */           MountHandler.ChooseFirstSkinResponse.Builder res = MountHandler.ChooseFirstSkinResponse.newBuilder();
/*    */ 
/*    */           
/* 27 */           boolean result = player.mountManager.chooseFirstSkin(skinId);
/* 28 */           if (!result) {
/* 29 */             res.setS2CCode(500);
/* 30 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } else {
/*    */             
/* 33 */             res.setS2CCode(200);
/*    */           } 
/* 35 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\ChooseFirstSkinHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */