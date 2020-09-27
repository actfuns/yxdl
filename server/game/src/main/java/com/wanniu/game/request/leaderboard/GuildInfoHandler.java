package com.wanniu.game.request.leaderboard;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.GuildLevelCO;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.poes.GuildPO;

import java.io.IOException;

import pomelo.area.LeaderBoardHandler;


@GClientEvent("area.leaderBoardHandler.guildInfoRequest")
public class GuildInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final LeaderBoardHandler.GuildInfoRequest req = LeaderBoardHandler.GuildInfoRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                LeaderBoardHandler.GuildInfoResponse.Builder res = LeaderBoardHandler.GuildInfoResponse.newBuilder();
                try {
                    String guildId = req.getC2SGuildId();
                    GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
                    if (null != guild) {
                        GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
                        int maxMember = (null != prop) ? prop.member : 1;
                        LeaderBoardHandler.RankGuildInfo.Builder data = LeaderBoardHandler.RankGuildInfo.newBuilder();
                        data.setGuildId(guild.id);
                        data.setGuildIcon(guild.icon);
                        data.setGuildMaster(guild.presidentName);
                        data.setGuildMasterPro(guild.presidentPro);
                        data.setGuildLevel(guild.level);
                        data.setCurMember(GuildUtil.getGuildMemberCount(guild.id));
                        data.setMaxMember(maxMember);
                        data.setFund((int) guild.sumFund);
                        data.setNotice(guild.notice);

                        res.setS2CCode(200);
                        res.setS2CData(data.build());
                        this.body.writeBytes(res.build().toByteArray());
                    } else {
                        res.setS2CCode(200);
                        res.setS2CMsg(LangService.getValue("GUILD_NOT_EXIST"));
                        this.body.writeBytes(res.build().toByteArray());
                    }
                } catch (Exception err) {
                    Out.error(new Object[]{err});
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


