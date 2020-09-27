package com.wanniu.game.area;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Body;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.Normal_WorldCO;
import com.wanniu.game.data.ResurrectionCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.data.ext.WayTreasureExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.data.ItemToBtlServerData;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.task.po.TaskPO;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public class AreaEvent {
    public static class MonsterData {
        public int templateId;
        public int level;
        public int qColor;
        public String id;
        public String name;
        public String sceneType;
        public int killType;
        public int pro;
        public int drop;
    }

    public static void onTaskEvent(String taskPlayerId, int unitTemplateId) {
        if (StringUtil.isNotEmpty(taskPlayerId)) {
            WNPlayer taskPlayer = PlayerUtil.getOnlinePlayer(taskPlayerId);
            if (taskPlayer != null) {
                if (taskPlayer.isProxy()) {
                    taskPlayer.onProxyEvent(3, body -> body.writeInt(unitTemplateId));


                    return;
                }

                for (TaskPO taskpo : taskPlayer.taskManager.treasureTasks.values()) {
                    TaskBase prop = TaskUtils.getTaskProp(taskpo.templateId);
                    for (String target : prop.targets) {
                        WayTreasureExt way = (WayTreasureExt) GameData.WayTreasures.get(Integer.valueOf(Integer.parseInt(target)));
                        if (way == null) {
                            continue;
                        }
                        if (way.monsterIds.contains(Integer.valueOf(unitTemplateId))) {
                            taskPlayer.taskManager.dealTaskEvent(Const.TaskType.FIND_TREASURE, target, 1);

                            int lastIndex = prop.targets.indexOf(target);
                            if (lastIndex < prop.targets.size() - 1) {
                                TaskUtils.treasurePush(taskPlayer, Integer.parseInt(prop.targets.get(lastIndex + 1)), taskpo.templateId);
                            }

                            return;
                        }
                    }
                }

                List<Normal_WorldCO> normal_WorldCOs = GameData.findNormal_Worlds(t -> (t.type >= 4));
                for (Normal_WorldCO normal_WorldCO : normal_WorldCOs) {
                    if (normal_WorldCO.iD == unitTemplateId) {
                        taskPlayer.onEvent(new TaskEvent(Const.EventType.killBossCount, new Object[]{Integer.valueOf(unitTemplateId), Integer.valueOf(1)}));
                    }
                }

                taskPlayer.onEvent(new TaskEvent(Const.EventType.killMonster, new Object[]{Integer.valueOf(unitTemplateId), Integer.valueOf(1)}));
                taskPlayer.taskManager.dealTaskEvent(Const.TaskType.GOT, String.valueOf(unitTemplateId), 1);
            }
        }
    }

    public static void unitDead(Area area, JSONObject msg) {
        int unitType = msg.getIntValue("unitType");
        String hitFinalPlayerId = msg.getString("hitFinal");
        String belongPlayerId = msg.getString("belongPlayerId");
        JSONArray atkAssistantList = msg.getJSONArray("atkAssistantList");
        WNPlayer hitFinalPlayer = null;
        if (!StringUtil.isEmpty(belongPlayerId)) {
            hitFinalPlayer = area.getPlayer(belongPlayerId);
        }
        if (hitFinalPlayer == null && !StringUtil.isEmpty(hitFinalPlayerId)) {
            hitFinalPlayer = area.getPlayer(hitFinalPlayerId);
        }

        if (unitType == 0) {
            int unitTemplateId = msg.getIntValue("unitTemplateId");


            String refreshPoint = msg.getString("refreshPoint");
            area.removeAliveBoss(Integer.valueOf(unitTemplateId), refreshPoint);

            if (hitFinalPlayer == null) {
                Out.debug(new Object[]{"怪物死亡时，受益人为空. belongPlayerId=", belongPlayerId, ",hitFinalPlayerId=", hitFinalPlayerId});

                return;
            }
            MonsterBase monsterProp = MonsterConfig.getInstance().get(unitTemplateId);
            if (monsterProp == null) {
                if (Arrays.binarySearch(GlobalConfig.Monster_NoDrop_IDLists, unitTemplateId) < 0) {
                    Out.error(new Object[]{"can not get prop from monsterProps by unitDead msg.unitTemplateId:", Integer.valueOf(unitTemplateId)});
                }
            } else {
                List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t ->
                        (t.monsterID == unitTemplateId && t.mapID == area.areaId));

                if (refreshProps != null && !refreshProps.isEmpty()) {
                    MonsterRefreshExt bossExt = refreshProps.get(0);
                    Out.info(new Object[]{"has boss dead:bossId = ", Integer.valueOf(bossExt.monsterID)});
                }

                JSONArray teamSharedIdList = msg.getJSONArray("awardPlayer");

                area.onMonsterDead(unitTemplateId, msg.getIntValue("unitLevel"), msg.getIntValue("posX"), msg.getIntValue("posY"), msg.getIntValue("attackType"), refreshPoint, hitFinalPlayer, teamSharedIdList, atkAssistantList);

                onTaskEvent(hitFinalPlayer.getId(), unitTemplateId);
                int shareType = monsterProp.shareType;
                if (shareType == 1 &&
                        atkAssistantList != null && !atkAssistantList.isEmpty()) {
                    atkAssistantList.forEach(atkAssistant -> {
                        String _playerId = (String) atkAssistant;

                        WNPlayer bindPlayer = area.getPlayer(_playerId);

                        if (_playerId != null && !_playerId.equals(belongPlayerId) && bindPlayer != null && bindPlayer.area.areaId == area.areaId) {
                            onTaskEvent(_playerId, unitTemplateId);
                        }
                    });
                }
                if (teamSharedIdList != null && !teamSharedIdList.isEmpty()) {
                    teamSharedIdList.forEach(teamSharedId -> onTaskEvent((String) teamSharedId, unitTemplateId));
                }
            }

        } else if (unitType == 1) {
            String unitPlayerId = msg.getString("unitPlayerId");
            WNPlayer deadPlayer = area.getPlayer(unitPlayerId);

            Area.Actor actor = area.getActor(unitPlayerId);
            if (actor != null) {
                actor.alive = false;
                ResurrectionCO resurrection = (ResurrectionCO) GameData.Resurrections.get(Integer.valueOf(area.areaId));
                if (resurrection != null && resurrection.resurrectCD > 0) {
                    actor.reliveCoolTime = System.currentTimeMillis() + (resurrection.resurrectCD * 1000);
                }
                if (!PlayerUtil.isOnline(unitPlayerId)) {
                    JobFactory.addDelayJob(() -> area.relive(unitPlayerId, area.getReliveType()), (GlobalConfig.JJC_RebirthTime * 1000));

                }
            } else if (!area.isNormal()) {
                area.recordDie(unitPlayerId);
            }
            if (hitFinalPlayerId != null) {
                if (deadPlayer != null) {
                    area.onPlayerDeadByPlayer(deadPlayer, hitFinalPlayer, msg.getIntValue("posX"), msg.getIntValue("posY"));

                    if (area.needSendKillMail()) {
                        deadPlayer.chouRenManager.beKilledOnce(hitFinalPlayerId);
                        deadPlayer.friendManager.beKilledOnce(hitFinalPlayerId);
                    }
                }

                if (hitFinalPlayer != null &&
                        area.needSendKillMail()) {
                    hitFinalPlayer.chouRenManager.killOtherOnce(unitPlayerId);
                    hitFinalPlayer.friendManager.killOtherOnce(unitPlayerId);
                }

            } else if (deadPlayer != null) {


                area.onPlayerDeadByMonster(deadPlayer, null, msg.getIntValue("posX"), msg.getIntValue("posY"));
            }
            List<ItemToBtlServerData> itemsPayLoad = null;
            List<NormalItem> normalItemsPayLoad = null;
            if (area.isPKDrop()) {
                long pkTime = msg.getLongValue("pkTime");
                if (pkTime < GlobalConfig.PK_Killed_LostEquip_HurtDmgTimeOut) {
                    Object[] objects = area.onPKPlayerDeadDrop(deadPlayer, hitFinalPlayer, msg.getIntValue("pkValue"), msg.getIntValue("posX"), msg.getIntValue("posY"));
                    itemsPayLoad = (List<ItemToBtlServerData>) objects[0];
                    normalItemsPayLoad = (List<NormalItem>) objects[1];
                }
            }


            if (hitFinalPlayer != null && deadPlayer != null && area.needSendKillMail()) {
                MailSysData mailData = null;
                if (itemsPayLoad != null && itemsPayLoad.size() > 0) {
                    mailData = new MailSysData("BeKilledBySomneone1");
                } else {
                    mailData = new MailSysData("BeKilledBySomneone2");
                }
                mailData.replace = new HashMap<>();
                mailData.replace.put("time", DateUtil.format(Calendar.getInstance().getTime()));
                mailData.replace.put("location", area.getSceneName());
                mailData.replace.put("name", hitFinalPlayer.getName());
                if (itemsPayLoad != null && itemsPayLoad.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (NormalItem nItem : normalItemsPayLoad) {

                        String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
                        String itemLink = ChannelUtil.setItemInfo(nItem);
                        DItemEquipBase base = ItemConfig.getInstance().getItemProp(nItem.prop.code);
                        itemText = itemText.replace("{a}", base.name).replace("{b}", itemLink);

                        String numText = LangService.getValue("DEFAULT");
                        numText = numText.replace("{a}", "*" + nItem.getNum());

                        String targetItemText = itemText + numText;

                        stringBuffer.append(targetItemText);
                        stringBuffer.append("、");
                    }

                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);

                    mailData.replace.put("item", stringBuffer.toString());
                }


                MailUtil.getInstance().sendMailToOnePlayer(deadPlayer.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.KILL_PLAYER);
            }
        }
    }


    public static void unitDeadEventB2R(Area area, JSONObject event) {
        area.onUnitDead(event);
    }


    public static void gameOverEventB2R(Area area, JSONObject event) {
        if (!area.isClose()) {
            Out.info(new Object[]{"scene game over:areaId=" + area.areaId + ",instanceId=", area.instanceId});
            area.isClose = true;
            area.onGameOver(event);
            area.addCloseFuture();
        }
    }

    public static void pickItemEventB2R(Area area, JSONObject msg) {
        area.onPickItem(msg.getString("playerId"), msg.getString("itemId"), msg.getBooleanValue("isGuard"));
    }

    public static void messageEventB2R(Area area, JSONObject msg) {
        String paramData, msgArray[] = msg.getString("msg").split(",");
        String type = msgArray[0];
        String playerId = msgArray[1];
        String param = msgArray[2];

        WNPlayer player = area.getPlayer(playerId);
        if (player == null) {
            Out.warn(new Object[]{"AreaEvent player is offline:", playerId, "::", type, "::", param});
            return;
        }
        switch (type) {
            case "accessable":
            case "unaccessable":
                player.taskManager.onTaskRequestEvent(type, Integer.valueOf(param).intValue(), null, 0);
                return;

            case "achievement":
                player.achievementManager.onPlaceArrived(Integer.parseInt(param));
                return;

            case "addUnit":
                player.onEvent(new TaskEvent(Const.EventType.addUnit, new Object[]{area, param}));
                return;

            case "loopTransform":
                JobFactory.addDelayJob(() -> player.onEvent(new TaskEvent(Const.EventType.loopTransform, new Object[]{area, param})), 0L);
                return;


            case "typeArena":
                paramData = msgArray[3];
                area.eatOrLostBuffer(player, param, paramData);
                return;

            case "挖宝事件":
                player.onEvent(new TaskEvent(Const.EventType.addUnit, new Object[]{area, param}));
                return;
        }
    }


    public static void battleReportEventB2R(Area area, JSONObject msg) {
        area.onBattleReport(msg.getJSONArray("data").toJavaList(DamageHealVO.class));
    }

    public static void killBossEventB2R(Area area, JSONObject msg) {
        area.onKillBoss(msg.getString("playerId"));
    }
}


