package com.wanniu.game.request.item;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.CombineTypeCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.CombineExt;
import com.wanniu.game.equip.EquipCraftConfig;
import com.wanniu.game.equip.EquipCraftUtil;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.po.DetailItemNum;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.ItemHandler;


@GClientEvent("area.itemHandler.combineRequest")
public class CombineHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag bag = player.getWnBag();

        ItemHandler.CombineRequest req = ItemHandler.CombineRequest.parseFrom(this.pak.getRemaingBytes());
        final int destId = req.getC2SDestID();
        final int num = req.getC2SNum();


        return new PomeloResponse() {
            protected void write() throws IOException {
                ItemHandler.CombineResponse.Builder res = ItemHandler.CombineResponse.newBuilder();

                CombineExt prop = EquipCraftConfig.getInstance().getCombineProp(destId);
                if (prop == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                DItemBase productProp = ItemUtil.getUnEquipPropByCode(prop.destCode);
                if (productProp == null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                Map<String, List<Integer>> destCounts = new HashMap<>();
                destCounts.put("bind", new ArrayList<>());
                destCounts.put("unBind", new ArrayList<>());

                for (int i = 0; i < prop.material.size(); i++) {
                    WNBag.SimpleItemInfo itemInfo = prop.material.get(i);
                    DetailItemNum countInfo = bag.findDetailItemNumByCode(itemInfo.itemCode);
                    double maxNum = Math.floor((countInfo.totalNum / itemInfo.itemNum));
                    if (maxNum < num) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("ITEM_COMBINE_NOT_ENOUGH"));
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    int unBindNum = 0;
                    int bindNum = 0;


                    int bindMax = (int) Math.floor((countInfo.bindNum / itemInfo.itemNum));
                    int leftCount = countInfo.bindNum % itemInfo.itemNum;
                    if (leftCount > 0 && leftCount + countInfo.unBindNum > itemInfo.itemNum) {
                        bindMax++;
                    }
                    bindNum = Math.min(bindMax, num);
                    unBindNum = Math.max(num - bindNum, 0);

                    if (bindNum > 0) {
                        ((List<Integer>) destCounts.get("bind")).add(Integer.valueOf(bindNum));
                    }
                    if (unBindNum > 0) {
                        ((List<Integer>) destCounts.get("unBind")).add(Integer.valueOf(unBindNum));
                    }
                }

                List<WNBag.SimpleItemInfo> destItems = new ArrayList<>();
                for (String key : destCounts.keySet()) {
                    int destCount = 0;
                    List<Integer> list_binds = destCounts.get(key);
                    if (list_binds.size() > 0) {
                        destCount = ((Integer) Collections.<Integer>min(list_binds)).intValue();
                    }

                    if (destCount > 0) {
                        WNBag.SimpleItemInfo itemInfo = new WNBag.SimpleItemInfo();
                        itemInfo.itemCode = prop.destCode;
                        itemInfo.itemNum = destCount;
                        itemInfo.forceType = key.equals("bind") ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
                        destItems.add(itemInfo);
                    }
                }
                if (!bag.testAddCodeItems(destItems)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                for (int j = 0; j < prop.material.size(); j++) {
                    WNBag.SimpleItemInfo v = prop.material.get(j);
                    int totalNeed = v.itemNum * num;

                    int leftCost = totalNeed;


                    if (leftCost > 0) {
                        bag.discardItem(v.itemCode, leftCost, Const.GOODS_CHANGE_TYPE.compound, null, false, false);
                    }
                }
                bag.addCodeItems(destItems, Const.GOODS_CHANGE_TYPE.compound);

                player.taskManager.dealTaskEvent(Const.TaskType.COMBINE_GEM, prop.destCode, num);


                if (productProp.itemSecondType == Const.ItemSecondType.gem.getValue()) {
                    player.achievementManager.onGemCombine(prop.destCode, num);
                }
                List<CombineTypeCO> combineTypeProps = GameData.findCombineTypes(t -> t.tagetCode.equals(prop.destCode));


                CombineTypeCO combineTypeProp = null;
                if (combineTypeProps.size() > 0) {
                    combineTypeProp = combineTypeProps.get(0);
                    CombineTypeCO combineIdProp = (CombineTypeCO) GameData.CombineTypes.get(Integer.valueOf(combineTypeProp.parentID));
                    if (combineIdProp != null) ;
                }


                if (prop.isNotice != 0) {
                    EquipCraftUtil.sendEquipCombineMsg(player, (DItemEquipBase) productProp);
                }

                player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.GEM_COMBINE_COUNT, new Object[]{Integer.valueOf(productProp.levelReq), Integer.valueOf(this.val$num)});
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


