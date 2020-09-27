package com.wanniu.game.data.base;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class MapBase {
    public int mapID;
    public String name;
    public int templateID;
    public int type;
    public String monsterHard;
    public int hardModel;
    public int dungeonTab;
    public int dungeonShow;
    public int allowedPlayers;
    public int allowedPet;
    public int autoReset;
    public int mapTypeID;
    public int defaultTimes;
    public int maxPurchase;
    public String bonusViewTC;
    public int adCombatPower;
    public int race;
    public int isSafe;
    public int pktype;
    public int changePKtype;
    public int ignorePkRule;
    public int canBeTrans;
    public int mapLevel;
    public int disConnToMapID;
    public int revivedMapID;
    public int fullPlayers;
    public int maxPlayers;
    public int lifeTime;
    public int boundary;
    public int reqLevel;
    public int reqUpLevel;
    public int levellimit;
    public int upLevellimit;
    public int reqVip;
    public int reqQuestId;
    public int allowedRace;
    public String reqState;
    public int stateValue;
    public int openRule;
    public String openDate;
    public String beginTime;
    public String endTime;
    public int closedToMapID;
    public String reqItemCode;
    public int reqItemCount;
    public int reduceItemCount;
    public int allowedTransfer;
    public String costItem;
    public int costItemNum;
    public int costGold;
    public int randChestChance;
    public int maxRandChest;
    public String randChestTC;
    public String sceneSmallMap;
    public String mapDesc;
    public String mapPic;
    public String connect;
    public int isChange;
    public int distribution;
    public int autoFight;
    public int useAgent;
    public int rideMount;
    public int takePet;
    public int revival;
    public int recovery;
    public int changePetAI;
    public int petAI;
    public int isSweep;
    public String monsterInfo;
    public int bossInfoShow;
    public int teamTips;
    public int qcolor;
    public int allowedPlayersMix;
    public int allowedPlayersMax;
    public String bossPic;
    public int fcValue;
    public int timeCount;
    public int leaveToMapID;
    public Map<String, Integer> toPath;
    public Map<Integer, float[]> toAreaXY;
    public Map<String, float[]> toPathXY;
    public List<Integer> OpenDate;
    public Map<Integer, Integer> m_monsterInfo;

    public int getKey() {
        return this.mapID;
    }


    public void beforeProperty() {
    }


    public void initProperty() {
        this.m_monsterInfo = new HashMap<>();
        this.toPath = new HashMap<>();
        this.toPathXY = (Map) new HashMap<>();
        this.toAreaXY = (Map) new HashMap<>();
        if (!StringUtil.isEmpty(this.connect)) {
            String[] connectStrs = this.connect.split(";");
            for (String connectStr : connectStrs) {
                if (!StringUtil.isEmpty(connectStr)) {
                    String[] data = connectStr.split(":");
                    int areaId = Integer.parseInt(data[0]);
                    this.toPath.put(data[1], Integer.valueOf(areaId));
                    if (data.length > 2) {
                        String[] xys = data[2].split(",");
                        float[] xy = new float[2];
                        xy[0] = Float.valueOf(xys[0]).floatValue();
                        xy[1] = Float.valueOf(xys[1]).floatValue();
                        this.toPathXY.put(data[1], xy);
                        this.toAreaXY.put(Integer.valueOf(areaId), xy);
                    }
                }
            }
        }

        if (this.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
            String[] openDays = this.openDate.split(",");
            if (openDays.length > 0) {
                this.OpenDate = new ArrayList<>();
                for (int i = 0; i < openDays.length; i++) {
                    this.OpenDate.add(Integer.valueOf(Integer.parseInt(openDays[i])));
                }

                int index = this.OpenDate.indexOf(Integer.valueOf(7));
                if (index >= 0) {
                    this.OpenDate.set(index, Integer.valueOf(0));
                }
            }
        }

        if (this.lifeTime > 300) {
            Out.warn(new Object[]{"sceneProp lifeTime is inValid, it should be between 0 and 300 mapId:", Integer.valueOf(this.mapID), " lifeTime:", Integer.valueOf(this.lifeTime)});
        } else if (this.lifeTime == 0) {
            this.lifeTime = 300;
        }

        boolean valid = false;
        for (Const.SCENE_TYPE sceneType : Const.SCENE_TYPE.values()) {
            if (this.type == sceneType.getValue()) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            Out.error(new Object[]{"sceneProp Type value inValid, mapId:", Integer.valueOf(this.mapID)});
        }


        if (!StringUtil.isEmpty(this.monsterInfo)) {

            int dungeonIdAdd = 0;

            if (this.hardModel == 2) {
                dungeonIdAdd = 10000;
            } else if (this.hardModel == 3) {
                dungeonIdAdd = 20000;
            }

            String[] datas = this.monsterInfo.split(";");
            for (String data : datas) {
                String[] as = data.split(":");

                if (as.length > 1) {
                    this.m_monsterInfo.put(Integer.valueOf(Integer.parseInt(as[0]) + dungeonIdAdd), Integer.valueOf(Integer.parseInt(as[1])));
                }
            }
        }
    }
}


