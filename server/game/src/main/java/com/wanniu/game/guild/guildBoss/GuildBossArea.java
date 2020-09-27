package com.wanniu.game.guild.guildBoss;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.DamageHealVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.data.ext.InspireLevelExt;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.monster.GuildBossRatioConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildBossPo;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.GuildBossHandler;

public class GuildBossArea
        extends Area {
    private GuildPO guildPo;
    private ScheduledFuture<?> future;
    private boolean isKilled = false;
    private boolean stopHurtAdd = false;
    private long killTime;
    private long outTime = 0L;
    private Map<String, Integer> playerEnterCount = new ConcurrentHashMap<>();
    private Set<String> onLines = new HashSet<>();

    public GuildBossArea(JSONObject opts, GuildPO guildPo) {
        super(opts);
        initStatisticsJob();
        if (this.guildPo == null && guildPo != null) {
            this.guildPo = guildPo;
        }
        this.outTime = calEndTime();
    }


    private long calEndTime() {
        return System.currentTimeMillis() + (GuildBossService.getInstance().getEndSeconds() * 1000);
    }

    public void preOverProcess() {
        pushDetailInfo();
        removeBoss();
    }

    public void removeBoss() {
        getXmdsManager().removeUnit(this.instanceId, 552001);
    }


    public void pushDetailInfo() {
        JobFactory.addDelayJob(() -> processPushDetailInfo(), 2000L);
    }


    public void processPushDetailInfo() {
        this.stopHurtAdd = true;
        cancelSchdule();
        Collection<String> roleIds = this.actors.keySet();
        TaskQueue.put(new TaskEvent(Const.EventType.over_statics_ranks, new Object[]{this.guildPo.id, roleIds}));
    }


    public void onGameOver() {
        this.killTime = System.currentTimeMillis() + 5000L;
        statistics(this.killTime, false);
    }


    public void onBattleReport(List<DamageHealVO> datas) {
        if (datas != null && !datas.isEmpty()) {
            for (DamageHealVO heal : datas) {
                if (heal.TotalDamage <= 0) {
                    continue;
                }
                setNewData(heal.PlayerUUID, heal.TotalDamage);
            }
        }
    }


    protected void addCloseFuture(int second) {
        super.addCloseFuture(second);
    }


    public void dispose() {
        super.dispose();
        cancelSchdule();
    }


    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);
        if (monsterId == 552001) {
            onBossDead();
        }
    }


    public int receiveSinlgInspire(WNPlayer player, GuildBossPo guildBossPO, boolean isAttributeChanged) {
        int totalAdd = getInpireAdd(1, guildBossPO.inspire.count);
        GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(guildBossPO.inspire.count, totalAdd / 100, 1);
        player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage) msg.build());
        if (totalAdd > 0 && isAttributeChanged) {
            player.btlDataManager.onGuildBossInpire();
            player.refreshBattlerServerEffect(false);
        }
        return totalAdd;
    }

    public int getInpireAdd(int index, int count) {
        InspireLevelExt co = GuildBossRatioConfig.getInspireLevelCO(index, count);
        return (co != null) ? co.totalInspirePlus : 0;
    }


    public int receiveGuildInspire(int index, int count) {
        int totalAdd = getInpireAdd(index, count);
        GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(count, totalAdd / 100, index);
        Collection<String> roleIds = this.actors.keySet();
        for (String playerId : roleIds) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage) msg.build());
            if (totalAdd > 0) {
                player.btlDataManager.onGuildBossInpire();
                player.refreshBattlerServerEffect(false);
            }
        }
        return totalAdd;
    }


    public int receiveGuildInspireAtk(WNPlayer player) {
        int totalAdd = getInpireAdd(2, this.guildPo.inspire.count);
        GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(this.guildPo.inspire.count, totalAdd / 100, 2);
        player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage) msg.build());
        return totalAdd;
    }


    public int receiveGuildInspireDef(WNPlayer player) {
        int totalAdd = getInpireAdd(3, this.guildPo.defInspire.count);
        GuildBossHandler.OnInspireChangePush.Builder msg = getOnInspireChangePush(this.guildPo.defInspire.count, totalAdd / 100, 3);
        player.receive("area.guildBossPush.onInspireChangePush", (GeneratedMessage) msg.build());
        return totalAdd;
    }


    public int getTotalAtkAdd(WNPlayer player) {
        int totalAdd = 0;
        GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
        totalAdd += getInpireAdd(1, guildBossPO.inspire.count);
        if (this.guildPo != null && this.guildPo.inspire != null) {
            totalAdd += getInpireAdd(2, this.guildPo.inspire.count);
        }
        return totalAdd;
    }


    public int getTotalDefAdd(WNPlayer player) {
        int totalAdd = 0;
        if (this.guildPo != null && this.guildPo.defInspire != null) {
            totalAdd += getInpireAdd(3, this.guildPo.defInspire.count);
        }
        return totalAdd;
    }

    public void receiveInspireAfterEnter(WNPlayer player) {
        GuildBossPo singleSprie = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
        int add = 0;
        add += receiveSinlgInspire(player, singleSprie, false);
        GuildPO guildPO = player.guildManager.guild;
        player.guildBossManager.getAndCheckGuildBossAtkPoForGuild(guildPO);
        player.guildBossManager.getAndCheckGuildBossDefPoForGuild(guildPO);
        add += receiveGuildInspireAtk(player);
        add += receiveGuildInspireDef(player);
        if (add > 0) {
            player.btlDataManager.onGuildBossInpire();
            player.refreshBattlerServerEffect(false);
        }
    }

    public void onPlayerLeave(WNPlayer player) {
        int totalAdd = 0;
        GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
        totalAdd += getInpireAdd(1, guildBossPO.inspire.count);
        if (this.guildPo != null && this.guildPo.inspire != null) {
            totalAdd += getInpireAdd(2, this.guildPo.inspire.count);
        }
        if (totalAdd > 0) {
            player.btlDataManager.onGuildBossInpire();
            player.refreshBattlerServerEffect(false);
        }
    }

    private GuildBossHandler.OnInspireChangePush.Builder getOnInspireChangePush(int personalTimes, int personalValue, int index) {
        GuildBossHandler.OnInspireChangePush.Builder bd = GuildBossHandler.OnInspireChangePush.newBuilder();
        bd.setTotalTimes(personalTimes);
        bd.setTotalValue(personalValue);
        bd.setIndex(index);
        bd.setS2CCode(200);
        return bd;
    }

    public void onBossDead() {
        Out.info(new Object[]{"工会BOSS活动。。怪被杀了,guildId=", this.guildPo.id});
        this.isKilled = true;
        this.killTime = System.currentTimeMillis();
        GuildBossService.getInstance().upgradeGuildBoss();
        statistics(this.killTime, true);
        pushDetailInfo();
        addCloseFuture(GlobalConfig.GuildBoss_LeaveTime - 3);
    }


    private void cancelSchdule() {
        if (this.future != null) {
            this.future.cancel(false);
            this.future = null;
        }
    }

    public boolean isKilled() {
        return this.isKilled;
    }


    private void pushKickTime(WNPlayer player) {
        if (this.outTime == 0L) {
            return;
        }
        long now = System.currentTimeMillis();
        int seconds = 1;
        if (now < this.outTime) {
            seconds = (int) ((this.outTime - now) / 1000L);
        }
        seconds = (seconds <= 0) ? 1 : seconds;
        MessagePush push = new MessagePush("area.guildBossPush.onQuitGuildBossPush", (GeneratedMessage) GuildBossHandler.OnQuitGuildBossPush.newBuilder().setEndSeconds(seconds).build());
        player.receive((Message) push);
    }


    public void playerLeaveRequest(WNPlayer player, boolean keepObject) {
        super.playerLeaveRequest(player, keepObject);
        if (!keepObject) {
            synchronized (this) {
                this.onLines.remove(player.getId());
            }
        }
    }


    public void onPlayerLeaved(WNPlayer player) {
        super.onPlayerLeaved(player);
        onPlayerLeave(player);
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        synchronized (this) {
            if (this.onLines.add(player.getId())) {
                Integer count = this.playerEnterCount.get(player.player.id);
                if (count == null) {
                    this.playerEnterCount.put(player.player.id, Integer.valueOf(1));
                } else {
                    this.playerEnterCount.put(player.player.id, Integer.valueOf(count.intValue() + 1));
                }
            }
        }
        player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.GUILD_BOSS_COUNT, new Object[0]);
    }

    public int getEnterCount(String playerId) {
        Integer count = this.playerEnterCount.get(playerId);
        if (count == null) {
            return 0;
        }
        return count.intValue();
    }


    private void initStatisticsJob() {
        this.future = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildBossArea.this.statistics(0L, false);
            }
        } 1000L, 1000L);
    }


    public void onReady(WNPlayer player) {
        String guildId = GuildService.getGuildId(player.player.id);
        if (guildId != null) {
            List<String> pushRoleIds = new ArrayList<>();
            pushRoleIds.add(player.getId());
            Collection<String> roleIds = this.actors.keySet();
            player.onEvent(new TaskEvent(Const.EventType.hurtRank_sort, new Object[]{guildId, roleIds, Boolean.valueOf(true), Long.valueOf(0L), Boolean.valueOf(false)}));
            receiveInspireAfterEnter(player);
            pushKickTime(player);
        } else {
            Out.warn(new Object[]{"发现有个玩家在工会BOSS场景没有工会ID,playerId=", player.player.id});
        }
    }


    private void statistics(long bossKillTime, boolean hasKilled) {
        if (this.guildPo == null) {
            Out.warn(new Object[]{"发现有个玩家在工会BOSS场景没有工会ID,instanceId=", this.instanceId});
            return;
        }
        Collection<String> roleIds = this.actors.keySet();
        TaskQueue.put(new TaskEvent(Const.EventType.hurtRank_sort, new Object[]{this.guildPo.id, roleIds, Boolean.valueOf(false), Long.valueOf(bossKillTime), Boolean.valueOf(hasKilled)}));
    }

    public void setNewData(String playerId, long hurt) {
        if (this.guildPo == null) {
            Out.warn(new Object[]{"发现有个玩家在工会BOSS场景没有工会ID,instanceId=", this.instanceId});
            return;
        }
        if (this.stopHurtAdd) {
            return;
        }

        int enterCount = getEnterCount(playerId);
        TaskQueue.put(new TaskEvent(Const.EventType.hurtRank, new Object[]{this.guildPo.id, playerId, Long.valueOf(hurt), Integer.valueOf(enterCount)}));
    }
}


