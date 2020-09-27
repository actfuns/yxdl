/*    */ package com.wanniu.game.chat.command.reset;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm reset help", "@gm reset ?"})
/*    */ public class ResetHelpCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 16 */     return "\n@gm reset rmb <value>\t\t重置充值元宝命令\n@gm reset money <value>\t\t重置绑定元宝命令\n@gm reset gold <value>\t\t重置银两命令\n@gm reset recovery [day]\t\t重置资源找回命令\n@gm reset sweep \t\t\t\t重置扫荡次数命令\n@gm reset chest [value]\t\t重置宝箱计数命令\n@gm reset task\t\t\t\t重置今日任务命令\n";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetHelpCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */