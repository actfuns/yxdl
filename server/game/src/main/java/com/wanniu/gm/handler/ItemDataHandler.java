package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class ItemDataHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        List<Object> list = new ArrayList();
        for (DItemBase it : ItemConfig.getInstance().getItemTemplates().values()) {
            Map<String, String> map = new HashMap<>();
            map.put("id", it.code);
            map.put("text", it.name);
            list.add(map);
        }
        for (DEquipBase it : ItemConfig.getInstance().getEquipTemplates().values()) {
            Map<String, String> map = new HashMap<>();
            map.put("id", it.code);
            map.put("text", it.name);
            list.add(map);
        }
        return (GMResponse) new GMJsonResponse(JSON.toJSONString(list));
    }

    public short getType() {
        return 12336;
    }
}


