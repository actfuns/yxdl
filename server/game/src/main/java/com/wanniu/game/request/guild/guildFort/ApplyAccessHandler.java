package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.applyAccessRequest")
public class ApplyAccessHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildFortHandler.ApplyAccessRequest req = GuildFortHandler.ApplyAccessRequest.parseFrom(this.pak.getRemaingBytes());
        final int fortId = req.getAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.ApplyAccessResponse.Builder res = GuildFortHandler.ApplyAccessResponse.newBuilder();
                String msg = player.guildFortManager.handleEnterPrepareArea(fortId);
                if (msg != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


