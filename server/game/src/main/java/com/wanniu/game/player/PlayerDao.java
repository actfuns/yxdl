package com.wanniu.game.player;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.poes.AchievementDataPO;
import com.wanniu.game.poes.HookSetPO;
import com.wanniu.game.poes.PlayerAttachPO;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerChouRenPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.PlayerTempPO;
import com.wanniu.game.poes.TaskListPO;
import com.wanniu.game.poes.XianYuanPO;
import com.wanniu.redis.GlobalDao;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.List;


public class PlayerDao {
    public static void insertPlayerId(AllBlobPO allBlob) {
        int logicServerId = allBlob.player.logicServerId;
        List<String> rids = getPlayerIdsByUid(allBlob.player.uid, logicServerId);
        rids.add(allBlob.player.id);
        String key = ConstsTR.playerIdsTR + "/" + allBlob.player.uid;
        GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
    }


    public static void insertPlayerId(PlayerPO po, AllBlobPO newBlob) {
        int logicServerId = newBlob.player.logicServerId;
        List<String> rids = getPlayerIdsByUid(newBlob.player.uid, logicServerId);
        rids.add(po.id);
        String key = ConstsTR.playerIdsTR + "/" + newBlob.player.uid;
        GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
    }

    public static List<String> getPlayerIdsByUid(String uid, int logicServerId) {
        String key = ConstsTR.playerIdsTR + "/" + uid;
        String existsRids = GlobalDao.hget(String.valueOf(logicServerId), key);
        List<String> rids = null;
        if (StringUtil.isNotEmpty(existsRids)) {
            rids = (List<String>) JSON.parseObject(existsRids, new TypeReference<List<String>>() {
            }, new com.alibaba.fastjson.parser.Feature[0]);
        }
        return (rids == null) ? new ArrayList<>() : rids;
    }

    public static void updatePlayerIds(String uid, int logicServerId, List<String> rids) {
        String key = ConstsTR.playerIdsTR + "/" + uid;
        GlobalDao.hset(String.valueOf(logicServerId), key, JSON.toJSONString(rids));
    }

    public static AllBlobPO getAllBlobData(String playerId) {
        PlayerPO player = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);

        PlayerBasePO playerBase = (PlayerBasePO) PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);

        PlayerTempPO playerTemp = (PlayerTempPO) PlayerPOManager.findPO(ConstsTR.playerTempTR, playerId, PlayerTempPO.class);

        AllBlobPO allBlobData = new AllBlobPO(player, playerBase, playerTemp);
        allBlobData.playerAttachPO = (PlayerAttachPO) PlayerPOManager.findPO(ConstsTR.playerAttachTR, playerId, PlayerAttachPO.class);
        allBlobData.tasks = (TaskListPO) PlayerPOManager.findPO(ConstsTR.taskTR, playerId, TaskListPO.class);
        allBlobData.achievements = (AchievementDataPO) PlayerPOManager.findPO(ConstsTR.achievementTR, playerId, AchievementDataPO.class);
        allBlobData.hookSetData = (HookSetPO) PlayerPOManager.findPO(ConstsTR.hookSetTR, playerId, HookSetPO.class);
        allBlobData.chouRens = (PlayerChouRenPO) PlayerPOManager.findPO(ConstsTR.player_chourenTR, playerId, PlayerChouRenPO.class);
        allBlobData.xianYuan = (XianYuanPO) PlayerPOManager.findPO(ConstsTR.xianYuanTR, playerId, XianYuanPO.class);

        return allBlobData;
    }


    public static PlayerPO getPlayerDataById(String playerId) throws Exception {
        PlayerPO player = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
        if (null != player && player.isDelete == 0) {
            return player;
        }
        return player;
    }


    public static boolean putName(String name, String playerId) {
        long code = GlobalDao.hsetnx(ConstsTR.NAME_MODULE.value, name, playerId);
        return (code > 0L);
    }


    public static boolean existsName(String name) {
        return GlobalDao.hexists(ConstsTR.NAME_MODULE.value, name);
    }

    public static void freeName(String name) {
        GlobalDao.hremove(ConstsTR.NAME_MODULE.value, name);
    }


    public static String getIdByName(String name) {
        return GlobalDao.hget(ConstsTR.NAME_MODULE.value, name);
    }
}


