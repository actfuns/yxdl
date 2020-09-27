/*    */ package com.wanniu.game.request.interact;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.InteractionCO;
/*    */ import com.wanniu.game.interact.PlayerInteract;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.interactHandler.interactRequest")
/*    */ public class InteractHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     pomelo.area.InteractHandler.InteractRequest msg = pomelo.area.InteractHandler.InteractRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     final int id = msg.getC2SId();
/* 31 */     final InteractionCO prop = PlayerInteract.getPropById(id);
/* 32 */     if (prop == null) {
/* 33 */       return (PomeloResponse)new ErrorResponse("interact error!!!");
/*    */     }
/*    */     
/* 36 */     if (!player.getInteractManager().enoughTimes(id)) {
/* 37 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TIMES_NOT_ENOUGH"));
/*    */     }
/*    */     
/* 40 */     final String playerId = msg.getC2SPlayerId();
/* 41 */     final String playerName = msg.getC2SPlayerName();
/* 42 */     Out.debug(new Object[] { "interactRequest id:", Integer.valueOf(id), "  playerId:", playerId, "  playerName:", playerName });
/* 43 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 46 */           pomelo.area.InteractHandler.InteractResponse.Builder res = pomelo.area.InteractHandler.InteractResponse.newBuilder();
/*    */           
/* 48 */           int gold = prop.gold;
/* 49 */           int diamond = prop.diamond;
/* 50 */           if (gold > 0) {
/* 51 */             if (player.moneyManager.getGold() > gold) {
/* 52 */               player.moneyManager.costGold(gold, Const.GOODS_CHANGE_TYPE.interact);
/* 53 */               player.getInteractManager().send(id, playerId, playerName);
/* 54 */               res.setS2CCode(200);
/*    */             } else {
/* 56 */               res.setS2CCode(500);
/* 57 */               res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/*    */             }
/*    */           
/* 60 */           } else if (player.moneyManager.enoughDiamond(diamond)) {
/* 61 */             player.moneyManager.costDiamond(diamond, Const.GOODS_CHANGE_TYPE.interact);
/*    */             
/* 63 */             player.getInteractManager().send(id, playerId, playerName);
/* 64 */             res.setS2CCode(200);
/*    */           } else {
/* 66 */             res.setS2CCode(500);
/* 67 */             res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
/*    */           } 
/*    */           
/* 70 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\interact\InteractHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */