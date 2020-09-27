/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.friend.ChouRenData;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_chouren")
/*    */ public class PlayerChouRenPO
/*    */   extends GEntity
/*    */ {
/* 17 */   public Map<String, ChouRenData> chouRens = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerChouRenPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */