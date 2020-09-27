/*    */ package com.wanniu.game.request.xianyuan;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.xianyuan.XianYuanService;
/*    */ import java.io.IOException;
/*    */ import pomelo.xianyuan.XianYuanHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("xianyuan.xianYuanHandler.applyXianYuanRequest")
/*    */ public class ApplyXianYuanHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.XIAN_YUAN.getValue())) {
/* 27 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("XIAN_YUAN_NOT_OPEN"));
/*    */     }
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 34 */           XianYuanHandler.XianYuanResponse.Builder res = XianYuanHandler.XianYuanResponse.newBuilder();
/*    */           
/* 36 */           XianYuanService.getInstance().applyXianYuanGetInfo(player, res);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\xianyuan\ApplyXianYuanHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */