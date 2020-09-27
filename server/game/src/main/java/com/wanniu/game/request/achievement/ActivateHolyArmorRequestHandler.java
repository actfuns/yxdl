/*    */ package com.wanniu.game.request.achievement;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.AchievementDataPO;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.achievementHandler.activateHolyArmorRequest")
/*    */ public class ActivateHolyArmorRequestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 35 */     AchievementHandler.ActivateHolyArmorRequest req = AchievementHandler.ActivateHolyArmorRequest.parseFrom(this.pak.getRemaingBytes());
/* 36 */     final int id = req.getId();
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 43 */           AchievementHandler.ActivateHolyArmorResponse.Builder res = AchievementHandler.ActivateHolyArmorResponse.newBuilder();
/*    */           
/* 45 */           AchievementDataPO.HolyArmour armour = (AchievementDataPO.HolyArmour)player.achievementManager.achievementDataPO.holyArmourMap.get(Integer.valueOf(id));
/* 46 */           if (armour.states == 1) {
/*    */             
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("ACHIEVEMENT_NOT_ACTIVATED"));
/*    */             return;
/*    */           } 
/* 52 */           if (armour.states == 3) {
/*    */             
/* 54 */             res.setS2CCode(500);
/* 55 */             res.setS2CMsg(LangService.getValue("ACHIEVEMENT_ACTIVATED"));
/*    */             
/*    */             return;
/*    */           } 
/* 59 */           player.achievementManager.activateHolyArmour(id);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 65 */           res.setS2CCode(200);
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\achievement\ActivateHolyArmorRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */