/*    */ package com.wanniu.game.request.map;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.WorldZoneCO;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.MapHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mapHandler.getMapListRequest")
/*    */ public class GetMapListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     MapHandler.GetMapListRequest req = MapHandler.GetMapListRequest.parseFrom(this.pak.getRemaingBytes());
/* 28 */     final int mapId = req.getC2SMapId();
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           MapHandler.GetMapListResponse.Builder res = MapHandler.GetMapListResponse.newBuilder();
/*    */           
/* 35 */           List<Integer> result = new ArrayList<>();
/* 36 */           List<WorldZoneCO> maps = GameData.findWorldZones(t -> (t.followMapID == mapId));
/* 37 */           maps.forEach(map -> {
/*    */               
/*    */               });
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 44 */           res.setS2CCode(200);
/* 45 */           res.addAllS2CMapIds(result);
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\map\GetMapListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */