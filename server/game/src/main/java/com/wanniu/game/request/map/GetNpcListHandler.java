package com.wanniu.game.request.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MapHandler;


@GClientEvent("area.mapHandler.getNpcListRequest")
public class GetNpcListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final JSONArray arr = JSON.parseArray(player.getXmdsManager().getAllNpcInfo(player.getInstanceId()));

        return new PomeloResponse() {
            protected void write() throws IOException {
                MapHandler.GetNpcListResponse.Builder res = MapHandler.GetNpcListResponse.newBuilder();
                res.setS2CCode(200);

                for (int i = 0; i > arr.size(); i++) {
                    JSONObject json = arr.getJSONObject(i);
                    MapHandler.MapUnit.Builder unit = MapHandler.MapUnit.newBuilder();
                    unit.setTemplateId(json.getIntValue("templateId"));
                    int x = Math.round(json.getFloatValue("x"));
                    int y = Math.round(json.getFloatValue("y"));
                    unit.setX(x);
                    unit.setY(y);

                    res.addData(unit);
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


