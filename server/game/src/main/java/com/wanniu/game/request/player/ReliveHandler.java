/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ResurrectionCO;
/*    */ import com.wanniu.game.player.ReliveManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
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
/*    */ @GClientEvent("area.playerHandler.reliveRequest")
/*    */ public class ReliveHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 34 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 36 */     PlayerHandler.ReliveRequest req = PlayerHandler.ReliveRequest.parseFrom(this.pak.getRemaingBytes());
/* 37 */     int c2s_type = req.getType();
/* 38 */     int payConfirm = req.getAutoPay();
/* 39 */     Out.debug(new Object[] { "reliveRequest :: ", Integer.valueOf(c2s_type), " && ", Integer.valueOf(payConfirm) });
/* 40 */     Area area = player.getArea();
/* 41 */     ReliveManager reliveManager = player.getReliveManager();
/* 42 */     int total = reliveManager.getReliveTotal(area.areaId);
/*    */     
/* 44 */     Area.ReliveType reliveType = area.getReliveType();
/* 45 */     int cost = Math.max(5, reliveManager.payCost);
/* 46 */     int reliveNum = 3 + player.vipManager.getReliveNum();
/* 47 */     ResurrectionCO resurrection = (ResurrectionCO)GameData.Resurrections.get(Integer.valueOf(area.areaId));
/* 48 */     if (resurrection != null && 
/* 49 */       resurrection.freeResurrect > 0) {
/* 50 */       reliveNum = 0;
/*    */     }
/*    */     
/* 53 */     if (c2s_type == 1) {
/* 54 */       reliveType = Area.ReliveType.NOW;
/* 55 */       if (reliveManager.nowReliveNum >= reliveNum) {
/* 56 */         if (payConfirm == 1) {
/* 57 */           reliveManager.payConfirm = 0;
/*    */         }
/* 59 */         PlayerPO po = player.player;
/* 60 */         int diamond = po.diamond + po.ticket;
/* 61 */         if (cost > diamond) {
/* 62 */           return (PomeloResponse)new ErrorResponse(LangService.getValue("NOT_ENOUGH_DIAMOND"));
/*    */         }
/* 64 */         if (po.ticket > cost) {
/* 65 */           player.moneyManager.costTicket(cost, Const.GOODS_CHANGE_TYPE.relive);
/*    */         } else {
/* 67 */           int ticket = po.ticket;
/* 68 */           if (ticket > 0) {
/* 69 */             player.moneyManager.costTicket(ticket, Const.GOODS_CHANGE_TYPE.relive);
/*    */           }
/* 71 */           player.moneyManager.costDiamond(cost, Const.GOODS_CHANGE_TYPE.relive);
/*    */         } 
/*    */       } 
/*    */       
/* 75 */       reliveManager.nowReliveNum++;
/*    */     } else {
/* 77 */       Area.Actor actor = area.getActor(player.getId());
/* 78 */       if (actor != null) {
/* 79 */         if (System.currentTimeMillis() < actor.reliveCoolTime) {
/* 80 */           return (PomeloResponse)new ErrorResponse(LangService.format("RELIVE_COOL_TIME", new Object[] { Long.valueOf(Math.max(1L, (actor.reliveCoolTime - System.currentTimeMillis()) / 1000L)) }));
/*    */         }
/*    */       } else {
/* 83 */         return (PomeloResponse)new ErrorResponse("");
/*    */       } 
/*    */     } 
/* 86 */     if (!area.isNormal() && total > 0) {
/* 87 */       int count = reliveManager.getReliveCount(area.areaId);
/* 88 */       if (count >= total) {
/* 89 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RELIVE_FULL"));
/*    */       }
/* 91 */       reliveManager.addRelive(area.areaId);
/*    */     } 
/*    */     
/* 94 */     final PlayerHandler.ReliveResponse.Builder res = area.relive(player.getId(), reliveType);
/*    */     
/* 96 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 99 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ReliveHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */