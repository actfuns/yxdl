/*     */ package com.wanniu.game.poes;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.game.DBField;
/*     */ import com.wanniu.game.DBTable;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @DBTable("player")
/*     */ public final class PlayerPO
/*     */   extends GEntity
/*     */ {
/*     */   @DBField(isPKey = true, fieldType = "char", size = 36)
/*     */   public String id;
/*     */   @DBField(size = 256)
/*     */   public String uid;
/*     */   public int logicServerId;
/*     */   @DBField(size = 64)
/*     */   public String name;
/*     */   public int isDelete;
/*     */   public int level;
/*     */   public long exp;
/*     */   public int prestige;
/*     */   public int pro;
/*     */   public int gold;
/*     */   public int diamond;
/*     */   public int ticket;
/*     */   public int friendly;
/*     */   public int consumePoint;
/*     */   public int charm;
/*     */   public int pawnGold;
/*     */   public int guildpoint;
/*     */   public int treasurePoint;
/*     */   public int fightPower;
/*     */   public int maxFightPower;
/*     */   public int upOrder;
/*     */   public int upLevel;
/*     */   public int classExp;
/*     */   public int vip;
/*     */   public Date vipEndTime;
/*     */   public int isAcceptAutoTeam;
/*     */   public Date createTime;
/*     */   public Date loginTime;
/*     */   public Date logoutTime;
/*     */   public Date refreshTime;
/*     */   public Date forbidTalkTime;
/*     */   public Date freezeTime;
/*     */   public String forbidTalkReason;
/*     */   public String freezeReason;
/*     */   public int totalCostDiamond;
/*     */   public String fightingPetId;
/*     */   public Date lvChangeTime;
/*     */   public Date fightChangeTime;
/*     */   public boolean openMount;
/*     */   @DBField(include = false)
/*     */   public int needExp;
/*     */   public int todayGold;
/*     */   public int todayDiamond;
/*     */   public int todayTicket;
/*     */   public String channel;
/*     */   public String subchannel;
/*     */   public String subchannelUID;
/*     */   public String mac;
/*     */   public String os;
/*     */   public String ip;
/* 102 */   public int exchangCount = 0;
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */