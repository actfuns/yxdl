/*    */ package com.wanniu.game.chat;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtils;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.chat.command.Command;
/*    */ import com.wanniu.game.chat.command.GmCommand;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GmCommandManager
/*    */ {
/* 20 */   private static final Map<String, GmCommand> commands = new HashMap<>();
/*    */   
/*    */   public static void init() {
/* 23 */     if (GWorld.DEBUG) {
/* 24 */       ClassUtils.scanPackage(GmCommand.class.getPackage().getName(), klass -> {
/*    */             if (GmCommand.class.isAssignableFrom(klass)) {
/*    */               Command command = klass.<Command>getAnnotation(Command.class);
/*    */               if (command != null) {
/*    */                 for (String v : command.value()) {
/*    */                   commands.put(v, (GmCommand)ClassUtils.newInstance(klass));
/*    */                 }
/*    */                 Out.debug(new Object[] { "GM命令注册：", Arrays.toString((Object[])command.value()), "->", klass.getSimpleName() });
/*    */               } 
/*    */             } 
/*    */           });
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static GmCommand find(String[] content) {
/* 40 */     StringBuilder sb = new StringBuilder(64);
/* 41 */     if (content.length > 1 && ("?".equals(content[1]) || "help".equalsIgnoreCase(content[1]))) {
/* 42 */       sb.append(content[0].toLowerCase()).append(" ");
/* 43 */       sb.append(content[1].toLowerCase());
/* 44 */     } else if (content.length > 2) {
/* 45 */       sb.append(content[0].toLowerCase()).append(" ");
/* 46 */       sb.append(content[1].toLowerCase()).append(" ");
/* 47 */       sb.append(content[2].toLowerCase());
/*    */     } 
/* 49 */     return commands.get(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\GmCommandManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */