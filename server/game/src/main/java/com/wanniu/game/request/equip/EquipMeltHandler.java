package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.BloodListCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MeltConfigCO;
import com.wanniu.game.data.QuestCO;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import pomelo.area.EquipHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.equipHandler.equipMeltRequest")
public class EquipMeltHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final WNBag wnBag = player.getWnBag();

        EquipHandler.EquipMeltRequest req = EquipHandler.EquipMeltRequest.parseFrom(this.pak.getRemaingBytes());
        final List<Integer> indexs = new ArrayList<>(new HashSet<>(req.getC2SIndexsList()));

        return new PomeloResponse() {
            protected void write() throws IOException {
                EquipHandler.EquipMeltResponse.Builder res = EquipHandler.EquipMeltResponse.newBuilder();

                if (indexs.size() == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MELT_NOTHING"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                int totalGold = 0;
                List<Object[]> tcCodes = new ArrayList();

                for (int i = 0; i < indexs.size(); i++) {
                    NormalItem item = wnBag.getItem(((Integer) indexs.get(i)).intValue());
                    if (item == null || (!item.isEquip() && !item.isBlood())) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("PARAM_INVALID"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    if (item.isEquip()) {
                        NormalEquip equip = (NormalEquip) item;
                        if (equip.prop.noMelt == 1) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("CAN_NOT_MELT"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        MeltConfigCO prop = ItemUtil.getMeltProp(equip.prop.meltLevel, equip.getQColor());
                        if (prop == null) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("PARAM_INVALID"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        totalGold += prop.costGold;
                        tcCodes.add(new Object[]{prop.tcCode, Boolean.valueOf(equip.isBinding())});


                        if (equip.getQColor() >= Const.ItemQuality.ORANGE.getValue()) {
                            ItemSpeData speData = equip.itemDb.speData;
                            StringBuffer sb = new StringBuffer();
                            if (speData != null) {
                                sb.append(speData.baseAtts.toString());
                                if (speData.extAtts != null) {
                                    sb.append("|||").append(speData.extAtts.toString());
                                }
                                if (speData.legendAtts != null) {
                                    sb.append("|||").append(speData.legendAtts.toString());
                                }
                            }
                            PlayerUtil.bi(getClass(), Const.BiLogType.Smelt, player, new Object[]{equip.itemDb.code, equip.itemDb.id, sb.toString()});
                        }
                    } else if (item.isBlood()) {
                        BloodListCO bloodListCO = (BloodListCO) GameData.BloodLists.get(Integer.valueOf(((QuestCO) GameData.Quests.get(item.itemCode())).min));
                        tcCodes.add(new Object[]{bloodListCO.melting, Boolean.valueOf(false)});
                    }
                }

                List<NormalItem> tcItems = new ArrayList<>();
                for (Object[] v : tcCodes) {
                    List<NormalItem> items = ItemUtil.createItemsByTcCode((String) v[0]);
                    for (NormalItem item : items) {
                        if (item.isEquip()) {
                            Const.ForceType forceType = ((Boolean) v[1]).booleanValue() ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
                            int bindType = ItemUtil.getPropBindType(item.prop, forceType);
                            item.setBind(bindType);
                        }
                        tcItems.add(item);
                    }
                }

                List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);

                int len = ItemUtil.getPackUpItemsNum(addItems) - indexs.size();
                if (len < 0) {
                    len = 0;
                }

                if (!player.moneyManager.costGold(totalGold, Const.GOODS_CHANGE_TYPE.melt)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                for (int j = 0; j < indexs.size(); j++) {
                    wnBag.discardItemByPos(((Integer) indexs.get(j)).intValue(), 1, false, Const.GOODS_CHANGE_TYPE.melt);
                }

                List<PlayerItemPO> notAddItems = new ArrayList<>();
                List<ItemOuterClass.MiniItem> showItems = new ArrayList<>();
                int getExp = 0;
                for (int k = 0; k < addItems.size(); k++) {
                    NormalItem addItem = addItems.get(k);
                    if (addItem.itemDb.code.equals("exp")) {
                        getExp += addItem.getWorth();
                    } else if (!addItem.itemDb.code.equals("gold")) {


                        ItemOuterClass.MiniItem.Builder item = ItemUtil.getMiniItemData(addItem.itemDb.code, addItem.itemDb.groupCount);
                        if (item != null) {
                            showItems.add(item.build());
                        }
                    }

                    if (wnBag.testAddEntityItem(addItems.get(k), true)) {
                        wnBag.addEntityItem(addItems.get(k), Const.GOODS_CHANGE_TYPE.melt, null, false, true);
                    } else {
                        notAddItems.add(addItem.itemDb);
                    }
                }
                if (notAddItems.size() > 0) {
                    MailSysData mailSysData = new MailSysData("Bag_full_melting");
                    ((MailData) mailSysData).entityItems = notAddItems;
                    MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailSysData, Const.GOODS_CHANGE_TYPE.melt);
                    player.sendSysTip(LangService.getValue("BAG_FULL_SMELTING_CHEST"), Const.TipsType.BLACK);
                }

                player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_MELT, 1);


                BILogService.getInstance().ansycReportMeltCultivate(player.getPlayer(), addItems);

                res.setS2CCode(200);
                res.setS2CExp(getExp);
                res.addAllS2CItem(showItems);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


