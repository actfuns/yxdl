package com.wanniu.game.blood;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.BloodListCO;
import com.wanniu.game.data.BloodSuitConfigCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.QuestCO;
import com.wanniu.game.data.ext.BloodSuitListExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.BloodPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BloodManager
        extends ModuleManager {
    private WNPlayer player;
    public BloodPO bloodPO;
    public static List<String> itemFilter = Arrays.asList(new String[]{"vq01", "vq02", "vq03", "vq04", "vq05", "vq06", "vq07", "vq08", "vq09", "vq10"});

    public BloodManager(WNPlayer player) {
        this.player = player;
        BloodPO bloodPO = (BloodPO) PlayerPOManager.findPO(ConstsTR.player_blood, player.getId(), BloodPO.class);
        if (bloodPO == null) {
            bloodPO = new BloodPO(player.getId());
            PlayerPOManager.put(ConstsTR.player_blood, player.getId(), (GEntity) bloodPO);
        }
        this.bloodPO = bloodPO;
    }


    private void _init() {
    }


    public List<NormalItem> getBloodItems() {
        List<NormalItem> bloods = this.player.bag.findItemBySecondType(Const.ItemSecondType.virtQuest);

        return bloods;
    }


    public Map<Integer, List<Integer>> getActivedSuits() {
        Map<Integer, List<Integer>> activedSuits = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : (Iterable<Map.Entry<Integer, Integer>>) this.bloodPO.equipedMap.entrySet()) {
            for (BloodSuitListExt bloodSuitListExt : GameData.BloodSuitLists.values()) {
                if (bloodSuitListExt.partIdList.contains(entry.getValue())) {
                    if (!activedSuits.containsKey(Integer.valueOf(bloodSuitListExt.suitID2))) {
                        activedSuits.put(Integer.valueOf(bloodSuitListExt.suitID2), new LinkedList<>());
                    }
                    List<Integer> suitList = activedSuits.get(Integer.valueOf(bloodSuitListExt.suitID2));
                    suitList.add(entry.getValue());
                }
            }
        }


        return activedSuits;
    }


    public int equipBlood(String itemId) {
        NormalItem item = this.player.bag.findItemById(itemId);
        int pos = this.player.bag.findPosById(itemId);
        if (pos == -1) {
            return 1;
        }
        if (item.prop.itemSecondType != Const.ItemSecondType.virtQuest.getValue()) {
            return 2;
        }
        if (itemFilter.contains(item.itemCode())) {
            return 3;
        }
        BloodListCO bloodListCO = (BloodListCO) GameData.BloodLists.get(Integer.valueOf(((QuestCO) GameData.Quests.get(item.itemCode())).min));


        this.player.bag.discardItemByPos(pos, 0, true, Const.GOODS_CHANGE_TYPE.blood);


        if (this.bloodPO.equipedMap.containsKey(Integer.valueOf(bloodListCO.sortID3))) {
            int oldBloodId = ((Integer) this.bloodPO.equipedMap.get(Integer.valueOf(bloodListCO.sortID3))).intValue();
            String oldBloodCode = "blood" + oldBloodId;
            NormalItem entityItem = ItemUtil.createItemsByItemCode(oldBloodCode, 1).get(0);
            this.player.bag.addEntityItem(entityItem, Const.GOODS_CHANGE_TYPE.blood, null, false, false);
        }


        this.bloodPO.equipedMap.put(Integer.valueOf(bloodListCO.sortID3), Integer.valueOf(bloodListCO.bloodID));

        blooodSync();

        ansycReportBloodChange(1, bloodListCO.sortID3, bloodListCO);

        return 0;
    }


    private void ansycReportBloodChange(int type, int position, BloodListCO bloodListCO) {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("code", bloodListCO.code);
            data.put("name", bloodListCO.bloodName);
            for (BloodSuitListExt bloodSuitListExt : GameData.BloodSuitLists.values()) {
                if (bloodSuitListExt.partIdList.contains(Integer.valueOf(bloodListCO.bloodID))) {
                    data.put("suitID", Integer.valueOf(bloodSuitListExt.suitID2));
                    data.put("suitName", bloodSuitListExt.suitName);
                    break;
                }
            }
            BILogService.getInstance().ansycReportBloodChange(this.player.getPlayer(), type, position, data);
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportBloodChange", e});
        }
    }


    public boolean unequipBlood(int sortId) {
        if (!this.bloodPO.equipedMap.containsKey(Integer.valueOf(sortId))) {
            return false;
        }
        int bloodId = ((Integer) this.bloodPO.equipedMap.get(Integer.valueOf(sortId))).intValue();

        String code = "blood" + bloodId;


        this.player.bag.addCodeItemMail(code, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.blood, "Bag_full_common");

        this.bloodPO.equipedMap.remove(Integer.valueOf(sortId));


        blooodSync();

        List<BloodListCO> cs = GameData.findBloodLists(v -> code.equals(v.code));
        if (!cs.isEmpty()) {
            BloodListCO bloodListCO = cs.get(0);
            ansycReportBloodChange(2, bloodListCO.sortID3, bloodListCO);
        }

        return true;
    }


    public Map<Const.PlayerBtlData, Integer> calSingleInfluence(int sortId) {
        Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();
        if (!this.bloodPO.equipedMap.containsKey(Integer.valueOf(sortId))) {
            return data;
        }

        BloodListCO bloodListCO = (BloodListCO) GameData.BloodLists.get(this.bloodPO.equipedMap.get(Integer.valueOf(sortId)));


        if (bloodListCO.proNum >= 1) {
            data.put(Const.PlayerBtlData.getE(bloodListCO.prop1), Integer.valueOf(bloodListCO.num1));
        }
        if (bloodListCO.proNum >= 2) {
            data.put(Const.PlayerBtlData.getE(bloodListCO.prop2), Integer.valueOf(bloodListCO.num2));
        }
        if (bloodListCO.proNum >= 3) {
            data.put(Const.PlayerBtlData.getE(bloodListCO.prop3), Integer.valueOf(bloodListCO.num3));
        }
        if (bloodListCO.proNum >= 4) {
            data.put(Const.PlayerBtlData.getE(bloodListCO.prop4), Integer.valueOf(bloodListCO.num4));
        }

        return data;
    }


    public Map<Const.PlayerBtlData, Integer> calAllInfluence() {
        Map<Const.PlayerBtlData, Integer> data = new ConcurrentHashMap<>();


        for (Map.Entry<Integer, Integer> entry1 : (Iterable<Map.Entry<Integer, Integer>>) this.bloodPO.equipedMap.entrySet()) {
            Map<Const.PlayerBtlData, Integer> singleData = calSingleInfluence(((Integer) entry1.getKey()).intValue());
            for (Map.Entry<Const.PlayerBtlData, Integer> entry2 : singleData.entrySet()) {
                Const.PlayerBtlData key = entry2.getKey();
                Integer value = entry2.getValue();
                if (data.containsKey(key)) {
                    data.put(key, Integer.valueOf(((Integer) data.get(key)).intValue() + value.intValue()));
                    continue;
                }
                data.put(key, value);
            }
        }


        Map<Integer, List<Integer>> activedSuits = getActivedSuits();
        for (Map.Entry<Integer, List<Integer>> entry : activedSuits.entrySet()) {
            List<BloodSuitConfigCO> bloodSuitConfigCOs = GameData.findBloodSuitConfigs(t -> (t.suitID == ((Integer) entry.getKey()).intValue() && t.partReqCount <= ((List) entry.getValue()).size()));

            for (BloodSuitConfigCO bloodSuitConfigCO : bloodSuitConfigCOs) {
                Const.PlayerBtlData key = Const.PlayerBtlData.getE(bloodSuitConfigCO.prop);
                Integer value = Integer.valueOf(bloodSuitConfigCO.num);
                if (data.containsKey(key)) {
                    data.put(key, Integer.valueOf(((Integer) data.get(key)).intValue() + value.intValue()));
                    continue;
                }
                data.put(key, value);
            }
        }


        return data;
    }


    public void blooodSync() {
        this.player.btlDataManager.data_blood = calAllInfluence();
        this.player.btlDataManager.calFinalData();
        this.player.onBloodChange();
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {

        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.BLOOD;
    }
}


