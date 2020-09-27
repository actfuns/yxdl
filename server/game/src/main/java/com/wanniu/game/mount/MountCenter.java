/*    */ package com.wanniu.game.mount;
/*    */ 
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.poes.MountPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ 
/*    */ public class MountCenter {
/*    */   private static MountCenter instance;
/*    */   
/*    */   public static synchronized MountCenter getInstance() {
/* 11 */     if (instance == null)
/* 12 */       instance = new MountCenter(); 
/* 13 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MountPO findMount(String playerId) {
/* 21 */     MountPO mount = (MountPO)PlayerPOManager.findPO(ConstsTR.mountTR, playerId, MountPO.class);
/* 22 */     return mount;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\mount\MountCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */