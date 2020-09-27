package com.wanniu.game.area;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;
import io.netty.channel.Channel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import pomelo.area.PlayerHandler;
import pomelo.area.TaskHandler;
import pomelo.player.PlayerOuterClass;


public class PlayerRemote {
    public static boolean isValidName(String randomName) {
        if (StringUtil.isEmpty(randomName) || randomName.length() > GWorld.__SERVER_LANG.getNameLimit()) {
            return false;
        }
        return !PlayerDao.existsName(randomName);
    }


    public static String getRandomName(int pro, int logicServerId) {
        try {
            String randomName = PlayerUtil.getRandomName(pro);
            for (int i = 0; i < 20; i++) {
                boolean isValid = isValidName(randomName);
                if (isValid) {
                    break;
                }
                randomName = PlayerUtil.getRandomName(pro);
                Out.debug(new Object[]{PlayerRemote.class, "重新随机名字   count : ", Integer.valueOf(i), " ---name: ", randomName});
            }
            return randomName;
        } catch (Exception e) {
            Out.error(new Object[]{PlayerRemote.class, "生成随机名字出错", e.getMessage()});
            return PlayerUtil.getRandomName(pro);
        }
    }


    public static WNPlayer createPlayer(String uid, String name, int pro, int logicServerId) {
        String playerId = UUID.randomUUID().toString();
        boolean isPutSuccess = PlayerDao.putName(name, playerId);
        if (!isPutSuccess) {
            Out.warn(new Object[]{"发现有玩家重名,创角失败!", name});
            return null;
        }


        if (!GameDao.putName(name, playerId)) {
            Out.warn(new Object[]{"建立本服角色列表时异常啦!", name});
        }

        AllBlobPO playerData = PlayerUtil.createPlayer(playerId, uid, name, pro, logicServerId);
        PlayerDao.insertPlayerId(playerData);


        return new WNPlayer(playerData);
    }


    public static void playerEnterAreaServerInner(WNPlayer player, Area area) {
        try {
            player.initBornData();

            player.write((Message) new PomeloPush() {
                protected void write() throws IOException {
                    PlayerHandler.BattleClearPush.Builder push = PlayerHandler.BattleClearPush.newBuilder();
                    push.setS2CName("");
                    this.body.writeBytes(push.build().toByteArray());
                }


                public String getRoute() {
                    return "area.playerPush.battleClearPush";
                }
            });

            if (player.getState() == 1) {
                AreaUtil.changeAreaPush(player, area.areaId, area.instanceId);
            } else {
                Out.warn(new Object[]{"change scene err!!!playerId=", player.getId(), ",areaId=", Integer.valueOf(area.areaId), ",instanceId=", area.instanceId});
            }

            area.addPlayer(player);


            if (area.sceneType != Const.SCENE_TYPE.NORMAL.getValue() && area.sceneType != Const.SCENE_TYPE.FIGHT_LEVEL.getValue() && area.sceneType != Const.SCENE_TYPE.LOOP.getValue()) {
                TaskHandler.TaskAutoPush.Builder autoPush = TaskHandler.TaskAutoPush.newBuilder();
                autoPush.setAuto(0);
                player.receive("area.taskPush.taskAutoPush", (GeneratedMessage) autoPush.build());
            }
        } catch (Exception error) {
            Out.error(new Object[]{error});
        }
    }

    public static void playerEnterAreaServer(WNPlayer player, String instanceId) {
        Area oldArea = player.getArea();
        if (oldArea != null) {
            oldArea.removePlayer(player, false);
        }
        Area area = AreaUtil.getArea(instanceId);

        playerEnterAreaServerInner(player, area);
    }


    public static void syncPlayerDataOffline(WNPlayer player, Area area) {
        player.setBornType(Const.BORN_TYPE.NORMAL);
        player.setEnterState(Const.ENTER_STATE.online.value);

        if (area.prop.disConnToMapID != 0) {
            String result = player.getXmdsManager().getBornPlace(area.instanceId, (AreaUtil.getAreaProp(area.prop.disConnToMapID)).templateID);
            JSONObject res = JSON.parseObject(result);
            player.syncBornData(res.getIntValue("x"), res.getIntValue("y"), area.prop.disConnToMapID);
        }


        player.soloManager.onPlayerOffline();
        Out.debug(new Object[]{PlayerRemote.class, "player.soloManager.quitMatching()"});
        player.friendManager.onPlayerOffline();
        player.onlineGiftManager.onPlayerOffline();
        player.five2FiveManager.onPlayerOffline();

        player.guildManager.onLogout();
    }


    public static List<PlayerOuterClass.PlayerBasic> getPlayersByUidAndLogicServerId(Channel channel, String uid, int logicServerId, String ip) {
        List<String> list_ids = PlayerDao.getPlayerIdsByUid(uid, logicServerId);
        if (list_ids.isEmpty()) {
            BILogService.getInstance().ansycReportRegister(channel, uid, ip);
        }

        List<PlayerPO> playerDatas = new ArrayList<>(list_ids.size());
        for (String playerId : list_ids) {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
            if (baseData != null && baseData.isDelete == 0) {
                playerDatas.add(baseData);
            }
        }

        playerDatas.sort(new Comparator<PlayerPO>() {
            public int compare(PlayerPO p0, PlayerPO p1) {
                Date loginTime0 = p0.loginTime;
                Date loginTime1 = p1.loginTime;
                if (loginTime0 == null)
                    return -1;
                if (loginTime1 == null) {
                    return 1;
                }
                if (loginTime1.getTime() == loginTime0.getTime()) {
                    return 0;
                }
                return (loginTime1.getTime() > loginTime0.getTime()) ? -1 : 1;
            }
        });


        List<PlayerOuterClass.PlayerBasic> playerBasics = new ArrayList<>();

        for (PlayerPO playerData : playerDatas) {
            AllBlobPO allblobData = PlayerDao.getAllBlobData(playerData.id);
            playerBasics.add(PlayerUtil.transToJson4BasicByBlob(allblobData));
        }
        return playerBasics;
    }
}


