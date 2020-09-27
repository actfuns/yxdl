package com.wanniu.game.auction;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.poes.AuctionItemPO;
import com.wanniu.redis.GameDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;


public class AuctionDataManager {
    private static AuctionDataManager instance;

    public static AuctionDataManager getInstance() {
        if (instance == null) {
            synchronized (ConsignmentLineService.class) {
                if (instance == null) {
                    instance = new AuctionDataManager();
                }
            }
        }
        return instance;
    }


    public static final Map<String, AuctionItemPO> items = new ConcurrentHashMap<>();

    public AuctionDataManager() {
        long start = System.currentTimeMillis();
        Map<String, String> result = GCache.hgetAll(ConstsTR.auction_itemsTR.value);
        for (Map.Entry<String, String> e : result.entrySet()) {
            AuctionItemPO item = (AuctionItemPO) JSON.parseObject(e.getValue(), AuctionItemPO.class);

            boolean show = (item.state == 1);
            LocalDateTime now = LocalDateTime.now();

            if (StringUtils.isEmpty(item.guildId)) {
                item.stateOverTime = now.plusMinutes(show ? GlobalConfig.Auction_WorldShowTime : GlobalConfig.Auction_WorldBiddingTime);
            } else {

                item.stateOverTime = now.plusMinutes(show ? GlobalConfig.Auction_GuildShowTime : GlobalConfig.Auction_GuildBiddingTime);
            }

            AuctionService.getInstance().addDelayJob(now, item);

            items.put(e.getKey(), item);
        }
        Out.info(new Object[]{"加载竟拍数据耗时:", Long.valueOf(System.currentTimeMillis() - start), " ms"});
    }


    public void onCloseGame() {
        for (Map.Entry<String, AuctionItemPO> e : items.entrySet()) {
            GameDao.update(ConstsTR.auction_itemsTR.value, e.getKey(), e.getValue());
        }
    }


    public List<AuctionItemPO> getItemByPredicate(Predicate<? super AuctionItemPO> predicate) {
        return (List<AuctionItemPO>) items.values().stream().filter(predicate).collect(Collectors.toList());
    }

    public boolean hasGuildItem(String guildId) {
        return items.values().stream().filter(v -> guildId.equals(v.guildId)).findFirst().isPresent();
    }


    public synchronized boolean canEnterWorld(String itemcode) {
        return (items.values().stream().filter(v -> (v.guildId == null && itemcode.equals(v.db.code))).count() < 3L);
    }

    public boolean hasWorldItem() {
        return items.values().stream().filter(v -> (v.guildId == null)).findFirst().isPresent();
    }

    public AuctionItemPO getAuctionItem(String id) {
        return items.get(id);
    }

    public void addAuctionItem(AuctionItemPO aitem) {
        items.put(aitem.id, aitem);
    }

    public void removeAuctionItem(String id) {
        items.remove(id);
        GCache.hremove(ConstsTR.auction_itemsTR.value, id);
    }
}


