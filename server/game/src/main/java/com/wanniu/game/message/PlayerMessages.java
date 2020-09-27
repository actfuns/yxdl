package com.wanniu.game.message;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sysSet.SysSetFlag;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.MessageHandler;


public class PlayerMessages {
    private WNPlayer player;
    public Map<Integer, Map<String, MessageData>> sendedMessages;
    public Map<Integer, Map<String, MessageData>> receivedMessages;

    public PlayerMessages(WNPlayer player) {
        this.player = player;
        this.sendedMessages = new ConcurrentHashMap<>();
        this.receivedMessages = new ConcurrentHashMap<>();
    }


    public final MessageData getReceivedMessage(int type, String messageId) {
        Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(type));
        if (messages != null) {
            MessageData message = messages.get(messageId);
            if (message != null && !message.isPastDue()) {
                return message;
            }
            return null;
        }

        return null;
    }


    public final boolean addSendedMessage(MessageData message) {
        if (message != null && !message.isPastDue()) {
            int count = clearPastDueMessages(false, message.messageType);

            int sendLimit = MessageUtil.getSendLimit(message.getMessageType());
            if (sendLimit > 0 && count >= sendLimit) {
                return false;
            }

            Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(message.messageType));
            if (messages == null) {
                messages = new ConcurrentHashMap<>();
                this.sendedMessages.put(Integer.valueOf(message.messageType), messages);
            }
            messages.put(message.id, message);
        }
        return true;
    }

    public final int getSendedMessageLengthByType(int type) {
        Map<String, MessageData> messages = getSendedMessageByType(type);
        int count = 0;
        if (messages != null) {
            count += messages.size();
        }
        return count;
    }

    public final Map<String, MessageData> getSendedMessageByType(int type) {
        clearPastDueMessages(false, type);
        Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(type));
        if (messages != null) {
            return messages;
        }
        return new ConcurrentHashMap<>();
    }

    public final boolean addReceivedMessage(MessageData message) {
        if (message != null && !message.isPastDue()) {
            Out.debug(new Object[]{"message data:", message});
            if (message.messageType == Const.MESSAGE_TYPE.team_invite.getValue() && !this.player.sysSetManager.isPermission(SysSetFlag.teamInviteSet)) {
                String msg = LangService.format("TEAM_REFUSE", new Object[]{this.player.getName()});
                PlayerUtil.sendSysMessageToPlayer(msg, message.createPlayerId, null);
                MessageUtil.deleteSendedPlayerMessage(message);
            } else {
                if ((message.messageType == Const.MESSAGE_TYPE.team_invite.getValue() && this.player.getTeamManager().isAcceptAutoTeam()) || (message.messageType == Const.MESSAGE_TYPE.team_apply.getValue() && this.player.getTeamManager().isAutoTeam())) {
                    return this.player.getTeamManager().onMessage(message.messageType, Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue(), message.id);
                }
                int count = clearPastDueMessages(true, message.messageType);
                if (count < Const.MESSAGE.MAX_COUNT.getValue()) {
                    if (message.messageType != Const.MESSAGE_TYPE.team_invite.getValue() && message.messageType != Const.MESSAGE_TYPE.team_invite.getValue()) {
                        Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(message.messageType));
                        if (messages == null) {
                            messages = new ConcurrentHashMap<>();
                            this.receivedMessages.put(Integer.valueOf(message.messageType), messages);
                        }
                        messages.put(message.id, message);
                    }
                    MessageHandler.OnMessageAddPush.Builder builder = MessageHandler.OnMessageAddPush.newBuilder();
                    builder.setS2CCode(200);
                    builder.setS2CData(message.toJson4PayLoad());
                    this.player.receive("area.messagePush.onMessageAddPush", (GeneratedMessage) builder.build());
                    return true;
                }
            }

        }
        return false;
    }

    public final void deleteReceivedMessage(int type, String id) {
        Map<String, MessageData> messages = this.receivedMessages.get(Integer.valueOf(type));
        if (messages != null) {
            messages.remove(id);
            this.receivedMessages.put(Integer.valueOf(type), messages);
        }
    }

    public final void deleteSendedMessage(int type, String id) {
        Map<String, MessageData> messages = this.sendedMessages.get(Integer.valueOf(type));
        if (messages != null) {
            messages.remove(id);
            this.sendedMessages.put(Integer.valueOf(type), messages);
        }
    }


    public final int clearPastDueMessages(boolean isReceived, int type) {
        Map<Integer, Map<String, MessageData>> messageAll = isReceived ? this.receivedMessages : this.sendedMessages;
        if (messageAll == null) {
            return 0;
        }
        Map<String, MessageData> messages = messageAll.get(Integer.valueOf(type));
        int count = 0;
        if (messages != null) {
            for (Map.Entry<String, MessageData> node : messages.entrySet()) {
                MessageData message = node.getValue();
                if (message.isPastDue()) {
                    messages.remove(node.getKey());
                    continue;
                }
                count++;
            }
        }

        return count;
    }


    public final void refreshNewDay() {
        _clearNewDayPastDueMessages(true);
        _clearNewDayPastDueMessages(false);
    }


    public final void _clearNewDayPastDueMessages(boolean isReceived) {
        Map<Integer, Map<String, MessageData>> messageAll = isReceived ? this.receivedMessages : this.sendedMessages;
        if (messageAll == null)
            return;
        for (Map.Entry<Integer, Map<String, MessageData>> node : messageAll.entrySet()) {
            Map<String, MessageData> messages = node.getValue();
            for (Map.Entry<String, MessageData> message : messages.entrySet()) {
                if (((MessageData) message.getValue()).isClearByNewDay()) {
                    messages.remove(message.getKey());
                }
            }
            messageAll.put(node.getKey(), messages);
        }
        if (isReceived) {
            this.receivedMessages = messageAll;
        } else {
            this.sendedMessages = messageAll;
        }
    }
}


