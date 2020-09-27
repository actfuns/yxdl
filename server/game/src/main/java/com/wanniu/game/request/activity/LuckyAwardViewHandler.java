package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;

import pomelo.area.ActivityHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.activityHandler.luckyAwardViewRequest")
public class LuckyAwardViewHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) LuckyAwardViewHandler.this.pak.getPlayer();
                ActivityHandler.LuckyAwardViewResponse.Builder res = ActivityHandler.LuckyAwardViewResponse.newBuilder();
                ArrayList<ItemOuterClass.MiniItem> data = player.activityManager.luckyAwardView();
                res.setS2CCode(200);
                res.addAllS2CData(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


