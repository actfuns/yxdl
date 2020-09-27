/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ @GMEvent
/*    */ public class RoleForbidHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public enum ForbidType
/*    */   {
/* 19 */     LOCK, UNLOCK, SHUTUP, UNSHUTUP, KICK;
/*    */   }
/*    */   
/*    */   public GMResponse execute(JSONArray arr) {
/* 23 */     String id = arr.getString(0);
/* 24 */     int type = arr.getIntValue(1);
/* 25 */     String time = arr.getString(2);
/* 26 */     String reason = arr.getString(3);
/* 27 */     PlayerPO po = PlayerUtil.getPlayerBaseData(id);
/* 28 */     if (type == ForbidType.LOCK.ordinal()) {
/* 29 */       WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 30 */       if (player != null) {
/* 31 */         player.kick(Const.KickReason.GM_KICK);
/*    */       }
/* 33 */       po.freezeTime = DateUtil.format(time);
/* 34 */       po.freezeReason = reason;
/* 35 */     } else if (type == ForbidType.UNLOCK.ordinal()) {
/* 36 */       po.freezeTime = null;
/* 37 */       po.freezeReason = null;
/* 38 */     } else if (type == ForbidType.SHUTUP.ordinal()) {
/* 39 */       po.forbidTalkTime = DateUtil.format(time);
/* 40 */       po.forbidTalkReason = reason;
/* 41 */     } else if (type == ForbidType.UNSHUTUP.ordinal()) {
/* 42 */       po.forbidTalkTime = null;
/* 43 */       po.forbidTalkReason = null;
/* 44 */     } else if (type == ForbidType.KICK.ordinal()) {
/* 45 */       WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 46 */       if (player != null) {
/* 47 */         player.kick(Const.KickReason.GM_KICK);
/*    */       }
/*    */     } 
/* 50 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 54 */     return 12290;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\RoleForbidHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */