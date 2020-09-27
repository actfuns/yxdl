package com.wanniu.login;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.ConstsTR;
import com.wanniu.core.redis.GCache;
import com.wanniu.login.po.AnnouncementPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AnnounceServer {
    private static AnnounceServer instance = new AnnounceServer();

    public static AnnounceServer getInstance() {
        return instance;
    }


    public static AnnouncementPO announce;


    public void init() {
        announce = null;

        Map<String, String> map = GCache.hgetAll(ConstsTR.announcement.value);
        List<AnnouncementPO> list = new ArrayList<>();
        map.forEach((k, v) -> paramList.add((AnnouncementPO) JSON.parseObject(v, AnnouncementPO.class)));


        for (AnnouncementPO p : list) {
            if (p.isUse) {
                announce = p;
                Out.info(new Object[]{"读取登录公告：" + announce.content});
            }
        }
    }
}


