package com.wanniu.game.message;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.data.SocialMessageCO;
import com.wanniu.game.poes.MessagePO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import pomelo.area.MessageHandler;

public class MessageData {
    public String id;
    public int messageType;
    public String createPlayerId;

    public static class MessageData_Data {
    }

    public static class MessageData_Team
            extends MessageData_Data {
        public String applyId;
        public String name;
        public String teamId;
    }

    public static class MessageData_DaoYou
            extends MessageData_Data {
        public String fromPlayerId;
        public String fromPlayerName;
    }

    public static class MessageData_Team_InviteId
            extends MessageData_Data {
        public String inviteId;
    }

    public static class MessageData_Team_apply
            extends MessageData_Data {
        public String teamId;
        public String applyId;
        public String name;
    }

    public static class MessageData_Quest
            extends MessageData_Data {
        public int finishCount;
    }

    public static class MessageData_Consignment
            extends MessageData_Data {
        public String id;
        public int num1;
        public int num2;
    }

    public Map<String, String> strMsg = new HashMap<>();

    public MessageData_Data data;
    public long validTime;
    public String strMsgToClient;
    public int HUDTime;
    private static final AtomicLong UUID = new AtomicLong(System.nanoTime());

    public MessageData() {
        this.id = String.valueOf(UUID.incrementAndGet());
    }

    public MessageData(MessagePO opts) {
        if (opts != null) {
            this.id = opts.id;
            this.messageType = opts.messageType;
            this.createPlayerId = opts.createPlayerId;
            this.strMsg = opts.strMsg;
            this.data = opts.data;
            init();
        }
    }

    public final void init() {
        SocialMessageCO socialMessageProp = SocialMessageConfig.getInstance().findMessageByMessageType(this.messageType);
        if (socialMessageProp == null) {
            Out.error(new Object[]{"there is no prop in socialMessageProp messageType:" + this.messageType});
            return;
        }
        this.validTime = -1L;
        this.strMsgToClient = socialMessageProp.messageText;
        if (this.strMsg != null) {
            for (Map.Entry<String, String> node : this.strMsg.entrySet()) {
                this.strMsgToClient = this.strMsgToClient.replace("{" + (String) node.getKey() + "}", node.getValue());
            }
        }
        this.validTime = System.currentTimeMillis() + (socialMessageProp.messageTime * 1000);
        this.HUDTime = socialMessageProp.hUDTime;
    }


    public final int getMessageType() {
        return this.messageType;
    }


    public final boolean isPastDue() {
        if (this.validTime == -1L) {
            return false;
        }
        boolean isClearByNewDay = isClearByNewDay();
        if (isClearByNewDay) {
            return false;
        }
        return (GWorld.APP_TIME > this.validTime);
    }

    public final boolean isClearByNewDay() {
        return (this.validTime == 0L);
    }

    public final MessageHandler.Message toJson4PayLoad() {
        MessageHandler.Message.Builder build = MessageHandler.Message.newBuilder();
        build.setId(this.id);
        build.setMessageType(this.messageType);
        build.setRemainTime(this.HUDTime);
        build.setStrMsg((null != this.strMsgToClient) ? this.strMsgToClient : "");
        return build.build();
    }
}


