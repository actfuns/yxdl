package com.wanniu.game.playerData;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.DungeonMapCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.UpLevelEventCO;
import com.wanniu.game.data.ext.UpLevelExpExt;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pomelo.area.PlayerHandler;

public class PlayerBaseDataManager
        extends ModuleManager {
    public WNPlayer player;
    public PlayerPO baseData;

    public PlayerBaseDataManager(WNPlayer player, PlayerPO baseData) {
        this.player = player;
        this.baseData = baseData;
        player.player = baseData;
        this.curLevelData = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
        this.curMaxLv = PlayerUtil.initCurMaxLv(this.baseData);
    }

    private int curMaxLv;
    private CharacterLevelCO curLevelData;

    public void addExp(long exp, Const.GOODS_CHANGE_TYPE from, int teamExp) {
        if (exp <= 0L) {
            return;
        }

        if (PlayerUtil.isRobot(this.baseData) &&
                this.baseData.level >= GWorld.ROBOT_MAX_LEVEL) {
            return;
        }


        long expAdd = 0L;
        if ((from == Const.GOODS_CHANGE_TYPE.monsterdrop || from == Const.GOODS_CHANGE_TYPE.task) && this.player.getLevel() >= GlobalConfig.WorldExp_ReqLevel) {
            String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
            if (StringUtil.isNotEmpty(playerId)) {
                PlayerPO result = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
                expAdd = (long) Math.ceil((this.player.leaderBoardManager.getExpAdd(result) / 100.0F * (float) exp));
            }
            exp += expAdd;
        }

        int preLevel = this.baseData.level;
        long preExp = this.baseData.exp;

        if (this.baseData.level == this.curMaxLv && this.baseData.exp >= this.curLevelData.experience) {


            int canUpgradeLv = PlayerUtil.calExpLv(this.baseData.exp, this.baseData.level);


            int punishRate = -GlobalConfig.Exp_RoleRank_Basic + (canUpgradeLv - this.curMaxLv) * GlobalConfig.Exp_RoleRank_PenaltyCoefficient;
            if (punishRate > 10000) {
                punishRate = 10000;
            }
            long realAddExp = exp * (10000 - punishRate) / 10000L;
            expAdd = expAdd * (10000 - punishRate) / 10000L;
            this.baseData.exp += realAddExp;
            if (this.baseData.exp >= 2147483647L) {
                this.baseData.exp = 2147483647L;
            }
        } else {

            this.baseData.exp += exp;
            if (this.baseData.exp >= 2147483647L) {
                this.baseData.exp = 2147483647L;
            }
            if (this.baseData.exp >= this.curLevelData.experience && this.baseData.level < this.curMaxLv) {
                _upgrade(preExp);


                long expGot = this.player.player.exp - preExp;
                for (int lv = preLevel; lv < this.baseData.level; lv++) {
                    expGot += ((CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(lv))).experience;
                }
                String addStr = LangService.getValue("GAIN_EXP1");
                addStr = addStr.replace("%s", String.valueOf(expGot));
                this.player.sendSysTip(addStr, Const.TipsType.LEFTDWON);
                if (expAdd > 0L) {
                    this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.EXP, String.valueOf(expGot), Long.valueOf(expAdd), null);
                } else {
                    this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.EXP, String.valueOf(expGot), null, null);
                }
            }
        }

        if (teamExp > 0) {
            this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.TEAM_EXP, String.valueOf(exp), String.valueOf(teamExp), null);
        }

        if (expAdd > 0L && this.baseData.exp - preExp > 0L) {
            this.player.pushDynamicData("exp", this.player.player.exp + ":" + expAdd);
        } else {
            this.player.pushDynamicData("exp", Long.valueOf(this.player.player.exp));
        }

        BILogService.getInstance().recordNum(this.player, Const.BiLogType.Exp, exp, from);
    }

    public void _upgrade(long preExp) {
        long[] finalData = PlayerUtil.getLevelByExp(this.baseData.exp, this.baseData.level, this.curMaxLv);
        int finalLevel = (int) finalData[1];
        upgrade(finalLevel, finalData[0]);
    }


    public void upgrade(int level, long exp) {
        if (PlayerUtil.isRobot(this.baseData)) {
            level = Math.min(GWorld.ROBOT_MAX_LEVEL, level);
        }

        if (this.baseData.level < level) {
            this.baseData.level = level;
            this.baseData.exp = exp;
            Out.info(new Object[]{"角色升级 playerId=", this.baseData.id, ",name=", this.baseData.name, ",level=", Integer.valueOf(this.baseData.level)});
            if (!this.player.isRobot()) {
                this.player.rankManager.onEvent(RankType.LEVEL, new Object[]{Integer.valueOf(this.player.getLevel()), Integer.valueOf(this.player.getUpOrder())});

                LogReportService.getInstance().ansycReportUpgrade(this.player);
                BILogService.getInstance().ansycReportPlayerData(this.player.getSession(), this.player.getPlayer(), true);
            }
        }

        CharacterLevelCO levelData = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
        this.player.player.needExp = levelData.experience;
        this.curLevelData = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(this.baseData.level));
        this.player.onUpgrade();
        this.player.pushDynamicData(Utils.ofMap(new Object[]{"level", Integer.valueOf(this.player.player.level), "needExp", Integer.valueOf(this.player.player.needExp)}));
    }


    public void sendIconMsgType() {
        String result = upgradeClass(true);
        if (result == null) {
            CommonUtil.sendIconMsgType(Const.MESSAGE_TYPE.upLevel_up, this.player.getId());
            updateSuperScript();
        }
    }


    public void addClassExp(int exp, Const.GOODS_CHANGE_TYPE from) {
        long expAdd = 0L;
        if (this.player.getLevel() >= GlobalConfig.WorldExp_ReqLevel && Const.GOODS_CHANGE_TYPE.use != from) {
            String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
            if (StringUtil.isNotEmpty(playerId)) {
                PlayerPO result = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
                expAdd = (long) Math.ceil((this.player.leaderBoardManager.getExpAdd(result) / 100.0F * exp));
            }
            exp = (int) (exp + expAdd);
        }

        this.baseData.classExp += exp;
        Out.info(new Object[]{"add classexp. playerId=", this.player.getId(), ",classexp=", Integer.valueOf(this.baseData.classExp), ",value=", Integer.valueOf(exp), ",from=", Integer.valueOf((from == null) ? 0 : from.value)});

        this.player.pushDynamicData("classExp", Integer.valueOf(this.player.player.classExp));
        sendIconMsgType();
    }


    public String upgradeClass() {
        return upgradeClass(false);
    }

    public UpLevelExpExt getNextUpLevelExp() {
        int upOrderId_next = this.baseData.upOrder + 1;
        UpLevelExpExt prop_next = (UpLevelExpExt) GameData.UpLevelExps.get(Integer.valueOf(upOrderId_next));
        return prop_next;
    }


    public String upgradeClass(boolean justCheck) {
        if (this.baseData.upOrder >= PlayerUtil.maxUpOrder)
            return LangService.getValue("UPGRADE_MAX_LEVEL");
        UpLevelExpExt prop_next = getNextUpLevelExp();
        int classID_next = prop_next.classID;

        if (prop_next.reqClassExp > this.baseData.classExp)
            return LangService.getValue("UPGRADE_NEED_UPLEVELEXP");
        if (prop_next.reqLevel > this.baseData.level) {

            if (this.player.getLevel() >= GlobalConfig.Role_LevelLimit) {
                return LangService.getValue("UPGRADE_MAX_LEVEL");
            }
            return LangService.getValue("UPGRADE_NEED_LEVEL").replace("{x}", "" + prop_next.reqLevel);
        }

        if (StringUtil.isNotEmpty(prop_next.reqEvents)) {
            String result = checkClassEvent(prop_next);
            if (result != null)
                return result;
        }
        if (justCheck) {
            return null;
        }
        this.baseData.classExp -= prop_next.reqClassExp;
        this.baseData.upOrder++;
        this.baseData.upLevel = classID_next;
        this.player.pushDynamicData(Utils.ofMap(new Object[]{"classExp", Integer.valueOf(this.player.player.classExp), "upOrder", Integer.valueOf(this.player.player.upOrder)}));
        this.curMaxLv = PlayerUtil.initCurMaxLv(this.baseData);
        this.player.onClassUpgrade();

        Out.info(new Object[]{"玩家进阶成功 playerId=", this.player.getId(), ", name=", this.player.getName(), ", upOrder=", Integer.valueOf(this.baseData.upOrder)});

        int oldLevel = this.baseData.level;
        if (this.baseData.exp >= this.curLevelData.experience && this.baseData.level < this.curMaxLv) {
            long preExp = this.baseData.exp;
            _upgrade(preExp);
        }
        if (this.baseData.level == oldLevel && this.player.rankManager != null) {


            PlayerRankInfoPO info = this.player.rankManager.getRankPO();
            if (info != null) {
                info.setUpOrder(this.baseData.upOrder);
            }
        }


        this.player.taskManager.dealTaskEvent(Const.TaskType.ROLE_UPGRADE, "", this.baseData.upLevel);


        this.player.achievementManager.playerRankChange(this.baseData.upLevel);

        return null;
    }


    public String checkClassEvent(UpLevelExpExt prop_next) {
        if (StringUtil.isNotEmpty(prop_next.reqEvents)) {
            int reqEvents = Integer.parseInt(prop_next.reqEvents);
            UpLevelEventCO event = (UpLevelEventCO) GameData.UpLevelEvents.get(Integer.valueOf(reqEvents));
            if (event == null)
                return null;
            int eventPar = event.eventPar;
            DungeonMapCO dungeonMap = (DungeonMapCO) GameData.DungeonMaps.get(Integer.valueOf(eventPar));
            if (dungeonMap == null) {
                return null;
            }
            int templateID = dungeonMap.templateID;
            int hardModel = dungeonMap.hardModel;
            int hard = this.player.fightLevelManager.getCurrHard(templateID);
            if (hard > hardModel) {
                return null;
            }
            Const.DungeonHardModel dhm = Const.DungeonHardModel.getE(hardModel);
            if (dhm == null)
                return null;
            StringBuffer hardModel_str = new StringBuffer("<f color='");
            hardModel_str.append(dhm.color);
            hardModel_str.append("'>");
            hardModel_str.append(dhm.desc).append("</f>");

            StringBuffer dungeonName = new StringBuffer("<f color='");
            dungeonName.append(dhm.color);
            dungeonName.append("'>");
            dungeonName.append(dungeonMap.name).append("</f>");
            return LangService.getValue("UPGRADE_NEED_OPTION").replace("{HardModel}", hardModel_str.toString()).replace("{Dungeon}", dungeonName.toString());
        }

        return null;
    }


    public void addPrestige(int prestige, Const.GOODS_CHANGE_TYPE from) {
        if (prestige >= 0) {
            this.baseData.prestige += prestige;
            if (this.baseData.prestige >= Integer.MAX_VALUE) {
                this.baseData.prestige = Integer.MAX_VALUE;
            }
        }
    }


    public boolean addFriendly(int num) {
        if (num > 0) {
            this.baseData.friendly += num;
            if (this.baseData.friendly >= Integer.MAX_VALUE) {
                this.baseData.friendly = Integer.MAX_VALUE;
            }
            return true;
        }
        return false;
    }


    public boolean costFriendly(int num) {
        if (num <= 0 || this.baseData.friendly < num) {
            return false;
        }
        this.baseData.friendly -= num;
        return true;
    }


    public boolean enoughFriendly(int num) {
        return (this.baseData.friendly >= num);
    }


    public int getPawnGold() {
        return this.baseData.pawnGold;
    }


    public boolean enoughPawnGold(int num) {
        return (this.baseData.pawnGold >= num);
    }


    public boolean addPawnGold(int num) {
        if (num > 0) {
            this.baseData.pawnGold += num;
            if (this.baseData.pawnGold >= Integer.MAX_VALUE) {
                this.baseData.pawnGold = Integer.MAX_VALUE;
            }
            return true;
        }
        return false;
    }


    public boolean costPawnGold(int num) {
        if (num < 0 || this.baseData.pawnGold < num) {
            return false;
        }
        this.baseData.pawnGold -= num;
        return true;
    }


    public boolean enoughTreasurePoint(int num) {
        return (this.baseData.treasurePoint >= num);
    }


    public boolean addTreasurePoint(int num) {
        if (num > 0) {
            this.baseData.treasurePoint += num;
            if (this.baseData.treasurePoint >= Integer.MAX_VALUE) {
                this.baseData.treasurePoint = Integer.MAX_VALUE;
            }
            return true;
        }
        return false;
    }


    public boolean costTreasurePoint(int num) {
        if (num < 0 || this.baseData.treasurePoint < num) {
            return false;
        }
        this.baseData.treasurePoint -= num;
        return true;
    }


    public boolean addGuildPoint(int num) {
        if (num > 0) {
            this.baseData.guildpoint += num;
            if (this.baseData.guildpoint >= Integer.MAX_VALUE) {
                this.baseData.guildpoint = Integer.MAX_VALUE;
            }
            return true;
        }
        return false;
    }


    public void setLoginTime(Date loginTime) {
        this.baseData.loginTime = loginTime;
    }


    public void setLogoutTime(Date logoutTime) {
        this.baseData.logoutTime = logoutTime;
    }


    public int getPrestige() {
        return this.baseData.prestige;
    }


    public void modifyVip(int vip, int lastTime) {
        Const.VipType vt = Const.VipType.getE(vip);

        getVip();
        if (vt == null) {
            return;
        }


        if (vt == Const.VipType.month) {
            if (this.baseData.vip == Const.VipType.forever.value || this.baseData.vip == Const.VipType.sb_double.value) {
                this.baseData.vip = Const.VipType.sb_double.value;
            } else {
                this.baseData.vip = vt.value;
            }

        } else if (vt == Const.VipType.forever) {
            if (this.baseData.vip == Const.VipType.month.value || this.baseData.vip == Const.VipType.sb_double.value) {
                this.baseData.vip = Const.VipType.sb_double.value;
            } else {
                this.baseData.vip = vt.value;
            }
        }


        if (vt == Const.VipType.month) {
            CardCO cardProp = (CardCO) GameData.Cards.get(Integer.valueOf(vip));
            Calendar c = Calendar.getInstance();
            if (this.baseData.vipEndTime != null && this.baseData.vipEndTime.after(Calendar.getInstance().getTime())) {
                c.setTime(this.baseData.vipEndTime);
                c.add(5, cardProp.lastTime);
                this.baseData.vipEndTime = c.getTime();
            } else {
                c.add(5, cardProp.lastTime);
                this.baseData.vipEndTime = c.getTime();
            }
        }
    }


    public int getVip() {
        if ((this.baseData.vip == Const.VipType.month.value || this.baseData.vip == Const.VipType.sb_double.value) &&
                this.baseData.vipEndTime.before(Calendar.getInstance().getTime())) {
            this.baseData.vipEndTime = null;
            if (this.baseData.vip == Const.VipType.month.value) {
                this.baseData.vip = Const.VipType.none.value;
            } else {
                this.baseData.vip = Const.VipType.forever.value;
            }
        }
        return this.baseData.vip;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
                sendIconMsgType();
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.BASE_DATA;
    }

    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        UpLevelExpExt prop_next = getNextUpLevelExp();
        String flag = checkClassEvent(prop_next);
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();

        data.setType(Const.SUPERSCRIPT_TYPE.UPLEVEL.getValue());
        data.setNumber((flag == null) ? 1 : 0);

        list.add(data.build());
        return list;
    }


    public final void updateSuperScript() {
        if (this.player != null) {
            this.player.updateSuperScriptList(getSuperScript());
        }
    }

    public void updateLvChangeTime(Date time) {
        this.baseData.lvChangeTime = time;
    }

    public void updateFightTime(Date time) {
        this.baseData.fightChangeTime = time;
    }

    public Date getLvChangeTime() {
        return this.baseData.lvChangeTime;
    }

    public Date getFightChangeTime() {
        return this.baseData.fightChangeTime;
    }


    public PomeloResponse exchange(int type) {
        if (this.player.getLevel() < GlobalConfig.Exchange_OpenLV) {
            Out.warn(new Object[]{"未满级也想兑换属性吗？playerId=", this.player.getId()});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        switch (type) {
            case 1:
                return exchangeByExp();
            case 2:
                return exchangeByUpexp();
            case 3:
                return exchangeByGold();
        }
        return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
    }


    private PomeloResponse exchangeByGold() {
        int needGold = GlobalConfig.Exchange_Gold;

        if (!this.player.moneyManager.costGold(needGold, Const.GOODS_CHANGE_TYPE.EXCHANGE_PROPARTY)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
        }

        (this.player.getPlayer()).exchangCount++;

        Out.info(new Object[]{"银两兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount)});


        this.player.onExchangeProparty();


        return null;
    }

    private PomeloResponse exchangeByUpexp() {
        int needUpExp = GlobalConfig.Exchange_UpExp;
        if ((this.player.getPlayer()).classExp < needUpExp) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAER_EXCHANGE_UPEXP_NOT_ENOUGH"));
        }

        (this.player.getPlayer()).classExp -= needUpExp;
        (this.player.getPlayer()).exchangCount++;
        Out.info(new Object[]{"修为兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount)});
        this.player.pushDynamicData("classExp", Integer.valueOf(this.player.player.classExp));


        this.player.onExchangeProparty();


        return null;
    }

    private PomeloResponse exchangeByExp() {
        int needExp = GlobalConfig.Exchange_Exp;
        if (this.player.getExp() < needExp) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAER_EXCHANGE_EXP_NOT_ENOUGH"));
        }

        (this.player.getPlayer()).exp -= needExp;
        (this.player.getPlayer()).exchangCount++;
        Out.info(new Object[]{"经验兑换属性成功. playerId=", this.player.getId(), ",count=", Integer.valueOf((this.player.getPlayer()).exchangCount)});
        this.player.pushDynamicData("exp", Long.valueOf(this.player.player.exp));


        this.player.onExchangeProparty();


        return null;
    }
}


