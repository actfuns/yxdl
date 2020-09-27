/*    */ package com.wanniu.game.guild.guildBoss;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
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
/*    */ public class GuildBossAreaHurtRankManager
/*    */ {
/*    */   private WNPlayer player;
/*    */   
/*    */   public GuildBossAreaHurtRankManager(WNPlayer player) {
/* 36 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<RankBean> getAndSetRankBeanList(String guildId) {
/* 46 */     List<RankBean> list = GuildBossAreaHurtRankCenter.getInstance().getRankList(guildId);
/* 47 */     if (list == null) {
/* 48 */       String vl = GCache.hget(ConstsTR.guildBossHurtTR.value, guildId);
/* 49 */       if (!StringUtil.isEmpty(vl)) {
/* 50 */         list = JSON.parseArray(vl, RankBean.class);
/*    */       } else {
/* 52 */         list = new ArrayList<>();
/*    */       } 
/* 54 */       GuildBossAreaHurtRankCenter.getInstance().replaceIfnullShowData(guildId, list);
/*    */     } 
/* 56 */     return list;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<RankBean> getRankBeanListOnBegin(String guildId) {
/* 66 */     GuildRankBean guildBean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
/* 67 */     if (guildBean == null) {
/* 68 */       return null;
/*    */     }
/* 70 */     List<RankBean> list = guildBean.getHurtListWithLock();
/* 71 */     if (!list.isEmpty()) {
/* 72 */       Collections.sort(list, GuildBossAreaHurtRankCenter.SORT_HURT);
/*    */     }
/* 74 */     return list;
/*    */   }
/*    */ 
/*    */   
/*    */   public WNPlayer getPlayer() {
/* 79 */     return this.player;
/*    */   }
/*    */   
/*    */   public void setPlayer(WNPlayer player) {
/* 83 */     this.player = player;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossAreaHurtRankManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */