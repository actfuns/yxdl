package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.recent.RecentChatMgr;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.getRecentChatListRequest")
public class GetRecentChatListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.GetRecentChatListResponse.Builder res = FriendHandler.GetRecentChatListResponse.newBuilder();
                RecentChatMgr recentMgr = player.getRecentChatMgr();
                res.setS2CCode(200);
                res.addAllS2CLs(recentMgr.getRecentLs());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


