package com.wanniu.game.request.farm;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GetLandCO;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;

import java.io.IOException;

import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.openRequest")
public class OpenHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.OpenRequest msg = FarmHandler.OpenRequest.parseFrom(this.pak.getRemaingBytes());
        final int blockId = msg.getBlockId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.OpenResponse.Builder res = FarmHandler.OpenResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();
                FarmPO farmPO = farmMgr.myPO;

                GetLandCO getLandCO = (GetLandCO) GameData.GetLands.get(Integer.valueOf(blockId));
                FarmMgr.Block block = (FarmMgr.Block) farmPO.blockMap.get(Integer.valueOf(blockId));


                if (getLandCO.getType != FarmMgr.OPEN_BLOCK.DIAMOND.value) {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_NO_NEED_TO_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (!player.moneyManager.enoughDiamond(getLandCO.value)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(String.format(LangService.getValue("FARM_DIAMOND_NEED"), new Object[]{Integer.valueOf(getLandCO.value)}));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (block.blockState != FarmMgr.BLOCK_STATE.CLOSED) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FARM_BLOCK_OPENED"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                boolean openRes = farmMgr.open(blockId);

                if (openRes) {
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


