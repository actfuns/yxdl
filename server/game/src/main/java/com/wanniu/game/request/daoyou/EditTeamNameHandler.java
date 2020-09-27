/*    */ package com.wanniu.game.request.daoyou;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.util.BlackWordUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.daoyou.DaoYouHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouEditTeamNameRequest")
/*    */ public class EditTeamNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 29 */     DaoYouHandler.DaoYouEditTeamNameRequest req = DaoYouHandler.DaoYouEditTeamNameRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     final String teamName = req.getTeamName();
/*    */     
/* 33 */     if (StringUtil.isEmpty(teamName)) {
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DAO_YOU_NAME_NOT_EMPTY"));
/*    */     }
/*    */     
/* 37 */     if (BlackWordUtil.isIncludeBlackString(teamName)) {
/* 38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
/*    */     }
/*    */     
/* 41 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 44 */           DaoYouHandler.DaoYouResponse.Builder res = DaoYouHandler.DaoYouResponse.newBuilder();
/*    */           
/* 46 */           String playerId = player.getId();
/* 47 */           String playerName = player.getName();
/* 48 */           String msg = DaoYouService.getInstance().editDaoYouName(playerId, playerName, teamName);
/* 49 */           if (!msg.equals("")) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(msg);
/* 52 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 54 */             res.setS2CCode(200);
/* 55 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\EditTeamNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */