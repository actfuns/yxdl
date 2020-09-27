package com.wanniu.game.rank;

import com.wanniu.game.rank.handler.ArenaScoreAllRankHandler;
import com.wanniu.game.rank.handler.ArenaScoreRankHandler;
import com.wanniu.game.rank.handler.DaoYouRankHandler;
import com.wanniu.game.rank.handler.Five2FiveRankHandler;
import com.wanniu.game.rank.handler.FleeRankHandler;
import com.wanniu.game.rank.handler.GemRankHandler;
import com.wanniu.game.rank.handler.GuildBossPreRankGuildHandler;
import com.wanniu.game.rank.handler.GuildBossPreRankSingleHandler;
import com.wanniu.game.rank.handler.GuildBossRankGuildHandler;
import com.wanniu.game.rank.handler.GuildBossRankSingleHandler;
import com.wanniu.game.rank.handler.GuildFortRankHandler;
import com.wanniu.game.rank.handler.GuildLevelRankHandler;
import com.wanniu.game.rank.handler.MountRankHandler;
import com.wanniu.game.rank.handler.PetRankHandler;
import com.wanniu.game.rank.handler.PlayerDemonTowerRankHandler;
import com.wanniu.game.rank.handler.PlayerFightPowerRankHandler;
import com.wanniu.game.rank.handler.PlayerFightPower_1RankHandler;
import com.wanniu.game.rank.handler.PlayerFightPower_3RankHandler;
import com.wanniu.game.rank.handler.PlayerFightPower_5RankHandler;
import com.wanniu.game.rank.handler.PlayerHpRankHandler;
import com.wanniu.game.rank.handler.PlayerLevelRankHandler;
import com.wanniu.game.rank.handler.PlayerMagRankHandler;
import com.wanniu.game.rank.handler.PlayerPhyRankHandler;
import com.wanniu.game.rank.handler.PlayerXianYuanRankHandler;
import com.wanniu.game.rank.handler.SoloRankHandler;

public enum RankType {
    FIGHTPOWER(101, (AbstractRankHandler) new PlayerFightPowerRankHandler()),
    FIGHTPOWER_1(102, (AbstractRankHandler) new PlayerFightPower_1RankHandler()),

    FIGHTPOWER_3(104, (AbstractRankHandler) new PlayerFightPower_3RankHandler()),

    FIGHTPOWER_5(106, (AbstractRankHandler) new PlayerFightPower_5RankHandler()),

    LEVEL(200, (AbstractRankHandler) new PlayerLevelRankHandler()),

    GUILD_LEVEL(300, (AbstractRankHandler) new GuildLevelRankHandler()),
    GUILD_FORT(400, (AbstractRankHandler) new GuildFortRankHandler()),

    Mount(500, (AbstractRankHandler) new MountRankHandler()),
    PET(600, (AbstractRankHandler) new PetRankHandler()),
    XIANYUAN(700, (AbstractRankHandler) new PlayerXianYuanRankHandler()),
    HP(800, (AbstractRankHandler) new PlayerHpRankHandler()),
    PHY(801, (AbstractRankHandler) new PlayerPhyRankHandler()),
    MAGIC(802, (AbstractRankHandler) new PlayerMagRankHandler()),
    FLEE(900, (AbstractRankHandler) new FleeRankHandler()),

    PVP_5V5(1003, (AbstractRankHandler) new Five2FiveRankHandler()),
    GemLevel(1100, (AbstractRankHandler) new GemRankHandler()),

    DAOYOU(2005, (AbstractRankHandler) DaoYouRankHandler.getInstance()),


    SOLO_SCORE(2006, (AbstractRankHandler) new SoloRankHandler()) {
        public String getRedisKey(int serverId, int season) {
            return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).append("-").append(season).toString();
        }
    },
    ARENA_SCORE(2007, (AbstractRankHandler) ArenaScoreRankHandler.getInstance()),
    ARENA_SCOREALL(2009, (AbstractRankHandler) ArenaScoreAllRankHandler.getInstance()) {
        public String getRedisKey(int serverId, int season) {
            return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).append("-").append(season).toString();
        }
    },
    DEMON_TOWER(2100, (AbstractRankHandler) new PlayerDemonTowerRankHandler()),
    GUILD_BOSS_SINGLE(2200, (AbstractRankHandler) GuildBossRankSingleHandler.getInstance()),
    GUILD_BOSS_PRE_SINGLE(2201, (AbstractRankHandler) GuildBossPreRankSingleHandler.getInstance()),
    GUILD_BOSS_GUILD(2300, (AbstractRankHandler) GuildBossRankGuildHandler.getInstance()),
    GUILD_BOSS_PRE_GUILD(2301, (AbstractRankHandler) GuildBossPreRankGuildHandler.getInstance());


    private final int value;


    private final AbstractRankHandler handler;


    RankType(int value, AbstractRankHandler handler) {
        this.value = value;
        this.handler = handler;
    }


    public String getRedisKey(int serverId, int season) {
        return (new StringBuilder(32)).append("rank/").append(serverId).append("/").append(name()).toString();
    }

    public int getValue() {
        return this.value;
    }

    public AbstractRankHandler getHandler() {
        return this.handler;
    }
}


