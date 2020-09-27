package com.wanniu.game.request.achievement;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AchievementDataPO;

import java.io.IOException;

import pomelo.area.AchievementHandler;


@GClientEvent("area.achievementHandler.getHolyArmorsRequest")
public class GetHolyArmorsRequestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();


        return new PomeloResponse() {

            protected void write() throws IOException {
                AchievementHandler.GetHolyArmorsResponse.Builder res = AchievementHandler.GetHolyArmorsResponse.newBuilder();


                for (AchievementDataPO.HolyArmour armour : player.achievementManager.achievementDataPO.holyArmourMap.values()) {
                    AchievementHandler.HolyArmor.Builder haBuilder = AchievementHandler.HolyArmor.newBuilder();
                    haBuilder.setId(armour.id);
                    haBuilder.setStates(armour.states);
                    res.addHolyArmors(haBuilder.build());
                }


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


