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
/*    */ @Command({"@gm reset gold"})
/*    */ public class ResetGoldCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm reset gold <value>\t重置银两命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer value = Integer.valueOf(0);
/* 24 */     if (args.length > 3) {
/* 25 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/*    */     
/* 28 */     int gold = player.moneyManager.getGold();
/* 29 */     if (gold > value.intValue()) {
/* 30 */       player.moneyManager.costGold(gold - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
/*    */     } else {
/* 32 */       player.moneyManager.addGold(value.intValue() - gold, Const.GOODS_CHANGE_TYPE.gm);
/*    */     } 
/* 34 */     return "已成功重置到" + value + "银两";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\reset\ResetGoldCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */