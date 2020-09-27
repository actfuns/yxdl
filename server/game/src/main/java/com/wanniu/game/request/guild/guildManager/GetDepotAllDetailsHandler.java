/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getDepotAllDetailsRequest")
/*    */ public class GetDepotAllDetailsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildManagerHandler.GetDepotAllDetailsResponse.Builder res = GuildManagerHandler.GetDepotAllDetailsResponse.newBuilder();
/*    */           
/* 29 */           GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 30 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == depotManager) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 33 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 36 */           ArrayList<ItemOuterClass.ItemDetail> list = depotManager.getDepotDetailsByPlayerId(player);
/* 37 */           res.setS2CCode(200);
/* 38 */           res.addAllS2CBagDetails(list);
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetDepotAllDetailsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */