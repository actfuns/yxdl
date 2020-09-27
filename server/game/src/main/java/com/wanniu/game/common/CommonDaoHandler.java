package com.wanniu.game.common;

import com.wanniu.core.db.handler.DBHandler;


public class CommonDaoHandler
        extends DBHandler {
    private String sql;

    public void run() {
        execute(this.sql);
    }

    public CommonDaoHandler(String sql) {
        this.sql = sql;
    }
}


