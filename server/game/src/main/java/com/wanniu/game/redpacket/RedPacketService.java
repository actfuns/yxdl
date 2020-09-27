package com.wanniu.game.redpacket;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.GGame;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RedPackageCO;
import com.wanniu.game.data.ext.ScheduleExt;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.poes.MessagePO;
import com.wanniu.game.poes.RedPacketCenterPO;
import com.wanniu.game.util.BlackWordUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pomelo.area.MessageHandler;
import pomelo.chat.ChatHandler;
import pomelo.redpacket.RedPacketHandler;


public class RedPacketService {
    private static RedPacketService redPacketService;
    public RedPacketCenterPO redPacketCenterPO;
    private ScheduleExt scheduleExt;
    private int taskId = 18;

    public static RedPacketService getInstance() {
        if (redPacketService == null) {
            redPacketService = new RedPacketService();
        }
        return redPacketService;
    }

    public void init() {
        this.scheduleExt = (ScheduleExt) GameData.Schedules.get(Integer.valueOf(this.taskId));

        String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value);
        if (data == null) {
            this.redPacketCenterPO = new RedPacketCenterPO();
            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
        } else {

            this.redPacketCenterPO = (RedPacketCenterPO) JSON.parseObject(data, RedPacketCenterPO.class);
        }


        List<RedPacket> rightToRemove = new LinkedList<>();

        synchronized (this.redPacketCenterPO) {
            for (null = this.redPacketCenterPO.redPackets.values().iterator(); null.hasNext(); ) {
                RedPacket redPacket = null.next();
                long leftMili = redPacket.dispatchDate.getTime() + (GlobalConfig.Red_HongbaoTime * 1000 * 60) - System.currentTimeMillis();
                if (leftMili <= 0L) {
                    rightToRemove.add(redPacket);

                    int fetchedNum = 0;
                    for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
                        if (redPacketFetchInfo.fetcherId == null) {
                            fetchedNum += redPacketFetchInfo.num;
                        }
                    }
                    if (redPacket.benifitType == 1) {
                        fetchedNum /= GlobalConfig.Red_HongbaoRatio;
                    }
                    if (fetchedNum > 0) {
                        MailSysData mailData = new MailSysData("RedPackBack");
                        List<MailData.Attachment> list_attach = new ArrayList<>();
                        MailData.Attachment attachment = new MailData.Attachment();
                        attachment.itemCode = VirtualItemType.DIAMOND.getItemcode();
                        attachment.itemNum = fetchedNum;
                        list_attach.add(attachment);
                        mailData.attachments = list_attach;
                        MailUtil.getInstance().sendMailToOnePlayer(redPacket.providerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.RedPacket);
                    }

                    continue;
                }
                String packetId = redPacket.id;
                JobFactory.addDelayJob(() -> {
                    synchronized (this.redPacketCenterPO) {
                        this.redPacketCenterPO.redPackets.remove(packetId);
                    }
                    RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
                    pushBuilder.setS2CCode(200);
                    pushBuilder.setId(packetId);
                    GWorld.getInstance().broadcast((Message) new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage) pushBuilder.build()), GWorld.__SERVER_ID);
                    if (redPacket.providerId != null) {
                        int fetchedNum = 0;
                        for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList)
                            fetchedNum += redPacketFetchInfo.num;
                        if (redPacket.benifitType == 1) fetchedNum /= GlobalConfig.Red_HongbaoRatio;
                        MailSysData mailData = new MailSysData("RedPackBack");
                        List<MailData.Attachment> list_attach = new ArrayList<>();
                        MailData.Attachment attachment = new MailData.Attachment();
                        attachment.itemCode = VirtualItemType.DIAMOND.getItemcode();
                        attachment.itemNum = fetchedNum;
                        list_attach.add(attachment);
                        mailData.attachments = list_attach;
                        MailUtil.getInstance().sendMailToOnePlayer(redPacket.providerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.RedPacket);
                    }
                }leftMili);
            }


            for (RedPacket redPacket : rightToRemove) {
                Out.error(new Object[]{"clear:", redPacket.id, ",", redPacket.providerName, ",", redPacket.dispatchDate});
                this.redPacketCenterPO.redPackets.remove(redPacket.id);
            }

            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
        }


        Map<LocalTime, Integer> slot = new HashMap<>();
        String[] slotStrs = GlobalConfig.Red_Time_Slot.split(";");
        for (String slotSubStr : slotStrs) {
            String[] slotSubStrs = slotSubStr.split(",");
            LocalTime localTime = LocalTime.parse(slotSubStrs[0]);
            int count = Integer.parseInt(slotSubStrs[1]);
            slot.put(localTime, Integer.valueOf(count));
        }

        for (Map.Entry<LocalTime, Integer> entry : slot.entrySet()) {
            LocalTime startTime = entry.getKey();
            LocalDate startDate = LocalDate.now();
            LocalDateTime baseStartDateTime = LocalDateTime.of(startDate, startTime);
            int repeatCount = ((Integer) entry.getValue()).intValue();
            long i;
            for (i = 0L; i < repeatCount; i++) {
                LocalDateTime startDateTime = baseStartDateTime.plusSeconds(i * GlobalConfig.Red_Time_Space);

                if (LocalDateTime.now().isAfter(startDateTime)) {
                    startDateTime = startDateTime.plusDays(1L);
                }
                Duration duration = Duration.between(LocalDateTime.now(), startDateTime);
                long timeOffset = duration.toMillis();
                JobFactory.addFixedRateJob(() -> {
                    String msg = "";
                    int msgCount = GameData.RedPackages.size();
                    if (msgCount >= 1) {
                        int randomMsgId = RandomUtil.getInt(1, msgCount);
                        msg = ((RedPackageCO) GameData.RedPackages.get(Integer.valueOf(randomMsgId))).words;
                    }
                    dispatchRedPacket(null, GlobalConfig.God_Red_Money, GlobalConfig.Red_Time_Number, 0, 1, 1, msg);
                }timeOffset, Const.Time.Day


                        .getValue());
            }
        }
    }


    public RedPacketHandler.GetRedPacketListResponse.Builder getAllRedPackets(String playerId) {
        RedPacketHandler.GetRedPacketListResponse.Builder builder = RedPacketHandler.GetRedPacketListResponse.newBuilder();

        GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);

        synchronized (this.redPacketCenterPO) {
            for (RedPacket redPacket : this.redPacketCenterPO.redPackets.values()) {


                if (redPacket.providerGuildId != null) {
                    if (guildPO == null) {
                        continue;
                    }
                    if (!redPacket.providerGuildId.equals(guildPO.id)) {
                        continue;
                    }
                }

                RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);

                if (redPacketInfoBuilder != null) {
                    builder.addRedPacketInfo(redPacketInfoBuilder);
                }
            }
        }


        builder.setS2CCode(200);
        return builder;
    }


    private RedPacketHandler.RedPacketInfo.Builder getRedPacketInfo(RedPacket redPacket, String playerId) {
        if (playerId != null) {
            GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);

            if (redPacket.providerGuildId != null) {
                if (guildPO == null) {
                    return null;
                }
                if (!redPacket.providerGuildId.equals(guildPO.id)) {
                    return null;
                }
            }
        }


        RedPacketHandler.RedPacketInfo.Builder builder = RedPacketHandler.RedPacketInfo.newBuilder();
        builder.setId(redPacket.id);
        builder.setCount(redPacket.count);
        builder.setTotalNum(redPacket.totalNum);
        builder.setChannelType((redPacket.providerGuildId == null) ? 0 : 1);
        builder.setBenifitType(redPacket.benifitType);
        builder.setFetchType(redPacket.fetchType);

        if (redPacket.providerId != null) {
            builder.setProviderId(redPacket.providerId);
        }

        builder.setProviderName(redPacket.providerName);
        builder.setMessage(redPacket.msg);
        builder.setDispatchTimestamp(redPacket.dispatchDate.getTime());


        for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
            if (redPacketFetchInfo.fetcherId != null) {
                RedPacketHandler.FetcherInfo.Builder fetcherInfoBuilder = RedPacketHandler.FetcherInfo.newBuilder();
                fetcherInfoBuilder.setFetcherId(redPacketFetchInfo.fetcherId);
                fetcherInfoBuilder.setFetcherName(redPacketFetchInfo.fetcherName);
                fetcherInfoBuilder.setFetcherValue(redPacketFetchInfo.num);

                builder.addFetcherList(fetcherInfoBuilder);
            }
        }


        return builder;
    }


    public int dispatchRedPacket(String playerId, int totalNum, int count, int channelType, int fetchType, int benifitType, String msg) {
        WNPlayer player = null;
        GuildPO guildPO = null;
        RedPacket redPacket = null;


        if (playerId != null) {
            player = PlayerUtil.getOnlinePlayer(playerId);
            guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);

            if (totalNum < GlobalConfig.Red_DiamondNumber_Down || totalNum > GlobalConfig.Red_DiamondNumber_Up) {
                return 1;
            }


            if (player.getLevel() < GlobalConfig.Red_SendLevel) {
                return 3;
            }
            if (!player.moneyManager.enoughDiamond(totalNum)) {
                return 4;
            }
            if (channelType == 1 && guildPO == null) {
                return 5;
            }

            player.moneyManager.costDiamond(totalNum, Const.GOODS_CHANGE_TYPE.RedPacket);


            msg = BlackWordUtil.replaceBlackString(msg);


            if (channelType == 0) {
                redPacket = new RedPacket(playerId, player.getName(), null, totalNum, count, fetchType, benifitType, msg);
            } else {

                redPacket = new RedPacket(playerId, player.getName(), guildPO.id, totalNum, count, fetchType, benifitType, msg);

            }

        } else {

            redPacket = new RedPacket(null, LangService.getValue("RED_PACKET_SYS_NAME"), null, totalNum, count, fetchType, benifitType, msg);
        }


        synchronized (this.redPacketCenterPO) {
            this.redPacketCenterPO.redPackets.put(redPacket.id, redPacket);
            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));
        }


        String packetId = redPacket.id;
        RedPacket tempRedpacket = redPacket;
        JobFactory.addDelayJob(() -> {
            synchronized (this.redPacketCenterPO) {
                this.redPacketCenterPO.redPackets.remove(packetId);
            }
            RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
            pushBuilder.setS2CCode(200);
            pushBuilder.setId(packetId);
            GWorld.getInstance().broadcast((Message) new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage) pushBuilder.build()), GWorld.__SERVER_ID);
            if (tempRedpacket.providerId != null) {
                int fetchedNum = 0;
                for (RedPacketFetchInfo redPacketFetchInfo : tempRedpacket.redPacketFetchInfoList) {
                    if (redPacketFetchInfo.fetcherId == null) fetchedNum += redPacketFetchInfo.num;
                }
                if (tempRedpacket.benifitType == 1) fetchedNum /= GlobalConfig.Red_HongbaoRatio;
                if (fetchedNum > 0) {
                    MailSysData mailData = new MailSysData("RedPackBack");
                    List<MailData.Attachment> list_attach = new ArrayList<>();
                    MailData.Attachment attachment = new MailData.Attachment();
                    attachment.itemCode = VirtualItemType.DIAMOND.getItemcode();
                    attachment.itemNum = fetchedNum;
                    list_attach.add(attachment);
                    mailData.attachments = list_attach;
                    MailUtil.getInstance().sendMailToOnePlayer(tempRedpacket.providerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.RedPacket);
                }
            }
        } (GlobalConfig.Red_HongbaoTime * 1000 * 60));


        RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
        pushBuilder.setS2CCode(200);
        RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);
        pushBuilder.setRedPacketInfo(redPacketInfoBuilder);


        MessagePO opts = new MessagePO();
        opts.createPlayerId = "";
        opts.id = "";
        opts.strMsg = null;
        opts.createTime = new Date();
        opts.messageType = Const.MESSAGE_TYPE.redpacket.getValue();
        opts.data = null;
        MessageData message = new MessageData(opts);
        MessageHandler.OnMessageAddPush.Builder onMessageAddPushBuilder = MessageHandler.OnMessageAddPush.newBuilder();
        onMessageAddPushBuilder.setS2CCode(200);
        onMessageAddPushBuilder.setS2CData(message.toJson4PayLoad());


        String chatMsg = LangService.format("RED_PACKET_DISPATCH_MSG", new Object[]{redPacket.providerName});
        if (redPacket.providerId == null) {
            chatMsg = LangService.getValue("RED_PACKET_SYS_MSG");
        }
        ChatHandler.OnChatPush.Builder chatPushBuilder = ChatHandler.OnChatPush.newBuilder();
        chatPushBuilder.setS2CPlayerId("");
        chatPushBuilder.setS2CUid("");
        chatPushBuilder.setS2CContent(chatMsg);
        chatPushBuilder.setS2CSys(1);
        chatPushBuilder.setS2CTime(DateUtil.getDateTime());
        chatPushBuilder.setS2CServerData("{}");
        if (redPacket.providerGuildId == null) {
            chatPushBuilder.setS2CScope(Const.CHAT_SCOPE.WORLD.getValue());
        } else {

            chatPushBuilder.setS2CScope(Const.CHAT_SCOPE.GUILD.getValue());
        }


        for (GPlayer gplayer : GGame.getInstance().getOnlinePlayers().values()) {
            GuildPO gguildPO = GuildServiceCenter.getInstance().getGuildByMemberId(gplayer.getId());
            if (redPacket.providerGuildId != null && (
                    gguildPO == null || !gguildPO.id.equals(redPacket.providerGuildId))) {
                continue;
            }

            gplayer.receive((Message) new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage) pushBuilder.build()));
            gplayer.receive((Message) new MessagePush("area.messagePush.onMessageAddPush", (GeneratedMessage) onMessageAddPushBuilder.build()));
            gplayer.receive((Message) new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage) chatPushBuilder.build()));
        }


        Out.info(new Object[]{"玩家id:", playerId, ",发布了红包id:", redPacket.id, ",totalNum:", Integer.valueOf(redPacket.totalNum), ",count:",
                Integer.valueOf(redPacket.count), ",channelType:", Integer.valueOf(channelType), ",fetchType:",
                Integer.valueOf(redPacket.fetchType), ",benifitType:", Integer.valueOf(redPacket.benifitType)});

        return 0;
    }


    public int fetchRedPacket(String playerId, String redPacketId) {
        GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(playerId);
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        RedPacket redPacket = null;
        RedPacketFetchInfo selectedFetchInfo = null;
        int selectedPos = 0;
        synchronized (this.redPacketCenterPO) {
            redPacket = (RedPacket) this.redPacketCenterPO.redPackets.get(redPacketId);
            if (redPacket == null) {


                return -1;
            }
            List<RedPacketFetchInfo> canFetchList = new LinkedList<>();
            for (RedPacketFetchInfo redPacketFetchInfo : redPacket.redPacketFetchInfoList) {
                if (redPacketFetchInfo.fetcherId != null) {
                    if (redPacketFetchInfo.fetcherId.equals(playerId)) {
                        return -2;
                    }
                    continue;
                }
                canFetchList.add(redPacketFetchInfo);
            }

            if (canFetchList.size() == 0) {
                return -3;
            }
            selectedPos = RandomUtil.random(canFetchList.size());
            selectedFetchInfo = canFetchList.get(selectedPos);


            if ((player.dailyActivityMgr.getTaskInfo(this.taskId)).process >= this.scheduleExt.maxAttend) {
                return -4;
            }
            if (player.getLevel() < GlobalConfig.Red_LootLevel) {
                return -5;
            }
            if (redPacket.providerGuildId != null) {
                if (guildPO == null) {
                    return -6;
                }
                if (!redPacket.providerGuildId.equals(guildPO.id)) {
                    return -7;
                }
            }

            selectedFetchInfo.SetFetcher(playerId, player.getName());

            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.RedPacket.value, JSON.toJSONString(this.redPacketCenterPO));

            switch (redPacket.benifitType) {
                case 0:
                    player.moneyManager.addDiamond(selectedFetchInfo.num, Const.GOODS_CHANGE_TYPE.RedPacket);
                    break;
                case 1:
                    player.moneyManager.addGold(selectedFetchInfo.num, Const.GOODS_CHANGE_TYPE.RedPacket);
                    break;

                default:
                    Out.error(new Object[]{"参数错误"});
                    return -8;
            }

        }
        player.dailyActivityMgr.onEvent(Const.DailyType.RED_PACKET, "0", 1);

        RedPacketHandler.OnRedPacketDispatchPush.Builder pushBuilder = RedPacketHandler.OnRedPacketDispatchPush.newBuilder();
        pushBuilder.setS2CCode(200);
        RedPacketHandler.RedPacketInfo.Builder redPacketInfoBuilder = getRedPacketInfo(redPacket, playerId);
        pushBuilder.setRedPacketInfo(redPacketInfoBuilder);


        for (GPlayer gplayer : GGame.getInstance().getOnlinePlayers().values()) {
            GuildPO gguildPO = GuildServiceCenter.getInstance().getGuildByMemberId(gplayer.getId());
            if (redPacket.providerGuildId != null && (
                    gguildPO == null || !gguildPO.id.equals(redPacket.providerGuildId))) {
                continue;
            }


            gplayer.receive((Message) new MessagePush("redpacket.redPacketPush.onRedPacketDispatchPush", (GeneratedMessage) pushBuilder.build()));


            if (redPacket.fetchType == 0) {
                ChatHandler.OnChatPush.Builder chatPushBuilder = ChatHandler.OnChatPush.newBuilder();
                if (redPacket.providerGuildId == null) {
                    chatPushBuilder = MessageUtil.createChatMsg(player, redPacket.msg, Const.CHAT_SCOPE.WORLD, Const.TipsType.ROLL);
                } else {

                    chatPushBuilder = MessageUtil.createChatMsg(player, redPacket.msg, Const.CHAT_SCOPE.GUILD, Const.TipsType.ROLL);
                }

                gplayer.receive((Message) new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage) chatPushBuilder.build()));
            }
        }


        Out.info(new Object[]{"玩家id:", playerId, ",获得了红包id:", redPacket.id, ",totalNum:", Integer.valueOf(redPacket.totalNum), ",count:",
                Integer.valueOf(redPacket.count), ",红包位置id:", Integer.valueOf(selectedPos), ",fetchType:",
                Integer.valueOf(redPacket.fetchType), ",benifitType:", Integer.valueOf(redPacket.benifitType)});


        return selectedFetchInfo.num;
    }
}


