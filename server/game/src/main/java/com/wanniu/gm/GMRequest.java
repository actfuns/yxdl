package com.wanniu.gm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.gm.request.GMHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.gm.handler.GMBaseHandler;

import java.util.HashMap;
import java.util.Map;

public class GMRequest
        extends GMHandler {
    private static final Map<Short, GMBaseHandler> handlers = new HashMap<>();

    public static void addHandler(GMBaseHandler handler) {
        handlers.put(Short.valueOf(handler.getType()), handler);
    }


    public void execute(Packet pak) {
        long key = pak.getLong();
        short op = pak.getShort();
        JSONArray arr = JSON.parseArray(pak.getString());

        GMResponse res = null;
        GMBaseHandler handler = handlers.get(Short.valueOf(op));
        if (handler != null) {

            try {
                if (handler instanceof GMByteArgsHandler) {
                    res = ((GMByteArgsHandler) handler).execute(arr, pak.getRemaingBytes());
                } else {

                    res = handler.execute(arr);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
                res = new GMErrorResponse();
            }
        } else {
            Out.error(new Object[]{"GMRequest : ", Long.valueOf(key), " - 0x", Integer.toHexString(op), " - "});
            res = new GMErrorResponse();
        }
        if (res != null) {
            res.setKey(key);
            pak.getSession().writeAndFlush(res);
        }
    }


    public short getType() {
        return 2748;
    }
}


