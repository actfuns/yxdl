package com.wanniu.game.request.player;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.proxy.ProxyType;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.getAreaLinesRequest")
public class GetAreaLinesHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final Area area = player.getArea();
        if (!area.isNormal() && area.sceneType != Const.SCENE_TYPE.CROSS_SERVER
                .getValue() && area.sceneType != Const.SCENE_TYPE.WORLD_BOSS
                .getValue()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
        }

        if (area.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() && GConfig.getInstance().isEnableProxy()) {
            final JSONObject json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_LINES,
                    Utils.toJSON(new Object[]{"areaId", Integer.valueOf(area.areaId), "logicServerId", Integer.valueOf(area.logicServerId)}));
            return new PomeloResponse() {
                protected void write() throws IOException {
                    PlayerHandler.GetAreaLinesResponse.Builder res = PlayerHandler.GetAreaLinesResponse.newBuilder();
                    res.setS2CCode(200);
                    JSONArray arr = json.getJSONArray("lines");
                    for (int i = 0; i < arr.size(); i++) {
                        JSONObject json = arr.getJSONObject(i);
                        PlayerHandler.AreaLineData.Builder line = PlayerHandler.AreaLineData.newBuilder();
                        line.setIndex(json.getIntValue("lineIndex"));
                        line.setInstanceId(json.getString("instanceId"));
                        int curCount = json.getIntValue("curCount");
                        if (curCount < area.prop.boundary) {
                            line.setState(0);
                        } else if (curCount >= area.prop.boundary && curCount < area.fullCount) {
                            line.setState(1);
                        } else {
                            line.setState(2);
                        }
                        res.addS2CData(line);
                    }
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
        }


        final List<Area> areas = AreaManager.getInstance().getAreaMap().getAreas(area.areaId, area.logicServerId);
        Collections.sort(areas, new Comparator<Area>() {
            public int compare(Area o1, Area o2) {
                return (o1.lineIndex > o2.lineIndex) ? 1 : ((o1.lineIndex == o2.lineIndex) ? 0 : -1);
            }
        });
        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.GetAreaLinesResponse.Builder res = PlayerHandler.GetAreaLinesResponse.newBuilder();
                res.setS2CCode(200);
                for (Area area : areas) {
                    PlayerHandler.AreaLineData.Builder line = PlayerHandler.AreaLineData.newBuilder();
                    line.setIndex(area.lineIndex);
                    line.setInstanceId(area.instanceId);
                    int curCount = area.getPlayerNum();
                    if (area.getPlayerNum() < area.prop.boundary) {
                        line.setState(0);
                    } else if (curCount >= area.prop.boundary && curCount < area.fullCount) {
                        line.setState(1);
                    } else {
                        line.setState(2);
                    }
                    res.addS2CData(line);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


