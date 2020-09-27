/*    */ package com.wanniu.game.request.map;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MapHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mapHandler.getNpcListRequest")
/*    */ public class GetNpcListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 27 */     final JSONArray arr = JSON.parseArray(player.getXmdsManager().getAllNpcInfo(player.getInstanceId()));
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           MapHandler.GetNpcListResponse.Builder res = MapHandler.GetNpcListResponse.newBuilder();
/* 33 */           res.setS2CCode(200);
/*    */           
/* 35 */           for (int i = 0; i > arr.size(); i++) {
/* 36 */             JSONObject json = arr.getJSONObject(i);
/* 37 */             MapHandler.MapUnit.Builder unit = MapHandler.MapUnit.newBuilder();
/* 38 */             unit.setTemplateId(json.getIntValue("templateId"));
/* 39 */             int x = Math.round(json.getFloatValue("x"));
/* 40 */             int y = Math.round(json.getFloatValue("y"));
/* 41 */             unit.setX(x);
/* 42 */             unit.setY(y);
/*    */             
/* 44 */             res.addData(unit);
/*    */           } 
/*    */           
/* 47 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\map\GetNpcListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */