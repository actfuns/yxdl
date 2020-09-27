/*    */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.area.AreaDataConfig;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.data.DungeonMapCostCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.base.MapBase;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.FightLevelsPO;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
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
/*    */ @GClientEvent("area.resourceDungeonHandler.enterResourceDugeonInfoRequest")
/*    */ public class EnterResourceDugeonInfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 32 */     ResourceDungeonHandler.EnterResourceDugeonInfoRequest req = ResourceDungeonHandler.EnterResourceDugeonInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 34 */     final int dungeonId = req.getDungeonId();
/*    */     
/* 36 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 39 */           ResourceDungeonHandler.EnterResourceDugeonInfoResponse.Builder res = ResourceDungeonHandler.EnterResourceDugeonInfoResponse.newBuilder();
/*    */           
/* 41 */           FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/*    */           
/* 43 */           fightLevelsPO.doubleReward = null;
/*    */           
/* 45 */           MapBase mapProp = AreaDataConfig.getInstance().get(dungeonId);
/*    */           
/* 47 */           FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO)fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));
/*    */           
/* 49 */           if (resourceDungeon == null) {
/* 50 */             resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
/* 51 */             fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
/*    */           } 
/*    */           
/* 54 */           if (resourceDungeon.usedTimes >= mapProp.defaultTimes + resourceDungeon.buyTimes) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("SOLO_ENTER_TIMES_LIMIT"));
/* 57 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 61 */           DungeonMapCostCO dungeonMapCostCO = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(dungeonId));
/* 62 */           if (player.getLevel() < dungeonMapCostCO.enterLevel) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("RESOURCE_DUNGEON_LEVEL_NEED"));
/* 65 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 68 */           resourceDungeon.entering = true;
/*    */           
/* 70 */           GWorld.getInstance().ansycExec(() -> AreaUtil.enterArea(player, dungeonId));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 77 */           res.setS2CCode(200);
/* 78 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\EnterResourceDugeonInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */