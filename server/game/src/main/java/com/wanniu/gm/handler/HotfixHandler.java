/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.hotupdate.HotUpdateService;
/*    */ import com.wanniu.gm.GMByteArgsHandler;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class HotfixHandler
/*    */   extends GMByteArgsHandler
/*    */ {
/*    */   public short getType() {
/* 21 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public GMResponse execute(JSONArray arr, byte[] bytes) {
/* 26 */     String className = arr.getString(0);
/* 27 */     String code = HotUpdateService.changeClass(className, bytes);
/* 28 */     return (GMResponse)new GMJsonResponse(code);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\HotfixHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */