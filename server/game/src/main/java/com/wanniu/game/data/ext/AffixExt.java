/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.ClassUtil;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.AffixCO;
/*    */ import com.wanniu.game.data.base.FourProp;
/*    */ import com.wanniu.game.player.AttributeUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AffixExt
/*    */   extends AffixCO
/*    */ {
/*    */   public Map<Integer, FourProp> props;
/*    */   public String attName;
/*    */   
/*    */   public int getKey() {
/* 27 */     return super.getKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 32 */     this.props = new HashMap<>();
/*    */     
/*    */     try {
/* 35 */       for (int i = 0; i < 5; i++) {
/* 36 */         String propName = (String)ClassUtil.getProperty(this, "prop" + i);
/* 37 */         if (StringUtil.isNotEmpty(propName)) {
/*    */ 
/*    */           
/* 40 */           FourProp _prop = new FourProp(AttributeUtil.getKeyByName(propName), ((Integer)ClassUtil.getProperty(this, "par" + i)).intValue(), ((Integer)ClassUtil.getProperty(this, "min" + i)).intValue(), ((Integer)ClassUtil.getProperty(this, "max" + i)).intValue());
/* 41 */           this.props.put(Integer.valueOf(i), _prop);
/* 42 */           if (!StringUtil.isEmpty(_prop.prop)) {
/* 43 */             this.attName = _prop.prop;
/*    */           }
/*    */         } 
/*    */       } 
/* 47 */     } catch (Exception e) {
/* 48 */       Out.error(new Object[] { e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\AffixExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */