/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import com.wanniu.game.data.ActivityCO;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ActivityExt
/*    */   extends ActivityCO
/*    */ {
/*    */   public long beginTime;
/*    */   public long endTime;
/*    */   
/*    */   public void initProperty() {
/* 14 */     Date dateBegin = DateUtil.format(this.openTime);
/* 15 */     this.beginTime = dateBegin.getTime();
/* 16 */     Date dateEnd = DateUtil.format(this.closeTime);
/* 17 */     this.endTime = dateEnd.getTime();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ActivityExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */