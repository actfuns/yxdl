package com.wanniu.game.request.chat;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;

@GClientEvent("chat.chatHandler.getChatServerIdRequest")
public class GetChatServerIdHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return (PomeloResponse) new ErrorResponse("404");
    }
}


