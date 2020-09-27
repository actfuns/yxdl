/*     */ package com.wanniu.game.request.item;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.CombineTypeCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.DItemBase;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.ext.CombineExt;
/*     */ import com.wanniu.game.equip.EquipCraftConfig;
/*     */ import com.wanniu.game.equip.EquipCraftUtil;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.po.DetailItemNum;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.ItemHandler;
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
/*     */ @GClientEvent("area.itemHandler.combineRequest")
/*     */ public class CombineHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  42 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  43 */     final WNBag bag = player.getWnBag();
/*     */     
/*  45 */     ItemHandler.CombineRequest req = ItemHandler.CombineRequest.parseFrom(this.pak.getRemaingBytes());
/*  46 */     final int destId = req.getC2SDestID();
/*  47 */     final int num = req.getC2SNum();
/*     */ 
/*     */     
/*  50 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  53 */           ItemHandler.CombineResponse.Builder res = ItemHandler.CombineResponse.newBuilder();
/*     */           
/*  55 */           CombineExt prop = EquipCraftConfig.getInstance().getCombineProp(destId);
/*  56 */           if (prop == null) {
/*  57 */             res.setS2CCode(500);
/*  58 */             res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
/*  59 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  64 */           DItemBase productProp = ItemUtil.getUnEquipPropByCode(prop.destCode);
/*  65 */           if (productProp == null) {
/*  66 */             res.setS2CCode(500);
/*  67 */             res.setS2CMsg(LangService.getValue("ITEM_NOT_COMBINE"));
/*  68 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  72 */           Map<String, List<Integer>> destCounts = new HashMap<>();
/*  73 */           destCounts.put("bind", new ArrayList<>());
/*  74 */           destCounts.put("unBind", new ArrayList<>());
/*     */           
/*  76 */           for (int i = 0; i < prop.material.size(); i++) {
/*  77 */             WNBag.SimpleItemInfo itemInfo = prop.material.get(i);
/*  78 */             DetailItemNum countInfo = bag.findDetailItemNumByCode(itemInfo.itemCode);
/*  79 */             double maxNum = Math.floor((countInfo.totalNum / itemInfo.itemNum));
/*  80 */             if (maxNum < num) {
/*  81 */               res.setS2CCode(500);
/*  82 */               res.setS2CMsg(LangService.getValue("ITEM_COMBINE_NOT_ENOUGH"));
/*  83 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  86 */             int unBindNum = 0;
/*  87 */             int bindNum = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  95 */             int bindMax = (int)Math.floor((countInfo.bindNum / itemInfo.itemNum));
/*  96 */             int leftCount = countInfo.bindNum % itemInfo.itemNum;
/*  97 */             if (leftCount > 0 && leftCount + countInfo.unBindNum > itemInfo.itemNum) {
/*  98 */               bindMax++;
/*     */             }
/* 100 */             bindNum = Math.min(bindMax, num);
/* 101 */             unBindNum = Math.max(num - bindNum, 0);
/*     */             
/* 103 */             if (bindNum > 0) {
/* 104 */               ((List<Integer>)destCounts.get("bind")).add(Integer.valueOf(bindNum));
/*     */             }
/* 106 */             if (unBindNum > 0) {
/* 107 */               ((List<Integer>)destCounts.get("unBind")).add(Integer.valueOf(unBindNum));
/*     */             }
/*     */           } 
/*     */           
/* 111 */           List<WNBag.SimpleItemInfo> destItems = new ArrayList<>();
/* 112 */           for (String key : destCounts.keySet()) {
/* 113 */             int destCount = 0;
/* 114 */             List<Integer> list_binds = destCounts.get(key);
/* 115 */             if (list_binds.size() > 0) {
/* 116 */               destCount = ((Integer)Collections.<Integer>min(list_binds)).intValue();
/*     */             }
/*     */             
/* 119 */             if (destCount > 0) {
/* 120 */               WNBag.SimpleItemInfo itemInfo = new WNBag.SimpleItemInfo();
/* 121 */               itemInfo.itemCode = prop.destCode;
/* 122 */               itemInfo.itemNum = destCount;
/* 123 */               itemInfo.forceType = key.equals("bind") ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
/* 124 */               destItems.add(itemInfo);
/*     */             } 
/*     */           } 
/* 127 */           if (!bag.testAddCodeItems(destItems)) {
/* 128 */             res.setS2CCode(500);
/* 129 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 130 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/* 134 */           for (int j = 0; j < prop.material.size(); j++) {
/* 135 */             WNBag.SimpleItemInfo v = prop.material.get(j);
/* 136 */             int totalNeed = v.itemNum * num;
/*     */             
/* 138 */             int leftCost = totalNeed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 144 */             if (leftCost > 0) {
/* 145 */               bag.discardItem(v.itemCode, leftCost, Const.GOODS_CHANGE_TYPE.compound, null, false, false);
/*     */             }
/*     */           } 
/* 148 */           bag.addCodeItems(destItems, Const.GOODS_CHANGE_TYPE.compound);
/*     */           
/* 150 */           player.taskManager.dealTaskEvent(Const.TaskType.COMBINE_GEM, prop.destCode, num);
/*     */ 
/*     */           
/* 153 */           if (productProp.itemSecondType == Const.ItemSecondType.gem.getValue()) {
/* 154 */             player.achievementManager.onGemCombine(prop.destCode, num);
/*     */           }
/* 156 */           List<CombineTypeCO> combineTypeProps = GameData.findCombineTypes(t -> t.tagetCode.equals(prop.destCode));
/*     */ 
/*     */           
/* 159 */           CombineTypeCO combineTypeProp = null;
/* 160 */           if (combineTypeProps.size() > 0) {
/* 161 */             combineTypeProp = combineTypeProps.get(0);
/* 162 */             CombineTypeCO combineIdProp = (CombineTypeCO)GameData.CombineTypes.get(Integer.valueOf(combineTypeProp.parentID));
/* 163 */             if (combineIdProp != null);
/*     */           } 
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
/* 183 */           if (prop.isNotice != 0) {
/* 184 */             EquipCraftUtil.sendEquipCombineMsg(player, (DItemEquipBase)productProp);
/*     */           }
/*     */           
/* 187 */           player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.GEM_COMBINE_COUNT, new Object[] { Integer.valueOf(productProp.levelReq), Integer.valueOf(this.val$num) });
/* 188 */           res.setS2CCode(200);
/* 189 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\item\CombineHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */