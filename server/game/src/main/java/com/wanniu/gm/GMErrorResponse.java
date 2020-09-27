/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class GMErrorResponse
/*    */   extends GMResponse
/*    */ {
/*    */   public GMErrorResponse() {
/* 10 */     super(251);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void response() throws IOException {
/* 15 */     this.body.writeInt(GWorld.__SERVER_ID);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMErrorResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */