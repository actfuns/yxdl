/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.gm.handler.GMBaseHandler;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GMByteArgsHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 27 */     throw new RuntimeException("2进制参数的处理类不能走这里...");
/*    */   }
/*    */   
/*    */   public abstract GMResponse execute(JSONArray paramJSONArray, byte[] paramArrayOfbyte);
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMByteArgsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */