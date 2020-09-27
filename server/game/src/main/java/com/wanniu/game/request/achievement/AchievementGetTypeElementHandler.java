package com.wanniu.game.request.achievement;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.AchievementHandler;


@GClientEvent("area.achievementHandler.achievementGetTypeElementRequest")
public class AchievementGetTypeElementHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        AchievementHandler.AchievementGetTypeElementRequest req = AchievementHandler.AchievementGetTypeElementRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final int id = req.getC2SId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                AchievementHandler.AchievementGetTypeElementResponse.Builder res = AchievementHandler.AchievementGetTypeElementResponse.newBuilder();
                if (!player.functionOpenManager.isOpen(Const.FunctionType.ACHIEVEMENT.getValue())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                player.achievementManager.toJson4PayloadbyTypeId(id, res);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


