package com.wanniu.game.leaderBoard;

import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.LeaderBoardPlayerPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.request.leaderboard.WorShipHandler;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pomelo.area.LeaderBoardHandler;
import pomelo.area.PlayerHandler;


public class LeaderBoardManager {
    public WNPlayer player;
    public LeaderBoardPlayerPO po;

    public LeaderBoardManager(WNPlayer player) {
        this.player = player;
        this.po = (LeaderBoardPlayerPO) PlayerPOManager.findPO(ConstsTR.player_leaderboardTR, this.player.getId(), LeaderBoardPlayerPO.class);
    }

    public LeaderBoardPlayerPO toJson4Serialize() {
        return this.po;
    }

    public WorShipHandler.WorshipRes worShip(WNPlayer player, int type) {
        List<String> awards = new ArrayList<>();
        WorShipHandler.WorshipRes data = new WorShipHandler.WorshipRes(true, "", awards);

        int reqLevel = GlobalConfig.WorldExp_ReqLevel;

        if (player.getLevel() < reqLevel) {

            data.result = false;
            data.info = LangService.getValue("REWARD_LEVEL_NOT_ENOUGH");
            return data;
        }

        if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {

            this.po.worShipTimes = 0;
            this.po.worShipDiamondTimes = 0;
        }

        int worShipTimeMax = GlobalConfig.WorldExp_Admire_MaxCount;

        if (this.po.worShipTimes >= worShipTimeMax) {

            data.result = false;
            data.info = LangService.getValue("WORLDEXP_NOT_TIME");
            return data;
        }

        int addGold = 0;

        if (type == 0) {

            addGold = GlobalConfig.WorldExp_Admire_AddGold;
        } else {
            addGold = GlobalConfig.WorldExp_DiamondAdmire_AddGold;

            int costDiamond = GlobalConfig.WorldExp_DiamondAdmire_Price;

            if (player.moneyManager.getDiamond() < costDiamond) {
                player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.PREPAID, null, null, null);
                data.result = false;
                return data;
            }

            player.moneyManager.costDiamond(costDiamond, Const.GOODS_CHANGE_TYPE.leaderBoard);


            this.po.worShipDiamondTimes++;
        }

        this.po.worShipTimes++;
        this.po.worShipTime = new Date();
        Out.info(new Object[]{"膜拜大神 playerId=", player.getId(), ",type=", Integer.valueOf(type)});
        player.moneyManager.addGold(addGold, Const.GOODS_CHANGE_TYPE.leaderBoard);
        BILogService.getInstance().ansycReportLeaderBoard(player.getPlayer(), type);

        if (this.po.worShipTimes == worShipTimeMax) {

            String itemCode = GlobalConfig.WorldExp_NormalChest_ItemCode;

            data.awards.add(itemCode);

            if (this.player.bag.testAddCodeItem(itemCode, 1, Const.ForceType.DEFAULT, true)) {

                this.player.bag.addCodeItem(itemCode, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.leaderBoard);
            } else {
                MailSysData mailData = new MailSysData("Worldexp_reward");
                mailData.attachments = new ArrayList();
                MailData.Attachment attachment = new MailData.Attachment();
                attachment.itemCode = itemCode;
                attachment.itemNum = 1;
                mailData.attachments.add(attachment);
                MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.leaderBoard);
            }

            if (this.po.worShipDiamondTimes == worShipTimeMax) {

                int randValue = RandomUtil.getInt(1, 10000);

                if (randValue <= GlobalConfig.WorldExp_SuperChest_Chance) {

                    itemCode = GlobalConfig.WorldExp_SuperChest_ItemCode;

                    data.awards.add(itemCode);

                    if (this.player.bag.testAddCodeItem(itemCode, 1, Const.ForceType.DEFAULT, true)) {

                        this.player.bag.addCodeItem(itemCode, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.leaderBoard);
                    } else {
                        MailSysData mailData = new MailSysData("Worldexp_reward");
                        mailData.attachments = new ArrayList();
                        MailData.Attachment attachment = new MailData.Attachment();
                        attachment.itemCode = itemCode;
                        attachment.itemNum = 1;
                        mailData.attachments.add(attachment);
                        MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.leaderBoard);
                    }

                    String playerName = MessageUtil.getPlayerNameColor(this.player.getName(), this.player.getPro());
                    String msg = LangService.getValue("WORLDEXP_NEWS");

                    msg = msg.replace("{playerName}", playerName);

                    MessageUtil.sendRollChat(player.getLogicServerId(), msg, Const.CHAT_SCOPE.SYSTEM);
                }
            }
        }

        updateSuperScript();


        this.player.dailyActivityMgr.onEvent(Const.DailyType.WORLD_LEVEL, "0", 1);

        this.player.achievementManager.onWorldLevelTimes();
        return data;
    }

    public LeaderBoardHandler.WorldLevelInfo worldLevelInfo(WNPlayer player) {
        LeaderBoardHandler.WorldLevelInfo.Builder data = LeaderBoardHandler.WorldLevelInfo.newBuilder();

        if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {
            this.po.worShipTimes = 0;
            this.po.worShipDiamondTimes = 0;
        }

        data.setWorShipTimes(this.po.worShipTimes);
        data.setMaxWorShipTimes(GlobalConfig.WorldExp_Admire_MaxCount);

        String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
        if (StringUtil.isEmpty(playerId)) {
            playerId = player.getId();
            Out.warn(new Object[]{"获取排行榜第一名时没有值"});
        }
        PlayerPO result = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);

        data.setWorldLevelId(playerId);
        data.setWorldLevelName(result.name);
        data.setWorldLevel(result.level);
        data.setWorldUpLevel(result.upOrder);

        data.addAllAvatars(PlayerUtil.getBattlerServerAvatar(playerId));
        data.setWorldLevelPro(result.pro);

        data.setAddExp(getExpAdd(result));

        GuildPO guild = GuildUtil.getPlayerGuild(playerId);
        data.setRank1StGuildName((guild != null) ? guild.name : "");
        data.setRank1StFight(result.fightPower);
        return data.build();
    }


    public int getExpAdd(PlayerPO result) {
        if (result == null) {
            return 0;
        }
        int expAdd = 0;

        int ratioPerLevel = GlobalConfig.WorldExp_RatioPerLevel;
        int maxExpRatio = GlobalConfig.WorldExp_MaxExpRatio;

        int levelDiff = result.level - this.player.getLevel();

        if (levelDiff > GlobalConfig.WorldExp_MaxLevelValue) {
            expAdd += ratioPerLevel * levelDiff;
        }

        if (levelDiff != 0 &&
                expAdd > maxExpRatio) {
            expAdd = maxExpRatio;
        }


        return expAdd;
    }

    public void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> data = getSuperScript();
        this.player.updateSuperScriptList(data);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> data = new ArrayList<>();

        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.WORLD_EXP.getValue())) {
            PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
            script.setType(Const.SUPERSCRIPT_TYPE.WORLD_LEVEL.getValue());
            script.setNumber(0);
            data.add(script.build());
        } else {
            if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {

                this.po.worShipTimes = 0;
                this.po.worShipDiamondTimes = 0;
            }

            int count = (GlobalConfig.WorldExp_Admire_MaxCount > this.po.worShipTimes) ? 1 : 0;

            PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
            script.setType(Const.SUPERSCRIPT_TYPE.WORLD_LEVEL.getValue());
            script.setNumber(count);
            data.add(script.build());
        }

        return data;
    }
}


