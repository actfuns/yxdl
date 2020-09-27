/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.MonsterRefreshCO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getLllsionBossInfoRequest")
/*    */ public class GetIllsionBossInfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           FightLevelHandler.GetLllsionBossInfoResponse.Builder res = FightLevelHandler.GetLllsionBossInfoResponse.newBuilder();
/*    */           
/* 38 */           for (MonsterRefreshCO refreshCO : GameData.MonsterRefreshs.values()) {
/* 39 */             Date bornBeginTime = AreaUtil.formatToday(refreshCO.rebornBeginTime);
/* 40 */             Date bornEndTime = AreaUtil.formatToday(refreshCO.rebornEndTime);
/* 41 */             FightLevelHandler.IllsionBossInfo.Builder info = FightLevelHandler.IllsionBossInfo.newBuilder();
/* 42 */             info.setId(refreshCO.iD);
/*    */             
/* 44 */             Long nextRefreshTime = Long.valueOf(0L);
/*    */             
/* 46 */             if (System.currentTimeMillis() < bornBeginTime.getTime()) {
/* 47 */               nextRefreshTime = Long.valueOf(bornBeginTime.getTime());
/* 48 */             } else if (System.currentTimeMillis() < bornEndTime.getTime()) {
/* 49 */               nextRefreshTime = Long.valueOf((refreshCO.coolDownTime * Const.Time.Minute.getValue()) - (
/* 50 */                   System.currentTimeMillis() - bornBeginTime.getTime()) % (refreshCO.coolDownTime * Const.Time.Minute.getValue()) + 
/* 51 */                   System.currentTimeMillis());
/*    */             } else {
/* 53 */               nextRefreshTime = Long.valueOf(DateUtil.getDateAfter(bornBeginTime, 1).getTimeInMillis());
/*    */             } 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 59 */             Date date = new Date();
/* 60 */             date.setTime(nextRefreshTime.longValue());
/* 61 */             info.setNextRefreshTime(nextRefreshTime.longValue() - System.currentTimeMillis());
/* 62 */             res.addBossInfos(info);
/*    */           } 
/*    */           
/* 65 */           res.setS2CCode(200);
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\GetIllsionBossInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */