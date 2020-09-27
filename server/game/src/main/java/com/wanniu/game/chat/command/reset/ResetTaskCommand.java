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
/*    */ @Command({"@gm reset task"})
/*    */ public class ResetTaskCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm reset task\t重置今日任务";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     player.taskManager.refreshNewDay();
/* 23 */     return "已成功重置今日任务";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetTaskCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */