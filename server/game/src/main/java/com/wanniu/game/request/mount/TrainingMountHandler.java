package com.wanniu.game.request.mount;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.trainingMountRequest")
public class TrainingMountHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final MountHandler.TrainingMountRequest req = MountHandler.TrainingMountRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) TrainingMountHandler.this.pak.getPlayer();
                MountHandler.TrainingMountResponse.Builder res = MountHandler.TrainingMountResponse.newBuilder();
                if (!player.mountManager.isOpenMount()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                int type = req.getC2SType();
                if (type == 1) {
                    int i = player.mountManager.upgradeLv();
                    if (i == -1) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("MOUNT_SKIN_HAVE_MAX_STAGE"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    if (i == -2) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("MOUNT_NOT_TEN_STAR"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    if (i == -3) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_ENOUGH_ITEM"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    res.setS2CCode(200);
                    res.setS2CData(player.mountManager.getMountData().build());
                    this.body.writeBytes(res.build().toByteArray());
                    Out.info(new Object[]{"坐骑升阶成功,roleId=", player.getId(), ",坐骑外形Id=", Integer.valueOf(player.mountManager.mount.usingSkinId), "坐骑阶级=",
                            Integer.valueOf(player.mountManager.mount.rideLevel)});

                    return;
                }
                int result = player.mountManager.upgradeStar();
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MOUNT_ALREADY_TEN_STAR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_ENOUGH_ITEM"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(200);
                res.setS2CData(player.mountManager.getMountData().build());
                this.body.writeBytes(res.build().toByteArray());
                Out.info(new Object[]{"坐骑升星成功,roleId=", player.getId(), ",坐骑外形Id=", Integer.valueOf(player.mountManager.mount.usingSkinId), "坐骑星级=",
                        Integer.valueOf(player.mountManager.mount.starLv)});
            }
        };
    }
}


