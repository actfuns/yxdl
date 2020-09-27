/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.base.MapBase;
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
/*    */ @GClientEvent("area.playerHandler.transByAreaIdRequest")
/*    */ public class TransByAreaIdHandler
/*    */   extends ChangeAreaFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 27 */     PlayerHandler.TransByAreaIdRequest req = PlayerHandler.TransByAreaIdRequest.parseFrom(this.pak.getRemaingBytes());
/* 28 */     int areaId = req.getC2SAreaId();
/* 29 */     MapBase sceneProp = AreaUtil.getAreaProp(areaId);
/* 30 */     String result = AreaUtil.canTransArea(sceneProp, player);
/* 31 */     if (result != null) {
/* 32 */       return (PomeloResponse)new ErrorResponse(result);
/*    */     }
/*    */     
/* 35 */     GWorld.getInstance().ansycExec(() -> {
/*    */           AreaUtil.disCardItemByTransArea(sceneProp, player);
/*    */           
/*    */           AreaUtil.enterArea(player, areaId, 0.0F, 0.0F);
/*    */         });
/* 40 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 43 */           PlayerHandler.TransByAreaIdResponse.Builder res = PlayerHandler.TransByAreaIdResponse.newBuilder();
/* 44 */           res.setS2CCode(200);
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\TransByAreaIdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */