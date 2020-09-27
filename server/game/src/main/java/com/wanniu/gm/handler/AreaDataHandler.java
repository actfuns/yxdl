package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.NormalMapCO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class AreaDataHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        List<Object> list = new ArrayList();
        for (NormalMapCO m : GameData.NormalMaps.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(m.mapID));
            map.put("text", m.name + " " + m.reqLevel + "级");
            list.add(map);
        }
        JSONObject jo = new JSONObject();
        jo.put("data", list);
        return (GMResponse) new GMJsonResponse(jo.toJSONString());
    }

    public short getType() {
        return 12291;
    }
}


