package com.wanniu.game.request.guild.guildManager;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.RecordInfo;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.guild.GuildManagerHandler;


@GClientEvent("guild.guildManagerHandler.getDepotRecordRequest")
public class GetDepotRecordHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        GuildManagerHandler.GetDepotRecordRequest req = GuildManagerHandler.GetDepotRecordRequest.parseFrom(this.pak.getRemaingBytes());
        final int page = req.getPage();
        return new PomeloResponse() {
            protected void write() throws IOException {
                GuildManagerHandler.GetDepotRecordResponse.Builder res = GuildManagerHandler.GetDepotRecordResponse.newBuilder();

                GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
                if (null == player.getId() || null == depotManager) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                ArrayList<RecordInfo> recordList = depotManager.getDepotRecordByPlayerId(player.getId(), page);

                List<GuildManagerHandler.RecordInfo> retList = new ArrayList<>();
                for (int i = 0; i < recordList.size(); i++) {
                    RecordInfo tmp = recordList.get(i);
                    if (null != tmp) {


                        GuildManagerHandler.RecordInfo.Builder guildMgrInfo = GuildManagerHandler.RecordInfo.newBuilder();
                        guildMgrInfo.setRole1(GuildCommonUtil.toMgrRoleInfo(tmp.role1.pro, tmp.role1.name));
                        guildMgrInfo.setRole2(GuildCommonUtil.toMgrRoleInfo(tmp.role2.pro, tmp.role2.name));
                        guildMgrInfo.setResultNum(tmp.resultNum);
                        guildMgrInfo.setResultStr(tmp.resultStr);
                        guildMgrInfo.setTime(tmp.time);
                        guildMgrInfo.setRecordType(tmp.recordType);
                        guildMgrInfo.setItem(GuildCommonUtil.toMgrItemRecordInfo(tmp.item.qColor, tmp.item.name));
                        retList.add(guildMgrInfo.build());
                    }
                }
                res.setS2CCode(200);
                res.addAllS2CRecordList(retList);
                res.setS2CPage(page);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


