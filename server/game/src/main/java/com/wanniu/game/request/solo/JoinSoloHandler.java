/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.solo.vo.ResultVO;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SoloHandler;
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
/*    */ @GClientEvent("area.soloHandler.joinSoloRequest")
/*    */ public class JoinSoloHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 29 */           SoloHandler.JoinSoloResponse.Builder res = SoloHandler.JoinSoloResponse.newBuilder();
/* 30 */           ResultVO result = player.soloManager.handleJoinSolo();
/*    */           
/* 32 */           if (result.result) {
/*    */             
/* 34 */             res.setS2CCode(200);
/* 35 */             res.setS2CAvgMatchTime(result.get(ResultVO.KEY.AVG_MATCHTIME).intValue());
/* 36 */             res.setS2CStartJoinTime(result.get(ResultVO.KEY.START_JOINTIME).intValue());
/*    */           } else {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(result.info);
/*    */           } 
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\JoinSoloHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */