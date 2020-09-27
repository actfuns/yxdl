package com.wanniu.game.request.entry;

import cn.qeng.common.login.TokenInfo;
import com.alibaba.fastjson.JSON;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.login.AuthServer;
import com.wanniu.core.util.DateUtils;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.PlayerRemote;
import com.wanniu.game.common.msg.ErrorResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import pomelo.player.PlayerOuterClass;


@GClientEvent("connector.entryHandler.entryRequest")
public class EntryHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        pomelo.connector.EntryHandler.EntryRequest req = pomelo.connector.EntryHandler.EntryRequest.parseFrom(this.pak.getRemaingBytes());

        if (!GWorld.DEBUG && !"1002".equals(req.getC2SClientVersion())) {
            return (PomeloResponse) new ErrorResponse("1月30号才开始公测噢~");
        }

        String uid = req.getC2SUid();

        if (StringUtil.isEmpty(uid)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
        }
        String token = req.getC2SToken();
        if (StringUtil.isEmpty(token)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_TOKEN_NULL"));
        }

        int logicServerId = req.getC2SLogicServerId();
        if (!GWorld.sids.contains(Integer.valueOf(logicServerId))) {
            Out.warn(new Object[]{"登录异常 C2SLogicServerId=", Integer.valueOf(logicServerId), ",SERVER_ID=", Integer.valueOf(GWorld.__SERVER_ID)});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        if (LocalDateTime.now().isBefore(GWorld.__EXTERNAL_TIME)) {
            if (!isWhiteList(this.pak.getIp(), uid)) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("SERVER_EXTERNAL_TIME") + GWorld.__EXTERNAL_TIME.format(DateUtils.F_YYYYMMDDHHMMSS));
            }
        }


        String auth_token = "/token/" + token;
        String authJson = AuthServer.get(auth_token);
        if (StringUtils.isEmpty(authJson)) {
            Out.warn(new Object[]{"登录已超时,Token信息为空,uid=", uid});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("VERIFY_FAIL"));
        }

        TokenInfo tokenInfo = (TokenInfo) JSON.parseObject(authJson, TokenInfo.class);
        if (StringUtils.isEmpty(tokenInfo.getUid()) || !tokenInfo.getUid().equals(uid)) {
            Out.warn(new Object[]{"登录异常,UID不匹配 auth_uid=", tokenInfo.getUid(), ",uid=", uid});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("VERIFY_FAIL"));
        }


        this.pak.setAttr(GGlobal.__KEY_USER_ID, uid);
        this.pak.setAttr(GGlobal.__KEY_TOKEN, auth_token);
        this.pak.setAttr(GGlobal.__KEY_TOKEN_INFO, tokenInfo);

        if (!LoginQueue.checkQueue(this.pak)) {
            return (PomeloResponse) new ErrorResponse("服务器爆满，请稍后...");
        }


        this.pak.setAttr(GGlobal.__KEY_LOGIC_SERVERID, Integer.valueOf(logicServerId));
        final List<PlayerOuterClass.PlayerBasic> players = PlayerRemote.getPlayersByUidAndLogicServerId(this.pak.getSession(), uid, logicServerId, this.pak.getIp());
        this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(players.size()));
        Out.info(new Object[]{"玩家进入选角界面uid=", uid, ",playerSize=", Integer.valueOf(players.size())});


        AuthServer.expire(auth_token, 7200);

        return new PomeloResponse() {
            protected void write() throws IOException {
                pomelo.connector.EntryHandler.EntryResponse.Builder res = pomelo.connector.EntryHandler.EntryResponse.newBuilder();

                res.addAllS2CPlayers(players);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public boolean isWhiteList(String ip, String uid) {
        try {
            String ltime = AuthServer.hget("/server/whitelist/ip", ip);
            if (StringUtil.isEmpty(ltime)) {
                ltime = AuthServer.hget("/server/whitelist/uid", uid);
            }
            if (StringUtil.isEmpty(ltime)) {
                return false;
            }
            long time = Long.parseLong(ltime);
            if (time > 0L && System.currentTimeMillis() > time) {
                return false;
            }
        } catch (Exception e) {
            Out.error(new Object[]{"判定白名单异常啦.", e});
            return false;
        }
        return true;
    }

    public short getType() {
        return 257;
    }
}


