package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TypeNameCO;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.enterLllsionBossRequest")
public class EnterIllsionBossHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        FightLevelHandler.EnterLllsionBossRequest req = FightLevelHandler.EnterLllsionBossRequest.parseFrom(this.pak.getRemaingBytes());

        int monsterRereshId = req.getC2SId();
        Out.info(new Object[]{getClass().getName(), " : ", Integer.valueOf(monsterRereshId)});

        MonsterRefreshExt refreshCO = (MonsterRefreshExt) GameData.MonsterRefreshs.get(Integer.valueOf(monsterRereshId));
        TypeNameCO refreshTypeName = (TypeNameCO) GameData.TypeNames.get(Integer.valueOf(refreshCO.type));

        if (refreshCO == null || player.getLevel() < refreshTypeName.minLv || player.getLevel() > refreshTypeName.maxLv) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LEVEL_NOT_LIMIT_ENTER"));
        }

        if (refreshCO.pointX > 0.0F && refreshCO.pointY > 0.0F) {
            int dstId = refreshCO.mapID;
            float dstX = refreshCO.pointX, dstY = refreshCO.pointY;
            GWorld.getInstance().ansycExec(() -> {
                String instanceId = player.getInstanceId();
                int oldAreaId = player.getAreaId();
                AreaUtil.enterArea(player, dstId, dstX, dstY);
                if (AreaUtil.needCreateArea(oldAreaId)) {
                    AreaUtil.closeAreaNoPlayer(instanceId);
                }
            });
        } else {
            AreaUtil.enterArea(player, refreshCO.mapID);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.EnterLllsionBossResponse.Builder res = FightLevelHandler.EnterLllsionBossResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


