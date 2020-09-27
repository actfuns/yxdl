package com.wanniu.game.request.redpacket;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.redpacket.RedPacketService;

import java.io.IOException;

import pomelo.redpacket.RedPacketHandler;


@GClientEvent("redpacket.redPacketHandler.getRedPacketListRequest")
public class GetRedPacketListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final RedPacketHandler.GetRedPacketListResponse.Builder res = RedPacketService.getInstance().getAllRedPackets(player.getId());
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


