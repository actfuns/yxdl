/*    */ package com.wanniu.gm.handler;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.wanniu.game.data.base.DEquipBase;
/*    */ import com.wanniu.game.data.base.DItemBase;
/*    */ import com.wanniu.game.item.ItemConfig;
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
/*    */ public class ItemDataHandler
/*    */   extends GMBaseHandler
/*    */ {
/*    */   public GMResponse execute(JSONArray arr) {
/* 27 */     List<Object> list = new ArrayList();
/* 28 */     for (DItemBase it : ItemConfig.getInstance().getItemTemplates().values()) {
/* 29 */       Map<String, String> map = new HashMap<>();
/* 30 */       map.put("id", it.code);
/* 31 */       map.put("text", it.name);
/* 32 */       list.add(map);
/*    */     } 
/* 34 */     for (DEquipBase it : ItemConfig.getInstance().getEquipTemplates().values()) {
/* 35 */       Map<String, String> map = new HashMap<>();
/* 36 */       map.put("id", it.code);
/* 37 */       map.put("text", it.name);
/* 38 */       list.add(map);
/*    */     } 
/* 40 */     return (GMResponse)new GMJsonResponse(JSON.toJSONString(list));
/*    */   }
/*    */   
/*    */   public short getType() {
/* 44 */     return 12336;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\handler\ItemDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */