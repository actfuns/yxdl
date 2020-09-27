package com.wanniu.game.request.playerSkills;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SkillHandler;


@GClientEvent("area.skillHandler.getSkillDetailRequest")
public class GetSkillDetailHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SkillHandler.GetSkillDetailRequest req = SkillHandler.GetSkillDetailRequest.parseFrom(this.pak.getRemaingBytes());
        final int skillId = req.getS2CSkillId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SkillHandler.GetSkillDetailResponse.Builder res = SkillHandler.GetSkillDetailResponse.newBuilder();
                SkillHandler.SkillDetail skillDetail = player.skillManager.getSkillDetail4PayLoad(skillId);
                if (skillDetail != null) {
                    res.setS2CCode(200);
                    res.setS2CSkill(skillDetail);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg("SKILL_NULL");
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


