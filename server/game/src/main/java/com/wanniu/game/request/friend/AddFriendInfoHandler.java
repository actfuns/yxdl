package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.addFriendInfoRequest")
public class AddFriendInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.AddFriendInfoResponse.Builder res = FriendHandler.AddFriendInfoResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                ArrayList<FriendHandler.PlayerInfo> rtData = friendManager.addFriendInfo(player.getLevel());
                res.setS2CCode(200);
                res.addAllData(rtData);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


