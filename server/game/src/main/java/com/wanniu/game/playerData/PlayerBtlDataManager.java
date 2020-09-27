/*     */ package com.wanniu.game.playerData;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.daoyou.DaoYouCenter;
/*     */ import com.wanniu.game.daoyou.DaoYouService;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.CharacterExt;
/*     */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DaoYouPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.Common;
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
/*     */ public class PlayerBtlDataManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private static final int Tenthousand = 10000;
/*  41 */   public Map<Const.PlayerBtlData, Integer> data_pro_lvl = new ConcurrentHashMap<>();
/*     */   
/*  43 */   public Map<Const.PlayerBtlData, Integer> data_class = new ConcurrentHashMap<>();
/*     */   
/*  45 */   public Map<String, Integer> data_equip = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  48 */   public Map<Const.PlayerBtlData, Integer> data_fashion = new ConcurrentHashMap<>();
/*     */   
/*  50 */   public Map<Const.PlayerBtlData, Integer> data_mount = new ConcurrentHashMap<>();
/*     */   
/*  52 */   public Map<Const.PlayerBtlData, Integer> data_dao_you = new ConcurrentHashMap<>();
/*     */   
/*  54 */   public Map<Const.PlayerBtlData, Integer> data_guild_bless = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  57 */   public Map<Const.PlayerBtlData, Integer> data_holy_armour = new ConcurrentHashMap<>();
/*     */   
/*  59 */   public Map<Const.PlayerBtlData, Integer> data_exchange_property = new ConcurrentHashMap<>();
/*     */   
/*  61 */   public Map<Const.PlayerBtlData, Integer> data_blood = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public Map<Const.PlayerBtlData, Integer> allInflus = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public Map<Const.PlayerBtlData, Integer> finalInflus = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public Map<Const.PlayerBtlData, Integer> fightPowerInflus = new HashMap<>();
/*     */   
/*     */   private WNPlayer player;
/*     */   
/*     */   public PlayerBtlDataManager(WNPlayer player) {
/*  81 */     this.player = player;
/*  82 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  87 */     calProLvlData();
/*  88 */     calClassData();
/*     */     
/*  90 */     this.data_mount = this.player.mountManager.data_mount_final;
/*  91 */     calDaoYouData();
/*  92 */     this.data_equip = this.player.equipManager.calAllInfluence();
/*  93 */     this.data_fashion = this.player.fashionManager.calAllInfluence();
/*  94 */     this.data_holy_armour = this.player.achievementManager.calAllInfluence();
/*  95 */     this.data_blood = this.player.bloodManager.calAllInfluence();
/*  96 */     resetCalExchangeProparty();
/*     */ 
/*     */     
/*  99 */     calFinalData();
/*     */   }
/*     */   
/*     */   public void resetCalExchangeProparty() {
/* 103 */     int count = (this.player.getPlayer()).exchangCount;
/* 104 */     if (count > 0) {
/* 105 */       Map<Const.PlayerBtlData, Integer> exchange_property = new ConcurrentHashMap<>();
/* 106 */       exchange_property.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(GlobalConfig.Exchange_AddBlood * count));
/* 107 */       exchange_property.put(Const.PlayerBtlData.Phy, Integer.valueOf(GlobalConfig.Exchange_AddPhyAttack * count));
/* 108 */       exchange_property.put(Const.PlayerBtlData.Ac, Integer.valueOf(GlobalConfig.Exchange_AddPhyDefense * count));
/* 109 */       exchange_property.put(Const.PlayerBtlData.Mag, Integer.valueOf(GlobalConfig.Exchange_AddMagAttack * count));
/* 110 */       exchange_property.put(Const.PlayerBtlData.Resist, Integer.valueOf(GlobalConfig.Exchange_AddMagDefense * count));
/* 111 */       this.data_exchange_property = exchange_property;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calClassData() {
/* 116 */     if (this.player.player.upOrder == 0) {
/* 117 */       this.data_class = new HashMap<>();
/*     */     } else {
/* 119 */       UpLevelExpExt prop = GameData.findUpLevelExps(t -> (t.upOrder == this.player.player.upOrder)).get(0);
/* 120 */       this.data_class = prop.attrs;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void onEquipChange() {
/* 126 */     calFinalData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void calModuleData() {
/* 132 */     this.allInflus.clear();
/* 133 */     this.finalInflus.clear();
/* 134 */     AttributeUtil.addData2AllData(this.data_pro_lvl, this.allInflus);
/* 135 */     AttributeUtil.addData2AllData(this.data_class, this.allInflus);
/*     */     
/* 137 */     AttributeUtil.addData2AllDataByKey(this.data_equip, this.allInflus);
/*     */ 
/*     */     
/* 140 */     AttributeUtil.addData2AllData(this.data_fashion, this.allInflus);
/* 141 */     AttributeUtil.addData2AllData(this.data_blood, this.allInflus);
/*     */     
/* 143 */     AttributeUtil.addData2AllData(this.player.skillManager.data_skill_attr, this.allInflus);
/* 144 */     AttributeUtil.addData2AllData(this.data_mount, this.allInflus);
/* 145 */     AttributeUtil.addData2AllData(this.player.petNewManager.masterAttr, this.allInflus);
/* 146 */     AttributeUtil.addData2AllData(this.player.petNewManager.masterAttrOnOutFight, this.allInflus);
/*     */     
/* 148 */     AttributeUtil.addData2AllData(this.data_dao_you, this.allInflus);
/* 149 */     AttributeUtil.addData2AllData(this.data_holy_armour, this.allInflus);
/*     */     
/* 151 */     AttributeUtil.addData2AllData(this.data_exchange_property, this.allInflus);
/*     */ 
/*     */     
/* 154 */     AttributeUtil.addData2AllDataByKey(this.player.guildManager.guildTechManager.calAllInfluence(), this.allInflus);
/*     */     
/* 156 */     AttributeUtil.addData2AllDataByKey(this.player.titleManager.calAllInfluence(), this.allInflus);
/*     */ 
/*     */     
/* 159 */     if (this.player.allBlobData.robotAttr != null) {
/* 160 */       AttributeUtil.addData2AllData(this.player.allBlobData.robotAttr, this.allInflus);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calBuffData() {
/* 169 */     this.fightPowerInflus = new HashMap<>(this.allInflus);
/*     */     
/* 171 */     AttributeUtil.addData2AllDataByKey(this.player.guildManager.calAllInfluence(), this.allInflus);
/*     */     
/* 173 */     AttributeUtil.addData2AllDataByKey(this.player.guildBossManager.calAllInfluence(), this.allInflus);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void calFinalData(int oldMaxHp, int oldPhy, int oldMag) {
/* 179 */     int baseValue = 0;
/* 180 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Phy)) {
/* 181 */       baseValue = ((Integer)this.allInflus.get(Const.PlayerBtlData.Phy)).intValue();
/*     */     }
/* 183 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Attack)) {
/* 184 */       baseValue += ((Integer)this.allInflus.get(Const.PlayerBtlData.Attack)).intValue();
/*     */     }
/* 186 */     this.allInflus.put(Const.PlayerBtlData.Phy, Integer.valueOf(baseValue));
/* 187 */     int basePer = 0;
/* 188 */     if (this.allInflus.containsKey(Const.PlayerBtlData.PhyPer)) {
/* 189 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.PhyPer)).intValue();
/*     */     }
/* 191 */     if (this.allInflus.containsKey(Const.PlayerBtlData.AttackPer)) {
/* 192 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.AttackPer)).intValue();
/*     */     }
/* 194 */     this.allInflus.put(Const.PlayerBtlData.PhyPer, Integer.valueOf(basePer));
/*     */     
/* 196 */     baseValue = 0;
/* 197 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Mag)) {
/* 198 */       baseValue = ((Integer)this.allInflus.get(Const.PlayerBtlData.Mag)).intValue();
/*     */     }
/* 200 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Attack)) {
/* 201 */       baseValue += ((Integer)this.allInflus.get(Const.PlayerBtlData.Attack)).intValue();
/*     */     }
/* 203 */     this.allInflus.put(Const.PlayerBtlData.Mag, Integer.valueOf(baseValue));
/* 204 */     basePer = 0;
/* 205 */     if (this.allInflus.containsKey(Const.PlayerBtlData.MagPer)) {
/* 206 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.MagPer)).intValue();
/*     */     }
/* 208 */     if (this.allInflus.containsKey(Const.PlayerBtlData.AttackPer)) {
/* 209 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.AttackPer)).intValue();
/*     */     }
/* 211 */     this.allInflus.put(Const.PlayerBtlData.MagPer, Integer.valueOf(basePer));
/*     */     
/* 213 */     baseValue = 0;
/* 214 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Ac)) {
/* 215 */       baseValue = ((Integer)this.allInflus.get(Const.PlayerBtlData.Ac)).intValue();
/*     */     }
/* 217 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Def)) {
/* 218 */       baseValue += ((Integer)this.allInflus.get(Const.PlayerBtlData.Def)).intValue();
/*     */     }
/* 220 */     this.allInflus.put(Const.PlayerBtlData.Ac, Integer.valueOf(baseValue));
/* 221 */     basePer = 0;
/* 222 */     if (this.allInflus.containsKey(Const.PlayerBtlData.AcPer)) {
/* 223 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.AcPer)).intValue();
/*     */     }
/* 225 */     if (this.allInflus.containsKey(Const.PlayerBtlData.DefPer)) {
/* 226 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.DefPer)).intValue();
/*     */     }
/* 228 */     this.allInflus.put(Const.PlayerBtlData.AcPer, Integer.valueOf(basePer));
/*     */     
/* 230 */     baseValue = 0;
/* 231 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Resist)) {
/* 232 */       baseValue = ((Integer)this.allInflus.get(Const.PlayerBtlData.Resist)).intValue();
/*     */     }
/* 234 */     if (this.allInflus.containsKey(Const.PlayerBtlData.Def)) {
/* 235 */       baseValue += ((Integer)this.allInflus.get(Const.PlayerBtlData.Def)).intValue();
/*     */     }
/* 237 */     this.allInflus.put(Const.PlayerBtlData.Resist, Integer.valueOf(baseValue));
/* 238 */     basePer = 0;
/* 239 */     if (this.allInflus.containsKey(Const.PlayerBtlData.ResistPer)) {
/* 240 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.ResistPer)).intValue();
/*     */     }
/* 242 */     if (this.allInflus.containsKey(Const.PlayerBtlData.DefPer)) {
/* 243 */       basePer += ((Integer)this.allInflus.get(Const.PlayerBtlData.DefPer)).intValue();
/*     */     }
/* 245 */     this.allInflus.put(Const.PlayerBtlData.ResistPer, Integer.valueOf(basePer));
/* 246 */     this.allInflus.remove(Const.PlayerBtlData.Attack);
/* 247 */     this.allInflus.remove(Const.PlayerBtlData.AttackPer);
/* 248 */     this.allInflus.remove(Const.PlayerBtlData.Def);
/* 249 */     this.allInflus.remove(Const.PlayerBtlData.DefPer);
/*     */ 
/*     */     
/* 252 */     AttributeUtil.addData2AllData(this.allInflus, this.finalInflus);
/*     */ 
/*     */     
/* 255 */     int curMaxHp = 0;
/* 256 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.HPPer) && this.finalInflus.containsKey(Const.PlayerBtlData.MaxHP)) {
/* 257 */       curMaxHp = ((Integer)this.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
/* 258 */       curMaxHp += curMaxHp * ((Integer)this.finalInflus.get(Const.PlayerBtlData.HPPer)).intValue() / 10000;
/* 259 */       this.finalInflus.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(curMaxHp));
/*     */     } 
/*     */     
/* 262 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Phy) && this.finalInflus.containsKey(Const.PlayerBtlData.PhyPer)) {
/* 263 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Phy)).intValue();
/* 264 */       this.finalInflus.put(Const.PlayerBtlData.Phy, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.PhyPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 267 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Mag) && this.finalInflus.containsKey(Const.PlayerBtlData.MagPer)) {
/* 268 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Mag)).intValue();
/* 269 */       this.finalInflus.put(Const.PlayerBtlData.Mag, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.MagPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 272 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Hit) && this.finalInflus.containsKey(Const.PlayerBtlData.HitPer)) {
/* 273 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Hit)).intValue();
/* 274 */       this.finalInflus.put(Const.PlayerBtlData.Hit, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.HitPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 277 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Dodge) && this.finalInflus.containsKey(Const.PlayerBtlData.DodgePer)) {
/* 278 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Dodge)).intValue();
/* 279 */       this.finalInflus.put(Const.PlayerBtlData.Dodge, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.DodgePer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 282 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Crit) && this.finalInflus.containsKey(Const.PlayerBtlData.CritPer)) {
/* 283 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Crit)).intValue();
/* 284 */       this.finalInflus.put(Const.PlayerBtlData.Crit, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.CritPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 287 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.ResCrit) && this.finalInflus.containsKey(Const.PlayerBtlData.ResCritPer)) {
/* 288 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.ResCrit)).intValue();
/* 289 */       this.finalInflus.put(Const.PlayerBtlData.ResCrit, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.ResCritPer)).intValue() / 10000));
/*     */     } 
/*     */ 
/*     */     
/* 293 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Ac) && this.finalInflus.containsKey(Const.PlayerBtlData.AcPer)) {
/* 294 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Ac)).intValue();
/* 295 */       this.finalInflus.put(Const.PlayerBtlData.Ac, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.AcPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 298 */     if (this.finalInflus.containsKey(Const.PlayerBtlData.Resist) && this.finalInflus.containsKey(Const.PlayerBtlData.ResistPer)) {
/* 299 */       int value = ((Integer)this.finalInflus.get(Const.PlayerBtlData.Resist)).intValue();
/* 300 */       this.finalInflus.put(Const.PlayerBtlData.Resist, Integer.valueOf(value + value * ((Integer)this.finalInflus.get(Const.PlayerBtlData.ResistPer)).intValue() / 10000));
/*     */     } 
/*     */     
/* 303 */     int nowMaxHp = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
/* 304 */     int nowPhy = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
/* 305 */     int nowMag = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();
/* 306 */     if (oldMaxHp != nowMaxHp && this.player.rankManager != null) {
/* 307 */       this.player.rankManager.onEvent(RankType.HP, new Object[] { Integer.valueOf(nowMaxHp) });
/*     */     }
/* 309 */     if (oldPhy != nowPhy && this.player.rankManager != null) {
/* 310 */       this.player.rankManager.onEvent(RankType.PHY, new Object[] { Integer.valueOf(nowPhy) });
/*     */     }
/* 312 */     if (oldMag != nowMag && this.player.rankManager != null) {
/* 313 */       this.player.rankManager.onEvent(RankType.MAGIC, new Object[] { Integer.valueOf(nowMag) });
/*     */     }
/* 315 */     if (GWorld.DEBUG) {
/* 316 */       StringBuilder sb = (new StringBuilder("\r\n==========================player:")).append(this.player.getName()).append(" finalInflus begin=====================\r\n");
/* 317 */       for (Const.PlayerBtlData key : this.finalInflus.keySet()) {
/* 318 */         sb.append(key.toString() + "\t" + key.chName + "=" + this.finalInflus.get(key)).append("\r\n");
/*     */       }
/* 320 */       sb.append("==========================player finalInflus end=================================\r\n");
/* 321 */       Out.error(new Object[] { sb.toString() });
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
/*     */   public void calFinalData(Map<String, Integer> influs, boolean isBuffAttr) {
/* 333 */     int oldMaxHp = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
/* 334 */     int oldPhy = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
/* 335 */     int oldMag = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();
/* 336 */     calModuleData();
/* 337 */     if (isBuffAttr) {
/* 338 */       calBuffData();
/* 339 */       AttributeUtil.addData2AllDataByKey(influs, this.allInflus);
/*     */     } else {
/* 341 */       AttributeUtil.addData2AllDataByKey(influs, this.allInflus);
/* 342 */       calBuffData();
/*     */     } 
/*     */     
/* 345 */     calFinalData(oldMaxHp, oldPhy, oldMag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void calFinalData() {
/* 352 */     int oldMaxHp = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue();
/* 353 */     int oldPhy = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue();
/* 354 */     int oldMag = ((Integer)this.finalInflus.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue();
/*     */     
/* 356 */     calModuleData();
/* 357 */     calBuffData();
/* 358 */     calFinalData(oldMaxHp, oldPhy, oldMag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onPlayerUpgrade() {
/* 365 */     calProLvlData();
/* 366 */     calFinalData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onClassLvlUp() {
/* 373 */     calClassData();
/* 374 */     calFinalData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onExchangeProparty() {
/* 381 */     resetCalExchangeProparty();
/* 382 */     calFinalData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calProLvlData() {
/* 389 */     this.data_pro_lvl.clear();
/* 390 */     CharacterExt character_prop = GameData.findCharacters(t -> (t.pro == this.player.player.pro)).get(0);
/* 391 */     this.data_pro_lvl.put(Const.PlayerBtlData.MaxHP, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initHP, character_prop.hPGrowUp, this.player.player.level)));
/* 392 */     this.data_pro_lvl.put(Const.PlayerBtlData.Phy, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.basePhyDamage, character_prop.phyGrowUp, this.player.player.level)));
/* 393 */     this.data_pro_lvl.put(Const.PlayerBtlData.Mag, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.baseMagDamage, character_prop.magGrowUp, this.player.player.level)));
/* 394 */     this.data_pro_lvl.put(Const.PlayerBtlData.Hit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initHit, character_prop.hitGrowUP, this.player.player.level)));
/* 395 */     this.data_pro_lvl.put(Const.PlayerBtlData.Dodge, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initDodge, character_prop.dodgeGrowUP, this.player.player.level)));
/* 396 */     this.data_pro_lvl.put(Const.PlayerBtlData.Crit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initCrit, character_prop.critGrowUP, this.player.player.level)));
/* 397 */     this.data_pro_lvl.put(Const.PlayerBtlData.ResCrit, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initResCrit, character_prop.resCritGrowUP, this.player.player.level)));
/* 398 */     this.data_pro_lvl.put(Const.PlayerBtlData.Ac, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initAc, character_prop.acGrowUp, this.player.player.level)));
/* 399 */     this.data_pro_lvl.put(Const.PlayerBtlData.Resist, Integer.valueOf(CommonUtil.getGrowUpValue(character_prop.initResist, character_prop.resistGrowUp, this.player.player.level)));
/* 400 */     this.data_pro_lvl.put(Const.PlayerBtlData.HPRecover, Integer.valueOf(character_prop.baseHPRegen));
/* 401 */     this.data_pro_lvl.put(Const.PlayerBtlData.HealEffect, Integer.valueOf(character_prop.healEffect));
/* 402 */     this.data_pro_lvl.put(Const.PlayerBtlData.HealedEffect, Integer.valueOf(character_prop.healedEffect));
/* 403 */     this.data_pro_lvl.put(Const.PlayerBtlData.CritDamage, Integer.valueOf(character_prop.critDamage));
/*     */ 
/*     */     
/* 406 */     if (StringUtil.isNotEmpty(character_prop.giftProp1)) {
/* 407 */       Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp1);
/* 408 */       if (gift != null)
/* 409 */         putBtlData(gift, character_prop.giftValue1, this.data_pro_lvl); 
/*     */     } 
/* 411 */     if (!StringUtil.isNotEmpty(character_prop.giftProp2)) {
/* 412 */       Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp2);
/* 413 */       if (gift != null)
/* 414 */         putBtlData(gift, character_prop.giftValue2, this.data_pro_lvl); 
/*     */     } 
/* 416 */     if (!StringUtil.isNotEmpty(character_prop.giftProp3)) {
/* 417 */       Const.PlayerBtlData gift = Const.PlayerBtlData.getE(character_prop.giftProp3);
/* 418 */       if (gift != null) {
/* 419 */         putBtlData(gift, character_prop.giftValue3, this.data_pro_lvl);
/*     */       }
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
/*     */   private static void putBtlData(Const.PlayerBtlData e, int value, Map<Const.PlayerBtlData, Integer> map) {
/* 432 */     if (map.containsKey(e)) {
/* 433 */       int value_data = ((Integer)map.get(e)).intValue();
/* 434 */       map.put(e, Integer.valueOf(value + value_data));
/*     */     } else {
/* 436 */       map.put(e, Integer.valueOf(value));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Number> _getBattlerServerEffect() {
/* 445 */     Map<String, Number> map = new HashMap<>();
/* 446 */     for (Const.PlayerBtlData pbd : Const.PlayerBtlData.values()) {
/* 447 */       if (this.allInflus.containsKey(pbd)) {
/* 448 */         map.put(pbd.name(), this.allInflus.get(pbd));
/*     */       } else {
/* 450 */         map.put(pbd.name(), Integer.valueOf(0));
/*     */       } 
/*     */     } 
/* 453 */     map.put("HP", Integer.valueOf(this.player.playerTempData.hp));
/* 454 */     float moveSpeed = 5.6F * (1.0F + ((Number)map.get(Const.PlayerBtlData.RunSpeed.name())).floatValue() / 10000.0F);
/* 455 */     if (this.player.playerBasePO.speed != 0.0F) {
/* 456 */       moveSpeed = this.player.playerBasePO.speed;
/*     */     }
/* 458 */     map.put("MoveSpeed", Float.valueOf(moveSpeed));
/* 459 */     int bagRemainCount = this.player.bag.emptyGridNum();
/* 460 */     map.put("bagRemainCount", Integer.valueOf(bagRemainCount));
/* 461 */     return map;
/*     */   }
/*     */   
/*     */   public List<Common.AttributeSimple> _getPlayerAttr() {
/* 465 */     List<Common.AttributeSimple> list = new ArrayList<>();
/* 466 */     for (Const.PlayerBtlData pbd : this.finalInflus.keySet()) {
/* 467 */       Common.AttributeSimple.Builder asb = Common.AttributeSimple.newBuilder();
/* 468 */       asb.setId(pbd.id);
/* 469 */       asb.setValue(((Integer)this.finalInflus.get(pbd)).intValue());
/* 470 */       list.add(asb.build());
/*     */     } 
/* 472 */     return list;
/*     */   }
/*     */   
/*     */   public int getPlayerBtlPropValue(Const.PlayerBtlData pbd) {
/* 476 */     if (this.finalInflus.containsKey(pbd)) {
/* 477 */       return ((Integer)this.finalInflus.get(pbd)).intValue();
/*     */     }
/* 479 */     return 0;
/*     */   }
/*     */   
/*     */   public void onMountPropChange() {
/* 483 */     this.data_mount = this.player.mountManager.data_mount_final;
/* 484 */     calFinalData();
/*     */   }
/*     */ 
/*     */   
/*     */   private void onPetPropChange() {
/* 489 */     calFinalData();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDaoYouChange() {
/* 494 */     calDaoYouData();
/* 495 */     calFinalData();
/*     */   }
/*     */   
/*     */   public void onGuildBossInpire() {
/* 499 */     calFinalData();
/*     */   }
/*     */   
/*     */   public void calDaoYouData() {
/* 503 */     DaoYouPO dyp = DaoYouService.getInstance().getDaoYou(this.player.getId());
/* 504 */     if (dyp == null) {
/* 505 */       this.data_dao_you.clear();
/*     */       return;
/*     */     } 
/* 508 */     String daoYouId = dyp.id;
/* 509 */     Map<Const.PlayerBtlData, Integer> tempDataDaoYou = DaoYouCenter.getInstance().getDaoYouBtl(daoYouId);
/* 510 */     if (tempDataDaoYou == null) {
/*     */       return;
/*     */     }
/* 513 */     this.data_dao_you = tempDataDaoYou;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 518 */     switch (eventType) {
/*     */       case UPGRADE:
/* 520 */         onPlayerUpgrade();
/*     */         break;
/*     */       case CLASS_UPGRADE:
/* 523 */         onClassLvlUp();
/*     */         break;
/*     */       case EQUIPMENT_CHANGE:
/* 526 */         onEquipChange();
/*     */         break;
/*     */       case PET_PROP_CHANGE:
/* 529 */         onPetPropChange();
/*     */         break;
/*     */       case GUILD_BLESS_CHANGE:
/*     */       case GUILD_TECH_CHANGE:
/*     */       case TITLE_CHANGE:
/*     */       case UPGRADE_TALENT_PASSIVE_SKILL:
/* 535 */         calFinalData();
/*     */         break;
/*     */       case EXCHANGE_PROPARTY:
/* 538 */         onExchangeProparty();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 547 */     return Const.ManagerType.BTL_DATA;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\playerData\PlayerBtlDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */