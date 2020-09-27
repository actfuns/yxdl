package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.AdventureItemAddCO;
import com.wanniu.game.data.AdventureItemCO;
import com.wanniu.game.data.ext.ActivityConfigExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.ActivityDataPO;

import java.io.IOException;
import java.util.List;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.dailyDrawRequest")
public class DailyDrawHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        List<AdventureItemCO> adventureItemCOList;
        List<AdventureItemAddCO> adventureItemCOAddList;
        ActivityFavorHandler.DailyDrawRequest req = ActivityFavorHandler.DailyDrawRequest.parseFrom(this.pak.getRemaingBytes());
        int id = req.getId();
        int timeType = req.getTimeType();
        int costType = req.getCostType();

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityManager activityManager = player.activityManager;
        ActivityDataPO activityDataPO = activityManager.toJson4Serialize();


        List<ActivityConfigExt> activityConfigExt = activityManager.findActivitieConfigsByRewardType(Const.ActivityRewardType.LUCK_DRAW);
        int proportion = -1;
        for (ActivityConfigExt activityConfigExt_temp : activityConfigExt) {
            if (activityConfigExt_temp.notes1.equals("Activity_Adventure_Proportion")) {
                proportion = activityConfigExt_temp.parameter1;
            }
        }
        if (proportion == -1) {
            Out.error(new Object[]{"数据表记录缺失"});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        int raffleticketsItemCount = player.bag.findItemNumByCode(Const.raffletickets);
        int needConsumeCount = 0;
        int needConsumeMoney = 0;


        Const.GOODS_CHANGE_TYPE costDes = Const.GOODS_CHANGE_TYPE.ActivityDraw;
        if (id == 1) {
            costDes = Const.GOODS_CHANGE_TYPE.ActivityDrawSpring;
        }

        switch (costType) {
            case 0:
                switch (id) {
                    case 0:
                        if (activityDataPO.daily_draw_free_time < 1) {
                            return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_FREE_TIME"));
                        }
                        activityDataPO.daily_draw_free_time--;
                        break;
                    case 1:
                        if (activityDataPO.daily_draw_free_time_add < 1) {
                            return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_FREE_TIME"));
                        }
                        activityDataPO.daily_draw_free_time_add--;
                        break;
                }
                return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));


            case 1:
                if (timeType == 0) {
                    needConsumeCount = 1;

                } else if (timeType == 1) {
                    needConsumeCount = 10;
                } else {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
                }

                if (!player.bag.discardItem(Const.raffletickets, needConsumeCount, costDes)) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_EXPLORE_TICKETS"));
                }
                break;


            case 2:
                if (timeType == 0) {
                    if (raffleticketsItemCount >= 1) {
                        needConsumeCount = 1;
                    } else {
                        needConsumeMoney = proportion * 1;
                    }

                } else if (timeType == 1) {
                    if (raffleticketsItemCount >= 10) {
                        needConsumeCount = 10;
                    } else {
                        needConsumeCount = raffleticketsItemCount;
                        needConsumeMoney = proportion * (10 - raffleticketsItemCount);
                    }
                } else {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
                }


                if (needConsumeMoney > 0 &&
                        !player.moneyManager.costDiamond(needConsumeMoney, costDes)) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_DAILY_DRAW_NO_DIAMOND"));
                }


                if (needConsumeCount > 0) {
                    player.bag.discardItem(Const.raffletickets, needConsumeCount, costDes);
                }
                break;
            default:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        final ActivityFavorHandler.DailyDrawResponse.Builder res = ActivityFavorHandler.DailyDrawResponse.newBuilder();
        res.setExploredTicketCountLeft(raffleticketsItemCount - needConsumeCount);

        switch (id) {
            case 0:
                adventureItemCOList = null;
                if (timeType == 0) {
                    adventureItemCOList = activityManager.DailyDraw_Draw(1);
                } else {
                    adventureItemCOList = activityManager.DailyDraw_Draw(10);
                }
                for (AdventureItemCO adventureItemCO : adventureItemCOList) {
                    ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
                    awardInfoBuilder.setId(adventureItemCO.id);
                    awardInfoBuilder.setCode(adventureItemCO.item);
                    awardInfoBuilder.setNum(adventureItemCO.itemNum);
                    res.addAwards(awardInfoBuilder.build());
                }

                res.setFreeCountLeft(activityDataPO.daily_draw_free_time);

                Out.info(new Object[]{player.getId(), ":每日抽奖成功,抽奖类型:", (timeType == 0) ? "单抽" : "十连抽", "常规抽奖"});
                break;
            case 1:
                adventureItemCOAddList = null;
                if (timeType == 0) {
                    adventureItemCOAddList = activityManager.DailyDraw_Draw_Add(1);
                } else {
                    adventureItemCOAddList = activityManager.DailyDraw_Draw_Add(10);
                }
                for (AdventureItemAddCO adventureItemAddCO : adventureItemCOAddList) {
                    ActivityFavorHandler.DailyDrawAwardInfo.Builder awardInfoBuilder = ActivityFavorHandler.DailyDrawAwardInfo.newBuilder();
                    awardInfoBuilder.setId(adventureItemAddCO.id);
                    awardInfoBuilder.setCode(adventureItemAddCO.item);
                    awardInfoBuilder.setNum(adventureItemAddCO.itemNum);
                    res.addAwards(awardInfoBuilder.build());
                }

                res.setFreeCountLeft(activityDataPO.daily_draw_free_time_add);

                Out.info(new Object[]{player.getId(), ":每日抽奖成功,抽奖类型:", (timeType == 0) ? "单抽" : "十连抽", "新春抽奖"});
                break;
            default:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        int count = (timeType == 0) ? 1 : 10;
        LogReportService.getInstance().ansycReportLuckDraw(player, id, count, needConsumeMoney, needConsumeCount);

        return new PomeloResponse() {
            protected void write() throws IOException {
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


