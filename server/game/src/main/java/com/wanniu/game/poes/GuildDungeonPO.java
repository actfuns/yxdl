/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeonRecord;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeonThrowInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import pomelo.guild.GuildManagerHandler;
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
/*    */ public class GuildDungeonPO
/*    */   extends GEntity
/*    */ {
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/* 38 */   public String id = ""; public int openTimesToday; public int openState;
/* 39 */   public Date dungeonPassedTime = new Date(0L); public int bReward; public int currPassedCount; public int totalPassedCount;
/* 40 */   public Date openTime = new Date(0L);
/* 41 */   public Map<Integer, GuildDungeonRecord> dungeonRecord = new HashMap<>();
/* 42 */   public String instanceId = "";
/* 43 */   public String serverId = "";
/* 44 */   public ArrayList<GuildDungeonThrowInfo> throwInfo = new ArrayList<>();
/* 45 */   public Map<Integer, ArrayList<String>> damagePlayer = new HashMap<>();
/* 46 */   public ArrayList<GuildManagerHandler.RankInfo> damageRankInfo = new ArrayList<>();
/* 47 */   public ArrayList<GuildManagerHandler.RankInfo> healRankInfo = new ArrayList<>();
/*    */   public int enterState;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\GuildDungeonPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */