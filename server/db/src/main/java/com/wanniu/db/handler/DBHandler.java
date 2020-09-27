package com.wanniu.db.handler;

import com.wanniu.core.tcp.protocol.NetHandler;


public abstract class DBHandler
        extends NetHandler {
    public static String tableName(String tr) {
        return "tb_" + tr;
    }
}


