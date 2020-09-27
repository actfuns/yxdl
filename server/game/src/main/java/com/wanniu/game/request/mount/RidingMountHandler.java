/*    */ package com.wanniu.game.request.mount;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.PlayerUtil;
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
/*    */ @GClientEvent("area.mountHandler.ridingMountRequest")
/*    */ public class RidingMountHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     MountHandler.RidingMountRequest req = MountHandler.RidingMountRequest.parseFrom(this.pak.getRemaingBytes());
/* 29 */     final GPlayer player = this.pak.getPlayer();
/* 30 */     final WNPlayer wPlayer = (WNPlayer)player;
/* 31 */     final int isUp = req.getC2SIsUp();
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           MountHandler.RidingMountResponse.Builder res = MountHandler.RidingMountResponse.newBuilder();
/* 36 */           if (null == player) {
/* 37 */             res.setS2CCode(500);
/* 38 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 39 */             this.body.writeBytes(res.build().toByteArray());
/* 40 */             PlayerUtil.logWarnIfPlayerNull(RidingMountHandler.this.pak);
/*    */             
/*    */             return;
/*    */           } 
/* 44 */           if (!AreaUtil.canRideMount(wPlayer.getAreaId())) {
/* 45 */             res.setS2CCode(500);
/* 46 */             MapBase map = AreaUtil.getAreaProp(wPlayer.getAreaId());
/* 47 */             if (map.type == Const.SCENE_TYPE.FIVE2FIVE.getValue() || map.type == Const.SCENE_TYPE.ALLY_FIGHT.getValue() || map.type == Const.SCENE_TYPE.ARENA.getValue() || map.type == Const.SCENE_TYPE.CROSS_SERVER.getValue() || map.type == Const.SCENE_TYPE.SIN_COM.getValue()) {
/* 48 */               res.setS2CMsg("");
/*    */             } else {
/* 50 */               res.setS2CMsg(LangService.getValue("MOUNT_THIS_SENCE_CANNOT_USE_MOUNT"));
/* 51 */             }  this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 55 */           int result = wPlayer.mountManager.ridingMount(isUp);
/*    */           
/* 57 */           if (result == 0) {
/* 58 */             res.setS2CCode(200);
/*    */           } else {
/*    */             
/* 61 */             res.setS2CCode(500);
/* 62 */             res.setS2CMsg("SOMETHING_ERR");
/*    */           } 
/* 64 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mount\RidingMountHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */