package com.wanniu.game.solo;

import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.area.MonsterUnit;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SoloMonsterCO;
import com.wanniu.game.data.SoloRankCO;

import java.util.Date;


public class SoloUtil {
    public static int calRankScore(int rankId, int starPoint, Date rankGotTime) {
        int maxRankStar = 10;


        int rankValue = rankId * (maxRankStar + 1) + starPoint;

        int timeValue = (int) (Math.pow(2.0D, 32.0D) - 1.0D - Math.floor((rankGotTime.getTime() / 1000L)));

        return (int) (rankValue * Math.pow(2.0D, 32.0D) + timeValue);
    }


    public static int getRankStar(int rankId) {
        SoloRankCO prop = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(rankId));

        return 0;
    }

    public static int diffDays(Date t1, Date t2) {
        long diff = t2.getTime() - t1.getTime();
        return (int) (diff / 86400000L);
    }


    public static SoloMonsterCO getSoloMonsterPropByPro(int pro) {
        int size = GameData.SoloMonsters.size();
        SoloMonsterCO robot = null;
        while (robot == null || robot.availably == 0) {
            robot = (SoloMonsterCO) GameData.SoloMonsters.get(Integer.valueOf(RandomUtil.getInt(size)));
        }
        return robot;
    }

    public static MonsterUnit getRobot(int pro) {
        SoloMonsterCO soloProp = getSoloMonsterPropByPro(pro);
        String startPoint = String.valueOf(soloProp.startPoint);

        MonsterUnit monsterData = new MonsterUnit();
        monsterData.id = soloProp.monID;
        monsterData.force = Const.AreaForce.FORCEB.value;
        monsterData.flag = startPoint;
        monsterData.autoGuard = true;

        return monsterData;
    }
}


