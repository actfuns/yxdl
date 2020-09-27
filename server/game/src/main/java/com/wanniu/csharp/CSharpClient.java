package com.wanniu.csharp;


import Xmds.XmdsManagerPrx;
import com.wanniu.core.GGame;
import com.wanniu.core.GSystem;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.csharp.ice.XmdsManager;
import com.wanniu.csharp.ice.ZoneManager;
import com.wanniu.csharp.message.CSharpJoinMessage;
import com.wanniu.csharp.protocol.CSharpMessage;
import com.wanniu.csharp.protocol.CSharpPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.AttributeKey;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public final class CSharpClient {
    private static final AttributeKey<CSharpNode> NodeKey = AttributeKey.valueOf("__KEY.CSharpNode__");


    private static CSharpClient instance = new CSharpClient();


    private CSharpBootstrap bootstrap = new CSharpBootstrap((ChannelHandler) new CSharpSessionHandler());


    private static ConcurrentHashMap<String, Channel> csharpServers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ZoneManager> zoneManagers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, XmdsManager> nbManagers = new ConcurrentHashMap<>();

    public static CSharpClient getInstance() {
        return instance;
    }


    public void start() {
        connectAsync(GGame.__CS_NODE);
    }

    public void connectAsync(CSharpNode node) {
        connectAsync(node, null);
    }

    public void connectAsync(final CSharpNode node, final Runnable cb) {
        (new Thread(new Runnable() {
            public void run() {
                CSharpClient.this.connect(node, cb);
            }
        })).start();
    }

    public void connect(CSharpNode node, Runnable cb) {
        if (!csharpServers.containsKey(node.getNodeId())) {
            Channel channel;
            while ((channel = this.bootstrap.connect(node.host, node.port)) == null) {
                GSystem.waitMills(5000);
                Out.warn(new Object[]{" reconnect ", node});
            }
            channel.attr(NodeKey).set(node);
            bind(channel);
        }
        if (cb != null) {
            cb.run();
        }
    }

    public static ZoneManagerPrx getZoneManager(String csharpServerId) {
        ZoneManager manager = zoneManagers.get(csharpServerId);
        if (manager != null) {
            return manager.getManager();
        }
        return null;
    }

    public static XmdsManagerPrx getXmdsManager(String csharpServerId) {
        XmdsManager manager = nbManagers.get(csharpServerId);
        if (manager != null) {
            return manager.getManager();
        }
        return null;
    }

    public void bind(Channel channel) {
        CSharpNode node = (CSharpNode) channel.attr(NodeKey).get();
        String nodeId = node.getNodeId();
        csharpServers.put(nodeId, channel);

        ZoneManager zoneManager = zoneManagers.get(nodeId);
        if (zoneManager != null)
            zoneManager.destory();
        zoneManager = (new ZoneManager(node)).bind();
        zoneManagers.put(nodeId, zoneManager);

        XmdsManager nbManager = nbManagers.get(nodeId);
        if (nbManager != null)
            nbManager.destory();
        nbManager = (new XmdsManager(node)).bind();
        nbManagers.put(nodeId, nbManager);

        channel.writeAndFlush((new CSharpJoinMessage(nodeId)).getContent()).awaitUninterruptibly(3000L);
    }

    public void close(Channel channel) {
        CSharpNode node = (CSharpNode) channel.attr(NodeKey).get();
        if (node != null) {
            String nodeId = node.getNodeId();
            Out.info(new Object[]{" connect ", node});
            csharpServers.remove(nodeId);
            GGame.getInstance().battleServerClose(nodeId);
            connectAsync(node);
        } else {
            Out.warn(new Object[]{" close ", channel.remoteAddress()});
        }
    }


    public static class Watcher {
        public int count;
        public long buf;
        public Map<Long, CSharpClient.WatcherSecond> ws = new ConcurrentHashMap<>();

        public void inrc(ByteBuf buf) {
            if (!GGame.MONITOR) {
                return;
            }

            this.buf += buf.readableBytes();
            this.count++;

            ((CSharpClient.WatcherSecond) this.ws.computeIfAbsent(Long.valueOf(System.currentTimeMillis() / 1000L), key -> new CSharpClient.WatcherSecond())).inrc(buf);
        }
    }

    public static class WatcherSecond {
        public int count;
        public long buf;

        public void inrc(ByteBuf buf) {
            this.buf += buf.readableBytes();
            this.count++;
        }
    }

    public static Watcher UP = new Watcher();
    public static Watcher DOWN = new Watcher();

    public void dispatch(CSharpMessage msg) {
        Channel channel = csharpServers.get(msg.getServerId());
        if (channel != null) {
            UP.inrc(msg.getContent());
            channel.writeAndFlush(msg.getContent());
        } else {
            Out.error(new Object[]{"dispatch - ", msg.getServerId(), " & ", msg.getHeader().getUid()});
        }
    }

    public void handle(final CSharpPacket pak) {
        String rid = pak.getHeader().getUid();
        GPlayer player = GGame.getInstance().getPlayer(rid);
        if (player == null)
            return;
        PomeloPush push = new PomeloPush() {
            protected void write() throws IOException {
                this.body.writeBytes(pak.getBody().array());
            }


            public String getRoute() {
                return "area.playerPush.battleEventPush";
            }
        };
        (push.getHeader()).compressRoute = true;
        DOWN.inrc(push.getContent());
        Channel session = player.getSession();
        if (session != null) {
            session.writeAndFlush(push.getContent());
        }
    }


    public void gmTestClose() {
        csharpServers.values().forEach(v -> v.close());
    }
}


