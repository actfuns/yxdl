package com.wanniu.game.fightLevel;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.area.FightLevelHandler;


public class DungeonService {
    private static DungeonService instance;

    public static DungeonService getInstance() {
        if (instance == null) {
            instance = new DungeonService();
        }
        return instance;
    }

    private DungeonService() {
        for (Iterator<MonsterRefreshExt> iterator = GameData.MonsterRefreshs.values().iterator(); iterator.hasNext(); ) {
            MonsterRefreshExt refreshExt = iterator.next();
            Date bornBeginTime = AreaUtil.formatToday(refreshExt.rebornBeginTime);
            Date bornEndTime = AreaUtil.formatToday(refreshExt.rebornEndTime);
            long now = System.currentTimeMillis();

            Long nextRefreshTime = Long.valueOf(0L);
            if (now < bornBeginTime.getTime()) {
                nextRefreshTime = Long.valueOf(bornBeginTime.getTime() - now);
            } else if (now < bornEndTime.getTime()) {
                nextRefreshTime = Long.valueOf((refreshExt.coolDownTime * Const.Time.Minute.getValue()) - (now - bornBeginTime.getTime()) % (refreshExt.coolDownTime * Const.Time.Minute.getValue()));
            } else {
                nextRefreshTime = Long.valueOf(DateUtil.getDateAfter(bornBeginTime, 1).getTimeInMillis() - now);
            }

            JobFactory.addFixedRateJob(() -> {
                long nowTime = System.currentTimeMillis();
                Date bornBeginTime_everyday = AreaUtil.formatToday(refreshExt.rebornBeginTime);
                Date bornEndTime_everyday = AreaUtil.formatToday(refreshExt.rebornEndTime);
                Out.info(new Object[]{"begin refresh boss next refresh date:", bornBeginTime_everyday, ",end time:", bornEndTime_everyday, ",bossId=", Integer.valueOf(refreshExt.monsterID)}, );
                if (nowTime >= bornBeginTime_everyday.getTime() && nowTime < bornEndTime_everyday.getTime()) {
                    if (refreshExt.msgSend > 0) {
                        String msg = LangService.getValue("MONSTER_BOSS_REBORN_MESSAGE");
                        MonsterBase monsterProp = MonsterConfig.getInstance().get(refreshExt.monsterID);
                        String monsterName = MessageUtil.getMonsterName(monsterProp.name, monsterProp.qcolor);
                        MapBase areaProp = AreaUtil.getAreaProp(refreshExt.mapID);
                        msg = msg.replace("{name}", monsterName);
                        msg = msg.replace("{site}", areaProp.name);
                        MessageUtil.sendRollChat(GWorld.__SERVER_ID, msg, Const.CHAT_SCOPE.SYSTEM);
                    }
                    for (Area area : AreaManager.getInstance().getAreaMap().values()) {
                        if (area.areaId != refreshExt.mapID) continue;
                        triggerMonster(GWorld.__SERVER_ID, refreshExt.iD, refreshExt.mapID, refreshExt.msgSend, refreshExt.monsterID);
                        Out.debug(new Object[]{"triggerMonster::", Integer.valueOf(refreshExt.iD), ",", Integer.valueOf(refreshExt.mapID), ",", Integer.valueOf(refreshExt.msgSend), ",", Integer.valueOf(refreshExt.monsterID)});
                    }
                }
            }nextRefreshTime


                    .longValue(), (refreshExt.coolDownTime * Const.Time.Minute.getValue()));
        }

    }


    public String enterDungeonInTeam(TeamData team, MapBase prop, int dungeonId) {
        Map<String, TeamData.TeamMemberData> teamMembers = team.teamMembers;
        String data = canEnterDungeon(teamMembers, prop);
        if (data != null) {
            return LangService.format("TEAM_MEMBER_BATTLE_ING", new Object[]{data});
        }

        List<FightLevelHandler.MemberData> memberData = new ArrayList<>();

        for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
            PlayerPO member = teamMember.getPlayerData();
            FightLevelHandler.MemberData.Builder md = FightLevelHandler.MemberData.newBuilder();
            md.setId(teamMember.id);
            md.setName(member.name);
            md.setPro(member.pro);
            md.setLevel(member.level);

            memberData.add(md.build());
        }

        int overTime = GlobalConfig.TeamGoMapLeftTime;

        FightLevelHandler.OnConfirmEnterFubenPush enterFuben = FightLevelHandler.OnConfirmEnterFubenPush.newBuilder().setS2CMsg(LangService.getValue("CONFIRM_ENTRY")).setS2CFubenId(prop.mapID).setS2COverTime(overTime).setS2CLeaderId(team.leaderId).addAllS2CMemberData(memberData).build();

        team.lock(overTime);

        if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {

            for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                teamMember.handup = teamMember.isFollow() ? Const.HandsUpState.ACCEPT.value : Const.HandsUpState.WAITING.value;
                if (teamMember.isBusy()) {
                    teamMember.handup = Const.HandsUpState.REFUSE.value;
                    continue;
                }
                if (teamMember.isLeader || !teamMember.follow) {
                    MessageUtil.sendMessage(teamMember.id, "area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage) enterFuben);
                }
            }
        } else {

            for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                teamMember.handup = teamMember.isLeader ? Const.HandsUpState.ACCEPT.value : Const.HandsUpState.WAITING.value;
                if (teamMember.isBusy()) {
                    teamMember.handup = Const.HandsUpState.REFUSE.value;
                    continue;
                }
                MessageUtil.sendMessage(teamMember.id, "area.fightLevelPush.onConfirmEnterFubenPush", (GeneratedMessage) enterFuben);
            }
        }


        if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
            for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                if (teamMember.isFollow()) {
                    FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(teamMember.id).setS2CIsReady(1).build();
                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        if (member.handup != Const.HandsUpState.REFUSE.value) {
                            MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage) msgData);
                        }
                    }
                }
            }
        } else {
            for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                if (teamMember.handup == Const.HandsUpState.REFUSE.value) {
                    FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(teamMember.id).setS2CIsReady(0).build();
                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        if (member.handup != Const.HandsUpState.REFUSE.value) {
                            MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage) msgData);
                        }
                    }
                }
            }
        }
        return data;
    }

    public String canEnterDungeon(Map<String, TeamData.TeamMemberData> teamMembers, MapBase prop) {
        StringBuilder data = null;
        for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
            if (!teamMember.isOnline()) {
                if (data == null) {
                    data = new StringBuilder();
                }
                PlayerPO playerPO = PlayerUtil.getPlayerBaseData(teamMember.id);
                if (playerPO != null) {
                    data.append(playerPO.name).append("、");
                }
            }
            WNPlayer player = teamMember.getPlayer();
            if (player != null && player.fightLevelManager.canEnterDungeon(player, prop, false) != null) {
                if (data == null) {
                    data = new StringBuilder();
                }
                data.append(player.getName()).append("、");
            }
        }
        return (data == null) ? null : data.substring(0, data.length() - 1);
    }

    private void triggerMonster(int serverId, int propId, int areaId, int send, int monsterId) {
        List<Area> ret = AreaManager.getInstance().getAreaMap().getAreas(areaId, serverId);

        if (ret.size() > 0) {
            int index = RandomUtil.getInt(0, ret.size() - 1);
            Area serverInfo = ret.get(index);

            List<Integer> monsterIds = new ArrayList<>();
            monsterIds.add(Integer.valueOf(propId));
            Area area = AreaUtil.getArea(serverInfo.instanceId);
            if (area != null) {
                area.createMonster(monsterIds, false);
            } else {
                Out.warn(new Object[]{"triggerMonster:", Integer.valueOf(propId), ",", Integer.valueOf(areaId), ",", Integer.valueOf(monsterId), " area is not exist!"});
            }
        } else {
            Out.warn(new Object[]{"triggerMonster:", Integer.valueOf(propId), ",", Integer.valueOf(areaId), ",", Integer.valueOf(monsterId), " area size error!"});
        }
    }
}


