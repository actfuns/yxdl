package com.wanniu.game.flee;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GameMapCO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.FleeHandler;


public class FleeArea
        extends Area {
    private ConcurrentHashMap<String, FleePlayer> playerMap = new ConcurrentHashMap<>();

    public FleeArea(JSONObject opts) {
        super(opts);
    }


    public void setForce(WNPlayer player) {
        FleePlayer fleePlayer = this.playerMap.get(player.getId());
        if (fleePlayer != null) {
            player.setForce(fleePlayer.force);
        } else {
            player.setForce(this.playerMap.size() + 1);
        }
    }


    public void onPlayerEntered(WNPlayer player) {
        FleePlayer fleePlayer = this.playerMap.get(player.getId());
        if (fleePlayer == null) {
            fleePlayer = new FleePlayer(player.getId(), player.getName(), player.getLevel(), player.getPro(), player.getForce(), this.playerMap.size() + 1);
            this.playerMap.put(fleePlayer.playerId, fleePlayer);
        }
        player.getXmdsManager().refreshPlayerPKMode(player.getId(), Const.PkModel.All.value);
    }


    public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {
        if (deadplayer == null || hitPlayer == null) {
            return;
        }
        ((FleePlayer) this.playerMap.get(hitPlayer.getId())).killCount++;
        FleePlayer deathPlayer = this.playerMap.get(deadplayer.getId());
        deathPlayer.rank = getAliveNum() + 1;
        deathPlayer.isDeath = true;

        int scoreChange = deadplayer.fleeManager.onGameOver(deathPlayer.rank);

        pushFleeDeath(deadplayer, deathPlayer.rank, scoreChange);
    }


    private int getAliveNum() {
        int num = 0;
        for (Area.Actor a : this.actors.values()) {
            if (a.alive) {
                num++;
            }
        }
        return num;
    }


    private void pushFleeDeath(WNPlayer player, int rank, int scoreChange) {
        FleeHandler.OnFleeDeathPush.Builder res = FleeHandler.OnFleeDeathPush.newBuilder();
        res.setS2CCode(200);
        res.setOuttime(((GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Flee_MapID))).timeCount);
        res.setRank(rank);
        res.setScoreChange(scoreChange);
        player.receive("area.fleePush.onFleeDeathPush", (GeneratedMessage) res.build());
    }


    public void onGameOver(JSONObject msg) {
        FleeHandler.OnFleeEndPush.Builder push = FleeHandler.OnFleeEndPush.newBuilder();
        push.setS2CCode(200);
        push.setOuttime(((GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Flee_MapID))).timeCount);
        List<FleePlayer> list = new ArrayList<>(this.playerMap.values());
        List<FleePlayer> notDeathList = new ArrayList<>();
        for (FleePlayer p : list) {
            if (!p.isDeath) {
                notDeathList.add(p);
            }
        }
        list.removeAll(notDeathList);
        Collections.sort(notDeathList, (o1, o2) -> o1.force - o2.force);


        for (int i = 0; i < notDeathList.size(); i++) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(((FleePlayer) notDeathList.get(i)).playerId);
            player.fleeManager.onGameOver(i + 1);
        }

        notDeathList.addAll(list);

        for (FleePlayer p : notDeathList) {
            FleeHandler.FleeMatchMemberInfo.Builder mem = FleeHandler.FleeMatchMemberInfo.newBuilder();
            mem.setPlayerId(p.playerId);
            mem.setPlayerName(p.playerName);
            mem.setPlayerLvl(p.playerLevel);
            mem.setPlayerPro(p.playerPro);
            mem.setKillCount(p.killCount);
            mem.setScoreChange(p.scoreChange);
            push.addRanks(mem);
        }
        for (String id : this.actors.keySet()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(id);
            player.receive("area.fleePush.onFleeEndPush", (GeneratedMessage) push.build());
        }
    }

    public Area.ReliveType getReliveType() {
        return Area.ReliveType.RANDOM;
    }


    public void onPlayerLogout(WNPlayer player) {
        boolean keepObject = isKeepObject();
        if (keepObject && !isClose()) {

            player.getXmdsManager().playerReady(player.getId());

            onPlayerAutoBattle(player, true);
        }
    }
}


