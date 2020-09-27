package com.wanniu.game.request.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.ResourceHandler;


@GClientEvent("area.resourceHandler.queryAreaDataRequest")
public class QueryAreaDataHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final Area area = player.getArea();
        if (area.npcDatas == null && area.isNormal()) {
            String units_str = player.getXmdsManager().getAllUnitInfo(player.getInstanceId());
            JSONArray npcs_json = JSON.parseArray(units_str);
            ResourceHandler.QueryAreaDataResponse.Builder res = ResourceHandler.QueryAreaDataResponse.newBuilder();
            res.setS2CCode(200);
            for (int i = 0; i < npcs_json.size(); i++) {
                JSONObject unit = npcs_json.getJSONObject(i);
                if ("XmdsInstanceNPC".equals(unit.get("type"))) {
                    ResourceHandler.Npc.Builder npc = ResourceHandler.Npc.newBuilder();
                    npc.setTemplateId(unit.getIntValue("templateId"));
                    npc.setId(unit.getIntValue("ObjectId"));
                    res.addS2CNpcs(npc);
                }
            }
            area.npcDatas = res.build().toByteArray();
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes((area.npcDatas == null) ? ResourceHandler.QueryAreaDataResponse.newBuilder().setS2CCode(200).build().toByteArray() : area.npcDatas);
            }
        };
    }

    public short getType() {
        return 1283;
    }
}


