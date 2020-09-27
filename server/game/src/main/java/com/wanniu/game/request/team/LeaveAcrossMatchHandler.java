package com.wanniu.game.request.team;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamUtil;

import java.io.IOException;

import pomelo.area.TeamHandler;


@GClientEvent("area.teamHandler.leaveAcrossMatchRequest")
public class LeaveAcrossMatchHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        TeamUtil.removeAcrossMatch(player);

        return new PomeloResponse() {
            protected void write() throws IOException {
                TeamHandler.LeaveAcrossMatchResponse.Builder res = TeamHandler.LeaveAcrossMatchResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


