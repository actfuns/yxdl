/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.Date;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_demon_tower")
/*    */ public final class DemonTowerPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String playerId;
/* 41 */   public int maxFloor = 1; public int failedMapId;
/* 42 */   public Date firstTimeToPeak = new Date(); public int sweepCountLeft; public Date sweepEndTime;
/* 43 */   public List<Long> leastTimeList = new LinkedList<>();
/*    */   public DemonTowerPO() {}
/*    */   
/*    */   public DemonTowerPO(String playerId, int currentFloor, int failedMapId, int sweepCountLeft) {
/* 47 */     this();
/* 48 */     this.playerId = playerId;
/* 49 */     this.maxFloor = currentFloor;
/* 50 */     this.failedMapId = 0;
/* 51 */     this.sweepCountLeft = sweepCountLeft;
/*    */     
/* 53 */     this.sweepEndTime = null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\DemonTowerPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */