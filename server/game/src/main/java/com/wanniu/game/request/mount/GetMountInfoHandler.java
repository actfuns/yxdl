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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mountHandler.getMountInfoRequest")
/*    */ public class GetMountInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     MountHandler.GetMountInfoRequest req = MountHandler.GetMountInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           WNPlayer player = (WNPlayer)GetMountInfoHandler.this.pak.getPlayer();
/* 28 */           MountHandler.GetMountInfoResponse.Builder res = MountHandler.GetMountInfoResponse.newBuilder();
/* 29 */           if (!player.mountManager.isOpenMount()) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           res.setS2CCode(200);
/* 37 */           res.setS2CData(player.mountManager.getMountData().build());
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\GetMountInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */