/*    */ package com.wanniu.game.request.rank;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.RankHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.rankHandler.saveRankNotify")
/*    */ public class SaveRankNotifyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     RankHandler.SaveRankNotify req = RankHandler.SaveRankNotify.parseFrom(this.pak.getRemaingBytes());
/* 17 */     GPlayer player = this.pak.getPlayer();
/* 18 */     WNPlayer wPlayer = (WNPlayer)player;
/* 19 */     int selectedRankId = req.getC2SSelectedRankId();
/* 20 */     wPlayer.titleManager.saveRank(selectedRankId);
/* 21 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\rank\SaveRankNotifyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */