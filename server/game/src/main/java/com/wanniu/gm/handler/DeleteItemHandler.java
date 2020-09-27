/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.player.po.AllBlobPO;
/*    */ import com.wanniu.gm.GMErrorResponse;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import com.wanniu.gm.GMStateResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class DeleteItemHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 23 */     String id = arr.getString(0);
/* 24 */     String itemId = arr.getString(1);
/* 25 */     int num = arr.getIntValue(2);
/* 26 */     int deleteType = arr.getIntValue(3);
/* 27 */     if (num < 0) {
/* 28 */       return (GMResponse)new GMErrorResponse();
/*    */     }
/* 30 */     WNPlayer player = PlayerUtil.findPlayer(id);
/* 31 */     if (player == null) {
/* 32 */       AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
/* 33 */       player = new WNPlayer(allBlobData);
/*    */     } 
/* 35 */     if (deleteType == 0) {
/* 36 */       player.bag.gmDeleteItemById(itemId, num);
/* 37 */       player.bag.update();
/* 38 */     } else if (deleteType == 1) {
/* 39 */       player.wareHouse.gmDeleteItemById(itemId, num);
/* 40 */       player.wareHouse.update();
/*    */     } 
/* 42 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 46 */     return 12322;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\DeleteItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */