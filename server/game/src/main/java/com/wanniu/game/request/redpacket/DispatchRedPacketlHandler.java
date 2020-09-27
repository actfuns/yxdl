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
/*    */ @GClientEvent("redpacket.redPacketHandler.dispatchRedPacketRequest")
/*    */ public class DispatchRedPacketlHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     RedPacketHandler.DispatchRedPacketRequest req = RedPacketHandler.DispatchRedPacketRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     int count = req.getCount();
/* 31 */     int totalNum = req.getTotalNum();
/* 32 */     int channelType = req.getChannelType();
/* 33 */     int fetchType = req.getFetchType();
/* 34 */     int benifitType = req.getBenifitType();
/* 35 */     String msg = req.getMessage();
/* 36 */     int result = RedPacketService.getInstance().dispatchRedPacket(player.getId(), totalNum, count, channelType, fetchType, benifitType, msg);
/* 37 */     switch (result) {
/*    */       case 0:
/* 39 */         return new PomeloResponse()
/*    */           {
/*    */             protected void write() throws IOException {
/* 42 */               RedPacketHandler.DispatchRedPacketResponse.Builder res = RedPacketHandler.DispatchRedPacketResponse.newBuilder();
/* 43 */               res.setS2CCode(200);
/* 44 */               this.body.writeBytes(res.build().toByteArray());
/*    */             }
/*    */           };
/*    */       
/*    */       case 1:
/* 49 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_TOTAL_NUM_BIGGER_OR_SMALLER"));
/*    */       case 2:
/* 51 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_COUNT_BIGGER_OR_SMALLER"));
/*    */       case 3:
/* 53 */         return (PomeloResponse)new ErrorResponse(String.format(LangService.getValue("RED_PACKET_LEVEL_NEED"), new Object[] { Integer.valueOf(GlobalConfig.Red_SendLevel) }));
/*    */       case 4:
/* 55 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_NOT_ENOUGH_DIAMOND"));
/*    */       case 5:
/* 57 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("RED_PACKET_NOT_IN_GUILD"));
/*    */     } 
/* 59 */     return (PomeloResponse)new ErrorResponse();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\redpacket\DispatchRedPacketlHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */