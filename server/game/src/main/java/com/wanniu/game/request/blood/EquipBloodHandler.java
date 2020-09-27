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


@GClientEvent("area.bloodHandler.equipBloodRequest")
public class EquipBloodHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        BloodHandler.EquipBloodRequest req = BloodHandler.EquipBloodRequest.parseFrom(this.pak.getRemaingBytes());
        String itemId = req.getItemId();

        if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {

            OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
            return (PomeloResponse) new ErrorResponse(LangService.format("BLOOD_NOT_OPEN", new Object[]{Integer.valueOf(prop.openLv)}));
        }

        int result = player.bloodManager.equipBlood(itemId);
        switch (result) {


            case 0:
                return new PomeloResponse() {
                    protected void write() throws IOException {
                        BloodHandler.EquipBloodResponse.Builder res = BloodHandler.EquipBloodResponse.newBuilder();
                        res.setS2CCode(200);


                        this.body.writeBytes(res.build().toByteArray());
                    }
                };
            case 1:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("BLOOD_NOT_HAVE"));
            case 2:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("BLOOD_NOT_BLOOD"));
            case 3:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("BLOOD_PARAM_ERROR"));
        }
        return (PomeloResponse) new ErrorResponse(LangService.getValue("BLOOD_PARAM_ERROR"));
    }
}


