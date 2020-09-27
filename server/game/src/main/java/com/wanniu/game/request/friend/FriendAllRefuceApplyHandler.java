package com.wanniu.game.request.friend;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAllRefuceApplyRequest")
public class FriendAllRefuceApplyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendAllRefuceApplyRequest msg = FriendHandler.FriendAllRefuceApplyRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList requestIds = msg.getC2SRequestIdsList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendAllRefuceApplyResponse.Builder res = FriendHandler.FriendAllRefuceApplyResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                for (String s : requestIds) {
                    friendManager.friendRefuseApply(s, player);
                }
                res.setS2CCode(200);
                res.setS2CMsg(LangService.getValue("FRIEND_REFUSE_SUCCESS"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


