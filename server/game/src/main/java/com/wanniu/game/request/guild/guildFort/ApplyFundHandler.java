package com.wanniu.game.request.guild.guildFort;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildFortHandler;


@GClientEvent("area.guildFortHandler.applyFundRequest")
public class ApplyFundHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildFortHandler.ApplyFundRequest req = GuildFortHandler.ApplyFundRequest.parseFrom(this.pak.getRemaingBytes());
        final int fortId = req.getAreaId();
        final int fund = req.getApplyFund();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildFortHandler.ApplyFundResponse.Builder res = GuildFortHandler.ApplyFundResponse.newBuilder();
                String msg = player.guildFortManager.handleApplyFund(res, fortId, fund);
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


