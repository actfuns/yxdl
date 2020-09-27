/*    */ package com.wanniu.game.chat.command.reset;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm reset chest"})
/*    */ public class ResetChestCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm reset chest [value]\t重置宝箱计数命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     Integer value = Integer.valueOf(0);
/* 23 */     if (args.length > 3) {
/* 24 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/* 26 */     player.illusionManager.illusionPO.putBox(1, value.intValue());
/* 27 */     return "已成功重置当前" + value + "宝箱计数";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetChestCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */