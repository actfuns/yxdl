/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.proxy.ProxyClient;
/*    */ import com.wanniu.core.proxy.ProxyType;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.area.AreaData;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.Utils;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.cross.CrossServerArea;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
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
/*    */ @GClientEvent("area.playerHandler.transByInstanceIdRequest")
/*    */ public class TransByInstanceIdHandler
/*    */   extends ChangeAreaFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 38 */     PlayerHandler.TransByInstanceIdRequest req = PlayerHandler.TransByInstanceIdRequest.parseFrom(this.pak.getRemaingBytes());
/* 39 */     String instanceId = req.getC2SInstanceId();
/* 40 */     if (StringUtil.isEmpty(instanceId)) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     }
/* 43 */     if (instanceId.equals(player.getInstanceId())) {
/* 44 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LINE_CHANGE_UNECESSARY"));
/*    */     }
/*    */     
/* 47 */     Area area = player.getArea();
/* 48 */     if (!area.isNormal() && area.sceneType != Const.SCENE_TYPE.CROSS_SERVER
/* 49 */       .getValue() && area.sceneType != Const.SCENE_TYPE.WORLD_BOSS
/* 50 */       .getValue()) {
/* 51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
/*    */     }
/*    */     
/* 54 */     boolean newCrossArea = false;
/* 55 */     Area targetArea = AreaUtil.getArea(instanceId);
/* 56 */     if (targetArea == null && area.sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue() && GConfig.getInstance().isEnableProxy()) {
/* 57 */       TeamData team = player.getTeamManager().getTeam();
/* 58 */       int count = (team == null) ? 1 : team.memberCount();
/* 59 */       JSONObject json = Utils.toJSON(new Object[] { "instanceId", instanceId, "count", Integer.valueOf(count) });
/* 60 */       json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_TRANS_LINE, json);
/* 61 */       if (json.containsKey("csNode")) {
/* 62 */         AreaData areaData = new AreaData(area.areaId, instanceId);
/* 63 */         JSONObject pos = PlayerUtil.getPlayerPosition(player);
/* 64 */         areaData.targetX = pos.getIntValue("x");
/* 65 */         areaData.targetY = pos.getIntValue("y");
/* 66 */         targetArea = AreaUtil.bindCrossServerArea(player, json, crossArea -> {
/*    */               AreaUtil.dispatchByInstanceId(player, areaData);
/*    */               player.sendSysTip(LangService.getValue("LINE_CHANGE_SUCESS"), Const.TipsType.BLACK);
/*    */             });
/* 70 */         newCrossArea = true;
/*    */       } 
/*    */     } 
/*    */     
/* 74 */     if (targetArea == null || targetArea.logicServerId != area.logicServerId || targetArea.areaId != area.areaId || targetArea
/*    */       
/* 76 */       .isFull()) {
/* 77 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
/*    */     }
/*    */     
/* 80 */     if (!newCrossArea) {
/* 81 */       AreaData areaData = new AreaData(area.areaId, instanceId);
/* 82 */       JSONObject pos = PlayerUtil.getPlayerPosition(player);
/* 83 */       areaData.targetX = pos.getIntValue("x");
/* 84 */       areaData.targetY = pos.getIntValue("y");
/*    */       
/* 86 */       targetArea = AreaUtil.dispatchByInstanceId(player, areaData);
/* 87 */       if (targetArea != null) {
/* 88 */         player.sendSysTip(LangService.getValue("LINE_CHANGE_SUCESS"), Const.TipsType.BLACK);
/*    */       } else {
/* 90 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("LINE_CHANGE_FAILED"));
/*    */       } 
/*    */     } 
/*    */     
/* 94 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 97 */           PlayerHandler.TransByInstanceIdResponse.Builder res = PlayerHandler.TransByInstanceIdResponse.newBuilder();
/* 98 */           res.setS2CCode(200);
/* 99 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\TransByInstanceIdHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */