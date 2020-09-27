/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.prepaid.PrepaidCenter;
/*    */ import com.wanniu.game.prepaid.PrepaidManager;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class PayHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 24 */     String roleType = arr.getString(0);
/* 25 */     String roleId = arr.getString(1);
/* 26 */     int productId = arr.getIntValue(2);
/* 27 */     boolean logBI = true;
/* 28 */     if (arr.size() > 3) {
/* 29 */       logBI = (arr.getIntValue(3) == 1);
/*    */     }
/*    */     
/* 32 */     if (roleType.equals("id")) {
/* 33 */       if (PlayerUtil.getPlayerBaseData(roleId) == null) {
/* 34 */         return (GMResponse)new GMStateResponse(-2);
/*    */       }
/*    */     } else {
/* 37 */       String id = PlayerDao.getIdByName(roleId);
/* 38 */       if (id == null) {
/* 39 */         return (GMResponse)new GMStateResponse(-2);
/*    */       }
/* 41 */       roleId = id;
/*    */     } 
/*    */     
/* 44 */     boolean isCard = false;
/*    */     
/* 46 */     if (productId == 1 || productId == 2) {
/* 47 */       isCard = true;
/*    */     }
/*    */ 
/*    */     
/* 51 */     boolean isSuperPackage = false;
/* 52 */     if (productId > 300) {
/* 53 */       isSuperPackage = true;
/*    */     }
/*    */     
/* 56 */     PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(roleId);
/* 57 */     manager.onCharge(productId, isCard, isSuperPackage, logBI);
/* 58 */     PrepaidCenter.getInstance().update(roleId, manager);
/* 59 */     Out.info(new Object[] { "GM补单记录 roleId=", roleId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage), ",logBI=", Boolean.valueOf(logBI) });
/* 60 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 64 */     return 8240;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\PayHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */