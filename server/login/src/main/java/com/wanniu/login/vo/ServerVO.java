package com.wanniu.login.vo;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.login.LoginServer;
import com.wanniu.login.proto.LoginHandler;
import io.netty.channel.Channel;

import java.io.IOException;
import java.util.Collection;


public class ServerVO {
    public int appId;
    public int areaId;
    public int logicServerId;
    public String name;
    public String host;
    public int port;
    public int show = ServerShow.OUTER.value;
    public int load = ServerLoad.SMOOTH.value;

    public boolean isNew;
    public boolean isHot;
    public boolean isRecommend;
    public int olCount;
    public int olLimit = 1000;

    public String extObj;

    public long pingtime;

    public JSONArray toShowJSON() {
        JSONArray arr = new JSONArray();
        arr.add(Integer.valueOf(this.logicServerId));
        arr.add(this.name);
        arr.add(this.host);
        arr.add(Integer.valueOf(this.port));
        arr.add(Integer.valueOf(this.load));
        arr.add(Integer.valueOf(this.isNew ? 1 : 0));
        arr.add(Integer.valueOf(this.isHot ? 1 : 0));
        arr.add(Integer.valueOf(this.isRecommend ? 1 : 0));
        arr.add(this.extObj);
        return arr;
    }

    public void setLoad(int load) {
        if (this.load != load) {
            this.load = load;
            syncClientState();
        }
    }

    public void setOlCount(int onlineCount) {
        if (onlineCount < 0) {
            this.olCount = 0;
            setLoad(ServerLoad.MAINTAIN.value);
            Out.info(new Object[]{this.name, "维护了。。。"});
        } else {
            int load = ServerLoad.SMOOTH.value;
            this.olCount = onlineCount;
            if (onlineCount >= this.olLimit / 2) {
                load = ServerLoad.FULL.value;
            } else if (onlineCount > this.olLimit / 3) {
                load = ServerLoad.FULL.value;
            } else if (onlineCount > this.olLimit / 8) {
                load = ServerLoad.BUSY.value;
            }
            if (this.load == ServerLoad.MAINTAIN.value) {
                Out.info(new Object[]{this.name, "连接了。。。"});
            }
            setLoad(load);
            this.pingtime = System.currentTimeMillis();
        }
    }

    public void setShow(int show) {
        if (show != this.show) {
            this.show = show;
            syncClientState();
        }
    }

    public void syncClientState() {
        Collection<Channel> channels = LoginServer.getInstance().getLoginSessions().values();
        for (Channel channel : channels) {
            channel.writeAndFlush(new PomeloPush() {
                protected void write() throws IOException {
                    LoginHandler.ServerStatePush.Builder push = LoginHandler.ServerStatePush.newBuilder();
                    String ip = channel.remoteAddress().toString();
                    ip = ip.substring(1, ip.indexOf(":"));
                    String uid = (String) channel.attr(GGlobal._KEY_USER_ID).get();
                    push.setSid(ServerVO.this.logicServerId);
                    if (ServerVO.this.show == ServerShow.OUTER.value || (ServerVO.this.show == ServerShow.INNER.value && LoginServer.getInstance().isWhiteList(ip, uid))) {
                        push.setState(ServerVO.this.load);
                    } else {
                        push.setState(ServerLoad.MAINTAIN.value);
                    }
                    this.body.writeBytes(push.build().toByteArray());
                }


                public String getRoute() {
                    return "login.loginPush.serverStatePush";
                }
            });
        }
    }

    public String toString() {
        return String.valueOf(this.appId) + " : " + this.logicServerId + " - " + this.name + " ->　" + this.host + ":" + this.port;
    }
}


