package com.wanniu.game.request.farm;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.cultivateSelfRequest")
public class CultivateSelfHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.CultivateSelfRequest msg = FarmHandler.CultivateSelfRequest.parseFrom(this.pak.getRemaingBytes());
        final int blockId = msg.getBlockId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.CultivateSelfResponse.Builder res = FarmHandler.CultivateSelfResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();

                boolean cultivateRes = farmMgr.cultivateSelf(blockId);
                if (!cultivateRes) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_CULTIVATE_FAIL"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


