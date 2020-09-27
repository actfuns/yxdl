/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ConstsTR
/*     */   implements Table
/*     */ {
/*  14 */   playerTR("player"), playerBaseTR("player_base"), playerAttachTR("player_attach"), playerTempTR("player_temp_data"), playerTitleTR("player_title"), shopMallTR("player_shop_mall"), intergalMallTR("player_intergal_mall"),
/*  15 */   taskTR("player_tasks"), skillTR("player_skill"), activityTR("player_activity"), mountTR("player_mount"), achievementTR("player_achieves"), playerPetTR("player_pets"), pkRuleTR("player_pk_data"), bagTR("player_bags"), player_signTR("player_sign"), player_consignmentTR("player_consignment"),
/*  16 */   consignment_itemsTR("consignment_items"), player_vipTR("player_vip"), player_solo_dataTR("player_solo_data"), player_arena_dataTR("player_arena_data"), player_func_openTR("player_func_open"), player_fightlevelTR("player_fightlevel"), monster_drop_infoTR("monster_drop_info"), player_friendsTR("player_friends"), player_chourenTR("player_chouren"), player_leaderboardTR("player_leaderboard"),
/*  17 */   player_blood("player_blood"),
/*     */ 
/*     */   
/*  20 */   player_dailyTR("player_daily"),
/*     */   
/*  22 */   player_farmTR("player_farm"),
/*     */   
/*  24 */   hookSetTR("player_hookset"), onlineGiftTR("player_online_data"), playerRecentChatTR("player_recent_chat"),
/*     */   
/*  26 */   playerBtlData("player_btl_data"), playerIdsTR("playerIdsTR"), intergalMallGlobalTR("global_intergal_mall"),
/*     */ 
/*     */   
/*  29 */   player_interactTR("player_interact"), player_interact_numTR("player_interact_num"),
/*     */   
/*  31 */   playerRankTR("player_rank_info"),
/*     */   
/*  33 */   playerRechargeActivityTR("player_recharge_activity"),
/*     */ 
/*     */   
/*  36 */   arenaSystemTR("arenaSystemTR"),
/*     */   
/*  38 */   soloSystemTR("soloSystemTR"),
/*     */   
/*  40 */   fleeSystemTR("fleeSystemTR"),
/*     */   
/*  42 */   rankTR("rank"),
/*     */   
/*  44 */   friendRankTR("friendRank"),
/*     */   
/*  46 */   seasonRankTR("seasonRank"),
/*     */ 
/*     */   
/*  49 */   playerGuildTR("player_guild"), guildTR("guild"), guildMemberTR("guild_member"), guildApplyTR("guild_apply"),
/*  50 */   guildNewsTR("guild_news"),
/*  51 */   guildAuctionLogTR("guild_auction_log"),
/*  52 */   guildImpeachTR("guild_impeach"), guildDepotTR("guild_depot"), guildBlessTR("guild_bless"), guildDungeonTR("guild_dungeon"), playerGuildTechTR("player_guild_tech"), guildBossHurtTR("guild_boss_rank"), guildBossTR("guild_boss"), redpointTR("red_point"), guildFortTR("guild_fort"), guildFortReportTR("guild_fort_report"),
/*     */   
/*  54 */   mailTR("player_mails"), serverMailsTR("servermails"),
/*     */ 
/*     */   
/*  57 */   fundsTR("funds"),
/*     */   
/*  59 */   feeOrder("feeOrder"), prepaidNewTR("prepaidNewTR"),
/*     */ 
/*     */   
/*  62 */   daoYouTR("dao_you"), daoYouMemberTR("dao_you_member"),
/*     */ 
/*     */   
/*  65 */   xianYuanTR("player_xianyuan"),
/*     */ 
/*     */   
/*  68 */   five2FiveTR("player_five2five"), five2FiveBtlTR("five2FiveBtl"), five2FiveShardBtlReportTR("five2FiveShardBtlReport"), fivie2FiveSystemTR("five2FiveSystem"),
/*     */   
/*  70 */   chat_item_tr("chat_item_tr"),
/*     */ 
/*     */   
/*  73 */   CDK("cdk"),
/*     */   
/*  75 */   CDK_LOCK("cdk_lock"),
/*     */   
/*  77 */   notice("notice"),
/*     */   
/*  79 */   PLAYER_DEMON_TOWER("PLAYER_DEMON_TOWER"), DAILY_RELIVE("DAILY_RELIVE"),
/*     */   
/*  81 */   player_fleeTR("player_flee"), NAME_MODULE("NAME_MODULE"),
/*     */   
/*  83 */   FIRST_LOGIN("first_login"),
/*     */   
/*  85 */   auction_itemsTR("auction_itemsTR"),
/*     */   
/*  87 */   RedPacket("RedPacket"),
/*     */   
/*  89 */   Rich("Rich"),
/*     */   
/*  91 */   SevenGoal("SevenGoal"),
/*     */   
/*  93 */   DemonTower("DemonTower"),
/*     */   
/*  95 */   GuildBossTR("guild_boss");
/*     */   
/*     */   public String value;
/*     */   
/*     */   ConstsTR(String tr) {
/* 100 */     this.value = tr;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\ConstsTR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */