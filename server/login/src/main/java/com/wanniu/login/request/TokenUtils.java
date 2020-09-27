package com.wanniu.login.request;

import java.util.HashMap;
import java.util.Map;


public class TokenUtils {
    public static Map<String, String> build(String channel, String uid, String mac, String os) {
        Map<String, String> tokenInfo = new HashMap<>();
        tokenInfo.put("channel", channel);
        tokenInfo.put("uid", uid);
        tokenInfo.put("mac", mac);
        tokenInfo.put("os", os);
        return tokenInfo;
    }
}


