package com.wanniu.game.request.player;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.PathService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerTempPO;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.changeAreaRequest")
public class ChangeAreaHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        PlayerHandler.ChangeAreaRequest req = PlayerHandler.ChangeAreaRequest.parseFrom(this.pak.getRemaingBytes());
        String pointId = req.getC2SPointId();
        int areaId = 0;
        float targetX = 0.0F;
        float targetY = 0.0F;

        Area area = player.getArea();
        PlayerTempPO tempData = player.getPlayerTempData();

        if ("0".equals(pointId)) {
            areaId = tempData.historyAreaId;
            targetX = tempData.historyX;
            targetY = tempData.historyY;
            float[] arrayOfFloat = PathService.findToAreaXYByPointId(areaId, pointId);
            if (arrayOfFloat != null) {
                targetX = arrayOfFloat[0];
                targetY = arrayOfFloat[1];
            }
        } else {
            areaId = PathService.findToAreaByPointId(player.getAreaId(), pointId);
            if (areaId == tempData.historyAreaId) {
                targetX = tempData.historyX;
                targetY = tempData.historyY;
            }
        }
        if (areaId == 0) {
            return (PomeloResponse) new ErrorResponse(player.getAreaId() + " - " + pointId + " : " + LangService.getValue("AREA_ID_NULL"));
        }
        float[] xy = PathService.findToAreaXYByAreaId(area.areaId, areaId);
        if (xy == null) {
            JSONObject json = area.getBornPlace(areaId);
            xy = new float[2];
            xy[0] = json.getFloatValue("x");
            xy[1] = json.getFloatValue("y");
            area.prop.toAreaXY.put(Integer.valueOf(areaId), xy);
        }
        if (xy != null && xy[0] != 0.0F && xy[1] != 0.0F) {
            targetX = xy[0];
            targetY = xy[1];
        }

        final PlayerHandler.ChangeAreaResponse.Builder res = PlayerHandler.ChangeAreaResponse.newBuilder();

        if (area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue() || area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVP.getValue()) {
            String str = player.guildFortManager.handleChangeArea(areaId);
            if (str != null) {
                return (PomeloResponse) new ErrorResponse(str);
            }
            res.setS2CCode(200);
            return new PomeloResponse() {
                protected void write() throws IOException {
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
        }


        MapBase sceneProp = AreaUtil.getAreaProp(areaId);
        String result = AreaUtil.canEnterArea(sceneProp, player);
        if (result != null) {
            return (PomeloResponse) new ErrorResponse(result);
        }

        Out.debug(new Object[]{Integer.valueOf(sceneProp.mapID), " ===changeArea=== x:", Float.valueOf(targetX), ", y:", Float.valueOf(targetY)});
        res.setS2CCode(200);
        if ((area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP.getValue()) && area.hasHighQualityItem()) {
            player.puchFuncGoToPickItem();

        } else if (req.getC2SType() == 0 && (sceneProp.type == Const.SCENE_TYPE.FIGHT_LEVEL
                .getValue() || area.sceneType == Const.SCENE_TYPE.LOOP
                .getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION_2
                .getValue())) {

            res.setS2CEnterTips(String.valueOf(sceneProp.mapID));
        } else {
            int dstId = areaId;
            float dstX = targetX, dstY = targetY;
            GWorld.getInstance().ansycExec(() -> {
                String instanceId = player.getInstanceId();

                int oldAreaId = player.getAreaId();

                AreaUtil.enterArea(player, dstId, dstX, dstY);
                if (AreaUtil.needCreateArea(oldAreaId)) {
                    AreaUtil.closeAreaNoPlayer(instanceId);
                }
            });
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


