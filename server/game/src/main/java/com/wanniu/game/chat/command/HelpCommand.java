/*   */ package com.wanniu.game.chat.command;
/*   */ 
/*   */ @Command({"@gm help", "@gm ?"})
/*   */ public class HelpCommand
/*   */   extends AbsCommand
/*   */ {
/*   */   public String help() {
/* 8 */     return "\n@gm add ?      添加系列命令\n@gm reset ?    重置系列命令\n@gm open ?     开启系列命令\n";
/*   */   }
/*   */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\HelpCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */