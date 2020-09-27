/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.fightLevel.FightLevelManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.enterDungeonRequest")
/*    */ public class EnterDungeonHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 26 */     FightLevelHandler.EnterDungeonRequest req = FightLevelHandler.EnterDungeonRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 28 */     final int dungeonId = req.getC2SDungeonId();
/* 29 */     Out.debug(new Object[] { getClass().getName(), " : ", Integer.valueOf(dungeonId) });
/*    */     
/* 31 */     Area area = player.getArea();
/* 32 */     if (area != null && 
/* 33 */       dungeonId == area.areaId) {
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("MAP_IN_MPA"));
/*    */     }
/*    */     
/* 37 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 40 */           FightLevelHandler.EnterDungeonResponse.Builder res = FightLevelHandler.EnterDungeonResponse.newBuilder();
/*    */           
/* 42 */           FightLevelManager fightLevelManager = player.fightLevelManager;
/*    */           
/* 44 */           String data = fightLevelManager.enterDungeonReq(player, dungeonId);
/* 45 */           if (data == null) {
/* 46 */             res.setS2CCode(200);
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(data);
/* 51 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\EnterDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */