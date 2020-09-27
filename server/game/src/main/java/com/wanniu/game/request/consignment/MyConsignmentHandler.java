package com.wanniu.game.request.consignment;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.consignmentShop.ConsignmentUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.ConsignmentLineHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.consignmentLineHandler.myConsignmentRequest")
public class MyConsignmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.MyConsignmentRequest msg = ConsignmentLineHandler.MyConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
        int globalZone = msg.getC2SGlobal();
        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.MyConsignmentResponse.Builder res = ConsignmentLineHandler.MyConsignmentResponse.newBuilder();
                res.setS2CCode(200);
                List<ItemOuterClass.ConsignmentItem> list = player.consignmentManager.getAll();
                res.addAllS2CData(list);
                res.setS2CCanSellNum(ConsignmentUtil.sellNum(player));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


