package com.wanniu.game.request.farm;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.harvestRequest")
public class HarvestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.HarvestRequest msg = FarmHandler.HarvestRequest.parseFrom(this.pak.getRemaingBytes());
        final int blockId = msg.getBlockId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmMgr farmMgr = player.getFarmMgr();
                FarmHandler.HarvestResponse.Builder res = farmMgr.harvest(blockId);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


