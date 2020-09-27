/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.equip.Suit;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.EquipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.equipHandler.getSuitAttrRequest")
/*    */ public class GetSuitAttrHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */ 
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           EquipHandler.GetSuitAttrResponse.Builder res = EquipHandler.GetSuitAttrResponse.newBuilder();
/*    */           
/* 34 */           List<EquipHandler.SuitTypeAttr> list = Suit.getPlayerSuitInfo(player);
/*    */           
/* 36 */           res.setS2CCode(200);
/* 37 */           res.addAllS2CData(list);
/*    */           
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\GetSuitAttrHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */