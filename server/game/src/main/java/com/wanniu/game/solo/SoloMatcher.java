package com.wanniu.game.solo;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.solo.vo.MatcherVO;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import pomelo.Common;
import pomelo.area.SoloHandler;


public class SoloMatcher {
    public long sumMatchingTime;
    public int matchedNumber;
    private Map<String, MatcherVO> matchers = new ConcurrentHashMap<>();
    private static List<MatchedTeam> matchedQueue = new CopyOnWriteArrayList<>();
    private static SoloMatcher soloService;

    public static SoloMatcher getInstance() {
        if (soloService == null) {
            soloService = new SoloMatcher();
        }
        return soloService;
    }

    private SoloMatcher() {
        init();
    }

    private void init() {
        this.sumMatchingTime = 0L;
        this.matchedNumber = 0;

        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                if (SoloService.getInstance().isInOpenTime()) {
                    SoloMatcher.this.checkMatchers();
                }
            }
        }, GlobalConfig.Solo_MatchWaitTime, GlobalConfig.Solo_MatchWaitTime, TimeUnit.SECONDS);
    }


    private void checkMatchers() {
        synchronized (this.matchers) {
            Iterator<MatcherVO> iter = this.matchers.values().iterator();
            while (iter.hasNext()) {
                MatcherVO mpo = iter.next();
                if (mpo.isOnline()) {
                    if (mpo.getBeginTime() >= GlobalConfig.Solo_MatchWaitTime)
                        mpo.increaseScoreRange();
                    continue;
                }
                if (mpo.getOfflinedTime() >= GlobalConfig.Solo_MatchOfflineTime) {
                    iter.remove();
                    Out.debug(new Object[]{"matcher list removed player:", mpo.getPlayer().getName()});
                }
            }


            for (MatcherVO mpo : this.matchers.values()) {
                if (mpo.isMarkedDel()) {
                    Out.warn(new Object[]{"匹配异常，命中匹配过了，playerId=", mpo.getPlayerId()});
                    continue;
                }
                if (!mpo.isOnline()) {
                    Out.warn(new Object[]{"匹配异常，命中不在线了，playerId=", mpo.getPlayerId()});
                    continue;
                }
                markMatched(mpo);
            }

            iter = this.matchers.values().iterator();
            while (iter.hasNext()) {
                MatcherVO mpo = iter.next();
                if (mpo.isMarkedDel()) {
                    iter.remove();
                    Out.debug(new Object[]{"matcher list removed player:" + mpo.getPlayer().getName()});
                }
            }
        }
    }


    private void markMatched(MatcherVO player) {
        int minScore = player.getMinScore();
        int maxScore = player.getMaxScore();

        for (MatcherVO mpo : this.matchers.values()) {
            if (!mpo.isMarkedDel() && mpo.isOnline() && mpo.getScore() >= minScore && mpo.getScore() <= maxScore && !player.getPlayerId().equals(mpo.getPlayerId())) {
                mpo.setMarkedDel(true);
                player.setMarkedDel(true);
                addWaiter(mpo.getPlayer(), player.getPlayer());
                return;
            }
        }
    }


    public void resetMatchingList() {
        this.sumMatchingTime = 0L;
        this.matchedNumber = 0;
        this.matchers.clear();
    }


    public boolean joinBattle(WNPlayer wnPlayer) {
        MatchedTeam team = getTeam(wnPlayer.getId());
        if (team == null) {
            return false;
        }
        GWorld.getInstance().ansycExec(() -> {
            synchronized (team) {
                if (team.getAllPlayers().contains(wnPlayer)) {
                    wnPlayer.achievementManager.onSoloBattle();

                    if (team.getBattleArea() != null) {
                        enterSoloArea(wnPlayer, team.getBattleArea());
                    } else {
                        team.setBattleArea(enterNewSoloArea(wnPlayer));
                    }

                    Out.info(new Object[]{"solo enter scene: instanceId=", (team.getBattleArea()).instanceId});
                    team.remove(wnPlayer.getId());
                }
            }
        });
        return true;
    }


    public int getAvgMatchingTime() {
        if (this.matchedNumber <= 0) {
            return GlobalConfig.Solo_MATCH_TIME;
        }
        return (int) (this.sumMatchingTime / this.matchedNumber) / 1000;
    }


    public long updateMatchingTime(long matchedTime) {
        this.matchedNumber++;
        this.sumMatchingTime += matchedTime;
        return this.sumMatchingTime / this.matchedNumber;
    }


    public WNPlayer findMatchedPlayer(int myScore, String myId) {
        WNPlayer dest = null;
        synchronized (this.matchers) {
            int matchScoreRange = GlobalConfig.Solo_MatchRangeIncrease;
            int minScore = myScore - matchScoreRange;
            int maxScore = myScore + matchScoreRange;

            MatcherVO player = this.matchers.get(myId);
            if (player != null) {
                minScore = player.getMinScore();
                maxScore = player.getMaxScore();
            }
            for (MatcherVO mpo : this.matchers.values()) {

                if (mpo.isOnline() && !mpo.isMarkedDel() && mpo.getScore() >= minScore && mpo.getScore() <= maxScore) {
                    dest = mpo.getPlayer();
                    break;
                }
            }
            if (dest != null) {
                this.matchers.remove(dest.getId());
                if (player != null) {
                    this.matchers.remove(player.getPlayerId());
                }
            }
        }
        return dest;
    }

    public void playerOffline(String playerId) {
        MatcherVO player = this.matchers.get(playerId);
        if (player != null) {
            player.setOffline();
        }
    }


    public void addToMatchingList(int myScore, WNPlayer me) {
        MatcherVO player = this.matchers.get(me.getId());

        if (player != null) {
            player.setOnline();
        } else {
            this.matchers.put(me.getId(), new MatcherVO(myScore, me));
        }
        Out.debug(new Object[]{me.getName(), " added -------mathers:", Integer.valueOf(this.matchers.size())});
    }


    public boolean isInMatchingList(String playerId) {
        return (this.matchers.get(playerId) != null);
    }


    public void delToMatchingList(String playerId) {
        this.matchers.remove(playerId);
    }


    public static void addWaiter(WNPlayer a, WNPlayer b) {
        Out.info(new Object[]{"solo matched:", "a=", a.getId(), ",b=", b.getId()});
        final MatchedTeam team = new MatchedTeam(a, b);

        matchedQueue.add(team);
        pushSoloMatched(a, b, false);
        pushSoloMatched(b, a, false);


        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                Collection<WNPlayer> members = team.getAllPlayers();
                for (WNPlayer member : members) {
                    SoloMatcher.getInstance().joinBattle(member);
                }


                SoloMatcher.matchedQueue.remove(team);
            }
        }, GlobalConfig.Solo_EnterTime, TimeUnit.SECONDS);
    }


    private static Area enterNewSoloArea(WNPlayer player) {
        player.setForce(Const.AreaForce.FORCEA.value);
        player.soloManager.onEnterSoloArea();
        Map<String, Object> userData = Utils.ofMap(new Object[]{"isAddRobot", Boolean.valueOf(false), "pro", Integer.valueOf(player.getPro())});
        Area area = AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[]{player.getId()}, ), player.getLogicServerId(), GlobalConfig.Solo_MapID, userData);
        if (!PlayerUtil.isOnline(player.getId())) {
            area.addPlayer(player);
            area.playerEnterRequest(player);
            player.getXmdsManager().playerReady(player.getId());
            area.onPlayerAutoBattle(player, true);
        }
        Out.debug(new Object[]{player.getName(), "-------------- enter1 --------------", area.instanceId});
        return area;
    }


    private static void enterSoloArea(WNPlayer player, Area area) {
        player.soloManager.onEnterSoloArea();
        if (area != null && !area.isClose()) {
            player.setForce(Const.AreaForce.FORCEB.value);
            Out.debug(new Object[]{player.getName(), "-------------- enter2 --------------", area.instanceId});
            if (!PlayerUtil.isOnline(player.getId())) {
                area.addPlayer(player);
                area.playerEnterRequest(player);
                player.getXmdsManager().playerReady(player.getId());
                area.onPlayerAutoBattle(player, true);
            } else {
                AreaData areaData = new AreaData(area.areaId, area.instanceId);
                AreaUtil.dispatchByInstanceId(player, areaData);
            }
        }
    }

    private MatchedTeam getTeam(String playerId) {
        for (MatchedTeam team : matchedQueue) {
            if (team.getPlayer(playerId) != null) {
                return team;
            }
        }
        return null;
    }


    public static void pushSoloMatched(WNPlayer me, WNPlayer vsPlayer, boolean isReconnect) {
        if (me == null || vsPlayer == null) {
            Out.error(new Object[]{"Player null occoured in pushSoloMatched..."});
            return;
        }
        me.soloManager.setBusy(true);
        me.dailyActivityMgr.onEvent(Const.DailyType.SOLO, "0", 1);
        getInstance().updateMatchingTime(me.soloManager.getMatchedTime());
        SoloHandler.OnSoloMatchedPush.Builder msg = SoloHandler.OnSoloMatchedPush.newBuilder();
        msg.setS2CCode(200);
        msg.setS2CVsPlayerName(vsPlayer.getName());
        msg.setS2CVsPlayerPro(vsPlayer.getPro());
        msg.setS2CVsPlayerLevel(vsPlayer.getLevel());
        List<Common.Avatar> equipAvatars = PlayerUtil.getBattlerServerAvatar(vsPlayer, false);
        msg.addAllS2CVsPlayerAvatars(equipAvatars);
        msg.setS2CWaitResponseTimeSec(GlobalConfig.Solo_EnterTime);
        me.receive("area.soloPush.onSoloMatchedPush", (GeneratedMessage) msg.build());
    }
}


