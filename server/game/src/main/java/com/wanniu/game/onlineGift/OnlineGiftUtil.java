/*    */ package com.wanniu.game.onlineGift;
/*    */ 
/*    */ import com.wanniu.game.data.ext.OlGiftExt;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class OnlineGiftUtil
/*    */ {
/*    */   public static List<OlGiftExt> getPropList() {
/* 10 */     return OlGiftConfig.getInstance().getPropList();
/*    */   }
/*    */   
/*    */   public static OlGiftExt getPropById(int giftId) {
/* 14 */     return OlGiftConfig.getInstance().getPropById(giftId);
/*    */   }
/*    */   
/*    */   public static List<OlGiftExt> getPropListByLevel(int giftType, int upLevel, int level) {
/* 18 */     return OlGiftConfig.getInstance().getPropListByLevel(giftType, upLevel, level);
/*    */   }
/*    */   
/*    */   public static OlGiftExt getPropByLevelAndTime(int upLevel, int level, int time) {
/* 22 */     return OlGiftConfig.getInstance().getPropByLevelAndTime(upLevel, level, time);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\onlineGift\OnlineGiftUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */