/*    */ package com.wanniu.game.chat.command.test;
/*    */ 
/*    */ import com.wanniu.csharp.CSharpClient;
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm test battle"})
/*    */ public class TestBattleCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm test battle\t 测试断开战斗服命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     CSharpClient.getInstance().gmTestClose();
/* 24 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\test\TestBattleCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */