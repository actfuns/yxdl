/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.MasteryPropCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ public class MasteryPropExt extends MasteryPropCO {
/*    */   public Map<String, Integer> attrs;
/*    */   public MasteryCostItem costs;
/*    */   public Const.Position Coords;
/*    */   
/*    */   public static class MasteryCostItem {
/*    */     public String itemCode;
/*    */     
/*    */     public MasteryCostItem(String itemCode, int itemNum) {
/* 19 */       this.itemCode = itemCode;
/* 20 */       this.itemNum = itemNum;
/*    */     }
/*    */ 
/*    */     
/*    */     public int itemNum;
/*    */   }
/*    */   
/*    */   public void initProperty() {
/* 28 */     Map<String, Integer> data = new TreeMap<>();
/* 29 */     String key = AttributeUtil.getKeyByName(this.prop);
/* 30 */     if (key != null) {
/* 31 */       data.put(key, Integer.valueOf(this.value));
/*    */     } else {
/*    */       
/* 34 */       Out.error(new Object[] { "MasteryLevelProp attrName not exist ", this.prop });
/*    */     } 
/* 36 */     this.attrs = data;
/* 37 */     MasteryCostItem costs = new MasteryCostItem(this.costItem, this.itemCount);
/* 38 */     this.costs = costs;
/*    */ 
/*    */     
/* 41 */     String[] str = this.coord.split(",");
/* 42 */     Const.Position coord = new Const.Position(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
/* 43 */     if (coord.y == 0) {
/* 44 */       Out.error(new Object[] { "MasteryLevelProp y is null " + this.iD });
/*    */     }
/* 46 */     this.Coords = coord;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\MasteryPropExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */