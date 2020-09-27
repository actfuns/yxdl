package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.concernFriendRequest")
public class ConcernFriendHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.ConcernFriendRequest msg = FriendHandler.ConcernFriendRequest.parseFrom(this.pak.getRemaingBytes());
        final String friendId = msg.getC2SFriendId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.ConcernFriendResponse.Builder res = FriendHandler.ConcernFriendResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                TreeMap<String, Object> rtData = friendManager.concernFriend(friendId, player);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                String info = (String) rtData.get("info");
                if (result) {
                    res.setS2CCode(200);
                    res.setS2CMsg(info);
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


