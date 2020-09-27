package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.ChouRenManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendDeleteChouRenRequest")
public class FriendDeleteChouRenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendDeleteChouRenRequest msg = FriendHandler.FriendDeleteChouRenRequest.parseFrom(this.pak.getRemaingBytes());
        final String chouRenId = msg.getC2SChouRenId();
        final ChouRenManager chouRenManager = player.getChouRenManager();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendDeleteChouRenResponse.Builder res = FriendHandler.FriendDeleteChouRenResponse.newBuilder();
                boolean rtFlag = chouRenManager.deleteChouRenById(chouRenId);
                if (rtFlag) {
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FRIEND_ADD_FAIL"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


