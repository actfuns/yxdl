package com.wanniu.game.request.farm;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PlantShopCO;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.Common;
import pomelo.farm.Farm;
import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.getShopInfoRequest")
public class GetShopInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.GetShopInfoRequest msg = FarmHandler.GetShopInfoRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.GetShopInfoResponse.Builder res = FarmHandler.GetShopInfoResponse.newBuilder();
                FarmMgr farmMgr = player.farmMgr;
                for (PlantShopCO plantShopCO : GameData.PlantShops.values()) {
                    Farm.ShopItemInfo.Builder sb = Farm.ShopItemInfo.newBuilder();
                    sb.setItemId(plantShopCO.iD);
                    if (farmMgr.myPO.shopToday.containsKey(Integer.valueOf(plantShopCO.iD))) {

                        sb.setChangeNumCurrent(((Integer) farmMgr.myPO.shopToday.get(Integer.valueOf(plantShopCO.iD))).intValue());
                    } else {

                        sb.setChangeNumCurrent(0);
                    }
                    sb.setChangeNumMax(plantShopCO.changeNum);
                    List<WNBag.SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(plantShopCO.parameter);
                    for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
                        Common.KeyValueStruct.Builder kvBuilder = Common.KeyValueStruct.newBuilder();
                        kvBuilder.setKey(simpleItemInfo.itemCode);
                        kvBuilder.setValue(String.valueOf(simpleItemInfo.itemNum));
                        sb.addNeed(kvBuilder.build());
                    }

                    simpleItemInfos = ItemUtil.parseString(plantShopCO.itemCode);
                    for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
                        Common.KeyValueStruct.Builder kvBuilder = Common.KeyValueStruct.newBuilder();
                        kvBuilder.setKey(simpleItemInfo.itemCode);
                        kvBuilder.setValue(String.valueOf(simpleItemInfo.itemNum));
                        sb.addAward(kvBuilder.build());
                    }
                }


                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


