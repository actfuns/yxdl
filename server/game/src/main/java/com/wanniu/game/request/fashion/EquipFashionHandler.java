package com.wanniu.game.request.fashion;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.Common;
import pomelo.area.FashionHandler;


@GClientEvent("area.fashionHandler.equipFashionRequest")
public class EquipFashionHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        FashionHandler.EquipFashionRequest req = FashionHandler.EquipFashionRequest.parseFrom(this.pak.getRemaingBytes());
        final String code = req.getCode();
        final boolean ison = req.getIson();


        return new PomeloResponse() {
            protected void write() throws IOException {
                FashionHandler.EquipFashionResponse.Builder res = FashionHandler.EquipFashionResponse.newBuilder();

                boolean result = player.fashionManager.equipFashion(code, ison);

                if (!result) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FASHION_DONT_HAVE"));
                }
                res.setS2CCode(200);

                List<Common.Avatar> list = PlayerUtil.getBattlerServerAvatar(player, true);
                for (Common.Avatar avatar : list) {
                    if (avatar.getTag() == Const.AVATAR_TYPE.R_HAND_WEAPON.value) {
                        res.setEquipedCode1(avatar);
                    }
                    if (avatar.getTag() == Const.AVATAR_TYPE.AVATAR_BODY.value) {
                        res.setEquipedCode2(avatar);
                    }
                    if (avatar.getTag() == Const.AVATAR_TYPE.REAR_EQUIPMENT.value) {
                        res.setEquipedCode3(avatar);
                    }
                }


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


