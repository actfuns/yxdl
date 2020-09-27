package com.wanniu.game.request.item;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.ItemHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.itemHandler.getAllEquipDetailsRequest")
public class GetAllEquipDetailsHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();

        ItemHandler.GetAllEquipDetailsRequest req = ItemHandler.GetAllEquipDetailsRequest.parseFrom(this.pak.getRemaingBytes());


        return new PomeloResponse() {
            protected void write() throws IOException {
                ItemHandler.GetAllEquipDetailsResponse.Builder res = ItemHandler.GetAllEquipDetailsResponse.newBuilder();

                List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
                data.addAll(wnBag.getAllEquipDetails4PayLoad());
                data.addAll(player.equipManager.getAllEquipDetails4PayLoad());
                data.addAll(player.wareHouse.getAllEquipDetails4PayLoad());

                res.setS2CCode(200);
                res.addAllS2CItems(data);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


