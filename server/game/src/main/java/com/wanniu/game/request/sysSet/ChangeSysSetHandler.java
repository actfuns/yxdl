package com.wanniu.game.request.sysSet;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SysSetHandler;


@GClientEvent("area.sysSetHandler.changeSysSetRequest")
public class ChangeSysSetHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        if (player == null) {
            return new PomeloResponse() {
                protected void write() throws IOException {
                    SysSetHandler.ChangeSysSetResponse.Builder res = SysSetHandler.ChangeSysSetResponse.newBuilder();
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
        }
        SysSetHandler.ChangeSysSetRequest req = SysSetHandler.ChangeSysSetRequest.parseFrom(this.pak.getRemaingBytes());
        SysSetHandler.SetData setData = req.getC2SSetData();
        player.sysSetManager.changeSet(setData);
        return new PomeloResponse() {
            protected void write() throws IOException {
                SysSetHandler.ChangeSysSetResponse.Builder res = SysSetHandler.ChangeSysSetResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


