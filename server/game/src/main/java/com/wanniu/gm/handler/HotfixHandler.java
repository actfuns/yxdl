package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.game.hotupdate.HotUpdateService;
import com.wanniu.gm.GMByteArgsHandler;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;


@GMEvent
public class HotfixHandler
        extends GMByteArgsHandler {
    public short getType() {
        return 2;
    }


    public GMResponse execute(JSONArray arr, byte[] bytes) {
        String className = arr.getString(0);
        String code = HotUpdateService.changeClass(className, bytes);
        return (GMResponse) new GMJsonResponse(code);
    }
}


