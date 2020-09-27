package com.wanniu.game.five2Five;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import pomelo.area.PlayerHandler;


public class Five2FiveArea
        extends Area {
    private CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsA;
    private CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMemsB;

    public Five2FiveArea(JSONObject opts) {
        super(opts);
        this.tempTeamMemsA = (CopyOnWriteArrayList<Five2FiveTempTeamMember>) opts.get("tempTeamMemsA");
        this.tempTeamMemsB = (CopyOnWriteArrayList<Five2FiveTempTeamMember>) opts.get("tempTeamMemsB");
    }


    public void setForce(WNPlayer player) {
        for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsA) {
            if (player.getId().equals(tempTeamMem.playerId)) {
                player.setForce(tempTeamMem.force);
                return;
            }
        }
        for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsB) {
            if (player.getId().equals(tempTeamMem.playerId)) {
                player.setForce(tempTeamMem.force);
                return;
            }
        }
    }


    public void addPlayer(WNPlayer player) {
        setForce(player);
        player.setArea(this);
        String enterSceneData = toJSON4EnterScene(player);
        JSONObject jsonObject = JSONObject.parseObject(enterSceneData);

        Map<String, Number> effects = (Map<String, Number>) jsonObject.get("effects");
        int index = 1;
        boolean isFinded = false;
        for (Five2FiveTempTeamMember member : this.tempTeamMemsA) {
            if (member.playerId.equals(player.getId())) {
                index = member.index;
                isFinded = true;
                break;
            }
        }
        if (!isFinded) {
            for (Five2FiveTempTeamMember member : this.tempTeamMemsB) {
                if (member.playerId.equals(player.getId())) {
                    index = member.index;
                }
            }
        }
        effects.put("index", Integer.valueOf(index));
        jsonObject.put("indexOut", Integer.valueOf(index));
        enterSceneData = JSONObject.toJSONString(jsonObject);
        Out.debug(new Object[]{"begin enter scene id:", this.instanceId});
        try {
            String playerId = player.getId();

            if (!this.actors.containsKey(playerId)) {
                this.hasPlayerEntered = true;
                this.actors.put(playerId, new Area.Actor());
            }
            removeCloseFuture();
            Out.debug(new Object[]{"enter scene id: ", this.instanceId, " ok", "index:", Integer.valueOf(this.lineIndex)});
        } catch (Exception error) {
            Out.error(new Object[]{"c# enter scene id: ", this.instanceId, " error : ", error, " enterSceneData:", enterSceneData});
            throw error;
        }
    }


    public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
        int overTime = GlobalConfig.Group_Resurrection;
        if (deadPlayer != null) {

            PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(deadPlayer, false);


            data.setCountDown(overTime);
            data.setCbType(Area.ReliveCB.RELIVE.value);

            WNNotifyManager.getInstance().pushRelive(deadPlayer, data.build());
        }

        Area.Actor playerData = (Area.Actor) this.actors.get(deadPlayer.getId());
        if (playerData == null) {
            Out.error(new Object[]{getClass(), "onPlayerDeadByPlayer not exist! :", deadPlayer.getId()});
            return;
        }
    }


    public void onGameOver(JSONObject event) {
        Out.debug(new Object[]{"5v5 gameover"});
        int winForce = event.getIntValue("winForce");
        List<Five2FiveTempTeamMember> tempTeamMems = new ArrayList<>();
        tempTeamMems.addAll(this.tempTeamMemsA);
        tempTeamMems.addAll(this.tempTeamMemsB);

        String statistice = getXmdsManager().getInstanceStatistic(this.instanceId);
        JSONObject statisticeJson = JSON.parseObject(statistice);
        Map<String, int[]> everyStatistieces = (Map) new HashMap<>();
        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
            String tempTeamMemPlayerId = tempTeamMem.playerId;
            Map<String, Integer> everyStatice = (Map<String, Integer>) statisticeJson.get(tempTeamMemPlayerId);
            int[] everyStatistiece = new int[4];
            if (everyStatice != null) {
                everyStatistiece[0] = ((Integer) everyStatice.get("killPlayerCount")).intValue();
                everyStatistiece[1] = ((Integer) everyStatice.get("totalDamage")).intValue();
                everyStatistiece[2] = ((Integer) everyStatice.get("totalHealing")).intValue();
                Integer deadCount = everyStatice.get("deadCount");
                everyStatistiece[3] = (deadCount == null) ? 0 : deadCount.intValue();
            }
            everyStatistieces.put(tempTeamMemPlayerId, everyStatistiece);
        }

        int maxMvpValue = 0;
        String mvpPlayerId = "";
        Map<String, Integer> killCounts = new HashMap<>();
        Map<String, Integer> hurts = new HashMap<>();
        Map<String, Integer> treatMents = new HashMap<>();
        Map<String, Integer> deadCounts = new HashMap<>();
        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
            String tempTeamPlayerId = tempTeamMem.playerId;
            int[] everyStatistiece = everyStatistieces.get(tempTeamPlayerId);
            int killCount = everyStatistiece[0];
            int hurt = everyStatistiece[1];
            int treatMent = everyStatistiece[2];
            int deadCount = everyStatistiece[3];

            if (tempTeamMem.force == winForce) {
                int mvpValue = killCount * GlobalConfig.Group_Kill + hurt * GlobalConfig.Group_Dps + treatMent * GlobalConfig.Group_Treatment;
                if (mvpValue > maxMvpValue) {
                    maxMvpValue = mvpValue;
                    mvpPlayerId = tempTeamPlayerId;
                }
            }
            killCounts.put(tempTeamPlayerId, Integer.valueOf(killCount));
            hurts.put(tempTeamPlayerId, Integer.valueOf(hurt));
            treatMents.put(tempTeamPlayerId, Integer.valueOf(treatMent));
            deadCounts.put(tempTeamPlayerId, Integer.valueOf(deadCount));
        }

        Map<String, Five2FivePlayerResultInfoVo> playerResultInfosA = new HashMap<>();
        for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsA) {
            String tempTeamPlayerId = tempTeamMem.playerId;
            int killCount = ((Integer) killCounts.get(tempTeamPlayerId)).intValue();
            int hurt = ((Integer) hurts.get(tempTeamPlayerId)).intValue();
            int treatMent = ((Integer) treatMents.get(tempTeamPlayerId)).intValue();
            boolean isMvp = false;
            if (mvpPlayerId.equals(tempTeamPlayerId)) {
                isMvp = true;
            }
            processPlayerResultInfo(tempTeamPlayerId, killCount, hurt, treatMent, isMvp, ((Integer) deadCounts.get(tempTeamPlayerId)).intValue(), playerResultInfosA);
        }

        Map<String, Five2FivePlayerResultInfoVo> playerResultInfosB = new HashMap<>();
        for (Five2FiveTempTeamMember tempTeamMem : this.tempTeamMemsB) {
            String tempTeamPlayerId = tempTeamMem.playerId;
            int killCount = ((Integer) killCounts.get(tempTeamPlayerId)).intValue();
            int hurt = ((Integer) hurts.get(tempTeamPlayerId)).intValue();
            int treatMent = ((Integer) treatMents.get(tempTeamPlayerId)).intValue();
            boolean isMvp = false;
            if (mvpPlayerId.equals(tempTeamPlayerId)) {
                isMvp = true;
            }
            processPlayerResultInfo(tempTeamPlayerId, killCount, hurt, treatMent, isMvp, ((Integer) deadCounts.get(tempTeamPlayerId)).intValue(), playerResultInfosB);
            if (playerResultInfosA.containsKey(tempTeamPlayerId)) {
                Out.warn(new Object[]{"5v5 Area:" + this.instanceId + " player [" + tempTeamPlayerId + "] duplicate"});
            }
        }

        String resultInstanceId = UUID.randomUUID().toString();
        onBothSidesGameOver(everyStatistieces, resultInstanceId, mvpPlayerId, winForce, this.tempTeamMemsA, playerResultInfosA, playerResultInfosB);
        onBothSidesGameOver(everyStatistieces, resultInstanceId, mvpPlayerId, winForce, this.tempTeamMemsB, playerResultInfosA, playerResultInfosB);
    }


    protected void onDisponseLeave(WNPlayer player) {
        player.five2FiveManager.leaveFive2FiveArea();
    }


    private void onBothSidesGameOver(Map<String, int[]> everyStatistieces, String resultInstanceId, String mvpPlayerId, int winForce, CopyOnWriteArrayList<Five2FiveTempTeamMember> tempTeamMems, Map<String, Five2FivePlayerResultInfoVo> resultInfosA, Map<String, Five2FivePlayerResultInfoVo> resultInfosB) {
        for (Five2FiveTempTeamMember tempTeamMem : tempTeamMems) {
            String tempTeamPlayerId = tempTeamMem.playerId;
            WNPlayer tempTeamPlayer = getPlayer(tempTeamPlayerId);
            if (tempTeamPlayer == null) {
                tempTeamPlayer = (WNPlayer) GWorld.getInstance().getWaitPlayers().get(tempTeamPlayerId);
            }
            int[] everyStatistiece = everyStatistieces.get(tempTeamPlayerId);
            int killCount = 0;
            int hurt = 0;
            int treatMent = 0;
            if (everyStatistiece != null) {
                killCount = everyStatistiece[0];
                hurt = everyStatistiece[1];
                treatMent = everyStatistiece[2];
            }
            int result = 0;
            int scoreChange = 0;
            if (winForce == 0) {
                result = Five2FiveService.Five2FiveResult.TIE.ordinal();
                scoreChange = 0;
            } else if (tempTeamMem.force == winForce) {
                result = Five2FiveService.Five2FiveResult.WIN.ordinal();
                scoreChange = GlobalConfig.Group_Integral;
            } else {
                result = Five2FiveService.Five2FiveResult.FAIL.ordinal();
                scoreChange = -GlobalConfig.Group_Lose;
            }
            boolean isMvp = false;
            if (tempTeamPlayerId.equals(mvpPlayerId)) {
                isMvp = true;
            }
            tempTeamPlayer.five2FiveManager.onGameEnd(resultInstanceId, result, killCount, hurt, treatMent, scoreChange, isMvp, resultInfosA, resultInfosB);
        }
    }


    private void processPlayerResultInfo(String tempTeamPlayerId, int killCount, int hurt, int treatMent, boolean isMvp, int deadCount, Map<String, Five2FivePlayerResultInfoVo> resultInfos) {
        Five2FivePlayerResultInfoVo resultInfoVo = new Five2FivePlayerResultInfoVo();
        WNPlayer tempPlayer = PlayerUtil.getOnlinePlayer(tempTeamPlayerId);
        if (tempPlayer == null) {
            tempPlayer = (WNPlayer) GWorld.getInstance().getWaitPlayers().get(tempTeamPlayerId);
        }
        resultInfoVo = new Five2FivePlayerResultInfoVo(tempPlayer.getId(), tempPlayer.getName(), tempPlayer.getLevel(), tempPlayer.getPro(), killCount, hurt, treatMent, isMvp ? 1 : 0, deadCount);
        resultInfos.put(tempTeamPlayerId, resultInfoVo);

        tempPlayer.achievementManager.onPassFiveVsFive();
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
            } (GlobalConfig.Group_Resurrection * 1000));
        }
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.TRIAL_ANTICIPATE, new Object[0]);
    }
}


