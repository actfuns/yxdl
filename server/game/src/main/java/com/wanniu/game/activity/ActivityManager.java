/*      */ package com.wanniu.game.activity;
/*      */ 
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.ClassUtil;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.core.util.RandomUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.activity.po.LuckyAward;
/*      */ import com.wanniu.game.bag.WNBag;
/*      */ import com.wanniu.game.chat.ChannelUtil;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ModuleManager;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.daily.DailyActivityMgr;
/*      */ import com.wanniu.game.data.ActivityCO;
/*      */ import com.wanniu.game.data.ActivityConfigCO;
/*      */ import com.wanniu.game.data.AdventureItemAddCO;
/*      */ import com.wanniu.game.data.AdventureItemCO;
/*      */ import com.wanniu.game.data.DrawCO;
/*      */ import com.wanniu.game.data.ForgedRandomAddCO;
/*      */ import com.wanniu.game.data.ForgedRandomCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.GroupRandomAddCO;
/*      */ import com.wanniu.game.data.GroupRandomCO;
/*      */ import com.wanniu.game.data.LimitTimeGiftCO;
/*      */ import com.wanniu.game.data.SevenLoginCO;
/*      */ import com.wanniu.game.data.SuperPackageCO;
/*      */ import com.wanniu.game.data.ext.ActivityConfigExt;
/*      */ import com.wanniu.game.data.ext.ActivityExt;
/*      */ import com.wanniu.game.data.ext.DrawExt;
/*      */ import com.wanniu.game.data.ext.RecoveryExt;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.ActivityDataPO;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Stack;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.lang3.time.DateUtils;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.ActivityFavorHandler;
/*      */ import pomelo.area.ActivityHandler;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ActivityManager
/*      */   extends ModuleManager
/*      */ {
/*      */   private WNPlayer player;
/*      */   private ActivityDataPO opts;
/*      */   private int luckyAwardTotalRate;
/*      */   private Stack<Integer> cachedLimitTimeGiftStack;
/*      */   
/*      */   private static void SortActivityConfigExt(List<ActivityConfigExt> awardProps) {
/*  104 */     Collections.sort(awardProps, (o1, o2) -> o1.parameter1 - o2.parameter1);
/*      */   }
/*      */   
/*      */   public ActivityManager(WNPlayer player, ActivityDataPO opts) {
/*  108 */     this.player = player;
/*  109 */     this.opts = opts;
/*  110 */     _init();
/*  111 */     this.cachedLimitTimeGiftStack = new Stack<>();
/*      */   }
/*      */   
/*      */   private void _init() {
/*  115 */     if (this.opts.drawedContainer.size() == 0 && this.opts.luckyAwardContainer.size() == 0)
/*  116 */       refreshLuckyAwardContainer(); 
/*      */   }
/*      */   
/*      */   public static class ResultSuperScript
/*      */   {
/*      */     public Const.SUPERSCRIPT_TYPE type;
/*      */     public int number;
/*      */   }
/*      */   
/*      */   public ActivityDataPO toJson4Serialize() {
/*  126 */     return this.opts;
/*      */   }
/*      */   
/*      */   public ActivityExt findActivityByType(int type) {
/*  130 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == type));
/*  131 */     for (ActivityCO _prop : props) {
/*  132 */       ActivityExt prop = (ActivityExt)_prop;
/*  133 */       if (null != prop) {
/*  134 */         return prop;
/*      */       }
/*      */     } 
/*  137 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ActivityConfigExt> findActivitieConfigsByRewardType(Const.ActivityRewardType activityRewardType) {
/*  147 */     ActivityExt activityExt = findActivityByType(activityRewardType.getValue());
/*  148 */     return GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
/*      */   }
/*      */   
/*      */   public ActivityExt findActivityById(int id) {
/*  152 */     List<ActivityExt> props = GameData.findActivitys(t -> (t.activityID == id));
/*  153 */     if (props.size() > 0) {
/*  154 */       ActivityExt prop = props.get(0);
/*  155 */       if (null != prop) {
/*  156 */         return prop;
/*      */       }
/*      */     } 
/*  159 */     return null;
/*      */   }
/*      */   
/*      */   public boolean hasFirstPayReward() {
/*  163 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.FIRST_PAY.getValue());
/*  164 */     if (prop == null) {
/*  165 */       return false;
/*      */     }
/*  167 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  168 */     if (props.size() > 0) {
/*  169 */       return isReward(((ActivityConfigExt)props.get(0)).id);
/*      */     }
/*  171 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSecondPayVaild() {
/*  176 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
/*  177 */     if (prop == null)
/*  178 */       return false; 
/*  179 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  180 */     for (ActivityConfigCO awardProp : awardProps) {
/*  181 */       if (!isReward(awardProp.id))
/*  182 */         return true; 
/*      */     } 
/*  184 */     return false;
/*      */   }
/*      */   
/*      */   public ActivityHandler.PayFirstResponse.Builder payFirst() {
/*  188 */     ActivityHandler.PayFirstResponse.Builder data = ActivityHandler.PayFirstResponse.newBuilder();
/*  189 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.FIRST_PAY.getValue());
/*  190 */     if (prop == null) {
/*  191 */       return data;
/*      */     }
/*  193 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  194 */     if (awardProps.size() > 0) {
/*  195 */       ActivityConfigExt awardProp = awardProps.get(0);
/*  196 */       if (!isReward(awardProp.id)) {
/*  197 */         data.setS2CAwardId(awardProp.id);
/*  198 */         ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
/*  199 */         ArrayList<ItemOuterClass.MiniItem> list = new ArrayList<>();
/*  200 */         for (WNBag.SimpleItemInfo item : reward) {
/*  201 */           ItemOuterClass.MiniItem.Builder bi = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/*  202 */           list.add(bi.build());
/*      */         } 
/*  204 */         data.addAllS2CAwardItems(list);
/*  205 */         if (this.player.prepaidManager.getPayedTimes() > 0)
/*      */         {
/*  207 */           data.setS2CState(1);
/*      */         }
/*      */       } 
/*      */     } 
/*  211 */     return data;
/*      */   }
/*      */   
/*      */   public ActivityHandler.PayFirstResponse.Builder paySecond() {
/*  215 */     ActivityHandler.PayFirstResponse.Builder data = ActivityHandler.PayFirstResponse.newBuilder();
/*  216 */     if (this.player.prepaidManager.getPayedTimes() < 1) {
/*  217 */       return data;
/*      */     }
/*  219 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
/*  220 */     if (prop == null) {
/*  221 */       return data;
/*      */     }
/*  223 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  224 */     SortActivityConfigExt(awardProps);
/*  225 */     int i = 0;
/*  226 */     for (ActivityConfigCO _awardProp : awardProps) {
/*  227 */       ActivityConfigExt awardProp = (ActivityConfigExt)_awardProp;
/*  228 */       if (!isReward(awardProp.id)) {
/*  229 */         data.setS2CAwardId(awardProp.id);
/*  230 */         ArrayList<ItemOuterClass.MiniItem> list = new ArrayList<>();
/*  231 */         ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
/*  232 */         for (WNBag.SimpleItemInfo item : reward) {
/*  233 */           ItemOuterClass.MiniItem.Builder bi = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/*  234 */           list.add(bi.build());
/*      */         } 
/*  236 */         data.addAllS2CAwardItems(list);
/*  237 */         if (this.player.prepaidManager.isEachPayMoneyEnough(i + 1, awardProp.parameter1))
/*      */         {
/*  239 */           data.setS2CState(1);
/*      */         }
/*      */         
/*      */         break;
/*      */       } 
/*  244 */       i++;
/*      */     } 
/*  246 */     return data;
/*      */   }
/*      */   
/*      */   public ActivityHandler.totalInfo.Builder payTotal() {
/*  250 */     ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
/*  251 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.TOTAL_PAY.getValue());
/*  252 */     if (prop == null) {
/*  253 */       data.setBeginTime("");
/*  254 */       data.setEndTime("");
/*  255 */       data.setDescribe("");
/*  256 */       return data;
/*      */     } 
/*  258 */     data.setBeginTime(prop.openTime);
/*  259 */     data.setEndTime(prop.closeTime);
/*  260 */     data.setDescribe(prop.activityRule);
/*      */     
/*  262 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  263 */     ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
/*  264 */     for (ActivityConfigCO _awardProp : awardProps) {
/*  265 */       ActivityConfigExt awardProp = (ActivityConfigExt)_awardProp;
/*  266 */       ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
/*  267 */       info.setAwardId(awardProp.id);
/*  268 */       ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
/*  269 */       info.setState(0);
/*  270 */       ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
/*  271 */       for (WNBag.SimpleItemInfo item : reward) {
/*  272 */         ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/*  273 */         list_item.add(_item.build());
/*      */       } 
/*  275 */       info.addAllAwardItems(list_item);
/*  276 */       int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
/*  277 */       info.setCurrNum(allPrepaidMoney);
/*  278 */       info.setNeedNum(awardProp.parameter1);
/*  279 */       if (isReward(awardProp.id)) {
/*  280 */         info.setState(2);
/*  281 */       } else if (allPrepaidMoney >= awardProp.parameter1) {
/*  282 */         info.setState(1);
/*      */       } 
/*  284 */       list.add(info.build());
/*      */     } 
/*  286 */     data.addAllAwards(list);
/*  287 */     return data;
/*      */   }
/*      */   
/*      */   public ActivityHandler.totalInfo.Builder consumeTotal() {
/*  291 */     ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
/*  292 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.TOTAL_CONSUME.getValue());
/*  293 */     if (prop == null) {
/*  294 */       data.setBeginTime("");
/*  295 */       data.setEndTime("");
/*  296 */       data.setDescribe("");
/*  297 */       return data;
/*      */     } 
/*  299 */     data.setBeginTime(prop.openTime);
/*  300 */     data.setEndTime(prop.closeTime);
/*  301 */     data.setDescribe(prop.activityRule);
/*  302 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*  303 */     ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
/*  304 */     for (ActivityConfigCO _awardProp : awardProps) {
/*  305 */       ActivityConfigExt awardProp = (ActivityConfigExt)_awardProp;
/*  306 */       ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
/*  307 */       info.setAwardId(awardProp.id);
/*  308 */       ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
/*  309 */       info.setState(0);
/*  310 */       ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
/*  311 */       for (WNBag.SimpleItemInfo item : reward) {
/*  312 */         ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/*  313 */         list_item.add(_item.build());
/*      */       } 
/*  315 */       info.addAllAwardItems(list_item);
/*  316 */       int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
/*  317 */       info.setCurrNum(allConsumeMoney);
/*  318 */       info.setNeedNum(awardProp.parameter1);
/*  319 */       if (isReward(awardProp.id)) {
/*  320 */         info.setState(2);
/*  321 */       } else if (allConsumeMoney >= awardProp.parameter1) {
/*  322 */         info.setState(1);
/*      */       } 
/*  324 */       list.add(info.build());
/*      */     } 
/*  326 */     data.addAllAwards(list);
/*  327 */     return data;
/*      */   }
/*      */   
/*      */   public ActivityHandler.ActivityLevelOrSwordResponse.Builder levelOrSword(int activityId) {
/*  331 */     ActivityHandler.ActivityLevelOrSwordResponse.Builder datas = ActivityHandler.ActivityLevelOrSwordResponse.newBuilder();
/*  332 */     ActivityExt activity = findActivityById(activityId);
/*  333 */     if (activity == null)
/*  334 */       return datas; 
/*  335 */     datas.setS2CBeginTime(activity.openTime);
/*  336 */     datas.setS2CBeginTime(activity.closeTime);
/*  337 */     datas.setS2CContent(activity.activityRule);
/*  338 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activity.activityID));
/*  339 */     ArrayList<ActivityHandler.awardState> list = new ArrayList<>();
/*  340 */     for (ActivityConfigCO _prop : props) {
/*  341 */       ActivityConfigExt prop = (ActivityConfigExt)_prop;
/*  342 */       ActivityHandler.awardState.Builder info = ActivityHandler.awardState.newBuilder();
/*  343 */       info.setAwardId(prop.id);
/*  344 */       ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
/*  345 */       info.setState(Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue());
/*  346 */       info.setNeedValue(prop.parameter1);
/*  347 */       ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);
/*  348 */       for (WNBag.SimpleItemInfo item : reward) {
/*  349 */         ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/*  350 */         list_item.add(_item.build());
/*      */       } 
/*  352 */       info.addAllAwardItems(list_item);
/*  353 */       int currNum = 0;
/*  354 */       if (activity.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
/*  355 */         currNum = this.player.getLevel();
/*      */       } else {
/*  357 */         currNum = (this.player.getPlayer()).fightPower;
/*      */       } 
/*      */       
/*  360 */       if (isReward(prop.id)) {
/*  361 */         info.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
/*  362 */       } else if (currNum >= prop.parameter1) {
/*  363 */         info.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
/*      */       } 
/*  365 */       list.add(info.build());
/*      */     } 
/*  367 */     datas.addAllS2CData(list);
/*      */     
/*  369 */     return datas;
/*      */   }
/*      */   
/*      */   public ActivityHandler.ActivityOpenFundsRes.Builder openFunds() {
/*  373 */     ActivityHandler.ActivityOpenFundsRes.Builder datas = ActivityHandler.ActivityOpenFundsRes.newBuilder();
/*  374 */     datas.setS2CBuyState(1);
/*  375 */     ArrayList<ActivityHandler.openFundsAward> list = new ArrayList<>();
/*  376 */     ActivityExt activity = findActivityByType(Const.ActivityRewardType.FOUNDATION.getValue());
/*  377 */     if (activity == null) {
/*  378 */       datas.addAllS2CData(new ArrayList());
/*  379 */       return datas;
/*      */     } 
/*  381 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activity.activityID));
/*  382 */     Object<Integer, Integer> fund = (Object<Integer, Integer>)getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
/*  383 */     if (fund != null)
/*  384 */       datas.setS2CBuyState(2); 
/*  385 */     for (ActivityConfigCO _prop : props) {
/*  386 */       ActivityHandler.openFundsAward.Builder _openFundsAward = ActivityHandler.openFundsAward.newBuilder();
/*  387 */       ActivityConfigExt prop = (ActivityConfigExt)_prop;
/*  388 */       ActivityHandler.awardState.Builder info = ActivityHandler.awardState.newBuilder();
/*  389 */       info.setAwardId(prop.id);
/*  390 */       info.setState(0);
/*  391 */       info.setNeedValue(0);
/*  392 */       ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
/*  393 */       int currNum = 0;
/*  394 */       ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);
/*  395 */       int parameter1 = prop.parameter1;
/*  396 */       for (WNBag.SimpleItemInfo item : reward) {
/*  397 */         _openFundsAward.setDiamond(item.itemNum);
/*  398 */         list_item.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
/*      */       } 
/*  400 */       info.addAllAwardItems(list_item);
/*  401 */       if ("Activity_Fund".equals(prop.notes1)) {
/*  402 */         currNum = this.player.getLevel();
/*  403 */         _openFundsAward.setType(1);
/*  404 */       } else if ("Activity_Fund_UpLevel".equals(prop.notes1)) {
/*  405 */         if (parameter1 > 10000) {
/*  406 */           parameter1 %= 10000;
/*      */         }
/*  408 */         currNum = this.player.player.upLevel;
/*  409 */         _openFundsAward.setType(1);
/*      */       } else {
/*  411 */         currNum = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
/*  412 */         _openFundsAward.setType(2);
/*      */       } 
/*  414 */       if (isReward(prop.id)) {
/*  415 */         info.setState(2);
/*  416 */       } else if (currNum >= parameter1) {
/*  417 */         info.setState(1);
/*      */       } else {
/*  419 */         info.setState(0);
/*      */       } 
/*  421 */       _openFundsAward.setAward(info.build());
/*  422 */       _openFundsAward.setValue(prop.parameter1);
/*  423 */       list.add(_openFundsAward.build());
/*      */     } 
/*  425 */     datas.addAllS2CData(list);
/*  426 */     return datas;
/*      */   }
/*      */   
/*      */   public HashMap<Integer, Integer> getActivityInfo(int value) {
/*  430 */     return (HashMap<Integer, Integer>)this.opts.activityInfo.get(Integer.valueOf(value));
/*      */   }
/*      */   
/*      */   public void addActivityInfo(int id, HashMap<Integer, Integer> data) {
/*  434 */     this.opts.activityInfo.put(Integer.valueOf(id), data);
/*      */   }
/*      */   
/*      */   public static class RewardRecord {
/*      */     public int awardId;
/*      */     public Date awardTime;
/*      */   }
/*      */   
/*      */   public ActivityHandler.ActivityAwardResponse.Builder activityAward(int awardId, int activityId) {
/*  443 */     ActivityHandler.ActivityAwardResponse.Builder data = ActivityHandler.ActivityAwardResponse.newBuilder();
/*  444 */     data.setS2CCode(200);
/*      */     
/*  446 */     ActivityExt propCenter = findActivityById(activityId);
/*  447 */     if (propCenter == null) {
/*  448 */       data.setS2CCode(500);
/*  449 */       data.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  450 */       return data;
/*      */     } 
/*  452 */     if (propCenter.isOpen == 0) {
/*  453 */       data.setS2CCode(500);
/*  454 */       data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_OPEN"));
/*  455 */       return data;
/*      */     } 
/*      */     
/*  458 */     if (propCenter.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue()) {
/*  459 */       if (!isReward(awardId)) {
/*  460 */         RewardRecord rr = new RewardRecord();
/*  461 */         rr.awardId = awardId;
/*  462 */         rr.awardTime = new Date();
/*  463 */         this.opts.activityRewardRecorder.put(Integer.valueOf(rr.awardId), rr);
/*      */       } 
/*  465 */       return data;
/*      */     } 
/*  467 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.id == awardId));
/*  468 */     if (props.size() <= 0 || ((ActivityConfigExt)props.get(0)).type != activityId) {
/*  469 */       data.setS2CCode(500);
/*  470 */       data.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  471 */       return data;
/*      */     } 
/*  473 */     ActivityConfigExt prop = props.get(0);
/*  474 */     Const.GOODS_CHANGE_TYPE origin = getActivityDetailOrigin(propCenter.activityTab);
/*      */     
/*  476 */     if (propCenter.activityTab != Const.ActivityRewardType.HAOLI_CHANGE.getValue() && 
/*  477 */       isReward(awardId)) {
/*  478 */       data.setS2CCode(500);
/*  479 */       data.setS2CMsg(LangService.getValue("ACTIVITY_RECEIVE"));
/*  480 */       return data;
/*      */     } 
/*      */     
/*  483 */     if (propCenter.activityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
/*  484 */       if (this.player.prepaidManager.getPayedTimes() == 0) {
/*  485 */         data.setS2CCode(500);
/*  486 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
/*  487 */         return data;
/*      */       } 
/*  489 */     } else if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
/*  490 */       if (!isSecondAwardValid(awardId)) {
/*  491 */         data.setS2CCode(500);
/*  492 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
/*  493 */         return data;
/*      */       } 
/*  495 */     } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
/*  496 */       int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
/*  497 */       if (allPrepaidMoney < prop.parameter1) {
/*  498 */         data.setS2CCode(500);
/*  499 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
/*  500 */         return data;
/*      */       } 
/*  502 */     } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
/*  503 */       int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
/*  504 */       if (allConsumeMoney < prop.parameter1) {
/*  505 */         data.setS2CCode(500);
/*  506 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
/*  507 */         return data;
/*      */       } 
/*  509 */     } else if (propCenter.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
/*  510 */       if (this.player.getLevel() < prop.parameter1) {
/*  511 */         data.setS2CCode(500);
/*  512 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
/*  513 */         return data;
/*      */       } 
/*  515 */     } else if (propCenter.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
/*  516 */       int power = (this.player.getPlayer()).fightPower;
/*  517 */       if (power < prop.parameter1) {
/*  518 */         data.setS2CCode(500);
/*  519 */         data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_BATTLE"));
/*  520 */         return data;
/*      */       } 
/*  522 */     } else if (propCenter.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
/*  523 */       if (getHaoliChangeState(prop) != Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
/*  524 */         data.setS2CCode(500);
/*  525 */         data.setS2CMsg(LangService.getValue("ACTIVITY_CHANGE_ITEM_NOT_ENOUGH"));
/*  526 */         return data;
/*      */       } 
/*  528 */       ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(prop.costItems);
/*  529 */       List<WNBag.SimpleItemInfo> list = getRankReward(prop.RankReward);
/*      */       
/*  531 */       List<Common.KeyValueStruct> changeItems = new ArrayList<>();
/*  532 */       for (WNBag.SimpleItemInfo simpleItemInfo : list) {
/*  533 */         Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
/*  534 */         items.setKey(simpleItemInfo.itemCode);
/*  535 */         items.setValue(String.valueOf(simpleItemInfo.itemNum));
/*  536 */         changeItems.add(items.build());
/*      */       } 
/*      */       
/*  539 */       for (int i = 0; i < costItem.size(); i++) {
/*  540 */         if (((WNBag.SimpleItemInfo)costItem.get(i)).itemCode.equals("diamond")) {
/*  541 */           this.player.moneyManager.costDiamond(((WNBag.SimpleItemInfo)costItem.get(i)).itemNum, origin, changeItems);
/*  542 */         } else if (((WNBag.SimpleItemInfo)costItem.get(i)).itemCode.equals("cash")) {
/*  543 */           this.player.moneyManager.costTicket(((WNBag.SimpleItemInfo)costItem.get(i)).itemNum, origin, changeItems);
/*  544 */         } else if (((WNBag.SimpleItemInfo)costItem.get(i)).itemCode.equals("gold")) {
/*  545 */           this.player.moneyManager.costGold(((WNBag.SimpleItemInfo)costItem.get(i)).itemNum, origin);
/*      */         } else {
/*  547 */           this.player.bag.discardItem(((WNBag.SimpleItemInfo)costItem.get(i)).itemCode, ((WNBag.SimpleItemInfo)costItem.get(i)).itemNum, origin);
/*      */         } 
/*      */       } 
/*  550 */       HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
/*      */       
/*  552 */       if (actInfo == null) {
/*  553 */         HashMap<Integer, Integer> actData = new HashMap<>();
/*  554 */         actData.put(Integer.valueOf(prop.id), Integer.valueOf(1));
/*  555 */         addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actData);
/*      */       }
/*  557 */       else if (actInfo.containsKey(Integer.valueOf(prop.id))) {
/*  558 */         actInfo.put(Integer.valueOf(prop.id), Integer.valueOf(((Integer)actInfo.get(Integer.valueOf(prop.id))).intValue() + 1));
/*  559 */         addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actInfo);
/*      */       } else {
/*  561 */         actInfo.put(Integer.valueOf(prop.id), Integer.valueOf(1));
/*  562 */         addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actInfo);
/*      */       }
/*      */     
/*  565 */     } else if (propCenter.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
/*  566 */       if (prop.notes1.equals("Activity_Fund") || prop.notes1.equals("Activity_Fund_UpLevel")) {
/*  567 */         HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
/*  568 */         if (actInfo == null) {
/*  569 */           data.setS2CCode(500);
/*  570 */           data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_BUYFUND"));
/*  571 */           return data;
/*      */         } 
/*  573 */         if (prop.notes1.equals("Activity_Fund")) {
/*  574 */           int level = this.player.getLevel();
/*  575 */           if (level < prop.parameter1) {
/*  576 */             data.setS2CCode(500);
/*  577 */             data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
/*  578 */             return data;
/*      */           } 
/*      */         } else {
/*  581 */           int level = this.player.player.upLevel;
/*  582 */           int para = prop.parameter1 % 10000;
/*  583 */           if (level < para) {
/*  584 */             data.setS2CCode(500);
/*  585 */             data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
/*  586 */             return data;
/*      */           } 
/*      */         } 
/*      */       } else {
/*  590 */         int buyCount = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
/*  591 */         if (buyCount < prop.parameter1) {
/*  592 */           data.setS2CCode(500);
/*  593 */           data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_CONDITION"));
/*  594 */           return data;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  603 */     List<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);
/*      */     
/*  605 */     for (WNBag.SimpleItemInfo item : reward) {
/*  606 */       item.forceType = Const.ForceType.BIND;
/*      */     }
/*      */     
/*  609 */     if (this.player.bag.testAddCodeItems(reward, Const.ForceType.BIND, false)) {
/*  610 */       this.player.bag.addCodeItems(reward, origin);
/*      */     } else {
/*  612 */       data.setS2CCode(500);
/*  613 */       return data;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  619 */     if (propCenter.activityTab != Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
/*  620 */       RewardRecord rr = new RewardRecord();
/*  621 */       rr.awardId = prop.id;
/*  622 */       rr.awardTime = new Date();
/*  623 */       this.opts.activityRewardRecorder.put(Integer.valueOf(prop.id), rr);
/*      */     } 
/*      */     
/*  626 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Const.GOODS_CHANGE_TYPE getActivityDetailOrigin(int activityTab) {
/*  636 */     switch (Const.ActivityRewardType.valueOf(activityTab)) {
/*      */       
/*      */       case UPGRADE:
/*  639 */         return Const.GOODS_CHANGE_TYPE.ACTIVITY_LEVEL;
/*      */       
/*      */       case null:
/*  642 */         return Const.GOODS_CHANGE_TYPE.ACTIVITY_FIGHT_POEWR;
/*      */       
/*      */       case null:
/*  645 */         return Const.GOODS_CHANGE_TYPE.RECEIVE_FUNDS;
/*      */       
/*      */       case null:
/*  648 */         return Const.GOODS_CHANGE_TYPE.ACTIVITY_TOTAL_PAY;
/*      */       
/*      */       case null:
/*  651 */         return Const.GOODS_CHANGE_TYPE.ACTIVITY_TOTAL_CONSUME;
/*      */       
/*      */       case null:
/*  654 */         return Const.GOODS_CHANGE_TYPE.exchange;
/*      */       
/*      */       case null:
/*  657 */         return Const.GOODS_CHANGE_TYPE.sign;
/*      */       
/*      */       case null:
/*  660 */         return Const.GOODS_CHANGE_TYPE.ActivityDraw;
/*      */ 
/*      */       
/*      */       case null:
/*  664 */         return Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE;
/*      */ 
/*      */       
/*      */       case null:
/*  668 */         return Const.GOODS_CHANGE_TYPE.recovered;
/*      */       
/*      */       case null:
/*  671 */         return Const.GOODS_CHANGE_TYPE.DailyRecharge;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case null:
/*  678 */         return Const.GOODS_CHANGE_TYPE.ActivityDrawSpring;
/*      */     } 
/*      */     
/*  681 */     Out.error(new Object[] { "福利活动里的产出类型未配置. activityTab=", Integer.valueOf(activityTab) });
/*  682 */     return Const.GOODS_CHANGE_TYPE.def;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSecondAwardValid(int awardId) {
/*  687 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
/*  688 */     if (prop == null) {
/*  689 */       return false;
/*      */     }
/*  691 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/*      */     
/*  693 */     SortActivityConfigExt(awardProps);
/*  694 */     for (int i = 0; i < awardProps.size(); i++) {
/*  695 */       ActivityConfigCO awardProp = (ActivityConfigCO)awardProps.get(i);
/*  696 */       if (awardProp.id == awardId) {
/*  697 */         return this.player.prepaidManager.isEachPayMoneyEnough(i + 1, awardProp.parameter1);
/*      */       }
/*      */     } 
/*  700 */     return false;
/*      */   }
/*      */   
/*      */   public ActivityHandler.ActivityLuckyAwardViewResponse.Builder activityLuckyAwardView() {
/*  704 */     ActivityHandler.ActivityLuckyAwardViewResponse.Builder data = ActivityHandler.ActivityLuckyAwardViewResponse.newBuilder();
/*  705 */     List<DrawExt> props = GameData.findDraws(t -> (t.iD == Const.LuckyDrawType.RECOMMEND_ITEM.getValue()));
/*  706 */     if (props.size() > 0) {
/*  707 */       DrawExt prop = props.get(0);
/*  708 */       ArrayList<ItemOuterClass.MiniItem> arrayList = new ArrayList<>();
/*  709 */       for (DrawExt.DrawItem item : prop.items) {
/*  710 */         arrayList.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
/*      */       }
/*  712 */       data.addAllS2CAwards(arrayList);
/*      */     } 
/*  714 */     Date now = new Date();
/*  715 */     int refreshInterval = GlobalConfig.Activity_LuckDraw;
/*  716 */     Calendar tmpTime = Calendar.getInstance();
/*  717 */     tmpTime.setTime(this.opts.refreshTime);
/*  718 */     tmpTime.set(11, 0);
/*  719 */     tmpTime.set(12, 0);
/*  720 */     tmpTime.set(13, 0);
/*  721 */     long diff = now.getTime() - tmpTime.getTimeInMillis();
/*  722 */     long intervalSecond = (refreshInterval * Const.Time.Day.getValue());
/*  723 */     if (diff > intervalSecond) {
/*  724 */       diff %= intervalSecond;
/*      */     }
/*  726 */     data.setS2CLeftRefreshTime((int)Math.floor(((intervalSecond - diff) / Const.Time.Second.getValue())));
/*  727 */     data.addAllS2CAwards(checkAwardDetail());
/*      */     
/*  729 */     ArrayList<ActivityHandler.awardInfo> list = new ArrayList<>();
/*  730 */     for (Integer pos : this.opts.drawedContainer.keySet()) {
/*  731 */       WNBag.SimpleItemInfo drawedAward = (WNBag.SimpleItemInfo)this.opts.drawedContainer.get(pos);
/*  732 */       ActivityHandler.awardInfo.Builder ab = ActivityHandler.awardInfo.newBuilder();
/*  733 */       ab.setPos(pos.intValue());
/*  734 */       ab.setItemInfo(ItemUtil.getMiniItemData(drawedAward.itemCode, drawedAward.itemNum).build());
/*      */     } 
/*  736 */     return data;
/*      */   }
/*      */   
/*      */   public ArrayList<ItemOuterClass.MiniItem> checkAwardDetail() {
/*  740 */     ArrayList<ItemOuterClass.MiniItem> data = new ArrayList<>();
/*  741 */     for (LuckyAward luckyAward : this.opts.luckyAwardContainer) {
/*  742 */       data.add(ItemUtil.getMiniItemData(luckyAward.itemCode, luckyAward.itemNum).build());
/*      */     }
/*  744 */     for (WNBag.SimpleItemInfo drawedAward : this.opts.drawedContainer.values()) {
/*  745 */       data.add(ItemUtil.getMiniItemData(drawedAward.itemCode, drawedAward.itemNum).build());
/*      */     }
/*  747 */     return data;
/*      */   }
/*      */   
/*      */   public ArrayList<ItemOuterClass.MiniItem> luckyAwardView() {
/*  751 */     ArrayList<ItemOuterClass.MiniItem> data = new ArrayList<>();
/*  752 */     List<DrawExt> props = GameData.findDraws(t -> (t.iD == Const.LuckyDrawType.VIEW_ITEM.getValue()));
/*  753 */     if (props.size() > 0) {
/*  754 */       DrawExt prop = props.get(0);
/*  755 */       if (prop.items != null) {
/*  756 */         for (DrawExt.DrawItem item : prop.items) {
/*  757 */           data.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
/*      */         }
/*      */       }
/*      */     } 
/*  761 */     return data;
/*      */   }
/*      */   
/*      */   public void refreshNewDay() {
/*  765 */     refreshLuckyAwardContainer();
/*  766 */     refreshSevendayLogin();
/*  767 */     refreshRecovered();
/*      */ 
/*      */     
/*  770 */     this.opts.refreshTime = this.player.player.refreshTime;
/*      */ 
/*      */     
/*  773 */     this.player.prepaidManager.po.dailyChargeDiamond = 0;
/*  774 */     this.opts.daily_recharge_have_entered = false;
/*  775 */     this.opts.super_pakage_have_enterd = false;
/*  776 */     this.opts.daily_draw_free_time = 1;
/*  777 */     this.opts.daily_draw_free_time_add = 1;
/*  778 */     this.opts.dailyRechargeRecorder.clear();
/*  779 */     this.opts.superPackageRecorder.clear();
/*  780 */     for (Iterator<Integer> iterator = this.opts.timeLimitGiftPushMap.keySet().iterator(); iterator.hasNext(); ) { int key = ((Integer)iterator.next()).intValue();
/*  781 */       this.opts.timeLimitGiftPushMap.put(Integer.valueOf(key), Integer.valueOf(0)); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public ActivityHandler.ReSetluckyAwardResponse.Builder reSetluckyAward() {
/*  787 */     ActivityHandler.ReSetluckyAwardResponse.Builder data = ActivityHandler.ReSetluckyAwardResponse.newBuilder();
/*  788 */     int resetCost = GlobalConfig.Activity_LuckDrwa_Reset;
/*  789 */     if (!this.player.moneyManager.enoughDiamond(resetCost)) {
/*  790 */       data.setS2CCode(500);
/*  791 */       return data;
/*      */     } 
/*  793 */     refreshLuckyAwardContainer();
/*  794 */     this.player.moneyManager.costDiamond(resetCost, Const.GOODS_CHANGE_TYPE.ActivityDraw);
/*      */     
/*  796 */     data.addAllS2CAwards(checkAwardDetail());
/*  797 */     return data;
/*      */   }
/*      */   
/*      */   public WNBag.SimpleItemInfo rateLuckyAward() {
/*  801 */     if (this.luckyAwardTotalRate <= 0) {
/*  802 */       return null;
/*      */     }
/*  804 */     int randRate = Utils.random(0, this.luckyAwardTotalRate - 1);
/*  805 */     int totalRate = 0;
/*  806 */     for (int i = 0; i < this.opts.luckyAwardContainer.size(); i++) {
/*  807 */       LuckyAward luckyAward = this.opts.luckyAwardContainer.get(i);
/*  808 */       if (this.opts.drawedContainer.size() + 1 >= luckyAward.round) {
/*      */ 
/*      */         
/*  811 */         totalRate += luckyAward.itemRate;
/*  812 */         if (totalRate > randRate) {
/*  813 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/*  814 */           item.index = i;
/*  815 */           item.itemCode = luckyAward.itemCode;
/*  816 */           item.itemNum = luckyAward.itemNum;
/*  817 */           item.type = luckyAward.id;
/*  818 */           return item;
/*      */         } 
/*      */       } 
/*  821 */     }  return null;
/*      */   }
/*      */   
/*      */   public ArrayList<WNBag.SimpleItemInfo> getRankReward(HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> data) {
/*  825 */     if (data.containsKey(Integer.valueOf(0))) {
/*  826 */       return data.get(Integer.valueOf(0));
/*      */     }
/*  828 */     return data.get(Integer.valueOf(this.player.getPro()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReward(int id) {
/*  842 */     return this.opts.activityRewardRecorder.containsKey(Integer.valueOf(id));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSumRedPointNum(List<PlayerHandler.SuperScriptType> ls) {
/*  858 */     int sum = 0;
/*  859 */     for (int i = 0; i < ls.size(); i++) {
/*  860 */       PlayerHandler.SuperScriptType elem = ls.get(i);
/*  861 */       if (null != elem)
/*      */       {
/*      */         
/*  864 */         sum += elem.getNumber(); } 
/*      */     } 
/*  866 */     return sum;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLogin() {
/*  871 */     updateDeskRedPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateDeskRedPoint() {
/*  878 */     List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
/*  879 */     int sum = 0;
/*  880 */     for (int i = 0; i < ls.size(); i++) {
/*  881 */       sum += ((PlayerHandler.SuperScriptType)ls.get(i)).getNumber();
/*      */     }
/*      */     
/*  884 */     this.player.updateSuperScript(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE, sum);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateSuperScriptList() {
/*  891 */     List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
/*  892 */     updateDeskRedPoint();
/*  893 */     this.player.updateSuperScriptList(ls);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
/*  904 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  905 */     data.setType(type);
/*  906 */     data.setNumber(num);
/*  907 */     return data.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
/*  916 */     List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
/*  917 */     ls.add(this.player.playerAttendance.getSuperScript());
/*  918 */     ls.add(this.player.onlineGiftManager.getSuperScript());
/*      */     
/*  920 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.ACTIVITY.getValue())) {
/*  921 */       return ls;
/*      */     }
/*  923 */     long now = System.currentTimeMillis();
/*      */     
/*  925 */     for (ActivityExt propCenter : GameData.Activitys.values()) {
/*  926 */       if (propCenter.isOpen == 0) {
/*      */         continue;
/*      */       }
/*  929 */       int scriptType = getRedpointValue(propCenter);
/*  930 */       boolean hasRedpoint = false;
/*  931 */       if (propCenter.beginTime == 0L || propCenter.endTime == 0L || propCenter.beginTime > now || now > propCenter.endTime) {
/*      */         continue;
/*      */       }
/*  934 */       if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue() && !hasFirstPayReward()) {
/*      */         continue;
/*      */       }
/*  937 */       if (propCenter.activityTab == Const.ActivityRewardType.LUCKY_REWARD.getValue()) {
/*  938 */         if (this.opts.drawedContainer.size() == 0);
/*      */         
/*      */         continue;
/*      */       } 
/*  942 */       if (propCenter.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue()) {
/*  943 */         for (String key : ActivityNoticeService.getInstance().getNoticeKey()) {
/*  944 */           if (!isReward(Integer.parseInt(key))) {
/*  945 */             hasRedpoint = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  952 */       if (propCenter.activityTab == Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue()) {
/*  953 */         boolean canGet = false;
/*  954 */         for (Iterator<Integer> iterator = this.opts.sevendayList.iterator(); iterator.hasNext(); ) { int state = ((Integer)iterator.next()).intValue();
/*  955 */           if (state == 1) {
/*  956 */             canGet = true;
/*      */             break;
/*      */           }  }
/*      */         
/*  960 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.OPEN_SERVER_DAY.getValue(), canGet ? 1 : 0));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  965 */       if (propCenter.activityTab == Const.ActivityRewardType.RECOVERY.getValue()) {
/*  966 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.RECOVERY.getValue(), hasRecoveryCount() ? 1 : 0));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  971 */       if (propCenter.activityTab == Const.ActivityRewardType.SUPER_PACKAGE.getValue()) {
/*  972 */         boolean enable = false;
/*  973 */         if (!this.opts.super_pakage_have_enterd)
/*      */         {
/*  975 */           for (SuperPackageCO superPackageCO : GameData.SuperPackages.values()) {
/*  976 */             if (!this.opts.superPackageRecorder.containsKey(Integer.valueOf(superPackageCO.iD))) {
/*  977 */               enable = true;
/*      */             }
/*      */           } 
/*      */         }
/*      */         
/*  982 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SUPER_PACKAGE.getValue(), enable ? 1 : 0));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  987 */       if (propCenter.activityTab == Const.ActivityRewardType.LUCK_DRAW.getValue()) {
/*  988 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.LUCKY_DRAW.getValue(), (this.opts.daily_draw_free_time > 0) ? 1 : 0));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  993 */       if (propCenter.activityTab == Const.ActivityRewardType.SPRING_DRAW.getValue()) {
/*  994 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SPRING_DRAW.getValue(), (this.opts.daily_draw_free_time_add > 0) ? 1 : 0));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  999 */       if (propCenter.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()) {
/* 1000 */         int value = RechargeActivityService.getInstance().getSingleRechargeRedPoint(this.player.getId());
/* 1001 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SINGLE_RECHARGE.getValue(), value));
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/* 1006 */       if (propCenter.activityTab == Const.ActivityRewardType.REVELRY_RECHARGE.getValue()) {
/* 1007 */         int value = RechargeActivityService.getInstance().getRevelryRechargeRedPoint(this.player.getId());
/* 1008 */         ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.REVELRY_RECHARGE.getValue(), value));
/*      */         
/*      */         continue;
/*      */       } 
/* 1012 */       List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == propCenter.activityID));
/* 1013 */       for (int awardIndex = 0; awardIndex < props.size(); awardIndex++) {
/* 1014 */         ActivityConfigExt prop = props.get(awardIndex);
/* 1015 */         if (propCenter.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
/* 1016 */           if (getHaoliChangeState(prop) == Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
/* 1017 */             hasRedpoint = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */           continue;
/*      */         } 
/* 1023 */         if (propCenter.activityTab == Const.ActivityRewardType.DAILY_RECHARGE.getValue()) {
/*      */           
/* 1025 */           if (!this.opts.daily_recharge_have_entered) {
/* 1026 */             hasRedpoint = true;
/*      */           }
/* 1028 */           if (this.player.prepaidManager.po.dailyChargeDiamond > prop.parameter1 && 
/* 1029 */             !this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(prop.id))) {
/* 1030 */             hasRedpoint = true;
/*      */           }
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/* 1037 */         if (isReward(prop.id)) {
/*      */           continue;
/*      */         }
/*      */         
/* 1041 */         if (propCenter.activityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
/* 1042 */           if (this.player.prepaidManager.getPayedTimes() == 0)
/*      */           {
/*      */             continue;
/*      */           }
/*      */         }
/* 1047 */         else if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
/* 1048 */           if (!hasFirstPayReward()) {
/*      */             break;
/*      */           }
/* 1051 */           if (!isSecondAwardValid(prop.id)) {
/*      */             continue;
/*      */           }
/* 1054 */         } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
/* 1055 */           int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
/* 1056 */           if (allPrepaidMoney < prop.parameter1) {
/*      */             break;
/*      */           }
/* 1059 */         } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
/* 1060 */           int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
/* 1061 */           if (allConsumeMoney < prop.parameter1) {
/*      */             break;
/*      */           }
/* 1064 */         } else if (propCenter.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
/* 1065 */           if (this.player.getLevel() < prop.parameter1) {
/*      */             continue;
/*      */           }
/* 1068 */         } else if (propCenter.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
/* 1069 */           int power = (this.player.getPlayer()).fightPower;
/* 1070 */           if (power < prop.parameter1) {
/*      */             break;
/*      */           }
/* 1073 */           scriptType = Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_FC_GIFT.getValue();
/* 1074 */         } else if (propCenter.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
/* 1075 */           if (prop.notes1.equals("Activity_Fund") || prop.notes1.equals("Activity_Fund_UpLevel")) {
/* 1076 */             HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
/* 1077 */             if (actInfo == null) {
/*      */               continue;
/*      */             }
/* 1080 */             if (prop.notes1.equals("Activity_Fund")) {
/* 1081 */               int level = this.player.getLevel();
/* 1082 */               if (level < prop.parameter1) {
/*      */                 continue;
/*      */               }
/*      */             } else {
/* 1086 */               int level = this.player.player.upLevel;
/* 1087 */               int para = prop.parameter1 % 10000;
/* 1088 */               if (level < para) {
/*      */                 break;
/*      */               }
/*      */             } 
/*      */           } else {
/* 1093 */             int buyCount = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
/* 1094 */             if (buyCount < prop.parameter1) {
/*      */               break;
/*      */             }
/*      */           } 
/*      */         } else {
/*      */           break;
/*      */         } 
/* 1101 */         hasRedpoint = true;
/*      */       } 
/*      */       
/* 1104 */       if (scriptType > Const.SUPERSCRIPT_TYPE.MIN.getValue() && hasRedpoint) {
/* 1105 */         ls.add(createSuperScriptType(scriptType, 1)); continue;
/*      */       } 
/* 1107 */       ls.add(createSuperScriptType(scriptType, 0));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1113 */     return ls;
/*      */   }
/*      */   
/*      */   private List<PlayerHandler.SuperScriptType> getLimitTimeSuperScript() {
/* 1117 */     List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
/* 1118 */     int minCount = 0;
/*      */     
/* 1120 */     for (Map.Entry<Integer, Date> entry : (Iterable<Map.Entry<Integer, Date>>)this.opts.timeLimitGiftTriggeredTimeMap.entrySet()) {
/* 1121 */       if (entry.getValue() == null) {
/*      */         continue;
/*      */       }
/*      */       
/* 1125 */       int triggeredId = ((Integer)this.opts.timeLimitGiftTriggeredIdMap.get(entry.getKey())).intValue();
/*      */       
/* 1127 */       if (triggeredId == -1) {
/*      */         continue;
/*      */       }
/*      */       
/* 1131 */       LimitTimeGiftCO limitTimeGiftCO = (LimitTimeGiftCO)GameData.LimitTimeGifts.get(Integer.valueOf(triggeredId));
/*      */ 
/*      */       
/* 1134 */       if (((Integer)this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
/*      */         continue;
/*      */       }
/*      */       
/* 1138 */       long offset = ((Date)entry.getValue()).getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
/* 1139 */       int count = 0;
/* 1140 */       if (offset > 0L) {
/* 1141 */         count = (int)(offset / 1000L);
/*      */       }
/*      */       
/* 1144 */       if (count > 0) {
/* 1145 */         if (minCount == 0) {
/* 1146 */           minCount = count; continue;
/* 1147 */         }  if (minCount > count) {
/* 1148 */           minCount = count;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1154 */     ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.LIMIT_TIME_GIFT.getValue(), minCount));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1159 */     return ls;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRedpointValue(ActivityExt ac) {
/* 1169 */     if (ac.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue())
/* 1170 */       return Const.SUPERSCRIPT_TYPE.TOTAL_PAY.getValue(); 
/* 1171 */     if (ac.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue())
/* 1172 */       return Const.SUPERSCRIPT_TYPE.TOTAL_CONSUME.getValue(); 
/* 1173 */     if (ac.activityTab == Const.ActivityRewardType.LEVEL.getValue())
/* 1174 */       return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_LV_GIFT.getValue(); 
/* 1175 */     if (ac.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue())
/* 1176 */       return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_FC_GIFT.getValue(); 
/* 1177 */     if (ac.activityTab == Const.ActivityRewardType.FOUNDATION.getValue())
/* 1178 */       return Const.SUPERSCRIPT_TYPE.FUNDS.getValue(); 
/* 1179 */     if (ac.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue())
/* 1180 */       return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_EXCHANGE.getValue(); 
/* 1181 */     if (ac.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue())
/* 1182 */       return Const.SUPERSCRIPT_TYPE.GAME_NOTICE.getValue(); 
/* 1183 */     if (ac.activityTab == Const.ActivityRewardType.DAILY_RECHARGE.getValue())
/* 1184 */       return Const.SUPERSCRIPT_TYPE.DAILY_RECHARGE.getValue(); 
/* 1185 */     if (ac.activityTab == Const.ActivityRewardType.SUPER_PACKAGE.getValue())
/* 1186 */       return Const.SUPERSCRIPT_TYPE.SUPER_PACKAGE.getValue(); 
/* 1187 */     if (ac.activityTab == Const.ActivityRewardType.LUCK_DRAW.getValue()) {
/* 1188 */       return Const.SUPERSCRIPT_TYPE.LUCKY_DRAW.getValue();
/*      */     }
/*      */     
/* 1191 */     return 0;
/*      */   }
/*      */   
/*      */   public int getActivityHud(int activityId, int ActivityTab) {
/* 1195 */     int hintNum = 0;
/* 1196 */     List<ActivityConfigExt> awards = GameData.findActivityConfigs(t -> (t.type == activityId));
/* 1197 */     if (ActivityTab == Const.ActivityRewardType.LEVEL.getValue()) {
/* 1198 */       for (ActivityConfigCO item : awards) {
/* 1199 */         if (!isReward(item.id)) {
/* 1200 */           int para = this.player.getLevel();
/* 1201 */           if (item.parameter1 > 10000) {
/* 1202 */             int upLevel = item.parameter1 % 10000;
/* 1203 */             if (this.player.player.upLevel >= upLevel)
/* 1204 */               hintNum++;  continue;
/*      */           } 
/* 1206 */           if (para >= item.parameter1) {
/* 1207 */             hintNum++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1211 */     } else if (ActivityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
/* 1212 */       for (ActivityConfigCO item : awards) {
/* 1213 */         if (!isReward(item.id)) {
/* 1214 */           int para = (this.player.getPlayer()).fightPower;
/* 1215 */           if (para >= item.parameter1) {
/* 1216 */             hintNum++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1220 */     } else if (ActivityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
/* 1221 */       for (ActivityConfigCO item : awards) {
/* 1222 */         if (!isReward(item.id)) {
/* 1223 */           int para = 0;
/* 1224 */           int needPara = item.parameter1;
/* 1225 */           if ("Activity_Fund".equals(item.notes1) || "Activity_Fund_UpLevel".equals(item.notes1)) {
/* 1226 */             HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
/* 1227 */             if (actInfo != null) {
/* 1228 */               if ("Activity_Fund" == item.notes1) {
/* 1229 */                 para = this.player.getLevel();
/*      */               } else {
/* 1231 */                 para = this.player.player.upLevel;
/* 1232 */                 needPara %= 10000;
/*      */               } 
/*      */             }
/*      */           } else {
/* 1236 */             para = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
/*      */           } 
/* 1238 */           if (para >= needPara) {
/* 1239 */             hintNum++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1243 */     } else if (ActivityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
/* 1244 */       for (ActivityConfigCO item : awards) {
/* 1245 */         if (!isReward(item.id) && 
/* 1246 */           this.player.prepaidManager.getPayedTimes() > 0) {
/* 1247 */           hintNum++;
/*      */         }
/*      */       }
/*      */     
/* 1251 */     } else if (ActivityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
/* 1252 */       for (ActivityConfigCO item : awards) {
/* 1253 */         if (!isReward(item.id))
/*      */         {
/* 1255 */           if (hasFirstPayReward())
/*      */           {
/* 1257 */             if (isSecondAwardValid(item.id)) {
/* 1258 */               hintNum++;
/*      */             }
/*      */           }
/*      */         }
/*      */       } 
/* 1263 */     } else if (ActivityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
/* 1264 */       for (ActivityConfigCO item : awards) {
/* 1265 */         if (!isReward(item.id)) {
/* 1266 */           int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
/*      */           
/* 1268 */           if (allPrepaidMoney >= item.parameter1)
/*      */           {
/* 1270 */             hintNum++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1274 */     } else if (ActivityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
/* 1275 */       for (ActivityConfigCO item : awards) {
/* 1276 */         if (!isReward(item.id)) {
/*      */           
/* 1278 */           int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
/*      */           
/* 1280 */           if (allConsumeMoney >= item.parameter1)
/*      */           {
/* 1282 */             hintNum++;
/*      */           }
/*      */         } 
/*      */       } 
/* 1286 */     } else if (ActivityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
/* 1287 */       for (ActivityConfigCO item : awards) {
/* 1288 */         if (getHaoliChangeState((ActivityConfigExt)item) == Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
/* 1289 */           hintNum++;
/*      */         }
/*      */       } 
/* 1292 */     } else if (ActivityTab == Const.ActivityRewardType.LUCKY_REWARD.getValue() && 
/* 1293 */       this.opts.drawedContainer.size() == 0) {
/* 1294 */       hintNum++;
/*      */     } 
/*      */     
/* 1297 */     return hintNum;
/*      */   }
/*      */   
/*      */   public void refreshLuckyAwardContainer() {
/* 1301 */     this.opts.luckyAwardContainer = new ArrayList();
/* 1302 */     Map<Integer, DrawExt> props = GameData.Draws;
/* 1303 */     for (DrawCO _prop : props.values()) {
/* 1304 */       DrawExt prop = (DrawExt)_prop;
/* 1305 */       if (prop.iD == Const.LuckyDrawType.EXCELLENT_ITEM.getValue() || prop.iD == Const.LuckyDrawType.NORMAL_ITEM.getValue() || prop.iD == Const.LuckyDrawType.BUFF_ITEM.getValue()) {
/* 1306 */         int tempTotalRate = prop.totalRate;
/* 1307 */         ArrayList<DrawExt.DrawItem> tempItems = new ArrayList<>(prop.items);
/* 1308 */         for (int i = 0; i < prop.itemNumber; i++) {
/* 1309 */           ResultRateEachAward result = rateEachAward(tempTotalRate, tempItems);
/* 1310 */           if (result != null) {
/*      */             
/* 1312 */             tempTotalRate -= result.itemRate;
/* 1313 */             tempItems.remove(result.index);
/* 1314 */             LuckyAward item = new LuckyAward();
/* 1315 */             item.itemCode = result.itemCode;
/* 1316 */             item.itemNum = result.itemNum;
/* 1317 */             item.itemRate = result.itemRate;
/* 1318 */             item.id = prop.iD;
/* 1319 */             item.round = prop.round;
/* 1320 */             this.opts.luckyAwardContainer.add(item);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 1325 */     this.opts.drawedContainer = new HashMap<>();
/* 1326 */     this.opts.buffTimes = 1;
/*      */     
/* 1328 */     calcLuckyAwardTotalRate();
/*      */   }
/*      */   
/*      */   public void calcLuckyAwardTotalRate() {
/* 1332 */     this.luckyAwardTotalRate = 0;
/* 1333 */     for (int i = 0; i < this.opts.luckyAwardContainer.size(); i++) {
/*      */       
/* 1335 */       LuckyAward luckyAward = this.opts.luckyAwardContainer.get(i);
/*      */       
/* 1337 */       if (this.opts.drawedContainer.size() + 1 >= luckyAward.round)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1342 */         this.luckyAwardTotalRate += luckyAward.itemRate;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ResultRateEachAward
/*      */   {
/*      */     public int index;
/*      */ 
/*      */ 
/*      */     
/*      */     public String itemCode;
/*      */ 
/*      */ 
/*      */     
/*      */     public int itemNum;
/*      */ 
/*      */ 
/*      */     
/*      */     public int itemRate;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultRateEachAward rateEachAward(int totalRate, ArrayList<DrawExt.DrawItem> luckyAwardContainer) {
/* 1370 */     if (totalRate <= 0) {
/* 1371 */       return null;
/*      */     }
/* 1373 */     int randRate = Utils.random(0, totalRate - 1);
/* 1374 */     int addRate = 0;
/* 1375 */     for (int i = 0; i < luckyAwardContainer.size(); i++) {
/* 1376 */       DrawExt.DrawItem luckyAward = luckyAwardContainer.get(i);
/* 1377 */       addRate += luckyAward.itemRate;
/* 1378 */       if (addRate > randRate) {
/* 1379 */         ResultRateEachAward result = new ResultRateEachAward();
/* 1380 */         result.index = i;
/* 1381 */         result.itemCode = luckyAward.itemCode;
/* 1382 */         result.itemNum = luckyAward.itemNum;
/* 1383 */         result.itemRate = luckyAward.itemRate;
/* 1384 */         return result;
/*      */       } 
/*      */     } 
/* 1387 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ArrayList<WNBag.SimpleItemInfo> getCostItem(HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> data) {
/* 1415 */     if (data.containsKey(Integer.valueOf(0))) {
/* 1416 */       return data.get(Integer.valueOf(0));
/*      */     }
/* 1418 */     return data.get(Integer.valueOf(this.player.getPro()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHaoliChangeState(ActivityConfigExt activityConfigProp) {
/* 1427 */     int key = activityConfigProp.id;
/* 1428 */     if (activityConfigProp.parameter1 != 0) {
/* 1429 */       HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
/* 1430 */       if (actInfo != null && actInfo.get(Integer.valueOf(key)) != null && (
/* 1431 */         (Integer)actInfo.get(Integer.valueOf(key))).intValue() >= activityConfigProp.parameter1) {
/* 1432 */         return Const.HAOLI_CHANGE_STATE.RECEIVED.getValue();
/*      */       }
/*      */     } 
/*      */     
/* 1436 */     int state = 0;
/* 1437 */     ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(activityConfigProp.costItems);
/* 1438 */     for (int j = 0; j < costItem.size(); j++) {
/* 1439 */       WNBag.SimpleItemInfo item = costItem.get(j);
/* 1440 */       if (item.itemCode.equals("diamond")) {
/* 1441 */         if (this.player.moneyManager.enoughDiamond(item.itemNum)) {
/* 1442 */           state++;
/*      */         }
/* 1444 */       } else if (item.itemCode.equals("cash")) {
/* 1445 */         if (this.player.moneyManager.enoughTicket(item.itemNum)) {
/* 1446 */           state++;
/*      */         }
/* 1448 */       } else if (item.itemCode.equals("gold")) {
/* 1449 */         if (this.player.moneyManager.enoughGold(item.itemNum)) {
/* 1450 */           state++;
/*      */         }
/*      */       } else {
/* 1453 */         int haveNum = this.player.bag.findItemNumByCode(item.itemCode);
/* 1454 */         if (haveNum >= item.itemNum) {
/* 1455 */           state++;
/*      */         }
/*      */       } 
/*      */     } 
/* 1459 */     if (costItem.size() == 0 || state != costItem.size()) {
/* 1460 */       return Const.HAOLI_CHANGE_STATE.CANNOT_RECEIVE.getValue();
/*      */     }
/* 1462 */     return Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue();
/*      */   }
/*      */   
/*      */   public ActivityHandler.OpenChangeResponse.Builder haoliChange() {
/* 1466 */     ActivityHandler.OpenChangeResponse.Builder changeInfo = ActivityHandler.OpenChangeResponse.newBuilder();
/* 1467 */     ArrayList<ActivityHandler.changeInfo> list_changeInfo = new ArrayList<>();
/* 1468 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
/* 1469 */     if (prop == null) {
/* 1470 */       return changeInfo;
/*      */     }
/* 1472 */     changeInfo.setS2CBeginTime(prop.openTime);
/* 1473 */     changeInfo.setS2CEndTime(prop.closeTime);
/* 1474 */     changeInfo.setS2CContent(prop.activityRule);
/* 1475 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/* 1476 */     for (int i = 0; i < awardProps.size(); i++) {
/* 1477 */       ActivityConfigExt p = awardProps.get(i);
/* 1478 */       ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(p.costItems);
/* 1479 */       ArrayList<WNBag.SimpleItemInfo> rewardItem = getRankReward(p.RankReward);
/* 1480 */       if (costItem != null && rewardItem != null) {
/* 1481 */         ActivityHandler.changeInfo.Builder changeData = ActivityHandler.changeInfo.newBuilder();
/* 1482 */         changeData.setChangeId(p.id);
/* 1483 */         ArrayList<ActivityHandler.changeItem> l_costItem = getChangeItemList(costItem);
/* 1484 */         ArrayList<ActivityHandler.changeItem> l_rewardItem = getChangeItemList(rewardItem);
/* 1485 */         changeData.addAllCostItem(l_costItem);
/* 1486 */         changeData.addAllRewardItem(l_rewardItem);
/* 1487 */         changeData.setChangeSate(getHaoliChangeState(p));
/*      */         
/* 1489 */         int changeNum = 0;
/* 1490 */         HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
/* 1491 */         if (actInfo != null && actInfo.get(Integer.valueOf(p.id)) != null) {
/* 1492 */           changeNum = ((Integer)actInfo.get(Integer.valueOf(p.id))).intValue();
/*      */         }
/* 1494 */         changeData.setChangeNum(changeNum);
/* 1495 */         if (p.parameter1 != 0) {
/* 1496 */           changeData.setChangeMax(p.parameter1);
/*      */         }
/* 1498 */         list_changeInfo.add(changeData.build());
/*      */       } 
/*      */     } 
/*      */     
/* 1502 */     changeInfo.addAllS2CChangeInfo(list_changeInfo);
/* 1503 */     return changeInfo;
/*      */   }
/*      */   
/*      */   private ArrayList<ActivityHandler.changeItem> getChangeItemList(ArrayList<WNBag.SimpleItemInfo> itemList) {
/* 1507 */     ArrayList<ActivityHandler.changeItem> l = new ArrayList<>();
/* 1508 */     for (WNBag.SimpleItemInfo info : itemList) {
/* 1509 */       ActivityHandler.changeItem.Builder ib = ActivityHandler.changeItem.newBuilder();
/* 1510 */       ib.setItemCode(info.itemCode);
/* 1511 */       ib.setItemNum(info.itemNum);
/* 1512 */       ib.setIsBind(info.forceType.getValue());
/* 1513 */       l.add(ib.build());
/*      */     } 
/* 1515 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ActivityHandler.ActivityLs> getVailyActivityLs() {
/* 1522 */     List<ActivityHandler.ActivityLs> ls = new ArrayList<>();
/* 1523 */     for (ActivityExt t : GameData.Activitys.values()) {
/* 1524 */       if (null == t) {
/*      */         continue;
/*      */       }
/*      */       
/* 1528 */       if (Const.TimeState.TIME_UP.getValue() != DateUtil.isOutDate(t.openTime, t.closeTime) || t.isOpen == 0) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1533 */       if (t.activityTab == Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue()) {
/* 1534 */         boolean continueFlag = true;
/* 1535 */         for (Iterator<Integer> iterator = this.opts.sevendayList.iterator(); iterator.hasNext(); ) { int state = ((Integer)iterator.next()).intValue();
/* 1536 */           if (state != 2) {
/* 1537 */             continueFlag = false;
/*      */             break;
/*      */           }  }
/*      */         
/* 1541 */         if (continueFlag) {
/*      */           continue;
/*      */         }
/*      */       } 
/*      */       
/* 1546 */       ActivityHandler.ActivityLs.Builder tmp = ActivityHandler.ActivityLs.newBuilder();
/* 1547 */       tmp.setId(t.activityID);
/* 1548 */       ls.add(tmp.build());
/*      */     } 
/* 1550 */     return ls;
/*      */   }
/*      */   
/*      */   public ActivityHandler.totalInfo.Builder DailyRecharge_Today() {
/* 1554 */     ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
/* 1555 */     ActivityExt prop = findActivityByType(Const.ActivityRewardType.DAILY_RECHARGE.getValue());
/* 1556 */     if (prop == null) {
/* 1557 */       data.setBeginTime("");
/* 1558 */       data.setEndTime("");
/* 1559 */       data.setDescribe("");
/* 1560 */       return data;
/*      */     } 
/* 1562 */     data.setBeginTime(prop.openTime);
/* 1563 */     data.setEndTime(prop.closeTime);
/* 1564 */     data.setDescribe(prop.activityRule);
/*      */     
/* 1566 */     List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
/* 1567 */     ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
/* 1568 */     for (ActivityConfigCO _awardProp : awardProps) {
/* 1569 */       ActivityConfigExt awardProp = (ActivityConfigExt)_awardProp;
/* 1570 */       ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
/* 1571 */       info.setAwardId(awardProp.id);
/* 1572 */       ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
/* 1573 */       info.setState(0);
/* 1574 */       ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
/* 1575 */       for (WNBag.SimpleItemInfo item : reward) {
/* 1576 */         ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
/* 1577 */         list_item.add(_item.build());
/*      */       } 
/* 1579 */       info.addAllAwardItems(list_item);
/* 1580 */       int todayPrepaidMoney = this.player.prepaidManager.getDailyCharge();
/* 1581 */       info.setCurrNum(todayPrepaidMoney);
/* 1582 */       info.setNeedNum(awardProp.parameter1);
/* 1583 */       if (this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(awardProp.id))) {
/* 1584 */         info.setState(2);
/* 1585 */       } else if (todayPrepaidMoney >= awardProp.parameter1) {
/* 1586 */         info.setState(1);
/*      */       } 
/* 1588 */       list.add(info.build());
/*      */     } 
/* 1590 */     data.addAllAwards(list);
/*      */     
/* 1592 */     this.opts.daily_recharge_have_entered = true;
/* 1593 */     updateSuperScriptList();
/* 1594 */     return data;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean DailyRecharge_GetAward(int awardId) {
/* 1599 */     List<ActivityConfigExt> activityConfigExts = findActivitieConfigsByRewardType(Const.ActivityRewardType.DAILY_RECHARGE);
/* 1600 */     ActivityConfigExt activityConfigExt = null;
/* 1601 */     for (ActivityConfigExt tempActivityConfigExt : activityConfigExts) {
/* 1602 */       if (tempActivityConfigExt.id == awardId) {
/* 1603 */         activityConfigExt = tempActivityConfigExt;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1607 */     if (activityConfigExt == null)
/* 1608 */       return false; 
/* 1609 */     if (this.player.prepaidManager.po.dailyChargeDiamond < activityConfigExt.parameter1) {
/* 1610 */       return false;
/*      */     }
/*      */     
/* 1613 */     if (this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(activityConfigExt.id))) {
/* 1614 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1618 */     RewardRecord rr = new RewardRecord();
/* 1619 */     rr.awardId = activityConfigExt.id;
/* 1620 */     rr.awardTime = new Date();
/* 1621 */     this.opts.dailyRechargeRecorder.put(Integer.valueOf(activityConfigExt.id), rr);
/*      */ 
/*      */ 
/*      */     
/* 1625 */     ArrayList<WNBag.SimpleItemInfo> simpleItemInfos = getRankReward(activityConfigExt.RankReward);
/* 1626 */     for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/* 1627 */       List<NormalItem> list_items = ItemUtil.createItemsByItemCode(simpleItemInfo.itemCode, simpleItemInfo.itemNum);
/* 1628 */       this.player.bag.addEntityItems(list_items, Const.GOODS_CHANGE_TYPE.DailyRecharge, null);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1633 */     updateSuperScriptList();
/* 1634 */     return true;
/*      */   }
/*      */   
/*      */   public int DailyRecharge_GetTodayMax() {
/* 1638 */     int max = 0;
/*      */     
/* 1640 */     List<ActivityConfigExt> activityConfigExts = findActivitieConfigsByRewardType(Const.ActivityRewardType.DAILY_RECHARGE);
/* 1641 */     for (ActivityConfigExt tempActivityConfigExt : activityConfigExts) {
/* 1642 */       if (tempActivityConfigExt.parameter1 > max) {
/* 1643 */         max = tempActivityConfigExt.parameter1;
/*      */       }
/*      */     } 
/* 1646 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ActivityFavorHandler.SuperPackageInfo.Builder SuperPackage_GetInfo() {
/* 1652 */     ActivityFavorHandler.SuperPackageInfo.Builder res = ActivityFavorHandler.SuperPackageInfo.newBuilder();
/*      */     
/* 1654 */     ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.SUPER_PACKAGE.getValue());
/*      */     
/* 1656 */     res.setBeginTime(activityExt.openTime);
/* 1657 */     res.setEndTime(activityExt.closeTime);
/* 1658 */     res.setDescribe(activityExt.activityRule);
/*      */     
/* 1660 */     for (SuperPackageCO superPackageCO : GameData.SuperPackages.values()) {
/* 1661 */       ActivityFavorHandler.SuperPackageAwardInfo.Builder spiBuilder = ActivityFavorHandler.SuperPackageAwardInfo.newBuilder();
/* 1662 */       spiBuilder.setPackageId(superPackageCO.iD);
/* 1663 */       spiBuilder.setPackageName(superPackageCO.packageName);
/* 1664 */       spiBuilder.setPackageCode(superPackageCO.packageCode);
/* 1665 */       spiBuilder.setPackageNum(superPackageCO.packageNum);
/* 1666 */       spiBuilder.setPackageIcon(superPackageCO.packageIcon);
/* 1667 */       spiBuilder.setPackageScript(superPackageCO.packageScript);
/* 1668 */       spiBuilder.setPackagePrice(superPackageCO.packagePrice);
/*      */       
/* 1670 */       boolean bought = this.opts.superPackageRecorder.containsKey(Integer.valueOf(superPackageCO.iD));
/* 1671 */       spiBuilder.setPackageState((bought == true) ? 1 : 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1685 */       res.addSuperPackageAwardInfo(spiBuilder.build());
/*      */     } 
/* 1687 */     this.opts.super_pakage_have_enterd = true;
/*      */     
/* 1689 */     updateSuperScriptList();
/* 1690 */     return res;
/*      */   }
/*      */   
/*      */   public boolean SuperPackage_GetBoughtable(int productId) {
/* 1694 */     return !this.opts.superPackageRecorder.containsKey(Integer.valueOf(productId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<AdventureItemCO> DailyDraw_Draw(int times) {
/* 1700 */     List<AdventureItemCO> res = new LinkedList<>();
/*      */ 
/*      */     
/* 1703 */     DailyDrawUpdateForgeRandomMap();
/*      */     
/* 1705 */     for (int j = 0; j < times; j++) {
/*      */       
/* 1707 */       int totalProb = 0;
/* 1708 */       List<Integer> probUpList = new LinkedList<>();
/* 1709 */       List<GroupRandomCO> groupRandomCOList = new LinkedList<>();
/* 1710 */       boolean forgeRandom = false;
/*      */       
/* 1712 */       GroupRandomCO selectedGroupRandomCO = null;
/* 1713 */       for (GroupRandomCO groupRandomCO : GameData.GroupRandoms.values()) {
/* 1714 */         if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(groupRandomCO.groupID))) {
/* 1715 */           totalProb += groupRandomCO.groupProb;
/*      */         
/*      */         }
/* 1718 */         else if (((Integer)this.opts.daily_draw_forgerandom_map.get(Integer.valueOf(groupRandomCO.groupID))).intValue() < ((ForgedRandomCO)GameData.ForgedRandoms.get(Integer.valueOf(groupRandomCO.groupID))).ramRed) {
/* 1719 */           totalProb += groupRandomCO.groupProb;
/*      */         } else {
/* 1721 */           selectedGroupRandomCO = (GroupRandomCO)GameData.GroupRandoms.get(Integer.valueOf(groupRandomCO.groupID));
/* 1722 */           forgeRandom = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/* 1727 */         totalProb += groupRandomCO.groupProb;
/* 1728 */         groupRandomCOList.add(groupRandomCO);
/* 1729 */         probUpList.add(Integer.valueOf(totalProb));
/*      */       } 
/*      */       
/* 1732 */       if (!forgeRandom) {
/* 1733 */         int k = -1;
/* 1734 */         int m = RandomUtil.getInt(0, totalProb);
/*      */         
/* 1736 */         for (int n = 0; n < probUpList.size(); n++) {
/* 1737 */           if (m <= ((Integer)probUpList.get(n)).intValue()) {
/* 1738 */             k = n;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1742 */         if (k == -1) {
/* 1743 */           Out.error(new Object[] { "随机出错" });
/*      */           break;
/*      */         } 
/* 1746 */         selectedGroupRandomCO = groupRandomCOList.get(k);
/*      */       } 
/*      */ 
/*      */       
/* 1750 */       totalProb = 0;
/* 1751 */       probUpList.clear();
/* 1752 */       int finalGroupId = selectedGroupRandomCO.groupID;
/* 1753 */       List<AdventureItemCO> adventureItemCOList = GameData.findAdventureItems(t -> (t.groupID == finalGroupId));
/* 1754 */       for (AdventureItemCO adventureItemCO : adventureItemCOList) {
/* 1755 */         if (adventureItemCO.isValid == 1) {
/* 1756 */           if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(adventureItemCO.groupID))) {
/* 1757 */             totalProb += adventureItemCO.prob;
/*      */           } else {
/* 1759 */             totalProb += ((Integer)this.opts.daily_draw_forgerandom_map.get(Integer.valueOf(adventureItemCO.groupID))).intValue();
/*      */           } 
/*      */         }
/*      */         
/* 1763 */         probUpList.add(Integer.valueOf(totalProb));
/*      */       } 
/* 1765 */       int randomProb = RandomUtil.getInt(0, totalProb);
/* 1766 */       int selectedId = -1;
/* 1767 */       for (int i = 0; i < probUpList.size(); i++) {
/* 1768 */         if (randomProb <= ((Integer)probUpList.get(i)).intValue()) {
/* 1769 */           selectedId = i;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1773 */       if (selectedId == -1) {
/* 1774 */         Out.error(new Object[] { "随机出错。" });
/*      */         break;
/*      */       } 
/* 1777 */       AdventureItemCO selectedAdventureItemCO = adventureItemCOList.get(selectedId);
/*      */ 
/*      */       
/* 1780 */       for (Integer groupId : this.opts.daily_draw_forgerandom_map.keySet()) {
/* 1781 */         ForgedRandomCO forgedRandomCO = (ForgedRandomCO)GameData.ForgedRandoms.get(groupId);
/* 1782 */         int currentProb = ((Integer)this.opts.daily_draw_forgerandom_map.get(groupId)).intValue();
/* 1783 */         if (selectedAdventureItemCO.groupID == groupId.intValue()) {
/* 1784 */           this.opts.daily_draw_forgerandom_map.put(groupId, Integer.valueOf(0)); continue;
/*      */         } 
/* 1786 */         this.opts.daily_draw_forgerandom_map.put(groupId, Integer.valueOf(currentProb + forgedRandomCO.ramAdd));
/*      */       } 
/*      */ 
/*      */       
/* 1790 */       res.add(selectedAdventureItemCO);
/*      */       
/* 1792 */       List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(selectedAdventureItemCO.item, selectedAdventureItemCO.itemNum);
/*      */       
/* 1794 */       for (NormalItem normalItem : normalItems) {
/* 1795 */         normalItem.setBind(selectedAdventureItemCO.isBind);
/*      */       }
/* 1797 */       this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ActivityDraw, "Activity_turntable");
/* 1798 */       if (selectedAdventureItemCO.isShow == 1) {
/* 1799 */         NormalItem nItem = normalItems.get(0);
/*      */         
/* 1801 */         String playerLink = ChannelUtil.setPlayerInfo(this.player);
/* 1802 */         String targetPlayerText = LangService.format("NAME_LINK", new Object[] { playerLink, this.player.getName() });
/*      */         
/* 1804 */         String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
/* 1805 */         String itemLink = ChannelUtil.setItemInfo(nItem);
/* 1806 */         itemText = itemText.replace("{a}", nItem.prop.name).replace("{b}", itemLink);
/*      */         
/* 1808 */         String numText = LangService.getValue("DEFAULT");
/* 1809 */         numText = numText.replace("{a}", "*" + normalItems.size());
/*      */         
/* 1811 */         String targetItemText = itemText + numText;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1816 */         String tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_ADVENTURE"), new Object[] { targetPlayerText, targetItemText, Const.TipsType.NORMAL });
/*      */ 
/*      */ 
/*      */         
/* 1820 */         MessageUtil.sendRollChat(this.player.getLogicServerId(), tempStr2, Const.CHAT_SCOPE.SYSTEM);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1829 */     updateSuperScriptList();
/*      */     
/* 1831 */     return res;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<AdventureItemAddCO> DailyDraw_Draw_Add(int times) {
/* 1836 */     List<AdventureItemAddCO> res = new LinkedList<>();
/*      */ 
/*      */     
/* 1839 */     DailyDrawUpdateForgeRandomMapAdd();
/*      */     
/* 1841 */     for (int j = 0; j < times; j++) {
/*      */       
/* 1843 */       int totalProb = 0;
/* 1844 */       List<Integer> probUpList = new LinkedList<>();
/* 1845 */       List<GroupRandomAddCO> groupRandomAddCOList = new LinkedList<>();
/* 1846 */       boolean forgeRandom = false;
/*      */       
/* 1848 */       GroupRandomAddCO selectedGroupRandomAddCO = null;
/* 1849 */       for (GroupRandomAddCO groupRandomAddCO : GameData.GroupRandomAdds.values()) {
/* 1850 */         if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(groupRandomAddCO.groupID))) {
/* 1851 */           totalProb += groupRandomAddCO.groupProb;
/*      */         
/*      */         }
/* 1854 */         else if (((Integer)this.opts.daily_draw_forgerandom_map_add.get(Integer.valueOf(groupRandomAddCO.groupID))).intValue() < ((ForgedRandomAddCO)GameData.ForgedRandomAdds.get(Integer.valueOf(groupRandomAddCO.groupID))).ramRed) {
/* 1855 */           totalProb += groupRandomAddCO.groupProb;
/*      */         } else {
/* 1857 */           selectedGroupRandomAddCO = (GroupRandomAddCO)GameData.GroupRandomAdds.get(Integer.valueOf(groupRandomAddCO.groupID));
/* 1858 */           forgeRandom = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/* 1863 */         totalProb += groupRandomAddCO.groupProb;
/* 1864 */         groupRandomAddCOList.add(groupRandomAddCO);
/* 1865 */         probUpList.add(Integer.valueOf(totalProb));
/*      */       } 
/*      */       
/* 1868 */       if (!forgeRandom) {
/* 1869 */         int k = -1;
/* 1870 */         int m = RandomUtil.getInt(0, totalProb);
/*      */         
/* 1872 */         for (int n = 0; n < probUpList.size(); n++) {
/* 1873 */           if (m <= ((Integer)probUpList.get(n)).intValue()) {
/* 1874 */             k = n;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1878 */         if (k == -1) {
/* 1879 */           Out.error(new Object[] { "随机出错" });
/*      */           break;
/*      */         } 
/* 1882 */         selectedGroupRandomAddCO = groupRandomAddCOList.get(k);
/*      */       } 
/*      */ 
/*      */       
/* 1886 */       totalProb = 0;
/* 1887 */       probUpList.clear();
/* 1888 */       int finalGroupId = selectedGroupRandomAddCO.groupID;
/* 1889 */       List<AdventureItemAddCO> adventureItemAddCOList = GameData.findAdventureItemAdds(t -> (t.groupID == finalGroupId));
/* 1890 */       for (AdventureItemAddCO adventureItemAddCO : adventureItemAddCOList) {
/* 1891 */         if (adventureItemAddCO.isValid == 1) {
/* 1892 */           if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(adventureItemAddCO.groupID))) {
/* 1893 */             totalProb += adventureItemAddCO.prob;
/*      */           } else {
/* 1895 */             totalProb += ((Integer)this.opts.daily_draw_forgerandom_map_add.get(Integer.valueOf(adventureItemAddCO.groupID))).intValue();
/*      */           } 
/*      */         }
/*      */         
/* 1899 */         probUpList.add(Integer.valueOf(totalProb));
/*      */       } 
/* 1901 */       int randomProb = RandomUtil.getInt(0, totalProb);
/* 1902 */       int selectedId = -1;
/* 1903 */       for (int i = 0; i < probUpList.size(); i++) {
/* 1904 */         if (randomProb <= ((Integer)probUpList.get(i)).intValue()) {
/* 1905 */           selectedId = i;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1909 */       if (selectedId == -1) {
/* 1910 */         Out.error(new Object[] { "随机出错。" });
/*      */         break;
/*      */       } 
/* 1913 */       AdventureItemAddCO selectedAdventureItemAddCO = adventureItemAddCOList.get(selectedId);
/*      */ 
/*      */       
/* 1916 */       for (Integer groupId : this.opts.daily_draw_forgerandom_map_add.keySet()) {
/* 1917 */         ForgedRandomAddCO forgedRandomAddCO = (ForgedRandomAddCO)GameData.ForgedRandomAdds.get(groupId);
/* 1918 */         int currentProb = ((Integer)this.opts.daily_draw_forgerandom_map_add.get(groupId)).intValue();
/* 1919 */         if (selectedAdventureItemAddCO.groupID == groupId.intValue()) {
/* 1920 */           this.opts.daily_draw_forgerandom_map_add.put(groupId, Integer.valueOf(0)); continue;
/*      */         } 
/* 1922 */         this.opts.daily_draw_forgerandom_map_add.put(groupId, Integer.valueOf(currentProb + forgedRandomAddCO.ramAdd));
/*      */       } 
/*      */ 
/*      */       
/* 1926 */       res.add(selectedAdventureItemAddCO);
/*      */       
/* 1928 */       List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(selectedAdventureItemAddCO.item, selectedAdventureItemAddCO.itemNum);
/*      */       
/* 1930 */       for (NormalItem normalItem : normalItems) {
/* 1931 */         normalItem.setBind(selectedAdventureItemAddCO.isBind);
/*      */       }
/* 1933 */       this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ActivityDrawSpring, "Activity_turntable");
/* 1934 */       if (selectedAdventureItemAddCO.isShow == 1) {
/* 1935 */         NormalItem nItem = normalItems.get(0);
/*      */         
/* 1937 */         String playerLink = ChannelUtil.setPlayerInfo(this.player);
/* 1938 */         String targetPlayerText = LangService.format("NAME_LINK", new Object[] { playerLink, this.player.getName() });
/*      */         
/* 1940 */         String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
/* 1941 */         String itemLink = ChannelUtil.setItemInfo(nItem);
/* 1942 */         itemText = itemText.replace("{a}", nItem.prop.name).replace("{b}", itemLink);
/*      */         
/* 1944 */         String numText = LangService.getValue("DEFAULT");
/* 1945 */         numText = numText.replace("{a}", "*" + normalItems.size());
/*      */         
/* 1947 */         String targetItemText = itemText + numText;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1952 */         String tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_ADVENTURE"), new Object[] { targetPlayerText, targetItemText, Const.TipsType.NORMAL });
/*      */ 
/*      */ 
/*      */         
/* 1956 */         MessageUtil.sendRollChat(this.player.getLogicServerId(), tempStr2, Const.CHAT_SCOPE.SYSTEM);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1965 */     updateSuperScriptList();
/*      */     
/* 1967 */     return res;
/*      */   }
/*      */   
/*      */   private void DailyDrawUpdateForgeRandomMap() {
/* 1971 */     if (GameData.ForgedRandoms.size() > 1) {
/* 1972 */       Out.error(new Object[] { "伪随机配置不能多于1条" });
/*      */     }
/*      */     
/* 1975 */     for (ForgedRandomCO forgedRandomCO : GameData.ForgedRandoms.values()) {
/* 1976 */       if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(forgedRandomCO.groupID))) {
/* 1977 */         this.opts.daily_draw_forgerandom_map.put(Integer.valueOf(forgedRandomCO.groupID), Integer.valueOf(forgedRandomCO.initial));
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1983 */     for (Integer groupId : this.opts.daily_draw_forgerandom_map.keySet()) {
/* 1984 */       if (!GameData.ForgedRandoms.containsKey(groupId)) {
/* 1985 */         this.opts.daily_draw_forgerandom_map.remove(groupId);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void DailyDrawUpdateForgeRandomMapAdd() {
/* 1993 */     if (GameData.ForgedRandomAdds.size() > 1) {
/* 1994 */       Out.error(new Object[] { "伪随机配置不能多于1条" });
/*      */     }
/*      */     
/* 1997 */     for (ForgedRandomAddCO forgedRandomAddCO : GameData.ForgedRandomAdds.values()) {
/* 1998 */       if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(forgedRandomAddCO.groupID))) {
/* 1999 */         this.opts.daily_draw_forgerandom_map_add.put(Integer.valueOf(forgedRandomAddCO.groupID), Integer.valueOf(forgedRandomAddCO.initial));
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2005 */     for (Integer groupId : this.opts.daily_draw_forgerandom_map_add.keySet()) {
/* 2006 */       if (!GameData.ForgedRandomAdds.containsKey(groupId)) {
/* 2007 */         this.opts.daily_draw_forgerandom_map_add.remove(groupId);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Date DailyDrawGetFreeTimeUpdateTime() {
/* 2014 */     Date now = new Date();
/* 2015 */     Calendar calendar = Calendar.getInstance();
/* 2016 */     calendar.setTime(now);
/* 2017 */     int h = calendar.get(11);
/* 2018 */     calendar.set(11, 5);
/* 2019 */     calendar.set(12, 0);
/* 2020 */     calendar.set(13, 0);
/* 2021 */     calendar.set(14, 0);
/* 2022 */     if (h > 5)
/* 2023 */       calendar.add(5, 1); 
/* 2024 */     return calendar.getTime();
/*      */   }
/*      */   
/*      */   public ActivityFavorHandler.SevenDayPackageGetInfoResponse getSevenDayPackageGetInfo() {
/* 2028 */     ActivityFavorHandler.SevenDayPackageGetInfoResponse.Builder result = ActivityFavorHandler.SevenDayPackageGetInfoResponse.newBuilder();
/*      */ 
/*      */     
/* 2031 */     ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue());
/* 2032 */     if (activityExt == null) {
/* 2033 */       result.setS2CCode(500);
/* 2034 */       result.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 2035 */       return result.build();
/*      */     } 
/*      */ 
/*      */     
/* 2039 */     ActivityFavorHandler.SevenDayPackageInfo.Builder info = ActivityFavorHandler.SevenDayPackageInfo.newBuilder();
/* 2040 */     info.setBeginTime(activityExt.openTime);
/* 2041 */     info.setEndTime(activityExt.closeTime);
/* 2042 */     info.setDescribe(activityExt.activityRule);
/*      */ 
/*      */     
/* 2045 */     for (int i = 0; i < this.opts.sevendayList.size(); i++) {
/* 2046 */       SevenLoginCO sevenLoginCO = (SevenLoginCO)GameData.SevenLogins.get(Integer.valueOf(i + 1));
/* 2047 */       ActivityFavorHandler.SevenDayPackageAwardInfo.Builder award = ActivityFavorHandler.SevenDayPackageAwardInfo.newBuilder();
/* 2048 */       award.setPackageId(sevenLoginCO.id);
/* 2049 */       award.setItemcode(sevenLoginCO.item1code);
/* 2050 */       award.setItemcount(sevenLoginCO.item1count);
/* 2051 */       award.setItemmodel(sevenLoginCO.item1Model);
/* 2052 */       award.setState(((Integer)this.opts.sevendayList.get(i)).intValue());
/* 2053 */       info.addSevenDayPackageAwardInfo(award);
/*      */     } 
/*      */     
/* 2056 */     result.setS2CCode(200);
/* 2057 */     result.setSevenDayPackageInfo(info);
/* 2058 */     return result.build();
/*      */   }
/*      */ 
/*      */   
/*      */   public ActivityFavorHandler.SevenDayPackageAwardResponse receiveSevenDayPackageAward(int packageId) {
/* 2063 */     ActivityFavorHandler.SevenDayPackageAwardResponse.Builder result = ActivityFavorHandler.SevenDayPackageAwardResponse.newBuilder();
/*      */ 
/*      */     
/* 2066 */     if (packageId > 7) {
/* 2067 */       result.setS2CCode(200);
/* 2068 */       return result.build();
/*      */     } 
/*      */ 
/*      */     
/* 2072 */     if (((Integer)this.opts.sevendayList.get(packageId - 1)).intValue() != 1) {
/* 2073 */       result.setS2CCode(200);
/* 2074 */       return result.build();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2086 */     this.opts.sevendayList.set(packageId - 1, Integer.valueOf(2));
/* 2087 */     Out.info(new Object[] { "领取七日登录礼包 playerId=", this.player.getId(), ",day=", Integer.valueOf(packageId) });
/*      */     
/* 2089 */     SevenLoginCO co = (SevenLoginCO)GameData.SevenLogins.get(Integer.valueOf(packageId));
/* 2090 */     this.player.getWnBag().addCodeItemMail(co.item1code, co.item1count, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ACTIVITY_SEVENDAY, "Bag_full_common");
/* 2091 */     result.setS2CCode(200);
/*      */     
/* 2093 */     updateSuperScriptList();
/* 2094 */     return result.build();
/*      */   }
/*      */ 
/*      */   
/*      */   private void refreshSevendayLogin() {
/* 2099 */     for (int i = 0; i < this.opts.sevendayList.size(); i++) {
/* 2100 */       if (((Integer)this.opts.sevendayList.get(i)).intValue() == 0) {
/* 2101 */         this.opts.sevendayList.set(i, Integer.valueOf(1));
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ActivityFavorHandler.RecoveredInfoResponse getRecoveredGetInfo() {
/* 2111 */     ActivityFavorHandler.RecoveredInfoResponse.Builder result = ActivityFavorHandler.RecoveredInfoResponse.newBuilder();
/*      */ 
/*      */     
/* 2114 */     ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
/* 2115 */     if (activityExt == null) {
/* 2116 */       result.setS2CCode(500);
/* 2117 */       result.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 2118 */       return result.build();
/*      */     } 
/*      */ 
/*      */     
/* 2122 */     ActivityFavorHandler.RecoveredInfo.Builder info = ActivityFavorHandler.RecoveredInfo.newBuilder();
/* 2123 */     info.setBeginTime(activityExt.openTime);
/* 2124 */     info.setEndTime(activityExt.closeTime);
/* 2125 */     info.setDescribe(activityExt.activityRule);
/*      */     
/* 2127 */     int recoveryDay = getRecoveryDay(activityExt.activityID);
/*      */ 
/*      */     
/* 2130 */     for (Map.Entry<Integer, Integer> e : (Iterable<Map.Entry<Integer, Integer>>)this.opts.recovery.entrySet()) {
/* 2131 */       RecoveryExt t = (RecoveryExt)GameData.Recoverys.get(e.getKey());
/* 2132 */       if (t != null) {
/* 2133 */         int count = ((Integer)e.getValue()).intValue();
/* 2134 */         ActivityFavorHandler.RecoveredSourceInfo.Builder rsi = ActivityFavorHandler.RecoveredSourceInfo.newBuilder();
/* 2135 */         rsi.setId(t.iD);
/* 2136 */         rsi.setSourceName(t.name);
/* 2137 */         rsi.setMinDate(count);
/* 2138 */         rsi.setMaxDate(getRecoveryMaxCount(t.type) * recoveryDay);
/* 2139 */         rsi.setState((count > 0) ? 0 : 1);
/* 2140 */         rsi.setNeedDiamond(t.cost * count);
/*      */         
/* 2142 */         int recoverCount = (count > 0) ? count : ((Integer)this.opts.recoveryHistory.getOrDefault(e.getKey(), Integer.valueOf(0))).intValue();
/* 2143 */         buildRecoveredItem(rsi, t.item1code, t.num1 * recoverCount);
/* 2144 */         buildRecoveredItem(rsi, t.item2code, t.num2 * recoverCount);
/* 2145 */         buildRecoveredItem(rsi, t.item3code, t.num3 * recoverCount);
/* 2146 */         buildRecoveredItem(rsi, t.item4code, t.num4 * recoverCount);
/*      */         
/* 2148 */         info.addRecoveredSourceInfo(rsi.build());
/*      */       } 
/*      */     } 
/* 2151 */     result.setRecoveredInfo(info.build());
/* 2152 */     result.setS2CCode(200);
/* 2153 */     return result.build();
/*      */   }
/*      */   
/*      */   private void buildRecoveredItem(ActivityFavorHandler.RecoveredSourceInfo.Builder rsi, String itemcode, int num) {
/* 2157 */     if (StringUtils.isNotEmpty(itemcode)) {
/* 2158 */       ActivityFavorHandler.RecoveredItem.Builder item = ActivityFavorHandler.RecoveredItem.newBuilder();
/* 2159 */       item.setCode(itemcode);
/* 2160 */       item.setNum(num);
/* 2161 */       rsi.addRecoveredItems(item);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ActivityFavorHandler.RecoveredResponse recoveredRequest(int id, int type) {
/* 2169 */     ActivityFavorHandler.RecoveredResponse.Builder result = ActivityFavorHandler.RecoveredResponse.newBuilder();
/* 2170 */     if (!this.opts.recovery.containsKey(Integer.valueOf(id))) {
/* 2171 */       result.setS2CCode(500);
/* 2172 */       return result.build();
/*      */     } 
/*      */ 
/*      */     
/* 2176 */     int count = ((Integer)this.opts.recovery.get(Integer.valueOf(id))).intValue();
/* 2177 */     if (count <= 0) {
/* 2178 */       result.setS2CCode(500);
/* 2179 */       return result.build();
/*      */     } 
/*      */     
/* 2182 */     RecoveryExt template = GameData.findRecoverys(v -> (v.iD == id)).get(0);
/* 2183 */     int totalCost = count * template.cost;
/*      */     
/* 2185 */     if (type == 1 && 
/* 2186 */       !this.player.moneyManager.enoughTicketAndDiamond(totalCost)) {
/* 2187 */       result.setS2CCode(500);
/* 2188 */       result.setS2CMsg(LangService.getValue("TICKET_NOT_ENOUGH"));
/* 2189 */       return result.build();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2194 */     ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
/* 2195 */     if (activityExt == null) {
/* 2196 */       result.setS2CCode(500);
/* 2197 */       return result.build();
/*      */     } 
/*      */     
/* 2200 */     float ratio = 0.5F;
/* 2201 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
/* 2202 */     for (ActivityConfigExt t : props) {
/* 2203 */       if (type == 0 && "Activity_Recovery_FreeRatio".equals(t.notes1)) {
/* 2204 */         ratio = t.parameter1 / 100.0F; break;
/*      */       } 
/* 2206 */       if (type == 1 && "Activity_Recovery_PerfectRatio".equals(t.notes1)) {
/* 2207 */         ratio = t.parameter1 / 100.0F;
/*      */         break;
/*      */       } 
/*      */     } 
/* 2211 */     List<WNBag.SimpleItemInfo> items = new ArrayList<>(4);
/* 2212 */     for (int i = 1; i <= 4; i++) {
/* 2213 */       String codeKey = "item" + i + "code";
/* 2214 */       String countKey = "num" + i;
/*      */       try {
/* 2216 */         String itemCode = ClassUtil.getProperty(template, codeKey).toString();
/* 2217 */         if (StringUtils.isNotEmpty(itemCode)) {
/* 2218 */           WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 2219 */           item.itemCode = itemCode;
/* 2220 */           item.itemNum = (int)Math.ceil(((((Integer)ClassUtil.getProperty(template, countKey)).intValue() * count) * ratio));
/* 2221 */           items.add(item);
/*      */         } 
/* 2223 */       } catch (Exception e) {
/* 2224 */         Out.error(new Object[] { e });
/*      */       } 
/*      */     } 
/*      */     
/* 2228 */     if (!this.player.getWnBag().testAddCodeItems(items)) {
/* 2229 */       result.setS2CCode(500);
/* 2230 */       result.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 2231 */       return result.build();
/*      */     } 
/*      */     
/* 2234 */     Out.info(new Object[] { "资源找回，roleId=", this.player.getId(), ",id=", Integer.valueOf(id), ",type=", Integer.valueOf(type), ",count=", Integer.valueOf(count) });
/*      */     
/* 2236 */     if (type == 1) {
/* 2237 */       this.player.moneyManager.costTicketAndDiamond(totalCost, Const.GOODS_CHANGE_TYPE.recovered);
/*      */     }
/* 2239 */     this.opts.recovery.put(Integer.valueOf(id), Integer.valueOf(0));
/*      */     
/* 2241 */     this.player.getWnBag().addCodeItems(items, Const.GOODS_CHANGE_TYPE.recovered);
/*      */     
/* 2243 */     updateSuperScriptList();
/* 2244 */     result.setS2CCode(200);
/* 2245 */     return result.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void refreshRecovered() {
/* 2253 */     ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
/* 2254 */     if (activityExt == null) {
/*      */       return;
/*      */     }
/* 2257 */     HashMap<Integer, Integer> stub = new HashMap<>(this.opts.recovery);
/* 2258 */     this.opts.recovery.clear();
/* 2259 */     this.opts.recoveryHistory.clear();
/*      */     
/* 2261 */     int recoveryDay = getRecoveryDay(activityExt.activityID);
/* 2262 */     int day = Math.max(Math.min(recoveryDay - 1, daysOfTwo(this.opts.refreshTime, new Date()) - 1), 0);
/* 2263 */     int level = (this.player.getPlayer()).level;
/* 2264 */     List<RecoveryExt> templates = GameData.findRecoverys(v -> (v.minLevel <= level && level <= v.maxLevel));
/* 2265 */     for (RecoveryExt t : templates) {
/* 2266 */       int progress; int max; switch (t.type) {
/*      */         
/*      */         case 1:
/* 2269 */           if (this.player.demonTowerManager.getSweepCountLeft() > 0) {
/* 2270 */             int i = 0;
/* 2271 */             int j = getRecoveryMaxCount(t.type);
/* 2272 */             refreshRecovery(Integer.valueOf(t.iD), day, j, i, stub, recoveryDay);
/*      */           } 
/*      */ 
/*      */ 
/*      */         
/*      */         case 2:
/* 2278 */           progress = (this.player.dailyActivityMgr.getTaskInfo(3)).process;
/* 2279 */           max = getRecoveryMaxCount(t.type);
/* 2280 */           refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
/*      */ 
/*      */ 
/*      */         
/*      */         case 3:
/* 2285 */           progress = (this.player.dailyActivityMgr.getTaskInfo(4)).process;
/* 2286 */           max = getRecoveryMaxCount(t.type);
/* 2287 */           refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
/*      */ 
/*      */ 
/*      */         
/*      */         case 4:
/* 2292 */           progress = (this.player.dailyActivityMgr.getTaskInfo(11)).process;
/* 2293 */           max = getRecoveryMaxCount(t.type);
/* 2294 */           refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
/*      */ 
/*      */ 
/*      */         
/*      */         case 5:
/* 2299 */           progress = (this.player.dailyActivityMgr.getTaskInfo(10)).process;
/* 2300 */           max = getRecoveryMaxCount(t.type);
/* 2301 */           refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
/*      */ 
/*      */ 
/*      */         
/*      */         case 6:
/* 2306 */           progress = (this.player.dailyActivityMgr.getTaskInfo(12)).process;
/* 2307 */           max = getRecoveryMaxCount(t.type);
/* 2308 */           refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getRecoveryMaxCount(int type) {
/* 2321 */     switch (type) {
/*      */       case 1:
/* 2323 */         return 1;
/*      */       case 2:
/* 2325 */         return (DailyActivityMgr.getConfig(3)).maxCount;
/*      */       case 3:
/* 2327 */         return (DailyActivityMgr.getConfig(4)).maxCount;
/*      */       case 4:
/* 2329 */         return (DailyActivityMgr.getConfig(11)).maxCount;
/*      */       case 5:
/* 2331 */         return (DailyActivityMgr.getConfig(10)).maxCount;
/*      */       case 6:
/* 2333 */         return (DailyActivityMgr.getConfig(12)).maxCount;
/*      */     } 
/* 2335 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getRecoveryDay(int activityID) {
/* 2343 */     List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activityID && "Activity_Recovery_Days".equals(t.notes1)));
/* 2344 */     if (props.isEmpty()) {
/* 2345 */       Out.error(new Object[] { "未配置资源找回功能所需要的可找回天数参数." });
/* 2346 */       return 1;
/*      */     } 
/* 2348 */     return ((ActivityConfigExt)props.get(0)).parameter1;
/*      */   }
/*      */   
/*      */   private void refreshRecovery(Integer type, int day, int maxCount, int progress, HashMap<Integer, Integer> stub, int recoveryDay) {
/* 2352 */     int count = maxCount - progress + day * maxCount;
/* 2353 */     if (day == 0) {
/* 2354 */       count += ((Integer)stub.getOrDefault(type, Integer.valueOf(0))).intValue();
/* 2355 */       count = Math.min(recoveryDay * maxCount, count);
/*      */     } 
/* 2357 */     if (count > 0) {
/* 2358 */       this.opts.recovery.put(type, Integer.valueOf(count));
/* 2359 */       this.opts.recoveryHistory.put(type, Integer.valueOf(count));
/*      */     } 
/*      */   }
/*      */   
/*      */   public static int daysOfTwo(Date fDate, Date oDate) {
/* 2364 */     Calendar aCalendar = Calendar.getInstance();
/* 2365 */     aCalendar.setTime(fDate);
/* 2366 */     int day1 = aCalendar.get(6);
/* 2367 */     aCalendar.setTime(oDate);
/* 2368 */     int day2 = aCalendar.get(6);
/* 2369 */     return day2 - day1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasRecoveryCount() {
/* 2376 */     for (Map.Entry<Integer, Integer> e : (Iterable<Map.Entry<Integer, Integer>>)this.opts.recovery.entrySet()) {
/* 2377 */       if (((Integer)e.getValue()).intValue() > 0) {
/* 2378 */         return true;
/*      */       }
/*      */     } 
/* 2381 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void gmRecovered(int day) {
/* 2388 */     Date old = this.opts.refreshTime;
/* 2389 */     this.opts.refreshTime = DateUtils.addDays(old, -day);
/* 2390 */     refreshRecovered();
/* 2391 */     this.opts.refreshTime = old;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void triggerLimitTimeGift(int condition) {
/* 2398 */     this.cachedLimitTimeGiftStack.push(Integer.valueOf(condition));
/*      */     
/* 2400 */     CheckLimitTimeGiftList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void CheckLimitTimeGiftList() {
/* 2408 */     if (this.player.area.getSceneType() != Const.SCENE_TYPE.NORMAL.getValue()) {
/*      */       return;
/*      */     }
/*      */     
/* 2412 */     boolean needPush = false;
/* 2413 */     while (this.cachedLimitTimeGiftStack.size() > 0) {
/* 2414 */       int condition = ((Integer)this.cachedLimitTimeGiftStack.pop()).intValue();
/* 2415 */       List<LimitTimeGiftCO> limitTimeGiftCOs = GameData.findLimitTimeGifts(t -> 
/* 2416 */           (t.condition == condition && t.minLevel <= this.player.getLevel() && t.maxLevel >= this.player.getLevel()));
/*      */       
/* 2418 */       if (limitTimeGiftCOs.size() != 1) {
/*      */         continue;
/*      */       }
/* 2421 */       LimitTimeGiftCO limitTimeGiftCO = limitTimeGiftCOs.get(0);
/*      */ 
/*      */       
/* 2424 */       if (limitTimeGiftCO.onlyPushOne == 1 && ((Integer)this.opts.timeLimitGiftPushMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2441 */       if (((Integer)this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 2446 */       if (RandomUtil.getInt(0, 100) > limitTimeGiftCO.pushPro) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2459 */       needPush = true;
/* 2460 */       boolean lastOver = false;
/* 2461 */       Date lastTime = (Date)this.opts.timeLimitGiftTriggeredTimeMap.get(Integer.valueOf(limitTimeGiftCO.condition));
/* 2462 */       if (lastTime != null) {
/* 2463 */         long offset = lastTime.getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
/* 2464 */         if (offset > 0L) {
/* 2465 */           lastOver = true;
/*      */         }
/*      */       } 
/* 2468 */       Out.info(new Object[] { "推送限时礼包，id：", Integer.valueOf(limitTimeGiftCO.id), "  是否覆盖上次推送：", Boolean.valueOf(lastOver) });
/*      */       
/* 2470 */       this.opts.timeLimitGiftTriggeredTimeMap.put(Integer.valueOf(limitTimeGiftCO.condition), new Date());
/* 2471 */       this.opts.timeLimitGiftTriggeredIdMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(limitTimeGiftCO.id));
/* 2472 */       int currentPushTime = ((Integer)this.opts.timeLimitGiftPushMap.get(Integer.valueOf(limitTimeGiftCO.condition))).intValue();
/* 2473 */       this.opts.timeLimitGiftPushMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(currentPushTime + 1));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2478 */     checkAndPushLimitTimeSuperScript();
/*      */     
/* 2480 */     if (!needPush) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2485 */     ActivityFavorHandler.LimitTimeGiftInfoPush.Builder builder = ActivityFavorHandler.LimitTimeGiftInfoPush.newBuilder();
/* 2486 */     builder.setS2CCode(200);
/* 2487 */     builder.addAllLimitTimeGiftInfo(getLimitTimeGiftInfos());
/* 2488 */     this.player.receive("area.activityFavorPush.limitTimeGiftInfoPush", (GeneratedMessage)builder.build());
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkAndPushLimitTimeSuperScript() {
/* 2493 */     List<PlayerHandler.SuperScriptType> superScriptTypes = getLimitTimeSuperScript();
/*      */     
/* 2495 */     if (superScriptTypes.size() != 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2500 */     this.player.updateSuperScriptList(superScriptTypes);
/*      */     
/* 2502 */     PlayerHandler.SuperScriptType superScriptType = superScriptTypes.get(0);
/*      */     
/* 2504 */     if (superScriptType.getNumber() == 0) {
/*      */       return;
/*      */     }
/* 2507 */     long delay = 1000L * superScriptType.getNumber() + 500L;
/*      */     
/* 2509 */     JobFactory.addDelayJob(() -> checkAndPushLimitTimeSuperScript(), delay);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ActivityFavorHandler.LimitTimeGiftInfo> getLimitTimeGiftInfos() {
/* 2515 */     List<ActivityFavorHandler.LimitTimeGiftInfo> limitTimeGiftInfos = new LinkedList<>();
/* 2516 */     for (Iterator<Map.Entry<Integer, Date>> iterator = this.opts.timeLimitGiftTriggeredTimeMap.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry<Integer, Date> entry = iterator.next();
/*      */       
/* 2518 */       List<LimitTimeGiftCO> limitTimeGiftCOs = GameData.findLimitTimeGifts(t -> 
/* 2519 */           (t.condition == ((Integer)entry.getKey()).intValue() && t.minLevel <= this.player.getLevel() && t.maxLevel >= this.player.getLevel()));
/*      */       
/* 2521 */       if (limitTimeGiftCOs.size() != 1) {
/*      */         continue;
/*      */       }
/* 2524 */       LimitTimeGiftCO limitTimeGiftCO = limitTimeGiftCOs.get(0);
/*      */       
/* 2526 */       if (entry.getValue() == null) {
/*      */         continue;
/*      */       }
/*      */       
/* 2530 */       if (((Integer)this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
/*      */         continue;
/*      */       }
/*      */       
/* 2534 */       long offset = ((Date)entry.getValue()).getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
/* 2535 */       if (offset <= 0L) {
/*      */         continue;
/*      */       }
/* 2538 */       ActivityFavorHandler.LimitTimeGiftInfo.Builder builder = ActivityFavorHandler.LimitTimeGiftInfo.newBuilder();
/* 2539 */       builder.setId(limitTimeGiftCO.id);
/* 2540 */       builder.setSecondRemain((int)(offset / 1000L) + 1);
/* 2541 */       limitTimeGiftInfos.add(builder.build()); }
/*      */     
/* 2543 */     return limitTimeGiftInfos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int BugLimitTimeGift(int id) {
/* 2551 */     LimitTimeGiftCO limitTimeGiftCO = (LimitTimeGiftCO)GameData.LimitTimeGifts.get(Integer.valueOf(id));
/*      */ 
/*      */     
/* 2554 */     if (!this.opts.timeLimitGiftBuyMap.containsKey(Integer.valueOf(limitTimeGiftCO.id))) {
/* 2555 */       return 1;
/*      */     }
/*      */ 
/*      */     
/* 2559 */     int buyCount = ((Integer)this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue();
/*      */     
/* 2561 */     if (buyCount > 0) {
/* 2562 */       return 2;
/*      */     }
/*      */ 
/*      */     
/* 2566 */     if (this.player.moneyManager.getDiamond() < limitTimeGiftCO.price) {
/* 2567 */       return 3;
/*      */     }
/*      */     
/* 2570 */     this.opts.timeLimitGiftBuyMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(buyCount + 1));
/*      */     
/* 2572 */     this.player.moneyManager.costDiamond(limitTimeGiftCO.price, Const.GOODS_CHANGE_TYPE.LimitTimeGift);
/*      */     
/* 2574 */     String[] strs1 = limitTimeGiftCO.rewardItem.split(";");
/* 2575 */     for (String strs1_item : strs1) {
/* 2576 */       String[] strs2 = strs1_item.split(":");
/* 2577 */       List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(strs2[0], Integer.parseInt(strs2[1]));
/*      */       
/* 2579 */       for (NormalItem normalItem : normalItems) {
/* 2580 */         normalItem.setBind(1);
/*      */       }
/* 2582 */       this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.LimitTimeGift, "Bag_full_common");
/*      */     } 
/*      */ 
/*      */     
/* 2586 */     checkAndPushLimitTimeSuperScript();
/*      */     
/* 2588 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerEvent(Const.PlayerEventType eventType) {
/* 2594 */     switch (eventType) {
/*      */       case UPGRADE:
/* 2596 */         triggerLimitTimeGift(3);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Const.ManagerType getManagerType() {
/* 2606 */     return Const.ManagerType.ACTIVITY;
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\ActivityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */