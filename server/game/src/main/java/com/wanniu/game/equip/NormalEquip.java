/*     */ package com.wanniu.game.equip;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.CommonUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DEquipBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.base.FourProp;
/*     */ import com.wanniu.game.data.ext.AffixExt;
/*     */ import com.wanniu.game.data.ext.EnchantExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.data.AttsObj;
/*     */ import com.wanniu.game.item.po.ItemSpeData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class NormalEquip
/*     */   extends NormalItem
/*     */ {
/*     */   public DEquipBase prop;
/*     */   public ItemSpeData speData;
/*     */   
/*     */   public NormalEquip(PlayerItemPO itemDb, DItemEquipBase prop) {
/*  45 */     super(itemDb, prop);
/*     */     
/*  47 */     this.prop = (DEquipBase)prop;
/*  48 */     this.speData = itemDb.speData;
/*     */     
/*  50 */     _init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void _init() {}
/*     */ 
/*     */   
/*     */   public ItemSpeData getSpeData() {
/*  58 */     return this.speData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQColor() {
/*  67 */     return this.prop.qcolor;
/*     */   }
/*     */   
/*     */   public int getEquipScore(PlayerBasePO basePO) {
/*  71 */     return getEquipScore(_calInfluence(basePO));
/*     */   }
/*     */   
/*     */   public int getEquipScore(Map<String, Integer> attrs) {
/*  75 */     float score = 0.0F;
/*  76 */     for (Map.Entry<String, Integer> entry : attrs.entrySet()) {
/*  77 */       score += AttributeUtil.getScoreRatioByKey(entry.getKey()) * Math.abs(((Integer)entry.getValue()).intValue());
/*     */     }
/*  79 */     Out.debug(new Object[] { getClass(), " getEquipScore:", attrs.toString(), " = ", Float.valueOf(score) });
/*  80 */     return (int)score;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemOuterClass.ItemDetail.Builder getItemDetail(PlayerBasePO basePO) {
/*  89 */     ItemOuterClass.ItemDetail.Builder data = ItemOuterClass.ItemDetail.newBuilder();
/*  90 */     data.setId(this.itemDb.id);
/*  91 */     data.setCode(this.itemDb.code);
/*  92 */     data.setBindType(getBind());
/*  93 */     data.setCanTrade(canTrade() ? 1 : 0);
/*  94 */     data.setCanAuction((canAuction() && getBind() != 1) ? 1 : 0);
/*  95 */     data.setCanDepotRole(canDepotRole() ? 1 : 0);
/*  96 */     data.setCanDepotGuild(canDepotGuild() ? 1 : 0);
/*     */     
/*  98 */     ItemOuterClass.EquipmentDetail.Builder equipDetail = ItemOuterClass.EquipmentDetail.newBuilder();
/*  99 */     equipDetail.setIsIdentfied(0);
/* 100 */     equipDetail.setScore(getEquipScore(_calInfluence(basePO)));
/*     */     
/* 102 */     equipDetail.setBaseScore(equipDetail.getScore());
/*     */ 
/*     */     
/* 105 */     DEquipBase attsProp = ItemConfig.getInstance().getEquipProp(this.prop.code);
/* 106 */     if (StringUtil.isNotEmpty(this.prop.baseCode)) {
/* 107 */       attsProp = ItemConfig.getInstance().getEquipProp(this.prop.baseCode);
/*     */     }
/* 109 */     int remakeScore = 0;
/* 110 */     int tempremakeScore = 0;
/* 111 */     int seniortempremakeScore = 0;
/* 112 */     List<AttsObj> list_ext = new ArrayList<>();
/* 113 */     if (this.speData.extAtts == null) {
/* 114 */       if (this.prop.fixedAtts != null) {
/* 115 */         for (String key : this.prop.fixedAtts.keySet()) {
/* 116 */           int value = ((Integer)this.prop.fixedAtts.get(key)).intValue();
/* 117 */           list_ext.add(new AttsObj(key, value, 0, value, value));
/* 118 */           remakeScore += CommonUtil.calOneAttributeFightScroreByStr(key, value);
/*     */         } 
/*     */       }
/*     */     } else {
/* 122 */       for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)this.speData.extAtts.entrySet()) {
/* 123 */         AffixExt affix = (AffixExt)GameData.Affixs.get(rp.k);
/* 124 */         if (affix == null) {
/* 125 */           Out.warn(new Object[] { "key=" + rp.k + " val=" + rp.v });
/*     */           continue;
/*     */         } 
/* 128 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(getQColor()));
/* 129 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 132 */         list_ext.add(new AttsObj(pair.prop, ((Integer)rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
/* 133 */         remakeScore += CommonUtil.calOneAttributeFightScroreById(((Integer)rp.k).intValue(), ((Integer)rp.v).intValue(), this.prop.qcolor);
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     equipDetail.addAllRandomAtts(EquipUtil.getAttsAttributeBase(list_ext));
/*     */     
/* 139 */     List<AttsObj> list_base = new ArrayList<>();
/* 140 */     if (this.speData.baseAtts != null) {
/* 141 */       for (String key : this.speData.baseAtts.keySet()) {
/* 142 */         FourProp pair = (FourProp)attsProp.baseAtts.get(key);
/* 143 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 146 */         list_base.add(new AttsObj(key, ((Integer)this.speData.baseAtts.get(key)).intValue(), pair.par, pair.min, pair.max));
/*     */       } 
/*     */     }
/* 149 */     equipDetail.addAllBaseAtts(EquipUtil.getAttsAttributeBase(list_base));
/*     */     
/* 151 */     List<AttsObj> star_base = new ArrayList<>();
/* 152 */     if (this.speData.extAttsAdd != null) {
/* 153 */       int add = 0;
/* 154 */       for (String key : this.speData.extAttsAdd.keySet()) {
/* 155 */         Integer vl = (Integer)this.speData.extAttsAdd.get(key);
/* 156 */         int ivl = (vl == null) ? 0 : vl.intValue();
/* 157 */         star_base.add(new AttsObj(key, ivl, 0, ivl, ivl));
/* 158 */         add = CommonUtil.calOneAttributeFightScroreByStr(key, ivl);
/* 159 */         remakeScore += add;
/*     */       } 
/* 161 */       if (this.speData.tempExtAtts_senior != null) {
/* 162 */         seniortempremakeScore += add;
/*     */       }
/*     */     } 
/* 165 */     equipDetail.addAllStarAttr(EquipUtil.getAttsAttributeBase(star_base));
/*     */ 
/*     */ 
/*     */     
/* 169 */     List<AttsObj> temp_star_base = new ArrayList<>();
/* 170 */     if (this.speData.tempExtAttsAdd != null) {
/* 171 */       for (String key : this.speData.tempExtAttsAdd.keySet()) {
/* 172 */         Integer vl = (Integer)this.speData.tempExtAttsAdd.get(key);
/* 173 */         int ivl = (vl == null) ? 0 : vl.intValue();
/* 174 */         temp_star_base.add(new AttsObj(key, ivl, 0, ivl, ivl));
/* 175 */         tempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(key, ivl);
/*     */       } 
/*     */     }
/* 178 */     equipDetail.addAllTempstarAttr(EquipUtil.getAttsAttributeBase(temp_star_base));
/* 179 */     if (this.speData.legendAtts != null) {
/* 180 */       for (Iterator<Integer> iterator = this.speData.legendAtts.keySet().iterator(); iterator.hasNext(); ) { int affixId = ((Integer)iterator.next()).intValue();
/* 181 */         AffixExt affix = (AffixExt)GameData.Affixs.get(Integer.valueOf(affixId));
/* 182 */         if (affix == null) {
/*     */           continue;
/*     */         }
/* 185 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(getQColor()));
/* 186 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 189 */         equipDetail.addUniqueAtts(EquipUtil.getAttributeBase(new AttsObj(pair.prop, ((Integer)this.speData.legendAtts.get(Integer.valueOf(affixId))).intValue(), pair.par, pair.min, pair.max))); }
/*     */     
/*     */     }
/*     */     
/* 193 */     if (this.speData.tempBaseAtts != null) {
/* 194 */       List<AttsObj> list_temp_base = new ArrayList<>();
/* 195 */       for (String key : this.speData.tempBaseAtts.keySet()) {
/* 196 */         FourProp pair = (FourProp)attsProp.baseAtts.get(key);
/* 197 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 200 */         list_temp_base.add(new AttsObj(key, ((Integer)this.speData.tempBaseAtts.get(key)).intValue(), pair.par, pair.min, pair.max));
/*     */       } 
/* 202 */       equipDetail.addAllTempBaseAtts(EquipUtil.getAttsAttributeBase(list_temp_base));
/*     */     } 
/*     */     
/* 205 */     if (this.speData.tempExtAtts != null) {
/* 206 */       List<AttsObj> list__temp_ext = new ArrayList<>();
/* 207 */       for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)this.speData.tempExtAtts.entrySet()) {
/* 208 */         AffixExt affix = (AffixExt)GameData.Affixs.get(rp.k);
/* 209 */         if (affix == null) {
/* 210 */           Out.error(new Object[] { "tempExtAtts null exception, id=" + getId() + " code=" + this.itemDb.code + " name=" + getName() + " k=" + rp.k + " v=" + rp.v });
/*     */           continue;
/*     */         } 
/* 213 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(getQColor()));
/* 214 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 217 */         list__temp_ext.add(new AttsObj(pair.prop, ((Integer)rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
/* 218 */         tempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(pair.prop, ((Integer)rp.v).intValue());
/*     */       } 
/* 220 */       equipDetail.addAllTempExtAtts(EquipUtil.getAttsAttributeBase(list__temp_ext));
/*     */     } 
/*     */     
/* 223 */     if (this.speData.tempExtAtts_senior != null) {
/* 224 */       List<AttsObj> list__temp_ext = new ArrayList<>();
/* 225 */       for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)this.speData.tempExtAtts_senior.entrySet()) {
/* 226 */         AffixExt affix = (AffixExt)GameData.Affixs.get(rp.k);
/* 227 */         if (affix == null) {
/* 228 */           Out.warn(new Object[] { "key=" + rp.k + " val=" + rp.v });
/*     */           continue;
/*     */         } 
/* 231 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(getQColor()));
/* 232 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 235 */         list__temp_ext.add(new AttsObj(pair.prop, ((Integer)rp.v).intValue(), pair.par, ItemUtil.calcRebuildPropMin(pair.min), pair.max));
/* 236 */         seniortempremakeScore += CommonUtil.calOneAttributeFightScroreByStr(pair.prop, ((Integer)rp.v).intValue());
/*     */       } 
/*     */       
/* 239 */       equipDetail.addAllTempExtAttsSenior(EquipUtil.getAttsAttributeBase(list__temp_ext));
/*     */     } 
/*     */     
/* 242 */     if (this.speData.tempUniqueAtts != null) {
/* 243 */       for (Iterator<Integer> iterator = this.speData.tempUniqueAtts.keySet().iterator(); iterator.hasNext(); ) { int affixId = ((Integer)iterator.next()).intValue();
/* 244 */         AffixExt affix = (AffixExt)GameData.Affixs.get(Integer.valueOf(affixId));
/* 245 */         if (affix == null) {
/*     */           continue;
/*     */         }
/* 248 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(getQColor()));
/* 249 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 252 */         equipDetail.addTempUniqueAtts(EquipUtil.getAttributeBase(new AttsObj(pair.prop, ((Integer)this.speData.tempUniqueAtts.get(Integer.valueOf(affixId))).intValue(), pair.par, pair.min, pair.max))); }
/*     */     
/*     */     }
/* 255 */     equipDetail.setRemakeScore(remakeScore);
/* 256 */     equipDetail.setTempRemakeScore(tempremakeScore);
/* 257 */     equipDetail.setSeniorTempRemakeScore(seniortempremakeScore);
/* 258 */     data.setEquipDetail(equipDetail);
/*     */     
/* 260 */     return data;
/*     */   }
/*     */   
/*     */   public Map<String, Integer> _calInfluence(PlayerBasePO basePO) {
/* 264 */     PlayerBasePO.EquipStrengthPos strengthInfo = (PlayerBasePO.EquipStrengthPos)basePO.strengthPos.get(Integer.valueOf(getPosition()));
/*     */     
/* 266 */     Map<String, Integer> data = new HashMap<>();
/*     */ 
/*     */     
/* 269 */     if (strengthInfo == null || (strengthInfo.enSection == 0 && strengthInfo.enLevel == 0)) {
/* 270 */       Utils.deepCopy(data, this.speData.baseAtts);
/*     */     } else {
/* 272 */       EnchantExt enchantExt = (EnchantExt)GameData.Enchants.get(Integer.valueOf(strengthInfo.enSection * 100 + strengthInfo.enLevel));
/* 273 */       if (enchantExt != null) {
/* 274 */         for (String key : this.speData.baseAtts.keySet()) {
/* 275 */           int value = ((Integer)this.speData.baseAtts.get(key)).intValue();
/* 276 */           value = value * (10000 + enchantExt.propPer) / 10000;
/* 277 */           if (data.containsKey(key)) {
/* 278 */             data.put(key, Integer.valueOf(((Integer)data.get(key)).intValue() + value)); continue;
/*     */           } 
/* 280 */           data.put(key, Integer.valueOf(value));
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 286 */     if (this.speData.extAtts == null) {
/* 287 */       Utils.deepCopy(data, this.prop.fixedAtts);
/*     */     } else {
/* 289 */       Utils.deepCopyAffix(data, this.speData.extAtts, getQColor());
/*     */     } 
/*     */     
/* 292 */     if (this.speData.extAttsAdd != null) {
/* 293 */       Utils.deepCopy(data, this.speData.extAttsAdd);
/*     */     }
/*     */     
/* 296 */     Utils.deepCopyAffix(data, this.speData.legendAtts, getQColor());
/*     */     
/* 298 */     return data;
/*     */   }
/*     */   
/*     */   public int getPosition() {
/* 302 */     return Const.ItemSecondType.getV(this.prop.type);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\equip\NormalEquip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */