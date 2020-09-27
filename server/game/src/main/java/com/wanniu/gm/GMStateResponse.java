/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class GMStateResponse
/*    */   extends GMResponse
/*    */ {
/*    */   private byte state;
/*    */   
/*    */   public GMStateResponse(int state) {
/* 12 */     super(250);
/* 13 */     this.state = (byte)state;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void response() throws IOException {
/* 18 */     this.body.writeInt(GWorld.__SERVER_ID);
/* 19 */     this.body.writeByte(0);
/* 20 */     this.body.writeByte(this.state);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMStateResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */