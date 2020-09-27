package com.wanniu.game.rank;

import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.leaderBoard.LeaderBoardDetail;
import com.wanniu.game.leaderBoard.LeaderBoardProto;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pomelo.area.LeaderBoardHandler;
import pomelo.revelry.ActivityRevelryHandler;
import redis.clients.jedis.Tuple;


public abstract class AbstractRankHandler {
    protected static final long target;

    static {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse("2025-01-01"));
        } catch (ParseException parseException) {
        }
        target = calendar.getTimeInMillis();
    }


    public int getCurrentSeason() {
        return getLastSeason() + 1;
    }


    public int getLastSeason() {
        return 0;
    }


    protected String getRedisKey(int logicServerId) {
        return getRedisKey(logicServerId, 0);
    }


    public LeaderBoardProto getRankData(WNPlayer player, int season) {
        return getRankData(GWorld.__SERVER_ID, season, getSelfId(player));
    }


    protected void updateRank(String key, long score, String memberId) {
        GCache.zadd(key, Double.parseDouble(score + "." + ((target - System.currentTimeMillis()) / 1000L)), memberId);
    }


    public void handle(GuildPO guild) {
    }


    public List<LeaderBoardDetail> getRankDetail(int serverId, int start, int end) {
        return getRankDetail(serverId, 0, start, end);
    }


    public List<LeaderBoardDetail> getRankDetail(int serverId, int season, int start, int end) {
        String key = getRedisKey(serverId, season);
        Set<Tuple> tuples = GCache.zrevrangeWithScores(key, start, end);
        List<LeaderBoardDetail> result = new ArrayList<>(tuples.size());
        int rank = 1;
        for (Tuple tuple : tuples) {
            LeaderBoardDetail detail = new LeaderBoardDetail();
            detail.rank = rank++;
            detail.score = tuple.getScore();
            detail.memberId = tuple.getElement();
            result.add(detail);
        }
        return result;
    }


    public long getSeasonRank(int serverId, int season, String playerId) {
        String key = getRedisKey(serverId, season);
        Long rank = GCache.zrevrank(key, playerId);
        return (rank == null) ? 0L : (rank.longValue() + 1L);
    }

    public long getRank(int logicServerId, String playerId) {
        return getSeasonRank(logicServerId, 0, playerId);
    }

    public void delRank(int serverId) {
        GCache.del(getRedisKey(serverId));
    }

    public String getFirstRankMemberId(int serverId) {
        Set<String> members = GCache.zrevrange(getRedisKey(serverId), 0L, 1L);
        return members.isEmpty() ? "" : members.iterator().next();
    }

    public void asyncUpdateRank(int serverId, String playerId, int score) {
        String key = getRedisKey(serverId);
        updateRank(key, score, playerId);
    }

    public void delRankMember(int serverId, String memberId) {
        GCache.zrem(getRedisKey(serverId), memberId);
    }

    public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
        int season = 0;
        if (Const.RankSeasonType.LAST_SEASON.value == seasonType) {
            season = getLastSeason();
        } else {
            season = getCurrentSeason();
        }
        String key = getRedisKey(serverId, season);

        LeaderBoardProto result = new LeaderBoardProto();
        int rank = 1;
        for (Tuple tuple : GCache.zrevrangeWithScores(key, 0L, (GlobalConfig.RankList_Limit - 1))) {
            String memberId = tuple.getElement();
            int score = (int) tuple.getScore();
            try {
                LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(memberId, score, rank);
                if (build == null) {
                    continue;
                }
                rank++;

                result.s2c_lists.add(build);

                if (selfId.equals(memberId)) {
                    result.s2c_myData = build;
                }
            } catch (Exception e) {
                Out.warn(new Object[]{"排行榜中的展示信息构建失败，忽略此人 playerId=", memberId});
            }
        }
        return result;
    }

    public double getSeasonScore(int logicServerId, int season, String selfId) {
        Double score = GCache.zscore(getRedisKey(logicServerId, season), selfId);
        return (score == null) ? 0.0D : score.doubleValue();
    }


    public SimpleRankData getSelfRankInfo(boolean isGameOver, String tabID, WNPlayer player) {
        String memberId = getSelfId(player);
        int season = getCurrentSeason();
        String key = getRedisKey(GWorld.__SERVER_ID, season);


        if (isGameOver) {
            key = (new StringBuilder(key.length() + 1 + tabID.length())).append(key).append("-").append(tabID).toString();
        }

        Long rank = GCache.zrevrank(key, memberId);
        rank = Long.valueOf((rank == null) ? 0L : (rank.longValue() + 1L));

        int score = 0;
        if (rank.longValue() > 0L) {
            Double scorex = GCache.zscore(key, memberId);
            score = (int) ((scorex == null) ? 0.0D : scorex.doubleValue());
        }
        SimpleRankData detail = new SimpleRankData();
        detail.setId(memberId);
        detail.setRank(rank.intValue());
        detail.setScore(score);
        return detail;
    }


    public Map<Integer, SimpleRankData> getSimpleRankData(boolean isGameOver, String tabID, int minRank, int maxRank) {
        int season = getCurrentSeason();
        String key = getRedisKey(GWorld.__SERVER_ID, season);

        if (isGameOver) {
            key = (new StringBuilder(key.length() + 1 + tabID.length())).append(key).append("-").append(tabID).toString();
        }

        Set<Tuple> tuples = GCache.zrevrangeWithScores(key, minRank, maxRank);
        Map<Integer, SimpleRankData> result = new HashMap<>();
        int rank = 1;
        for (Tuple tuple : tuples) {
            SimpleRankData detail = new SimpleRankData();
            detail.setId(tuple.getElement());
            detail.setRank(rank++);
            detail.setScore((int) tuple.getScore());
            result.put(Integer.valueOf(detail.getRank()), detail);
        }
        return result;
    }


    public Map<Integer, SimpleRankData> copyRankToKey(String tabID) {
        int season = getCurrentSeason();
        String key = getRedisKey(GWorld.__SERVER_ID, season);
        Set<Tuple> tuples = GCache.zrevrangeWithScores(key, 0L, 9999L);

        Map<Integer, SimpleRankData> result = new HashMap<>();
        Map<String, Double> scoreMembers = new HashMap<>();
        int rank = 1;
        for (Tuple tuple : tuples) {
            scoreMembers.put(tuple.getElement(), Double.valueOf(tuple.getScore()));

            SimpleRankData detail = new SimpleRankData();
            detail.setId(tuple.getElement());
            detail.setRank(rank++);
            detail.setScore((int) tuple.getScore());

            result.put(Integer.valueOf(detail.getRank()), detail);
        }

        String newKey = key + "-" + tabID;
        GCache.zadd(newKey, scoreMembers);

        GCache.expire(newKey, 2592000);
        return result;
    }

    public abstract void handle(WNPlayer paramWNPlayer, Object... paramVarArgs);

    protected abstract String getRedisKey(int paramInt1, int paramInt2);

    public abstract String getSelfId(WNPlayer paramWNPlayer);

    public abstract String getSelfName(WNPlayer paramWNPlayer);

    public abstract LeaderBoardHandler.LeaderBoardData genBuilderInfo(String paramString, long paramLong, int paramInt);

    public abstract void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder paramBuilder, SimpleRankData paramSimpleRankData);
}


