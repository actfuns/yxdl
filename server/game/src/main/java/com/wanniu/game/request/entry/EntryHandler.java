/*     */ package com.wanniu.game.request.entry;
/*     */ 
/*     */ import cn.qeng.common.login.TokenInfo;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.login.AuthServer;
/*     */ import com.wanniu.core.util.DateUtils;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.PlayerRemote;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import java.io.IOException;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.player.PlayerOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("connector.entryHandler.entryRequest")
/*     */ public class EntryHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  36 */     pomelo.connector.EntryHandler.EntryRequest req = pomelo.connector.EntryHandler.EntryRequest.parseFrom(this.pak.getRemaingBytes());
/*     */     
/*  38 */     if (!GWorld.DEBUG && !"1002".equals(req.getC2SClientVersion())) {
/*  39 */       return (PomeloResponse)new ErrorResponse("1月30号才开始公测噢~");
/*     */     }
/*     */     
/*  42 */     String uid = req.getC2SUid();
/*     */     
/*  44 */     if (StringUtil.isEmpty(uid)) {
/*  45 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
/*     */     }
/*  47 */     String token = req.getC2SToken();
/*  48 */     if (StringUtil.isEmpty(token)) {
/*  49 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PLAYER_TOKEN_NULL"));
/*     */     }
/*     */     
/*  52 */     int logicServerId = req.getC2SLogicServerId();
/*  53 */     if (!GWorld.sids.contains(Integer.valueOf(logicServerId))) {
/*  54 */       Out.warn(new Object[] { "登录异常 C2SLogicServerId=", Integer.valueOf(logicServerId), ",SERVER_ID=", Integer.valueOf(GWorld.__SERVER_ID) });
/*  55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */     } 
/*     */ 
/*     */     
/*  59 */     if (LocalDateTime.now().isBefore(GWorld.__EXTERNAL_TIME))
/*     */     {
/*  61 */       if (!isWhiteList(this.pak.getIp(), uid)) {
/*  62 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("SERVER_EXTERNAL_TIME") + GWorld.__EXTERNAL_TIME.format(DateUtils.F_YYYYMMDDHHMMSS));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*  67 */     String auth_token = "/token/" + token;
/*  68 */     String authJson = AuthServer.get(auth_token);
/*  69 */     if (StringUtils.isEmpty(authJson)) {
/*  70 */       Out.warn(new Object[] { "登录已超时,Token信息为空,uid=", uid });
/*  71 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("VERIFY_FAIL"));
/*     */     } 
/*     */     
/*  74 */     TokenInfo tokenInfo = (TokenInfo)JSON.parseObject(authJson, TokenInfo.class);
/*  75 */     if (StringUtils.isEmpty(tokenInfo.getUid()) || !tokenInfo.getUid().equals(uid)) {
/*  76 */       Out.warn(new Object[] { "登录异常,UID不匹配 auth_uid=", tokenInfo.getUid(), ",uid=", uid });
/*  77 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("VERIFY_FAIL"));
/*     */     } 
/*     */ 
/*     */     
/*  81 */     this.pak.setAttr(GGlobal.__KEY_USER_ID, uid);
/*  82 */     this.pak.setAttr(GGlobal.__KEY_TOKEN, auth_token);
/*  83 */     this.pak.setAttr(GGlobal.__KEY_TOKEN_INFO, tokenInfo);
/*     */     
/*  85 */     if (!LoginQueue.checkQueue(this.pak)) {
/*  86 */       return (PomeloResponse)new ErrorResponse("服务器爆满，请稍后...");
/*     */     }
/*     */ 
/*     */     
/*  90 */     this.pak.setAttr(GGlobal.__KEY_LOGIC_SERVERID, Integer.valueOf(logicServerId));
/*  91 */     final List<PlayerOuterClass.PlayerBasic> players = PlayerRemote.getPlayersByUidAndLogicServerId(this.pak.getSession(), uid, logicServerId, this.pak.getIp());
/*  92 */     this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(players.size()));
/*  93 */     Out.info(new Object[] { "玩家进入选角界面uid=", uid, ",playerSize=", Integer.valueOf(players.size()) });
/*     */ 
/*     */     
/*  96 */     AuthServer.expire(auth_token, 7200);
/*     */     
/*  98 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 101 */           pomelo.connector.EntryHandler.EntryResponse.Builder res = pomelo.connector.EntryHandler.EntryResponse.newBuilder();
/*     */           
/* 103 */           res.addAllS2CPlayers(players);
/*     */           
/* 105 */           res.setS2CCode(200);
/* 106 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public boolean isWhiteList(String ip, String uid) {
/*     */     try {
/* 113 */       String ltime = AuthServer.hget("/server/whitelist/ip", ip);
/* 114 */       if (StringUtil.isEmpty(ltime)) {
/* 115 */         ltime = AuthServer.hget("/server/whitelist/uid", uid);
/*     */       }
/* 117 */       if (StringUtil.isEmpty(ltime)) {
/* 118 */         return false;
/*     */       }
/* 120 */       long time = Long.parseLong(ltime);
/* 121 */       if (time > 0L && System.currentTimeMillis() > time) {
/* 122 */         return false;
/*     */       }
/*     */     }
/* 125 */     catch (Exception e) {
/* 126 */       Out.error(new Object[] { "判定白名单异常啦.", e });
/* 127 */       return false;
/*     */     } 
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   public short getType() {
/* 133 */     return 257;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\entry\EntryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */