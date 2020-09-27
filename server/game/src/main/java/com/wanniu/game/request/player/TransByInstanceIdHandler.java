package com.wanniu.game.request.player;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.proxy.ProxyType;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.cross.CrossServerArea;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.transByInstanceIdRequest")
public class TransByInstanceIdHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        PlayerHandler.TransByInstanceIdRequest req = PlayerHandler.TransByInstanceIdRequest.parseFrom(this.pak.getRemaingBytes());
        String instanceId = req.getC2SInstanceId();
        if (StringUtil.isEmpty(instanceId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }
        if (instanceId.equals(player.getInstanceId())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LINE_CHANGE_UNECESSARY"));
        }

        Area area = player.getArea();
        if (!area.isNormal() && area.sceneType != Const.SCENE_TYPE.CROSS_SERVER
                .getValue() && area.sceneType != Const.SCENE_TYPE.WORLD_BOSS
                .getValue()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
        }

        boolean newCrossArea = false;
        Area targetArea = AreaUtil.getArea(instanceId);
        if (targetArea == null && area.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() && GConfig.getInstance().isEnableProxy()) {
            TeamData team = player.getTeamManager().getTeam();
            int count = (team == null) ? 1 : team.memberCount();
            JSONObject json = Utils.toJSON(new Object[]{"instanceId", instanceId, "count", Integer.valueOf(count)});
            json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_TRANS_LINE, json);
            if (json.containsKey("csNode")) {
                AreaData areaData = new AreaData(area.areaId, instanceId);
                JSONObject pos = PlayerUtil.getPlayerPosition(player);
                areaData.targetX = pos.getIntValue("x");
                areaData.targetY = pos.getIntValue("y");
                targetArea = AreaUtil.bindCrossServerArea(player, json, crossArea -> {
                    AreaUtil.dispatchByInstanceId(player, areaData);
                    player.sendSysTip(LangService.getValue("LINE_CHANGE_SUCESS"), Const.TipsType.BLACK);
                });
                newCrossArea = true;
            }
        }

        if (targetArea == null || targetArea.logicServerId != area.logicServerId || targetArea.areaId != area.areaId || targetArea

                .isFull()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
        }

        if (!newCrossArea) {
            AreaData areaData = new AreaData(area.areaId, instanceId);
            JSONObject pos = PlayerUtil.getPlayerPosition(player);
            areaData.targetX = pos.getIntValue("x");
            areaData.targetY = pos.getIntValue("y");

            targetArea = AreaUtil.dispatchByInstanceId(player, areaData);
            if (targetArea != null) {
                player.sendSysTip(LangService.getValue("LINE_CHANGE_SUCESS"), Const.TipsType.BLACK);
            } else {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
            }
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.TransByInstanceIdResponse.Builder res = PlayerHandler.TransByInstanceIdResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


