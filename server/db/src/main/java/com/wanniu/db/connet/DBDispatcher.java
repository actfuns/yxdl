package com.wanniu.db.connet;

import com.wanniu.core.db.DBType;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.db.handler.NotifyHandler;
import com.wanniu.db.handler.UpdateHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class DBDispatcher implements Runnable {
    private static final int HIGH_WATER = 10000;
    private static final UpdateHandler Update = new UpdateHandler();
    private static final NotifyHandler Notify = new NotifyHandler();


    private static BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>();

    public void run() {
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

    public void add(Packet pak) {
        __QUEUE__.add(pak);
        if (__QUEUE__.size() > 10000) {
            int size = __QUEUE__.size();

            if (size % 500 == 0)
                Out.info(new Object[]{"DB服务处理队列太长: ", Integer.valueOf(size)});
        }
    }

    public void execute(Packet pak) {
        NotifyHandler notifyHandler;
        NetHandler handler = null;
        short type = pak.getPacketType();
        if (type == DBType.UPDATE) {
            UpdateHandler updateHandler = Update;
        } else if (type == DBType.NOTIFY) {
            notifyHandler = Notify;
        } else {
            Out.error(new Object[]{"undefine db handler : ", pak.getHeader().getTypeHexString()});
            return;
        }
        notifyHandler.bindSession(pak.getSession());
        try {
            notifyHandler.execute(pak);
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }

    public int getQueueSize() {
        return __QUEUE__.size();
    }
}


