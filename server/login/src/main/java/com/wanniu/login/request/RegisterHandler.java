/*    */ package com.wanniu.login.request;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.game.protocol.ErrorResponse;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.game.request.GClientEvent;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.redis.GCache;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.login.LoginServer;
/*    */ import com.wanniu.login.proto.LoginHandler;
/*    */ import com.wanniu.login.vo.AppVO;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ 
/*    */ @GClientEvent("login.loginHandler.registerRequest")
/*    */ public class RegisterHandler
/*    */   extends PomeloRequest
/*    */ {
/* 25 */   private Map<Integer, Integer> DEFAULT = new HashMap<>();
/*    */ 
/*    */   
/*    */   public PomeloResponse request() throws Exception {
/* 29 */     if (LoginServer.getInstance().isBlackIp(this.pak.getIp())) {
/* 30 */       this.pak.close();
/* 31 */       return null;
/*    */     } 
/*    */     
/* 34 */     LoginHandler.RegisterRequest req = LoginHandler.RegisterRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     String accout = req.getAccount();
/* 36 */     if (StringUtil.isEmpty(accout)) {
/* 37 */       return (PomeloResponse)new ErrorResponse("账号不能为空！");
/*    */     }
/* 39 */     if (!StringUtil.isAlphaNumeric_(accout)) {
/* 40 */       return (PomeloResponse)new ErrorResponse("账号只能由字母数字和_构成！");
/*    */     }
/* 42 */     if (accout.length() < 6) {
/* 43 */       return (PomeloResponse)new ErrorResponse("账号长度不能少于6位！");
/*    */     }
/* 45 */     if (GCache.exists("/account/" + accout)) {
/* 46 */       return (PomeloResponse)new ErrorResponse("账号已存在！");
/*    */     }
/*    */     
/* 49 */     String pwd = req.getPassword();
/* 50 */     if (StringUtil.isEmpty(pwd)) {
/* 51 */       return (PomeloResponse)new ErrorResponse("密码不能为空！");
/*    */     }
/* 53 */     final AppVO app = LoginServer.getInstance().getApp(req.getAppId());
/* 54 */     if (app == null) {
/* 55 */       return (PomeloResponse)new ErrorResponse("app id not exists : " + req.getAppId());
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     final String uuid = UUID.randomUUID().toString();
/* 63 */     GCache.put("/account/" + accout, pwd);
/*    */     
/* 65 */     Map<String, String> tokenInfo = TokenUtils.build("", accout, req.getImei(), String.valueOf(req.getOs()));
/* 66 */     GCache.put("/token/" + uuid, JSON.toJSONString(tokenInfo), 600);
/*    */     
/* 68 */     Out.info(new Object[] { "新增账号：", accout, " = ", pwd, this.pak.getIp() });
/* 69 */     this.pak.setAttr(GGlobal._KEY_USER_ID, accout);
/* 70 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 73 */           LoginHandler.RegisterResponse.Builder res = LoginHandler.RegisterResponse.newBuilder();
/* 74 */           res.setS2CCode(200);
/*    */           
/* 76 */           res.setToken(uuid);
/* 77 */           res.setBoard(app.getServerList(RegisterHandler.this.DEFAULT, RegisterHandler.this.pak).toJSONString());
/*    */           
/* 79 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\request\RegisterHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */