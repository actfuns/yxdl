/*    */ package com.wanniu.game.chat.command.reset;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm reset money"})
/*    */ public class ResetMoneyCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm reset money <value> 重置绑定元宝命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer value = Integer.valueOf(0);
/* 24 */     if (args.length > 3) {
/* 25 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/* 27 */     int ticket = player.moneyManager.getTicket();
/* 28 */     if (ticket > value.intValue()) {
/* 29 */       player.moneyManager.costTicket(ticket - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
/*    */     } else {
/* 31 */       player.moneyManager.addTicket(value.intValue() - ticket, Const.GOODS_CHANGE_TYPE.gm);
/*    */     } 
/* 33 */     return "已成功重置" + value + "绑定元宝";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetMoneyCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */