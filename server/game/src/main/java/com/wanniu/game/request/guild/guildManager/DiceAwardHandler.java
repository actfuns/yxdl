package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.guildDungeon.GuildDiceAwardResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.diceAwardRequest")
public class DiceAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildManagerHandler.DiceAwardRequest req = GuildManagerHandler.DiceAwardRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.DiceAwardResponse.Builder res = GuildManagerHandler.DiceAwardResponse.newBuilder();

                GuildDiceAwardResult data = GuildService.diceAward(player.getId(), req.getS2CPos());
                if (data.result) {
                    res.setS2CCode(200);
                    res.setS2CItemInfo(data.itemInfo);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(data.info);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


