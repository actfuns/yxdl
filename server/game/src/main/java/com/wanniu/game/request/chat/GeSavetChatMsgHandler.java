package com.wanniu.game.request.chat;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.chat.ChatHandler;


@GClientEvent("chat.chatHandler.getSaveChatMsgRequest")
public class GeSavetChatMsgHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ChatHandler.GetSaveChatMsgRequest req = ChatHandler.GetSaveChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
        int scope = req.getC2SScope();
        String uid = req.getC2SUid();
        int index = req.getC2SIndex();


        return new PomeloResponse() {
            protected void write() throws IOException {
                ChatHandler.GetSaveChatMsgResponse.Builder res = ChatHandler.GetSaveChatMsgResponse.newBuilder();
                res.setS2CCode(200);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


