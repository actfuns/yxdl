/*    */ package com.wanniu.game.request.fightLevel.resourcedungeon;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.RechargeCostCO;
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
/*    */ @GClientEvent("area.resourceDungeonHandler.buyTimesRequest")
/*    */ public class BuyTimesHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 29 */     ResourceDungeonHandler.BuyTimesRequest req = ResourceDungeonHandler.BuyTimesRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     final int dungeonId = req.getDungeonId();
/*    */     
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           ResourceDungeonHandler.BuyTimesResponse.Builder res = ResourceDungeonHandler.BuyTimesResponse.newBuilder();
/* 37 */           FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/* 38 */           FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO)fightLevelsPO.resourceDungeon.get(Integer.valueOf(dungeonId));
/* 39 */           if (resourceDungeon == null) {
/* 40 */             resourceDungeon = new FightLevelsPO.ResourceDungeonPO();
/* 41 */             fightLevelsPO.resourceDungeon.put(Integer.valueOf(dungeonId), resourceDungeon);
/*    */           } 
/*    */ 
/*    */           
/* 45 */           RechargeCostCO config = (RechargeCostCO)GameData.RechargeCosts.get(Integer.valueOf(resourceDungeon.buyTimes + 1));
/* 46 */           if (config == null) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("SOLO_BUY_TIMES_LIMIT"));
/* 49 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 54 */           if (!player.moneyManager.costTicketAndDiamond(config.costNum, Const.GOODS_CHANGE_TYPE.resource_dungeon_buy_times).isSuccess()) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("TICKET_NOT_ENOUGH"));
/* 57 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 62 */           resourceDungeon.buyTimes++;
/*    */           
/* 64 */           res.setS2CCode(200);
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\resourcedungeon\BuyTimesHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */