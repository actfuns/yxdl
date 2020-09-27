/*    */ package com.wanniu.game.guild;
/*    */ 
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechData;
/*    */ import com.wanniu.game.guild.po.GuildBlessPO;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.area.GuildDepotHandler;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildMsg
/*    */ {
/*    */   public int notifyType;
/*    */   public GuildMsgData data;
/*    */   
/*    */   public GuildMsg(int notifyType, GuildMsgData data) {
/* 18 */     this.notifyType = notifyType;
/* 19 */     this.data = data;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static abstract class GuildMsgData {}
/*    */ 
/*    */   
/*    */   public static class RefreshGuildMsg
/*    */     extends GuildMsgData
/*    */   {
/*    */     public int isIn;
/*    */     
/*    */     public int isOut;
/*    */     
/*    */     public int job;
/*    */     
/* 36 */     public String jobName = "";
/* 37 */     public String guildName = "";
/* 38 */     public ArrayList<GuildHandler.ContributeTimesInfo> timesList = new ArrayList<>();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class JoinGuildBlessMsg
/*    */     extends RefreshGuildMsg
/*    */   {
/* 46 */     public GuildBlessPO blessData = new GuildBlessPO();
/*    */   }
/*    */ 
/*    */   
/*    */   public static class DepotRefreshGuildMsg
/*    */     extends GuildMsgData
/*    */   {
/*    */     public int type;
/*    */     
/*    */     public int bagIndex;
/*    */     
/* 57 */     public GuildDepotHandler.DepotLevelInfo levelInfo = GuildDepotHandler.DepotLevelInfo.newBuilder().build();
/* 58 */     public GuildDepotCondition condition = new GuildDepotCondition();
/*    */   }
/*    */ 
/*    */   
/*    */   public static class BlessRefreshGuildMsg
/*    */     extends GuildMsgData
/*    */   {
/*    */     public int type;
/*    */     
/*    */     public int blessValue;
/* 68 */     public int[] finishStateArr = new int[3];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class ShopRefreshGuildMsg
/*    */     extends GuildMsgData {}
/*    */ 
/*    */   
/*    */   public static class TechRefreshGuildMsg
/*    */     extends GuildMsgData
/*    */   {
/* 80 */     public GuildTechData techData = new GuildTechData();
/*    */   }
/*    */   
/*    */   public static class DungeonPassGuildMsg extends GuildMsgData {
/*    */     public int dungeonCount;
/*    */   }
/*    */   
/*    */   public static class DungeonPlayerNumGuildMsg extends GuildMsgData {
/*    */     public int playerNum;
/*    */   }
/*    */   
/*    */   public static class OnChatGuildMsg extends GuildMsgData {
/*    */     public String playerId;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildMsg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */