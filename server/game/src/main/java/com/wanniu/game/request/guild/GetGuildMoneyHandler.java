package com.wanniu.game.request.guild;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getGuildMoneyRequest")
public class GetGuildMoneyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetGuildMoneyResponse.Builder res = GuildHandler.GetGuildMoneyResponse.newBuilder();

                JSONObject retData = player.guildManager.toJson4MoneyPayLoad();
                res.setS2CCode(200);
                res.setDepositCount(retData.getIntValue("depositCount"));
                res.setDepositCountMax(retData.getIntValue("depositCountMax"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


