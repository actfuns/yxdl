/*     */ package com.wanniu.game.poes;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.game.DBTable;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
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
/*     */ @DBTable("player_rank_info")
/*     */ public class PlayerRankInfoPO
/*     */   extends GEntity
/*     */ {
/*     */   private String id;
/*     */   private String name;
/*     */   private int pro;
/*     */   private int level;
/*     */   private int fightPower;
/*     */   private int upOrder;
/*     */   private int hp;
/*     */   private int phy;
/*     */   private int mag;
/*     */   private int xianyuan;
/*     */   private int demonTower;
/*     */   private int mountFightPower;
/*     */   private int mountSkinId;
/*     */   private int petId;
/*     */   private String petName;
/*     */   private int petFightPower;
/*     */   
/*     */   public void setId(String id) {
/*  54 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getGuildName() {
/*  58 */     GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(this.id);
/*  59 */     if (guildPO != null) {
/*  60 */       return guildPO.name;
/*     */     }
/*     */     
/*  63 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  75 */     this.name = name;
/*     */   }
/*     */   
/*     */   public int getPro() {
/*  79 */     return this.pro;
/*     */   }
/*     */   
/*     */   public void setPro(int pro) {
/*  83 */     this.pro = pro;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  87 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(int level) {
/*  91 */     this.level = level;
/*     */   }
/*     */   
/*     */   public int getFightPower() {
/*  95 */     return this.fightPower;
/*     */   }
/*     */   
/*     */   public void setFightPower(int fightPower) {
/*  99 */     this.fightPower = fightPower;
/*     */   }
/*     */   
/*     */   public int getUpOrder() {
/* 103 */     return this.upOrder;
/*     */   }
/*     */   
/*     */   public void setUpOrder(int upOrder) {
/* 107 */     this.upOrder = upOrder;
/*     */   }
/*     */   
/*     */   public String getId() {
/* 111 */     return this.id;
/*     */   }
/*     */   
/*     */   public int getHp() {
/* 115 */     return this.hp;
/*     */   }
/*     */   
/*     */   public void setHp(int hp) {
/* 119 */     this.hp = hp;
/*     */   }
/*     */   
/*     */   public int getPhy() {
/* 123 */     return this.phy;
/*     */   }
/*     */   
/*     */   public void setPhy(int phy) {
/* 127 */     this.phy = phy;
/*     */   }
/*     */   
/*     */   public int getMag() {
/* 131 */     return this.mag;
/*     */   }
/*     */   
/*     */   public void setMag(int mag) {
/* 135 */     this.mag = mag;
/*     */   }
/*     */   
/*     */   public int getXianyuan() {
/* 139 */     return this.xianyuan;
/*     */   }
/*     */   
/*     */   public void setXianyuan(int xianyuan) {
/* 143 */     this.xianyuan = xianyuan;
/*     */   }
/*     */   
/*     */   public int getDemonTower() {
/* 147 */     return this.demonTower;
/*     */   }
/*     */   
/*     */   public void setDemonTower(int demonTower) {
/* 151 */     this.demonTower = demonTower;
/*     */   }
/*     */   
/*     */   public int getMountFightPower() {
/* 155 */     return this.mountFightPower;
/*     */   }
/*     */   
/*     */   public void setMountFightPower(int mountFightPower) {
/* 159 */     this.mountFightPower = mountFightPower;
/*     */   }
/*     */   
/*     */   public int getMountSkinId() {
/* 163 */     return this.mountSkinId;
/*     */   }
/*     */   
/*     */   public void setMountSkinId(int mountSkinId) {
/* 167 */     this.mountSkinId = mountSkinId;
/*     */   }
/*     */   
/*     */   public int getPetId() {
/* 171 */     return this.petId;
/*     */   }
/*     */   
/*     */   public void setPetId(int petId) {
/* 175 */     this.petId = petId;
/*     */   }
/*     */   
/*     */   public String getPetName() {
/* 179 */     return this.petName;
/*     */   }
/*     */   
/*     */   public void setPetName(String petName) {
/* 183 */     this.petName = petName;
/*     */   }
/*     */   
/*     */   public int getPetFightPower() {
/* 187 */     return this.petFightPower;
/*     */   }
/*     */   
/*     */   public void setPetFightPower(int petFightPower) {
/* 191 */     this.petFightPower = petFightPower;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerRankInfoPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */