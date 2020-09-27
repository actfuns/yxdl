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
/*    */ @Command({"@gm reset name"})
/*    */ public class ResetNameCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm reset name <pname>\t 重置角色名字命令";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 24 */     return "已成功重置角色名字...";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetNameCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */