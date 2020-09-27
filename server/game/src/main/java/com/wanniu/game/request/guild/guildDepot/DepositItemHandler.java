package com.wanniu.game.request.guild.guildDepot;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildDepotHandler;


@GClientEvent("area.guildDepotHandler.depositItemRequest")
public class DepositItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildDepotHandler.DepositItemRequest req = GuildDepotHandler.DepositItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int c2s_fromIndex = req.getC2SFromIndex();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildDepotHandler.DepositItemResponse.Builder res = GuildDepotHandler.DepositItemResponse.newBuilder();
                if (c2s_fromIndex == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult resData = player.guildManager.depositEquipToDepot(c2s_fromIndex);
                int result = resData.result;
                if (result == 0) {
                    player.taskManager.dealTaskEvent(Const.TaskType.GUILD_CONTRIBUTE, 1);
                    res.setS2CCode(200);
                    res.setS2CBagGrid(resData.bagGrid);
                    res.setDepositCount(resData.depositCount);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EMPTY_BAG_INDEX"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_NOT_EQUIP"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_IS_BIND"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_CANNOT_DEPOSIT"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_DEPOSIT_COUNT_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -7) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_LEVEL_NOT_NOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -8) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_COLOR_NOT_NOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -9) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_CONFIG_NOT_EXIST"));
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
                    res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_UPLEVEL_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_LEVEL_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_JOB_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_QUALITY_NOT_IN_CONDITION"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 7) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DEPOT_SPACE_NOT_ENOUGH"));
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


