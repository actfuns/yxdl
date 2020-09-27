/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.BloodListCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.MeltConfigCO;
/*     */ import com.wanniu.game.data.QuestCO;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.ItemSpeData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import pomelo.area.EquipHandler;
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
/*     */ @GClientEvent("area.equipHandler.equipMeltRequest")
/*     */ public class EquipMeltHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  49 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  50 */     final WNBag wnBag = player.getWnBag();
/*     */     
/*  52 */     EquipHandler.EquipMeltRequest req = EquipHandler.EquipMeltRequest.parseFrom(this.pak.getRemaingBytes());
/*  53 */     final List<Integer> indexs = new ArrayList<>(new HashSet<>(req.getC2SIndexsList()));
/*     */     
/*  55 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  58 */           EquipHandler.EquipMeltResponse.Builder res = EquipHandler.EquipMeltResponse.newBuilder();
/*     */           
/*  60 */           if (indexs.size() == 0) {
/*  61 */             res.setS2CCode(500);
/*  62 */             res.setS2CMsg(LangService.getValue("MELT_NOTHING"));
/*  63 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  67 */           int totalGold = 0;
/*  68 */           List<Object[]> tcCodes = new ArrayList();
/*     */           
/*  70 */           for (int i = 0; i < indexs.size(); i++) {
/*  71 */             NormalItem item = wnBag.getItem(((Integer)indexs.get(i)).intValue());
/*  72 */             if (item == null || (!item.isEquip() && !item.isBlood())) {
/*  73 */               res.setS2CCode(500);
/*  74 */               res.setS2CMsg(LangService.getValue("PARAM_INVALID"));
/*  75 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*  79 */             if (item.isEquip()) {
/*  80 */               NormalEquip equip = (NormalEquip)item;
/*  81 */               if (equip.prop.noMelt == 1) {
/*  82 */                 res.setS2CCode(500);
/*  83 */                 res.setS2CMsg(LangService.getValue("CAN_NOT_MELT"));
/*  84 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 
/*     */                 return;
/*     */               } 
/*  88 */               MeltConfigCO prop = ItemUtil.getMeltProp(equip.prop.meltLevel, equip.getQColor());
/*  89 */               if (prop == null) {
/*  90 */                 res.setS2CCode(500);
/*  91 */                 res.setS2CMsg(LangService.getValue("PARAM_INVALID"));
/*  92 */                 this.body.writeBytes(res.build().toByteArray());
/*     */                 return;
/*     */               } 
/*  95 */               totalGold += prop.costGold;
/*  96 */               tcCodes.add(new Object[] { prop.tcCode, Boolean.valueOf(equip.isBinding()) });
/*     */ 
/*     */               
/*  99 */               if (equip.getQColor() >= Const.ItemQuality.ORANGE.getValue()) {
/* 100 */                 ItemSpeData speData = equip.itemDb.speData;
/* 101 */                 StringBuffer sb = new StringBuffer();
/* 102 */                 if (speData != null) {
/* 103 */                   sb.append(speData.baseAtts.toString());
/* 104 */                   if (speData.extAtts != null) {
/* 105 */                     sb.append("|||").append(speData.extAtts.toString());
/*     */                   }
/* 107 */                   if (speData.legendAtts != null) {
/* 108 */                     sb.append("|||").append(speData.legendAtts.toString());
/*     */                   }
/*     */                 } 
/* 111 */                 PlayerUtil.bi(getClass(), Const.BiLogType.Smelt, player, new Object[] { equip.itemDb.code, equip.itemDb.id, sb.toString() });
/*     */               } 
/* 113 */             } else if (item.isBlood()) {
/* 114 */               BloodListCO bloodListCO = (BloodListCO)GameData.BloodLists.get(Integer.valueOf(((QuestCO)GameData.Quests.get(item.itemCode())).min));
/* 115 */               tcCodes.add(new Object[] { bloodListCO.melting, Boolean.valueOf(false) });
/*     */             } 
/*     */           } 
/*     */           
/* 119 */           List<NormalItem> tcItems = new ArrayList<>();
/* 120 */           for (Object[] v : tcCodes) {
/* 121 */             List<NormalItem> items = ItemUtil.createItemsByTcCode((String)v[0]);
/* 122 */             for (NormalItem item : items) {
/* 123 */               if (item.isEquip()) {
/* 124 */                 Const.ForceType forceType = ((Boolean)v[1]).booleanValue() ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
/* 125 */                 int bindType = ItemUtil.getPropBindType(item.prop, forceType);
/* 126 */                 item.setBind(bindType);
/*     */               } 
/* 128 */               tcItems.add(item);
/*     */             } 
/*     */           } 
/*     */           
/* 132 */           List<NormalItem> addItems = ItemUtil.getPackUpItems(tcItems);
/*     */           
/* 134 */           int len = ItemUtil.getPackUpItemsNum(addItems) - indexs.size();
/* 135 */           if (len < 0) {
/* 136 */             len = 0;
/*     */           }
/*     */           
/* 139 */           if (!player.moneyManager.costGold(totalGold, Const.GOODS_CHANGE_TYPE.melt)) {
/* 140 */             res.setS2CCode(500);
/* 141 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 142 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/* 146 */           for (int j = 0; j < indexs.size(); j++) {
/* 147 */             wnBag.discardItemByPos(((Integer)indexs.get(j)).intValue(), 1, false, Const.GOODS_CHANGE_TYPE.melt);
/*     */           }
/*     */           
/* 150 */           List<PlayerItemPO> notAddItems = new ArrayList<>();
/* 151 */           List<ItemOuterClass.MiniItem> showItems = new ArrayList<>();
/* 152 */           int getExp = 0;
/* 153 */           for (int k = 0; k < addItems.size(); k++) {
/* 154 */             NormalItem addItem = addItems.get(k);
/* 155 */             if (addItem.itemDb.code.equals("exp")) {
/* 156 */               getExp += addItem.getWorth();
/* 157 */             } else if (!addItem.itemDb.code.equals("gold")) {
/*     */ 
/*     */               
/* 160 */               ItemOuterClass.MiniItem.Builder item = ItemUtil.getMiniItemData(addItem.itemDb.code, addItem.itemDb.groupCount);
/* 161 */               if (item != null) {
/* 162 */                 showItems.add(item.build());
/*     */               }
/*     */             } 
/*     */             
/* 166 */             if (wnBag.testAddEntityItem(addItems.get(k), true)) {
/* 167 */               wnBag.addEntityItem(addItems.get(k), Const.GOODS_CHANGE_TYPE.melt, null, false, true);
/*     */             } else {
/* 169 */               notAddItems.add(addItem.itemDb);
/*     */             } 
/*     */           } 
/* 172 */           if (notAddItems.size() > 0) {
/* 173 */             MailSysData mailSysData = new MailSysData("Bag_full_melting");
/* 174 */             ((MailData)mailSysData).entityItems = notAddItems;
/* 175 */             MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailSysData, Const.GOODS_CHANGE_TYPE.melt);
/* 176 */             player.sendSysTip(LangService.getValue("BAG_FULL_SMELTING_CHEST"), Const.TipsType.BLACK);
/*     */           } 
/*     */           
/* 179 */           player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_MELT, 1);
/*     */ 
/*     */           
/* 182 */           BILogService.getInstance().ansycReportMeltCultivate(player.getPlayer(), addItems);
/*     */           
/* 184 */           res.setS2CCode(200);
/* 185 */           res.setS2CExp(getExp);
/* 186 */           res.addAllS2CItem(showItems);
/*     */           
/* 188 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipMeltHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */