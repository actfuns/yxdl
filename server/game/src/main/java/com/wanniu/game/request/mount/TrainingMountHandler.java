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
/*    */ @GClientEvent("area.mountHandler.trainingMountRequest")
/*    */ public class TrainingMountHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final MountHandler.TrainingMountRequest req = MountHandler.TrainingMountRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           WNPlayer player = (WNPlayer)TrainingMountHandler.this.pak.getPlayer();
/* 30 */           MountHandler.TrainingMountResponse.Builder res = MountHandler.TrainingMountResponse.newBuilder();
/* 31 */           if (!player.mountManager.isOpenMount()) {
/* 32 */             res.setS2CCode(500);
/* 33 */             res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
/* 34 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 37 */           int type = req.getC2SType();
/* 38 */           if (type == 1) {
/* 39 */             int i = player.mountManager.upgradeLv();
/* 40 */             if (i == -1) {
/* 41 */               res.setS2CCode(500);
/* 42 */               res.setS2CMsg(LangService.getValue("MOUNT_SKIN_HAVE_MAX_STAGE"));
/* 43 */               this.body.writeBytes(res.build().toByteArray()); return;
/*    */             } 
/* 45 */             if (i == -2) {
/* 46 */               res.setS2CCode(500);
/* 47 */               res.setS2CMsg(LangService.getValue("MOUNT_NOT_TEN_STAR"));
/* 48 */               this.body.writeBytes(res.build().toByteArray()); return;
/*    */             } 
/* 50 */             if (i == -3) {
/* 51 */               res.setS2CCode(500);
/* 52 */               res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_ENOUGH_ITEM"));
/* 53 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             } 
/* 56 */             res.setS2CCode(200);
/* 57 */             res.setS2CData(player.mountManager.getMountData().build());
/* 58 */             this.body.writeBytes(res.build().toByteArray());
/* 59 */             Out.info(new Object[] { "坐骑升阶成功,roleId=", player.getId(), ",坐骑外形Id=", Integer.valueOf(player.mountManager.mount.usingSkinId), "坐骑阶级=", 
/* 60 */                   Integer.valueOf(player.mountManager.mount.rideLevel) });
/*    */             
/*    */             return;
/*    */           } 
/* 64 */           int result = player.mountManager.upgradeStar();
/* 65 */           if (result == -1) {
/* 66 */             res.setS2CCode(500);
/* 67 */             res.setS2CMsg(LangService.getValue("MOUNT_ALREADY_TEN_STAR"));
/* 68 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 70 */           if (result == -2) {
/* 71 */             res.setS2CCode(500);
/* 72 */             res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_ENOUGH_ITEM"));
/* 73 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 76 */           res.setS2CCode(200);
/* 77 */           res.setS2CData(player.mountManager.getMountData().build());
/* 78 */           this.body.writeBytes(res.build().toByteArray());
/* 79 */           Out.info(new Object[] { "坐骑升星成功,roleId=", player.getId(), ",坐骑外形Id=", Integer.valueOf(player.mountManager.mount.usingSkinId), "坐骑星级=", 
/* 80 */                 Integer.valueOf(player.mountManager.mount.starLv) });
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\TrainingMountHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */