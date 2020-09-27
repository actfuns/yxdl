/*    */ package com.wanniu.game.chat.command.test;
/*    */ 
/*    */ import com.wanniu.core.util.FileUtil;
/*    */ import com.wanniu.game.chat.command.AbsCommand;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.DEquipBase;
/*    */ import com.wanniu.game.data.base.DItemBase;
/*    */ import com.wanniu.game.item.ItemConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.File;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Command({"@gm test automation"})
/*    */ public class TestAutomationCommand
/*    */   extends AbsCommand
/*    */ {
/*    */   public String help() {
/* 26 */     return "@gm test automation\t\t生成后台所需的命令";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String exec(WNPlayer player, String... args) {
/* 31 */     genItemTemplateLog();
/* 32 */     genFuncTemplateLog();
/*    */     
/* 34 */     return "OK";
/*    */   }
/*    */   
/*    */   private void genFuncTemplateLog() {
/* 38 */     Set<Integer> test = new HashSet<>();
/* 39 */     StringBuilder sb = new StringBuilder(2048);
/* 40 */     for (Const.GOODS_CHANGE_TYPE type : Const.GOODS_CHANGE_TYPE.values()) {
/* 41 */       if (test.contains(Integer.valueOf(type.value))) {
/* 42 */         throw new RuntimeException("来源有重复的ID：" + type.value);
/*    */       }
/* 44 */       test.add(Integer.valueOf(type.value));
/* 45 */       sb.append("i18n.func.code." + type.value + "=" + type.getDesc() + "\n");
/*    */     } 
/* 47 */     FileUtil.write(new File("E:\\mmoarpg\\platform-gm\\src\\main\\resources\\template-func.properties"), sb.toString());
/*    */   }
/*    */   
/*    */   private void genItemTemplateLog() {
/* 51 */     StringBuilder sb = new StringBuilder(2048);
/* 52 */     for (DItemBase it : ItemConfig.getInstance().getItemTemplates().values()) {
/* 53 */       sb.append("i18n.item." + it.code + "=" + it.name + "\n");
/*    */     }
/* 55 */     for (DEquipBase it : ItemConfig.getInstance().getEquipTemplates().values()) {
/* 56 */       sb.append("i18n.item." + it.code + "=" + it.name + "\n");
/*    */     }
/* 58 */     FileUtil.write(new File("E:\\mmoarpg\\platform-gm\\src\\main\\resources\\template-item.properties"), sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\test\TestAutomationCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */