/*     */ package com.wanniu.game.common.msg;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.SoloDataPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.AchievementHandler;
/*     */ import pomelo.area.BagHandler;
/*     */ import pomelo.area.ConsignmentLineHandler;
/*     */ import pomelo.area.EquipHandler;
/*     */ import pomelo.area.FunctionHandler;
/*     */ import pomelo.area.ItemHandler;
/*     */ import pomelo.area.LimitTimeActivityHandler;
/*     */ import pomelo.area.MailHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.area.RankHandler;
/*     */ import pomelo.area.SkillHandler;
/*     */ import pomelo.area.SkillKeysHandler;
/*     */ import pomelo.area.SoloHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WNNotifyManager
/*     */ {
/*     */   private static WNNotifyManager instance;
/*     */   
/*     */   public static WNNotifyManager getInstance() {
/*  68 */     if (instance == null) {
/*  69 */       instance = new WNNotifyManager();
/*     */     }
/*  71 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void teamBagGridNumPush(WNPlayer player, int args) {
/*  81 */     player.refreshPlayerRemainTeamBagCountData(args);
/*     */   }
/*     */   
/*     */   public void pushFunctionGoTo(WNPlayer player, FunctionHandler.FunctionGoToPush.Builder args) {
/*  85 */     Out.debug(new Object[] { getClass(), "pushFunctionGoTo: ", player.getName(), " id: ", player.getId(), " data: ", args });
/*  86 */     args.setS2CCode(200);
/*     */     
/*  88 */     player.receive("area.functionPush.functionGoToPush", (GeneratedMessage)args.build());
/*     */   }
/*     */   
/*     */   public void pushFishItem(WNPlayer player, List<ItemOuterClass.MiniItem> args) {
/*  92 */     Out.debug(new Object[] { getClass(), "pushFishItem: ", player.getName(), " id: ", player.getId(), " data: ", args });
/*     */     
/*  94 */     ItemHandler.FishItemPush.Builder data = ItemHandler.FishItemPush.newBuilder();
/*  95 */     data.setS2CCode(200);
/*  96 */     data.addAllS2CItem(args);
/*  97 */     player.receive("area.itemPush.fishItemPush", (GeneratedMessage)data.build());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void pushSkillUpdate(WNPlayer player, List<Integer> skillIds) {
/* 102 */     if (skillIds.size() <= 0) {
/*     */       return;
/*     */     }
/* 105 */     SkillHandler.SkillUpdatePush.Builder data = SkillHandler.SkillUpdatePush.newBuilder();
/* 106 */     data.setS2CCode(200);
/*     */     
/* 108 */     ArrayList<SkillHandler.SkillBasic> skills = new ArrayList<>();
/*     */     
/* 110 */     for (Iterator<Integer> iterator = skillIds.iterator(); iterator.hasNext(); ) { int index = ((Integer)iterator.next()).intValue();
/* 111 */       SkillHandler.SkillBasic skillBasic = player.skillManager.getSkillBasicUpdate4PayLoad(index);
/* 112 */       if (skillBasic != null) {
/* 113 */         skills.add(skillBasic);
/*     */       } }
/*     */     
/* 116 */     data.addAllS2CData(skills);
/* 117 */     boolean isCanSetting = false;
/* 118 */     data.setHubLock(!!isCanSetting);
/* 119 */     if (skills.size() > 0) {
/* 120 */       player.receive("area.skillPush.skillUpdatePush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */   
/*     */   public final void pushSkillKeysUpdate(WNPlayer player, List<Common.SkillKeyStruct> data) {
/* 125 */     if (data.size() > 0) {
/* 126 */       SkillKeysHandler.SkillKeyUpdatePush.Builder build = SkillKeysHandler.SkillKeyUpdatePush.newBuilder();
/* 127 */       build.setS2CCode(200);
/* 128 */       build.addAllS2CData(data);
/* 129 */       player.receive("area.skillKeysPush.skillKeyUpdatePush", (GeneratedMessage)build.build());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushEquipmentDynamic(WNPlayer player, int[] grids, boolean refresh) {
/* 141 */     Out.debug(new Object[] { getClass(), "@#@pushEquipmentDynamic: ", player.getName(), " id: ", player.getId(), " data: ", grids, ",refresh:", Boolean.valueOf(refresh) });
/* 142 */     EquipHandler.EquipmentSimplePush.Builder data = EquipHandler.EquipmentSimplePush.newBuilder();
/* 143 */     data.setS2CCode(200);
/* 144 */     List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();
/*     */     
/* 146 */     ItemHandler.ItemDetailPush.Builder equipDetails = ItemHandler.ItemDetailPush.newBuilder();
/* 147 */     equipDetails.setS2CCode(200);
/*     */     
/* 149 */     for (int pos : grids) {
/* 150 */       bagGrids.add(player.equipManager.getEquip4PayLoad(pos));
/*     */       
/* 152 */       NormalEquip normalEquip = player.equipManager.getEquipment(pos);
/* 153 */       if (normalEquip != null && refresh) {
/* 154 */         equipDetails.addS2CData(normalEquip.getItemDetail(player.playerBasePO));
/*     */       }
/*     */     } 
/*     */     
/* 158 */     if (equipDetails.getS2CDataCount() > 0) {
/* 159 */       player.receive("area.itemPush.itemDetailPush", (GeneratedMessage)equipDetails.build());
/*     */     }
/*     */     
/* 162 */     data.addAllS2CData(bagGrids);
/* 163 */     if (bagGrids.size() > 0) {
/* 164 */       player.receive("area.equipPush.equipmentSimplePush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushEquipmentPOS(WNPlayer player, int[] poses, boolean refresh) {
/* 172 */     Out.debug(new Object[] { getClass(), "@#@pushEquipmentPOS: ", player.getName(), " id: ", player.getId(), " data: ", poses, ",refresh:", Boolean.valueOf(refresh) });
/* 173 */     EquipHandler.StrengthPosPush.Builder data = EquipHandler.StrengthPosPush.newBuilder();
/* 174 */     data.setS2CCode(200);
/* 175 */     List<ItemOuterClass.EquipGridStrengthInfo> grids = new ArrayList<>();
/* 176 */     for (int pos : poses) {
/* 177 */       grids.add(player.equipManager.getStrenghInfo(pos));
/*     */     }
/*     */     
/* 180 */     data.addAllStrengthInfos(grids);
/* 181 */     if (grids.size() > 0) {
/* 182 */       player.receive("area.equipPush.equipStrengthPosPush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushBagItemDynamic(WNPlayer player, List<Integer> grid, boolean flag, Const.GOODS_CHANGE_TYPE source) {
/* 190 */     BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
/* 191 */     List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();
/*     */     
/* 193 */     BagHandler.BagNewEquipPush.Builder newEquip = BagHandler.BagNewEquipPush.newBuilder();
/*     */     
/* 195 */     ItemHandler.ItemDetailPush.Builder itemDetails = ItemHandler.ItemDetailPush.newBuilder();
/* 196 */     itemDetails.setS2CCode(200);
/*     */     
/* 198 */     for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 199 */       ItemOuterClass.Grid.Builder gb = player.getWnBag().getGrid4PayLoad(pos);
/* 200 */       if (source != null) {
/* 201 */         gb.setSource(source.getValue());
/*     */       }
/* 203 */       bagGrids.add(gb.build());
/* 204 */       NormalItem item = player.getWnBag().getItem(pos);
/*     */       
/* 206 */       if (flag && item != null) {
/* 207 */         itemDetails.addS2CData(item.getItemDetail(player.playerBasePO));
/* 208 */         if (item.itemDb.isNew == 1) {
/* 209 */           newEquip.addS2CData(item.getId());
/*     */         }
/*     */       }  }
/*     */ 
/*     */     
/* 214 */     if (itemDetails.getS2CDataCount() > 0) {
/* 215 */       player.receive("area.itemPush.itemDetailPush", (GeneratedMessage)itemDetails.build());
/*     */     }
/*     */     
/* 218 */     data.setS2CType(Const.BAG_TYPE.BAG.getValue());
/* 219 */     data.addAllS2CData(bagGrids);
/* 220 */     if (bagGrids.size() > 0) {
/* 221 */       player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage)data.build());
/*     */     }
/*     */     
/* 224 */     if (newEquip.getS2CDataCount() > 0) {
/* 225 */       player.receive("area.bagPush.bagNewEquipPush", (GeneratedMessage)newEquip.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushBagItemDynamic(WNPlayer player, List<Integer> grid, boolean flag) {
/* 233 */     pushBagItemDynamic(player, grid, flag, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushBagNewItem(WNPlayer player, String code, int num, Const.GOODS_CHANGE_TYPE from) {
/* 240 */     Out.debug(new Object[] { getClass(), "bag pushBagNewItem: ", (player.getPlayer()).name, " id: ", (player.getPlayer()).id, " ::: ", code, ":", Integer.valueOf(num) });
/*     */     
/* 242 */     BagHandler.BagNewItemPush.Builder data = BagHandler.BagNewItemPush.newBuilder();
/*     */     
/* 244 */     ItemOuterClass.MiniItem.Builder item = ItemUtil.getMiniItemData(code, num, null);
/* 245 */     if (item != null) {
/*     */ 
/*     */ 
/*     */       
/* 249 */       data.addS2CData(item);
/* 250 */       player.receive("area.bagPush.bagNewItemPush", (GeneratedMessage)data.build());
/* 251 */       player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.ITEM, item.getName(), Integer.valueOf(item.getQColor()), String.valueOf(num), from);
/*     */     } else {
/* 253 */       Out.error(new Object[] { "pushBagNewItem item:::", code, ":", Integer.valueOf(num), ":", "is null" });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void gridNotEnough(WNPlayer player) {
/* 258 */     BagHandler.BagGridFullPush.Builder data = BagHandler.BagGridFullPush.newBuilder();
/* 259 */     data.setS2CCode(200);
/* 260 */     player.receive("area.bagPush.bagGridFullPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushBagItemDynamicWareHouse(WNPlayer player, List<Integer> grid, boolean flag) {
/* 264 */     Out.debug(new Object[] { "wareHouse pushBagItemDynamic: ", player.getName(), " id: ", player.getId() });
/* 265 */     BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
/* 266 */     List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();
/*     */     
/* 268 */     WNBag wareHouse = player.wareHouse;
/*     */     
/* 270 */     for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 271 */       bagGrids.add(wareHouse.getGrid4PayLoad(pos).build()); }
/*     */ 
/*     */     
/* 274 */     data.setS2CType(Const.BAG_TYPE.WAREHOUSE.getValue());
/* 275 */     data.addAllS2CData(bagGrids);
/* 276 */     if (bagGrids.size() > 0) {
/* 277 */       player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */   
/*     */   public void pushBagItemDynamicRecycle(WNPlayer player, List<Integer> grid, boolean flag) {
/* 282 */     Out.debug(new Object[] { "recycle pushBagItemDynamic: ", player.getName(), " id: ", player.getId() });
/* 283 */     BagHandler.BagItemUpdatePush.Builder data = BagHandler.BagItemUpdatePush.newBuilder();
/* 284 */     List<ItemOuterClass.Grid> bagGrids = new ArrayList<>();
/*     */     
/* 286 */     WNBag recycle = player.recycle;
/*     */     
/* 288 */     for (Iterator<Integer> iterator = grid.iterator(); iterator.hasNext(); ) { int pos = ((Integer)iterator.next()).intValue();
/* 289 */       bagGrids.add(recycle.getGrid4PayLoad(pos).build()); }
/*     */ 
/*     */     
/* 292 */     data.setS2CType(Const.BAG_TYPE.RECYCLE.getValue());
/* 293 */     data.addAllS2CData(bagGrids);
/* 294 */     if (bagGrids.size() > 0) {
/* 295 */       player.receive("area.bagPush.bagItemUpdatePush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushEffectData(WNPlayer player, Map<String, Object> args) {
/* 303 */     Out.debug(new Object[] { getClass(), "pushEffectData: ", player.getName(), " id: ", player.getId(), " data: ", args });
/* 304 */     PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();
/* 305 */     List<Common.PropertyStruct> playerData = new ArrayList<>();
/* 306 */     Iterator<String> keys = args.keySet().iterator();
/* 307 */     while (keys.hasNext()) {
/* 308 */       String key = keys.next();
/* 309 */       playerData.add(CommonUtil.transferDataType(key, args.get(key)).build());
/*     */     } 
/* 311 */     data.addAllS2CData(playerData);
/* 312 */     if (playerData.size() > 0) {
/* 313 */       player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushPlayerDynamic(WNPlayer player, Common.PropertyStruct prop) {
/* 321 */     Out.debug(new Object[] { "pushPlayerDynamic: ", player.getName(), " id: ", player.getId(), " data: ", prop });
/* 322 */     PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();
/* 323 */     data.addS2CData(prop);
/* 324 */     if (data.getS2CDataCount() > 0) {
/* 325 */       player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushPlayerDynamic(WNPlayer player, Map<String, Object> args) {
/* 333 */     Out.debug(new Object[] { "pushPlayerDynamic: ", player.getName(), " id: ", player.getId(), " data: ", args });
/* 334 */     PlayerHandler.PlayerDynamicPush.Builder data = PlayerHandler.PlayerDynamicPush.newBuilder();
/*     */     
/* 336 */     for (String key : args.keySet()) {
/* 337 */       Object value = args.get(key);
/* 338 */       if (value == null) {
/* 339 */         Out.error(new Object[] { "player prop ", key, " is null" });
/*     */         continue;
/*     */       } 
/* 342 */       data.addS2CData(CommonUtil.transferDataType(key, value));
/*     */     } 
/*     */     
/* 345 */     if (data.getS2CDataCount() > 0) {
/* 346 */       player.receive("area.playerPush.playerDynamicPush", (GeneratedMessage)data.build());
/*     */     }
/*     */   }
/*     */   
/*     */   public void pushRelive(WNPlayer player, PlayerHandler.PlayerRelivePush data) {
/* 351 */     Out.debug(new Object[] { getClass(), " pushRelive: ", player.getName(), " id: ", player.getId() });
/* 352 */     player.receive("area.playerPush.playerRelivePush", (GeneratedMessage)data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void levelChange(WNPlayer player, int level) {
/* 360 */     player.getPlayerTasks().onLevelChange(level);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushMails(WNPlayer player, ArrayList<MailHandler.Mail> mails) {
/* 366 */     MailHandler.OnGetMailPush.Builder build = MailHandler.OnGetMailPush.newBuilder();
/* 367 */     build.setS2CCode(200);
/* 368 */     build.addAllMails(mails);
/* 369 */     player.receive("area.mailPush.onGetMailPush", (GeneratedMessage)build.build());
/*     */   }
/*     */   
/*     */   public void pushAchievements(WNPlayer player, List<AchievementHandler.Achievement> achievements) {
/* 373 */     Out.debug(new Object[] { getClass(), "pushAchievements : ", player.getName(), "id: ", player.getId(), "data: ", achievements });
/* 374 */     AchievementHandler.OnAchievementPush.Builder data = AchievementHandler.OnAchievementPush.newBuilder();
/* 375 */     data.setS2CCode(200);
/* 376 */     data.addAllS2CAchievements(achievements);
/* 377 */     player.receive("area.achievementPush.onAchievementPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushAwardRank(WNPlayer player, int rankId) {
/* 381 */     RankHandler.OnAwardRankPush.Builder build = RankHandler.OnAwardRankPush.newBuilder();
/* 382 */     build.setS2CCode(200);
/* 383 */     build.setS2CAwardRankId(rankId);
/* 384 */     player.receive("area.rankPush.onAwardRankPush", (GeneratedMessage)build.build());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushNewReward(WNPlayer player) {
/* 390 */     SoloHandler.OnNewRewardPush.Builder data = SoloHandler.OnNewRewardPush.newBuilder();
/* 391 */     data.setS2CCode(200);
/*     */     
/* 393 */     Out.debug(new Object[] { getClass(), "pushNewReward : ", player.getName(), "id: ", player.getId(), "data: ", data });
/* 394 */     player.receive("area.soloPush.onNewRewardPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushFightPoint(WNPlayer player, int fightPoint) {
/* 398 */     SoloHandler.OnFightPointPush.Builder data = SoloHandler.OnFightPointPush.newBuilder();
/* 399 */     data.setS2CCode(200);
/* 400 */     data.setS2CFightPoint(fightPoint);
/* 401 */     Out.debug(new Object[] { getClass(), "pushFightPoint : ", player.getName(), "id: ", player.getId(), "data: ", data });
/* 402 */     player.receive("area.soloPush.onFightPointPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushRoundEnd(WNPlayer player, SoloHandler.RoundResult roundResult) {
/* 406 */     SoloHandler.OnRoundEndPush.Builder data = SoloHandler.OnRoundEndPush.newBuilder();
/* 407 */     data.setS2CCode(200);
/* 408 */     data.setS2CRoundResult(roundResult);
/* 409 */     Out.debug(new Object[] { getClass(), "pushRoundEnd : ", player.getName(), "id: ", player.getId(), "data: ", data });
/* 410 */     player.receive("area.soloPush.onRoundEndPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushGameEnd(WNPlayer player, SoloHandler.GameResult gameResult, int gameOverTime, boolean isAddBox) {
/* 414 */     SoloHandler.OnGameEndPush.Builder data = SoloHandler.OnGameEndPush.newBuilder();
/* 415 */     data.setS2CCode(200);
/* 416 */     data.setS2CGameOverTime(gameOverTime);
/* 417 */     data.setS2CGameResult(gameResult);
/*     */     
/* 419 */     boolean finish = true;
/* 420 */     for (SoloDataPO.RankStatus s : player.soloManager.soloData.dailyRewards) {
/* 421 */       if (s.getStatus() == 0) {
/* 422 */         finish = false;
/*     */       }
/*     */     } 
/* 425 */     if (isAddBox) {
/* 426 */       data.setDailyBattleTimes(GlobalConfig.Solo_PKForChest);
/* 427 */     } else if (!finish) {
/* 428 */       data.setDailyBattleTimes(player.soloManager.soloData.dailyBattleTimes);
/*     */     } 
/* 430 */     Out.debug(new Object[] { getClass(), "pushGameEnd : ", player.getName(), "id: ", player.getId(), "data: ", data });
/* 431 */     player.receive("area.soloPush.onGameEndPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushRebirth(WNPlayer player, String name) {
/* 435 */     Out.debug(new Object[] { WNNotifyManager.class, "pushRebirth: ", player.getName(), "id: ", player.getId(), "data:", name });
/*     */     
/* 437 */     PlayerHandler.PlayerSaverRebirthPush.Builder data = PlayerHandler.PlayerSaverRebirthPush.newBuilder();
/* 438 */     data.setSaverName(name);
/* 439 */     player.receive("area.playerPush.playerSaverRebirthPush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public final void consignmentRemovePush(WNPlayer player, String id) {
/* 443 */     ConsignmentLineHandler.ConsignmentRemovePush.Builder push = ConsignmentLineHandler.ConsignmentRemovePush.newBuilder();
/* 444 */     push.setS2CCode(200);
/* 445 */     push.setS2CId(id);
/* 446 */     player.receive("area.consignmentLinePush.consignmentRemovePush", (GeneratedMessage)push.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushActivityInfo(WNPlayer player, ArrayList<LimitTimeActivityHandler.ActivityInfo> activityInfo) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateScript(WNPlayer player) {
/* 463 */     player.updateSuperScriptList(player.getItemChangeScript());
/*     */   }
/*     */   
/*     */   public void pushPlayerBattleData(WNPlayer player) {
/* 467 */     if (player.btlDataManager == null)
/*     */       return; 
/* 469 */     PlayerHandler.PlayerBattleAttributePush.Builder data = PlayerHandler.PlayerBattleAttributePush.newBuilder();
/* 470 */     Map<Const.PlayerBtlData, Integer> finalInflus = player.btlDataManager.finalInflus;
/* 471 */     for (Const.PlayerBtlData pbd : finalInflus.keySet()) {
/* 472 */       if (pbd == null)
/*     */         continue; 
/* 474 */       Common.AttributeSimple.Builder as = Common.AttributeSimple.newBuilder();
/* 475 */       as.setId(pbd.id);
/* 476 */       as.setValue(((Integer)finalInflus.get(pbd)).intValue());
/* 477 */       data.addDatas(as);
/*     */     } 
/* 479 */     player.receive("area.playerPush.playerBattleAttributePush", (GeneratedMessage)data.build());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\msg\WNNotifyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */