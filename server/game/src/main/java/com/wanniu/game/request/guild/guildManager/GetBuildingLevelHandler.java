/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepot;
/*    */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*    */ import com.wanniu.game.guild.guildBless.GuildBless;
/*    */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.GuildMemberPO;
/*    */ import io.netty.util.internal.StringUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.getBuildingLevelRequest")
/*    */ public class GetBuildingLevelHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           GuildManagerHandler.GetBuildingLevelResponse.Builder res = GuildManagerHandler.GetBuildingLevelResponse.newBuilder();
/*    */           
/* 33 */           GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 34 */           GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 35 */           if (StringUtil.isNullOrEmpty(player.getId()) || null == blessManager || null == depotManager) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 38 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 42 */           GuildManagerHandler.BuildingLevel.Builder data = GuildManagerHandler.BuildingLevel.newBuilder();
/* 43 */           GuildMemberPO myInfo = GuildUtil.getGuildMember(player.getId());
/* 44 */           if (null != myInfo) {
/* 45 */             GuildBless bless = blessManager.getBless(myInfo.guildId);
/* 46 */             if (null != bless) {
/* 47 */               data.setBlessLevel(bless.level);
/* 48 */               data.setTechLevel(bless.tech.level);
/*    */             } 
/*    */             
/* 51 */             GuildDepot depot = depotManager.getDepot(myInfo.guildId);
/* 52 */             if (null != depot) {
/* 53 */               data.setDepotLevel(depot.depotData.level);
/*    */             }
/*    */           } 
/*    */           
/* 57 */           res.setS2CCode(200);
/* 58 */           res.setS2CLevelInfo(data.build());
/* 59 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GetBuildingLevelHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */