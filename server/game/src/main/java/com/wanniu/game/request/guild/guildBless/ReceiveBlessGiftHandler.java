package com.wanniu.game.request.guild.guildBless;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildBlessHandler;


@GClientEvent("area.guildBlessHandler.receiveBlessGiftRequest")
public class ReceiveBlessGiftHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildBlessHandler.ReceiveBlessGiftRequest req = GuildBlessHandler.ReceiveBlessGiftRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildBlessHandler.ReceiveBlessGiftResponse.Builder res = GuildBlessHandler.ReceiveBlessGiftResponse.newBuilder();

                GuildResult resData = player.guildManager.receiveBlessGift(req.getIndex());
                int result = resData.result;
                if (0 == result) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-1 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BLESS_GIFT_HAVE_RECEIVED"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (-2 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (1 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (2 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BLESS_NOT_FINISH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (3 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_PARAMS"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (4 == result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_GETTED"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


