package com.wanniu.game.recent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecentChatMsg {
    public Date recentChatTime = new Date(0L);
    public List<ChatMsg> msgLs = new ArrayList<>();
    public Boolean isRead;
}


