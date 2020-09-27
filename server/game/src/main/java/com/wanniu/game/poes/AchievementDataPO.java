package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.data.ArmourAttributeCO;
import com.wanniu.game.data.GameData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@DBTable("player_achieves")
public class AchievementDataPO
        extends GEntity {
    public Map<Integer, AchievePO> achievements = new HashMap<>();

    public List<Integer> receivedAwards = new ArrayList<>();


    public List<Integer> finishedFriendAchievementList = new ArrayList<>();


    public Map<Integer, HolyArmour> holyArmourMap = new HashMap<>();

    public AchievementDataPO() {
        for (ArmourAttributeCO armourAttributeCO : GameData.ArmourAttributes.values()) {
            HolyArmour armour = new HolyArmour(armourAttributeCO.iD);
            this.holyArmourMap.put(Integer.valueOf(armour.id), armour);
        }
    }

    public static class AchievePO {
        public int id;
        public int scheduleCurr;
        public List<String> data;
        public int awardState;
    }

    public static class HolyArmour {
        public int id;
        public int states;

        public HolyArmour() {
        }

        public HolyArmour(int id) {
            this.id = id;
            this.states = 1;
        }
    }
}


