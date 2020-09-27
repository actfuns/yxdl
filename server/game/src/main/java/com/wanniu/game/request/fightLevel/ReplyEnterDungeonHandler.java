package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.replyEnterDungeonRequest")
public class ReplyEnterDungeonHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        FightLevelHandler.ReplyEnterDungeonRequest req = FightLevelHandler.ReplyEnterDungeonRequest.parseFrom(this.pak.getRemaingBytes());

        int dungeonId = req.getC2SDungeonId();
        int c2sType = req.getC2SType();

        String data = null;


        FightLevelManager fightLevelManager = player.fightLevelManager;
        data = fightLevelManager.replyEnterDungeon(player, c2sType, dungeonId);

        Out.debug(new Object[]{"c2sType:", Integer.valueOf(c2sType), " - ", data});

        final FightLevelHandler.ReplyEnterDungeonResponse.Builder res = FightLevelHandler.ReplyEnterDungeonResponse.newBuilder();
        if (data == null) {
            res.setS2CCode(200);
        } else {
            res.setS2CCode(500);
            res.setS2CMsg(data);
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


