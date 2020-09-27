package com.wanniu.game.guild;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.HackerException;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.BlessItemCO;
import com.wanniu.game.data.BlessLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildContributeCO;
import com.wanniu.game.data.GuildLevelCO;
import com.wanniu.game.data.GuildPositionCO;
import com.wanniu.game.data.WareHouseValueCO;
import com.wanniu.game.data.ext.BlessLevelExt;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.dao.FindPlayerGuildDao;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.guidDepot.GuildCond;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.guild.guildBless.GuildBless;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
import com.wanniu.game.guild.guildShop.GuildShopManager;
import com.wanniu.game.guild.guildTech.GuildTechManager;
import com.wanniu.game.guild.po.GuildBlessPO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.player.po.MiscData;
import com.wanniu.game.poes.GuildApplyPO;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerGuildPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.util.BlackWordUtil;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;
import io.netty.util.internal.StringUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import pomelo.area.GuildBlessHandler;
import pomelo.area.GuildDepotHandler;
import pomelo.area.GuildHandler;
import pomelo.area.GuildShopHandler;
import pomelo.area.GuildTechHandler;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


public class GuildManager {
    public GuildPO guild;
    public GuildMemberPO member;
    public PlayerGuildPO guildData;
    public GuildShopManager guildShopManager;
    public GuildTechManager guildTechManager;
    public int throwAwardState;
    private WNPlayer player;
    public ScheduledFuture<?> timer = null;

    public GuildManager(WNPlayer player, PlayerGuildPO guildData) {
        this.player = player;
        if (null == guildData) {
            this.guildData = new PlayerGuildPO();
            this.guildData.refreshTime = new Date();
            PlayerPOManager.put(ConstsTR.playerGuildTR, player.getId(), (GEntity) this.guildData);
        } else {
            this.guildData = guildData;
        }

        init();
    }

    public void cancelTimer() {
        if (null != this.timer) {
            this.timer.cancel(true);
            this.timer = null;
        }
    }

    public void clearBuffTime() {
        this.guildData.buffTime = 0;
        clearBlessBuff();
        changeBlessBuff();
        cancelTimer();
    }

    public void startTimer() {
        cancelTimer();
        if (this.guildData.buffTime > 0) {
            this.timer = JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    GuildManager.this.guildData.buffTime--;
                    if (GuildManager.this.guildData.buffTime <= 0) {
                        GuildManager.this.clearBuffTime();
                    }
                }
            }, 1L, Const.Time.Second.getValue());
        } else {
            clearBuffTime();
        }
    }


    public void updateBuffTime() {
        Date nowTime = new Date();
        Date logoutTime = (this.player.getPlayer()).logoutTime;
        long leaveTime = nowTime.getTime() - logoutTime.getTime();
        this.guildData.buffTime = (int) (this.guildData.buffTime - leaveTime * 0.001D);
    }

    public void init() {
        this.guildShopManager = new GuildShopManager(this.player);
        this.guildTechManager = new GuildTechManager(this.player);
        syncGuildInfo(false);
    }

    public void updateGuildTimer() {
        startTimer();
        updateBuffTime();
    }

    public void syncGuildInfo(boolean isNotifyBattleServer) {
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (myInfo != null) {
            GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
            if (null != myGuild) {
                this.member = myInfo;
                this.guild = myGuild;
                if (isNotifyBattleServer) {
                    this.player.refreshBattlerServerBasic();
                }
                return;
            }
        }
    }


    public void onLogin() {
        updateGuildTimer();
        playerOnlineRefreshGuildData();
        refreshGuildInfo(false);
        if (StringUtil.isNullOrEmpty(getGuildId())) {
            this.player.pkRuleManager.onExitGuild();
        } else {

            this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
        }

        pushRedPoint();
    }


    public void bagAddItems(List<NormalItem> items) {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
            return;
        }

        boolean _isNeedPush = true;
        for (int i = 0; i < items.size(); i++) {
            final String _code = ((NormalItem) items.get(i)).itemDb.code;
            List<GuildContributeCO> ls = GameData.findGuildContributes(new Predicate<GuildContributeCO>() {
                public boolean test(GuildContributeCO co) {
                    return (co.costItem == _code);
                }
            });

            if (ls.size() > 0) {
                _isNeedPush = false;

                break;
            }
        }
        if (_isNeedPush) {
            pushRedPoint();
        }
    }

    public void bagDelItem(final String code) {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
            return;
        }

        List<GuildContributeCO> ls = GameData.findGuildContributes(new Predicate<GuildContributeCO>() {
            public boolean test(GuildContributeCO co) {
                return (co.costItem == code);
            }
        });

        if (ls.size() > 0) {
            pushRedPoint();
        }
    }


    public boolean isCanRecBlessGift() {
        boolean canPush = false;
        for (int i = 0; i < this.guildData.blessRecState.length; i++) {
            if (this.guildData.blessRecState[i] == Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue()) {
                canPush = true;
                break;
            }
        }
        return canPush;
    }

    public void pushRedPoint() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
            return;
        }

        boolean isPushRedPoint = false;
        if (checkIsCanContribute() || isCanRecBlessGift() || this.player.guildBossManager.needUpdateRedPoint() || this.player.auctionManager.canGuildPush() || this.player.auctionManager.needUpdateRedPoint() || this.player.guildFortManager.needUpdateRedPoint()) {
            isPushRedPoint = true;
        }

        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILD.getValue());
        if (isPushRedPoint) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }

        list.add(data.build());
        this.player.updateSuperScriptList(list);
    }


    public void onLogout() {
        update();
        cancelTimer();
    }

    public JSONObject toJson4MoneyPayLoad() {
        JSONObject data = new JSONObject();
        data.put("depositCount", Integer.valueOf(this.guildData.depositCount));
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        data.put("depositCountMax", Integer.valueOf(settingProp.warehousePutIn));
        return data;
    }


    public void refreshNewDay() {
        this.guildData.contributeTimesMap.clear();

        this.guildData.depositCount = 0;

        this.guildData.blessCount = 0;

        for (int i = 0; i < this.guildData.blessRecState.length; i++) {
            this.guildData.blessRecState[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
        }

        this.guildData.buffIds.clear();

        this.guildShopManager.refreshNewDay(true);

        this.guildTechManager.refreshNewDay(true);

        this.guildData.refreshTime = new Date();

        pushRedPoint();
    }


    public void clearBlessBuff() {
        this.guildData.buffIds.clear();
        this.guildData.buffTime = 0;
    }


    public void changeBlessBuff() {
        this.player.onGuildBlessChange();
    }

    public Map<String, Integer> calAllInfluence() {
        Map<String, Integer> buffAttrs = new HashMap<>();
        if (isInGuild()) {
            buffAttrs = GuildUtil.getBlessBuffAttrs(this.guildData.buffIds);
        }
        return buffAttrs;
    }

    public void pushAndRefreshGuildEffect() {
        this.player.updatePlayerGuildTechAttrs();
    }


    public void resetGuildInfo(boolean isNotifyBattleServer) {
        this.guild = null;
        this.member = null;
        if (isNotifyBattleServer) {
            clearBlessBuff();
            changeBlessBuff();
            this.player.refreshBattlerServerBasic();
        }
    }

    public String getGuildName() {
        return (this.guild != null) ? this.guild.name : "";
    }

    public void refreshGuildInfo(boolean isNotifyBattleServer) {
        GuildUtil.refreshGuildJobPush(this.player);
        syncGuildInfo(isNotifyBattleServer);
    }

    public GuildPO getGuildInfo() {
        return (this.guild == null) ? new GuildPO() : this.guild;
    }

    public boolean isInGuild() {
        return (this.guild != null);
    }

    public int getContributeTimes(int type) {
        if (this.guildData.contributeTimesMap.containsKey(Integer.valueOf(type))) {
            return ((Integer) this.guildData.contributeTimesMap.get(Integer.valueOf(type))).intValue();
        }
        return 0;
    }

    public int getJob() {
        return (this.member != null) ? this.member.job : 0;
    }

    public String getJobName() {
        String jobName = (String) (getGuildInfo()).officeNames.get(Integer.valueOf(getJob()));
        return (jobName == null) ? "" : jobName;
    }

    public boolean isPresident() {
        return (Const.GuildJob.PRESIDENT.getValue() == getJob());
    }

    public boolean isVicePresident() {
        return (Const.GuildJob.VICE_PRESIDENT.getValue() == getJob());
    }

    public void addContributeTimes(int type, int times) {
        if (this.guildData.contributeTimesMap.containsKey(Integer.valueOf(type))) {
            int count = ((Integer) this.guildData.contributeTimesMap.get(Integer.valueOf(type))).intValue();
            count += times;
            this.guildData.contributeTimesMap.put(Integer.valueOf(type), Integer.valueOf(count));
        } else {
            this.guildData.contributeTimesMap.put(Integer.valueOf(type), Integer.valueOf(times));
        }
    }


    public int getTotalContribution(String guildId) {
        if (this.guildData.totalContributionMap.containsKey(guildId)) {
            return ((Integer) this.guildData.totalContributionMap.get(guildId)).intValue();
        }
        return 0;
    }


    public void addTotalContribution(String guildId, int value) {
        if (this.guildData.totalContributionMap.containsKey(guildId)) {
            int con = ((Integer) this.guildData.totalContributionMap.get(guildId)).intValue();
            con += value;
            this.guildData.totalContributionMap.put(guildId, Integer.valueOf(con));
        } else {
            this.guildData.totalContributionMap.put(guildId, Integer.valueOf(value));
        }
    }


    public void addContribution(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加公会贡献时参数小于0.");
        }
        int before = this.guildData.contribution;

        if (0L + this.guildData.contribution + num > 2147483647L) {
            this.guildData.contribution = Integer.MAX_VALUE;
        } else {
            this.guildData.contribution += num;
        }
        int after = this.guildData.contribution;
        Out.info(new Object[]{"add contribution. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GUILDPOINT, before, 1, num, after, origin.value);
    }


    public int getContribution() {
        return this.guildData.contribution;
    }


    public boolean enoughContribution(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的公会贡献是否足够时参数小于0.");
        }
        return (getContribution() >= num);
    }


    public boolean costContribution(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return true;
        }
        if (!enoughContribution(num)) {
            return false;
        }

        int before = this.guildData.contribution;
        this.guildData.contribution -= num;
        int after = this.guildData.contribution;
        Out.info(new Object[]{"cost contribution. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GUILDPOINT, before, 2, num, after, origin.value);


        return true;
    }

    public GuildResult createGuild(JSONObject params) {
        GuildResult ret = new GuildResult();
        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (null == prop) {
            ret.result = -1;
            return ret;
        }

        boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
        if (isInGuild) {
            ret.result = -2;
            return ret;
        }

        if (this.player.getLevel() < prop.joinLv) {
            ret.result = -3;
            return ret;
        }

        Date now = new Date();
        long lastSelfExitPassedTime = now.getTime() - this.guildData.lastSelfExitTime.getTime();
        if (lastSelfExitPassedTime < prop.selfOutMs) {
            long needMs = prop.selfOutMs - lastSelfExitPassedTime;
            String cdInfo = GuildCommonUtil.leftTimeTips(needMs);
            ret.result = -10;
            ret.cdInfo = cdInfo;
            return ret;
        }

        if ((this.player.getPlayer()).diamond < prop.cost) {
            ret.result = -4;
            return ret;
        }

        if (params.getString("name").length() < 3) {
            ret.result = -6;
            return ret;
        }

        if (params.getString("name").length() > 6) {
            ret.result = -7;
            return ret;
        }

        if (BlackWordUtil.isIncludeSpecialChar(params.getString("name"))) {
            ret.result = -8;
            return ret;
        }

        if (BlackWordUtil.isIncludeBlackString(params.getString("name"))) {
            ret.result = -9;
            return ret;
        }

        ret = GuildService.createGuild(this.player, params);

        if (ret.result == 0) {
            syncGuildInfo(false);
            this.player.moneyManager.costDiamond(prop.cost, Const.GOODS_CHANGE_TYPE.guild_create);
            refreshGuildInfo(true);
            pushAndRefreshGuildEffect();
            this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
        }
        return ret;
    }

    public GuildResult joinGuild(String guildId) {
        GuildResult ret = new GuildResult();
        GuildResult.JoinGuild data = new GuildResult.JoinGuild();
        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (null == prop) {
            ret.result = -1;
            return ret;
        }
        boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
        if (isInGuild) {
            ret.result = -2;
            return ret;
        }

        GuildPO guild = GuildUtil.getGuild(guildId);
        if (null == guild) {
            ret.result = -3;
            return ret;
        }

        if (guild.entryUpLevel > 0) {
            if ((this.player.getPlayer()).upLevel < guild.entryUpLevel) {
                data.needUpLevel = guild.entryUpLevel;
                ret.data = data;
                ret.result = -4;
                return ret;
            }
        } else {
            int needLevel = Math.max(prop.joinLv, guild.entryLevel);
            if (this.player.getLevel() < needLevel) {
                ret.result = -5;
                ret.needLevel = needLevel;
                ret.data = data;
                return ret;
            }
        }

        Date now = new Date();
        long lastSelfExitPassedTime = now.getTime() - this.guildData.lastSelfExitTime.getTime();
        lastSelfExitPassedTime = (lastSelfExitPassedTime > 0L) ? lastSelfExitPassedTime : prop.selfOutMs;
        if (lastSelfExitPassedTime < prop.selfOutMs) {
            long needMs = prop.selfOutMs - lastSelfExitPassedTime;
            String cdInfo = GuildCommonUtil.leftTimeTips(needMs);
            ret.result = -6;
            data.cdInfo = cdInfo;
            ret.data = data;
            return ret;
        }
        if (!GWorld.sids.contains(Integer.valueOf(this.player.getLogicServerId()))) {
            ret.result = -7;
            return ret;
        }

        ret = GuildService.joinGuild(this.player, guildId);

        if (ret.result != 0 ||
                ret.joined) ;


        return ret;
    }

    public GuildResult joinGuildByPlayerId(String playerId) {
        GuildResult ret = new GuildResult();
        boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
        if (isInGuild) {
            ret.result = -2;
            return ret;
        }
        GuildMemberPO memInfo = GuildUtil.getGuildMember(playerId);
        if (null == memInfo || null == memInfo.playerId) {
            ret.result = -20;
            return ret;
        }

        ret = joinGuild(memInfo.guildId);
        return ret;
    }

    public GuildResult invitePlayerJoinGuild(String playerId) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }

        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right11 == 0) {
            ret.result = -2;
            return ret;
        }
        boolean isInGuild = GuildUtil.isInGuild(playerId);
        if (isInGuild) {
            ret.result = -3;
            return ret;
        }
        if (!PlayerUtil.isOnline(playerId)) {
            ret.result = -4;
            return ret;
        }

        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (null != player && !GWorld.sids.contains(Integer.valueOf(player.getLogicServerId()))) {
            ret.result = -7;
            return ret;
        }

        GuildHandler.GuildInvitePush.Builder inviteInfo = GuildHandler.GuildInvitePush.newBuilder();
        inviteInfo.setS2CCode(200);
        inviteInfo.setPlayerId(this.player.getId());
        inviteInfo.setPlayerPro(this.player.getPro());
        inviteInfo.setPlayerName(this.player.getName());
        inviteInfo.setGuildId(myGuild.id);
        inviteInfo.setGuildLevel(myGuild.level);
        inviteInfo.setGuildName(myGuild.name);

        if (null != player) {
            player.guildManager.pushInviteJoinGuild(inviteInfo);
        }

        ret.result = 0;
        return ret;
    }

    public void pushInviteJoinGuild(GuildHandler.GuildInvitePush.Builder inviteInfo) {
        this.player.receive("area.guildPush.guildInvitePush", (GeneratedMessage) inviteInfo.build());
    }

    public GuildResult dealApply(String applyId, int operate) {
        GuildResult ret = new GuildResult();
        if (operate < 2 && null == applyId) {
            ret.result = -20;
            return ret;
        }
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right3 == 0) {
            ret.result = -2;
            return ret;
        }

        ret = GuildService.dealApply(this.player, applyId, operate);

        if (ret.result == 0) ;


        return ret;
    }

    public GuildResult setGuildInfo(GuildSetData params) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -2;
            return ret;
        }

        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        GuildSetData newParams = new GuildSetData();
        if (params.entryLevel > 0) {
            if (params.entryLevel < prop.joinLv) {
                ret.result = -4;
                return ret;
            }
            newParams.entryLevel = params.entryLevel;
        }
        if (params.entryUpLevel > 0 || params.entryUpLevel == 0) {
            newParams.entryUpLevel = params.entryUpLevel;
        }

        if (params.guildMode > 0 && (
                params.guildMode == Const.GuildMode.AUTO_MODE.getValue() || params.guildMode == Const.GuildMode.CHECK_MODE.getValue())) {
            newParams.guildMode = params.guildMode;
        }


        return GuildService.setGuildInfo(this.player, newParams);
    }

    public GuildResult setGuildQQGroup(String qqGroup) {
        GuildResult ret = new GuildResult();
        if (qqGroup.length() > 10) {
            ret.result = -1;
            return ret;
        }
        if (!BlackWordUtil.isNumberString(qqGroup)) {
            ret.result = -2;
            return ret;
        }
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -3;
            return ret;
        }
        return GuildService.setGuildQQGroup(this.player, qqGroup);
    }

    public List<GuildHandler.GuildInfo> getGuildList(String name) {
        List<GuildHandler.GuildInfo> data = new ArrayList<>();

        List<GuildPO> guildList = GuildUtil.getGuildList(this.player.getLogicServerId(), name);
        List<GuildApplyPO> applies = GuildUtil.getPlayerApplyIdList(this.player.getId());

        for (GuildPO guild : guildList) {
            GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
            GuildHandler.GuildBaseInfo.Builder baseInfo = GuildHandler.GuildBaseInfo.newBuilder();
            baseInfo.setGuildId(guild.id);
            baseInfo.setName(guild.name);
            baseInfo.setLevel(guild.level);
            baseInfo.setPresidentId(guild.presidentId);
            baseInfo.setPresidentName(guild.presidentName);
            baseInfo.setEntryLevel(guild.entryLevel);
            baseInfo.setEntryUpLevel(guild.entryUpLevel);
            baseInfo.setGuildMode(guild.guildMode);
            baseInfo.setGuildIcon(guild.icon);
            baseInfo.setMemberNum(GuildUtil.getGuildMemberCount(guild.id));
            baseInfo.setMemberMax(levelProp.member);
            PlayerPO president = PlayerUtil.getPlayerBaseData(guild.presidentId);
            if (null == president) {
                continue;
            }
            baseInfo.setPresidentPro(president.pro);
            baseInfo.setPresidentLevel(president.level);
            baseInfo.setCreateTime(guild.createTime.toString());

            GuildHandler.GuildInfo.Builder guildInfo = GuildHandler.GuildInfo.newBuilder();
            guildInfo.setBaseInfo(baseInfo);

            boolean haveApply = false;
            for (GuildApplyPO guildApplyPO : applies) {
                if (guildApplyPO.guildId.equals(guild.id)) {
                    haveApply = true;
                    break;
                }
            }
            if (haveApply) {
                guildInfo.setApplyState(1);
            }
            data.add(guildInfo.build());
        }

        data.sort(new Comparator<GuildHandler.GuildInfo>() {
            public int compare(GuildHandler.GuildInfo guildA, GuildHandler.GuildInfo guildB) {
                GuildHandler.GuildBaseInfo baseA = guildA.toBuilder().getBaseInfo();
                GuildHandler.GuildBaseInfo baseB = guildB.toBuilder().getBaseInfo();
                if (baseA.getLevel() != baseB.getLevel()) {
                    return (baseA.getLevel() < baseB.getLevel()) ? 1 : -1;
                }
                return baseB.getCreateTime().compareTo(baseA.getCreateTime());
            }
        });


        return data;
    }

    public GuildHandler.MyContributeInfo getMyContributeInfo(String guildId) {
        GuildHandler.MyContributeInfo.Builder myContributeInfo = GuildHandler.MyContributeInfo.newBuilder();
        int myContribute = 0;


        myContribute = getContribution();
        myContributeInfo.setCurrentContribute(myContribute);
        myContributeInfo.setTotalContribute(getTotalContribution(guildId));
        myContributeInfo.addAllTimesList(getContributeTimesList());
        return myContributeInfo.build();
    }

    public List<GuildHandler.ContributeTimesInfo> getContributeTimesList() {
        List<GuildHandler.ContributeTimesInfo> timesList = new ArrayList<>();
        Map<String, GuildContributeCO> propMap = GuildUtil.getGuildContributePropMap();
        for (String key : propMap.keySet()) {
            GuildContributeCO prop = propMap.get(key);
            GuildHandler.ContributeTimesInfo.Builder tempInfo = GuildHandler.ContributeTimesInfo.newBuilder();
            tempInfo.setType(prop.type);
            tempInfo.setTimes(getContributeTimes(prop.type));
            tempInfo.setMaxTimes(prop.time);
            timesList.add(tempInfo.build());
        }

        return timesList;
    }

    public GuildHandler.MyGuildInfo getMyGuildInfo() {
        GuildHandler.MyGuildInfo.Builder data = GuildHandler.MyGuildInfo.newBuilder();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            return null;
        }
        GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
        if (null == guild) {
            return null;
        }

        GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
        if (null == levelProp) {
            return null;
        }

        GuildHandler.GuildBaseInfo.Builder baseInfo = GuildHandler.GuildBaseInfo.newBuilder();
        baseInfo.setGuildId(guild.id);
        baseInfo.setName(guild.name);
        baseInfo.setLevel(guild.level);
        baseInfo.setPresidentId(guild.presidentId);
        baseInfo.setPresidentName(guild.presidentName);
        baseInfo.setEntryLevel(guild.entryLevel);
        baseInfo.setEntryUpLevel(guild.entryUpLevel);
        baseInfo.setGuildMode(guild.guildMode);
        baseInfo.setGuildIcon(guild.icon);
        baseInfo.setMemberNum(GuildUtil.getGuildMemberCount(guild.id));
        baseInfo.setMemberMax(levelProp.member);
        PlayerPO president = PlayerUtil.getPlayerBaseData(guild.presidentId);
        baseInfo.setPresidentPro(1);
        baseInfo.setPresidentLevel(1);
        if (null == president) {
            Out.debug(new Object[]{"getMyGuildInfo getPlayerBaseData player not exit,guildId:", guild.id, ", playerId:", guild.presidentId});
        } else {
            baseInfo.setPresidentPro(president.pro);
            baseInfo.setPresidentLevel(president.level);
        }

        data.setBaseInfo(baseInfo.build());
        data.setNotice(guild.notice);
        data.setFund((int) guild.fund);
        data.setExp((int) guild.exp);
        data.setQqGroup(guild.qqGroup);
        data.setMyInfo(getMyContributeInfo(guild.id));
        Date now = new Date();
        int passedDay = (int) Math.floor(((now.getTime() - guild.changeNameTime.getTime()) / Const.Time.Day.getValue()));
        passedDay = Math.min(passedDay, 7);
        data.setChangeNamePassedDay(passedDay);

        List<GuildHandler.OfficeName> officeNames = new ArrayList<>();
        for (Integer key : guild.officeNames.keySet()) {
            GuildHandler.OfficeName.Builder jobInfo = GuildHandler.OfficeName.newBuilder();
            jobInfo.setJob(key.intValue());
            jobInfo.setName((String) guild.officeNames.get(key));
            officeNames.add(jobInfo.build());
        }
        data.addAllOfficeNames(officeNames);
        return data.build();
    }

    public void onChangeName() {
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            return;
        }
        myInfo.name = this.player.getName();
        GuildUtil.updateGuildMember(myInfo);
        GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
        if (null == guild) {
            return;
        }
        if (guild.presidentId.equals(this.player.getId())) {
            guild.presidentName = this.player.getName();
            GuildUtil.updateGuild(guild);
        }
    }

    public GuildResult getMyGuildMemberList() {
        GuildResult ret = new GuildResult();
        GuildResult.MyGuildMember data = new GuildResult.MyGuildMember();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }

        GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
        if (null == guild) {
            ret.result = -1;
            return ret;
        }


        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        int kickCount = guild.kickCount;
        if (DateUtil.canRefreshData(5, guild.kickTime)) {
            kickCount = 0;
        }
        int leftKickNum = settingProp.fireNum - kickCount;
        data.leftKickNum = (leftKickNum > 0) ? leftKickNum : 0;

        List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(myInfo.guildId);
        Map<Integer, String> defaultNames = GuildUtil.getJobNameMap();
        GuildHandler.MemberInfo.Builder president = GuildHandler.MemberInfo.newBuilder();
        GuildHandler.MemberInfo.Builder me = GuildHandler.MemberInfo.newBuilder();
        for (GuildMemberPO member : memberList) {
            PlayerPO playerBase = PlayerUtil.getPlayerBaseData(member.playerId);
            if (null == playerBase) {
                continue;
            }

            GuildHandler.MemberInfo.Builder tempInfo = GuildHandler.MemberInfo.newBuilder();
            tempInfo.setGuildName(guild.name);
            tempInfo.setPlayerId(member.playerId);
            tempInfo.setJob(member.job);
            tempInfo.setJoinTime(member.createTime.toString());
            if (null != guild.officeNames.get(Integer.valueOf(member.job))) {
                tempInfo.setJobName((String) guild.officeNames.get(Integer.valueOf(member.job)));
            } else {
                tempInfo.setJobName(defaultNames.get(Integer.valueOf(member.job)));
            }

            tempInfo.setName(playerBase.name);
            tempInfo.setPro(playerBase.pro);
            tempInfo.setLevel(playerBase.level);
            tempInfo.setUpLevel(playerBase.upOrder);

            PlayerGuildPO redisPo = FindPlayerGuildDao.getPlayerGuildPOById(member.playerId);
            if (null == redisPo) {
                continue;
            }

            Map<String, Integer> totalContrMap = redisPo.totalContributionMap;
            int contribution = 0;
            int totalContribute = 0;
            if (null != totalContrMap && totalContrMap.size() > 0) {
                if (totalContrMap.containsKey(guild.id)) {
                    totalContribute = ((Integer) totalContrMap.get(guild.id)).intValue();
                } else {

                    totalContribute = 0;
                }
            }

            contribution = redisPo.contribution;
            tempInfo.setCurrentContribute(contribution);
            tempInfo.setTotalContribute(totalContribute);
            boolean isOnline = PlayerUtil.isOnline(member.playerId);
            tempInfo.setOnlineState(isOnline ? 1 : 0);
            tempInfo.setLastActiveTime((int) Math.ceil((playerBase.logoutTime.getTime() / Const.Time.Second.getValue())));

            if (tempInfo.getJob() == Const.GuildJob.PRESIDENT.getValue()) {
                president = tempInfo;
                if (tempInfo.getPlayerId().equals(this.player.getId()))
                    me = tempInfo;
                continue;
            }
            if (tempInfo.getPlayerId().equals(this.player.getId())) {
                me = tempInfo;
                continue;
            }
            data.list.add(tempInfo.build());
        }


        data.list.sort((o1, o2) -> {
            GuildHandler.MemberInfo.Builder memberA = o1.toBuilder();


            GuildHandler.MemberInfo.Builder memberB = o1.toBuilder();


            return (memberA.getOnlineState() != memberB.getOnlineState()) ? ((memberA.getOnlineState() < memberB.getOnlineState()) ? 1 : -1) : ((memberA.getJob() != memberB.getJob()) ? ((memberA.getJob() < memberB.getJob()) ? -1 : 1) : ((memberA.getUpLevel() != memberB.getUpLevel()) ? ((memberA.getUpLevel() < memberB.getUpLevel()) ? 1 : -1) : ((memberA.getLevel() != memberB.getLevel()) ? ((memberA.getLevel() < memberB.getLevel()) ? 1 : -1) : memberB.getJoinTime().compareTo(memberA.getJoinTime()))));
        });


        if (!president.getPlayerId().equals(me.getPlayerId())) {
            data.list.add(0, me.build());
        }

        data.list.add(0, president.build());
        ret.result = 0;
        ret.data = data;
        return ret;
    }

    public List<GuildHandler.ApplyInfo> getMyGuildApplyList() {
        List<GuildHandler.ApplyInfo> data = new ArrayList<>();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            return data;
        }
        GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
        if (null == guild) {
            return data;
        }
        List<GuildApplyPO> applyList = GuildUtil.getGuildApplyList(myInfo.guildId);
        for (GuildApplyPO apply : applyList) {
            PlayerPO playerBase = PlayerUtil.getPlayerBaseData(apply.playerId);
            if (null == playerBase) {
                continue;
            }
            GuildHandler.ApplyInfo.Builder tempInfo = GuildHandler.ApplyInfo.newBuilder();
            tempInfo.setApplyId(apply.id);
            tempInfo.setPlayerId(apply.playerId);
            tempInfo.setPro(playerBase.pro);
            tempInfo.setName(playerBase.name);
            tempInfo.setLevel(playerBase.level);
            tempInfo.setFightPower(playerBase.fightPower);
            tempInfo.setUpLevel(this.player.player.upLevel);
            tempInfo.setCreateTime(apply.createTime.toString());
            data.add(tempInfo.build());
        }

        data.sort((applyA, applyB) -> (applyA.getUpLevel() != applyB.getUpLevel()) ? ((applyA.getUpLevel() < applyB.getUpLevel()) ? 1 : -1) : ((applyA.getLevel() != applyB.getLevel()) ? ((applyA.getLevel() < applyB.getLevel()) ? 1 : -1) : ((applyA.getFightPower() != applyB.getFightPower()) ? ((applyA.getFightPower() < applyB.getFightPower()) ? 1 : -1) : applyB.getCreateTime().compareTo(applyA.getCreateTime()))));


        return data;
    }

    public GuildResult exitGuild() {
        GuildResult ret = GuildService.exitGuild(this.player);
        if (ret.result == 0) {
            this.guildData.lastSelfExitTime = new Date();
            Set<String> ids = new HashSet<>();
            ids.add(this.player.getId());
            GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
            GuildService.notifySomePlayerRefreshGuild(ids, msg, null);
            this.player.pkRuleManager.onExitGuild();
            update();
        }
        return ret;
    }

    public GuildResult kickMember(String kickId) {
        GuildResult ret = GuildService.kickMember(this.player, kickId);
        return ret;
    }

    public GuildResult upgradeGuildLevel() {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right12 == 0) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
        if (null == settingProp || null == levelProp) {
            ret.result = -3;
            ret.des = "配置错误";
            return ret;
        }
        if (!this.player.moneyManager.enoughGold(levelProp.gold)) {
            ret.result = -4;
            ret.des = "银两不足";
            return ret;
        }

        ret = GuildService.upgradeGuildLevel(this.player);

        if (ret.result == 0) {
            this.player.moneyManager.costGold(levelProp.gold, Const.GOODS_CHANGE_TYPE.guild_upgrade_level);
        }


        return ret;
    }

    public GuildResult changeGuildNotice(String notice) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }

        if (null == notice) {
            ret.result = -3;
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        int maxLen = (settingProp.announcement > 0) ? settingProp.announcement : 100;
        if (notice.length() > maxLen) {
            ret.result = -4;
            return ret;
        }

        String replacedNotice = BlackWordUtil.replaceBlackString(notice);
        ret = GuildService.changeGuildNotice(this.player, replacedNotice);
        return ret;
    }

    public GuildResult changeGuildName(String name) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right2 == 0) {
            ret.result = -2;
            return ret;
        }
        Date now = new Date();
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        int dayCD = settingProp.changeNameCD;
        long cdOverTime = myGuild.changeNameTime.getTime() + (dayCD * Const.Time.Day.getValue());
        if (now.getTime() < cdOverTime) {
            ret.result = 2;
            return ret;
        }
        if (null == name || name.length() < 3) {
            ret.result = -4;
            return ret;
        }
        if (name.length() > settingProp.nameMaxLen) {
            ret.result = -5;
            return ret;
        }
        if (BlackWordUtil.isIncludeSpecialChar(name)) {
            ret.result = -8;
            return ret;
        }
        if (BlackWordUtil.isIncludeBlackString(name)) {
            ret.result = -9;
            return ret;
        }

        GuildSettingExt settintProp = GuildUtil.getGuildSettingExtProp();
        String costCode = settintProp.changeName;
        int costNum = settintProp.changeNameCost;
        int haveNum = this.player.bag.findItemNumByCode(costCode);
        if (haveNum < costNum) {
            ret.result = -6;
            return ret;
        }

        ret = GuildService.changeGuildName(this.player, name);
        if (ret.result == 0) {
            this.player.bag.discardItem(costCode, costNum, Const.GOODS_CHANGE_TYPE.guildchangename, null, false, false);
            update();
        }
        return ret;
    }

    public GuildResult changeOfficeName(List<GuildHandler.OfficeName> officeNames) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            return ret;
        }

        GuildSettingExt settintProp = GuildUtil.getGuildSettingExtProp();
        for (GuildHandler.OfficeName office : officeNames) {
            if (office.getJob() < Const.GuildJob.PRESIDENT.getValue() || office.getJob() > Const.GuildJob.MEMBER.getValue()) {
                ret.result = -3;
                return ret;
            }
            if (office.getName().isEmpty()) {
                ret.result = -4;
                return ret;
            }
            if (office.getName().length() > settintProp.maxLen) {
                ret.result = -5;
                return ret;
            }
            if (BlackWordUtil.isIncludeSpecialChar(office.getName())) {
                ret.result = -8;
                return ret;
            }
            if (BlackWordUtil.isIncludeBlackString(office.getName())) {
                ret.result = -9;
                return ret;
            }
        }

        ret = GuildService.changeOfficeName(this.player, officeNames);
        if (ret.result == 0) ;

        return ret;
    }


    public boolean checkIsCanContribute() {
        boolean ret = false;

        for (int i = 1; i <= 2; i++) {
            GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(i);
            String costCode = contributeProp.costItem;
            int costNum = contributeProp.costAmount;

            if (getContributeTimes(i) < contributeProp.time) {
                if (1 == i) {
                    if (this.player.moneyManager.enoughGold(costNum)) {
                        ret = true;
                        break;
                    }
                } else {
                    int haveNum = this.player.bag.findItemNumByCode(costCode);
                    if (haveNum >= costNum) {
                        ret = true;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    public GuildResult contributeToGuild(int type, int times) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }

        GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(type);
        if (null == contributeProp || times == 0) {
            ret.result = -2;
            return ret;
        }
        String costCode = contributeProp.costItem;
        int costNum = contributeProp.costAmount * times;
        if (type == 1) {
            if (!this.player.moneyManager.enoughGold(costNum)) {
                ret.result = -3;
                return ret;
            }
        } else {
            int haveNum = this.player.bag.findItemNumByCode(costCode);
            if (haveNum < costNum) {
                ret.result = -4;
                return ret;
            }
        }
        if (getContributeTimes(type) + times > contributeProp.time) {
            ret.result = -5;
            return ret;
        }

        ret = GuildService.contributeToGuild(this.player, type, times);

        if (ret.result == 0) {
            if (type == 1) {
                this.player.moneyManager.costGold(costNum, Const.GOODS_CHANGE_TYPE.guild_donate);
            } else {
                this.player.bag.discardItem(costCode, costNum, Const.GOODS_CHANGE_TYPE.guild_donate);
            }
            int totalPoints = contributeProp.guildPoints * times;
            addContribution(totalPoints, Const.GOODS_CHANGE_TYPE.guild_donate);
            addTotalContribution(myGuild.id, totalPoints);
            addContributeTimes(type, times);

            this.player.taskManager.dealTaskEvent(Const.TaskType.GUILD_DONATE, "1", 1);
            pushRedPoint();


            (getMiscData()).guildDonateToday = 1;

            update();
        }
        return ret;
    }

    public MiscData getMiscData() {
        if (null == this.player.playerAttachPO.miscData) {
            this.player.playerAttachPO.miscData = new MiscData();
        }

        return this.player.playerAttachPO.miscData;
    }

    public GuildResult setMemberJob(String memberId, int job) {
        GuildResult ret = new GuildResult();
        if (null == memberId || memberId.isEmpty() || job > Const.GuildJob.MEMBER.getValue()) {
            ret.result = -20;
            return ret;
        }
        if (memberId == this.player.getId()) {
            ret.result = -21;
            return ret;
        }

        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }
        GuildMemberPO memberInfo = GuildUtil.getGuildMember(memberId);
        if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
            ret.result = -2;
            return ret;
        }
        if (myInfo.job > Const.GuildJob.ELDER.getValue()) {
            ret.result = -3;
            return ret;
        }
        if (myInfo.job >= memberInfo.job || myInfo.job >= job) {
            ret.result = -4;
            return ret;
        }

        ret = GuildService.setMemberJob(this.player, memberId, job);
        if (ret.result == 0) ;

        return ret;
    }

    public GuildResult transferGuildPresident(String memberId) {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            return ret;
        }

        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            return ret;
        }
        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            return ret;
        }

        GuildMemberPO memberInfo = GuildUtil.getGuildMember(memberId);
        if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
            ret.result = -3;
            return ret;
        }

        PlayerPO newPresident = PlayerUtil.getPlayerBaseData(memberId);
        if (null == newPresident) {
            ret.result = -20;
            return ret;
        }

        ret = GuildService.transferGuildPresident(this.player.getId(), memberId);
        return ret;
    }

    public List<GuildHandler.RecordInfo> getGuildRecordList(int page) {
        List<GuildHandler.RecordInfo> list = new ArrayList<>();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            return list;
        }
        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            return list;
        }
        if (page == 0) {
            return list;
        }
        List<GuildRecordData> records = GuildDao.getGuildNews(myGuild.id);
        int perPageNum = 50;
        int startIndex = (page - 1) * perPageNum;
        int endIndex = startIndex + perPageNum;
        for (int i = startIndex; i < records.size() && i < endIndex; i++) {
            GuildRecordData record = records.get(i);
            Date recordTime = record.time;
            GuildHandler.RecordInfo.Builder tempInfo = GuildHandler.RecordInfo.newBuilder();
            tempInfo.setTime(DateUtil.format(recordTime, "MM-dd HH:mm:ss"));
            if (null != record.role1 && 0 != record.role1.pro) {
                tempInfo.setRole1(GuildCommonUtil.convertRoleInfo(record.role1));
            }
            if (null != record.role2 && record.role2.pro != 0) {
                tempInfo.setRole2(GuildCommonUtil.convertRoleInfo(record.role2));
            }
            if (null != record.result) {
                tempInfo.setResultNum(record.result.v1);

                if (null != record.result.v2 && !record.result.v2.isEmpty()) {
                    tempInfo.setResultStr(record.result.v2);
                }
            }
            if (null != record.build && !record.build.isEmpty()) {
                tempInfo.setBuild(record.build);
            }

            tempInfo.setRecordType(record.type);
            list.add(tempInfo.build());
        }
        return list;
    }

    public GuildResult impeachGuildPresident() {
        GuildResult ret = new GuildResult();
        GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }

        GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = "不是公会成员";
            return ret;
        }
        if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            ret.des = "不能弹劾自己";
            return ret;
        }
        boolean isPresidentOnline = PlayerUtil.isOnline(myGuild.presidentId);
        if (isPresidentOnline) {
            ret.result = -3;
            ret.des = "会长在线";
            return ret;
        }
        PlayerPO president = PlayerUtil.getPlayerBaseData(myGuild.presidentId);
        if (null == president) {
            ret.result = -4;
            ret.des = "会长不存在，系统错误";
            return ret;
        }
        Date logoutTime = president.logoutTime;
        Date nowTime = new Date();
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (null == settingProp) {
            ret.result = -5;
            ret.des = "配置不存在，系统错误";
            return ret;
        }
        if (nowTime.getTime() - logoutTime.getTime() < settingProp.impeachMs) {
            ret.result = -6;
            ret.des = LangService.getValue("GUILD_PRESIDENT_OFFTIME_NOT_ENOUGH").replace("{day}", String.valueOf(settingProp.impeach));
            return ret;
        }

        ret = GuildService.impeachGuildPresident(this.player, this.guild.presidentId, logoutTime);

        if (ret.result == 0) ;


        return ret;
    }


    public void onTaskEvent() {
        this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
    }

    public void playerOnlineRefreshGuildData() {
        GuildResult resData = GuildService.playerOnlineRefreshGuild(this.player);
        GuildResult.PlayerOnlineRefreshGuild data = (GuildResult.PlayerOnlineRefreshGuild) resData.data;
        changeGuildData(data, false);
    }

    public void changeGuildData(GuildMsg msg, boolean isPush) {
        GuildMsg.JoinGuildBlessMsg joinBless = (GuildMsg.JoinGuildBlessMsg) msg.data;
        GuildBlessPO data = joinBless.blessData;

        if (null != data && null != data.allBlobData) {
            if (null != data.allBlobData.goods) {
                this.guildShopManager.goods = data.allBlobData.goods;
            }
            if (null != data.allBlobData.techData) {
                this.guildTechManager.refreshTechData(data.allBlobData.techData);
            }


            this.guildTechManager.refreshLevel();

            int[] arr = data.allBlobData.finishStateArr;
            for (int i = 0; i < arr.length; i++) {
                if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i])
                    this.guildData.blessRecState[i] = arr[i];
            }
            if (data.allBlobData.throwAwardState > 0) {
                this.throwAwardState = data.allBlobData.throwAwardState;
            }
        }

        if (isPush) {
            pushAndRefreshGuildEffect();
            changeBlessBuff();
        }
    }

    public void changeGuildData(GuildResult.PlayerOnlineRefreshGuild data, boolean isPush) {
        if (null == data) {
            return;
        }

        if (null != data.goods) {
            this.guildShopManager.goods = data.goods;
        }
        if (null != data.techData) {
            this.guildTechManager.refreshTechData(data.techData);
        }

        this.guildTechManager.refreshLevel();

        int[] arr = data.finishStateArr;
        for (int i = 0; i < arr.length; i++) {
            if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i]) {
                this.guildData.blessRecState[i] = arr[i];
            }
        }
        if (data.throwAwardState > 0) {
            this.throwAwardState = data.throwAwardState;
        }

        if (isPush) {
            pushAndRefreshGuildEffect();
            changeBlessBuff();
        }
    }

    public void resetGuildPublicData(boolean isPush) {
        this.guildData.buffIds.clear();
        for (int i = 0; i < this.guildData.blessRecState.length; i++) {
            this.guildData.blessRecState[i] = 0;
        }
        this.guildTechManager.resetPublicData();
        this.guildShopManager.resetPublicData();
        if (isPush) {
            pushAndRefreshGuildEffect();
            changeBlessBuff();
        }
        resetGuildInfo(true);
    }

    public void onNotifyRefreshGuild(GuildMsg msg) {
        int refreshType = msg.notifyType;
        if (refreshType == Const.NotifyType.GUILD_REFRESH.getValue()) {
            refreshGuildInfo(false);
        } else if (refreshType == Const.NotifyType.GUILD_JOIN_PUSH.getValue()) {
            refreshGuildInfo(true);
            changeGuildData(msg, true);
            pushToClientRefreshGuild(msg);
            if (this.guild != null) {
                this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
            }
        } else if (refreshType == Const.NotifyType.GUILD_EXIT_PUSH.getValue()) {
            resetGuildPublicData(true);
            refreshGuildInfo(true);
            this.player.pkRuleManager.onExitGuild();
            pushToClientRefreshGuild(msg);
        } else if (refreshType == Const.NotifyType.GUILD_JOB_CHANGE.getValue()) {
            refreshGuildInfo(true);
            pushToClientRefreshGuild(msg);
        } else if (refreshType == Const.NotifyType.GUILD_CHANGE_NAME.getValue()) {
            refreshGuildInfo(true);
            pushToClientRefreshGuild(msg);
        } else if (refreshType == Const.NotifyType.DEPOT_DEPOSIT_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_REMOVE_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_UPGRADE_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_CONDITION_PUSH.getValue()) {
            GuildMsg.DepotRefreshGuildMsg msgData = (GuildMsg.DepotRefreshGuildMsg) msg.data;
            GuildDepotHandler.DepotRefreshPush.Builder data = GuildDepotHandler.DepotRefreshPush.newBuilder();
            data.setS2CCode(200);
            data.setType(msgData.type);
            data.setBagIndex(msgData.bagIndex);
            data.setLevelInfo(msgData.levelInfo);
            data.setCondition(GuildCommonUtil.toHandlerDepot(msgData.condition));
            this.player.receive("area.guildDepotPush.depotRefreshPush", (GeneratedMessage) data.build());

        } else if (refreshType == Const.NotifyType.BLESS_FINISH_PUSH.getValue()) {
            GuildBlessHandler.BlessRefreshPush.Builder blessData = GuildBlessHandler.BlessRefreshPush.newBuilder();
            blessData.setS2CCode(200);

            GuildMsg.BlessRefreshGuildMsg blessMsgData = (GuildMsg.BlessRefreshGuildMsg) msg.data;
            blessData.setType(refreshType - Const.NotifyType.BLESS_PUSH_START.getValue() + 1);
            if (blessMsgData.finishStateArr.length > 0) {
                blessData.addAllFinishState(GuildCommonUtil.toList(blessMsgData.finishStateArr));
                blessData.setBlessValue(blessMsgData.blessValue);

                for (int i = 0; i < blessMsgData.finishStateArr.length; i++) {
                    if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i])
                        this.guildData.blessRecState[i] = blessMsgData.finishStateArr[i];
                }
            }
        } else if (refreshType == Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue()) {

            pushToClientRefreshGuild(msg);


            GuildBlessHandler.BlessRefreshPush.Builder blessData = GuildBlessHandler.BlessRefreshPush.newBuilder();
            blessData.setS2CCode(200);
            blessData.setType(Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue() - Const.NotifyType.BLESS_PUSH_START.getValue() + 1);
            this.player.receive("area.guildBlessPush.blessRefreshPush", (GeneratedMessage) blessData.build());


            GuildShopHandler.ShopRefreshPush.Builder shopData = GuildShopHandler.ShopRefreshPush.newBuilder();
            shopData.setS2CCode(200);
            shopData.setType(Const.NotifyType.SHOP_NEW_DAY_PUSH.getValue() - Const.NotifyType.SHOP_PUSH_START.getValue() + 1);
            this.player.receive("area.guildShopPush.shopRefreshPush", (GeneratedMessage) shopData.build());


            GuildTechHandler.GuildTechRefreshPush.Builder techData = GuildTechHandler.GuildTechRefreshPush.newBuilder();


            techData.setType(1);
            this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage) techData.build());

            pushAndRefreshGuildEffect();
            clearBlessBuff();
            changeBlessBuff();
        } else if (refreshType == Const.NotifyType.TECH_LEVEL_PUSH.getValue()) {
            GuildMsg.TechRefreshGuildMsg msgData = (GuildMsg.TechRefreshGuildMsg) msg.data;
            boolean changeInfluence = this.guildTechManager.refreshTechData(msgData.techData);
            if (changeInfluence) {
                pushAndRefreshGuildEffect();
                changeBlessBuff();
            }

            GuildTechHandler.GuildTechRefreshPush.Builder data = GuildTechHandler.GuildTechRefreshPush.newBuilder();
            data.setS2CCode(200);
            data.setType(refreshType - Const.NotifyType.TECH_PUSH_START.getValue() + 1);
            data.setLevel(msgData.techData.blobData.level);
            this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage) data.build());
        } else if (refreshType == Const.NotifyType.TECH_BUFF_LEVEL_PUSH.getValue()) {

            GuildMsg.TechRefreshGuildMsg msgData = (GuildMsg.TechRefreshGuildMsg) msg.data;
            boolean changeInfluence = this.guildTechManager.refreshTechData(msgData.techData);
            if (changeInfluence) {
                pushAndRefreshGuildEffect();
                changeBlessBuff();
            }

            GuildTechHandler.GuildTechRefreshPush.Builder data = GuildTechHandler.GuildTechRefreshPush.newBuilder();
            data.setS2CCode(200);
            data.setType(1);
            this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage) data.build());
        } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_OPEN.getValue()) {
            Area area = this.player.getArea();

            GuildHandler.GuildDungeonOpenPush.Builder data = GuildHandler.GuildDungeonOpenPush.newBuilder();
            if (null != area && (area.isNormal() || area.sceneType == Const.SCENE_TYPE.WORLD_BOSS.getValue())) {
                data.setS2CCode(200);
                this.player.receive("area.guildPush.guildDungeonOpenPush", (GeneratedMessage) data.build());
            }
        } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_PASS.getValue()) {
            GuildMsg.DungeonPassGuildMsg msgData = (GuildMsg.DungeonPassGuildMsg) msg.data;
            GuildHandler.GuildDungeonPassPush.Builder data = GuildHandler.GuildDungeonPassPush.newBuilder();
            data.setDungeonCount(msgData.dungeonCount);
            this.player.receive("area.guildPush.guildDungeonPassPush", (GeneratedMessage) data.build());
        } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_PLAYER_NUM.getValue()) {
            GuildMsg.DungeonPlayerNumGuildMsg msgData = (GuildMsg.DungeonPlayerNumGuildMsg) msg.data;
            GuildHandler.GuildDungeonPlayerNumPush.Builder data = GuildHandler.GuildDungeonPlayerNumPush.newBuilder();
            data.setS2CCode(200);
            data.setPlayerNum(msgData.playerNum);
            this.player.receive("area.guildPush.guildDungeonPlayerNumPush", (GeneratedMessage) data.build());
        } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_OPEN_CHAT.getValue()) {
            GuildMsg.OnChatGuildMsg msgData = (GuildMsg.OnChatGuildMsg) msg.data;
            WNPlayer player = PlayerUtil.getOnlinePlayer(msgData.playerId);
            if (null == player) {
                return;
            }


            MessageUtil.sendChatMsgAsyn(player, LangService.getValue("GDUNGEON_OPEN_WORDS"), Const.CHAT_SCOPE.GUILD, Const.TipsType.NORMAL);
        }
    }

    public void pushToClientRefreshGuild(GuildMsg msg) {
        int refreshType = msg.notifyType;

        GuildHandler.GuildRefreshPush.Builder data = GuildHandler.GuildRefreshPush.newBuilder();
        data.setS2CCode(200);

        if (refreshType <= 0)
            return;
        if (refreshType == Const.NotifyType.GUILD_JOIN_PUSH.getValue()) {
            data.setIsIn(1);
        } else if (refreshType == Const.NotifyType.GUILD_EXIT_PUSH.getValue()) {
            data.setIsOut(1);
        } else if (refreshType == Const.NotifyType.GUILD_JOB_CHANGE.getValue()) {
            GuildMsg.RefreshGuildMsg msgData = (GuildMsg.RefreshGuildMsg) msg.data;
            data.setJob(msgData.job);
            data.setJobName(msgData.jobName);
        } else if (refreshType == Const.NotifyType.GUILD_CHANGE_NAME.getValue()) {
            GuildMsg.RefreshGuildMsg msgData = (GuildMsg.RefreshGuildMsg) msg.data;
            data.setGuildName(msgData.guildName);
        } else if (refreshType == Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue()) {
            data.addAllTimesList(getContributeTimesList());
        }

        this.player.receive("area.guildPush.guildRefreshPush", (GeneratedMessage) data.build());
    }

    public GuildResult depositEquipToDepot(int bagIndex) {
        GuildResult ret = new GuildResult();
        if (bagIndex < 0) {
            ret.result = -1;
            ret.des = "参数错误";
            return ret;
        }

        NormalItem item = this.player.bag.getItem(bagIndex);
        if (null == item) {
            ret.result = -2;
            ret.des = "该包裹格子没有装备错误";
            return ret;
        }
        if (!item.isEquip()) {
            ret.result = -4;
            ret.des = "不是装备";
            return ret;
        }
        if (item.isBinding()) {
            ret.result = -3;
            ret.des = "道具已绑定";
            return ret;
        }
        if (!item.canDepotGuild()) {
            ret.result = -5;
            ret.des = "该道具不能存入公会仓库";
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (this.guildData.depositCount >= settingProp.warehousePutIn) {
            ret.result = -6;
            ret.des = "今日存入次数已用完";
            return ret;
        }

        if (item.getLevel() < settingProp.warehouseMinLv) {
            ret.result = -7;
            ret.des = "装备等级太低";
            return ret;
        }

        if (item.getQLevel() < settingProp.warehouseMinQ) {
            ret.result = -8;
            ret.des = "装备品质太低";
            return ret;
        }

        WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(item.getLevel(), item.getQLevel());
        if (null == depositProp) {
            ret.result = -9;
            ret.des = "未找到该品质对应的配置";
            return ret;
        }

        int addNum = depositProp.wareHouseValue;
        PlayerItemPO itemData = item.cloneItemDB();
        ret = GuildService.depotDepositEquip(this.player, itemData);

        if (ret.result == 0) {
            this.player.bag.removeItemByPos(bagIndex, false, Const.GOODS_CHANGE_TYPE.guild_store);
            this.player.baseDataManager.addPawnGold(addNum);
            this.player.pushDynamicData("pawnGold", Integer.valueOf(this.player.player.pawnGold));

            ret.depositCount = ++this.guildData.depositCount;
            update();
        }
        return ret;
    }


    public void update() {
        GameDao.update(this.player.getId(), ConstsTR.playerGuildTR, this.guildData);
    }

    public GuildResult takeOutEquipFromDepot(int depotIndex) {
        GuildResult ret = new GuildResult();
        if (depotIndex <= 0) {
            ret.result = -1;
            ret.des = "参数错误";
            return ret;
        }

        if (!this.player.bag.testEmptyGridLarge(1)) {
            ret.result = -2;
            ret.des = "背包格子不够";
            return ret;
        }

        int havePawnGold = this.player.baseDataManager.getPawnGold();
        ret = GuildService.depotTakeOutEquip(this.player, depotIndex, havePawnGold);
        if (ret.result == 0) {
            PlayerItemPO itemData = ret.itemData;
            NormalItem item = ItemUtil.createItemByDbOpts(itemData);
            WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(item.getLevel(), item.getQLevel());
            int costNum = depositProp.wareHouseCost;
            this.player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.guild_store, null, true, false);
            this.player.baseDataManager.costPawnGold(costNum);
            this.player.pushDynamicData("pawnGold", Integer.valueOf(this.player.player.pawnGold));

            update();
        }
        return ret;
    }

    public GuildResult setDepotCondition(GuildDepotCondition condition) {
        GuildResult ret = new GuildResult();
        GuildCond useCond = condition.useCond;
        if (0 == useCond.job || useCond.job > Const.GuildJob.MEMBER.getValue() || (0 == useCond.level && 0 == useCond.upLevel)) {
            ret.result = -1;
            ret.des = "参数错误";
            return ret;
        }

        if (!GuildUtil.checkCondition(condition)) {
            ret.result = -2;
            ret.des = "装备品质区间不合理";
            return ret;
        }

        ret = GuildService.depotSetCondition(this.player, condition);
        if (ret.result == 0) ;
        return ret;
    }

    public GuildResult deleteEquipFromDepot(int depotIndex) {
        GuildResult ret = new GuildResult();
        if (depotIndex == 0) {
            ret.result = -1;
            ret.des = "参数错误";
            return ret;
        }

        ret = GuildService.depotDeleteEquip(this.player, depotIndex);
        if (ret.result == 0) ;
        return ret;
    }

    public GuildResult upgradeDepotLevel() {
        GuildResult ret = new GuildResult();
        int myGold = this.player.moneyManager.getGold();
        ret = GuildService.depotUpgradeLevel(this.player, myGold);
        GuildResult.DepotUpgradeLevelData data = (GuildResult.DepotUpgradeLevelData) ret.data;
        if (ret.result == 0 &&
                data.costGoldNum > 0) {
            this.player.moneyManager.costGold(data.costGoldNum, Const.GOODS_CHANGE_TYPE.guild_upgrade_depot_level);
            update();
        }

        return ret;
    }


    public GuildBlessHandler.MyBlessInfo getMyBlessInfo() {
        GuildBlessHandler.MyBlessInfo.Builder data = GuildBlessHandler.MyBlessInfo.newBuilder();
        data.setBlessCount(this.guildData.blessCount);

        List<Map<String, Integer>> buffAttrs = GuildUtil.getBlessBuffAttrsList(this.guildData.buffIds);
        if (null != buffAttrs) {
            data.addAllBlessAttrs(AttributeUtil.getAttributeBaseByArray(buffAttrs));
        }
        data.setBuffTime(this.guildData.buffTime);
        data.addAllReceiveState(GuildCommonUtil.toList(this.guildData.blessRecState));
        GuildBlessPO blessPO = GuildBlessCenter.getInstance().getBlessData(getGuildId());

        List<GuildBlessHandler.BlessItem> itemList = new ArrayList<>();
        for (int i = 0; i < blessPO.gifts.size(); i++) {
            Map<String, Integer> ls = blessPO.gifts.get(i);
            GuildBlessHandler.BlessItem.Builder tempInfo = GuildBlessHandler.BlessItem.newBuilder();
            List<ItemOuterClass.MiniItem> items = new ArrayList<>();
            for (String key : ls.keySet()) {
                ItemOuterClass.MiniItem.Builder tmpItem = ItemUtil.getMiniItemData(key, 1);
                if (null == tmpItem) {
                    Out.error(new Object[]{"GuildBless toJson4PayLoad config is null:", key});
                    continue;
                }
                tmpItem.setGroupCount(((Integer) ls.get(key)).intValue());
                items.add(tmpItem.build());
            }
            tempInfo.addAllItem(items);
            itemList.add(tempInfo.build());
        }
        data.addAllItemList(itemList);
        return data.build();
    }

    public GuildResult blessAction(int id, int times) {
        GuildResult ret = new GuildResult();
        BlessItemCO blessItemProp = GuildUtil.getBlessItemById(id);
        if (null == blessItemProp) {
            ret.result = -1;
            ret.des = "参数错误";
            return ret;
        }
        String itemCode = blessItemProp.itemID;
        int haveItemNum = this.player.bag.findItemNumByCode(itemCode);
        if (haveItemNum < times) {
            ret.result = -2;
            ret.des = "材料不足";
            return ret;
        }

        ret = GuildService.blessAction(this.player, id, this.guildData.blessCount, times);

        if (ret.result == 0) {
            this.guildData.blessCount += times;
            this.player.bag.discardItem(itemCode, times, Const.GOODS_CHANGE_TYPE.guild_bless, null, false, false);
            (getMiscData()).guildBlessToday = 1;
            GuildResult.GuildBlessActionData data = (GuildResult.GuildBlessActionData) ret.data;
            data.blessCount = this.guildData.blessCount;

            this.guildData.buffIds.clear();
            this.guildData.buffTime = data.buffTime;
            this.guildData.buffIds = data.buffIds;
            for (int i = 0; i < data.finishState.length; i++) {
                if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i]) {
                    this.guildData.blessRecState[i] = data.finishState[i];
                }
            }

            GuildBless bless = GuildBlessCenter.getInstance().getBless(this.guild.id);
            if (null != bless) {
                BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.blessLevel);
                if (blessLevelExt != null) {


                    this.guild.fund += ((BlessLevelCO) blessLevelExt).addGuildFunds;
                    this.guild.sumFund += ((BlessLevelCO) blessLevelExt).addGuildFunds;
                    Out.info(new Object[]{"添加仙盟基金 guildId=", this.guild.id, ", fund=", Integer.valueOf(((BlessLevelCO) blessLevelExt).addGuildFunds)});
                    GuildServiceCenter.getInstance().saveGuild(this.guild);


                    this.player.guildManager.addContribution(((BlessLevelCO) blessLevelExt).addGuildPoints, Const.GOODS_CHANGE_TYPE.guild_bless);
                    this.player.guildManager.addTotalContribution(this.guild.id, ((BlessLevelCO) blessLevelExt).addGuildPoints);
                }
            }


            pushRedPoint();
            startTimer();
            changeBlessBuff();
            update();
        }
        return ret;
    }

    public GuildResult receiveBlessGift(int index) {
        GuildResult ret = new GuildResult();
        if (index < 0 && index >= 2) {
            ret.result = -10;
            ret.des = "参数错误";
            return ret;
        }

        if (this.guildData.blessRecState[index] == Const.EVENT_GIFT_STATE.RECEIVED.getValue()) {
            ret.result = -1;
            ret.des = "已领取";
            return ret;
        }

        if (!this.player.bag.testEmptyGridLarge(1)) {
            ret.result = -2;
            ret.des = "背包格子不够";
            return ret;
        }

        ret = GuildService.receiveBlessGift(this.player, index);
        if (ret.result == 0) {

            GuildResult.GuildGiftAndBuffData gift = (GuildResult.GuildGiftAndBuffData) ret.data;
            List<NormalItem> list_items = ItemUtil.createItemsByItemCode(gift.itemCode);
            this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.guild_bless_award, "Bag_full_common");
            this.guildData.blessRecState[index] = Const.EVENT_GIFT_STATE.RECEIVED.getValue();
            gift.receiveState = GuildCommonUtil.toList(this.guildData.blessRecState);
            update();
            pushRedPoint();
        }
        return ret;
    }

    public GuildResult upgradeBlessLevel() {
        GuildResult ret = new GuildResult();
        int haveGold = this.player.moneyManager.getGold();
        ret = GuildService.upgradeBlessLevel(this.player, haveGold);
        GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel) ret.data;
        if (ret.result == 0 &&
                data.needGold > 0) {
            this.player.moneyManager.costGold(data.needGold, Const.GOODS_CHANGE_TYPE.guild_upgrade_bless_level);
            update();
        }

        return ret;
    }

    public GuildDungeonResult joinGuildDungeon(Area area, int type) {
        GuildDungeonResult data = new GuildDungeonResult();
        data.type = 0;
        if (!area.isNormal() && area.getSceneType() != Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && area.getSceneType() != Const.SCENE_TYPE.WORLD_BOSS.getValue()) {
            data.result = false;
            data.info = LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
            return data;
        }

        if (!getGuildId().equals(this.guildData.joinDungeonGuildId) && DateUtil.isSameDay(new Date(), this.guildData.joinDungeonTime)) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_NO_TIMES");
            return data;
        }

        GuildService.joinGuildDungeon(this.player.getId(), this.player.getLevel());

        if (LangService.getValue("GDUNGEON_ENTER_ERROR").equals(data.info)) {
            if (type == 0) {
                data.result = true;
                data.type = 1;
            }
            return data;
        }

        if (!data.result) {
            return data;
        }

        if (area.getSceneType() == Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && area.areaId == data.dungeonId) {

            data.result = false;
            data.info = LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
            return data;
        }


        return data;
    }

    public GuildDungeonResult leaveDungeon(WNPlayer player) {
        GuildDungeonResult data = new GuildDungeonResult();
        data.result = true;
        data.info = "";


        return data;
    }

    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILD.getValue());
        data.setNumber(0);
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue())) {
            list.add(data.build());
            return list;
        }
        if (!isInGuild()) {
            list.add(data.build());
            return list;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(this.member.job);
        if (null == jobProp) {
            list.add(data.build());
            return list;
        }
        if (jobProp.right3 > 0) {
            int applyCount = GuildUtil.getGuildApplyCount(getGuildId());
            if (applyCount > 0) {
                int tmp = data.getNumber();
                data.setNumber(tmp + 1);
            }
        }

        if (null != this.guildData.blessRecState) {
            for (int i = 0; i < this.guildData.blessRecState.length; i++) {
                if (this.guildData.blessRecState.length > i) {

                    if (this.guildData.blessRecState[i] != Const.EVENT_GIFT_STATE.RECEIVED.getValue()) {
                        int tmp = data.getNumber();
                        data.setNumber(tmp + 1);
                    }
                }
            }
        }
        if (this.throwAwardState > 0) {
            int tmp = data.getNumber();
            data.setNumber(tmp + 1);
        }

        return list;
    }


    public void setJoinDungeonGuildId(String guildId) {
        if (!this.guildData.joinDungeonGuildId.equals(guildId)) {
            this.guildData.joinDungeonGuildId = guildId;
        }

        Date now = new Date();
        if (!DateUtil.isSameDay(now, this.guildData.joinDungeonTime)) {
            this.guildData.joinDungeonTime = now;
        }
    }

    public String getGuildId() {
        return (this.guild != null) ? this.guild.id : "";
    }

    public String getGuildIcon() {
        return (this.guild != null) ? this.guild.icon : "";
    }

    public void setGuildJobInfo(String guildId, String guildName, int guildJob, String guildIcon) {
        if (null == this.guild) {
            this.guild = new GuildPO();
        }
        if (null == this.member) {
            this.member = new GuildMemberPO();
        }
        this.guild.id = guildId;
        this.guild.name = guildName;
        this.guild.icon = guildIcon;
        this.guild.job = guildJob;
        this.member.job = guildJob;
    }


    public int calAuctionBonus() {
        if (StringUtils.isEmpty(getGuildId())) {
            return 0;
        }
        Set<String> ids = GuildUtil.getGuildMemberIdList(getGuildId());
        if (ids == null || ids.isEmpty()) {
            return 0;
        }

        return Math.min(GlobalConfig.Auction_MaxBonus, this.guild.auctionBonus / ids.size());
    }

    public void addAuctionBonus(int value) {
        if (this.guild == null) {
            return;
        }


        value = value * GlobalConfig.Auction_GuildTaxation / 100;

        int before = this.guild.auctionBonus;
        this.guild.auctionBonus += value;
        int after = this.guild.auctionBonus;
        Out.info(new Object[]{"add auction bonus. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(value), ",after=", Integer.valueOf(after)});
    }
}


