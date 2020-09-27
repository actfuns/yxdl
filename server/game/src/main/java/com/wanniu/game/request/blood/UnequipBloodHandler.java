package com.wanniu.game.request.blood;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.OpenLvCO;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.BloodHandler;


@GClientEvent("area.bloodHandler.unequipBloodRequest")
public class UnequipBloodHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {

            OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
            return (PomeloResponse) new ErrorResponse(LangService.format("BLOOD_NOT_OPEN", new Object[]{Integer.valueOf(prop.openLv)}));
        }

        BloodHandler.UnequipBloodRequest req = BloodHandler.UnequipBloodRequest.parseFrom(this.pak.getRemaingBytes());
        int sortId = req.getSortId();

        boolean result = player.bloodManager.unequipBlood(sortId);
        if (!result) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("BLOOD_UNEQUIP_FAIL"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                BloodHandler.UnequipBloodResponse.Builder res = BloodHandler.UnequipBloodResponse.newBuilder();
                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


