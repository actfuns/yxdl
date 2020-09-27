package com.wanniu.core.tcp;

import com.wanniu.core.GConfig;
import com.wanniu.core.GServer;
import com.wanniu.core.game.request.GClientEvent;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public abstract class PacketDispatcher
        implements Runnable {
    private static final int __CAPACITY__ = GConfig.getInstance().getInt("client.dispatcher.capacity", 5000);

    private static final int __WARN_COUNT__ = __CAPACITY__ * 2 / 3;

    private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("client.monitor.enable", true);


    private final BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>(__CAPACITY__);


    protected final Map<Short, NetHandler> handlers = new HashMap<>();
    protected final Map<String, NetHandler> s_handlers = new HashMap<>();


    private boolean __running__ = true;


    public void registerHandler(NetHandler handler) {
        if (handler.getClass().isAnnotationPresent((Class) GClientEvent.class)) {
            GClientEvent handle = handler.getClass().<GClientEvent>getAnnotation(GClientEvent.class);
            GServer.getInstance().addGlobalRoute(handle.value(), this);
            this.s_handlers.put(handle.value(), handler);
        } else {
            this.handlers.put(Short.valueOf(handler.getType()), handler);
        }
    }


    public boolean add(Packet packet) {
        if (this.__running__) {
            if (this.__QUEUE__.size() > __WARN_COUNT__) {
                Out.info(new Object[]{"队列偏大 -> " + this.__QUEUE__.size()});
            }
            if (this.__QUEUE__.offer(packet)) {
                return true;
            }
            Out.error(new Object[]{"队列过大，丢弃了请求：" + packet.getHeader().getTypeHexString()});
            return false;
        }

        return false;
    }


    public void stop() {
        this.__running__ = false;
    }

    public final void run() {
        Packet packet = null;
        long sTime = 0L;
        while (true) {
            try {
                packet = this.__QUEUE__.take();
                if (__MONITOR_ENABLE__) {
                    sTime = System.currentTimeMillis();
                    execute(packet);
                    if (System.currentTimeMillis() - sTime > 100L)
                        Out.warn(new Object[]{String.format("处理句柄【%s】耗时 -> %s", new Object[]{packet.getHeader().getTypeHexString(), Long.valueOf(System.currentTimeMillis() - sTime)})});
                    continue;
                }
                execute(packet);
            } catch (Exception e) {
                Out.error(new Object[]{String.format("处理句柄【%s】出错 -> %s", new Object[]{packet.getHeader().getTypeHexString(), e.toString()}), e});
            }
        }
    }

    public abstract void execute(Packet paramPacket);
}


