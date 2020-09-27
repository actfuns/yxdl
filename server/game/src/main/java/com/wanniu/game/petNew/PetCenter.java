/*    */ package com.wanniu.game.petNew;
/*    */ 
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.poes.PlayerPetsNewPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ 
/*    */ public class PetCenter {
/*    */   private static PetCenter instance;
/*    */   
/*    */   public static synchronized PetCenter getInstance() {
/* 11 */     if (instance == null)
/* 12 */       instance = new PetCenter(); 
/* 13 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PlayerPetsNewPO findPet(String playerId) {
/* 21 */     PlayerPetsNewPO pets = (PlayerPetsNewPO)PlayerPOManager.findPO(ConstsTR.playerPetTR, playerId, PlayerPetsNewPO.class);
/* 22 */     return pets;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\petNew\PetCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */