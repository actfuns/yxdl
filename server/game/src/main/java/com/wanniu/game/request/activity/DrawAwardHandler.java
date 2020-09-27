package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.ActivityHandler;


@GClientEvent("area.activityHandler.drawAwardRequest")
public class DrawAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityHandler.DrawAwardRequest req = ActivityHandler.DrawAwardRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
            }
        };
    }
}


