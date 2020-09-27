/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.groovy.GameGroovyManager;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class JavaScriptHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 15 */     String script = arr.getString(0);
/* 16 */     return (GMResponse)new GMJsonResponse(GameGroovyManager.getInstance().sendGroovyCodeText(script));
/*    */   }
/*    */   
/*    */   public short getType() {
/* 20 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\JavaScriptHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */