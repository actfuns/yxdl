/*      */ package com.wanniu.game.farm;
/*      */ 
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.game.bag.WNBag;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.ModuleManager;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.GetLandCO;
/*      */ import com.wanniu.game.data.MiscCO;
/*      */ import com.wanniu.game.data.PlantLevelCO;
/*      */ import com.wanniu.game.data.PlantShopCO;
/*      */ import com.wanniu.game.data.PlantingCO;
/*      */ import com.wanniu.game.item.ItemConfig;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.FarmPO;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.TimerTask;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.farm.Farm;
/*      */ import pomelo.farm.FarmHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FarmMgr
/*      */   extends ModuleManager
/*      */ {
/*      */   public FarmPO myPO;
/*      */   private WNPlayer player;
/*      */   
/*      */   public enum BLOCK_STATE
/*      */   {
/*   57 */     CLOSED(0),
/*   58 */     OPENED(1),
/*   59 */     SOWED(2);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     BLOCK_STATE(int value) {
/*   64 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SEED_STATE {
/*   69 */     UNSOWED(0),
/*   70 */     SEEDED(1),
/*   71 */     GROWED(2),
/*   72 */     MATURE(3),
/*   73 */     HARVESTABLE(4);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     SEED_STATE(int value) {
/*   78 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum CULTIVATE_TYPE {
/*   83 */     NONE(0),
/*   84 */     WATER(1),
/*   85 */     BUG(2),
/*   86 */     GRASS(3);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     CULTIVATE_TYPE(int value) {
/*   91 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SEED_TYPE {
/*   96 */     APPLE(1),
/*   97 */     PEAR(2),
/*   98 */     PEACH(3),
/*   99 */     CHERRIES(4),
/*  100 */     GRAPE(5);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     SEED_TYPE(int value) {
/*  105 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum SEED_QUALITY {
/*  110 */     BLUE(1), PURPLE(2), ORANGE(3), GREE(4), RED(5);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     SEED_QUALITY(int value) {
/*  115 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum OPEN_BLOCK {
/*  120 */     LV(1), DIAMOND(2), MONTHCARD(3), FOREVERCARD(4);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     OPEN_BLOCK(int value) {
/*  125 */       this.value = value;
/*      */     }
/*      */   }
/*      */   
/*      */   public enum RECORD_TYPE {
/*  130 */     FRIEND_WATER(1), FRIEND_BUG(2), FRIEND_GRASS(3), FRIEND_STEAL(4), SOW(5), WATER(6), BUG(7), GRASS(8),
/*      */     
/*  132 */     FORGET_WATER(10), FORGET_BUG(11), FORGET_GRASS(12), HARVEST(13);
/*      */     
/*      */     public final int value;
/*      */     
/*      */     RECORD_TYPE(int value) {
/*  137 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Block
/*      */   {
/*      */     public int blockId;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  165 */     public FarmMgr.BLOCK_STATE blockState = FarmMgr.BLOCK_STATE.CLOSED;
/*  166 */     public String seedCode = null;
/*  167 */     public FarmMgr.SEED_STATE seedState = FarmMgr.SEED_STATE.UNSOWED;
/*  168 */     public FarmMgr.CULTIVATE_TYPE cultivateType = FarmMgr.CULTIVATE_TYPE.NONE;
/*  169 */     public int friendCultivateNum = 0;
/*  170 */     public List<String> stolerList = new LinkedList<>();
/*  171 */     public Date nextTime = null;
/*  172 */     public int missTime = 0;
/*      */     public Block() {}
/*      */     
/*      */     public Block(int blockId) {
/*  176 */       this();
/*  177 */       this.blockId = blockId;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Seed
/*      */   {
/*      */     public String seedCode;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  193 */     public int num = 0;
/*      */     public Seed() {}
/*      */     
/*      */     public Seed(String seedCode, int num) {
/*  197 */       this();
/*  198 */       this.seedCode = seedCode;
/*  199 */       this.num = num;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Product
/*      */   {
/*      */     public String productCode;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  215 */     public int num = 0;
/*      */     public Product() {}
/*      */     
/*      */     public Product(String productCode, int num) {
/*  219 */       this();
/*  220 */       this.productCode = productCode;
/*  221 */       this.num = num;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class RecordInfo
/*      */   {
/*      */     public FarmMgr.RECORD_TYPE recordType;
/*      */ 
/*      */     
/*      */     public Date recordTime;
/*      */     
/*      */     public List<String> recordParams;
/*      */ 
/*      */     
/*      */     public RecordInfo() {
/*  238 */       this.recordType = FarmMgr.RECORD_TYPE.WATER;
/*  239 */       this.recordTime = new Date();
/*  240 */       this.recordParams = new LinkedList<>();
/*      */     }
/*      */ 
/*      */     
/*      */     public RecordInfo(FarmMgr.RECORD_TYPE recordType, List<String> recordParams) {
/*  245 */       this.recordType = recordType;
/*  246 */       this.recordTime = new Date();
/*  247 */       this.recordParams = recordParams;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public FarmMgr(WNPlayer player) {
/*  253 */     this.player = player;
/*  254 */     this.myPO = getPlayerPO(player.getId());
/*      */     
/*  256 */     UpdateBlocks();
/*      */     
/*  258 */     Date now = new Date();
/*  259 */     if (!scheduleMap.containsKey(player.getId())) {
/*  260 */       Map<Integer, ScheduledFuture<?>> s_map = scheduleMap.put(player.getId(), new HashMap<>());
/*  261 */       for (Block block : this.myPO.blockMap.values()) {
/*  262 */         PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*      */ 
/*      */         
/*  265 */         if (block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) {
/*  266 */           while (now.getTime() >= block.nextTime.getTime()) {
/*  267 */             if (block.seedState == SEED_STATE.SEEDED) {
/*  268 */               block.seedState = SEED_STATE.GROWED;
/*  269 */               int nextStageProb = getNextStageProb(block);
/*  270 */               long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
/*      */               
/*  272 */               block.nextTime = new Date(nextnextTimeStamp);
/*  273 */               if (block.cultivateType != CULTIVATE_TYPE.NONE)
/*  274 */                 block.missTime++; 
/*  275 */               block.cultivateType = getRandomCultivateType(); continue;
/*  276 */             }  if (block.seedState == SEED_STATE.GROWED) {
/*  277 */               block.seedState = SEED_STATE.MATURE;
/*  278 */               int nextStageProb = getNextStageProb(block);
/*  279 */               long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
/*      */               
/*  281 */               block.nextTime = new Date(nextnextTimeStamp);
/*  282 */               if (block.cultivateType != CULTIVATE_TYPE.NONE)
/*  283 */                 block.missTime++; 
/*  284 */               block.cultivateType = getRandomCultivateType(); continue;
/*  285 */             }  if (block.seedState == SEED_STATE.MATURE) {
/*  286 */               block.seedState = SEED_STATE.HARVESTABLE;
/*      */ 
/*      */               
/*  289 */               if (block.cultivateType != CULTIVATE_TYPE.NONE)
/*  290 */                 block.missTime++; 
/*  291 */               block.cultivateType = CULTIVATE_TYPE.NONE;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*  296 */           if (block.seedState != SEED_STATE.HARVESTABLE) {
/*  297 */             ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(new BlockTimerTask(this.myPO.playerId, block.blockId), block.nextTime.getTime() - now.getTime());
/*  298 */             s_map.put(Integer.valueOf(block.blockId), scheduledFuture);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getNextStageProb(Block block) {
/*  310 */     int stageProb = -1;
/*  311 */     if (block.seedState == SEED_STATE.SEEDED) {
/*  312 */       stageProb = GlobalConfig.Planting_GrowStageProp;
/*  313 */     } else if (block.seedState == SEED_STATE.GROWED) {
/*  314 */       stageProb = GlobalConfig.Planting_MatureStageProp;
/*      */     } 
/*  316 */     return stageProb;
/*      */   }
/*      */ 
/*      */   
/*      */   public static CULTIVATE_TYPE getRandomCultivateType() {
/*  321 */     CULTIVATE_TYPE[] cultivateTypes = { CULTIVATE_TYPE.WATER, CULTIVATE_TYPE.BUG, CULTIVATE_TYPE.GRASS };
/*  322 */     return cultivateTypes[RandomUtil.getInt(0, cultivateTypes.length - 1)];
/*      */   }
/*      */ 
/*      */   
/*      */   public static Date evaluateHarvestTime(String playerId, int blockId) {
/*  327 */     FarmPO tempPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  328 */     Block block = (Block)tempPO.blockMap.get(Integer.valueOf(blockId));
/*  329 */     PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*      */     
/*  331 */     if (block.seedState == SEED_STATE.UNSOWED || block.seedState == SEED_STATE.HARVESTABLE) {
/*  332 */       return null;
/*      */     }
/*  334 */     long endTimeStamp = block.nextTime.getTime();
/*  335 */     if (block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) {
/*  336 */       endTimeStamp += (plantingCO.growTime * 60 * 1000 * GlobalConfig.Planting_SeedStageProp / 100);
/*      */       
/*  338 */       if (block.seedState == SEED_STATE.MATURE) {
/*  339 */         endTimeStamp += (plantingCO.growTime * 60 * 1000 * GlobalConfig.Planting_MatureStageProp / 100);
/*      */       }
/*      */     } 
/*      */     
/*  343 */     return new Date(endTimeStamp);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date getProtectEndTime(String playerId, int blockId) {
/*  349 */     FarmPO tempPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  350 */     Block block = (Block)tempPO.blockMap.get(Integer.valueOf(blockId));
/*  351 */     if (block.seedState != SEED_STATE.HARVESTABLE) {
/*  352 */       return null;
/*      */     }
/*  354 */     Date now = new Date();
/*  355 */     long protectEndTimeStamp = block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000);
/*  356 */     if (now.getTime() < protectEndTimeStamp) {
/*  357 */       return new Date(protectEndTimeStamp);
/*      */     }
/*  359 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void AddRecord(Queue<RecordInfo> recordQueue, RecordInfo recordInfo) {
/*  366 */     if (recordQueue.size() >= GlobalConfig.Planting_MaxRecord) {
/*  367 */       recordQueue.poll();
/*      */     }
/*  369 */     recordQueue.add(recordInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*  374 */   private static Map<String, Map<Integer, ScheduledFuture<?>>> scheduleMap = new HashMap<>();
/*      */   
/*      */   public static class BlockTimerTask extends TimerTask {
/*      */     String playerId;
/*      */     int blockId;
/*      */     
/*      */     public BlockTimerTask(String playerId, int blockId) {
/*  381 */       this.playerId = playerId;
/*  382 */       this.blockId = blockId;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void run() {
/*  389 */       FarmPO tempPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, this.playerId, FarmPO.class);
/*  390 */       FarmMgr.Block block = (FarmMgr.Block)tempPO.blockMap.get(Integer.valueOf(this.blockId));
/*  391 */       PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*  392 */       if (block.seedState == FarmMgr.SEED_STATE.SEEDED) {
/*  393 */         block.seedState = FarmMgr.SEED_STATE.GROWED;
/*  394 */         int nextStageProb = FarmMgr.getNextStageProb(block);
/*  395 */         long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
/*      */         
/*  397 */         block.nextTime = new Date(nextnextTimeStamp);
/*  398 */         if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
/*  399 */           block.missTime++;
/*      */           
/*  401 */           FarmMgr.RECORD_TYPE recordType = null;
/*  402 */           if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
/*  403 */             recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
/*  404 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
/*  405 */             recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
/*  406 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
/*  407 */             recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
/*  408 */           }  List<String> recordParams = new LinkedList<>();
/*  409 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  410 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  411 */           FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
/*  412 */           FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
/*      */         } 
/*  414 */         block.cultivateType = FarmMgr.getRandomCultivateType();
/*  415 */       } else if (block.seedState == FarmMgr.SEED_STATE.GROWED) {
/*  416 */         block.seedState = FarmMgr.SEED_STATE.MATURE;
/*  417 */         int nextStageProb = FarmMgr.getNextStageProb(block);
/*  418 */         long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
/*      */         
/*  420 */         block.nextTime = new Date(nextnextTimeStamp);
/*  421 */         if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
/*  422 */           block.missTime++;
/*      */           
/*  424 */           FarmMgr.RECORD_TYPE recordType = null;
/*  425 */           if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
/*  426 */             recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
/*  427 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
/*  428 */             recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
/*  429 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
/*  430 */             recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
/*  431 */           }  List<String> recordParams = new LinkedList<>();
/*  432 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  433 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  434 */           FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
/*  435 */           FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
/*      */         } 
/*  437 */         block.cultivateType = FarmMgr.getRandomCultivateType();
/*  438 */       } else if (block.seedState == FarmMgr.SEED_STATE.MATURE) {
/*  439 */         block.seedState = FarmMgr.SEED_STATE.HARVESTABLE;
/*      */ 
/*      */         
/*  442 */         if (block.cultivateType != FarmMgr.CULTIVATE_TYPE.NONE) {
/*  443 */           block.missTime++;
/*      */           
/*  445 */           FarmMgr.RECORD_TYPE recordType = null;
/*  446 */           if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.WATER) {
/*  447 */             recordType = FarmMgr.RECORD_TYPE.FORGET_WATER;
/*  448 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.BUG) {
/*  449 */             recordType = FarmMgr.RECORD_TYPE.FORGET_BUG;
/*  450 */           } else if (block.cultivateType == FarmMgr.CULTIVATE_TYPE.GRASS) {
/*  451 */             recordType = FarmMgr.RECORD_TYPE.FORGET_GRASS;
/*  452 */           }  List<String> recordParams = new LinkedList<>();
/*  453 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  454 */           recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  455 */           FarmMgr.RecordInfo recordInfo = new FarmMgr.RecordInfo(recordType, recordParams);
/*  456 */           FarmMgr.AddRecord(tempPO.recordLs, recordInfo);
/*      */         } 
/*  458 */         block.cultivateType = FarmMgr.getRandomCultivateType();
/*      */       } 
/*      */ 
/*      */       
/*  462 */       if (block.seedState != FarmMgr.SEED_STATE.HARVESTABLE) {
/*  463 */         ScheduledFuture<?> scheduledFuture2 = JobFactory.addDelayJob(new BlockTimerTask(tempPO.playerId, block.blockId), block.nextTime.getTime() - (new Date()).getTime());
/*  464 */         ((Map<Integer, ScheduledFuture<?>>)FarmMgr.scheduleMap.get(this.playerId)).put(Integer.valueOf(block.blockId), scheduledFuture2);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public FarmPO getPlayerPO(String playerId) {
/*  472 */     FarmPO po = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  473 */     if (po == null) {
/*  474 */       po = new FarmPO(playerId);
/*  475 */       PlayerPOManager.put(ConstsTR.player_farmTR, playerId, (GEntity)po);
/*      */     } 
/*      */     
/*  478 */     return po;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getPlayerSowable(String playerId) {
/*  483 */     FarmPO playerPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  484 */     if (playerPO == null)
/*      */     {
/*  486 */       return false;
/*      */     }
/*  488 */     boolean sowable = false;
/*  489 */     for (Block block : playerPO.blockMap.values()) {
/*  490 */       if (block.blockState == BLOCK_STATE.OPENED) {
/*  491 */         sowable = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  496 */     return sowable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPlayerCultivatable(String playerId) {
/*  507 */     for (Block block : this.myPO.blockMap.values()) {
/*  508 */       if (block.blockState == BLOCK_STATE.SOWED && (
/*  509 */         block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) && 
/*  510 */         block.cultivateType != CULTIVATE_TYPE.NONE) {
/*  511 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  517 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getFriendCultivatable(String friendId) {
/*  522 */     FarmPO friendPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, friendId, FarmPO.class);
/*  523 */     if (friendPO == null)
/*      */     {
/*  525 */       return false;
/*      */     }
/*  527 */     if (friendPO.blockMap == null)
/*      */     {
/*  529 */       return false;
/*      */     }
/*  531 */     Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
/*  532 */     if (!friendIdSet.contains(friendId))
/*      */     {
/*  534 */       return false;
/*      */     }
/*  536 */     for (Block block : friendPO.blockMap.values()) {
/*  537 */       if (block.blockState == BLOCK_STATE.SOWED && (
/*  538 */         block.seedState == SEED_STATE.SEEDED || block.seedState == SEED_STATE.GROWED || block.seedState == SEED_STATE.MATURE) && 
/*  539 */         block.cultivateType != CULTIVATE_TYPE.NONE) {
/*  540 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  546 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPlayerHarvestable(String playerId) {
/*  557 */     for (Block block : this.myPO.blockMap.values()) {
/*  558 */       if (block.blockState == BLOCK_STATE.SOWED && 
/*  559 */         block.seedState == SEED_STATE.HARVESTABLE) {
/*  560 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  565 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getPlayerStealable(String playerId) {
/*  570 */     FarmPO playerPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  571 */     if (playerPO == null)
/*      */     {
/*  573 */       return false;
/*      */     }
/*  575 */     if (playerPO.blockMap == null)
/*      */     {
/*  577 */       return false;
/*      */     }
/*      */     
/*  580 */     for (Block block : playerPO.blockMap.values()) {
/*  581 */       if (block.blockState == BLOCK_STATE.SOWED && 
/*  582 */         block.seedState == SEED_STATE.MATURE) {
/*  583 */         Date now = new Date();
/*  584 */         if (now.getTime() >= block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000))
/*      */         {
/*  586 */           if (!block.stolerList.contains(this.myPO.playerId)) {
/*  587 */             return true;
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  595 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void UpdateBlocks() {
/*  652 */     for (Block block : this.myPO.blockMap.values()) {
/*  653 */       GetLandCO getLandCO = (GetLandCO)GameData.GetLands.get(Integer.valueOf(block.blockId));
/*      */       
/*  655 */       boolean open = false;
/*      */       
/*  657 */       if (getLandCO.getType == OPEN_BLOCK.LV.value) {
/*  658 */         if (this.player.getLevel() >= getLandCO.value) {
/*  659 */           open = true;
/*      */         }
/*  661 */       } else if (getLandCO.getType == OPEN_BLOCK.DIAMOND.value) {
/*  662 */         if (Const.VipType.month.value == this.player.baseDataManager.getVip() || Const.VipType.sb_double.value == this.player.baseDataManager.getVip()) {
/*  663 */           open = true;
/*      */         }
/*  665 */       } else if (getLandCO.getType == OPEN_BLOCK.FOREVERCARD.value && (
/*  666 */         Const.VipType.forever.value == this.player.baseDataManager.getVip() || Const.VipType.sb_double.value == this.player.baseDataManager.getVip())) {
/*  667 */         open = true;
/*      */       } 
/*      */ 
/*      */       
/*  671 */       if (open) {
/*  672 */         block.blockState = BLOCK_STATE.OPENED;
/*  673 */         block.seedState = SEED_STATE.UNSOWED;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  678 */     updateSuperScriptList();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean open(int blockId) {
/*  683 */     GetLandCO getLandCO = (GetLandCO)GameData.GetLands.get(Integer.valueOf(blockId));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  692 */     if (getLandCO.getType != OPEN_BLOCK.DIAMOND.value) {
/*  693 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  697 */     if (!this.player.moneyManager.enoughDiamond(getLandCO.value)) {
/*  698 */       return false;
/*      */     }
/*      */     
/*  701 */     Block block = (Block)this.myPO.blockMap.get(Integer.valueOf(blockId));
/*      */     
/*  703 */     if (block.blockState != BLOCK_STATE.CLOSED) {
/*  704 */       return false;
/*      */     }
/*      */     
/*  707 */     this.player.moneyManager.costDiamond(getLandCO.value, Const.GOODS_CHANGE_TYPE.FarmOpen);
/*      */     
/*  709 */     block.blockState = BLOCK_STATE.OPENED;
/*  710 */     block.seedState = SEED_STATE.UNSOWED;
/*      */     
/*  712 */     updateSuperScriptList();
/*      */     
/*  714 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean sow(int blockId, String seedCode) {
/*  719 */     Block block = (Block)this.myPO.blockMap.get(Integer.valueOf(blockId));
/*  720 */     PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     if (block.blockState != BLOCK_STATE.OPENED) {
/*  730 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  734 */     if (this.myPO.lv < plantingCO.plantLevel) {
/*  735 */       return false;
/*      */     }
/*      */     
/*  738 */     int seedNum = this.player.bag.findItemNumByCode(seedCode);
/*      */ 
/*      */     
/*  741 */     if (seedNum < 1) {
/*  742 */       return false;
/*      */     }
/*      */     
/*  745 */     this.player.bag.discardItem(seedCode, 1, Const.GOODS_CHANGE_TYPE.FarmSow);
/*      */     
/*  747 */     block.seedCode = seedCode;
/*  748 */     block.blockState = BLOCK_STATE.SOWED;
/*  749 */     block.seedState = SEED_STATE.SEEDED;
/*      */ 
/*      */     
/*  752 */     block.cultivateType = getRandomCultivateType();
/*      */     
/*  754 */     int nextStageProb = getNextStageProb(block);
/*  755 */     long nextnextTimeStamp = block.nextTime.getTime() + (plantingCO.growTime * 60 * 1000 * nextStageProb / 100);
/*  756 */     block.nextTime = new Date(nextnextTimeStamp);
/*      */ 
/*      */     
/*  759 */     RECORD_TYPE recordType = RECORD_TYPE.SOW;
/*      */     
/*  761 */     List<String> recordParams = new LinkedList<>();
/*  762 */     recordParams.add(plantingCO.name);
/*  763 */     RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
/*  764 */     AddRecord(this.myPO.recordLs, recordInfo);
/*      */     
/*  766 */     ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(new BlockTimerTask(this.myPO.playerId, block.blockId), nextnextTimeStamp);
/*  767 */     ((Map<Integer, ScheduledFuture<?>>)scheduleMap.get(this.myPO.playerId)).put(Integer.valueOf(block.blockId), scheduledFuture);
/*      */     
/*  769 */     updateSuperScriptList();
/*      */     
/*  771 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public FarmHandler.CultivateFriendResponse.Builder cultivateFriend(int blockId, String playerId) {
/*  777 */     FarmHandler.CultivateFriendResponse.Builder builder = FarmHandler.CultivateFriendResponse.newBuilder();
/*      */ 
/*      */     
/*  780 */     Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
/*  781 */     if (!friendIdSet.contains(playerId)) {
/*  782 */       builder.setS2CCode(500);
/*  783 */       builder.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));
/*      */       
/*  785 */       return builder;
/*      */     } 
/*      */     
/*  788 */     FarmPO friendPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  789 */     if (friendPO == null) {
/*  790 */       builder.setS2CCode(500);
/*  791 */       builder.setS2CMsg(LangService.getValue("FARM_PLAYER_PO_NOT_FOUND"));
/*      */       
/*  793 */       return builder;
/*      */     } 
/*  795 */     Block block = (Block)friendPO.blockMap.get(Integer.valueOf(blockId));
/*      */ 
/*      */     
/*  798 */     if (block.blockState != BLOCK_STATE.SOWED) {
/*  799 */       builder.setS2CCode(500);
/*  800 */       builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));
/*      */       
/*  802 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  806 */     if (block.cultivateType == CULTIVATE_TYPE.NONE) {
/*  807 */       builder.setS2CCode(500);
/*  808 */       builder.setS2CMsg(LangService.getValue("FARM_CULTIVATE_FAIL"));
/*      */       
/*  810 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  814 */     RECORD_TYPE recordType = null;
/*  815 */     if (block.cultivateType == CULTIVATE_TYPE.WATER) {
/*  816 */       recordType = RECORD_TYPE.FRIEND_WATER;
/*  817 */     } else if (block.cultivateType == CULTIVATE_TYPE.BUG) {
/*  818 */       recordType = RECORD_TYPE.FRIEND_BUG;
/*  819 */     } else if (block.cultivateType == CULTIVATE_TYPE.GRASS) {
/*  820 */       recordType = RECORD_TYPE.FRIEND_GRASS;
/*  821 */     }  List<String> recordParams = new LinkedList<>();
/*  822 */     recordParams.add(this.player.getName());
/*  823 */     RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
/*  824 */     AddRecord(friendPO.recordLs, recordInfo);
/*      */ 
/*      */     
/*  827 */     block.cultivateType = CULTIVATE_TYPE.NONE;
/*  828 */     int fate = this.player.processXianYuanGet(GlobalConfig.Fate_Plant);
/*      */     
/*  830 */     builder.setFate(fate);
/*  831 */     builder.setS2CCode(200);
/*      */     
/*  833 */     updateSuperScriptList();
/*      */     
/*  835 */     return builder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean cultivateSelf(int blockId) {
/*  843 */     Block block = (Block)this.myPO.blockMap.get(Integer.valueOf(blockId));
/*      */ 
/*      */     
/*  846 */     if (block.blockState != BLOCK_STATE.SOWED) {
/*  847 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  851 */     if (block.cultivateType == CULTIVATE_TYPE.NONE) {
/*  852 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  856 */     RECORD_TYPE recordType = null;
/*  857 */     if (block.cultivateType == CULTIVATE_TYPE.WATER) {
/*  858 */       recordType = RECORD_TYPE.WATER;
/*  859 */     } else if (block.cultivateType == CULTIVATE_TYPE.BUG) {
/*  860 */       recordType = RECORD_TYPE.BUG;
/*  861 */     } else if (block.cultivateType == CULTIVATE_TYPE.GRASS) {
/*  862 */       recordType = RECORD_TYPE.GRASS;
/*  863 */     }  List<String> recordParams = new LinkedList<>();
/*  864 */     PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*  865 */     recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  866 */     RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
/*  867 */     AddRecord(this.myPO.recordLs, recordInfo);
/*      */     
/*  869 */     block.cultivateType = CULTIVATE_TYPE.NONE;
/*      */     
/*  871 */     updateSuperScriptList();
/*      */     
/*  873 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public FarmHandler.HarvestResponse.Builder harvest(int blockId) {
/*  878 */     FarmHandler.HarvestResponse.Builder builder = FarmHandler.HarvestResponse.newBuilder();
/*      */     
/*  880 */     Block block = (Block)this.myPO.blockMap.get(Integer.valueOf(blockId));
/*      */ 
/*      */     
/*  883 */     if (block.blockState != BLOCK_STATE.SOWED) {
/*  884 */       builder.setS2CCode(500);
/*  885 */       builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));
/*  886 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  890 */     if (block.seedState != SEED_STATE.HARVESTABLE) {
/*  891 */       builder.setS2CCode(500);
/*  892 */       builder.setS2CMsg(LangService.getValue("FARM_UNMATURE"));
/*  893 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  897 */     PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/*  898 */     PlantLevelCO plantLevelCO = (PlantLevelCO)GameData.PlantLevels.get(Integer.valueOf(this.myPO.lv));
/*  899 */     PlantLevelCO plantLevelCOMax = (PlantLevelCO)GameData.PlantLevels.get(Integer.valueOf(GameData.PlantLevels.size()));
/*  900 */     if (this.myPO.lv < plantLevelCOMax.level) {
/*  901 */       this.myPO.exp += plantingCO.getExp;
/*  902 */       if (this.myPO.exp >= plantLevelCO.exp) {
/*  903 */         this.myPO.lv++;
/*  904 */         this.myPO.exp -= plantingCO.getExp;
/*  905 */         if (this.myPO.lv == plantLevelCOMax.level) {
/*  906 */           this.myPO.exp = 0;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  912 */     int rewardNum = plantingCO.harvest * (100 - block.missTime * GlobalConfig.Planting_DeductionProp) * (100 + plantLevelCO.harvestAdd) * (100 - block.stolerList.size() * (100 - GlobalConfig.Planting_StealProp)) / 1000000;
/*  913 */     this.player.bag.addCodeItemMail(plantingCO.product, rewardNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmHarvest, "Bag_full_common");
/*      */ 
/*      */     
/*  916 */     block.blockState = BLOCK_STATE.OPENED;
/*  917 */     block.seedCode = null;
/*  918 */     block.seedState = SEED_STATE.UNSOWED;
/*  919 */     block.cultivateType = CULTIVATE_TYPE.NONE;
/*  920 */     block.friendCultivateNum = 0;
/*  921 */     block.stolerList.clear();
/*  922 */     block.nextTime = null;
/*  923 */     block.missTime = 0;
/*      */ 
/*      */     
/*  926 */     RECORD_TYPE recordType = RECORD_TYPE.HARVEST;
/*      */     
/*  928 */     List<String> recordParams = new LinkedList<>();
/*  929 */     recordParams.add(String.valueOf(rewardNum));
/*  930 */     recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/*  931 */     RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
/*  932 */     AddRecord(this.myPO.recordLs, recordInfo);
/*      */     
/*  934 */     Farm.Block.Builder farmBlockBuilder = Farm.Block.newBuilder();
/*  935 */     farmBlockBuilder.setBlockId(blockId);
/*  936 */     farmBlockBuilder.setBlockState(block.blockState.value);
/*  937 */     farmBlockBuilder.setSeedCode(block.seedCode);
/*  938 */     farmBlockBuilder.setSeedState(block.seedState.value);
/*  939 */     farmBlockBuilder.setCultivateType(block.cultivateType.value);
/*      */     
/*  941 */     builder.setBlock(farmBlockBuilder.build());
/*      */     
/*  943 */     builder.setS2CCode(200);
/*      */ 
/*      */     
/*  946 */     updateSuperScriptList();
/*      */     
/*  948 */     return builder;
/*      */   }
/*      */ 
/*      */   
/*      */   public FarmHandler.StealResponse.Builder steal(int blockId, String playerId) {
/*  953 */     FarmHandler.StealResponse.Builder builder = FarmHandler.StealResponse.newBuilder();
/*      */ 
/*      */     
/*  956 */     Set<String> friendIdSet = this.player.friendManager.getAllFriendId();
/*  957 */     if (!friendIdSet.contains(playerId)) {
/*  958 */       builder.setS2CCode(500);
/*  959 */       builder.setS2CMsg(LangService.getValue("FARM_NOT_MY_FRIEND"));
/*      */       
/*  961 */       return builder;
/*      */     } 
/*      */     
/*  964 */     FarmPO friendPO = (FarmPO)PlayerPOManager.findPO(ConstsTR.player_farmTR, playerId, FarmPO.class);
/*  965 */     if (friendPO == null) {
/*  966 */       builder.setS2CCode(500);
/*  967 */       builder.setS2CMsg(LangService.getValue("FARM_PLAYER_PO_NOT_FOUND"));
/*      */       
/*  969 */       return builder;
/*      */     } 
/*  971 */     Block block = (Block)friendPO.blockMap.get(Integer.valueOf(blockId));
/*      */ 
/*      */     
/*  974 */     if (block.blockState != BLOCK_STATE.SOWED) {
/*  975 */       builder.setS2CCode(500);
/*  976 */       builder.setS2CMsg(LangService.getValue("FARM_UNSOWED"));
/*  977 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  981 */     if (block.seedState != SEED_STATE.HARVESTABLE) {
/*  982 */       builder.setS2CCode(500);
/*  983 */       builder.setS2CMsg(LangService.getValue("FARM_UNMATURE"));
/*  984 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  988 */     Date now = new Date();
/*  989 */     if (now.getTime() < block.nextTime.getTime() + (GlobalConfig.Planting_ProtectionTime * 60 * 1000)) {
/*  990 */       builder.setS2CCode(500);
/*  991 */       builder.setS2CMsg(LangService.getValue("FARM_IN_PROTECTION"));
/*  992 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/*  996 */     if (block.stolerList.contains(this.myPO.playerId)) {
/*  997 */       builder.setS2CCode(500);
/*  998 */       builder.setS2CMsg(LangService.getValue("FARM_CANNOT_STEAL"));
/*  999 */       return builder;
/*      */     } 
/*      */ 
/*      */     
/* 1003 */     PlantingCO plantingCO = (PlantingCO)ItemConfig.plantingMap.get(block.seedCode);
/* 1004 */     PlantLevelCO plantLevelCO = (PlantLevelCO)GameData.PlantLevels.get(Integer.valueOf(friendPO.lv));
/* 1005 */     int awardNum = plantingCO.harvest * (100 - block.missTime * GlobalConfig.Planting_DeductionProp) * (100 + plantLevelCO.harvestAdd) * GlobalConfig.Planting_StealProp / 1000000;
/* 1006 */     this.player.bag.addCodeItemMail(plantingCO.product, awardNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmSteal, "Bag_full_common");
/* 1007 */     block.stolerList.add(this.myPO.playerId);
/*      */ 
/*      */     
/* 1010 */     RECORD_TYPE recordType = RECORD_TYPE.FRIEND_STEAL;
/*      */     
/* 1012 */     List<String> recordParams = new LinkedList<>();
/* 1013 */     recordParams.add(this.player.getName());
/* 1014 */     recordParams.add(String.valueOf(awardNum));
/* 1015 */     recordParams.add(((MiscCO)GameData.Miscs.get(plantingCO.product)).name);
/* 1016 */     RecordInfo recordInfo = new RecordInfo(recordType, recordParams);
/* 1017 */     AddRecord(this.myPO.recordLs, recordInfo);
/*      */     
/* 1019 */     builder.setProductCode(plantingCO.product);
/* 1020 */     builder.setNum(awardNum);
/* 1021 */     builder.setS2CCode(200);
/*      */     
/* 1023 */     updateSuperScriptList();
/*      */     
/* 1025 */     return builder;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean ChangeShopItem(int itemId) {
/* 1030 */     PlantShopCO plantShopCO = (PlantShopCO)GameData.PlantShops.get(Integer.valueOf(itemId));
/* 1031 */     if (this.myPO.shopToday.containsKey(Integer.valueOf(itemId)) && (
/* 1032 */       (Integer)this.myPO.shopToday.get(Integer.valueOf(itemId))).intValue() >= plantShopCO.changeNum) {
/* 1033 */       return false;
/*      */     }
/* 1035 */     if (!this.player.bag.discardItemsByCode(plantShopCO.parameter, Const.GOODS_CHANGE_TYPE.FarmChange))
/* 1036 */       return false; 
/* 1037 */     List<WNBag.SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(plantShopCO.parameter);
/* 1038 */     for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/* 1039 */       this.player.bag.addCodeItemMail(simpleItemInfo.itemCode, simpleItemInfo.itemNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.FarmChange, "Bag_full_common");
/*      */     }
/* 1041 */     return true;
/*      */   }
/*      */   
/*      */   public void refreshNewDay() {
/* 1045 */     this.myPO.shopToday.clear();
/*      */     
/* 1047 */     updateSuperScriptList();
/*      */   }
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
/* 1051 */     List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
/*      */     
/* 1053 */     int meSowable = getPlayerSowable(this.player.getId()) ? 1 : 0;
/* 1054 */     int meCultivatable = getPlayerCultivatable(this.player.getId()) ? 1 : 0;
/* 1055 */     int meHarvestable = getPlayerHarvestable(this.player.getId()) ? 1 : 0;
/*      */     
/* 1057 */     ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FARM_CULTIVATE.getValue(), meSowable + meCultivatable + meHarvestable));
/*      */     
/* 1059 */     for (String friendId : this.player.friendManager.getAllFriendId()) {
/* 1060 */       int friendStealable = getPlayerStealable(friendId) ? 1 : 0;
/* 1061 */       int friendCultivatable = getFriendCultivatable(friendId) ? 1 : 0;
/* 1062 */       ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.FARM_FRIEND.getValue(), friendStealable + friendCultivatable));
/*      */     } 
/*      */     
/* 1065 */     return ls;
/*      */   }
/*      */   
/*      */   private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
/* 1069 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1070 */     data.setType(type);
/* 1071 */     data.setNumber(num);
/* 1072 */     return data.build();
/*      */   }
/*      */   
/*      */   public void updateSuperScriptList() {
/* 1076 */     List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
/* 1077 */     this.player.updateSuperScriptList(ls);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 1083 */     switch (eventType) {
/*      */       case UPGRADE:
/*      */       case PAY:
/* 1086 */         UpdateBlocks();
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Const.ManagerType getManagerType() {
/* 1097 */     return Const.ManagerType.FARM;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\farm\FarmMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */