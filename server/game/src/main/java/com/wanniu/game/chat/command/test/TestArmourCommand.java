/*    */ package com.wanniu.game.chat.command.test;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.AchievementDataPO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm test armour"})
/*    */ public class TestArmourCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm test armour <id>\t 测试激活元始圣甲命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer holyArmourId = Integer.valueOf(Integer.parseInt(args[3]));
/* 24 */     AchievementDataPO.HolyArmour holyArmour = (AchievementDataPO.HolyArmour)player.achievementManager.achievementDataPO.holyArmourMap.get(holyArmourId);
/* 25 */     if (holyArmour == null) {
/* 26 */       return "ID未找到";
/*    */     }
/* 28 */     if (holyArmour.states == 1) {
/* 29 */       holyArmour.states = 2;
/*    */     }
/* 31 */     player.achievementManager.activateHolyArmour(holyArmourId.intValue());
/* 32 */     return "OK";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\test\TestArmourCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */