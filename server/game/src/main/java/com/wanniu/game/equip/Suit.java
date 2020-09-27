package com.wanniu.game.equip;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.EquipHandler;


public class Suit {
    public static List<EquipHandler.SuitTypeAttr> getPlayerSuitInfo(WNPlayer player) {
        List<EquipHandler.SuitTypeAttr> data = new ArrayList<>();


        return data;
    }

    public static Map<String, Integer> getSuitAttr(int pro, EquipManager equipManager, boolean sendMsg, String[] uid, int type) {
        WNPlayer player = equipManager.player;
        Map<String, Integer> data = new HashMap<>();


        return data;
    }


    public static List<EquipHandler.SuitAttrSort> getSuitTypeDetail(int pro, int type) {
        List<EquipHandler.SuitAttrSort> data = new ArrayList<>();


        Out.debug(new Object[]{Suit.class, data});
        return data;
    }
}


