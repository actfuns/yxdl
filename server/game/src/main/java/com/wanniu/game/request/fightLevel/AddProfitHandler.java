package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.addProfitRequest")
public class AddProfitHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        FightLevelHandler.AddProfitRequest request = FightLevelHandler.AddProfitRequest.parseFrom(this.pak.getRemaingBytes());
        int mapId = request.getMapId();


        if (!player.bag.discardItem(Const.ITEM_CODE.DUNGEONPROFIT.value, 1, Const.GOODS_CHANGE_TYPE.use)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
        }


        player.fightLevelManager.addPrifit(mapId);

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.AddProfitResponse.Builder res = FightLevelHandler.AddProfitResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


