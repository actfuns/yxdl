package com.wanniu.game.request.playerSkills;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.SkillDataExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.playerSkill.SkillManager;
import com.wanniu.game.playerSkill.SkillUtil;
import com.wanniu.game.playerSkill.po.SkillDB;

import java.io.IOException;

import pomelo.area.SkillHandler;


@GClientEvent("area.skillHandler.upgradeSkillRequest")
public class UpgradeSkillHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        SkillHandler.UpgradeSkillRequest req = SkillHandler.UpgradeSkillRequest.parseFrom(this.pak.getRemaingBytes());
        final int skillId = req.getS2CSkillId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                SkillHandler.UpgradeSkillResponse.Builder res = SkillHandler.UpgradeSkillResponse.newBuilder();
                SkillManager skillManager = player.skillManager;
                SkillDB skill = skillManager.getSkill(skillId);
                if (skill == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                if (skill.flag == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_LOCK"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                SkillManager.CheckSkillData data = skillManager.checkSkillReq(skill);
                int result = data.result;
                if (result == 0) {
                    if (skillManager.upgradeOneSkill(skill.id)) {
                        SkillDataExt prop = SkillUtil.getProp(skillId);
                        if (prop.skillType == Const.SkillType.EFFECT_PASSIVE.getValue()) {
                            player.initAndCalAllInflu(null);
                            player.pushAndRefreshEffect(false);
                        }
                        res.setS2CCode(200);
                    } else {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    }
                    player.getPlayerTasks().dealTaskEvent(Const.TaskType.SKILL_UP, 1);
                } else if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_MAX_LEVEL"));
                } else if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_LEVEL_NOT_ENOUGH"));
                } else if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                } else if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_PRESKILL_NOT_READY"));
                } else if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SKILL_PRESKILL_NOT_READY"));
                } else if (result == -6) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
                } else if (result == -99) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


