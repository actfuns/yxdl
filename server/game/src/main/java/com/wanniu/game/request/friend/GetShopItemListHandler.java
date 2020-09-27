package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.getShopItemListRequest")
public class GetShopItemListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {


            protected void write() throws IOException {
                FriendHandler.GetShopItemListResponse.Builder res = FriendHandler.GetShopItemListResponse.newBuilder();
                res.setS2CCode(200);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


