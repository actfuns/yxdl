/*    */ package com.wanniu.game.request.auction;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.common.msg.MessageUtil;
/*    */ import com.wanniu.game.guild.dao.GuildDao;
/*    */ import com.wanniu.game.guild.guidDepot.GuildAuctionLog;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import pomelo.auction.AuctionHandler;
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
/*    */ 
/*    */ @GClientEvent("auction.auctionHandler.auctionLogRequest")
/*    */ public class AuctionLogHandle
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 43 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 44 */     final String guildId = player.guildManager.getGuildId();
/* 45 */     if (StringUtils.isEmpty(guildId)) {
/* 46 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 49 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 52 */           AuctionHandler.AuctionLogResponse.Builder response = AuctionHandler.AuctionLogResponse.newBuilder();
/*    */           
/* 54 */           for (GuildAuctionLog log : GuildDao.getGuildAuctionLog(guildId)) {
/* 55 */             AuctionHandler.AuctionLog.Builder builder = AuctionHandler.AuctionLog.newBuilder();
/* 56 */             builder.setId(log.type);
/* 57 */             builder.setItem(MessageUtil.itemColorName(log.item.qColor, log.item.name));
/* 58 */             builder.setTime(log.time);
/* 59 */             builder.setNum(log.price);
/* 60 */             if (StringUtils.isNotEmpty(log.player)) {
/* 61 */               builder.setRole1(log.player);
/*    */             }
/* 63 */             response.addS2CLog(builder);
/*    */           } 
/*    */           
/* 66 */           response.setS2CCode(200);
/* 67 */           this.body.writeBytes(response.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\auction\AuctionLogHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */