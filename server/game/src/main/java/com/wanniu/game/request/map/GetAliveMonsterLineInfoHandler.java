/*    */ package com.wanniu.game.request.map;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MapHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mapHandler.getAliveMonsterLineInfoRequest")
/*    */ public class GetAliveMonsterLineInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 24 */     final Area area = player.getArea();
/*    */     
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           MapHandler.GetAliveMonsterLineInfoResponse.Builder res = MapHandler.GetAliveMonsterLineInfoResponse.newBuilder();
/* 30 */           res.setS2CCode(200);
/* 31 */           res.addAllS2CMonsterInfos(area.aliveBoss);
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\map\GetAliveMonsterLineInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */