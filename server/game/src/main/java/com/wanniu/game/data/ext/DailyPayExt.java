package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.DailyPayCO;

import java.util.ArrayList;

public class DailyPayExt
        extends DailyPayCO {
    public int Job;
    public ArrayList<AwardInfo> awards;

    public void initProperty() {
        this.Job = Const.PlayerPro.Value(this.job);
        this.awards = new ArrayList<>();
        if (this.rewardCode1 != null && this.rewardNum1 != 0) {
            AwardInfo awardInfo = new AwardInfo();
            awardInfo.itemCode = this.rewardCode1;
            awardInfo.itemNum = this.rewardNum1;
            this.awards.add(awardInfo);
        }
        if (this.rewardCode2 != null && this.rewardNum2 != 0) {
            AwardInfo awardInfo = new AwardInfo();
            awardInfo.itemCode = this.rewardCode2;
            awardInfo.itemNum = this.rewardNum2;
            this.awards.add(awardInfo);
        }
        if (this.rewardCode3 != null && this.rewardNum3 != 0) {
            AwardInfo awardInfo = new AwardInfo();
            awardInfo.itemCode = this.rewardCode3;
            awardInfo.itemNum = this.rewardNum3;
            this.awards.add(awardInfo);
        }
        if (this.rewardCode4 != null && this.rewardNum4 != 0) {
            AwardInfo awardInfo = new AwardInfo();
            awardInfo.itemCode = this.rewardCode4;
            awardInfo.itemNum = this.rewardNum4;
            this.awards.add(awardInfo);
        }
    }


    public static class AwardInfo {
        public String itemCode;


        public int itemNum;


        public int enchantLv;


        public AwardInfo() {
        }


        public AwardInfo(String itemCode, int itemNum, int enchantLv) {
            this.itemCode = itemCode;
            this.itemNum = itemNum;
            this.enchantLv = enchantLv;
        }
    }
}


