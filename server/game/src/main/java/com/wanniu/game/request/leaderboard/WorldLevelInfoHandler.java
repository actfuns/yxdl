package com.wanniu.game.request.leaderboard;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.LeaderBoardHandler;


@GClientEvent("area.leaderBoardHandler.worldLevelInfoRequest")
public class WorldLevelInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        if (!player.functionOpenManager.isOpen(Const.FunctionType.WORLD_EXP.getValue())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
        }

        final LeaderBoardHandler.WorldLevelInfo data = player.leaderBoardManager.worldLevelInfo(player);

        return new PomeloResponse() {
            protected void write() throws IOException {
                LeaderBoardHandler.WorldLevelInfoResponse.Builder res = LeaderBoardHandler.WorldLevelInfoResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


