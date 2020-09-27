/*     */ package com.wanniu.game.request.player;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.proxy.ProxyType;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.playerHandler.getAreaLinesRequest")
/*     */ public class GetAreaLinesHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  37 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  39 */     final Area area = player.getArea();
/*  40 */     if (!area.isNormal() && area.sceneType != Const.SCENE_TYPE.CROSS_SERVER
/*  41 */       .getValue() && area.sceneType != Const.SCENE_TYPE.WORLD_BOSS
/*  42 */       .getValue()) {
/*  43 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
/*     */     }
/*     */     
/*  46 */     if (area.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() && GConfig.getInstance().isEnableProxy()) {
/*  47 */       final JSONObject json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_LINES, 
/*  48 */           Utils.toJSON(new Object[] { "areaId", Integer.valueOf(area.areaId), "logicServerId", Integer.valueOf(area.logicServerId) }));
/*  49 */       return new PomeloResponse()
/*     */         {
/*     */           protected void write() throws IOException {
/*  52 */             PlayerHandler.GetAreaLinesResponse.Builder res = PlayerHandler.GetAreaLinesResponse.newBuilder();
/*  53 */             res.setS2CCode(200);
/*  54 */             JSONArray arr = json.getJSONArray("lines");
/*  55 */             for (int i = 0; i < arr.size(); i++) {
/*  56 */               JSONObject json = arr.getJSONObject(i);
/*  57 */               PlayerHandler.AreaLineData.Builder line = PlayerHandler.AreaLineData.newBuilder();
/*  58 */               line.setIndex(json.getIntValue("lineIndex"));
/*  59 */               line.setInstanceId(json.getString("instanceId"));
/*  60 */               int curCount = json.getIntValue("curCount");
/*  61 */               if (curCount < area.prop.boundary) {
/*  62 */                 line.setState(0);
/*  63 */               } else if (curCount >= area.prop.boundary && curCount < area.fullCount) {
/*  64 */                 line.setState(1);
/*     */               } else {
/*  66 */                 line.setState(2);
/*     */               } 
/*  68 */               res.addS2CData(line);
/*     */             } 
/*  70 */             this.body.writeBytes(res.build().toByteArray());
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/*  76 */     final List<Area> areas = AreaManager.getInstance().getAreaMap().getAreas(area.areaId, area.logicServerId);
/*  77 */     Collections.sort(areas, new Comparator<Area>()
/*     */         {
/*     */           public int compare(Area o1, Area o2) {
/*  80 */             return (o1.lineIndex > o2.lineIndex) ? 1 : ((o1.lineIndex == o2.lineIndex) ? 0 : -1);
/*     */           }
/*     */         });
/*  83 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  86 */           PlayerHandler.GetAreaLinesResponse.Builder res = PlayerHandler.GetAreaLinesResponse.newBuilder();
/*  87 */           res.setS2CCode(200);
/*  88 */           for (Area area : areas) {
/*  89 */             PlayerHandler.AreaLineData.Builder line = PlayerHandler.AreaLineData.newBuilder();
/*  90 */             line.setIndex(area.lineIndex);
/*  91 */             line.setInstanceId(area.instanceId);
/*  92 */             int curCount = area.getPlayerNum();
/*  93 */             if (area.getPlayerNum() < area.prop.boundary) {
/*  94 */               line.setState(0);
/*  95 */             } else if (curCount >= area.prop.boundary && curCount < area.fullCount) {
/*  96 */               line.setState(1);
/*     */             } else {
/*  98 */               line.setState(2);
/*     */             } 
/* 100 */             res.addS2CData(line);
/*     */           } 
/* 102 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\GetAreaLinesHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */