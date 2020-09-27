package com.wanniu.game.request.farm;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.cultivateFriendRequest")
public class CultivateFriendHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.CultivateFriendRequest msg = FarmHandler.CultivateFriendRequest.parseFrom(this.pak.getRemaingBytes());
        final String friendId = msg.getFriendId();
        final int blockId = msg.getBlockId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmMgr farmMgr = player.getFarmMgr();
                FarmHandler.CultivateFriendResponse.Builder res = farmMgr.cultivateFriend(blockId, friendId);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


