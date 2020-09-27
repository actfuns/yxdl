package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.AchievementConfigCO;

import java.util.HashMap;
import java.util.Map;


public class AchievementConfigExt
        extends AchievementConfigCO {
    public int id;
    public String name;
    public Const.ACHIEVEMENT_TYPE _type;
    public int beloneId;
    public Map<String, Integer> awards;

    public void initProperty() {
        this.id = this.typeId;
        this.name = this.type;

        if (this.id == 0) {
            this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_ALL;
            this.beloneId = 0;
        } else if ((int) Math.floor((this.id % 10)) == 0) {
            this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_MAIN;
            this.beloneId = this.id;
        } else {
            this._type = Const.ACHIEVEMENT_TYPE.ACHIEVEMENT_TYPE_SUB;
            this.beloneId = (int) (Math.floor((this.id / 10)) * 10.0D);
        }

        this.awards = new HashMap<>();
        String[] items = this.awardKey.split(",");
        for (String item : items) {
            String[] codenum = item.split(":");
            this.awards.put(codenum[0], Integer.valueOf(Integer.parseInt(codenum[1])));
        }
    }
}


