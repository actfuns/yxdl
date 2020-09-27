package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.getRivalInfoRequest")
public class GetRivalInfoHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.GetRivalInfoResponse.Builder res = SoloHandler.GetRivalInfoResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CVsPlayerName("");
                res.setS2CVsPlayerPro(1);
                res.setS2CVsPlayerLevel(0);

                Area area = player.getArea();
                for (String id : area.actors.keySet()) {
                    if (id.equals(player.getId())) {
                        continue;
                    }
                    WNPlayer rival = PlayerUtil.getOnlinePlayer(id);
                    res.setS2CVsPlayerName(rival.getName());
                    res.setS2CVsPlayerPro(rival.getPro());
                    res.setS2CVsPlayerLevel(rival.getLevel());
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


