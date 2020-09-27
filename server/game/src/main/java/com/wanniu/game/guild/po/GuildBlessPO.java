/*    */ package com.wanniu.game.guild.po;
/*    */ 
/*    */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechData;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class GuildBlessPO
/*    */ {
/*    */   public static class GuildBlessItem
/*    */   {
/*    */     public int id;
/*    */     public int finishNum;
/*    */     public int needNum;
/*    */   }
/*    */   
/*    */   public static class GuildBlessAllBlob
/*    */   {
/*    */     public int blessValue;
/*    */     public int blessValueMax;
/* 33 */     public ArrayList<GuildRecordData> news = new ArrayList<>();
/* 34 */     public Date refreshTime = new Date(0L);
/* 35 */     public Map<Integer, GuildBlessPO.GuildBlessItem> blessItems = new HashMap<>(); public int blessLevel;
/* 36 */     public ArrayList<Integer> goods = new ArrayList<>();
/* 37 */     public GuildTechData techData = new GuildTechData();
/* 38 */     public int[] finishStateArr = new int[3]; public GuildBlessAllBlob() {
/* 39 */       for (int i = 0; i < this.finishStateArr.length; i++) {
/* 40 */         this.finishStateArr[i] = 0;
/*    */       }
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public int throwAwardState;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public String id = "";
/* 54 */   public Date createTime = new Date(0L);
/* 55 */   public GuildBlessAllBlob allBlobData = new GuildBlessAllBlob();
/* 56 */   public List<Map<String, Integer>> gifts = new ArrayList<>();
/*    */   public int logicServerId;
/*    */   public int level;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\po\GuildBlessPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */