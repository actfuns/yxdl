package com.wanniu.game.request.playerSkills;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.playerSkill.SkillManager;

import java.io.IOException;

import pomelo.area.SkillHandler;


@GClientEvent("area.skillHandler.upgradeSkillOneKeyRequest")
public class UpgradeSkillOneKeyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SkillHandler.UpgradeSkillOneKeyResponse.Builder res = SkillHandler.UpgradeSkillOneKeyResponse.newBuilder();
                SkillManager skillManager = player.skillManager;


                int result = skillManager.upgradeSkillOneKey2();
                if (result == 0) {

                    res.setS2CCode(200);
                    res.addAllSkillList(player.skillManager.getSkillsBasicList());
                    this.body.writeBytes(res.build().toByteArray());
                } else if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_UPGRADE_NONE"));
                    this.body.writeBytes(res.build().toByteArray());
                } else if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


