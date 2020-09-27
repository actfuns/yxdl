/*    */ package com.wanniu.game.rank;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.MountPO;
/*    */ import com.wanniu.game.poes.PetNewPO;
/*    */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RankManager
/*    */ {
/*    */   private final WNPlayer player;
/*    */   private PlayerRankInfoPO rankPO;
/*    */   
/*    */   public RankManager(WNPlayer player) {
/* 25 */     this.player = player;
/* 26 */     this.rankPO = RankCenter.getInstance().findRankPO(player.getId());
/* 27 */     if (this.rankPO == null) {
/* 28 */       this.rankPO = initRankPO();
/* 29 */       PlayerPOManager.put(ConstsTR.playerRankTR, player.getId(), (GEntity)this.rankPO);
/*    */     } 
/*    */   }
/*    */   
/*    */   public PlayerRankInfoPO getRankPO() {
/* 34 */     return this.rankPO;
/*    */   }
/*    */   
/*    */   private PlayerRankInfoPO initRankPO() {
/* 38 */     PlayerRankInfoPO info = new PlayerRankInfoPO();
/* 39 */     info.setId(this.player.getId());
/* 40 */     info.setName(this.player.getName());
/* 41 */     info.setPro(this.player.getPro());
/* 42 */     info.setLevel(this.player.getLevel());
/* 43 */     info.setUpOrder(this.player.getUpOrder());
/* 44 */     info.setFightPower(this.player.getFightPower());
/*    */     
/* 46 */     Map<Const.PlayerBtlData, Integer> attrs = this.player.btlDataManager.finalInflus;
/* 47 */     info.setHp(((Integer)attrs.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue());
/* 48 */     info.setMag(((Integer)attrs.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue());
/* 49 */     info.setPhy(((Integer)attrs.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue());
/*    */     
/* 51 */     info.setXianyuan(this.player.moneyManager.getXianYuan());
/* 52 */     info.setDemonTower(this.player.demonTowerManager.getMaxFloor());
/*    */ 
/*    */ 
/*    */     
/* 56 */     MountPO mount = this.player.mountManager.mount;
/* 57 */     info.setMountFightPower((mount == null) ? 0 : mount.fightPower);
/* 58 */     info.setMountSkinId((mount == null) ? 0 : mount.usingSkinId);
/*    */ 
/*    */ 
/*    */     
/* 62 */     PetNewPO petMax = null;
/* 63 */     int petFightPowerMax = 0;
/* 64 */     for (PetNewPO pet : this.player.petNewManager.petsPO.pets.values()) {
/* 65 */       int petFightPower = pet.fightPower;
/* 66 */       if (petFightPower > petFightPowerMax) {
/* 67 */         petFightPowerMax = petFightPower;
/* 68 */         petMax = pet;
/*    */       } 
/*    */     } 
/* 71 */     if (petMax != null) {
/* 72 */       info.setPetId(petMax.id);
/* 73 */       info.setPetName(petMax.name);
/* 74 */       info.setPetFightPower(petMax.fightPower);
/*    */     } else {
/* 76 */       info.setPetId(1);
/* 77 */       info.setPetName("");
/* 78 */       info.setPetFightPower(1);
/*    */     } 
/* 80 */     return info;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEvent(RankType type, Object... value) {
/* 87 */     if (this.player.isRobot()) {
/*    */       return;
/*    */     }
/* 90 */     GWorld.getInstance().ansycExec(() -> type.getHandler().handle(this.player, value));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onChangeName() {
/* 97 */     this.rankPO.setName(this.player.getName());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\RankManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */