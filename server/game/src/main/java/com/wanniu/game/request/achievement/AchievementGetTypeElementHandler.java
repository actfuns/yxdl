/*    */ package com.wanniu.game.request.achievement;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.AchievementHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.achievementHandler.achievementGetTypeElementRequest")
/*    */ public class AchievementGetTypeElementHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     AchievementHandler.AchievementGetTypeElementRequest req = AchievementHandler.AchievementGetTypeElementRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 27 */     final int id = req.getC2SId();
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 32 */           AchievementHandler.AchievementGetTypeElementResponse.Builder res = AchievementHandler.AchievementGetTypeElementResponse.newBuilder();
/* 33 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.ACHIEVEMENT.getValue())) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/* 36 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 39 */           player.achievementManager.toJson4PayloadbyTypeId(id, res);
/* 40 */           res.setS2CCode(200);
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\achievement\AchievementGetTypeElementHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */