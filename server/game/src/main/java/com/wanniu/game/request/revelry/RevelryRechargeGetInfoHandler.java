package com.wanniu.game.request.revelry;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.StartSerRechargeCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.RevelryRechargePO;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryRechargeGetInfoRequest")
public class RevelryRechargeGetInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityRevelryHandler.RevelryRechargeGetInfoRequest req = ActivityRevelryHandler.RevelryRechargeGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
        int day = req.getDay();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final ActivityRevelryHandler.RevelryRechargeGetInfoResponse.Builder result = ActivityRevelryHandler.RevelryRechargeGetInfoResponse.newBuilder();

        RevelryRechargePO po = RechargeActivityService.getInstance().getRevelryRechargeInfo(player.getId(), day);
        for (StartSerRechargeCO template : GameData.findStartSerRecharges(v -> (v.date == day))) {
            ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder awardInfo = ActivityRevelryHandler.RevelryRechargeAwardInfo.newBuilder();
            awardInfo.setId(template.iD);
            awardInfo.setCurrNum((po == null) ? 0 : po.getRmb());
            awardInfo.setNeedNum(template.rechargeNumber);
            awardInfo.setState((po == null) ? 0 : ((Integer) po.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue());
            if (StringUtils.isNotEmpty(template.reward1)) {
                ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
                item.setCode(template.reward1);
                item.setGroupCount(template.num1);
                awardInfo.addItem(item);
            }
            if (StringUtils.isNotEmpty(template.reward2)) {
                ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
                item.setCode(template.reward2);
                item.setGroupCount(template.num2);
                awardInfo.addItem(item);
            }
            if (StringUtils.isNotEmpty(template.reward3)) {
                ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
                item.setCode(template.reward3);
                item.setGroupCount(template.num3);
                awardInfo.addItem(item);
            }
            if (StringUtils.isNotEmpty(template.reward4)) {
                ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
                item.setCode(template.reward4);
                item.setGroupCount(template.num4);
                awardInfo.addItem(item);
            }
            if (StringUtils.isNotEmpty(template.reward5)) {
                ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
                item.setCode(template.reward5);
                item.setGroupCount(template.num5);
                awardInfo.addItem(item);
            }
            result.addInfo(awardInfo);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


