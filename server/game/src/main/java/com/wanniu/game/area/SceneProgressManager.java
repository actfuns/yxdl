/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.task.TaskEvent;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SceneProgressManager
/*    */ {
/* 18 */   public Map<Integer, Object> progress = null;
/*    */   
/*    */   public SceneProgressManager(Map<Integer, Object> data) {
/* 21 */     this.progress = data;
/*    */   }
/*    */   
/*    */   public void onEvent(TaskEvent event) {
/* 25 */     if (event.type == Const.EventType.changeSceneProgress.getValue()) {
/* 26 */       int key = ((Integer)event.params[0]).intValue();
/* 27 */       Object value = event.params;
/* 28 */       if (value == null) {
/* 29 */         this.progress.remove(Integer.valueOf(key));
/*    */       } else {
/* 31 */         this.progress.put(Integer.valueOf(key), value);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Object[]> toJson4BattleServer() {
/* 42 */     List<Object[]> data = new ArrayList();
/* 43 */     for (Iterator<Integer> iterator = this.progress.keySet().iterator(); iterator.hasNext(); ) { int key = ((Integer)iterator.next()).intValue();
/* 44 */       Object value = this.progress.get(Integer.valueOf(key));
/* 45 */       data.add(new Object[] { Integer.valueOf(key), value }); }
/*    */     
/* 47 */     return data;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\SceneProgressManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */