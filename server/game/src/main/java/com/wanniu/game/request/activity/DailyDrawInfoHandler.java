package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.AdventureItemAddCO;
import com.wanniu.game.data.AdventureItemCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ActivityConfigExt;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.dailyDrawInfoRequest")
public class DailyDrawInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.DailyDrawInfoRequest req = ActivityFavorHandler.DailyDrawInfoRequest.parseFrom(this.pak.getRemaingBytes());
        final int id = req.getId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityExt activityExt, activityExtAdd;
                WNPlayer player = (WNPlayer) DailyDrawInfoHandler.this.pak.getPlayer();

                ActivityManager activityManager = player.activityManager;


                ActivityFavorHandler.DailyDrawInfoResponse.Builder res = ActivityFavorHandler.DailyDrawInfoResponse.newBuilder();

                switch (id) {
                    case 0:
                        res.setFreeCountLeft((activityManager.toJson4Serialize()).daily_draw_free_time);

                        for (AdventureItemCO adventureItemCO : GameData.AdventureItems.values()) {
                            ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
                            awardInfoBuilder.setId(adventureItemCO.id);
                            awardInfoBuilder.setCode(adventureItemCO.item);
                            awardInfoBuilder.setNum(adventureItemCO.itemNum);
                            res.addAwards(awardInfoBuilder.build());
                        }

                        activityExt = activityManager.findActivityByType(Const.ActivityRewardType.LUCK_DRAW.getValue());
                        res.setBeginTime(activityExt.openTime);
                        res.setEndTime(activityExt.closeTime);
                        res.setDescribe(activityExt.activityRule);
                        res.setFreeCountUpdateTimeStamp(activityManager.DailyDrawGetFreeTimeUpdateTime().getTime());
                        break;
                    case 1:
                        res.setFreeCountLeft((activityManager.toJson4Serialize()).daily_draw_free_time_add);

                        for (AdventureItemAddCO adventureItemAddCO : GameData.AdventureItemAdds.values()) {
                            ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
                            awardInfoBuilder.setId(adventureItemAddCO.id);
                            awardInfoBuilder.setCode(adventureItemAddCO.item);
                            awardInfoBuilder.setNum(adventureItemAddCO.itemNum);
                            res.addAwards(awardInfoBuilder.build());
                        }

                        activityExtAdd = activityManager.findActivityByType(Const.ActivityRewardType.SPRING_DRAW.getValue());
                        res.setBeginTime(activityExtAdd.openTime);
                        res.setEndTime(activityExtAdd.closeTime);
                        res.setDescribe(activityExtAdd.activityRule);
                        res.setFreeCountUpdateTimeStamp(activityManager.DailyDrawGetFreeTimeUpdateTime().getTime());
                        break;


                    default:
                        return;
                }

                int count = player.bag.findItemNumByCode(Const.raffletickets);
                res.setExploredTicketCountLeft(count);


                List<ActivityConfigExt> activityConfigExt = activityManager.findActivitieConfigsByRewardType(Const.ActivityRewardType.LUCK_DRAW);
                int proportion = -1;
                for (ActivityConfigExt activityConfigExt_temp : activityConfigExt) {
                    if (activityConfigExt_temp.notes1.equals("Activity_Adventure_Proportion")) {
                        proportion = activityConfigExt_temp.parameter1;
                    }
                }
                if (proportion == -1) {
                    Out.debug(new Object[]{"数据表记录缺失"});
                    return;
                }
                res.setProportion(proportion);

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        }
                ;
    }
}


