/*    */ package com.wanniu.game.request.achievement;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.achievementHandler.getHolyArmorsRequest")
/*    */ public class GetHolyArmorsRequestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 34 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */ 
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 43 */           AchievementHandler.GetHolyArmorsResponse.Builder res = AchievementHandler.GetHolyArmorsResponse.newBuilder();
/*    */ 
/*    */           
/* 46 */           for (AchievementDataPO.HolyArmour armour : player.achievementManager.achievementDataPO.holyArmourMap.values()) {
/* 47 */             AchievementHandler.HolyArmor.Builder haBuilder = AchievementHandler.HolyArmor.newBuilder();
/* 48 */             haBuilder.setId(armour.id);
/* 49 */             haBuilder.setStates(armour.states);
/* 50 */             res.addHolyArmors(haBuilder.build());
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 55 */           res.setS2CCode(200);
/* 56 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\achievement\GetHolyArmorsRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */