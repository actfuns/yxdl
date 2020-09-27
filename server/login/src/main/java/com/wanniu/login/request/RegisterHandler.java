package com.wanniu.login.request;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.protocol.ErrorResponse;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.game.request.GClientEvent;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.GCache;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.login.LoginServer;
import com.wanniu.login.proto.LoginHandler;
import com.wanniu.login.vo.AppVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@GClientEvent("login.loginHandler.registerRequest")
public class RegisterHandler
        extends PomeloRequest {
    private Map<Integer, Integer> DEFAULT = new HashMap<>();


    public PomeloResponse request() throws Exception {
        if (LoginServer.getInstance().isBlackIp(this.pak.getIp())) {
            this.pak.close();
            return null;
        }

        LoginHandler.RegisterRequest req = LoginHandler.RegisterRequest.parseFrom(this.pak.getRemaingBytes());
        String accout = req.getAccount();
        if (StringUtil.isEmpty(accout)) {
            return (PomeloResponse) new ErrorResponse("账号不能为空！");
        }
        if (!StringUtil.isAlphaNumeric_(accout)) {
            return (PomeloResponse) new ErrorResponse("账号只能由字母数字和_构成！");
        }
        if (accout.length() < 6) {
            return (PomeloResponse) new ErrorResponse("账号长度不能少于6位！");
        }
        if (GCache.exists("/account/" + accout)) {
            return (PomeloResponse) new ErrorResponse("账号已存在！");
        }

        String pwd = req.getPassword();
        if (StringUtil.isEmpty(pwd)) {
            return (PomeloResponse) new ErrorResponse("密码不能为空！");
        }
        final AppVO app = LoginServer.getInstance().getApp(req.getAppId());
        if (app == null) {
            return (PomeloResponse) new ErrorResponse("app id not exists : " + req.getAppId());
        }


        final String uuid = UUID.randomUUID().toString();
        GCache.put("/account/" + accout, pwd);

        Map<String, String> tokenInfo = TokenUtils.build("", accout, req.getImei(), String.valueOf(req.getOs()));
        GCache.put("/token/" + uuid, JSON.toJSONString(tokenInfo), 600);

        Out.info(new Object[]{"新增账号：", accout, " = ", pwd, this.pak.getIp()});
        this.pak.setAttr(GGlobal._KEY_USER_ID, accout);
        return new PomeloResponse() {
            protected void write() throws IOException {
                LoginHandler.RegisterResponse.Builder res = LoginHandler.RegisterResponse.newBuilder();
                res.setS2CCode(200);

                res.setToken(uuid);
                res.setBoard(app.getServerList(RegisterHandler.this.DEFAULT, RegisterHandler.this.pak).toJSONString());

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


