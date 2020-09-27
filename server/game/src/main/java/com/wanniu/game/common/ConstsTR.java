package com.wanniu.game.common;


public enum ConstsTR
        implements Table {
    playerTR("player"), playerBaseTR("player_base"), playerAttachTR("player_attach"), playerTempTR("player_temp_data"), playerTitleTR("player_title"), shopMallTR("player_shop_mall"), intergalMallTR("player_intergal_mall"),
    taskTR("player_tasks"), skillTR("player_skill"), activityTR("player_activity"), mountTR("player_mount"), achievementTR("player_achieves"), playerPetTR("player_pets"), pkRuleTR("player_pk_data"), bagTR("player_bags"), player_signTR("player_sign"), player_consignmentTR("player_consignment"),
    consignment_itemsTR("consignment_items"), player_vipTR("player_vip"), player_solo_dataTR("player_solo_data"), player_arena_dataTR("player_arena_data"), player_func_openTR("player_func_open"), player_fightlevelTR("player_fightlevel"), monster_drop_infoTR("monster_drop_info"), player_friendsTR("player_friends"), player_chourenTR("player_chouren"), player_leaderboardTR("player_leaderboard"),
    player_blood("player_blood"),


    player_dailyTR("player_daily"),

    player_farmTR("player_farm"),

    hookSetTR("player_hookset"), onlineGiftTR("player_online_data"), playerRecentChatTR("player_recent_chat"),

    playerBtlData("player_btl_data"), playerIdsTR("playerIdsTR"), intergalMallGlobalTR("global_intergal_mall"),


    player_interactTR("player_interact"), player_interact_numTR("player_interact_num"),

    playerRankTR("player_rank_info"),

    playerRechargeActivityTR("player_recharge_activity"),


    arenaSystemTR("arenaSystemTR"),

    soloSystemTR("soloSystemTR"),

    fleeSystemTR("fleeSystemTR"),

    rankTR("rank"),

    friendRankTR("friendRank"),

    seasonRankTR("seasonRank"),


    playerGuildTR("player_guild"), guildTR("guild"), guildMemberTR("guild_member"), guildApplyTR("guild_apply"),
    guildNewsTR("guild_news"),
    guildAuctionLogTR("guild_auction_log"),
    guildImpeachTR("guild_impeach"), guildDepotTR("guild_depot"), guildBlessTR("guild_bless"), guildDungeonTR("guild_dungeon"), playerGuildTechTR("player_guild_tech"), guildBossHurtTR("guild_boss_rank"), guildBossTR("guild_boss"), redpointTR("red_point"), guildFortTR("guild_fort"), guildFortReportTR("guild_fort_report"),

    mailTR("player_mails"), serverMailsTR("servermails"),


    fundsTR("funds"),

    feeOrder("feeOrder"), prepaidNewTR("prepaidNewTR"),


    daoYouTR("dao_you"), daoYouMemberTR("dao_you_member"),


    xianYuanTR("player_xianyuan"),


    five2FiveTR("player_five2five"), five2FiveBtlTR("five2FiveBtl"), five2FiveShardBtlReportTR("five2FiveShardBtlReport"), fivie2FiveSystemTR("five2FiveSystem"),

    chat_item_tr("chat_item_tr"),


    CDK("cdk"),

    CDK_LOCK("cdk_lock"),

    notice("notice"),

    PLAYER_DEMON_TOWER("PLAYER_DEMON_TOWER"), DAILY_RELIVE("DAILY_RELIVE"),

    player_fleeTR("player_flee"), NAME_MODULE("NAME_MODULE"),

    FIRST_LOGIN("first_login"),

    auction_itemsTR("auction_itemsTR"),

    RedPacket("RedPacket"),

    Rich("Rich"),

    SevenGoal("SevenGoal"),

    DemonTower("DemonTower"),

    GuildBossTR("guild_boss");

    public String value;

    ConstsTR(String tr) {
        this.value = tr;
    }
}


