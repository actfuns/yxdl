/*     */ package com.wanniu.game.request.guild.guildDepot;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.guild.GuildResult;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import pomelo.area.GuildDepotHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.guildDepotHandler.depositItemRequest")
/*     */ public class DepositItemHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  21 */     GuildDepotHandler.DepositItemRequest req = GuildDepotHandler.DepositItemRequest.parseFrom(this.pak.getRemaingBytes());
/*  22 */     final int c2s_fromIndex = req.getC2SFromIndex();
/*  23 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  26 */           GuildDepotHandler.DepositItemResponse.Builder res = GuildDepotHandler.DepositItemResponse.newBuilder();
/*  27 */           if (c2s_fromIndex == 0) {
/*  28 */             res.setS2CCode(500);
/*  29 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  30 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  34 */           GuildResult resData = player.guildManager.depositEquipToDepot(c2s_fromIndex);
/*  35 */           int result = resData.result;
/*  36 */           if (result == 0) {
/*  37 */             player.taskManager.dealTaskEvent(Const.TaskType.GUILD_CONTRIBUTE, 1);
/*  38 */             res.setS2CCode(200);
/*  39 */             res.setS2CBagGrid(resData.bagGrid);
/*  40 */             res.setDepositCount(resData.depositCount);
/*  41 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  43 */           if (result == -1) {
/*  44 */             res.setS2CCode(500);
/*  45 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  46 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  48 */           if (result == -2) {
/*  49 */             res.setS2CCode(500);
/*  50 */             res.setS2CMsg(LangService.getValue("DEPOT_EMPTY_BAG_INDEX"));
/*  51 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  53 */           if (result == -3) {
/*  54 */             res.setS2CCode(500);
/*  55 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EQUIP"));
/*  56 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  58 */           if (result == -4) {
/*  59 */             res.setS2CCode(500);
/*  60 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_IS_BIND"));
/*  61 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  63 */           if (result == -5) {
/*  64 */             res.setS2CCode(500);
/*  65 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_CANNOT_DEPOSIT"));
/*  66 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  68 */           if (result == -6) {
/*  69 */             res.setS2CCode(500);
/*  70 */             res.setS2CMsg(LangService.getValue("DEPOT_DEPOSIT_COUNT_NOT_ENOUGH"));
/*  71 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  73 */           if (result == -7) {
/*  74 */             res.setS2CCode(500);
/*  75 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_LEVEL_NOT_NOUGH"));
/*  76 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  78 */           if (result == -8) {
/*  79 */             res.setS2CCode(500);
/*  80 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_COLOR_NOT_NOUGH"));
/*  81 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  83 */           if (result == -9) {
/*  84 */             res.setS2CCode(500);
/*  85 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_CONFIG_NOT_EXIST"));
/*  86 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  88 */           if (result == 1) {
/*  89 */             res.setS2CCode(500);
/*  90 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/*  91 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  93 */           if (result == 2) {
/*  94 */             res.setS2CCode(500);
/*  95 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
/*  96 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  98 */           if (result == 3) {
/*  99 */             res.setS2CCode(500);
/* 100 */             res.setS2CMsg(LangService.getValue("DEPOT_UPLEVEL_NOT_ENOUGH"));
/* 101 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 103 */           if (result == 4) {
/* 104 */             res.setS2CCode(500);
/* 105 */             res.setS2CMsg(LangService.getValue("DEPOT_LEVEL_NOT_ENOUGH"));
/* 106 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 108 */           if (result == 5) {
/* 109 */             res.setS2CCode(500);
/* 110 */             res.setS2CMsg(LangService.getValue("DEPOT_JOB_NOT_ENOUGH"));
/* 111 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 113 */           if (result == 6) {
/* 114 */             res.setS2CCode(500);
/* 115 */             res.setS2CMsg(LangService.getValue("DEPOT_EQUIP_QUALITY_NOT_IN_CONDITION"));
/* 116 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 118 */           if (result == 7) {
/* 119 */             res.setS2CCode(500);
/* 120 */             res.setS2CMsg(LangService.getValue("DEPOT_SPACE_NOT_ENOUGH"));
/* 121 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/* 124 */           res.setS2CCode(500);
/* 125 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 126 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildDepot\DepositItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */