/*    */ package com.wanniu.core.groovy;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import groovy.lang.GroovyClassLoader;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.io.StringWriter;
/*    */ 
/*    */ 
/*    */ public class GameGroovyManager
/*    */ {
/*    */   private GameGroovyManager() {}
/*    */   
/*    */   public String sendGroovyCodeText(String codeText) {
/* 15 */     GroovyClassLoader loader = new GroovyClassLoader(GameGroovyManager.class.getClassLoader());
/* 16 */     Class<?> clz = loader.parseClass(codeText);
/*    */     try {
/* 18 */       IGameGroovy object = (IGameGroovy)clz.newInstance();
/* 19 */       return object.execute();
/* 20 */     } catch (Exception e) {
/* 21 */       Out.error(new Object[] { "GameGroovyManager sendGroovyCodeText", e });
/* 22 */       try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
/* 23 */         e.printStackTrace(pw);
/* 24 */         return sw.toString();
/* 25 */       } catch (IOException iOException) {
/* 26 */         return "请求助研发人员...";
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class GameGroovyManagerHolder
/*    */   {
/* 33 */     public static final GameGroovyManager INSTANCE = new GameGroovyManager();
/*    */   }
/*    */   
/*    */   public static GameGroovyManager getInstance() {
/* 37 */     return GameGroovyManagerHolder.INSTANCE;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\groovy\GameGroovyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */