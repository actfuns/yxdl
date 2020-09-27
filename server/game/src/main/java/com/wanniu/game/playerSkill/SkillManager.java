/*     */ package com.wanniu.game.playerSkill;
/*     */ 
/*     */ import Xmds.SkillDataICE;
/*     */ import com.wanniu.core.common.StringInt;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.CharacterExt;
/*     */ import com.wanniu.game.data.ext.PassiveSkillExt;
/*     */ import com.wanniu.game.data.ext.SkillDataExt;
/*     */ import com.wanniu.game.data.ext.SkillValueExt;
/*     */ import com.wanniu.game.data.ext.TalentEffectExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.playerSkill.po.SkillDB;
/*     */ import com.wanniu.game.poes.SkillsPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.PlayerHandler;
/*     */ import pomelo.area.SkillHandler;
/*     */ import pomelo.area.SkillKeysHandler;
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
/*     */ public class SkillManager
/*     */   extends ModuleManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public SkillsPO player_skills;
/*  48 */   private static SkillComparator comparator = new SkillComparator();
/*  49 */   private static SkillLevelComparator comparator_lv = new SkillLevelComparator();
/*     */   public Map<Const.PlayerBtlData, Integer> data_skill_attr;
/*     */   
/*     */   public SkillManager(WNPlayer player, SkillsPO skills) {
/*  53 */     this.player = player;
/*  54 */     this.player_skills = skills;
/*  55 */     refreshPassiveSkillData();
/*     */   }
/*     */ 
/*     */   
/*     */   public static SkillsPO initNewPlayerSkills(int pro, int initLevel) {
/*  60 */     CharacterExt prop = GameData.findCharacters(t -> (t.pro == pro)).get(0);
/*  61 */     List<CharacterExt.InitSkill> initSkills = prop.initSkills;
/*  62 */     Map<Integer, SkillDB> skills_list = new HashMap<>();
/*  63 */     int openCount = 0;
/*  64 */     for (int i = 0; i < initSkills.size(); i++) {
/*  65 */       CharacterExt.InitSkill cfg = initSkills.get(i);
/*  66 */       SkillDB skill = new SkillDB(cfg.level, cfg.id, 0, 0, 0, i);
/*  67 */       SkillDataExt scf = (SkillDataExt)GameData.SkillDatas.get(Integer.valueOf(cfg.id));
/*  68 */       int needLvl = ((Integer)scf.lvReqData.get(0)).intValue();
/*  69 */       if (initLevel >= needLvl) {
/*  70 */         skill.flag = 1;
/*  71 */         openCount++;
/*     */       } 
/*  73 */       skills_list.put(Integer.valueOf(cfg.id), skill);
/*     */     } 
/*     */     
/*  76 */     SkillsPO player_skills = new SkillsPO();
/*  77 */     player_skills.skills = skills_list;
/*  78 */     player_skills.openCount = openCount;
/*  79 */     player_skills.talentSkills = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     return player_skills;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerUpgrade() {
/*  95 */     List<SkillDataExt> props = GameData.findSkillDatas(t -> (t.pro_ == this.player.player.pro && t.learnSkill == 1 && t.lvReqData.size() > 0 && ((Integer)t.lvReqData.get(0)).intValue() <= this.player.baseDataManager.baseData.level));
/*     */     
/*  97 */     List<Integer> list = new ArrayList<>();
/*  98 */     for (SkillDataExt prop : props) {
/*  99 */       SkillDB skill = getSkill(prop.skillID);
/* 100 */       if (skill != null && 
/* 101 */         skill.flag != 1) {
/* 102 */         skill.flag = 1;
/* 103 */         skill.lv = 1;
/* 104 */         list.add(Integer.valueOf(prop.skillID));
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     if (list.size() > 0) {
/* 109 */       this.player.refreshBattlerServerSkill(Const.SkillHandleType.ADD.getValue(), list);
/* 110 */       WNNotifyManager.getInstance().pushSkillUpdate(this.player, list);
/* 111 */       WNNotifyManager.getInstance().pushSkillKeysUpdate(this.player, this.player.skillKeyManager.toJson4Payload());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillDB getSkill(int skillId) {
/* 117 */     return (SkillDB)this.player_skills.skills.get(Integer.valueOf(skillId));
/*     */   }
/*     */   
/*     */   public void upgradeSkill(SkillDB skill) {
/* 121 */     int skill_next_lv = skill.lv + 1;
/* 122 */     SkillDataExt prop = (SkillDataExt)GameData.SkillDatas.get(Integer.valueOf(skill.id));
/* 123 */     int cost = 0;
/* 124 */     if (prop.costReqData.containsKey(Integer.valueOf(skill_next_lv)))
/* 125 */       cost = ((Integer)prop.costReqData.get(Integer.valueOf(skill_next_lv))).intValue(); 
/* 126 */     this.player.moneyManager.costGold(cost, Const.GOODS_CHANGE_TYPE.skill);
/* 127 */     skill.lv = skill_next_lv;
/* 128 */     Out.info(new Object[] { "技能升级 playerId=", this.player.getId(), ",skillId=", Integer.valueOf(skill.id), ",level=", Integer.valueOf(skill_next_lv) });
/*     */     
/* 130 */     this.player.achievementManager.onSkillLevelChange(skill.lv);
/*     */     
/* 132 */     BILogService.getInstance().ansycReportSkillUpgrade(this.player.getPlayer(), skill.id, prop.skillName, skill.lv);
/*     */   }
/*     */   
/*     */   public boolean upgradeOneSkill(int skillId) {
/* 136 */     SkillDB skill = getSkill(skillId);
/* 137 */     CheckSkillData result = checkSkillReq(skill);
/* 138 */     if (result.result == 0) {
/* 139 */       upgradeSkill(skill);
/*     */     }
/*     */     
/* 142 */     List<Integer> list = new ArrayList<>();
/* 143 */     list.add(Integer.valueOf(skillId));
/* 144 */     WNNotifyManager.getInstance().pushSkillUpdate(this.player, list);
/* 145 */     this.player.refreshBattlerServerSkill(Const.SkillHandleType.CHANGE.getValue(), list);
/* 146 */     this.player.onPlayerSkillUpgrade();
/* 147 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sortAndUpgrade(Map<Integer, Object> map, int deep) {
/* 157 */     if (--deep < 0) {
/* 158 */       Out.error(new Object[] { "sortAndUpgrade 死锁", map });
/*     */       
/*     */       return;
/*     */     } 
/* 162 */     List<SkillDB> list = new ArrayList<>();
/*     */     
/* 164 */     for (SkillDB skillDB : this.player_skills.skills.values()) {
/* 165 */       if ((checkSkillReq(skillDB)).result == 0)
/* 166 */         list.add(skillDB); 
/*     */     } 
/* 168 */     if (list.size() < 1)
/*     */       return; 
/* 170 */     list.sort(comparator_lv);
/* 171 */     SkillDB skill = list.get(0);
/* 172 */     upgradeSkill(skill);
/* 173 */     map.put(Integer.valueOf(skill.id), null);
/* 174 */     sortAndUpgrade(map, deep);
/*     */   }
/*     */   
/*     */   public SkillDB getSkillByPos(int pos) {
/* 178 */     for (SkillDB skill : this.player_skills.skills.values()) {
/* 179 */       if (skill.pos == pos)
/* 180 */         return skill; 
/*     */     } 
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int changeSkillsPos(SkillKeysHandler.SaveSkillKeysRequest req) {
/* 193 */     List<SkillKeysHandler.SkillKey> list = req.getS2CSkillKeysList();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     for (SkillKeysHandler.SkillKey sk : list) {
/* 199 */       int skillId = sk.getSkillId();
/* 200 */       int pos = sk.getKeyPos();
/* 201 */       if (skillId == 0) {
/* 202 */         SkillDB skillDB = getSkillByPos(pos);
/* 203 */         if (skillDB != null && 
/* 204 */           skillDB.pos == 0)
/* 205 */           return -3;  continue;
/*     */       } 
/* 207 */       SkillDB skill = getSkill(skillId);
/* 208 */       if (skill == null) {
/* 209 */         return -4;
/*     */       }
/* 211 */       if (sk.getKeyPos() > 5 || sk.getKeyPos() == 0) {
/* 212 */         return -3;
/*     */       }
/*     */       
/* 215 */       int flag_pos = 0, flag_skillId = 0;
/* 216 */       for (SkillKeysHandler.SkillKey _sk : list) {
/* 217 */         if (_sk.getKeyPos() == sk.getKeyPos())
/* 218 */           flag_pos++; 
/* 219 */         if (_sk.getSkillId() == skillId)
/* 220 */           flag_skillId++; 
/*     */       } 
/* 222 */       if (flag_pos > 1 || flag_skillId > 1) {
/* 223 */         return -1;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 229 */     for (SkillKeysHandler.SkillKey sk : list) {
/* 230 */       int skillId = sk.getSkillId();
/* 231 */       int pos = sk.getKeyPos();
/* 232 */       if (skillId == 0) {
/* 233 */         SkillDB skillDB = getSkillByPos(pos);
/* 234 */         if (skillDB != null)
/* 235 */           skillDB.pos = 0;  continue;
/*     */       } 
/* 237 */       SkillDB skill = getSkill(sk.getSkillId());
/* 238 */       skill.pos = sk.getKeyPos();
/*     */     } 
/*     */ 
/*     */     
/* 242 */     return 0;
/*     */   }
/*     */   
/*     */   public final List<SkillInfo> toJson4BattleServer() {
/* 246 */     List<SkillInfo> skills = new ArrayList<>();
/*     */     
/* 248 */     for (SkillDB skill : this.player_skills.skills.values()) {
/* 249 */       if (skill.flag == 1) {
/* 250 */         SkillInfo data = new SkillInfo();
/* 251 */         SkillDataExt prop = getProp(skill.id);
/* 252 */         data.type = prop.skillType;
/* 253 */         data.id = skill.id;
/* 254 */         data.level = skill.lv;
/*     */         
/* 256 */         data.talentLevel = 1;
/* 257 */         data.skillTime = skill.skillTime;
/* 258 */         data.cdTime = 0;
/* 259 */         skills.add(data);
/*     */       } 
/*     */     } 
/* 262 */     return skills;
/*     */   }
/*     */   
/*     */   public static SkillDataExt getProp(int skillId) {
/* 266 */     return (SkillDataExt)GameData.SkillDatas.get(Integer.valueOf(skillId));
/*     */   }
/*     */   
/*     */   public final void syncBattleSkillTime(List<SkillDataICE> skillTimeArray) {
/* 270 */     for (SkillDataICE skillTimeData : skillTimeArray) {
/* 271 */       SkillDB skill = getSkill(skillTimeData.skillId);
/* 272 */       if (skill != null) {
/* 273 */         skill.skillTime = skillTimeData.skillTime; continue;
/*     */       } 
/* 275 */       Out.debug(new Object[] { "syncBattleSkillTime error-- id is: ", Integer.valueOf(skillTimeData.skillId) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void onLevelChange() {
/* 285 */     updateSuperScript();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSuperScript() {}
/*     */ 
/*     */   
/*     */   public final SkillHandler.GetAllSkillResponse.Builder toJson4Payload() {
/* 294 */     SkillHandler.GetAllSkillResponse.Builder result = SkillHandler.GetAllSkillResponse.newBuilder();
/* 295 */     ArrayList<SkillHandler.SkillBasic> data = new ArrayList<>();
/* 296 */     result.setHubLock(false);
/* 297 */     for (SkillDB skill : this.player_skills.skills.values()) {
/* 298 */       data.add(toJSON4BasicPayload(skill, false));
/*     */     }
/* 300 */     data.sort(comparator);
/* 301 */     result.addAllSkillList(data);
/* 302 */     return result;
/*     */   }
/*     */   
/*     */   public final ArrayList<SkillHandler.SkillBasic> getSkillsBasicList() {
/* 306 */     ArrayList<SkillHandler.SkillBasic> data = new ArrayList<>();
/* 307 */     for (SkillDB skill : this.player_skills.skills.values()) {
/* 308 */       data.add(toJSON4BasicPayload(skill, false));
/*     */     }
/* 310 */     data.sort(comparator);
/* 311 */     return data;
/*     */   }
/*     */   
/*     */   public final SkillHandler.SkillBasic getSkillBasicUpdate4PayLoad(int skillId) {
/* 315 */     SkillDB skill = getSkill(skillId);
/* 316 */     SkillHandler.SkillBasic basicJson = null;
/* 317 */     basicJson = toJSON4BasicPayload(skill, true);
/* 318 */     return basicJson;
/*     */   }
/*     */   
/*     */   public final SkillHandler.SkillBasic toJSON4BasicPayload(SkillDB skill, boolean isRefresh) {
/* 322 */     SkillHandler.SkillBasic.Builder data = SkillHandler.SkillBasic.newBuilder();
/* 323 */     SkillDataExt prop = SkillUtil.getProp(skill.id);
/* 324 */     data.setPos(prop.skillIndex);
/* 325 */     data.setLevel(skill.lv);
/* 326 */     data.setExtlv(skill.extLv);
/* 327 */     data.setFlag(skill.flag);
/* 328 */     data.setSkillId(skill.id);
/* 329 */     data.setName(prop.skillName);
/* 330 */     data.setPic(prop.skillIcon);
/* 331 */     if (prop.skillType == Const.SkillType.EFFECT_PASSIVE.getValue()) {
/* 332 */       data.setType(Const.SkillType.BATTLE_PASSIVE.getValue());
/*     */     } else {
/* 334 */       data.setType(prop.skillType);
/*     */     } 
/* 336 */     data.setMaxLevel(prop.maxLevel);
/* 337 */     int nextLevel = 0;
/* 338 */     if (skill.lv < prop.lvReqData.size()) {
/* 339 */       nextLevel = ((Integer)prop.lvReqData.get(skill.lv)).intValue();
/*     */     }
/* 341 */     data.setUpgradeNeedLevel(nextLevel);
/* 342 */     data.setDetailNeedRefresh(!!isRefresh);
/*     */     
/* 344 */     ArrayList<Integer> superScripts = new ArrayList<>();
/* 345 */     int isCanUp = 0;
/* 346 */     int isEnSkill1CanUp = 0;
/* 347 */     int isEnSkill2CanUp = 0;
/*     */     
/* 349 */     CheckSkillData result = checkSkillReq(skill);
/* 350 */     isCanUp = (result.result == 0) ? 1 : 0;
/* 351 */     superScripts.add(Integer.valueOf(isCanUp));
/* 352 */     superScripts.add(Integer.valueOf(isEnSkill1CanUp));
/* 353 */     superScripts.add(Integer.valueOf(isEnSkill2CanUp));
/*     */     
/* 355 */     int nextReqCost = 0;
/* 356 */     if (prop.costReqData.containsKey(Integer.valueOf(skill.lv + 1)))
/* 357 */       nextReqCost = ((Integer)prop.costReqData.get(Integer.valueOf(skill.lv + 1))).intValue(); 
/* 358 */     data.setCost(nextReqCost);
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
/* 370 */     data.addAllCanUpgrade(superScripts);
/* 371 */     return data.build();
/*     */   }
/*     */   
/*     */   public final SkillHandler.SkillDetail getSkillDetail4PayLoad(int skillId) {
/* 375 */     SkillDB skill = getSkill(skillId);
/* 376 */     if (skill == null)
/* 377 */       return null; 
/* 378 */     SkillDataExt prop = SkillUtil.getProp(skillId);
/* 379 */     SkillHandler.SkillDetail.Builder data = SkillHandler.SkillDetail.newBuilder();
/* 380 */     SkillValueExt exProp = (SkillValueExt)GameData.SkillValues.get(Integer.valueOf(skillId));
/* 381 */     data.setColddown(exProp.cDTime);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 390 */     data.setCurManaCost(0);
/*     */ 
/*     */     
/* 393 */     ArrayList<String> curDesData = SkillUtil.getDesData(skillId, getUpCorrectLevel(skill) + skill.extLv);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     data.addAllCurDesData(curDesData);
/* 400 */     int nextReqCost = 0;
/* 401 */     if (prop.costReqData.containsKey(Integer.valueOf(skill.lv + 1)))
/* 402 */       nextReqCost = ((Integer)prop.costReqData.get(Integer.valueOf(skill.lv + 1))).intValue(); 
/* 403 */     ArrayList<SkillHandler.ReqItem> items = new ArrayList<>();
/*     */     
/* 405 */     String iCode = "gold";
/* 406 */     DItemEquipBase itemData = ItemUtil.getPropByCode(iCode);
/* 407 */     int curItemNum = (this.player.getPlayer()).gold;
/* 408 */     int iNum = nextReqCost;
/*     */     
/* 410 */     if (itemData != null) {
/* 411 */       SkillHandler.ReqItem.Builder item = SkillHandler.ReqItem.newBuilder();
/* 412 */       item.setItemCode(iCode);
/* 413 */       item.setItemQua(itemData.qcolor);
/* 414 */       item.setItemIcon(itemData.icon);
/* 415 */       item.setItemReqNum(iNum);
/* 416 */       item.setItemCurNum(curItemNum);
/* 417 */       items.add(item.build());
/*     */     } 
/* 419 */     data.addAllReqItems(items);
/*     */     
/* 421 */     ArrayList<SkillHandler.TalentDetail> TalentList = new ArrayList<>();
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
/* 434 */     data.addAllTalentList(TalentList);
/*     */ 
/*     */     
/* 437 */     int canUpgrade = 0;
/* 438 */     data.setCanUpgrade(canUpgrade);
/* 439 */     return data.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public final CheckSkillData checkSkillReq(SkillDB skill) {
/* 444 */     int curLv = skill.lv;
/* 445 */     SkillDataExt prop = SkillUtil.getProp(skill.id);
/*     */ 
/*     */     
/* 448 */     if (curLv >= prop.maxLevel) {
/* 449 */       CheckSkillData checkSkillData = new CheckSkillData(-1);
/* 450 */       return checkSkillData;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     int reqPlayerLevel = 0;
/* 462 */     if (curLv >= prop.lvReqData.size()) {
/* 463 */       reqPlayerLevel = 0;
/*     */     } else {
/* 465 */       reqPlayerLevel = ((Integer)prop.lvReqData.get(curLv)).intValue();
/*     */     } 
/* 467 */     if (reqPlayerLevel > this.player.getLevel()) {
/* 468 */       CheckSkillData checkSkillData = new CheckSkillData(-2);
/* 469 */       return checkSkillData;
/*     */     } 
/*     */ 
/*     */     
/* 473 */     int reqCost = 0;
/* 474 */     if (prop.costReqData.containsKey(Integer.valueOf(curLv + 1))) {
/* 475 */       reqCost = ((Integer)prop.costReqData.get(Integer.valueOf(curLv + 1))).intValue();
/*     */     }
/* 477 */     if (!this.player.moneyManager.enoughGold(reqCost)) {
/* 478 */       CheckSkillData checkSkillData = new CheckSkillData(-3);
/* 479 */       return checkSkillData;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 489 */     StringInt item = null;
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
/* 506 */     CheckSkillData data = new CheckSkillData(0);
/* 507 */     data.reqCost = reqCost;
/* 508 */     data.reqCostItem = item;
/* 509 */     return data;
/*     */   }
/*     */   
/*     */   public final int getUpCorrectLevel(SkillDB skill) {
/* 513 */     return (skill.lv <= 0) ? 1 : skill.lv;
/*     */   }
/*     */   
/*     */   private static class SkillComparator implements Comparator<SkillHandler.SkillBasic> {
/*     */     private SkillComparator() {}
/*     */     
/*     */     public int compare(SkillHandler.SkillBasic skillA, SkillHandler.SkillBasic skillB) {
/* 520 */       return skillA.getPos() - skillB.getPos();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SkillLevelComparator implements Comparator<SkillDB> {
/*     */     private SkillLevelComparator() {}
/*     */     
/*     */     public int compare(SkillDB skillA, SkillDB skillB) {
/* 528 */       return skillA.lv - skillB.lv;
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
/*     */   
/*     */   public final List<SkillInfo> toJson4UpdateBattleServer(int type, List<Integer> skillIds) {
/* 541 */     if (skillIds == null || skillIds.size() <= 0) {
/* 542 */       return null;
/*     */     }
/* 544 */     ArrayList<SkillInfo> skills = new ArrayList<>();
/* 545 */     for (Iterator<Integer> iterator = skillIds.iterator(); iterator.hasNext(); ) { int skillId = ((Integer)iterator.next()).intValue();
/* 546 */       SkillDB skill = getSkill(skillId);
/* 547 */       if (skill != null && skill.flag == 1) {
/* 548 */         SkillInfo skilldata = _getBattlerServerSkillData(type, skill);
/* 549 */         Out.debug(new Object[] { "toJson4UpdateBattleServer _getBattlerServerSkillData: ", Integer.valueOf(skill.id), "--", skilldata });
/* 550 */         if (skilldata != null) {
/* 551 */           skills.add(skilldata);
/*     */         }
/*     */       }  }
/*     */     
/* 555 */     return skills;
/*     */   }
/*     */   
/*     */   private final SkillInfo _getBattlerServerSkillData(int type, SkillDB skill) {
/* 559 */     SkillDataExt prop = SkillUtil.getProp(skill.id);
/* 560 */     if (type == Const.SkillHandleType.DELETE.getValue()) {
/* 561 */       SkillInfo skillInfo = new SkillInfo();
/* 562 */       skillInfo.id = skill.id;
/* 563 */       skillInfo.level = skill.lv;
/* 564 */       skillInfo.talentLevel = skill.lv;
/* 565 */       skillInfo.type = prop.skillType;
/* 566 */       skillInfo.skillTime = skill.skillTime;
/*     */       
/* 568 */       skillInfo.cdTime = 0;
/* 569 */       return skillInfo;
/*     */     } 
/* 571 */     SkillInfo info = new SkillInfo();
/* 572 */     if (prop.skillType == Const.SkillType.ACTIVE.getValue()) {
/*     */       
/* 574 */       int skillLv = skill.lv;
/* 575 */       int skillType = prop.skillType;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 580 */       boolean isMeetWeapon = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 589 */       if (!isMeetWeapon)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 597 */         info.id = skill.id;
/* 598 */         info.level = skillLv;
/* 599 */         info.talentLevel = skillLv;
/* 600 */         info.type = skillType;
/* 601 */         info.skillTime = skill.skillTime;
/*     */         
/* 603 */         info.cdTime = 0;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 616 */       return null;
/*     */     } 
/* 618 */     return info;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 623 */     switch (eventType) {
/*     */       case UPGRADE:
/* 625 */         onPlayerUpgrade();
/*     */         break;
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
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 638 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 639 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 640 */     data.setType(Const.SUPERSCRIPT_TYPE.SKILL.getValue());
/* 641 */     data.setNumber(0);
/* 642 */     for (SkillDB skill : this.player_skills.skills.values()) {
/*     */       
/* 644 */       if ((checkSkillReq(skill)).result == 0) {
/* 645 */         data.setNumber(1);
/*     */         break;
/*     */       } 
/*     */     } 
/* 649 */     list.add(data.build());
/* 650 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 655 */     return Const.ManagerType.SKILL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpgradeSkill(SkillDB skill) {
/* 665 */     int curLv = skill.lv;
/* 666 */     SkillDataExt prop = SkillUtil.getProp(skill.id);
/*     */ 
/*     */     
/* 669 */     if (curLv >= prop.maxLevel) {
/* 670 */       return false;
/*     */     }
/* 672 */     int reqPlayerLevel = 0;
/* 673 */     if (curLv >= prop.lvReqData.size()) {
/* 674 */       reqPlayerLevel = 0;
/*     */     } else {
/* 676 */       reqPlayerLevel = ((Integer)prop.lvReqData.get(curLv)).intValue();
/*     */     } 
/* 678 */     if (reqPlayerLevel > this.player.getLevel()) {
/* 679 */       return false;
/*     */     }
/* 681 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgradeSkillOneKey2() {
/* 691 */     boolean flag = false;
/* 692 */     for (SkillDB skill : this.player_skills.skills.values()) {
/* 693 */       if (canUpgradeSkill(skill)) {
/* 694 */         flag = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 698 */     if (!flag) {
/* 699 */       return -1;
/*     */     }
/* 701 */     Map<Integer, Object> map = new HashMap<>();
/* 702 */     sortAndUpgrade(map, 150);
/* 703 */     List<Integer> list_id = new ArrayList<>();
/* 704 */     for (Integer id : map.keySet()) {
/* 705 */       list_id.add(id);
/*     */     }
/* 707 */     if (list_id.size() > 0) {
/* 708 */       WNNotifyManager.getInstance().pushSkillUpdate(this.player, list_id);
/* 709 */       this.player.refreshBattlerServerSkill(Const.SkillHandleType.CHANGE.getValue(), list_id);
/* 710 */       this.player.onPlayerSkillUpgrade();
/* 711 */       this.player.pushDynamicData("gold", Integer.valueOf(this.player.player.gold));
/* 712 */       return 0;
/*     */     } 
/* 714 */     return -2;
/*     */   }
/*     */   
/*     */   public static class CheckSkillData {
/*     */     public int result;
/*     */     public int reqCost;
/*     */     public StringInt reqCostItem;
/*     */     public int reqSpCost;
/*     */     
/*     */     public CheckSkillData(int result) {
/* 724 */       this.result = result;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SkillInfo {
/*     */     public int id;
/*     */     public int level;
/*     */     public int talentLevel;
/*     */     public int type;
/*     */     public long skillTime;
/*     */     public int cdTime;
/*     */     public int flag;
/*     */   }
/*     */   
/*     */   public int getSkillsPower() {
/* 739 */     int power = 0;
/* 740 */     for (SkillDB skill : this.player_skills.skills.values()) {
/*     */       
/* 742 */       SkillDataExt skillData = SkillUtil.getProp(skill.id);
/* 743 */       power = skillData.getSkillPower(skill.lv) + power;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 750 */     return power;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshPassiveSkillData() {
/* 757 */     this.data_skill_attr = new ConcurrentHashMap<>();
/* 758 */     Map<Integer, SkillDB> map = this.player_skills.talentSkills;
/* 759 */     if (map == null)
/*     */       return; 
/* 761 */     for (SkillDB s : map.values()) {
/* 762 */       PassiveSkillExt prop = (PassiveSkillExt)GameData.PassiveSkills.get(Integer.valueOf(s.id));
/* 763 */       if (prop.skillType == 0) {
/*     */         
/* 765 */         if (prop.ValueAttribute1 != null) {
/* 766 */           int value = 0;
/* 767 */           if (prop.ValueSetMap1 != null && prop.ValueSetMap1.containsKey(Integer.valueOf(s.lv))) {
/* 768 */             value = ((Integer)prop.ValueSetMap1.get(Integer.valueOf(s.lv))).intValue();
/*     */           } else {
/* 770 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据" });
/*     */           } 
/* 772 */           this.data_skill_attr.put(prop.ValueAttribute1, Integer.valueOf(value));
/*     */         } 
/* 774 */         if (prop.ValueAttribute2 != null) {
/* 775 */           int value = 0;
/* 776 */           if (prop.ValueSetMap2 != null && prop.ValueSetMap2.containsKey(Integer.valueOf(s.lv))) {
/* 777 */             value = ((Integer)prop.ValueSetMap2.get(Integer.valueOf(s.lv))).intValue();
/*     */           } else {
/* 779 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据" });
/*     */           } 
/* 781 */           this.data_skill_attr.put(prop.ValueAttribute2, Integer.valueOf(value));
/*     */         } 
/* 783 */         if (prop.ValueAttribute3 != null) {
/* 784 */           int value = 0;
/* 785 */           if (prop.ValueSetMap3 != null && prop.ValueSetMap3.containsKey(Integer.valueOf(s.lv))) {
/* 786 */             value = ((Integer)prop.ValueSetMap3.get(Integer.valueOf(s.lv))).intValue();
/*     */           } else {
/* 788 */             Out.error(new Object[] { "麻痹啊，天赋技能", Integer.valueOf(s.id), "对应等级无数据" });
/*     */           } 
/* 790 */           this.data_skill_attr.put(prop.ValueAttribute3, Integer.valueOf(value));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTalentPoint(int value) {
/* 797 */     this.player_skills.talentPoint += value;
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
/*     */   private void addNewTalentSkill(TalentEffectExt prop) {
/* 841 */     if (prop.talentType == 0) {
/* 842 */       refreshPassiveSkillData();
/* 843 */       this.player.onTalentPassiveSkillUpgrade();
/* 844 */     } else if (prop.talentType != 1) {
/*     */ 
/*     */       
/* 847 */       if (prop.talentType == 2) {
/* 848 */         SkillDB s = (SkillDB)this.player_skills.skills.get(Integer.valueOf(prop.beforeSkill));
/* 849 */         if (s != null) {
/* 850 */           int replaceSkillId = prop.getReplaceSkillId(1);
/* 851 */           if (replaceSkillId != 0)
/* 852 */             s.replaceSkillId = replaceSkillId; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\playerSkill\SkillManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */