/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SoloRequestFilter
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 22 */     if (player.getSceneType() == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/* 23 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CROSS_SERVER_AUTH_LIMIT"));
/*    */     }
/*    */     
/* 26 */     return request(player);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;
/*    */   
/*    */   public short getType() {
/* 33 */     return 515;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\SoloRequestFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */