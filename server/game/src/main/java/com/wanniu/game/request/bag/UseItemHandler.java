/*     */ package com.wanniu.game.request.bag;
/*     */ 
/*     */ import Xmds.RefreshPlayerPropertyChange;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.FashionItemCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.data.ext.BaseDataExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.request.task.AcceptTaskHandler;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.BagHandler;
/*     */ import pomelo.area.FashionHandler;
/*     */ import pomelo.area.PetNewHandler;
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
/*     */ @GClientEvent("area.bagHandler.useItemRequest")
/*     */ public class UseItemHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  54 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  55 */     BagHandler.UseItemRequest req = BagHandler.UseItemRequest.parseFrom(this.pak.getRemaingBytes());
/*  56 */     final int index = req.getC2SGridIndex();
/*  57 */     final int num = req.getC2SNum();
/*     */     
/*  59 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  62 */           BagHandler.UseItemResponse.Builder res = BagHandler.UseItemResponse.newBuilder();
/*  63 */           if (null == player) {
/*  64 */             res.setS2CCode(500);
/*  65 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*  66 */             this.body.writeBytes(res.build().toByteArray());
/*  67 */             PlayerUtil.logWarnIfPlayerNull(UseItemHandler.this.pak);
/*     */             return;
/*     */           } 
/*  70 */           WNBag wnBag = player.getWnBag();
/*  71 */           if (num <= 0) {
/*  72 */             res.setS2CCode(200);
/*  73 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  77 */           NormalItem item = wnBag.getItem(index);
/*     */           
/*  79 */           if (item == null || ItemUtil.isEquipByItemType(item.prop.itemType)) {
/*  80 */             res.setS2CCode(500);
/*  81 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  82 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  87 */           if (!item.canUse()) {
/*  88 */             res.setS2CCode(500);
/*  89 */             res.setS2CMsg(LangService.getValue("ITEM_CAN_NOT_USE"));
/*  90 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  95 */           if (item.itemDb.groupCount < num || num <= 0) {
/*  96 */             res.setS2CCode(500);
/*  97 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  98 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 103 */           DItemBase template = (DItemBase)item.getTemplate();
/* 104 */           if (template.levelReq > (player.getPlayer()).level) {
/* 105 */             res.setS2CCode(500);
/* 106 */             res.setS2CMsg(LangService.getValue("BAG_PLAYER_LEVEL_NOT_ENOUGH_CANNOT_USE"));
/* 107 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/* 110 */           if (item.prop.code.equals(Const.ITEM_CODE.Changename.value)) {
/* 111 */             res.setS2CCode(200);
/* 112 */             res.setIsGain(2);
/* 113 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 115 */           if (item.prop.itemType == Const.ItemType.Chest.getValue())
/* 116 */           { int needDiamond = template.min;
/*     */             
/* 118 */             if (needDiamond > 0 && !player.moneyManager.enoughDiamond(needDiamond)) {
/* 119 */               res.setS2CCode(500);
/* 120 */               res.setS2CMsg("");
/* 121 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 125 */             String tc = (String)template.chestTC.get(Integer.valueOf(player.getPro()));
/* 126 */             List<NormalItem> tcItems = new ArrayList<>();
/* 127 */             for (int i = 0; i < num; i++) {
/*     */               
/* 129 */               List<NormalItem> items = ItemUtil.createItemsByRealTC(tc, player.getLevel());
/* 130 */               tcItems.addAll(items);
/*     */             } 
/*     */             
/* 133 */             List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);
/*     */ 
/*     */             
/* 136 */             int needGridNum = ItemUtil.getPackUpItemsNum(addItems);
/* 137 */             if (needGridNum > 0) {
/* 138 */               if (!wnBag.testEmptyGridLarge(1, false)) {
/* 139 */                 res.setS2CCode(500);
/* 140 */                 res.setS2CMsg("");
/* 141 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/* 145 */               if (wnBag.emptyGridNum() < needGridNum) {
/* 146 */                 res.setS2CCode(500);
/* 147 */                 res.setS2CMsg(LangService.getValue("STORE_SPACE_NOT_ENOUGH"));
/* 148 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/* 153 */             wnBag.discardItemByPos(index, num, false, Const.GOODS_CHANGE_TYPE.use);
/*     */             
/* 155 */             List<ItemOuterClass.MiniItem> chest = new ArrayList<>();
/*     */             
/* 157 */             List<PlayerItemPO> notAddItems = new ArrayList<>();
/* 158 */             for (int j = 0; j < addItems.size(); j++) {
/* 159 */               NormalItem addItem = addItems.get(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 165 */               if (wnBag.testAddEntityItem(addItem, true)) {
/* 166 */                 if (!addItem.isVirtual()) {
/* 167 */                   chest.add(ItemUtil.getMiniItemData(addItem.itemDb.code, addItem.itemDb.groupCount, Const.ForceType.getE(addItem.getBind())).build());
/*     */                 }
/* 169 */                 wnBag.addEntityItem(addItem, Const.GOODS_CHANGE_TYPE.use, null, false, false);
/*     */               } else {
/* 171 */                 notAddItems.add(addItem.itemDb);
/*     */               } 
/*     */             } 
/* 174 */             if (notAddItems.size() > 0) {
/* 175 */               MailSysData mailSysData = new MailSysData("Bag_full_openbox");
/* 176 */               ((MailData)mailSysData).entityItems = notAddItems;
/* 177 */               MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailSysData, Const.GOODS_CHANGE_TYPE.use);
/* 178 */               player.sendSysTip(LangService.getValue("BAG_FULL_SMELTING_CHEST"), Const.TipsType.BLACK);
/*     */             } 
/*     */             
/* 181 */             if (needDiamond > 0) {
/* 182 */               player.moneyManager.costDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.use);
/*     */             }
/*     */             
/* 185 */             res.setS2CCode(200);
/* 186 */             res.addAllS2CChest(chest);
/* 187 */             this.body.writeBytes(res.build().toByteArray()); }
/* 188 */           else { if (item.prop.itemType == Const.ItemType.Potion.getValue()) {
/*     */               
/* 190 */               if (num != 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 199 */                 res.setS2CCode(500);
/* 200 */                 res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 201 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/* 205 */               if (item.isCD()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 215 */                 res.setS2CCode(500);
/* 216 */                 res.setS2CMsg(LangService.getValue("BAG_USE_IN_CD"));
/* 217 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/* 221 */               Area area = player.getArea();
/* 222 */               MapBase areaProp = AreaUtil.getAreaProp(area.areaId);
/* 223 */               if (areaProp.useAgent == 0) {
/*     */ 
/*     */                 
/* 226 */                 res.setS2CCode(500);
/* 227 */                 res.setS2CMsg(LangService.getValue("BAG_THIS_SENCE_CANNOT_USE_MEDICAMENT"));
/* 228 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/* 232 */               player.bag.setCD(item.prop.itemSecondType, index);
/* 233 */               player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/* 234 */               UseItemHandler.GetItemChanagePropertyResult data = ItemUtil.getItemChanageProperty(item);
/* 235 */               if (data.bPet) {
/* 236 */                 player.refreshPlayerPetPropertyChange(data.itemData);
/*     */               } else {
/*     */                 
/* 239 */                 player.bufferManager.add(data.itemData);
/* 240 */                 player.refreshPlayerPropertyChange(data.itemData);
/*     */               } 
/*     */               
/* 243 */               player.sendSysTip(LangService.getValue("GAIN_POTION"), Const.TipsType.NO_BG);
/* 244 */               res.setS2CCode(200);
/* 245 */               res.setIsGain(1);
/* 246 */               this.body.writeBytes(res.build().toByteArray()); return;
/*     */             } 
/* 248 */             if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.rideItem.getValue()) {
/*     */               
/* 250 */               if (num != 1) {
/* 251 */                 res.setS2CCode(500);
/* 252 */                 res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 253 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 return;
/*     */               } 
/* 256 */               int ret = player.mountManager.addNewSkin(template.min);
/* 257 */               if (ret == 1) {
/* 258 */                 player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/* 259 */                 res.setS2CCode(200);
/* 260 */                 this.body.writeBytes(res.build().toByteArray()); return;
/*     */               } 
/* 262 */               if (ret == -1) {
/* 263 */                 res.setS2CCode(500);
/* 264 */                 res.setS2CMsg(LangService.getValue("BAG_HAD_THIS_SKIN"));
/* 265 */                 this.body.writeBytes(res.build().toByteArray()); return;
/*     */               } 
/* 267 */               if (ret == -2) {
/* 268 */                 res.setS2CCode(500);
/* 269 */                 res.setS2CMsg(LangService.getValue("BAG_SKIN_NULL"));
/* 270 */                 this.body.writeBytes(res.build().toByteArray()); return;
/*     */               } 
/* 272 */               if (ret == -3) {
/* 273 */                 res.setS2CCode(500);
/* 274 */                 res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
/* 275 */                 this.body.writeBytes(res.build().toByteArray()); return;
/*     */               } 
/*     */             } else {
/* 278 */               if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.petItem.getValue() && ((DItemBase)item.prop).prop.equals("pet")) {
/* 279 */                 DItemBase prop = (DItemBase)item.prop;
/* 280 */                 int petId = prop.min;
/* 281 */                 String msg = player.petNewManager.summonPetByItem(petId);
/* 282 */                 if (msg != null) {
/* 283 */                   BaseDataExt baseDataExt = (BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(petId));
/* 284 */                   for (int i = 0; i < num; i++) {
/* 285 */                     player.bag.addCodeItemMail(baseDataExt.petItemCode, baseDataExt.itemCount, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.pet, "Bag_full_common");
/*     */                   }
/* 287 */                   player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.use);
/*     */                 } else {
/* 289 */                   player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/*     */                 } 
/* 291 */                 res.setS2CCode(200);
/* 292 */                 this.body.writeBytes(res.build().toByteArray()); return;
/*     */               } 
/* 294 */               if (item.prop.itemType == Const.ItemType.Misc.getValue() && item.prop.itemSecondType == Const.ItemSecondType.petItem.getValue()) {
/* 295 */                 if (num != 1) {
/* 296 */                   res.setS2CCode(500);
/* 297 */                   res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 298 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 301 */                 PetNewHandler.SummonPetResponse result = player.petNewManager.summonPet(template.min).build();
/* 302 */                 boolean ret = (result.getS2CCode() == 200);
/* 303 */                 if (ret) {
/* 304 */                   player.bag.discardItemByPos(index, 1, false, Const.GOODS_CHANGE_TYPE.petCost);
/* 305 */                   res.setS2CCode(200);
/* 306 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 309 */                 res.setS2CCode(500);
/* 310 */                 res.setS2CMsg(LangService.getValue("GAIN_PET_SAME"));
/* 311 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/* 315 */               if (item.prop.itemType == Const.ItemType.Misc.getValue() && item.prop.itemSecondType == Const.ItemSecondType.misc.getValue() && template.prop.equals("ExpRatio")) {
/*     */                 
/* 317 */                 if (num != 1) {
/* 318 */                   res.setS2CCode(500);
/* 319 */                   res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 320 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 323 */                 player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/*     */                 
/* 325 */                 player.bufferManager.addLocalBuff("ExdExp", (template.par * Const.Time.Minute.getValue()), template.min);
/* 326 */                 player.sendSysTip(LangService.getValue("ITEM_USE_NOTICE").replace("{itemName}", item.prop.name), Const.TipsType.NO_BG);
/* 327 */                 res.setS2CCode(200);
/* 328 */                 this.body.writeBytes(res.build().toByteArray());
/* 329 */               } else if (item.prop.itemType == Const.ItemType.Misc.getValue() && template.prop.equals("rank")) {
/*     */                 
/* 331 */                 if (num != 1) {
/* 332 */                   res.setS2CCode(500);
/* 333 */                   res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 334 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 337 */                 player.titleManager.onAwardRank(template.min);
/* 338 */                 player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/* 339 */                 res.setS2CCode(200);
/* 340 */                 this.body.writeBytes(res.build().toByteArray());
/* 341 */               } else if (item.prop.itemType == Const.ItemType.Mate.getValue() && item.prop.itemSecondType == Const.ItemSecondType.fashionItem.getValue()) {
/* 342 */                 if (num != 1) {
/* 343 */                   res.setS2CCode(500);
/* 344 */                   res.setS2CMsg(LangService.getValue("BAG_ONLY_ONE_CAN_BE_USED_AT_A_TIME"));
/* 345 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 348 */                 FashionItemCO fashionItemCO = (FashionItemCO)GameData.FashionItems.get(item.itemCode());
/* 349 */                 boolean activiateResult = player.fashionManager.activiateFashion(fashionItemCO.prop);
/* 350 */                 if (!activiateResult) {
/* 351 */                   res.setS2CCode(500);
/* 352 */                   res.setS2CMsg(LangService.getValue("FASHION_CANNOT_ACTIVIATE"));
/* 353 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 356 */                 player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/* 357 */                 res.setS2CCode(200);
/* 358 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/* 360 */                 FashionHandler.FashionGetPush.Builder fBuilder = FashionHandler.FashionGetPush.newBuilder();
/* 361 */                 fBuilder.setS2CCode(200);
/* 362 */                 fBuilder.setCode(fashionItemCO.prop);
/* 363 */                 player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)fBuilder.build());
/*     */               }
/* 365 */               else if (item.prop.itemType == Const.ItemType.Misc.getValue() && template.prop.equals("ReducePK")) {
/* 366 */                 int pkValue = player.pkRuleManager.getPkValue();
/* 367 */                 if (pkValue <= 0) {
/* 368 */                   res.setS2CCode(500);
/* 369 */                   res.setS2CMsg(LangService.getValue("PK_VALUE_ZERO_NOT_USE"));
/* 370 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   return;
/*     */                 } 
/* 373 */                 int maxCount = (pkValue + template.min - 1) / template.min;
/* 374 */                 int realCount = (num <= maxCount) ? num : maxCount;
/* 375 */                 player.changePlayerPkValue(-template.min * realCount);
/* 376 */                 player.bag.discardItemByPos(index, realCount, Const.GOODS_CHANGE_TYPE.use);
/*     */                 
/* 378 */                 player.sendSysTip(LangService.getValue("GAIN_POTION"), Const.TipsType.NO_BG);
/*     */                 
/* 380 */                 res.setS2CCode(200);
/* 381 */                 this.body.writeBytes(res.build().toByteArray());
/* 382 */               } else if (item.prop.itemType == Const.ItemType.Misc.getValue()) {
/* 383 */                 if (template.prop.equals("gold")) {
/* 384 */                   player.moneyManager.addGold(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 385 */                 } else if (template.prop.equals("prestige")) {
/* 386 */                   player.addPrestige(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 387 */                   player.pushDynamicData("prestige", Integer.valueOf(player.player.prestige));
/* 388 */                 } else if (template.prop.equals("ticket")) {
/* 389 */                   player.moneyManager.addTicket(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 390 */                 } else if (template.prop.equals("exp")) {
/* 391 */                   player.addExp(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 392 */                 } else if (template.prop.equals("upexp")) {
/* 393 */                   player.baseDataManager.addClassExp(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 394 */                 } else if (template.prop.equals("guildPoints")) {
/* 395 */                   int totalPoints = template.min * num;
/* 396 */                   player.guildManager.addContribution(totalPoints, Const.GOODS_CHANGE_TYPE.use);
/* 397 */                   String guildId = player.guildManager.getGuildId();
/* 398 */                   player.guildManager.addTotalContribution(guildId, totalPoints);
/* 399 */                   player.guildManager.pushRedPoint();
/* 400 */                 } else if (template.prop.equals("solopoint")) {
/* 401 */                   player.soloManager.addSolopoint(template.min * num, Const.GOODS_CHANGE_TYPE.use);
/* 402 */                 } else if (template.prop.equalsIgnoreCase("CbtQuest")) {
/*     */                   
/* 404 */                   int templateId = template.par;
/* 405 */                   if (player.taskManager.treasureTasks.size() > 0) {
/* 406 */                     res.setS2CCode(500);
/* 407 */                     res.setS2CMsg(LangService.getValue("TASK_IS_ACCPETED"));
/* 408 */                     this.body.writeBytes(res.build().toByteArray());
/*     */                     
/*     */                     return;
/*     */                   } 
/*     */                   
/* 413 */                   TaskBase prop = TaskUtils.getTaskProp(templateId);
/* 414 */                   AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 8);
/* 415 */                   if (result.task != null) {
/* 416 */                     player.getPlayerTasks().pushTaskUpdate(result.task);
/*     */ 
/*     */                     
/* 419 */                     TaskUtils.treasurePush(player, Integer.parseInt(result.task.prop.targets.get(0)), templateId);
/*     */ 
/*     */                     
/* 422 */                     player.bag.discardItemByPos(index, 1, Const.GOODS_CHANGE_TYPE.use);
/*     */                     
/* 424 */                     res.setS2CCode(200);
/* 425 */                     this.body.writeBytes(res.build().toByteArray());
/*     */                     return;
/*     */                   } 
/* 428 */                   res.setS2CCode(500);
/* 429 */                   res.setS2CMsg(result.msg);
/* 430 */                   this.body.writeBytes(res.build().toByteArray());
/*     */                   
/*     */                   return;
/*     */                 } 
/*     */                 
/* 435 */                 player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.use);
/* 436 */                 res.setS2CCode(200);
/* 437 */                 this.body.writeBytes(res.build().toByteArray());
/*     */               } 
/*     */             }  }
/*     */         
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public static class GetItemChanagePropertyResult { public RefreshPlayerPropertyChange itemData;
/*     */     
/*     */     public GetItemChanagePropertyResult(RefreshPlayerPropertyChange itemData, boolean bPet) {
/* 448 */       this.itemData = itemData;
/* 449 */       this.bPet = bPet;
/*     */     }
/*     */     
/*     */     public boolean bPet; }
/*     */ 
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\bag\UseItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */