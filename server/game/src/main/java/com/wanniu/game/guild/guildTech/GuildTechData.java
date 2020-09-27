/*    */ package com.wanniu.game.guild.guildTech;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GuildTechData
/*    */ {
/*    */   public String id;
/*    */   
/*    */   public static class GuildTechBlob
/*    */   {
/*    */     public int level;
/*    */     public int buffLevel;
/*    */     public int refreshLevel;
/* 15 */     public Map<String, Integer> products = new HashMap<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 23 */   public GuildTechBlob blobData = new GuildTechBlob();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildTech\GuildTechData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */