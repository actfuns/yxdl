/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.TurnRewardCO;
/*    */ import java.util.HashMap;
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
/*    */ public class TurnRewardExt
/*    */   extends TurnRewardCO
/*    */ {
/*    */   public HashMap<String, Integer> getRewardMap;
/*    */   
/*    */   public void initProperty() {
/* 21 */     this.getRewardMap = new HashMap<>();
/*    */     
/* 23 */     String[] getRewardStrs = this.getReward.split(";");
/* 24 */     for (String getRewardSubStr : getRewardStrs) {
/* 25 */       String[] getRewardSubStrs = getRewardSubStr.split(":");
/*    */       
/* 27 */       this.getRewardMap.put(getRewardSubStrs[0], Integer.valueOf(Integer.parseInt(getRewardSubStrs[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TurnRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */