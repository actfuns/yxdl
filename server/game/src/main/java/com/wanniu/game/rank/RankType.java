/*     */ package com.wanniu.game.rank;
/*     */ 
/*     */ import com.wanniu.game.rank.handler.ArenaScoreAllRankHandler;
/*     */ import com.wanniu.game.rank.handler.ArenaScoreRankHandler;
/*     */ import com.wanniu.game.rank.handler.DaoYouRankHandler;
/*     */ import com.wanniu.game.rank.handler.Five2FiveRankHandler;
/*     */ import com.wanniu.game.rank.handler.FleeRankHandler;
/*     */ import com.wanniu.game.rank.handler.GemRankHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossPreRankGuildHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossPreRankSingleHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossRankGuildHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossRankSingleHandler;
/*     */ import com.wanniu.game.rank.handler.GuildFortRankHandler;
/*     */ import com.wanniu.game.rank.handler.GuildLevelRankHandler;
/*     */ import com.wanniu.game.rank.handler.MountRankHandler;
/*     */ import com.wanniu.game.rank.handler.PetRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerDemonTowerRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerFightPowerRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerFightPower_1RankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerFightPower_3RankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerFightPower_5RankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerHpRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerLevelRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerMagRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerPhyRankHandler;
/*     */ import com.wanniu.game.rank.handler.PlayerXianYuanRankHandler;
/*     */ import com.wanniu.game.rank.handler.SoloRankHandler;
/*     */ 
/*     */ public enum RankType {
/*  30 */   FIGHTPOWER(101, (AbstractRankHandler)new PlayerFightPowerRankHandler()),
/*  31 */   FIGHTPOWER_1(102, (AbstractRankHandler)new PlayerFightPower_1RankHandler()),
/*     */   
/*  33 */   FIGHTPOWER_3(104, (AbstractRankHandler)new PlayerFightPower_3RankHandler()),
/*     */   
/*  35 */   FIGHTPOWER_5(106, (AbstractRankHandler)new PlayerFightPower_5RankHandler()),
/*     */   
/*  37 */   LEVEL(200, (AbstractRankHandler)new PlayerLevelRankHandler()),
/*     */   
/*  39 */   GUILD_LEVEL(300, (AbstractRankHandler)new GuildLevelRankHandler()),
/*  40 */   GUILD_FORT(400, (AbstractRankHandler)new GuildFortRankHandler()),
/*     */   
/*  42 */   Mount(500, (AbstractRankHandler)new MountRankHandler()),
/*  43 */   PET(600, (AbstractRankHandler)new PetRankHandler()),
/*  44 */   XIANYUAN(700, (AbstractRankHandler)new PlayerXianYuanRankHandler()),
/*  45 */   HP(800, (AbstractRankHandler)new PlayerHpRankHandler()),
/*  46 */   PHY(801, (AbstractRankHandler)new PlayerPhyRankHandler()),
/*  47 */   MAGIC(802, (AbstractRankHandler)new PlayerMagRankHandler()),
/*  48 */   FLEE(900, (AbstractRankHandler)new FleeRankHandler()),
/*     */   
/*  50 */   PVP_5V5(1003, (AbstractRankHandler)new Five2FiveRankHandler()),
/*  51 */   GemLevel(1100, (AbstractRankHandler)new GemRankHandler()),
/*     */   
/*  53 */   DAOYOU(2005, (AbstractRankHandler)DaoYouRankHandler.getInstance()),
/*     */ 
/*     */   
/*  56 */   SOLO_SCORE(2006, (AbstractRankHandler)new SoloRankHandler())
/*     */   {
/*     */     public String getRedisKey(int serverId, int season) {
/*  59 */       return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).append("-").append(season).toString();
/*     */     }
/*     */   },
/*  62 */   ARENA_SCORE(2007, (AbstractRankHandler)ArenaScoreRankHandler.getInstance()),
/*  63 */   ARENA_SCOREALL(2009, (AbstractRankHandler)ArenaScoreAllRankHandler.getInstance())
/*     */   {
/*     */     public String getRedisKey(int serverId, int season) {
/*  66 */       return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).append("-").append(season).toString();
/*     */     }
/*     */   },
/*  69 */   DEMON_TOWER(2100, (AbstractRankHandler)new PlayerDemonTowerRankHandler()),
/*  70 */   GUILD_BOSS_SINGLE(2200, (AbstractRankHandler)GuildBossRankSingleHandler.getInstance()),
/*  71 */   GUILD_BOSS_PRE_SINGLE(2201, (AbstractRankHandler)GuildBossPreRankSingleHandler.getInstance()),
/*  72 */   GUILD_BOSS_GUILD(2300, (AbstractRankHandler)GuildBossRankGuildHandler.getInstance()),
/*  73 */   GUILD_BOSS_PRE_GUILD(2301, (AbstractRankHandler)GuildBossPreRankGuildHandler.getInstance());
/*     */ 
/*     */ 
/*     */   
/*     */   private final int value;
/*     */ 
/*     */   
/*     */   private final AbstractRankHandler handler;
/*     */ 
/*     */   
/*     */   RankType(int value, AbstractRankHandler handler) {
/*  84 */     this.value = value;
/*  85 */     this.handler = handler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRedisKey(int serverId, int season) {
/*  95 */     return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).toString();
/*     */   }
/*     */   
/*     */   public int getValue() {
/*  99 */     return this.value;
/*     */   }
/*     */   
/*     */   public AbstractRankHandler getHandler() {
/* 103 */     return this.handler;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\RankType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */