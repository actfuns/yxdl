/*     */ package com.wanniu.login.request;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.protocol.ErrorResponse;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.game.request.GClientEvent;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.redis.GCache;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.core.util.http.HttpRequester;
/*     */ import com.wanniu.core.util.http.HttpRespons;
/*     */ import com.wanniu.login.LoginServer;
/*     */ import com.wanniu.login.vo.AppVO;
/*     */ import com.wanniu.login.vo.LoginResult;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ @GClientEvent("login.loginHandler.loginRequest")
/*     */ public class LoginHandler
/*     */   extends PomeloRequest
/*     */ {
/*  30 */   private static HttpRequester httpReq = new HttpRequester("UTF-8");
/*     */   
/*     */   public PomeloResponse request() throws Exception {
/*     */     final String newUid;
/*  34 */     com.wanniu.login.proto.LoginHandler.LoginRequest req = com.wanniu.login.proto.LoginHandler.LoginRequest.parseFrom(this.pak.getRemaingBytes());
/*  35 */     String uid = req.getUid();
/*  36 */     String token = req.getToken();
/*  37 */     if (StringUtil.isEmpty(uid) || StringUtil.isEmpty(token)) {
/*  38 */       return (PomeloResponse)new ErrorResponse("用户名和密码不能为空！");
/*     */     }
/*  40 */     if (LoginServer.getInstance().isBlackList(this.pak.getIp(), uid)) {
/*  41 */       Out.warn(new Object[] { this.pak.getIp(), " : ", uid });
/*  42 */       this.pak.close();
/*  43 */       return null;
/*     */     } 
/*     */     
/*  46 */     AppVO app = null;
/*  47 */     int appId = LoginServer.__APP_ID;
/*  48 */     if (StringUtil.isNotEmpty(req.getChannel())) {
/*  49 */       Map<String, String> params = new HashMap<>();
/*  50 */       params.put("uid", req.getUid());
/*  51 */       params.put("channel", req.getChannel());
/*  52 */       params.put("channelUid", req.getChannelUid());
/*  53 */       params.put("accessToken", req.getToken());
/*  54 */       params.put("productId", req.getAppId());
/*  55 */       params.put("mac", req.getImei());
/*  56 */       params.put("os", String.valueOf(req.getOs()));
/*  57 */       params.put("ip", this.pak.getIp());
/*  58 */       String loginUrl = GConfig.getInstance().get("usercenter.url");
/*  59 */       HttpRespons respons = httpReq.sendPost(loginUrl, params);
/*  60 */       if (respons.getCode() == 200 && StringUtil.isNotEmpty(respons.getContent())) {
/*  61 */         LoginResult loginResult = (LoginResult)JSON.parseObject(respons.getContent(), LoginResult.class);
/*  62 */         if (!loginResult.success) {
/*  63 */           return (PomeloResponse)new ErrorResponse(loginResult.desc);
/*     */         }
/*  65 */         app = LoginServer.getInstance().getApp(appId);
/*  66 */         uid = loginResult.username;
/*     */       } else {
/*  68 */         return (PomeloResponse)new ErrorResponse("登录验证失败！");
/*     */       } 
/*     */     } else {
/*  71 */       String pwd = GCache.get("/account/" + uid);
/*  72 */       if (!token.equals(pwd)) {
/*  73 */         return (PomeloResponse)new ErrorResponse("用户名或密码错误！");
/*     */       }
/*  75 */       if (StringUtil.isNumeric(req.getAppId())) {
/*  76 */         appId = Integer.parseInt(req.getAppId());
/*     */       } else {
/*  78 */         Out.warn(new Object[] { this.pak.getIp(), " login error app ", req.getAppId() });
/*     */       } 
/*  80 */       app = LoginServer.getInstance().getApp(appId);
/*     */     } 
/*  82 */     if (app == null) {
/*  83 */       return (PomeloResponse)new ErrorResponse("app id not exists : " + appId);
/*     */     }
/*     */     
/*  86 */     final String uuid = UUID.randomUUID().toString();
/*     */     
/*  88 */     String playerServers = GCache.get("/player/servers/" + uid);
/*  89 */     Map<Integer, Integer> histories = new HashMap<>();
/*  90 */     if (!StringUtil.isEmpty(playerServers)) {
/*     */       try {
/*  92 */         JSONArray arr = JSON.parseArray(playerServers);
/*  93 */         for (int i = 0; i < arr.size(); i++) {
/*  94 */           JSONObject json = arr.getJSONObject(i);
/*  95 */           int sid = json.getIntValue("sid");
/*  96 */           int count = json.getIntValue("count");
/*  97 */           if (count > 0) {
/*  98 */             histories.put(Integer.valueOf(sid), Integer.valueOf(count));
/*     */           }
/*     */         } 
/* 101 */       } catch (Exception e) {
/* 102 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (StringUtil.isNotEmpty(req.getChannel())) {
/* 109 */       String channel = req.getChannel();
/* 110 */       int length = channel.length() + 1 + uid.length();
/* 111 */       newUid = (new StringBuilder(length)).append(channel).append('_').append(uid).toString();
/*     */     }
/*     */     else {
/*     */       
/* 115 */       newUid = uid;
/*     */     } 
/*     */     
/* 118 */     Map<String, String> tokenInfo = TokenUtils.build(req.getChannel(), newUid, req.getImei(), 
/* 119 */         String.valueOf(req.getOs()));
/* 120 */     GCache.put("/token/" + uuid, JSON.toJSONString(tokenInfo), 600);
/*     */     
/* 122 */     this.pak.setAttr(GGlobal._KEY_USER_ID, newUid);
/* 123 */     final JSONArray board = app.getServerList(histories, this.pak);
/*     */     
/* 125 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 128 */           com.wanniu.login.proto.LoginHandler.LoginResponse.Builder res = com.wanniu.login.proto.LoginHandler.LoginResponse.newBuilder();
/* 129 */           res.setS2CCode(200);
/* 130 */           res.setToken(uuid);
/* 131 */           res.setNewUid(newUid);
/* 132 */           res.setBoard(board.toJSONString());
/* 133 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\request\LoginHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */