/*    */ package com.wanniu.game.request.leaderboard;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.LeaderBoardHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.leaderBoardHandler.worldLevelInfoRequest")
/*    */ public class WorldLevelInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 25 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.WORLD_EXP.getValue())) {
/* 26 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*    */     }
/*    */     
/* 29 */     final LeaderBoardHandler.WorldLevelInfo data = player.leaderBoardManager.worldLevelInfo(player);
/*    */     
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 34 */           LeaderBoardHandler.WorldLevelInfoResponse.Builder res = LeaderBoardHandler.WorldLevelInfoResponse.newBuilder();
/* 35 */           res.setS2CCode(200);
/* 36 */           res.setS2CData(data);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\leaderboard\WorldLevelInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */