/*    */ package com.wanniu.game.request.daily;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.common.CommonUtil;
/*    */ import com.wanniu.game.daily.DailyActivityMgr;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.dailyActivityHandler.dailyActivityRequest")
/*    */ public class DailyActivityHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     return new PomeloResponse() {
/* 28 */         WNPlayer player = (WNPlayer)DailyActivityHandler.this.pak.getPlayer();
/*    */ 
/*    */         
/*    */         protected void write() throws IOException {
/* 32 */           pomelo.area.DailyActivityHandler.DailyActivityResponse.Builder res = pomelo.area.DailyActivityHandler.DailyActivityResponse.newBuilder();
/*    */           try {
/* 34 */             if (null == this.player) {
/* 35 */               res.setS2CCode(500);
/* 36 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 37 */               this.body.writeBytes(res.build().toByteArray());
/* 38 */               PlayerUtil.logWarnIfPlayerNull(DailyActivityHandler.this.pak);
/*    */               
/*    */               return;
/*    */             } 
/* 42 */             DailyActivityMgr mgr = this.player.dailyActivityMgr;
/* 43 */             res.setS2CCode(200);
/* 44 */             res.addAllS2CDailyLs(mgr.getDailyLs());
/* 45 */             res.setS2CTotalDegree(mgr.po.totalDegree);
/* 46 */             res.addAllS2CDegreeLs(mgr.getDegreeLs());
/* 47 */             res.setS2CWeekIndex(CommonUtil.getWeek());
/* 48 */             this.body.writeBytes(res.build().toByteArray());
/* 49 */           } catch (Exception err) {
/* 50 */             Out.error(new Object[] { err });
/* 51 */             res.setS2CCode(500);
/* 52 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daily\DailyActivityHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */