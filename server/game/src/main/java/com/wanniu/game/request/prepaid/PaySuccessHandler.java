package com.wanniu.game.request.prepaid;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.pay.request.PayHandler;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.prepaid.PrepaidService;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;


public class PaySuccessHandler
        extends PayHandler {
    public void execute(Packet pak) {
        final long key = pak.getLong();
        JSONObject json = JSON.parseObject(pak.getString());
        String orderId = json.getString("orderId");


        String playerId = json.getString("playerId");
        if (StringUtils.isNotEmpty(playerId)) {
            int productId = json.getIntValue("productId");
            PrepaidService.getInstance().onSimulationOrder(orderId, playerId, productId);
        }

        PrepaidService.getInstance().onPaySuccess(orderId);

        pak.getSession().writeAndFlush(new Message() {
            protected void write() throws IOException {
                this.body.writeLong(key);
                this.body.writeString("success");
            }


            public short getType() {
                return 245;
            }
        });
    }


    public short getType() {
        return 245;
    }
}


