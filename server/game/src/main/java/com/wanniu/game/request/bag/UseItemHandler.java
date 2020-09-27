package com.wanniu.game.request.bag;

import Xmds.RefreshPlayerPropertyChange;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.FashionItemCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.task.AcceptTaskHandler;
import com.wanniu.game.task.TaskUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.BagHandler;
import pomelo.area.FashionHandler;
import pomelo.area.PetNewHandler;
import pomelo.item.ItemOuterClass;


@GClientEvent("area.bagHandler.useItemRequest")
public class UseItemHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        BagHandler.UseItemRequest req = BagHandler.UseItemRequest.parseFrom(this.pak.getRemaingBytes());
        final int index = req.getC2SGridIndex();
        final int num = req.getC2SNum();

        return new PomeloResponse() {
            protected void write() throws IOException {
                BagHandler.UseItemResponse.Builder res = BagHandler.UseItemResponse.newBuilder();
                if (null == player) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    PlayerUtil.logWarnIfPlayerNull(UseItemHandler.this.pak);
                    return;
                }
                WNBag wnBag = player.getWnBag();
                if (num <= 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                NormalItem item = wnBag.getItem(index);

                if (item == null || ItemUtil.isEquipByItemType(item.prop.itemType)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (!item.canUse()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("ITEM_CAN_NOT_USE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                if (item.itemDb.groupCount < num || num <= 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }

                DItemBase template = (DItemBase) item.getTemplate();
                if (template.levelReq > (player.getPlayer()).level) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_PLAYER_LEVEL_NOT_ENOUGH_CANNOT_USE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (item.prop.code.equals(Const.ITEM_CODE.Changename.value)) {
                    res.setS2CCode(200);
                    res.setIsGain(2);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (item.prop.itemType == Const.ItemType.Chest.getValue()) {
                    int needDiamond = template.min;

                    if (needDiamond > 0 && !player.moneyManager.enoughDiamond(needDiamond)) {
                        res.setS2CCode(500);
                        res.setS2CMsg("");
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    String tc = (String) template.chestTC.get(Integer.valueOf(player.getPro()));
                    List<NormalItem> tcItems = new ArrayList<>();
                    for (int i = 0; i < num; i++) {

                        List<NormalItem> items = ItemUtil.createItemsByRealTC(tc, player.getLevel());
                        tcItems.addAll(items);
                    }

                    List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);


                    int needGridNum = ItemUtil.getPackUpItemsNum(addItems);
                    if (needGridNum > 0) {
                        if (!wnBag.testEmptyGridLarge(1, false)) {
                            res.setS2CCode(500);
                            res.setS2CMsg("");
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        if (wnBag.emptyGridNum() < needGridNum) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("STORE_SPACE_NOT_ENOUGH"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                    }
                    wnBag.discardItemByPos(index, num, false, Const.GOODS_CHANGE_TYPE.use);

                    List<ItemOuterClass.MiniItem> chest = new ArrayList<>();

                    List<PlayerItemPO> notAddItems = new ArrayList<>();
                    for (int j = 0; j < addItems.size(); j++) {
                        NormalItem addItem = addItems.get(j);


                        if (wnBag.testAddEntityItem(addItem, true)) {
                            if (!addItem.isVirtual()) {
                                chest.add(ItemUtil.getMiniItemData(addItem.itemDb.code, addItem.itemDb.groupCount, Const.ForceType.getE(addItem.getBind())).build());
                            }
                            wnBag.addEntityItem(addItem, Const.GOODS_CHANGE_TYPE.use, null, false, false);
                        } else {
                            notAddItems.add(addItem.itemDb);
                        }
                    }
                    if (notAddItems.size() > 0) {
                        MailSysData mailSysData = new MailSysData("Bag_full_openbox");
                        ((MailData) mailSysData).entityItems = notAddItems;
                        MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailSysData, Const.GOODS_CHANGE_TYPE.use);
                        player.sendSysTip(LangService.getValue("BAG_FULL_SMELTING_CHEST"), Const.TipsType.BLACK);
                    }

                    if (needDiamond > 0) {
                        player.moneyManager.costDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.use);
                    }

                    res.setS2CCode(200);
                    res.addAllS2CChest(chest);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    if (item.prop.itemType == Const.ItemType.Potion.getValue()) {

                        if (num != 1) {


                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        if (item.isCD()) {


                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_USE_IN_CD"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        Area area = player.getArea();
                        MapBase areaProp = AreaUtil.getAreaProp(area.areaId);
                        if (areaProp.useAgent == 0) {


                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_THIS_SENCE_CANNOT_USE_MEDICAMENT"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        player.bag.setCD(item.prop.itemSecondType, index);
                        player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
                        UseItemHandler.GetItemChanagePropertyResult data = ItemUtil.getItemChanageProperty(item);
                        if (data.bPet) {
                            player.refreshPlayerPetPropertyChange(data.itemData);
                        } else {

                            player.bufferManager.add(data.itemData);
                            player.refreshPlayerPropertyChange(data.itemData);
                        }

                        player.sendSysTip(LangService.getValue("GAIN_POTION"), Const.TipsType.NO_BG);
                        res.setS2CCode(200);
                        res.setIsGain(1);
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.rideItem.getValue()) {

                        if (num != 1) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        int ret = player.mountManager.addNewSkin(template.min);
                        if (ret == 1) {
                            player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        if (ret == -1) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_HAD_THIS_SKIN"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        if (ret == -2) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("BAG_SKIN_NULL"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        if (ret == -3) {
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                    } else {
                        if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.petItem.getValue() && ((DItemBase) item.prop).prop.equals("pet")) {
                            DItemBase prop = (DItemBase) item.prop;
                            int petId = prop.min;
                            String msg = player.petNewManager.summonPetByItem(petId);
                            if (msg != null) {
                                BaseDataExt baseDataExt = (BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(petId));
                                for (int i = 0; i < num; i++) {
                                    player.bag.addCodeItemMail(baseDataExt.petItemCode, baseDataExt.itemCount, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.pet, "Bag_full_common");
                                }
                                player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.use);
                            } else {
                                player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
                            }
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                            return;
                        }
                        if (item.prop.itemType == Const.ItemType.Misc.getValue() && item.prop.itemSecondType == Const.ItemSecondType.petItem.getValue()) {
                            if (num != 1) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            PetNewHandler.SummonPetResponse result = player.petNewManager.summonPet(template.min).build();
                            boolean ret = (result.getS2CCode() == 200);
                            if (ret) {
                                player.bag.discardItemByPos(index, 1, false, Const.GOODS_CHANGE_TYPE.petCost);
                                res.setS2CCode(200);
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            res.setS2CCode(500);
                            res.setS2CMsg(LangService.getValue("GAIN_PET_SAME"));
                            this.body.writeBytes(res.build().toByteArray());

                            return;
                        }
                        if (item.prop.itemType == Const.ItemType.Misc.getValue() && item.prop.itemSecondType == Const.ItemSecondType.misc.getValue() && template.prop.equals("ExpRatio")) {

                            if (num != 1) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);

                            player.bufferManager.addLocalBuff("ExdExp", (template.par * Const.Time.Minute.getValue()), template.min);
                            player.sendSysTip(LangService.getValue("ITEM_USE_NOTICE").replace("{itemName}", item.prop.name), Const.TipsType.NO_BG);
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        } else if (item.prop.itemType == Const.ItemType.Misc.getValue() && template.prop.equals("rank")) {

                            if (num != 1) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            player.titleManager.onAwardRank(template.min);
                            player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        } else if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.fashionItem.getValue()) {
                            if (num != 1) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            FashionItemCO fashionItemCO = (FashionItemCO) GameData.FashionItems.get(item.itemCode());
                            boolean activiateResult = player.fashionManager.activiateFashion(fashionItemCO.prop);
                            if (!activiateResult) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("FASHION_CANNOT_ACTIVIATE"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());

                            FashionHandler.FashionGetPush.Builder fBuilder = FashionHandler.FashionGetPush.newBuilder();
                            fBuilder.setS2CCode(200);
                            fBuilder.setCode(fashionItemCO.prop);
                            player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) fBuilder.build());
                        } else if (item.prop.itemType == Const.ItemType.Misc.getValue() && template.prop.equals("ReducePK")) {
                            int pkValue = player.pkRuleManager.getPkValue();
                            if (pkValue <= 0) {
                                res.setS2CCode(500);
                                res.setS2CMsg(LangService.getValue("PK_VALUE_ZERO_NOT_USE"));
                                this.body.writeBytes(res.build().toByteArray());
                                return;
                            }
                            int maxCount = (pkValue + template.min - 1) / template.min;
                            int realCount = (num <= maxCount) ? num : maxCount;
                            player.changePlayerPkValue(-template.min * realCount);
                            player.bag.discardItemByPos(index, realCount, Const.GOODS_CHANGE_TYPE.use);

                            player.sendSysTip(LangService.getValue("GAIN_POTION"), Const.TipsType.NO_BG);

                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        } else if (item.prop.itemType == Const.ItemType.Misc.getValue()) {
                            if (template.prop.equals("gold")) {
                                player.moneyManager.addGold(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                            } else if (template.prop.equals("prestige")) {
                                player.addPrestige(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                                player.pushDynamicData("prestige", Integer.valueOf(player.player.prestige));
                            } else if (template.prop.equals("ticket")) {
                                player.moneyManager.addTicket(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                            } else if (template.prop.equals("exp")) {
                                player.addExp(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                            } else if (template.prop.equals("upexp")) {
                                player.baseDataManager.addClassExp(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                            } else if (template.prop.equals("guildPoints")) {
                                int totalPoints = template.min * num;
                                player.guildManager.addContribution(totalPoints, Const.GOODS_CHANGE_TYPE.use);
                                String guildId = player.guildManager.getGuildId();
                                player.guildManager.addTotalContribution(guildId, totalPoints);
                                player.guildManager.pushRedPoint();
                            } else if (template.prop.equals("solopoint")) {
                                player.soloManager.addSolopoint(template.min * num, Const.GOODS_CHANGE_TYPE.use);
                            } else if (template.prop.equalsIgnoreCase("CbtQuest")) {

                                int templateId = template.par;
                                if (player.taskManager.treasureTasks.size() > 0) {
                                    res.setS2CCode(500);
                                    res.setS2CMsg(LangService.getValue("TASK_IS_ACCPETED"));
                                    this.body.writeBytes(res.build().toByteArray());

                                    return;
                                }

                                TaskBase prop = TaskUtils.getTaskProp(templateId);
                                AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 8);
                                if (result.task != null) {
                                    player.getPlayerTasks().pushTaskUpdate(result.task);


                                    TaskUtils.treasurePush(player, Integer.parseInt(result.task.prop.targets.get(0)), templateId);


                                    player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);

                                    res.setS2CCode(200);
                                    this.body.writeBytes(res.build().toByteArray());
                                    return;
                                }
                                res.setS2CCode(500);
                                res.setS2CMsg(result.msg);
                                this.body.writeBytes(res.build().toByteArray());

                                return;
                            }

                            player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.use);
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    }
                }

            }
        };
    }

    public static class GetItemChanagePropertyResult {
        public RefreshPlayerPropertyChange itemData;

        public GetItemChanagePropertyResult(RefreshPlayerPropertyChange itemData, boolean bPet) {
            this.itemData = itemData;
            this.bPet = bPet;
        }

        public boolean bPet;
    }

}


