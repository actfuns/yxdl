package com.wanniu.game.request.friend;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.ChouRenManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAllDeleteChouRenRequest")
public class FriendAllDeleteChouRenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendAllDeleteChouRenRequest msg = FriendHandler.FriendAllDeleteChouRenRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList chouRenIds = msg.getC2SChouRenIdsList();
        final ChouRenManager chouRenManager = player.getChouRenManager();
        return new PomeloResponse() {
            protected void write() throws IOException {
                for (String s : chouRenIds) {
                    chouRenManager.deleteChouRenById(s);
                }
                FriendHandler.FriendAllDeleteChouRenResponse.Builder res = FriendHandler.FriendAllDeleteChouRenResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
            }
        };
    }
}


