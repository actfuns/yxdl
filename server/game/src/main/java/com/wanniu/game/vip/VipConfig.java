/*    */ package com.wanniu.game.vip;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.VipCO;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class VipConfig {
/*    */   private static VipConfig _instance;
/*    */   private VipCO[] vipProps;
/*    */   private int maxVipLevel;
/*    */   
/*    */   public static VipConfig getInstance() {
/* 13 */     if (_instance == null) {
/* 14 */       _instance = new VipConfig();
/*    */     }
/* 16 */     return _instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private VipConfig() {
/* 24 */     if (this.vipProps == null) {
/* 25 */       Collection<VipCO> loadVips = GameData.Vips.values();
/* 26 */       this.vipProps = new VipCO[loadVips.size()];
/* 27 */       loadVips.toArray(this.vipProps);
/* 28 */       int maxVipLev = 0;
/* 29 */       for (VipCO v : this.vipProps) {
/* 30 */         if (v.vipLevel > maxVipLev) {
/* 31 */           maxVipLev = v.vipLevel;
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 36 */       this.maxVipLevel = maxVipLev;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMaxVipLevel() {
/* 42 */     return this.maxVipLevel;
/*    */   }
/*    */   
/*    */   public VipCO[] getVipProps() {
/* 46 */     return this.vipProps;
/*    */   }
/*    */   
/*    */   public VipCO findVipProp(int vipLev) {
/* 50 */     for (VipCO v : this.vipProps) {
/* 51 */       if (v.vipLevel > vipLev) {
/* 52 */         return v;
/*    */       }
/*    */     } 
/* 55 */     return null;
/*    */   }
/*    */   
/*    */   public int getVipFunc(int vip, VipFuncType vft) {
/* 59 */     VipCO vipProp = findVipProp(vip);
/* 60 */     if (vipProp == null) {
/* 61 */       return 0;
/*    */     }
/* 63 */     switch (vft) {
/*    */       case MONERY_TREE:
/* 65 */         return vipProp.vipMoneyTime;
/*    */       case MONSTER_KILL_EXP:
/* 67 */         return vipProp.extraExp;
/*    */       case SINGLE_SCENE:
/* 69 */         return vipProp.singleDungeonTime;
/*    */       case TEAM_SCENE:
/* 71 */         return vipProp.teamDungeonTime;
/*    */       case SECRET_SCENE:
/* 73 */         return vipProp.mysteriesDungeonTime;
/*    */       case SUPER_SCENE:
/* 75 */         return vipProp.superDungeonTime;
/*    */       case SIN_COM:
/* 77 */         return vipProp.soloTime;
/*    */       case CONSIGNMENT_STORE:
/* 79 */         return vipProp.storeItemNum;
/*    */       case BUY_SINGLE_SCENE:
/* 81 */         return vipProp.buySingleDungeonTime;
/*    */       case BUY_TEAM_SCENE:
/* 83 */         return vipProp.buyTeamDungeonTime;
/*    */       case BUY_SUPER_SCENE:
/* 85 */         return vipProp.buySuperDungeonTime;
/*    */     } 
/* 87 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\vip\VipConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */