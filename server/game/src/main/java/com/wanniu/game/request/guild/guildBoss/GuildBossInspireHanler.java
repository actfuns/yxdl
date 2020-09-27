package com.wanniu.game.request.guild.guildBoss;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildBossHandler;


@GClientEvent("area.guildBossHandler.guildBossInspireRequest")
public class GuildBossInspireHanler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildBossHandler.GuildBossInspireRequest req = GuildBossHandler.GuildBossInspireRequest.parseFrom(this.pak.getRemaingBytes());
        final int index = req.getC2SIndex();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildBossHandler.EnterGuildBossAreaResponse.Builder res = GuildBossHandler.EnterGuildBossAreaResponse.newBuilder();
                String msg = player.guildBossManager.handlerInspireGuildBoss(index);
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


