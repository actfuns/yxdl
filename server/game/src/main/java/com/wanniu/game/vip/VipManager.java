/*     */ package com.wanniu.game.vip;
/*     */ 
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.DateUtils;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.VipPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VipManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private static final float Tenthousand = 10000.0F;
/*     */   private final WNPlayer player;
/*     */   public VipPO po;
/*     */   
/*     */   public VipManager(WNPlayer player, VipPO po) {
/*  28 */     this.player = player;
/*  29 */     if (po == null) {
/*  30 */       player.playerAttachPO.vipData = po = new VipPO();
/*     */     }
/*  32 */     this.po = po;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int takeDailyReward(int type) {
/*  41 */     CardCO cardProp = (CardCO)GameData.Cards.get(Integer.valueOf(type));
/*  42 */     if (cardProp == null) {
/*  43 */       return -4;
/*     */     }
/*  45 */     Const.VipType vt = Const.VipType.getE(type);
/*  46 */     if (vt == Const.VipType.month) {
/*  47 */       if (this.player.baseDataManager.getVip() != Const.VipType.month.value && this.player.baseDataManager.getVip() != Const.VipType.sb_double.value) {
/*  48 */         return -1;
/*     */       }
/*  50 */       if (this.po.lastMonthRewardDate != null && DateUtils.isToday(this.po.lastMonthRewardDate)) {
/*  51 */         return -3;
/*     */       }
/*  53 */       this.po.lastMonthRewardDate = Calendar.getInstance().getTime();
/*  54 */     } else if (vt == Const.VipType.forever) {
/*  55 */       if (this.player.baseDataManager.getVip() != Const.VipType.forever.value && this.player.baseDataManager.getVip() != Const.VipType.sb_double.value) {
/*  56 */         return -2;
/*     */       }
/*  58 */       if (this.po.lastForeverRewardDate != null && DateUtils.isToday(this.po.lastForeverRewardDate)) {
/*  59 */         return -3;
/*     */       }
/*  61 */       this.po.lastForeverRewardDate = Calendar.getInstance().getTime();
/*     */     } 
/*  63 */     this.player.moneyManager.addTicket(cardProp.dailyDW, Const.GOODS_CHANGE_TYPE.dailypay_gift);
/*     */     
/*  65 */     updateSuperScript();
/*  66 */     return 0;
/*     */   }
/*     */   
/*     */   public float getVipExpRatio() {
/*  70 */     if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
/*  71 */       CardCO card = (CardCO)GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
/*  72 */       return card.prv2 / 10000.0F;
/*     */     } 
/*  74 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getExtGoldRatio() {
/*  78 */     if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
/*  79 */       CardCO card = (CardCO)GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
/*  80 */       return card.prv3 / 10000.0F;
/*     */     } 
/*  82 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/*  87 */     if (eventType == Const.PlayerEventType.AFTER_LOGIN) {
/*  88 */       updateSuperScript();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/*  94 */     return Const.ManagerType.VIP;
/*     */   }
/*     */   
/*     */   public long getVipRemainTime() {
/*  98 */     long remain = 0L;
/*  99 */     if (this.player.baseDataManager.getVip() == Const.VipType.none.value || this.player.baseDataManager.getVip() == Const.VipType.forever.value) {
/* 100 */       return 0L;
/*     */     }
/* 102 */     Calendar c_end = Calendar.getInstance();
/* 103 */     c_end.setTime(this.player.player.vipEndTime);
/* 104 */     remain = (c_end.getTimeInMillis() - System.currentTimeMillis()) / 1000L;
/* 105 */     if (remain < 0L) {
/* 106 */       remain = 0L;
/*     */     }
/* 108 */     return remain;
/*     */   }
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
/*     */   public final List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 125 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 126 */     PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
/* 127 */     script.setType(Const.SUPERSCRIPT_TYPE.VIP.getValue());
/*     */     
/* 129 */     int vipType = this.player.baseDataManager.getVip();
/* 130 */     int num = 0;
/* 131 */     if ((vipType == Const.VipType.month.value || vipType == Const.VipType.sb_double.value) && (
/* 132 */       this.po.lastMonthRewardDate == null || !DateUtils.isToday(this.po.lastMonthRewardDate))) {
/* 133 */       num++;
/*     */     }
/*     */     
/* 136 */     if ((vipType == Const.VipType.forever.value || vipType == Const.VipType.sb_double.value) && (
/* 137 */       this.po.lastForeverRewardDate == null || !DateUtils.isToday(this.po.lastForeverRewardDate))) {
/* 138 */       num++;
/*     */     }
/*     */     
/* 141 */     script.setNumber(num);
/*     */     
/* 143 */     list.add(script.build());
/* 144 */     return list;
/*     */   }
/*     */   
/*     */   public final void updateSuperScript() {
/* 148 */     this.player.updateSuperScriptList(getSuperScript());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReliveNum() {
/* 155 */     if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
/* 156 */       CardCO card = (CardCO)GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
/* 157 */       if (card != null) {
/* 158 */         return card.prv10;
/*     */       }
/*     */     } 
/* 161 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\vip\VipManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */