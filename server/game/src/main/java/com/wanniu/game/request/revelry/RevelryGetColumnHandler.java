package com.wanniu.game.request.revelry;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.KingCO;
import com.wanniu.game.revelry.RevelryClass;
import com.wanniu.game.revelry.RevelryColumn;
import com.wanniu.game.revelry.RevelryManager;
import com.wanniu.game.revelry.RevelryToday;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryGetColumnRequest")
public class RevelryGetColumnHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final ActivityRevelryHandler.RevelryGetColumnResponse.Builder result = ActivityRevelryHandler.RevelryGetColumnResponse.newBuilder();

        List<RevelryClass> revelryClassList = RevelryManager.getInstance().getRevelryClassList();
        if (revelryClassList.isEmpty()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        for (RevelryClass revelryClass : revelryClassList) {
            ActivityRevelryHandler.RevelryTabInfo.Builder tabInfo = ActivityRevelryHandler.RevelryTabInfo.newBuilder().setName(revelryClass.getName());

            int defaultSeleteIndex = 0;
            long timeleft = 2147483647L;

            for (Map.Entry<String, RevelryToday> e : (Iterable<Map.Entry<String, RevelryToday>>) revelryClass.getTodays().entrySet()) {
                ActivityRevelryHandler.RevelryTodayInfo.Builder todayInfo = ActivityRevelryHandler.RevelryTodayInfo.newBuilder().setName(((RevelryToday) e.getValue()).getName());


                for (RevelryColumn column : ((RevelryToday) e.getValue()).getColumns()) {
                    ActivityRevelryHandler.RevelryColumnInfo.Builder columnInfo = ActivityRevelryHandler.RevelryColumnInfo.newBuilder();
                    columnInfo.setId(column.getId());
                    columnInfo.setName(column.getName());
                    columnInfo.setLabel(column.getLabel());
                    columnInfo.setGoto1(column.getGoto1());
                    columnInfo.setGoto2(column.getGoto2());
                    columnInfo.setTip(column.getTip());
                    todayInfo.addColumn(columnInfo);
                }

                tabInfo.addToday(todayInfo);
                if (((RevelryToday) e.getValue()).getTimeleft() < timeleft) {
                    timeleft = ((RevelryToday) e.getValue()).getTimeleft();
                    defaultSeleteIndex = tabInfo.getTodayCount();
                }
            }

            result.setSelectedIndex(defaultSeleteIndex);
            result.addInfo(tabInfo);
        }


        for (Map.Entry<Integer, KingCO> e : (Iterable<Map.Entry<Integer, KingCO>>) GameData.Kings.entrySet()) {
            if (((KingCO) e.getValue()).isOpen == 0) {
                continue;
            }
            KingCO template = e.getValue();
            ActivityRevelryHandler.KingExchange.Builder exchange = ActivityRevelryHandler.KingExchange.newBuilder();
            exchange.setTabId(template.tabID);
            exchange.setTabName(template.tabName);

            exchange.setItem1Code(template.item1code);
            exchange.setItem1Num(template.num1);

            exchange.setItem2Code(template.item2code);
            exchange.setItem2Num(template.num2);

            exchange.setAvatarId(template.avatarId);
            exchange.setTip(template.activityDesc);
            exchange.setShowType(template.showType);

            result.addExchange(exchange);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                result.setS2CCode(200);
                this.body.writeBytes(result.build().toByteArray());
            }
        };
    }
}


