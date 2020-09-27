package com.wanniu.game.five2Five.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.five2Five.Five2FivePlayerResultInfoVo;
import com.wanniu.game.poes.Five2FivePO;
import com.wanniu.game.poes.Five2FivePlayerBtlReportPO;
import com.wanniu.game.poes.Five2FiveSystemPO;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


public class Five2FiveDao {
    public static void updateFive2FiveSystem(Five2FiveSystemPO systemPo) {
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fivie2FiveSystemTR, systemPo);
    }


    public static Five2FiveSystemPO getFive2FivePO(String logicServerId) {
        return (Five2FiveSystemPO) GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.fivie2FiveSystemTR, Five2FiveSystemPO.class);
    }


    public static void updatePlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
        Jedis redis = GCache.getRedis();
        try {
            Transaction multi = redis.multi();
            multi.hset(getBtlReportTR(btlPo.playerId), btlPo.id, Utils.serialize(btlPo));
            multi.exec();
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            GCache.release(redis);
        }
    }


    public static void delPlayerFive2FiveBtlReportPO(Five2FivePlayerBtlReportPO btlPo) {
        Jedis redis = GCache.getRedis();
        try {
            Transaction multi = redis.multi();
            multi.hdel(getBtlReportTR(btlPo.playerId), new String[]{btlPo.id});
            multi.exec();
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            GCache.release(redis);
        }
    }


    public static Five2FivePO getPlayerFive2FivePO(String playerId) {
        return (Five2FivePO) PlayerPOManager.findPO(ConstsTR.five2FiveTR, playerId, Five2FivePO.class);
    }


    public static List<Five2FivePlayerBtlReportPO> getPlayerFive2FiveBtlReportPO(String playerId) {
        List<Five2FivePlayerBtlReportPO> list = new ArrayList<>();
        Map<String, String> dataMap = GCache.hgetAll(getBtlReportTR(playerId));
        if (dataMap != null && !dataMap.isEmpty()) {
            for (String data : dataMap.values()) {
                Five2FivePlayerBtlReportPO btlReportPo = (Five2FivePlayerBtlReportPO) Utils.deserialize(data, Five2FivePlayerBtlReportPO.class);
                if (btlReportPo != null) {
                    list.add(btlReportPo);
                }
            }
        }
        Collections.sort(list, new Comparator<Five2FivePlayerBtlReportPO>() {
            public int compare(Five2FivePlayerBtlReportPO o1, Five2FivePlayerBtlReportPO o2) {
                long i = o2.createTime.getTime() - o1.createTime.getTime();
                if (i > 0L)
                    return 1;
                if (i < 0L) {
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }


    public static void updateShardBtlReport(String instanceId, List<Five2FivePlayerResultInfoVo> resultInfos) {
        String resultInfoJson = Utils.serialize(resultInfos);
        int expired = 86400;
        GCache.put(getShardBtlReportTR(instanceId), resultInfoJson, expired);
    }


    public static List<Five2FivePlayerResultInfoVo> getShardBtlReport(String instanceId) {
        String data = GCache.get(getShardBtlReportTR(instanceId));
        List<Five2FivePlayerResultInfoVo> resultInfos = new ArrayList<>();
        if (StringUtil.isNotEmpty(data)) {
            resultInfos = (List<Five2FivePlayerResultInfoVo>) JSON.parseObject(data, new TypeReference<List<Five2FivePlayerResultInfoVo>>() {
            }, new com.alibaba.fastjson.parser.Feature[0]);
        }
        return resultInfos;
    }


    private static String getBtlReportTR(String playerId) {
        return ConstsTR.five2FiveBtlTR.value + "/" + playerId;
    }


    private static String getShardBtlReportTR(String instanceId) {
        return ConstsTR.five2FiveShardBtlReportTR.value + "/" + instanceId;
    }
}


