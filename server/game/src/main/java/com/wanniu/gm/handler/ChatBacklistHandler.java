/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.request.chat.ChatBacklistManager;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ @GMEvent
/*    */ public class ChatBacklistHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 14 */     ChatBacklistManager.getInstance().addIp(arr.getString(0));
/* 15 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 19 */     return 6;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\ChatBacklistHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */