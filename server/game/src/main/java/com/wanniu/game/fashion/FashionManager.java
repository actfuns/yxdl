package com.wanniu.game.fashion;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.FashSuitConfigExt;
import com.wanniu.game.data.ext.FashionExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


public class FashionManager
        extends ModuleManager {
    public WNPlayer player;

    public FashionManager(WNPlayer player) {
        this.player = player;
    }


    private boolean getFashionGet(String code) {
        boolean have = false;
        for (String temp_code : this.player.playerBasePO.fashions_get) {
            if (temp_code.equals(code)) {
                have = true;
                break;
            }
        }
        if (!have) {
            return false;
        }
        return true;
    }

    private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(type);
        data.setNumber(num);
        return data.build();
    }

    public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
        List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();

        ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FLAG_FASHION.getValue(), this.player.playerBasePO.fashion_get_spot));


        return ls;
    }


    public boolean activiateFashion(String code) {
        if (getFashionGet(code)) {
            return false;
        }

        FashionExt fashionExt = (FashionExt) GameData.Fashions.get(code);
        if (this.player.getPro() != fashionExt.pro) {
            return false;
        }
        this.player.playerBasePO.fashions_get.add(code);

        LogReportService.getInstance().ansycReportFashion(this.player, code);

        this.player.playerBasePO.fashion_get_spot = 1;
        List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
        this.player.updateSuperScriptList(ls);

        return true;
    }


    public boolean equipFashion(String code, boolean isOn) {
        FashionExt fashionExt = (FashionExt) GameData.Fashions.get(code);

        if (!getFashionGet(code)) {
            return false;
        }
        if (isOn) {
            this.player.playerBasePO.fashions_equiped.put(Integer.valueOf(fashionExt.type), fashionExt.code);
        } else {
            this.player.playerBasePO.fashions_equiped.put(Integer.valueOf(fashionExt.type), null);
        }

        fashionSync();
        return true;
    }


    public void fashionSync() {
        this.player.btlDataManager.data_fashion = calAllInfluence();
        this.player.btlDataManager.calFinalData();
        this.player.onFashionChange();
        this.player.refreshBattlerServerAvatar();
    }


    public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
        Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();


        for (Map.Entry<Integer, String> entry : (Iterable<Map.Entry<Integer, String>>) this.player.playerBasePO.fashions_equiped.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            String code = entry.getValue();

            FashionExt fashion = (FashionExt) GameData.Fashions.get(code);

            deepCopy(data, fashion.atts);
        }


        Map<Integer, List<String>> suits = new HashMap<>();
        for (FashionExt fashion : GameData.Fashions.values()) {
            List<String> list = suits.get(Integer.valueOf(fashion.fashionID));
            if (list == null) {
                list = new ArrayList<>();
                suits.put(Integer.valueOf(fashion.fashionID), list);
            }
            if (list.contains(fashion.code)) {
                Out.debug(new Object[]{list});
                Out.error(new Object[]{"居然会走到这里？"});

                continue;
            }
            if (this.player.playerBasePO.fashions_get.contains(fashion.code)) {
                list.add(fashion.code);
            }
        }


        for (FashSuitConfigExt suit : GameData.FashSuitConfigs.values()) {
            for (Iterator<Integer> iterator = suits.keySet().iterator(); iterator.hasNext(); ) {
                int suitID = ((Integer) iterator.next()).intValue();
                int count = ((List) suits.get(Integer.valueOf(suitID))).size();
                if (count == 2) {
                    deepCopy(data, suit.Attr2Map);
                }
                if (count == 3) {
                    deepCopy(data, suit.Attr3Map);
                }
            }

        }
        return data;
    }


    private void deepCopy(Map<Const.PlayerBtlData, Integer> data, Map<Const.PlayerBtlData, Integer> source) {
        if (source == null) {
            return;
        }
        for (Map.Entry<Const.PlayerBtlData, Integer> entry : source.entrySet()) {
            if (data.get(entry.getKey()) != null && ((Integer) data.get(entry.getKey())).intValue() > 0) {
                data.put(entry.getKey(), Integer.valueOf(((Integer) data.get(entry.getKey())).intValue() + ((Integer) entry.getValue()).intValue()));
                continue;
            }
            data.put(entry.getKey(), entry.getValue());
        }
    }


    public List<ItemOuterClass.EquipFashionInfo> toJson4Fashion() {
        List<ItemOuterClass.EquipFashionInfo> list = new ArrayList<>();
        for (String temp_code : this.player.playerBasePO.fashions_get) {
            FashionExt fashion = (FashionExt) GameData.Fashions.get(temp_code);

            ItemOuterClass.EquipFashionInfo.Builder fashionInfo = ItemOuterClass.EquipFashionInfo.newBuilder();
            fashionInfo.setPos(fashion.type);
            fashionInfo.setItemcode(temp_code);
            list.add(fashionInfo.build());
        }
        return list;
    }

    public void onPlayerEvent(Const.PlayerEventType eventType) {
        List<PlayerHandler.SuperScriptType> ls;
        switch (eventType) {
            case AFTER_LOGIN:
                ls = getSuperScriptList();
                this.player.updateSuperScriptList(ls);
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.FASHION;
    }
}


