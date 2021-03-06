package com.wanniu.game.request.fightLevel.resourcedungeon;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.ResourceDungeon;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.ResourceDungeonHandler;


@GClientEvent("area.resourceDungeonHandler.resourceCountDownRequest")
public class ResourceCountDownHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                ResourceDungeonHandler.ResourceCountDownResponse.Builder res = ResourceDungeonHandler.ResourceCountDownResponse.newBuilder();

                Area area = player.getArea();
                if (area.getSceneType() != Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                res.setCountDown(300000L + (Const.Time.Second.getValue() * 15) + ((ResourceDungeon) area).createTime - System.currentTimeMillis());

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


