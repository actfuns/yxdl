/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getBenifitableRequest")
/*    */ public class GetBenifitableHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 19 */     FightLevelHandler.GetBenifitableRequest req = FightLevelHandler.GetBenifitableRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 21 */     final Area area = player.getArea();
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FightLevelHandler.GetBenifitableResponse.Builder res = FightLevelHandler.GetBenifitableResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 35 */           res.setS2CCode(200);
/* 36 */           res.setBenifitable((area.getActor(player.getId())).profitable);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\GetBenifitableHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */