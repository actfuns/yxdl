/*    */ package com.wanniu.game.chat.command.open;
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
/*    */ @Command({"@gm open 月卡", "@gm open 尊享卡"})
/*    */ public class OpenCardCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm open [月卡|尊享卡]\t开启月卡功能";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     String type = args[2];
/* 23 */     player.prepaidManager.onChargeCardByOpen(type);
/* 24 */     return type + " 已开通...";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\open\OpenCardCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */