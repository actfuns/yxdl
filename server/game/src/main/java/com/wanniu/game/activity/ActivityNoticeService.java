package com.wanniu.game.activity;

import cn.qeng.common.gm.po.GameNoticePO;
import com.alibaba.fastjson.JSON;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Utils;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.activity.ActivityNoticeHandler;
import com.wanniu.redis.GlobalDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ActivityNoticeService {
    private static final ActivityNoticeService instance = new ActivityNoticeService();

    private static final int SYNC_INTERVAL = 60000;

    private long nextSyncTime = System.currentTimeMillis();

    private List<GameNoticePO> cacheNotices = new ArrayList<>();
    private List<String> cacheNoticeIds = new ArrayList<>();

    public static ActivityNoticeService getInstance() {
        return instance;
    }

    public String getNotice(WNPlayer player) {
        long now = System.currentTimeMillis();
        if (now >= this.nextSyncTime) {
            sync(now);
        } else {
            Out.debug(new Object[]{"命中缓存游戏内公告..."});
        }
        ArrayList<ActivityNoticeHandler.ContextInfo> list = new ArrayList<>(this.cacheNotices.size());
        for (GameNoticePO prop : this.cacheNotices) {
            ActivityNoticeHandler.ContextInfo info = new ActivityNoticeHandler.ContextInfo();
            info.ID = prop.getId();
            info.NoticeTitle = prop.getName();
            info.ReleaseTime = prop.getCreateDate();
            info.ReleasePerson = "";
            info.Content = prop.getContent();
            info.isRead = player.activityManager.isReward(prop.getId()) ? 1 : 0;
            list.add(info);
        }
        return JSON.toJSONString(list);
    }

    private void sync(long now) {
        Out.debug(new Object[]{"开始同步游戏内公告..."});
        Map<String, String> map = GlobalDao.hgetAll("game_notice");
        List<GameNoticePO> listPo = new ArrayList<>(map.size());
        List<String> noticeIds = new ArrayList<>();
        map.forEach((k, v) -> {
            listPo.add(Utils.deserialize(v, GameNoticePO.class));

            noticeIds.add(k);
        });
        Collections.sort(listPo, (o1, o2) -> o2.getId() - o1.getId());

        this.cacheNotices = listPo;
        this.cacheNoticeIds = noticeIds;
        this.nextSyncTime = now + 60000L;
    }

    public List<String> getNoticeKey() {
        return this.cacheNoticeIds;
    }
}


