/*    */ package com.wanniu.game.request.redpacket;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.redpacket.RedPacketService;
/*    */ import java.io.IOException;
/*    */ import pomelo.redpacket.RedPacketHandler;
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
/*    */ @GClientEvent("redpacket.redPacketHandler.fetchRedPacketRequest")
/*    */ public class FetchRedPacketlHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     RedPacketHandler.FetchRedPacketRequest req = RedPacketHandler.FetchRedPacketRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     String id = req.getId();
/* 32 */     final int result = RedPacketService.getInstance().fetchRedPacket(player.getId(), id);
/*    */     
/* 34 */     if (result > 0) {
/* 35 */       return new PomeloResponse()
/*    */         {
/*    */           protected void write() throws IOException {
/* 38 */             RedPacketHandler.FetchRedPacketResponse.Builder res = RedPacketHandler.FetchRedPacketResponse.newBuilder();
/* 39 */             res.setS2CCode(200);
/* 40 */             res.setValue(result);
/* 41 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/*    */         };
/*    */     }
/*    */ 
/*    */     
/* 47 */     switch (result) {
/*    */       
/*    */       case -1:
/* 50 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_WRONG_ID"));
/*    */       case -2:
/* 52 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_FETCHED"));
/*    */       case -3:
/* 54 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_FETCHED_OUT"));
/*    */       case -4:
/* 56 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_CANNOT_FETCH"));
/*    */       case -5:
/* 58 */         return (PomeloResponse)new ErrorResponse(String.format(LangService.getValue("RED_PACKET_LEVEL_NEED"), new Object[] { Integer.valueOf(GlobalConfig.Red_LootLevel) }));
/*    */       case -6:
/* 60 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_GUILD"));
/*    */       case -7:
/* 62 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_THIS_GUILD"));
/*    */     } 
/* 64 */     return (PomeloResponse)new ErrorResponse();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\redpacket\FetchRedPacketlHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */