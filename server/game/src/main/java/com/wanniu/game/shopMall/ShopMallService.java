/*    */ package com.wanniu.game.shopMall;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.game.JobFactory;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopMallService
/*    */ {
/*    */   private ShopMallService() {
/* 23 */     resetWeekBuy();
/*    */   }
/*    */   
/*    */   private static final class Holder {
/* 27 */     public static final ShopMallService instance = new ShopMallService();
/*    */   }
/*    */   
/*    */   public static ShopMallService getInstance() {
/* 31 */     return Holder.instance;
/*    */   }
/*    */   
/*    */   public Date getResetTime() {
/* 35 */     Calendar monDay = Calendar.getInstance();
/* 36 */     monDay.set(7, 2);
/* 37 */     monDay.set(11, 5);
/* 38 */     monDay.set(12, 0);
/* 39 */     monDay.set(13, 0);
/* 40 */     monDay.set(14, 0);
/* 41 */     return monDay.getTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void resetWeekBuy() {
/* 48 */     Date monday = getResetTime();
/*    */     
/* 50 */     long delay = monday.getTime() - System.currentTimeMillis();
/* 51 */     if (delay < 0L) {
/* 52 */       delay += (Const.Time.Day.getValue() * 7);
/*    */     }
/* 54 */     Out.info(new Object[] { "shopMall resetWeekBuy delay : ", Long.valueOf(delay) });
/* 55 */     JobFactory.addFixedRateJob(() -> { Out.info(new Object[] { "resetWeekBuy..." }, ); Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers(); WNPlayer player = null; for (GPlayer gplayer : players.values()) { player = (WNPlayer)gplayer; player.shopMallManager.refreshNewWeek(); }  }delay, Const.Time.Day
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
/* 66 */         .getValue());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\shopMall\ShopMallService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */