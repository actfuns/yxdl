package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.wanniu.core.db.GCache;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.Map;


@GMEvent
public class RedisCommandHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String command = arr.getString(0);

        Object result = null;
        switch (command) {
            case "HVALS":
                result = GCache.hvals(arr.getString(1));
                break;
            case "HGETALL":
                result = GCache.hgetAll(arr.getString(1));
                break;
            case "HMSET":
                GCache.hmset(arr.getString(1), (Map) JSON.parseObject(arr.getString(2), new TypeReference<Map<String, String>>() {
                }, new com.alibaba.fastjson.parser.Feature[0]));
                break;
        }


        return (GMResponse) new GMJsonResponse(JSON.toJSONString(result));
    }


    public short getType() {
        return 8;
    }
}


