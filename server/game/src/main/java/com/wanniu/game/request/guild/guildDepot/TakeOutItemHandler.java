/*    */ package com.wanniu.game.request.guild.guildDepot;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildDepotHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildDepotHandler.takeOutItemRequest")
/*    */ public class TakeOutItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildDepotHandler.TakeOutItemRequest req = GuildDepotHandler.TakeOutItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final int c2s_fromIndex = req.getC2SFromIndex();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildDepotHandler.TakeOutItemResponse.Builder res = GuildDepotHandler.TakeOutItemResponse.newBuilder();
/*    */           
/* 27 */           if (c2s_fromIndex == 0) {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 34 */           GuildResult resData = player.guildManager.takeOutEquipFromDepot(c2s_fromIndex);
/* 35 */           int result = resData.result;
/* 36 */           if (result == 0) {
/* 37 */             res.setS2CCode(200);
/* 38 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 40 */           if (result == -1) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 43 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 45 */           if (result == -2) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 48 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 50 */           if (result == 1) {
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 53 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 55 */           if (result == 2) {
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
/* 58 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 60 */           if (result == 3) {
/* 61 */             res.setS2CCode(500);
/* 62 */             res.setS2CMsg(LangService.getValue("DEPOT_EMPTY_DEPOT_BAG_INDEX"));
/* 63 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 65 */           if (result == 4) {
/* 66 */             res.setS2CCode(500);
/* 67 */             res.setS2CMsg(LangService.getValue("DEPOT_PAWN_GOLD_NOT_ENOUGH"));
/* 68 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 71 */           res.setS2CCode(500);
/* 72 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildDepot\TakeOutItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */