/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.GetLandCO;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import java.util.HashMap;
/*    */ import java.util.LinkedList;
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
/*    */ @DBTable("player_farm")
/*    */ public final class FarmPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String playerId;
/*    */   public int exp;
/*    */   public int lv;
/* 50 */   public Map<Integer, FarmMgr.Block> blockMap = new HashMap<>(); public LinkedList<FarmMgr.RecordInfo> recordLs; public FarmPO() {
/* 51 */     for (GetLandCO getLandCO : GameData.GetLands.values()) {
/* 52 */       FarmMgr.Block block = new FarmMgr.Block(getLandCO.landNum);
/* 53 */       this.blockMap.put(Integer.valueOf(getLandCO.landNum), block);
/*    */     } 
/*    */     
/* 56 */     this.recordLs = new LinkedList<>();
/*    */ 
/*    */ 
/*    */     
/* 60 */     this.shopToday = new HashMap<>();
/*    */   }
/*    */   public int stealCountToday; public Map<Integer, Integer> shopToday;
/*    */   public FarmPO(String playerId) {
/* 64 */     this();
/* 65 */     this.playerId = playerId;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\FarmPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */