/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.NormalMapCO;
/*    */ import com.wanniu.gm.GMEvent;
/*    */ import com.wanniu.gm.GMJsonResponse;
/*    */ import com.wanniu.gm.GMResponse;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GMEvent
/*    */ public class AreaDataHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 26 */     List<Object> list = new ArrayList();
/* 27 */     for (NormalMapCO m : GameData.NormalMaps.values()) {
/* 28 */       Map<String, String> map = new HashMap<>();
/* 29 */       map.put("id", String.valueOf(m.mapID));
/* 30 */       map.put("text", m.name + " " + m.reqLevel + "级");
/* 31 */       list.add(map);
/*    */     } 
/* 33 */     JSONObject jo = new JSONObject();
/* 34 */     jo.put("data", list);
/* 35 */     return (GMResponse)new GMJsonResponse(jo.toJSONString());
/*    */   }
/*    */   
/*    */   public short getType() {
/* 39 */     return 12291;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\AreaDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */