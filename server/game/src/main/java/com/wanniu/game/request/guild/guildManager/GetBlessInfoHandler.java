/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getBlessInfoRequest")
/*    */ public class GetBlessInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildManagerHandler.GetBlessInfoResponse.Builder res = GuildManagerHandler.GetBlessInfoResponse.newBuilder();
/*    */           
/* 28 */           GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 29 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           GuildManagerHandler.GuildBlessInfo blessData = blessManager.getBlessInfoByPlayerId(player.getId());
/* 37 */           res.setS2CCode(200);
/* 38 */           res.setS2CBlessInfo(blessData);
/*    */           
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetBlessInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */