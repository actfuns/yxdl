/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.mail.WNMail;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ @DBTable("player_mails")
/*    */ public class PlayerMailDataPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(fieldType = "mediumblob")
/* 15 */   public Map<String, WNMail> mails = new HashMap<>();
/*    */ 
/*    */   
/* 18 */   public Map<String, String> serverMailRecord = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerMailDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */