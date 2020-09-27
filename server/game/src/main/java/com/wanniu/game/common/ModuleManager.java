/*    */ package com.wanniu.game.common;
/*    */ 
/*    */ import java.util.List;
/*    */ import pomelo.area.PlayerHandler;
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
/*    */ public abstract class ModuleManager
/*    */ {
/*    */   public abstract void onPlayerEvent(Const.PlayerEventType paramPlayerEventType);
/*    */   
/*    */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   public abstract Const.ManagerType getManagerType();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\ModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */