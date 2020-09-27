/*    */ package com.wanniu.game.chat.command;
/*    */ 
/*    */ import com.wanniu.game.chat.GMChatUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbsCommand
/*    */   implements GmCommand
/*    */ {
/*    */   public GMChatUtil.GMChatResult call(WNPlayer player, String... args) {
/* 15 */     if (args.length > 3 && ("?".equals(args[3]) || "help".equalsIgnoreCase(args[3]))) {
/* 16 */       return new GMChatUtil.GMChatResult(true, help());
/*    */     }
/* 18 */     String result = null;
/*    */     try {
/* 20 */       result = exec(player, args);
/* 21 */     } catch (Exception e) {
/* 22 */       result = help() + "执行时发生了异常情况\n异常信息：" + e.getMessage() + "\n";
/*    */     } 
/* 24 */     return new GMChatUtil.GMChatResult(true, result);
/*    */   }
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 28 */     return help();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\AbsCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */