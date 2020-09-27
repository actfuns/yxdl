package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ActivityConfigExt;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.singleRechargeGetInfoRequest")
public class SingleRechargeGetInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityExt activityExt = player.activityManager.findActivityByType(Const.ActivityRewardType.SINGLE_RECHARGE.getValue());
        if (activityExt == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        ActivityFavorHandler.SingleRechargeInfo.Builder info = ActivityFavorHandler.SingleRechargeInfo.newBuilder();
        info.setBeginTime(activityExt.openTime);
        info.setEndTime(activityExt.closeTime);
        info.setDescribe(activityExt.activityRule);

        Map<Integer, Integer> stateInfo = RechargeActivityService.getInstance().getSingleRechargeInfo(player.getId());
        List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
        for (ActivityConfigExt template : activityConfigExts) {
            ActivityFavorHandler.SingleRechargeAwardInfo.Builder srab = ActivityFavorHandler.SingleRechargeAwardInfo.newBuilder();
            srab.setId(template.id);

            ArrayList<WNBag.SimpleItemInfo> rewardItem = player.activityManager.getRankReward(template.RankReward);
            for (WNBag.SimpleItemInfo sii : rewardItem) {
                ActivityFavorHandler.SingleRechargeItem.Builder item = ActivityFavorHandler.SingleRechargeItem.newBuilder();
                item.setCode(sii.itemCode);
                item.setGroupCount(sii.itemNum);
                srab.addItem(item);
            }
            srab.setState(((Integer) stateInfo.getOrDefault(Integer.valueOf(template.id), Integer.valueOf(0))).intValue());
            srab.setCurrNum(0);
            srab.setNeedNum(template.parameter1);
            info.addSingleRechargeAwardInfo(srab);
        }

        final ActivityFavorHandler.SingleRechargeGetInfoResponse.Builder res = ActivityFavorHandler.SingleRechargeGetInfoResponse.newBuilder();
        res.setS2CCode(200);
        res.setSingleRechargeInfo(info);
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


