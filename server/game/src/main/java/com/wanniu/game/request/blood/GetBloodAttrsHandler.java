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
import java.util.Map;

import pomelo.area.BloodHandler;


@GClientEvent("area.bloodHandler.getBloodAttrsRequest")
public class GetBloodAttrsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();


        if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {

            OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
            return (PomeloResponse) new ErrorResponse(LangService.format(LangService.getValue("BLOOD_NOT_OPEN"), new Object[]{Integer.valueOf(prop.openLv)}));
        }

        final Map<Const.PlayerBtlData, Integer> attrs = player.bloodManager.calAllInfluence();

        return new PomeloResponse() {
            protected void write() throws IOException {
                BloodHandler.GetBloodAttrsResponse.Builder res = BloodHandler.GetBloodAttrsResponse.newBuilder();


                for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>) attrs.entrySet()) {
                    BloodHandler.BloodAttr.Builder ab = BloodHandler.BloodAttr.newBuilder();
                    ab.setId(((Const.PlayerBtlData) entry.getKey()).id);
                    ab.setValue(((Integer) entry.getValue()).intValue());
                    res.addBloodAttrs(ab.build());
                }
                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


