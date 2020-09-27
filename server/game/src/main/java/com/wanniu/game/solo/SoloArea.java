package com.wanniu.game.solo;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.area.MonsterUnit;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.SoloMonsterCO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class SoloArea
        extends Area {
    public static int clearSeconds = 400;

    private boolean isGameOver = false;

    public SoloArea(JSONObject opts) {
        super(opts);

        JobFactory.addDelayJob(() -> {
            Out.info(new Object[]{"问道玩法清场.", this.instanceId}, ); AreaManager.getInstance().closeArea(this.instanceId);
        }clearSeconds, TimeUnit.SECONDS);
    }


    public void addRobot(SoloMonsterCO soloProp) {
        String startPoint = String.valueOf(soloProp.startPoint);

        MonsterUnit monsterData = new MonsterUnit();
        monsterData.id = soloProp.monID;
        monsterData.force = Const.AreaForce.FORCEB.value;
        monsterData.flag = startPoint;
        monsterData.autoGuard = true;
        List<MonsterUnit> monsters = new ArrayList<>();
        monsters.add(monsterData);
        addUnitsToArea(monsters);
    }

    public String toJSON4EnterScene(WNPlayer player) {
        JSONObject json = player.toJSON4EnterScene(this);

        Map<String, Number> tempData = (Map<String, Number>) json.get("tempData");
        tempData.put("x", Integer.valueOf(0));
        tempData.put("y", Integer.valueOf(0));
        return json.toJSONString();
    }


    public void setForce(WNPlayer player) {
    }


    private static class SoloResult {
        public String playerId;

        public int result;


        public SoloResult(String playerId, int result) {
            this.playerId = playerId;
            this.result = result;
        }
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.SOLO_ANTICIPATE, new Object[0]);
    }


    public void onGameOver(JSONObject msg) {
        if (this.isGameOver) {
            return;
        }
        Out.info(new Object[]{"soloArea gameover,instanceId=", this.instanceId});
        int winForce = msg.getIntValue("winForce");
        List<SoloResult> playerDatas = new ArrayList<>();

        int winScore = 0, failScore = 0;
        for (String playerId : this.actors.keySet()) {
            WNPlayer player = getPlayer(playerId);
            if (winForce == 0) {
                playerDatas.add(new SoloResult(playerId, 3));
                continue;
            }
            if (player.getForce() == winForce) {
                playerDatas.add(new SoloResult(playerId, 1));
                winScore = player.soloManager.getScore();
                continue;
            }
            playerDatas.add(new SoloResult(playerId, 2));
            failScore = player.soloManager.getScore();
        }


        int addScore = 0;
        int subScore = 0;
        if (winForce != 0) {
            addScore = calcWinnerScore(winScore, failScore);
            subScore = calcLoserScore(winScore, failScore);
        }

        for (String playerId : this.actors.keySet()) {
            WNPlayer player = getPlayer(playerId);
            if (player != null) {

                if (playerDatas.size() == 2) {
                    if (playerId == ((SoloResult) playerDatas.get(0)).playerId) {
                        player.soloManager.onGameEnd(((SoloResult) playerDatas.get(0)).result, getPlayer(((SoloResult) playerDatas.get(1)).playerId), addScore, subScore);
                        continue;
                    }
                    player.soloManager.onGameEnd(((SoloResult) playerDatas.get(1)).result, getPlayer(((SoloResult) playerDatas.get(0)).playerId), addScore, subScore);
                    continue;
                }
                player.soloManager.onGameEnd(((SoloResult) playerDatas.get(0)).result, null, addScore, subScore);
            }
        }


        this.isGameOver = true;
    }


    private int calcScoreVariable(int winnerScore, int loserScore) {
        int base = GlobalConfig.Solo_WinGetPoint;
        int diff = winnerScore - loserScore;
        int floatValue = diff / 20;

        floatValue = Math.min(Math.max(-base, floatValue), base);
        return base - floatValue;
    }


    private int calcWinnerScore(int winnerScore, int loserScore) {
        return calcScoreVariable(winnerScore, loserScore) + 1;
    }


    private static int TOP_RANKSCORE = 1000;


    private int calcLoserScore(int winnerScore, int loserScore) {
        if (loserScore < TOP_RANKSCORE) {
            return 1;
        }
        return -calcScoreVariable(winnerScore, loserScore);
    }


    protected void onDisponseLeave(WNPlayer player) {
        player.soloManager.handleLeaveSoloArea();
    }


    public void onPlayerDeadByPlayer(WNPlayer deadplayer, WNPlayer hitPlayer, float x, float y) {
    }


    public void onPlayerLogout(WNPlayer player) {
        boolean keepObject = isKeepObject();
        if (keepObject && !isClose()) {

            player.getXmdsManager().playerReady(player.getId());

            onPlayerAutoBattle(player, true);
        }
    }
}


