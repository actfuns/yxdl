package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.friend.BlackActor;
import com.wanniu.game.friend.FriendData;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.friend.MessageDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@DBTable("player_friends")
public class PlayerFriendsPO
        extends GEntity {
    public Map<String, FriendData> friends = new HashMap<>();
    public Date addPointTime = new Date(0L);
    public Date friendShipTime = new Date(0L);
    public int addPointToday;
    public Map<String, FriendManager.ApplyFriendData> applyFriendIds = new HashMap<>();
    public Map<String, BlackActor> blackList = new HashMap<>();
    public List<MessageDate> friendMessage = new ArrayList<>();
    public Map<String, FriendManager.RecordInfo> recordInfos = new HashMap<>();
}


