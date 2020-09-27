/*    */ package com.wanniu.game.activity;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.data.ActivityCO;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ActivityCenterManager {
/*    */   private static ActivityCenterManager instance;
/*    */   
/*    */   public static synchronized ActivityCenterManager getIntance() {
/* 17 */     if (instance == null)
/* 18 */       instance = new ActivityCenterManager(); 
/* 19 */     return instance;
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFundsNum(int serverId) {
/* 47 */     String data = GCache.hget(Integer.toString(serverId), ConstsTR.fundsTR.value);
/* 48 */     int num = 0;
/* 49 */     if (StringUtil.isEmpty(data)) {
/* 50 */       num = getJoinNum(serverId);
/* 51 */       GCache.hset(Integer.toString(serverId), ConstsTR.fundsTR.value, String.valueOf(num));
/*    */     } else {
/* 53 */       num = Integer.parseInt(data);
/*    */     } 
/* 55 */     return num;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addFundRecord(int serverId) {
/* 66 */     GCache.hincr(Integer.toString(serverId), ConstsTR.fundsTR.value, 1L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getJoinNum(int serverId) {
/* 76 */     int num = 0;
/* 77 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()));
/* 78 */     ActivityExt prop = null;
/* 79 */     Iterator<ActivityExt> iterator = props.iterator(); if (iterator.hasNext()) { ActivityCO p = (ActivityCO)iterator.next();
/* 80 */       prop = (ActivityExt)p; }
/*    */ 
/*    */     
/* 83 */     if (prop != null) {
/* 84 */       num = prop.joinNum;
/*    */     }
/* 86 */     return num;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\ActivityCenterManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */