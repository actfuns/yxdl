package com.wanniu.game.friend;

import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.poes.PlayerFriendsPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.HashMap;
import java.util.Map;


public class FriendsCenter {
    private static FriendsCenter instance;
    private Map<String, FriendManager> friendsMgr;

    public static synchronized FriendsCenter getInstance() {
        if (null == instance) {
            instance = new FriendsCenter();
        }
        return instance;
    }

    private FriendsCenter() {
        this.friendsMgr = new HashMap<>();
    }

    public Map<String, FriendManager> getAllFriendMgr() {
        return this.friendsMgr;
    }

    public void onPlayerDisponse(String playerId) {
        this.friendsMgr.remove(playerId);
    }


    public FriendManager getFriendsMgr(String playerId) {
        if (this.friendsMgr.containsKey(playerId)) {
            return this.friendsMgr.get(playerId);
        }

        PlayerFriendsPO po = (PlayerFriendsPO) PlayerPOManager.findPO(ConstsTR.player_friendsTR, playerId, PlayerFriendsPO.class);

        FriendManager friendMgr = new FriendManager(playerId, po);
        this.friendsMgr.put(playerId, friendMgr);
        return friendMgr;
    }


    public Map<String, Object> friendAgreeApply(String selfId, String requestId) {
        FriendManager friendMgr = getFriendsMgr(selfId);
        return friendMgr.friendAgreeApply(requestId);
    }
}


