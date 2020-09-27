/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ import pomelo.item.ItemOuterClass;
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
/*    */ @GClientEvent("area.fightLevelHandler.getMonsterLeaderRequest")
/*    */ public class GetMonsterLeaderHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 25 */     FightLevelHandler.GetMonsterLeaderRequest req = FightLevelHandler.GetMonsterLeaderRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final int monsterId = req.getS2CMonsterId();
/* 27 */     final int areaId = req.getS2CAreaId();
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           FightLevelHandler.GetMonsterLeaderResponse.Builder res = FightLevelHandler.GetMonsterLeaderResponse.newBuilder();
/*    */           
/* 34 */           GetMonsterLeaderHandler.GetMonsterLeaderData data = player.fightLevelManager.getMonsterLeader(player, monsterId, areaId);
/* 35 */           res.setS2CCode(200);
/* 36 */           res.addAllS2CDropItems(data.dropItems);
/* 37 */           res.setS2CReqLevel(data.reqLevel);
/* 38 */           res.setS2CReqUpLevel(data.reqUpLevel);
/* 39 */           res.setS2CRefreshPoint(data.refreshPoint);
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public static class GetMonsterLeaderData
/*    */   {
/*    */     public List<ItemOuterClass.MiniItem> dropItems;
/*    */     public int reqLevel;
/*    */     public int reqUpLevel;
/*    */     public String refreshPoint;
/*    */     
/*    */     public GetMonsterLeaderData(List<ItemOuterClass.MiniItem> dropItems, int reqLevel, int reqUpLevel, String refreshPoint) {
/* 53 */       this.dropItems = dropItems;
/* 54 */       this.reqLevel = reqLevel;
/* 55 */       this.reqUpLevel = reqUpLevel;
/* 56 */       this.refreshPoint = refreshPoint;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\GetMonsterLeaderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */