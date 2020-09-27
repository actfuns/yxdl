package com.wanniu.game.guild.guildFort;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import pomelo.chat.ChatHandler;


public class GuildFortUtil {
    public static void mailToAllGuildManagerWhenBidBegin() {
        List<String> playerIds = GuildUtil.getMemberIds(new Const.GuildJob[]{Const.GuildJob.PRESIDENT, Const.GuildJob.VICE_PRESIDENT});
        MailSysData mailData = new MailSysData("GuildFortNotifyBidBegin");
        mailData.replace = new HashMap<>();
        mailData.replace.put("begintime", GuildFortService.getInstance().getBattleBeginTimeString());
        mailData.replace.put("endtime", GuildFortService.getInstance().getBattleEndTimeString());

        MailUtil.getInstance().sendMailToSomePlayer(playerIds.<String>toArray(new String[playerIds.size()]), (MailData) mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
    }


    public static void pushRedPointToAll() {
        for (GPlayer gPlayer : PlayerUtil.getAllOnlinePlayer()) {
            ((WNPlayer) gPlayer).guildFortManager.pushRedPoint();
        }
    }

    public static void pushRedPoint(Set<String> players) {
        for (String playerId : players) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null) {
                player.guildFortManager.pushRedPoint();
            }
        }
    }


    public static void sendRollTipsToAllAnsy(String msg) {
        sendRollTipsToAllAsyn(msg, Const.CHAT_SCOPE.WORLD);
    }


    public static void sendRollTipsToAllAsyn(String msg, Const.CHAT_SCOPE scope) {
        GWorld.getInstance().ansycExec(() -> {
            for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                WNPlayer wp = (WNPlayer) p;
                MessageUtil.sendSysTip(wp, msg, Const.TipsType.ROLL);
                sendChatMsg(wp, msg, scope, Const.TipsType.BLACK);
            }
        });
    }


    public static void sendRollTipsAsyn(Set<String> playerIds, String msg, Const.CHAT_SCOPE scope) {
        GWorld.getInstance().ansycExec(() -> {
            for (String playerId : playerIds) {
                WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
                if (player != null) {
                    if (scope == Const.CHAT_SCOPE.SYSTEM || scope == Const.CHAT_SCOPE.WORLD) {
                        MessageUtil.sendSysTip(player, msg, Const.TipsType.ROLL);
                    }
                    sendChatMsg(player, msg, scope, Const.TipsType.BLACK);
                }
            }
        });
    }

    private static void sendChatMsg(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
        ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
        msg.setS2CPlayerId((player.getPlayer()).id);
        msg.setS2CUid((player.getPlayer()).uid);
        msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
        msg.setS2CScope(scope.getValue());
        msg.setS2CSys(scroll.getValue());
        msg.setS2CTime(DateUtil.getDateTime());


        msg.setS2CServerData("{}");

        player.receive("chat.chatPush.onChatPush", (GeneratedMessage) msg.build());
    }
}


