/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.player.PathService;
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
/*    */ 
/*    */ @GClientEvent("area.playerHandler.queryLoadWayRequest")
/*    */ public class QueryLoadWayHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 29 */     PlayerHandler.QueryLoadWayRequest req = PlayerHandler.QueryLoadWayRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     final int toAreaId = req.getC2SAreaId();
/* 31 */     final String pointId = req.getC2SPointId();
/* 32 */     final int areaId = player.getAreaId();
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           PlayerHandler.QueryLoadWayResponse.Builder res = PlayerHandler.QueryLoadWayResponse.newBuilder();
/*    */ 
/*    */           
/* 40 */           if (toAreaId == 0 || StringUtil.isEmpty(pointId) || areaId == toAreaId) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           int pointId = PathService.getInstance().findPath(areaId, toAreaId);
/* 47 */           if (pointId != 0) {
/* 48 */             res.setS2CPointId(String.valueOf(pointId));
/* 49 */             res.setS2CCode(200);
/* 50 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 52 */             res.setS2CCode(500);
/* 53 */             res.setS2CMsg(LangService.getValue("TARGET_PATH_NOT_AVAILABLE"));
/* 54 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\QueryLoadWayHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */