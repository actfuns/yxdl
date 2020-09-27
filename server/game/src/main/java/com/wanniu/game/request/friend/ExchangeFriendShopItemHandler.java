package com.wanniu.game.request.friend;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.FriendHandler;


@GClientEvent("area.friendHandler.exchangeFriendShopItemRequest")
public class ExchangeFriendShopItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                FriendHandler.ExchangeFriendShopItemResponse.Builder res = FriendHandler.ExchangeFriendShopItemResponse.newBuilder();

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


