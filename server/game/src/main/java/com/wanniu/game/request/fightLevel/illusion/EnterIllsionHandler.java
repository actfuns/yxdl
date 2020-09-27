package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SectionCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.enterLllsionRequest")
public class EnterIllsionHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.EnterLllsionRequest req = FightLevelHandler.EnterLllsionRequest.parseFrom(this.pak.getRemaingBytes());

        int lllusionId = req.getC2SId();
        Out.debug(new Object[]{getClass().getName(), " : ", Integer.valueOf(lllusionId)});

        final SectionCO secionCO = (SectionCO) GameData.Sections.get(Integer.valueOf(lllusionId));

        if (secionCO == null || player.getLevel() < secionCO.minLv) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.EnterLllsionResponse.Builder res = FightLevelHandler.EnterLllsionResponse.newBuilder();

                AreaUtil.enterArea(player, secionCO.dungeonID);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


