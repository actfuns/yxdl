package com.wanniu.core.db;

import com.wanniu.core.GConfig;


public class DBType {
    public static final short JOIN = GConfig.getInstance().getShort("db.type.join", (short) 13297);

    public static final short PING = GConfig.getInstance().getShort("db.type.ping", (short) 13298);

    public static final short UPDATE = GConfig.getInstance().getShort("db.type.update", (short) 13299);

    public static final short QUERY = GConfig.getInstance().getShort("db.type.query", (short) 13300);

    public static final short NOTIFY = GConfig.getInstance().getShort("db.type.notify", (short) 13301);
}


