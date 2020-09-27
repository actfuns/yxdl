/*    */ package com.wanniu.core.groovy;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStreamReader;
/*    */ 
/*    */ public class GroovyTextGender
/*    */ {
/*    */   public static void main(String[] args) {
/* 12 */     GroovyTextGender g = new GroovyTextGender();
/* 13 */     g.parse();
/*    */   }
/*    */ 
/*    */   
/*    */   public void parse() {
/* 18 */     String path = System.getProperty("user.dir");
/* 19 */     path = path + "/src/com/groovy";
/*    */     try {
/* 21 */       File file = new File(path + "/GroovyExcutor.java");
/* 22 */       if (file.isFile() && file.exists()) {
/* 23 */         InputStreamReader read = new InputStreamReader(new FileInputStream(file));
/*    */         
/* 25 */         BufferedReader bufferedReader = new BufferedReader(read);
/* 26 */         String lineTxt = null;
/* 27 */         boolean isFirst = false;
/* 28 */         while ((lineTxt = bufferedReader.readLine()) != null) {
/* 29 */           if (!isFirst) {
/* 30 */             System.out.println("\" " + lineTxt.trim() + "\"");
/*    */           } else {
/* 32 */             System.out.println("+\" " + lineTxt.trim() + "\"");
/*    */           } 
/* 34 */           isFirst = true;
/* 35 */           System.out.println("+\"\\r\\n\\t\"");
/*    */         } 
/* 37 */         read.close();
/*    */       }
/*    */     
/* 40 */     } catch (Exception e) {
/* 41 */       Out.error(new Object[] { "GroovyTextGender parse", e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\groovy\GroovyTextGender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */