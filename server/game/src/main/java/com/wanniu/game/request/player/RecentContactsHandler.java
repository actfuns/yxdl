/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.recentContactsRequest")
/*    */ public class RecentContactsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     PlayerHandler.RecentContactsRequest req = PlayerHandler.RecentContactsRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     final ProtocolStringList ids = req.getC2SIdsList();
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           PlayerHandler.RecentContactsResponse.Builder res = PlayerHandler.RecentContactsResponse.newBuilder();
/*    */           
/* 39 */           List<PlayerHandler.recentContactInfo> data = new ArrayList<>();
/* 40 */           if (ids == null) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.addAllS2CData(data);
/* 43 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           ids.forEach(v -> {
/*    */                 WNPlayer p = PlayerUtil.findPlayer(v);
/*    */                 
/*    */                 PlayerHandler.recentContactInfo.Builder info = PlayerHandler.recentContactInfo.newBuilder();
/*    */                 info.setId(v);
/*    */                 info.setName(p.getName());
/*    */                 info.setLevel((p.getPlayer()).level);
/*    */                 info.setPro((p.getPlayer()).pro);
/*    */                 info.setIsFriend(1);
/*    */                 data.add(info.build());
/*    */               });
/* 57 */           data.forEach(v -> {
/*    */               
/*    */               });
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 64 */           res.setS2CCode(200);
/* 65 */           res.addAllS2CData(data);
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\RecentContactsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */