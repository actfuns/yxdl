package com.wanniu.game.arena;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaEvent;
import com.wanniu.game.arena.vo.ArenaBattleVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GameMapCO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.ArenaHandler;
import pomelo.area.PlayerHandler;


public class ArenaArea
        extends Area {
    private String firstPlayerId;
    private ConcurrentHashMap<String, ArenaBattleVO> rank = new ConcurrentHashMap<>();

    public ArenaArea(JSONObject opts) {
        super(opts);
    }


    private void refreshPlayerRank(WNPlayer player) {
        ArenaBattleVO vo = this.rank.get(player.getId());
        int oldScore = vo.getScore();
        vo.setScore(player.arenaManager.getScore());
        vo.setKillCount(player.arenaManager.getCombo());
        if (oldScore != vo.getScore()) {
            vo.setUpdateTime(System.currentTimeMillis());
        }
    }


    private List<ArenaHandler.ArenaBattleScore> getAllKillCount() {
        List<ArenaBattleVO> listRank = new ArrayList<>(this.rank.values());
        Collections.sort(listRank, new Comparator<ArenaBattleVO>() {
            public int compare(ArenaBattleVO left, ArenaBattleVO right) {
                return (left.getKillCount() >= right.getKillCount()) ? -1 : 1;
            }
        });


        List<ArenaHandler.ArenaBattleScore> top3 = new ArrayList<>();
        for (ArenaBattleVO bf : listRank) {
            top3.add(bf.toBuilder(false));
        }

        return top3;
    }


    private List<ArenaHandler.ArenaBattleScore> getAllScores() {
        List<ArenaBattleVO> listRank = new ArrayList<>(this.rank.values());
        Collections.sort(listRank, new Comparator<ArenaBattleVO>() {
            public int compare(ArenaBattleVO left, ArenaBattleVO right) {
                int i = right.getScore() - left.getScore();
                if (i == 0) {
                    i = (int) (left.getUpdateTime() - right.getUpdateTime());
                }
                return i;
            }
        });


        List<ArenaHandler.ArenaBattleScore> top3 = new ArrayList<>();
        for (ArenaBattleVO bf : listRank) {
            top3.add(bf.toBuilder(true));
        }

        return top3;
    }


    private void pushArenaBattleInfo(WNPlayer targetPlayer) {
        List<ArenaHandler.ArenaBattleScore> killRank = getAllKillCount();
        List<ArenaHandler.ArenaBattleScore> scoreRank = getAllScores();
        int i = 1;
        for (ArenaHandler.ArenaBattleScore ab : scoreRank) {
            WNPlayer player = null;
            if (targetPlayer != null && targetPlayer.getId().equals(ab.getId())) {
                player = targetPlayer;
            } else {
                player = getPlayer(ab.getId());
            }

            if (player != null) {
                ArenaHandler.OnArenaBattleInfoPush.Builder builder = ArenaHandler.OnArenaBattleInfoPush.newBuilder();
                builder.setS2CCode(200);
                builder.setS2CKillCount(player.arenaManager.getCombo());
                builder.setS2CIndex(i);
                builder.setS2CScore(player.arenaManager.getScore());
                builder.addAllS2CScores(scoreRank);
                builder.setS2CPlayerCount(this.actors.size());
                builder.addAllS2CKillCountList(killRank);

                player.receive("area.arenaPush.onArenaBattleInfoPush", (GeneratedMessage) builder.build());
            } else {
                Out.error(new Object[]{getClass(), "_pushBattleMessage can't find player id:", ab.getId()});
            }
            i++;
        }
        if (!scoreRank.isEmpty()) {
            String newFirst = ((ArenaHandler.ArenaBattleScore) scoreRank.get(0)).getId();

            if (!newFirst.equals(this.firstPlayerId)) {
                String tips = LangService.format("ARENA_TO_FIRST", new Object[]{((ArenaBattleVO) this.rank.get(newFirst)).getName()});
                for (String tempPlayerId : this.actors.keySet()) {
                    WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
                    if (tempPlayer != null) {
                        MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
                    }
                }
                this.firstPlayerId = newFirst;
            }
        } else {
            this.firstPlayerId = null;
        }
    }


    public void setForce(WNPlayer player) {
        ArenaBattleVO obj = this.rank.get(player.getId());
        if (obj == null) {
            player.setForce(this.rank.size() + 2);
        } else {
            player.setForce(obj.getForce());
        }
    }

    public void onPlayerEntered(WNPlayer player) {
        ArenaBattleVO obj = this.rank.get(player.getId());
        if (obj == null) {
            obj = new ArenaBattleVO();
            obj.setId(player.getId());
            obj.setName(player.getName());
            obj.setPro(player.getPro());
            obj.setForce(player.getForce());
            this.rank.put(obj.getId(), obj);
        }

        player.getXmdsManager().refreshPlayerPKMode(player.getId(), Const.PkModel.All.value);
        player.achievementManager.onArenaScore(0);
        if (this.firstPlayerId == null) {
            this.firstPlayerId = player.getId();
        }
        player.arenaManager.setArenaInstanceId(this.instanceId);

        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.FIVE_MOUNTAIN_ANTICIPATE, new Object[0]);
    }


    public void onPlayerDeadByMonster(WNPlayer deadplayer, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
        if (deadplayer == null) {
            return;
        }

        if (this.firstPlayerId.equals(deadplayer.getId()) && deadplayer.arenaManager.getScore() > 0) {
            String tips = LangService.format("ARENA_FIRST_KILLED", new Object[]{deadplayer.getName()});
            for (String tempPlayerId : this.actors.keySet()) {
                WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
                if (tempPlayer != null) {
                    MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
                }
            }
        }

        int score = deadplayer.arenaManager.getScore();
        score = (int) Math.ceil(score * 60.0D / 100.0D);
        deadplayer.arenaManager.dropPlayerScore(null, playerX, playerY, score);
        refreshPlayerRank(deadplayer);

        int overTime = GlobalConfig.JJC_RebirthTime;
        if (deadplayer != null) {

            PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadplayer, false);
            data.setCountDown(overTime);

            WNNotifyManager.getInstance().pushRelive(deadplayer, data.build());
        }

        Area.Actor playerData = (Area.Actor) this.actors.get(deadplayer.getId());
        if (playerData == null) {
            Out.error(new Object[]{getClass(), "onPlayerDeadByPlayer not exist! :", deadplayer.getId()});

            return;
        }
        pushArenaBattleInfo((WNPlayer) null);
    }


    public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {
        if (deadplayer == null || hitPlayer == null) {
            return;
        }


        if (this.firstPlayerId.equals(deadplayer.getId()) && deadplayer.arenaManager.getScore() > 0) {
            String tips = LangService.format("ARENA_FIRST_KILLED", new Object[]{deadplayer.getName()});
            for (String tempPlayerId : this.actors.keySet()) {
                WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempPlayerId);
                if (tempPlayer != null) {
                    MessageUtil.sendSysTip(tempPlayer, tips, Const.TipsType.ROLL);
                }
            }
        }

        int score = deadplayer.arenaManager.getScore();
        score = (int) Math.ceil(score * 60.0D / 100.0D);
        deadplayer.arenaManager.dropPlayerScore(hitPlayer, x, y, score);

        Area.Actor deadActor = (Area.Actor) this.actors.get(deadplayer.getId());
        hitPlayer.arenaManager.killPlayer(deadplayer, deadActor, this.rank.size());

        refreshPlayerRank(deadplayer);
        refreshPlayerRank(hitPlayer);

        int overTime = GlobalConfig.JJC_RebirthTime;
        if (deadplayer != null) {

            PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadplayer, false);
            data.setCountDown(overTime);

            WNNotifyManager.getInstance().pushRelive(deadplayer, data.build());
        }

        Area.Actor playerData = (Area.Actor) this.actors.get(deadplayer.getId());
        if (playerData == null) {
            Out.error(new Object[]{getClass(), "onPlayerDeadByPlayer not exist! :", deadplayer.getId()});

            return;
        }
        pushArenaBattleInfo((WNPlayer) null);
    }


    public boolean onCleanItem(Area.AreaItem areaItem) {
        return false;
    }


    public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        WNPlayer player = getPlayer(playerId);
        if (player == null) {
            return null;
        }
        Out.debug(new Object[]{getClass(), player.getName(), " fightLevel onPickItem itemId:", itemId, ",isGuard:", Boolean.valueOf(isGuard)});
        Area.AreaItem itemInfo = (Area.AreaItem) this.items.get(itemId);
        if (itemInfo != null) {
            int groupCount = itemInfo.item.itemDb.groupCount;
            player.arenaManager.addScore(groupCount);
            refreshPlayerRank(player);
            this.items.remove(itemId);
        }
        pushArenaBattleInfo((WNPlayer) null);
        return itemInfo;
    }


    public boolean isFull() {
        if (super.isFull()) {
            return true;
        }
        return (this.rank.size() >= this.fullCount);
    }


    public boolean isFull(int addCount) {
        if (super.isFull(addCount)) {
            return true;
        }
        return (this.rank.size() + addCount > this.fullCount);
    }


    private void pushArenaBattleEnd(WNPlayer player) {
        if (player == null)
            return;
        ArenaHandler.OnArenaBattleEndPush.Builder res = ArenaHandler.OnArenaBattleEndPush.newBuilder();
        res.setS2CCode(200);
        res.setOuttime(((GameMapCO) GameData.GameMaps.get(Integer.valueOf(70002))).timeCount);
        player.receive("area.arenaPush.onArenaBattleEndPush", (GeneratedMessage) res.build());
    }


    public void onGameOver(JSONObject msg) {
        List<ArenaHandler.ArenaBattleScore> listRank = getAllScores();

        for (int i = 0; i < listRank.size(); i++) {
            ArenaHandler.ArenaBattleScore info = listRank.get(i);
            WNPlayer player = getPlayer(info.getId());
            if (player != null) {
                player.arenaManager.onAreaClose(i + 1);
                if (player.getInstanceId().equals(this.instanceId)) {
                    pushArenaBattleEnd(player);

                    getXmdsManager().revivePlayer(player.getId(), reliveData(Area.ReliveType.PLACE));
                }

                player.getXmdsManager().refreshPlayerPKMode(player.getId(), player.pkRuleManager.pkData.pkModel);
            } else {
                Out.error(new Object[]{"can't find player error in arenaArea!!!"});
            }


            player.achievementManager.onArenaBattle();
        }
        Out.debug(new Object[]{"ArenaArea onGameOver-----"});
    }

    public Area.ReliveType getReliveType() {
        return Area.ReliveType.RANDOM;
    }

    public void onEndEnterScene(WNPlayer player) {
        super.onEndEnterScene(player);
        pushArenaBattleInfo(player);
    }


    public void onPlayerLogout(WNPlayer player) {
        boolean keepObject = isKeepObject();
        if (keepObject && !isClose()) {

            player.getXmdsManager().playerReady(player.getId());

            onPlayerAutoBattle(player, true);
        }

        Area.Actor actor = getActor(player.getId());
        if (actor != null && !actor.alive && !PlayerUtil.isOnline(player.getId())) {
            JobFactory.addDelayJob(() -> {
                if (!actor.alive) relive(player.getId(), getReliveType());
            } (GlobalConfig.JJC_RebirthTime * 1000));
        }
    }


    public void onPlayerLeaved(WNPlayer player) {
        refreshPlayerRank(player);
        pushArenaBattleInfo(player);
    }
}


