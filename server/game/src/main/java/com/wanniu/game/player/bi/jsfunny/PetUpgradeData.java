/*    */ package com.wanniu.game.player.bi.jsfunny;
/*    */ 
/*    */ import com.wanniu.game.poes.PlayerPO;
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
/*    */ public class PetUpgradeData
/*    */   extends AnsycPublisher
/*    */ {
/*    */   protected String channel() {
/* 27 */     return "data.PetUpgrade";
/*    */   }
/*    */   
/*    */   public PetUpgradeData(PlayerPO player, int petId, String petName, int upLevel, int level, long exp) {
/* 31 */     this.data.put("os", player.os);
/* 32 */     this.data.put("channel", player.channel);
/* 33 */     this.data.put("subchannel", player.subchannel);
/* 34 */     this.data.put("id", player.id);
/* 35 */     this.data.put("name", player.name);
/*    */     
/* 37 */     this.data.put("petId", Integer.valueOf(petId));
/* 38 */     this.data.put("petName", petName);
/* 39 */     this.data.put("upLevel", Integer.valueOf(upLevel));
/* 40 */     this.data.put("level", Integer.valueOf(level));
/* 41 */     this.data.put("exp", Long.valueOf(exp));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\jsfunny\PetUpgradeData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */