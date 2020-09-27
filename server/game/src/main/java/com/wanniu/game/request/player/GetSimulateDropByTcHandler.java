package com.wanniu.game.request.player;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.TreasureClassExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.playerHandler.getSimulateDropByTcRequest")
public class GetSimulateDropByTcHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        if (!GWorld.DEBUG) {
            this.pak.getSession().close();
            return null;
        }

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.SimulateDropByTcRequest req = PlayerHandler.SimulateDropByTcRequest.parseFrom(this.pak.getRemaingBytes());
        String tcCode = req.getC2STcCode();
        int tcCount = req.getC2STcCount();
        int tcLevel = req.getC2STcLevel();

        if (tcCount > 10000) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SIMULATE_TOO_LARGE"));
        }
        TreasureClassExt prop = (TreasureClassExt) GameData.TreasureClasss.get(tcCode);
        if (prop == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SIMULATE_PROP_FIND"));
        }
        if (prop.tcLevel < tcLevel) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("SIMULATE_LEVEL_LOW"));
        }

        final PlayerHandler.SimulateDropByTcResponse.Builder res = PlayerHandler.SimulateDropByTcResponse.newBuilder();
        int runCount = 0;
        for (int i = 0; i < tcCount; i++) {
            List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(tcCode);
            if (tcItems.size() > 0) {
                runCount++;
                PlayerHandler.SimulateDataPush.Builder data = PlayerHandler.SimulateDataPush.newBuilder();
                tcItems.forEach(v -> {
                    if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
                        ItemOuterClass.MiniItem.Builder propTmp = ItemUtil.getMiniItemData(v.itemCode(), v.getWorth());

                        data.addS2CItems(propTmp);
                    } else {
                        ItemOuterClass.MiniItem.Builder propTmp = ItemUtil.getMiniItemData(v.itemCode(), v.getNum());
                        data.addS2CItems(propTmp);
                    }
                });
                player.receive("area.playerPush.simulateDropPush", (GeneratedMessage) data.build());
            }
        }

        res.setS2CRunNum(runCount);
        res.setS2CSuccPer(runCount / tcCount * 100);

        return new PomeloResponse() {
            protected void write() throws IOException {
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


