/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.TransportCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransportExt
/*    */   extends TransportCO
/*    */ {
/*    */   public int targetX;
/*    */   public int targetY;
/*    */   public Map<String, Integer> targetPoint_;
/*    */   
/*    */   public void initProperty() {
/* 18 */     if (!StringUtil.isEmpty(this.targetPoint)) {
/* 19 */       String[] targetPointStr = this.targetPoint.split(",");
/* 20 */       int targetX = (int)Float.parseFloat(targetPointStr[0]);
/* 21 */       int targetY = (int)Float.parseFloat(targetPointStr[1]);
/* 22 */       this.targetPoint_ = new HashMap<>();
/* 23 */       this.targetPoint_.put("targetX", Integer.valueOf(targetX));
/* 24 */       this.targetPoint_.put("targetY", Integer.valueOf(targetY));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TransportExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */