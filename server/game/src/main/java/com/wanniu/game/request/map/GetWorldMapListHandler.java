/*    */ package com.wanniu.game.request.map;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.AreaDataConfig;
/*    */ import com.wanniu.game.data.base.MapBase;
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
/*    */ @GClientEvent("area.mapHandler.getWorldMapListRequest")
/*    */ public class GetWorldMapListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           MapHandler.GetWorldMapListResponse.Builder res = MapHandler.GetWorldMapListResponse.newBuilder();
/* 30 */           List<MapHandler.WorldMap> data = new ArrayList<>();
/* 31 */           List<MapBase> props = AreaDataConfig.getInstance().find(t -> 
/* 32 */               (t.type >= 1 && t.type <= 2));
/*    */           
/* 34 */           props.forEach(prop -> {
/*    */                 MapHandler.WorldMap.Builder map = MapHandler.WorldMap.newBuilder();
/*    */                 map.setId(prop.mapID);
/*    */                 map.setIsOpen(1);
/*    */                 data.add(map.build());
/*    */               });
/* 40 */           res.addAllData(data);
/* 41 */           res.setS2CCode(200);
/* 42 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\map\GetWorldMapListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */