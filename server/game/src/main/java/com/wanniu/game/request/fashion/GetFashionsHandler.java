package com.wanniu.game.request.fashion;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.FashionExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FashionHandler;
import pomelo.area.PlayerHandler;


@GClientEvent("area.fashionHandler.getFashionsRequest")
public class GetFashionsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FashionHandler.GetFashionsResponse.Builder res = FashionHandler.GetFashionsResponse.newBuilder();

                for (String temp_code : player.playerBasePO.fashions_get) {
                    FashionExt fashionExt = (FashionExt) GameData.Fashions.get(temp_code);
                    switch (Const.FASHION_TYPE.valueOf(fashionExt.type)) {
                        case WEPON:
                            res.addCode1(temp_code);

                        case CLOTH:
                            res.addCode2(temp_code);

                        case WING:
                            res.addCode3(temp_code);
                    }


                }
                String equipedCode1 = (String) player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.WEPON.value));
                if (equipedCode1 != null) {

                    res.addCode1(equipedCode1);
                    res.setEquipedCode1(equipedCode1);
                }
                String equipedCode2 = (String) player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.CLOTH.value));
                if (equipedCode2 != null) {

                    res.addCode2(equipedCode2);
                    res.setEquipedCode2(equipedCode2);
                }
                String equipedCode3 = (String) player.playerBasePO.fashions_equiped.get(Integer.valueOf(Const.FASHION_TYPE.WING.value));
                if (equipedCode3 != null) {

                    res.addCode3(equipedCode3);
                    res.setEquipedCode3(equipedCode3);
                }

                player.playerBasePO.fashion_get_spot = 0;
                List<PlayerHandler.SuperScriptType> ls = player.fashionManager.getSuperScriptList();
                player.updateSuperScriptList(ls);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


