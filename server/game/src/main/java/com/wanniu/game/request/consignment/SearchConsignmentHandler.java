package com.wanniu.game.request.consignment;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.ConsignmentLineHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.consignmentLineHandler.searchConsignmentRequest")
public class SearchConsignmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        ConsignmentLineHandler.SearchConsignmentRequest msg = ConsignmentLineHandler.SearchConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
        String condition = msg.getC2SCondition();
        final List<ItemOuterClass.ConsignmentItem> result = ConsignmentLineService.getInstance().search(player, GWorld.__SERVER_ID, condition);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ConsignmentLineHandler.SearchConsignmentResponse.Builder res = ConsignmentLineHandler.SearchConsignmentResponse.newBuilder();
                res.setS2CCode(200);
                res.addAllS2CData(result);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


