/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.alibaba.fastjson.annotation.JSONField;
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBField;
/*    */ import com.wanniu.game.guild.GuildAllBlob;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuildPO
/*    */   extends GEntity
/*    */ {
/* 58 */   public Map<Integer, String> officeNames = new HashMap<>();
/* 59 */   public GuildAllBlob allBlobData = new GuildAllBlob();
/* 60 */   public Date changeNameTime = new Date(0L);
/* 61 */   public Date kickTime = new Date(0L);
/*    */ 
/*    */   
/*    */   public GuildFortInfoPO getFortInfo() {
/* 65 */     synchronized (this) {
/* 66 */       if (this.fortInfo == null) {
/* 67 */         this.fortInfo = new GuildFortInfoPO();
/*    */       }
/*    */     } 
/*    */     
/* 71 */     return this.fortInfo;
/*    */   }
/*    */   
/*    */   @DBField(isPKey = true, fieldType = "varchar", size = 50)
/*    */   public String id;
/*    */   public int logicServerId;
/*    */   public String icon;
/*    */   public String name;
/*    */   public int level;
/*    */   public String presidentId;
/*    */   public int presidentPro;
/*    */   public String presidentName;
/*    */   public String qqGroup;
/*    */   public long fund;
/*    */   public long sumFund;
/*    */   public long exp;
/*    */   public int entryLevel;
/*    */   public int entryUpLevel;
/*    */   public int guildMode;
/*    */   public String notice;
/*    */   public String logicName;
/*    */   public String jobName;
/*    */   public int job;
/*    */   public Date createTime;
/*    */   public int kickCount;
/*    */   public InspirePO inspire;
/*    */   public InspirePO defInspire;
/*    */   public GuildFortInfoPO fortInfo;
/*    */   @JSONField(serialize = false)
/*    */   @DBField(include = false)
/*    */   public boolean modify;
/*    */   public int auctionBonus;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\GuildPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */