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


@GClientEvent("redpacket.redPacketHandler.dispatchRedPacketRequest")
public class DispatchRedPacketlHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        RedPacketHandler.DispatchRedPacketRequest req = RedPacketHandler.DispatchRedPacketRequest.parseFrom(this.pak.getRemaingBytes());
        int count = req.getCount();
        int totalNum = req.getTotalNum();
        int channelType = req.getChannelType();
        int fetchType = req.getFetchType();
        int benifitType = req.getBenifitType();
        String msg = req.getMessage();
        int result = RedPacketService.getInstance().dispatchRedPacket(player.getId(), totalNum, count, channelType, fetchType, benifitType, msg);
        switch (result) {
            case 0:
                return new PomeloResponse() {
                    protected void write() throws IOException {
                        RedPacketHandler.DispatchRedPacketResponse.Builder res = RedPacketHandler.DispatchRedPacketResponse.newBuilder();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                    }
                };

            case 1:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_TOTAL_NUM_BIGGER_OR_SMALLER"));
            case 2:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_COUNT_BIGGER_OR_SMALLER"));
            case 3:
                return (PomeloResponse) new ErrorResponse(String.format(LangService.getValue("RED_PACKET_LEVEL_NEED"), new Object[]{Integer.valueOf(GlobalConfig.Red_SendLevel)}));
            case 4:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_NOT_ENOUGH_DIAMOND"));
            case 5:
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_GUILD"));
        }
        return (PomeloResponse) new ErrorResponse();
    }
}


