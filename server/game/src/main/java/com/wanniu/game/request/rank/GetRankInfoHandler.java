/*    */ package com.wanniu.game.request.rank;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.rank.TitleManager;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.area.RankHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.rankHandler.getRankInfoRequest")
/*    */ public class GetRankInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     GPlayer player = this.pak.getPlayer();
/* 22 */     final WNPlayer wPlayer = (WNPlayer)player;
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           RankHandler.GetRankInfoResponse.Builder res = RankHandler.GetRankInfoResponse.newBuilder();
/* 27 */           TitleManager titleManager = wPlayer.titleManager;
/* 28 */           int id = titleManager.getSelectedRankId();
/*    */           
/* 30 */           res.setS2CCode(200);
/* 31 */           res.setS2CSelectedRankId(id);
/*    */           
/* 33 */           ArrayList<RankHandler.AwardRank.Builder> list = titleManager.getRankInfo();
/* 34 */           for (RankHandler.AwardRank.Builder builder : list) {
/* 35 */             res.addS2CAwardRanks(builder.build());
/*    */           }
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\rank\GetRankInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */