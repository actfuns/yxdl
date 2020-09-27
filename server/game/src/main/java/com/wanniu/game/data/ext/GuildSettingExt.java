/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.GuildSettingCO;
/*    */ 
/*    */ 
/*    */ public class GuildSettingExt
/*    */   extends GuildSettingCO
/*    */ {
/*    */   public long selfOutMs;
/*    */   public long kickOutMs;
/*    */   public long fireOutMs;
/*    */   public long impeachMs;
/*    */   public long impeachTimeMs;
/*    */   public int guildBossBeginHours;
/*    */   public int guildBossBeginMinutes;
/*    */   public int guildBossEndHours;
/*    */   public int guildBossEndMinutes;
/*    */   
/*    */   public void initProperty() {
/* 21 */     this.selfOutMs = (this.selfOut * 60 * 1000);
/* 22 */     this.kickOutMs = (this.kickOut * 60 * 1000);
/* 23 */     this.fireOutMs = (this.fireOut * 60 * 1000);
/* 24 */     this.impeachMs = (this.impeach * 24 * 60 * 60 * 1000);
/* 25 */     this.impeachTimeMs = (this.impeachTime * 60 * 1000);
/*    */     
/* 27 */     if (!StringUtil.isEmpty(this.gBossOpenTime)) {
/* 28 */       String[] beginStrs = this.gBossOpenTime.split(":");
/* 29 */       this.guildBossBeginHours = Integer.parseInt(beginStrs[0]);
/* 30 */       this.guildBossBeginMinutes = Integer.parseInt(beginStrs[1]);
/*    */     } 
/*    */     
/* 33 */     if (!StringUtil.isEmpty(this.gBossCloseTime)) {
/* 34 */       String[] endStrs = this.gBossCloseTime.split(":");
/* 35 */       this.guildBossEndHours = Integer.parseInt(endStrs[0]);
/* 36 */       this.guildBossEndMinutes = Integer.parseInt(endStrs[1]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\GuildSettingExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */