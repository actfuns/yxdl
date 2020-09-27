/*     */ package com.wanniu.game.request.guild;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.guild.GuildResult;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import pomelo.area.GuildHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.guildHandler.createGuildRequest")
/*     */ public class CreateGuildHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  33 */     final GuildHandler.CreateGuildRequest req = GuildHandler.CreateGuildRequest.parseFrom(this.pak.getRemaingBytes());
/*  34 */     final JSONObject params = new JSONObject();
/*  35 */     params.put("icon", req.getC2SIcon());
/*  36 */     params.put("name", req.getC2SName());
/*  37 */     params.put("qqGroup", req.getC2SQqGroup());
/*     */     
/*  39 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  42 */           GuildHandler.CreateGuildResponse.Builder res = GuildHandler.CreateGuildResponse.newBuilder();
/*  43 */           if (null == player) {
/*  44 */             res.setS2CCode(500);
/*  45 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*  46 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  49 */           GuildResult ret = player.guildManager.createGuild(params);
/*  50 */           int result = ret.result;
/*  51 */           if (0 == result) {
/*  52 */             GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
/*  53 */             if (null == guildInfo) {
/*  54 */               res.setS2CCode(500);
/*  55 */               res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
/*  56 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  59 */             MessageUtil.sendRollChat(GWorld.__SERVER_ID, String.format(LangService.getValue("GUILD_CREATE"), new Object[] { this.val$player.getName(), this.val$req.getC2SName() }), Const.CHAT_SCOPE.SYSTEM);
/*  60 */             res.setS2CCode(200);
/*  61 */             res.setS2CGuildInfo(guildInfo);
/*  62 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  65 */           GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  66 */           if (-1 == result) {
/*  67 */             res.setS2CCode(500);
/*  68 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*  69 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  71 */           if (-2 == result) {
/*  72 */             res.setS2CCode(500);
/*  73 */             res.setS2CMsg(LangService.getValue("GUILD_CREATE_ERROR"));
/*  74 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  76 */           if (-3 == result) {
/*  77 */             res.setS2CCode(500);
/*  78 */             res.setS2CMsg(LangService.getValue("GUILD_CREATE_LEVEL").replace("{roleLevel}", String.valueOf(prop.joinLv)));
/*  79 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  81 */           if (-4 == result) {
/*  82 */             res.setS2CCode(500);
/*  83 */             res.setS2CMsg(LangService.getValue("GUILD_CREATE_COST").replace("{guildPay}", String.valueOf(prop.cost)));
/*  84 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  86 */           if (-5 == result) {
/*  87 */             res.setS2CCode(500);
/*  88 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  89 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  91 */           if (-6 == result) {
/*  92 */             res.setS2CCode(500);
/*  93 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_SHORT"));
/*  94 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  96 */           if (-7 == result) {
/*  97 */             res.setS2CCode(500);
/*  98 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_LONG"));
/*  99 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 101 */           if (-8 == result) {
/* 102 */             res.setS2CCode(500);
/* 103 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_SPECIAL_CHAR"));
/* 104 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 106 */           if (-9 == result) {
/* 107 */             res.setS2CCode(500);
/* 108 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_BLACK_STRING"));
/* 109 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 111 */           if (-10 == result) {
/* 112 */             res.setS2CCode(500);
/* 113 */             res.setS2CMsg(LangService.getValue("GUILD_CREATE_CD").replace("{time}", String.valueOf(ret.cdInfo)));
/* 114 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 116 */           if (1 == result) {
/* 117 */             res.setS2CCode(500);
/* 118 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
/* 119 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/* 121 */           if (-11 == result) {
/* 122 */             res.setS2CCode(500);
/* 123 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_EMPTY"));
/* 124 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\CreateGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */