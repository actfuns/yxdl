package com.wanniu.game.request.friend;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.FriendManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.addBlackListRequest")
public class AddBlackListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FriendHandler.AddBlackListRequest msg = FriendHandler.AddBlackListRequest.parseFrom(this.pak.getRemaingBytes());
        final String blackListId = msg.getC2SBlackListId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.AddBlackListResponse.Builder res = FriendHandler.AddBlackListResponse.newBuilder();
                FriendManager friendManager = player.getFriendManager();
                String info = friendManager.addBlackList(blackListId);
                if (info == null) {
                    res.setS2CCode(200);
                    res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


