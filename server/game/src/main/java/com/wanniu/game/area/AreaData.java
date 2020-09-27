/*    */ package com.wanniu.game.area;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AreaData
/*    */ {
/*    */   public int areaId;
/*    */   public String instanceId;
/*    */   public float targetX;
/*    */   public float targetY;
/*    */   public int logicServerId;
/*    */   
/*    */   public AreaData(int areaId) {
/* 18 */     this.areaId = areaId;
/*    */   }
/*    */   
/*    */   public AreaData(int areaId, String instanceId) {
/* 22 */     this.areaId = areaId;
/* 23 */     this.instanceId = instanceId;
/*    */   }
/*    */   
/*    */   public AreaData(int areaId, float targetX, float targetY) {
/* 27 */     this.areaId = areaId;
/* 28 */     this.targetX = targetX;
/* 29 */     this.targetY = targetY;
/*    */   }
/*    */   
/*    */   public AreaData(int areaId, float targetX, float targetY, String instanceId) {
/* 33 */     this.areaId = areaId;
/* 34 */     this.targetX = targetX;
/* 35 */     this.targetY = targetY;
/* 36 */     this.instanceId = instanceId;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 40 */     return this.areaId + " : " + this.instanceId + " x:" + this.targetX + " y:" + this.targetY;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */