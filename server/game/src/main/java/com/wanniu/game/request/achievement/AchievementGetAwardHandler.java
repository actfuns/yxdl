/*    */ package com.wanniu.game.request.achievement;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.achievement.po.BaseInfo;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.AchievementConfigExt;
/*    */ import com.wanniu.game.data.ext.AchievementExt;
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
/*    */ @GClientEvent("area.achievementHandler.achievementGetAwardRequest")
/*    */ public class AchievementGetAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 29 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 31 */     AchievementHandler.AchievementGetAwardRequest req = AchievementHandler.AchievementGetAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     final int achieveId = req.getC2SId();
/* 33 */     final int _type = req.getC2SType();
/*    */     
/* 35 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 40 */           AchievementHandler.AchievementGetAwardResponse.Builder res = AchievementHandler.AchievementGetAwardResponse.newBuilder();
/*    */           
/* 42 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.ACHIEVEMENT.getValue())) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/* 45 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 48 */           AchievementConfigExt configExt = null;
/* 49 */           if (_type == 0) {
/* 50 */             configExt = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(achieveId));
/* 51 */           } else if (_type == 1) {
/* 52 */             AchievementExt achievementExt = (AchievementExt)GameData.Achievements.get(Integer.valueOf(achieveId));
/* 53 */             configExt = (AchievementConfigExt)GameData.AchievementConfigs.get(Integer.valueOf(achievementExt.chapterID));
/*    */           } 
/*    */           
/* 56 */           if (player.getLevel() < configExt.lv || (configExt.quest != 0 && 
/* 57 */             !player.taskManager.finishedNormalTasks.containsKey(Integer.valueOf(configExt.quest)))) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("ACHIEVE_CHAPTER_NOT_OPEN"));
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 64 */           BaseInfo baseInfo = player.achievementManager.getAward(_type, achieveId);
/* 65 */           if (baseInfo.code == 200) {
/* 66 */             res.setS2CCode(baseInfo.code);
/* 67 */             player.achievementManager.updateSuperScript();
/*    */           } else {
/* 69 */             res.setS2CCode(baseInfo.code);
/* 70 */             res.setS2CMsg(baseInfo.msg);
/*    */           } 
/*    */           
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\achievement\AchievementGetAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */