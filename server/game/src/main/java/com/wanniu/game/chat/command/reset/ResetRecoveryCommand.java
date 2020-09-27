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
/*    */ @Command({"@gm reset recovery"})
/*    */ public class ResetRecoveryCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm reset recovery [day]\t重置资源找回命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     Integer day = Integer.valueOf(1);
/* 23 */     if (args.length > 3) {
/* 24 */       day = Integer.valueOf(Math.min(Integer.parseInt(args[3]), 3));
/*    */     }
/* 26 */     player.activityManager.gmRecovered(day.intValue());
/* 27 */     return "资源找回已修正到" + day + "天前...";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetRecoveryCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */