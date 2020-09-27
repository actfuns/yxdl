/*    */ package com.wanniu.game.chat.command.add;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm add level"})
/*    */ public class AddLevelCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm add level <value>\t添加等级命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer value = Integer.valueOf(1);
/* 24 */     if (args.length > 3) {
/* 25 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/* 27 */     player.baseDataManager.upgrade(Math.min(GlobalConfig.Role_LevelLimit, player.getLevel() + value.intValue()), 0L);
/* 28 */     return "升级成功";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddLevelCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */