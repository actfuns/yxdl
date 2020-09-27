/*    */ package com.wanniu.game.task;
/*    */ 
/*    */ import com.wanniu.core.game.PoolFactory;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskQueue
/*    */ {
/* 16 */   private static Executor TaskExecutor = Executors.newSingleThreadExecutor((ThreadFactory)new PoolFactory("任务处理器"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void put(TaskEvent event) {
/* 24 */     TaskExecutor.execute(event);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\TaskQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */