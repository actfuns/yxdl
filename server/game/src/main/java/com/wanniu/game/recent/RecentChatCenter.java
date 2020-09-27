package com.wanniu.game.recent;

import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.poes.RecentChatPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.HashMap;
import java.util.Map;


public class RecentChatCenter {
    private static RecentChatCenter instance;
    private Map<String, RecentChatMgr> recentChatMgrs = new HashMap<>();


    public static RecentChatCenter getInstance() {
        if (null == instance) {
            instance = new RecentChatCenter();
        }
        return instance;
    }

    public RecentChatMgr getRecentChatMgr(String playerId) {
        if (this.recentChatMgrs.containsKey(playerId)) {
            return this.recentChatMgrs.get(playerId);
        }

        RecentChatPO po = (RecentChatPO) PlayerPOManager.findPO(ConstsTR.playerRecentChatTR, playerId, RecentChatPO.class);
        RecentChatMgr recentChatMgr = new RecentChatMgr(playerId, po);
        this.recentChatMgrs.put(playerId, recentChatMgr);
        return recentChatMgr;
    }
}


