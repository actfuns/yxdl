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
/*    */ @GClientEvent("area.guildDepotHandler.deleteItemRequest")
/*    */ public class DeleteItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildDepotHandler.DeleteItemRequest req = GuildDepotHandler.DeleteItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final int c2s_fromIndex = req.getC2SFromIndex();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildDepotHandler.DeleteItemResponse.Builder res = GuildDepotHandler.DeleteItemResponse.newBuilder();
/* 26 */           GuildResult resData = player.guildManager.deleteEquipFromDepot(c2s_fromIndex);
/* 27 */           int result = resData.result;
/* 28 */           if (result == 0) {
/* 29 */             res.setS2CCode(200);
/* 30 */             res.setDeleteCount(resData.deleteCount);
/* 31 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 33 */           if (result == -1) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 36 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 38 */           if (result == 1) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 41 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 43 */           if (result == 2) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 46 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 48 */           if (result == 3) {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
/* 51 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 53 */           if (result == 4) {
/* 54 */             res.setS2CCode(500);
/* 55 */             res.setS2CMsg(LangService.getValue("DEPOT_DELETE_T_COUNT_NOT_ENOUGH"));
/* 56 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 58 */           if (result == 5) {
/* 59 */             res.setS2CCode(500);
/* 60 */             res.setS2CMsg(LangService.getValue("DEPOT_EMPTY_DEPOT_BAG_INDEX"));
/* 61 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 64 */           res.setS2CCode(500);
/* 65 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildDepot\DeleteItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */