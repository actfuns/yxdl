package com.wanniu.game.request.auction;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.auction.AuctionService;

import java.io.IOException;

import pomelo.auction.AuctionHandler;


@GClientEvent("auction.auctionHandler.syncAuctionInfoRequest")
public class SyncAuctionInfoHandle
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        AuctionService.getInstance().addSyncRequest(this.pak.getPlayer().getId());

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(AuctionHandler.SyncAuctionInfoResponse.newBuilder().setS2CCode(200).build().toByteArray());
            }
        };
    }
}


