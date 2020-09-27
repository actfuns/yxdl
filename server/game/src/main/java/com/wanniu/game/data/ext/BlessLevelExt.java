/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.BlessBuffCO;
/*    */ import com.wanniu.game.data.BlessLevelCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class BlessLevelExt
/*    */   extends BlessLevelCO {
/* 15 */   public Map<Const.PlayerBtlData, Integer> bufsAttr = new HashMap<>();
/*    */   
/*    */   public void initProperty() {
/* 18 */     super.initProperty();
/* 19 */     this.buffList = new ArrayList<>();
/* 20 */     String[] strArr = this.blessBuff.split(",");
/* 21 */     for (int i = 0; i < strArr.length; i++) {
/* 22 */       int id = Integer.parseInt(strArr[i]);
/* 23 */       this.buffList.add(Integer.valueOf(id));
/* 24 */       BlessBuffCO prop = (BlessBuffCO)GameData.BlessBuffs.get(Integer.valueOf(id));
/* 25 */       if (prop == null) {
/* 26 */         Out.error(new Object[] { "找不到工会buffId" });
/*    */       } else {
/*    */         
/* 29 */         Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(prop.buffAttribute1);
/* 30 */         if (pbd == null) {
/* 31 */           Out.error(new Object[] { "找不到工会buff类型" });
/*    */         } else {
/*    */           
/* 34 */           this.bufsAttr.put(pbd, Integer.valueOf(prop.buffValue1));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public List<Integer> buffList;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BlessLevelExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */