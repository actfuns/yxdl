package com.wanniu.game.request.friend;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.concernAllFriendRequest")
public class ConcernAllFriendHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.ConcernAllFriendRequest msg = FriendHandler.ConcernAllFriendRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList friendIds = msg.getC2SFriendIdsList();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.ConcernAllFriendResponse.Builder res = FriendHandler.ConcernAllFriendResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                for (String s : friendIds) {
                    friendManager.concernFriend(s, player);
                }
                res.setS2CCode(200);
                res.setS2CMsg("");
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


