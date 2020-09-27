/*    */ package com.wanniu.game.chat.command.add;
/*    */ 
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.DItemEquipBase;
/*    */ import com.wanniu.game.item.ItemConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm add item"})
/*    */ public class AddItemCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 20 */     return "@gm add item <code> [num]\t添加道具命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 25 */     String itemCode = args[3];
/* 26 */     Integer value = Integer.valueOf(1);
/* 27 */     if (args.length > 4) {
/* 28 */       value = Integer.valueOf(Integer.parseInt(args[4]));
/*    */     }
/*    */ 
/*    */     
/* 32 */     if (ItemConfig.getInstance().getItemProp(itemCode) == null) {
/* 33 */       DItemEquipBase t = ItemConfig.getInstance().getItemPropByName(itemCode);
/* 34 */       if (t == null) {
/* 35 */         return "你输入的道具编号【" + itemCode + "】不存在";
/*    */       }
/* 37 */       itemCode = t.code;
/*    */     } 
/*    */ 
/*    */     
/* 41 */     if (!player.bag.testAddCodeItem(itemCode, value.intValue())) {
/* 42 */       return "您的背包装不下啊...";
/*    */     }
/*    */     
/* 45 */     player.bag.addCodeItem(itemCode, value.intValue(), Const.ForceType.UN_BIND, Const.GOODS_CHANGE_TYPE.gm);
/* 46 */     return "OK";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\add\AddItemCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */