package com.wanniu.game.request.daily;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.attendance.PlayerAttendance;
import com.wanniu.game.common.Const;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.VitBonusExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.DailyActivityHandler;


@GClientEvent("area.dailyActivityHandler.getDegreeRewardRequest")
public class GetDegreeRewardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            WNPlayer player = (WNPlayer) GetDegreeRewardHandler.this.pak.getPlayer();
            DailyActivityHandler.GetDegreeRewardRequest req = DailyActivityHandler.GetDegreeRewardRequest.parseFrom(GetDegreeRewardHandler.this.pak.getRemaingBytes());


            protected void write() throws IOException {
                DailyActivityHandler.GetDegreeRewardResponse.Builder res = DailyActivityHandler.GetDegreeRewardResponse.newBuilder();
                try {
                    if (null == this.player) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    DailyActivityMgr mgr = this.player.dailyActivityMgr;
                    if (null == mgr) {
                        return;
                    }

                    JSONObject ret = mgr.getReward(this.req.getId());
                    if (0 == ret.getIntValue("result")) {
                        VitBonusExt prop = (VitBonusExt) GameData.VitBonuss.get(Integer.valueOf(this.req.getId()));
                        List<NormalItem> list_items = ItemUtil.createItemsByItemCode(prop.rewards);
                        this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.daily_activity, "Bag_full_common");
                        res.setS2CCode(200);
                        res.setId(this.req.getId());
                        res.setS2CState(PlayerAttendance.GiftState.RECEIVED.getValue());
                        mgr.updateRewardState();
                        mgr.updateSuperScript();
                        this.body.writeBytes(res.build().toByteArray());
                    } else {
                        res.setS2CCode(500);
                        res.setS2CMsg(ret.getString("des"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
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


