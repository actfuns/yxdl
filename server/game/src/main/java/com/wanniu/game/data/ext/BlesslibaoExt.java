/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.BlesslibaoCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlesslibaoExt
/*    */   extends BlesslibaoCO
/*    */ {
/* 15 */   public Map<String, Integer> itemCode30 = new HashMap<>();
/* 16 */   public Map<String, Integer> itemCode60 = new HashMap<>();
/* 17 */   public Map<String, Integer> itemCode100 = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initLs(String code, Map<String, Integer> map) {
/* 21 */     String[] rewards = code.split(",");
/* 22 */     for (int i = 0; i < rewards.length; i++) {
/* 23 */       String[] _elem = rewards[i].split(":");
/* 24 */       if (2 != _elem.length) {
/* 25 */         Out.error(new Object[] { "the config err in Blesslibao.json" });
/*    */       }
/*    */       else {
/*    */         
/* 29 */         map.put(_elem[0], Integer.valueOf(_elem[1]));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   public void initProperty() {
/* 34 */     super.initProperty();
/* 35 */     initLs(this.blessAward30, this.itemCode30);
/* 36 */     initLs(this.blessAward60, this.itemCode60);
/* 37 */     initLs(this.blessAward100, this.itemCode100);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BlesslibaoExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */