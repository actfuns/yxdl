/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.solo.vo.ResultVO;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SoloHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.soloHandler.leaveSoloAreaRequest")
/*    */ public class LeaveSoloAreaHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 26 */     if (player.getSceneType() != Const.SCENE_TYPE.SIN_COM.getValue()) {
/* 27 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
/*    */     }
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         
/*    */         protected void write() throws IOException
/*    */         {
/* 34 */           SoloHandler.LeaveSoloAreaResponse.Builder res = SoloHandler.LeaveSoloAreaResponse.newBuilder();
/*    */           
/* 36 */           ResultVO result = player.soloManager.handleLeaveSoloArea();
/* 37 */           if (result.result) {
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 42 */             res.setS2CCode(200);
/*    */           } else {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(result.info);
/*    */           } 
/*    */           
/* 48 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\LeaveSoloAreaHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */