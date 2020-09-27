package com.wanniu.game.request.task;

import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.team.TeamData;


public class TaskMessages {
    public static final boolean onMessage(WNPlayer player, Const.MESSAGE_TYPE msgType, int operate, MessageData message) {
        if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
            if (message.messageType == Const.MESSAGE_TYPE.daily_task_times.getValue()) {
                if (player.taskManager.dailyTasks.size() > 0) {
                    MessageUtil.sendSysTip(player, LangService.getValue("DAILY_HAS_ACCEPTED"), Const.TipsType.BLACK);
                    return false;
                }

                TaskBase prop = TaskUtils.getRDDailyTask(player.getLevel(), 0, player.getPro());
                AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 2);
                if (result.task != null) {
                    result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
                    player.getPlayerTasks().pushTaskUpdate(result.task);
                    return true;
                }
                MessageUtil.sendSysTip(player, result.msg, Const.TipsType.BLACK);
                return false;
            }

            if (message.messageType == Const.MESSAGE_TYPE.loop_task_addfriend.getValue()) {
                TeamData team = player.teamManager.getTeam();
                if (team != null && !player.getId().equals(team.leaderId)) {
                    player.friendManager.friendApply(team.leaderId, player);
                }
            } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_member_leave.getValue()) {

                TeamData team = player.teamManager.getTeam();
                if (team != null && team.leaderId.equals(player.getId())) {
                    player.teamManager.setIsAutoTeam(true);
                    MessageUtil.sendSysTip(player, LangService.getValue("TEAM_SET_AUTO_SUCC"), Const.TipsType.BLACK);
                    player.teamManager.pushTeamData();
                }
            } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_times.getValue()) {

                TeamData team = player.teamManager.getTeam();
                if (team == null) {
                    MessageUtil.sendSysTip(player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
                    return false;
                }

                if (!team.leaderId.equals(player.getId())) {
                    MessageUtil.sendSysTip(player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
                    return false;
                }


                if (team.memberCount() < 3) {
                    MessageUtil.sendSysTip(player, String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[]{Integer.valueOf(3)}), Const.TipsType.BLACK);
                    return false;
                }


                TaskBase prop = TaskUtils.getFirstLoopTask();
                int templateId = prop.iD;

                AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(templateId, prop.kind);
                if (result.task != null) {
                    result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));

                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        WNPlayer mPlayer = member.getPlayer();
                        if (mPlayer == null)
                            continue;
                        mPlayer.getPlayerTasks().pushTaskUpdate(result.task);
                    }
                } else {
                    Out.error(new Object[]{"accept loop task failed"});
                    return false;
                }
            }
        }

        return true;
    }
}


