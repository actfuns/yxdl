/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TransportCO;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
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
/*    */ @GClientEvent("area.playerHandler.transportRequest")
/*    */ public class TransportHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 30 */     PlayerHandler.TransportRequest req = PlayerHandler.TransportRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     final int transportId = req.getC2STransportId();
/*    */     
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           PlayerHandler.TransportResponse.Builder res = PlayerHandler.TransportResponse.newBuilder();
/*    */           
/* 38 */           boolean result = PlayerUtil.transPortById(player, transportId);
/* 39 */           if (result) {
/* 40 */             res.setS2CCode(200);
/* 41 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 43 */             TransportCO transportProp = (TransportCO)GameData.Transports.get(Integer.valueOf(transportId));
/* 44 */             if (transportProp != null) {
/* 45 */               res.setS2CCode(500);
/* 46 */               res.setS2CMsg(transportProp.failTips);
/* 47 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } else {
/* 49 */               res.setS2CCode(500);
/* 50 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 51 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } 
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\TransportHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */