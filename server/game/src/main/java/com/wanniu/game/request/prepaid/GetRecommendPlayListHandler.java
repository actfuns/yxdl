/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.VitalityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.vitalityHandler.getRecommendPlayListRequest")
/*    */ public class GetRecommendPlayListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 18 */           VitalityHandler.GetRecommendPlayListResponse.Builder res = VitalityHandler.GetRecommendPlayListResponse.newBuilder();
/*    */ 
/*    */ 
/*    */           
/* 22 */           res.setS2CCode(200);
/* 23 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\GetRecommendPlayListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */