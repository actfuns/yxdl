/*    */ package com.wanniu.game.chat.command.add;
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
/*    */ @Command({"@gm add rmb"})
/*    */ public class AddRmbCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 18 */     return "@gm add rmb <value>\t添加充值元宝命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 23 */     Integer value = Integer.valueOf(1);
/* 24 */     if (args.length > 3) {
/* 25 */       value = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/* 27 */     player.moneyManager.addDiamond(value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
/* 28 */     return "已成功添加" + value + "充值元宝";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddRmbCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */