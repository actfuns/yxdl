package com.wanniu.game.social;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SocialFriendCO;

import java.util.ArrayList;
import java.util.Map;


public class SocialFriendProps {
    public static SocialFriendCO findByID(int id) {
        Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
        for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
            SocialFriendCO friend = node.getValue();
            if (friend.iD == id) {
                return friend;
            }
        }
        return null;
    }

    public static SocialFriendCO findByMSocialAction(int action) {
        Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
        for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
            SocialFriendCO friend = node.getValue();
            if (friend.mSocialAction == action) {
                return friend;
            }
        }
        return null;
    }

    public static ArrayList<SocialFriendCO> find(String key, Object value) {
        ArrayList<SocialFriendCO> list = new ArrayList<>();
        Map<Integer, SocialFriendCO> SocialFriends = GameData.SocialFriends;
        for (Map.Entry<Integer, SocialFriendCO> node : SocialFriends.entrySet()) {
            SocialFriendCO friend = node.getValue();
            if (key.equals("iD")) {
                if (friend.iD == ((Integer) value).intValue())
                    list.add(friend);
                continue;
            }
            if (key.equals("mSocialAction")) {
                if (friend.mSocialAction == ((Integer) value).intValue())
                    list.add(friend);
                continue;
            }
            if (key.equals("favorNum")) {
                if (friend.favorNum == ((Integer) value).intValue())
                    list.add(friend);
                continue;
            }
            if (key.equals("friendshipNum")) {
                if (friend.friendshipNum == ((Integer) value).intValue())
                    list.add(friend);
                continue;
            }
            if (key.equals("killNum") &&
                    friend.killNum == ((Integer) value).intValue()) {
                list.add(friend);
            }
        }

        return list;
    }
}


