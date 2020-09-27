/*    */ package com.wanniu.game.request.guild.guildBless;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildBlessHandler;
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
/*    */ @GClientEvent("area.guildBlessHandler.blessActionRequest")
/*    */ public class BlessActionHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 29 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 30 */     GuildBlessHandler.BlessActionRequest req = GuildBlessHandler.BlessActionRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     final int id = req.getId();
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           GuildBlessHandler.BlessActionResponse.Builder res = GuildBlessHandler.BlessActionResponse.newBuilder();
/*    */           
/* 37 */           if (id <= 0) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 40 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 44 */           GuildResult resData = player.guildManager.blessAction(id, 1);
/* 45 */           int result = resData.result;
/* 46 */           if (result == 0) {
/* 47 */             player.taskManager.dealTaskEvent(Const.TaskType.GUILD_PRAY, 1);
/* 48 */             GuildResult.GuildBlessActionData data = (GuildResult.GuildBlessActionData)resData.data;
/* 49 */             res.setS2CCode(200);
/* 50 */             GuildBlessHandler.BlessResult.Builder s2c_result = GuildBlessHandler.BlessResult.newBuilder();
/* 51 */             s2c_result.setBlessCount(data.blessCount);
/* 52 */             s2c_result.setBlessValue(data.blessValue);
/* 53 */             s2c_result.setId(data.id);
/* 54 */             s2c_result.setFinishNum(data.finishNum);
/* 55 */             s2c_result.addAllFinishState(GuildCommonUtil.toList(data.finishState));
/* 56 */             res.setS2CResult(s2c_result.build());
/* 57 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 59 */           if (result == -1) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 62 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 64 */           if (result == -2) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_ITEM"));
/* 67 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 69 */           if (result == 1) {
/* 70 */             res.setS2CCode(500);
/* 71 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 72 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 74 */           if (result == 2) {
/* 75 */             res.setS2CCode(500);
/* 76 */             res.setS2CMsg(LangService.getValue("BLESS_TIMES_NOT_ENOUGH"));
/* 77 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 79 */           if (result == 3) {
/* 80 */             res.setS2CCode(500);
/* 81 */             res.setS2CMsg(LangService.getValue("BLESS_ITEM_NOT_EXIST"));
/* 82 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 85 */           res.setS2CCode(500);
/* 86 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 87 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBless\BlessActionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */