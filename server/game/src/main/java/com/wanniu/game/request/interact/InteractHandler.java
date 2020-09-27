package com.wanniu.game.request.interact;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.InteractionCO;
import com.wanniu.game.interact.PlayerInteract;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;


@GClientEvent("area.interactHandler.interactRequest")
public class InteractHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        pomelo.area.InteractHandler.InteractRequest msg = pomelo.area.InteractHandler.InteractRequest.parseFrom(this.pak.getRemaingBytes());
        final int id = msg.getC2SId();
        final InteractionCO prop = PlayerInteract.getPropById(id);
        if (prop == null) {
            return (PomeloResponse) new ErrorResponse("interact error!!!");
        }

        if (!player.getInteractManager().enoughTimes(id)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TIMES_NOT_ENOUGH"));
        }

        final String playerId = msg.getC2SPlayerId();
        final String playerName = msg.getC2SPlayerName();
        Out.debug(new Object[]{"interactRequest id:", Integer.valueOf(id), "  playerId:", playerId, "  playerName:", playerName});
        return new PomeloResponse() {
            protected void write() throws IOException {
                pomelo.area.InteractHandler.InteractResponse.Builder res = pomelo.area.InteractHandler.InteractResponse.newBuilder();

                int gold = prop.gold;
                int diamond = prop.diamond;
                if (gold > 0) {
                    if (player.moneyManager.getGold() > gold) {
                        player.moneyManager.costGold(gold, Const.GOODS_CHANGE_TYPE.interact);
                        player.getInteractManager().send(id, playerId, playerName);
                        res.setS2CCode(200);
                    } else {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    }

                } else if (player.moneyManager.enoughDiamond(diamond)) {
                    player.moneyManager.costDiamond(diamond, Const.GOODS_CHANGE_TYPE.interact);

                    player.getInteractManager().send(id, playerId, playerName);
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


