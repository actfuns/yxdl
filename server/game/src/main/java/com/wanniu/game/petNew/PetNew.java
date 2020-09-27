/*     */ package com.wanniu.game.petNew;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.common.IntIntPair;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.PetExpLevelCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.ext.BaseDataExt;
/*     */ import com.wanniu.game.data.ext.MasterPropExt;
/*     */ import com.wanniu.game.data.ext.MasterUpgradePropExt;
/*     */ import com.wanniu.game.data.ext.PassiveSkillExt;
/*     */ import com.wanniu.game.data.ext.PetConfigExt;
/*     */ import com.wanniu.game.data.ext.PetSkillExt;
/*     */ import com.wanniu.game.data.ext.PetUpgradeExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.PetNewPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.PetNewHandler;
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
/*     */ public class PetNew
/*     */ {
/*     */   private static final int Tenthousand = 10000;
/*     */   public PetNewPO po;
/*     */   public BaseDataExt prop;
/*     */   private PetExpLevelCO curLevelExp;
/*     */   public Map<Const.PlayerBtlData, Integer> attr_all_pet;
/*     */   public Map<Const.PlayerBtlData, Integer> attr_final_pet;
/*     */   public Map<Const.PlayerBtlData, Integer> attr_final_pet_next;
/*     */   public Map<Const.PlayerBtlData, Integer> attr_master;
/*     */   private int curMaxLv;
/*     */   private WNPlayer master;
/*     */   
/*     */   public PetNew(PetNewPO po, WNPlayer master) {
/*  67 */     this.po = po;
/*  68 */     this.master = master;
/*  69 */     this.prop = (BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(po.id));
/*  70 */     initCurMaxLv();
/*  71 */     this.attr_all_pet = new HashMap<>();
/*  72 */     this.attr_final_pet = new HashMap<>();
/*  73 */     this.attr_final_pet_next = new HashMap<>();
/*  74 */     calAttr();
/*  75 */     calMasterAttr();
/*     */   }
/*     */   
/*     */   public int getCurMaxLv() {
/*  79 */     return this.curMaxLv;
/*     */   }
/*     */   
/*     */   public void initCurMaxLv() {
/*  83 */     this.curLevelExp = (PetExpLevelCO)GameData.PetExpLevels.get(Integer.valueOf(this.po.level));
/*  84 */     this.curMaxLv = ((PetConfigExt)GameData.PetConfigs.get("LevelLimit")).intValue;
/*     */   }
/*     */   
/*     */   private void calAttr() {
/*  88 */     this.attr_all_pet.clear();
/*  89 */     this.attr_final_pet.clear();
/*  90 */     this.attr_all_pet.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.basePhyDamage, this.prop.phyGrowUp, this.po.level)));
/*  91 */     this.attr_all_pet.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.baseMagDamage, this.prop.magGrowUp, this.po.level)));
/*  92 */     this.attr_all_pet.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initHit, this.prop.hitGrowUP, this.po.level)));
/*  93 */     this.attr_all_pet.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCrit, this.prop.critGrowUP, this.po.level)));
/*  94 */     this.attr_all_pet.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCritDamage, this.prop.critDamageGrowUp, this.po.level)));
/*     */ 
/*     */     
/*  97 */     Map<Const.PlayerBtlData, Integer> upLevelAttrs = null;
/*  98 */     List<PetUpgradeExt> list = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == this.po.upLevel));
/*  99 */     if (list.size() > 0) {
/* 100 */       upLevelAttrs = ((PetUpgradeExt)list.get(0)).upLevelAttrs;
/* 101 */       AttributeUtil.addData2AllData(upLevelAttrs, this.attr_all_pet);
/*     */     } 
/* 103 */     AttributeUtil.addData2AllData(calPassiveSkill(), this.attr_all_pet);
/*     */     
/* 105 */     AttributeUtil.addData2AllData(getSkillAttr(1), this.attr_all_pet);
/* 106 */     AttributeUtil.addData2AllData(this.attr_all_pet, this.attr_final_pet);
/*     */     
/* 108 */     calFinalData(this.attr_final_pet);
/*     */     
/* 110 */     this.po.fightPower = CommonUtil.calPetFightPower(this.attr_final_pet, this.po.id);
/* 111 */     this.po.fightPower += getSkillsPower();
/*     */     
/* 113 */     calNextAttr();
/*     */   }
/*     */   
/*     */   private void calNextAttr() {
/* 117 */     this.attr_final_pet_next.clear();
/*     */     
/* 119 */     Map<Const.PlayerBtlData, Integer> attr_temp = new HashMap<>();
/* 120 */     attr_temp.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.basePhyDamage, this.prop.phyGrowUp, this.po.level)));
/* 121 */     attr_temp.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.baseMagDamage, this.prop.magGrowUp, this.po.level)));
/* 122 */     attr_temp.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initHit, this.prop.hitGrowUP, this.po.level)));
/* 123 */     attr_temp.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCrit, this.prop.critGrowUP, this.po.level)));
/* 124 */     attr_temp.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(CommonUtil.getGrowUpValue(this.prop.initCritDamage, this.prop.critDamageGrowUp, this.po.level)));
/*     */     
/* 126 */     List<PetUpgradeExt> list = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == this.po.upLevel + 1));
/* 127 */     if (list.size() > 0) {
/* 128 */       Map<Const.PlayerBtlData, Integer> upLevelAttrs = ((PetUpgradeExt)list.get(0)).upLevelAttrs;
/* 129 */       AttributeUtil.addData2AllData(upLevelAttrs, attr_temp);
/*     */     } 
/* 131 */     AttributeUtil.addData2AllData(calPassiveSkill(), attr_temp);
/*     */     
/* 133 */     AttributeUtil.addData2AllData(getSkillAttr(1), attr_temp);
/*     */     
/* 135 */     AttributeUtil.addData2AllData(attr_temp, this.attr_final_pet_next);
/* 136 */     calFinalData(this.attr_final_pet_next);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calFinalData(Map<Const.PlayerBtlData, Integer> attr) {
/* 144 */     int baseValue = 0;
/* 145 */     if (attr.containsKey(Const.PlayerBtlData.Phy)) {
/* 146 */       baseValue += ((Integer)attr.get(Const.PlayerBtlData.Phy)).intValue();
/*     */     }
/* 148 */     if (attr.containsKey(Const.PlayerBtlData.Attack)) {
/* 149 */       baseValue += ((Integer)attr.get(Const.PlayerBtlData.Attack)).intValue();
/*     */     }
/* 151 */     attr.put(Const.PlayerBtlData.Phy, Integer.valueOf(baseValue));
/*     */     
/* 153 */     int basePer = 0;
/* 154 */     if (attr.containsKey(Const.PlayerBtlData.PhyPer)) {
/* 155 */       basePer += ((Integer)attr.get(Const.PlayerBtlData.PhyPer)).intValue();
/*     */     }
/* 157 */     if (attr.containsKey(Const.PlayerBtlData.AttackPer)) {
/* 158 */       basePer += ((Integer)attr.get(Const.PlayerBtlData.AttackPer)).intValue();
/*     */     }
/* 160 */     attr.put(Const.PlayerBtlData.PhyPer, Integer.valueOf(basePer));
/*     */     
/* 162 */     baseValue = 0;
/* 163 */     if (attr.containsKey(Const.PlayerBtlData.Mag)) {
/* 164 */       baseValue += ((Integer)attr.get(Const.PlayerBtlData.Mag)).intValue();
/*     */     }
/* 166 */     if (attr.containsKey(Const.PlayerBtlData.Attack)) {
/* 167 */       baseValue += ((Integer)attr.get(Const.PlayerBtlData.Attack)).intValue();
/*     */     }
/* 169 */     attr.put(Const.PlayerBtlData.Mag, Integer.valueOf(baseValue));
/*     */     
/* 171 */     basePer = 0;
/* 172 */     if (attr.containsKey(Const.PlayerBtlData.MagPer)) {
/* 173 */       basePer += ((Integer)attr.get(Const.PlayerBtlData.MagPer)).intValue();
/*     */     }
/* 175 */     if (attr.containsKey(Const.PlayerBtlData.AttackPer)) {
/* 176 */       basePer += ((Integer)attr.get(Const.PlayerBtlData.AttackPer)).intValue();
/*     */     }
/* 178 */     attr.put(Const.PlayerBtlData.MagPer, Integer.valueOf(basePer));
/*     */ 
/*     */     
/* 181 */     if (attr.containsKey(Const.PlayerBtlData.Phy) && attr.containsKey(Const.PlayerBtlData.PhyPer)) {
/* 182 */       int value = ((Integer)attr.get(Const.PlayerBtlData.Phy)).intValue();
/* 183 */       attr.put(Const.PlayerBtlData.Phy, Integer.valueOf(value + value * ((Integer)attr.get(Const.PlayerBtlData.PhyPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 186 */     if (attr.containsKey(Const.PlayerBtlData.Mag) && attr.containsKey(Const.PlayerBtlData.MagPer)) {
/* 187 */       int value = ((Integer)attr.get(Const.PlayerBtlData.Mag)).intValue();
/* 188 */       attr.put(Const.PlayerBtlData.Mag, Integer.valueOf(value + value * ((Integer)attr.get(Const.PlayerBtlData.MagPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 191 */     if (attr.containsKey(Const.PlayerBtlData.Hit) && attr.containsKey(Const.PlayerBtlData.HitPer)) {
/* 192 */       int value = ((Integer)attr.get(Const.PlayerBtlData.Hit)).intValue();
/* 193 */       attr.put(Const.PlayerBtlData.Hit, Integer.valueOf(value + value * ((Integer)attr.get(Const.PlayerBtlData.HitPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 196 */     if (attr.containsKey(Const.PlayerBtlData.Crit) && attr.containsKey(Const.PlayerBtlData.CritPer)) {
/* 197 */       int value = ((Integer)attr.get(Const.PlayerBtlData.Crit)).intValue();
/* 198 */       attr.put(Const.PlayerBtlData.Crit, Integer.valueOf(value + value * ((Integer)attr.get(Const.PlayerBtlData.CritPer)).intValue() / 10000));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calMasterAttr() {
/* 206 */     this.attr_master = new HashMap<>();
/* 207 */     MasterPropExt prop = (MasterPropExt)GameData.MasterProps.get(Integer.valueOf(this.po.id));
/* 208 */     for (Const.PlayerBtlData pbd : prop.attr_master.keySet()) {
/* 209 */       this.attr_master.put(pbd, Integer.valueOf(CommonUtil.getGrowUpValue(((Integer)prop.attr_master.get(pbd)).intValue(), ((Float)prop.attr_grow.get(pbd)).floatValue(), this.po.level)));
/*     */     }
/*     */ 
/*     */     
/* 213 */     List<MasterUpgradePropExt> props = GameData.findMasterUpgradeProps(v -> (v.petID == this.po.id && v.upLevel == this.po.upLevel));
/* 214 */     if (props.size() == 1) {
/* 215 */       MasterUpgradePropExt template = props.get(0);
/* 216 */       AttributeUtil.addData2AllData(template.attr_master, this.attr_master);
/*     */     } else {
/* 218 */       Out.warn(new Object[] { "宠物升阶对人物加成配置异常. petId=", Integer.valueOf(this.po.id), ",upLevel=", Integer.valueOf(this.po.upLevel) });
/*     */     } 
/*     */     
/* 221 */     AttributeUtil.addData2AllData(calMasterPassiveSkill(), this.attr_master);
/*     */     
/* 223 */     AttributeUtil.addData2AllData(getSkillAttr(2), this.attr_all_pet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Const.PlayerBtlData, Integer> calPassiveSkill() {
/* 232 */     Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
/* 233 */     for (PetSkill skill : this.po.skills.values()) {
/* 234 */       if (skill.level > 0) {
/* 235 */         PetSkillExt skillProp = (PetSkillExt)GameData.PetSkills.get(Integer.valueOf(skill.id));
/* 236 */         if (skillProp == null) {
/* 237 */           Out.error(new Object[] { "can't find prop by skillId:", Integer.valueOf(skill.id) });
/*     */           continue;
/*     */         } 
/* 240 */         if (skillProp.skillType == Const.SkillType.PASSIVE.getValue())
/* 241 */           for (Const.PlayerBtlData pbd : skillProp.attributeValues.keySet()) {
/* 242 */             Map<Integer, Integer> map_attr_level = (Map<Integer, Integer>)skillProp.attributeValues.get(pbd);
/* 243 */             Integer value = map_attr_level.get(Integer.valueOf(skill.level));
/* 244 */             if (value != null) {
/* 245 */               map.put(pbd, value);
/*     */             }
/*     */           }  
/*     */       } 
/*     */     } 
/* 250 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Const.PlayerBtlData, Integer> calMasterPassiveSkill() {
/* 259 */     Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
/* 260 */     for (PetSkill skill : this.po.skills.values()) {
/* 261 */       if (skill.level > 0) {
/* 262 */         PetSkillExt skillProp = (PetSkillExt)GameData.PetSkills.get(Integer.valueOf(skill.id));
/* 263 */         if (skillProp.skillType == Const.SkillType.PET_PASSIVE.getValue())
/* 264 */           for (Const.PlayerBtlData pbd : skillProp.attributeValues.keySet()) {
/* 265 */             Map<Integer, Integer> map_attr_level = (Map<Integer, Integer>)skillProp.attributeValues.get(pbd);
/* 266 */             Integer value = map_attr_level.get(Integer.valueOf(skill.level));
/* 267 */             if (value != null) {
/* 268 */               map.put(pbd, value);
/*     */             }
/*     */           }  
/*     */       } 
/*     */     } 
/* 273 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PetNewHandler.PetDataInfo.Builder toJson4PayLoad() {
/* 282 */     PetNewHandler.PetDataInfo.Builder data = PetNewHandler.PetDataInfo.newBuilder();
/* 283 */     data.setId(this.po.id);
/* 284 */     data.setName(this.po.name);
/* 285 */     data.setExp(this.po.exp);
/* 286 */     data.setLevel(this.po.level);
/* 287 */     data.setUpLevel(this.po.upLevel);
/* 288 */     data.setFightPower(this.po.fightPower);
/* 289 */     ArrayList<Common.AttributeSimple> list_attrs_pet = new ArrayList<>();
/* 290 */     for (Const.PlayerBtlData pbd : this.attr_final_pet.keySet()) {
/* 291 */       Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
/* 292 */       asb.setId(pbd.id);
/* 293 */       asb.setValue(((Integer)this.attr_final_pet.get(pbd)).intValue());
/* 294 */       list_attrs_pet.add(asb.build());
/*     */     } 
/* 296 */     data.addAllAttrsFinal(list_attrs_pet);
/*     */     
/* 298 */     ArrayList<Common.AttributeSimple> list_attrs_pet_next = new ArrayList<>();
/* 299 */     for (Const.PlayerBtlData pbd : this.attr_final_pet_next.keySet()) {
/* 300 */       Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
/* 301 */       asb.setId(pbd.id);
/* 302 */       asb.setValue(((Integer)this.attr_final_pet_next.get(pbd)).intValue());
/* 303 */       list_attrs_pet_next.add(asb.build());
/*     */     } 
/* 305 */     data.addAllNextAttrsFinal(list_attrs_pet_next);
/*     */     
/* 307 */     ArrayList<PetNewHandler.SkillDataInfo> list_skill = new ArrayList<>();
/* 308 */     for (IntIntPair iip : this.prop.getInitSkills()) {
/* 309 */       PetSkill skill = (PetSkill)this.po.skills.get(Integer.valueOf(iip.first));
/* 310 */       if (skill != null) {
/* 311 */         PetNewHandler.SkillDataInfo.Builder sb = PetNewHandler.SkillDataInfo.newBuilder();
/* 312 */         sb.setId(skill.id);
/* 313 */         sb.setLevel(skill.level);
/* 314 */         sb.setPos(skill.pos);
/* 315 */         sb.setInborn(skill.inborn);
/* 316 */         list_skill.add(sb.build());
/*     */       } 
/*     */     } 
/* 319 */     data.addAllSkills(list_skill);
/* 320 */     return data;
/*     */   }
/*     */   
/*     */   public int addExp(int exp, boolean synchBattleServer) {
/* 324 */     if (this.po.level >= getCurMaxLv()) {
/* 325 */       return -1;
/*     */     }
/* 327 */     this.po.exp += exp;
/* 328 */     boolean upgrade = false;
/* 329 */     if (this.po.exp >= this.curLevelExp.experience) {
/* 330 */       upgrade = upgrade(synchBattleServer);
/* 331 */       if (synchBattleServer && this.master != null) {
/* 332 */         pushInfoUpdate();
/*     */       }
/*     */     }
/* 335 */     else if (synchBattleServer && this.master != null) {
/* 336 */       pushExpUpdate();
/*     */     } 
/*     */ 
/*     */     
/* 340 */     if (upgrade) {
/* 341 */       this.master.achievementManager.onGetPetLevel(this.po.id, this.po.level);
/*     */     }
/* 343 */     return upgrade ? 1 : 0;
/*     */   }
/*     */   
/*     */   public void pushInfoUpdate() {
/* 347 */     PetNewHandler.PetInfoUpdatePush.Builder data = PetNewHandler.PetInfoUpdatePush.newBuilder();
/* 348 */     data.setS2CPet(toJson4PayLoad());
/* 349 */     this.master.receive("area.petNewPush.petInfoUpdatePush", (GeneratedMessage)data.build());
/*     */   }
/*     */   
/*     */   public void pushExpUpdate() {
/* 353 */     PetNewHandler.PetExpUpdatePush.Builder data = PetNewHandler.PetExpUpdatePush.newBuilder();
/* 354 */     data.setS2CPetId(this.po.id);
/* 355 */     data.setS2CCurExp(this.po.exp);
/* 356 */     this.master.receive("area.petNewPush.petExpUpdatePush", (GeneratedMessage)data.build());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNextLevelneedExp() {
/* 366 */     if (!canAddExp()) {
/* 367 */       return 0L;
/*     */     }
/*     */     
/* 370 */     PetExpLevelCO prop = (PetExpLevelCO)GameData.PetExpLevels.get(Integer.valueOf(this.po.level));
/* 371 */     return prop.experience - this.po.exp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long[] getLevelByExp(long exp, int nowLevel, int curMaxLv) {
/* 381 */     int level = nowLevel;
/* 382 */     long curExp = exp;
/* 383 */     for (int i = nowLevel; i < curMaxLv; i++) {
/* 384 */       PetExpLevelCO prop = (PetExpLevelCO)GameData.PetExpLevels.get(Integer.valueOf(i));
/* 385 */       int needExp = prop.experience;
/* 386 */       if (curExp < needExp) {
/*     */         break;
/*     */       }
/* 389 */       curExp -= needExp;
/* 390 */       level++;
/* 391 */       if (level == ((PetConfigExt)GameData.PetConfigs.get("LevelLimit")).intValue) {
/* 392 */         curExp = 0L;
/*     */         break;
/*     */       } 
/* 395 */       if (level == curMaxLv) {
/* 396 */         PetExpLevelCO _prop = (PetExpLevelCO)GameData.PetExpLevels.get(Integer.valueOf(level));
/* 397 */         if (curExp > _prop.experience) {
/* 398 */           curExp = _prop.experience;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 403 */     return new long[] { curExp, level };
/*     */   }
/*     */   
/*     */   public String getBattlerServerPetData() {
/* 407 */     JSONObject json = new JSONObject();
/* 408 */     json.put("petBase", getBattlerServerPetBase());
/* 409 */     json.put("petEffect", getBattlerServerPetEffect());
/* 410 */     json.put("petSkill", getBattlerServerPetSkill());
/* 411 */     json.put("petMode", Integer.valueOf(getPkDataToBattleJson()));
/* 412 */     String str = json.toString();
/* 413 */     return str;
/*     */   }
/*     */   
/*     */   public int getPkDataToBattleJson() {
/* 417 */     MapBase sceneProp = AreaDataConfig.getInstance().get(this.master.getAreaId());
/* 418 */     if (sceneProp != null && 
/* 419 */       sceneProp.changePetAI == 0) {
/* 420 */       return sceneProp.petAI;
/*     */     }
/*     */     
/* 423 */     return PetManager.getPkModel();
/*     */   }
/*     */   
/*     */   public boolean upgrade(boolean synchBattleServer) {
/* 427 */     int oldLevel = this.po.level;
/* 428 */     long oldExp = this.po.exp;
/* 429 */     boolean flag_upgrade = false;
/* 430 */     long[] par = getLevelByExp(this.po.exp, this.po.level, getCurMaxLv());
/* 431 */     int curLevel = (int)par[1];
/* 432 */     if (this.po.level != curLevel)
/* 433 */       flag_upgrade = true; 
/* 434 */     this.po.exp = par[0];
/* 435 */     this.po.level = curLevel;
/*     */ 
/*     */     
/* 438 */     LogReportService.getInstance().ansycReportPetUpgrade(this.master, this.po.id, this.po.name, this.po.upLevel, this.po.level, this.po.exp);
/* 439 */     BILogService.getInstance().ansycReportPetCultivate(this.master.getPlayer(), oldLevel, this.po.level, oldExp, this.po.exp, this.po.id);
/*     */     
/* 441 */     initCurMaxLv();
/* 442 */     calAttr();
/* 443 */     calMasterAttr();
/* 444 */     if (synchBattleServer) {
/* 445 */       this.master.petNewManager.refreshMasterAttr();
/* 446 */       this.master.onPetPropChange();
/*     */     } 
/* 448 */     if (this.master.petNewManager.petsPO.fightPetId == this.po.id && synchBattleServer) {
/* 449 */       this.master.getXmdsManager().refreshPlayerPetDataChange(this.master.getId(), PetOperatorType.Reset.getValue(), getBattlerServerPetData());
/*     */     }
/* 451 */     return flag_upgrade;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgradeUplevel() {
/* 460 */     int nextUplvl = this.po.upLevel + 1;
/* 461 */     if (nextUplvl > ((PetConfigExt)GameData.PetConfigs.get("Upgrade.LevelLimit")).intValue) {
/* 462 */       return -1;
/*     */     }
/* 464 */     PetUpgradeExt prop_next = GameData.findPetUpgrades(t -> (t.petID == this.po.id && t.targetUpLevel == nextUplvl)).get(0);
/* 465 */     if (this.po.level < prop_next.reqLevel) {
/* 466 */       return -2;
/*     */     }
/* 468 */     String mateCode = prop_next.mateCode;
/* 469 */     int mateCount = prop_next.mateCount;
/* 470 */     if (!this.master.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.pet)) {
/* 471 */       return -3;
/*     */     }
/*     */     
/* 474 */     this.po.upLevel++;
/*     */     
/* 476 */     LogReportService.getInstance().ansycReportPetUpgrade(this.master, this.po.id, this.po.name, this.po.upLevel, this.po.level, this.po.exp);
/* 477 */     BILogService.getInstance().ansycReportPetCultivate(this.master.getPlayer(), this.po.upLevel, mateCode, mateCount, this.po.id);
/*     */ 
/*     */     
/* 480 */     boolean newSkill = false;
/* 481 */     int openSkillID = prop_next.openSkillID;
/* 482 */     if (openSkillID != 0) {
/* 483 */       PetSkill skill = (PetSkill)this.po.skills.get(Integer.valueOf(openSkillID));
/* 484 */       if (skill != null) {
/* 485 */         skill.level = 1;
/* 486 */         newSkill = true;
/*     */       } 
/*     */     } 
/* 489 */     initCurMaxLv();
/* 490 */     calAttr();
/* 491 */     calMasterAttr();
/* 492 */     this.master.petNewManager.refreshMasterAttr();
/* 493 */     this.master.onPetPropChange();
/* 494 */     if (this.master.petNewManager.petsPO.fightPetId == this.po.id) {
/* 495 */       this.master.getXmdsManager().refreshPlayerPetDataChange(this.master.getId(), PetOperatorType.Reset.getValue(), getBattlerServerPetData());
/*     */     }
/* 497 */     JSONArray arr = new JSONArray();
/* 498 */     List<Map<String, Integer>> list = getBattlerServerPetSkill();
/* 499 */     for (Map<String, Integer> map : list) {
/* 500 */       arr.add(map);
/*     */     }
/* 502 */     if (newSkill && this.master.petNewManager.petsPO.fightPetId == this.po.id) {
/* 503 */       this.master.getXmdsManager().refreshPlayerPetSkillChange(this.master.getId(), 0, arr.toJSONString());
/*     */     }
/*     */ 
/*     */     
/* 507 */     this.master.achievementManager.onPetUpGrade(0, this.po.upLevel);
/* 508 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean canAddExp() {
/* 512 */     return (this.po.level < getCurMaxLv());
/*     */   }
/*     */   
/*     */   public JSONObject getBattlerServerPetBase() {
/* 516 */     JSONObject data = new JSONObject();
/* 517 */     data.put("Model", this.prop.model);
/* 518 */     data.put("ModelPercent", Integer.valueOf(this.prop.modelPercent));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 527 */     data.put("ModelStar", "");
/* 528 */     data.put("ModelStarPercent", Integer.valueOf(0));
/* 529 */     data.put("ModelStarScenePercent", Integer.valueOf(0));
/*     */     
/* 531 */     data.put("name", this.po.name);
/* 532 */     data.put("level", Integer.valueOf(this.po.level));
/* 533 */     data.put("Qcolor", Integer.valueOf(this.prop.qcolor));
/* 534 */     data.put("templateId", Integer.valueOf(this.po.id));
/* 535 */     data.put("Icon", this.prop.icon);
/* 536 */     data.put("upGradeLevel", Integer.valueOf(this.po.upLevel));
/* 537 */     return data;
/*     */   }
/*     */   
/*     */   public JSONObject getBattlerServerPetEffect() {
/* 541 */     JSONObject data = new JSONObject();
/* 542 */     for (Const.PlayerBtlData pbd : this.attr_all_pet.keySet()) {
/* 543 */       data.put(pbd.name(), this.attr_all_pet.get(pbd));
/*     */     }
/* 545 */     data.put("MoveSpeed", Float.valueOf(this.prop.moveSpeed));
/*     */     
/* 547 */     data.put(Const.PlayerBtlData.MaxHP.name(), Integer.valueOf(999999999));
/* 548 */     data.put("HP", Integer.valueOf(999999999));
/*     */     
/* 550 */     return data;
/*     */   }
/*     */   
/*     */   public List<Map<String, Integer>> getBattlerServerPetSkill() {
/* 554 */     List<Map<String, Integer>> data = new ArrayList<>();
/* 555 */     for (PetSkill skill : this.po.skills.values()) {
/* 556 */       int type = (getPetSkillBySkillId(skill.id)).skillType;
/* 557 */       if ((type == Const.SkillType.BATTLE_PASSIVE.getValue() || type == Const.SkillType.ACTIVE.getValue() || type == Const.SkillType.NORMAL.getValue()) && 
/* 558 */         skill.level > 0) {
/* 559 */         Map<String, Integer> e = new HashMap<>();
/* 560 */         e.put("id", Integer.valueOf(skill.id));
/* 561 */         e.put("level", Integer.valueOf(skill.level));
/* 562 */         e.put("talentLevel", Integer.valueOf(skill.level));
/* 563 */         e.put("type", Integer.valueOf(type));
/* 564 */         e.put("skillTime", Integer.valueOf(0));
/* 565 */         data.add(e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 570 */     return data;
/*     */   }
/*     */   
/*     */   public static PetSkillExt getPetSkillBySkillId(int skillId) {
/* 574 */     return (PetSkillExt)GameData.PetSkills.get(Integer.valueOf(skillId));
/*     */   }
/*     */   
/*     */   private int getSkillsPower() {
/* 578 */     int power = 0;
/* 579 */     for (PetSkill skill : this.po.skills.values()) {
/* 580 */       PetSkillExt skillProp = (PetSkillExt)GameData.PetSkills.get(Integer.valueOf(skill.id));
/* 581 */       power += skillProp.getSkillPower(skill.level);
/*     */     } 
/* 583 */     return power;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Const.PlayerBtlData, Integer> getSkillAttr(int targetType) {
/* 593 */     Map<Const.PlayerBtlData, Integer> map = new HashMap<>();
/* 594 */     for (PetSkill ps : this.po.passiveSkills.values()) {
/* 595 */       PassiveSkillExt prop = (PassiveSkillExt)GameData.PassiveSkills.get(Integer.valueOf(ps.id));
/* 596 */       if (prop.skillType == 0 && prop.target == targetType) {
/*     */         
/* 598 */         if (prop.ValueAttribute1 != null) {
/* 599 */           int value = 0;
/* 600 */           if (prop.ValueSetMap1 != null && prop.ValueSetMap1.containsKey(Integer.valueOf(ps.level))) {
/* 601 */             value = ((Integer)prop.ValueSetMap1.get(Integer.valueOf(ps.level))).intValue();
/*     */           } else {
/* 603 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据" });
/*     */           } 
/* 605 */           map.put(prop.ValueAttribute1, Integer.valueOf(value));
/*     */         } 
/* 607 */         if (prop.ValueAttribute2 != null) {
/* 608 */           int value = 0;
/* 609 */           if (prop.ValueSetMap2 != null && prop.ValueSetMap2.containsKey(Integer.valueOf(ps.level))) {
/* 610 */             value = ((Integer)prop.ValueSetMap2.get(Integer.valueOf(ps.level))).intValue();
/*     */           } else {
/* 612 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据" });
/*     */           } 
/* 614 */           map.put(prop.ValueAttribute2, Integer.valueOf(value));
/*     */         } 
/* 616 */         if (prop.ValueAttribute3 != null) {
/* 617 */           int value = 0;
/* 618 */           if (prop.ValueSetMap3 != null && prop.ValueSetMap3.containsKey(Integer.valueOf(ps.level))) {
/* 619 */             value = ((Integer)prop.ValueSetMap3.get(Integer.valueOf(ps.level))).intValue();
/*     */           } else {
/* 621 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(ps.id), "对应等级无数据" });
/*     */           } 
/* 623 */           map.put(prop.ValueAttribute3, Integer.valueOf(value));
/*     */         } 
/*     */       } 
/*     */     } 
/* 627 */     return map;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\petNew\PetNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */