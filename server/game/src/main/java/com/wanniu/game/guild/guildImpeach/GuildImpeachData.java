/*    */ package com.wanniu.game.guild.guildImpeach;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildImpeachData
/*    */ {
/*    */   public String id;
/*    */   public int logicServerId;
/*    */   
/*    */   public static class Sponsor
/*    */   {
/*    */     public String id;
/*    */     public int pro;
/*    */     public String name;
/*    */   }
/* 21 */   public Date logoutTime = new Date(0L);
/* 22 */   public Date createTime = new Date(0L);
/* 23 */   public ArrayList<String> playerIds = new ArrayList<>();
/* 24 */   public Sponsor sponsor = new Sponsor();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildImpeach\GuildImpeachData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */