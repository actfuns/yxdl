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
/*    */ @Command({"@gm love you"})
/*    */ public class LoveYouCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 16 */     return "@gm love you 嘿嘿，你懂的...";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 21 */     player.baseDataManager.upgrade(60, 0L);
/*    */ 
/*    */     
/* 24 */     GMChatUtil.checkContent(player, "@gm add rmb 88888888");
/*    */     
/* 26 */     GMChatUtil.checkContent(player, "@gm add money 88888888");
/*    */     
/* 28 */     GMChatUtil.checkContent(player, "@gm add gold 88888888");
/*    */     
/* 30 */     GMChatUtil.checkContent(player, "@gm openFunc");
/*    */     
/* 32 */     GMChatUtil.checkContent(player, "@gm add gr10 10");
/*    */     
/* 34 */     GMChatUtil.checkContent(player, "@gm add gg10 10");
/*    */     
/* 36 */     GMChatUtil.checkContent(player, "@gm add gb10 10");
/*    */     
/* 38 */     GMChatUtil.checkContent(player, "@gm add gp10 10");
/*    */     
/* 40 */     GMChatUtil.checkContent(player, "@gm add gy10 10");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 49 */     GMChatUtil.checkContent(player, "@gm add 无敌屠龙刀 1");
/* 50 */     GMChatUtil.checkContent(player, "@gm add 伪原始圣甲 1");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     return "爱我就对了...";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\LoveYouCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */