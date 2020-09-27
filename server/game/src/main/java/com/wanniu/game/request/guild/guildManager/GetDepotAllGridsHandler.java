/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.guild.guidDepot.PlayerGuildDepot;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getDepotAllGridsRequest")
/*    */ public class GetDepotAllGridsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildManagerHandler.GetDepotAllGridsResponse.Builder res = GuildManagerHandler.GetDepotAllGridsResponse.newBuilder();
/*    */           
/* 26 */           GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 27 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 33 */           PlayerGuildDepot data = depotManager.getDepotDataByPlayerId(player);
/* 34 */           res.setS2CCode(200);
/* 35 */           res.setS2CBagInfo(data.bagInfo);
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetDepotAllGridsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */