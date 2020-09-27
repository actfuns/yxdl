package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.recent.RecentChatMgr;

import java.io.IOException;
import java.util.List;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.getChatMsgRequest")
public class GetChatMsgHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final FriendHandler.GetChatMsgRequest req = FriendHandler.GetChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.GetChatMsgResponse.Builder res = FriendHandler.GetChatMsgResponse.newBuilder();
                RecentChatMgr recentChatMgr = player.getRecentChatMgr();
                List<FriendHandler.ChatMsg> ls = recentChatMgr.getRecentMsg(req.getC2SFriendId());
                res.setS2CCode(200);
                res.addAllS2CMsgLs(ls);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


