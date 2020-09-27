/*     */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.DungeonMapCostCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ResRewardCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FightLevelsPO;
/*     */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.ResourceDungeonHandler;
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
/*     */ @GClientEvent("area.resourceDungeonHandler.resourceSweepRequest")
/*     */ public class ResourceSweepHandler
/*     */   extends FightLevelLine
/*     */ {
/*     */   public PomeloResponse request(final WNPlayer player) throws Exception {
/*  39 */     ResourceDungeonHandler.ResourceSweepRequest req = ResourceDungeonHandler.ResourceSweepRequest.parseFrom(this.pak.getRemaingBytes());
/*  40 */     final int dungeonId = req.getDungeonId();
/*  41 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  44 */           ResourceDungeonHandler.ResourceSweepResponse.Builder res = ResourceDungeonHandler.ResourceSweepResponse.newBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  53 */           MapBase mapProp = AreaDataConfig.getInstance().get(dungeonId);
/*  54 */           FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/*  55 */           FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO)fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));
/*  56 */           if (resourceDungeon == null) {
/*  57 */             resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
/*  58 */             fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
/*     */           } 
/*     */ 
/*     */           
/*  62 */           if (resourceDungeon.usedTimes < 1) {
/*  63 */             res.setS2CCode(500);
/*  64 */             res.setS2CMsg(LangService.getValue("SOLO_USE_SWEEP_BY_ONE"));
/*  65 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  69 */           if (resourceDungeon.usedTimes >= mapProp.defaultTimes + resourceDungeon.buyTimes) {
/*  70 */             res.setS2CCode(500);
/*  71 */             res.setS2CMsg(LangService.getValue("SOLO_ENTER_TIMES_LIMIT"));
/*  72 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  77 */           ResRewardCO config = (ResRewardCO)GameData.ResRewards.get(Integer.valueOf(player.getLevel()));
/*  78 */           if (config == null) {
/*  79 */             res.setS2CCode(500);
/*  80 */             res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
/*  81 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  86 */           resourceDungeon.usedTimes++;
/*     */ 
/*     */           
/*  89 */           DungeonMapCostCO dungeonMapCostCO = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
/*  90 */           int difficult = mapProp.hardModel;
/*  91 */           String saodangReward = null;
/*     */           try {
/*  93 */             Object saodangRewardObj = ResRewardCO.class.getField("saodangReward" + String.valueOf(dungeonMapCostCO.playType) + String.valueOf(difficult)).get(config);
/*  94 */             saodangReward = String.valueOf(saodangRewardObj);
/*     */           }
/*  96 */           catch (Exception e) {
/*  97 */             e.printStackTrace();
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */           
/* 104 */           if (saodangReward.isEmpty()) {
/* 105 */             System.out.println("empty::::::::::::::::::::::::::::::::::::::::::::;");
/* 106 */             Out.error(new Object[] { "资源副本扫荡奖励未配置 playerId=", this.val$player.getId(), ",Name=", this.val$player.getName(), ",dungeonId=", 
/* 107 */                   Integer.valueOf(this.val$dungeonId) });
/*     */           } else {
/* 109 */             System.out.println(saodangReward + ":::::::::code:::::::::::::::::::::::::::::::::::::::::::::::::::");
/*     */             
/* 111 */             List<NormalItem> list_items = new ArrayList<>();
/*     */             
/* 113 */             switch (dungeonMapCostCO.playType) {
/*     */               case 1:
/* 115 */                 switch (difficult) {
/*     */                   case 1:
/* 117 */                     list_items = ItemUtil.createItemsByTcCode("JxBx-SD1");
/*     */                     break;
/*     */                   case 2:
/* 120 */                     list_items = ItemUtil.createItemsByTcCode("JxBx-SD2");
/*     */                     break;
/*     */                   case 3:
/* 123 */                     list_items = ItemUtil.createItemsByTcCode("JxBx-SD3");
/*     */                     break;
/*     */                 } 
/*     */                 
/*     */                 break;
/*     */               
/*     */               case 2:
/* 130 */                 switch (difficult) {
/*     */                   case 1:
/* 132 */                     list_items = ItemUtil.createItemsByTcCode("ScBx-SD1");
/*     */                     break;
/*     */                   case 2:
/* 135 */                     list_items = ItemUtil.createItemsByTcCode("ScBx-SD2");
/*     */                     break;
/*     */                   case 3:
/* 138 */                     list_items = ItemUtil.createItemsByTcCode("ScBx-SD3");
/*     */                     break;
/*     */                 } 
/*     */                 
/*     */                 break;
/*     */               
/*     */               case 3:
/* 145 */                 switch (difficult) {
/*     */                   case 1:
/* 147 */                     list_items = ItemUtil.createItemsByTcCode("HyBx-SD1");
/*     */                     break;
/*     */                   case 2:
/* 150 */                     list_items = ItemUtil.createItemsByTcCode("HyBx-SD2");
/*     */                     break;
/*     */                   case 3:
/* 153 */                     list_items = ItemUtil.createItemsByTcCode("HyBx-SD3");
/*     */                     break;
/*     */                 } 
/*     */ 
/*     */ 
/*     */                 
/*     */                 break;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 164 */             System.out.println(list_items + ":::::::::::::::::::::::::list_items:::::::::::::::::::::::::::::::::::");
/* 165 */             player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.resource_dungeon_sweep, "Bag_full_common");
/*     */             
/* 167 */             System.out.println(":::::::::::::::::::::::::接发给:::::::::::::::::::::::::::::::::::");
/*     */             
/* 169 */             List<ItemOuterClass.MiniItem> list_award = new ArrayList<>();
/* 170 */             System.out.println();
/* 171 */             for (NormalItem item : list_items) {
/* 172 */               System.out.println("::::::::::::::::::item:::::::::::::::::::::::::::::::");
/* 173 */               list_award.add(item.toJSON4MiniItem());
/*     */             } 
/*     */             
/* 176 */             res.addAllAwardItems(list_award);
/*     */           } 
/* 178 */           res.setS2CCode(200);
/* 179 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\ResourceSweepHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */