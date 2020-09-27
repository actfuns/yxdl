/*     */ package com.wanniu.game.onlineGift;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.game.attendance.PlayerAttendance;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.OlGiftExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.OnlineDataPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.area.OnlineGiftHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OnlineGiftManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public OnlineDataPO onlineData;
/*     */   public Const.ONLINE_GIFT_TYPE giftType;
/*  34 */   public ScheduledFuture<?> timer = null;
/*     */   
/*     */   public OnlineGiftManager(WNPlayer player, OnlineDataPO data) {
/*  37 */     this.player = player;
/*  38 */     this.onlineData = data;
/*  39 */     initGiftType();
/*  40 */     if (this.onlineData == null) {
/*  41 */       this.onlineData = PlayerUtil.createOnlineData(player.getId(), this.giftType, player.player.upLevel, player.getLevel());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getNextDaySpecifiedTime(Date time, int hour) {
/*  49 */     Calendar nextFive = Calendar.getInstance();
/*  50 */     nextFive.setTime(time);
/*  51 */     nextFive.add(5, 1);
/*  52 */     nextFive.set(11, hour);
/*  53 */     nextFive.set(12, 0);
/*  54 */     nextFive.set(13, 0);
/*  55 */     nextFive.set(14, 0);
/*     */     
/*  57 */     return nextFive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFirstDay() {
/*  66 */     Calendar now = Calendar.getInstance();
/*  67 */     Calendar nextFive = getNextDaySpecifiedTime((this.player.getPlayer()).createTime, 5);
/*  68 */     return now.before(nextFive);
/*     */   }
/*     */   
/*     */   public void initGiftType() {
/*  72 */     this.giftType = Const.ONLINE_GIFT_TYPE.NORMAL;
/*  73 */     if (isFirstDay()) {
/*  74 */       this.giftType = Const.ONLINE_GIFT_TYPE.FIRST_DAY;
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLogin() {
/*  79 */     startTimer();
/*     */   }
/*     */   
/*     */   public void cancelTimer() {
/*  83 */     if (null != this.timer) {
/*  84 */       this.timer.cancel(true);
/*  85 */       this.timer = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkIsAllReceived() {
/*  90 */     int sum = 0;
/*  91 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
/*  92 */     for (Integer state : this.onlineData.rewardState.values()) {
/*  93 */       if (PlayerAttendance.GiftState.RECEIVED.getValue() == state.intValue() || PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == state.intValue()) {
/*  94 */         sum++;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     return (sum >= propList.size());
/*     */   }
/*     */   
/*     */   public void startTimer() {
/* 102 */     cancelTimer();
/* 103 */     if (!checkIsAllReceived()) {
/* 104 */       this.timer = JobFactory.addScheduleJob(new Runnable()
/*     */           {
/*     */             public void run() {
/* 107 */               OnlineGiftManager.this.onlineData.sumTime++;
/* 108 */               OnlineGiftManager.this.updateState(OnlineGiftManager.this.onlineData.sumTime);
/* 109 */               if (OnlineGiftManager.this.checkIsAllReceived()) {
/* 110 */                 OnlineGiftManager.this.cancelTimer();
/*     */               }
/*     */             }
/* 113 */           },  1L, Const.Time.Second.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {
/* 118 */     this.onlineData.sumTime = 0L;
/* 119 */     this.onlineData.rewardState.clear();
/* 120 */     startTimer();
/* 121 */     initGiftType();
/* 122 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
/* 123 */     for (int i = 0; i < propList.size(); i++) {
/* 124 */       this.onlineData.rewardState.put(Integer.valueOf(((OlGiftExt)propList.get(i)).giftId), Integer.valueOf(PlayerAttendance.GiftState.NO_RECEIVE.getValue()));
/*     */     }
/* 126 */     pushGiftInfoToClient();
/*     */   }
/*     */   
/*     */   public void updateState(long sumTime) {
/* 130 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
/* 131 */     boolean isNeedPushRedPoint = false;
/* 132 */     for (OlGiftExt prop : propList) {
/* 133 */       if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId)) || PlayerAttendance.GiftState.RECEIVED.getValue() == ((Integer)this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
/*     */         continue;
/*     */       }
/*     */       
/* 137 */       if (sumTime >= (prop.time * 60) && PlayerAttendance.GiftState.NO_RECEIVE.getValue() == ((Integer)this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
/* 138 */         this.onlineData.rewardState.put(Integer.valueOf(prop.giftId), Integer.valueOf(PlayerAttendance.GiftState.CAN_RECEIVE.getValue()));
/* 139 */         isNeedPushRedPoint = true;
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     if (isNeedPushRedPoint) {
/* 144 */       this.player.activityManager.updateSuperScriptList();
/*     */     }
/*     */   }
/*     */   
/*     */   public OnlineGiftHandler.OnlineGift toJson4Payload() {
/* 149 */     OnlineGiftHandler.OnlineGift.Builder data = OnlineGiftHandler.OnlineGift.newBuilder();
/* 150 */     data.setOnlineTime((int)this.onlineData.sumTime);
/* 151 */     ArrayList<OnlineGiftHandler.GiftInfo> giftList = new ArrayList<>();
/*     */     
/* 153 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
/*     */     
/* 155 */     for (OlGiftExt prop : propList) {
/* 156 */       OnlineGiftHandler.GiftInfo.Builder tempInfo = OnlineGiftHandler.GiftInfo.newBuilder();
/* 157 */       if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId))) {
/*     */         continue;
/*     */       }
/*     */       
/* 161 */       tempInfo.setState(((Integer)this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue());
/* 162 */       tempInfo.setId(prop.giftId);
/* 163 */       tempInfo.setTime(prop.time);
/* 164 */       tempInfo.setName(prop.name);
/* 165 */       tempInfo.addAllItem(prop.getMiniItems());
/* 166 */       giftList.add(tempInfo.build());
/*     */     } 
/*     */     
/* 169 */     data.addAllGiftList(giftList);
/*     */     
/* 171 */     return data.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerHandler.SuperScriptType getSuperScript() {
/* 178 */     int number = 0;
/* 179 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
/*     */     
/* 181 */     for (OlGiftExt prop : propList) {
/* 182 */       if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId)) || PlayerAttendance.GiftState.CAN_RECEIVE.getValue() != ((Integer)this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
/*     */         continue;
/*     */       }
/*     */       
/* 186 */       number++;
/*     */     } 
/*     */     
/* 189 */     PlayerHandler.SuperScriptType.Builder scriptNum = PlayerHandler.SuperScriptType.newBuilder();
/* 190 */     scriptNum.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ONLINE_GIFT.getValue());
/* 191 */     scriptNum.setNumber(number);
/* 192 */     return scriptNum.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerOffline() {
/* 199 */     cancelTimer();
/*     */   }
/*     */   
/*     */   public int receiveGift(int giftId) {
/* 203 */     OlGiftExt prop = OnlineGiftUtil.getPropById(giftId);
/* 204 */     if (prop == null || !this.onlineData.rewardState.containsKey(Integer.valueOf(giftId))) {
/* 205 */       return -6;
/*     */     }
/* 207 */     if (prop.type != this.giftType.getValue()) {
/* 208 */       return -7;
/*     */     }
/* 210 */     if (PlayerAttendance.GiftState.RECEIVED.getValue() == ((Integer)this.onlineData.rewardState.get(Integer.valueOf(giftId))).intValue()) {
/* 211 */       return -1;
/*     */     }
/* 213 */     if ((this.player.getPlayer()).upLevel != 0) {
/* 214 */       if ((this.player.getPlayer()).upLevel < prop.downOrder || (this.player.getPlayer()).upLevel > prop.upOrder) {
/* 215 */         return -2;
/*     */       }
/*     */     }
/* 218 */     else if (this.player.getLevel() < prop.lvDown || this.player.getLevel() > prop.lvUp) {
/* 219 */       return -3;
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (PlayerAttendance.GiftState.NO_RECEIVE.getValue() == ((Integer)this.onlineData.rewardState.get(Integer.valueOf(giftId))).intValue()) {
/* 224 */       return -4;
/*     */     }
/*     */     
/* 227 */     List<WNBag.SimpleItemInfo> items = prop.items;
/* 228 */     Map<String, Integer> rewards = new HashMap<>();
/* 229 */     for (int i = 0; i < items.size(); i++) {
/* 230 */       WNBag.SimpleItemInfo tmp = items.get(i);
/* 231 */       rewards.put(tmp.itemCode, Integer.valueOf(tmp.itemNum));
/*     */     } 
/*     */     
/* 234 */     List<NormalItem> list_items = ItemUtil.createItemsByItemCode(rewards);
/* 235 */     this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.ONLINE_GIFT, "Bag_full_common");
/*     */     
/* 237 */     this.onlineData.rewardState.put(Integer.valueOf(giftId), Integer.valueOf(PlayerAttendance.GiftState.RECEIVED.getValue()));
/*     */     
/* 239 */     this.player.activityManager.updateSuperScriptList();
/* 240 */     return 0;
/*     */   }
/*     */   
/*     */   public void pushGiftInfoToClient() {
/* 244 */     OnlineGiftHandler.GiftInfoPush.Builder data = OnlineGiftHandler.GiftInfoPush.newBuilder();
/* 245 */     data.setS2CCode(200);
/* 246 */     data.setS2CGift(toJson4Payload());
/* 247 */     this.player.receive("area.onlineGiftPush.giftInfoPush", (GeneratedMessage)data.build());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\onlineGift\OnlineGiftManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */