package com.wanniu.game.request.auction;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.auction.AuctionService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AuctionItemPO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.auction.AuctionHandler;


@GClientEvent("auction.auctionHandler.auctionListRequest")
public class AuctionListHandle
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        AuctionHandler.AuctionListRequest request = AuctionHandler.AuctionListRequest.parseFrom(this.pak.getRemaingBytes());
        int type = request.getC2SType();

        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final AuctionHandler.AuctionListResponse.Builder response = AuctionHandler.AuctionListResponse.newBuilder();

        List<AuctionItemPO> items = new ArrayList<>();
        switch (type) {
            case 1:
                response.setS2CBonus(player.guildManager.calAuctionBonus());
                items = AuctionService.getInstance().getGuildAuctionItemList(player);
                break;
            case 2:
                items = AuctionService.getInstance().getWorldAuctionItemList(player);
                break;
            case 3:
                items = AuctionService.getInstance().getSelfAuctionItemList(player);
                break;
            default:
                Out.warn(new Object[]{"拉取竞拍列表大类错误 type=", Integer.valueOf(type)});
                break;
        }

        for (AuctionItemPO item : items) {
            response.addS2CData(AuctionService.getInstance().toAuctionItem(player, item));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                response.setS2CCode(200);
                this.body.writeBytes(response.build().toByteArray());
            }
        };
    }
}


