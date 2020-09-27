package com.wanniu.game.player.bi.jsfunny;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.util.DateUtils;
import com.wanniu.game.GWorld;
import com.wanniu.redis.PublishCenter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public abstract class AnsycPublisher {
    private final String uuid;
    protected final LocalDateTime now;
    protected final Map<String, Object> data = new HashMap<>();


    protected abstract String channel();


    protected boolean oneDay() {
        return false;
    }

    public AnsycPublisher() {
        this.now = LocalDateTime.now();
        this.uuid = UUID.randomUUID().toString();
        this.data.put("_id", this.uuid);
        this.data.put("sid", Integer.valueOf(GWorld.__SERVER_ID));
        this.data.put("date", this.now.format(DateUtils.F_YYYYMMDDHHMMSS));


        if (oneDay()) {
            this.data.put("_one_day", Boolean.valueOf(true));
        }
    }

    public void publishing() {
        GWorld.getInstance().ansycExec(() -> PublishCenter.publish(channel(), JSON.toJSONString(this.data)));
    }
}


