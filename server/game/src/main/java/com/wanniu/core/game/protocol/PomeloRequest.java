/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.game.request.GameHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
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
/*    */ public abstract class PomeloRequest
/*    */   extends GameHandler
/*    */ {
/*    */   public static final int OK = 200;
/*    */   public static final int KICK = 400;
/*    */   public static final int FAIL = 500;
/*    */   protected Packet pak;
/*    */   
/*    */   public void execute(Packet pak) {
/* 25 */     this.watcher.begin(pak.getHeader().getLength());
/* 26 */     this.pak = pak;
/* 27 */     PomeloResponse res = null;
/*    */     try {
/* 29 */       res = request();
/* 30 */     } catch (Exception e) {
/* 31 */       res = GGame.getInstance().getErrResponse(e);
/*    */     } 
/* 33 */     if (res != null) {
/* 34 */       PomeloHeader header = res.getHeader();
/* 35 */       header.setType(pak.getHeader().getType());
/* 36 */       this.watcher.end(res.getContent().readableBytes());
/* 37 */       write(res);
/*    */     } else {
/* 39 */       this.watcher.end(0);
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract PomeloResponse request() throws Exception;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\protocol\PomeloRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */