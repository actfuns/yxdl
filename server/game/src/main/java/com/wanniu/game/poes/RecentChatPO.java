package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.recent.RecentChatMsg;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_recent_chat")
public class RecentChatPO
        extends GEntity {
    public Map<String, RecentChatMsg> msg = new HashMap<>();
}


