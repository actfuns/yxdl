package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.RecordInfo;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getBlessRecordRequest")
public class GetBlessRecordHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildManagerHandler.GetBlessRecordRequest req = GuildManagerHandler.GetBlessRecordRequest.parseFrom(this.pak.getRemaingBytes());
        final int page = req.getPage();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetBlessRecordResponse.Builder res = GuildManagerHandler.GetBlessRecordResponse.newBuilder();

                GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
                if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                List<RecordInfo> recordList = blessManager.getBlessRecordByPlayerId(player.getId(), page);
                List<GuildManagerHandler.RecordInfo> managerRecordList = new ArrayList<>();
                for (int i = 0; i < recordList.size(); i++) {
                    RecordInfo tmpInfo = recordList.get(i);
                    GuildManagerHandler.RecordInfo.Builder rInfo = GuildManagerHandler.RecordInfo.newBuilder();
                    GuildManagerHandler.RoleInfo role1 = GuildCommonUtil.toGuildMgrHandler(((RecordInfo) recordList.get(i)).role1);
                    GuildManagerHandler.RoleInfo role2 = GuildCommonUtil.toGuildMgrHandler(((RecordInfo) recordList.get(i)).role2);
                    if (null != role1) {
                        rInfo.setRole1(role1);
                    }

                    if (null != role2) {
                        rInfo.setRole2(role2);
                    }

                    rInfo.setResultNum(tmpInfo.resultNum);
                    rInfo.setResultStr(tmpInfo.resultStr);
                    rInfo.setTime(tmpInfo.time);
                    rInfo.setRecordType(tmpInfo.recordType);
                    GuildManagerHandler.ItemRecordInfo.Builder itemRecord = GuildManagerHandler.ItemRecordInfo.newBuilder();
                    itemRecord.setQColor(tmpInfo.item.qColor);
                    itemRecord.setName(tmpInfo.item.name);
                    rInfo.setItem(itemRecord.build());
                    managerRecordList.add(rInfo.build());
                }
                res.setS2CCode(200);
                res.addAllS2CRecordList(managerRecordList);
                res.setS2CPage(page);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


