/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.DropListExt;
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
/*    */ @DBTable("player_demon_tower_center")
/*    */ public final class DemonTowerCenterPO
/*    */   extends GEntity
/*    */ {
/* 33 */   public List<String> firstPlayerIds = new LinkedList<>();
/* 34 */   public List<Date> firstPlayerDates = new LinkedList<>();
/* 35 */   public List<String> fastPlayerIds = new LinkedList<>();
/* 36 */   public List<Long> fastPlayerTimes = new LinkedList<>();
/*    */   
/*    */   public DemonTowerCenterPO() {
/* 39 */     for (DropListExt dropListExt : GameData.DropLists.values()) {
/* 40 */       this.firstPlayerIds.add(null);
/* 41 */       this.firstPlayerDates.add(null);
/* 42 */       this.fastPlayerIds.add(null);
/* 43 */       this.fastPlayerTimes.add(null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\DemonTowerCenterPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */