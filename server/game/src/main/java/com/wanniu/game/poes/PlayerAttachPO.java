/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.guild.guildFort.dao.GuildFortAwardPO;
/*    */ import com.wanniu.game.item.po.MedalPO;
/*    */ import com.wanniu.game.player.po.MiscData;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_attach")
/*    */ public class PlayerAttachPO
/*    */   extends GEntity
/*    */ {
/*    */   public int sysSet;
/* 22 */   public MiscData miscData = new MiscData();
/*    */ 
/*    */   
/*    */   public int guildBlessToday;
/*    */ 
/*    */   
/*    */   public int guildSkillUpToday;
/*    */ 
/*    */   
/*    */   public int guildDonateToday;
/*    */ 
/*    */   
/*    */   public MedalPO medal;
/*    */   
/*    */   public Map<String, String> config;
/*    */   
/*    */   public List<Integer> firstKillMonsterIds;
/*    */   
/*    */   public Map<Integer, Object> sceneProgress;
/*    */   
/*    */   public VipPO vipData;
/*    */   
/*    */   public int KillBossCount;
/*    */   
/*    */   public GuildFortAwardPO guildFortDailyAwards;
/*    */ 
/*    */   
/*    */   public PlayerAttachPO() {
/* 50 */     this.KillBossCount = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addFirstMonsterId(int monsterId) {
/* 55 */     this.firstKillMonsterIds.add(Integer.valueOf(monsterId));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerAttachPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */