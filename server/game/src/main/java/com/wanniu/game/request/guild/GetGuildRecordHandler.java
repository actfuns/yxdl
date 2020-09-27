package com.wanniu.game.request.guild;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.getGuildRecordRequest")
public class GetGuildRecordHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildHandler.GetGuildRecordRequest req = GuildHandler.GetGuildRecordRequest.parseFrom(this.pak.getRemaingBytes());
        final int page = req.getPage();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.GetGuildRecordResponse.Builder res = GuildHandler.GetGuildRecordResponse.newBuilder();
                List<GuildHandler.RecordInfo> recordList = player.guildManager.getGuildRecordList(page);
                res.setS2CCode(200);
                res.setS2CPage(page);
                res.addAllS2CRecordList(recordList);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


