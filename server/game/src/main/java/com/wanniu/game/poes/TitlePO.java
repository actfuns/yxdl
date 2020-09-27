/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.rank.TitleManager;
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
/*    */ @DBTable("player_title")
/*    */ public final class TitlePO
/*    */   extends GEntity
/*    */ {
/*    */   public int selectedRankId;
/* 22 */   public Map<Integer, TitleManager.AwardRankData> awardRanks = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\TitlePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */