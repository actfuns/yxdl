/*    */ package com.wanniu.core.game.protocol;
/*    */ 
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
/* 24 */     this.pak = pak;
/* 25 */     PomeloResponse res = null;
/*    */     try {
/* 27 */       res = request();
/* 28 */     } catch (Exception e) {
/* 29 */       e.printStackTrace();
/*    */     } 
/* 31 */     if (res != null) {
/* 32 */       PomeloHeader header = res.getHeader();
/* 33 */       header.setType(pak.getHeader().getType());
/* 34 */       write(res);
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract PomeloResponse request() throws Exception;
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\PomeloRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */