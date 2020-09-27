package com.wanniu.core.db.connet;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.GSystem;
import com.wanniu.core.db.DBType;
import com.wanniu.core.db.QueryVo;
import com.wanniu.core.db.message.DBJoinMessage;
import com.wanniu.core.db.message.DBPingMessage;
import com.wanniu.core.db.message.DBQueryMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.client.ClientCallback;
import com.wanniu.core.tcp.client.ClientWorker;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.tcp.protocol.Prefix;
import com.wanniu.core.tcp.protocol.RequestMessage;
import io.netty.channel.ChannelHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DBClient
        extends ClientWorker {
    private static DBClient instance = new DBClient();

    public static DBClient getInstance() {
        return instance;
    }


    public boolean isEnable() {
        return GConfig.getInstance().isEnableDB();
    }


    public void start() {
        if (isEnable()) {
            this.serverHost = GConfig.getInstance().get("server.db.host");
            this.serverPort = GConfig.getInstance().getInt("server.db.port");
            this.bootstrap = new DBClientBootstrap((ChannelHandler) new DBClientHandler((ClientCallback) this));
            super.start();
        }
    }


    public void add(Message message) {
        if (!isEnable()) {
            return;
        }
        super.add(message);
    }


    public void doStart() {
        Out.info(new Object[]{"开始重新注册DB服务..."});
        Packet pc = this.bootstrap.request((RequestMessage) new DBJoinMessage());
        if (pc == null) {
            if (this.session == null) {
                return;
            }
        } else {
            int status = pc.getInt();
            if (status == 200) {
                registed();
                return;
            }
        }
        Out.info(new Object[]{String.format("无法注册DB服 -> %s:%d", new Object[]{this.serverHost, Integer.valueOf(this.serverPort)})});
        GSystem.waitMills(5000);
        doStart();
    }

    public void registed() {
        Out.info(new Object[]{"成功注册到DB服务，开始等待信息发送..."});
    }


    public void handlePacket(Packet pak) {
        long reqId = pak.getLong();
        response(reqId, pak);
    }


    public void ping() {
        add((Message) new DBPingMessage());
    }

    public <T> T get(QueryVo vo, Class<T> cl) {
        List<T> ts = query(vo, cl);
        if (ts != null && !ts.isEmpty()) {
            return ts.get(0);
        }
        return null;
    }

    public <T> List<T> query(QueryVo vo, Class<T> cl) {
        if (!isEnable()) {
            return new ArrayList<>();
        }
        DBQueryMessage dbQuery = new DBQueryMessage(vo);
        Packet response = request((RequestMessage) dbQuery);
        List<T> result = new ArrayList<>();
        if (response != null) {
            byte[] buf = response.getBytes(Prefix.INT);
            if (buf != null) {
                String res = new String(buf, GGlobal.UTF_8);
                result = JSONObject.parseArray(res, cl);
            }
        }
        return result;
    }

    public void onPlayerleave(final String playerId) {
        if (isEnable())
            getInstance().add(new Message() {
                protected void write() throws IOException {
                    this.body.writeString(playerId);
                }


                public short getType() {
                    return DBType.NOTIFY;
                }
            });
    }
}


