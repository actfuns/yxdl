/*    */ package com.wanniu.game.guild.guidDepot;
/*    */ 
/*    */ import com.wanniu.game.poes.GuildDepotPO;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerGuildDepot
/*    */ {
/* 16 */   public GuildDepotPO depotInfo = new GuildDepotPO();
/* 17 */   public GuildManagerHandler.BagGridsInfo bagInfo = GuildManagerHandler.BagGridsInfo.newBuilder().build();
/* 18 */   public ArrayList<ItemOuterClass.ItemDetail> detailInfo = new ArrayList<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guidDepot\PlayerGuildDepot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */