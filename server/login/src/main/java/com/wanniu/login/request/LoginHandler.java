package com.wanniu.login.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.protocol.ErrorResponse;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.game.request.GClientEvent;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.core.util.http.HttpRequester;
import com.wanniu.core.util.http.HttpRespons;
import com.wanniu.login.LoginServer;
import com.wanniu.login.vo.AppVO;
import com.wanniu.login.vo.LoginResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@GClientEvent("login.loginHandler.loginRequest")
public class LoginHandler
        extends PomeloRequest {
    private static HttpRequester httpReq = new HttpRequester("UTF-8");

    public PomeloResponse request() throws Exception {
        final String newUid;
        com.wanniu.login.proto.LoginHandler.LoginRequest req = com.wanniu.login.proto.LoginHandler.LoginRequest.parseFrom(this.pak.getRemaingBytes());
        String uid = req.getUid();
        String token = req.getToken();
        if (StringUtil.isEmpty(uid) || StringUtil.isEmpty(token)) {
            return (PomeloResponse) new ErrorResponse("用户名和密码不能为空！");
        }
        if (LoginServer.getInstance().isBlackList(this.pak.getIp(), uid)) {
            Out.warn(new Object[]{this.pak.getIp(), " : ", uid});
            this.pak.close();
            return null;
        }

        AppVO app = null;
        int appId = LoginServer.__APP_ID;
        if (StringUtil.isNotEmpty(req.getChannel())) {
            Map<String, String> params = new HashMap<>();
            params.put("uid", req.getUid());
            params.put("channel", req.getChannel());
            params.put("channelUid", req.getChannelUid());
            params.put("accessToken", req.getToken());
            params.put("productId", req.getAppId());
            params.put("mac", req.getImei());
            params.put("os", String.valueOf(req.getOs()));
            params.put("ip", this.pak.getIp());
            String loginUrl = GConfig.getInstance().get("usercenter.url");
            HttpRespons respons = httpReq.sendPost(loginUrl, params);
            if (respons.getCode() == 200 && StringUtil.isNotEmpty(respons.getContent())) {
                LoginResult loginResult = (LoginResult) JSON.parseObject(respons.getContent(), LoginResult.class);
                if (!loginResult.success) {
                    return (PomeloResponse) new ErrorResponse(loginResult.desc);
                }
                app = LoginServer.getInstance().getApp(appId);
                uid = loginResult.username;
            } else {
                return (PomeloResponse) new ErrorResponse("登录验证失败！");
            }
        } else {
            String pwd = GCache.get("/account/" + uid);
            if (!token.equals(pwd)) {
                return (PomeloResponse) new ErrorResponse("用户名或密码错误！");
            }
            if (StringUtil.isNumeric(req.getAppId())) {
                appId = Integer.parseInt(req.getAppId());
            } else {
                Out.warn(new Object[]{this.pak.getIp(), " login error app ", req.getAppId()});
            }
            app = LoginServer.getInstance().getApp(appId);
        }
        if (app == null) {
            return (PomeloResponse) new ErrorResponse("app id not exists : " + appId);
        }

        final String uuid = UUID.randomUUID().toString();

        String playerServers = GCache.get("/player/servers/" + uid);
        Map<Integer, Integer> histories = new HashMap<>();
        if (!StringUtil.isEmpty(playerServers)) {
            try {
                JSONArray arr = JSON.parseArray(playerServers);
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject json = arr.getJSONObject(i);
                    int sid = json.getIntValue("sid");
                    int count = json.getIntValue("count");
                    if (count > 0) {
                        histories.put(Integer.valueOf(sid), Integer.valueOf(count));
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }


        if (StringUtil.isNotEmpty(req.getChannel())) {
            String channel = req.getChannel();
            int length = channel.length() + 1 + uid.length();
            newUid = (new StringBuilder(length)).append(channel).append('_').append(uid).toString();
        } else {

            newUid = uid;
        }

        Map<String, String> tokenInfo = TokenUtils.build(req.getChannel(), newUid, req.getImei(),
                String.valueOf(req.getOs()));
        GCache.put("/token/" + uuid, JSON.toJSONString(tokenInfo), 600);

        this.pak.setAttr(GGlobal._KEY_USER_ID, newUid);
        final JSONArray board = app.getServerList(histories, this.pak);

        return new PomeloResponse() {
            protected void write() throws IOException {
                com.wanniu.login.proto.LoginHandler.LoginResponse.Builder res = com.wanniu.login.proto.LoginHandler.LoginResponse.newBuilder();
                res.setS2CCode(200);
                res.setToken(uuid);
                res.setNewUid(newUid);
                res.setBoard(board.toJSONString());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


