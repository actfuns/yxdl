/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import cn.qeng.common.login.TokenInfo;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.PoolFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.http.HttpRequester;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.downjoy.HttpClientUtil;
/*     */ import com.wanniu.game.downjoy.MD5;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.redis.GlobalDao;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BILogService
/*     */ {
/*  51 */   private String downjoyReportUrl = GConfig.getInstance().get("downjoy.report.url");
/*  52 */   private int downjoyAppId = GConfig.getInstance().getInt("downjoy.report.appId", 0);
/*  53 */   private String downjoyAppKey = GConfig.getInstance().get("downjoy.report.appKey");
/*     */ 
/*     */   
/*  56 */   private int aliAppId = GConfig.getInstance().getInt("ali.report.appId", 0);
/*  57 */   private String aliAppKey = GConfig.getInstance().get("ali.report.appKey");
/*  58 */   private String aliReportUrl = GConfig.getInstance().get("ali.report.url");
/*     */   
/*     */   private static BILogService instance;
/*     */   
/*     */   private final ExecutorService ansycReportExec;
/*     */   
/*     */   public static BILogService getInstance() {
/*  65 */     if (instance == null) {
/*  66 */       synchronized (BILogService.class) {
/*  67 */         if (instance == null) {
/*  68 */           instance = new BILogService();
/*     */         }
/*     */       } 
/*     */     }
/*  72 */     return instance;
/*     */   }
/*     */   
/*  75 */   private static Map<String, Map<Const.BiLogType, List<BILogItem>>> items = new ConcurrentHashMap<>();
/*     */   
/*     */   private BILogService() {
/*  78 */     this.ansycReportExec = Executors.newSingleThreadExecutor((ThreadFactory)new PoolFactory("ansyc-report"));
/*     */     
/*  80 */     JobFactory.addFixedRateJob(() -> { for (Map<Const.BiLogType, List<BILogItem>> pitems : items.values()) { for (Const.BiLogType logType : pitems.keySet()) { List<BILogItem> list = pitems.get(logType); if (list == null) continue;  for (BILogItem item : list) { long now = GWorld.APP_TIME; switch (logType) { case Gold_Total: case Cash_Total: case Diamond_Total: case Exp_Total: if (item.time + Const.Time.Minute.getValue() < now) list.remove(item);  continue;case Consignment_Total: if (item.time + Const.Time.Day.getValue() < now) list.remove(item);  continue;case Gift_Total: if (item.time + Const.Time.Hour.getValue() < now) list.remove(item);  continue; }  list.remove(item); }  }  }  if (items.size() > 10000) { Out.warn(new Object[] { "BILogService size: ", Integer.valueOf(items.size()) }, ); if (items.size() > 20000) items.clear();  }  }0L, 10000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recordNum(WNPlayer player, Const.BiLogType logType, long num, Const.GOODS_CHANGE_TYPE from) {
/* 132 */     if (player.isRobot())
/*     */       return; 
/* 134 */     GWorld.getInstance().ansycExec(() -> {
/*     */           List<BILogItem> list = null;
/*     */           if (logType == Const.BiLogType.Gold || logType == Const.BiLogType.Cash || logType == Const.BiLogType.Diamond || logType == Const.BiLogType.Exp || logType == Const.BiLogType.FightPower || logType == Const.BiLogType.Consignment || logType == Const.BiLogType.Gift) {
/*     */             Map<Const.BiLogType, List<BILogItem>> pitem = items.get(player.getId());
/*     */             if (pitem == null) {
/*     */               pitem = new ConcurrentHashMap<>();
/*     */               items.put(player.getId(), pitem);
/*     */             } 
/*     */             list = pitem.get(logType);
/*     */             if (list == null) {
/*     */               list = new CopyOnWriteArrayList<>();
/*     */               pitem.put(logType, list);
/*     */             } 
/*     */             list.add(new BILogItem(GWorld.APP_TIME, Math.abs(num)));
/*     */           } 
/*     */           long total = 0L;
/*     */           if (list != null && list.size() > 0) {
/*     */             for (BILogItem item : list) {
/*     */               total += item.num;
/*     */             }
/*     */           }
/*     */           switch (logType) {
/*     */             case Gold:
/*     */               if (Math.abs(num) > 2000000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Gold, player, new Object[] { Long.valueOf(num), from });
/*     */               }
/*     */               if (total > 10000000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Gold_Total, player, new Object[] { Long.valueOf(total) });
/*     */               }
/*     */               break;
/*     */             case Cash:
/*     */               if (Math.abs(num) > 5000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Cash, player, new Object[] { Long.valueOf(num), from });
/*     */               }
/*     */               if (total > 10000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Cash_Total, player, new Object[] { Long.valueOf(total) });
/*     */               }
/*     */               break;
/*     */             case Diamond:
/*     */               PlayerUtil.bi(getClass(), Const.BiLogType.Diamond, player, new Object[] { Long.valueOf(num), from });
/*     */               PlayerUtil.bi(getClass(), Const.BiLogType.Diamond_Total, player, new Object[] { Long.valueOf(total) });
/*     */               break;
/*     */             case Exp:
/*     */               if (Math.abs(num) > 500000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Exp, player, new Object[] { Long.valueOf(num), from });
/*     */               }
/*     */               if (total > 2000000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Exp_Total, player, new Object[] { Long.valueOf(total) });
/*     */               }
/*     */               break;
/*     */             case FightPower:
/*     */               if (num > 5000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.FightPower, player, new Object[] { Long.valueOf(num), from });
/*     */               }
/*     */               if (total > 30000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.FightPower_Total, player, new Object[] { Long.valueOf(total) });
/*     */               }
/*     */               break;
/*     */             case Consignment:
/*     */               if (Math.abs(num) > 3000L) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Consignment, player, new Object[] { Long.valueOf(num), from });
/*     */               }
/*     */               if (list.size() > 50) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Consignment_Total, player, new Object[] { Integer.valueOf(list.size()) });
/*     */               }
/*     */               break;
/*     */             case Gift:
/*     */               if (list.size() > 10) {
/*     */                 PlayerUtil.bi(getClass(), Const.BiLogType.Gift_Total, player, new Object[] { Integer.valueOf(list.size()) });
/*     */               }
/*     */               break;
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class BILogItem
/*     */   {
/*     */     public long time;
/*     */ 
/*     */ 
/*     */     
/*     */     public long num;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BILogItem(long time, long num) {
/* 224 */       this.time = time;
/* 225 */       this.num = num;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportOnline(int onlineCount) {
/* 233 */     String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
/* 234 */     if (StringUtils.isNotEmpty(reportUrl)) {
/* 235 */       Map<String, Integer> ps = new HashMap<>();
/* 236 */       ps.put("type", Integer.valueOf(0));
/* 237 */       ps.put("area_id", Integer.valueOf(GWorld.__AREA_ID));
/* 238 */       ps.put("server_id", Integer.valueOf(GGame.__SERVER_ID));
/* 239 */       ps.put("count", Integer.valueOf(onlineCount));
/*     */       
/* 241 */       Map<String, String> params = new HashMap<>();
/* 242 */       params.put("name", "Online");
/* 243 */       params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
/* 244 */       params.put("data", JSON.toJSONString(ps));
/*     */       
/* 246 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               Out.info(new Object[] { "online report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent() });
/* 249 */             } catch (IOException e) {
/*     */               Out.warn(new Object[] { "online report exception", JSON.toJSONString(params), e });
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportRegister(Channel channel, String uid, String ip) {
/* 260 */     String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
/* 261 */     if (StringUtils.isNotEmpty(reportUrl) && !GlobalDao.hexists(ConstsTR.FIRST_LOGIN.value, uid)) {
/* 262 */       GlobalDao.hset(ConstsTR.FIRST_LOGIN.value, uid, "1");
/*     */       
/* 264 */       Map<String, Object> ps = new HashMap<>();
/* 265 */       ps.put("kingdom", Integer.valueOf(1));
/* 266 */       ps.put("userid", uid);
/*     */       
/* 268 */       Map<String, String> params = new HashMap<>();
/* 269 */       params.put("name", "Register");
/* 270 */       params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
/* 271 */       params.put("data", JSON.toJSONString(ps));
/*     */       
/* 273 */       TokenInfo tokenInfo = (TokenInfo)channel.attr(GGlobal.__KEY_TOKEN_INFO).get();
/* 274 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               if (tokenInfo != null) {
/*     */                 params.put("source", tokenInfo.getSubchannel());
/*     */                 params.put("device_id", tokenInfo.getMac());
/*     */                 params.put("platform", String.valueOf(osToPlatform(tokenInfo.getOs())));
/*     */                 params.put("ip", ip);
/*     */               } 
/*     */               Out.info(new Object[] { "register report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent() });
/* 283 */             } catch (IOException e) {
/*     */               Out.warn(new Object[] { "register report exception", JSON.toJSONString(params), e });
/*     */               GlobalDao.hremove(ConstsTR.FIRST_LOGIN.value, uid);
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportLogout(WNPlayer player) {
/* 295 */     String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
/* 296 */     if (StringUtils.isNotEmpty(reportUrl)) {
/* 297 */       Map<String, Object> ps = new HashMap<>();
/* 298 */       ps.put("kingdom", Integer.valueOf(1));
/* 299 */       ps.put("userid", player.getUid());
/* 300 */       ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
/* 301 */       ps.put("roleid", player.getId());
/*     */ 
/*     */       
/* 304 */       Map<String, Object> extra = new HashMap<>();
/* 305 */       extra.put("区服", Integer.valueOf(GGame.__SERVER_ID));
/* 306 */       extra.put("角色名", (player.getPlayer()).name);
/* 307 */       extra.put("角色职业", Integer.valueOf((player.getPlayer()).pro));
/* 308 */       extra.put("角色等级", Integer.valueOf((player.getPlayer()).level));
/* 309 */       extra.put("角色突破等级", Integer.valueOf((player.getPlayer()).upLevel));
/* 310 */       extra.put("角色VIP等级", Integer.valueOf(player.baseDataManager.getVip()));
/* 311 */       extra.put("角色战斗力", Integer.valueOf((player.getPlayer()).fightPower));
/* 312 */       extra.put("元宝存量", Integer.valueOf((player.getPlayer()).diamond));
/* 313 */       extra.put("绑元存量", Integer.valueOf((player.getPlayer()).ticket));
/* 314 */       extra.put("银两存量", Integer.valueOf((player.getPlayer()).gold));
/* 315 */       ps.put("extra", extra);
/*     */       
/* 317 */       Map<String, String> params = new HashMap<>();
/* 318 */       params.put("name", "Logout");
/* 319 */       params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
/* 320 */       params.put("data", JSON.toJSONString(ps));
/* 321 */       params.put("source", String.valueOf((player.getPlayer()).subchannel));
/* 322 */       params.put("device_id", (player.getPlayer()).mac);
/* 323 */       params.put("platform", String.valueOf(osToPlatform((player.getPlayer()).os)));
/* 324 */       params.put("ip", (player.getPlayer()).ip);
/*     */       
/* 326 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               Out.info(new Object[] { "logout report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent() });
/* 329 */             } catch (IOException e) {
/*     */               Out.warn(new Object[] { "logout report exception", JSON.toJSONString(params), e });
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ansycReportRechargeSuccess(PlayerPO player, int chargeDiamond, int payMoneyAmount, String classfield) {
/* 337 */     String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
/* 338 */     if (StringUtils.isNotEmpty(reportUrl)) {
/* 339 */       Map<String, Object> ps = new HashMap<>();
/* 340 */       ps.put("type", Integer.valueOf(1));
/* 341 */       ps.put("userid", player.uid);
/* 342 */       ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
/* 343 */       ps.put("user_level", Integer.valueOf(player.level));
/* 344 */       ps.put("kingdom", Integer.valueOf(chargeDiamond));
/* 345 */       ps.put("phylum", Integer.valueOf(payMoneyAmount));
/* 346 */       ps.put("roleid", player.id);
/* 347 */       ps.put("classfield", classfield);
/*     */       
/* 349 */       Map<String, Object> extra = new HashMap<>();
/* 350 */       extra.put("区服", Integer.valueOf(GGame.__SERVER_ID));
/* 351 */       extra.put("角色名", player.name);
/* 352 */       extra.put("角色职业", Integer.valueOf(player.pro));
/* 353 */       extra.put("角色等级", Integer.valueOf(player.level));
/* 354 */       extra.put("角色突破等级", Integer.valueOf(player.upLevel));
/* 355 */       extra.put("角色战斗力", Integer.valueOf(player.fightPower));
/* 356 */       extra.put("元宝存量", Integer.valueOf(player.diamond));
/* 357 */       extra.put("绑元存量", Integer.valueOf(player.ticket));
/* 358 */       extra.put("银两存量", Integer.valueOf(player.gold));
/*     */       
/* 360 */       ps.put("extra", extra);
/* 361 */       Map<String, String> params = new HashMap<>();
/* 362 */       params.put("name", "RechargeSuccess");
/* 363 */       params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
/* 364 */       params.put("data", JSON.toJSONString(ps));
/* 365 */       params.put("source", String.valueOf(player.subchannel));
/* 366 */       params.put("device_id", player.mac);
/* 367 */       params.put("platform", String.valueOf(osToPlatform(player.os)));
/* 368 */       params.put("ip", player.ip);
/*     */       
/* 370 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               Out.info(new Object[] { "RechargeSuccess report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent() });
/* 373 */             } catch (IOException e) {
/*     */               Out.warn(new Object[] { "RechargeSuccess report exception", JSON.toJSONString(params), e });
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int osToPlatform(String os) {
/* 385 */     if ("6".equals(os))
/* 386 */       return 2; 
/* 387 */     if ("5".equals(os)) {
/* 388 */       return 1;
/*     */     }
/* 390 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportPlayerData(Channel session, PlayerPO player, boolean upgrade) {
/*     */     try {
/* 399 */       if (session == null || player == null) {
/* 400 */         Out.warn(new Object[] { "异步上报玩家数据时，Session为空" });
/*     */         
/*     */         return;
/*     */       } 
/* 404 */       TokenInfo tokenInfo = (TokenInfo)session.attr(GGlobal.__KEY_TOKEN_INFO).get();
/* 405 */       if (tokenInfo != null && StringUtils.isNotEmpty(tokenInfo.getSubchannel())) {
/* 406 */         String subchannel = tokenInfo.getSubchannel();
/* 407 */         switch (subchannel) {
/*     */           case "P_ALI":
/* 409 */             ansycReportPlayerDataBy1001P_Ali(tokenInfo, player, upgrade);
/*     */             break;
/*     */           case "1003":
/* 412 */             if (upgrade) {
/* 413 */               ansycReportPlayerDataBy1003(tokenInfo, player);
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 420 */     } catch (Exception e) {
/* 421 */       Out.error(new Object[] { "异步上报玩家数据时发生异常啦.", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void ansycReportPlayerDataBy1001P_Ali(TokenInfo tokenInfo, PlayerPO player, boolean upgrade) throws UnsupportedEncodingException {
/* 427 */     long timeStamp = System.currentTimeMillis() / 1000L;
/*     */     
/* 429 */     JSONObject object = new JSONObject();
/* 430 */     object.put("id", Long.valueOf(timeStamp));
/* 431 */     object.put("service", "ucid.game.gameData");
/*     */     
/* 433 */     JSONObject data = new JSONObject();
/*     */     
/* 435 */     JSONObject gameData = new JSONObject();
/* 436 */     gameData.put("category", "loginGameRole");
/*     */ 
/*     */     
/* 439 */     JSONObject content = new JSONObject();
/* 440 */     content.put("zoneId", Integer.valueOf(GWorld.__SERVER_ID));
/* 441 */     content.put("zoneName", GWorld.__SERVER_NAME);
/* 442 */     content.put("roleId", player.id);
/* 443 */     content.put("roleName", player.name);
/* 444 */     content.put("roleCTime", Long.valueOf(player.createTime.getTime() / 1000L));
/* 445 */     content.put("roleLevel", String.valueOf(player.level));
/* 446 */     content.put("os", "6".equals(player.os) ? "android" : "ios");
/* 447 */     if (upgrade) {
/* 448 */       content.put("roleLevelMTime", Long.valueOf(timeStamp));
/*     */     }
/* 450 */     gameData.put("content", content);
/*     */ 
/*     */     
/* 453 */     data.put("accountId", player.subchannelUID);
/* 454 */     data.put("gameData", URLEncoder.encode(gameData.toJSONString(), "UTF-8"));
/*     */ 
/*     */ 
/*     */     
/* 458 */     object.put("sign", sign((Map<String, Object>)data, this.aliAppKey));
/* 459 */     object.put("data", data);
/*     */ 
/*     */ 
/*     */     
/* 463 */     JSONObject game = new JSONObject();
/* 464 */     game.put("gameId", Integer.valueOf(this.aliAppId));
/* 465 */     object.put("game", game);
/*     */ 
/*     */     
/* 468 */     String postData = object.toJSONString();
/* 469 */     this.ansycReportExec.execute(() -> {
/*     */           try {
/*     */             String result = HttpClientUtil.doPost(this.aliReportUrl, postData, "application/json");
/*     */             Out.info(new Object[] { "AliReport result:", result });
/* 473 */           } catch (Exception e) {
/*     */             Out.warn(new Object[] { "AliReport report exception", e });
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static String sign(Map<String, Object> reqMap, String signKey) {
/* 481 */     TreeMap<String, Object> signMap = new TreeMap<>(reqMap);
/* 482 */     StringBuilder stringBuilder = new StringBuilder(1024);
/* 483 */     for (Map.Entry<String, Object> entry : signMap.entrySet()) {
/*     */       
/* 485 */       if ("sign".equals(entry.getKey()) || "signType".equals(entry.getKey())) {
/*     */         continue;
/*     */       }
/*     */       
/* 489 */       if (entry.getValue() != null) {
/* 490 */         stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     } 
/*     */     
/* 494 */     stringBuilder.append(signKey);
/*     */     
/* 496 */     String signSrc = stringBuilder.toString().replaceAll("&", "");
/* 497 */     return MD5.encrypt(signSrc).toLowerCase();
/*     */   }
/*     */ 
/*     */   
/*     */   private void ansycReportPlayerDataBy1003(TokenInfo tokenInfo, PlayerPO player) {
/* 502 */     if (StringUtils.isNotEmpty(this.downjoyReportUrl)) {
/* 503 */       long timeStamp = System.currentTimeMillis();
/* 504 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               Long appId = Long.valueOf(this.downjoyAppId);
/*     */               
/*     */               String umid = tokenInfo.getSubchannelUid();
/*     */               
/*     */               String token = tokenInfo.getAccessToken();
/*     */               String zoneId = String.valueOf(GWorld.__SERVER_ID);
/*     */               String zoneName = GWorld.__SERVER_NAME;
/*     */               String roleId = player.id;
/*     */               String roleName = player.name;
/*     */               Date roleCreateTime = player.createTime;
/*     */               String roleLevel = String.valueOf(player.level);
/*     */               Date roleLevelModifyTime = new Date(timeStamp);
/*     */               JSONObject object = new JSONObject();
/*     */               object.put("appId", appId);
/*     */               object.put("timestamp", Long.valueOf(timeStamp));
/*     */               JSONObject data = new JSONObject();
/*     */               data.put("umid", umid);
/*     */               data.put("zoneId", zoneId);
/*     */               data.put("zoneName", zoneName);
/*     */               data.put("roleId", roleId);
/*     */               data.put("roleName", roleName);
/*     */               data.put("roleCTime", Long.valueOf(roleCreateTime.getTime() / 1000L));
/*     */               data.put("roleLevel", roleLevel);
/*     */               data.put("roleLevelMTime", Long.valueOf(roleLevelModifyTime.getTime() / 1000L));
/*     */               String encodeData = URLEncoder.encode(data.toJSONString(), "UTF-8");
/*     */               object.put("data", encodeData);
/*     */               String signParam = (new StringBuilder(512)).append("appId=").append(appId).append("&data=").append(encodeData).append("&timestamp=").append(timeStamp).append(token).append(this.downjoyAppKey).toString();
/*     */               String sign = MD5.getDigest(signParam);
/*     */               object.put("sig", sign);
/*     */               object.put("token", token);
/*     */               String postData = object.toJSONString();
/*     */               String result = HttpClientUtil.doPost(this.downjoyReportUrl, postData, "application/json");
/*     */               Out.info(new Object[] { "DownjoyReport result:", result });
/* 539 */             } catch (Exception e) {
/*     */               Out.warn(new Object[] { "DownjoyReport report exception", e });
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 547 */     String test = "%7bcode=value2name=value3personid=value1202cb962234w4ers2aa";
/* 548 */     System.out.println(MD5.encrypt(test).toLowerCase());
/*     */   }
/*     */   
/*     */   public void ansycReportHolyArmour(PlayerPO player, Map<Integer, String> data) {
/* 552 */     Map<String, Object> param = new HashMap<>();
/* 553 */     param.put("phylum", JSON.toJSON(data));
/* 554 */     ansycReport(player, "ActivateHolyArmour", param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ansycReport(PlayerPO player, String name, Map<String, Object> param) {
/* 561 */     String reportUrl = GConfig.getInstance().get("server.bi.reportUrl");
/* 562 */     if (StringUtils.isNotEmpty(reportUrl)) {
/* 563 */       Map<String, Object> ps = new HashMap<>();
/* 564 */       ps.put("userid", player.uid);
/* 565 */       ps.put("clientid", Integer.valueOf(GGame.__SERVER_ID));
/* 566 */       ps.put("user_level", Integer.valueOf(player.level));
/* 567 */       ps.put("roleid", player.id);
/* 568 */       ps.putAll(param);
/*     */       
/* 570 */       Map<String, Object> extra = new HashMap<>();
/* 571 */       extra.put("角色名", player.name);
/* 572 */       extra.put("角色职业", Integer.valueOf(player.pro));
/* 573 */       extra.put("角色突破等级", Integer.valueOf(player.upLevel));
/* 574 */       extra.put("角色战斗力", Integer.valueOf(player.fightPower));
/* 575 */       extra.put("元宝存量", Integer.valueOf(player.diamond));
/* 576 */       extra.put("绑元存量", Integer.valueOf(player.ticket));
/* 577 */       extra.put("银两存量", Integer.valueOf(player.gold));
/*     */       
/* 579 */       ps.put("extra", extra);
/* 580 */       Map<String, String> params = new HashMap<>();
/* 581 */       params.put("name", name);
/* 582 */       params.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
/* 583 */       params.put("data", JSON.toJSONString(ps));
/* 584 */       params.put("source", String.valueOf(player.subchannel));
/* 585 */       params.put("device_id", player.mac);
/* 586 */       params.put("platform", String.valueOf(osToPlatform(player.os)));
/* 587 */       params.put("ip", player.ip);
/*     */       
/* 589 */       this.ansycReportExec.execute(() -> {
/*     */             try {
/*     */               Out.info(new Object[] { "ansycReport ", name, " report result:", (new HttpRequester()).sendPost(reportUrl, params).getContent() });
/* 592 */             } catch (IOException e) {
/*     */               Out.warn(new Object[] { "ansycReport", name, " report exception", JSON.toJSONString(params), e });
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ansycReportSkillUpgrade(PlayerPO player, int skillId, String skillName, int skillLevel) {
/* 600 */     Map<String, Object> param = new HashMap<>();
/* 601 */     param.put("kingdom", Integer.valueOf(skillId));
/* 602 */     param.put("phylum", Integer.valueOf(skillLevel));
/* 603 */     param.put("classfield", skillName);
/* 604 */     ansycReport(player, "UpgradeSkill", param);
/*     */   }
/*     */   
/*     */   public void ansycReportEquipChange(PlayerPO player, int type, int position, Map<String, Object> data) {
/* 608 */     Map<String, Object> param = new HashMap<>();
/* 609 */     param.put("kingdom", Integer.valueOf(type));
/* 610 */     param.put("phylum", Integer.valueOf(position));
/* 611 */     param.put("classfield", data);
/* 612 */     ansycReport(player, "EquipChange", param);
/*     */   }
/*     */   
/*     */   public void ansycReportPetActivate(PlayerPO player, int id, String petName) {
/* 616 */     Map<String, Object> param = new HashMap<>();
/* 617 */     param.put("kingdom", Integer.valueOf(id));
/* 618 */     param.put("phylum", petName);
/* 619 */     ansycReport(player, "PetActivate", param);
/*     */   }
/*     */   
/*     */   public void ansycReportPetBattle(PlayerPO player, int petId, String petName, int level, int upLevel, int type) {
/* 623 */     Map<String, Object> param = new HashMap<>();
/* 624 */     param.put("kingdom", Integer.valueOf(petId));
/* 625 */     param.put("phylum", petName);
/* 626 */     param.put("classfield", Integer.valueOf(level));
/* 627 */     param.put("family", Integer.valueOf(upLevel));
/* 628 */     param.put("genus", Integer.valueOf(type));
/* 629 */     ansycReport(player, "PetBattle", param);
/*     */   }
/*     */   
/*     */   public void ansycReportMountActivate(PlayerPO player, int id, String skinName) {
/* 633 */     Map<String, Object> param = new HashMap<>();
/* 634 */     param.put("kingdom", Integer.valueOf(id));
/* 635 */     param.put("phylum", skinName);
/* 636 */     ansycReport(player, "MountActivate", param);
/*     */   }
/*     */   
/*     */   public void ansycReportBloodChange(PlayerPO player, int type, int position, Map<String, Object> data) {
/* 640 */     Map<String, Object> param = new HashMap<>();
/* 641 */     param.put("kingdom", Integer.valueOf(type));
/* 642 */     param.put("phylum", Integer.valueOf(position));
/* 643 */     param.put("classfield", data);
/* 644 */     ansycReport(player, "BloodChange", param);
/*     */   }
/*     */   
/*     */   public void ansycReportResourceDungeon(PlayerPO player, int win, int mapID) {
/* 648 */     Map<String, Object> param = new HashMap<>();
/* 649 */     param.put("kingdom", Integer.valueOf(win));
/* 650 */     param.put("phylum", Integer.valueOf(mapID));
/* 651 */     ansycReport(player, "ResourceDungeon", param);
/*     */   }
/*     */   
/*     */   public void ansycReportDemonTower(PlayerPO player, int win, int mapID) {
/* 655 */     Map<String, Object> param = new HashMap<>();
/* 656 */     param.put("kingdom", Integer.valueOf(win));
/* 657 */     param.put("phylum", Integer.valueOf(mapID));
/* 658 */     ansycReport(player, "DemonTower", param);
/*     */   }
/*     */   
/*     */   public void ansycReportFightLevel(PlayerPO player, int win, int mapID, String instanceId) {
/* 662 */     Map<String, Object> param = new HashMap<>();
/* 663 */     param.put("kingdom", Integer.valueOf(win));
/* 664 */     param.put("phylum", Integer.valueOf(mapID));
/* 665 */     param.put("classfield", instanceId);
/* 666 */     ansycReport(player, "FightLevel", param);
/*     */   }
/*     */   
/*     */   public void ansycReportEnteredArea(PlayerPO player, int sceneType, int areaId) {
/* 670 */     Map<String, Object> param = new HashMap<>();
/* 671 */     param.put("kingdom", Integer.valueOf(sceneType));
/* 672 */     param.put("phylum", Integer.valueOf(areaId));
/* 673 */     ansycReport(player, "EnteredArea", param);
/*     */   }
/*     */   
/*     */   public void ansycReportLeaderBoard(PlayerPO player, int type) {
/* 677 */     Map<String, Object> param = new HashMap<>();
/* 678 */     param.put("kingdom", Integer.valueOf(type));
/* 679 */     ansycReport(player, "LeaderBoard", param);
/*     */   }
/*     */   
/*     */   public void ansycReportKillBoss(PlayerPO player, int sceneType, int monsterId) {
/* 683 */     Map<String, Object> param = new HashMap<>();
/* 684 */     param.put("kingdom", Integer.valueOf(sceneType));
/* 685 */     param.put("phylum", Integer.valueOf(monsterId));
/* 686 */     ansycReport(player, "KillBoss", param);
/*     */   }
/*     */   
/*     */   public void ansycReportEconomy(PlayerPO player, String currency, boolean kingdom, int value, int origin) {
/* 690 */     Map<String, Object> param = new HashMap<>();
/* 691 */     param.put("currency", currency);
/* 692 */     param.put("kingdom", kingdom ? "earing" : "expenditure");
/* 693 */     param.put("amount", Integer.valueOf(value));
/* 694 */     param.put("phylum", Integer.valueOf(origin));
/* 695 */     ansycReport(player, "Economy", param);
/*     */   }
/*     */   
/*     */   public void ansycReportItem(PlayerPO player, boolean kingdom, String itemcode, int count, Const.GOODS_CHANGE_TYPE origin, String name) {
/* 699 */     Map<String, Object> param = new HashMap<>();
/* 700 */     param.put("kingdom", kingdom ? "获得" : "消耗");
/* 701 */     param.put("phylum", Integer.valueOf(origin.value));
/* 702 */     param.put("family", name + "(" + itemcode + "):" + count);
/* 703 */     ansycReport(player, "Item", param);
/*     */   }
/*     */   
/*     */   public void ansycReportMeltCultivate(PlayerPO player, List<NormalItem> items) {
/* 707 */     Map<String, Object> param = new HashMap<>();
/* 708 */     StringBuilder sb = new StringBuilder(128);
/* 709 */     for (NormalItem item : items) {
/* 710 */       sb.append(item.getName()).append("(").append(item.itemCode()).append(")").append(item.getNum()).append(",");
/*     */     }
/* 712 */     param.put("family", sb.toString());
/* 713 */     ansycReport(player, "MeltCultivate", param);
/*     */   }
/*     */   
/*     */   public void ansycReportMission(PlayerPO player, String phylum, int kind, int id, String name) {
/* 717 */     Map<String, Object> param = new HashMap<>();
/*     */ 
/*     */ 
/*     */     
/* 721 */     if (kind == 1) {
/* 722 */       param.put("kingdom", "主线任务main");
/* 723 */     } else if (kind == 2) {
/* 724 */       param.put("kingdom", "支线任务side");
/* 725 */     } else if (kind == 3) {
/* 726 */       param.put("kingdom", "日常任务daily");
/*     */     } else {
/*     */       return;
/*     */     } 
/* 730 */     param.put("phylum", phylum);
/* 731 */     param.put("genus", Integer.valueOf(id));
/* 732 */     param.put("family", name);
/* 733 */     ansycReport(player, "Mission", param);
/*     */   }
/*     */   
/*     */   public void ansycReportPetCultivate(PlayerPO player, int upLevel, String itemcode, int count, int id) {
/* 737 */     Map<String, Object> param = new HashMap<>();
/* 738 */     param.put("kingdom", Integer.valueOf(2));
/* 739 */     param.put("phylum", "");
/* 740 */     param.put("classfield", (upLevel - 1) + "_" + upLevel);
/* 741 */     DItemBase it = (DItemBase)ItemConfig.getInstance().getItemTemplates().get(itemcode);
/* 742 */     param.put("family", ((it == null) ? "" : it.name) + "(" + itemcode + "):" + count);
/* 743 */     param.put("genus", Integer.valueOf(id));
/* 744 */     ansycReport(player, "PetCultivate", param);
/*     */   }
/*     */   
/*     */   public void ansycReportPetCultivate(PlayerPO player, int oldLevel, int level, long oldExp, long exp, int id) {
/* 748 */     Map<String, Object> param = new HashMap<>();
/* 749 */     param.put("kingdom", Integer.valueOf(1));
/* 750 */     param.put("phylum", oldLevel + "_" + level + "," + oldExp + "_" + exp);
/* 751 */     param.put("classfield", "");
/* 752 */     param.put("family", "");
/* 753 */     param.put("genus", Integer.valueOf(id));
/* 754 */     ansycReport(player, "PetCultivate", param);
/*     */   }
/*     */   
/*     */   public void ansycReportRideTrainBI(PlayerPO player, int kingdom, int level, int starLv, String itemcode, int count) {
/* 758 */     Map<String, Object> param = new HashMap<>();
/* 759 */     param.put("kingdom", Integer.valueOf(kingdom));
/* 760 */     param.put("phylum", Integer.valueOf(level));
/* 761 */     param.put("classfield", Integer.valueOf(starLv));
/* 762 */     DItemBase it = (DItemBase)ItemConfig.getInstance().getItemTemplates().get(itemcode);
/* 763 */     param.put("family", ((it == null) ? "" : it.name) + "(" + itemcode + "):" + count);
/* 764 */     ansycReport(player, "RideTrainBI", param);
/*     */   }
/*     */   
/*     */   public void ansycReportStrengthenCultivate(PlayerPO player, int pos, int oldLevel, int level, JSONObject mates) {
/* 768 */     Map<String, Object> param = new HashMap<>();
/* 769 */     param.put("kingdom", Integer.valueOf(pos));
/* 770 */     param.put("phylum", "强化前等级：" + oldLevel);
/* 771 */     param.put("classfield", "强化后等级:" + level);
/* 772 */     StringBuilder sb = new StringBuilder(128);
/* 773 */     for (String itemcode : mates.keySet()) {
/* 774 */       int needNum = mates.getIntValue(itemcode);
/* 775 */       DItemBase it = (DItemBase)ItemConfig.getInstance().getItemTemplates().get(itemcode);
/* 776 */       sb.append((it == null) ? "" : it.name).append("(").append(itemcode).append(")").append(needNum).append(",");
/*     */     } 
/* 778 */     param.put("family", sb.toString());
/* 779 */     ansycReport(player, "StrengthenCultivate", param);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\BILogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */