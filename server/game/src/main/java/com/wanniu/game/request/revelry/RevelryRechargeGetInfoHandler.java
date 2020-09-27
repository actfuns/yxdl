/*    */ package com.wanniu.game.request.revelry;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.RechargeActivityService;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.StartSerRechargeCO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.RevelryRechargePO;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import pomelo.revelry.ActivityRevelryHandler;
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
/*    */ @GClientEvent("revelry.activityRevelryHandler.revelryRechargeGetInfoRequest")
/*    */ public class RevelryRechargeGetInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     ActivityRevelryHandler.RevelryRechargeGetInfoRequest req = ActivityRevelryHandler.RevelryRechargeGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     int day = req.getDay();
/* 32 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 34 */     final ActivityRevelryHandler.RevelryRechargeGetInfoResponse.Builder result = ActivityRevelryHandler.RevelryRechargeGetInfoResponse.newBuilder();
/*    */     
/* 36 */     RevelryRechargePO po = RechargeActivityService.getInstance().getRevelryRechargeInfo(player.getId(), day);
/* 37 */     for (StartSerRechargeCO template : GameData.findStartSerRecharges(v -> (v.date == day))) {
/* 38 */       ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder awardInfo = ActivityRevelryHandler.RevelryRechargeAwardInfo.newBuilder();
/* 39 */       awardInfo.setId(template.iD);
/* 40 */       awardInfo.setCurrNum((po == null) ? 0 : po.getRmb());
/* 41 */       awardInfo.setNeedNum(template.rechargeNumber);
/* 42 */       awardInfo.setState((po == null) ? 0 : ((Integer)po.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue());
/* 43 */       if (StringUtils.isNotEmpty(template.reward1)) {
/* 44 */         ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
/* 45 */         item.setCode(template.reward1);
/* 46 */         item.setGroupCount(template.num1);
/* 47 */         awardInfo.addItem(item);
/*    */       } 
/* 49 */       if (StringUtils.isNotEmpty(template.reward2)) {
/* 50 */         ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
/* 51 */         item.setCode(template.reward2);
/* 52 */         item.setGroupCount(template.num2);
/* 53 */         awardInfo.addItem(item);
/*    */       } 
/* 55 */       if (StringUtils.isNotEmpty(template.reward3)) {
/* 56 */         ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
/* 57 */         item.setCode(template.reward3);
/* 58 */         item.setGroupCount(template.num3);
/* 59 */         awardInfo.addItem(item);
/*    */       } 
/* 61 */       if (StringUtils.isNotEmpty(template.reward4)) {
/* 62 */         ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
/* 63 */         item.setCode(template.reward4);
/* 64 */         item.setGroupCount(template.num4);
/* 65 */         awardInfo.addItem(item);
/*    */       } 
/* 67 */       if (StringUtils.isNotEmpty(template.reward5)) {
/* 68 */         ActivityRevelryHandler.RevelryRechargeItem.Builder item = ActivityRevelryHandler.RevelryRechargeItem.newBuilder();
/* 69 */         item.setCode(template.reward5);
/* 70 */         item.setGroupCount(template.num5);
/* 71 */         awardInfo.addItem(item);
/*    */       } 
/* 73 */       result.addInfo(awardInfo);
/*    */     } 
/*    */     
/* 76 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 79 */           result.setS2CCode(200);
/* 80 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryRechargeGetInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */