package com.wanniu.gm;

import com.wanniu.core.gm.request.GMHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.DateUtils;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;

import java.time.LocalDate;


public class GameInfoHandler
        extends GMHandler {
    public void execute(Packet pak) {
        GWorld.__AREA_ID = pak.getInt();
        GWorld.__ACROSS_SERVER_ID = pak.getInt();
        GWorld.__SERVER_NAME = pak.getString();
        GWorld.__PLAYER_LIMIT = pak.getInt();
        String openTime = pak.getString();

        if (StringUtil.isNotEmpty(openTime)) {

            if (openTime.length() > 10) {
                openTime = openTime.substring(0, 10);
            }
            GWorld.resetOpenServerDate(LocalDate.parse(openTime, DateUtils.F_YYYYMMDD));
        } else {

            GWorld.resetOpenServerDate(LocalDate.now());
        }

        GWorld.__NEW = pak.getBoolean();
        GWorld.__HOT = pak.getBoolean();
        GWorld.__RECOMMEND = pak.getBoolean();
        GWorld.__SHOW = pak.getByte();

        if (pak.remaing() > 0) {
            String externalTime = pak.getString();
            if (StringUtil.isNotEmpty(externalTime)) {
                GWorld.resetExternalTime(externalTime);
            }
        }

        GWorld.getInstance().syncServerInfo();
        Out.info(new Object[]{"gm-server sync game info ok!"});
    }

    public short getType() {
        return 255;
    }
}


