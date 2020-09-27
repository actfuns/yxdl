/*    */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.AreaDataConfig;
/*    */ import com.wanniu.game.data.DungeonMapCostCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.FightLevelsPO;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.ResourceDungeonHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.resourceDungeonHandler.queryResourceDugeonInfoRequest")
/*    */ public class QueryResourceDugeonInfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           ResourceDungeonHandler.QueryResourceDugeonInfoResponse.Builder res = ResourceDungeonHandler.QueryResourceDugeonInfoResponse.newBuilder();
/*    */           
/* 43 */           FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/* 44 */           List<ResourceDungeonHandler.ResourceDungeonInfo> list = new ArrayList<>();
/* 45 */           for (DungeonMapCostCO config : GameData.DungeonMapCosts.values()) {
/* 46 */             MapBase mapProp = AreaDataConfig.getInstance().get(config.mapID);
/*    */             
/* 48 */             FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO)fightLevelsPO.resourceDungeon.get(Integer.valueOf(config.mapID));
/*    */             
/* 50 */             if (resourceDungeon == null) {
/* 51 */               resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
/* 52 */               fightLevelsPO.resourceDungeon.put(Integer.valueOf(config.mapID), resourceDungeon);
/*    */             } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 60 */             ResourceDungeonHandler.ResourceDungeonInfo.Builder info = ResourceDungeonHandler.ResourceDungeonInfo.newBuilder();
/* 61 */             info.setDungeonId(config.mapID);
/* 62 */             info.setLastTimes(mapProp.defaultTimes - resourceDungeon.usedTimes + resourceDungeon.buyTimes);
/* 63 */             info.setBuyTimes(resourceDungeon.buyTimes);
/* 64 */             info.setCanBuyTimes(GameData.RechargeCosts.size() - resourceDungeon.buyTimes);
/* 65 */             info.setCanSweep((resourceDungeon.usedTimes > 0));
/* 66 */             info.setAwardItems(config.showReward);
/* 67 */             info.setPlayType(config.playType);
/* 68 */             info.setEnterLevel(config.enterLevel);
/* 69 */             list.add(info.build());
/*    */           } 
/*    */           
/* 72 */           res.addAllDungeons(list);
/* 73 */           res.setS2CCode(200);
/* 74 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\QueryResourceDugeonInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */