/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
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
/*    */ @GClientEvent("area.fightLevelHandler.addProfitRequest")
/*    */ public class AddProfitHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 25 */     FightLevelHandler.AddProfitRequest request = FightLevelHandler.AddProfitRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     int mapId = request.getMapId();
/*    */ 
/*    */     
/* 29 */     if (!player.bag.discardItem(Const.ITEM_CODE.DUNGEONPROFIT.value, 1, Const.GOODS_CHANGE_TYPE.use)) {
/* 30 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
/*    */     }
/*    */ 
/*    */     
/* 34 */     player.fightLevelManager.addPrifit(mapId);
/*    */     
/* 36 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 39 */           FightLevelHandler.AddProfitResponse.Builder res = FightLevelHandler.AddProfitResponse.newBuilder();
/* 40 */           res.setS2CCode(200);
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\AddProfitHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */