/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.VitBonusCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class VitBonusExt
/*    */   extends VitBonusCO {
/*    */   public Map<String, Integer> rewards;
/*    */   
/*    */   public void initRewards(Map<String, Integer> map) {
/* 13 */     String[] rewards = this.chestCode.split(",");
/* 14 */     for (int i = 0; i < rewards.length; i++) {
/* 15 */       String[] _elem = rewards[i].split(":");
/* 16 */       if (2 != _elem.length) {
/* 17 */         Out.error(new Object[] { "the config err in VitBonus.json" });
/*    */       }
/*    */       else {
/*    */         
/* 21 */         map.put(_elem[0], Integer.valueOf(_elem[1]));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public void initProperty() {
/* 26 */     super.initProperty();
/* 27 */     this.rewards = new HashMap<>();
/* 28 */     initRewards(this.rewards);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\VitBonusExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */