/*    */ package com.wanniu.game.request.resource;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ResourceHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.resourceHandler.queryAreaDataRequest")
/*    */ public class QueryAreaDataHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 28 */     final Area area = player.getArea();
/* 29 */     if (area.npcDatas == null && area.isNormal()) {
/* 30 */       String units_str = player.getXmdsManager().getAllUnitInfo(player.getInstanceId());
/* 31 */       JSONArray npcs_json = JSON.parseArray(units_str);
/* 32 */       ResourceHandler.QueryAreaDataResponse.Builder res = ResourceHandler.QueryAreaDataResponse.newBuilder();
/* 33 */       res.setS2CCode(200);
/* 34 */       for (int i = 0; i < npcs_json.size(); i++) {
/* 35 */         JSONObject unit = npcs_json.getJSONObject(i);
/* 36 */         if ("XmdsInstanceNPC".equals(unit.get("type"))) {
/* 37 */           ResourceHandler.Npc.Builder npc = ResourceHandler.Npc.newBuilder();
/* 38 */           npc.setTemplateId(unit.getIntValue("templateId"));
/* 39 */           npc.setId(unit.getIntValue("ObjectId"));
/* 40 */           res.addS2CNpcs(npc);
/*    */         } 
/*    */       } 
/* 43 */       area.npcDatas = res.build().toByteArray();
/*    */     } 
/*    */     
/* 46 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 49 */           this.body.writeBytes((area.npcDatas == null) ? ResourceHandler.QueryAreaDataResponse.newBuilder().setS2CCode(200).build().toByteArray() : area.npcDatas);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 55 */     return 1283;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\resource\QueryAreaDataHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */