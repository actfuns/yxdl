/*     */ package com.wanniu.game.player.bi;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.jsfunny.ConsignmentData;
/*     */ import com.wanniu.game.player.bi.jsfunny.CreatePlayerData;
/*     */ import com.wanniu.game.player.bi.jsfunny.FashionData;
/*     */ import com.wanniu.game.player.bi.jsfunny.ItemFlowData;
/*     */ import com.wanniu.game.player.bi.jsfunny.LoginData;
/*     */ import com.wanniu.game.player.bi.jsfunny.LuckDrawData;
/*     */ import com.wanniu.game.player.bi.jsfunny.MoneyFlowData;
/*     */ import com.wanniu.game.player.bi.jsfunny.MoneyMonitorData;
/*     */ import com.wanniu.game.player.bi.jsfunny.MountSkinData;
/*     */ import com.wanniu.game.player.bi.jsfunny.MountUpgradeData;
/*     */ import com.wanniu.game.player.bi.jsfunny.OnlineCountData;
/*     */ import com.wanniu.game.player.bi.jsfunny.PacketMonitorData;
/*     */ import com.wanniu.game.player.bi.jsfunny.PetSkinData;
/*     */ import com.wanniu.game.player.bi.jsfunny.PetUpgradeData;
/*     */ import com.wanniu.game.player.bi.jsfunny.RechargeData;
/*     */ import com.wanniu.game.player.bi.jsfunny.RoleUpgradeData;
/*     */ import com.wanniu.game.player.bi.jsfunny.ShopData;
/*     */ import com.wanniu.game.poes.PlayerPO;
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
/*     */ public class LogReportService
/*     */ {
/*  46 */   private static final LogReportService instance = new LogReportService();
/*     */   
/*     */   public static final int OPERATE_ADD = 1;
/*     */   public static final int OPERATE_COST = 2;
/*     */   
/*     */   public static LogReportService getInstance() {
/*  52 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportOnline(int onlineCount, int robotOnlineCount) {
/*     */     try {
/*  63 */       (new OnlineCountData(onlineCount, robotOnlineCount)).publishing();
/*  64 */     } catch (Exception e) {
/*  65 */       Out.warn(new Object[] { "ansycReportOnline Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportUpgrade(WNPlayer player) {
/*     */     try {
/*  74 */       (new RoleUpgradeData(player)).publishing();
/*  75 */     } catch (Exception e) {
/*  76 */       Out.warn(new Object[] { "ansycReportUpgrade Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportMoneyFlow(PlayerPO player, VirtualItemType type, int before, int operate, int value, int after, int origin) {
/*     */     try {
/*  85 */       (new MoneyFlowData(player, type, before, operate, value, after, origin)).publishing();
/*     */ 
/*     */       
/*  88 */       switch (type) {
/*     */         case DIAMOND:
/*  90 */           BILogService.getInstance().ansycReportEconomy(player, "yb", (operate == 1), value, origin);
/*     */           break;
/*     */         case CASH:
/*  93 */           BILogService.getInstance().ansycReportEconomy(player, "bdyb", (operate == 1), value, origin);
/*     */           break;
/*     */         case GOLD:
/*  96 */           BILogService.getInstance().ansycReportEconomy(player, "yl", (operate == 1), value, origin);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/* 101 */     } catch (Exception e) {
/* 102 */       Out.warn(new Object[] { "ansycReportMoneyFlow Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportItemFlow(PlayerPO player, int operate, String itemcode, int count, boolean bind, Const.GOODS_CHANGE_TYPE origin, String name) {
/* 112 */     if (origin == null) {
/* 113 */       origin = Const.GOODS_CHANGE_TYPE.def;
/*     */     }
/*     */     try {
/* 116 */       (new ItemFlowData(player, operate, itemcode, count, bind, origin.value)).publishing();
/*     */ 
/*     */       
/* 119 */       BILogService.getInstance().ansycReportItem(player, (operate == 1), itemcode, count, origin, name);
/* 120 */     } catch (Exception e) {
/* 121 */       Out.warn(new Object[] { "ansycReportItemFlow Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportMountUpgrade(WNPlayer player, int rideLevel, int starLv) {
/*     */     try {
/* 130 */       (new MountUpgradeData(player.getPlayer(), rideLevel, starLv)).publishing();
/* 131 */     } catch (Exception e) {
/* 132 */       Out.warn(new Object[] { "ansycReportMount Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportPetUpgrade(WNPlayer player, int petId, String petName, int upLevel, int level, long exp) {
/*     */     try {
/* 141 */       (new PetUpgradeData(player.getPlayer(), petId, petName, upLevel, level, exp)).publishing();
/* 142 */     } catch (Exception e) {
/* 143 */       Out.warn(new Object[] { "ansycReportMount Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportRecharge(PlayerPO player, int productId, int type, int money) {
/*     */     try {
/* 152 */       (new RechargeData(player, productId, type, money)).publishing();
/* 153 */     } catch (Exception e) {
/* 154 */       Out.warn(new Object[] { "ansycReportRecharge Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportShop(WNPlayer player, String itemcode, int itemnum, int consumeType, int costMoney) {
/*     */     try {
/* 163 */       (new ShopData(player.getPlayer(), itemcode, itemnum, consumeType, costMoney)).publishing();
/* 164 */     } catch (Exception e) {
/* 165 */       Out.warn(new Object[] { "ansycReportShop Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportCreatePlayer(WNPlayer player) {
/*     */     try {
/* 174 */       (new CreatePlayerData(player.getPlayer())).publishing();
/* 175 */     } catch (Exception e) {
/* 176 */       Out.warn(new Object[] { "ansycReportCreatePlayer Exception", e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ansycReportMountSkin(WNPlayer player, int skinId) {
/*     */     try {
/* 182 */       (new MountSkinData(player.getPlayer(), skinId)).publishing();
/* 183 */     } catch (Exception e) {
/* 184 */       Out.warn(new Object[] { "ansycReportMountSkin Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportPetSkin(WNPlayer player, int petId) {
/*     */     try {
/* 193 */       (new PetSkinData(player.getPlayer(), petId)).publishing();
/* 194 */     } catch (Exception e) {
/* 195 */       Out.warn(new Object[] { "ansycReportPetSkin Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportFashion(WNPlayer player, String code) {
/*     */     try {
/* 204 */       (new FashionData(player.getPlayer(), code)).publishing();
/* 205 */     } catch (Exception e) {
/* 206 */       Out.warn(new Object[] { "ansycReportFashion Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportLuckDraw(WNPlayer player, int type, int count, int money, int itemcount) {
/*     */     try {
/* 215 */       (new LuckDrawData(player.getPlayer(), type, count, money, itemcount)).publishing();
/* 216 */     } catch (Exception e) {
/* 217 */       Out.warn(new Object[] { "ansycReportLuckDraw Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportConsignment(WNPlayer player, String buyerId, String buyerName, String itemcode, int itemcount) {
/*     */     try {
/* 226 */       (new ConsignmentData(player.getPlayer(), buyerId, buyerName, itemcode, itemcount)).publishing();
/* 227 */     } catch (Exception e) {
/* 228 */       Out.warn(new Object[] { "ansycReportConsignment Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportMoneyMonitor(WNPlayer player, VirtualItemType type, int today, int threshold) {
/*     */     try {
/* 237 */       (new MoneyMonitorData(player.getPlayer(), type, today, threshold)).publishing();
/* 238 */     } catch (Exception e) {
/* 239 */       Out.warn(new Object[] { "ansycReportMoneyMonitor Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportPacketMonitor(PlayerPO player, Integer count, short type, String route) {
/*     */     try {
/* 248 */       (new PacketMonitorData(player, count, type, route)).publishing();
/* 249 */     } catch (Exception e) {
/* 250 */       Out.warn(new Object[] { "ansycReportPacketMonitor Exception", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ansycReportLogin(PlayerPO player) {
/*     */     try {
/* 259 */       (new LoginData(player)).publishing();
/* 260 */     } catch (Exception e) {
/* 261 */       Out.warn(new Object[] { "ansycReportLogin Exception", e });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\bi\LogReportService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */