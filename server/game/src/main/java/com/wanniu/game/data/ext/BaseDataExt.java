package com.wanniu.game.data.ext;

import com.wanniu.core.common.IntIntPair;
import com.wanniu.game.data.BaseDataCO;

import java.util.ArrayList;
import java.util.List;


public class BaseDataExt
        extends BaseDataCO {
    private IntIntPair[] _initSkills;
    public List<String> list_ExpCode = new ArrayList<>();

    public void initProperty() {
        List<IntIntPair> sl = new ArrayList<>();
        String[] skillsInfo = this.initSkill.split("\\|");
        for (String skillInfo : skillsInfo) {
            String[] params = skillInfo.split(":");
            if (params.length > 1) {
                IntIntPair pair = new IntIntPair();
                pair.first = Integer.parseInt(params[0]);
                pair.second = Integer.parseInt(params[1]);
                sl.add(pair);
            }
        }
        this._initSkills = new IntIntPair[sl.size()];
        this._initSkills = sl.<IntIntPair>toArray(this._initSkills);

        String[] _expCode = this.expCode.split(",");
        for (String par : _expCode) {
            this.list_ExpCode.add(par);
        }
    }


    public IntIntPair[] getInitSkills() {
        return this._initSkills;
    }


    public String getModelStar(int level) {
        return null;
    }


    public int getModelStarPercent(int level) {
        return 0;
    }


    public int getModelStarScenePercent(int level) {
        return 0;
    }
}


