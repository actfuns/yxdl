/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ @DBTable("player_pets")
/*    */ public class PlayerPetsNewPO
/*    */   extends GEntity
/*    */ {
/* 13 */   public Map<Integer, PetNewPO> pets = new HashMap<>();
/*    */   
/*    */   public int fightPetId;
/* 16 */   public int pkModel = 1;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerPetsNewPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */