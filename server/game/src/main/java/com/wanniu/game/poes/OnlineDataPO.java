/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_online_data")
/*    */ public class OnlineDataPO
/*    */   extends GEntity
/*    */ {
/*    */   public long sumTime;
/* 18 */   public Map<Integer, Integer> rewardState = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\OnlineDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */