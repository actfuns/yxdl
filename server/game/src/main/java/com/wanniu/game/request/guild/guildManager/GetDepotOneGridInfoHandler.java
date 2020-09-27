/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotOneGrid;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getDepotOneGridInfoRequest")
/*    */ public class GetDepotOneGridInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     GuildManagerHandler.GetDepotOneGridInfoRequest req = GuildManagerHandler.GetDepotOneGridInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final int bagIndex = req.getBagIndex();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildManagerHandler.GetDepotOneGridInfoResponse.Builder res = GuildManagerHandler.GetDepotOneGridInfoResponse.newBuilder();
/* 28 */           GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 29 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           GuildDepotOneGrid data = depotManager.getDepotOneGridInfoByPlayerId(player, bagIndex);
/* 37 */           res.setS2CCode(200);
/* 38 */           res.setS2CBagGrid(data.grid);
/* 39 */           res.setS2CBagDetail(data.detail);
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetDepotOneGridInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */