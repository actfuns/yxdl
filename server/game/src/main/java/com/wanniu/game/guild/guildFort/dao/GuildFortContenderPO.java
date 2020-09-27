/*     */ package com.wanniu.game.guild.guildFort.dao;
/*     */ 
/*     */ import com.alibaba.fastjson.annotation.JSONField;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortStatPush;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class GuildFortContenderPO
/*     */ {
/*  16 */   public String guildId = "";
/*  17 */   public String guildName = "";
/*  18 */   public String guildIcon = "";
/*  19 */   public int guildLevel = 0;
/*  20 */   public int attendTimes = 0;
/*  21 */   public int winTimes = 0;
/*     */ 
/*     */   
/*  24 */   public Map<String, GuildFortMemberPO> members = new HashMap<>();
/*  25 */   public int memberNumber = 0;
/*     */   
/*  27 */   public int pickItemNum = 0;
/*  28 */   public int defBuffScore = 0;
/*  29 */   public int defBuff = 0;
/*     */   
/*  31 */   public int killMonsterNum = 0;
/*  32 */   public int attBuffScore = 0;
/*  33 */   public int attBuff = 0;
/*     */   
/*  35 */   public int killPlayerNum = 0;
/*  36 */   public int killPlayerScore = 0;
/*  37 */   public int killFlagNum = 0;
/*  38 */   public int killFlagScore = 0;
/*  39 */   public int score = 0;
/*     */   
/*     */   public boolean isWinner = false;
/*     */ 
/*     */   
/*     */   public GuildFortContenderPO() {}
/*     */ 
/*     */   
/*     */   public GuildFortContenderPO(String guildId) {
/*  48 */     this.guildId = guildId;
/*  49 */     build();
/*     */   }
/*     */ 
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public synchronized GuildFortContenderPO getContenderPO() {
/*  55 */     build();
/*  56 */     GuildFortContenderPO po = new GuildFortContenderPO();
/*     */     
/*  58 */     po.guildId = this.guildId;
/*  59 */     po.guildName = this.guildName;
/*  60 */     po.guildIcon = this.guildIcon;
/*  61 */     po.guildLevel = this.guildLevel;
/*  62 */     po.attendTimes = this.attendTimes;
/*  63 */     po.winTimes = this.winTimes;
/*     */     
/*  65 */     po.memberNumber = this.memberNumber;
/*     */ 
/*     */     
/*  68 */     po.pickItemNum = this.pickItemNum;
/*  69 */     po.defBuffScore = this.defBuffScore;
/*  70 */     po.defBuff = this.defBuff;
/*     */     
/*  72 */     po.killMonsterNum = this.killMonsterNum;
/*  73 */     po.attBuffScore = this.attBuffScore;
/*  74 */     po.attBuff = this.attBuff;
/*     */ 
/*     */     
/*  77 */     po.killPlayerNum = this.killPlayerNum;
/*  78 */     po.killPlayerScore = this.killPlayerScore;
/*  79 */     po.killFlagNum = this.killFlagNum;
/*  80 */     po.killFlagScore = this.killFlagScore;
/*  81 */     po.score = this.score;
/*  82 */     po.isWinner = this.isWinner;
/*  83 */     return po;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public synchronized GuildFortStatPush getPush() {
/*  88 */     GuildFortStatPush po = new GuildFortStatPush();
/*  89 */     po.memberNumber = this.members.size();
/*  90 */     for (GuildFortMemberPO member : this.members.values()) {
/*  91 */       po.killPlayerNum += member.getKilledPlayerNum();
/*  92 */       po.killFlagNum += member.getKilledFlagNum();
/*  93 */       po.defBuffScore += member.getDefBuffScore();
/*  94 */       po.attBuffScore += member.getAttBuffScore();
/*  95 */       po.score += member.getScore();
/*     */     } 
/*  97 */     po.defBuff = po.defBuffScore / GlobalConfig.GuildFort_PickAddDefense;
/*  98 */     po.attBuff = po.attBuffScore / GlobalConfig.GuildFort_KillMonAddAttack;
/*     */     
/* 100 */     return po;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public synchronized GuildFortContenderPO build() {
/* 105 */     if (StringUtil.isNotEmpty(this.guildId)) {
/* 106 */       GuildPO guild = GuildServiceCenter.getInstance().getGuild(this.guildId);
/* 107 */       if (guild != null) {
/* 108 */         this.guildName = guild.name;
/* 109 */         this.guildIcon = guild.icon;
/* 110 */         this.guildLevel = guild.level;
/* 111 */         this.attendTimes = (guild.getFortInfo()).attendTimes;
/* 112 */         this.winTimes = (guild.getFortInfo()).winTimes;
/*     */         
/* 114 */         this.memberNumber = this.members.size();
/* 115 */         this.pickItemNum = 0;
/* 116 */         this.killMonsterNum = 0;
/* 117 */         this.killPlayerNum = 0;
/* 118 */         this.killFlagNum = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 123 */         for (GuildFortMemberPO member : this.members.values()) {
/* 124 */           this.pickItemNum += member.getPickItemNum();
/* 125 */           this.killMonsterNum += member.getKilledMonsterNum();
/* 126 */           this.killPlayerNum += member.getKilledPlayerNum();
/* 127 */           this.killFlagNum += member.getKilledFlagNum();
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 133 */         this.killPlayerScore = this.killPlayerNum * GlobalConfig.GuildFort_KillPoint;
/* 134 */         this.killFlagScore = this.killFlagNum * GlobalConfig.GuildFort_DestroyPoint;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public synchronized GuildFortMemberPO getMemberAndPut(WNPlayer player) {
/* 152 */     String playerId = player.getId();
/* 153 */     if (this.members.containsKey(playerId)) {
/* 154 */       return this.members.get(playerId);
/*     */     }
/* 156 */     GuildFortMemberPO member = new GuildFortMemberPO(playerId, player.getName(), player.getLevel(), player.guildManager.getJob(), player.guildManager.getGuildName());
/* 157 */     this.members.put(playerId, member);
/* 158 */     return member;
/*     */   }
/*     */ 
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public synchronized Collection<GuildFortMemberPO> getMembers() {
/* 164 */     return this.members.values();
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public boolean isMember(WNPlayer player) {
/* 169 */     return isMember(player.guildManager.getGuildId());
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public boolean isMember(String guildId) {
/* 174 */     if (guildId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     return guildId.equals(this.guildId);
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public String getGuildId() {
/* 182 */     return this.guildId;
/*     */   }
/*     */ 
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public boolean isWinner() {
/* 188 */     return this.isWinner;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void setWinner(boolean isWinner) {
/* 193 */     this.isWinner = isWinner;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getScore() {
/* 198 */     return this.score;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\dao\GuildFortContenderPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */