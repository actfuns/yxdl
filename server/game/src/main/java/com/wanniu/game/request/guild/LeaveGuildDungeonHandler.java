package com.wanniu.game.request.guild;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.guildDungeon.GuildDungeon;
import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildHandler;


@GClientEvent("area.guildHandler.leaveGuildDungeonRequest")
public class LeaveGuildDungeonHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildHandler.LeaveGuildDungeonResponse.Builder res = GuildHandler.LeaveGuildDungeonResponse.newBuilder();

                GuildDungeon area = (GuildDungeon) player.getArea();
                if (area.sceneType != Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("AREA_ID_NULL"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                GuildDungeonResult data = player.guildManager.leaveDungeon(player);

                if (data.result) {
                    res.setS2CCode(200);
                    res.setS2CMsg(data.info);
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


