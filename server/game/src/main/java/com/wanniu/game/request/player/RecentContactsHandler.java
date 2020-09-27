package com.wanniu.game.request.player;

import com.google.protobuf.ProtocolStringList;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.recentContactsRequest")
public class RecentContactsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        PlayerHandler.RecentContactsRequest req = PlayerHandler.RecentContactsRequest.parseFrom(this.pak.getRemaingBytes());
        final ProtocolStringList ids = req.getC2SIdsList();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.RecentContactsResponse.Builder res = PlayerHandler.RecentContactsResponse.newBuilder();

                List<PlayerHandler.recentContactInfo> data = new ArrayList<>();
                if (ids == null) {
                    res.setS2CCode(500);
                    res.addAllS2CData(data);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                ids.forEach(v -> {
                    WNPlayer p = PlayerUtil.findPlayer(v);

                    PlayerHandler.recentContactInfo.Builder info = PlayerHandler.recentContactInfo.newBuilder();
                    info.setId(v);
                    info.setName(p.getName());
                    info.setLevel((p.getPlayer()).level);
                    info.setPro((p.getPlayer()).pro);
                    info.setIsFriend(1);
                    data.add(info.build());
                });
                data.forEach(v -> {

                });


                res.setS2CCode(200);
                res.addAllS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


