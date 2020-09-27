package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.data.NpcListCO;

public class NpcListExt
        extends NpcListCO {
    public int id;
    public String type;
    public Limit successArray;
    public Limit failScoldArray;
    public Limit failBattleArray;
    public int totalDrop;

    public static class Limit {
        public int min;
        public int max;
    }

    public void initProperty() {
        this.id = this.npcID;
        this.successArray = new Limit();
        this.failScoldArray = new Limit();
        this.failBattleArray = new Limit();
        if (this.type.indexOf("1") == 0) {
            this.totalDrop = this.sucessDrop + this.failScold + this.failBattle;

            if (this.sucessDrop >= 0) {
                this.successArray.min = 0;
                this.successArray.max = this.sucessDrop;
            } else {
                Out.error(new Object[]{"NpcDataProp 策划数据错误 SucessDrop 配的概率<0,id:", Integer.valueOf(this.id), ",SucessDrop值:", Integer.valueOf(this.sucessDrop), this});
            }

            if (this.failScold >= 0) {
                this.failScoldArray.min = this.successArray.max;
                this.failScoldArray.max = this.failScold;
            } else {
                Out.error(new Object[]{"NpcDataProp 策划数据错误 FailScold 配的概率<0,id:", Integer.valueOf(this.id), ",FailScold值:", Integer.valueOf(this.failScold), this});
            }

            if (this.failBattle >= 0) {
                this.failBattleArray.min = this.failScoldArray.max;
                this.failBattleArray.max = this.failBattle;
            } else {
                Out.error(new Object[]{"NpcDataProp 策划数据错误 FailBattle 配的概率<0 ,id:", Integer.valueOf(this.id), ",FailBattle值:", Integer.valueOf(this.failBattle), this});
            }
        }
    }

    public int steal() {
        int temp = RandomUtil.random(this.totalDrop);
        if (temp >= this.successArray.min && temp < this.successArray.max)
            return 1;
        if (temp >= this.failScoldArray.min && temp < this.failScoldArray.max)
            return 2;
        if (temp >= this.failBattleArray.min && temp < this.failBattleArray.max) {
            return 3;
        }
        return 2;
    }
}


