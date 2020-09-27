/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SoloHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.soloHandler.getRivalInfoRequest")
/*    */ public class GetRivalInfoHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 27 */           SoloHandler.GetRivalInfoResponse.Builder res = SoloHandler.GetRivalInfoResponse.newBuilder();
/* 28 */           res.setS2CCode(200);
/* 29 */           res.setS2CVsPlayerName("");
/* 30 */           res.setS2CVsPlayerPro(1);
/* 31 */           res.setS2CVsPlayerLevel(0);
/*    */           
/* 33 */           Area area = player.getArea();
/* 34 */           for (String id : area.actors.keySet()) {
/* 35 */             if (id.equals(player.getId())) {
/*    */               continue;
/*    */             }
/* 38 */             WNPlayer rival = PlayerUtil.getOnlinePlayer(id);
/* 39 */             res.setS2CVsPlayerName(rival.getName());
/* 40 */             res.setS2CVsPlayerPro(rival.getPro());
/* 41 */             res.setS2CVsPlayerLevel(rival.getLevel());
/*    */           } 
/* 43 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\GetRivalInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */