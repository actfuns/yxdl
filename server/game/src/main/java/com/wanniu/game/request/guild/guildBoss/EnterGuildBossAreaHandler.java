package com.wanniu.game.request.guild.guildBoss;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildBossHandler;


@GClientEvent("area.guildBossHandler.enterGuildBossAreaRequest")
public class EnterGuildBossAreaHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            GuildBossHandler.EnterGuildBossAreaResponse.Builder res = GuildBossHandler.EnterGuildBossAreaResponse.newBuilder();
            String msg = player.guildBossManager.handleEnterGuildBossArea();


            protected void write() throws IOException {
                if (this.msg != null) {
                    this.res.setS2CCode(500);
                    this.res.setS2CMsg(this.msg);
                } else {
                    this.res.setS2CCode(200);
                }
                this.body.writeBytes(this.res.build().toByteArray());
            }
        };
    }
}


