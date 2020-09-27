package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.queryPlayerNameRequest")
public class QueryPlayerNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.QueryPlayerNameRequest msg = FriendHandler.QueryPlayerNameRequest.parseFrom(this.pak.getRemaingBytes());
        final String strName = msg.getC2SStrName();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendManager friendManager = player.getFriendManager();
                FriendHandler.QueryPlayerNameResponse.Builder rtData = friendManager.queryPlayerName(strName);
                this.body.writeBytes(rtData.build().toByteArray());
            }
        };
    }
}


