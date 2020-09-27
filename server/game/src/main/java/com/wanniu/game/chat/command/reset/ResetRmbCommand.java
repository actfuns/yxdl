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
/*    */ @Command({"@gm reset rmb"})
/*    */ public class ResetRmbCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm reset rmb <value>\t重置充值元宝命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer value = Integer.valueOf(0);
/* 24 */     if (args.length > 3) {
/* 25 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/*    */     
/* 28 */     int diamond = player.moneyManager.getDiamond();
/* 29 */     if (diamond > value.intValue()) {
/* 30 */       player.moneyManager.costDiamond(diamond - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
/*    */     } else {
/* 32 */       player.moneyManager.addDiamond(value.intValue() - diamond, Const.GOODS_CHANGE_TYPE.gm);
/*    */     } 
/* 34 */     return "已成功重置" + value + "充值元宝";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetRmbCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */