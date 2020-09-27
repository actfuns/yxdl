package com.wanniu.game.request.hookSet;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.HookSetHandler;


@GClientEvent("area.hookSetHandler.changeHookSetRequest")
public class ChangeHookSetHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        HookSetHandler.ChangeHookSetRequest msg = HookSetHandler.ChangeHookSetRequest.parseFrom(this.pak.getRemaingBytes());

        final HookSetHandler.ChangeHookSetResponse.Builder res = HookSetHandler.ChangeHookSetResponse.newBuilder();
        if (player != null) {
            HookSetHandler.HookSetData hsd = msg.getC2SHookSetData();
            List<Integer> colors = hsd.getMeltQcolorList();


            res.setS2CCode(200);
            player.getHookSet().changeHookSet(hsd);
        } else {

            res.setS2CCode(500);
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


