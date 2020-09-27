/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.DungeonMapCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.fightLevel.FightLevelManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import pomelo.area.FightLevelHandler;
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
/*    */ @GClientEvent("area.fightLevelHandler.fubenListRequest")
/*    */ public class FubenListHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 33 */     FightLevelHandler.FubenListRequest req = FightLevelHandler.FubenListRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     int mapId = req.getMapId();
/* 35 */     final int mapType = req.getType();
/* 36 */     final DungeonMapCO map = (DungeonMapCO)GameData.DungeonMaps.get(Integer.valueOf(mapId));
/* 37 */     if (map == null) {
/* 38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DUNGEON_NULL"));
/*    */     }
/*    */     
/* 41 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 44 */           FightLevelHandler.FubenListResponse.Builder res = FightLevelHandler.FubenListResponse.newBuilder();
/*    */           
/* 46 */           FightLevelManager fightLevelManager = player.fightLevelManager;
/* 47 */           List<DungeonMapCO> dungeonMaps = GameData.findDungeonMaps(t -> 
/* 48 */               (t.templateID == map.templateID && t.dungeonShow == 1 && t.type == mapType));
/*    */           
/* 50 */           Collections.sort(dungeonMaps, new Comparator<DungeonMapCO>()
/*    */               {
/*    */                 public int compare(DungeonMapCO o1, DungeonMapCO o2) {
/* 53 */                   return o1.hardModel - o2.hardModel;
/*    */                 }
/*    */               });
/* 56 */           dungeonMaps.forEach(t -> {
/*    */                 FightLevelHandler.FubenInfo.Builder dungeonInfo = FightLevelHandler.FubenInfo.newBuilder();
/*    */                 
/*    */                 dungeonInfo.setMapId(t.mapID);
/*    */                 
/*    */                 dungeonInfo.setRemainTimes((player.getLevel() >= t.reqLevel + 30) ? 0 : Math.max(0, 3 + fightLevelManager.getTodayBuy(t.templateID) - fightLevelManager.getTodayFinish(t.templateID)));
/*    */                 
/*    */                 dungeonInfo.addAllAwardItems(fightLevelManager.getDropItems(t.bonusViewTC));
/*    */                 
/*    */                 res.addS2CList(dungeonInfo);
/*    */               });
/* 67 */           res.setS2CHard(0);
/* 68 */           res.setS2CAcross(0);
/* 69 */           res.setS2CCode(200);
/* 70 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\FubenListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */