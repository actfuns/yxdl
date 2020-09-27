package com.wanniu.game.request.playerSkillKey;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SkillKeysHandler;


@GClientEvent("area.skillKeysHandler.saveSkillKeysRequest")
public class SaveSkillKeysHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final SkillKeysHandler.SaveSkillKeysRequest req = SkillKeysHandler.SaveSkillKeysRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                SkillKeysHandler.SaveSkillKeysResponse.Builder res = SkillKeysHandler.SaveSkillKeysResponse.newBuilder();
                int result = player.skillManager.changeSkillsPos(req);

                if (result == 0) {
                    res.setS2CCode(200);
                    WNNotifyManager.getInstance().pushSkillKeysUpdate(player, player.skillKeyManager.toJson4Payload());
                } else if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_REPEAT");
                } else if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILLKEY_SET_ERROR_KEY_LOCK");
                } else if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_NOT_CAN_SET");
                } else if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILLKEY_SET_ERROR_NOT_FIND_SKILL");
                } else if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILLKEY_SET_ERROR_SKILL_NOT_LEARN");
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


