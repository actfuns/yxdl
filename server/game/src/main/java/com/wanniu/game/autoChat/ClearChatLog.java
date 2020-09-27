/*    */ package com.wanniu.game.autoChat;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.game.JobFactory;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.ScheduledFuture;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClearChatLog
/*    */ {
/*    */   private static ClearChatLog ClearChatLog;
/*    */   private ScheduledFuture<?> autoClear;
/*    */   
/*    */   public static ClearChatLog getInstance() {
/* 30 */     if (ClearChatLog != null) {
/* 31 */       return ClearChatLog;
/*    */     }
/* 33 */     ClearChatLog = new ClearChatLog();
/* 34 */     return ClearChatLog;
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 39 */     this.autoClear = JobFactory.addScheduleJob(new Runnable()
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public void run()
/*    */           {
/* 48 */             List<String> list = GCache.lRangeAll("chatLog");
/* 49 */             int listSize = list.size();
/* 50 */             if (list != null && list.size() > 0) {
/* 51 */               HashSet<String> set = new HashSet<>(list);
/* 52 */               if (set.size() == 1 && list.size() >= 5) {
/* 53 */                 String playerId = set.iterator().next();
/* 54 */                 WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 55 */                 if (player != null) {
/* 56 */                   player.kick(Const.KickReason.GM_KICK);
/*    */                 }
/* 58 */                 PlayerPO po = PlayerUtil.getPlayerBaseData(playerId);
/*    */                 
/* 60 */                 long currentTime = System.currentTimeMillis() + 600000L;
/* 61 */                 Date date = new Date(currentTime);
/* 62 */                 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 63 */                 String nowTime = df.format(date);
/* 64 */                 Date parse = null;
/*    */                 try {
/* 66 */                   parse = df.parse(nowTime);
/* 67 */                 } catch (ParseException e) {
/* 68 */                   e.printStackTrace();
/*    */                 } 
/* 70 */                 System.out.println(nowTime);
/* 71 */                 po.forbidTalkTime = parse;
/* 72 */                 po.forbidTalkReason = "刷屏禁言10分钟";
/*    */               } 
/*    */             } 
/*    */ 
/*    */             
/* 77 */             GCache.remove("chatLog");
/*    */           }
/*    */         },  0L, 60000L);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\autoChat\ClearChatLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */