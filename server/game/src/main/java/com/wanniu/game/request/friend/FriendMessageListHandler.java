package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendMessageListRequest")
public class FriendMessageListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendManager friendManager = player.getFriendManager();
                FriendHandler.FriendMessageListResponse.Builder rtData = friendManager.friendMessageList();
                rtData.setS2CCode(200);
                rtData.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
                this.body.writeBytes(rtData.build().toByteArray());
            }
        };
    }
}


