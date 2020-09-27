/*    */ package com.wanniu.game.request.leaderboard;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.LeaderBoardHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.leaderBoardHandler.worShipRequest")
/*    */ public class WorShipHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 24 */     LeaderBoardHandler.WorShipRequest req = LeaderBoardHandler.WorShipRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final int _type = req.getC2SType();
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           LeaderBoardHandler.WorShipResponse.Builder res = LeaderBoardHandler.WorShipResponse.newBuilder();
/*    */           
/* 32 */           WorShipHandler.WorshipRes result = player.leaderBoardManager.worShip(player, _type);
/* 33 */           if (result.result) {
/* 34 */             res.setS2CCode(200);
/* 35 */             res.addAllS2CAwards(result.awards);
/*    */           } else {
/* 37 */             res.setS2CCode(500);
/* 38 */             res.setS2CMsg(result.info);
/*    */           } 
/*    */           
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public static final class WorshipRes
/*    */   {
/*    */     public boolean result;
/*    */     public String info;
/*    */     public List<String> awards;
/*    */     
/*    */     public WorshipRes(boolean result, String info, List<String> awards) {
/* 53 */       this.result = result;
/* 54 */       this.info = info;
/* 55 */       this.awards = awards;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\leaderboard\WorShipHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */