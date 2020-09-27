package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;


@GMEvent
public class NoticeHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String content = arr.getString(0);
        for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
            WNPlayer wp = (WNPlayer) p;
            wp.sendSysTip(content, Const.TipsType.ROLL);
        }

        MessageUtil.sendRollChat(GWorld.__SERVER_ID, content, Const.CHAT_SCOPE.SYSTEM);
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 4482;
    }
}


