/*    */ package com.wanniu.game.request.map;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.AreaDataConfig;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.player.ChangeAreaFilter;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MapHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mapHandler.enterSceneByAreaIdRequest")
/*    */ public class EnterSceneByAreaIdHandler
/*    */   extends ChangeAreaFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 29 */     MapHandler.GnterSceneByAreaIdRequest req = MapHandler.GnterSceneByAreaIdRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     int areaId = req.getC2SAreaId();
/* 31 */     if (areaId == 0) {
/* 32 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
/*    */     }
/* 34 */     MapBase prop = AreaDataConfig.getInstance().get(areaId);
/* 35 */     if (prop == null) {
/* 36 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
/*    */     }
/*    */     
/* 39 */     AreaUtil.enterArea(player, areaId);
/*    */     
/* 41 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 44 */           MapHandler.GnterSceneByAreaIdResponse.Builder res = MapHandler.GnterSceneByAreaIdResponse.newBuilder();
/* 45 */           res.setS2CCode(200);
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\map\EnterSceneByAreaIdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */