package com.wanniu.game.request.auction;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.auction.AuctionDataManager;
import com.wanniu.game.auction.AuctionService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RewardListCO;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.money.CostResult;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AuctionItemPO;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import pomelo.auction.AuctionHandler;


@GClientEvent("auction.auctionHandler.auctionRequest")
public class AuctionHandle
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        AuctionHandler.AuctionRequest request = AuctionHandler.AuctionRequest.parseFrom(this.pak.getRemaingBytes());
        String id = request.getItemId();
        int price = request.getPrice();


        AuctionItemPO item = AuctionDataManager.getInstance().getAuctionItem(id);
        if (item == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("AUCTION_ITEM_NOT_EXSIT"));
        }

        synchronized (item) {

            if (item.state != 2) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("AUCTION_NOT_START"));
            }


            Optional<RewardListCO> template = GameData.RewardLists.values().stream().filter(v -> item.db.code.equals(v.code)).findFirst();
            if (!template.isPresent()) {
                Out.warn(new Object[]{"竞拍物品找不到竞价模板，code=", item.db.code});
                return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
            }


            if (price < item.maxPrice && item.nextPrice != price) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("AUCTION_PRICE_CHANGE"));
            }

            WNPlayer player = (WNPlayer) this.pak.getPlayer();


            if (StringUtils.isNotEmpty(item.guildId) && !item.guildId.equals(player.guildManager.getGuildId())) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("AUCTION_NOT_GUILD"));
            }


            price = Math.min(price, item.maxPrice);


            CostResult result = player.moneyManager.costTicketAndDiamond(price, Const.GOODS_CHANGE_TYPE.AUCTION);
            if (!result.isSuccess()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("TICKET_NOT_ENOUGH"));
            }

            int bonus = 0;

            if (StringUtils.isNotEmpty(item.playerId)) {
                bonus = price - item.curPrice;
                AuctionService.getInstance().restitution(item);
            } else {
                bonus = item.curPrice;
            }
            player.guildManager.addAuctionBonus(bonus);


            item.curPrice = price;
            item.nextPrice = Math.min(item.maxPrice, item.curPrice + ((RewardListCO) template.get()).addPrice * item.db.groupCount);
            item.playerId = player.getId();
            item.diamond = result.getValue(VirtualItemType.DIAMOND);
            item.ticket = result.getValue(VirtualItemType.CASH);


            LocalDateTime now = LocalDateTime.now();
            long timeleft = Duration.between(now, item.stateOverTime).getSeconds();
            if (timeleft < GlobalConfig.Auction_LastAddTimes) {
                item.stateOverTime = now.plusSeconds(GlobalConfig.Auction_PerAddTimes + timeleft);
                AuctionService.getInstance().resetDelayJob(now, item);
            }


            if (item.participant == null) {
                item.participant = new HashSet();
            }
            item.participant.add(item.playerId);


            if (item.curPrice >= item.maxPrice) {
                AuctionService.getInstance().settlementAttribution(item);
            } else {

                GWorld.getInstance().ansycExec(() -> AuctionService.getInstance().syncAuctionItemInfo(item));
            }
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                AuctionHandler.AuctionResponse.Builder response = AuctionHandler.AuctionResponse.newBuilder();
                response.setS2CCode(200);
                this.body.writeBytes(response.build().toByteArray());
            }
        };
    }
}


