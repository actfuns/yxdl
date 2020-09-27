/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.BattleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.battleHandler.throwPointRequest")
/*    */ public class ThrowPointHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 22 */     BattleHandler.ThrowPointRequest req = BattleHandler.ThrowPointRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String id = req.getId();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           BattleHandler.ThrowPointResponse.Builder res = BattleHandler.ThrowPointResponse.newBuilder();
/*    */           
/* 29 */           Area area = player.getArea();
/*    */           
/* 31 */           res.setS2CCode(200);
/* 32 */           res.setPoint(area.randomPoint(player, id));
/*    */           
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\ThrowPointHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */