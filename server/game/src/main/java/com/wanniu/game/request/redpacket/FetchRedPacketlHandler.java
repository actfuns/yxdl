package com.wanniu.game.request.redpacket;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.redpacket.RedPacketService;

import java.io.IOException;

import pomelo.redpacket.RedPacketHandler;


@GClientEvent("redpacket.redPacketHandler.fetchRedPacketRequest")
public class FetchRedPacketlHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        RedPacketHandler.FetchRedPacketRequest req = RedPacketHandler.FetchRedPacketRequest.parseFrom(this.pak.getRemaingBytes());

        String id = req.getId();
        final int result = RedPacketService.getInstance().fetchRedPacket(player.getId(), id);

        if (result > 0) {
            return new PomeloResponse() {
                protected void write() throws IOException {
                    RedPacketHandler.FetchRedPacketResponse.Builder res = RedPacketHandler.FetchRedPacketResponse.newBuilder();
                    res.setS2CCode(200);
                    res.setValue(result);
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
        }


        switch (result) {

            case -1:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_WRONG_ID"));
            case -2:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_FETCHED"));
            case -3:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_FETCHED_OUT"));
            case -4:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_CANNOT_FETCH"));
            case -5:
                return (PomeloResponse) new ErrorResponse(String.format(LangService.getValue("RED_PACKET_LEVEL_NEED"), new Object[]{Integer.valueOf(GlobalConfig.Red_LootLevel)}));
            case -6:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_GUILD"));
            case -7:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_THIS_GUILD"));
        }
        return (PomeloResponse) new ErrorResponse();
    }
}


