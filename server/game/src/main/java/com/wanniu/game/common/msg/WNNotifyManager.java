package com.wanniu.game.common.msg;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.SoloDataPO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.AchievementHandler;
import pomelo.area.BagHandler;
import pomelo.area.ConsignmentLineHandler;
import pomelo.area.EquipHandler;
import pomelo.area.FunctionHandler;
import pomelo.area.ItemHandler;
import pomelo.area.LimitTimeActivityHandler;
import pomelo.area.MailHandler;
import pomelo.area.PlayerHandler;
import pomelo.area.RankHandler;
import pomelo.area.SkillHandler;
import pomelo.area.SkillKeysHandler;
import pomelo.area.SoloHandler;
import pomelo.item.ItemOuterClass;


public class WNNotifyManager {
    private static WNNotifyManager instance;

    public static WNNotifyManager getInstance() {
        if (instance == null) {
            instance = new WNNotifyManager();
        }
        return instance;
    }


    public void teamBagGridNumPush(WNPlayer player, int args) {
        player.refreshPlayerRemainTeamBagCountData(args);
    }

    public void pushFunctionGoTo(WNPlayer player, FunctionHandler.FunctionGoToPush.Builder args) {
        Out.debug(new Object[]{getClass(), "pushFunctionGoTo: ", player.getName(), " id: ", player.getId(), " data: ", args});
        args.setS2CCode(200);

        player.receive("area.functionPush.functionGoToPush", (GeneratedMessage) args.build());
    }

    public void pushFishItem(WNPlayer player, List<ItemOuterClass.MiniItem> args) {
        Out.debug(new Object[]{getClass(), "pushFishItem: ", player.getName(), " id: ", player.getId(), " data: ", args});

        ItemHandler.FishItemPush.Builder data = ItemHandler.FishItemPush.newBuilder();
        data.setS2CCode(200);
        data.addAllS2CItem(args);
        player.receive("area.itemPush.fishItemPush", (GeneratedMessage) data.build());
    }


    public final void pushSkillUpdate(WNPlayer player, List<Integer> skillIds) {
        if (skillIds.size() <= 0) {
            return;
        }
        SkillHandler.SkillUpdatePush.Builder data = SkillHandler.SkillUpdatePush.newBuilder();
        data.setS2CCode(200);

        ArrayList<SkillHandler.SkillBasic> skills = new ArrayList<>();

        for (Iterator<Integer> iterator = skillIds.iterator(); iterator.hasNext(); ) {
            int index = ((Integer) iterator.next()).intValue();
            SkillHandler.SkillBasic skillBasic = player.skillManager.getSkillBasicUpdate4PayLoad(index);
            if (skillBasic != null) {
                skills.add(skillBasic);
            }
        }

        data.addAllS2CData(skills);
        boolean isCanSetting = false;
        data.setHubLock(!!isCanSetting);
        if (skills.size() > 0) {
            player.receive("area.skillPush.skillUpdatePush", (GeneratedMessage) data.build());
        }
    }

    public final void pushSkillKeysUpdate(WNPlayer player, List<Common.SkillKeyStruct> data) {
        if (data.size() > 0) {
            SkillKeysHandler.SkillKeyUpdatePush.Builder build = SkillKeysHandler.SkillKeyUpdatePush.newBuilder();
            build.setS2CCode(200);
            build.addAllS2CData(data);
            player.receive("area.skillKeysPush.skillKeyUpdatePush", (GeneratedMessage) build.build());
        }
    }


    public void pushEquipmentDynamic(WNPlayer player, int[] grids, boolean refresh) {
        Out.debug(new Object[]{getClass(), "@#@pushEquipmentDynamic: ", player.getName(), " id: ", player.getId(), " data: ", grids, ",refresh:", Boolean.valueOf(refresh)});
        EquipHandler.EquipmentSimplePush.Builder data = EquipHandler.EquipmentSimplePush.newBuilder();
        data.setS2CCode(200);
        List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();

        ItemHandler.ItemDetailPush.Builder equipDetails = ItemHandler.ItemDetailPush.newBuilder();
        equipDetails.setS2CCode(200);

        for (int pos : grids) {
            bagGrids.add(player.equipManager.getEquip4PayLoad(pos));

            NormalEquip normalEquip = player.equipManager.getEquipment(pos);
            if (normalEquip != null && refresh) {
                equipDetails.addS2CData(normalEquip.getItemDetail(player.playerBasePO));
            }
        }

        if (equipDetails.getS2CDataCount() > 0) {
            player.receive("area.itemPush.itemDetailPush", (GeneratedMessage) equipDetails.build());
        }

        data.addAllS2CData(bagGrids);
        if (bagGrids.size() > 0) {
            player.receive("area.equipPush.equipmentSimplePush", (GeneratedMessage) data.build());
        }
    }


    public void pushEquipmentPOS(WNPlayer player, int[] poses, boolean refresh) {
        Out.debug(new Object[]{getClass(), "@#@pushEquipmentPOS: ", player.getName(), " id: ", player.getId(), " data: ", poses, ",refresh:", Boolean.valueOf(refresh)});
        EquipHandler.StrengthPosPush.Builder data = EquipHandler.StrengthPosPush.newBuilder();
        data.setS2CCode(200);
        List<ItemOuterClass.EquipGridStrengthInfo> grids = new ArrayList<>();
        for (int pos : poses) {
            grids.add(player.equipManager.getStrenghInfo(pos));
        }

        data.addAllStrengthInfos(grids);
        if (grids.size() > 0) {
            player.receive("area.equipPush.equipStrengthPosPush", (GeneratedMessage) data.build());
        }
    }


    public void pushBagItemDynamic(WNPlayer player, List<Integer> grid, boolean flag, Const.GOODS_CHANGE_TYPE source) {
        BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
        List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();

        BagHandler.BagNewEquipPush.Builder newEquip = BagHandler.BagNewEquipPush.newBuilder();

        ItemHandler.ItemDetailPush.Builder itemDetails = ItemHandler.ItemDetailPush.newBuilder();
        itemDetails.setS2CCode(200);

        for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            ItemOuterClass.Grid.Builder gb = player.getWnBag().getGrid4PayLoad(pos);
            if (source != null) {
                gb.setSource(source.getValue());
            }
            bagGrids.add(gb.build());
            NormalItem item = player.getWnBag().getItem(pos);

            if (flag && item != null) {
                itemDetails.addS2CData(item.getItemDetail(player.playerBasePO));
                if (item.itemDb.isNew == 1) {
                    newEquip.addS2CData(item.getId());
                }
            }
        }


        if (itemDetails.getS2CDataCount() > 0) {
            player.receive("area.itemPush.itemDetailPush", (GeneratedMessage) itemDetails.build());
        }

        data.setS2CType(Const.BAG_TYPE.BAG.getValue());
        data.addAllS2CData(bagGrids);
        if (bagGrids.size() > 0) {
            player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage) data.build());
        }

        if (newEquip.getS2CDataCount() > 0) {
            player.receive("area.bagPush.bagNewEquipPush", (GeneratedMessage) newEquip.build());
        }
    }


    public void pushBagItemDynamic(WNPlayer player, List<Integer> grid, boolean flag) {
        pushBagItemDynamic(player, grid, flag, null);
    }


    public void pushBagNewItem(WNPlayer player, String code, int num, Const.GOODS_CHANGE_TYPE from) {
        Out.debug(new Object[]{getClass(), "bag pushBagNewItem: ", (player.getPlayer()).name, " id: ", (player.getPlayer()).id, " ::: ", code, ":", Integer.valueOf(num)});

        BagHandler.BagNewItemPush.Builder data = BagHandler.BagNewItemPush.newBuilder();

        ItemOuterClass.MiniItem.Builder item = ItemUtil.getMiniItemData(code, num, null);
        if (item != null) {


            data.addS2CData(item);
            player.receive("area.bagPush.bagNewItemPush", (GeneratedMessage) data.build());
            player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.ITEM, item.getName(), Integer.valueOf(item.getQColor()), String.valueOf(num), from);
        } else {
            Out.error(new Object[]{"pushBagNewItem item:::", code, ":", Integer.valueOf(num), ":", "is null"});
        }
    }

    public void gridNotEnough(WNPlayer player) {
        BagHandler.BagGridFullPush.Builder data = BagHandler.BagGridFullPush.newBuilder();
        data.setS2CCode(200);
        player.receive("area.bagPush.bagGridFullPush", (GeneratedMessage) data.build());
    }

    public void pushBagItemDynamicWareHouse(WNPlayer player, List<Integer> grid, boolean flag) {
        Out.debug(new Object[]{"wareHouse pushBagItemDynamic: ", player.getName(), " id: ", player.getId()});
        BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
        List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();

        WNBag wareHouse = player.wareHouse;

        for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            bagGrids.add(wareHouse.getGrid4PayLoad(pos).build());
        }


        data.setS2CType(Const.BAG_TYPE.WAREHOUSE.getValue());
        data.addAllS2CData(bagGrids);
        if (bagGrids.size() > 0) {
            player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage) data.build());
        }
    }

    public void pushBagItemDynamicRecycle(WNPlayer player, List<Integer> grid, boolean flag) {
        Out.debug(new Object[]{"recycle pushBagItemDynamic: ", player.getName(), " id: ", player.getId()});
        BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
        List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();

        WNBag recycle = player.recycle;

        for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            bagGrids.add(recycle.getGrid4PayLoad(pos).build());
        }


        data.setS2CType(Const.BAG_TYPE.RECYCLE.getValue());
        data.addAllS2CData(bagGrids);
        if (bagGrids.size() > 0) {
            player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage) data.build());
        }
    }


    public void pushEffectData(WNPlayer player, Map<String, Object> args) {
        Out.debug(new Object[]{getClass(), "pushEffectData: ", player.getName(), " id: ", player.getId(), " data: ", args});
        PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();
        List<Common.PropertyStruct> playerData = new ArrayList<>();
        Iterator<String> keys = args.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            playerData.add(CommonUtil.transferDataType(key, args.get(key)).build());
        }
        data.addAllS2CData(playerData);
        if (playerData.size() > 0) {
            player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage) data.build());
        }
    }


    public void pushPlayerDynamic(WNPlayer player, Common.PropertyStruct prop) {
        Out.debug(new Object[]{"pushPlayerDynamic: ", player.getName(), " id: ", player.getId(), " data: ", prop});
        PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();
        data.addS2CData(prop);
        if (data.getS2CDataCount() > 0) {
            player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage) data.build());
        }
    }


    public void pushPlayerDynamic(WNPlayer player, Map<String, Object> args) {
        Out.debug(new Object[]{"pushPlayerDynamic: ", player.getName(), " id: ", player.getId(), " data: ", args});
        PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();

        for (String key : args.keySet()) {
            Object value = args.get(key);
            if (value == null) {
                Out.error(new Object[]{"player prop ", key, " is null"});
                continue;
            }
            data.addS2CData(CommonUtil.transferDataType(key, value));
        }

        if (data.getS2CDataCount() > 0) {
            player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage) data.build());
        }
    }

    public void pushRelive(WNPlayer player, PlayerHandler.PlayerRelivePush data) {
        Out.debug(new Object[]{getClass(), " pushRelive: ", player.getName(), " id: ", player.getId()});
        player.receive("area.playerPush.playerRelivePush", (GeneratedMessage) data);
    }


    public void levelChange(WNPlayer player, int level) {
        player.getPlayerTasks().onLevelChange(level);
    }


    public void pushMails(WNPlayer player, ArrayList<MailHandler.Mail> mails) {
        MailHandler.OnGetMailPush.Builder build = MailHandler.OnGetMailPush.newBuilder();
        build.setS2CCode(200);
        build.addAllMails(mails);
        player.receive("area.mailPush.onGetMailPush", (GeneratedMessage) build.build());
    }

    public void pushAchievements(WNPlayer player, List<AchievementHandler.Achievement> achievements) {
        Out.debug(new Object[]{getClass(), "pushAchievements : ", player.getName(), "id: ", player.getId(), "data: ", achievements});
        AchievementHandler.OnAchievementPush.Builder data = AchievementHandler.OnAchievementPush.newBuilder();
        data.setS2CCode(200);
        data.addAllS2CAchievements(achievements);
        player.receive("area.achievementPush.onAchievementPush", (GeneratedMessage) data.build());
    }

    public void pushAwardRank(WNPlayer player, int rankId) {
        RankHandler.OnAwardRankPush.Builder build = RankHandler.OnAwardRankPush.newBuilder();
        build.setS2CCode(200);
        build.setS2CAwardRankId(rankId);
        player.receive("area.rankPush.onAwardRankPush", (GeneratedMessage) build.build());
    }


    public void pushNewReward(WNPlayer player) {
        SoloHandler.OnNewRewardPush.Builder data = SoloHandler.OnNewRewardPush.newBuilder();
        data.setS2CCode(200);

        Out.debug(new Object[]{getClass(), "pushNewReward : ", player.getName(), "id: ", player.getId(), "data: ", data});
        player.receive("area.soloPush.onNewRewardPush", (GeneratedMessage) data.build());
    }

    public void pushFightPoint(WNPlayer player, int fightPoint) {
        SoloHandler.OnFightPointPush.Builder data = SoloHandler.OnFightPointPush.newBuilder();
        data.setS2CCode(200);
        data.setS2CFightPoint(fightPoint);
        Out.debug(new Object[]{getClass(), "pushFightPoint : ", player.getName(), "id: ", player.getId(), "data: ", data});
        player.receive("area.soloPush.onFightPointPush", (GeneratedMessage) data.build());
    }

    public void pushRoundEnd(WNPlayer player, SoloHandler.RoundResult roundResult) {
        SoloHandler.OnRoundEndPush.Builder data = SoloHandler.OnRoundEndPush.newBuilder();
        data.setS2CCode(200);
        data.setS2CRoundResult(roundResult);
        Out.debug(new Object[]{getClass(), "pushRoundEnd : ", player.getName(), "id: ", player.getId(), "data: ", data});
        player.receive("area.soloPush.onRoundEndPush", (GeneratedMessage) data.build());
    }

    public void pushGameEnd(WNPlayer player, SoloHandler.GameResult gameResult, int gameOverTime, boolean isAddBox) {
        SoloHandler.OnGameEndPush.Builder data = SoloHandler.OnGameEndPush.newBuilder();
        data.setS2CCode(200);
        data.setS2CGameOverTime(gameOverTime);
        data.setS2CGameResult(gameResult);

        boolean finish = true;
        for (SoloDataPO.RankStatus s : player.soloManager.soloData.dailyRewards) {
            if (s.getStatus() == 0) {
                finish = false;
            }
        }
        if (isAddBox) {
            data.setDailyBattleTimes(GlobalConfig.Solo_PKForChest);
        } else if (!finish) {
            data.setDailyBattleTimes(player.soloManager.soloData.dailyBattleTimes);
        }
        Out.debug(new Object[]{getClass(), "pushGameEnd : ", player.getName(), "id: ", player.getId(), "data: ", data});
        player.receive("area.soloPush.onGameEndPush", (GeneratedMessage) data.build());
    }

    public void pushRebirth(WNPlayer player, String name) {
        Out.debug(new Object[]{WNNotifyManager.class, "pushRebirth: ", player.getName(), "id: ", player.getId(), "data:", name});

        PlayerHandler.PlayerSaverRebirthPush.Builder data = PlayerHandler.PlayerSaverRebirthPush.newBuilder();
        data.setSaverName(name);
        player.receive("area.playerPush.playerSaverRebirthPush", (GeneratedMessage) data.build());
    }

    public final void consignmentRemovePush(WNPlayer player, String id) {
        ConsignmentLineHandler.ConsignmentRemovePush.Builder push = ConsignmentLineHandler.ConsignmentRemovePush.newBuilder();
        push.setS2CCode(200);
        push.setS2CId(id);
        player.receive("area.consignmentLinePush.consignmentRemovePush", (GeneratedMessage) push.build());
    }


    public void pushActivityInfo(WNPlayer player, ArrayList<LimitTimeActivityHandler.ActivityInfo> activityInfo) {
    }


    public void updateScript(WNPlayer player) {
        player.updateSuperScriptList(player.getItemChangeScript());
    }

    public void pushPlayerBattleData(WNPlayer player) {
        if (player.btlDataManager == null)
            return;
        PlayerHandler.PlayerBattleAttributePush.Builder data = PlayerHandler.PlayerBattleAttributePush.newBuilder();
        Map<Const.PlayerBtlData, Integer> finalInflus = player.btlDataManager.finalInflus;
        for (Const.PlayerBtlData pbd : finalInflus.keySet()) {
            if (pbd == null)
                continue;
            Common.AttributeSimple.Builder as = Common.AttributeSimple.newBuilder();
            as.setId(pbd.id);
            as.setValue(((Integer) finalInflus.get(pbd)).intValue());
            data.addDatas(as);
        }
        player.receive("area.playerPush.playerBattleAttributePush", (GeneratedMessage) data.build());
    }
}


