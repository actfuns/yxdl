/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.ItemTypeConfigCO;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class ItemTypeConfigExt
/*    */   extends ItemTypeConfigCO
/*    */ {
/*    */   public List<String> subTypes;
/*    */   
/*    */   public void beforeProperty() {
/* 18 */     this.subTypes = new ArrayList<>();
/* 19 */     for (int i = 1; i <= 12; i++) {
/* 20 */       Field f_sub_type = ClassUtil.getDeclaredField(this, "subType" + i);
/*    */       try {
/* 22 */         Object subType = f_sub_type.get(this);
/* 23 */         if (subType != null && StringUtil.isNotEmpty(subType.toString())) {
/* 24 */           this.subTypes.add(subType.toString());
/*    */         }
/* 26 */       } catch (Exception e) {
/* 27 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getKey() {
/* 34 */     return this.iD;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ItemTypeConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */