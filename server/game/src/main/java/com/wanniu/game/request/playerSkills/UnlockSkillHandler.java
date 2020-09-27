package com.wanniu.game.request.playerSkills;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.SkillHandler;


@GClientEvent("area.skillHandler.unlockSkillRequest")
public class UnlockSkillHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                SkillHandler.UnlockSkillResponse.Builder res = SkillHandler.UnlockSkillResponse.newBuilder();

                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


