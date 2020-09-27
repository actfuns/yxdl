/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.guild.guidDepot.GuildBagItem;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*    */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildDepotPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String id;
/*    */   public int logicServerId;
/*    */   public int level;
/*    */   public Date createTime;
/* 26 */   public GuildDepotCondition condition = new GuildDepotCondition();
/* 27 */   public ArrayList<GuildRecordData> news = new ArrayList<>();
/* 28 */   public GuildBagItem bag = new GuildBagItem();
/* 29 */   public Date refreshTime = new Date(0L);
/*    */   public int deleteCount;
/*    */   public int deleteCountMax;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\GuildDepotPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */