package com.wanniu.core.gm;

import com.wanniu.core.GConfig;


public class GMType {
    public static final short JOIN = GConfig.getInstance().getShort("gm.type.join", (short) 255);

    public static final short PING = GConfig.getInstance().getShort("gm.type.ping", (short) 242);
}


