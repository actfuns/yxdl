/*    */ package com.wanniu.game.rank;
/*    */ 
/*    */ import com.wanniu.game.guild.GuildServiceCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.LeaderBoardHandler;
/*    */ import pomelo.revelry.ActivityRevelryHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractGuildRankHandler
/*    */   extends AbstractRankHandler
/*    */ {
/*    */   public String getSelfId(WNPlayer player) {
/* 22 */     return player.guildManager.getGuildId();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSelfName(WNPlayer player) {
/* 27 */     return player.guildManager.getGuildName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank) {
/* 35 */     LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();
/*    */     
/* 37 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
/* 38 */     if (null == guild) {
/* 39 */       return null;
/*    */     }
/*    */     
/* 42 */     List<String> contents = new ArrayList<>(5);
/* 43 */     contents.add(String.valueOf(rank));
/* 44 */     contents.add(memberId);
/* 45 */     contents.add(guild.icon);
/* 46 */     contents.add(guild.name);
/* 47 */     contents.add(String.valueOf(guild.level));
/* 48 */     builder.addAllContents(contents);
/* 49 */     return builder.build();
/*    */   }
/*    */ 
/*    */   
/*    */   public void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder info, SimpleRankData rankData) {
/* 54 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(rankData.getId());
/* 55 */     if (guild != null) {
/*    */       
/* 57 */       info.addContents(String.valueOf(rankData.getRank()));
/*    */       
/* 59 */       info.addContents(String.valueOf(guild.level));
/*    */       
/* 61 */       info.addContents(guild.name);
/*    */       
/* 63 */       info.addContents(guild.icon);
/*    */       
/* 65 */       info.addContents(String.valueOf(guild.level));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\AbstractGuildRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */