package com.wanniu.game.request.friend;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendDeleteRequest")
public class FriendDeleteHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.FriendDeleteRequest msg = FriendHandler.FriendDeleteRequest.parseFrom(this.pak.getRemaingBytes());
        final String friendId = msg.getC2SFriendId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.FriendDeleteResponse.Builder res = FriendHandler.FriendDeleteResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                JSONObject ret = friendManager.deleteFriend(friendId);
                if (ret.getIntValue("code") == 200) {
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
                } else if (ret.getIntValue("code") == 500) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FRIEND_NOT_EXIST"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


