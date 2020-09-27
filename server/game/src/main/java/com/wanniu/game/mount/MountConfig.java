package com.wanniu.game.mount;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.RideListExt;
import com.wanniu.game.data.ext.SkinListExt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MountConfig {
    private static MountConfig instance;

    public static MountConfig getInstance() {
        if (instance == null) {
            instance = new MountConfig();
        }
        return instance;
    }

    private Map<Integer, RideListExt> mountTable = GameData.RideLists;
    private Map<Integer, SkinListExt> mountSkinTable = GameData.SkinLists;


    public List<RideListExt> getMountPropList() {
        return new ArrayList<>(GameData.RideLists.values());
    }


    public List<SkinListExt> getMountSkinPropList() {
        return new ArrayList<>(GameData.SkinLists.values());
    }


    public RideListExt getMountPropByID(int mountId) {
        return this.mountTable.get(Integer.valueOf(mountId));
    }


    public SkinListExt getMountSkinPropByID(int skinId) {
        return this.mountSkinTable.get(Integer.valueOf(skinId));
    }

    public Map<String, Integer> getSkinTotalAttribute(List<Integer> skinAry) {
        Map<String, Integer> attrTable = new TreeMap<>();
        for (Map.Entry<Integer, SkinListExt> node : this.mountSkinTable.entrySet()) {
            SkinListExt skin = node.getValue();
            if (skinAry.indexOf(Integer.valueOf(skin.skinID)) != -1) ;
        }


        return attrTable;
    }
}


