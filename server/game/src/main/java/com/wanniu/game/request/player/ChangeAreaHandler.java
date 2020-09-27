/*     */ package com.wanniu.game.request.player;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.player.PathService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerTempPO;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ @GClientEvent("area.playerHandler.changeAreaRequest")
/*     */ public class ChangeAreaHandler
/*     */   extends ChangeAreaFilter
/*     */ {
/*     */   public PomeloResponse request(WNPlayer player) throws Exception {
/*  34 */     PlayerHandler.ChangeAreaRequest req = PlayerHandler.ChangeAreaRequest.parseFrom(this.pak.getRemaingBytes());
/*  35 */     String pointId = req.getC2SPointId();
/*  36 */     int areaId = 0;
/*  37 */     float targetX = 0.0F;
/*  38 */     float targetY = 0.0F;
/*     */     
/*  40 */     Area area = player.getArea();
/*  41 */     PlayerTempPO tempData = player.getPlayerTempData();
/*     */     
/*  43 */     if ("0".equals(pointId)) {
/*  44 */       areaId = tempData.historyAreaId;
/*  45 */       targetX = tempData.historyX;
/*  46 */       targetY = tempData.historyY;
/*  47 */       float[] arrayOfFloat = PathService.findToAreaXYByPointId(areaId, pointId);
/*  48 */       if (arrayOfFloat != null) {
/*  49 */         targetX = arrayOfFloat[0];
/*  50 */         targetY = arrayOfFloat[1];
/*     */       } 
/*     */     } else {
/*  53 */       areaId = PathService.findToAreaByPointId(player.getAreaId(), pointId);
/*  54 */       if (areaId == tempData.historyAreaId) {
/*  55 */         targetX = tempData.historyX;
/*  56 */         targetY = tempData.historyY;
/*     */       } 
/*     */     } 
/*  59 */     if (areaId == 0) {
/*  60 */       return (PomeloResponse)new ErrorResponse(player.getAreaId() + " - " + pointId + " : " + LangService.getValue("AREA_ID_NULL"));
/*     */     }
/*  62 */     float[] xy = PathService.findToAreaXYByAreaId(area.areaId, areaId);
/*  63 */     if (xy == null) {
/*  64 */       JSONObject json = area.getBornPlace(areaId);
/*  65 */       xy = new float[2];
/*  66 */       xy[0] = json.getFloatValue("x");
/*  67 */       xy[1] = json.getFloatValue("y");
/*  68 */       area.prop.toAreaXY.put(Integer.valueOf(areaId), xy);
/*     */     } 
/*  70 */     if (xy != null && xy[0] != 0.0F && xy[1] != 0.0F) {
/*  71 */       targetX = xy[0];
/*  72 */       targetY = xy[1];
/*     */     } 
/*     */     
/*  75 */     final PlayerHandler.ChangeAreaResponse.Builder res = PlayerHandler.ChangeAreaResponse.newBuilder();
/*     */     
/*  77 */     if (area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue() || area.sceneType == Const.SCENE_TYPE.GUILD_FORT_PVP.getValue()) {
/*  78 */       String str = player.guildFortManager.handleChangeArea(areaId);
/*  79 */       if (str != null) {
/*  80 */         return (PomeloResponse)new ErrorResponse(str);
/*     */       }
/*  82 */       res.setS2CCode(200);
/*  83 */       return new PomeloResponse()
/*     */         {
/*     */           protected void write() throws IOException {
/*  86 */             this.body.writeBytes(res.build().toByteArray());
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/*  92 */     MapBase sceneProp = AreaUtil.getAreaProp(areaId);
/*  93 */     String result = AreaUtil.canEnterArea(sceneProp, player);
/*  94 */     if (result != null) {
/*  95 */       return (PomeloResponse)new ErrorResponse(result);
/*     */     }
/*     */     
/*  98 */     Out.debug(new Object[] { Integer.valueOf(sceneProp.mapID), " ===changeArea=== x:", Float.valueOf(targetX), ", y:", Float.valueOf(targetY) });
/*  99 */     res.setS2CCode(200);
/* 100 */     if ((area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP.getValue()) && area.hasHighQualityItem()) {
/* 101 */       player.puchFuncGoToPickItem();
/*     */     
/*     */     }
/* 104 */     else if (req.getC2SType() == 0 && (sceneProp.type == Const.SCENE_TYPE.FIGHT_LEVEL
/* 105 */       .getValue() || area.sceneType == Const.SCENE_TYPE.LOOP
/* 106 */       .getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION_2
/* 107 */       .getValue())) {
/*     */       
/* 109 */       res.setS2CEnterTips(String.valueOf(sceneProp.mapID));
/*     */     } else {
/* 111 */       int dstId = areaId;
/* 112 */       float dstX = targetX, dstY = targetY;
/* 113 */       GWorld.getInstance().ansycExec(() -> {
/*     */             String instanceId = player.getInstanceId();
/*     */             
/*     */             int oldAreaId = player.getAreaId();
/*     */             
/*     */             AreaUtil.enterArea(player, dstId, dstX, dstY);
/*     */             if (AreaUtil.needCreateArea(oldAreaId)) {
/*     */               AreaUtil.closeAreaNoPlayer(instanceId);
/*     */             }
/*     */           });
/*     */     } 
/* 124 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 127 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ChangeAreaHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */