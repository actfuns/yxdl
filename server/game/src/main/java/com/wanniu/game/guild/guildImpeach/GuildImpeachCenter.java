package com.wanniu.game.guild.guildImpeach;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildMsg;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.RoleInfo;
import com.wanniu.game.guild.dao.GuildImpeachDao;
import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GuildImpeachCenter {
    private static GuildImpeachCenter instance;
    Map<String, GuildImpeachData> impeachMap;

    private GuildImpeachCenter() {
        this.impeachMap = new HashMap<>();
        init();
    }

    public static GuildImpeachCenter getInstance() {
        if (instance == null) {
            instance = new GuildImpeachCenter();
        }
        return instance;
    }

    public void init() {
        initFromRedis();

        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildImpeachCenter.this.refreshAllImpeach();
            }
        }, Const.Time.Minute.getValue());
    }

    public void initFromRedis() {
        ArrayList<GuildImpeachData> impeachList = GuildImpeachDao.getImpeachList();
        for (int i = 0; i < impeachList.size(); i++) {
            GuildImpeachData impeach = impeachList.get(i);
            this.impeachMap.put(impeach.id, impeach);
        }
    }

    public void refreshAllImpeach() {
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (null == this.impeachMap || settingProp == null)
            return;
        List<GuildImpeachData> copyList = new ArrayList<>();
        for (GuildImpeachData data : this.impeachMap.values()) {
            copyList.add(data);
        }

        for (GuildImpeachData impeach : copyList) {
            refreshOneImpeachByData(impeach, settingProp);
        }
    }

    public void refreshImpeash(String guildId) {
        GuildImpeachData impeach = getImpeach(guildId);
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        refreshOneImpeachByData(impeach, settingProp);
    }

    public void refreshOneImpeachByData(GuildImpeachData impeach, GuildSettingExt settingProp) {
        if (null == settingProp || null == impeach) {
            return;
        }
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        if (null != impeach) {
            long createTime = impeach.createTime.getTime();
            long nowTime = System.currentTimeMillis();
            if (nowTime - createTime > settingProp.impeachTimeMs) {
                int impeachNum = impeach.playerIds.size();
                if (impeachNum >= settingProp.impeachNo) {
                    autoTransferPresident(impeach.id);
                    removeGuildImpeach(impeach.id);
                } else {

                    GuildRecordData record = new GuildRecordData();
                    record.type = Const.GuildRecord.IMPEACH_TIMEOUT.getValue();
                    RoleInfo role1 = new RoleInfo();
                    role1.pro = impeach.sponsor.pro;
                    role1.name = impeach.sponsor.name;
                    record.role1 = role1;
                    record.result.v2 = Integer.toString(impeach.playerIds.size());
                    guildManager.addGuildRecord(impeach.id, record);
                    removeGuildImpeach(impeach.id);
                }
            }
        }
    }


    public GuildImpeachData getImpeach(String guildId) {
        return this.impeachMap.get(guildId);
    }


    public void addImpeachAndSave(GuildImpeachData impeach) {
        this.impeachMap.put(impeach.id, impeach);
        updateGuildImpeach(impeach.id);
    }

    public void updateGuildImpeach(String guildId) {
        GuildImpeachData impeach = getImpeach(guildId);
        if (null == impeach) {
            return;
        }
        updateGuildImpeachByData(impeach);
    }

    public void removeGuildImpeach(String guildId) {
        GuildImpeachData impeach = getImpeach(guildId);
        if (null == impeach) {
            return;
        }
        removeGuildImpeachByData(impeach);
    }

    public void updateGuildImpeachByData(GuildImpeachData impeach) {
        GuildImpeachDao.updateGuildImpeach(impeach);
    }

    public void removeGuildImpeachByData(GuildImpeachData impeach) {
        GuildImpeachDao.removeGuildImpeachByData(impeach);
        this.impeachMap.remove(impeach.id);
    }

    public void sortGuildMember(List<GuildMemberPO> list) {
        list.sort((memberA, memberB) -> {
            boolean isTodayA = !DateUtil.canRefreshData(5, memberA.lastContributeTime);
            boolean isTodayB = !DateUtil.canRefreshData(5, memberB.lastContributeTime);
            return (isTodayA && isTodayB) ? ((memberA.lastContributeValue != memberB.lastContributeValue) ? ((memberA.lastContributeValue < memberB.lastContributeValue) ? 1 : -1) : ((memberA.createTime.getTime() < memberB.createTime.getTime()) ? -1 : 1)) : (isTodayA ? -1 : (isTodayB ? 1 : ((memberA.createTime.getTime() < memberB.createTime.getTime()) ? -1 : 1)));
        });
    }


    public boolean autoTransferPresident(String guildId) {
        GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
        GuildPO guild = guildManager.getGuild(guildId);
        if (null == guild) {
            return false;
        }

        ArrayList<GuildMemberPO> memberList = guildManager.getGuildMemberList(guildId);
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        if (null == settingProp) {
            return false;
        }


        GuildMemberPO oldPresident = null;
        List<GuildMemberPO> viceGroup = new ArrayList<>();
        List<GuildMemberPO> memberGroup = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            GuildMemberPO member = memberList.get(i);
            if (member.job == Const.GuildJob.VICE_PRESIDENT.getValue()) {
                viceGroup.add(member);
            } else if (member.job == Const.GuildJob.PRESIDENT.getValue()) {
                oldPresident = member;
            } else {
                memberGroup.add(member);
            }
        }

        GuildMemberPO newPresident = null;
        if (viceGroup.size() > 0) {
            sortGuildMember(viceGroup);
            if (!DateUtil.canRefreshData(5, ((GuildMemberPO) viceGroup.get(0)).lastContributeTime)) {
                newPresident = viceGroup.get(0);
            }
        }
        if (null == newPresident && memberGroup.size() > 0) {
            sortGuildMember(memberGroup);
            newPresident = memberGroup.get(0);
        }
        if (null == newPresident) {
            return false;
        }
        oldPresident.job = Const.GuildJob.MEMBER.getValue();
        newPresident.job = Const.GuildJob.PRESIDENT.getValue();
        guild.presidentId = newPresident.playerId;
        guild.presidentPro = newPresident.pro;
        guild.presidentName = newPresident.name;

        guildManager.saveMember(newPresident);
        guildManager.saveMember(oldPresident);
        guildManager.saveGuild(guild);


        Map<String, String> map = new HashMap<>();
        map.put("guildposition", (String) guild.officeNames.get(Integer.valueOf(oldPresident.job)));
        GuildCommonUtil.sendMailSystenType(oldPresident.playerId, "Guild_position", map);

        Map<String, String> newMap = new HashMap<>();
        newMap.put("guildposition", (String) guild.officeNames.get(Integer.valueOf(newPresident.job)));
        GuildCommonUtil.sendMailSystenType(oldPresident.playerId, "Guild_position", newMap);


        GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
        msgData.job = oldPresident.job;
        msgData.jobName = (String) guild.officeNames.get(Integer.valueOf(oldPresident.job));
        GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), (GuildMsg.GuildMsgData) msgData);
        msg.data = (GuildMsg.GuildMsgData) msgData;
        Set<String> ids1 = new HashSet<>();
        ids1.add(oldPresident.playerId);
        GuildService.notifySomePlayerRefreshGuild(ids1, msg, null);

        GuildMsg.RefreshGuildMsg msgData2 = new GuildMsg.RefreshGuildMsg();
        msgData2.job = newPresident.job;
        msgData2.jobName = (String) guild.officeNames.get(Integer.valueOf(newPresident.job));
        GuildMsg msg2 = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), (GuildMsg.GuildMsgData) msgData2);
        msg2.data = (GuildMsg.GuildMsgData) msgData2;
        Set<String> ids2 = new HashSet<>();
        ids1.add(newPresident.playerId);
        GuildService.notifySomePlayerRefreshGuild(ids2, msg, null);

        return true;
    }
}


