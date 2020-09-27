package com.wanniu.game.request.blood;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.OpenLvCO;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.BloodPO;
import com.wanniu.redis.PlayerPOManager;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import pomelo.area.BloodHandler;


@GClientEvent("area.bloodHandler.getEquipedBloodsRequest")
public class GetEquipedBloodsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        BloodHandler.GetEquipedBloodsRequest req = BloodHandler.GetEquipedBloodsRequest.parseFrom(this.pak.getRemaingBytes());
        String playerId = req.getPlayerId();

        if (!player.functionOpenManager.isOpen(Const.FunctionType.BloodLineage.getValue())) {

            OpenLvCO prop = FunctionOpenUtil.getPropByName(Const.FunctionType.BloodLineage.getValue());
            return (PomeloResponse) new ErrorResponse(LangService.format("BLOOD_NOT_OPEN", new Object[]{Integer.valueOf(prop.openLv)}));
        }

        BloodPO bloodPO = (BloodPO) PlayerPOManager.findPO(ConstsTR.player_blood, playerId, BloodPO.class);
        if (bloodPO == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NULL"));
        }

        final Map<Integer, Integer> equipedBloods = bloodPO.equipedMap;

        return new PomeloResponse() {
            protected void write() throws IOException {
                BloodHandler.GetEquipedBloodsResponse.Builder res = BloodHandler.GetEquipedBloodsResponse.newBuilder();


                for (Iterator<Integer> iterator = equipedBloods.values().iterator(); iterator.hasNext(); ) {
                    int bloodId = ((Integer) iterator.next()).intValue();


                    res.addBloodIds(bloodId);
                }

                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


