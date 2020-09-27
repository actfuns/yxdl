package com.wanniu.game.farm;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GetLandCO;
import com.wanniu.game.data.MiscCO;
import com.wanniu.game.data.PlantLevelCO;
import com.wanniu.game.data.PlantShopCO;
import com.wanniu.game.data.PlantingCO;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.PlayerHandler;
import pomelo.farm.Farm;
import pomelo.farm.FarmHandler;


public class FarmMgr
        extends ModuleManager {
    public FarmPO myPO;
    private WNPlayer player;

    public enum BLOCK_STATE {
        CLOSED(0),
        OPENED(1),
        SOWED(2);

        public final int value;

        BLOCK_STATE(int value) {
            this.value = value;
        }
    }

    public enum SEED_STATE {
        UNSOWED(0),
        SEEDED(1),
        GROWED(2),
        MATURE(3),
        HARVESTABLE(4);

        public final int value;

        SEED_STATE(int value) {
            this.value = value;
        }
    }

    public enum CULTIVATE_TYPE {
        NONE(0),
        WATER(1),
        BUG(2),
        GRASS(3);

        public final int value;

        CULTIVATE_TYPE(int value) {
            this.value = value;
        }
    }

    public enum SEED_TYPE {
        APPLE(1),
        PEAR(2),
        PEACH(3),
        CHERRIES(4),
        GRAPE(5);

        public final int value;

        SEED_TYPE(int value) {
            this.value = value;
        }
    }

    public enum SEED_QUALITY {
        BLUE(1), PURPLE(2), ORANGE(3), GREE(4), RED(5);

        public final int value;

        SEED_QUALITY(int value) {
            this.value = value;
        }
    }

    public enum OPEN_BLOCK {
        LV(1), DIAMOND(2), MONTHCARD(3), FOREVERCARD(4);

        public final int value;

        OPEN_BLOCK(int value) {
            this.value = value;
        }
    }

    public enum RECORD_TYPE {
        FRIEND_WATER(1), FRIEND_BUG(2), FRIEND_GRASS(3), FRIEND_STEAL(4), SOW(5), WATER(6), BUG(7), GRASS(8),

        FORGET_WATER(10), FORGET_BUG(11), FORGET_GRASS(12), HARVEST(13);

        public final int value;

        RECORD_TYPE(int value) {
            this.value = value;
        }
    }


    public static class Block {
        public int blockId;


        public FarmMgr.BLOCK_STATE blockState = FarmMgr.BLOCK_STATE.CLOSED;
        public String seedCode = null;
        public FarmMgr.SEED_STATE seedState = FarmMgr.SEED_STATE.UNSOWED;
        public FarmMgr.CULTIVATE_TYPE cultivateType = FarmMgr.CULTIVATE_TYPE.NONE;
        public int friendCultivateNum = 0;
        public List<String> stolerList = new LinkedList<>();
        public Date nextTime = null;
        public int missTime = 0;

        public Block() {
        }

        public Block(int blockId) {
            this();
            this.blockId = blockId;
        }
    }


    public static class Seed {
        public String seedCode;


        public int num = 0;

        public Seed() {
        }

        public Seed(String seedCode, int num) {
            this();
            this.seedCode = seedCode;
            this.num = num;
        }
    }


    public static class Product {
        public String productCode;


        public int num = 0;

        public Product() {
        }

        public Product(String productCode, int num) {
            this();
            this.productCode = productCode;
            this.num = num;
        }
    }


    public static class RecordInfo {
        public FarmMgr.RECORD_TYPE recordType;


        public Date recordTime;

        public List<String> recordParams;


        public RecordInfo() {
            this.recordType = FarmMgr.RECORD_TYPE.WATER;
            this.recordTime = new Date();
            this.recordParams = new LinkedList<>();
        }


        public RecordInfo(FarmMgr.RECORD_TYPE recordType, List<String> recordParams) {
            this.recordType = recordType;
            this.recordTime = new Date();
            this.recordParams = recordParams;
        }
    }


    public FarmMgr(WNPlayer player) {
        this.player = player;
        this.myPO = getPlayerPO(player.getId());

        UpdateBlocks();

        Date now = new Date();
        if (!scheduleMap.containsKey(player.getId())) {
            Map<Integer, ScheduledFuture<?>> s_map = scheduleMap.put(player.getId(), new HashMap<>());
            for (Block block : this.myPO.blockMap.values()) {
                PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);


                if (block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) {
                    while (now.getTime() >= block.nextTime.getTime()) {
                        if (block.seedState == SEED_STATE.SEEDED) {
                            block.seedState = SEED_STATE.GROWED;
                            int nextStageProb = getNextStageProb(block);
                            long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);

                            block.nextTime = new Date(nextnextTimeStamp);
                            if (block.cultivateType != CULTIVATE_TYPE.NONE)
                                block.missTime++;
                            block.cultivateType = getRandomCultivateType();
                            continue;
                        }
                        if (block.seedState == SEED_STATE.GROWED) {
                            block.seedState = SEED_STATE.MATURE;
                            int nextStageProb = getNextStageProb(block);
                            long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);

                            block.nextTime = new Date(nextnextTimeStamp);
                            if (block.cultivateType != CULTIVATE_TYPE.NONE)
                                block.missTime++;
                            block.cultivateType = getRandomCultivateType();
                            continue;
                        }
                        if (block.seedState == SEED_STATE.MATURE) {
                            block.seedState = SEED_STATE.HARVESTABLE;


                            if (block.cultivateType != CULTIVATE_TYPE.NONE)
                                block.missTime++;
                            block.cultivateType = CULTIVATE_TYPE.NONE;

                            break;
                        }
                    }
                    if (block.seedState != SEED_STATE.HARVESTABLE) {
                        ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(new BlockTimerTask(this.myPO.playerId, block.blockId), block.nextTime.getTime() - now.getTime());
                        s_map.put(Integer.valueOf(block.blockId), scheduledFuture);
                    }
                }
            }
        }
    }


    public static int getNextStageProb(Block block) {
        int stageProb = -1;
        if (block.seedState == SEED_STATE.SEEDED) {
            stageProb = GlobalConfig.Planting_GrowStageProp;
        } else if (block.seedState == SEED_STATE.GROWED) {
            stageProb = GlobalConfig.Planting_MatureStageProp;
        }
        return stageProb;
    }


    public static CULTIVATE_TYPE getRandomCultivateType() {
        CULTIVATE_TYPE[] cultivateTypes = {CULTIVATE_TYPE.WATER, CULTIVATE_TYPE.BUG, CULTIVATE_TYPE.GRASS};
        return cultivateTypes[RandomUtil.getInt(0, cultivateTypes.length - 1)];
    }


    public static Date evaluateHarvestTime(String playerId, int blockId) {
        FarmPO tempPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        Block block = (Block) tempPO.blockMap.get(Integer.valueOf(blockId));
        PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);

        if (block.seedState == SEED_STATE.UNSOWED || block.seedState == SEED_STATE.HARVESTABLE) {
            return null;
        }
        long endTimeStamp = block.nextTime.getTime();
        if (block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) {
            endTimeStamp += (plantingCO.growTime * 60 * 1000 * GlobalConfig.Planting_SeedStageProp / 100);

            if (block.seedState == SEED_STATE.MATURE) {
                endTimeStamp += (plantingCO.growTime * 60 * 1000 * GlobalConfig.Planting_MatureStageProp / 100);
            }
        }

        return new Date(endTimeStamp);
    }


    public static Date getProtectEndTime(String playerId, int blockId) {
        FarmPO tempPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        Block block = (Block) tempPO.blockMap.get(Integer.valueOf(blockId));
        if (block.seedState != SEED_STATE.HARVESTABLE) {
            return null;
        }
        Date now = new Date();
        long protectEndTimeStamp = block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000);
        if (now.getTime() < protectEndTimeStamp) {
            return new Date(protectEndTimeStamp);
        }
        return null;
    }


    public static void AddRecord(Queue<RecordInfo> recordQueue, RecordInfo recordInfo) {
        if (recordQueue.size() >= GlobalConfig.Planting_MaxRecord) {
            recordQueue.poll();
        }
        recordQueue.add(recordInfo);
    }


    private static Map<String, Map<Integer, ScheduledFuture<?>>> scheduleMap = new HashMap<>();

    public static class BlockTimerTask extends TimerTask {
        String playerId;
        int blockId;

        public BlockTimerTask(String playerId, int blockId) {
            this.playerId = playerId;
            this.blockId = blockId;
        }


        public void run() {
            FarmPO tempPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, this.playerId, FarmPO.class);
            FarmMgr.Block block = (FarmMgr.Block) tempPO.blockMap.get(Integer.valueOf(this.blockId));
            PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);
            if (block.seedState == FarmMgr.SEED_STATE.SEEDED) {
                block.seedState = FarmMgr.SEED_STATE.GROWED;
                int nextStageProb = FarmMgr.getNextStageProb(block);
                long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);

                block.nextTime = new Date(nextnextTimeStamp);
                if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
                    block.missTime++;

                    FarmMgr.RECORD_TYPE recordType = null;
                    if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
                    }
                    List<String> recordParams = new LinkedList<>();
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
                    FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
                }
                block.cultivateType = FarmMgr.getRandomCultivateType();
            } else if (block.seedState == FarmMgr.SEED_STATE.GROWED) {
                block.seedState = FarmMgr.SEED_STATE.MATURE;
                int nextStageProb = FarmMgr.getNextStageProb(block);
                long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);

                block.nextTime = new Date(nextnextTimeStamp);
                if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
                    block.missTime++;

                    FarmMgr.RECORD_TYPE recordType = null;
                    if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
                    }
                    List<String> recordParams = new LinkedList<>();
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
                    FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
                }
                block.cultivateType = FarmMgr.getRandomCultivateType();
            } else if (block.seedState == FarmMgr.SEED_STATE.MATURE) {
                block.seedState = FarmMgr.SEED_STATE.HARVESTABLE;


                if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
                    block.missTime++;

                    FarmMgr.RECORD_TYPE recordType = null;
                    if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
                    } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
                        recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
                    }
                    List<String> recordParams = new LinkedList<>();
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
                    FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
                    FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
                }
                block.cultivateType = FarmMgr.getRandomCultivateType();
            }


            if (block.seedState != FarmMgr.SEED_STATE.HARVESTABLE) {
                ScheduledFuture<?> scheduledFuture2 = JobFactory.addDelayJob(new BlockTimerTask(tempPO.playerId, block.blockId), block.nextTime.getTime() - (new Date()).getTime());
                ((Map<Integer, ScheduledFuture<?>>) FarmMgr.scheduleMap.get(this.playerId)).put(Integer.valueOf(block.blockId), scheduledFuture2);
            }
        }
    }


    public FarmPO getPlayerPO(String playerId) {
        FarmPO po = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        if (po == null) {
            po = new FarmPO(playerId);
            PlayerPOManager.put(ConstsTR.player_farmTR, playerId, (GEntity) po);
        }

        return po;
    }


    public boolean getPlayerSowable(String playerId) {
        FarmPO playerPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        if (playerPO == null) {
            return false;
        }
        boolean sowable = false;
        for (Block block : playerPO.blockMap.values()) {
            if (block.blockState == BLOCK_STATE.OPENED) {
                sowable = true;

                break;
            }
        }
        return sowable;
    }


    public boolean getPlayerCultivatable(String playerId) {
        for (Block block : this.myPO.blockMap.values()) {
            if (block.blockState == BLOCK_STATE.SOWED && (
                    block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) &&
                    block.cultivateType != CULTIVATE_TYPE.NONE) {
                return true;
            }
        }


        return false;
    }


    public boolean getFriendCultivatable(String friendId) {
        FarmPO friendPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, friendId, FarmPO.class);
        if (friendPO == null) {
            return false;
        }
        if (friendPO.blockMap == null) {
            return false;
        }
        Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
        if (!friendIdSet.contains(friendId)) {
            return false;
        }
        for (Block block : friendPO.blockMap.values()) {
            if (block.blockState == BLOCK_STATE.SOWED && (
                    block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) &&
                    block.cultivateType != CULTIVATE_TYPE.NONE) {
                return true;
            }
        }


        return false;
    }


    public boolean getPlayerHarvestable(String playerId) {
        for (Block block : this.myPO.blockMap.values()) {
            if (block.blockState == BLOCK_STATE.SOWED &&
                    block.seedState == SEED_STATE.HARVESTABLE) {
                return true;
            }
        }


        return false;
    }


    public boolean getPlayerStealable(String playerId) {
        FarmPO playerPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        if (playerPO == null) {
            return false;
        }
        if (playerPO.blockMap == null) {
            return false;
        }

        for (Block block : playerPO.blockMap.values()) {
            if (block.blockState == BLOCK_STATE.SOWED &&
                    block.seedState == SEED_STATE.MATURE) {
                Date now = new Date();
                if (now.getTime() >= block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000)) {
                    if (!block.stolerList.contains(this.myPO.playerId)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }


    public void UpdateBlocks() {
        for (Block block : this.myPO.blockMap.values()) {
            GetLandCO getLandCO = (GetLandCO) GameData.GetLands.get(Integer.valueOf(block.blockId));

            boolean open = false;

            if (getLandCO.getType == OPEN_BLOCK.LV.value) {
                if (this.player.getLevel() >= getLandCO.value) {
                    open = true;
                }
            } else if (getLandCO.getType == OPEN_BLOCK.DIAMOND.value) {
                if (Const.VipType.month.value == this.player.baseDataManager.getVip() || Const.VipType.sb_double.value == this.player.baseDataManager.getVip()) {
                    open = true;
                }
            } else if (getLandCO.getType == OPEN_BLOCK.FOREVERCARD.value && (
                    Const.VipType.forever.value == this.player.baseDataManager.getVip() || Const.VipType.sb_double.value == this.player.baseDataManager.getVip())) {
                open = true;
            }


            if (open) {
                block.blockState = BLOCK_STATE.OPENED;
                block.seedState = SEED_STATE.UNSOWED;
            }
        }


        updateSuperScriptList();
    }


    public boolean open(int blockId) {
        GetLandCO getLandCO = (GetLandCO) GameData.GetLands.get(Integer.valueOf(blockId));


        if (getLandCO.getType != OPEN_BLOCK.DIAMOND.value) {
            return false;
        }


        if (!this.player.moneyManager.enoughDiamond(getLandCO.value)) {
            return false;
        }

        Block block = (Block) this.myPO.blockMap.get(Integer.valueOf(blockId));

        if (block.blockState != BLOCK_STATE.CLOSED) {
            return false;
        }

        this.player.moneyManager.costDiamond(getLandCO.value, Const.GOODS_CHANGE_TYPE.FarmOpen);

        block.blockState = BLOCK_STATE.OPENED;
        block.seedState = SEED_STATE.UNSOWED;

        updateSuperScriptList();

        return true;
    }


    public boolean sow(int blockId, String seedCode) {
        Block block = (Block) this.myPO.blockMap.get(Integer.valueOf(blockId));
        PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);


        if (block.blockState != BLOCK_STATE.OPENED) {
            return false;
        }


        if (this.myPO.lv < plantingCO.plantLevel) {
            return false;
        }

        int seedNum = this.player.bag.findItemNumByCode(seedCode);


        if (seedNum < 1) {
            return false;
        }

        this.player.bag.discardItem(seedCode, 1, Const.GOODS_CHANGE_TYPE.FarmSow);

        block.seedCode = seedCode;
        block.blockState = BLOCK_STATE.SOWED;
        block.seedState = SEED_STATE.SEEDED;


        block.cultivateType = getRandomCultivateType();

        int nextStageProb = getNextStageProb(block);
        long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
        block.nextTime = new Date(nextnextTimeStamp);


        RECORD_TYPE recordType = RECORD_TYPE.SOW;

        List<String> recordParams = new LinkedList<>();
        recordParams.add(plantingCO.name);
        RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
        AddRecord(this.myPO.recordLs, recordInfo);

        ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(new BlockTimerTask(this.myPO.playerId, block.blockId), nextnextTimeStamp);
        ((Map<Integer, ScheduledFuture<?>>) scheduleMap.get(this.myPO.playerId)).put(Integer.valueOf(block.blockId), scheduledFuture);

        updateSuperScriptList();

        return true;
    }


    public FarmHandler.CultivateFriendResponse.Builder cultivateFriend(int blockId, String playerId) {
        FarmHandler.CultivateFriendResponse.Builder builder = FarmHandler.CultivateFriendResponse.newBuilder();


        Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
        if (!friendIdSet.contains(playerId)) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));

            return builder;
        }

        FarmPO friendPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        if (friendPO == null) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_PLAYER_PO_NOT_FOUND"));

            return builder;
        }
        Block block = (Block) friendPO.blockMap.get(Integer.valueOf(blockId));


        if (block.blockState != BLOCK_STATE.SOWED) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));

            return builder;
        }


        if (block.cultivateType == CULTIVATE_TYPE.NONE) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_CULTIVATE_FAIL"));

            return builder;
        }


        RECORD_TYPE recordType = null;
        if (block.cultivateType == CULTIVATE_TYPE.WATER) {
            recordType = RECORD_TYPE.FRIEND_WATER;
        } else if (block.cultivateType == CULTIVATE_TYPE.BUG) {
            recordType = RECORD_TYPE.FRIEND_BUG;
        } else if (block.cultivateType == CULTIVATE_TYPE.GRASS) {
            recordType = RECORD_TYPE.FRIEND_GRASS;
        }
        List<String> recordParams = new LinkedList<>();
        recordParams.add(this.player.getName());
        RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
        AddRecord(friendPO.recordLs, recordInfo);


        block.cultivateType = CULTIVATE_TYPE.NONE;
        int fate = this.player.processXianYuanGet(GlobalConfig.Fate_Plant);

        builder.setFate(fate);
        builder.setS2CCode(200);

        updateSuperScriptList();

        return builder;
    }


    public boolean cultivateSelf(int blockId) {
        Block block = (Block) this.myPO.blockMap.get(Integer.valueOf(blockId));


        if (block.blockState != BLOCK_STATE.SOWED) {
            return false;
        }


        if (block.cultivateType == CULTIVATE_TYPE.NONE) {
            return false;
        }


        RECORD_TYPE recordType = null;
        if (block.cultivateType == CULTIVATE_TYPE.WATER) {
            recordType = RECORD_TYPE.WATER;
        } else if (block.cultivateType == CULTIVATE_TYPE.BUG) {
            recordType = RECORD_TYPE.BUG;
        } else if (block.cultivateType == CULTIVATE_TYPE.GRASS) {
            recordType = RECORD_TYPE.GRASS;
        }
        List<String> recordParams = new LinkedList<>();
        PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);
        recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
        RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
        AddRecord(this.myPO.recordLs, recordInfo);

        block.cultivateType = CULTIVATE_TYPE.NONE;

        updateSuperScriptList();

        return true;
    }


    public FarmHandler.HarvestResponse.Builder harvest(int blockId) {
        FarmHandler.HarvestResponse.Builder builder = FarmHandler.HarvestResponse.newBuilder();

        Block block = (Block) this.myPO.blockMap.get(Integer.valueOf(blockId));


        if (block.blockState != BLOCK_STATE.SOWED) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));
            return builder;
        }


        if (block.seedState != SEED_STATE.HARVESTABLE) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_UNMATURE"));
            return builder;
        }


        PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);
        PlantLevelCO plantLevelCO = (PlantLevelCO) GameData.PlantLevels.get(Integer.valueOf(this.myPO.lv));
        PlantLevelCO plantLevelCOMax = (PlantLevelCO) GameData.PlantLevels.get(Integer.valueOf(GameData.PlantLevels.size()));
        if (this.myPO.lv < plantLevelCOMax.level) {
            this.myPO.exp += plantingCO.getExp;
            if (this.myPO.exp >= plantLevelCO.exp) {
                this.myPO.lv++;
                this.myPO.exp -= plantingCO.getExp;
                if (this.myPO.lv == plantLevelCOMax.level) {
                    this.myPO.exp = 0;
                }
            }
        }


        int rewardNum = plantingCO.harvest * (100 - block.missTime * GlobalConfig.Planting_DeductionProp) * (100 + plantLevelCO.harvestAdd) * (100 - block.stolerList.size() * (100 - GlobalConfig.Planting_StealProp)) / 1000000;
        this.player.bag.addCodeItemMail(plantingCO.product, rewardNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmHarvest, "Bag_full_common");


        block.blockState = BLOCK_STATE.OPENED;
        block.seedCode = null;
        block.seedState = SEED_STATE.UNSOWED;
        block.cultivateType = CULTIVATE_TYPE.NONE;
        block.friendCultivateNum = 0;
        block.stolerList.clear();
        block.nextTime = null;
        block.missTime = 0;


        RECORD_TYPE recordType = RECORD_TYPE.HARVEST;

        List<String> recordParams = new LinkedList<>();
        recordParams.add(String.valueOf(rewardNum));
        recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
        RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
        AddRecord(this.myPO.recordLs, recordInfo);

        Farm.Block.Builder farmBlockBuilder = Farm.Block.newBuilder();
        farmBlockBuilder.setBlockId(blockId);
        farmBlockBuilder.setBlockState(block.blockState.value);
        farmBlockBuilder.setSeedCode(block.seedCode);
        farmBlockBuilder.setSeedState(block.seedState.value);
        farmBlockBuilder.setCultivateType(block.cultivateType.value);

        builder.setBlock(farmBlockBuilder.build());

        builder.setS2CCode(200);


        updateSuperScriptList();

        return builder;
    }


    public FarmHandler.StealResponse.Builder steal(int blockId, String playerId) {
        FarmHandler.StealResponse.Builder builder = FarmHandler.StealResponse.newBuilder();


        Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
        if (!friendIdSet.contains(playerId)) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));

            return builder;
        }

        FarmPO friendPO = (FarmPO) PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
        if (friendPO == null) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_PLAYER_PO_NOT_FOUND"));

            return builder;
        }
        Block block = (Block) friendPO.blockMap.get(Integer.valueOf(blockId));


        if (block.blockState != BLOCK_STATE.SOWED) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));
            return builder;
        }


        if (block.seedState != SEED_STATE.HARVESTABLE) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_UNMATURE"));
            return builder;
        }


        Date now = new Date();
        if (now.getTime() < block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000)) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_IN_PROTECTION"));
            return builder;
        }


        if (block.stolerList.contains(this.myPO.playerId)) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("FARM_CANNOT_STEAL"));
            return builder;
        }


        PlantingCO plantingCO = (PlantingCO) ItemConfig.plantingMap.get(block.seedCode);
        PlantLevelCO plantLevelCO = (PlantLevelCO) GameData.PlantLevels.get(Integer.valueOf(friendPO.lv));
        int awardNum = plantingCO.harvest * (100 - block.missTime * GlobalConfig.Planting_DeductionProp) * (100 + plantLevelCO.harvestAdd) * GlobalConfig.Planting_StealProp / 1000000;
        this.player.bag.addCodeItemMail(plantingCO.product, awardNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmSteal, "Bag_full_common");
        block.stolerList.add(this.myPO.playerId);


        RECORD_TYPE recordType = RECORD_TYPE.FRIEND_STEAL;

        List<String> recordParams = new LinkedList<>();
        recordParams.add(this.player.getName());
        recordParams.add(String.valueOf(awardNum));
        recordParams.add(((MiscCO) GameData.Miscs.get(plantingCO.product)).name);
        RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
        AddRecord(this.myPO.recordLs, recordInfo);

        builder.setProductCode(plantingCO.product);
        builder.setNum(awardNum);
        builder.setS2CCode(200);

        updateSuperScriptList();

        return builder;
    }


    public boolean ChangeShopItem(int itemId) {
        PlantShopCO plantShopCO = (PlantShopCO) GameData.PlantShops.get(Integer.valueOf(itemId));
        if (this.myPO.shopToday.containsKey(Integer.valueOf(itemId)) && (
                (Integer) this.myPO.shopToday.get(Integer.valueOf(itemId))).intValue() >= plantShopCO.changeNum) {
            return false;
        }
        if (!this.player.bag.discardItemsByCode(plantShopCO.parameter, Const.GOODS_CHANGE_TYPE.FarmChange))
            return false;
        List<WNBag.SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(plantShopCO.parameter);
        for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
            this.player.bag.addCodeItemMail(simpleItemInfo.itemCode, simpleItemInfo.itemNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmChange, "Bag_full_common");
        }
        return true;
    }

    public void refreshNewDay() {
        this.myPO.shopToday.clear();

        updateSuperScriptList();
    }

    public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
        List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();

        int meSowable = getPlayerSowable(this.player.getId()) ? 1 : 0;
        int meCultivatable = getPlayerCultivatable(this.player.getId()) ? 1 : 0;
        int meHarvestable = getPlayerHarvestable(this.player.getId()) ? 1 : 0;

        ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FARM_CULTIVATE.getValue(), meSowable + meCultivatable + meHarvestable));

        for (String friendId : this.player.friendManager.getAllFriendId()) {
            int friendStealable = getPlayerStealable(friendId) ? 1 : 0;
            int friendCultivatable = getFriendCultivatable(friendId) ? 1 : 0;
            ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FARM_FRIEND.getValue(), friendStealable + friendCultivatable));
        }

        return ls;
    }

    private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(type);
        data.setNumber(num);
        return data.build();
    }

    public void updateSuperScriptList() {
        List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
        this.player.updateSuperScriptList(ls);
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
            case PAY:
                UpdateBlocks();
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.FARM;
    }
}


