/*     */ package com.wanniu.game.petNew;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.common.IntIntPair;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.PetItemCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.ext.BaseDataExt;
/*     */ import com.wanniu.game.data.ext.PetAssociateExt;
/*     */ import com.wanniu.game.data.ext.PetConfigExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PetNewPO;
/*     */ import com.wanniu.game.poes.PlayerPetsNewPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import com.wanniu.game.util.BlackWordUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.PetNewHandler;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ public class PetManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public PlayerPetsNewPO petsPO;
/*     */   public WNPlayer player;
/*     */   public Map<Integer, PetNew> playerPets;
/*  58 */   public Map<Const.PlayerBtlData, Integer> masterAttr = new ConcurrentHashMap<>();
/*  59 */   public Map<Const.PlayerBtlData, Integer> masterAttrOnOutFight = new HashMap<>();
/*     */ 
/*     */   
/*     */   public PetManager(WNPlayer player, PlayerPetsNewPO petsPO) {
/*  63 */     this.player = player;
/*  64 */     this.petsPO = petsPO;
/*  65 */     this.playerPets = new HashMap<>();
/*     */   }
/*     */   
/*     */   public void init() {
/*  69 */     for (PetNewPO petPO : this.petsPO.pets.values()) {
/*  70 */       PetNew pet = new PetNew(petPO, this.player);
/*  71 */       this.playerPets.put(Integer.valueOf(petPO.id), pet);
/*     */     } 
/*  73 */     refreshMasterAttr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.SummonPetResponse.Builder summonPet(int id) {
/*  83 */     PetNewHandler.SummonPetResponse.Builder res = PetNewHandler.SummonPetResponse.newBuilder();
/*  84 */     Map<Integer, BaseDataExt> map = GameData.BaseDatas;
/*     */     
/*  86 */     if (!map.containsKey(Integer.valueOf(id)) || this.petsPO.pets.containsKey(Integer.valueOf(id))) {
/*  87 */       res.setS2CCode(500);
/*  88 */       res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*  89 */       Out.warn(new Object[] { "宠物召唤失败,配表不存在或者已经有该宠物了!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id) });
/*  90 */       return res;
/*     */     } 
/*  92 */     BaseDataExt prop = map.get(Integer.valueOf(id));
/*  93 */     String itemCode = prop.petItemCode;
/*  94 */     int itemCount = prop.itemCount;
/*  95 */     if (!this.player.bag.isItemNumEnough(itemCode, itemCount)) {
/*  96 */       res.setS2CCode(500);
/*  97 */       res.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
/*  98 */       Out.warn(new Object[] { "宠物召唤失败,道具不足!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id) });
/*  99 */       return res;
/*     */     } 
/*     */     
/* 102 */     this.player.bag.discardItem(itemCode, itemCount, Const.GOODS_CHANGE_TYPE.pet);
/*     */     
/* 104 */     PetNew pet = createPet(id, prop);
/* 105 */     if (pet.po.id == this.petsPO.fightPetId) {
/* 106 */       res.setS2CFight(1);
/*     */     } else {
/* 108 */       res.setS2CFight(0);
/* 109 */     }  res.setS2CCode(200);
/* 110 */     Out.info(new Object[] { "宠物召唤成功!,roleId=", this.player.getId(), ",id=", Integer.valueOf(id) });
/* 111 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String summonPetByItem(int id) {
/* 121 */     if (this.playerPets.containsKey(Integer.valueOf(id)))
/* 122 */       return LangService.getValue("ALREADY_HAVE_PET"); 
/* 123 */     BaseDataExt prop = (BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(id));
/* 124 */     if (prop == null)
/* 125 */       return LangService.getValue("SOMETHING_ERR"); 
/* 126 */     createPet(id, prop);
/* 127 */     return null;
/*     */   }
/*     */   
/*     */   public PetNew createPet(int id, BaseDataExt prop) {
/* 131 */     PetNewPO petPo = new PetNewPO();
/* 132 */     petPo.id = id;
/* 133 */     petPo.name = prop.petName;
/* 134 */     petPo.level = prop.initLevel;
/* 135 */     petPo.upLevel = 0;
/* 136 */     petPo.skills = new HashMap<>();
/* 137 */     int index = 0;
/* 138 */     for (IntIntPair iip : prop.getInitSkills()) {
/* 139 */       PetSkill skill = new PetSkill(iip.first, iip.second, index, 0);
/* 140 */       petPo.skills.put(Integer.valueOf(iip.first), skill);
/* 141 */       index++;
/*     */     } 
/* 143 */     petPo.passiveSkills = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     this.petsPO.pets.put(Integer.valueOf(petPo.id), petPo);
/* 151 */     PetNew pet = new PetNew(petPo, this.player);
/* 152 */     this.playerPets.put(Integer.valueOf(id), pet);
/* 153 */     if (this.playerPets.size() == 1) {
/* 154 */       petOutFight(petPo.id, 1);
/*     */     }
/* 156 */     refreshMasterAttr();
/* 157 */     this.player.onPetPropChange();
/* 158 */     String key = MessageUtil.getColor(pet.prop.qcolor);
/* 159 */     if (key != null && key.length() > 0) {
/* 160 */       String color = LangService.getValue(key).replace("{a}", petPo.name);
/* 161 */       String str = LangService.getValue("GAIN_PET").replace("{petName}", color);
/* 162 */       this.player.sendSysTip(str, Const.TipsType.NORMAL);
/*     */     } 
/* 164 */     PetNewHandler.OnNewPetDetailPush.Builder data = PetNewHandler.OnNewPetDetailPush.newBuilder();
/* 165 */     data.setS2CCode(200);
/* 166 */     data.setS2CMsg("");
/* 167 */     data.setPetInfo(pet.toJson4PayLoad());
/*     */     
/* 169 */     this.player.receive("area.petNewPush.onNewPetDetailPush", (GeneratedMessage)data.build());
/* 170 */     this.player.achievementManager.onGetPet(prop.qcolor);
/* 171 */     this.player.achievementManager.onGetPetLevel(petPo.id, petPo.level);
/*     */     
/* 173 */     LogReportService.getInstance().ansycReportPetSkin(this.player, id);
/* 174 */     BILogService.getInstance().ansycReportPetActivate(this.player.getPlayer(), id, prop.petName);
/* 175 */     return pet;
/*     */   }
/*     */   
/*     */   public PetNewHandler.GetAllPetsInfoResponse.Builder toJson4Payload() {
/* 179 */     PetNewHandler.GetAllPetsInfoResponse.Builder data = PetNewHandler.GetAllPetsInfoResponse.newBuilder();
/* 180 */     data.setS2CCode(200);
/* 181 */     data.setS2CFightingPetId(this.petsPO.fightPetId);
/* 182 */     for (PetNew pet : this.playerPets.values()) {
/* 183 */       data.addS2CPetInfo(pet.toJson4PayLoad());
/*     */     }
/* 185 */     return data;
/*     */   }
/*     */   
/*     */   public void refreshMasterAttr() {
/* 189 */     this.masterAttr = new HashMap<>();
/* 190 */     this.masterAttrOnOutFight = new HashMap<>();
/* 191 */     for (PetNew pet : this.playerPets.values()) {
/* 192 */       AttributeUtil.addData2AllData(pet.attr_master, this.masterAttr);
/* 193 */       if (this.petsPO.fightPetId == pet.po.id) {
/* 194 */         int rate = 0;
/*     */         
/* 196 */         switch (pet.prop.qcolor) {
/*     */           case 1:
/* 198 */             rate = ((PetConfigExt)GameData.PetConfigs.get("PetPro.Transform1")).intValue;
/*     */             break;
/*     */           case 2:
/* 201 */             rate = ((PetConfigExt)GameData.PetConfigs.get("PetPro.Transform2")).intValue;
/*     */             break;
/*     */           case 3:
/* 204 */             rate = ((PetConfigExt)GameData.PetConfigs.get("PetPro.Transform3")).intValue;
/*     */             break;
/*     */           case 4:
/* 207 */             rate = ((PetConfigExt)GameData.PetConfigs.get("PetPro.Transform4")).intValue;
/*     */             break;
/*     */         } 
/* 210 */         if (rate == 0) {
/* 211 */           Out.error(new Object[] { "Can't find qcolor by petid:" + pet.po.id + " qcolor:" + pet.prop.qcolor });
/*     */           
/*     */           continue;
/*     */         } 
/* 215 */         for (Const.PlayerBtlData btl : pet.attr_all_pet.keySet()) {
/* 216 */           if (btl != Const.PlayerBtlData.CritDamage) {
/* 217 */             int val = ((Integer)pet.attr_all_pet.get(btl)).intValue() * rate / 100;
/* 218 */             this.masterAttrOnOutFight.put(btl, Integer.valueOf(val));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 223 */     AttributeUtil.addData2AllData(calAssociateInfluence(), this.masterAttr);
/*     */ 
/*     */     
/* 226 */     if (this.player.rankManager != null) {
/* 227 */       updateRank();
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateRank() {
/* 232 */     PetNewPO petMax = null;
/* 233 */     int petFightPowerMax = 0;
/* 234 */     for (PetNewPO pet : this.petsPO.pets.values()) {
/* 235 */       int petFightPower = pet.fightPower;
/* 236 */       if (petFightPower > petFightPowerMax) {
/* 237 */         petFightPowerMax = petFightPower;
/* 238 */         petMax = pet;
/*     */       } 
/*     */     } 
/* 241 */     if (petMax != null && this.player.rankManager != null) {
/* 242 */       this.player.rankManager.onEvent(RankType.PET, new Object[] { Integer.valueOf(petMax.id), petMax.name, Integer.valueOf(petMax.fightPower) });
/*     */     }
/*     */   }
/*     */   
/*     */   public String petOutFight(int petId, int type) {
/* 247 */     PetNew pet = this.playerPets.get(Integer.valueOf(petId));
/* 248 */     if (pet == null) {
/* 249 */       return LangService.getValue("PET_NOT_EXIST");
/*     */     }
/* 251 */     if (type == 1) {
/* 252 */       if (this.petsPO.fightPetId == petId) {
/* 253 */         return LangService.getValue("ALREADY_BATTLE");
/*     */       }
/* 255 */       if (StringUtil.isEmpty(getFightingPetId())) {
/*     */         
/* 257 */         this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Add.getValue(), pet.getBattlerServerPetData());
/*     */       } else {
/* 259 */         this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Replace.getValue(), pet.getBattlerServerPetData());
/*     */       } 
/* 261 */       this.petsPO.fightPetId = petId;
/* 262 */       this.player.sendSysTip(LangService.getValue("BATTLING"), Const.TipsType.NO_BG);
/*     */     }
/* 264 */     else if (type == 0) {
/* 265 */       if (StringUtil.isEmpty(getFightingPetId()) || this.petsPO.fightPetId != petId) {
/* 266 */         return LangService.getValue("ALREADY_REST");
/*     */       }
/* 268 */       this.petsPO.fightPetId = 0;
/* 269 */       MapBase prop = AreaUtil.getAreaProp(this.player.getAreaId());
/* 270 */       if (prop != null && 1 == prop.takePet) {
/*     */         try {
/* 272 */           this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Delete.getValue(), null);
/* 273 */         } catch (Exception e) {
/* 274 */           Out.error(new Object[] { "syncNowPetData error", e });
/*     */         } 
/* 276 */         this.player.sendSysTip(LangService.getValue("RESTING"), Const.TipsType.NO_BG);
/*     */       } 
/*     */     } else {
/* 279 */       return LangService.getValue("PARAM_ERROR");
/*     */     } 
/*     */     
/* 282 */     refreshMasterAttr();
/* 283 */     this.player.onPetPropChange();
/*     */ 
/*     */     
/* 286 */     this.player.player.fightingPetId = String.valueOf(this.petsPO.fightPetId);
/* 287 */     this.player.pushDynamicData("fightingPetId", this.player.player.fightingPetId);
/*     */     
/* 289 */     BILogService.getInstance().ansycReportPetBattle(this.player.getPlayer(), petId, pet.prop.petName, pet.po.level, pet.po.upLevel, type);
/* 290 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.ChangePetNameNewResponse.Builder changePetName(int id, String petName) {
/* 299 */     PetNewHandler.ChangePetNameNewResponse.Builder result = PetNewHandler.ChangePetNameNewResponse.newBuilder();
/* 300 */     result.setS2CCode(500);
/* 301 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 302 */     if (pet == null) {
/* 303 */       result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 304 */       return result;
/*     */     } 
/*     */     
/* 307 */     if (petName == null || petName.length() <= 0) {
/* 308 */       result.setS2CMsg(LangService.getValue("PET_NAME_NULL"));
/* 309 */       return result;
/*     */     } 
/* 311 */     if (petName.length() > 6) {
/* 312 */       result.setS2CMsg(LangService.getValue("PET_NAME_LONG"));
/* 313 */       return result;
/*     */     } 
/* 315 */     if (!CommonUtil.isLegalString(petName) || BlackWordUtil.isIncludeBlackString(petName)) {
/* 316 */       result.setS2CMsg(LangService.getValue("ILLEGAL_CHARACTER"));
/* 317 */       return result;
/*     */     } 
/* 319 */     if (!this.player.moneyManager.costDiamond(((PetConfigExt)GameData.PetConfigs.get("Rename.Cost")).intValue, Const.GOODS_CHANGE_TYPE.petChangeName)) {
/* 320 */       result.setS2CMsg(LangService.getValue("NOT_ENOUGH_DIAMOND"));
/* 321 */       return result;
/*     */     } 
/* 323 */     result.setS2CCode(200);
/*     */     
/* 325 */     pet.po.name = petName;
/*     */     
/* 327 */     updateRank();
/*     */     
/* 329 */     if (this.petsPO.fightPetId == pet.po.id) {
/* 330 */       this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
/*     */     }
/* 332 */     result.setPetInfo(pet.toJson4PayLoad());
/* 333 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.AddExpByItemResponse.Builder addExpByItem(int id, String itemCode, int itemCount) {
/* 343 */     PetNewHandler.AddExpByItemResponse.Builder result = PetNewHandler.AddExpByItemResponse.newBuilder();
/* 344 */     result.setS2CCode(500);
/* 345 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 346 */     if (pet == null) {
/* 347 */       result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 348 */       Out.warn(new Object[] { "宠物单次加经验失败,找不到该宠物!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode });
/* 349 */       return result;
/*     */     } 
/* 351 */     if (!pet.prop.list_ExpCode.contains(itemCode)) {
/* 352 */       result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 353 */       Out.warn(new Object[] { "宠物单次加经验失败,配表找不到宠物使用的经验药水!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode });
/* 354 */       return result;
/*     */     } 
/* 356 */     if (!this.player.bag.isItemNumEnough(itemCode, itemCount)) {
/* 357 */       result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
/* 358 */       return result;
/*     */     } 
/* 360 */     if (!pet.canAddExp()) {
/* 361 */       result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
/* 362 */       Out.warn(new Object[] { "宠物单次加经验失败,等级超上限了!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode, ",当前等级为:", Integer.valueOf(pet.po.level), ",当前可提升最大等级为:", Integer.valueOf(pet.getCurMaxLv()) });
/* 363 */       return result;
/*     */     } 
/* 365 */     result.setS2CCode(200);
/* 366 */     PetItemCO prop_item = (PetItemCO)GameData.PetItems.get(itemCode);
/* 367 */     int exp = prop_item.min;
/* 368 */     int remain = itemCount;
/*     */     
/* 370 */     while (pet.canAddExp() && remain > 0) {
/* 371 */       remain--;
/* 372 */       pet.addExp(exp, true);
/*     */     } 
/* 374 */     this.player.bag.discardItem(itemCode, itemCount - remain, Const.GOODS_CHANGE_TYPE.pet);
/* 375 */     result.setPetInfo(pet.toJson4PayLoad());
/*     */ 
/*     */     
/* 378 */     this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
/* 379 */     Out.info(new Object[] { "宠物单次加经验成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",道具Id=", itemCode, "，当前等级=", Integer.valueOf(pet.po.level), ",当前经验为:", Long.valueOf(pet.po.exp) });
/* 380 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.UpgradeToTopResponse.Builder reqUpgrade2Top(int id) {
/* 390 */     PetNewHandler.UpgradeToTopResponse.Builder result = PetNewHandler.UpgradeToTopResponse.newBuilder();
/* 391 */     result.setS2CCode(500);
/* 392 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 393 */     if (pet == null) {
/* 394 */       result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 395 */       Out.warn(new Object[] { "宠物升级最高等级失败,找不到该宠物!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id) });
/* 396 */       return result;
/*     */     } 
/* 398 */     if (!pet.canAddExp()) {
/* 399 */       result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
/* 400 */       Out.warn(new Object[] { "宠物升级最高等级失败,等级超上限了!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), ",当前等级为:", Integer.valueOf(pet.po.level), ",当前可提升最大等级为:", Integer.valueOf(pet.getCurMaxLv()) });
/* 401 */       return result;
/*     */     } 
/* 403 */     boolean flag = false;
/* 404 */     for (String itemCode : pet.prop.list_ExpCode) {
/* 405 */       if (this.player.bag.findItemNumByCode(itemCode) > 0) {
/* 406 */         flag = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 410 */     if (!flag) {
/* 411 */       result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
/* 412 */       return result;
/*     */     } 
/* 414 */     result.setS2CCode(200);
/* 415 */     boolean hasUpgrade = false;
/* 416 */     boolean hasItem = true;
/* 417 */     int loopCount = 0;
/* 418 */     while (pet.canAddExp() && hasItem && loopCount++ < 100) {
/* 419 */       boolean isItemFlag = false;
/* 420 */       long nextLvExp = pet.getNextLevelneedExp();
/* 421 */       for (String itemCode : pet.prop.list_ExpCode) {
/* 422 */         if (!pet.canAddExp())
/*     */           break; 
/* 424 */         PetItemCO prop_item = (PetItemCO)GameData.PetItems.get(itemCode);
/* 425 */         int exp = prop_item.min;
/* 426 */         int itemCount = this.player.bag.findItemNumByCode(itemCode);
/* 427 */         if (itemCount <= 0) {
/*     */           continue;
/*     */         }
/* 430 */         isItemFlag = true;
/* 431 */         long canAddExp = 1L * itemCount * exp;
/* 432 */         int removeItemCount = itemCount;
/* 433 */         int result_addExp = 0;
/* 434 */         if (nextLvExp >= canAddExp) {
/* 435 */           result_addExp = pet.addExp((int)canAddExp, false);
/*     */         } else {
/* 437 */           long t1 = nextLvExp % exp;
/* 438 */           removeItemCount = (t1 == 0L) ? (int)(nextLvExp / exp) : (int)(nextLvExp / exp + 1L);
/* 439 */           result_addExp = pet.addExp((int)nextLvExp, false);
/*     */         } 
/* 441 */         if (result_addExp == 1) {
/* 442 */           hasUpgrade = true;
/* 443 */           nextLvExp = pet.getNextLevelneedExp();
/*     */         } 
/* 445 */         this.player.bag.discardItem(itemCode, removeItemCount, Const.GOODS_CHANGE_TYPE.pet);
/*     */       } 
/* 447 */       hasItem = isItemFlag;
/*     */     } 
/* 449 */     if (loopCount >= 100) {
/* 450 */       Out.warn(new Object[] { "一键升顶时判断有异常情况,怀疑死循环,playerId=", this.player.getId() });
/*     */     }
/*     */     
/* 453 */     if (hasUpgrade && this.petsPO.fightPetId == pet.po.id) {
/* 454 */       this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
/*     */     }
/* 456 */     if (hasUpgrade) {
/* 457 */       refreshMasterAttr();
/* 458 */       this.player.onPetPropChange();
/* 459 */       pet.pushInfoUpdate();
/*     */     } else {
/* 461 */       pet.pushExpUpdate();
/*     */     } 
/* 463 */     result.setPetInfo(pet.toJson4PayLoad());
/*     */ 
/*     */     
/* 466 */     this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
/* 467 */     Out.info(new Object[] { "宠物升级最高等级成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "，当前等级=", Integer.valueOf(pet.po.level), ",当前经验为:", Long.valueOf(pet.po.exp) });
/* 468 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.UpgradeOneLevelResponse.Builder reqUpgradeOneLevel(int id) {
/* 478 */     PetNewHandler.UpgradeOneLevelResponse.Builder result = PetNewHandler.UpgradeOneLevelResponse.newBuilder();
/* 479 */     result.setS2CCode(500);
/* 480 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 481 */     if (pet == null) {
/* 482 */       result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 483 */       return result;
/*     */     } 
/* 485 */     if (!pet.canAddExp()) {
/* 486 */       result.setS2CMsg(LangService.getValue("PET_MAX_LEVEL"));
/* 487 */       return result;
/*     */     } 
/* 489 */     boolean flag = false;
/* 490 */     for (String itemCode : pet.prop.list_ExpCode) {
/* 491 */       if (this.player.bag.findItemNumByCode(itemCode) > 0) {
/* 492 */         flag = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 496 */     if (!flag) {
/* 497 */       result.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
/* 498 */       return result;
/*     */     } 
/*     */     
/* 501 */     result.setS2CCode(200);
/* 502 */     int targetLevel = pet.po.level + 1;
/* 503 */     boolean hasUpgrade = false;
/* 504 */     for (String itemCode : pet.prop.list_ExpCode) {
/* 505 */       if (!pet.canAddExp())
/*     */         break; 
/* 507 */       PetItemCO prop_item = (PetItemCO)GameData.PetItems.get(itemCode);
/* 508 */       int exp = prop_item.min;
/* 509 */       int itemCount = this.player.bag.findItemNumByCode(itemCode);
/* 510 */       int remain = itemCount;
/* 511 */       int result_addExp = 0;
/* 512 */       while (pet.po.level < targetLevel && remain > 0) {
/* 513 */         remain--;
/* 514 */         result_addExp = pet.addExp(exp, false);
/* 515 */         if (!hasUpgrade && result_addExp == 1) {
/* 516 */           hasUpgrade = true;
/*     */         }
/*     */       } 
/* 519 */       this.player.bag.discardItem(itemCode, itemCount - remain, Const.GOODS_CHANGE_TYPE.pet);
/*     */     } 
/* 521 */     result.setPetInfo(pet.toJson4PayLoad());
/*     */ 
/*     */ 
/*     */     
/* 525 */     if (hasUpgrade && this.petsPO.fightPetId == pet.po.id) {
/* 526 */       this.player.getXmdsManager().refreshPlayerPetDataChange(this.player.getId(), PetOperatorType.Reset.getValue(), pet.getBattlerServerPetData());
/*     */     }
/* 528 */     if (hasUpgrade) {
/* 529 */       refreshMasterAttr();
/* 530 */       this.player.onPetPropChange();
/* 531 */       pet.pushInfoUpdate();
/*     */     } else {
/* 533 */       pet.pushExpUpdate();
/*     */     } 
/*     */ 
/*     */     
/* 537 */     this.player.taskManager.dealTaskEvent(Const.TaskType.PET_TRAIN, String.valueOf(id), 1);
/* 538 */     return result;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getBattlerServerPetBase() {
/* 542 */     if (this.petsPO.fightPetId != 0) {
/* 543 */       PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
/* 544 */       return (Map<String, Object>)pet.getBattlerServerPetBase();
/*     */     } 
/* 546 */     Map<String, Object> data = new HashMap<>();
/* 547 */     data.put("Model", "");
/* 548 */     data.put("ModelPercent", Integer.valueOf(0));
/* 549 */     data.put("ModelStar", "");
/* 550 */     data.put("ModelStarPercent", Integer.valueOf(0));
/* 551 */     data.put("name", "");
/* 552 */     data.put("level", Integer.valueOf(0));
/* 553 */     data.put("Qcolor", Integer.valueOf(0));
/* 554 */     data.put("templateId", Integer.valueOf(0));
/* 555 */     data.put("Icon", "");
/* 556 */     data.put("upGradeLevel", Integer.valueOf(0));
/* 557 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Object> getBattlerServerPetEffect() {
/* 562 */     Map<String, Object> data = new HashMap<>();
/* 563 */     if (this.petsPO.fightPetId != 0) {
/* 564 */       PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 570 */       JSONObject json = pet.getBattlerServerPetEffect();
/* 571 */       for (String key : json.keySet()) {
/* 572 */         data.put(key, json.get(key));
/*     */       }
/*     */     } else {
/* 575 */       data.put("Ac", Integer.valueOf(0));
/* 576 */       data.put("Crit", Integer.valueOf(0));
/* 577 */       data.put("Dodge", Integer.valueOf(0));
/* 578 */       data.put("Hit", Integer.valueOf(0));
/* 579 */       data.put("HP", Integer.valueOf(0));
/* 580 */       data.put("HPReborn", Integer.valueOf(0));
/* 581 */       data.put("IgnoreAc", Integer.valueOf(0));
/* 582 */       data.put("IgnoreAcPer", Integer.valueOf(0));
/* 583 */       data.put("IgnoreResist", Integer.valueOf(0));
/* 584 */       data.put("IgnoreResistPer", Integer.valueOf(0));
/* 585 */       data.put("IgnorMagDamage", Integer.valueOf(0));
/* 586 */       data.put("IgnorPhyDamage", Integer.valueOf(0));
/* 587 */       data.put("MaxHP", Integer.valueOf(0));
/* 588 */       data.put("MaxMag", Integer.valueOf(0));
/* 589 */       data.put("MaxMP", Integer.valueOf(0));
/* 590 */       data.put("MaxPhy", Integer.valueOf(0));
/* 591 */       data.put("MinMag", Integer.valueOf(0));
/* 592 */       data.put("MinPhy", Integer.valueOf(0));
/* 593 */       data.put("MoveSpeed", Integer.valueOf(0));
/* 594 */       data.put("MP", Integer.valueOf(0));
/* 595 */       data.put("MPReborn", Integer.valueOf(0));
/* 596 */       data.put("Rescrit", Integer.valueOf(0));
/* 597 */       data.put("Resist", Integer.valueOf(0));
/* 598 */       data.put("HealEffect", Integer.valueOf(0));
/* 599 */       data.put("HealedEffect", Integer.valueOf(0));
/*     */     } 
/* 601 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map<String, Integer>> getBattlerServerPetSkill() {
/* 607 */     List<Map<String, Integer>> data = new ArrayList<>();
/* 608 */     if (this.petsPO.fightPetId != 0) {
/* 609 */       PetNew pet = this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
/* 610 */       return pet.getBattlerServerPetSkill();
/*     */     } 
/* 612 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPkDataToBattleJson() {
/* 621 */     MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
/* 622 */     if (sceneProp != null && 
/* 623 */       sceneProp.changePetAI == 0) {
/* 624 */       return sceneProp.petAI;
/*     */     }
/*     */     
/* 627 */     return getPkModel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPkModel() {
/* 636 */     return 1;
/*     */   }
/*     */   
/*     */   public String getFightingPetId() {
/* 640 */     return (this.petsPO.fightPetId == 0) ? "" : (this.petsPO.fightPetId + "");
/*     */   }
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
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 657 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int petCanGet() {
/* 662 */     return this.petsPO.pkModel;
/*     */   }
/*     */   
/*     */   public PetNew getFightingPet() {
/* 666 */     return this.playerPets.get(Integer.valueOf(this.petsPO.fightPetId));
/*     */   }
/*     */   
/*     */   public void addExp(String id, int exp) {
/* 670 */     addExp(StringUtil.isEmpty(id) ? 0 : Integer.parseInt(id), exp);
/*     */   }
/*     */   
/*     */   public void addExp(int id, int exp) {
/* 674 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 675 */     if (pet != null) {
/* 676 */       pet.addExp(exp, true);
/*     */     }
/*     */   }
/*     */   
/*     */   public String changePetPkModel(int reqModel) {
/* 681 */     MapBase sceneProp = AreaDataConfig.getInstance().get(this.player.getAreaId());
/* 682 */     if (sceneProp != null && 
/* 683 */       sceneProp.changePKtype == 0) {
/* 684 */       return LangService.getValue("AREA_CANNOT_CHANG_PKMODE");
/*     */     }
/*     */     
/* 687 */     if (reqModel == getPkModel()) {
/* 688 */       return LangService.getValue("PARAM_ERROR");
/*     */     }
/* 690 */     this.petsPO.pkModel = reqModel;
/*     */     
/* 692 */     this.player.getXmdsManager().refreshPlayerPetFollowModeChange(this.player.getId(), reqModel);
/*     */     
/* 694 */     this.player.pushDynamicData("petPkModel", Integer.valueOf(this.petsPO.pkModel));
/*     */     
/* 696 */     return null;
/*     */   }
/*     */   
/*     */   public PetNewHandler.UpGradeUpLevelResponse.Builder upgradeUplevel(int id) {
/* 700 */     PetNewHandler.UpGradeUpLevelResponse.Builder res = PetNewHandler.UpGradeUpLevelResponse.newBuilder();
/* 701 */     res.setS2CCode(500);
/* 702 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 703 */     if (pet == null) {
/* 704 */       res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 705 */       Out.warn(new Object[] { "宠物突破失败,因为宠物不存在!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id) });
/* 706 */       return res;
/*     */     } 
/* 708 */     int result = pet.upgradeUplevel();
/* 709 */     if (result == 0) {
/* 710 */       res.setS2CCode(200);
/* 711 */       res.setPetInfo(pet.toJson4PayLoad());
/*     */     } else {
/* 713 */       Out.warn(new Object[] { "宠物突破失败!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "result=", Integer.valueOf(result) });
/* 714 */       res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*     */     } 
/* 716 */     this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.PET_UPGRADE_UPLV, new Object[] { Integer.valueOf(getMaxPetUpLv()) });
/* 717 */     Out.info(new Object[] { "宠物突破成功!,roleId=", this.player.getId(), ",宠物id=", Integer.valueOf(id), "当前阶为:", Integer.valueOf(pet.po.upLevel) });
/* 718 */     return res;
/*     */   }
/*     */   
/*     */   private void onPlayerUpgrade() {
/* 722 */     for (PetNew pet : this.playerPets.values()) {
/* 723 */       pet.initCurMaxLv();
/*     */     }
/*     */   }
/*     */   
/*     */   public PetNewHandler.GetPetInfoNewResponse.Builder getPetInfo(int id) {
/* 728 */     PetNewHandler.GetPetInfoNewResponse.Builder res = PetNewHandler.GetPetInfoNewResponse.newBuilder();
/* 729 */     PetNew pet = this.playerPets.get(Integer.valueOf(id));
/* 730 */     if (pet == null) {
/* 731 */       res.setS2CCode(500);
/* 732 */       res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 733 */       return res;
/*     */     } 
/* 735 */     res.setS2CCode(200);
/* 736 */     res.setS2CPet(pet.toJson4PayLoad());
/* 737 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Const.PlayerBtlData, Integer> calAssociateInfluence() {
/* 745 */     Map<Const.PlayerBtlData, Integer> data = new HashMap<>();
/* 746 */     for (PetAssociateExt petAssociateExt : GameData.PetAssociates.values()) {
/* 747 */       boolean actived = true;
/* 748 */       for (Map.Entry<Integer, Integer> entry : (Iterable<Map.Entry<Integer, Integer>>)petAssociateExt.petIDMap.entrySet()) {
/* 749 */         PetNewPO activedPetNewPO = null;
/* 750 */         for (PetNewPO petNewPO : this.petsPO.pets.values()) {
/* 751 */           if (petNewPO.id == ((Integer)entry.getKey()).intValue())
/*     */           {
/* 753 */             if (petNewPO.upLevel >= ((Integer)entry.getValue()).intValue()) {
/*     */               
/* 755 */               activedPetNewPO = petNewPO;
/*     */               break;
/*     */             } 
/*     */           }
/*     */         } 
/* 760 */         if (activedPetNewPO == null)
/*     */         {
/* 762 */           actived = false;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 767 */       if (!actived) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 772 */       for (Map.Entry<Integer, Integer> entry2 : (Iterable<Map.Entry<Integer, Integer>>)petAssociateExt.addProMap.entrySet()) {
/* 773 */         Const.PlayerBtlData key = Const.PlayerBtlData.getE(((Integer)entry2.getKey()).intValue());
/* 774 */         int oldValue = 0;
/* 775 */         if (data.containsKey(key)) {
/* 776 */           oldValue += ((Integer)data.get(key)).intValue();
/*     */         }
/*     */         
/* 779 */         data.put(key, Integer.valueOf(((Integer)entry2.getValue()).intValue() + oldValue));
/*     */       } 
/*     */     } 
/*     */     
/* 783 */     return data;
/*     */   }
/*     */   
/*     */   public int getMaxPetUpLv() {
/* 787 */     int maxUpLv = 0;
/* 788 */     for (PetNew petNew : this.playerPets.values()) {
/* 789 */       if (petNew.po.upLevel > maxUpLv) {
/* 790 */         maxUpLv = petNew.po.upLevel;
/*     */       }
/*     */     } 
/* 793 */     return maxUpLv;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 798 */     switch (eventType) {
/*     */       case UPGRADE:
/* 800 */         onPlayerUpgrade();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 811 */     return Const.ManagerType.PET;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\petNew\PetManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */