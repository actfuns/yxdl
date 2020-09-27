package com.wanniu.game.request.guild.guildTech;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.guildTech.GuildTechManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildTechHandler;


@GClientEvent("area.guildTechHandler.buyGuildProductRequest")
public class BuyGuildProductHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildTechHandler.BuyGuildProductRequest req = GuildTechHandler.BuyGuildProductRequest.parseFrom(this.pak.getRemaingBytes());
        final int productId = req.getProductId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildTechHandler.BuyGuildProductResponse.Builder res = GuildTechHandler.BuyGuildProductResponse.newBuilder();
                GuildTechManager guildTechManager = player.guildManager.guildTechManager;
                GuildResult ret = guildTechManager.buyGuildTechProduct(productId);
                int result = ret.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setS2CId(Integer.parseInt(ret.id));
                    res.setS2CState(ret.state);
                    res.setS2CContribution(player.guildManager.getContribution());
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_PRODUCT_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_PRODUCT_SELL_OUT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PRODUCT_NEED_JOB_TOO_LOW"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PRODUCT_NEED_LEVEL_TOO_LOW"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTION_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -7) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
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


