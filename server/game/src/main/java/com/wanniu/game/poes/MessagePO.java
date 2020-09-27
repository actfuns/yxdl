package com.wanniu.game.poes;

import com.wanniu.game.message.MessageData;

import java.util.Date;
import java.util.Map;

public class MessagePO {
    public String id;

    public Date createTime;

    public String createPlayerId;

    public int messageType;

    public Map<String, String> strMsg;

    public MessageData.MessageData_Data data;
}


