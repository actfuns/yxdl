/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.GTechnologyCO;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GTechnologyExt
/*    */   extends GTechnologyCO
/*    */ {
/*    */   public Map<String, Integer> attrs;
/*    */   public List<Integer> recommendPros;
/*    */   
/*    */   public void putAttr(String str, int value) {
/* 18 */     if (null == this.attrs) {
/* 19 */       this.attrs = new HashMap<>();
/*    */     }
/*    */     
/* 22 */     if (!StringUtil.isNullOrEmpty(str)) {
/* 23 */       String attr = AttributeUtil.getKeyByName(str);
/* 24 */       this.attrs.put(attr, Integer.valueOf(value));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void initProperty() {
/* 29 */     putAttr(this.techAttribute1, this.techValue1);
/* 30 */     putAttr(this.techAttribute2, this.techValue2);
/* 31 */     this.recommendPros = new ArrayList<>();
/* 32 */     if (StringUtil.isNullOrEmpty(this.recommend)) {
/* 33 */       String[] proArr = this.recommend.split(",");
/* 34 */       for (String pro : proArr)
/* 35 */         this.recommendPros.add(Integer.valueOf(Integer.parseInt(pro))); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\GTechnologyExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */