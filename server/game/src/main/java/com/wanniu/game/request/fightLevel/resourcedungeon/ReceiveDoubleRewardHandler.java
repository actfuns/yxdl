/*     */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.DungeonMapCostCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FightLevelsPO;
/*     */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.ResourceDungeonHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.resourceDungeonHandler.receiveDoubleRewardRequest")
/*     */ public class ReceiveDoubleRewardHandler
/*     */   extends FightLevelLine
/*     */ {
/*     */   public PomeloResponse request(final WNPlayer player) throws Exception {
/*  32 */     ResourceDungeonHandler.ReceiveDoubleRewardRequest req = ResourceDungeonHandler.ReceiveDoubleRewardRequest.parseFrom(this.pak.getRemaingBytes());
/*     */     
/*  34 */     final int dungeonId = req.getDungeonId();
/*     */     
/*  36 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  39 */           ResourceDungeonHandler.ReceiveDoubleRewardResponse.Builder res = ResourceDungeonHandler.ReceiveDoubleRewardResponse.newBuilder();
/*     */ 
/*     */ 
/*     */           
/*  43 */           DungeonMapCostCO config = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
/*  44 */           FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  49 */           if (config.isDoubleBonus == 0) {
/*  50 */             res.setS2CCode(500);
/*  51 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  52 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  57 */           if (fightLevelsPO.doubleReward == null) {
/*  58 */             res.setS2CCode(500);
/*  59 */             res.setS2CMsg(LangService.getValue("DUNGEON_NOT_DOUBLE_REWARD"));
/*  60 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  64 */           if (player.player.diamond < config.bounsCostDiamond) {
/*  65 */             res.setS2CCode(500);
/*  66 */             res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
/*  67 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  72 */           List<Common.KeyValueStruct> changeItems = new ArrayList<>();
/*     */ 
/*     */           
/*  75 */           if (fightLevelsPO.doubleReward.doubleVirtualItems != null) {
/*  76 */             for (String key : fightLevelsPO.doubleReward.doubleVirtualItems.keySet()) {
/*  77 */               int value = ((Integer)fightLevelsPO.doubleReward.doubleVirtualItems.get(key)).intValue();
/*  78 */               Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
/*  79 */               items.setKey(key);
/*  80 */               items.setValue(String.valueOf(value));
/*  81 */               changeItems.add(items.build());
/*     */               
/*  83 */               if (key.equals("exp")) {
/*  84 */                 player.addExp(value, Const.GOODS_CHANGE_TYPE.resource_dungeon_award); continue;
/*  85 */               }  if (key.equals("gold")) {
/*  86 */                 player.moneyManager.addGold(value, Const.GOODS_CHANGE_TYPE.resource_dungeon_award);
/*     */               }
/*     */             } 
/*     */           }
/*  90 */           if (fightLevelsPO.doubleReward.doubleItems != null && fightLevelsPO.doubleReward.doubleItems
/*  91 */             .size() > 0) {
/*  92 */             for (PlayerItemPO it : fightLevelsPO.doubleReward.doubleItems) {
/*  93 */               Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
/*  94 */               items.setKey(it.code);
/*  95 */               items.setValue(String.valueOf(it.groupCount));
/*  96 */               changeItems.add(items.build());
/*     */             } 
/*  98 */             player.bag.addEntityItemsPO(fightLevelsPO.doubleReward.doubleItems, Const.GOODS_CHANGE_TYPE.resource_dungeon_award);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 103 */           player.moneyManager.costDiamond(config.bounsCostDiamond, Const.GOODS_CHANGE_TYPE.resource_dungeon_cost_diamond, changeItems);
/*     */ 
/*     */ 
/*     */           
/* 107 */           fightLevelsPO.doubleReward = null;
/*     */           
/* 109 */           res.setS2CCode(200);
/* 110 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\ReceiveDoubleRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */