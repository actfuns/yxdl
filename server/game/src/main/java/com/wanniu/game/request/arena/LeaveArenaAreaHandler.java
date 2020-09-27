package com.wanniu.game.request.arena;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.area.ArenaHandler;


@GClientEvent("area.arenaHandler.leaveArenaAreaRequest")
public class LeaveArenaAreaHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                ArenaHandler.LeaveArenaAreaResponse.Builder res = ArenaHandler.LeaveArenaAreaResponse.newBuilder();
                player.arenaManager.handleLeaveArenaArea(res);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


