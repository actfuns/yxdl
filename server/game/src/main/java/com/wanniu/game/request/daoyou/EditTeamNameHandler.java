package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.util.BlackWordUtil;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouEditTeamNameRequest")
public class EditTeamNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouEditTeamNameRequest req = DaoYouHandler.DaoYouEditTeamNameRequest.parseFrom(this.pak.getRemaingBytes());

        final String teamName = req.getTeamName();

        if (StringUtil.isEmpty(teamName)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DAO_YOU_NAME_NOT_EMPTY"));
        }

        if (BlackWordUtil.isIncludeBlackString(teamName)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouResponse.Builder res = DaoYouHandler.DaoYouResponse.newBuilder();

                String playerId = player.getId();
                String playerName = player.getName();
                String msg = DaoYouService.getInstance().editDaoYouName(playerId, playerName, teamName);
                if (!msg.equals("")) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


