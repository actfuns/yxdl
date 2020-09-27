package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.enterDungeonRequest")
public class EnterDungeonHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.EnterDungeonRequest req = FightLevelHandler.EnterDungeonRequest.parseFrom(this.pak.getRemaingBytes());

        final int dungeonId = req.getC2SDungeonId();
        Out.debug(new Object[]{getClass().getName(), " : ", Integer.valueOf(dungeonId)});

        Area area = player.getArea();
        if (area != null &&
                dungeonId == area.areaId) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("MAP_IN_MPA"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.EnterDungeonResponse.Builder res = FightLevelHandler.EnterDungeonResponse.newBuilder();

                FightLevelManager fightLevelManager = player.fightLevelManager;

                String data = fightLevelManager.enterDungeonReq(player, dungeonId);
                if (data == null) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(data);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


