package com.wanniu.game.request.guild.guildTech;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.guildTech.GuildTechManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.GuildTechHandler;


@GClientEvent("area.guildTechHandler.upgradeGuildSkillRequest")
public class UpgradeGuildSkillHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildTechHandler.UpgradeGuildSkillRequest req = GuildTechHandler.UpgradeGuildSkillRequest.parseFrom(this.pak.getRemaingBytes());
        final int skillId = req.getSkillId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildTechHandler.UpgradeGuildSkillResponse.Builder res = GuildTechHandler.UpgradeGuildSkillResponse.newBuilder();

                GuildTechManager guildTechManager = player.guildManager.guildTechManager;
                GuildResult ret = guildTechManager.upgradeSkillLevel(skillId);
                int result = ret.result;
                if (result == 0) {
                    GuildTechHandler.GuildSkill skillData = guildTechManager.getOneSkillData(skillId);
                    player.taskManager.dealTaskEvent(Const.TaskType.GUILD_TECH_UP, 1);
                    res.setS2CCode(200);
                    res.setS2CSkillInfo(skillData);
                    res.setS2CContribution(player.guildManager.getContribution());
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_SKILL_NOT_EXIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TECH_SKILL_LEVEL_FULL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(ret.des);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTION_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -5) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


