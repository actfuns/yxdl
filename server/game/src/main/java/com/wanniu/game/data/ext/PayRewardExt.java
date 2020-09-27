package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.PayRewardCO;
import com.wanniu.game.mail.data.MailData;

import java.util.ArrayList;


public class PayRewardExt
        extends PayRewardCO {
    public RefreshTime RefreshTime;
    public ArrayList<MailData.Attachment> RankReward;

    public void initProperty() {
        this.RankReward = new ArrayList<>();

        if (StringUtil.isNotEmpty(this.payReward)) {
            String[] rewards = this.payReward.split(";");
            for (int i = 0; i < rewards.length; i++) {
                String[] rw = rewards[i].split(":");
                if (rw.length == 2) {
                    MailData.Attachment item = new MailData.Attachment();
                    item.itemCode = rw[0];
                    item.itemNum = Integer.parseInt(rw[1]);
                    this.RankReward.add(item);
                }
            }
        }

        if (StringUtil.isNotEmpty(this.payRefreshDay)) {
            String[] day = this.payRefreshDay.split("-");
            if (day.length == 2) {
                this.RefreshTime = new RefreshTime();
                this.RefreshTime.Year = Integer.parseInt(day[0]);
                this.RefreshTime.Month = Integer.parseInt(day[1]);
            }
        }
    }

    public static class RefreshTime {
        public int Year;
        public int Month;
    }
}


