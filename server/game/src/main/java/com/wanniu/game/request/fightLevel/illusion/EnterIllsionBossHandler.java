/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TypeNameCO;
/*    */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.enterLllsionBossRequest")
/*    */ public class EnterIllsionBossHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 31 */     FightLevelHandler.EnterLllsionBossRequest req = FightLevelHandler.EnterLllsionBossRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 33 */     int monsterRereshId = req.getC2SId();
/* 34 */     Out.info(new Object[] { getClass().getName(), " : ", Integer.valueOf(monsterRereshId) });
/*    */     
/* 36 */     MonsterRefreshExt refreshCO = (MonsterRefreshExt)GameData.MonsterRefreshs.get(Integer.valueOf(monsterRereshId));
/* 37 */     TypeNameCO refreshTypeName = (TypeNameCO)GameData.TypeNames.get(Integer.valueOf(refreshCO.type));
/*    */     
/* 39 */     if (refreshCO == null || player.getLevel() < refreshTypeName.minLv || player.getLevel() > refreshTypeName.maxLv) {
/* 40 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LEVEL_NOT_LIMIT_ENTER"));
/*    */     }
/*    */     
/* 43 */     if (refreshCO.pointX > 0.0F && refreshCO.pointY > 0.0F) {
/* 44 */       int dstId = refreshCO.mapID; float dstX = refreshCO.pointX, dstY = refreshCO.pointY;
/* 45 */       GWorld.getInstance().ansycExec(() -> {
/*    */             String instanceId = player.getInstanceId();
/*    */             int oldAreaId = player.getAreaId();
/*    */             AreaUtil.enterArea(player, dstId, dstX, dstY);
/*    */             if (AreaUtil.needCreateArea(oldAreaId)) {
/*    */               AreaUtil.closeAreaNoPlayer(instanceId);
/*    */             }
/*    */           });
/*    */     } else {
/* 54 */       AreaUtil.enterArea(player, refreshCO.mapID);
/*    */     } 
/*    */     
/* 57 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 60 */           FightLevelHandler.EnterLllsionBossResponse.Builder res = FightLevelHandler.EnterLllsionBossResponse.newBuilder();
/* 61 */           res.setS2CCode(200);
/* 62 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\EnterIllsionBossHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */