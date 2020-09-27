package com.wanniu.game.request.revelry;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.DateUtils;
import com.wanniu.game.GWorld;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryRechargeGetColumnRequest")
public class RevelryRechargeGetColumnHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final ActivityRevelryHandler.RevelryRechargeGetColumnResponse.Builder result = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.newBuilder();

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityExt activityExt = player.activityManager.findActivityByType(Const.ActivityRewardType.REVELRY_RECHARGE.getValue());
        if (activityExt == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }
        result.setDescribe(activityExt.activityRule);

        LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
        result.setBeginTime(openServerDate.atTime(0, 0, 0).format(DateUtils.F_YYYYMMDDHHMMSS));
        result.setEndTime(openServerDate.plusDays(6L).atTime(23, 59, 59).format(DateUtils.F_YYYYMMDDHHMMSS));

        int day = RechargeActivityService.getInstance().getOpenServerDay();
        if (day > 0) {
            result.setToday(day);
        }

        Map<Integer, String> columns = RechargeActivityService.getInstance().getAllColumn();
        for (Map.Entry<Integer, String> e : columns.entrySet()) {
            ActivityRevelryHandler.RevelryRechargeColumn.Builder column = ActivityRevelryHandler.RevelryRechargeColumn.newBuilder();
            column.setDay(((Integer) e.getKey()).intValue());
            column.setName(e.getValue());
            result.addColumn(column);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


