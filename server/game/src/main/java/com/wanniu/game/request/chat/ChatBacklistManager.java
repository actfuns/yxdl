package com.wanniu.game.request.chat;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.util.StringUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ChatBacklistManager {
    private static final ChatBacklistManager instance = new ChatBacklistManager();
    private final ConcurrentMap<String, Long> backlist = new ConcurrentHashMap<>();

    public static ChatBacklistManager getInstance() {
        return instance;
    }

    public boolean inBacklist(String ip) {
        if (StringUtil.isNotEmpty(ip)) {
            return this.backlist.containsKey(ip);
        }
        return false;
    }

    public void addIp(String ip) {
        this.backlist.put(ip, Long.valueOf(System.currentTimeMillis()));
    }

    public void remove(String ip) {
        this.backlist.remove(ip);
    }

    public String toString() {
        return JSON.toJSONString(this.backlist);
    }
}


