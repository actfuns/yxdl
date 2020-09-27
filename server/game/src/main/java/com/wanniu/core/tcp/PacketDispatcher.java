package com.wanniu.core.tcp;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.request.GameHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Header;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.tcp.server.IPBlacks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public abstract class PacketDispatcher
        implements Runnable {
    private static final String GET_SYSTIME_REQUEST = "getSysTimeRequest";
    private static final int __CAPACITY__ = GConfig.getInstance().getInt("client.dispatcher.capacity", 100000);

    private static final int __WARN_COUNT__ = __CAPACITY__ * 2 / 3;

    private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("client.monitor.enable", true);


    private final BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>(__CAPACITY__);


    protected final Map<Short, NetHandler> handlers = new HashMap<>();
    protected final Map<String, NetHandler> s_handlers = new HashMap<>();

    public int getHandlerCount() {
        return this.handlers.size() + this.s_handlers.size();
    }

    public void echo() {
        for (Short key : this.handlers.keySet()) {
            System.out.println("\t" + Integer.toHexString(key.intValue()));
        }
        for (Map.Entry<String, NetHandler> key : this.s_handlers.entrySet()) {
            System.out.println("\t" + ((((NetHandler) key.getValue()).getType() != 0) ? ("0x" + Integer.toHexString(((NetHandler) key.getValue()).getType()) + " : ") : "") + (String) key.getKey());
        }
    }


    private boolean __running__ = true;

    public NetHandler getHandler(String route) {
        return this.s_handlers.get(route);
    }


    public void registerHandler(NetHandler handler) {
        if (handler.getClass().isAnnotationPresent((Class) GClientEvent.class)) {
            GClientEvent handle = handler.getClass().<GClientEvent>getAnnotation(GClientEvent.class);
            GGame.getInstance().addGlobalRoute(handle.value(), this);
            this.s_handlers.put(handle.value(), handler);
            ((GameHandler) handler).watcher.handlerName = handle.value();
        } else {
            this.handlers.put(Short.valueOf(handler.getType()), handler);
        }
    }


    public boolean add(Packet packet) {
        if (this.__running__) {
            if (this.__QUEUE__.size() > __WARN_COUNT__) {
                Out.info(new Object[]{"队列偏大 -> ", Integer.valueOf(this.__QUEUE__.size())});
            }
            if (this.__QUEUE__.offer(packet)) {
                return true;
            }
            Out.error(new Object[]{"队列过大，丢弃了请求：", packet.getHeader().getTypeHexString()});
            return false;
        }

        return false;
    }


    public void stop() {
        this.__running__ = false;
    }

    public final void run() {
        Packet packet = null;
        while (true) {
            try {
                packet = this.__QUEUE__.take();
                if (__MONITOR_ENABLE__) {

                    long startExecuteTime = System.nanoTime();

                    Header header = packet.getHeader();
                    execute(packet);


                    long endExecuteTime = System.nanoTime();

                    float delay = (float) (startExecuteTime - header.getReceiveTime()) / 1000000.0F;
                    float exec = (float) (endExecuteTime - startExecuteTime) / 1000000.0F;

                    String protocal = header.getTypeHexString();
                    if (Out.isEnableDebug() || !protocal.endsWith("getSysTimeRequest")) {
                        GPlayer player = packet.getPlayer();
                        Out.info(new Object[]{"handle ", protocal, ", delay=", Float.valueOf(delay), " ms, exec=", Float.valueOf(exec), " ms, playerId=", (player == null) ? Integer.valueOf(0) : player.getId()});
                    }
                    continue;
                }
                execute(packet);
            } catch (Exception e) {
                Out.error(new Object[]{String.format("处理句柄【%s】出错 -> %s", new Object[]{packet.getHeader().getTypeHexString(), e.toString()}), e});
                IPBlacks.getInstance().exceptionIp(packet.getSession());
            }
        }
    }

    public abstract void execute(Packet paramPacket);
}


