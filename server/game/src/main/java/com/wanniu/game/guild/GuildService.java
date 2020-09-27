package com.wanniu.game.guild;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.BlessLevelCO;
import com.wanniu.game.data.GBuffCO;
import com.wanniu.game.data.GDungeonCO;
import com.wanniu.game.data.GDungeonMapCO;
import com.wanniu.game.data.GDungeonRankCO;
import com.wanniu.game.data.GTechnologyLevelCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildBuildingCO;
import com.wanniu.game.data.GuildContributeCO;
import com.wanniu.game.data.GuildLevelCO;
import com.wanniu.game.data.GuildPositionCO;
import com.wanniu.game.data.WareHouseLevelCO;
import com.wanniu.game.data.WareHouseValueCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.BlessLevelExt;
import com.wanniu.game.data.ext.GBuffExt;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.data.ext.RankRewardExt;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.guidDepot.GuildCond;
import com.wanniu.game.guild.guidDepot.GuildDepot;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.guild.guildBless.GuildBless;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.guild.guildBoss.GuildBossCenter;
import com.wanniu.game.guild.guildDungeon.GuildDiceAwardResult;
import com.wanniu.game.guild.guildDungeon.GuildDungeonAward;
import com.wanniu.game.guild.guildDungeon.GuildDungeonPlayerInfo;
import com.wanniu.game.guild.guildDungeon.GuildDungeonRecord;
import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
import com.wanniu.game.guild.guildDungeon.GuildDungeonThrowInfo;
import com.wanniu.game.guild.guildDungeon.OpenGuildDungeonResult;
import com.wanniu.game.guild.guildImpeach.GuildImpeachCenter;
import com.wanniu.game.guild.guildImpeach.GuildImpeachData;
import com.wanniu.game.guild.guildTech.GuildTech;
import com.wanniu.game.guild.po.GuildBlessPO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildApplyPO;
import com.wanniu.game.poes.GuildDungeonPO;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.PlayerPOManager;
import io.netty.util.internal.StringUtil;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import pomelo.area.GuildHandler;
import pomelo.guild.GuildManagerHandler;


public class GuildService {
    public static void notifySomePlayerRefreshGuild(Set<String> playerIds, GuildMsg data, String exceptId) {
        for (String playerId : playerIds) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (null == player || playerId.equals(exceptId)) {
                continue;
            }
            player.guildManager.onNotifyRefreshGuild(data);
        }
    }

    public static void notifyAllMemberRefreshGuild(String guildId, GuildMsg data, String exceptId) {
        Set<String> playerIds = GuildServiceCenter.getInstance().getGuildMemberIdList(guildId);
        if (null == playerIds)
            return;
        notifySomePlayerRefreshGuild(playerIds, data, exceptId);
    }


    public static GuildResult createGuild(WNPlayer player, JSONObject param) {
        GuildResult ret = new GuildResult();
        GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
        if (null == prop) {
            ret.result = -1;
            return ret;
        }

        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        if (guildServiceMgr.isInGuild(player.getId())) {
            ret.result = -2;
            ret.des = "已入会";
            return ret;
        }

        if (StringUtil.isNullOrEmpty(param.getString("name"))) {

            ret.result = -11;
            ret.des = LangService.getValue("GUILD_NAME_EMPTY");
            return ret;
        }

        boolean isNameExist = guildServiceMgr.existGuildName(GWorld.__SERVER_ID, param.getString("name"));
        if (isNameExist) {
            ret.result = 1;
            ret.des = "名字已存在";
            return ret;
        }

        String guildId = UUID.randomUUID().toString();
        GuildPO guild = new GuildPO();
        guild.id = guildId;
        guild.logicServerId = player.getLogicServerId();
        guild.icon = param.getString("icon");
        guild.name = param.getString("name");
        guild.presidentId = player.getId();
        guild.presidentPro = player.getPro();
        guild.presidentName = player.getName();


        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.GUILD.getValue());
        guild.level = buildProp.minLv;
        guild.createTime = new Date();
        guild.qqGroup = param.getString("qqGroup");
        guild.fund = 0L;
        guild.sumFund = 0L;
        guild.exp = 0L;

        guild.entryLevel = prop.joinLv;
        guild.entryUpLevel = 0;
        guild.guildMode = Const.GuildMode.AUTO_MODE.getValue();
        guild.notice = prop.defaultNote;
        guild.changeNameTime = new Date();
        guild.kickCount = 0;
        guild.kickTime = new Date();
        guild.officeNames = GuildUtil.getJobNameMap();
        guild.allBlobData = new GuildAllBlob();

        GuildMemberPO member = player.toJSON4GuildMember();
        member.guildId = guildId;

        member.job = Const.GuildJob.PRESIDENT.getValue();
        member.createTime = new Date();

        guildServiceMgr.addGuild(guild);
        guildServiceMgr.addMember(member);
        guildServiceMgr.removeAllPlayerApplyAsync(player.getId());

        GuildDepotCenter.getInstance().createDepot(guildId, player.getLogicServerId());
        GuildBlessCenter.getInstance().createBless(guildId, player.getLogicServerId());
        guildServiceMgr.refreshGuildTopInfo(guildId);

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.CREATE_GUILD.getValue();
        record.role1.pro = guild.presidentPro;
        record.role1.name = guild.presidentName;

        guildServiceMgr.addGuildRecord(guild.id, record);

        ret.result = 0;
        ret.id = guildId;
        return ret;
    }

    public static String getGuildId(String playerId) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        return guildManager.getGuildId(playerId);
    }

    public static GuildResult joinGuild(WNPlayer player, String guildId) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        boolean isInGuild = guildManager.isInGuild(player.getId());
        if (isInGuild) {
            ret.result = -2;
            ret.des = "已入会";
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (null == settingProp) {
            ret.result = -1;
            ret.des = "配置错误";
            return ret;
        }

        List<GuildApplyPO> applyList = guildManager.getPlayerApplyList(player.getId());
        if (null != applyList && applyList.size() >= settingProp.applyMax) {
            ret.result = 1;
            ret.des = "申请数量已达上限";
            return ret;
        }

        for (GuildApplyPO apply : applyList) {
            if (apply.id == guildId) {
                ret.result = 4;
                ret.des = "已申请";
                return ret;
            }
        }


        GuildPO guild = guildManager.getGuild(guildId);
        if (null == guild) {
            ret.result = 2;
            ret.des = "公会不存在";
            return ret;
        }

        GuildLevelCO guildLevelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
        if (null == guildLevelProp) {
            ret.result = -1;
            ret.des = "配置错误";
            return ret;
        }

        Set<String> memberList = guildManager.getGuildMemberIdList(guildId);
        if (memberList.size() >= guildLevelProp.member) {
            ret.result = 3;
            ret.des = "公会人数已满";
            return ret;
        }

        if (guild.guildMode == Const.GuildMode.AUTO_MODE.getValue()) {
            GuildMemberPO newMember = player.toJSON4GuildMember();
            newMember.guildId = guildId;
            newMember.job = Const.GuildJob.MEMBER.getValue();
            newMember.createTime = new Date();
            newMember.lastContributeValue = 0L;

            player.guildManager.setGuildJobInfo(guildId, guild.name, Const.GuildJob.MEMBER.getValue(), guild.icon);


            GuildRecordData record = new GuildRecordData();
            record.type = Const.GuildRecord.JOIN.getValue();
            record.role1 = new RoleInfo();
            record.role1.pro = newMember.pro;
            record.role1.name = newMember.name;
            guildManager.addGuildRecord(guild.id, record);
            guildManager.addMember(newMember);
            guildManager.removeAllPlayerApplyAsync(newMember.playerId);


            Set<String> ids = new HashSet<>();
            ids.add(newMember.playerId);

            GuildMsg.JoinGuildBlessMsg msgData = new GuildMsg.JoinGuildBlessMsg();
            msgData.blessData = GuildBlessCenter.getInstance().getBlessData(guild.id);

            GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOIN_PUSH.getValue(), msgData);
            msg.data = msgData;

            notifySomePlayerRefreshGuild(ids, msg, null);

            guildManager.refreshGuildTopInfo(guildId);
            ret.result = 0;
            ret.joined = true;
            ret.des = "加入成功";
            ret.memberId = player.getId();
            player.auctionManager.pushScript();
            return ret;
        }
        String applyId = UUID.randomUUID().toString();
        GuildApplyPO applyInfo = new GuildApplyPO();
        applyInfo.id = applyId;
        applyInfo.guildId = guildId;
        applyInfo.playerId = player.getId();
        applyInfo.createTime = new Date();

        guildManager.addApply(applyInfo);

        ret.result = 0;
        ret.joined = false;
        ret.des = "申请成功";
        return ret;
    }


    public static GuildResult dealApply(WNPlayer player, String applyId, int operate) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right3 == 0) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        int memberNum = guildManager.getGuildMemberCount(myGuild.id);
        GuildLevelCO guildLevelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
        if (operate != 0 && operate != 2 &&
                memberNum >= guildLevelProp.member) {
            ret.result = -3;
            ret.des = "公会人数已满";
            return ret;
        }


        List<GuildApplyPO> applyList = new ArrayList<>();
        if (operate >= 2) {
            applyList = guildManager.getGuildApplyList(myGuild.id);
            if (applyList.size() == 0) {
                ret.result = 0;
                ret.des = "success";
                return ret;
            }
        } else {
            GuildApplyPO oneApply = guildManager.getApply(applyId);
            if (null == oneApply) {
                ret.result = -4;
                ret.des = "申请已处理或已过期";
                return ret;
            }
            applyList.add(oneApply);
        }

        applyList.sort((applyA, applyB) -> {
            long detaTime = applyA.createTime.getTime() - applyB.createTime.getTime();

            return (detaTime > 0L) ? -1 : 1;
        });
        int leftHole = guildLevelProp.member - memberNum;
        int count = 0;

        GuildBlessPO data = GuildBlessCenter.getInstance().getBlessData(myGuild.id);
        String guildName = myGuild.name;
        for (int i = 0; i < applyList.size(); i++) {
            GuildApplyPO apply = applyList.get(i);
            if (operate == 0 || operate == 2) {
                MailSysData mailData = new MailSysData("Guild_apply_refused");
                mailData.replace = new HashMap<>();
                mailData.replace.put("guildName", guildName);
                MailUtil.getInstance().sendMailToOnePlayer(apply.playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
                guildManager.removeApply(apply.id);
            } else {
                if (count >= leftHole) {
                    break;
                }
                if (!guildManager.isInGuild(apply.playerId)) {


                    PlayerPO po = PlayerUtil.getPlayerBaseData(apply.playerId);
                    GuildMemberPO newMember = new GuildMemberPO();
                    newMember.playerId = apply.playerId;
                    newMember.name = po.name;
                    newMember.pro = po.pro;
                    newMember.guildId = apply.guildId;
                    newMember.job = Const.GuildJob.MEMBER.getValue();
                    newMember.createTime = new Date();
                    newMember.lastContributeTime = new Date(0L);
                    newMember.lastContributeValue = 0L;

                    WNPlayer newPlayer = PlayerUtil.getOnlinePlayer(apply.playerId);
                    if (null != newPlayer) {
                        newPlayer.guildManager.setGuildJobInfo(apply.guildId, guildName, Const.GuildJob.MEMBER.getValue(), myGuild.icon);
                    }


                    GuildRecordData record = new GuildRecordData();
                    record.type = Const.GuildRecord.JOIN.getValue();
                    record.role1.pro = newMember.pro;
                    record.role1.name = newMember.name;

                    guildManager.addGuildRecord(myGuild.id, record);
                    guildManager.addMember(newMember);
                    guildManager.removeAllPlayerApplyAsync(apply.playerId);
                    guildManager.removeApply(apply.id);

                    GuildMsg.JoinGuildBlessMsg msgData = new GuildMsg.JoinGuildBlessMsg();
                    msgData.blessData = data;
                    GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOIN_PUSH.getValue(), msgData);
                    Set<String> ids = new HashSet<>();
                    ids.add(newMember.playerId);

                    notifySomePlayerRefreshGuild(ids, msg, null);
                    count++;

                    MailSysData mailData = new MailSysData("Guild_join");
                    mailData.replace = new TreeMap<>();
                    mailData.replace.put("guildName", guildName);
                    MailUtil.getInstance().sendMailToOnePlayer(apply.playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
                }
            }
        }

        guildManager.refreshGuildTopInfo(myGuild.id);
        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult setGuildInfo(WNPlayer player, GuildSetData param) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -2;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO guild = guildManager.getGuild(myInfo.guildId);
        if (null == guild) {
            ret.result = -2;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right5 == 0) {
            ret.result = -3;
            ret.des = "没有权限";
        }

        if (param.entryUpLevel == 0) {
            guild.entryLevel = param.entryUpLevel;
        }
        if (param.entryLevel > 0) {
            guild.entryLevel = param.entryLevel;
        }
        if (param.guildMode > 0) {
            guild.guildMode = param.guildMode;
        }

        guildManager.saveGuild(guild);
        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult setGuildQQGroup(WNPlayer player, String qqGroup) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -3;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO guild = guildManager.getGuild(myInfo.guildId);
        if (null == guild) {
            ret.result = -3;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right7 == 0) {
            ret.result = -4;
            ret.des = "没有权限";
            return ret;
        }

        guild.qqGroup = qqGroup;
        guildManager.saveGuild(guild);
        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult exitGuild(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            return ret;
        }

        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = 1;
            return ret;
        }

        if (GuildBossCenter.getInstance().isOpen()) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_BOSS_IN");
            return ret;
        }

        if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
            int count = GuildUtil.getGuildMemberCount(myInfo.guildId);
            if (1 == count) {


                GuildRecordData guildRecordData = new GuildRecordData();
                guildRecordData.type = Const.GuildRecord.EXIT.getValue();
                guildRecordData.role1.pro = myInfo.pro;
                guildRecordData.role1.name = myInfo.name;
                guildManager.addGuildRecord(myGuild.id, guildRecordData);
                guildManager.removeMember(myInfo.playerId);

                guildManager.refreshGuildTopInfo(myGuild.id);
                ret.result = 0;
                ret.id = myGuild.id;
                ret.name = myGuild.name;

                GuildUtil.removeGuild(myGuild);
                return ret;
            }

            ret.result = 2;
            return ret;
        }


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.EXIT.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        guildManager.addGuildRecord(myGuild.id, record);
        guildManager.removeMember(myInfo.playerId);

        guildManager.refreshGuildTopInfo(myGuild.id);
        ret.result = 0;
        ret.id = myGuild.id;
        ret.name = myGuild.name;
        player.auctionManager.pushScript();
        return ret;
    }

    public static String get1stMemeberId(String guildId, String selfId) {
        List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildId);
        List<GuildHandler.MemberInfo> list = new ArrayList<>();
        for (GuildMemberPO member : memberList) {
            PlayerPO playerBase = PlayerUtil.getPlayerBaseData(member.playerId);
            if (null == playerBase) {
                continue;
            }

            GuildHandler.MemberInfo.Builder tempInfo = GuildHandler.MemberInfo.newBuilder();
            tempInfo.setPlayerId(member.playerId);
            tempInfo.setJob(member.job);
            tempInfo.setJoinTime(member.createTime.toString());
            tempInfo.setLevel(playerBase.level);
            tempInfo.setUpLevel(playerBase.upLevel);
            boolean isOnline = PlayerUtil.isOnline(member.playerId);
            tempInfo.setOnlineState(isOnline ? 1 : 0);
            tempInfo.setLastActiveTime((int) Math.ceil((playerBase.logoutTime.getTime() / Const.Time.Second.getValue())));
            if (!member.playerId.equals(selfId)) {
                list.add(tempInfo.build());
            }
        }

        list.sort((o1, o2) -> {
            GuildHandler.MemberInfo.Builder memberA = o1.toBuilder();


            GuildHandler.MemberInfo.Builder memberB = o1.toBuilder();


            return (memberA.getJob() != memberB.getJob()) ? ((memberA.getJob() < memberB.getJob()) ? -1 : 1) : ((memberA.getUpLevel() != memberB.getUpLevel()) ? ((memberA.getUpLevel() < memberB.getUpLevel()) ? 1 : -1) : ((memberA.getLevel() != memberB.getLevel()) ? ((memberA.getLevel() < memberB.getLevel()) ? 1 : -1) : memberB.getJoinTime().compareTo(memberA.getJoinTime())));
        });


        if (list.size() > 0) {
            return ((GuildHandler.MemberInfo) list.get(0)).getPlayerId();
        }

        return null;
    }


    public static void delRoleDelGuild(GuildPO guildPo, String playerId) {
        List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildPo.id);
        for (int i = 0; i < memberList.size(); i++) {
            delRoleClearMember(((GuildMemberPO) memberList.get(i)).playerId);
        }

        GuildServiceCenter.getInstance().delGuild(guildPo);
    }

    public static void delRoleClearMember(String playerId) {
        GuildServiceCenter guildServiceCenter = GuildServiceCenter.getInstance();
        GuildMemberPO delInfo = guildServiceCenter.getGuildMember(playerId);
        if (null == delInfo) {
            return;
        }

        guildServiceCenter.removeMember(delInfo.playerId);

        Set<String> ids = new HashSet<>();
        ids.add(delInfo.playerId);
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
        notifySomePlayerRefreshGuild(ids, msg, null);


        guildServiceCenter.refreshGuildTopInfo(delInfo.guildId);
    }


    public static GuildResult delRole(String playerId) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceCenter = GuildServiceCenter.getInstance();

        GuildPO guildPo = guildServiceCenter.getGuildByMemberId(playerId);
        if (null == guildPo) {

            ret.result = -1;
            List<GuildApplyPO> applies = guildServiceCenter.getPlayerApplyList(playerId);
            if (null != applies) {
                for (int i = applies.size() - 1; i >= 0; i--) {
                    guildServiceCenter.removeApply(((GuildApplyPO) applies.get(i)).id);
                }
            }
            return ret;
        }

        String newPresidentId = get1stMemeberId(guildPo.id, playerId);

        if (guildPo.presidentId.equals(playerId)) {
            if (null != newPresidentId) {

                transferGuildPresident(playerId, newPresidentId);
                delRoleClearMember(playerId);
            } else {
                delRoleDelGuild(guildPo, playerId);
            }
        } else {
            delRoleClearMember(playerId);
        }

        return ret;
    }

    public static GuildResult kickMember(WNPlayer player, String kickId) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        if (GuildBossCenter.getInstance().isOpen()) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_BOSS_IN");
            return ret;
        }

        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right4 == 0) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        GuildMemberPO kickInfo = guildManager.getGuildMember(kickId);
        if (null == kickInfo || !kickInfo.guildId.equals(myInfo.guildId)) {
            ret.result = -3;
            ret.des = "对方不是公会成员";
            return ret;
        }

        if (myInfo.job >= kickInfo.job) {
            ret.result = -4;
            ret.des = "无法踢除同等或更高级职位成员";
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (System.currentTimeMillis() - kickInfo.createTime.getTime() < settingProp.kickOutMs) {
            ret.result = -5;
            ret.des = "入会时间过短";
            return ret;
        }

        if (DateUtil.canRefreshData(5, myGuild.kickTime)) {
            myGuild.kickCount = 0;
        }

        if (myGuild.kickCount >= settingProp.fireNum) {
            ret.result = -6;
            ret.des = "今日踢人次数已用完";
            return ret;
        }

        myGuild.kickCount++;
        myGuild.kickTime = new Date();
        int leftKickNum = settingProp.fireNum - myGuild.kickCount;

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.KICK.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.role2.pro = kickInfo.pro;
        record.role2.name = kickInfo.name;
        guildManager.addGuildRecord(myGuild.id, record);
        guildManager.removeMember(kickInfo.playerId);


        Set<String> ids = new HashSet<>();
        ids.add(kickInfo.playerId);
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
        notifySomePlayerRefreshGuild(ids, msg, null);

        String guildName = myGuild.name;

        MailSysData mailData = new MailSysData("Guild_kick");
        mailData.replace = new HashMap<>();
        mailData.replace.put("guildName", guildName);
        MailUtil.getInstance().sendMailToOnePlayer(kickInfo.playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);

        ret.id = myGuild.id;
        ret.name = myGuild.name;
        ret.leftKickNum = leftKickNum;
        myGuild.modify = true;

        guildManager.refreshGuildTopInfo(myGuild.id);
        player.auctionManager.pushScript();
        return ret;
    }

    public static GuildResult upgradeGuildLevel(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
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

        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.GUILD.getValue());
        if (myGuild.level >= buildProp.maxLv) {
            ret.result = 1;
            ret.des = "公会等级已满";
            return ret;
        }
        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless || bless.level < levelProp.building1) {
            ret.result = 2;
            ret.needLevel = levelProp.building1;
            ret.des = "公会祈福等级不够";
            return ret;
        }

        if (bless.tech.level < levelProp.building2) {
            ret.result = 3;
            ret.des = "公会修行等级不够";
            ret.needLevel = levelProp.building2;
            return ret;
        }

        GuildDepot depot = GuildDepotCenter.getInstance().getDepot(myInfo.guildId);
        if (null == depot || depot.depotData.level < levelProp.building3) {
            ret.result = 4;
            ret.des = "公会仓库等级不够";
            ret.needLevel = levelProp.building3;
            return ret;
        }

        if (myGuild.exp < levelProp.exp) {
            ret.result = 5;
            ret.des = "公会威望不足";
            return ret;
        }

        long preExp = myGuild.exp;
        int preLevel = myGuild.level;
        myGuild.level++;
        myGuild.exp -= levelProp.exp;

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = Integer.toString(myGuild.level);

        guildManager.addGuildRecord(myGuild.id, record);

        GuildResult.UpgradeGuildLvData data = new GuildResult.UpgradeGuildLvData();
        data.preLevel = preLevel;
        data.preExp = preExp;
        data.exp = myGuild.exp;
        data.level = myGuild.level;
        data.costExp = levelProp.exp;

        ret.result = 0;
        ret.des = "sucess";
        ret.data = data;
        guildManager.refreshGuildTopInfo(myGuild.id);


        GCache.hset(ConstsTR.guildTR.value, myGuild.id, Utils.serialize(myGuild));
        return ret;
    }


    public static GuildResult changeGuildNotice(WNPlayer player, String notice) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right1 == 0) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        myGuild.notice = notice;
        guildManager.saveGuild(myGuild);

        ret.result = 0;
        ret.des = "success";
        ret.newNotice = notice;
        return ret;
    }

    public static GuildResult changeGuildName(WNPlayer player, String name) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right2 == 0) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        boolean isExist = guildManager.existGuildName(myGuild.logicServerId, name);
        if (isExist) {
            ret.result = 1;
            ret.des = "名字已存在";
        }

        Date now = new Date();
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        int dayCD = settingProp.changeNameCD;
        long cdOverTime = myGuild.changeNameTime.getTime() + (dayCD * Const.Time.Day.getValue());
        if (now.getTime() < cdOverTime) {
            ret.result = 2;
            ret.des = "更名cd中";
            return ret;
        }

        String oldName = myGuild.name;
        myGuild.name = name;
        myGuild.changeNameTime = now;

        GuildDao.GuildNameMap.remove(oldName);


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.GUILD_NAME.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = myGuild.name;
        guildManager.addGuildRecord(myGuild.id, record);
        guildManager.saveGuild(myGuild);


        GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
        msgData.guildName = myGuild.name;
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_CHANGE_NAME.getValue(), msgData);
        notifyAllMemberRefreshGuild(myGuild.id, msg, null);

        guildManager.refreshGuildTopInfo(myGuild.id);


        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult changeOfficeName(WNPlayer player, List<GuildHandler.OfficeName> officeNames) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        Map<Integer, String> tempNames = myGuild.officeNames;

        for (GuildHandler.OfficeName office : officeNames) {
            tempNames.put(Integer.valueOf(office.getJob()), office.getName());
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (Integer key : tempNames.keySet()) {
            String name = tempNames.get(key);
            if (countMap.containsKey(name)) {
                countMap.put(name, Integer.valueOf(((Integer) countMap.get(name)).intValue() + 1));
            } else {
                countMap.put(name, Integer.valueOf(1));
            }

            if (((Integer) countMap.get(name)).intValue() > 1) {
                ret.result = 1;
                ret.des = "名称重复";
                return ret;
            }
        }

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.OFFICE_NAME.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        guildManager.addGuildRecord(myGuild.id, record);
        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult contributeToGuild(WNPlayer player, int type, int times) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(type);
        int addFund = contributeProp.guildFunds * times;
        int addGuildPoints = contributeProp.guildPoints * times;
        int addExp = contributeProp.guildExp * times;

        Date refreshTime = myGuild.allBlobData.refreshTime;
        if (null == myGuild.allBlobData.refreshTime || DateUtil.canRefreshData(5, refreshTime)) {
            myGuild.allBlobData.todaySumFund = 0;
            myGuild.allBlobData.todaySumExp = 0;
            myGuild.allBlobData.refreshTime = new Date();
        }

        GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
        int todayLeftFund = Math.max(levelProp.maxFundsDay - myGuild.allBlobData.todaySumFund, 0);
        int todayLeftExp = Math.max(levelProp.maxExpDay - myGuild.allBlobData.todaySumExp, 0);
        int addRealFund = Math.min(todayLeftFund, addFund);
        int addRealExp = Math.min(todayLeftExp, addExp);

        myGuild.fund += addRealFund;
        myGuild.sumFund += addRealFund;
        myGuild.exp += addRealExp;
        myGuild.allBlobData.todaySumFund += addRealFund;
        myGuild.allBlobData.todaySumExp += addRealExp;
        if (null == myInfo.lastContributeTime) {
            myInfo.lastContributeTime = new Date();
        }

        if (!DateUtil.canRefreshData(5, myInfo.lastContributeTime)) {
            myInfo.lastContributeValue += addGuildPoints;
        } else {
            myInfo.lastContributeValue = addGuildPoints;
        }

        myInfo.lastContributeTime = new Date();

        guildManager.saveGuild(myGuild);
        guildManager.saveMember(myInfo);

        guildManager.refreshGuildTopInfo(myGuild.id);
        ret.result = 0;
        ret.des = "success";
        ret.addReadFund = addRealFund;
        ret.addRealExp = addRealExp;
        ret.id = myGuild.id;
        ret.name = myGuild.name;
        return ret;
    }


    public static boolean gmAddGuildMoney(String playerId, String moneyName, int num) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (myInfo == null) {
            return false;
        }
        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (myGuild == null) {
            return false;
        }
        if (moneyName.equals("fund")) {
            myGuild.fund += num;
            myGuild.sumFund += num;
        }
        if (moneyName.equals("exp")) {
            myGuild.exp += num;
        }
        guildManager.saveGuild(myGuild);
        return true;
    }

    public static GuildResult setMemberJob(WNPlayer player, String memberId, int job) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildMemberPO memberInfo = guildManager.getGuildMember(memberId);
        if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
            ret.result = -2;
            ret.des = "对方不是本公会成员";
            return ret;
        }
        if (myInfo.job > Const.GuildJob.ELDER.getValue()) {
            ret.result = -3;
            ret.des = "没有权限";
            return ret;
        }
        if (myInfo.job >= memberInfo.job || myInfo.job >= job) {
            ret.result = -4;
            ret.des = "无法设置比自己同等和高等级职位";
            return ret;
        }
        if (memberInfo.job == job) {
            ret.result = 0;
            ret.des = "success";
            return ret;
        }
        int jobCount = GuildUtil.getGuildMemberCountByJob(myGuild.id, job);
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(job);
        if (jobCount >= jobProp.setNumber) {
            ret.result = -5;
            ret.des = "该职位人数已满";
            return ret;
        }

        memberInfo.job = job;

        GuildRecordData.GuildRecordResult recordRet = new GuildRecordData.GuildRecordResult(memberInfo.job, (String) myGuild.officeNames.get(Integer.valueOf(memberInfo.job)));
        GuildRecordData record = new GuildRecordData(Const.GuildRecord.JOB.getValue(), myInfo, memberInfo, recordRet);
        guildManager.addGuildRecord(myGuild.id, record);
        guildManager.saveMember(memberInfo);

        TreeMap<String, String> map1 = new TreeMap<>();
        map1.put("guildposition", (String) myGuild.officeNames.get(Integer.valueOf(job)));


        WNPlayer memberPlayer = PlayerUtil.getOnlinePlayer(memberInfo.playerId);
        if (null != memberPlayer) {
            memberPlayer.guildManager.setGuildJobInfo(myGuild.id, myGuild.name, job, myGuild.icon);
        }
        Set<String> ids = new HashSet<>();
        ids.add(memberInfo.playerId);

        GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
        msgData.job = memberInfo.job;
        msgData.jobName = (String) myGuild.officeNames.get(Integer.valueOf(memberInfo.job));
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), msgData);
        notifySomePlayerRefreshGuild(ids, msg, null);

        ret.result = 0;
        ret.des = "success";
        return ret;
    }

    public static GuildResult transferGuildPresident(String playerId, String memberId) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (null == myInfo) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            ret.des = "没有权限";
            return ret;
        }

        GuildMemberPO memberInfo = guildManager.getGuildMember(memberId);
        if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
            ret.result = -3;
            ret.des = "对方不是本公会成员";
            return ret;
        }

        GuildResult.TransferGuildPresidentData retData = new GuildResult.TransferGuildPresidentData();
        String oldName = myGuild.presidentName;
        int oldPro = myGuild.presidentPro;

        retData.preId = myGuild.presidentId;
        retData.preName = oldName;

        myGuild.presidentId = memberInfo.playerId;
        myGuild.presidentPro = memberInfo.pro;
        myGuild.presidentName = memberInfo.name;

        retData.nowId = myGuild.presidentId;
        retData.nowName = myGuild.presidentName;

        memberInfo.job = Const.GuildJob.PRESIDENT.getValue();
        myInfo.job = Const.GuildJob.MEMBER.getValue();


        int type = Const.GuildRecord.TRANSFER_PRESIDENT.getValue();
        GuildRecordData record = new GuildRecordData(type, myInfo, memberInfo);
        guildManager.addGuildRecord(myGuild.id, record);

        guildManager.saveGuild(myGuild);
        guildManager.saveMember(myInfo);
        guildManager.saveMember(memberInfo);


        Map<String, String> map1 = new HashMap<>();
        map1.put("guildposition", (String) myGuild.officeNames.get(Integer.valueOf(myInfo.job)));
        GuildCommonUtil.sendMailSystenType(myInfo.playerId, "Guild_position", map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("guildposition", (String) myGuild.officeNames.get(Integer.valueOf(memberInfo.job)));
        GuildCommonUtil.sendMailSystenType(memberInfo.playerId, "Guild_position", map2);

        notifyGuildJobChange(myInfo, myGuild);
        notifyGuildJobChange(memberInfo, myGuild);

        GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
        if (null != impeach) {

            GuildRecordData record1 = new GuildRecordData();
            record1.type = Const.GuildRecord.TRANSFER_IMPEACH_BECOME_INVALID.getValue();
            record1.role1.pro = impeach.sponsor.pro;
            record1.role2.name = impeach.sponsor.name;
            record1.role2.pro = oldPro;
            record1.role2.name = oldName;
            record1.result.v2 = Integer.toString(impeach.playerIds.size());
            guildManager.addGuildRecord(myGuild.id, record1);

            GuildImpeachCenter.getInstance().removeGuildImpeachByData(impeach);
        }
        retData.newJob = myInfo.job;
        ret.result = 0;
        ret.des = "success";
        ret.data = retData;
        return ret;
    }

    public static void notifyGuildJobChange(GuildMemberPO player, GuildPO myGuild) {
        GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
        msgData.job = player.job;
        msgData.jobName = (String) myGuild.officeNames.get(Integer.valueOf(player.job));
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), msgData);
        notifySomePlayerRefreshGuild(new HashSet<>(Arrays.asList(new String[]{player.playerId}, )), msg, null);
    }

    public static GuildResult impeachGuildPresident(WNPlayer player, String presidentId, Date logoutTime) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
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

        if (!presidentId.equals(myGuild.presidentId)) {
            ret.result = -3;
            ret.des = "会长不匹配，可能已更换会长";
            return ret;
        }

        Date nowTime = new Date();
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (nowTime.getTime() - logoutTime.getTime() < settingProp.impeachMs) {
            ret.result = -6;
            ret.des = LangService.getValue("GUILD_PRESIDENT_OFFTIME_NOT_ENOUGH").replace("{day}", String.valueOf(settingProp.impeach));
            return ret;
        }


        GuildImpeachCenter.getInstance().refreshImpeash(myGuild.id);
        GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
        int isNew = 0;
        if (null != impeach) {
            if (impeach.playerIds.indexOf(myInfo.playerId) != -1) {
                ret.result = -7;
                long createTime = impeach.createTime.getTime();
                long remainTime = settingProp.impeachTimeMs - nowTime.getTime() - createTime;
                String _strT = GuildCommonUtil.leftTimeTips(remainTime);
                ret.des = MessageFormat.format(LangService.getValue("GUILD_PRESIDENT_TIPS"), new Object[]{Integer.valueOf(settingProp.impeachTime / 60), Integer.valueOf(settingProp.impeachNo), Integer.valueOf(impeach.playerIds.size()), _strT});
                return ret;
            }

            impeach.playerIds.add(myInfo.playerId);
            GuildImpeachCenter.getInstance().updateGuildImpeachByData(impeach);
        } else {
            impeach = new GuildImpeachData();
            impeach.id = myGuild.id;
            impeach.logicServerId = myGuild.logicServerId;
            impeach.logoutTime = logoutTime;
            impeach.createTime = new Date();
            impeach.playerIds.add(myInfo.playerId);
            impeach.sponsor = new GuildImpeachData.Sponsor();
            impeach.sponsor.id = myInfo.playerId;
            impeach.sponsor.name = myInfo.name;
            isNew = 1;
            GuildImpeachCenter.getInstance().addImpeachAndSave(impeach);
        }


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.IMPEACH.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.role2.pro = myGuild.presidentPro;
        record.role2.name = myGuild.presidentName;
        record.result.v2 = Integer.toString(impeach.playerIds.size());
        guildManager.addGuildRecord(myGuild.id, record);

        ret.result = 0;
        ret.isNew = isNew;
        ret.des = "success";
        return ret;
    }

    public static GuildResult presidentOnline(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = -1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = -2;
            ret.des = "不是会长上线";
            return ret;
        }
        GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
        if (null == impeach) {
            ret.result = -2;
            ret.des = "没有被弹劾，不需要清除";
            return ret;
        }

        GuildImpeachCenter.getInstance().removeGuildImpeach(myGuild.id);
        impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
        if (null != impeach) {

            GuildRecordData record = new GuildRecordData();
            record.type = Const.GuildRecord.ONLINE_IMPEACH_BECOME_INVALID.getValue();
            record.role1.pro = impeach.sponsor.pro;
            record.role2.name = impeach.sponsor.name;
            record.role2.pro = myGuild.presidentPro;
            record.role2.name = myGuild.presidentName;
            record.result.v2 = Integer.toString(impeach.playerIds.size());
            guildManager.addGuildRecord(myGuild.id, record);
            GuildImpeachCenter.getInstance().removeGuildImpeachByData(impeach);
        }
        ret.result = 0;
        ret.des = "success";
        return ret;
    }


    public static GuildResult depotDepositEquip(WNPlayer player, PlayerItemPO item) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildDepot depot = GuildDepotCenter.getInstance().getDepot(myInfo.guildId);
        if (null == depot) {
            ret.result = 2;
            ret.des = "公会仓库不存在";
            return ret;
        }

        GuildCond useCond = depot.depotData.condition.useCond;

        if (player.getLevel() < useCond.level) {
            ret.result = 4;
            ret.des = "等级不满足";
            return ret;
        }

        if (myInfo.job > useCond.job) {
            ret.result = 5;
            ret.des = "公会职位不满足";
            return ret;
        }


        NormalItem equip = ItemUtil.createItemByDbOpts(item);
        GuildCond equipQuality = new GuildCond();
        equipQuality.level = equip.getLevel();
        equipQuality.upLevel = equip.getUpLevel();
        equipQuality.qColor = equip.getQLevel();

        if (!GuildUtil.isInCondition(equipQuality, depot.depotData.condition)) {
            ret.result = 6;
            ret.des = "装备品质不在设定范围内";
            return ret;
        }

        WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(equip.getLevel(), equip.getQLevel());
        if (null == depositProp) {
            ret.result = -9;
            ret.des = "未找到该品质对应的配置";
            return ret;
        }


        if (!depot.testEmptyGridLarge(1)) {
            ret.result = 7;
            ret.des = "仓库空间不足";
            return ret;
        }

        int addIndex = depot.addEquip(equip, myInfo.playerId);
        if (addIndex <= 0) {
            ret.result = 7;
            ret.des = "仓库增加道具失败(异常)";
            return ret;
        }

        RoleInfo role1 = new RoleInfo();
        role1.pro = myInfo.pro;
        role1.name = myInfo.name;


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.DEPOSIT_EQUIP.getValue();
        record.role1 = role1;
        ItemRecordInfo tmpItem = new ItemRecordInfo();
        tmpItem.qColor = equip.getQLevel();
        tmpItem.name = equip.getName();
        record.item = tmpItem;
        record.result.v2 = Integer.toString(depositProp.wareHouseValue);
        depot.addRecord(record, true);

        ret.result = 0;
        ret.des = "success";
        ret.bagGrid = depot.bag.getGrid4PayLoad(addIndex);
        return ret;
    }

    public static GuildResult depotTakeOutEquip(WNPlayer player, int bagIndex, int havePawnGold) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
        GuildDepot depot = depotManager.getDepot(myInfo.guildId);
        if (null == depot) {
            ret.result = 2;
            ret.des = "公会仓库不存在";
            return ret;
        }

        NormalItem equip = depot.getEquip(bagIndex);
        if (null == equip) {
            ret.result = 3;
            ret.des = "该格子不存在道具";
            return ret;
        }
        WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(equip.getLevel(), equip.getQLevel());
        if (null == depositProp || havePawnGold < depositProp.wareHouseCost) {
            ret.result = 4;
            ret.des = "仓库贡献不足";
            return ret;
        }


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.TAKE_OUT_EQUIP.getValue();
        record.role1 = new RoleInfo();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.item = new ItemRecordInfo();
        record.item.qColor = equip.getQLevel();
        record.item.name = equip.getName();
        record.result.v2 = Integer.toString(depositProp.wareHouseCost);
        depot.addRecord(record, false);

        depot.removeEquip(bagIndex, myInfo.playerId, false);
        ret.result = 0;
        ret.des = "success";
        ret.itemData = equip.cloneItemDB();
        return ret;
    }

    public static GuildResult depotDeleteEquip(WNPlayer player, int bagIndex) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right6 == 0) {
            ret.result = 2;
            ret.des = "没有权限";
            return ret;
        }

        GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
        GuildDepot depot = depotManager.getDepot(myInfo.guildId);
        if (null == depot) {
            ret.result = 3;
            ret.des = "公会仓库不存在";
            return ret;
        }

        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (depot.getDeleteCount() >= settingProp.warehouseDel) {
            ret.result = 4;
            ret.des = "进入删除次数已用完";
            return ret;
        }

        NormalItem equip = depot.getEquip(bagIndex);
        if (null == equip) {
            ret.result = 5;
            ret.des = "该格子不存在道具";
            return ret;
        }


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.DELETE_EQUIP.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.item = new ItemRecordInfo();
        record.item.qColor = equip.getQLevel();
        record.item.name = equip.getName();
        depot.addRecord(record, false);

        depot.removeEquip(bagIndex, myInfo.playerId, true);
        ret.result = 0;
        ret.des = "success";
        ret.deleteCount = depot.getDeleteCount();
        return ret;
    }

    public static GuildResult depotSetCondition(WNPlayer player, GuildDepotCondition condition) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right6 == 0) {
            ret.result = 2;
            ret.des = "没有权限";
            return ret;
        }

        GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
        GuildDepot depot = depotManager.getDepot(myInfo.guildId);
        if (null == depot) {
            ret.result = 3;
            ret.des = "公会仓库不存在";
            return ret;
        }

        depot.setCondition(condition, myInfo.playerId);
        ret.result = 0;
        ret.des = "success";
        ret.newCondition = condition;
        return ret;
    }


    public static GuildResult depotUpgradeLevel(WNPlayer player, int myGold) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (null == jobProp || jobProp.right6 == 0) {
            ret.result = 2;
            ret.des = "没有权限";
            return ret;
        }

        GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
        GuildDepot depot = depotManager.getDepot(myInfo.guildId);
        if (null == depot) {
            ret.result = 3;
            ret.des = "公会仓库不存在";
            return ret;
        }

        WareHouseLevelCO levelProp = GuildUtil.getDepotLevelProp(depot.depotData.level);
        if (null == levelProp) {
            ret.result = 3;
            ret.des = "公会仓库等级配置不存在";
            return ret;
        }
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.DEPOT.getValue());
        if (depot.depotData.level >= buildProp.maxLv) {
            ret.result = 4;
            ret.des = "公会仓库等级已满";
            return ret;
        }

        if (myGuild.level < levelProp.gLevel) {
            ret.result = 5;
            ret.des = "公会等级不足";
            return ret;
        }
        if (myGold < levelProp.gold) {
            ret.result = 6;
            ret.des = "公会等级不足";
        }
        if (myGuild.fund < levelProp.funds) {
            ret.result = 7;
            ret.des = "工会资金不足";
            return ret;
        }

        int preLevel = depot.depotData.level;
        myGuild.fund -= levelProp.funds;
        depot.upgradeLevel(myInfo.playerId);


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = Integer.toString(depot.depotData.level);
        record.build = buildProp.buildingName;
        GuildServiceCenter.getInstance().addGuildRecord(myGuild.id, record);

        GuildResult.DepotUpgradeLevelData tmpData = new GuildResult.DepotUpgradeLevelData();
        tmpData.costGoldNum = levelProp.gold;
        tmpData.newLevel = depot.depotData.level;
        tmpData.fund = myGuild.fund;
        tmpData.id = myGuild.id;
        tmpData.name = myGuild.name;
        tmpData.preLevel = preLevel;
        ret.result = 0;
        ret.des = "sucess";
        ret.data = tmpData;
        return ret;
    }

    public static GuildResult playerOnlineRefreshGuild(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildResult.PlayerOnlineRefreshGuild data = new GuildResult.PlayerOnlineRefreshGuild();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            ret.data = data;
            return ret;
        }

        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            ret.data = data;
            return ret;
        }

        GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
        GuildBlessPO bless = (blessManager.getBless(myInfo.guildId)).blessData;
        if (null == bless) {
            ret.result = 0;
            ret.des = "公会祈福未开启";
            ret.data = data;
            return ret;
        }

        if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
            presidentOnline(player);
        }

        data.isInGuild = 1;
        data.goods = bless.allBlobData.goods;
        data.techData = bless.allBlobData.techData;
        data.refreshTime = bless.allBlobData.refreshTime;
        data.finishStateArr = bless.allBlobData.finishStateArr;
        data.throwAwardState = getThrowAwardState(myInfo.guildId, player.getId());

        ret.result = 0;
        ret.des = "success";
        ret.data = data;
        return ret;
    }

    public static int getThrowAwardState(String guildId, String playerId) {
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
        if (dungeonInfo.openState > 0) {
            return 0;
        }

        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        Date now = new Date();
        if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() > (dungeonConfig.throwTime * Const.Time.Minute.getValue())) {
            return 0;
        }

        for (int pos = 0; pos < dungeonInfo.throwInfo.size(); pos++) {
            GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(pos);
            if (null == info.diceInfo.get(playerId)) {
                if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {

                    return 1;
                }
            }
        }
        return 0;
    }

    public static GuildResult blessAction(WNPlayer player, int id, int blessCount, int times) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless) {
            ret.result = 1;
            ret.des = "公会祈福不存在";
            return ret;
        }

        BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.blessLevel);
        if (blessCount + times > ((BlessLevelCO) blessLevelExt).blessTime) {
            ret.result = 2;
            ret.des = "祈福次数不足";
            return ret;
        }
        if (!bless.isTodayValidBlessId(id)) {
            ret.result = 3;
            ret.des = "该祈福道具今日不能使用";
            return ret;
        }

        ret.result = 0;
        ret.des = "success";
        ret.data = (bless.blessAction(id, times, player)).data;
        return ret;
    }


    public static GuildResult receiveBlessGift(WNPlayer player, int index) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
        if (null == myInfo) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }

        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless) {
            ret.result = 1;
            ret.des = "公会祈福不存在";
            return ret;
        }

        if (index < 0 || bless.blessData.allBlobData.finishStateArr.length < index) {
            ret.result = 3;
            ret.des = "参数错误";
            return ret;
        }

        if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == bless.blessData.allBlobData.finishStateArr[index]) {
            ret.result = 2;
            ret.des = "公会祈福未完成总进度";
            return ret;
        }

        if (Const.EVENT_GIFT_STATE.RECEIVED.getValue() == bless.blessData.allBlobData.finishStateArr[index]) {
            ret.result = 4;
            ret.des = "已领取过改奖励";
            return ret;
        }

        ret.result = 0;
        ret.des = "success";
        ret.data = bless.getGiftAndBuffInfo(index);
        return ret;
    }

    public static GuildResult upgradeBlessLevel(WNPlayer player, int haveGold) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless) {
            ret.result = 1;
            ret.des = "公会祈福不存在";
            return ret;
        }

        if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
            ret.result = 2;
            ret.des = "没有祈福升级操作权限";
            return ret;
        }
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.BLESS.getValue());
        if (bless.level >= buildProp.maxLv) {
            ret.result = 3;
            ret.des = "祈福等级已满";
            return ret;
        }
        BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.level);
        if (myGuild.level < ((BlessLevelCO) blessLevelExt).gLevel) {
            ret.result = 4;
            ret.des = "公会等级不足";
            return ret;
        }
        if (haveGold < ((BlessLevelCO) blessLevelExt).gold) {
            ret.result = 5;
            ret.des = "银两不足";
            return ret;
        }
        if (myGuild.fund < ((BlessLevelCO) blessLevelExt).funds) {
            ret.result = 6;
            ret.des = "公会资金不足";
            return ret;
        }

        int preLevel = bless.level;
        myGuild.fund -= ((BlessLevelCO) blessLevelExt).funds;
        bless.upgradeLevel(myInfo.playerId);
        bless.randomBlessItem();


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = Integer.toString(bless.level);
        record.build = buildProp.buildingName;
        guildManager.addGuildRecord(myGuild.id, record);

        GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
        tmpData.level = bless.level;
        tmpData.needGold = ((BlessLevelCO) blessLevelExt).gold;
        tmpData.fund = myGuild.fund;
        tmpData.id = myGuild.id;
        tmpData.name = myGuild.name;
        tmpData.preLevel = preLevel;

        ret.result = 0;
        ret.des = "success";
        ret.data = tmpData;
        return ret;
    }

    public static GuildResult getGuildTodayGoodsList(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
        GuildBless bless = blessManager.getBlessByPlayerId(player.getId());
        if (null == bless) {
            ret.result = 0;
            ret.des = "公会商店未开启";
            ret.goods = null;
            return ret;
        }

        ret.result = 0;
        ret.des = "success";
        ret.goods = bless.goods;
        return ret;
    }

    public static GuildResult getGuildTodayTechData(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
        GuildBless bless = blessManager.getBlessByPlayerId(player.getId());
        if (null == bless) {
            ret.result = 0;
            ret.des = "公会修行未开启";
            ret.techData = null;
            return ret;
        }
        ret.result = 0;
        ret.des = "success";
        ret.techData = bless.tech.toJson4Serialize();
        return ret;
    }

    public static GuildResult techUpgradeLevel(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless) {
            ret.result = 1;
            ret.des = "公会修行不存在";
            return ret;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right8 == 0) {
            ret.result = 2;
            ret.des = "没有修行升级操作权限";
            return ret;
        }

        GuildTech tech = bless.tech;
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
        if (tech.level >= buildProp.maxLv) {
            ret.result = 3;
            ret.des = "修行等级已满";
            return ret;
        }

        GTechnologyLevelCO levelProp = GuildUtil.getTechLevelPropByLevel(tech.level);
        if (myGuild.level < levelProp.gLevel) {
            ret.result = 4;
            ret.des = "公会等级不足";
            ret.needLevel = levelProp.gLevel;
            return ret;
        }
        if (player.player.gold < levelProp.gold) {
            ret.result = 5;
            ret.des = "银两不足";
            return ret;
        }
        if (myGuild.fund < levelProp.funds) {
            ret.result = 6;
            ret.des = "公会资金不足";
            return ret;
        }
        myGuild.fund -= levelProp.funds;
        tech.upgradeLevel(player);
        bless.saveToRedis();

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = Integer.toString(tech.level);
        record.build = buildProp.buildingName;
        guildManager.addGuildRecord(myGuild.id, record);

        GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
        tmpData.level = tech.level;
        tmpData.needGold = levelProp.gold;
        tmpData.fund = myGuild.fund;
        tmpData.id = myGuild.id;
        tmpData.name = myGuild.name;

        ret.result = 0;
        ret.des = "success";
        ret.data = tmpData;
        return ret;
    }

    public static GuildResult techUpgradeBuffLevel(WNPlayer player) {
        GuildResult ret = new GuildResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
        GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
        if (null == myInfo || null == myGuild) {
            ret.result = 1;
            ret.des = LangService.getValue("GUILD_NOT_JOIN");
            return ret;
        }
        GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
        if (null == bless) {
            ret.result = 1;
            ret.des = "公会修行不存在";
            return ret;
        }
        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right9 == 0) {
            ret.result = 2;
            ret.des = "没有修行增益属性升级操作权限";
            return ret;
        }

        GuildTech tech = bless.tech;
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
        if (tech.buffLevel >= buildProp.maxLv) {
            ret.result = 3;
            ret.des = "修行Buff等级已满";
            return ret;
        }
        if (tech.buffLevel >= tech.level) {
            ret.result = 4;
            ret.des = "需要升级修行";
            return ret;
        }
        GBuffExt gBuffExt = GuildUtil.getTechBuffPropByLevel(tech.buffLevel);
        if (myGuild.fund < ((GBuffCO) gBuffExt).funds) {
            ret.result = 5;
            ret.des = "公会资金不足";
            return ret;
        }

        myGuild.fund -= ((GBuffCO) gBuffExt).funds;
        tech.upgradeBuffLevel(player);
        bless.saveToRedis();

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        record.result.v2 = Integer.toString(tech.buffLevel);
        record.build = buildProp.buildingName2;
        guildManager.addGuildRecord(myGuild.id, record);

        GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
        tmpData.fund = myGuild.fund;
        tmpData.buffLevel = tech.buffLevel;
        ret.result = 0;
        ret.des = "success";
        ret.data = tmpData;
        return ret;
    }

    public static boolean playerIsPresident(String playerId) {
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
        if (null != myInfo && Const.GuildJob.PRESIDENT.getValue() == myInfo.job) {
            return true;
        }
        return false;
    }

    public static boolean playerRemoveGuildData(String playerId, boolean isSave) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (null != myInfo && Const.GuildJob.PRESIDENT.getValue() == myInfo.job) {
            return false;
        }

        if (isSave) {
            return true;
        }

        if (null == myInfo) {
            guildManager.removeAllPlayerApplyAsync(playerId);
            return true;
        }

        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null != myGuild) {
            GuildRecordData record = new GuildRecordData(Const.GuildRecord.EXIT.getValue(), myInfo, null);
            guildManager.addGuildRecord(myGuild.id, record);
        }

        guildManager.removeMember(playerId);
        guildManager.removeAllPlayerApplyAsync(playerId);
        return true;
    }

    public static boolean setDungeonCloseTime(final String guildId, Date openTime) {
        long lastTime = System.currentTimeMillis() - openTime.getTime();
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        lastTime = ((dungeonConfig.fightTime + dungeonConfig.openForReady) * Const.Time.Minute.getValue()) - lastTime;

        if (lastTime <= 0L) {
            GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
            if (dungeonInfo.openState <= 0) {
                return false;
            }
            dungeonInfo.openState = 0;
            dungeonInfo.dungeonPassedTime = new Date();
            dungeonInfo.instanceId = "";
            dungeonInfo.serverId = "";
            GuildUtil.updateGuildDungeon(dungeonInfo);
            return false;
        }

        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
                String instanceId = dungeonInfo.instanceId;

                if (dungeonInfo.openState > 0) {
                    dungeonInfo.openState = 0;
                    dungeonInfo.dungeonPassedTime = new Date();
                    dungeonInfo.instanceId = "";
                    dungeonInfo.serverId = "";
                    GuildUtil.updateGuildDungeon(dungeonInfo);
                }

                if (!StringUtil.isNullOrEmpty(instanceId)) ;
            }
        }, lastTime);


        return true;
    }

    public static void setDungeonThrowRewardTimeByopenTime(final String guildId, Date openTime) {
        long lastTime = System.currentTimeMillis() - openTime.getTime();
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        lastTime = ((dungeonConfig.fightTime + dungeonConfig.openForReady + dungeonConfig.throwTime) * Const.Time.Minute.getValue()) - lastTime;
        if (lastTime <= 0L) {
            GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
            if (dungeonInfo.bReward <= 0) {
                return;
            }

            for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
                GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
                if (null != info.mostPointPlayerId && !info.mostPointPlayerId.isEmpty()) {


                    MailSysData mailData = new MailSysData("Guild_dungeon_roll");
                    mailData.attachments = new ArrayList();
                    MailData.Attachment attach = new MailData.Attachment();
                    attach.itemCode = info.dropItem.code;
                    attach.itemNum = 1;
                    mailData.attachments.add(attach);
                    mailData.entityItems = new ArrayList();
                    mailData.entityItems.add(info.dropItem);
                    MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
                }
            }
            dungeonInfo.bReward = 1;
            GuildUtil.updateGuildDungeon(dungeonInfo);

            return;
        }
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
                if (dungeonInfo.bReward > 0) {
                    return;
                }
                for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
                    GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
                    if (!StringUtil.isNullOrEmpty(info.mostPointPlayerId)) {


                        MailSysData mailData = new MailSysData("Guild_dungeon_roll");


                        mailData.entityItems = new ArrayList();
                        mailData.entityItems.add(info.dropItem);
                        MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
                    }
                }
                dungeonInfo.bReward = 1;
                GuildUtil.updateGuildDungeon(dungeonInfo);
            }
        }lastTime);
    }


    public static void setDungeonOpenTime(final String playerId, final String guildId, int readyTime) {
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
                Set<String> playerIds = guildManager.getGuildMemberIdList(guildId);
                playerIds.remove(playerId);
                GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_OPEN.getValue(), null);
                GuildService.notifySomePlayerRefreshGuild(playerIds, msg, null);
            }
        } (readyTime * 60 * 1000));
    }

    public static int getGuildDungeonState(String playerId) {
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
        if (null != myInfo) {
            GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
            if (null != dungeonInfo) {
                return dungeonInfo.openState;
            }
        }
        return 0;
    }

    public static void clearDungeonState(String playerId) {
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
        if (null != myInfo) {
            GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
            if (null != dungeonInfo) {
                dungeonInfo.enterState = 0;
            }
        }
    }

    public static OpenGuildDungeonResult openGuildDungeon(String playerId) {
        OpenGuildDungeonResult data = new OpenGuildDungeonResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (null == myInfo) {
            data.result = false;
            data.info = LangService.getValue("GUILD_NOT_JOIN");
            return data;
        }

        GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
        if (jobProp.right10 == 0) {
            data.result = false;
            data.info = LangService.getValue("GUILD_NO_POWER");
            return data;
        }

        GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
        if (null == myGuild) {
            data.result = false;
            data.info = LangService.getValue("GUILD_NOT_EXIST");
            return data;
        }

        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        Date now = new Date();

        if (DateUtil.canRefreshData(5, dungeonInfo.openTime)) {
            dungeonInfo.openTimesToday = 0;
        }

        if (dungeonInfo.openTimesToday >= dungeonConfig.openTime) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_OPEN_MAX");
            return data;
        }
        if (dungeonInfo.openState > 0) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_FIGHTING");
            return data;
        }

        if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() < (dungeonConfig.openCD * Const.Time.Minute.getValue())) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_OPEN_CD");
            return data;
        }

        dungeonInfo.openTimesToday++;
        dungeonInfo.openTime = now;
        dungeonInfo.openState = 1;
        dungeonInfo.bReward = 0;

        dungeonInfo.dungeonPassedTime = new Date(0L);

        dungeonInfo.dungeonRecord = new HashMap<>();
        dungeonInfo.instanceId = "";
        dungeonInfo.serverId = "";
        dungeonInfo.throwInfo = new ArrayList();
        dungeonInfo.damagePlayer = new HashMap<>();
        dungeonInfo.damageRankInfo = new ArrayList();
        dungeonInfo.healRankInfo = new ArrayList();

        dungeonInfo.currPassedCount = 0;
        dungeonInfo.totalPassedCount = myGuild.level;

        GuildUtil.updateGuildDungeon(dungeonInfo);

        setDungeonCloseTime(myInfo.guildId, dungeonInfo.openTime);
        setDungeonThrowRewardTimeByopenTime(myInfo.guildId, dungeonInfo.openTime);
        setDungeonOpenTime(playerId, myInfo.guildId, dungeonConfig.openForReady);

        data.waitTime = (dungeonConfig.openForReady * 60);

        GuildMsg.OnChatGuildMsg msgData = new GuildMsg.OnChatGuildMsg();
        msgData.playerId = playerId;
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_OPEN_CHAT.getValue(), msgData);

        notifyAllMemberRefreshGuild(myGuild.id, msg, null);


        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.OPEN_GUILD_DUNGEON.getValue();
        record.role1.pro = myInfo.pro;
        record.role1.name = myInfo.name;
        guildManager.addGuildRecord(myGuild.id, record);

        Set<String> playerIds = guildManager.getGuildMemberIdList(myInfo.guildId);
        MailSysData mailData = new MailSysData("Guild_dungeon_open");
        mailData.replace = new HashMap<>();
        mailData.replace.put("time", now.toString());

        MailUtil.getInstance().sendMailToSomePlayer(playerIds.<String>toArray(new String[playerIds.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
        return data;
    }

    public static GuildManagerHandler.DungeonList guildDungeonList(String playerId) {
        GuildManagerHandler.DungeonList.Builder data = GuildManagerHandler.DungeonList.newBuilder();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (null == myInfo) {
            return data.build();
        }
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
        Date now = new Date();
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        data.setOpenTime(dungeonConfig.openForReady * Const.Time.Minute.getValue() / 1000);
        if (dungeonInfo.openState > 0) {
            int tmpTime = (int) (dungeonInfo.openTime.getTime() + (dungeonConfig.openForReady * Const.Time.Minute.getValue()));
            data.setTime(tmpTime);
            if (now.getTime() > data.getTime()) {
                data.setTime(data.getTime() + dungeonConfig.fightTime * Const.Time.Minute.getValue());
                data.setState(3);
            } else {
                data.setState(2);
            }
            data.setCurrDungeonCount(dungeonInfo.currPassedCount + 1);
        } else {
            if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() < (dungeonConfig.openCD * Const.Time.Minute.getValue())) {
                data.setState(4);
            } else {
                data.setState(1);
            }
            int tmpTime2 = (int) (dungeonInfo.dungeonPassedTime.getTime() + (dungeonConfig.throwTime * Const.Time.Minute.getValue()));
            data.setTime(tmpTime2);
            data.setCurrDungeonCount(0);
        }

        data.setTime((int) Math.floor(data.getTime() * 0.001D));

        data.setMaxDungeonCount(dungeonInfo.totalPassedCount);

        if (dungeonInfo.totalPassedCount == 0) {
            GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
            if (null != myGuild) {
                data.setMaxDungeonCount(myGuild.level);
            }
        }

        List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));


        props.sort(new Comparator<GDungeonMapCO>() {
            public int compare(GDungeonMapCO o1, GDungeonMapCO o2) {
                return o1.layer - o2.layer;
            }
        });

        for (int i = 0; i < props.size(); i++) {
            GDungeonMapCO prop = props.get(i);
            GuildDungeonRecord recordInfo = (GuildDungeonRecord) dungeonInfo.dungeonRecord.get(Integer.valueOf(i + 1));
            GuildManagerHandler.DungeonInfo.Builder dungeon = GuildManagerHandler.DungeonInfo.newBuilder();
            dungeon.setDungeonId(prop.mapID);
            if (null != recordInfo) {
                if (null != recordInfo.killPlayerId && !recordInfo.killPlayerId.isEmpty()) {
                    PlayerPO killPlayer = PlayerUtil.getPlayerBaseData(recordInfo.killPlayerId);
                    dungeon.setKilledPlayerInfo(PlayerUtil.playerBasicData(killPlayer));
                }
                dungeon.setCurrPlayerNum(recordInfo.currPlayerNum);
            }

            dungeon.setTotalPlayerNum(prop.allowedPlayers);
            data.setDungeonList(i, dungeon);
        }


        return data.build();
    }

    public static GuildDungeonResult joinGuildDungeon(String playerId, int playerLevel) {
        GuildDungeonResult data = new GuildDungeonResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        if (null == myInfo) {
            data.result = false;
            data.info = LangService.getValue("GUILD_NOT_JOIN");
            return data;
        }
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
        if (dungeonInfo.openState <= 0) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_NOTOPEN");
            return data;
        }
        if (dungeonInfo.enterState == 1) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_ENTER_ERROR");
            return data;
        }

        Date now = new Date();
        long diffTime = now.getTime() - dungeonInfo.openTime.getTime();
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        if (diffTime < (dungeonConfig.openForReady * Const.Time.Minute.getValue())) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_OPEN_GETREADY");
            return data;
        }

        List<GDungeonMapCO> props = GuildCommonUtil.findAndSortDungeonMap();
        GDungeonMapCO prop = props.get(dungeonInfo.currPassedCount);
        if (null == prop) {
            data.result = false;
            data.info = LangService.getValue("PARAM_ERROR");
            return data;
        }

        if (playerLevel < prop.reqLevel) {
            data.result = false;
            data.info = LangService.getValue("DUNGEON_LEVEL_NOT_ENOUGH");
            return data;
        }
        GuildDungeonRecord recordInfo = (GuildDungeonRecord) dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonInfo.currPassedCount + 1));
        if (null != recordInfo && recordInfo.currPlayerNum >= prop.allowedPlayers) {
            data.result = false;
            data.info = LangService.getValue("GDUNGEON_PLAYER_MAX");
            return data;
        }

        data.dungeonId = prop.mapID;
        data.guildId = myInfo.guildId;
        data.maxCountDungeonId = ((GDungeonMapCO) props.get(dungeonInfo.totalPassedCount - 1)).mapID;
        data.instanceId = dungeonInfo.instanceId;
        data.dungeonCount = dungeonInfo.currPassedCount + 1;

        if (data.instanceId.isEmpty()) {
            dungeonInfo.enterState = 1;
        }

        return data;
    }

    public static ArrayList<GuildManagerHandler.RankInfo> dungeonRank(String playerId, int type) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);

        if (null == myInfo) {
            return null;
        }
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
        if (type == 1) {
            return dungeonInfo.damageRankInfo;
        }
        return dungeonInfo.healRankInfo;
    }


    public static GuildDungeonAward dungeonAwardInfo(String playerId) {
        GuildDungeonAward data = new GuildDungeonAward();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        PlayerBasePO basePO = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);

        if (null == myInfo) {
            return data;
        }

        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);

        if (dungeonInfo.openState > 0) {
            data.isFightOver = 0;
            return data;
        }

        Date now = new Date();

        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();

        long timeInterval = now.getTime() - dungeonInfo.dungeonPassedTime.getTime();

        if (timeInterval < (dungeonConfig.throwTime * Const.Time.Minute.getValue())) {
            data.diceLeftTime = (int) Math.floor(((dungeonConfig.throwTime * Const.Time.Minute.getValue()) - timeInterval) * 0.001D);
        }

        data.getDungeonScoreInfo = getDungeonScoreInfo(dungeonInfo, playerId);

        ArrayList<GuildManagerHandler.AwardInfo> itemInfos = new ArrayList<>();
        for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
            GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);

            GuildManagerHandler.AwardInfo.Builder itemInfo = GuildManagerHandler.AwardInfo.newBuilder();
            itemInfo.setPos(i);
            itemInfo.setDropItem(ItemUtil.createItemByDbOpts(info.dropItem).getItemDetail(basePO));
            itemInfo.setDungeonCount(info.dungeonCount);


            if (null != info.mostPointPlayerName && !info.mostPointPlayerName.isEmpty()) {
                itemInfo.setPlayerName(info.mostPointPlayerName);
                itemInfo.setPlayerPro(info.mostPointPlayerPro);
                itemInfo.setPlayerDicePoint(info.mostPoint);
            }

            for (int id = 0; id < info.diceInfo.size(); id++) {
                itemInfo.setDiceInfo(id, (GuildManagerHandler.DiceInfo) info.diceInfo.get(Integer.valueOf(id)));
            }

            if (null != info.diceInfo.get(playerId)) {
                itemInfo.setState(1);
            } else if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
                itemInfo.setState(2);
            } else {
                itemInfo.setState(3);
            }

            itemInfos.add(itemInfo.build());
        }

        itemInfos.sort(new Comparator<GuildManagerHandler.AwardInfo>() {
            public int compare(GuildManagerHandler.AwardInfo o1, GuildManagerHandler.AwardInfo o2) {
                int QColor1 = (ItemUtil.getPropByCode(o1.toBuilder().getDropItem().getCode())).qcolor;
                int QColor2 = (ItemUtil.getPropByCode(o2.toBuilder().getDropItem().getCode())).qcolor;
                return (QColor1 > QColor2) ? 1 : -1;
            }
        });

        data.itemInfos = itemInfos;
        return data;
    }

    public static boolean isDamagePlayer(Map<Integer, ArrayList<String>> damagePlayer, int dungeonCount, String playerId) {
        ArrayList<String> eachCountDamage = damagePlayer.get(Integer.valueOf(dungeonCount));
        if (null != eachCountDamage && eachCountDamage.size() > 0 &&
                eachCountDamage.indexOf(playerId) != -1) {
            return true;
        }

        return false;
    }

    public static ArrayList<GuildManagerHandler.GetDungeonScoreInfo> getDungeonScoreInfo(GuildDungeonPO dungeonInfo, String playerId) {
        ArrayList<GuildManagerHandler.GetDungeonScoreInfo> data = new ArrayList<>();
        if (dungeonInfo.currPassedCount > 0) {
            GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
            dungeonScoreInfo.setType(1);
            dungeonScoreInfo.setValue(dungeonInfo.currPassedCount);
            int dungeonScore = 0;
            List<GDungeonMapCO> props = GuildCommonUtil.findAndSortDungeonMap();

            for (int i = 0; i < dungeonInfo.currPassedCount; i++) {
                if (isDamagePlayer(dungeonInfo.damagePlayer, i + 1, playerId)) {
                    dungeonScore += ((GDungeonMapCO) props.get(i)).gpoints;
                }
            }
            dungeonScoreInfo.setScore(dungeonScore);

            data.add(dungeonScoreInfo.build());
        }

        int rank = getRank(dungeonInfo.damageRankInfo, playerId);

        if (rank > 0) {
            List<GDungeonRankCO> list = GameData.findGDungeonRanks(t ->
                    (t.rankType == 1 && t.openTime == getRank(dungeonInfo.damageRankInfo, playerId)));


            GDungeonRankCO rankProp = null;
            if (null != list && list.size() > 0) {
                rankProp = list.get(0);
            }
            if (null != rankProp) {
                GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
                dungeonScoreInfo.setType(2);
                dungeonScoreInfo.setValue(rank);
                dungeonScoreInfo.setScore(rankProp.gpoints);
                data.add(dungeonScoreInfo.build());
            }
        }

        if (rank > 0) {
            rank = getRank(dungeonInfo.healRankInfo, playerId);
            GDungeonRankCO rankProp = null;
            List<GDungeonRankCO> list = GameData.findGDungeonRanks(t ->
                    (t.rankType == 2 && t.openTime == getRank(dungeonInfo.healRankInfo, playerId)));


            if (null != list && list.size() > 0) {
                rankProp = list.get(0);
            }

            if (null != rankProp) {

                GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
                dungeonScoreInfo.setType(3);
                dungeonScoreInfo.setValue(rank);
                dungeonScoreInfo.setScore(rankProp.gpoints);

                data.add(dungeonScoreInfo.build());
            }
        }
        return data;
    }


    public static int getRank(ArrayList<GuildManagerHandler.RankInfo> rankInfo, String playerId) {
        for (int i = 0; i < rankInfo.size(); i++) {
            if (((GuildManagerHandler.RankInfo) rankInfo.get(i)).getPlayerId() == playerId) {
                return i + 1;
            }
        }
        return 0;
    }

    public static GuildDiceAwardResult diceAward(String playerId, int pos) {
        GuildDiceAwardResult data = new GuildDiceAwardResult();
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
        PlayerBasePO basePO = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);

        if (null == myInfo) {
            data.result = false;
            data.info = LangService.getValue("GUILD_NOT_JOIN");
            return data;
        }

        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
        GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(pos);

        if (null != info.diceInfo.get(playerId)) {
            data.result = false;
            data.info = LangService.getValue("ROLL_COMPLETED");
            return data;
        }
        if (!isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
            data.result = false;
            data.info = LangService.getValue("ROLL_NORIGHT");
            return data;
        }

        if (dungeonInfo.openState != 0) {
            data.result = false;
            data.info = LangService.getValue("ROLL_NOTOPEN");
            return data;
        }

        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();

        Date now = new Date();

        if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() > (dungeonConfig.throwTime * Const.Time.Minute.getValue())) {
            data.result = false;
            data.info = LangService.getValue("ROLL_END");
            return data;
        }

        PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);
        int point = Utils.random(0, 100);
        GuildManagerHandler.DiceInfo.Builder tmpDiceInfo = GuildManagerHandler.DiceInfo.newBuilder();
        tmpDiceInfo.setPlayerName(player.name);
        tmpDiceInfo.setPlayerPro(player.pro);
        tmpDiceInfo.setDicePoint(point);
        info.diceInfo.put(playerId, tmpDiceInfo.build());

        if (info.mostPoint == 0 || point > info.mostPoint) {
            info.mostPointPlayerId = playerId;
            info.mostPointPlayerName = player.name;
            info.mostPointPlayerPro = player.pro;
            info.mostPoint = point;
        }

        GuildUtil.updateGuildDungeon(dungeonInfo);

        GuildManagerHandler.AwardInfo.Builder itemInfo = GuildManagerHandler.AwardInfo.newBuilder();
        itemInfo.setPos(pos);
        itemInfo.setDropItem(ItemUtil.createItemByDbOpts(info.dropItem).getItemDetail(basePO));
        itemInfo.setDungeonCount(info.dungeonCount);
        itemInfo.setPlayerName(info.mostPointPlayerName);
        itemInfo.setPlayerPro(info.mostPointPlayerPro);
        itemInfo.setPlayerDicePoint(info.mostPoint);

        for (int i = 0; i < info.diceInfo.size(); i++) {
            GuildManagerHandler.DiceInfo diceInfo = (GuildManagerHandler.DiceInfo) info.diceInfo.get(playerId);
            itemInfo.setDiceInfo(i, diceInfo);
        }

        if (null != info.diceInfo.get(playerId)) {
            itemInfo.setState(1);
        } else if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
            itemInfo.setState(2);
        } else {
            itemInfo.setState(3);
        }

        data.itemInfo = itemInfo.build();
        return data;
    }

    public static void dungeonPass(String guildId, int dungeonCount, String killPlayerId) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);

        if (dungeonInfo.openState <= 0) {
            return;
        }

        dungeonInfo.currPassedCount = dungeonCount;
        dungeonInfo.instanceId = "";
        dungeonInfo.serverId = "";

        if (dungeonInfo.currPassedCount >= dungeonInfo.totalPassedCount) {
            dungeonInfo.openState = 0;
            dungeonInfo.dungeonPassedTime = new Date();
            setDungeonThrowRewardTimeByPassedTime(guildId, dungeonInfo.dungeonPassedTime);


            GuildRecordData record = new GuildRecordData();
            record.type = Const.GuildRecord.GUILD_DUNGEON_PASS.getValue();
            GuildMemberPO myInfo = guildManager.getGuildMember(killPlayerId);
            if (null != myInfo) {
                record.role1 = new RoleInfo();
                record.role1.pro = myInfo.pro;
                record.role1.name = myInfo.name;
                GuildPO myGuild = guildManager.getGuild(guildId);
                guildManager.addGuildRecord(myGuild.id, record);
            }
        }
        GuildUtil.updateGuildDungeon(dungeonInfo);

        GuildMsg.DungeonPassGuildMsg msgData = new GuildMsg.DungeonPassGuildMsg();
        msgData.dungeonCount = dungeonCount + 1;
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_PASS.getValue(), msgData);
        notifyAllMemberRefreshGuild(guildId, msg, null);
    }

    public static void setDungeonThrowRewardTimeByPassedTime(final String guildId, Date dungeonPassedTime) {
        long hasPassedTime = System.currentTimeMillis() - dungeonPassedTime.getTime();
        GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
        long leftTime = (dungeonConfig.throwTime * Const.Time.Minute.getValue()) - hasPassedTime;

        if (leftTime < 0L) {
            return;
        }
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
                if (dungeonInfo.bReward > 0)
                    return;
                for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
                    GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
                    if (!StringUtil.isNullOrEmpty(info.mostPointPlayerId)) {


                        MailSysData mailData = new MailSysData("Guild_dungeon_roll");


                        mailData.entityItems = new ArrayList();
                        mailData.entityItems.add(info.dropItem);
                        MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
                    }
                }
                dungeonInfo.bReward = 1;
                GuildUtil.updateGuildDungeon(dungeonInfo);
            }
        }leftTime);
    }

    public static void updatePlayerNum(String guildId, int dungeonCount, int playerNum) {
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
        GuildDungeonRecord recordInfo = (GuildDungeonRecord) dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonCount));
        if (null != recordInfo) {
            playerNumNotify(guildId, dungeonInfo.currPassedCount, recordInfo.currPlayerNum, playerNum);
            recordInfo.currPlayerNum = playerNum;
        } else {
            GuildDungeonRecord tmpRecord = new GuildDungeonRecord();
            tmpRecord.currPlayerNum = playerNum;
            tmpRecord.killPlayerId = "";
            dungeonInfo.dungeonRecord.put(Integer.valueOf(dungeonCount), tmpRecord);
        }
        GuildUtil.updateGuildDungeon(dungeonInfo);
    }


    public static void playerNumNotify(String guildId, int currPassedCount, int currPlayerNum, int playerNum) {
        GDungeonMapCO prop = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && t.layer == currPassedCount + 1)).get(0);

        if (null != prop && ((
                currPlayerNum == prop.allowedPlayers && playerNum == prop.allowedPlayers - 1) || (playerNum == prop.allowedPlayers && currPlayerNum == prop.allowedPlayers - 1))) {
            GuildMsg.DungeonPlayerNumGuildMsg msgData = new GuildMsg.DungeonPlayerNumGuildMsg();
            msgData.playerNum = playerNum;
            GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_PLAYER_NUM.getValue(), msgData);
            notifyAllMemberRefreshGuild(guildId, msg, null);
        }
    }


    public static void dungeonInit(String guildId, String instanceId, String serverId) {
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
        dungeonInfo.instanceId = instanceId;
        dungeonInfo.serverId = serverId;
        GuildUtil.updateGuildDungeon(dungeonInfo);
    }

    public static void updateDropItem(String guildId, int dungeonCount, List<PlayerItemPO> dropItemInfo) {
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
        for (PlayerItemPO dropItem : dropItemInfo) {
            GuildDungeonThrowInfo tmpInfo = new GuildDungeonThrowInfo();
            tmpInfo.dropItem = dropItem;
            tmpInfo.dungeonCount = dungeonCount;
            tmpInfo.diceInfo = new HashMap<>();
            tmpInfo.mostPointPlayerId = "";
            tmpInfo.mostPointPlayerName = "";
            tmpInfo.mostPointPlayerPro = 0;
            tmpInfo.mostPoint = 0;
            dungeonInfo.throwInfo.add(tmpInfo);
        }
        GuildUtil.updateGuildDungeon(dungeonInfo);
    }

    public static GuildDungeonPO updateDamageAndHeal(String guildId, Map<String, GuildDungeonPlayerInfo> playerInfo, int dungeonCount, String killPlayerId) {
        GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
        for (String id : playerInfo.keySet()) {
            GuildDungeonPlayerInfo info = playerInfo.get(id);
            if (info.damage > 0) {
                boolean isExsist = false;
                for (int i = 0; i < dungeonInfo.damageRankInfo.size(); i++) {
                    GuildManagerHandler.RankInfo.Builder rankInfo = ((GuildManagerHandler.RankInfo) dungeonInfo.damageRankInfo.get(i)).toBuilder();
                    if (rankInfo.getPlayerId().equals(id)) {
                        rankInfo.setValue(rankInfo.getValue() + info.damage);
                        isExsist = true;
                    }
                }
                if (!isExsist) {
                    GuildManagerHandler.RankInfo.Builder rankData = GuildManagerHandler.RankInfo.newBuilder();
                    PlayerPO player = PlayerUtil.getPlayerBaseData(id);
                    rankData.setPlayerId(id);
                    rankData.setPlayerName(player.name);
                    rankData.setPlayerPro(player.pro);
                    rankData.setLevel(player.level);
                    rankData.setUpGradeLevel(player.upLevel);
                    rankData.setValue(info.damage);
                    dungeonInfo.damageRankInfo.add(rankData.build());
                }

                dungeonInfo.damageRankInfo.sort(new Comparator<GuildManagerHandler.RankInfo>() {
                    public int compare(GuildManagerHandler.RankInfo o1, GuildManagerHandler.RankInfo o2) {
                        return (o1.toBuilder().getValue() < o2.toBuilder().getValue()) ? 1 : -1;
                    }
                });

                ArrayList<String> eachCountDamage = (ArrayList<String>) dungeonInfo.damagePlayer.get(Integer.valueOf(dungeonCount));
                if (null != eachCountDamage) {
                    int index = eachCountDamage.indexOf(id);
                    if (index == -1) {
                        eachCountDamage.add(id);
                    }
                } else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(id);
                    dungeonInfo.damagePlayer.put(Integer.valueOf(dungeonCount), temp);
                }
            }

            if (info.heal > 0) {
                boolean isExsist = false;
                for (int i = 0; i < dungeonInfo.healRankInfo.size(); i++) {
                    GuildManagerHandler.RankInfo.Builder rankInfo = ((GuildManagerHandler.RankInfo) dungeonInfo.healRankInfo.get(i)).toBuilder();
                    if (rankInfo.getPlayerId().equals(id)) {
                        rankInfo.setValue(rankInfo.getValue() + info.heal);
                        isExsist = true;
                    }
                }

                if (!isExsist) {
                    GuildManagerHandler.RankInfo.Builder rankData = GuildManagerHandler.RankInfo.newBuilder();
                    PlayerPO player = PlayerUtil.getPlayerBaseData(id);
                    rankData.setPlayerId(id);
                    rankData.setPlayerName(player.name);
                    rankData.setPlayerPro(player.pro);
                    rankData.setLevel(player.level);
                    rankData.setUpGradeLevel(player.upLevel);
                    rankData.setValue(info.heal);
                    dungeonInfo.healRankInfo.add(rankData.build());
                }
                dungeonInfo.healRankInfo.sort(new Comparator<GuildManagerHandler.RankInfo>() {
                    public int compare(GuildManagerHandler.RankInfo o1, GuildManagerHandler.RankInfo o2) {
                        return (o1.toBuilder().getValue() < o2.toBuilder().getValue()) ? 1 : -1;
                    }
                });
            }
        }

        if (null != killPlayerId && !killPlayerId.isEmpty()) {
            GuildDungeonRecord recordInfo = (GuildDungeonRecord) dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonCount));
            if (null != recordInfo) {
                recordInfo.killPlayerId = killPlayerId;
            } else {
                GuildDungeonRecord tmpRecord = new GuildDungeonRecord();
                tmpRecord.currPlayerNum = 0;
                tmpRecord.killPlayerId = killPlayerId;
                dungeonInfo.dungeonRecord.put(Integer.valueOf(dungeonCount), tmpRecord);
            }
        }

        GuildUtil.updateGuildDungeon(dungeonInfo);

        return dungeonInfo;
    }

    public String getItemName(String code) {
        DItemEquipBase prop = ItemUtil.getPropByCode(code);
        if (null != prop) {
            return prop.name;
        }
        return "";
    }

    public static void addGuildMoneyByGuildBoss(String guildId, RankRewardExt co, int rank) {
        if (co.guildFund <= 0) {
            return;
        }

        GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
        if (guild == null) {
            return;
        }

        guild.fund += co.guildFund;
        guild.sumFund += co.guildFund;
        Out.info(new Object[]{"添加仙盟基金 guildId=", guildId, ", fund=", Integer.valueOf(co.guildFund)});

        GuildServiceCenter.getInstance().saveGuild(guild);


        try {
            MailSysData mail = new MailSysData("GuildFundNotice");
            mail.replace = new HashMap<>();
            mail.replace.put("GuildNname", guild.name);
            mail.replace.put("Rank", String.valueOf(rank));
            mail.replace.put("GuildFund", String.valueOf(co.guildFund));
            MailUtil.getInstance().sendMailToOnePlayer(guild.presidentId, (MailData) mail, Const.GOODS_CHANGE_TYPE.def);
        } catch (Exception e) {
            Out.warn(new Object[]{"给盟主再发个邮件.playerId=", guild.presidentId, e});
        }
    }
}


