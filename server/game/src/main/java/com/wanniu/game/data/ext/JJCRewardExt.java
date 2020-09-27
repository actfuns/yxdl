/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.JJCRewardCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JJCRewardExt
/*    */   extends JJCRewardCO
/*    */ {
/*    */   public Map<String, Integer> _rankReward;
/*    */   
/*    */   public void initProperty() {
/* 17 */     this._rankReward = new HashMap<>();
/* 18 */     if (StringUtil.isEmpty(this.rankReward)) {
/*    */       return;
/*    */     }
/* 21 */     String[] rewards = this.rankReward.split(";");
/* 22 */     for (String s : rewards) {
/* 23 */       String[] rw = s.split(":");
/* 24 */       if (rw.length >= 2)
/* 25 */         this._rankReward.put(rw[0], Integer.valueOf(Integer.parseInt(rw[1]))); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\JJCRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */