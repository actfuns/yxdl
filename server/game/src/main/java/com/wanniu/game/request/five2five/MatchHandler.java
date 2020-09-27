/*    */ package com.wanniu.game.request.five2five;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.daily.DailyActivityMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.solo.SoloRequestFilter;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.dailyActivity.DailyActivity;
/*    */ import pomelo.five2five.Five2FiveHandler;
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
/*    */ @GClientEvent("five2five.five2FiveHandler.five2FiveMatchRequest")
/*    */ public class MatchHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         private static final int hdid = 8;
/*    */ 
/*    */         
/*    */         protected void write() throws IOException {
/* 37 */           Five2FiveHandler.Five2FiveMatchRequest req = Five2FiveHandler.Five2FiveMatchRequest.parseFrom(MatchHandler.this.pak.getRemaingBytes());
/* 38 */           int matchOrReMatch = req.getMatchOrReMatch();
/*    */           
/* 40 */           Five2FiveHandler.Five2FiveMatchResponse.Builder res = Five2FiveHandler.Five2FiveMatchResponse.newBuilder();
/* 41 */           DailyActivityMgr mgr = player.dailyActivityMgr;
/* 42 */           List<DailyActivity.DailyInfo> dailyInfoList = mgr.getDailyLs();
/* 43 */           List<String> itemList = new ArrayList<>();
/* 44 */           int CurNum1 = 0;
/* 45 */           int maxNum1 = 0;
/* 46 */           for (DailyActivity.DailyInfo info : dailyInfoList) {
/* 47 */             int id = info.getId();
/* 48 */             int CurNum = info.getCurNum();
/* 49 */             int maxNum = info.getMaxNum();
/* 50 */             if (info.getId() == 8) {
/* 51 */               CurNum1 = CurNum;
/* 52 */               maxNum1 = maxNum;
/*    */             } 
/*    */           } 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 75 */           if (maxNum1 <= CurNum1) {
/* 76 */             res.setS2CCode(500);
/*    */             
/* 78 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 83 */           player.five2FiveManager.applyFive2FiveMatch(res, matchOrReMatch);
/* 84 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\five2five\MatchHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */