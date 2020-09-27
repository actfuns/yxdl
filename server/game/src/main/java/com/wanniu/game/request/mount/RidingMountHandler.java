package com.wanniu.game.request.mount;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.ridingMountRequest")
public class RidingMountHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MountHandler.RidingMountRequest req = MountHandler.RidingMountRequest.parseFrom(this.pak.getRemaingBytes());
        final GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;
        final int isUp = req.getC2SIsUp();
        return new PomeloResponse() {
            protected void write() throws IOException {
                MountHandler.RidingMountResponse.Builder res = MountHandler.RidingMountResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    PlayerUtil.logWarnIfPlayerNull(RidingMountHandler.this.pak);

                    return;
                }
                if (!AreaUtil.canRideMount(wPlayer.getAreaId())) {
                    res.setS2CCode(500);
                    MapBase map = AreaUtil.getAreaProp(wPlayer.getAreaId());
                    if (map.type == Const.SCENE_TYPE.FIVE2FIVE.getValue() || map.type == Const.SCENE_TYPE.ALLY_FIGHT.getValue() || map.type == Const.SCENE_TYPE.ARENA.getValue() || map.type == Const.SCENE_TYPE.CROSS_SERVER.getValue() || map.type == Const.SCENE_TYPE.SIN_COM.getValue()) {
                        res.setS2CMsg("");
                    } else {
                        res.setS2CMsg(LangService.getValue("MOUNT_THIS_SENCE_CANNOT_USE_MOUNT"));
                    }
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                int result = wPlayer.mountManager.ridingMount(isUp);

                if (result == 0) {
                    res.setS2CCode(200);
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg("SOMETHING_ERR");
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


