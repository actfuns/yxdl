package com.wanniu.game.request.auction;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.guild.dao.GuildDao;
import com.wanniu.game.guild.guidDepot.GuildAuctionLog;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import pomelo.auction.AuctionHandler;


@GClientEvent("auction.auctionHandler.auctionLogRequest")
public class AuctionLogHandle
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String guildId = player.guildManager.getGuildId();
        if (StringUtils.isEmpty(guildId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                AuctionHandler.AuctionLogResponse.Builder response = AuctionHandler.AuctionLogResponse.newBuilder();

                for (GuildAuctionLog log : GuildDao.getGuildAuctionLog(guildId)) {
                    AuctionHandler.AuctionLog.Builder builder = AuctionHandler.AuctionLog.newBuilder();
                    builder.setId(log.type);
                    builder.setItem(MessageUtil.itemColorName(log.item.qColor, log.item.name));
                    builder.setTime(log.time);
                    builder.setNum(log.price);
                    if (StringUtils.isNotEmpty(log.player)) {
                        builder.setRole1(log.player);
                    }
                    response.addS2CLog(builder);
                }

                response.setS2CCode(200);
                this.body.writeBytes(response.build().toByteArray());
            }
        };
    }
}


