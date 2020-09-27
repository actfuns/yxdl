package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.GConfig;
import com.wanniu.core.util.DataUtil;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@GMEvent
public class ReloadScriptHandler
        extends GMBaseHandler {
    public enum ScriptType {
        ACTIVITY_LIST,

        SIGN,

        ONLINE_GIFT,

        LEVEL_GIFT,

        POWER_GIFT,

        OPEN_SERVER;
    }

    public GMResponse execute(JSONArray arr) {
        String types = arr.getString(0);
        List<File> files = new ArrayList<>();
        for (String t : types.split(";")) {
            int type = Integer.parseInt(t);
            String path = GConfig.getInstance().get("dir.game.data");
            if (type == ScriptType.ACTIVITY_LIST.ordinal()) {
                files.add(new File(path + "/activity/Activity/Activity.json"));
            } else if (type == ScriptType.SIGN.ordinal()) {
                files.add(new File(path + "/sign/sign/accumulate.json"));
                files.add(new File(path + "/sign/sign/luxury_sign.json"));
                files.add(new File(path + "/sign/sign/normal_sign.json"));
            } else if (type == ScriptType.ONLINE_GIFT.ordinal()) {
                files.add(new File(path + "/activity/OnlineGift/OlGift.json"));
            } else if (type == ScriptType.LEVEL_GIFT.ordinal()) {
                files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
            } else if (type == ScriptType.POWER_GIFT.ordinal()) {
                files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
            } else if (type == ScriptType.OPEN_SERVER.ordinal()) {
                files.add(new File(path + "/activity/Activity/ActivityConfig.json"));
            }
        }
        for (File f : files) {
            if (f.exists()) {
                DataUtil.loadData(f);
            }
        }
        DataUtil.initProperty();
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 24592;
    }
}


