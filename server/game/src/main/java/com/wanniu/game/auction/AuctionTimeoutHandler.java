package com.wanniu.game.auction;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.poes.AuctionItemPO;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;


public class AuctionTimeoutHandler
        implements Runnable {
    private final String id;

    public AuctionTimeoutHandler(String id) {
        this.id = id;
    }


    public void run() {
        AuctionItemPO item = AuctionDataManager.getInstance().getAuctionItem(this.id);
        if (item == null) {
            return;
        }
        synchronized (item) {

            switch (item.state) {
                case 1:
                    updateAuctionState(item);
                    break;
                case 2:
                    updateShowState(item);
                    break;
                default:
                    Out.warn(new Object[]{"竞拍物品出现非法状态了.", Integer.valueOf(item.state)});
                    break;
            }
        }
    }


    private void updateShowState(AuctionItemPO item) {
        if (StringUtils.isEmpty(item.guildId)) {
            AuctionService.getInstance().settlementAttribution(item);

        } else {

            String playerId = item.playerId;
            if (StringUtils.isEmpty(playerId)) {
                Out.debug(new Object[]{"竟拍物品流入世界竟拍.id=", item.id});

                AuctionService.getInstance().syncRemoveAuctionItem(item);


                String guildId = item.guildId;
                if (StringUtils.isNotEmpty(guildId)) {
                    int type = 3;
                    GWorld.getInstance().ansycExec(() -> AuctionService.getInstance().log(guildId, playerId, type, item.db.code, item.curPrice));
                }


                if (AuctionDataManager.getInstance().canEnterWorld(item.db.code)) {
                    item.state = 1;
                    item.guildId = null;
                    LocalDateTime now = LocalDateTime.now();
                    item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_WorldShowTime);


                    AuctionService.getInstance().addDelayJob(now, item);


                    AuctionService.getInstance().syncAddAuctionItemInfo(Arrays.asList(new AuctionItemPO[]{item}, ), 2);


                    AuctionService.getInstance().processWorldAuctionsPoint();
                } else {
                    Out.info(new Object[]{"世界竞拍此物品已达上限，直接回收掉...id=", item.id});
                    item.state = 1;
                    item.guildId = null;
                    AuctionService.getInstance().settlementAttribution(item);
                }

                JobFactory.addDelayJob(() -> AuctionService.getInstance().trySendAuctionBonus(guildId), 100000L);
            } else {

                AuctionService.getInstance().settlementAttribution(item);
            }
        }
    }

    private void updateAuctionState(AuctionItemPO item) {
        Out.debug(new Object[]{"竟拍物品切换竟拍状态.id=", item.id});

        LocalDateTime now = LocalDateTime.now();
        item.state = 2;

        if (StringUtils.isEmpty(item.guildId)) {
            item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_WorldBiddingTime);
        } else {

            item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_GuildBiddingTime);
        }


        AuctionService.getInstance().addDelayJob(now, item);


        AuctionService.getInstance().syncAuctionItemInfo(item);
    }
}


