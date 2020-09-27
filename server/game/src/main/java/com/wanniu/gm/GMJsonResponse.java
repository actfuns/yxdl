/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.tcp.protocol.Prefix;
/*    */ import com.wanniu.game.GWorld;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class GMJsonResponse
/*    */   extends GMResponse
/*    */ {
/*    */   private String json;
/*    */   
/*    */   public GMJsonResponse(JSONObject json) {
/* 15 */     super(250);
/* 16 */     this.json = json.toJSONString();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void response() throws IOException {
/* 21 */     this.body.writeInt(GWorld.__SERVER_ID);
/* 22 */     this.body.writeByte(1);
/* 23 */     this.body.writeBytes(Prefix.INT, this.json.getBytes(GGlobal.UTF_8));
/*    */   }
/*    */   
/*    */   public GMJsonResponse(String json) {
/* 27 */     super(250);
/* 28 */     this.json = json;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMJsonResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */