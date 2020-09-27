package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.friend.ChouRenManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.TreeMap;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.friendAddChouRenRequest")
public class FriendAddChouRenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final ChouRenManager chouRenManager = player.getChouRenManager();
        FriendHandler.FriendAddChouRenRequest msg = FriendHandler.FriendAddChouRenRequest.parseFrom(this.pak.getRemaingBytes());
        final String chouRenId = msg.getC2SChouRenId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                TreeMap<String, Object> rtData = chouRenManager.add2ChouRenList(chouRenId);
                boolean result = ((Boolean) rtData.get("result")).booleanValue();
                FriendHandler.FriendAddChouRenResponse.Builder res = FriendHandler.FriendAddChouRenResponse.newBuilder();
                String info = (String) rtData.get("info");
                if (result) {
                    res.setS2CCode(200);
                } else {

                    res.setS2CCode(500);
                }
                res.setS2CMsg(info);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


