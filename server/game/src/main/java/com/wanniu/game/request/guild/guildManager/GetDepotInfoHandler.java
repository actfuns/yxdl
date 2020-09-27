/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.guild.guidDepot.PlayerGuildDepot;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getDepotInfoRequest")
/*    */ public class GetDepotInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           GuildManagerHandler.GetDepotInfoResponse.Builder res = GuildManagerHandler.GetDepotInfoResponse.newBuilder();
/*    */           
/* 32 */           PlayerGuildDepot depotData = GuildDepotCenter.getInstance().getDepotDataByPlayerId(player);
/* 33 */           if (null == depotData) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 36 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 40 */           GuildManagerHandler.DepotInfo.Builder depotInfo = GuildManagerHandler.DepotInfo.newBuilder();
/* 41 */           if (null != depotData.depotInfo) {
/* 42 */             depotInfo.setLevel(depotData.depotInfo.level);
/* 43 */             GuildManagerHandler.DepotCondition depCond = GuildCommonUtil.toManagerCond(depotData.depotInfo.condition);
/* 44 */             if (null != depCond) {
/* 45 */               depotInfo.setDepotCond(depCond);
/*    */             } else {
/* 47 */               Out.error(new Object[] { "depCond is null:", depCond });
/*    */             } 
/*    */             
/* 50 */             depotInfo.setDeleteCount(depotData.depotInfo.deleteCount);
/* 51 */             depotInfo.setDeleteCountMax(depotData.depotInfo.deleteCountMax);
/*    */           } 
/*    */           
/* 54 */           GuildManagerHandler.BagInfo.Builder depotBag = GuildManagerHandler.BagInfo.newBuilder();
/* 55 */           if (null != depotData.bagInfo) {
/* 56 */             depotBag.setBagGridCount(depotData.bagInfo.getBagGridCount());
/* 57 */             depotBag.setBagTotalCount(depotData.bagInfo.getBagTotalCount());
/* 58 */             depotBag.addAllBagGrids(depotData.bagInfo.getBagGridsList());
/* 59 */             depotBag.addAllBagDetails(depotData.detailInfo);
/*    */           } 
/*    */           
/* 62 */           res.setS2CCode(200);
/* 63 */           res.setS2CDepotInfo(depotInfo.build());
/* 64 */           res.setS2CDepotBag(depotBag.build());
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetDepotInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */