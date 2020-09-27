/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechSkill;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ @DBTable("player_guild")
/*    */ public class PlayerGuildPO
/*    */   extends GEntity
/*    */ {
/* 35 */   public Map<String, Integer> totalContributionMap = new HashMap<>();
/* 36 */   public Map<Integer, Integer> contributeTimesMap = new HashMap<>();
/* 37 */   public Date lastSelfExitTime = new Date(0L);
/* 38 */   public Date joinDungeonTime = new Date(0L);
/* 39 */   public Date refreshTime = new Date(0L);
/* 40 */   public List<Integer> buffIds = new ArrayList<>();
/* 41 */   public int[] blessRecState = new int[3]; public PlayerGuildPO() {
/* 42 */     for (int i = 0; i < this.blessRecState.length; i++) {
/* 43 */       this.blessRecState[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
/*    */     }
/* 45 */     this.skills = new HashMap<>();
/* 46 */     this.boughtList = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public int contribution;
/*    */   public int depositCount;
/*    */   public int blessCount;
/*    */   public String joinDungeonGuildId;
/*    */   public int buffTime;
/*    */   public Map<Integer, GuildTechSkill> skills;
/*    */   public List<Integer> boughtList;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerGuildPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */