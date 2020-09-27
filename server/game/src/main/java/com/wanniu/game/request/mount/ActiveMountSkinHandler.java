/*    */ package com.wanniu.game.request.mount;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ 
/*    */ @GClientEvent("area.mountHandler.activeMountSkinRequest")
/*    */ public class ActiveMountSkinHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final MountHandler.ActiveMountSkinRequest req = MountHandler.ActiveMountSkinRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           WNPlayer player = (WNPlayer)ActiveMountSkinHandler.this.pak.getPlayer();
/* 30 */           int skinId = req.getC2SSkinId();
/* 31 */           MountHandler.ActiveMountSkinResponse.Builder res = MountHandler.ActiveMountSkinResponse.newBuilder();
/*    */           
/* 33 */           int oldSkin = player.mountManager.mount.usingSkinId;
/* 34 */           int result = player.mountManager.changeSkin(skinId);
/* 35 */           if (result == -1) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_HAVE"));
/*    */           } else {
/* 39 */             res.setS2CCode(200);
/*    */           } 
/* 41 */           Out.info(new Object[] { "坐骑换肤成功,roleId=", player.getId(), ",老坐骑外形Id=", Integer.valueOf(oldSkin), "新坐骑外形Id=", 
/* 42 */                 Integer.valueOf(player.mountManager.mount.usingSkinId) });
/* 43 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\ActiveMountSkinHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */