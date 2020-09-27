/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.recent.RecentChatMsg;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_recent_chat")
/*    */ public class RecentChatPO
/*    */   extends GEntity
/*    */ {
/* 16 */   public Map<String, RecentChatMsg> msg = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\RecentChatPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */