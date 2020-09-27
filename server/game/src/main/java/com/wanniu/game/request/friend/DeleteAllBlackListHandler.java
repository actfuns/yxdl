package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.deleteAllBlackListRequest")
public class DeleteAllBlackListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.DeleteAllBlackListResponse.Builder res = FriendHandler.DeleteAllBlackListResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                friendManager.deleteBlackList();
                res.setS2CCode(200);
                res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


