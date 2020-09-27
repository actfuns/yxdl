package com.wanniu.game.request.farm;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.PlantingCO;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.sowRequest")
public class SowHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.SowRequest msg = FarmHandler.SowRequest.parseFrom(this.pak.getRemaingBytes());
        final int blockId = msg.getBlockId();
        final String seedCode = msg.getSeedCode();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.SowResponse.Builder res = FarmHandler.SowResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();
                FarmPO farmPO = farmMgr.myPO;

                FarmMgr.Block block = (FarmMgr.Block) farmPO.blockMap.get(Integer.valueOf(blockId));


                if (block.blockState != FarmMgr.BLOCK_STATE.OPENED) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_BLOCK_CANNOT_SOW"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);
                if (farmPO.lv < plantingCO.plantLevel) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_NOT_ENOUGH_LV"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                int seedNum = player.bag.findItemNumByCode(seedCode);


                if (seedNum < 1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_NO_SEED"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                boolean sowRes = farmMgr.sow(blockId, seedCode);

                if (sowRes) {
                    res.setS2CCode(200);
                } else {
                    Out.error(new Object[]{"不会走到这里"});
                    res.setS2CCode(500);

                    return;
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


