/*    */ package com.wanniu.game.chat.command.test;
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
/*    */ @Command({"@gm test reconnect"})
/*    */ public class TestReconnectCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm test reconnect\t测试重连命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     player.getSession().close();
/* 23 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\test\TestReconnectCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */