/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.guild.GuildServiceCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import com.wanniu.game.rank.AbstractGuildRankHandler;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.LeaderBoardHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildFortRankHandler
/*    */   extends AbstractGuildRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 23 */     return RankType.GUILD_FORT.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 30 */     String guildId = (String)value[0];
/* 31 */     long winTimes = ((Integer)value[1]).intValue();
/*    */     
/* 33 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 34 */     updateRank(key, winTimes, guildId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank) {
/* 42 */     LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();
/*    */     
/* 44 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
/* 45 */     if (null == guild) {
/* 46 */       return null;
/*    */     }
/*    */     
/* 49 */     List<String> contents = new ArrayList<>(5);
/* 50 */     contents.add(String.valueOf(rank));
/* 51 */     contents.add(memberId);
/* 52 */     contents.add(guild.icon);
/* 53 */     contents.add(guild.name);
/* 54 */     contents.add(String.valueOf(guild.level));
/* 55 */     contents.add(String.valueOf(score));
/* 56 */     builder.addAllContents(contents);
/* 57 */     return builder.build();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(GuildPO guild) {
/* 64 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 65 */     long winTimes = guild.fortInfo.winTimes;
/* 66 */     updateRank(key, winTimes, guild.id);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\GuildFortRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */