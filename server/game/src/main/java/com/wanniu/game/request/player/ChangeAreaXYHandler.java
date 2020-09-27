/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.area.AreaData;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.changeAreaXYRequest")
/*    */ public class ChangeAreaXYHandler
/*    */   extends ChangeAreaFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 29 */     PlayerHandler.ChangeAreaXYRequest req = PlayerHandler.ChangeAreaXYRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     final String instanceId = req.getInstanceId();
/* 32 */     if (StringUtil.isEmpty(instanceId)) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     }
/* 35 */     if (instanceId.equals(player.getInstanceId())) {
/* 36 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("MAP_NOT_SWITCH"));
/*    */     }
/*    */     
/* 39 */     final int areaId = req.getMapId();
/* 40 */     final int posx = req.getPosx();
/* 41 */     final int posy = req.getPosy();
/* 42 */     Out.debug(new Object[] { "changeAreaXYRequest player instanceId:", instanceId, "AreaId:", Integer.valueOf(areaId), " x:", Integer.valueOf(posx), " y:", Integer.valueOf(posy) });
/*    */     
/* 44 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 47 */           PlayerHandler.ChangeAreaXYResponse.Builder res = PlayerHandler.ChangeAreaXYResponse.newBuilder();
/*    */ 
/*    */           
/* 50 */           MapBase sceneProp = AreaUtil.getAreaProp(areaId);
/* 51 */           String result = AreaUtil.canTransArea(sceneProp, player);
/* 52 */           if (result != null) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(result);
/* 55 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 58 */           AreaUtil.disCardItemByTransArea(sceneProp, player);
/* 59 */           AreaUtil.changeArea(player, new AreaData(areaId, posx, posy, instanceId));
/* 60 */           res.setS2CCode(200);
/* 61 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ChangeAreaXYHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */