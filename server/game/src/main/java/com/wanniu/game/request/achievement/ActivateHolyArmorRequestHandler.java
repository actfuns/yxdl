package com.wanniu.game.request.achievement;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AchievementDataPO;

import java.io.IOException;

import pomelo.area.AchievementHandler;


@GClientEvent("area.achievementHandler.activateHolyArmorRequest")
public class ActivateHolyArmorRequestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        AchievementHandler.ActivateHolyArmorRequest req = AchievementHandler.ActivateHolyArmorRequest.parseFrom(this.pak.getRemaingBytes());
        final int id = req.getId();

        return new PomeloResponse() {

            protected void write() throws IOException {
                AchievementHandler.ActivateHolyArmorResponse.Builder res = AchievementHandler.ActivateHolyArmorResponse.newBuilder();

                AchievementDataPO.HolyArmour armour = (AchievementDataPO.HolyArmour) player.achievementManager.achievementDataPO.holyArmourMap.get(Integer.valueOf(id));
                if (armour.states == 1) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ACHIEVEMENT_NOT_ACTIVATED"));
                    return;
                }
                if (armour.states == 3) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ACHIEVEMENT_ACTIVATED"));

                    return;
                }
                player.achievementManager.activateHolyArmour(id);


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


