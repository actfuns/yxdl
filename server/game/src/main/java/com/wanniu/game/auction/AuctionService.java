package com.wanniu.game.auction;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.GGame;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtils;
import com.wanniu.game.GWorld;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RewardListCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.ItemRecordInfo;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.guidDepot.GuildAuctionLog;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AuctionItemPO;
import com.wanniu.game.poes.GuildBossPo;
import com.wanniu.game.poes.GuildMemberPO;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.PlayerPOManager;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import pomelo.auction.AuctionHandler;


public class AuctionService {
    private static final AuctionService instance = new AuctionService();

    private static final Map<String, Long> syncs = new ConcurrentHashMap<>();

    private static final Map<String, ScheduledFuture<?>> futures = new ConcurrentHashMap<>();

    public static AuctionService getInstance() {
        return instance;
    }


    public void addSyncRequest(String playerId) {
        syncs.put(playerId, Long.valueOf(System.currentTimeMillis()));
    }


    public void cancelSyncRequest(String playerId) {
        syncs.remove(playerId);
    }


    public void addAuctionItem(List<NormalItem> items, String guildId, String rewardSource) {
        LocalDateTime now = LocalDateTime.now();

        List<AuctionItemPO> newItemList = new ArrayList<>();
        for (NormalItem item : items) {
            AuctionItemPO aitem = create(item, guildId, rewardSource);
            AuctionDataManager.getInstance().addAuctionItem(aitem);

            addDelayJob(now, aitem);
            newItemList.add(aitem);
        }


        GWorld.getInstance().ansycExec(() -> syncAddAuctionItemInfo(newItemList, 1));
    }


    public void processGuildAuctionsPoint(String guildId) {
        List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildId);
        if (memberList != null && !memberList.isEmpty()) {
            for (GuildMemberPO po : memberList) {
                WNPlayer player = PlayerUtil.getOnlinePlayer(po.playerId);
                if (player != null) {
                    player.auctionManager.pushScript();
                }
            }
        }
    }


    public void processWorldAuctionsPoint() {
        Map<String, GPlayer> map = GGame.getInstance().getOnlinePlayers();
        if (map != null && !map.isEmpty()) {
            Collection<GPlayer> playerIds = map.values();
            for (GPlayer player : playerIds) {
                ((WNPlayer) player).auctionManager.pushScript();
            }
        }
    }


    public void syncAddAuctionItemInfo(List<AuctionItemPO> newItemList, int type) {
        for (String playerId : syncs.keySet()) {
            WNPlayer player = GWorld.getInstance().getPlayer(playerId);
            if (player == null) {
                continue;
            }

            AuctionHandler.AddAuctionItemPush.Builder push = AuctionHandler.AddAuctionItemPush.newBuilder();
            for (AuctionItemPO item : newItemList) {

                if (hasContinue(item, player)) {
                    continue;
                }
                push.addS2CItem(toAuctionItem(player, item));
            }
            if (push.getS2CItemCount() > 0) {
                push.setS2CType(type);
                player.receive("auction.auctionPush.addAuctionItemPush", (GeneratedMessage) push.build());
            }
        }
    }


    public void syncAuctionItemInfo(AuctionItemPO item) {
        for (String playerId : syncs.keySet()) {
            WNPlayer player = GWorld.getInstance().getPlayer(playerId);
            if (player == null) {
                continue;
            }


            if (hasContinue(item, player)) {
                continue;
            }

            AuctionHandler.AuctionItemPush.Builder push = AuctionHandler.AuctionItemPush.newBuilder();
            push.setS2CItem(toAuctionItem(player, item));
            player.receive("auction.auctionPush.auctionItemPush", (GeneratedMessage) push.build());
        }
    }


    public void syncRemoveAuctionItem(AuctionItemPO item) {
        AuctionHandler.RemoveAuctionItemPush push = AuctionHandler.RemoveAuctionItemPush.newBuilder().setId(item.id).build();
        for (String playerId : syncs.keySet()) {
            WNPlayer player = GWorld.getInstance().getPlayer(playerId);
            if (player == null) {
                continue;
            }


            if (hasContinue(item, player)) {
                continue;
            }

            player.receive("auction.auctionPush.removeAuctionItemPush", (GeneratedMessage) push);
        }
    }


    private boolean hasContinue(AuctionItemPO item, WNPlayer player) {
        if (StringUtils.isNotEmpty(item.guildId) &&
                !item.guildId.equals(player.guildManager.getGuildId())) {
            if (item.participant == null || !item.participant.contains(player.getId())) {
                return true;
            }
        }

        return false;
    }

    public AuctionHandler.AuctionItem toAuctionItem(WNPlayer player, AuctionItemPO item) {
        NormalItem normalItem = ItemUtil.createItemByDbOpts(item.db);
        AuctionHandler.AuctionItem.Builder builder = AuctionHandler.AuctionItem.newBuilder();
        builder.setId(item.id);
        builder.setDetail(normalItem.getItemDetail(player.playerBasePO));
        builder.setState(item.state);
        builder.setTimeleft((int) Duration.between(LocalDateTime.now(), item.stateOverTime).getSeconds());
        builder.setCurPrice(item.nextPrice);
        builder.setMaxPrice(item.maxPrice);
        builder.setSelf(player.getId().equals(item.playerId));
        builder.setNum(normalItem.getNum());
        builder.setSource((item.source == null) ? "" : item.source);
        return builder.build();
    }

    private AuctionItemPO create(NormalItem item, String guildId, String rewardSource) {
        AuctionItemPO data = new AuctionItemPO();
        data.id = UUID.randomUUID().toString();
        data.db = item.itemDb;

        data.db.isBind = Const.ForceType.BIND.getValue();


        data.state = 1;
        data.stateOverTime = LocalDateTime.now().plusMinutes(GlobalConfig.Auction_GuildShowTime).plusSeconds(RandomUtils.nextInt(1, 60));
        data.guildId = guildId;
        data.source = rewardSource;

        Optional<RewardListCO> template = GameData.RewardLists.values().stream().filter(v -> data.db.code.equals(v.code)).findFirst();
        if (template.isPresent()) {
            data.curPrice = ((RewardListCO) template.get()).auctionMin * item.getNum();
            data.maxPrice = ((RewardListCO) template.get()).auctionMax * item.getNum();
        } else {
            Out.warn(new Object[]{"竞拍物品找不到竞价模板，code=", data.db.code});
            data.curPrice = 100 * item.getNum();
            data.maxPrice = 100000 * item.getNum();
        }
        data.nextPrice = data.curPrice;
        return data;
    }


    public List<AuctionItemPO> getGuildAuctionItemList(WNPlayer player) {
        String guildId = player.guildManager.getGuildId();
        if (StringUtils.isEmpty(guildId)) {
            return Collections.emptyList();
        }
        return AuctionDataManager.getInstance().getItemByPredicate(v -> guildId.equals(v.guildId));
    }


    public List<AuctionItemPO> getSelfAuctionItemList(WNPlayer player) {
        return AuctionDataManager.getInstance().getItemByPredicate(v -> (v.participant != null && v.participant.contains(player.getId())));
    }


    public List<AuctionItemPO> getWorldAuctionItemList(WNPlayer player) {
        List<AuctionItemPO> list = AuctionDataManager.getInstance().getItemByPredicate(v -> (v.guildId == null));
        if (list != null && !list.isEmpty()) {
            GuildBossPo guildBossPO = player.guildBossManager.getAndCheckUpdateGuildBossPo(player.player.id);
            guildBossPO.aucpoint = 1;

            player.auctionManager.pushScript();
        }
        return list;
    }

    public void addDelayJob(LocalDateTime now, AuctionItemPO item) {
        long timeleft = Duration.between(now, item.stateOverTime).getSeconds();
        futures.put(item.id, JobFactory.addDelayJob(() -> {
            removeSchedule(item.id);
            GWorld.getInstance().ansycExec(new AuctionTimeoutHandler(item.id));
        }timeleft, TimeUnit.SECONDS));
    }


    public void resetDelayJob(LocalDateTime now, AuctionItemPO item) {
        ScheduledFuture<?> future = futures.remove(item.id);
        if (future != null) {
            future.cancel(false);
            if (!future.isCancelled()) {
                Out.warn(new Object[]{"记录一个非法状态, itemId=", item.id});

                return;
            }
        }

        addDelayJob(now, item);
    }

    public void removeSchedule(String id) {
        futures.remove(id);
    }


    public void settlementAttribution(AuctionItemPO item) {
        String playerId = item.playerId;
        Out.info(new Object[]{"结算竟拍归属，id=", item.id, ",code=", item.db.code, ",playerId=", playerId, ",price=", Integer.valueOf(item.curPrice)});

        AuctionDataManager.getInstance().removeAuctionItem(item.id);
        ScheduledFuture<?> future = futures.remove(item.id);
        if (future != null) {
            future.cancel(false);
        }
        boolean isPrice = (item.curPrice >= item.maxPrice);
        if (StringUtils.isNotEmpty(playerId)) {
            try {
                String mailKey = isPrice ? "AuctionGetReward2" : "AuctionGetReward1";
                MailSysData mail = new MailSysData(mailKey);
                mail.entityItems = new ArrayList();
                mail.entityItems.add(item.db);

                mail.replace = new HashMap<>();
                mail.replace.put("Price", String.valueOf(item.curPrice));
                DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
                mail.replace.put("Item", MessageUtil.itemColorName(itemBase.qcolor, itemBase.name));

                MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mail, Const.GOODS_CHANGE_TYPE.AUCTION);


                if (item.diamond > 0) {
                    PlayerPO playerPo = PlayerUtil.getPlayerBaseData(playerId);
                    if (playerPo != null) {
                        playerPo.totalCostDiamond += item.diamond;
                        RechargeActivityService.getInstance().onConsumeEvent(playerId, item.diamond);

                        Out.info(new Object[]{"add totalCostDiamond playerId=", playerId, ",num=", Integer.valueOf(item.diamond)});
                    } else {
                        Out.warn(new Object[]{"add totalCostDiamond error. playerId=", playerId, ",num=", Integer.valueOf(item.diamond)});
                    }
                }
            } catch (Exception e) {
                Out.warn(new Object[]{"竞拍结算归属异常.playerId=", playerId, ",diamond=", Integer.valueOf(item.diamond), ",ticket=", Integer.valueOf(item.ticket), ",itemcode=", item.db.code});
            }
        }


        String guildId = item.guildId;
        if (StringUtils.isNotEmpty(guildId)) {
            int type = isPrice ? 2 : 1;
            GWorld.getInstance().ansycExec(() -> log(guildId, playerId, type, item.db.code, item.curPrice));
        }


        GWorld.getInstance().ansycExec(() -> getInstance().syncRemoveAuctionItem(item));


        trySendAuctionBonus(guildId);


        processWorldAuctionsPoint();
    }

    public void trySendAuctionBonus(String guildId) {
        int totalBonus, bonus;
        if (StringUtils.isEmpty(guildId)) {
            return;
        }


        if (AuctionDataManager.getInstance().hasGuildItem(guildId)) {
            return;
        }


        GuildPO guild = GuildUtil.getGuild(guildId);
        if (guild == null) {
            return;
        }


        Set<String> ids = GuildUtil.getGuildMemberIdList(guildId);
        if (ids == null || ids.isEmpty()) {
            return;
        }


        synchronized (guild) {
            totalBonus = guild.auctionBonus;
            bonus = Math.min(GlobalConfig.Auction_MaxBonus, totalBonus / ids.size());
            if (bonus <= 0) {
                return;
            }
            guild.auctionBonus = 0;
        }


        for (String playerId : ids) {
            try {
                MailSysData mail = new MailSysData("AuctionShareBonus");
                mail.attachments = new ArrayList();


                MailData.Attachment att = new MailData.Attachment();
                att.itemCode = VirtualItemType.CASH.getItemcode();
                att.itemNum = bonus;
                mail.attachments.add(att);

                mail.replace = new HashMap<>();
                mail.replace.put("Price", String.valueOf(totalBonus));
                mail.replace.put("Num", String.valueOf(bonus));

                MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mail, Const.GOODS_CHANGE_TYPE.AUCTION_BONUS);
            } catch (Exception e) {
                Out.warn(new Object[]{"竞拍分红异常.playerId=", playerId, ",ticket=", Integer.valueOf(bonus)});
            }
        }
    }


    public void restitution(AuctionItemPO item) {
        try {
            MailSysData mail = new MailSysData("AuctionReturn");
            mail.attachments = new ArrayList();

            if (item.diamond > 0) {
                MailData.Attachment att = new MailData.Attachment();
                att.itemCode = VirtualItemType.DIAMOND.getItemcode();
                att.itemNum = item.diamond;
                mail.attachments.add(att);
            }
            if (item.ticket > 0) {
                MailData.Attachment att = new MailData.Attachment();
                att.itemCode = VirtualItemType.CASH.getItemcode();
                att.itemNum = item.ticket;
                mail.attachments.add(att);
            }

            mail.replace = new HashMap<>();
            DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
            mail.replace.put("Item", MessageUtil.itemColorName(itemBase.qcolor, itemBase.name));
            MailUtil.getInstance().sendMailToOnePlayer(item.playerId, (MailData) mail, Const.GOODS_CHANGE_TYPE.AUCTION_RESTITUTION);
        } catch (Exception e) {
            Out.warn(new Object[]{"竞拍归还竞价异常.playerId=", item.playerId, ",diamond=", Integer.valueOf(item.diamond), ",ticket=", Integer.valueOf(item.ticket)});
        }
    }


    public void log(String guildId, String playerId, int type, String itemcode, int price) {
        GuildAuctionLog log = new GuildAuctionLog();
        log.type = type;
        DItemEquipBase itemBase = ItemUtil.getPropByCode(itemcode);
        log.item = new ItemRecordInfo();
        log.item.name = itemBase.name;
        log.item.qColor = itemBase.qcolor;
        log.price = price;
        log.time = LocalDateTime.now().format(DateUtils.F_YYYYMMDDHHMMSS);
        if (StringUtils.isNotEmpty(playerId)) {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
            if (baseData != null) {
                log.player = baseData.name;
            }
        }
        addGuildAuctionLog(guildId, log);
    }

    public void addGuildAuctionLog(String guildId, GuildAuctionLog record) {
        List<GuildAuctionLog> logs = GuildDao.getGuildAuctionLog(guildId);
        synchronized (logs) {
            logs.add(0, record);
            while (logs.size() > 50) {
                logs.remove(logs.size() - 1);
            }
        }
        GuildDao.saveGuildAuctionLog(guildId);
    }
}


