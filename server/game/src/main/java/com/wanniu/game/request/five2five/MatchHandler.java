package com.wanniu.game.request.five2five;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.dailyActivity.DailyActivity;
import pomelo.five2five.Five2FiveHandler;


@GClientEvent("five2five.five2FiveHandler.five2FiveMatchRequest")
public class MatchHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            private static final int hdid = 8;


            protected void write() throws IOException {
                Five2FiveHandler.Five2FiveMatchRequest req = Five2FiveHandler.Five2FiveMatchRequest.parseFrom(MatchHandler.this.pak.getRemaingBytes());
                int matchOrReMatch = req.getMatchOrReMatch();

                Five2FiveHandler.Five2FiveMatchResponse.Builder res = Five2FiveHandler.Five2FiveMatchResponse.newBuilder();
                DailyActivityMgr mgr = player.dailyActivityMgr;
                List<DailyActivity.DailyInfo> dailyInfoList = mgr.getDailyLs();
                List<String> itemList = new ArrayList<>();
                int CurNum1 = 0;
                int maxNum1 = 0;
                for (DailyActivity.DailyInfo info : dailyInfoList) {
                    int id = info.getId();
                    int CurNum = info.getCurNum();
                    int maxNum = info.getMaxNum();
                    if (info.getId() == 8) {
                        CurNum1 = CurNum;
                        maxNum1 = maxNum;
                    }
                }


                if (maxNum1 <= CurNum1) {
                    res.setS2CCode(500);

                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                player.five2FiveManager.applyFive2FiveMatch(res, matchOrReMatch);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


