package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.GWorld;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.data.ext.SkinListExt;
import com.wanniu.game.leaderBoard.LeaderBoardProto;
import com.wanniu.game.rank.RankType;
import com.wanniu.gm.GMErrorResponse;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.HashMap;
import java.util.Map;

import pomelo.area.LeaderBoardHandler;


@GMEvent
public class RankHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        int type = arr.getInteger(0).intValue();
        int subType = arr.getInteger(1).intValue();

        RankType kind = RankType.FIGHTPOWER;
        if (type == 0) {
            switch (subType) {
                case 0:
                    kind = RankType.FIGHTPOWER;
                    break;
                case 1:
                    kind = RankType.LEVEL;
                    break;
                case 2:
                    kind = RankType.Mount;
                    break;
                case 3:
                    kind = RankType.PET;
                    break;
                case 4:
                    kind = RankType.XIANYUAN;
                    break;
                case 5:
                    kind = RankType.DEMON_TOWER;
                    break;
                case 6:
                    kind = RankType.HP;
                    break;
                case 7:
                    kind = RankType.PHY;
                    break;
                case 8:
                    kind = RankType.MAGIC;
                    break;
            }


        } else if (type == 1) {
            if (subType == 0) {
                kind = RankType.GUILD_LEVEL;
            } else if (subType == 1) {
                kind = RankType.GUILD_FORT;
            }
        } else if (type == 2) {
            if (subType == 0) {
                kind = RankType.SOLO_SCORE;
            } else if (subType == 1) {
                kind = RankType.PVP_5V5;
            } else if (subType == 2) {
                kind = RankType.ARENA_SCOREALL;
            }
        }
        LeaderBoardProto result = kind.getHandler().getRankData(GWorld.__SERVER_ID, -1, "");
        if (result == null) {
            return (GMResponse) new GMErrorResponse();
        }

        JSONArray jaData = new JSONArray();
        for (LeaderBoardHandler.LeaderBoardData leaderBoardData : result.s2c_lists) {
            JSONArray ja = new JSONArray();
            for (int i = 0; i < leaderBoardData.getContentsCount(); i++) {
                if (i == 2) {
                    CharacterExt p = (CharacterExt) GameData.Characters.get(Integer.valueOf(Integer.parseInt(leaderBoardData.getContents(i))));
                    ja.add((p == null) ? "" : p.proName);

                } else if (kind.equals(RankType.Mount) && i == 6) {
                    SkinListExt skin = (SkinListExt) GameData.SkinLists.get(Integer.valueOf(Integer.parseInt(leaderBoardData.getContents(i))));
                    ja.add((skin == null) ? "" : skin.skinName);
                } else {

                    ja.add(leaderBoardData.getContents(i));
                }
            }
            jaData.add(ja);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("data", jaData);
        JSONObject jo = new JSONObject(data);
        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 20496;
    }
}


