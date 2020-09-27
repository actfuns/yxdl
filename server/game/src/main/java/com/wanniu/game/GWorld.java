/*     */ package com.wanniu.game;
/*     */ 
/*     */ import cn.qeng.common.login.TokenInfo;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.game.message.BroadcastMessage;
/*     */ import com.wanniu.core.game.protocol.PomeloHeader;
/*     */ import com.wanniu.core.game.protocol.PomeloPacket;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.gm.GMClient;
/*     */ import com.wanniu.core.gm.request.GMHandler;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.login.AuthServer;
/*     */ import com.wanniu.core.pay.PayClient;
/*     */ import com.wanniu.core.pay.request.PayHandler;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.DateUtils;
/*     */ import com.wanniu.csharp.CSharpClient;
/*     */ import com.wanniu.csharp.protocol.CSharpMessage;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.area.AreaMap;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.auction.AuctionDataManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.guild.dao.GuildDao;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortCenter;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.ProxyUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.WNProxy;
/*     */ import com.wanniu.game.player.WNRobot;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.request.entry.LoginQueue;
/*     */ import com.wanniu.game.request.prepaid.PaySuccessHandler;
/*     */ import com.wanniu.game.revelry.RevelryManager;
/*     */ import com.wanniu.gm.GMEvent;
/*     */ import com.wanniu.gm.GMRequest;
/*     */ import com.wanniu.gm.handler.GMBaseHandler;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.util.Attribute;
/*     */ import java.io.IOException;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.commons.lang3.time.DateUtils;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GWorld
/*     */   extends GGame
/*     */ {
/*     */   public static LocalDate OPEN_SERVER_DATE;
/*  76 */   public static int __ACROSS_SERVER_ID = __SERVER_ID;
/*     */   
/*  78 */   public static boolean __NEW = GConfig.getInstance().getBoolean("game.new", false);
/*  79 */   public static boolean __RECOMMEND = GConfig.getInstance().getBoolean("game.recommend", false);
/*  80 */   public static boolean __HOT = GConfig.getInstance().getBoolean("game.hot", false);
/*     */   
/*  82 */   public static int __AREA_ID = GConfig.getInstance().getInt("game.areaId", 0);
/*     */   
/*  84 */   public static String __SERVER_NAME = GConfig.getInstance().get("game.name");
/*     */   
/*  86 */   public static int __PLAYER_LIMIT = GConfig.getInstance().getInt("game.limit", 1000);
/*     */   
/*  88 */   public static int __SHOW = 2;
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static LocalDateTime __EXTERNAL_TIME = LocalDateTime.now();
/*     */   
/*  94 */   public static boolean ROBOT = GConfig.getInstance().getBoolean("game.tool.debug", false);
/*     */ 
/*     */   
/*  97 */   public static Set<Integer> sids = GConfig.getInstance().getSet("game.sid.list");
/*     */   
/*     */   public static boolean ROBOTS = true;
/*     */   
/* 101 */   public static final Map<String, WNRobot> Robots = new ConcurrentHashMap<>();
/* 102 */   public static final Map<String, WNProxy> Proxys = new ConcurrentHashMap<>();
/*     */   
/* 104 */   public static int ROBOT_MAX_LEVEL = 39;
/*     */ 
/*     */   
/*     */   public void setOlAvgTime() {}
/*     */ 
/*     */   
/*     */   static {
/* 111 */     instance = new GWorld();
/*     */   }
/*     */   
/*     */   public static GWorld getInstance() {
/* 115 */     return (GWorld)instance;
/*     */   }
/*     */   
/*     */   public boolean isOnline(String rid) {
/* 119 */     return (this.onlinePlayers.containsKey(rid) || Robots.containsKey(rid) || Proxys.containsKey(rid));
/*     */   }
/*     */   
/*     */   public boolean isLocal(String rid) {
/* 123 */     return (this.onlinePlayers.containsKey(rid) || this.waitPlayers.containsKey(rid) || Robots.containsKey(rid));
/*     */   }
/*     */   public WNPlayer getPlayer(String rid) {
/*     */     WNProxy wNProxy;
/* 127 */     WNPlayer player = (WNPlayer)super.getPlayer(rid);
/* 128 */     if (player == null) {
/* 129 */       WNRobot wNRobot = getRobot(rid);
/* 130 */       if (wNRobot == null) {
/* 131 */         wNProxy = getProxy(rid);
/*     */       }
/*     */     } 
/* 134 */     return (WNPlayer)wNProxy;
/*     */   }
/*     */   
/*     */   public static WNRobot getRobot(String rid) {
/* 138 */     return Robots.get(rid);
/*     */   }
/*     */   
/*     */   public static WNProxy getProxy(String rid) {
/* 142 */     return Proxys.get(rid);
/*     */   }
/*     */   
/*     */   public PomeloResponse getErrResponse(Exception e) {
/* 146 */     Out.error(new Object[] { "处理逻辑异常.", e });
/* 147 */     return (PomeloResponse)new ErrorResponse(e.getMessage());
/*     */   }
/*     */   
/*     */   public void addPacket(Packet packet) {
/* 151 */     PomeloPacket pak = (PomeloPacket)packet;
/* 152 */     PomeloHeader header = pak.getHeader();
/* 153 */     if ("area.playerHandler.battleEventNotify".equals(header.route_s)) {
/* 154 */       CSharpClient.getInstance().dispatch(new CSharpMessage(pak));
/*     */     } else {
/* 156 */       putGlobalRoute(header.route_s, packet);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void broadcast(Message msg, int logicServerId) {
/* 161 */     broadcast(msg);
/*     */   }
/*     */   
/*     */   public void addClassByAnnotation(Class<?> clz) throws Exception {
/* 165 */     super.addClassByAnnotation(clz);
/* 166 */     if (clz.isAnnotationPresent((Class)GMEvent.class)) {
/* 167 */       GMRequest.addHandler((GMBaseHandler)clz.newInstance());
/* 168 */     } else if (clz.getSuperclass() == GMHandler.class) {
/* 169 */       GMClient.getInstance().registerHandler((GMHandler)clz.newInstance());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected String searchPath() {
/* 175 */     return super.searchPath() + ";" + GMRequest.class.getPackage().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void battleServerClose(String serverId) {
/* 180 */     AreaMap areas = AreaManager.getInstance().getAreaMap();
/* 181 */     for (Area area : areas.values()) {
/* 182 */       if (area.getServerId().equals(serverId)) {
/* 183 */         area.bsClose = true;
/* 184 */         AreaManager.getInstance().closeArea(area.instanceId);
/* 185 */         Out.info(new Object[] { serverId, " 战斗服关闭  : ", area.instanceId, " : ", Integer.valueOf(area.areaId), " : ", area.prop.name });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void battleServerStart(String serverId) {
/* 192 */     AreaMap areas = AreaManager.getInstance().getAreaMap();
/* 193 */     for (Area area : areas.values()) {
/* 194 */       if (area.getServerId().equals(serverId))
/*     */       {
/*     */ 
/*     */         
/* 198 */         areas.remove(area.instanceId);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void battleServerEvent(String eventType, String msg) {
/* 207 */     Out.debug(new Object[] { eventType, " : ", msg });
/* 208 */     switch (eventType) {
/*     */       case "areaEvent":
/*     */       case "zoneEvent":
/* 211 */         AreaManager.getInstance().areaBattleServerEvent(JSON.parseObject(msg));
/*     */         return;
/*     */       
/*     */       case "playerEvent":
/* 215 */         AreaManager.getInstance().playerBattleServerEvent(JSON.parseObject(msg));
/*     */         return;
/*     */       
/*     */       case "taskEvent":
/* 219 */         AreaManager.getInstance().taskBattleServerEvent(JSON.parseObject(msg));
/*     */         return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private JSONObject newServerJSON() {
/* 226 */     JSONObject json = new JSONObject();
/* 227 */     json.put("appId", Integer.valueOf(__APP_ID));
/* 228 */     json.put("logicServerId", Integer.valueOf(__SERVER_ID));
/* 229 */     json.put("acrossServerId", Integer.valueOf(__ACROSS_SERVER_ID));
/* 230 */     return json;
/*     */   }
/*     */   
/*     */   private void updateLoginState(int load) {
/* 234 */     JSONObject json = newServerJSON();
/* 235 */     json.put("type", Integer.valueOf(259));
/* 236 */     json.put("logicServerId", Integer.valueOf(__SERVER_ID));
/* 237 */     json.put("load", Integer.valueOf(load));
/* 238 */     AuthServer.publish(json);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onAfterStart() {
/* 243 */     super.onAfterStart();
/* 244 */     afterGame();
/* 245 */     if (!GConfig.getInstance().isEnableGm()) {
/* 246 */       syncServerInfo();
/*     */     }
/*     */   }
/*     */   
/*     */   public void syncServerInfo() {
/* 251 */     JSONObject json = newServerJSON();
/* 252 */     json.put("type", Integer.valueOf(257));
/* 253 */     json.put("proto", "game");
/* 254 */     json.put("name", __SERVER_NAME);
/* 255 */     json.put("areaId", Integer.valueOf(__AREA_ID));
/* 256 */     json.put("recommend", Boolean.valueOf(__RECOMMEND));
/* 257 */     json.put("new", Boolean.valueOf(__NEW));
/* 258 */     json.put("hot", Boolean.valueOf(__HOT));
/* 259 */     json.put("olLimit", Integer.valueOf(__PLAYER_LIMIT));
/* 260 */     json.put("show", Integer.valueOf(__SHOW));
/* 261 */     json.put("host", GConfig.getInstance().getGamePubHost());
/* 262 */     json.put("port", Integer.valueOf(GConfig.getInstance().getGamePort()));
/* 263 */     json.put("sidList", sids);
/* 264 */     AuthServer.publish(json);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void afterGame() {
/* 270 */     PayClient.getInstance().registerHandler((PayHandler)new PaySuccessHandler());
/*     */     
/* 272 */     AreaManager.getInstance().init();
/*     */ 
/*     */     
/* 275 */     JobFactory.addFixedRateJob(() -> { int onlineCount = getOnlineCount(); updateLoginState(onlineCount); Out.info(new Object[] { "在线人数 : ", Integer.valueOf(this.onlinePlayers.size()), "/", Integer.valueOf(onlineCount), " - ", Integer.valueOf(this.waitPlayers.size()) }, ); LogReportService.getInstance().ansycReportOnline(this.onlinePlayers.size(), Robots.size()); }60000L, 60000L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     JobFactory.addFixedRateJob(() -> BILogService.getInstance().ansycReportOnline(this.onlinePlayers.size()), 60000L, 300000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCloseGame() {
/* 289 */     super.onCloseGame();
/* 290 */     updateLoginState(-1);
/* 291 */     AreaManager.getInstance().onCloseGame();
/* 292 */     PlayerPOManager.onCloseGame();
/* 293 */     GuildFortCenter.getInstance().onCloseGame();
/* 294 */     GuildDao.onCloseGame();
/* 295 */     ConsignmentLineService.getInstance().onCloseGame();
/* 296 */     AuctionDataManager.getInstance().onCloseGame();
/*     */ 
/*     */     
/* 299 */     disponseRobots();
/*     */   }
/*     */   
/*     */   private void disponseRobots() {
/* 303 */     for (WNRobot robot : Robots.values()) {
/* 304 */       GameDao.freeName(robot.getName());
/* 305 */       GCache.expire(robot.getId(), 300);
/* 306 */       Out.info(new Object[] { "停机维护时，回收机器人资源 robotId=", robot.getId(), ",robotName=", robot.getName() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected BroadcastMessage stopMessage() {
/* 312 */     return new BroadcastMessage()
/*     */       {
/*     */         protected void write() throws IOException {
/* 315 */           PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
/* 316 */           data.setS2CReasonType(Const.KickReason.SERVER_SHUT_DOWN.value);
/* 317 */           this.body.writeBytes(data.build().toByteArray());
/*     */         }
/*     */ 
/*     */         
/*     */         public String getRoute() {
/* 322 */           return "area.playerPush.kickPlayerPush";
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void onRemoveWaitPlayer(GPlayer player) {
/* 328 */     WNPlayer wnPlayer = (WNPlayer)player;
/* 329 */     if (wnPlayer.soloManager.isBusy() || wnPlayer.arenaManager.isInArena()) {
/*     */       return;
/*     */     }
/*     */     
/* 333 */     Area area = wnPlayer.getArea();
/*     */     
/* 335 */     if (area != null && !area.isClose() && !area.isNormal()) {
/*     */       return;
/*     */     }
/*     */     
/* 339 */     super.onRemoveWaitPlayer(player);
/*     */   }
/*     */   
/*     */   public void onSessionClose(Channel channel) {
/* 343 */     LoginQueue.remove(channel);
/*     */     
/* 345 */     String token = (String)channel.attr(GGlobal.__KEY_TOKEN).get();
/* 346 */     if (token != null) {
/* 347 */       String uid = (String)channel.attr(GGlobal.__KEY_USER_ID).get();
/* 348 */       int second = 300;
/* 349 */       Attribute<Boolean> timeout = channel.attr(GGlobal.__KEY_SESSION_TIMEOUT);
/* 350 */       if (timeout.get() != null && ((Boolean)timeout.get()).booleanValue()) {
/* 351 */         second = 5400;
/*     */       }
/*     */ 
/*     */       
/* 355 */       TokenInfo tokenInfo = (TokenInfo)channel.attr(GGlobal.__KEY_TOKEN_INFO).get();
/* 356 */       AuthServer.put(token, JSON.toJSONString(tokenInfo), second);
/* 357 */       Out.info(new Object[] { "Session关闭，重写Token uid=", uid, ",token=", token, ",second=", Integer.valueOf(second) });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onAcrossReceive(Packet pak) {
/* 362 */     Out.debug(new Object[] { "onAcrossReceive :: ", pak.getHeader().getTypeHexString(), " : ", Integer.valueOf(pak.remaing()) });
/* 363 */     if (pak.getPacketType() == 1026) {
/* 364 */       ProxyUtil.onAcrossPlayerEvent(pak);
/* 365 */     } else if (pak.getPacketType() == 1267) {
/* 366 */       String playerId = pak.getString();
/* 367 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 368 */       if (player != null) {
/* 369 */         Channel channel = player.getSession();
/* 370 */         channel.writeAndFlush(pak.getBody());
/*     */       } 
/* 372 */     } else if (pak.getPacketType() == 1265) {
/* 373 */       ProxyUtil.onAcrossTeamEvent(pak);
/* 374 */     } else if (pak.getPacketType() == 1266) {
/* 375 */       ProxyUtil.onAcrossChangeArea(pak);
/* 376 */     } else if (pak.getPacketType() == 1025) {
/* 377 */       String playerId = pak.getString();
/* 378 */       WNProxy proxy = Proxys.get(playerId);
/* 379 */       if (proxy != null) {
/* 380 */         proxy.from(pak);
/*     */       }
/*     */     } else {
/* 383 */       super.onAcrossReceive(pak);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void closeArea(String instanceId) {
/* 388 */     AreaUtil.closeArea(instanceId);
/*     */   }
/*     */   
/*     */   public void onPlayerDie(String instanceId, String diePlayerId, String hitPlayerId) {
/* 392 */     Area area = AreaUtil.getArea(instanceId);
/* 393 */     if (area != null) {
/* 394 */       WNPlayer player = getPlayer(diePlayerId);
/* 395 */       area.pushRelive(player);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOnlineCount() {
/* 403 */     return this.onlinePlayers.size() + Robots.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resetOpenServerDate(LocalDate newOpenDate) {
/* 410 */     if (OPEN_SERVER_DATE == null || !newOpenDate.isEqual(OPEN_SERVER_DATE)) {
/* 411 */       Out.info(new Object[] { "重置开服日期:", newOpenDate.format(DateUtils.F_YYYYMMDD) });
/* 412 */       OPEN_SERVER_DATE = newOpenDate;
/* 413 */       RevelryManager.getInstance().onResetOpenServerDate(OPEN_SERVER_DATE);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void resetExternalTime(String externalTime) {
/* 418 */     LocalDateTime time = LocalDateTime.parse(externalTime, DateUtils.F_YYYYMMDDHHMMSS);
/* 419 */     if (!time.isEqual(__EXTERNAL_TIME)) {
/* 420 */       __EXTERNAL_TIME = time;
/* 421 */       Out.info(new Object[] { "重置对外时间:", externalTime });
/*     */     } 
/*     */   }
/*     */   
/* 425 */   public int max_error_count = 3;
/*     */ 
/*     */   
/*     */   public void handleCopyPacket(GPlayer player, Integer count, PomeloHeader header) {
/* 429 */     if (count.intValue() >= this.max_error_count) {
/* 430 */       Out.info(new Object[] { "复制封包次数超出了上限,准备T人... playerId=", player.getId(), " count=", count });
/*     */       
/* 432 */       if (player instanceof WNPlayer) {
/* 433 */         PlayerPO po = PlayerUtil.getPlayerBaseData(player.getId());
/* 434 */         po.freezeTime = DateUtils.addMinutes(new Date(), 5);
/* 435 */         po.freezeReason = "网络波动";
/*     */         
/* 437 */         LogReportService.getInstance().ansycReportPacketMonitor(po, count, header.getType(), header.route_s);
/*     */       } 
/* 439 */       player.getSession().close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\GWorld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */