/*    */ package com.wanniu.game.chat.command.open;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm open ?", "@gm open help"})
/*    */ public class OpenHelpCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 16 */     return "@gm open [月卡|尊享卡]";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\open\OpenHelpCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */