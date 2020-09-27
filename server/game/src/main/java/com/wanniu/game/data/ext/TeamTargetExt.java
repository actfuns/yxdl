/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.TeamTargetCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.RandomUtils;
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
/*    */ 
/*    */ 
/*    */ public class TeamTargetExt
/*    */   extends TeamTargetCO
/*    */ {
/*    */   public Map<Const.PlayerBtlData, Integer> randomAttrs() {
/* 33 */     Map<Const.PlayerBtlData, Integer> result = new HashMap<>();
/* 34 */     if (this.min1 > 0 && this.max1 >= this.min1) {
/* 35 */       Const.PlayerBtlData attr1 = Const.PlayerBtlData.getE(this.prop1);
/* 36 */       if (attr1 != null) {
/* 37 */         result.put(attr1, Integer.valueOf(RandomUtils.nextInt(this.min1, this.max1)));
/*    */       }
/*    */     } 
/*    */     
/* 41 */     if (this.min2 > 0 && this.max2 >= this.min2) {
/* 42 */       Const.PlayerBtlData attr2 = Const.PlayerBtlData.getE(this.prop2);
/* 43 */       if (attr2 != null) {
/* 44 */         result.put(attr2, Integer.valueOf(RandomUtils.nextInt(this.min2, this.max2)));
/*    */       }
/*    */     } 
/*    */     
/* 48 */     if (this.min3 > 0 && this.max3 >= this.min3) {
/* 49 */       Const.PlayerBtlData attr3 = Const.PlayerBtlData.getE(this.prop3);
/* 50 */       if (attr3 != null) {
/* 51 */         result.put(attr3, Integer.valueOf(RandomUtils.nextInt(this.min3, this.max3)));
/*    */       }
/*    */     } 
/* 54 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TeamTargetExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */