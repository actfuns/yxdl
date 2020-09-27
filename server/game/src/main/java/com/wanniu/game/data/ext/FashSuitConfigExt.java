/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.FashSuitConfigCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FashSuitConfigExt
/*    */   extends FashSuitConfigCO
/*    */ {
/*    */   public Map<Const.PlayerBtlData, Integer> Attr2Map;
/*    */   public Map<Const.PlayerBtlData, Integer> Attr3Map;
/*    */   
/*    */   public void initProperty() {
/* 19 */     this.Attr2Map = new HashMap<>();
/* 20 */     this.Attr3Map = new HashMap<>();
/*    */     
/* 22 */     String[] attr2strs = this.attr2.split(";");
/* 23 */     String[] attr3strs = this.attr3.split(";");
/*    */     
/* 25 */     for (String str : attr2strs) {
/* 26 */       String[] sub_str = str.split(":");
/* 27 */       this.Attr2Map.put(Const.PlayerBtlData.getE(Integer.parseInt(sub_str[0])), Integer.valueOf(Integer.parseInt(sub_str[1])));
/*    */     } 
/*    */     
/* 30 */     for (String str : attr3strs) {
/* 31 */       String[] sub_str = str.split(":");
/* 32 */       this.Attr2Map.put(Const.PlayerBtlData.getE(Integer.parseInt(sub_str[0])), Integer.valueOf(Integer.parseInt(sub_str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\FashSuitConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */