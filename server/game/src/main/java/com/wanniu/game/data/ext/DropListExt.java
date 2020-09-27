package com.wanniu.game.data.ext;

import com.wanniu.game.data.DropListCO;

import java.util.HashMap;
import java.util.Map;


public class DropListExt
        extends DropListCO {
    public int[] weeks;
    public Map<String, Integer> rewardPreview;
    public Map<String, Integer> firstRewardPreview;
    public Map<String, Integer> weekRewardPreview;

    public void initProperty() {
        String[] weeks = this.weekDay.split(",");
        this.weeks = new int[weeks.length];
        for (int i = 0; i < weeks.length; i++) {
            this.weeks[i] = Integer.parseInt(weeks[i]);
            if (this.weeks[i] == 7) {
                this.weeks[i] = 1;
            } else {
                this.weeks[i] = this.weeks[i] + 1;
            }
        }

        String[] rewardPreviewStrs = this.itemView.split(";");
        this.rewardPreview = new HashMap<>();
        for (int j = 0; j < rewardPreviewStrs.length; j++) {

            String str = rewardPreviewStrs[j];
            String[] params = str.split(":");
            String code = params[0];
            int count = Integer.parseInt(params[1]);
            this.rewardPreview.put(code, Integer.valueOf(count));
        }


        String[] firstRewardPreviewStrs = this.firstReward.split(";");
        this.firstRewardPreview = new HashMap<>();
        for (int k = 0; k < rewardPreviewStrs.length; k++) {

            String str = firstRewardPreviewStrs[k];
            String[] params = str.split(":");
            String code = params[0];
            int count = Integer.parseInt(params[1]);
            this.firstRewardPreview.put(code, Integer.valueOf(count));
        }


        String[] weekRewardPreviewStrs = this.weekReward.split(";");
        this.weekRewardPreview = new HashMap<>();
        for (int m = 0; m < weekRewardPreviewStrs.length; m++) {

            String str = weekRewardPreviewStrs[m];
            String[] params = str.split(":");
            String code = params[0];
            int count = Integer.parseInt(params[1]);
            this.weekRewardPreview.put(code, Integer.valueOf(count));
        }
    }


    public boolean isWeek(int week) {
        for (int i = 0; i < this.weeks.length; i++) {
            if (this.weeks[i] == week) {
                return true;
            }
        }
        return false;
    }
}


