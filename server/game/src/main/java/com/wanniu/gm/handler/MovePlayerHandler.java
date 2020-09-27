/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.player.PlayerDao;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.player.po.AllBlobPO;
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
/*    */ public class MovePlayerHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 23 */     String id = arr.getString(0);
/* 24 */     int areaId = arr.getIntValue(1);
/* 25 */     WNPlayer player = PlayerUtil.getOnlinePlayer(id);
/* 26 */     if (player == null) {
/* 27 */       AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
/* 28 */       player = new WNPlayer(allBlobData);
/*    */     } 
/* 30 */     AreaUtil.dispatchByAreaId(player, areaId, null);
/* 31 */     return (GMResponse)new GMStateResponse(1);
/*    */   }
/*    */   
/*    */   public short getType() {
/* 35 */     return 12292;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\MovePlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */