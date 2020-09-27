package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MonsterRefreshCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;
import java.util.Date;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.getLllsionBossInfoRequest")
public class GetIllsionBossInfoHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.GetLllsionBossInfoResponse.Builder res = FightLevelHandler.GetLllsionBossInfoResponse.newBuilder();

                for (MonsterRefreshCO refreshCO : GameData.MonsterRefreshs.values()) {
                    Date bornBeginTime = AreaUtil.formatToday(refreshCO.rebornBeginTime);
                    Date bornEndTime = AreaUtil.formatToday(refreshCO.rebornEndTime);
                    FightLevelHandler.IllsionBossInfo.Builder info = FightLevelHandler.IllsionBossInfo.newBuilder();
                    info.setId(refreshCO.iD);

                    Long nextRefreshTime = Long.valueOf(0L);

                    if (System.currentTimeMillis() < bornBeginTime.getTime()) {
                        nextRefreshTime = Long.valueOf(bornBeginTime.getTime());
                    } else if (System.currentTimeMillis() < bornEndTime.getTime()) {
                        nextRefreshTime = Long.valueOf((refreshCO.coolDownTime * Const.Time.Minute.getValue()) - (
                                System.currentTimeMillis() - bornBeginTime.getTime()) % (refreshCO.coolDownTime * Const.Time.Minute.getValue()) +
                                System.currentTimeMillis());
                    } else {
                        nextRefreshTime = Long.valueOf(DateUtil.getDateAfter(bornBeginTime, 1).getTimeInMillis());
                    }


                    Date date = new Date();
                    date.setTime(nextRefreshTime.longValue());
                    info.setNextRefreshTime(nextRefreshTime.longValue() - System.currentTimeMillis());
                    res.addBossInfos(info);
                }

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


