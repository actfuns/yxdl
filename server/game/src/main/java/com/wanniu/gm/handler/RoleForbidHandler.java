package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;

@GMEvent
public class RoleForbidHandler
        extends GMBaseHandler {
    public enum ForbidType {
        LOCK, UNLOCK, SHUTUP, UNSHUTUP, KICK;
    }

    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        int type = arr.getIntValue(1);
        String time = arr.getString(2);
        String reason = arr.getString(3);
        PlayerPO po = PlayerUtil.getPlayerBaseData(id);
        if (type == ForbidType.LOCK.ordinal()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(id);
            if (player != null) {
                player.kick(Const.KickReason.GM_KICK);
            }
            po.freezeTime = DateUtil.format(time);
            po.freezeReason = reason;
        } else if (type == ForbidType.UNLOCK.ordinal()) {
            po.freezeTime = null;
            po.freezeReason = null;
        } else if (type == ForbidType.SHUTUP.ordinal()) {
            po.forbidTalkTime = DateUtil.format(time);
            po.forbidTalkReason = reason;
        } else if (type == ForbidType.UNSHUTUP.ordinal()) {
            po.forbidTalkTime = null;
            po.forbidTalkReason = null;
        } else if (type == ForbidType.KICK.ordinal()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(id);
            if (player != null) {
                player.kick(Const.KickReason.GM_KICK);
            }
        }
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 12290;
    }
}


