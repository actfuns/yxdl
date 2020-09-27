package com.wanniu.game.request.guild.guildDepot;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.guidDepot.GuildCond;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildDepotHandler;


@GClientEvent("area.guildDepotHandler.setConditionRequest")
public class SetConditionHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final GuildDepotHandler.SetConditionRequest req = GuildDepotHandler.SetConditionRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildDepotHandler.SetConditionResponse.Builder res = GuildDepotHandler.SetConditionResponse.newBuilder();

                int useLevel = req.getUseLevel();
                int useUpLevel = req.getUseUpLevel();
                int useJob = req.getUseJob();
                int minLevel = req.getMinLevel();
                int minUpLevel = req.getMinUpLevel();
                int minqColor = req.getMinqColor();
                int maxLevel = req.getMaxLevel();
                int maxUpLevel = req.getMaxUpLevel();
                int maxqColor = req.getMaxqColor();

                GuildDepotCondition cond = new GuildDepotCondition();
                cond.useCond = new GuildCond(useLevel, useUpLevel, useJob, 0);
                cond.minCond = new GuildCond(minLevel, minUpLevel, 0, minqColor);
                cond.maxCond = new GuildCond(maxLevel, maxUpLevel, 0, maxqColor);

                GuildResult resData = player.guildManager.setDepotCondition(cond);
                int result = resData.result;
                if (result == 0) {
                    res.setS2CCode(200);

                    GuildDepotHandler.DepotCondition condition = GuildCommonUtil.toHandlerDepot(resData.newCondition);
                    res.setS2CCondition(condition);
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
                    res.setS2CMsg(LangService.getValue("DEPOT_QUALITY_CONDITION_INVALID"));
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
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


