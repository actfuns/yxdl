/*      */ package com.wanniu.game.guild;
/*      */ 
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.area.Area;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.HackerException;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.data.BlessItemCO;
/*      */ import com.wanniu.game.data.BlessLevelCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.GuildContributeCO;
/*      */ import com.wanniu.game.data.GuildLevelCO;
/*      */ import com.wanniu.game.data.GuildPositionCO;
/*      */ import com.wanniu.game.data.WareHouseValueCO;
/*      */ import com.wanniu.game.data.ext.BlessLevelExt;
/*      */ import com.wanniu.game.data.ext.GuildSettingExt;
/*      */ import com.wanniu.game.guild.dao.FindPlayerGuildDao;
/*      */ import com.wanniu.game.guild.dao.GuildDao;
/*      */ import com.wanniu.game.guild.guidDepot.GuildCond;
/*      */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*      */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*      */ import com.wanniu.game.guild.guildBless.GuildBless;
/*      */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
/*      */ import com.wanniu.game.guild.guildShop.GuildShopManager;
/*      */ import com.wanniu.game.guild.guildTech.GuildTechManager;
/*      */ import com.wanniu.game.guild.po.GuildBlessPO;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.VirtualItemType;
/*      */ import com.wanniu.game.item.po.PlayerItemPO;
/*      */ import com.wanniu.game.player.AttributeUtil;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.player.bi.LogReportService;
/*      */ import com.wanniu.game.player.po.MiscData;
/*      */ import com.wanniu.game.poes.GuildApplyPO;
/*      */ import com.wanniu.game.poes.GuildMemberPO;
/*      */ import com.wanniu.game.poes.GuildPO;
/*      */ import com.wanniu.game.poes.PlayerGuildPO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.util.BlackWordUtil;
/*      */ import com.wanniu.redis.GameDao;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import io.netty.util.internal.StringUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Comparator;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import java.util.function.Predicate;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import pomelo.area.GuildBlessHandler;
/*      */ import pomelo.area.GuildDepotHandler;
/*      */ import pomelo.area.GuildHandler;
/*      */ import pomelo.area.GuildShopHandler;
/*      */ import pomelo.area.GuildTechHandler;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GuildManager
/*      */ {
/*      */   public GuildPO guild;
/*      */   public GuildMemberPO member;
/*      */   public PlayerGuildPO guildData;
/*      */   public GuildShopManager guildShopManager;
/*      */   public GuildTechManager guildTechManager;
/*      */   public int throwAwardState;
/*      */   private WNPlayer player;
/*  122 */   public ScheduledFuture<?> timer = null;
/*      */   
/*      */   public GuildManager(WNPlayer player, PlayerGuildPO guildData) {
/*  125 */     this.player = player;
/*  126 */     if (null == guildData) {
/*  127 */       this.guildData = new PlayerGuildPO();
/*  128 */       this.guildData.refreshTime = new Date();
/*  129 */       PlayerPOManager.put(ConstsTR.playerGuildTR, player.getId(), (GEntity)this.guildData);
/*      */     } else {
/*  131 */       this.guildData = guildData;
/*      */     } 
/*      */     
/*  134 */     init();
/*      */   }
/*      */   
/*      */   public void cancelTimer() {
/*  138 */     if (null != this.timer) {
/*  139 */       this.timer.cancel(true);
/*  140 */       this.timer = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void clearBuffTime() {
/*  145 */     this.guildData.buffTime = 0;
/*  146 */     clearBlessBuff();
/*  147 */     changeBlessBuff();
/*  148 */     cancelTimer();
/*      */   }
/*      */   
/*      */   public void startTimer() {
/*  152 */     cancelTimer();
/*  153 */     if (this.guildData.buffTime > 0) {
/*  154 */       this.timer = JobFactory.addScheduleJob(new Runnable()
/*      */           {
/*      */             public void run() {
/*  157 */               GuildManager.this.guildData.buffTime--;
/*  158 */               if (GuildManager.this.guildData.buffTime <= 0) {
/*  159 */                 GuildManager.this.clearBuffTime();
/*      */               }
/*      */             }
/*  162 */           },  1L, Const.Time.Second.getValue());
/*      */     } else {
/*  164 */       clearBuffTime();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateBuffTime() {
/*  171 */     Date nowTime = new Date();
/*  172 */     Date logoutTime = (this.player.getPlayer()).logoutTime;
/*  173 */     long leaveTime = nowTime.getTime() - logoutTime.getTime();
/*  174 */     this.guildData.buffTime = (int)(this.guildData.buffTime - leaveTime * 0.001D);
/*      */   }
/*      */   
/*      */   public void init() {
/*  178 */     this.guildShopManager = new GuildShopManager(this.player);
/*  179 */     this.guildTechManager = new GuildTechManager(this.player);
/*  180 */     syncGuildInfo(false);
/*      */   }
/*      */   
/*      */   public void updateGuildTimer() {
/*  184 */     startTimer();
/*  185 */     updateBuffTime();
/*      */   }
/*      */   
/*      */   public void syncGuildInfo(boolean isNotifyBattleServer) {
/*  189 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  190 */     if (myInfo != null) {
/*  191 */       GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/*  192 */       if (null != myGuild) {
/*  193 */         this.member = myInfo;
/*  194 */         this.guild = myGuild;
/*  195 */         if (isNotifyBattleServer) {
/*  196 */           this.player.refreshBattlerServerBasic();
/*      */         }
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLogin() {
/*  205 */     updateGuildTimer();
/*  206 */     playerOnlineRefreshGuildData();
/*  207 */     refreshGuildInfo(false);
/*  208 */     if (StringUtil.isNullOrEmpty(getGuildId())) {
/*  209 */       this.player.pkRuleManager.onExitGuild();
/*      */     } else {
/*      */       
/*  212 */       this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
/*      */     } 
/*      */     
/*  215 */     pushRedPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bagAddItems(List<NormalItem> items) {
/*  224 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
/*      */       return;
/*      */     }
/*      */     
/*  228 */     boolean _isNeedPush = true;
/*  229 */     for (int i = 0; i < items.size(); i++) {
/*  230 */       final String _code = ((NormalItem)items.get(i)).itemDb.code;
/*  231 */       List<GuildContributeCO> ls = GameData.findGuildContributes(new Predicate<GuildContributeCO>()
/*      */           {
/*      */             public boolean test(GuildContributeCO co) {
/*  234 */               return (co.costItem == _code);
/*      */             }
/*      */           });
/*      */       
/*  238 */       if (ls.size() > 0) {
/*  239 */         _isNeedPush = false;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  244 */     if (_isNeedPush) {
/*  245 */       pushRedPoint();
/*      */     }
/*      */   }
/*      */   
/*      */   public void bagDelItem(final String code) {
/*  250 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
/*      */       return;
/*      */     }
/*      */     
/*  254 */     List<GuildContributeCO> ls = GameData.findGuildContributes(new Predicate<GuildContributeCO>()
/*      */         {
/*      */           public boolean test(GuildContributeCO co) {
/*  257 */             return (co.costItem == code);
/*      */           }
/*      */         });
/*      */     
/*  261 */     if (ls.size() > 0) {
/*  262 */       pushRedPoint();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCanRecBlessGift() {
/*  272 */     boolean canPush = false;
/*  273 */     for (int i = 0; i < this.guildData.blessRecState.length; i++) {
/*  274 */       if (this.guildData.blessRecState[i] == Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue()) {
/*  275 */         canPush = true;
/*      */         break;
/*      */       } 
/*      */     } 
/*  279 */     return canPush;
/*      */   }
/*      */   
/*      */   public void pushRedPoint() {
/*  283 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue()) || !isInGuild()) {
/*      */       return;
/*      */     }
/*      */     
/*  287 */     boolean isPushRedPoint = false;
/*  288 */     if (checkIsCanContribute() || isCanRecBlessGift() || this.player.guildBossManager.needUpdateRedPoint() || this.player.auctionManager.canGuildPush() || this.player.auctionManager.needUpdateRedPoint() || this.player.guildFortManager.needUpdateRedPoint()) {
/*  289 */       isPushRedPoint = true;
/*      */     }
/*      */     
/*  292 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*  293 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  294 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILD.getValue());
/*  295 */     if (isPushRedPoint) {
/*  296 */       data.setNumber(1);
/*      */     } else {
/*  298 */       data.setNumber(0);
/*      */     } 
/*      */     
/*  301 */     list.add(data.build());
/*  302 */     this.player.updateSuperScriptList(list);
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLogout() {
/*  307 */     update();
/*  308 */     cancelTimer();
/*      */   }
/*      */   
/*      */   public JSONObject toJson4MoneyPayLoad() {
/*  312 */     JSONObject data = new JSONObject();
/*  313 */     data.put("depositCount", Integer.valueOf(this.guildData.depositCount));
/*  314 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  315 */     data.put("depositCountMax", Integer.valueOf(settingProp.warehousePutIn));
/*  316 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshNewDay() {
/*  324 */     this.guildData.contributeTimesMap.clear();
/*      */     
/*  326 */     this.guildData.depositCount = 0;
/*      */     
/*  328 */     this.guildData.blessCount = 0;
/*      */     
/*  330 */     for (int i = 0; i < this.guildData.blessRecState.length; i++) {
/*  331 */       this.guildData.blessRecState[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
/*      */     }
/*      */     
/*  334 */     this.guildData.buffIds.clear();
/*      */     
/*  336 */     this.guildShopManager.refreshNewDay(true);
/*      */     
/*  338 */     this.guildTechManager.refreshNewDay(true);
/*      */     
/*  340 */     this.guildData.refreshTime = new Date();
/*      */     
/*  342 */     pushRedPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearBlessBuff() {
/*  349 */     this.guildData.buffIds.clear();
/*  350 */     this.guildData.buffTime = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void changeBlessBuff() {
/*  358 */     this.player.onGuildBlessChange();
/*      */   }
/*      */   
/*      */   public Map<String, Integer> calAllInfluence() {
/*  362 */     Map<String, Integer> buffAttrs = new HashMap<>();
/*  363 */     if (isInGuild()) {
/*  364 */       buffAttrs = GuildUtil.getBlessBuffAttrs(this.guildData.buffIds);
/*      */     }
/*  366 */     return buffAttrs;
/*      */   }
/*      */   
/*      */   public void pushAndRefreshGuildEffect() {
/*  370 */     this.player.updatePlayerGuildTechAttrs();
/*      */   }
/*      */ 
/*      */   
/*      */   public void resetGuildInfo(boolean isNotifyBattleServer) {
/*  375 */     this.guild = null;
/*  376 */     this.member = null;
/*  377 */     if (isNotifyBattleServer) {
/*  378 */       clearBlessBuff();
/*  379 */       changeBlessBuff();
/*  380 */       this.player.refreshBattlerServerBasic();
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getGuildName() {
/*  385 */     return (this.guild != null) ? this.guild.name : "";
/*      */   }
/*      */   
/*      */   public void refreshGuildInfo(boolean isNotifyBattleServer) {
/*  389 */     GuildUtil.refreshGuildJobPush(this.player);
/*  390 */     syncGuildInfo(isNotifyBattleServer);
/*      */   }
/*      */   
/*      */   public GuildPO getGuildInfo() {
/*  394 */     return (this.guild == null) ? new GuildPO() : this.guild;
/*      */   }
/*      */   
/*      */   public boolean isInGuild() {
/*  398 */     return (this.guild != null);
/*      */   }
/*      */   
/*      */   public int getContributeTimes(int type) {
/*  402 */     if (this.guildData.contributeTimesMap.containsKey(Integer.valueOf(type))) {
/*  403 */       return ((Integer)this.guildData.contributeTimesMap.get(Integer.valueOf(type))).intValue();
/*      */     }
/*  405 */     return 0;
/*      */   }
/*      */   
/*      */   public int getJob() {
/*  409 */     return (this.member != null) ? this.member.job : 0;
/*      */   }
/*      */   
/*      */   public String getJobName() {
/*  413 */     String jobName = (String)(getGuildInfo()).officeNames.get(Integer.valueOf(getJob()));
/*  414 */     return (jobName == null) ? "" : jobName;
/*      */   }
/*      */   
/*      */   public boolean isPresident() {
/*  418 */     return (Const.GuildJob.PRESIDENT.getValue() == getJob());
/*      */   }
/*      */   
/*      */   public boolean isVicePresident() {
/*  422 */     return (Const.GuildJob.VICE_PRESIDENT.getValue() == getJob());
/*      */   }
/*      */   
/*      */   public void addContributeTimes(int type, int times) {
/*  426 */     if (this.guildData.contributeTimesMap.containsKey(Integer.valueOf(type))) {
/*  427 */       int count = ((Integer)this.guildData.contributeTimesMap.get(Integer.valueOf(type))).intValue();
/*  428 */       count += times;
/*  429 */       this.guildData.contributeTimesMap.put(Integer.valueOf(type), Integer.valueOf(count));
/*      */     } else {
/*  431 */       this.guildData.contributeTimesMap.put(Integer.valueOf(type), Integer.valueOf(times));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalContribution(String guildId) {
/*  442 */     if (this.guildData.totalContributionMap.containsKey(guildId)) {
/*  443 */       return ((Integer)this.guildData.totalContributionMap.get(guildId)).intValue();
/*      */     }
/*  445 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTotalContribution(String guildId, int value) {
/*  455 */     if (this.guildData.totalContributionMap.containsKey(guildId)) {
/*  456 */       int con = ((Integer)this.guildData.totalContributionMap.get(guildId)).intValue();
/*  457 */       con += value;
/*  458 */       this.guildData.totalContributionMap.put(guildId, Integer.valueOf(con));
/*      */     } else {
/*  460 */       this.guildData.totalContributionMap.put(guildId, Integer.valueOf(value));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addContribution(int num, Const.GOODS_CHANGE_TYPE origin) {
/*  471 */     if (num == 0) {
/*      */       return;
/*      */     }
/*  474 */     if (num < 0) {
/*  475 */       throw new HackerException("增加公会贡献时参数小于0.");
/*      */     }
/*  477 */     int before = this.guildData.contribution;
/*      */     
/*  479 */     if (0L + this.guildData.contribution + num > 2147483647L) {
/*  480 */       this.guildData.contribution = Integer.MAX_VALUE;
/*      */     } else {
/*  482 */       this.guildData.contribution += num;
/*      */     } 
/*  484 */     int after = this.guildData.contribution;
/*  485 */     Out.info(new Object[] { "add contribution. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/*  486 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GUILDPOINT, before, 1, num, after, origin.value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getContribution() {
/*  493 */     return this.guildData.contribution;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean enoughContribution(int num) {
/*  503 */     if (num < 0) {
/*  504 */       throw new HackerException("判定玩家身上的公会贡献是否足够时参数小于0.");
/*      */     }
/*  506 */     return (getContribution() >= num);
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
/*      */   public boolean costContribution(int num, Const.GOODS_CHANGE_TYPE origin) {
/*  518 */     if (num == 0) {
/*  519 */       return true;
/*      */     }
/*  521 */     if (!enoughContribution(num)) {
/*  522 */       return false;
/*      */     }
/*      */     
/*  525 */     int before = this.guildData.contribution;
/*  526 */     this.guildData.contribution -= num;
/*  527 */     int after = this.guildData.contribution;
/*  528 */     Out.info(new Object[] { "cost contribution. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) });
/*  529 */     LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GUILDPOINT, before, 2, num, after, origin.value);
/*      */ 
/*      */     
/*  532 */     return true;
/*      */   }
/*      */   
/*      */   public GuildResult createGuild(JSONObject params) {
/*  536 */     GuildResult ret = new GuildResult();
/*  537 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  538 */     if (null == prop) {
/*  539 */       ret.result = -1;
/*  540 */       return ret;
/*      */     } 
/*      */     
/*  543 */     boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
/*  544 */     if (isInGuild) {
/*  545 */       ret.result = -2;
/*  546 */       return ret;
/*      */     } 
/*      */     
/*  549 */     if (this.player.getLevel() < prop.joinLv) {
/*  550 */       ret.result = -3;
/*  551 */       return ret;
/*      */     } 
/*      */     
/*  554 */     Date now = new Date();
/*  555 */     long lastSelfExitPassedTime = now.getTime() - this.guildData.lastSelfExitTime.getTime();
/*  556 */     if (lastSelfExitPassedTime < prop.selfOutMs) {
/*  557 */       long needMs = prop.selfOutMs - lastSelfExitPassedTime;
/*  558 */       String cdInfo = GuildCommonUtil.leftTimeTips(needMs);
/*  559 */       ret.result = -10;
/*  560 */       ret.cdInfo = cdInfo;
/*  561 */       return ret;
/*      */     } 
/*      */     
/*  564 */     if ((this.player.getPlayer()).diamond < prop.cost) {
/*  565 */       ret.result = -4;
/*  566 */       return ret;
/*      */     } 
/*      */     
/*  569 */     if (params.getString("name").length() < 3) {
/*  570 */       ret.result = -6;
/*  571 */       return ret;
/*      */     } 
/*      */     
/*  574 */     if (params.getString("name").length() > 6) {
/*  575 */       ret.result = -7;
/*  576 */       return ret;
/*      */     } 
/*      */     
/*  579 */     if (BlackWordUtil.isIncludeSpecialChar(params.getString("name"))) {
/*  580 */       ret.result = -8;
/*  581 */       return ret;
/*      */     } 
/*      */     
/*  584 */     if (BlackWordUtil.isIncludeBlackString(params.getString("name"))) {
/*  585 */       ret.result = -9;
/*  586 */       return ret;
/*      */     } 
/*      */     
/*  589 */     ret = GuildService.createGuild(this.player, params);
/*      */     
/*  591 */     if (ret.result == 0) {
/*  592 */       syncGuildInfo(false);
/*  593 */       this.player.moneyManager.costDiamond(prop.cost, Const.GOODS_CHANGE_TYPE.guild_create);
/*  594 */       refreshGuildInfo(true);
/*  595 */       pushAndRefreshGuildEffect();
/*  596 */       this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
/*      */     } 
/*  598 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult joinGuild(String guildId) {
/*  602 */     GuildResult ret = new GuildResult();
/*  603 */     GuildResult.JoinGuild data = new GuildResult.JoinGuild();
/*  604 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  605 */     if (null == prop) {
/*  606 */       ret.result = -1;
/*  607 */       return ret;
/*      */     } 
/*  609 */     boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
/*  610 */     if (isInGuild) {
/*  611 */       ret.result = -2;
/*  612 */       return ret;
/*      */     } 
/*      */     
/*  615 */     GuildPO guild = GuildUtil.getGuild(guildId);
/*  616 */     if (null == guild) {
/*  617 */       ret.result = -3;
/*  618 */       return ret;
/*      */     } 
/*      */     
/*  621 */     if (guild.entryUpLevel > 0) {
/*  622 */       if ((this.player.getPlayer()).upLevel < guild.entryUpLevel) {
/*  623 */         data.needUpLevel = guild.entryUpLevel;
/*  624 */         ret.data = data;
/*  625 */         ret.result = -4;
/*  626 */         return ret;
/*      */       } 
/*      */     } else {
/*  629 */       int needLevel = Math.max(prop.joinLv, guild.entryLevel);
/*  630 */       if (this.player.getLevel() < needLevel) {
/*  631 */         ret.result = -5;
/*  632 */         ret.needLevel = needLevel;
/*  633 */         ret.data = data;
/*  634 */         return ret;
/*      */       } 
/*      */     } 
/*      */     
/*  638 */     Date now = new Date();
/*  639 */     long lastSelfExitPassedTime = now.getTime() - this.guildData.lastSelfExitTime.getTime();
/*  640 */     lastSelfExitPassedTime = (lastSelfExitPassedTime > 0L) ? lastSelfExitPassedTime : prop.selfOutMs;
/*  641 */     if (lastSelfExitPassedTime < prop.selfOutMs) {
/*  642 */       long needMs = prop.selfOutMs - lastSelfExitPassedTime;
/*  643 */       String cdInfo = GuildCommonUtil.leftTimeTips(needMs);
/*  644 */       ret.result = -6;
/*  645 */       data.cdInfo = cdInfo;
/*  646 */       ret.data = data;
/*  647 */       return ret;
/*      */     } 
/*  649 */     if (!GWorld.sids.contains(Integer.valueOf(this.player.getLogicServerId()))) {
/*  650 */       ret.result = -7;
/*  651 */       return ret;
/*      */     } 
/*      */     
/*  654 */     ret = GuildService.joinGuild(this.player, guildId);
/*      */     
/*  656 */     if (ret.result != 0 || 
/*  657 */       ret.joined);
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
/*  669 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult joinGuildByPlayerId(String playerId) {
/*  673 */     GuildResult ret = new GuildResult();
/*  674 */     boolean isInGuild = GuildUtil.isInGuild(this.player.getId());
/*  675 */     if (isInGuild) {
/*  676 */       ret.result = -2;
/*  677 */       return ret;
/*      */     } 
/*  679 */     GuildMemberPO memInfo = GuildUtil.getGuildMember(playerId);
/*  680 */     if (null == memInfo || null == memInfo.playerId) {
/*  681 */       ret.result = -20;
/*  682 */       return ret;
/*      */     } 
/*      */     
/*  685 */     ret = joinGuild(memInfo.guildId);
/*  686 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult invitePlayerJoinGuild(String playerId) {
/*  690 */     GuildResult ret = new GuildResult();
/*  691 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  692 */     if (null == myInfo) {
/*  693 */       ret.result = -1;
/*  694 */       return ret;
/*      */     } 
/*      */     
/*  697 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/*  698 */     if (null == myGuild) {
/*  699 */       ret.result = -1;
/*  700 */       return ret;
/*      */     } 
/*  702 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  703 */     if (jobProp.right11 == 0) {
/*  704 */       ret.result = -2;
/*  705 */       return ret;
/*      */     } 
/*  707 */     boolean isInGuild = GuildUtil.isInGuild(playerId);
/*  708 */     if (isInGuild) {
/*  709 */       ret.result = -3;
/*  710 */       return ret;
/*      */     } 
/*  712 */     if (!PlayerUtil.isOnline(playerId)) {
/*  713 */       ret.result = -4;
/*  714 */       return ret;
/*      */     } 
/*      */     
/*  717 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*  718 */     if (null != player && !GWorld.sids.contains(Integer.valueOf(player.getLogicServerId()))) {
/*  719 */       ret.result = -7;
/*  720 */       return ret;
/*      */     } 
/*      */     
/*  723 */     GuildHandler.GuildInvitePush.Builder inviteInfo = GuildHandler.GuildInvitePush.newBuilder();
/*  724 */     inviteInfo.setS2CCode(200);
/*  725 */     inviteInfo.setPlayerId(this.player.getId());
/*  726 */     inviteInfo.setPlayerPro(this.player.getPro());
/*  727 */     inviteInfo.setPlayerName(this.player.getName());
/*  728 */     inviteInfo.setGuildId(myGuild.id);
/*  729 */     inviteInfo.setGuildLevel(myGuild.level);
/*  730 */     inviteInfo.setGuildName(myGuild.name);
/*      */     
/*  732 */     if (null != player) {
/*  733 */       player.guildManager.pushInviteJoinGuild(inviteInfo);
/*      */     }
/*      */     
/*  736 */     ret.result = 0;
/*  737 */     return ret;
/*      */   }
/*      */   
/*      */   public void pushInviteJoinGuild(GuildHandler.GuildInvitePush.Builder inviteInfo) {
/*  741 */     this.player.receive("area.guildPush.guildInvitePush", (GeneratedMessage)inviteInfo.build());
/*      */   }
/*      */   
/*      */   public GuildResult dealApply(String applyId, int operate) {
/*  745 */     GuildResult ret = new GuildResult();
/*  746 */     if (operate < 2 && null == applyId) {
/*  747 */       ret.result = -20;
/*  748 */       return ret;
/*      */     } 
/*  750 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  751 */     if (null == myInfo) {
/*  752 */       ret.result = -1;
/*  753 */       return ret;
/*      */     } 
/*      */     
/*  756 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  757 */     if (jobProp.right3 == 0) {
/*  758 */       ret.result = -2;
/*  759 */       return ret;
/*      */     } 
/*      */     
/*  762 */     ret = GuildService.dealApply(this.player, applyId, operate);
/*      */     
/*  764 */     if (ret.result == 0);
/*      */ 
/*      */ 
/*      */     
/*  768 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult setGuildInfo(GuildSetData params) {
/*  772 */     GuildResult ret = new GuildResult();
/*  773 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  774 */     if (null == myInfo) {
/*  775 */       ret.result = -2;
/*  776 */       return ret;
/*      */     } 
/*      */     
/*  779 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  780 */     GuildSetData newParams = new GuildSetData();
/*  781 */     if (params.entryLevel > 0) {
/*  782 */       if (params.entryLevel < prop.joinLv) {
/*  783 */         ret.result = -4;
/*  784 */         return ret;
/*      */       } 
/*  786 */       newParams.entryLevel = params.entryLevel;
/*      */     } 
/*  788 */     if (params.entryUpLevel > 0 || params.entryUpLevel == 0) {
/*  789 */       newParams.entryUpLevel = params.entryUpLevel;
/*      */     }
/*      */     
/*  792 */     if (params.guildMode > 0 && (
/*  793 */       params.guildMode == Const.GuildMode.AUTO_MODE.getValue() || params.guildMode == Const.GuildMode.CHECK_MODE.getValue())) {
/*  794 */       newParams.guildMode = params.guildMode;
/*      */     }
/*      */ 
/*      */     
/*  798 */     return GuildService.setGuildInfo(this.player, newParams);
/*      */   }
/*      */   
/*      */   public GuildResult setGuildQQGroup(String qqGroup) {
/*  802 */     GuildResult ret = new GuildResult();
/*  803 */     if (qqGroup.length() > 10) {
/*  804 */       ret.result = -1;
/*  805 */       return ret;
/*      */     } 
/*  807 */     if (!BlackWordUtil.isNumberString(qqGroup)) {
/*  808 */       ret.result = -2;
/*  809 */       return ret;
/*      */     } 
/*  811 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  812 */     if (null == myInfo) {
/*  813 */       ret.result = -3;
/*  814 */       return ret;
/*      */     } 
/*  816 */     return GuildService.setGuildQQGroup(this.player, qqGroup);
/*      */   }
/*      */   
/*      */   public List<GuildHandler.GuildInfo> getGuildList(String name) {
/*  820 */     List<GuildHandler.GuildInfo> data = new ArrayList<>();
/*      */     
/*  822 */     List<GuildPO> guildList = GuildUtil.getGuildList(this.player.getLogicServerId(), name);
/*  823 */     List<GuildApplyPO> applies = GuildUtil.getPlayerApplyIdList(this.player.getId());
/*      */     
/*  825 */     for (GuildPO guild : guildList) {
/*  826 */       GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
/*  827 */       GuildHandler.GuildBaseInfo.Builder baseInfo = GuildHandler.GuildBaseInfo.newBuilder();
/*  828 */       baseInfo.setGuildId(guild.id);
/*  829 */       baseInfo.setName(guild.name);
/*  830 */       baseInfo.setLevel(guild.level);
/*  831 */       baseInfo.setPresidentId(guild.presidentId);
/*  832 */       baseInfo.setPresidentName(guild.presidentName);
/*  833 */       baseInfo.setEntryLevel(guild.entryLevel);
/*  834 */       baseInfo.setEntryUpLevel(guild.entryUpLevel);
/*  835 */       baseInfo.setGuildMode(guild.guildMode);
/*  836 */       baseInfo.setGuildIcon(guild.icon);
/*  837 */       baseInfo.setMemberNum(GuildUtil.getGuildMemberCount(guild.id));
/*  838 */       baseInfo.setMemberMax(levelProp.member);
/*  839 */       PlayerPO president = PlayerUtil.getPlayerBaseData(guild.presidentId);
/*  840 */       if (null == president) {
/*      */         continue;
/*      */       }
/*  843 */       baseInfo.setPresidentPro(president.pro);
/*  844 */       baseInfo.setPresidentLevel(president.level);
/*  845 */       baseInfo.setCreateTime(guild.createTime.toString());
/*      */       
/*  847 */       GuildHandler.GuildInfo.Builder guildInfo = GuildHandler.GuildInfo.newBuilder();
/*  848 */       guildInfo.setBaseInfo(baseInfo);
/*      */       
/*  850 */       boolean haveApply = false;
/*  851 */       for (GuildApplyPO guildApplyPO : applies) {
/*  852 */         if (guildApplyPO.guildId.equals(guild.id)) {
/*  853 */           haveApply = true;
/*      */           break;
/*      */         } 
/*      */       } 
/*  857 */       if (haveApply) {
/*  858 */         guildInfo.setApplyState(1);
/*      */       }
/*  860 */       data.add(guildInfo.build());
/*      */     } 
/*      */     
/*  863 */     data.sort(new Comparator<GuildHandler.GuildInfo>()
/*      */         {
/*      */           public int compare(GuildHandler.GuildInfo guildA, GuildHandler.GuildInfo guildB) {
/*  866 */             GuildHandler.GuildBaseInfo baseA = guildA.toBuilder().getBaseInfo();
/*  867 */             GuildHandler.GuildBaseInfo baseB = guildB.toBuilder().getBaseInfo();
/*  868 */             if (baseA.getLevel() != baseB.getLevel()) {
/*  869 */               return (baseA.getLevel() < baseB.getLevel()) ? 1 : -1;
/*      */             }
/*  871 */             return baseB.getCreateTime().compareTo(baseA.getCreateTime());
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */     
/*  877 */     return data;
/*      */   }
/*      */   
/*      */   public GuildHandler.MyContributeInfo getMyContributeInfo(String guildId) {
/*  881 */     GuildHandler.MyContributeInfo.Builder myContributeInfo = GuildHandler.MyContributeInfo.newBuilder();
/*  882 */     int myContribute = 0;
/*      */ 
/*      */ 
/*      */     
/*  886 */     myContribute = getContribution();
/*  887 */     myContributeInfo.setCurrentContribute(myContribute);
/*  888 */     myContributeInfo.setTotalContribute(getTotalContribution(guildId));
/*  889 */     myContributeInfo.addAllTimesList(getContributeTimesList());
/*  890 */     return myContributeInfo.build();
/*      */   }
/*      */   
/*      */   public List<GuildHandler.ContributeTimesInfo> getContributeTimesList() {
/*  894 */     List<GuildHandler.ContributeTimesInfo> timesList = new ArrayList<>();
/*  895 */     Map<String, GuildContributeCO> propMap = GuildUtil.getGuildContributePropMap();
/*  896 */     for (String key : propMap.keySet()) {
/*  897 */       GuildContributeCO prop = propMap.get(key);
/*  898 */       GuildHandler.ContributeTimesInfo.Builder tempInfo = GuildHandler.ContributeTimesInfo.newBuilder();
/*  899 */       tempInfo.setType(prop.type);
/*  900 */       tempInfo.setTimes(getContributeTimes(prop.type));
/*  901 */       tempInfo.setMaxTimes(prop.time);
/*  902 */       timesList.add(tempInfo.build());
/*      */     } 
/*      */     
/*  905 */     return timesList;
/*      */   }
/*      */   
/*      */   public GuildHandler.MyGuildInfo getMyGuildInfo() {
/*  909 */     GuildHandler.MyGuildInfo.Builder data = GuildHandler.MyGuildInfo.newBuilder();
/*  910 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  911 */     if (null == myInfo) {
/*  912 */       return null;
/*      */     }
/*  914 */     GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
/*  915 */     if (null == guild) {
/*  916 */       return null;
/*      */     }
/*      */     
/*  919 */     GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
/*  920 */     if (null == levelProp) {
/*  921 */       return null;
/*      */     }
/*      */     
/*  924 */     GuildHandler.GuildBaseInfo.Builder baseInfo = GuildHandler.GuildBaseInfo.newBuilder();
/*  925 */     baseInfo.setGuildId(guild.id);
/*  926 */     baseInfo.setName(guild.name);
/*  927 */     baseInfo.setLevel(guild.level);
/*  928 */     baseInfo.setPresidentId(guild.presidentId);
/*  929 */     baseInfo.setPresidentName(guild.presidentName);
/*  930 */     baseInfo.setEntryLevel(guild.entryLevel);
/*  931 */     baseInfo.setEntryUpLevel(guild.entryUpLevel);
/*  932 */     baseInfo.setGuildMode(guild.guildMode);
/*  933 */     baseInfo.setGuildIcon(guild.icon);
/*  934 */     baseInfo.setMemberNum(GuildUtil.getGuildMemberCount(guild.id));
/*  935 */     baseInfo.setMemberMax(levelProp.member);
/*  936 */     PlayerPO president = PlayerUtil.getPlayerBaseData(guild.presidentId);
/*  937 */     baseInfo.setPresidentPro(1);
/*  938 */     baseInfo.setPresidentLevel(1);
/*  939 */     if (null == president) {
/*  940 */       Out.debug(new Object[] { "getMyGuildInfo getPlayerBaseData player not exit,guildId:", guild.id, ", playerId:", guild.presidentId });
/*      */     } else {
/*  942 */       baseInfo.setPresidentPro(president.pro);
/*  943 */       baseInfo.setPresidentLevel(president.level);
/*      */     } 
/*      */     
/*  946 */     data.setBaseInfo(baseInfo.build());
/*  947 */     data.setNotice(guild.notice);
/*  948 */     data.setFund((int)guild.fund);
/*  949 */     data.setExp((int)guild.exp);
/*  950 */     data.setQqGroup(guild.qqGroup);
/*  951 */     data.setMyInfo(getMyContributeInfo(guild.id));
/*  952 */     Date now = new Date();
/*  953 */     int passedDay = (int)Math.floor(((now.getTime() - guild.changeNameTime.getTime()) / Const.Time.Day.getValue()));
/*  954 */     passedDay = Math.min(passedDay, 7);
/*  955 */     data.setChangeNamePassedDay(passedDay);
/*      */     
/*  957 */     List<GuildHandler.OfficeName> officeNames = new ArrayList<>();
/*  958 */     for (Integer key : guild.officeNames.keySet()) {
/*  959 */       GuildHandler.OfficeName.Builder jobInfo = GuildHandler.OfficeName.newBuilder();
/*  960 */       jobInfo.setJob(key.intValue());
/*  961 */       jobInfo.setName((String)guild.officeNames.get(key));
/*  962 */       officeNames.add(jobInfo.build());
/*      */     } 
/*  964 */     data.addAllOfficeNames(officeNames);
/*  965 */     return data.build();
/*      */   }
/*      */   
/*      */   public void onChangeName() {
/*  969 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  970 */     if (null == myInfo) {
/*      */       return;
/*      */     }
/*  973 */     myInfo.name = this.player.getName();
/*  974 */     GuildUtil.updateGuildMember(myInfo);
/*  975 */     GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
/*  976 */     if (null == guild) {
/*      */       return;
/*      */     }
/*  979 */     if (guild.presidentId.equals(this.player.getId())) {
/*  980 */       guild.presidentName = this.player.getName();
/*  981 */       GuildUtil.updateGuild(guild);
/*      */     } 
/*      */   }
/*      */   
/*      */   public GuildResult getMyGuildMemberList() {
/*  986 */     GuildResult ret = new GuildResult();
/*  987 */     GuildResult.MyGuildMember data = new GuildResult.MyGuildMember();
/*  988 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/*  989 */     if (null == myInfo) {
/*  990 */       ret.result = -1;
/*  991 */       return ret;
/*      */     } 
/*      */     
/*  994 */     GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
/*  995 */     if (null == guild) {
/*  996 */       ret.result = -1;
/*  997 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1001 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1002 */     int kickCount = guild.kickCount;
/* 1003 */     if (DateUtil.canRefreshData(5, guild.kickTime)) {
/* 1004 */       kickCount = 0;
/*      */     }
/* 1006 */     int leftKickNum = settingProp.fireNum - kickCount;
/* 1007 */     data.leftKickNum = (leftKickNum > 0) ? leftKickNum : 0;
/*      */     
/* 1009 */     List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(myInfo.guildId);
/* 1010 */     Map<Integer, String> defaultNames = GuildUtil.getJobNameMap();
/* 1011 */     GuildHandler.MemberInfo.Builder president = GuildHandler.MemberInfo.newBuilder();
/* 1012 */     GuildHandler.MemberInfo.Builder me = GuildHandler.MemberInfo.newBuilder();
/* 1013 */     for (GuildMemberPO member : memberList) {
/* 1014 */       PlayerPO playerBase = PlayerUtil.getPlayerBaseData(member.playerId);
/* 1015 */       if (null == playerBase) {
/*      */         continue;
/*      */       }
/*      */       
/* 1019 */       GuildHandler.MemberInfo.Builder tempInfo = GuildHandler.MemberInfo.newBuilder();
/* 1020 */       tempInfo.setGuildName(guild.name);
/* 1021 */       tempInfo.setPlayerId(member.playerId);
/* 1022 */       tempInfo.setJob(member.job);
/* 1023 */       tempInfo.setJoinTime(member.createTime.toString());
/* 1024 */       if (null != guild.officeNames.get(Integer.valueOf(member.job))) {
/* 1025 */         tempInfo.setJobName((String)guild.officeNames.get(Integer.valueOf(member.job)));
/*      */       } else {
/* 1027 */         tempInfo.setJobName(defaultNames.get(Integer.valueOf(member.job)));
/*      */       } 
/*      */       
/* 1030 */       tempInfo.setName(playerBase.name);
/* 1031 */       tempInfo.setPro(playerBase.pro);
/* 1032 */       tempInfo.setLevel(playerBase.level);
/* 1033 */       tempInfo.setUpLevel(playerBase.upOrder);
/*      */       
/* 1035 */       PlayerGuildPO redisPo = FindPlayerGuildDao.getPlayerGuildPOById(member.playerId);
/* 1036 */       if (null == redisPo) {
/*      */         continue;
/*      */       }
/*      */       
/* 1040 */       Map<String, Integer> totalContrMap = redisPo.totalContributionMap;
/* 1041 */       int contribution = 0;
/* 1042 */       int totalContribute = 0;
/* 1043 */       if (null != totalContrMap && totalContrMap.size() > 0) {
/* 1044 */         if (totalContrMap.containsKey(guild.id)) {
/* 1045 */           totalContribute = ((Integer)totalContrMap.get(guild.id)).intValue();
/*      */         } else {
/*      */           
/* 1048 */           totalContribute = 0;
/*      */         } 
/*      */       }
/*      */       
/* 1052 */       contribution = redisPo.contribution;
/* 1053 */       tempInfo.setCurrentContribute(contribution);
/* 1054 */       tempInfo.setTotalContribute(totalContribute);
/* 1055 */       boolean isOnline = PlayerUtil.isOnline(member.playerId);
/* 1056 */       tempInfo.setOnlineState(isOnline ? 1 : 0);
/* 1057 */       tempInfo.setLastActiveTime((int)Math.ceil((playerBase.logoutTime.getTime() / Const.Time.Second.getValue())));
/*      */       
/* 1059 */       if (tempInfo.getJob() == Const.GuildJob.PRESIDENT.getValue()) {
/* 1060 */         president = tempInfo;
/* 1061 */         if (tempInfo.getPlayerId().equals(this.player.getId()))
/* 1062 */           me = tempInfo;  continue;
/*      */       } 
/* 1064 */       if (tempInfo.getPlayerId().equals(this.player.getId())) {
/* 1065 */         me = tempInfo; continue;
/*      */       } 
/* 1067 */       data.list.add(tempInfo.build());
/*      */     } 
/*      */ 
/*      */     
/* 1071 */     data.list.sort((o1, o2) -> {
/*      */           GuildHandler.MemberInfo.Builder memberA = o1.toBuilder();
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           GuildHandler.MemberInfo.Builder memberB = o1.toBuilder();
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           return (memberA.getOnlineState() != memberB.getOnlineState()) ? ((memberA.getOnlineState() < memberB.getOnlineState()) ? 1 : -1) : ((memberA.getJob() != memberB.getJob()) ? ((memberA.getJob() < memberB.getJob()) ? -1 : 1) : ((memberA.getUpLevel() != memberB.getUpLevel()) ? ((memberA.getUpLevel() < memberB.getUpLevel()) ? 1 : -1) : ((memberA.getLevel() != memberB.getLevel()) ? ((memberA.getLevel() < memberB.getLevel()) ? 1 : -1) : memberB.getJoinTime().compareTo(memberA.getJoinTime()))));
/*      */         });
/*      */ 
/*      */ 
/*      */     
/* 1087 */     if (!president.getPlayerId().equals(me.getPlayerId())) {
/* 1088 */       data.list.add(0, me.build());
/*      */     }
/*      */     
/* 1091 */     data.list.add(0, president.build());
/* 1092 */     ret.result = 0;
/* 1093 */     ret.data = data;
/* 1094 */     return ret;
/*      */   }
/*      */   
/*      */   public List<GuildHandler.ApplyInfo> getMyGuildApplyList() {
/* 1098 */     List<GuildHandler.ApplyInfo> data = new ArrayList<>();
/* 1099 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1100 */     if (null == myInfo) {
/* 1101 */       return data;
/*      */     }
/* 1103 */     GuildPO guild = GuildUtil.getGuild(myInfo.guildId);
/* 1104 */     if (null == guild) {
/* 1105 */       return data;
/*      */     }
/* 1107 */     List<GuildApplyPO> applyList = GuildUtil.getGuildApplyList(myInfo.guildId);
/* 1108 */     for (GuildApplyPO apply : applyList) {
/* 1109 */       PlayerPO playerBase = PlayerUtil.getPlayerBaseData(apply.playerId);
/* 1110 */       if (null == playerBase) {
/*      */         continue;
/*      */       }
/* 1113 */       GuildHandler.ApplyInfo.Builder tempInfo = GuildHandler.ApplyInfo.newBuilder();
/* 1114 */       tempInfo.setApplyId(apply.id);
/* 1115 */       tempInfo.setPlayerId(apply.playerId);
/* 1116 */       tempInfo.setPro(playerBase.pro);
/* 1117 */       tempInfo.setName(playerBase.name);
/* 1118 */       tempInfo.setLevel(playerBase.level);
/* 1119 */       tempInfo.setFightPower(playerBase.fightPower);
/* 1120 */       tempInfo.setUpLevel(this.player.player.upLevel);
/* 1121 */       tempInfo.setCreateTime(apply.createTime.toString());
/* 1122 */       data.add(tempInfo.build());
/*      */     } 
/*      */     
/* 1125 */     data.sort((applyA, applyB) -> (applyA.getUpLevel() != applyB.getUpLevel()) ? ((applyA.getUpLevel() < applyB.getUpLevel()) ? 1 : -1) : ((applyA.getLevel() != applyB.getLevel()) ? ((applyA.getLevel() < applyB.getLevel()) ? 1 : -1) : ((applyA.getFightPower() != applyB.getFightPower()) ? ((applyA.getFightPower() < applyB.getFightPower()) ? 1 : -1) : applyB.getCreateTime().compareTo(applyA.getCreateTime()))));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1135 */     return data;
/*      */   }
/*      */   
/*      */   public GuildResult exitGuild() {
/* 1139 */     GuildResult ret = GuildService.exitGuild(this.player);
/* 1140 */     if (ret.result == 0) {
/* 1141 */       this.guildData.lastSelfExitTime = new Date();
/* 1142 */       Set<String> ids = new HashSet<>();
/* 1143 */       ids.add(this.player.getId());
/* 1144 */       GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
/* 1145 */       GuildService.notifySomePlayerRefreshGuild(ids, msg, null);
/* 1146 */       this.player.pkRuleManager.onExitGuild();
/* 1147 */       update();
/*      */     } 
/* 1149 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult kickMember(String kickId) {
/* 1153 */     GuildResult ret = GuildService.kickMember(this.player, kickId);
/* 1154 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult upgradeGuildLevel() {
/* 1158 */     GuildResult ret = new GuildResult();
/* 1159 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1160 */     if (null == myInfo) {
/* 1161 */       ret.result = -1;
/* 1162 */       ret.des = "不是公会成员";
/* 1163 */       return ret;
/*      */     } 
/* 1165 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1166 */     if (null == myGuild) {
/* 1167 */       ret.result = -1;
/* 1168 */       ret.des = "不是公会成员";
/* 1169 */       return ret;
/*      */     } 
/*      */     
/* 1172 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 1173 */     if (jobProp.right12 == 0) {
/* 1174 */       ret.result = -2;
/* 1175 */       ret.des = "没有权限";
/* 1176 */       return ret;
/*      */     } 
/*      */     
/* 1179 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1180 */     GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
/* 1181 */     if (null == settingProp || null == levelProp) {
/* 1182 */       ret.result = -3;
/* 1183 */       ret.des = "配置错误";
/* 1184 */       return ret;
/*      */     } 
/* 1186 */     if (!this.player.moneyManager.enoughGold(levelProp.gold)) {
/* 1187 */       ret.result = -4;
/* 1188 */       ret.des = "银两不足";
/* 1189 */       return ret;
/*      */     } 
/*      */     
/* 1192 */     ret = GuildService.upgradeGuildLevel(this.player);
/*      */     
/* 1194 */     if (ret.result == 0) {
/* 1195 */       this.player.moneyManager.costGold(levelProp.gold, Const.GOODS_CHANGE_TYPE.guild_upgrade_level);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1205 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult changeGuildNotice(String notice) {
/* 1209 */     GuildResult ret = new GuildResult();
/* 1210 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1211 */     if (null == myInfo) {
/* 1212 */       ret.result = -1;
/* 1213 */       return ret;
/*      */     } 
/* 1215 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1216 */     if (null == myGuild) {
/* 1217 */       ret.result = -1;
/* 1218 */       ret.des = "不是公会成员";
/* 1219 */       return ret;
/*      */     } 
/*      */     
/* 1222 */     if (null == notice) {
/* 1223 */       ret.result = -3;
/* 1224 */       return ret;
/*      */     } 
/*      */     
/* 1227 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1228 */     int maxLen = (settingProp.announcement > 0) ? settingProp.announcement : 100;
/* 1229 */     if (notice.length() > maxLen) {
/* 1230 */       ret.result = -4;
/* 1231 */       return ret;
/*      */     } 
/*      */     
/* 1234 */     String replacedNotice = BlackWordUtil.replaceBlackString(notice);
/* 1235 */     ret = GuildService.changeGuildNotice(this.player, replacedNotice);
/* 1236 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult changeGuildName(String name) {
/* 1240 */     GuildResult ret = new GuildResult();
/* 1241 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1242 */     if (null == myInfo) {
/* 1243 */       ret.result = -1;
/* 1244 */       return ret;
/*      */     } 
/* 1246 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1247 */     if (null == myGuild) {
/* 1248 */       ret.result = -1;
/* 1249 */       return ret;
/*      */     } 
/*      */     
/* 1252 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 1253 */     if (jobProp.right2 == 0) {
/* 1254 */       ret.result = -2;
/* 1255 */       return ret;
/*      */     } 
/* 1257 */     Date now = new Date();
/* 1258 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1259 */     int dayCD = settingProp.changeNameCD;
/* 1260 */     long cdOverTime = myGuild.changeNameTime.getTime() + (dayCD * Const.Time.Day.getValue());
/* 1261 */     if (now.getTime() < cdOverTime) {
/* 1262 */       ret.result = 2;
/* 1263 */       return ret;
/*      */     } 
/* 1265 */     if (null == name || name.length() < 3) {
/* 1266 */       ret.result = -4;
/* 1267 */       return ret;
/*      */     } 
/* 1269 */     if (name.length() > settingProp.nameMaxLen) {
/* 1270 */       ret.result = -5;
/* 1271 */       return ret;
/*      */     } 
/* 1273 */     if (BlackWordUtil.isIncludeSpecialChar(name)) {
/* 1274 */       ret.result = -8;
/* 1275 */       return ret;
/*      */     } 
/* 1277 */     if (BlackWordUtil.isIncludeBlackString(name)) {
/* 1278 */       ret.result = -9;
/* 1279 */       return ret;
/*      */     } 
/*      */     
/* 1282 */     GuildSettingExt settintProp = GuildUtil.getGuildSettingExtProp();
/* 1283 */     String costCode = settintProp.changeName;
/* 1284 */     int costNum = settintProp.changeNameCost;
/* 1285 */     int haveNum = this.player.bag.findItemNumByCode(costCode);
/* 1286 */     if (haveNum < costNum) {
/* 1287 */       ret.result = -6;
/* 1288 */       return ret;
/*      */     } 
/*      */     
/* 1291 */     ret = GuildService.changeGuildName(this.player, name);
/* 1292 */     if (ret.result == 0) {
/* 1293 */       this.player.bag.discardItem(costCode, costNum, Const.GOODS_CHANGE_TYPE.guildchangename, null, false, false);
/* 1294 */       update();
/*      */     } 
/* 1296 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult changeOfficeName(List<GuildHandler.OfficeName> officeNames) {
/* 1300 */     GuildResult ret = new GuildResult();
/* 1301 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1302 */     if (null == myInfo) {
/* 1303 */       ret.result = -1;
/* 1304 */       return ret;
/*      */     } 
/* 1306 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1307 */     if (null == myGuild) {
/* 1308 */       ret.result = -1;
/* 1309 */       return ret;
/*      */     } 
/*      */     
/* 1312 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1313 */       ret.result = -2;
/* 1314 */       return ret;
/*      */     } 
/*      */     
/* 1317 */     GuildSettingExt settintProp = GuildUtil.getGuildSettingExtProp();
/* 1318 */     for (GuildHandler.OfficeName office : officeNames) {
/* 1319 */       if (office.getJob() < Const.GuildJob.PRESIDENT.getValue() || office.getJob() > Const.GuildJob.MEMBER.getValue()) {
/* 1320 */         ret.result = -3;
/* 1321 */         return ret;
/* 1322 */       }  if (office.getName().isEmpty()) {
/* 1323 */         ret.result = -4;
/* 1324 */         return ret;
/* 1325 */       }  if (office.getName().length() > settintProp.maxLen) {
/* 1326 */         ret.result = -5;
/* 1327 */         return ret;
/* 1328 */       }  if (BlackWordUtil.isIncludeSpecialChar(office.getName())) {
/* 1329 */         ret.result = -8;
/* 1330 */         return ret;
/* 1331 */       }  if (BlackWordUtil.isIncludeBlackString(office.getName())) {
/* 1332 */         ret.result = -9;
/* 1333 */         return ret;
/*      */       } 
/*      */     } 
/*      */     
/* 1337 */     ret = GuildService.changeOfficeName(this.player, officeNames);
/* 1338 */     if (ret.result == 0);
/*      */     
/* 1340 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkIsCanContribute() {
/* 1349 */     boolean ret = false;
/*      */     
/* 1351 */     for (int i = 1; i <= 2; i++) {
/* 1352 */       GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(i);
/* 1353 */       String costCode = contributeProp.costItem;
/* 1354 */       int costNum = contributeProp.costAmount;
/*      */       
/* 1356 */       if (getContributeTimes(i) < contributeProp.time) {
/* 1357 */         if (1 == i) {
/* 1358 */           if (this.player.moneyManager.enoughGold(costNum)) {
/* 1359 */             ret = true;
/*      */             break;
/*      */           } 
/*      */         } else {
/* 1363 */           int haveNum = this.player.bag.findItemNumByCode(costCode);
/* 1364 */           if (haveNum >= costNum) {
/* 1365 */             ret = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 1371 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult contributeToGuild(int type, int times) {
/* 1375 */     GuildResult ret = new GuildResult();
/* 1376 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1377 */     if (null == myInfo) {
/* 1378 */       ret.result = -1;
/* 1379 */       return ret;
/*      */     } 
/* 1381 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1382 */     if (null == myGuild) {
/* 1383 */       ret.result = -1;
/* 1384 */       return ret;
/*      */     } 
/*      */     
/* 1387 */     GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(type);
/* 1388 */     if (null == contributeProp || times == 0) {
/* 1389 */       ret.result = -2;
/* 1390 */       return ret;
/*      */     } 
/* 1392 */     String costCode = contributeProp.costItem;
/* 1393 */     int costNum = contributeProp.costAmount * times;
/* 1394 */     if (type == 1) {
/* 1395 */       if (!this.player.moneyManager.enoughGold(costNum)) {
/* 1396 */         ret.result = -3;
/* 1397 */         return ret;
/*      */       } 
/*      */     } else {
/* 1400 */       int haveNum = this.player.bag.findItemNumByCode(costCode);
/* 1401 */       if (haveNum < costNum) {
/* 1402 */         ret.result = -4;
/* 1403 */         return ret;
/*      */       } 
/*      */     } 
/* 1406 */     if (getContributeTimes(type) + times > contributeProp.time) {
/* 1407 */       ret.result = -5;
/* 1408 */       return ret;
/*      */     } 
/*      */     
/* 1411 */     ret = GuildService.contributeToGuild(this.player, type, times);
/*      */     
/* 1413 */     if (ret.result == 0) {
/* 1414 */       if (type == 1) {
/* 1415 */         this.player.moneyManager.costGold(costNum, Const.GOODS_CHANGE_TYPE.guild_donate);
/*      */       } else {
/* 1417 */         this.player.bag.discardItem(costCode, costNum, Const.GOODS_CHANGE_TYPE.guild_donate);
/*      */       } 
/* 1419 */       int totalPoints = contributeProp.guildPoints * times;
/* 1420 */       addContribution(totalPoints, Const.GOODS_CHANGE_TYPE.guild_donate);
/* 1421 */       addTotalContribution(myGuild.id, totalPoints);
/* 1422 */       addContributeTimes(type, times);
/*      */       
/* 1424 */       this.player.taskManager.dealTaskEvent(Const.TaskType.GUILD_DONATE, "1", 1);
/* 1425 */       pushRedPoint();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1434 */       (getMiscData()).guildDonateToday = 1;
/*      */       
/* 1436 */       update();
/*      */     } 
/* 1438 */     return ret;
/*      */   }
/*      */   
/*      */   public MiscData getMiscData() {
/* 1442 */     if (null == this.player.playerAttachPO.miscData) {
/* 1443 */       this.player.playerAttachPO.miscData = new MiscData();
/*      */     }
/*      */     
/* 1446 */     return this.player.playerAttachPO.miscData;
/*      */   }
/*      */   
/*      */   public GuildResult setMemberJob(String memberId, int job) {
/* 1450 */     GuildResult ret = new GuildResult();
/* 1451 */     if (null == memberId || memberId.isEmpty() || job > Const.GuildJob.MEMBER.getValue()) {
/* 1452 */       ret.result = -20;
/* 1453 */       return ret;
/*      */     } 
/* 1455 */     if (memberId == this.player.getId()) {
/* 1456 */       ret.result = -21;
/* 1457 */       return ret;
/*      */     } 
/*      */     
/* 1460 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1461 */     if (null == myInfo) {
/* 1462 */       ret.result = -1;
/* 1463 */       return ret;
/*      */     } 
/* 1465 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1466 */     if (null == myGuild) {
/* 1467 */       ret.result = -1;
/* 1468 */       return ret;
/*      */     } 
/* 1470 */     GuildMemberPO memberInfo = GuildUtil.getGuildMember(memberId);
/* 1471 */     if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
/* 1472 */       ret.result = -2;
/* 1473 */       return ret;
/*      */     } 
/* 1475 */     if (myInfo.job > Const.GuildJob.ELDER.getValue()) {
/* 1476 */       ret.result = -3;
/* 1477 */       return ret;
/*      */     } 
/* 1479 */     if (myInfo.job >= memberInfo.job || myInfo.job >= job) {
/* 1480 */       ret.result = -4;
/* 1481 */       return ret;
/*      */     } 
/*      */     
/* 1484 */     ret = GuildService.setMemberJob(this.player, memberId, job);
/* 1485 */     if (ret.result == 0);
/*      */     
/* 1487 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult transferGuildPresident(String memberId) {
/* 1491 */     GuildResult ret = new GuildResult();
/* 1492 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1493 */     if (null == myInfo) {
/* 1494 */       ret.result = -1;
/* 1495 */       return ret;
/*      */     } 
/*      */     
/* 1498 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1499 */     if (null == myGuild) {
/* 1500 */       ret.result = -1;
/* 1501 */       return ret;
/*      */     } 
/* 1503 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1504 */       ret.result = -2;
/* 1505 */       return ret;
/*      */     } 
/*      */     
/* 1508 */     GuildMemberPO memberInfo = GuildUtil.getGuildMember(memberId);
/* 1509 */     if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
/* 1510 */       ret.result = -3;
/* 1511 */       return ret;
/*      */     } 
/*      */     
/* 1514 */     PlayerPO newPresident = PlayerUtil.getPlayerBaseData(memberId);
/* 1515 */     if (null == newPresident) {
/* 1516 */       ret.result = -20;
/* 1517 */       return ret;
/*      */     } 
/*      */     
/* 1520 */     ret = GuildService.transferGuildPresident(this.player.getId(), memberId);
/* 1521 */     return ret;
/*      */   }
/*      */   
/*      */   public List<GuildHandler.RecordInfo> getGuildRecordList(int page) {
/* 1525 */     List<GuildHandler.RecordInfo> list = new ArrayList<>();
/* 1526 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1527 */     if (null == myInfo) {
/* 1528 */       return list;
/*      */     }
/* 1530 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1531 */     if (null == myGuild) {
/* 1532 */       return list;
/*      */     }
/* 1534 */     if (page == 0) {
/* 1535 */       return list;
/*      */     }
/* 1537 */     List<GuildRecordData> records = GuildDao.getGuildNews(myGuild.id);
/* 1538 */     int perPageNum = 50;
/* 1539 */     int startIndex = (page - 1) * perPageNum;
/* 1540 */     int endIndex = startIndex + perPageNum;
/* 1541 */     for (int i = startIndex; i < records.size() && i < endIndex; i++) {
/* 1542 */       GuildRecordData record = records.get(i);
/* 1543 */       Date recordTime = record.time;
/* 1544 */       GuildHandler.RecordInfo.Builder tempInfo = GuildHandler.RecordInfo.newBuilder();
/* 1545 */       tempInfo.setTime(DateUtil.format(recordTime, "MM-dd HH:mm:ss"));
/* 1546 */       if (null != record.role1 && 0 != record.role1.pro) {
/* 1547 */         tempInfo.setRole1(GuildCommonUtil.convertRoleInfo(record.role1));
/*      */       }
/* 1549 */       if (null != record.role2 && record.role2.pro != 0) {
/* 1550 */         tempInfo.setRole2(GuildCommonUtil.convertRoleInfo(record.role2));
/*      */       }
/* 1552 */       if (null != record.result) {
/* 1553 */         tempInfo.setResultNum(record.result.v1);
/*      */         
/* 1555 */         if (null != record.result.v2 && !record.result.v2.isEmpty()) {
/* 1556 */           tempInfo.setResultStr(record.result.v2);
/*      */         }
/*      */       } 
/* 1559 */       if (null != record.build && !record.build.isEmpty()) {
/* 1560 */         tempInfo.setBuild(record.build);
/*      */       }
/*      */       
/* 1563 */       tempInfo.setRecordType(record.type);
/* 1564 */       list.add(tempInfo.build());
/*      */     } 
/* 1566 */     return list;
/*      */   }
/*      */   
/*      */   public GuildResult impeachGuildPresident() {
/* 1570 */     GuildResult ret = new GuildResult();
/* 1571 */     GuildMemberPO myInfo = GuildUtil.getGuildMember(this.player.getId());
/* 1572 */     if (null == myInfo) {
/* 1573 */       ret.result = -1;
/* 1574 */       ret.des = "不是公会成员";
/* 1575 */       return ret;
/*      */     } 
/*      */     
/* 1578 */     GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/* 1579 */     if (null == myGuild) {
/* 1580 */       ret.result = -1;
/* 1581 */       ret.des = "不是公会成员";
/* 1582 */       return ret;
/*      */     } 
/* 1584 */     if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
/* 1585 */       ret.result = -2;
/* 1586 */       ret.des = "不能弹劾自己";
/* 1587 */       return ret;
/*      */     } 
/* 1589 */     boolean isPresidentOnline = PlayerUtil.isOnline(myGuild.presidentId);
/* 1590 */     if (isPresidentOnline) {
/* 1591 */       ret.result = -3;
/* 1592 */       ret.des = "会长在线";
/* 1593 */       return ret;
/*      */     } 
/* 1595 */     PlayerPO president = PlayerUtil.getPlayerBaseData(myGuild.presidentId);
/* 1596 */     if (null == president) {
/* 1597 */       ret.result = -4;
/* 1598 */       ret.des = "会长不存在，系统错误";
/* 1599 */       return ret;
/*      */     } 
/* 1601 */     Date logoutTime = president.logoutTime;
/* 1602 */     Date nowTime = new Date();
/* 1603 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1604 */     if (null == settingProp) {
/* 1605 */       ret.result = -5;
/* 1606 */       ret.des = "配置不存在，系统错误";
/* 1607 */       return ret;
/*      */     } 
/* 1609 */     if (nowTime.getTime() - logoutTime.getTime() < settingProp.impeachMs) {
/* 1610 */       ret.result = -6;
/* 1611 */       ret.des = LangService.getValue("GUILD_PRESIDENT_OFFTIME_NOT_ENOUGH").replace("{day}", String.valueOf(settingProp.impeach));
/* 1612 */       return ret;
/*      */     } 
/*      */     
/* 1615 */     ret = GuildService.impeachGuildPresident(this.player, this.guild.presidentId, logoutTime);
/*      */     
/* 1617 */     if (ret.result == 0);
/*      */ 
/*      */     
/* 1620 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onTaskEvent() {
/* 1625 */     this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
/*      */   }
/*      */   
/*      */   public void playerOnlineRefreshGuildData() {
/* 1629 */     GuildResult resData = GuildService.playerOnlineRefreshGuild(this.player);
/* 1630 */     GuildResult.PlayerOnlineRefreshGuild data = (GuildResult.PlayerOnlineRefreshGuild)resData.data;
/* 1631 */     changeGuildData(data, false);
/*      */   }
/*      */   
/*      */   public void changeGuildData(GuildMsg msg, boolean isPush) {
/* 1635 */     GuildMsg.JoinGuildBlessMsg joinBless = (GuildMsg.JoinGuildBlessMsg)msg.data;
/* 1636 */     GuildBlessPO data = joinBless.blessData;
/*      */     
/* 1638 */     if (null != data && null != data.allBlobData) {
/* 1639 */       if (null != data.allBlobData.goods) {
/* 1640 */         this.guildShopManager.goods = data.allBlobData.goods;
/*      */       }
/* 1642 */       if (null != data.allBlobData.techData) {
/* 1643 */         this.guildTechManager.refreshTechData(data.allBlobData.techData);
/*      */       }
/*      */ 
/*      */       
/* 1647 */       this.guildTechManager.refreshLevel();
/*      */       
/* 1649 */       int[] arr = data.allBlobData.finishStateArr;
/* 1650 */       for (int i = 0; i < arr.length; i++) {
/* 1651 */         if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i])
/* 1652 */           this.guildData.blessRecState[i] = arr[i]; 
/*      */       } 
/* 1654 */       if (data.allBlobData.throwAwardState > 0) {
/* 1655 */         this.throwAwardState = data.allBlobData.throwAwardState;
/*      */       }
/*      */     } 
/*      */     
/* 1659 */     if (isPush) {
/* 1660 */       pushAndRefreshGuildEffect();
/* 1661 */       changeBlessBuff();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void changeGuildData(GuildResult.PlayerOnlineRefreshGuild data, boolean isPush) {
/* 1666 */     if (null == data) {
/*      */       return;
/*      */     }
/*      */     
/* 1670 */     if (null != data.goods) {
/* 1671 */       this.guildShopManager.goods = data.goods;
/*      */     }
/* 1673 */     if (null != data.techData) {
/* 1674 */       this.guildTechManager.refreshTechData(data.techData);
/*      */     }
/*      */     
/* 1677 */     this.guildTechManager.refreshLevel();
/*      */     
/* 1679 */     int[] arr = data.finishStateArr;
/* 1680 */     for (int i = 0; i < arr.length; i++) {
/* 1681 */       if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i]) {
/* 1682 */         this.guildData.blessRecState[i] = arr[i];
/*      */       }
/*      */     } 
/* 1685 */     if (data.throwAwardState > 0) {
/* 1686 */       this.throwAwardState = data.throwAwardState;
/*      */     }
/*      */     
/* 1689 */     if (isPush) {
/* 1690 */       pushAndRefreshGuildEffect();
/* 1691 */       changeBlessBuff();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void resetGuildPublicData(boolean isPush) {
/* 1696 */     this.guildData.buffIds.clear();
/* 1697 */     for (int i = 0; i < this.guildData.blessRecState.length; i++) {
/* 1698 */       this.guildData.blessRecState[i] = 0;
/*      */     }
/* 1700 */     this.guildTechManager.resetPublicData();
/* 1701 */     this.guildShopManager.resetPublicData();
/* 1702 */     if (isPush) {
/* 1703 */       pushAndRefreshGuildEffect();
/* 1704 */       changeBlessBuff();
/*      */     } 
/* 1706 */     resetGuildInfo(true);
/*      */   }
/*      */   
/*      */   public void onNotifyRefreshGuild(GuildMsg msg) {
/* 1710 */     int refreshType = msg.notifyType;
/* 1711 */     if (refreshType == Const.NotifyType.GUILD_REFRESH.getValue()) {
/* 1712 */       refreshGuildInfo(false);
/* 1713 */     } else if (refreshType == Const.NotifyType.GUILD_JOIN_PUSH.getValue()) {
/* 1714 */       refreshGuildInfo(true);
/* 1715 */       changeGuildData(msg, true);
/* 1716 */       pushToClientRefreshGuild(msg);
/* 1717 */       if (this.guild != null) {
/* 1718 */         this.player.taskManager.dealTaskEvent(Const.TaskType.ADD_GUILD, "1", 1);
/*      */       }
/* 1720 */     } else if (refreshType == Const.NotifyType.GUILD_EXIT_PUSH.getValue()) {
/* 1721 */       resetGuildPublicData(true);
/* 1722 */       refreshGuildInfo(true);
/* 1723 */       this.player.pkRuleManager.onExitGuild();
/* 1724 */       pushToClientRefreshGuild(msg);
/* 1725 */     } else if (refreshType == Const.NotifyType.GUILD_JOB_CHANGE.getValue()) {
/* 1726 */       refreshGuildInfo(true);
/* 1727 */       pushToClientRefreshGuild(msg);
/* 1728 */     } else if (refreshType == Const.NotifyType.GUILD_CHANGE_NAME.getValue()) {
/* 1729 */       refreshGuildInfo(true);
/* 1730 */       pushToClientRefreshGuild(msg);
/* 1731 */     } else if (refreshType == Const.NotifyType.DEPOT_DEPOSIT_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_REMOVE_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_UPGRADE_PUSH.getValue() || refreshType == Const.NotifyType.DEPOT_CONDITION_PUSH.getValue()) {
/* 1732 */       GuildMsg.DepotRefreshGuildMsg msgData = (GuildMsg.DepotRefreshGuildMsg)msg.data;
/* 1733 */       GuildDepotHandler.DepotRefreshPush.Builder data = GuildDepotHandler.DepotRefreshPush.newBuilder();
/* 1734 */       data.setS2CCode(200);
/* 1735 */       data.setType(msgData.type);
/* 1736 */       data.setBagIndex(msgData.bagIndex);
/* 1737 */       data.setLevelInfo(msgData.levelInfo);
/* 1738 */       data.setCondition(GuildCommonUtil.toHandlerDepot(msgData.condition));
/* 1739 */       this.player.receive("area.guildDepotPush.depotRefreshPush", (GeneratedMessage)data.build());
/*      */     
/*      */     }
/* 1742 */     else if (refreshType == Const.NotifyType.BLESS_FINISH_PUSH.getValue()) {
/* 1743 */       GuildBlessHandler.BlessRefreshPush.Builder blessData = GuildBlessHandler.BlessRefreshPush.newBuilder();
/* 1744 */       blessData.setS2CCode(200);
/*      */       
/* 1746 */       GuildMsg.BlessRefreshGuildMsg blessMsgData = (GuildMsg.BlessRefreshGuildMsg)msg.data;
/* 1747 */       blessData.setType(refreshType - Const.NotifyType.BLESS_PUSH_START.getValue() + 1);
/* 1748 */       if (blessMsgData.finishStateArr.length > 0) {
/* 1749 */         blessData.addAllFinishState(GuildCommonUtil.toList(blessMsgData.finishStateArr));
/* 1750 */         blessData.setBlessValue(blessMsgData.blessValue);
/*      */         
/* 1752 */         for (int i = 0; i < blessMsgData.finishStateArr.length; i++) {
/* 1753 */           if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i])
/* 1754 */             this.guildData.blessRecState[i] = blessMsgData.finishStateArr[i]; 
/*      */         } 
/*      */       } 
/* 1757 */     } else if (refreshType == Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue()) {
/*      */       
/* 1759 */       pushToClientRefreshGuild(msg);
/*      */ 
/*      */       
/* 1762 */       GuildBlessHandler.BlessRefreshPush.Builder blessData = GuildBlessHandler.BlessRefreshPush.newBuilder();
/* 1763 */       blessData.setS2CCode(200);
/* 1764 */       blessData.setType(Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue() - Const.NotifyType.BLESS_PUSH_START.getValue() + 1);
/* 1765 */       this.player.receive("area.guildBlessPush.blessRefreshPush", (GeneratedMessage)blessData.build());
/*      */ 
/*      */       
/* 1768 */       GuildShopHandler.ShopRefreshPush.Builder shopData = GuildShopHandler.ShopRefreshPush.newBuilder();
/* 1769 */       shopData.setS2CCode(200);
/* 1770 */       shopData.setType(Const.NotifyType.SHOP_NEW_DAY_PUSH.getValue() - Const.NotifyType.SHOP_PUSH_START.getValue() + 1);
/* 1771 */       this.player.receive("area.guildShopPush.shopRefreshPush", (GeneratedMessage)shopData.build());
/*      */ 
/*      */       
/* 1774 */       GuildTechHandler.GuildTechRefreshPush.Builder techData = GuildTechHandler.GuildTechRefreshPush.newBuilder();
/*      */ 
/*      */       
/* 1777 */       techData.setType(1);
/* 1778 */       this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage)techData.build());
/*      */       
/* 1780 */       pushAndRefreshGuildEffect();
/* 1781 */       clearBlessBuff();
/* 1782 */       changeBlessBuff();
/* 1783 */     } else if (refreshType == Const.NotifyType.TECH_LEVEL_PUSH.getValue()) {
/* 1784 */       GuildMsg.TechRefreshGuildMsg msgData = (GuildMsg.TechRefreshGuildMsg)msg.data;
/* 1785 */       boolean changeInfluence = this.guildTechManager.refreshTechData(msgData.techData);
/* 1786 */       if (changeInfluence) {
/* 1787 */         pushAndRefreshGuildEffect();
/* 1788 */         changeBlessBuff();
/*      */       } 
/*      */       
/* 1791 */       GuildTechHandler.GuildTechRefreshPush.Builder data = GuildTechHandler.GuildTechRefreshPush.newBuilder();
/* 1792 */       data.setS2CCode(200);
/* 1793 */       data.setType(refreshType - Const.NotifyType.TECH_PUSH_START.getValue() + 1);
/* 1794 */       data.setLevel(msgData.techData.blobData.level);
/* 1795 */       this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage)data.build());
/*      */     }
/* 1797 */     else if (refreshType == Const.NotifyType.TECH_BUFF_LEVEL_PUSH.getValue()) {
/*      */       
/* 1799 */       GuildMsg.TechRefreshGuildMsg msgData = (GuildMsg.TechRefreshGuildMsg)msg.data;
/* 1800 */       boolean changeInfluence = this.guildTechManager.refreshTechData(msgData.techData);
/* 1801 */       if (changeInfluence) {
/* 1802 */         pushAndRefreshGuildEffect();
/* 1803 */         changeBlessBuff();
/*      */       } 
/*      */       
/* 1806 */       GuildTechHandler.GuildTechRefreshPush.Builder data = GuildTechHandler.GuildTechRefreshPush.newBuilder();
/* 1807 */       data.setS2CCode(200);
/* 1808 */       data.setType(1);
/* 1809 */       this.player.receive("area.guildTechPush.guildTechRefreshPush", (GeneratedMessage)data.build());
/* 1810 */     } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_OPEN.getValue()) {
/* 1811 */       Area area = this.player.getArea();
/*      */       
/* 1813 */       GuildHandler.GuildDungeonOpenPush.Builder data = GuildHandler.GuildDungeonOpenPush.newBuilder();
/* 1814 */       if (null != area && (area.isNormal() || area.sceneType == Const.SCENE_TYPE.WORLD_BOSS.getValue())) {
/* 1815 */         data.setS2CCode(200);
/* 1816 */         this.player.receive("area.guildPush.guildDungeonOpenPush", (GeneratedMessage)data.build());
/*      */       } 
/* 1818 */     } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_PASS.getValue()) {
/* 1819 */       GuildMsg.DungeonPassGuildMsg msgData = (GuildMsg.DungeonPassGuildMsg)msg.data;
/* 1820 */       GuildHandler.GuildDungeonPassPush.Builder data = GuildHandler.GuildDungeonPassPush.newBuilder();
/* 1821 */       data.setDungeonCount(msgData.dungeonCount);
/* 1822 */       this.player.receive("area.guildPush.guildDungeonPassPush", (GeneratedMessage)data.build());
/* 1823 */     } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_PLAYER_NUM.getValue()) {
/* 1824 */       GuildMsg.DungeonPlayerNumGuildMsg msgData = (GuildMsg.DungeonPlayerNumGuildMsg)msg.data;
/* 1825 */       GuildHandler.GuildDungeonPlayerNumPush.Builder data = GuildHandler.GuildDungeonPlayerNumPush.newBuilder();
/* 1826 */       data.setS2CCode(200);
/* 1827 */       data.setPlayerNum(msgData.playerNum);
/* 1828 */       this.player.receive("area.guildPush.guildDungeonPlayerNumPush", (GeneratedMessage)data.build());
/* 1829 */     } else if (refreshType == Const.NotifyType.GUILD_DUNGEON_OPEN_CHAT.getValue()) {
/* 1830 */       GuildMsg.OnChatGuildMsg msgData = (GuildMsg.OnChatGuildMsg)msg.data;
/* 1831 */       WNPlayer player = PlayerUtil.getOnlinePlayer(msgData.playerId);
/* 1832 */       if (null == player) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/* 1837 */       MessageUtil.sendChatMsgAsyn(player, LangService.getValue("GDUNGEON_OPEN_WORDS"), Const.CHAT_SCOPE.GUILD, Const.TipsType.NORMAL);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pushToClientRefreshGuild(GuildMsg msg) {
/* 1842 */     int refreshType = msg.notifyType;
/*      */     
/* 1844 */     GuildHandler.GuildRefreshPush.Builder data = GuildHandler.GuildRefreshPush.newBuilder();
/* 1845 */     data.setS2CCode(200);
/*      */     
/* 1847 */     if (refreshType <= 0)
/*      */       return; 
/* 1849 */     if (refreshType == Const.NotifyType.GUILD_JOIN_PUSH.getValue()) {
/* 1850 */       data.setIsIn(1);
/* 1851 */     } else if (refreshType == Const.NotifyType.GUILD_EXIT_PUSH.getValue()) {
/* 1852 */       data.setIsOut(1);
/* 1853 */     } else if (refreshType == Const.NotifyType.GUILD_JOB_CHANGE.getValue()) {
/* 1854 */       GuildMsg.RefreshGuildMsg msgData = (GuildMsg.RefreshGuildMsg)msg.data;
/* 1855 */       data.setJob(msgData.job);
/* 1856 */       data.setJobName(msgData.jobName);
/* 1857 */     } else if (refreshType == Const.NotifyType.GUILD_CHANGE_NAME.getValue()) {
/* 1858 */       GuildMsg.RefreshGuildMsg msgData = (GuildMsg.RefreshGuildMsg)msg.data;
/* 1859 */       data.setGuildName(msgData.guildName);
/* 1860 */     } else if (refreshType == Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue()) {
/* 1861 */       data.addAllTimesList(getContributeTimesList());
/*      */     } 
/*      */     
/* 1864 */     this.player.receive("area.guildPush.guildRefreshPush", (GeneratedMessage)data.build());
/*      */   }
/*      */   
/*      */   public GuildResult depositEquipToDepot(int bagIndex) {
/* 1868 */     GuildResult ret = new GuildResult();
/* 1869 */     if (bagIndex < 0) {
/* 1870 */       ret.result = -1;
/* 1871 */       ret.des = "参数错误";
/* 1872 */       return ret;
/*      */     } 
/*      */     
/* 1875 */     NormalItem item = this.player.bag.getItem(bagIndex);
/* 1876 */     if (null == item) {
/* 1877 */       ret.result = -2;
/* 1878 */       ret.des = "该包裹格子没有装备错误";
/* 1879 */       return ret;
/*      */     } 
/* 1881 */     if (!item.isEquip()) {
/* 1882 */       ret.result = -4;
/* 1883 */       ret.des = "不是装备";
/* 1884 */       return ret;
/*      */     } 
/* 1886 */     if (item.isBinding()) {
/* 1887 */       ret.result = -3;
/* 1888 */       ret.des = "道具已绑定";
/* 1889 */       return ret;
/*      */     } 
/* 1891 */     if (!item.canDepotGuild()) {
/* 1892 */       ret.result = -5;
/* 1893 */       ret.des = "该道具不能存入公会仓库";
/* 1894 */       return ret;
/*      */     } 
/*      */     
/* 1897 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1898 */     if (this.guildData.depositCount >= settingProp.warehousePutIn) {
/* 1899 */       ret.result = -6;
/* 1900 */       ret.des = "今日存入次数已用完";
/* 1901 */       return ret;
/*      */     } 
/*      */     
/* 1904 */     if (item.getLevel() < settingProp.warehouseMinLv) {
/* 1905 */       ret.result = -7;
/* 1906 */       ret.des = "装备等级太低";
/* 1907 */       return ret;
/*      */     } 
/*      */     
/* 1910 */     if (item.getQLevel() < settingProp.warehouseMinQ) {
/* 1911 */       ret.result = -8;
/* 1912 */       ret.des = "装备品质太低";
/* 1913 */       return ret;
/*      */     } 
/*      */     
/* 1916 */     WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(item.getLevel(), item.getQLevel());
/* 1917 */     if (null == depositProp) {
/* 1918 */       ret.result = -9;
/* 1919 */       ret.des = "未找到该品质对应的配置";
/* 1920 */       return ret;
/*      */     } 
/*      */     
/* 1923 */     int addNum = depositProp.wareHouseValue;
/* 1924 */     PlayerItemPO itemData = item.cloneItemDB();
/* 1925 */     ret = GuildService.depotDepositEquip(this.player, itemData);
/*      */     
/* 1927 */     if (ret.result == 0) {
/* 1928 */       this.player.bag.removeItemByPos(bagIndex, false, Const.GOODS_CHANGE_TYPE.guild_store);
/* 1929 */       this.player.baseDataManager.addPawnGold(addNum);
/* 1930 */       this.player.pushDynamicData("pawnGold", Integer.valueOf(this.player.player.pawnGold));
/*      */       
/* 1932 */       ret.depositCount = ++this.guildData.depositCount;
/* 1933 */       update();
/*      */     } 
/* 1935 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void update() {
/* 1940 */     GameDao.update(this.player.getId(), ConstsTR.playerGuildTR, this.guildData);
/*      */   }
/*      */   
/*      */   public GuildResult takeOutEquipFromDepot(int depotIndex) {
/* 1944 */     GuildResult ret = new GuildResult();
/* 1945 */     if (depotIndex <= 0) {
/* 1946 */       ret.result = -1;
/* 1947 */       ret.des = "参数错误";
/* 1948 */       return ret;
/*      */     } 
/*      */     
/* 1951 */     if (!this.player.bag.testEmptyGridLarge(1)) {
/* 1952 */       ret.result = -2;
/* 1953 */       ret.des = "背包格子不够";
/* 1954 */       return ret;
/*      */     } 
/*      */     
/* 1957 */     int havePawnGold = this.player.baseDataManager.getPawnGold();
/* 1958 */     ret = GuildService.depotTakeOutEquip(this.player, depotIndex, havePawnGold);
/* 1959 */     if (ret.result == 0) {
/* 1960 */       PlayerItemPO itemData = ret.itemData;
/* 1961 */       NormalItem item = ItemUtil.createItemByDbOpts(itemData);
/* 1962 */       WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(item.getLevel(), item.getQLevel());
/* 1963 */       int costNum = depositProp.wareHouseCost;
/* 1964 */       this.player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.guild_store, null, true, false);
/* 1965 */       this.player.baseDataManager.costPawnGold(costNum);
/* 1966 */       this.player.pushDynamicData("pawnGold", Integer.valueOf(this.player.player.pawnGold));
/*      */       
/* 1968 */       update();
/*      */     } 
/* 1970 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult setDepotCondition(GuildDepotCondition condition) {
/* 1974 */     GuildResult ret = new GuildResult();
/* 1975 */     GuildCond useCond = condition.useCond;
/* 1976 */     if (0 == useCond.job || useCond.job > Const.GuildJob.MEMBER.getValue() || (0 == useCond.level && 0 == useCond.upLevel)) {
/* 1977 */       ret.result = -1;
/* 1978 */       ret.des = "参数错误";
/* 1979 */       return ret;
/*      */     } 
/*      */     
/* 1982 */     if (!GuildUtil.checkCondition(condition)) {
/* 1983 */       ret.result = -2;
/* 1984 */       ret.des = "装备品质区间不合理";
/* 1985 */       return ret;
/*      */     } 
/*      */     
/* 1988 */     ret = GuildService.depotSetCondition(this.player, condition);
/* 1989 */     if (ret.result == 0);
/* 1990 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult deleteEquipFromDepot(int depotIndex) {
/* 1994 */     GuildResult ret = new GuildResult();
/* 1995 */     if (depotIndex == 0) {
/* 1996 */       ret.result = -1;
/* 1997 */       ret.des = "参数错误";
/* 1998 */       return ret;
/*      */     } 
/*      */     
/* 2001 */     ret = GuildService.depotDeleteEquip(this.player, depotIndex);
/* 2002 */     if (ret.result == 0);
/* 2003 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult upgradeDepotLevel() {
/* 2007 */     GuildResult ret = new GuildResult();
/* 2008 */     int myGold = this.player.moneyManager.getGold();
/* 2009 */     ret = GuildService.depotUpgradeLevel(this.player, myGold);
/* 2010 */     GuildResult.DepotUpgradeLevelData data = (GuildResult.DepotUpgradeLevelData)ret.data;
/* 2011 */     if (ret.result == 0 && 
/* 2012 */       data.costGoldNum > 0) {
/* 2013 */       this.player.moneyManager.costGold(data.costGoldNum, Const.GOODS_CHANGE_TYPE.guild_upgrade_depot_level);
/* 2014 */       update();
/*      */     } 
/*      */     
/* 2017 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GuildBlessHandler.MyBlessInfo getMyBlessInfo() {
/* 2026 */     GuildBlessHandler.MyBlessInfo.Builder data = GuildBlessHandler.MyBlessInfo.newBuilder();
/* 2027 */     data.setBlessCount(this.guildData.blessCount);
/*      */     
/* 2029 */     List<Map<String, Integer>> buffAttrs = GuildUtil.getBlessBuffAttrsList(this.guildData.buffIds);
/* 2030 */     if (null != buffAttrs) {
/* 2031 */       data.addAllBlessAttrs(AttributeUtil.getAttributeBaseByArray(buffAttrs));
/*      */     }
/* 2033 */     data.setBuffTime(this.guildData.buffTime);
/* 2034 */     data.addAllReceiveState(GuildCommonUtil.toList(this.guildData.blessRecState));
/* 2035 */     GuildBlessPO blessPO = GuildBlessCenter.getInstance().getBlessData(getGuildId());
/*      */     
/* 2037 */     List<GuildBlessHandler.BlessItem> itemList = new ArrayList<>();
/* 2038 */     for (int i = 0; i < blessPO.gifts.size(); i++) {
/* 2039 */       Map<String, Integer> ls = blessPO.gifts.get(i);
/* 2040 */       GuildBlessHandler.BlessItem.Builder tempInfo = GuildBlessHandler.BlessItem.newBuilder();
/* 2041 */       List<ItemOuterClass.MiniItem> items = new ArrayList<>();
/* 2042 */       for (String key : ls.keySet()) {
/* 2043 */         ItemOuterClass.MiniItem.Builder tmpItem = ItemUtil.getMiniItemData(key, 1);
/* 2044 */         if (null == tmpItem) {
/* 2045 */           Out.error(new Object[] { "GuildBless toJson4PayLoad config is null:", key });
/*      */           continue;
/*      */         } 
/* 2048 */         tmpItem.setGroupCount(((Integer)ls.get(key)).intValue());
/* 2049 */         items.add(tmpItem.build());
/*      */       } 
/* 2051 */       tempInfo.addAllItem(items);
/* 2052 */       itemList.add(tempInfo.build());
/*      */     } 
/* 2054 */     data.addAllItemList(itemList);
/* 2055 */     return data.build();
/*      */   }
/*      */   
/*      */   public GuildResult blessAction(int id, int times) {
/* 2059 */     GuildResult ret = new GuildResult();
/* 2060 */     BlessItemCO blessItemProp = GuildUtil.getBlessItemById(id);
/* 2061 */     if (null == blessItemProp) {
/* 2062 */       ret.result = -1;
/* 2063 */       ret.des = "参数错误";
/* 2064 */       return ret;
/*      */     } 
/* 2066 */     String itemCode = blessItemProp.itemID;
/* 2067 */     int haveItemNum = this.player.bag.findItemNumByCode(itemCode);
/* 2068 */     if (haveItemNum < times) {
/* 2069 */       ret.result = -2;
/* 2070 */       ret.des = "材料不足";
/* 2071 */       return ret;
/*      */     } 
/*      */     
/* 2074 */     ret = GuildService.blessAction(this.player, id, this.guildData.blessCount, times);
/*      */     
/* 2076 */     if (ret.result == 0) {
/* 2077 */       this.guildData.blessCount += times;
/* 2078 */       this.player.bag.discardItem(itemCode, times, Const.GOODS_CHANGE_TYPE.guild_bless, null, false, false);
/* 2079 */       (getMiscData()).guildBlessToday = 1;
/* 2080 */       GuildResult.GuildBlessActionData data = (GuildResult.GuildBlessActionData)ret.data;
/* 2081 */       data.blessCount = this.guildData.blessCount;
/*      */       
/* 2083 */       this.guildData.buffIds.clear();
/* 2084 */       this.guildData.buffTime = data.buffTime;
/* 2085 */       this.guildData.buffIds = data.buffIds;
/* 2086 */       for (int i = 0; i < data.finishState.length; i++) {
/* 2087 */         if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.guildData.blessRecState[i]) {
/* 2088 */           this.guildData.blessRecState[i] = data.finishState[i];
/*      */         }
/*      */       } 
/*      */       
/* 2092 */       GuildBless bless = GuildBlessCenter.getInstance().getBless(this.guild.id);
/* 2093 */       if (null != bless) {
/* 2094 */         BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.blessLevel);
/* 2095 */         if (blessLevelExt != null) {
/*      */ 
/*      */           
/* 2098 */           this.guild.fund += ((BlessLevelCO)blessLevelExt).addGuildFunds;
/* 2099 */           this.guild.sumFund += ((BlessLevelCO)blessLevelExt).addGuildFunds;
/* 2100 */           Out.info(new Object[] { "添加仙盟基金 guildId=", this.guild.id, ", fund=", Integer.valueOf(((BlessLevelCO)blessLevelExt).addGuildFunds) });
/* 2101 */           GuildServiceCenter.getInstance().saveGuild(this.guild);
/*      */ 
/*      */           
/* 2104 */           this.player.guildManager.addContribution(((BlessLevelCO)blessLevelExt).addGuildPoints, Const.GOODS_CHANGE_TYPE.guild_bless);
/* 2105 */           this.player.guildManager.addTotalContribution(this.guild.id, ((BlessLevelCO)blessLevelExt).addGuildPoints);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2110 */       pushRedPoint();
/* 2111 */       startTimer();
/* 2112 */       changeBlessBuff();
/* 2113 */       update();
/*      */     } 
/* 2115 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult receiveBlessGift(int index) {
/* 2119 */     GuildResult ret = new GuildResult();
/* 2120 */     if (index < 0 && index >= 2) {
/* 2121 */       ret.result = -10;
/* 2122 */       ret.des = "参数错误";
/* 2123 */       return ret;
/*      */     } 
/*      */     
/* 2126 */     if (this.guildData.blessRecState[index] == Const.EVENT_GIFT_STATE.RECEIVED.getValue()) {
/* 2127 */       ret.result = -1;
/* 2128 */       ret.des = "已领取";
/* 2129 */       return ret;
/*      */     } 
/*      */     
/* 2132 */     if (!this.player.bag.testEmptyGridLarge(1)) {
/* 2133 */       ret.result = -2;
/* 2134 */       ret.des = "背包格子不够";
/* 2135 */       return ret;
/*      */     } 
/*      */     
/* 2138 */     ret = GuildService.receiveBlessGift(this.player, index);
/* 2139 */     if (ret.result == 0) {
/*      */       
/* 2141 */       GuildResult.GuildGiftAndBuffData gift = (GuildResult.GuildGiftAndBuffData)ret.data;
/* 2142 */       List<NormalItem> list_items = ItemUtil.createItemsByItemCode(gift.itemCode);
/* 2143 */       this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.guild_bless_award, "Bag_full_common");
/* 2144 */       this.guildData.blessRecState[index] = Const.EVENT_GIFT_STATE.RECEIVED.getValue();
/* 2145 */       gift.receiveState = GuildCommonUtil.toList(this.guildData.blessRecState);
/* 2146 */       update();
/* 2147 */       pushRedPoint();
/*      */     } 
/* 2149 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildResult upgradeBlessLevel() {
/* 2153 */     GuildResult ret = new GuildResult();
/* 2154 */     int haveGold = this.player.moneyManager.getGold();
/* 2155 */     ret = GuildService.upgradeBlessLevel(this.player, haveGold);
/* 2156 */     GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel)ret.data;
/* 2157 */     if (ret.result == 0 && 
/* 2158 */       data.needGold > 0) {
/* 2159 */       this.player.moneyManager.costGold(data.needGold, Const.GOODS_CHANGE_TYPE.guild_upgrade_bless_level);
/* 2160 */       update();
/*      */     } 
/*      */     
/* 2163 */     return ret;
/*      */   }
/*      */   
/*      */   public GuildDungeonResult joinGuildDungeon(Area area, int type) {
/* 2167 */     GuildDungeonResult data = new GuildDungeonResult();
/* 2168 */     data.type = 0;
/* 2169 */     if (!area.isNormal() && area.getSceneType() != Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && area.getSceneType() != Const.SCENE_TYPE.WORLD_BOSS.getValue()) {
/* 2170 */       data.result = false;
/* 2171 */       data.info = LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
/* 2172 */       return data;
/*      */     } 
/*      */     
/* 2175 */     if (!getGuildId().equals(this.guildData.joinDungeonGuildId) && DateUtil.isSameDay(new Date(), this.guildData.joinDungeonTime)) {
/* 2176 */       data.result = false;
/* 2177 */       data.info = LangService.getValue("GDUNGEON_NO_TIMES");
/* 2178 */       return data;
/*      */     } 
/*      */     
/* 2181 */     GuildService.joinGuildDungeon(this.player.getId(), this.player.getLevel());
/*      */     
/* 2183 */     if (LangService.getValue("GDUNGEON_ENTER_ERROR").equals(data.info)) {
/* 2184 */       if (type == 0) {
/* 2185 */         data.result = true;
/* 2186 */         data.type = 1;
/*      */       } 
/* 2188 */       return data;
/*      */     } 
/*      */     
/* 2191 */     if (!data.result) {
/* 2192 */       return data;
/*      */     }
/*      */     
/* 2195 */     if (area.getSceneType() == Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && area.areaId == data.dungeonId) {
/*      */       
/* 2197 */       data.result = false;
/* 2198 */       data.info = LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
/* 2199 */       return data;
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
/* 2235 */     return data;
/*      */   }
/*      */   
/*      */   public GuildDungeonResult leaveDungeon(WNPlayer player) {
/* 2239 */     GuildDungeonResult data = new GuildDungeonResult();
/* 2240 */     data.result = true;
/* 2241 */     data.info = "";
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
/* 2259 */     return data;
/*      */   }
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 2263 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 2264 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 2265 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILD.getValue());
/* 2266 */     data.setNumber(0);
/* 2267 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.GUILD.getValue())) {
/* 2268 */       list.add(data.build());
/* 2269 */       return list;
/*      */     } 
/* 2271 */     if (!isInGuild()) {
/* 2272 */       list.add(data.build());
/* 2273 */       return list;
/*      */     } 
/* 2275 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(this.member.job);
/* 2276 */     if (null == jobProp) {
/* 2277 */       list.add(data.build());
/* 2278 */       return list;
/*      */     } 
/* 2280 */     if (jobProp.right3 > 0) {
/* 2281 */       int applyCount = GuildUtil.getGuildApplyCount(getGuildId());
/* 2282 */       if (applyCount > 0) {
/* 2283 */         int tmp = data.getNumber();
/* 2284 */         data.setNumber(tmp + 1);
/*      */       } 
/*      */     } 
/*      */     
/* 2288 */     if (null != this.guildData.blessRecState) {
/* 2289 */       for (int i = 0; i < this.guildData.blessRecState.length; i++) {
/* 2290 */         if (this.guildData.blessRecState.length > i)
/*      */         {
/*      */           
/* 2293 */           if (this.guildData.blessRecState[i] != Const.EVENT_GIFT_STATE.RECEIVED.getValue()) {
/* 2294 */             int tmp = data.getNumber();
/* 2295 */             data.setNumber(tmp + 1);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/* 2300 */     if (this.throwAwardState > 0) {
/* 2301 */       int tmp = data.getNumber();
/* 2302 */       data.setNumber(tmp + 1);
/*      */     } 
/*      */     
/* 2305 */     return list;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setJoinDungeonGuildId(String guildId) {
/* 2310 */     if (!this.guildData.joinDungeonGuildId.equals(guildId)) {
/* 2311 */       this.guildData.joinDungeonGuildId = guildId;
/*      */     }
/*      */     
/* 2314 */     Date now = new Date();
/* 2315 */     if (!DateUtil.isSameDay(now, this.guildData.joinDungeonTime)) {
/* 2316 */       this.guildData.joinDungeonTime = now;
/*      */     }
/*      */   }
/*      */   
/*      */   public String getGuildId() {
/* 2321 */     return (this.guild != null) ? this.guild.id : "";
/*      */   }
/*      */   
/*      */   public String getGuildIcon() {
/* 2325 */     return (this.guild != null) ? this.guild.icon : "";
/*      */   }
/*      */   
/*      */   public void setGuildJobInfo(String guildId, String guildName, int guildJob, String guildIcon) {
/* 2329 */     if (null == this.guild) {
/* 2330 */       this.guild = new GuildPO();
/*      */     }
/* 2332 */     if (null == this.member) {
/* 2333 */       this.member = new GuildMemberPO();
/*      */     }
/* 2335 */     this.guild.id = guildId;
/* 2336 */     this.guild.name = guildName;
/* 2337 */     this.guild.icon = guildIcon;
/* 2338 */     this.guild.job = guildJob;
/* 2339 */     this.member.job = guildJob;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int calAuctionBonus() {
/* 2346 */     if (StringUtils.isEmpty(getGuildId())) {
/* 2347 */       return 0;
/*      */     }
/* 2349 */     Set<String> ids = GuildUtil.getGuildMemberIdList(getGuildId());
/* 2350 */     if (ids == null || ids.isEmpty()) {
/* 2351 */       return 0;
/*      */     }
/*      */     
/* 2354 */     return Math.min(GlobalConfig.Auction_MaxBonus, this.guild.auctionBonus / ids.size());
/*      */   }
/*      */   
/*      */   public void addAuctionBonus(int value) {
/* 2358 */     if (this.guild == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2363 */     value = value * GlobalConfig.Auction_GuildTaxation / 100;
/*      */     
/* 2365 */     int before = this.guild.auctionBonus;
/* 2366 */     this.guild.auctionBonus += value;
/* 2367 */     int after = this.guild.auctionBonus;
/* 2368 */     Out.info(new Object[] { "add auction bonus. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(value), ",after=", Integer.valueOf(after) });
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */