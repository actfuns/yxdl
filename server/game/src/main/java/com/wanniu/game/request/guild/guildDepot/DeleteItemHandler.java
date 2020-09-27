package com.wanniu.game.request.guild.guildDepot;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildDepotHandler;


@GClientEvent("area.guildDepotHandler.deleteItemRequest")
public class DeleteItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildDepotHandler.DeleteItemRequest req = GuildDepotHandler.DeleteItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int c2s_fromIndex = req.getC2SFromIndex();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildDepotHandler.DeleteItemResponse.Builder res = GuildDepotHandler.DeleteItemResponse.newBuilder();
                GuildResult resData = player.guildManager.deleteEquipFromDepot(c2s_fromIndex);
                int result = resData.result;
                if (result == 0) {
                    res.setS2CCode(200);
                    res.setDeleteCount(resData.deleteCount);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_DELETE_T_COUNT_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EMPTY_DEPOT_BAG_INDEX"));
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


