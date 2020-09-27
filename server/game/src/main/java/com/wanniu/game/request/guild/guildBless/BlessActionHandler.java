package com.wanniu.game.request.guild.guildBless;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildBlessHandler;


@GClientEvent("area.guildBlessHandler.blessActionRequest")
public class BlessActionHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildBlessHandler.BlessActionRequest req = GuildBlessHandler.BlessActionRequest.parseFrom(this.pak.getRemaingBytes());
        final int id = req.getId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildBlessHandler.BlessActionResponse.Builder res = GuildBlessHandler.BlessActionResponse.newBuilder();

                if (id <= 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildResult resData = player.guildManager.blessAction(id, 1);
                int result = resData.result;
                if (result == 0) {
                    player.taskManager.dealTaskEvent(Const.TaskType.GUILD_PRAY, 1);
                    GuildResult.GuildBlessActionData data = (GuildResult.GuildBlessActionData) resData.data;
                    res.setS2CCode(200);
                    GuildBlessHandler.BlessResult.Builder s2c_result = GuildBlessHandler.BlessResult.newBuilder();
                    s2c_result.setBlessCount(data.blessCount);
                    s2c_result.setBlessValue(data.blessValue);
                    s2c_result.setId(data.id);
                    s2c_result.setFinishNum(data.finishNum);
                    s2c_result.addAllFinishState(GuildCommonUtil.toList(data.finishState));
                    res.setS2CResult(s2c_result.build());
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
                    res.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
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
                    res.setS2CMsg(LangService.getValue("BLESS_TIMES_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == 3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BLESS_ITEM_NOT_EXIST"));
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


