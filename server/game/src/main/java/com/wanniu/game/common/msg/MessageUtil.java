package com.wanniu.game.common.msg;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ShowTipUtil;
import com.wanniu.game.data.SocialMessageCO;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.message.SocialMessageConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.HashMap;
import java.util.Map;

import pomelo.chat.ChatHandler;


public final class MessageUtil
        extends ShowTipUtil {
    public static void sendMessage(String playerId, String route, GeneratedMessage data) {
        WNPlayer player = GWorld.getInstance().getPlayer(playerId);
        if (player != null) {
            player.write((Message) new MessagePush(route, data));
        }
    }


    public static void sendRollChat(int logicServerId, String content, Const.CHAT_SCOPE scope) {
        ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
        msg.setS2CPlayerId("");
        msg.setS2CUid("");
        msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
        msg.setS2CScope((scope != null) ? scope.getValue() : Const.CHAT_SCOPE.WORLD.getValue());
        msg.setS2CSys(Const.TipsType.BLACK.getValue());
        msg.setS2CTime(DateUtil.getDateTime());
        msg.setS2CServerData("{}");

        GWorld.getInstance().broadcast((Message) new MessagePush("chat.chatPush.onChatPush", (GeneratedMessage) msg.build()), logicServerId);
    }


    public static void sendSysChat(WNPlayer player, String content) {
        sendSysChat(player, content, Const.TipsType.NORMAL);
    }


    public static void sendSysChat(WNPlayer player, String content, Const.TipsType scroll) {
        sendChatMsgAsyn(player, content, Const.CHAT_SCOPE.SYSTEM, scroll);
    }


    public static void sendChatMsgAsyn(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
        GWorld.getInstance().ansycExec(() -> {
            ChatHandler.OnChatPush.Builder msg = createChatMsg(player, content, scope, scroll);
            player.receive("chat.chatPush.onChatPush", (GeneratedMessage) msg.build());
        });
    }


    public static ChatHandler.OnChatPush.Builder createChatMsg(WNPlayer player, String content, Const.CHAT_SCOPE scope, Const.TipsType scroll) {
        ChatHandler.OnChatPush.Builder msg = ChatHandler.OnChatPush.newBuilder();
        Map<String, Object> serverData = new HashMap<>();
        serverData.put("acceptRoleId", "");
        serverData.put("s2c_level", Integer.valueOf(player.getLevel()));
        serverData.put("s2c_name", (player.getPlayer()).name);
        serverData.put("s2c_pro", Integer.valueOf(player.getPro()));
        serverData.put("s2c_vip", Integer.valueOf(0));
        serverData.put("s2c_zoneId", Integer.valueOf(player.getLogicServerId()));

        msg.setS2CPlayerId((player.getPlayer()).id);

        msg.setS2CUid((player.getPlayer()).uid);
        msg.setS2CContent(StringUtil.isEmpty(content) ? "content is null" : content);
        msg.setS2CScope(scope.getValue());
        msg.setS2CSys(scroll.getValue());
        msg.setS2CTime(DateUtil.getDateTime());
        msg.setS2CServerData(JSON.toJSONString(serverData));
        return msg;
    }


    public static MessageData createMessage(int messageType, String createPlayerId, MessageData.MessageData_Data data) {
        return createMessage(messageType, createPlayerId, data, null);
    }

    public static MessageData createMessage(int messageType, String createPlayerId, MessageData.MessageData_Data data, Map<String, String> strMsg) {
        MessageData opts = new MessageData();
        opts.messageType = messageType;
        opts.createPlayerId = createPlayerId;
        opts.strMsg = strMsg;
        opts.data = data;
        opts.init();
        return opts;
    }


    public static int getSendLimit(int messageType) {
        SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(messageType);
        int limit = 0;
        if (socialMessageProp != null) {
            limit = socialMessageProp.sendLimite;
        }
        return limit;
    }


    public static int getReceiveLimit(int messageType) {
        SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(messageType);
        int limit = 0;
        if (socialMessageProp != null) {
            limit = socialMessageProp.receiveLimite;
        }
        return limit;
    }


    public static boolean sendMessageToPlayer(MessageData message, String playerId) {
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player != null) {
            return player.messageManager.addReceivedMessage(message);
        }
        return true;
    }


    public static void deleteSendedPlayerMessage(MessageData message) {
        String playerId = message.createPlayerId;
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player != null)
            player.messageManager.deleteSendedMessage(message.messageType, message.id);
    }
}


