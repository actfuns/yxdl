/*     */ package com.wanniu.gm.handler;
/*     */ 
/*     */ import cn.qeng.common.gm.vo.GmItemVO;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DEquipBase;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.base.FourProp;
/*     */ import com.wanniu.game.data.ext.AffixExt;
/*     */ import com.wanniu.game.equip.RepeatKeyMap;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.PlayerDao;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.po.AllBlobPO;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
/*     */ import com.wanniu.gm.GMEvent;
/*     */ import com.wanniu.gm.GMJsonResponse;
/*     */ import com.wanniu.gm.GMResponse;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GMEvent
/*     */ public class QueryBagItemHandler
/*     */   extends GMBaseHandler
/*     */ {
/*     */   public GMResponse execute(JSONArray arr) {
/*  46 */     String id = arr.getString(0);
/*  47 */     int type = arr.getIntValue(1);
/*  48 */     WNPlayer player = PlayerUtil.findPlayer(id);
/*  49 */     if (player == null) {
/*  50 */       AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
/*  51 */       player = new WNPlayer(allBlobData);
/*     */     } 
/*  53 */     Map<String, Object> data = new HashMap<>();
/*  54 */     if (type == 0) {
/*  55 */       List<GmItemVO> items = new ArrayList<>();
/*  56 */       for (NormalItem it : player.bag.bagGrids.values()) {
/*  57 */         if (it == null) {
/*     */           continue;
/*     */         }
/*  60 */         boolean isEquip = ItemUtil.isEquipByItemType(it.prop.itemType);
/*  61 */         GmItemVO vo = new GmItemVO(it.itemDb.id, it.prop.code, it.prop.name, it.itemDb.groupCount, isEquip ? "是" : "否");
/*  62 */         if (isEquip) {
/*  63 */           initEquipAttr(vo, it.itemDb);
/*     */         }
/*  65 */         items.add(vo);
/*     */       } 
/*  67 */       data.put("total", Integer.valueOf(items.size()));
/*  68 */       data.put("rows", items);
/*  69 */     } else if (type == 1) {
/*  70 */       PlayerBasePO basePo = player.playerBasePO;
/*  71 */       List<GmItemVO> items = new ArrayList<>();
/*  72 */       for (Map.Entry<Integer, PlayerItemPO> entry : (Iterable<Map.Entry<Integer, PlayerItemPO>>)basePo.equipGrids.entrySet()) {
/*  73 */         PlayerItemPO it = entry.getValue();
/*  74 */         DItemEquipBase tm = ItemConfig.getInstance().getItemProp(it.code);
/*  75 */         GmItemVO vo = new GmItemVO(it.id, it.code, tm.name, it.groupCount, "");
/*  76 */         vo.setLevel(((PlayerBasePO.EquipStrengthPos)basePo.strengthPos.get(entry.getKey())).enSection + "段" + ((PlayerBasePO.EquipStrengthPos)basePo.strengthPos.get(entry.getKey())).enLevel + "级");
/*     */         
/*  78 */         StringBuilder sb = new StringBuilder();
/*     */         
/*  80 */         for (String code : ((PlayerBasePO.EquipStrengthPos)basePo.strengthPos.get(entry.getKey())).gems.values()) {
/*  81 */           DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
/*  82 */           sb.append(prop.name + "：" + prop.prop + "+" + prop.max);
/*  83 */           sb.append("<br />");
/*     */         } 
/*  85 */         vo.setGemAttr(sb.toString());
/*  86 */         initEquipAttr(vo, it);
/*  87 */         items.add(vo);
/*     */       } 
/*  89 */       data.put("total", Integer.valueOf(items.size()));
/*  90 */       data.put("rows", items);
/*  91 */     } else if (type == 2) {
/*  92 */       List<GmItemVO> items = new ArrayList<>();
/*  93 */       for (NormalItem it : player.wareHouse.bagGrids.values()) {
/*  94 */         if (it == null) {
/*     */           continue;
/*     */         }
/*  97 */         boolean isEquip = ItemUtil.isEquipByItemType(it.prop.itemType);
/*  98 */         GmItemVO vo = new GmItemVO(it.itemDb.id, it.prop.code, it.prop.name, it.itemDb.groupCount, isEquip ? "是" : "否");
/*  99 */         if (isEquip) {
/* 100 */           initEquipAttr(vo, it.itemDb);
/*     */         }
/* 102 */         items.add(vo);
/*     */       } 
/* 104 */       data.put("total", Integer.valueOf(items.size()));
/* 105 */       data.put("rows", items);
/*     */     } 
/*     */     
/* 108 */     JSONObject jo = new JSONObject(data);
/* 109 */     return (GMResponse)new GMJsonResponse(jo);
/*     */   }
/*     */   
/*     */   private void initEquipAttr(GmItemVO vo, PlayerItemPO it) {
/* 113 */     DEquipBase prop = ItemConfig.getInstance().getEquipProp(it.code);
/*     */     
/* 115 */     StringBuilder sb = new StringBuilder();
/* 116 */     for (String key : it.speData.baseAtts.keySet()) {
/* 117 */       sb.append(AttributeUtil.getNameByKey(key));
/* 118 */       sb.append("+" + it.speData.baseAtts.get(key));
/* 119 */       sb.append("<br />");
/*     */     } 
/* 121 */     vo.setBaseAttr(sb.toString());
/*     */     
/* 123 */     sb = new StringBuilder();
/* 124 */     if (it.speData.extAtts == null) {
/* 125 */       for (String key : prop.fixedAtts.keySet()) {
/* 126 */         sb.append(AttributeUtil.getNameByKey(key));
/* 127 */         sb.append("+" + prop.fixedAtts.get(key));
/* 128 */         sb.append("<br />");
/*     */       } 
/*     */     } else {
/* 131 */       for (RepeatKeyMap.Pair<Integer, Integer> rp : (Iterable<RepeatKeyMap.Pair<Integer, Integer>>)it.speData.extAtts.entrySet()) {
/* 132 */         AffixExt affix = (AffixExt)GameData.Affixs.get(rp.k);
/* 133 */         if (affix == null) {
/* 134 */           Out.warn(new Object[] { "key=" + rp.k + " val=" + rp.v });
/*     */           continue;
/*     */         } 
/* 137 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(prop.qcolor));
/* 138 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 141 */         sb.append(AttributeUtil.getNameByKey(pair.prop));
/* 142 */         sb.append("+" + rp.v);
/* 143 */         sb.append("<br />");
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     vo.setExtAttr(sb.toString());
/*     */     
/* 149 */     if (it.speData.legendAtts != null) {
/* 150 */       sb = new StringBuilder();
/* 151 */       for (Iterator<Integer> iterator = it.speData.legendAtts.keySet().iterator(); iterator.hasNext(); ) { int affixId = ((Integer)iterator.next()).intValue();
/* 152 */         AffixExt affix = (AffixExt)GameData.Affixs.get(Integer.valueOf(affixId));
/* 153 */         if (affix == null) {
/*     */           continue;
/*     */         }
/* 156 */         FourProp pair = (FourProp)affix.props.get(Integer.valueOf(prop.qcolor));
/* 157 */         if (pair == null) {
/*     */           continue;
/*     */         }
/* 160 */         sb.append(AttributeUtil.getNameByKey(pair.prop));
/* 161 */         sb.append("+" + it.speData.legendAtts.get(Integer.valueOf(affixId))); }
/*     */       
/* 163 */       vo.setLegendAttr(sb.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public short getType() {
/* 168 */     return 12321;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\QueryBagItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */