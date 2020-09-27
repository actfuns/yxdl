package com.wanniu.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GSystem;
import com.wanniu.core.http.HttpServer;
import com.wanniu.core.http.HttpServerMsgHandler;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.GCache;
import com.wanniu.login.announce.AnnounceMsgHandler;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class LoginMain {
    public static void main(String[] args) {
        server_main(args);


        startHttpServer();
    }

    public static void server_main(String[] args) {
        GConfig.getInstance().init();
        AnnounceServer.getInstance().init();

        (new Thread(new Runnable() {
            public void run() {
                while (true) {
                    Jedis subscriberJedis = null;
                    try {
                        subscriberJedis = GCache.getRedis();
                        subscriberJedis.subscribe(new JedisPubSub() {
                            public void onMessage(String channel, String message) {
                                try {
                                    JSONObject json = JSON.parseObject(message);
                                    LoginServer.getInstance().distatcher(json);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Out.error(new Object[]{String.format("Message. Channel: %s, Msg: %s", new Object[]{channel, message})});
                                }
                            }


                            public void onSubscribe(String channel, int subscribedChannels) {
                                Out.info(
                                        new Object[]{Integer.valueOf(subscribedChannels), " subscribedChannels onSubscribe: ", channel});
                            }

                            public void onUnsubscribe(String channel, int subscribedChannels) {
                                Out.warn(
                                        new Object[]{Integer.valueOf(subscribedChannels), " subscribedChannels onUnsubscribe: ", channel});
                            }
                        }, new String[]{"/server/login"});
                    } catch (Exception e) {
                        Out.error(new Object[]{"auth redis closed!!!", e.toString()});
                        if (subscriberJedis != null) {
                            GCache.release(subscriberJedis);
                        }
                        GSystem.waitMills(1000);
                    }
                }
            }
        })).start();

        (new Thread(new Runnable() {
            public void run() {
                while (true) {
                    Jedis subscriberJedis = null;
                    try {
                        subscriberJedis = GCache.getRedis();
                        subscriberJedis.subscribe(new JedisPubSub() {
                            public void onMessage(String channel, String message) {
                                try {
                                    AnnounceServer.getInstance().init();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Out.error(new Object[]{String.format("Message. Channel: %s, Msg: %s", new Object[]{channel, message})});
                                }
                            }


                            public void onSubscribe(String channel, int subscribedChannels) {
                                Out.info(
                                        new Object[]{Integer.valueOf(subscribedChannels), " subscribedChannels onSubscribe: ", channel});
                            }

                            public void onUnsubscribe(String channel, int subscribedChannels) {
                                Out.warn(
                                        new Object[]{Integer.valueOf(subscribedChannels), " subscribedChannels onUnsubscribe: ", channel});
                            }
                        }, new String[]{"/login/announce"});
                    } catch (Exception e) {
                        Out.error(new Object[]{"auth redis closed!!!", e.toString()});
                        if (subscriberJedis != null) {
                            GCache.release(subscriberJedis);
                        }
                        GSystem.waitMills(1000);
                    }
                }
            }
        })).start();
        LoginServer.getInstance().start();
    }

    public static void addArea(int areaId, String areaName) {
        GConfig.getInstance().init();
        JSONObject json = new JSONObject();
        json.put("type", Integer.valueOf(261));
        json.put("appId", Integer.valueOf(80));
        json.put("areaId", Integer.valueOf(areaId));
        json.put("areaName", areaName);
        GCache.publish(json);
        Out.info(new Object[]{"已执行！！！"});
        System.exit(1);
    }

    public static void removeArea(int areaId) {
        GConfig.getInstance().init();
        JSONObject json = new JSONObject();
        json.put("type", Integer.valueOf(262));
        json.put("appId", Integer.valueOf(80));
        json.put("areaId", Integer.valueOf(areaId));
        GCache.publish(json);
        Out.info(new Object[]{"已执行！！！"});
        System.exit(1);
    }

    public static void removeServer(int logicServerId) {
        GConfig.getInstance().init();
        JSONObject json = new JSONObject();
        json.put("type", Integer.valueOf(263));
        json.put("appId", Integer.valueOf(80));
        json.put("logicServerId", Integer.valueOf(logicServerId));
        GCache.publish(json);
        Out.info(new Object[]{"已执行！！！"});
        System.exit(1);
    }


    public static void startHttpServer() {
        AnnounceMsgHandler handler = new AnnounceMsgHandler("/announce");
        final HttpServer httpServer = new HttpServer();
        httpServer.addHandler((HttpServerMsgHandler) handler);
        Thread t = new Thread("充值监听：待修改") {
            public void run() {
                try {
                    httpServer.run(GConfig.getInstance().getInt("httpserver.port"));
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        };
        t.start();
    }
}


