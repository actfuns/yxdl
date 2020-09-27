/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.MessageUtil;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class NoticeHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 21 */     String content = arr.getString(0);
/* 22 */     for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/* 23 */       WNPlayer wp = (WNPlayer)p;
/* 24 */       wp.sendSysTip(content, Const.TipsType.ROLL);
/*    */     } 
/*    */     
/* 27 */     MessageUtil.sendRollChat(GWorld.__SERVER_ID, content, Const.CHAT_SCOPE.SYSTEM);
/* 28 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 32 */     return 4482;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\NoticeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */