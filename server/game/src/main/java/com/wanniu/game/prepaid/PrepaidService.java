/*     */ package com.wanniu.game.prepaid;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.core.util.http.HttpRequester;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.PayCO;
/*     */ import com.wanniu.game.data.SuperPackageCO;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.FeeOrderPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.area.PrepaidHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrepaidService
/*     */ {
/*     */   private static PrepaidService instance;
/*  37 */   private static String createOrderUrl = GConfig.getInstance().get("server.pay.orderUrl");
/*  38 */   private static String notifyOrderUrl = GConfig.getInstance().get("server.pay.notifyUrl");
/*  39 */   private static String payNotifyUrl = "http://127.0.0.1:8100/paycenter/to/PayNotify.jsp";
/*     */   
/*     */   public static synchronized PrepaidService getInstance() {
/*  42 */     if (instance == null)
/*  43 */       instance = new PrepaidService(); 
/*  44 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private HashMap<String, String> prepaidConfig;
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(HashMap<String, String> prepaidConfig) {
/*  54 */     this.prepaidConfig = prepaidConfig;
/*     */   }
/*     */   
/*     */   public Object getConfig(String configName) {
/*  58 */     return this.prepaidConfig.get(configName);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPaySuccess(String orderId) {
/*  63 */     String orderKey = ConstsTR.feeOrder.value + "/" + orderId;
/*  64 */     String order = GCache.get(orderKey);
/*  65 */     if (StringUtil.isEmpty(order)) {
/*  66 */       Out.warn(new Object[] { "充值回调，重复通知... orderId=", orderId });
/*     */       return;
/*     */     } 
/*  69 */     FeeOrderPO po = (FeeOrderPO)JSON.parseObject(order, FeeOrderPO.class);
/*     */     
/*  71 */     GCache.remove(orderKey);
/*  72 */     String playerId = po.playerId;
/*  73 */     int productId = po.productId;
/*  74 */     boolean isCard = po.isCard;
/*  75 */     boolean isSuperPackage = po.isSuperPackage;
/*  76 */     Out.info(new Object[] { "充值回调 orderId=", orderId, ",playerId=", playerId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage) });
/*     */     
/*  78 */     PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(playerId);
/*  79 */     manager.onCharge(productId, isCard, isSuperPackage, true);
/*  80 */     PrepaidCenter.getInstance().update(playerId, manager);
/*     */ 
/*     */     
/*     */     try {
/*  84 */       int type = 0;
/*  85 */       int money = 0;
/*  86 */       if (isCard) {
/*  87 */         type = 1;
/*  88 */         money = ((CardCO)GameData.Cards.get(Integer.valueOf(productId))).payMoneyAmount;
/*     */       }
/*  90 */       else if (!isSuperPackage) {
/*  91 */         type = 0;
/*  92 */         money = ((PayCO)GameData.Pays.get(Integer.valueOf(productId))).payMoneyAmount;
/*     */       } else {
/*  94 */         type = 2;
/*  95 */         money = ((SuperPackageCO)GameData.SuperPackages.get(Integer.valueOf(productId))).packagePrice;
/*     */       } 
/*     */       
/*  98 */       PlayerPO player = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*  99 */       LogReportService.getInstance().ansycReportRecharge(player, productId, type, money);
/* 100 */     } catch (Exception e) {
/* 101 */       Out.warn(new Object[] { "上报充值异常啦...", e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getResponseType(HashMap<String, String> dataMap) {
/* 106 */     if (dataMap.containsKey("pm_id") && 
/* 107 */       Integer.parseInt(dataMap.get("pm_id")) == 30) {
/* 108 */       return Const.PrepaidType.WP_PREPAID_REQUEST.getValue();
/*     */     }
/*     */     
/* 111 */     return Const.PrepaidType.PREPAID_REQUEST.getValue();
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
/*     */   public PomeloResponse createOrderId(int productId, int channelId, WNPlayer player, boolean isCard, boolean isSuperPackage, String imei, int os) {
/* 125 */     float money = 0.0F;
/* 126 */     if (isCard) {
/* 127 */       money = ((CardCO)GameData.Cards.get(Integer.valueOf(productId))).payMoneyAmount;
/*     */     }
/* 129 */     else if (!isSuperPackage) {
/* 130 */       money = ((PayCO)GameData.Pays.get(Integer.valueOf(productId))).payMoneyAmount;
/*     */     } else {
/* 132 */       money = ((SuperPackageCO)GameData.SuperPackages.get(Integer.valueOf(productId))).packagePrice;
/*     */     } 
/* 134 */     Map<String, String> params = new HashMap<>();
/* 135 */     params.put("appid", String.valueOf(GGame.__APP_ID));
/* 136 */     params.put("channel", String.valueOf(channelId));
/* 137 */     params.put("money", String.valueOf(money));
/* 138 */     params.put("username", player.getUid());
/* 139 */     params.put("serverid", String.valueOf(GGame.__SERVER_ID));
/* 140 */     params.put("roleid", player.getId());
/* 141 */     params.put("subchannel", (player.getPlayer()).subchannel);
/*     */     
/* 143 */     String orderId = null;
/*     */     
/* 145 */     if (GConfig.getInstance().isEnablePay()) {
/*     */       try {
/* 147 */         orderId = (new HttpRequester()).sendPost(createOrderUrl, params).getContent();
/* 148 */       } catch (Exception e) {
/* 149 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     }
/* 152 */     final PrepaidHandler.PrepaidOrderIdResponse.Builder res = PrepaidHandler.PrepaidOrderIdResponse.newBuilder();
/* 153 */     if (!StringUtil.isNotEmpty(orderId)) {
/* 154 */       res.setS2CCode(500);
/*     */     } else {
/* 156 */       res.setS2CCode(200);
/* 157 */       res.setS2COrderId(orderId);
/*     */       
/* 159 */       FeeOrderPO po = new FeeOrderPO();
/* 160 */       po.orderId = orderId;
/* 161 */       po.createtime = new Date();
/* 162 */       po.playerId = player.getId();
/* 163 */       po.productId = productId;
/* 164 */       po.isCard = isCard;
/* 165 */       po.isSuperPackage = isSuperPackage;
/*     */ 
/*     */       
/* 168 */       GCache.put(ConstsTR.feeOrder.value + "/" + po.orderId, Utils.serialize(po), 432000);
/*     */       
/* 170 */       Out.info(new Object[] { "创建订单 playerId=", player.getId(), ",name=", player.getName(), ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage) });
/*     */ 
/*     */       
/* 173 */       if (StringUtils.isNotEmpty(notifyOrderUrl)) {
/* 174 */         res.setAppNotifyUrl(notifyOrderUrl);
/*     */       }
/*     */     } 
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
/* 192 */     PomeloResponse me = new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException
/*     */         {
/* 196 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/* 199 */     return me;
/*     */   }
/*     */   
/*     */   public PomeloResponse createOrderId(int productId, int channelId, WNPlayer player, boolean isCard, String imei, int os) {
/* 203 */     return createOrderId(productId, channelId, player, isCard, false, imei, os);
/*     */   }
/*     */   
/*     */   public void onSimulationOrder(String orderId, String playerId, int productId) {
/* 207 */     String orderKey = ConstsTR.feeOrder.value + "/" + orderId;
/* 208 */     if (!GCache.exists(orderKey)) {
/* 209 */       FeeOrderPO po = new FeeOrderPO();
/* 210 */       po.orderId = orderId;
/* 211 */       po.createtime = new Date();
/* 212 */       po.playerId = playerId;
/* 213 */       po.productId = productId;
/*     */       
/* 215 */       if (productId < 100) {
/* 216 */         po.isCard = true;
/*     */       
/*     */       }
/* 219 */       else if (productId > 300) {
/* 220 */         po.isSuperPackage = true;
/*     */       } 
/*     */ 
/*     */       
/* 224 */       GCache.put(orderKey, Utils.serialize(po), 86400);
/* 225 */       Out.info(new Object[] { "创建虚拟订单 playerId=", playerId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(po.isCard), ",isSuperPackage=", Boolean.valueOf(po.isSuperPackage) });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\prepaid\PrepaidService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */