package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendRefuceApplyRequest")
public class FriendRefuceApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendRefuceApplyRequest msg = FriendHandler.FriendRefuceApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final String requestId = msg.getC2SRequestId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendRefuceApplyResponse.Builder res = FriendHandler.FriendRefuceApplyResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                TreeMap<String, Object> rtData = friendManager.friendRefuseApply(requestId, player);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                if (result) {
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_REFUSE_SUCCESS"));
                } else {

                    res.setS2CCode(500);
                    String info = (String) rtData.get("info");
                    res.setS2CMsg(info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


