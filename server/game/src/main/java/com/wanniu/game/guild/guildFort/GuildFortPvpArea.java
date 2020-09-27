/*     */ package com.wanniu.game.guild.guildFort;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.DamageHealVO;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ public class GuildFortPvpArea
/*     */   extends Area {
/*     */   private GuildFort fort;
/*  22 */   private Map<String, Integer> playerEnterCount = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*     */   public GuildFortPvpArea(JSONObject opts) {
/*  26 */     super(opts);
/*  27 */     int fortId = opts.getIntValue("fortId");
/*  28 */     this.fort = GuildFortCenter.getInstance().getFort(fortId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBattleReport(List<DamageHealVO> datas) {
/*  37 */     if (this.fort.isBattleOver()) {
/*     */       return;
/*     */     }
/*  40 */     if (datas != null && !datas.isEmpty()) {
/*  41 */       for (DamageHealVO heal : datas) {
/*  42 */         if (heal.TotalDamage <= 0) {
/*  43 */           Out.error(new Object[] { "Damage onBattleReport value exception, val=", Integer.valueOf(heal.TotalDamage) });
/*     */         }
/*     */         
/*  46 */         if (heal.TotalHealing <= 0) {
/*  47 */           Out.error(new Object[] { "Healing onBattleReport value exception, val=", Integer.valueOf(heal.TotalHealing) });
/*     */         }
/*     */         
/*  50 */         WNPlayer player = getPlayer(heal.PlayerUUID);
/*  51 */         if (player == null) {
/*  52 */           Out.warn(new Object[] { "player null onBattleReport" });
/*     */           continue;
/*     */         } 
/*  55 */         int count = getEnterCount(player.getId());
/*  56 */         this.fort.onBattleReport(player, heal, count);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/*  66 */     super.onPlayerEntered(player);
/*  67 */     this.fort.onPlayerEntered(player);
/*  68 */     addEnterCount(player);
/*     */   }
/*     */   
/*     */   private void addEnterCount(WNPlayer player) {
/*  72 */     Integer count = this.playerEnterCount.get(player.player.id);
/*  73 */     if (count == null) {
/*  74 */       this.playerEnterCount.put(player.player.id, Integer.valueOf(1));
/*     */     } else {
/*  76 */       this.playerEnterCount.put(player.player.id, Integer.valueOf(count.intValue() + 1));
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getEnterCount(String playerId) {
/*  81 */     Integer count = this.playerEnterCount.get(playerId);
/*  82 */     if (count == null) {
/*  83 */       return 0;
/*     */     }
/*  85 */     return count.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForce(WNPlayer player) {
/*  96 */     if (this.fort.isDefenserMember(player.guildManager.getGuildId())) {
/*  97 */       player.setForce(Const.AreaForce.FORCEA.value);
/*     */     } else {
/*  99 */       player.setForce(Const.AreaForce.FORCEB.value);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean noCloseIfNoPlayer() {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
/* 117 */     super.onPlayerDeadByPlayer(deadPlayer, hitPlayer, x, y);
/* 118 */     this.fort.onKilledPlayer(hitPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
/* 124 */     super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);
/*     */     
/* 126 */     this.fort.onKilledFlag(player, monsterId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onAddBuff(GuildFortContenderPO contender) {
/* 134 */     for (String pid : this.actors.keySet()) {
/* 135 */       WNPlayer player = PlayerUtil.getOnlinePlayer(pid);
/* 136 */       if (player != null && player.guildManager.guild != null && 
/* 137 */         player.guildManager.getGuildId().equals(contender.guildId)) {
/* 138 */         Map<String, Integer> map = new HashMap<>();
/* 139 */         map.put(Const.PlayerBtlData.Attack.toString(), Integer.valueOf(contender.attBuff));
/* 140 */         map.put(Const.PlayerBtlData.Def.toString(), Integer.valueOf(contender.defBuff));
/* 141 */         player.btlDataManager.calFinalData(map, true);
/* 142 */         player.refreshBattlerServerEffect(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushReport(MessagePush defenserMessage, MessagePush attackerMessage) {
/* 154 */     for (String pid : this.actors.keySet()) {
/* 155 */       WNPlayer player = PlayerUtil.getOnlinePlayer(pid);
/* 156 */       if (player != null) {
/* 157 */         if (this.fort.isDefenserMember(player.guildManager.getGuildId())) {
/* 158 */           player.receive((Message)defenserMessage); continue;
/*     */         } 
/* 160 */         player.receive((Message)attackerMessage);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\GuildFortPvpArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */