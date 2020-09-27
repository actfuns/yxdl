/*    */ package com.wanniu.game.hotupdate;
/*    */ 
/*    */ import java.lang.instrument.ClassDefinition;
/*    */ import java.lang.instrument.UnmodifiableClassException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HotUpdateService
/*    */ {
/*    */   public static String changeClass(String className, byte[] classBt) {
/*    */     try {
/* 30 */       Class<?> cls = Class.forName(className);
/* 31 */       if (JavaAgent.INST == null) {
/* 32 */         return "启动命令行没有写上正确的格式:java -javaagent:agent.jar -jar xx.jar,或者没有找到agent.jar";
/*    */       }
/* 34 */       JavaAgent.INST.redefineClasses(new ClassDefinition[] { new ClassDefinition(cls, classBt) });
/* 35 */     } catch (ClassNotFoundException e) {
/* 36 */       return "请写上完整的类名.例如com.wanniu.game.hotupdate.HotUpdateService";
/* 37 */     } catch (UnmodifiableClassException e) {
/* 38 */       return "热更的时候发生未知错误,请检查:" + e.getMessage();
/*    */     } 
/* 40 */     return "OK";
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\hotupdate\HotUpdateService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */