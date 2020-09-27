package com.wanniu.game.request.auction;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.auction.AuctionService;

import java.io.IOException;

import pomelo.auction.AuctionHandler;


@GClientEvent("auction.auctionHandler.cancelSyncAuctionInfoRequest")
public class CancelSyncAuctionInfoHandle
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        AuctionService.getInstance().cancelSyncRequest(this.pak.getPlayer().getId());

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(AuctionHandler.CancelSyncAuctionInfoResponse.newBuilder().setS2CCode(200).build().toByteArray());
            }
        };
    }
}


