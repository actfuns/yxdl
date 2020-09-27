package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.DateUtils;
import com.wanniu.game.GWorld;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.data.AddRechargeLimitCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.continuousRechargeGetInfoRequest")
public class ContinuousRechargeGetInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final ActivityFavorHandler.ContinuousRechargeGetInfoResponse.Builder res = ActivityFavorHandler.ContinuousRechargeGetInfoResponse.newBuilder();

        ActivityFavorHandler.ContinuousRechargeInfo.Builder info = ActivityFavorHandler.ContinuousRechargeInfo.newBuilder();

        LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
        info.setBeginTime(openServerDate.atTime(0, 0, 0).format(DateUtils.F_YYYYMMDDHHMMSS));
        info.setEndTime(openServerDate.plusDays(6L).atTime(23, 59, 59).format(DateUtils.F_YYYYMMDDHHMMSS));

        Map<Integer, Integer> stateInfo = RechargeActivityService.getInstance().getContinuousRechargeInfo(player.getId());

        info.setDay(RechargeActivityService.getInstance().getContinuousRechargeDay(player.getId()));

        for (AddRechargeLimitCO temlate : GameData.AddRechargeLimits.values()) {
            ActivityFavorHandler.ContinuousRechargeAwardInfo.Builder builder = ActivityFavorHandler.ContinuousRechargeAwardInfo.newBuilder();
            builder.setDay(temlate.addTime);
            builder.setMoney(temlate.rechargeLimit);

            String[] arrayOfString = temlate.rechargeFReward.split(",");
            for (String strs1_item : arrayOfString) {
                ActivityFavorHandler.ContinuousRechargeItem.Builder item = ActivityFavorHandler.ContinuousRechargeItem.newBuilder();
                String[] strs2 = strs1_item.split(":");
                item.setCode(strs2[0]);
                item.setGroupCount(Integer.parseInt(strs2[1]));
                builder.addItem(item);
            }

            builder.setState(((Integer) stateInfo.getOrDefault(Integer.valueOf(temlate.addTime), Integer.valueOf(0))).intValue());
            info.addContinuousRechargeAwardInfo(builder);


            if (builder.getDay() == info.getDay()) {
                info.setNeedNum(builder.getMoney());
                info.setCurrNum(player.prepaidManager.getTodayPayValue() / 100);
            }
        }


        ActivityFavorHandler.ContinuousRechargeAwardInfo.Builder awardInfo = ActivityFavorHandler.ContinuousRechargeAwardInfo.newBuilder();
        awardInfo.setDay(0);
        awardInfo.setMoney(0);

        String[] strs1 = GlobalConfig.AddRecharge_Reward.split(",");
        for (String strs1_item : strs1) {
            ActivityFavorHandler.ContinuousRechargeItem.Builder item = ActivityFavorHandler.ContinuousRechargeItem.newBuilder();
            String[] strs2 = strs1_item.split(":");
            item.setCode(strs2[0]);
            item.setGroupCount(Integer.parseInt(strs2[1]));
            awardInfo.addItem(item);
        }

        awardInfo.setState(((Integer) stateInfo.getOrDefault(Integer.valueOf(0), Integer.valueOf(0))).intValue());
        info.addContinuousRechargeAwardInfo(awardInfo);


        res.setS2CCode(200);
        res.setContinuousRechargeInfo(info);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


