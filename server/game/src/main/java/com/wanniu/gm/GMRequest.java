/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.gm.request.GMHandler;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.gm.handler.GMBaseHandler;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GMRequest
/*    */   extends GMHandler
/*    */ {
/* 15 */   private static final Map<Short, GMBaseHandler> handlers = new HashMap<>();
/*    */   
/*    */   public static void addHandler(GMBaseHandler handler) {
/* 18 */     handlers.put(Short.valueOf(handler.getType()), handler);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(Packet pak) {
/* 23 */     long key = pak.getLong();
/* 24 */     short op = pak.getShort();
/* 25 */     JSONArray arr = JSON.parseArray(pak.getString());
/*    */     
/* 27 */     GMResponse res = null;
/* 28 */     GMBaseHandler handler = handlers.get(Short.valueOf(op));
/* 29 */     if (handler != null) {
/*    */       
/*    */       try {
/* 32 */         if (handler instanceof GMByteArgsHandler) {
/* 33 */           res = ((GMByteArgsHandler)handler).execute(arr, pak.getRemaingBytes());
/*    */         }
/*    */         else {
/*    */           
/* 37 */           res = handler.execute(arr);
/*    */         } 
/* 39 */       } catch (Exception e) {
/* 40 */         Out.error(new Object[] { e });
/* 41 */         res = new GMErrorResponse();
/*    */       } 
/*    */     } else {
/* 44 */       Out.error(new Object[] { "GMRequest : ", Long.valueOf(key), " - 0x", Integer.toHexString(op), " - " });
/* 45 */       res = new GMErrorResponse();
/*    */     } 
/* 47 */     if (res != null) {
/* 48 */       res.setKey(key);
/* 49 */       pak.getSession().writeAndFlush(res);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 55 */     return 2748;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */