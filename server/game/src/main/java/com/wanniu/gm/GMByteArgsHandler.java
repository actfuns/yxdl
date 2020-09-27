package com.wanniu.gm;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.gm.handler.GMBaseHandler;


public abstract class GMByteArgsHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        throw new RuntimeException("2进制参数的处理类不能走这里...");
    }

    public abstract GMResponse execute(JSONArray paramJSONArray, byte[] paramArrayOfbyte);
}


