/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.item.po.PlayerItemPO;
/*    */ import java.util.HashMap;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
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
/*    */ @DBTable("player_base")
/*    */ public class PlayerBasePO
/*    */   extends GEntity
/*    */ {
/*    */   public Map<Integer, PlayerItemPO> equipGrids;
/*    */   public Map<Integer, EquipStrengthPos> strengthPos;
/*    */   public String model;
/*    */   public float speed;
/* 45 */   public List<String> fashions_get = new LinkedList<>();
/* 46 */   public Map<Integer, String> fashions_equiped = new HashMap<>(); public PlayerBasePO() {
/* 47 */     for (Const.FASHION_TYPE t : Const.FASHION_TYPE.values()) {
/* 48 */       this.fashions_equiped.put(Integer.valueOf(t.value), null);
/*    */     }
/* 50 */     this.openRebornToday = false;
/* 51 */     this.openRebuildToday = false;
/* 52 */     this.openKaiguangToday = false;
/*    */   }
/*    */   
/*    */   public int fashion_get_spot;
/*    */   public boolean openRebornToday;
/*    */   public boolean openRebuildToday;
/*    */   public boolean openKaiguangToday;
/*    */   
/*    */   public static class EquipStrengthPos {
/*    */     public int enSection;
/*    */     public int enLevel;
/*    */     public Map<Integer, String> gems;
/*    */     public int socks;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerBasePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */