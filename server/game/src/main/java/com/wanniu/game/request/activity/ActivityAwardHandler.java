/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityAwardRequest")
/*    */ public class ActivityAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     ActivityHandler.ActivityAwardRequest req = ActivityHandler.ActivityAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int awardId = req.getS2CAwardId();
/* 23 */     final int activityId = req.getS2CActivityId();
/*    */     
/* 25 */     final ActivityHandler.ActivityAwardResponse.Builder res = player.activityManager.activityAward(awardId, activityId);
/*    */     
/* 27 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 29 */           if (res.getS2CCode() == 200) {
/* 30 */             player.activityManager.updateSuperScriptList();
/*    */             
/* 32 */             res.setS2CMsg(LangService.getValue("ACTIVITY_RECEIVE"));
/* 33 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/* 35 */             ActivityExt propCenter = player.activityManager.findActivityById(activityId);
/* 36 */             Out.info(new Object[] { this.val$player.getId(), ":", propCenter.activity, "领取成功,礼包id:", Integer.valueOf(this.val$awardId) });
/*    */           } else {
/* 38 */             res.setS2CCode(500);
/* 39 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */