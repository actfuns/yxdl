package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.enterWorldBossRequest")
public class EnterWorldBossHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.EnterWorldBossRequest req = FightLevelHandler.EnterWorldBossRequest.parseFrom(this.pak.getRemaingBytes());
        final int areaId = req.getS2CAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.EnterWorldBossResponse.Builder res = FightLevelHandler.EnterWorldBossResponse.newBuilder();

                Area area = player.getArea();

                if (area.areaId == areaId) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAP_IN_MPA"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (AreaUtil.needCreateArea(area.areaId)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (areaId == GlobalConfig.World_Boss_NewScene) {

                    int newMapLevel = GlobalConfig.World_Boss_NewScene_Close;

                    int questId = GlobalConfig.World_Boss_NweScene_Quest;

                    if (player.player.level >= newMapLevel && player.taskManager.isCompleteTaskByID(questId)) {

                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                        this.body.writeBytes(res.build().toByteArray());
                    }
                }

                Area newArea = AreaUtil.enterArea(player, areaId);
                if (newArea != null) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg("");
                    this.body.writeBytes(res.build().toByteArray());
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


