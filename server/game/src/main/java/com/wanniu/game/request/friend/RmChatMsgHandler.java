package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.recent.RecentChatMgr;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.rmChatMsgRequest")
public class RmChatMsgHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final FriendHandler.RmChatMsgRequest req = FriendHandler.RmChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.RmChatMsgResponse.Builder res = FriendHandler.RmChatMsgResponse.newBuilder();
                try {
                    RecentChatMgr recentMgr = player.getRecentChatMgr();
                    recentMgr.removeRecentMsg(req.getC2SFriendId());
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


