/*    */ package com.wanniu.game.chat.command.add;
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
/*    */ @Command({"@gm add petexp"})
/*    */ public class AddPetexpCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 17 */     return "@gm add petexp <petId> <exp>\t添加宠物经验命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 22 */     Integer petId = Integer.valueOf(1);
/* 23 */     if (args.length > 3) {
/* 24 */       petId = Integer.valueOf(Integer.parseInt(args[3]));
/*    */     }
/* 26 */     Integer exp = Integer.valueOf(1);
/* 27 */     if (args.length > 4) {
/* 28 */       exp = Integer.valueOf(Integer.parseInt(args[4]));
/*    */     }
/*    */     
/* 31 */     player.petNewManager.addExp(petId.intValue(), exp.intValue());
/* 32 */     return "已成功添加" + exp + "经验";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddPetexpCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */