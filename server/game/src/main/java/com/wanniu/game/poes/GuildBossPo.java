/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.Date;
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
/*    */ @DBTable("player_guild_boss")
/*    */ public class GuildBossPo
/*    */   extends GEntity
/*    */ {
/* 36 */   public InspirePO inspire = new InspirePO();
/* 37 */   public int hasPoint = 0;
/* 38 */   public Date pointDate = new Date();
/* 39 */   public int aucpoint = 0;
/* 40 */   public Date aucpointDate = new Date();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\GuildBossPo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */