package com.wanniu.redis;

import com.wanniu.core.db.QueryVo;
import com.wanniu.core.db.connet.DBClient;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.friend.FriendsCenter;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.game.player.PlayerUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PlayerPOManager {
    public static int MAX_COUNT = 100000;

    public static long EXPIRE = 3600000L;

    public static Map<String, Map<String, GEntity>> pos = new ConcurrentHashMap<>();


    static {
        JobFactory.addScheduleJob(() -> clearOfflinePO(), EXPIRE, EXPIRE);
    }


    private static Map<String, GEntity> getPlayerPOMap(String playerId) {
        Map<String, GEntity> playerPOMap = pos.get(playerId);
        if (playerPOMap == null) {
            playerPOMap = new ConcurrentHashMap<>();
            pos.put(playerId, playerPOMap);
        }
        return playerPOMap;
    }


    public static <T extends GEntity> T findPO(ConstsTR tr, String playerId, Class<T> clazz) {
        GEntity po = null;
        Map<String, GEntity> playerPOMap = getPlayerPOMap(playerId);

        String key = tr.value;
        if (playerPOMap.containsKey(key)) {
            po = playerPOMap.get(key);
        } else {
            po = GameDao.<GEntity>get(playerId, tr, clazz);
            if (po != null) {
                playerPOMap.put(key, po);
            } else {
                po = (GEntity) DBClient.getInstance().get(new QueryVo(tr.value, playerId), clazz);
                if (po != null) {
                    playerPOMap.put(key, po);
                }
            }
        }


        int size = pos.size();
        if (pos.size() > MAX_COUNT) {
            Out.warn(new Object[]{"po count is: ", Integer.valueOf(size)});
            clearOfflinePO();
        }

        return (T) po;
    }


    public static void clearOfflinePO() {
        for (String rid : pos.keySet()) {
            if (!PlayerUtil.isLocal(rid)) {
                MailCenter.getInstance().onPlayerDisponse(rid);
                FriendsCenter.getInstance().onPlayerDisponse(rid);

                update(rid, pos.remove(rid));
            }
        }
    }

    public static void onCloseGame() {
        clearOfflinePO();
    }

    public static void clearOfflinePO(String playerId) {
        if (pos.containsKey(playerId)) {
            MailCenter.getInstance().onPlayerDisponse(playerId);
            FriendsCenter.getInstance().onPlayerDisponse(playerId);

            update(playerId, pos.remove(playerId));
            DBClient.getInstance().onPlayerleave(playerId);
        }
    }


    public static void sync(String playerId) {
        update(playerId, pos.get(playerId));
    }


    private static void update(String playerId, Map<String, GEntity> playerPos) {
        if (playerPos == null) {
            return;
        }
        for (String tr : playerPos.keySet()) {
            GEntity entity = playerPos.get(tr);
            GameDao.update(playerId, tr, entity);
        }
    }


    public static void put(ConstsTR tr, String playerId, GEntity po) {
        Map<String, GEntity> playerPoMap = getPlayerPOMap(playerId);
        playerPoMap.put(tr.value, po);
    }
}


