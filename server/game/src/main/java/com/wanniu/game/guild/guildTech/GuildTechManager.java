/*     */ package com.wanniu.game.guild.guildTech;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GTechnologyItemCO;
/*     */ import com.wanniu.game.data.GTechnologyLevelCO;
/*     */ import com.wanniu.game.data.GuildBuildingCO;
/*     */ import com.wanniu.game.data.ext.GBuffExt;
/*     */ import com.wanniu.game.data.ext.GTechnologyExt;
/*     */ import com.wanniu.game.guild.GuildResult;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.guild.dao.FindPlayerGuildDao;
/*     */ import com.wanniu.game.guild.guildBless.GuildBless;
/*     */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildMemberPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.PlayerGuildPO;
/*     */ import io.netty.util.internal.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.GuildTechHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildTechManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public int level;
/*     */   public int buffLevel;
/*     */   public Map<String, Integer> products;
/*     */   public PlayerGuildPO techData;
/*     */   
/*     */   public GuildTechManager(WNPlayer player) {
/*  45 */     this.player = player;
/*  46 */     this.level = 0;
/*  47 */     this.buffLevel = 0;
/*  48 */     this.products = new HashMap<>();
/*  49 */     this.techData = FindPlayerGuildDao.getPlayerGuildPOById(player.getId());
/*  50 */     init();
/*     */   }
/*     */   
/*     */   public void init() {
/*  54 */     List<Integer> skillIdArray = GuildUtil.getTechSkillIdList();
/*  55 */     for (int i = 0; i < skillIdArray.size(); i++) {
/*  56 */       int skillId = ((Integer)skillIdArray.get(i)).intValue();
/*  57 */       if (!this.techData.skills.containsKey(Integer.valueOf(skillId))) {
/*  58 */         GuildTechSkill skill = new GuildTechSkill();
/*  59 */         skill.skillId = skillId;
/*  60 */         skill.level = 0;
/*  61 */         this.techData.skills.put(Integer.valueOf(skillId), skill);
/*     */       } 
/*     */     } 
/*  64 */     refreshLevel();
/*     */   }
/*     */ 
/*     */   
/*     */   public void refreshLevel() {
/*  69 */     GuildPO guidlPo = GuildUtil.getPlayerGuild(this.player.getId());
/*  70 */     if (null == guidlPo) {
/*  71 */       this.level = 0;
/*  72 */       this.buffLevel = 0;
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(guidlPo.id);
/*  77 */     if (null != bless) {
/*  78 */       this.level = bless.tech.level;
/*  79 */       this.buffLevel = bless.tech.buffLevel;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuildResult getGuildTechAsync() {
/*  84 */     GuildResult ret = GuildService.getGuildTodayTechData(this.player);
/*  85 */     boolean isChangeInfluence = refreshTechData(ret.techData);
/*  86 */     if (isChangeInfluence) {
/*  87 */       pushAndRefreshGuildEffect();
/*     */     }
/*  89 */     return ret;
/*     */   }
/*     */   
/*     */   public boolean refreshTechData(GuildTechData data) {
/*  93 */     boolean isChangeInfluence = false;
/*  94 */     this.level = data.blobData.level;
/*     */     
/*  96 */     if (this.buffLevel != data.blobData.buffLevel) {
/*  97 */       this.buffLevel = data.blobData.buffLevel;
/*  98 */       isChangeInfluence = true;
/*     */     } 
/*     */     
/* 101 */     this.products = data.blobData.products;
/* 102 */     refreshLevel();
/* 103 */     return isChangeInfluence;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetPublicData() {
/* 108 */     this.level = 0;
/* 109 */     this.buffLevel = 0;
/* 110 */     this.products.clear();
/*     */   }
/*     */   
/*     */   public GuildTechHandler.GuildTechInfo toJson4PayLoad() {
/* 114 */     GuildTechHandler.GuildTechInfo.Builder data = GuildTechHandler.GuildTechInfo.newBuilder();
/* 115 */     data.setLevel(this.level);
/*     */     
/* 117 */     data.setBuffInfo(getBuffData());
/*     */ 
/*     */     
/* 120 */     data.addAllSkillList(getSkillData());
/*     */ 
/*     */     
/* 123 */     return data.build();
/*     */   }
/*     */   
/*     */   public GuildTechHandler.GuildBuff getBuffData() {
/* 127 */     GuildTechHandler.GuildBuff.Builder data = GuildTechHandler.GuildBuff.newBuilder();
/* 128 */     GBuffExt buffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel);
/* 129 */     data.setLevel(this.buffLevel);
/* 130 */     if (null != buffProp) {
/* 131 */       data.setNeedFund(buffProp.funds);
/* 132 */       data.addAllCurrentAttrs(AttributeUtil.getAttributeBase(buffProp.attrs));
/*     */     } 
/*     */     
/* 135 */     GBuffExt nextBuffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel + 1);
/* 136 */     if (null != nextBuffProp) {
/* 137 */       data.addAllNextAttrs(AttributeUtil.getAttributeBase(nextBuffProp.attrs));
/*     */     }
/* 139 */     return data.build();
/*     */   }
/*     */   
/*     */   public List<GuildTechHandler.GuildSkill> getSkillData() {
/* 143 */     List<GuildTechHandler.GuildSkill> data = new ArrayList<>();
/* 144 */     for (GuildTechSkill skill : this.techData.skills.values()) {
/* 145 */       int skillId = skill.skillId;
/* 146 */       int skillLevel = skill.level;
/*     */       
/* 148 */       GTechnologyExt prop = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel);
/* 149 */       if (null == prop) {
/*     */         continue;
/*     */       }
/*     */       
/* 153 */       GTechnologyExt nextProp = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel + 1);
/*     */       
/* 155 */       GuildTechHandler.GuildSkill.Builder skillData = GuildTechHandler.GuildSkill.newBuilder();
/* 156 */       skillData.setId(skillId);
/* 157 */       skillData.setLevel(skillLevel);
/* 158 */       skillData.setTechName(prop.techName);
/* 159 */       skillData.setTechDes(prop.techDes);
/* 160 */       skillData.addAllCurrentAttrs(AttributeUtil.getAttributeBase(prop.attrs));
/* 161 */       skillData.setRecommend((prop.recommendPros.indexOf(Integer.valueOf(this.player.getPro())) != -1) ? 1 : 0);
/* 162 */       skillData.setIcon(prop.icon);
/* 163 */       if (null != nextProp) {
/* 164 */         skillData.addAllNextAttrs(AttributeUtil.getAttributeBase(nextProp.attrs));
/* 165 */         skillData.setNeedContribution(prop.points);
/* 166 */         skillData.setNeedGold(prop.gold);
/*     */       } 
/* 168 */       data.add(skillData.build());
/*     */     } 
/*     */     
/* 171 */     return data;
/*     */   }
/*     */   
/*     */   public GuildTechHandler.GuildSkill getOneSkillData(int id) {
/* 175 */     GuildTechHandler.GuildSkill.Builder skillData = GuildTechHandler.GuildSkill.newBuilder();
/* 176 */     GuildTechSkill skill = (GuildTechSkill)this.techData.skills.get(Integer.valueOf(id));
/* 177 */     if (null == skill) {
/* 178 */       return skillData.build();
/*     */     }
/* 180 */     int skillId = skill.skillId;
/* 181 */     int skillLevel = skill.level;
/*     */     
/* 183 */     GTechnologyExt prop = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel);
/* 184 */     if (null == prop) {
/* 185 */       return skillData.build();
/*     */     }
/* 187 */     GTechnologyExt nextProp = GuildUtil.getTechSkillPropByIdLevel(skillId, skillLevel + 1);
/*     */     
/* 189 */     skillData.setId(skillId);
/* 190 */     skillData.setLevel(skillLevel);
/* 191 */     skillData.setTechName(prop.techName);
/* 192 */     skillData.setTechDes(prop.techDes);
/* 193 */     skillData.addAllCurrentAttrs(AttributeUtil.getAttributeBase(prop.attrs));
/* 194 */     skillData.setRecommend((prop.recommendPros.indexOf(Integer.valueOf(this.player.getPro())) != 1) ? 1 : 0);
/* 195 */     skillData.setIcon(prop.icon);
/* 196 */     skillData.setNeedContribution(0);
/* 197 */     skillData.setNeedGold(0);
/* 198 */     if (null != nextProp) {
/* 199 */       skillData.addAllNextAttrs(AttributeUtil.getAttributeBase(nextProp.attrs));
/* 200 */       skillData.setNeedContribution(prop.points);
/* 201 */       skillData.setNeedGold(prop.gold);
/*     */     } 
/* 203 */     return skillData.build();
/*     */   }
/*     */   
/*     */   public List<GuildTechHandler.GuildProduct> getProduceData() {
/* 207 */     List<GuildTechHandler.GuildProduct> data = new ArrayList<>();
/* 208 */     for (String key : this.products.keySet()) {
/* 209 */       int id = Integer.parseInt(key);
/* 210 */       GTechnologyItemCO prop = GuildUtil.getTechProducePropById(id);
/* 211 */       if (null == prop) {
/*     */         continue;
/*     */       }
/* 214 */       String itemCode = prop.itemID;
/* 215 */       int itemNum = prop.count;
/*     */       
/* 217 */       GuildTechHandler.GuildProduct.Builder product = GuildTechHandler.GuildProduct.newBuilder();
/* 218 */       product.setId(id);
/* 219 */       product.setItem(ItemUtil.getMiniItemData(itemCode, itemNum).build());
/* 220 */       product.getItem().toBuilder().setBindType(prop.isBind);
/* 221 */       product.setLevel(prop.needLevel);
/* 222 */       product.setUpLevel(0);
/* 223 */       product.setNeedJob(prop.needPosition);
/* 224 */       product.setNeedContribution(prop.pointsPrice);
/* 225 */       if (this.techData.boughtList.indexOf(Integer.valueOf(id)) != -1) {
/* 226 */         product.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
/*     */       } else {
/* 228 */         product.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
/*     */       } 
/* 230 */       data.add(product.build());
/*     */     } 
/* 232 */     return data;
/*     */   }
/*     */   
/*     */   public void refreshNewDay(boolean isNewDay) {
/* 236 */     if (isNewDay) {
/* 237 */       this.techData.boughtList.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Integer> calAllInfluence() {
/* 243 */     Map<String, Integer> influs = new HashMap<>();
/* 244 */     if (!this.player.guildManager.isInGuild()) {
/* 245 */       return influs;
/*     */     }
/*     */     
/* 248 */     refreshLevel();
/*     */     
/* 250 */     GBuffExt buffProp = GuildUtil.getTechBuffPropByLevel(this.buffLevel);
/* 251 */     for (String key : buffProp.attrs.keySet()) {
/* 252 */       if (StringUtil.isNullOrEmpty(key)) {
/* 253 */         Out.error(new Object[] { "key is null buffProp" });
/*     */         continue;
/*     */       } 
/* 256 */       if (influs.containsKey(key)) {
/* 257 */         int tmp = ((Integer)influs.get(key)).intValue();
/* 258 */         influs.put(key, Integer.valueOf(tmp + ((Integer)buffProp.attrs.get(key)).intValue())); continue;
/*     */       } 
/* 260 */       influs.put(key, (Integer)buffProp.attrs.get(key));
/*     */     } 
/*     */ 
/*     */     
/* 264 */     for (Iterator<Integer> iterator = this.techData.skills.keySet().iterator(); iterator.hasNext(); ) { int skillId = ((Integer)iterator.next()).intValue();
/* 265 */       GuildTechSkill skill = (GuildTechSkill)this.techData.skills.get(Integer.valueOf(skillId));
/* 266 */       GTechnologyExt skillProp = GuildUtil.getTechSkillPropByIdLevel(skill.skillId, skill.level);
/* 267 */       if (null == skillProp) {
/*     */         continue;
/*     */       }
/*     */       
/* 271 */       for (String key : skillProp.attrs.keySet()) {
/* 272 */         if (StringUtil.isNullOrEmpty(key)) {
/* 273 */           Out.error(new Object[] { "key is null in skillProp" });
/*     */           
/*     */           continue;
/*     */         } 
/* 277 */         if (influs.containsKey(key)) {
/* 278 */           int tmp = ((Integer)influs.get(key)).intValue();
/* 279 */           influs.put(key, Integer.valueOf(tmp + ((Integer)skillProp.attrs.get(key)).intValue())); continue;
/*     */         } 
/* 281 */         influs.put(key, (Integer)skillProp.attrs.get(key));
/*     */       }  }
/*     */ 
/*     */     
/* 285 */     return influs;
/*     */   }
/*     */   
/*     */   public void pushAndRefreshGuildEffect() {
/* 289 */     this.player.updatePlayerGuildTechAttrs();
/*     */   }
/*     */   
/*     */   public GuildResult upgradeTechLevel() {
/* 293 */     GuildResult ret = new GuildResult();
/* 294 */     ret = GuildService.techUpgradeLevel(this.player);
/* 295 */     GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel)ret.data;
/* 296 */     if (ret.result == 0) {
/* 297 */       this.level = data.level;
/* 298 */       if (data.needGold > 0) {
/* 299 */         this.player.moneyManager.costGold(data.needGold, Const.GOODS_CHANGE_TYPE.guild_upgrade_tech_level);
/*     */       }
/*     */     } 
/* 302 */     return ret;
/*     */   }
/*     */   
/*     */   public GuildResult upgradeBuffLevel() {
/* 306 */     GuildResult ret = new GuildResult();
/* 307 */     ret = GuildService.techUpgradeBuffLevel(this.player);
/* 308 */     GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel)ret.data;
/* 309 */     if (ret.result == 0) {
/* 310 */       this.buffLevel = data.buffLevel;
/* 311 */       pushAndRefreshGuildEffect();
/*     */     } 
/* 313 */     return ret;
/*     */   }
/*     */   
/*     */   public GuildResult upgradeSkillLevel(int id) {
/* 317 */     GuildResult ret = new GuildResult();
/* 318 */     getGuildTechAsync();
/* 319 */     if (!this.techData.skills.containsKey(Integer.valueOf(id))) {
/* 320 */       ret.result = -1;
/* 321 */       ret.des = "技能不存在";
/* 322 */       return ret;
/*     */     } 
/*     */     
/* 325 */     GuildBuildingCO buildingProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
/* 326 */     GTechnologyLevelCO skillLevelProp = GuildUtil.getTechLevelPropByLevel(this.level);
/*     */     
/* 328 */     int levelPerStage = 10;
/* 329 */     int skillLevelMax = this.level * levelPerStage;
/* 330 */     if (null != skillLevelProp) {
/* 331 */       skillLevelMax = skillLevelProp.maxSkill;
/*     */     }
/*     */ 
/*     */     
/* 335 */     if (((GuildTechSkill)this.techData.skills.get(Integer.valueOf(id))).level >= buildingProp.maxLv * levelPerStage) {
/* 336 */       ret.result = -2;
/* 337 */       ret.des = "技能等级已满";
/* 338 */       return ret;
/*     */     } 
/*     */     
/* 341 */     if (((GuildTechSkill)this.techData.skills.get(Integer.valueOf(id))).level >= skillLevelMax) {
/* 342 */       ret.result = -3;
/* 343 */       String _des = LangService.getValue("TECH_SKILL_NEED_TECH_LEVEL");
/* 344 */       _des = _des.replace("{0}", "" + this.level);
/* 345 */       _des = _des.replace("{1}", "" + skillLevelMax);
/* 346 */       ret.des = _des;
/* 347 */       return ret;
/*     */     } 
/*     */     
/* 350 */     GTechnologyExt skillProp = GuildUtil.getTechSkillPropByIdLevel(id, ((GuildTechSkill)this.techData.skills.get(Integer.valueOf(id))).level);
/* 351 */     if (!this.player.guildManager.enoughContribution(skillProp.points)) {
/* 352 */       ret.result = -4;
/* 353 */       ret.des = "帮贡不足";
/* 354 */       return ret;
/*     */     } 
/* 356 */     if (!this.player.moneyManager.enoughGold(skillProp.gold)) {
/* 357 */       ret.result = -5;
/* 358 */       ret.des = "银两不足";
/* 359 */       return ret;
/*     */     } 
/*     */     
/* 362 */     ((GuildTechSkill)this.techData.skills.get(Integer.valueOf(id))).level++;
/* 363 */     this.player.guildManager.costContribution(skillProp.points, Const.GOODS_CHANGE_TYPE.guild_tech);
/* 364 */     this.player.moneyManager.costGold(skillProp.gold, Const.GOODS_CHANGE_TYPE.guild_tech);
/* 365 */     this.player.allBlobData.playerAttachPO.miscData.guildSkillUpToday = 1;
/*     */     
/* 367 */     pushAndRefreshGuildEffect();
/* 368 */     ret.result = 0;
/* 369 */     ret.des = "success";
/* 370 */     return ret;
/*     */   }
/*     */   
/*     */   public GuildResult buyGuildTechProduct(int id) {
/* 374 */     GuildResult ret = new GuildResult();
/* 375 */     getGuildTechAsync();
/* 376 */     GTechnologyItemCO prop = GuildUtil.getTechProducePropById(id);
/*     */     
/* 378 */     if (null == prop || !this.products.containsKey(Integer.valueOf(id))) {
/* 379 */       ret.result = -1;
/* 380 */       ret.des = "产出不存在";
/* 381 */       return ret;
/*     */     } 
/* 383 */     if (this.techData.boughtList.indexOf(Integer.valueOf(id)) != -1) {
/* 384 */       ret.result = -2;
/* 385 */       ret.des = "已购买";
/* 386 */       return ret;
/*     */     } 
/* 388 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 389 */     if (null == myInfo) {
/* 390 */       ret.result = -3;
/* 391 */       ret.des = "还没有加入公会";
/* 392 */       return ret;
/*     */     } 
/* 394 */     if (myInfo.job > prop.needPosition) {
/* 395 */       ret.result = -4;
/* 396 */       ret.des = "职位太低";
/* 397 */       return ret;
/*     */     } 
/* 399 */     if (prop.needLevel > 0 && this.player.getLevel() < prop.needLevel) {
/* 400 */       ret.result = -5;
/* 401 */       ret.des = "等级不够";
/* 402 */       return ret;
/*     */     } 
/* 404 */     if (this.player.guildManager.enoughContribution(prop.pointsPrice)) {
/* 405 */       ret.result = -6;
/* 406 */       ret.des = "帮贡不足";
/* 407 */       return ret;
/*     */     } 
/* 409 */     String itemCode = prop.itemID;
/* 410 */     int itemNum = ((Integer)this.products.get(Integer.valueOf(id))).intValue();
/* 411 */     if (!this.player.bag.testAddCodeItem(itemCode, itemNum, Const.ForceType.getE(prop.isBind))) {
/* 412 */       ret.result = -7;
/* 413 */       ret.des = "背包空间不足";
/* 414 */       return ret;
/*     */     } 
/*     */     
/* 417 */     this.player.bag.addCodeItem(itemCode, itemNum, Const.ForceType.getE(prop.isBind), Const.GOODS_CHANGE_TYPE.guild_buy_tech_product, null);
/* 418 */     this.player.guildManager.costContribution(prop.pointsPrice, Const.GOODS_CHANGE_TYPE.guild_buy_tech_product);
/* 419 */     this.techData.boughtList.add(Integer.valueOf(id));
/*     */     
/* 421 */     ret.result = 0;
/* 422 */     ret.des = "success";
/* 423 */     ret.id = String.valueOf(id);
/* 424 */     ret.state = Const.EVENT_GIFT_STATE.RECEIVED.getValue();
/* 425 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildTech\GuildTechManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */