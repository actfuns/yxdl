/*    */ package com.wanniu.game.hotupdate;
/*    */ 
/*    */ import java.lang.instrument.Instrumentation;
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
/*    */ public class JavaAgent
/*    */ {
/* 24 */   public static Instrumentation INST = null;
/*    */   
/*    */   public static void premain(String agentArgs, Instrumentation inst) {
/* 27 */     INST = inst;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\hotupdate\JavaAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */