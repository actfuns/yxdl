package com.wanniu.core.gm;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;


class GMDispatcher
        implements Runnable {
    private static final int HIGH_WATER = 500;
    private static BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>();


    Map<Short, NetHandler> handlers = new ConcurrentHashMap<>();


    public void registerHandler(NetHandler handler) {
        if (this.handlers.containsKey(Short.valueOf(handler.getType()))) {
            Out.warn(new Object[]{"register more gm handler : 0x", Integer.toHexString(handler.getType())});
        }
        this.handlers.put(Short.valueOf(handler.getType()), handler);
    }

    public void add(Packet mo) {
        __QUEUE__.add(mo);
        if (__QUEUE__.size() > 500) {
            Out.info(new Object[]{"GM服务处理队列太长: ", Integer.valueOf(__QUEUE__.size())});
        }
    }

    public final void run() {
        while (true) {
            try {
                while (true) {
                    Packet msg = __QUEUE__.take();
                    execute(msg);
                }
                break;
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }

    public void execute(Packet action) {
        NetHandler handler = this.handlers.get(Short.valueOf(action.getPacketType()));
        if (handler != null) {
            handler.execute(action);
        } else {
            Out.warn(new Object[]{"GM系统未找到对应的消息处理句柄：", action.getHeader().getTypeHexString()});
        }
    }
}


