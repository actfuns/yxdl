/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.replyEnterDungeonRequest")
/*    */ public class ReplyEnterDungeonHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 24 */     FightLevelHandler.ReplyEnterDungeonRequest req = FightLevelHandler.ReplyEnterDungeonRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 26 */     int dungeonId = req.getC2SDungeonId();
/* 27 */     int c2sType = req.getC2SType();
/*    */     
/* 29 */     String data = null;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     FightLevelManager fightLevelManager = player.fightLevelManager;
/* 35 */     data = fightLevelManager.replyEnterDungeon(player, c2sType, dungeonId);
/*    */     
/* 37 */     Out.debug(new Object[] { "c2sType:", Integer.valueOf(c2sType), " - ", data });
/*    */     
/* 39 */     final FightLevelHandler.ReplyEnterDungeonResponse.Builder res = FightLevelHandler.ReplyEnterDungeonResponse.newBuilder();
/* 40 */     if (data == null) {
/* 41 */       res.setS2CCode(200);
/*    */     } else {
/* 43 */       res.setS2CCode(500);
/* 44 */       res.setS2CMsg(data);
/*    */     } 
/* 46 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 49 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\ReplyEnterDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */