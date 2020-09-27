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
/*    */ @GClientEvent("area.soloHandler.queryRewardRequest")
/*    */ public class QueryRewardHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 29 */           SoloHandler.QueryRewardResponse.Builder res = SoloHandler.QueryRewardResponse.newBuilder();
/* 30 */           ResultVO result = player.soloManager.handleQueryReward();
/* 31 */           res.setS2CCode(200);
/* 32 */           res.setS2CHasReward(result.get(ResultVO.KEY.HAS_REWARD).intValue());
/*    */           
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\QueryRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */