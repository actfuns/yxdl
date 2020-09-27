package com.wanniu.game.request.achievement;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.achievement.po.BaseInfo;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.AchievementConfigExt;
import com.wanniu.game.data.ext.AchievementExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.AchievementHandler;


@GClientEvent("area.achievementHandler.achievementGetAwardRequest")
public class AchievementGetAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        AchievementHandler.AchievementGetAwardRequest req = AchievementHandler.AchievementGetAwardRequest.parseFrom(this.pak.getRemaingBytes());
        final int achieveId = req.getC2SId();
        final int _type = req.getC2SType();

        return new PomeloResponse() {

            protected void write() throws IOException {
                AchievementHandler.AchievementGetAwardResponse.Builder res = AchievementHandler.AchievementGetAwardResponse.newBuilder();

                if (!player.functionOpenManager.isOpen(Const.FunctionType.ACHIEVEMENT.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                AchievementConfigExt configExt = null;
                if (_type == 0) {
                    configExt = (AchievementConfigExt) GameData.AchievementConfigs.get(Integer.valueOf(achieveId));
                } else if (_type == 1) {
                    AchievementExt achievementExt = (AchievementExt) GameData.Achievements.get(Integer.valueOf(achieveId));
                    configExt = (AchievementConfigExt) GameData.AchievementConfigs.get(Integer.valueOf(achievementExt.chapterID));
                }

                if (player.getLevel() < configExt.lv || (configExt.quest != 0 &&
                        !player.taskManager.finishedNormalTasks.containsKey(Integer.valueOf(configExt.quest)))) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ACHIEVE_CHAPTER_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                BaseInfo baseInfo = player.achievementManager.getAward(_type, achieveId);
                if (baseInfo.code == 200) {
                    res.setS2CCode(baseInfo.code);
                    player.achievementManager.updateSuperScript();
                } else {
                    res.setS2CCode(baseInfo.code);
                    res.setS2CMsg(baseInfo.msg);
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


