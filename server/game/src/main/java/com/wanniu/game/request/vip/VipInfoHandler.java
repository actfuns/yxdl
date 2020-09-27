package com.wanniu.game.request.vip;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.VipHandler;


@GClientEvent("area.vipHandler.vipInfoRequest")
public class VipInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) VipInfoHandler.this.pak.getPlayer();
                VipHandler.VipResponse.Builder res = VipHandler.VipResponse.newBuilder();
                res.setS2CCode(200);
                VipHandler.VipGiftInfo.Builder info_month = VipHandler.VipGiftInfo.newBuilder();
                info_month.setType(Const.VipType.month.value);
                boolean flag = false;
                if (player.vipManager.po.lastMonthRewardDate != null &&
                        DateUtil.isToday(player.vipManager.po.lastMonthRewardDate)) {
                    flag = true;
                }
                info_month.setFlag(flag ? 1 : 0);
                res.addDatas(info_month);

                VipHandler.VipGiftInfo.Builder info_forever = VipHandler.VipGiftInfo.newBuilder();
                info_forever.setType(Const.VipType.forever.value);
                flag = false;
                if (player.vipManager.po.lastForeverRewardDate != null &&
                        DateUtil.isToday(player.vipManager.po.lastForeverRewardDate)) {
                    flag = true;
                }
                info_forever.setFlag(flag ? 1 : 0);
                res.addDatas(info_forever);
                res.setS2CRemainTime(player.vipManager.getVipRemainTime());

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


