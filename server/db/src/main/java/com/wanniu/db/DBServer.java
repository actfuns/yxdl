package com.wanniu.db;

import com.wanniu.core.GGlobal;
import com.wanniu.core.GSystem;
import com.wanniu.core.db.DBType;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.db.connet.DBDispatcher;
import com.wanniu.db.handler.QueryHandler;
import com.wanniu.db.handler.RegisterHandler;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DBServer {
    public static final DBDispatcher Dispatcher = new DBDispatcher();

    public static final Map<Integer, Channel> Channels = new ConcurrentHashMap<>();

    public static void onProcessExit() {
        while (Dispatcher.getQueueSize() > 0) {
            Out.info(new Object[]{String.format("等待数据保存到数据库，还有【%d】条记录！", new Object[]{Integer.valueOf(Dispatcher.getQueueSize())})});
            GSystem.waitMills(500);
        }
    }

    private static final QueryHandler Query = new QueryHandler();

    public static void handlePacket(Packet pak) {
        short type = pak.getPacketType();
        if (type == DBType.QUERY) {
            Query.execute(pak);
            return;
        }
        if (type == DBType.PING) {
            Out.debug(new Object[]{pak.getAttr(GGlobal._KEY_LOGICSERVERID), " ping..."});
            return;
        }
        if (type == DBType.JOIN) {
            RegisterHandler registerHandler = new RegisterHandler();
            registerHandler.bindSession(pak.getSession());
            registerHandler.execute(pak);
            return;
        }
        Dispatcher.add(pak);
    }


    public static void onClose(Channel channel) {
        Integer logicServerId = (Integer) channel.attr(GGlobal._KEY_LOGICSERVERID).get();
        if (logicServerId != null) {
            Channels.remove(logicServerId);
            Out.info(new Object[]{logicServerId, " close!!!"});
        }
    }
}


