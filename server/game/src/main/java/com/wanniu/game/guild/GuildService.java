/*      */ package com.wanniu.game.guild;
/*      */ 
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.wanniu.core.db.GCache;
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.data.BlessLevelCO;
/*      */ import com.wanniu.game.data.GBuffCO;
/*      */ import com.wanniu.game.data.GDungeonCO;
/*      */ import com.wanniu.game.data.GDungeonMapCO;
/*      */ import com.wanniu.game.data.GDungeonRankCO;
/*      */ import com.wanniu.game.data.GTechnologyLevelCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.GuildBuildingCO;
/*      */ import com.wanniu.game.data.GuildContributeCO;
/*      */ import com.wanniu.game.data.GuildLevelCO;
/*      */ import com.wanniu.game.data.GuildPositionCO;
/*      */ import com.wanniu.game.data.WareHouseLevelCO;
/*      */ import com.wanniu.game.data.WareHouseValueCO;
/*      */ import com.wanniu.game.data.base.DItemEquipBase;
/*      */ import com.wanniu.game.data.ext.BlessLevelExt;
/*      */ import com.wanniu.game.data.ext.GBuffExt;
/*      */ import com.wanniu.game.data.ext.GuildSettingExt;
/*      */ import com.wanniu.game.data.ext.RankRewardExt;
/*      */ import com.wanniu.game.guild.dao.GuildDao;
/*      */ import com.wanniu.game.guild.guidDepot.GuildCond;
/*      */ import com.wanniu.game.guild.guidDepot.GuildDepot;
/*      */ import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
/*      */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*      */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*      */ import com.wanniu.game.guild.guildBless.GuildBless;
/*      */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*      */ import com.wanniu.game.guild.guildBoss.GuildBossCenter;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDiceAwardResult;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonAward;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonPlayerInfo;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonRecord;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
/*      */ import com.wanniu.game.guild.guildDungeon.GuildDungeonThrowInfo;
/*      */ import com.wanniu.game.guild.guildDungeon.OpenGuildDungeonResult;
/*      */ import com.wanniu.game.guild.guildImpeach.GuildImpeachCenter;
/*      */ import com.wanniu.game.guild.guildImpeach.GuildImpeachData;
/*      */ import com.wanniu.game.guild.guildTech.GuildTech;
/*      */ import com.wanniu.game.guild.po.GuildBlessPO;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.po.PlayerItemPO;
/*      */ import com.wanniu.game.mail.MailUtil;
/*      */ import com.wanniu.game.mail.data.MailData;
/*      */ import com.wanniu.game.mail.data.MailSysData;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.GuildApplyPO;
/*      */ import com.wanniu.game.poes.GuildDungeonPO;
/*      */ import com.wanniu.game.poes.GuildMemberPO;
/*      */ import com.wanniu.game.poes.GuildPO;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import io.netty.util.internal.StringUtil;
/*      */ import java.text.MessageFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.UUID;
/*      */ import pomelo.area.GuildHandler;
/*      */ import pomelo.guild.GuildManagerHandler;
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
/*      */ public class GuildService
/*      */ {
/*      */   public static void notifySomePlayerRefreshGuild(Set<String> playerIds, GuildMsg data, String exceptId) {
/*  110 */     for (String playerId : playerIds) {
/*  111 */       WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/*  112 */       if (null == player || playerId.equals(exceptId)) {
/*      */         continue;
/*      */       }
/*  115 */       player.guildManager.onNotifyRefreshGuild(data);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void notifyAllMemberRefreshGuild(String guildId, GuildMsg data, String exceptId) {
/*  120 */     Set<String> playerIds = GuildServiceCenter.getInstance().getGuildMemberIdList(guildId);
/*  121 */     if (null == playerIds)
/*      */       return; 
/*  123 */     notifySomePlayerRefreshGuild(playerIds, data, exceptId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GuildResult createGuild(WNPlayer player, JSONObject param) {
/*  133 */     GuildResult ret = new GuildResult();
/*  134 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/*  135 */     if (null == prop) {
/*  136 */       ret.result = -1;
/*  137 */       return ret;
/*      */     } 
/*      */     
/*  140 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/*  141 */     if (guildServiceMgr.isInGuild(player.getId())) {
/*  142 */       ret.result = -2;
/*  143 */       ret.des = "已入会";
/*  144 */       return ret;
/*      */     } 
/*      */     
/*  147 */     if (StringUtil.isNullOrEmpty(param.getString("name"))) {
/*      */       
/*  149 */       ret.result = -11;
/*  150 */       ret.des = LangService.getValue("GUILD_NAME_EMPTY");
/*  151 */       return ret;
/*      */     } 
/*      */     
/*  154 */     boolean isNameExist = guildServiceMgr.existGuildName(GWorld.__SERVER_ID, param.getString("name"));
/*  155 */     if (isNameExist) {
/*  156 */       ret.result = 1;
/*  157 */       ret.des = "名字已存在";
/*  158 */       return ret;
/*      */     } 
/*      */     
/*  161 */     String guildId = UUID.randomUUID().toString();
/*  162 */     GuildPO guild = new GuildPO();
/*  163 */     guild.id = guildId;
/*  164 */     guild.logicServerId = player.getLogicServerId();
/*  165 */     guild.icon = param.getString("icon");
/*  166 */     guild.name = param.getString("name");
/*  167 */     guild.presidentId = player.getId();
/*  168 */     guild.presidentPro = player.getPro();
/*  169 */     guild.presidentName = player.getName();
/*      */ 
/*      */     
/*  172 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.GUILD.getValue());
/*  173 */     guild.level = buildProp.minLv;
/*  174 */     guild.createTime = new Date();
/*  175 */     guild.qqGroup = param.getString("qqGroup");
/*  176 */     guild.fund = 0L;
/*  177 */     guild.sumFund = 0L;
/*  178 */     guild.exp = 0L;
/*      */     
/*  180 */     guild.entryLevel = prop.joinLv;
/*  181 */     guild.entryUpLevel = 0;
/*  182 */     guild.guildMode = Const.GuildMode.AUTO_MODE.getValue();
/*  183 */     guild.notice = prop.defaultNote;
/*  184 */     guild.changeNameTime = new Date();
/*  185 */     guild.kickCount = 0;
/*  186 */     guild.kickTime = new Date();
/*  187 */     guild.officeNames = GuildUtil.getJobNameMap();
/*  188 */     guild.allBlobData = new GuildAllBlob();
/*      */     
/*  190 */     GuildMemberPO member = player.toJSON4GuildMember();
/*  191 */     member.guildId = guildId;
/*      */     
/*  193 */     member.job = Const.GuildJob.PRESIDENT.getValue();
/*  194 */     member.createTime = new Date();
/*      */     
/*  196 */     guildServiceMgr.addGuild(guild);
/*  197 */     guildServiceMgr.addMember(member);
/*  198 */     guildServiceMgr.removeAllPlayerApplyAsync(player.getId());
/*      */     
/*  200 */     GuildDepotCenter.getInstance().createDepot(guildId, player.getLogicServerId());
/*  201 */     GuildBlessCenter.getInstance().createBless(guildId, player.getLogicServerId());
/*  202 */     guildServiceMgr.refreshGuildTopInfo(guildId);
/*      */     
/*  204 */     GuildRecordData record = new GuildRecordData();
/*  205 */     record.type = Const.GuildRecord.CREATE_GUILD.getValue();
/*  206 */     record.role1.pro = guild.presidentPro;
/*  207 */     record.role1.name = guild.presidentName;
/*      */     
/*  209 */     guildServiceMgr.addGuildRecord(guild.id, record);
/*      */     
/*  211 */     ret.result = 0;
/*  212 */     ret.id = guildId;
/*  213 */     return ret;
/*      */   }
/*      */   
/*      */   public static String getGuildId(String playerId) {
/*  217 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  218 */     return guildManager.getGuildId(playerId);
/*      */   }
/*      */   
/*      */   public static GuildResult joinGuild(WNPlayer player, String guildId) {
/*  222 */     GuildResult ret = new GuildResult();
/*  223 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  224 */     boolean isInGuild = guildManager.isInGuild(player.getId());
/*  225 */     if (isInGuild) {
/*  226 */       ret.result = -2;
/*  227 */       ret.des = "已入会";
/*  228 */       return ret;
/*      */     } 
/*      */     
/*  231 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  232 */     if (null == settingProp) {
/*  233 */       ret.result = -1;
/*  234 */       ret.des = "配置错误";
/*  235 */       return ret;
/*      */     } 
/*      */     
/*  238 */     List<GuildApplyPO> applyList = guildManager.getPlayerApplyList(player.getId());
/*  239 */     if (null != applyList && applyList.size() >= settingProp.applyMax) {
/*  240 */       ret.result = 1;
/*  241 */       ret.des = "申请数量已达上限";
/*  242 */       return ret;
/*      */     } 
/*      */     
/*  245 */     for (GuildApplyPO apply : applyList) {
/*  246 */       if (apply.id == guildId) {
/*  247 */         ret.result = 4;
/*  248 */         ret.des = "已申请";
/*  249 */         return ret;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  254 */     GuildPO guild = guildManager.getGuild(guildId);
/*  255 */     if (null == guild) {
/*  256 */       ret.result = 2;
/*  257 */       ret.des = "公会不存在";
/*  258 */       return ret;
/*      */     } 
/*      */     
/*  261 */     GuildLevelCO guildLevelProp = GuildUtil.getGuildLevelPropByLevel(guild.level);
/*  262 */     if (null == guildLevelProp) {
/*  263 */       ret.result = -1;
/*  264 */       ret.des = "配置错误";
/*  265 */       return ret;
/*      */     } 
/*      */     
/*  268 */     Set<String> memberList = guildManager.getGuildMemberIdList(guildId);
/*  269 */     if (memberList.size() >= guildLevelProp.member) {
/*  270 */       ret.result = 3;
/*  271 */       ret.des = "公会人数已满";
/*  272 */       return ret;
/*      */     } 
/*      */     
/*  275 */     if (guild.guildMode == Const.GuildMode.AUTO_MODE.getValue()) {
/*  276 */       GuildMemberPO newMember = player.toJSON4GuildMember();
/*  277 */       newMember.guildId = guildId;
/*  278 */       newMember.job = Const.GuildJob.MEMBER.getValue();
/*  279 */       newMember.createTime = new Date();
/*  280 */       newMember.lastContributeValue = 0L;
/*      */       
/*  282 */       player.guildManager.setGuildJobInfo(guildId, guild.name, Const.GuildJob.MEMBER.getValue(), guild.icon);
/*      */ 
/*      */       
/*  285 */       GuildRecordData record = new GuildRecordData();
/*  286 */       record.type = Const.GuildRecord.JOIN.getValue();
/*  287 */       record.role1 = new RoleInfo();
/*  288 */       record.role1.pro = newMember.pro;
/*  289 */       record.role1.name = newMember.name;
/*  290 */       guildManager.addGuildRecord(guild.id, record);
/*  291 */       guildManager.addMember(newMember);
/*  292 */       guildManager.removeAllPlayerApplyAsync(newMember.playerId);
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
/*  305 */       Set<String> ids = new HashSet<>();
/*  306 */       ids.add(newMember.playerId);
/*      */       
/*  308 */       GuildMsg.JoinGuildBlessMsg msgData = new GuildMsg.JoinGuildBlessMsg();
/*  309 */       msgData.blessData = GuildBlessCenter.getInstance().getBlessData(guild.id);
/*      */       
/*  311 */       GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOIN_PUSH.getValue(), msgData);
/*  312 */       msg.data = msgData;
/*      */       
/*  314 */       notifySomePlayerRefreshGuild(ids, msg, null);
/*      */       
/*  316 */       guildManager.refreshGuildTopInfo(guildId);
/*  317 */       ret.result = 0;
/*  318 */       ret.joined = true;
/*  319 */       ret.des = "加入成功";
/*  320 */       ret.memberId = player.getId();
/*  321 */       player.auctionManager.pushScript();
/*  322 */       return ret;
/*      */     } 
/*  324 */     String applyId = UUID.randomUUID().toString();
/*  325 */     GuildApplyPO applyInfo = new GuildApplyPO();
/*  326 */     applyInfo.id = applyId;
/*  327 */     applyInfo.guildId = guildId;
/*  328 */     applyInfo.playerId = player.getId();
/*  329 */     applyInfo.createTime = new Date();
/*      */     
/*  331 */     guildManager.addApply(applyInfo);
/*      */     
/*  333 */     ret.result = 0;
/*  334 */     ret.joined = false;
/*  335 */     ret.des = "申请成功";
/*  336 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildResult dealApply(WNPlayer player, String applyId, int operate) {
/*  341 */     GuildResult ret = new GuildResult();
/*  342 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  343 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  344 */     if (null == myInfo) {
/*  345 */       ret.result = -1;
/*  346 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  347 */       return ret;
/*      */     } 
/*      */     
/*  350 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  351 */     if (null == myGuild) {
/*  352 */       ret.result = -1;
/*  353 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  354 */       return ret;
/*      */     } 
/*      */     
/*  357 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  358 */     if (null == jobProp || jobProp.right3 == 0) {
/*  359 */       ret.result = -2;
/*  360 */       ret.des = "没有权限";
/*  361 */       return ret;
/*      */     } 
/*      */     
/*  364 */     int memberNum = guildManager.getGuildMemberCount(myGuild.id);
/*  365 */     GuildLevelCO guildLevelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
/*  366 */     if (operate != 0 && operate != 2 && 
/*  367 */       memberNum >= guildLevelProp.member) {
/*  368 */       ret.result = -3;
/*  369 */       ret.des = "公会人数已满";
/*  370 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/*  374 */     List<GuildApplyPO> applyList = new ArrayList<>();
/*  375 */     if (operate >= 2) {
/*  376 */       applyList = guildManager.getGuildApplyList(myGuild.id);
/*  377 */       if (applyList.size() == 0) {
/*  378 */         ret.result = 0;
/*  379 */         ret.des = "success";
/*  380 */         return ret;
/*      */       } 
/*      */     } else {
/*  383 */       GuildApplyPO oneApply = guildManager.getApply(applyId);
/*  384 */       if (null == oneApply) {
/*  385 */         ret.result = -4;
/*  386 */         ret.des = "申请已处理或已过期";
/*  387 */         return ret;
/*      */       } 
/*  389 */       applyList.add(oneApply);
/*      */     } 
/*      */     
/*  392 */     applyList.sort((applyA, applyB) -> {
/*      */           long detaTime = applyA.createTime.getTime() - applyB.createTime.getTime();
/*      */           
/*      */           return (detaTime > 0L) ? -1 : 1;
/*      */         });
/*  397 */     int leftHole = guildLevelProp.member - memberNum;
/*  398 */     int count = 0;
/*      */     
/*  400 */     GuildBlessPO data = GuildBlessCenter.getInstance().getBlessData(myGuild.id);
/*  401 */     String guildName = myGuild.name;
/*  402 */     for (int i = 0; i < applyList.size(); i++) {
/*  403 */       GuildApplyPO apply = applyList.get(i);
/*  404 */       if (operate == 0 || operate == 2) {
/*  405 */         MailSysData mailData = new MailSysData("Guild_apply_refused");
/*  406 */         mailData.replace = new HashMap<>();
/*  407 */         mailData.replace.put("guildName", guildName);
/*  408 */         MailUtil.getInstance().sendMailToOnePlayer(apply.playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*  409 */         guildManager.removeApply(apply.id);
/*      */       } else {
/*  411 */         if (count >= leftHole) {
/*      */           break;
/*      */         }
/*  414 */         if (!guildManager.isInGuild(apply.playerId)) {
/*      */ 
/*      */ 
/*      */           
/*  418 */           PlayerPO po = PlayerUtil.getPlayerBaseData(apply.playerId);
/*  419 */           GuildMemberPO newMember = new GuildMemberPO();
/*  420 */           newMember.playerId = apply.playerId;
/*  421 */           newMember.name = po.name;
/*  422 */           newMember.pro = po.pro;
/*  423 */           newMember.guildId = apply.guildId;
/*  424 */           newMember.job = Const.GuildJob.MEMBER.getValue();
/*  425 */           newMember.createTime = new Date();
/*  426 */           newMember.lastContributeTime = new Date(0L);
/*  427 */           newMember.lastContributeValue = 0L;
/*      */           
/*  429 */           WNPlayer newPlayer = PlayerUtil.getOnlinePlayer(apply.playerId);
/*  430 */           if (null != newPlayer) {
/*  431 */             newPlayer.guildManager.setGuildJobInfo(apply.guildId, guildName, Const.GuildJob.MEMBER.getValue(), myGuild.icon);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  436 */           GuildRecordData record = new GuildRecordData();
/*  437 */           record.type = Const.GuildRecord.JOIN.getValue();
/*  438 */           record.role1.pro = newMember.pro;
/*  439 */           record.role1.name = newMember.name;
/*      */           
/*  441 */           guildManager.addGuildRecord(myGuild.id, record);
/*  442 */           guildManager.addMember(newMember);
/*  443 */           guildManager.removeAllPlayerApplyAsync(apply.playerId);
/*  444 */           guildManager.removeApply(apply.id);
/*      */           
/*  446 */           GuildMsg.JoinGuildBlessMsg msgData = new GuildMsg.JoinGuildBlessMsg();
/*  447 */           msgData.blessData = data;
/*  448 */           GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOIN_PUSH.getValue(), msgData);
/*  449 */           Set<String> ids = new HashSet<>();
/*  450 */           ids.add(newMember.playerId);
/*      */           
/*  452 */           notifySomePlayerRefreshGuild(ids, msg, null);
/*  453 */           count++;
/*      */           
/*  455 */           MailSysData mailData = new MailSysData("Guild_join");
/*  456 */           mailData.replace = new TreeMap<>();
/*  457 */           mailData.replace.put("guildName", guildName);
/*  458 */           MailUtil.getInstance().sendMailToOnePlayer(apply.playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  463 */     guildManager.refreshGuildTopInfo(myGuild.id);
/*  464 */     ret.result = 0;
/*  465 */     ret.des = "success";
/*  466 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult setGuildInfo(WNPlayer player, GuildSetData param) {
/*  470 */     GuildResult ret = new GuildResult();
/*  471 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  472 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  473 */     if (null == myInfo) {
/*  474 */       ret.result = -2;
/*  475 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  476 */       return ret;
/*      */     } 
/*      */     
/*  479 */     GuildPO guild = guildManager.getGuild(myInfo.guildId);
/*  480 */     if (null == guild) {
/*  481 */       ret.result = -2;
/*  482 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  483 */       return ret;
/*      */     } 
/*      */     
/*  486 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  487 */     if (null == jobProp || jobProp.right5 == 0) {
/*  488 */       ret.result = -3;
/*  489 */       ret.des = "没有权限";
/*      */     } 
/*      */     
/*  492 */     if (param.entryUpLevel == 0) {
/*  493 */       guild.entryLevel = param.entryUpLevel;
/*      */     }
/*  495 */     if (param.entryLevel > 0) {
/*  496 */       guild.entryLevel = param.entryLevel;
/*      */     }
/*  498 */     if (param.guildMode > 0) {
/*  499 */       guild.guildMode = param.guildMode;
/*      */     }
/*      */     
/*  502 */     guildManager.saveGuild(guild);
/*  503 */     ret.result = 0;
/*  504 */     ret.des = "success";
/*  505 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult setGuildQQGroup(WNPlayer player, String qqGroup) {
/*  509 */     GuildResult ret = new GuildResult();
/*  510 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  511 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  512 */     if (null == myInfo) {
/*  513 */       ret.result = -3;
/*  514 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  515 */       return ret;
/*      */     } 
/*      */     
/*  518 */     GuildPO guild = guildManager.getGuild(myInfo.guildId);
/*  519 */     if (null == guild) {
/*  520 */       ret.result = -3;
/*  521 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  522 */       return ret;
/*      */     } 
/*  524 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  525 */     if (null == jobProp || jobProp.right7 == 0) {
/*  526 */       ret.result = -4;
/*  527 */       ret.des = "没有权限";
/*  528 */       return ret;
/*      */     } 
/*      */     
/*  531 */     guild.qqGroup = qqGroup;
/*  532 */     guildManager.saveGuild(guild);
/*  533 */     ret.result = 0;
/*  534 */     ret.des = "success";
/*  535 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult exitGuild(WNPlayer player) {
/*  539 */     GuildResult ret = new GuildResult();
/*  540 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  541 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  542 */     if (null == myInfo) {
/*  543 */       ret.result = 1;
/*  544 */       return ret;
/*      */     } 
/*      */     
/*  547 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  548 */     if (null == myGuild) {
/*  549 */       ret.result = 1;
/*  550 */       return ret;
/*      */     } 
/*      */     
/*  553 */     if (GuildBossCenter.getInstance().isOpen()) {
/*  554 */       ret.result = -1;
/*  555 */       ret.des = LangService.getValue("GUILD_BOSS_IN");
/*  556 */       return ret;
/*      */     } 
/*      */     
/*  559 */     if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
/*  560 */       int count = GuildUtil.getGuildMemberCount(myInfo.guildId);
/*  561 */       if (1 == count) {
/*      */ 
/*      */         
/*  564 */         GuildRecordData guildRecordData = new GuildRecordData();
/*  565 */         guildRecordData.type = Const.GuildRecord.EXIT.getValue();
/*  566 */         guildRecordData.role1.pro = myInfo.pro;
/*  567 */         guildRecordData.role1.name = myInfo.name;
/*  568 */         guildManager.addGuildRecord(myGuild.id, guildRecordData);
/*  569 */         guildManager.removeMember(myInfo.playerId);
/*      */         
/*  571 */         guildManager.refreshGuildTopInfo(myGuild.id);
/*  572 */         ret.result = 0;
/*  573 */         ret.id = myGuild.id;
/*  574 */         ret.name = myGuild.name;
/*      */         
/*  576 */         GuildUtil.removeGuild(myGuild);
/*  577 */         return ret;
/*      */       } 
/*      */       
/*  580 */       ret.result = 2;
/*  581 */       return ret;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  586 */     GuildRecordData record = new GuildRecordData();
/*  587 */     record.type = Const.GuildRecord.EXIT.getValue();
/*  588 */     record.role1.pro = myInfo.pro;
/*  589 */     record.role1.name = myInfo.name;
/*  590 */     guildManager.addGuildRecord(myGuild.id, record);
/*  591 */     guildManager.removeMember(myInfo.playerId);
/*      */     
/*  593 */     guildManager.refreshGuildTopInfo(myGuild.id);
/*  594 */     ret.result = 0;
/*  595 */     ret.id = myGuild.id;
/*  596 */     ret.name = myGuild.name;
/*  597 */     player.auctionManager.pushScript();
/*  598 */     return ret;
/*      */   }
/*      */   
/*      */   public static String get1stMemeberId(String guildId, String selfId) {
/*  602 */     List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildId);
/*  603 */     List<GuildHandler.MemberInfo> list = new ArrayList<>();
/*  604 */     for (GuildMemberPO member : memberList) {
/*  605 */       PlayerPO playerBase = PlayerUtil.getPlayerBaseData(member.playerId);
/*  606 */       if (null == playerBase) {
/*      */         continue;
/*      */       }
/*      */       
/*  610 */       GuildHandler.MemberInfo.Builder tempInfo = GuildHandler.MemberInfo.newBuilder();
/*  611 */       tempInfo.setPlayerId(member.playerId);
/*  612 */       tempInfo.setJob(member.job);
/*  613 */       tempInfo.setJoinTime(member.createTime.toString());
/*  614 */       tempInfo.setLevel(playerBase.level);
/*  615 */       tempInfo.setUpLevel(playerBase.upLevel);
/*  616 */       boolean isOnline = PlayerUtil.isOnline(member.playerId);
/*  617 */       tempInfo.setOnlineState(isOnline ? 1 : 0);
/*  618 */       tempInfo.setLastActiveTime((int)Math.ceil((playerBase.logoutTime.getTime() / Const.Time.Second.getValue())));
/*  619 */       if (!member.playerId.equals(selfId)) {
/*  620 */         list.add(tempInfo.build());
/*      */       }
/*      */     } 
/*      */     
/*  624 */     list.sort((o1, o2) -> {
/*      */           GuildHandler.MemberInfo.Builder memberA = o1.toBuilder();
/*      */ 
/*      */ 
/*      */           
/*      */           GuildHandler.MemberInfo.Builder memberB = o1.toBuilder();
/*      */ 
/*      */ 
/*      */           
/*      */           return (memberA.getJob() != memberB.getJob()) ? ((memberA.getJob() < memberB.getJob()) ? -1 : 1) : ((memberA.getUpLevel() != memberB.getUpLevel()) ? ((memberA.getUpLevel() < memberB.getUpLevel()) ? 1 : -1) : ((memberA.getLevel() != memberB.getLevel()) ? ((memberA.getLevel() < memberB.getLevel()) ? 1 : -1) : memberB.getJoinTime().compareTo(memberA.getJoinTime())));
/*      */         });
/*      */ 
/*      */ 
/*      */     
/*  638 */     if (list.size() > 0) {
/*  639 */       return ((GuildHandler.MemberInfo)list.get(0)).getPlayerId();
/*      */     }
/*      */     
/*  642 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void delRoleDelGuild(GuildPO guildPo, String playerId) {
/*  653 */     List<GuildMemberPO> memberList = GuildUtil.getGuildMemberList(guildPo.id);
/*  654 */     for (int i = 0; i < memberList.size(); i++) {
/*  655 */       delRoleClearMember(((GuildMemberPO)memberList.get(i)).playerId);
/*      */     }
/*      */     
/*  658 */     GuildServiceCenter.getInstance().delGuild(guildPo);
/*      */   }
/*      */   
/*      */   public static void delRoleClearMember(String playerId) {
/*  662 */     GuildServiceCenter guildServiceCenter = GuildServiceCenter.getInstance();
/*  663 */     GuildMemberPO delInfo = guildServiceCenter.getGuildMember(playerId);
/*  664 */     if (null == delInfo) {
/*      */       return;
/*      */     }
/*      */     
/*  668 */     guildServiceCenter.removeMember(delInfo.playerId);
/*      */     
/*  670 */     Set<String> ids = new HashSet<>();
/*  671 */     ids.add(delInfo.playerId);
/*  672 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
/*  673 */     notifySomePlayerRefreshGuild(ids, msg, null);
/*      */ 
/*      */     
/*  676 */     guildServiceCenter.refreshGuildTopInfo(delInfo.guildId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GuildResult delRole(String playerId) {
/*  686 */     GuildResult ret = new GuildResult();
/*  687 */     GuildServiceCenter guildServiceCenter = GuildServiceCenter.getInstance();
/*      */     
/*  689 */     GuildPO guildPo = guildServiceCenter.getGuildByMemberId(playerId);
/*  690 */     if (null == guildPo) {
/*      */       
/*  692 */       ret.result = -1;
/*  693 */       List<GuildApplyPO> applies = guildServiceCenter.getPlayerApplyList(playerId);
/*  694 */       if (null != applies) {
/*  695 */         for (int i = applies.size() - 1; i >= 0; i--) {
/*  696 */           guildServiceCenter.removeApply(((GuildApplyPO)applies.get(i)).id);
/*      */         }
/*      */       }
/*  699 */       return ret;
/*      */     } 
/*      */     
/*  702 */     String newPresidentId = get1stMemeberId(guildPo.id, playerId);
/*      */     
/*  704 */     if (guildPo.presidentId.equals(playerId)) {
/*  705 */       if (null != newPresidentId) {
/*      */         
/*  707 */         transferGuildPresident(playerId, newPresidentId);
/*  708 */         delRoleClearMember(playerId);
/*      */       } else {
/*  710 */         delRoleDelGuild(guildPo, playerId);
/*      */       } 
/*      */     } else {
/*  713 */       delRoleClearMember(playerId);
/*      */     } 
/*      */     
/*  716 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult kickMember(WNPlayer player, String kickId) {
/*  720 */     GuildResult ret = new GuildResult();
/*  721 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  722 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  723 */     if (null == myInfo) {
/*  724 */       ret.result = -1;
/*  725 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  726 */       return ret;
/*      */     } 
/*      */     
/*  729 */     if (GuildBossCenter.getInstance().isOpen()) {
/*  730 */       ret.result = -1;
/*  731 */       ret.des = LangService.getValue("GUILD_BOSS_IN");
/*  732 */       return ret;
/*      */     } 
/*      */     
/*  735 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  736 */     if (null == myGuild) {
/*  737 */       ret.result = -1;
/*  738 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  739 */       return ret;
/*      */     } 
/*      */     
/*  742 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  743 */     if (jobProp.right4 == 0) {
/*  744 */       ret.result = -2;
/*  745 */       ret.des = "没有权限";
/*  746 */       return ret;
/*      */     } 
/*      */     
/*  749 */     GuildMemberPO kickInfo = guildManager.getGuildMember(kickId);
/*  750 */     if (null == kickInfo || !kickInfo.guildId.equals(myInfo.guildId)) {
/*  751 */       ret.result = -3;
/*  752 */       ret.des = "对方不是公会成员";
/*  753 */       return ret;
/*      */     } 
/*      */     
/*  756 */     if (myInfo.job >= kickInfo.job) {
/*  757 */       ret.result = -4;
/*  758 */       ret.des = "无法踢除同等或更高级职位成员";
/*  759 */       return ret;
/*      */     } 
/*      */     
/*  762 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  763 */     if (System.currentTimeMillis() - kickInfo.createTime.getTime() < settingProp.kickOutMs) {
/*  764 */       ret.result = -5;
/*  765 */       ret.des = "入会时间过短";
/*  766 */       return ret;
/*      */     } 
/*      */     
/*  769 */     if (DateUtil.canRefreshData(5, myGuild.kickTime)) {
/*  770 */       myGuild.kickCount = 0;
/*      */     }
/*      */     
/*  773 */     if (myGuild.kickCount >= settingProp.fireNum) {
/*  774 */       ret.result = -6;
/*  775 */       ret.des = "今日踢人次数已用完";
/*  776 */       return ret;
/*      */     } 
/*      */     
/*  779 */     myGuild.kickCount++;
/*  780 */     myGuild.kickTime = new Date();
/*  781 */     int leftKickNum = settingProp.fireNum - myGuild.kickCount;
/*      */     
/*  783 */     GuildRecordData record = new GuildRecordData();
/*  784 */     record.type = Const.GuildRecord.KICK.getValue();
/*  785 */     record.role1.pro = myInfo.pro;
/*  786 */     record.role1.name = myInfo.name;
/*  787 */     record.role2.pro = kickInfo.pro;
/*  788 */     record.role2.name = kickInfo.name;
/*  789 */     guildManager.addGuildRecord(myGuild.id, record);
/*  790 */     guildManager.removeMember(kickInfo.playerId);
/*      */ 
/*      */     
/*  793 */     Set<String> ids = new HashSet<>();
/*  794 */     ids.add(kickInfo.playerId);
/*  795 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_EXIT_PUSH.getValue(), null);
/*  796 */     notifySomePlayerRefreshGuild(ids, msg, null);
/*      */     
/*  798 */     String guildName = myGuild.name;
/*      */     
/*  800 */     MailSysData mailData = new MailSysData("Guild_kick");
/*  801 */     mailData.replace = new HashMap<>();
/*  802 */     mailData.replace.put("guildName", guildName);
/*  803 */     MailUtil.getInstance().sendMailToOnePlayer(kickInfo.playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*      */     
/*  805 */     ret.id = myGuild.id;
/*  806 */     ret.name = myGuild.name;
/*  807 */     ret.leftKickNum = leftKickNum;
/*  808 */     myGuild.modify = true;
/*      */     
/*  810 */     guildManager.refreshGuildTopInfo(myGuild.id);
/*  811 */     player.auctionManager.pushScript();
/*  812 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult upgradeGuildLevel(WNPlayer player) {
/*  816 */     GuildResult ret = new GuildResult();
/*  817 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  818 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  819 */     if (null == myInfo) {
/*  820 */       ret.result = -1;
/*  821 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  822 */       return ret;
/*      */     } 
/*  824 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  825 */     if (null == myGuild) {
/*  826 */       ret.result = -1;
/*  827 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  828 */       return ret;
/*      */     } 
/*      */     
/*  831 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/*  832 */       ret.result = -2;
/*  833 */       ret.des = "没有权限";
/*  834 */       return ret;
/*      */     } 
/*      */     
/*  837 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  838 */     GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
/*  839 */     if (null == settingProp || null == levelProp) {
/*  840 */       ret.result = -3;
/*  841 */       ret.des = "配置错误";
/*  842 */       return ret;
/*      */     } 
/*      */     
/*  845 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.GUILD.getValue());
/*  846 */     if (myGuild.level >= buildProp.maxLv) {
/*  847 */       ret.result = 1;
/*  848 */       ret.des = "公会等级已满";
/*  849 */       return ret;
/*      */     } 
/*  851 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/*  852 */     if (null == bless || bless.level < levelProp.building1) {
/*  853 */       ret.result = 2;
/*  854 */       ret.needLevel = levelProp.building1;
/*  855 */       ret.des = "公会祈福等级不够";
/*  856 */       return ret;
/*      */     } 
/*      */     
/*  859 */     if (bless.tech.level < levelProp.building2) {
/*  860 */       ret.result = 3;
/*  861 */       ret.des = "公会修行等级不够";
/*  862 */       ret.needLevel = levelProp.building2;
/*  863 */       return ret;
/*      */     } 
/*      */     
/*  866 */     GuildDepot depot = GuildDepotCenter.getInstance().getDepot(myInfo.guildId);
/*  867 */     if (null == depot || depot.depotData.level < levelProp.building3) {
/*  868 */       ret.result = 4;
/*  869 */       ret.des = "公会仓库等级不够";
/*  870 */       ret.needLevel = levelProp.building3;
/*  871 */       return ret;
/*      */     } 
/*      */     
/*  874 */     if (myGuild.exp < levelProp.exp) {
/*  875 */       ret.result = 5;
/*  876 */       ret.des = "公会威望不足";
/*  877 */       return ret;
/*      */     } 
/*      */     
/*  880 */     long preExp = myGuild.exp;
/*  881 */     int preLevel = myGuild.level;
/*  882 */     myGuild.level++;
/*  883 */     myGuild.exp -= levelProp.exp;
/*      */     
/*  885 */     GuildRecordData record = new GuildRecordData();
/*  886 */     record.type = Const.GuildRecord.UPGRADE.getValue();
/*  887 */     record.role1.pro = myInfo.pro;
/*  888 */     record.role1.name = myInfo.name;
/*  889 */     record.result.v2 = Integer.toString(myGuild.level);
/*      */     
/*  891 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/*  893 */     GuildResult.UpgradeGuildLvData data = new GuildResult.UpgradeGuildLvData();
/*  894 */     data.preLevel = preLevel;
/*  895 */     data.preExp = preExp;
/*  896 */     data.exp = myGuild.exp;
/*  897 */     data.level = myGuild.level;
/*  898 */     data.costExp = levelProp.exp;
/*      */     
/*  900 */     ret.result = 0;
/*  901 */     ret.des = "sucess";
/*  902 */     ret.data = data;
/*  903 */     guildManager.refreshGuildTopInfo(myGuild.id);
/*      */ 
/*      */     
/*  906 */     GCache.hset(ConstsTR.guildTR.value, myGuild.id, Utils.serialize(myGuild));
/*  907 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildResult changeGuildNotice(WNPlayer player, String notice) {
/*  912 */     GuildResult ret = new GuildResult();
/*  913 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  914 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  915 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  916 */     if (null == myInfo || null == myGuild) {
/*  917 */       ret.result = -1;
/*  918 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  919 */       return ret;
/*      */     } 
/*      */     
/*  922 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  923 */     if (jobProp.right1 == 0) {
/*  924 */       ret.result = -2;
/*  925 */       ret.des = "没有权限";
/*  926 */       return ret;
/*      */     } 
/*      */     
/*  929 */     myGuild.notice = notice;
/*  930 */     guildManager.saveGuild(myGuild);
/*      */     
/*  932 */     ret.result = 0;
/*  933 */     ret.des = "success";
/*  934 */     ret.newNotice = notice;
/*  935 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult changeGuildName(WNPlayer player, String name) {
/*  939 */     GuildResult ret = new GuildResult();
/*  940 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/*  941 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/*  942 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/*  943 */     if (null == myInfo || null == myGuild) {
/*  944 */       ret.result = -1;
/*  945 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/*  946 */       return ret;
/*      */     } 
/*      */     
/*  949 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/*  950 */     if (jobProp.right2 == 0) {
/*  951 */       ret.result = -2;
/*  952 */       ret.des = "没有权限";
/*  953 */       return ret;
/*      */     } 
/*      */     
/*  956 */     boolean isExist = guildManager.existGuildName(myGuild.logicServerId, name);
/*  957 */     if (isExist) {
/*  958 */       ret.result = 1;
/*  959 */       ret.des = "名字已存在";
/*      */     } 
/*      */     
/*  962 */     Date now = new Date();
/*  963 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*  964 */     int dayCD = settingProp.changeNameCD;
/*  965 */     long cdOverTime = myGuild.changeNameTime.getTime() + (dayCD * Const.Time.Day.getValue());
/*  966 */     if (now.getTime() < cdOverTime) {
/*  967 */       ret.result = 2;
/*  968 */       ret.des = "更名cd中";
/*  969 */       return ret;
/*      */     } 
/*      */     
/*  972 */     String oldName = myGuild.name;
/*  973 */     myGuild.name = name;
/*  974 */     myGuild.changeNameTime = now;
/*      */     
/*  976 */     GuildDao.GuildNameMap.remove(oldName);
/*      */ 
/*      */     
/*  979 */     GuildRecordData record = new GuildRecordData();
/*  980 */     record.type = Const.GuildRecord.GUILD_NAME.getValue();
/*  981 */     record.role1.pro = myInfo.pro;
/*  982 */     record.role1.name = myInfo.name;
/*  983 */     record.result.v2 = myGuild.name;
/*  984 */     guildManager.addGuildRecord(myGuild.id, record);
/*  985 */     guildManager.saveGuild(myGuild);
/*      */ 
/*      */     
/*  988 */     GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
/*  989 */     msgData.guildName = myGuild.name;
/*  990 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_CHANGE_NAME.getValue(), msgData);
/*  991 */     notifyAllMemberRefreshGuild(myGuild.id, msg, null);
/*      */     
/*  993 */     guildManager.refreshGuildTopInfo(myGuild.id);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  999 */     ret.result = 0;
/* 1000 */     ret.des = "success";
/* 1001 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult changeOfficeName(WNPlayer player, List<GuildHandler.OfficeName> officeNames) {
/* 1005 */     GuildResult ret = new GuildResult();
/* 1006 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1007 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1008 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1009 */     if (null == myInfo || null == myGuild) {
/* 1010 */       ret.result = -1;
/* 1011 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1012 */       return ret;
/*      */     } 
/*      */     
/* 1015 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1016 */       ret.result = -2;
/* 1017 */       ret.des = "没有权限";
/* 1018 */       return ret;
/*      */     } 
/*      */     
/* 1021 */     Map<Integer, String> tempNames = myGuild.officeNames;
/*      */     
/* 1023 */     for (GuildHandler.OfficeName office : officeNames) {
/* 1024 */       tempNames.put(Integer.valueOf(office.getJob()), office.getName());
/*      */     }
/*      */     
/* 1027 */     Map<String, Integer> countMap = new HashMap<>();
/* 1028 */     for (Integer key : tempNames.keySet()) {
/* 1029 */       String name = tempNames.get(key);
/* 1030 */       if (countMap.containsKey(name)) {
/* 1031 */         countMap.put(name, Integer.valueOf(((Integer)countMap.get(name)).intValue() + 1));
/*      */       } else {
/* 1033 */         countMap.put(name, Integer.valueOf(1));
/*      */       } 
/*      */       
/* 1036 */       if (((Integer)countMap.get(name)).intValue() > 1) {
/* 1037 */         ret.result = 1;
/* 1038 */         ret.des = "名称重复";
/* 1039 */         return ret;
/*      */       } 
/*      */     } 
/*      */     
/* 1043 */     GuildRecordData record = new GuildRecordData();
/* 1044 */     record.type = Const.GuildRecord.OFFICE_NAME.getValue();
/* 1045 */     record.role1.pro = myInfo.pro;
/* 1046 */     record.role1.name = myInfo.name;
/* 1047 */     guildManager.addGuildRecord(myGuild.id, record);
/* 1048 */     ret.result = 0;
/* 1049 */     ret.des = "success";
/* 1050 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult contributeToGuild(WNPlayer player, int type, int times) {
/* 1054 */     GuildResult ret = new GuildResult();
/* 1055 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1056 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1057 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1058 */     if (null == myInfo || null == myGuild) {
/* 1059 */       ret.result = -1;
/* 1060 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1061 */       return ret;
/*      */     } 
/*      */     
/* 1064 */     GuildContributeCO contributeProp = GuildUtil.getGuildContributePropByType(type);
/* 1065 */     int addFund = contributeProp.guildFunds * times;
/* 1066 */     int addGuildPoints = contributeProp.guildPoints * times;
/* 1067 */     int addExp = contributeProp.guildExp * times;
/*      */     
/* 1069 */     Date refreshTime = myGuild.allBlobData.refreshTime;
/* 1070 */     if (null == myGuild.allBlobData.refreshTime || DateUtil.canRefreshData(5, refreshTime)) {
/* 1071 */       myGuild.allBlobData.todaySumFund = 0;
/* 1072 */       myGuild.allBlobData.todaySumExp = 0;
/* 1073 */       myGuild.allBlobData.refreshTime = new Date();
/*      */     } 
/*      */     
/* 1076 */     GuildLevelCO levelProp = GuildUtil.getGuildLevelPropByLevel(myGuild.level);
/* 1077 */     int todayLeftFund = Math.max(levelProp.maxFundsDay - myGuild.allBlobData.todaySumFund, 0);
/* 1078 */     int todayLeftExp = Math.max(levelProp.maxExpDay - myGuild.allBlobData.todaySumExp, 0);
/* 1079 */     int addRealFund = Math.min(todayLeftFund, addFund);
/* 1080 */     int addRealExp = Math.min(todayLeftExp, addExp);
/*      */     
/* 1082 */     myGuild.fund += addRealFund;
/* 1083 */     myGuild.sumFund += addRealFund;
/* 1084 */     myGuild.exp += addRealExp;
/* 1085 */     myGuild.allBlobData.todaySumFund += addRealFund;
/* 1086 */     myGuild.allBlobData.todaySumExp += addRealExp;
/* 1087 */     if (null == myInfo.lastContributeTime) {
/* 1088 */       myInfo.lastContributeTime = new Date();
/*      */     }
/*      */     
/* 1091 */     if (!DateUtil.canRefreshData(5, myInfo.lastContributeTime)) {
/* 1092 */       myInfo.lastContributeValue += addGuildPoints;
/*      */     } else {
/* 1094 */       myInfo.lastContributeValue = addGuildPoints;
/*      */     } 
/*      */     
/* 1097 */     myInfo.lastContributeTime = new Date();
/*      */     
/* 1099 */     guildManager.saveGuild(myGuild);
/* 1100 */     guildManager.saveMember(myInfo);
/*      */     
/* 1102 */     guildManager.refreshGuildTopInfo(myGuild.id);
/* 1103 */     ret.result = 0;
/* 1104 */     ret.des = "success";
/* 1105 */     ret.addReadFund = addRealFund;
/* 1106 */     ret.addRealExp = addRealExp;
/* 1107 */     ret.id = myGuild.id;
/* 1108 */     ret.name = myGuild.name;
/* 1109 */     return ret;
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
/*      */   public static boolean gmAddGuildMoney(String playerId, String moneyName, int num) {
/* 1122 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1123 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 1124 */     if (myInfo == null) {
/* 1125 */       return false;
/*      */     }
/* 1127 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/* 1128 */     if (myGuild == null) {
/* 1129 */       return false;
/*      */     }
/* 1131 */     if (moneyName.equals("fund")) {
/* 1132 */       myGuild.fund += num;
/* 1133 */       myGuild.sumFund += num;
/*      */     } 
/* 1135 */     if (moneyName.equals("exp")) {
/* 1136 */       myGuild.exp += num;
/*      */     }
/* 1138 */     guildManager.saveGuild(myGuild);
/* 1139 */     return true;
/*      */   }
/*      */   
/*      */   public static GuildResult setMemberJob(WNPlayer player, String memberId, int job) {
/* 1143 */     GuildResult ret = new GuildResult();
/* 1144 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1145 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1146 */     if (null == myInfo) {
/* 1147 */       ret.result = -1;
/* 1148 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1149 */       return ret;
/*      */     } 
/*      */     
/* 1152 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1153 */     if (null == myGuild) {
/* 1154 */       ret.result = -1;
/* 1155 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1156 */       return ret;
/*      */     } 
/*      */     
/* 1159 */     GuildMemberPO memberInfo = guildManager.getGuildMember(memberId);
/* 1160 */     if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
/* 1161 */       ret.result = -2;
/* 1162 */       ret.des = "对方不是本公会成员";
/* 1163 */       return ret;
/*      */     } 
/* 1165 */     if (myInfo.job > Const.GuildJob.ELDER.getValue()) {
/* 1166 */       ret.result = -3;
/* 1167 */       ret.des = "没有权限";
/* 1168 */       return ret;
/*      */     } 
/* 1170 */     if (myInfo.job >= memberInfo.job || myInfo.job >= job) {
/* 1171 */       ret.result = -4;
/* 1172 */       ret.des = "无法设置比自己同等和高等级职位";
/* 1173 */       return ret;
/*      */     } 
/* 1175 */     if (memberInfo.job == job) {
/* 1176 */       ret.result = 0;
/* 1177 */       ret.des = "success";
/* 1178 */       return ret;
/*      */     } 
/* 1180 */     int jobCount = GuildUtil.getGuildMemberCountByJob(myGuild.id, job);
/* 1181 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(job);
/* 1182 */     if (jobCount >= jobProp.setNumber) {
/* 1183 */       ret.result = -5;
/* 1184 */       ret.des = "该职位人数已满";
/* 1185 */       return ret;
/*      */     } 
/*      */     
/* 1188 */     memberInfo.job = job;
/*      */     
/* 1190 */     GuildRecordData.GuildRecordResult recordRet = new GuildRecordData.GuildRecordResult(memberInfo.job, (String)myGuild.officeNames.get(Integer.valueOf(memberInfo.job)));
/* 1191 */     GuildRecordData record = new GuildRecordData(Const.GuildRecord.JOB.getValue(), myInfo, memberInfo, recordRet);
/* 1192 */     guildManager.addGuildRecord(myGuild.id, record);
/* 1193 */     guildManager.saveMember(memberInfo);
/*      */     
/* 1195 */     TreeMap<String, String> map1 = new TreeMap<>();
/* 1196 */     map1.put("guildposition", (String)myGuild.officeNames.get(Integer.valueOf(job)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1201 */     WNPlayer memberPlayer = PlayerUtil.getOnlinePlayer(memberInfo.playerId);
/* 1202 */     if (null != memberPlayer) {
/* 1203 */       memberPlayer.guildManager.setGuildJobInfo(myGuild.id, myGuild.name, job, myGuild.icon);
/*      */     }
/* 1205 */     Set<String> ids = new HashSet<>();
/* 1206 */     ids.add(memberInfo.playerId);
/*      */     
/* 1208 */     GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
/* 1209 */     msgData.job = memberInfo.job;
/* 1210 */     msgData.jobName = (String)myGuild.officeNames.get(Integer.valueOf(memberInfo.job));
/* 1211 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), msgData);
/* 1212 */     notifySomePlayerRefreshGuild(ids, msg, null);
/*      */     
/* 1214 */     ret.result = 0;
/* 1215 */     ret.des = "success";
/* 1216 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult transferGuildPresident(String playerId, String memberId) {
/* 1220 */     GuildResult ret = new GuildResult();
/* 1221 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1222 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 1223 */     if (null == myInfo) {
/* 1224 */       ret.result = -1;
/* 1225 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1226 */       return ret;
/*      */     } 
/*      */     
/* 1229 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1230 */     if (null == myGuild) {
/* 1231 */       ret.result = -1;
/* 1232 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1233 */       return ret;
/*      */     } 
/*      */     
/* 1236 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1237 */       ret.result = -2;
/* 1238 */       ret.des = "没有权限";
/* 1239 */       return ret;
/*      */     } 
/*      */     
/* 1242 */     GuildMemberPO memberInfo = guildManager.getGuildMember(memberId);
/* 1243 */     if (null == memberInfo || !memberInfo.guildId.equals(myGuild.id)) {
/* 1244 */       ret.result = -3;
/* 1245 */       ret.des = "对方不是本公会成员";
/* 1246 */       return ret;
/*      */     } 
/*      */     
/* 1249 */     GuildResult.TransferGuildPresidentData retData = new GuildResult.TransferGuildPresidentData();
/* 1250 */     String oldName = myGuild.presidentName;
/* 1251 */     int oldPro = myGuild.presidentPro;
/*      */     
/* 1253 */     retData.preId = myGuild.presidentId;
/* 1254 */     retData.preName = oldName;
/*      */     
/* 1256 */     myGuild.presidentId = memberInfo.playerId;
/* 1257 */     myGuild.presidentPro = memberInfo.pro;
/* 1258 */     myGuild.presidentName = memberInfo.name;
/*      */     
/* 1260 */     retData.nowId = myGuild.presidentId;
/* 1261 */     retData.nowName = myGuild.presidentName;
/*      */     
/* 1263 */     memberInfo.job = Const.GuildJob.PRESIDENT.getValue();
/* 1264 */     myInfo.job = Const.GuildJob.MEMBER.getValue();
/*      */ 
/*      */     
/* 1267 */     int type = Const.GuildRecord.TRANSFER_PRESIDENT.getValue();
/* 1268 */     GuildRecordData record = new GuildRecordData(type, myInfo, memberInfo);
/* 1269 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 1271 */     guildManager.saveGuild(myGuild);
/* 1272 */     guildManager.saveMember(myInfo);
/* 1273 */     guildManager.saveMember(memberInfo);
/*      */ 
/*      */     
/* 1276 */     Map<String, String> map1 = new HashMap<>();
/* 1277 */     map1.put("guildposition", (String)myGuild.officeNames.get(Integer.valueOf(myInfo.job)));
/* 1278 */     GuildCommonUtil.sendMailSystenType(myInfo.playerId, "Guild_position", map1);
/*      */     
/* 1280 */     Map<String, String> map2 = new HashMap<>();
/* 1281 */     map2.put("guildposition", (String)myGuild.officeNames.get(Integer.valueOf(memberInfo.job)));
/* 1282 */     GuildCommonUtil.sendMailSystenType(memberInfo.playerId, "Guild_position", map2);
/*      */     
/* 1284 */     notifyGuildJobChange(myInfo, myGuild);
/* 1285 */     notifyGuildJobChange(memberInfo, myGuild);
/*      */     
/* 1287 */     GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
/* 1288 */     if (null != impeach) {
/*      */       
/* 1290 */       GuildRecordData record1 = new GuildRecordData();
/* 1291 */       record1.type = Const.GuildRecord.TRANSFER_IMPEACH_BECOME_INVALID.getValue();
/* 1292 */       record1.role1.pro = impeach.sponsor.pro;
/* 1293 */       record1.role2.name = impeach.sponsor.name;
/* 1294 */       record1.role2.pro = oldPro;
/* 1295 */       record1.role2.name = oldName;
/* 1296 */       record1.result.v2 = Integer.toString(impeach.playerIds.size());
/* 1297 */       guildManager.addGuildRecord(myGuild.id, record1);
/*      */       
/* 1299 */       GuildImpeachCenter.getInstance().removeGuildImpeachByData(impeach);
/*      */     } 
/* 1301 */     retData.newJob = myInfo.job;
/* 1302 */     ret.result = 0;
/* 1303 */     ret.des = "success";
/* 1304 */     ret.data = retData;
/* 1305 */     return ret;
/*      */   }
/*      */   
/*      */   public static void notifyGuildJobChange(GuildMemberPO player, GuildPO myGuild) {
/* 1309 */     GuildMsg.RefreshGuildMsg msgData = new GuildMsg.RefreshGuildMsg();
/* 1310 */     msgData.job = player.job;
/* 1311 */     msgData.jobName = (String)myGuild.officeNames.get(Integer.valueOf(player.job));
/* 1312 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_JOB_CHANGE.getValue(), msgData);
/* 1313 */     notifySomePlayerRefreshGuild(new HashSet<>(Arrays.asList(new String[] { player.playerId }, )), msg, null);
/*      */   }
/*      */   
/*      */   public static GuildResult impeachGuildPresident(WNPlayer player, String presidentId, Date logoutTime) {
/* 1317 */     GuildResult ret = new GuildResult();
/* 1318 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1319 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1320 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1321 */     if (null == myInfo || null == myGuild) {
/* 1322 */       ret.result = -1;
/* 1323 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1324 */       return ret;
/*      */     } 
/* 1326 */     if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
/* 1327 */       ret.result = -2;
/* 1328 */       ret.des = "不能弹劾自己";
/* 1329 */       return ret;
/*      */     } 
/*      */     
/* 1332 */     boolean isPresidentOnline = PlayerUtil.isOnline(myGuild.presidentId);
/* 1333 */     if (isPresidentOnline) {
/* 1334 */       ret.result = -3;
/* 1335 */       ret.des = "会长在线";
/* 1336 */       return ret;
/*      */     } 
/*      */     
/* 1339 */     if (!presidentId.equals(myGuild.presidentId)) {
/* 1340 */       ret.result = -3;
/* 1341 */       ret.des = "会长不匹配，可能已更换会长";
/* 1342 */       return ret;
/*      */     } 
/*      */     
/* 1345 */     Date nowTime = new Date();
/* 1346 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1347 */     if (nowTime.getTime() - logoutTime.getTime() < settingProp.impeachMs) {
/* 1348 */       ret.result = -6;
/* 1349 */       ret.des = LangService.getValue("GUILD_PRESIDENT_OFFTIME_NOT_ENOUGH").replace("{day}", String.valueOf(settingProp.impeach));
/* 1350 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1354 */     GuildImpeachCenter.getInstance().refreshImpeash(myGuild.id);
/* 1355 */     GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
/* 1356 */     int isNew = 0;
/* 1357 */     if (null != impeach) {
/* 1358 */       if (impeach.playerIds.indexOf(myInfo.playerId) != -1) {
/* 1359 */         ret.result = -7;
/* 1360 */         long createTime = impeach.createTime.getTime();
/* 1361 */         long remainTime = settingProp.impeachTimeMs - nowTime.getTime() - createTime;
/* 1362 */         String _strT = GuildCommonUtil.leftTimeTips(remainTime);
/* 1363 */         ret.des = MessageFormat.format(LangService.getValue("GUILD_PRESIDENT_TIPS"), new Object[] { Integer.valueOf(settingProp.impeachTime / 60), Integer.valueOf(settingProp.impeachNo), Integer.valueOf(impeach.playerIds.size()), _strT });
/* 1364 */         return ret;
/*      */       } 
/*      */       
/* 1367 */       impeach.playerIds.add(myInfo.playerId);
/* 1368 */       GuildImpeachCenter.getInstance().updateGuildImpeachByData(impeach);
/*      */     } else {
/* 1370 */       impeach = new GuildImpeachData();
/* 1371 */       impeach.id = myGuild.id;
/* 1372 */       impeach.logicServerId = myGuild.logicServerId;
/* 1373 */       impeach.logoutTime = logoutTime;
/* 1374 */       impeach.createTime = new Date();
/* 1375 */       impeach.playerIds.add(myInfo.playerId);
/* 1376 */       impeach.sponsor = new GuildImpeachData.Sponsor();
/* 1377 */       impeach.sponsor.id = myInfo.playerId;
/* 1378 */       impeach.sponsor.name = myInfo.name;
/* 1379 */       isNew = 1;
/* 1380 */       GuildImpeachCenter.getInstance().addImpeachAndSave(impeach);
/*      */     } 
/*      */ 
/*      */     
/* 1384 */     GuildRecordData record = new GuildRecordData();
/* 1385 */     record.type = Const.GuildRecord.IMPEACH.getValue();
/* 1386 */     record.role1.pro = myInfo.pro;
/* 1387 */     record.role1.name = myInfo.name;
/* 1388 */     record.role2.pro = myGuild.presidentPro;
/* 1389 */     record.role2.name = myGuild.presidentName;
/* 1390 */     record.result.v2 = Integer.toString(impeach.playerIds.size());
/* 1391 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 1393 */     ret.result = 0;
/* 1394 */     ret.isNew = isNew;
/* 1395 */     ret.des = "success";
/* 1396 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult presidentOnline(WNPlayer player) {
/* 1400 */     GuildResult ret = new GuildResult();
/* 1401 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1402 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1403 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1404 */     if (null == myInfo || null == myGuild) {
/* 1405 */       ret.result = -1;
/* 1406 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1407 */       return ret;
/*      */     } 
/*      */     
/* 1410 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1411 */       ret.result = -2;
/* 1412 */       ret.des = "不是会长上线";
/* 1413 */       return ret;
/*      */     } 
/* 1415 */     GuildImpeachData impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
/* 1416 */     if (null == impeach) {
/* 1417 */       ret.result = -2;
/* 1418 */       ret.des = "没有被弹劾，不需要清除";
/* 1419 */       return ret;
/*      */     } 
/*      */     
/* 1422 */     GuildImpeachCenter.getInstance().removeGuildImpeach(myGuild.id);
/* 1423 */     impeach = GuildImpeachCenter.getInstance().getImpeach(myGuild.id);
/* 1424 */     if (null != impeach) {
/*      */       
/* 1426 */       GuildRecordData record = new GuildRecordData();
/* 1427 */       record.type = Const.GuildRecord.ONLINE_IMPEACH_BECOME_INVALID.getValue();
/* 1428 */       record.role1.pro = impeach.sponsor.pro;
/* 1429 */       record.role2.name = impeach.sponsor.name;
/* 1430 */       record.role2.pro = myGuild.presidentPro;
/* 1431 */       record.role2.name = myGuild.presidentName;
/* 1432 */       record.result.v2 = Integer.toString(impeach.playerIds.size());
/* 1433 */       guildManager.addGuildRecord(myGuild.id, record);
/* 1434 */       GuildImpeachCenter.getInstance().removeGuildImpeachByData(impeach);
/*      */     } 
/* 1436 */     ret.result = 0;
/* 1437 */     ret.des = "success";
/* 1438 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildResult depotDepositEquip(WNPlayer player, PlayerItemPO item) {
/* 1443 */     GuildResult ret = new GuildResult();
/* 1444 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1445 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1446 */     if (null == myInfo) {
/* 1447 */       ret.result = 1;
/* 1448 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1449 */       return ret;
/*      */     } 
/*      */     
/* 1452 */     GuildDepot depot = GuildDepotCenter.getInstance().getDepot(myInfo.guildId);
/* 1453 */     if (null == depot) {
/* 1454 */       ret.result = 2;
/* 1455 */       ret.des = "公会仓库不存在";
/* 1456 */       return ret;
/*      */     } 
/*      */     
/* 1459 */     GuildCond useCond = depot.depotData.condition.useCond;
/*      */     
/* 1461 */     if (player.getLevel() < useCond.level) {
/* 1462 */       ret.result = 4;
/* 1463 */       ret.des = "等级不满足";
/* 1464 */       return ret;
/*      */     } 
/*      */     
/* 1467 */     if (myInfo.job > useCond.job) {
/* 1468 */       ret.result = 5;
/* 1469 */       ret.des = "公会职位不满足";
/* 1470 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1474 */     NormalItem equip = ItemUtil.createItemByDbOpts(item);
/* 1475 */     GuildCond equipQuality = new GuildCond();
/* 1476 */     equipQuality.level = equip.getLevel();
/* 1477 */     equipQuality.upLevel = equip.getUpLevel();
/* 1478 */     equipQuality.qColor = equip.getQLevel();
/*      */     
/* 1480 */     if (!GuildUtil.isInCondition(equipQuality, depot.depotData.condition)) {
/* 1481 */       ret.result = 6;
/* 1482 */       ret.des = "装备品质不在设定范围内";
/* 1483 */       return ret;
/*      */     } 
/*      */     
/* 1486 */     WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(equip.getLevel(), equip.getQLevel());
/* 1487 */     if (null == depositProp) {
/* 1488 */       ret.result = -9;
/* 1489 */       ret.des = "未找到该品质对应的配置";
/* 1490 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1494 */     if (!depot.testEmptyGridLarge(1)) {
/* 1495 */       ret.result = 7;
/* 1496 */       ret.des = "仓库空间不足";
/* 1497 */       return ret;
/*      */     } 
/*      */     
/* 1500 */     int addIndex = depot.addEquip(equip, myInfo.playerId);
/* 1501 */     if (addIndex <= 0) {
/* 1502 */       ret.result = 7;
/* 1503 */       ret.des = "仓库增加道具失败(异常)";
/* 1504 */       return ret;
/*      */     } 
/*      */     
/* 1507 */     RoleInfo role1 = new RoleInfo();
/* 1508 */     role1.pro = myInfo.pro;
/* 1509 */     role1.name = myInfo.name;
/*      */ 
/*      */     
/* 1512 */     GuildRecordData record = new GuildRecordData();
/* 1513 */     record.type = Const.GuildRecord.DEPOSIT_EQUIP.getValue();
/* 1514 */     record.role1 = role1;
/* 1515 */     ItemRecordInfo tmpItem = new ItemRecordInfo();
/* 1516 */     tmpItem.qColor = equip.getQLevel();
/* 1517 */     tmpItem.name = equip.getName();
/* 1518 */     record.item = tmpItem;
/* 1519 */     record.result.v2 = Integer.toString(depositProp.wareHouseValue);
/* 1520 */     depot.addRecord(record, true);
/*      */     
/* 1522 */     ret.result = 0;
/* 1523 */     ret.des = "success";
/* 1524 */     ret.bagGrid = depot.bag.getGrid4PayLoad(addIndex);
/* 1525 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult depotTakeOutEquip(WNPlayer player, int bagIndex, int havePawnGold) {
/* 1529 */     GuildResult ret = new GuildResult();
/* 1530 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1531 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1532 */     if (null == myInfo) {
/* 1533 */       ret.result = 1;
/* 1534 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1535 */       return ret;
/*      */     } 
/*      */     
/* 1538 */     GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 1539 */     GuildDepot depot = depotManager.getDepot(myInfo.guildId);
/* 1540 */     if (null == depot) {
/* 1541 */       ret.result = 2;
/* 1542 */       ret.des = "公会仓库不存在";
/* 1543 */       return ret;
/*      */     } 
/*      */     
/* 1546 */     NormalItem equip = depot.getEquip(bagIndex);
/* 1547 */     if (null == equip) {
/* 1548 */       ret.result = 3;
/* 1549 */       ret.des = "该格子不存在道具";
/* 1550 */       return ret;
/*      */     } 
/* 1552 */     WareHouseValueCO depositProp = GuildUtil.getDepotDepositValueProp(equip.getLevel(), equip.getQLevel());
/* 1553 */     if (null == depositProp || havePawnGold < depositProp.wareHouseCost) {
/* 1554 */       ret.result = 4;
/* 1555 */       ret.des = "仓库贡献不足";
/* 1556 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1560 */     GuildRecordData record = new GuildRecordData();
/* 1561 */     record.type = Const.GuildRecord.TAKE_OUT_EQUIP.getValue();
/* 1562 */     record.role1 = new RoleInfo();
/* 1563 */     record.role1.pro = myInfo.pro;
/* 1564 */     record.role1.name = myInfo.name;
/* 1565 */     record.item = new ItemRecordInfo();
/* 1566 */     record.item.qColor = equip.getQLevel();
/* 1567 */     record.item.name = equip.getName();
/* 1568 */     record.result.v2 = Integer.toString(depositProp.wareHouseCost);
/* 1569 */     depot.addRecord(record, false);
/*      */     
/* 1571 */     depot.removeEquip(bagIndex, myInfo.playerId, false);
/* 1572 */     ret.result = 0;
/* 1573 */     ret.des = "success";
/* 1574 */     ret.itemData = equip.cloneItemDB();
/* 1575 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult depotDeleteEquip(WNPlayer player, int bagIndex) {
/* 1579 */     GuildResult ret = new GuildResult();
/* 1580 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1581 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1582 */     if (null == myInfo) {
/* 1583 */       ret.result = 1;
/* 1584 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1585 */       return ret;
/*      */     } 
/* 1587 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 1588 */     if (null == jobProp || jobProp.right6 == 0) {
/* 1589 */       ret.result = 2;
/* 1590 */       ret.des = "没有权限";
/* 1591 */       return ret;
/*      */     } 
/*      */     
/* 1594 */     GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 1595 */     GuildDepot depot = depotManager.getDepot(myInfo.guildId);
/* 1596 */     if (null == depot) {
/* 1597 */       ret.result = 3;
/* 1598 */       ret.des = "公会仓库不存在";
/* 1599 */       return ret;
/*      */     } 
/*      */     
/* 1602 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/* 1603 */     if (depot.getDeleteCount() >= settingProp.warehouseDel) {
/* 1604 */       ret.result = 4;
/* 1605 */       ret.des = "进入删除次数已用完";
/* 1606 */       return ret;
/*      */     } 
/*      */     
/* 1609 */     NormalItem equip = depot.getEquip(bagIndex);
/* 1610 */     if (null == equip) {
/* 1611 */       ret.result = 5;
/* 1612 */       ret.des = "该格子不存在道具";
/* 1613 */       return ret;
/*      */     } 
/*      */ 
/*      */     
/* 1617 */     GuildRecordData record = new GuildRecordData();
/* 1618 */     record.type = Const.GuildRecord.DELETE_EQUIP.getValue();
/* 1619 */     record.role1.pro = myInfo.pro;
/* 1620 */     record.role1.name = myInfo.name;
/* 1621 */     record.item = new ItemRecordInfo();
/* 1622 */     record.item.qColor = equip.getQLevel();
/* 1623 */     record.item.name = equip.getName();
/* 1624 */     depot.addRecord(record, false);
/*      */     
/* 1626 */     depot.removeEquip(bagIndex, myInfo.playerId, true);
/* 1627 */     ret.result = 0;
/* 1628 */     ret.des = "success";
/* 1629 */     ret.deleteCount = depot.getDeleteCount();
/* 1630 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult depotSetCondition(WNPlayer player, GuildDepotCondition condition) {
/* 1634 */     GuildResult ret = new GuildResult();
/* 1635 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1636 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1637 */     if (null == myInfo) {
/* 1638 */       ret.result = 1;
/* 1639 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1640 */       return ret;
/*      */     } 
/* 1642 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 1643 */     if (null == jobProp || jobProp.right6 == 0) {
/* 1644 */       ret.result = 2;
/* 1645 */       ret.des = "没有权限";
/* 1646 */       return ret;
/*      */     } 
/*      */     
/* 1649 */     GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 1650 */     GuildDepot depot = depotManager.getDepot(myInfo.guildId);
/* 1651 */     if (null == depot) {
/* 1652 */       ret.result = 3;
/* 1653 */       ret.des = "公会仓库不存在";
/* 1654 */       return ret;
/*      */     } 
/*      */     
/* 1657 */     depot.setCondition(condition, myInfo.playerId);
/* 1658 */     ret.result = 0;
/* 1659 */     ret.des = "success";
/* 1660 */     ret.newCondition = condition;
/* 1661 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildResult depotUpgradeLevel(WNPlayer player, int myGold) {
/* 1666 */     GuildResult ret = new GuildResult();
/* 1667 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1668 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1669 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1670 */     if (null == myInfo || null == myGuild) {
/* 1671 */       ret.result = 1;
/* 1672 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1673 */       return ret;
/*      */     } 
/* 1675 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 1676 */     if (null == jobProp || jobProp.right6 == 0) {
/* 1677 */       ret.result = 2;
/* 1678 */       ret.des = "没有权限";
/* 1679 */       return ret;
/*      */     } 
/*      */     
/* 1682 */     GuildDepotCenter depotManager = GuildDepotCenter.getInstance();
/* 1683 */     GuildDepot depot = depotManager.getDepot(myInfo.guildId);
/* 1684 */     if (null == depot) {
/* 1685 */       ret.result = 3;
/* 1686 */       ret.des = "公会仓库不存在";
/* 1687 */       return ret;
/*      */     } 
/*      */     
/* 1690 */     WareHouseLevelCO levelProp = GuildUtil.getDepotLevelProp(depot.depotData.level);
/* 1691 */     if (null == levelProp) {
/* 1692 */       ret.result = 3;
/* 1693 */       ret.des = "公会仓库等级配置不存在";
/* 1694 */       return ret;
/*      */     } 
/* 1696 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.DEPOT.getValue());
/* 1697 */     if (depot.depotData.level >= buildProp.maxLv) {
/* 1698 */       ret.result = 4;
/* 1699 */       ret.des = "公会仓库等级已满";
/* 1700 */       return ret;
/*      */     } 
/*      */     
/* 1703 */     if (myGuild.level < levelProp.gLevel) {
/* 1704 */       ret.result = 5;
/* 1705 */       ret.des = "公会等级不足";
/* 1706 */       return ret;
/*      */     } 
/* 1708 */     if (myGold < levelProp.gold) {
/* 1709 */       ret.result = 6;
/* 1710 */       ret.des = "公会等级不足";
/*      */     } 
/* 1712 */     if (myGuild.fund < levelProp.funds) {
/* 1713 */       ret.result = 7;
/* 1714 */       ret.des = "工会资金不足";
/* 1715 */       return ret;
/*      */     } 
/*      */     
/* 1718 */     int preLevel = depot.depotData.level;
/* 1719 */     myGuild.fund -= levelProp.funds;
/* 1720 */     depot.upgradeLevel(myInfo.playerId);
/*      */ 
/*      */     
/* 1723 */     GuildRecordData record = new GuildRecordData();
/* 1724 */     record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
/* 1725 */     record.role1.pro = myInfo.pro;
/* 1726 */     record.role1.name = myInfo.name;
/* 1727 */     record.result.v2 = Integer.toString(depot.depotData.level);
/* 1728 */     record.build = buildProp.buildingName;
/* 1729 */     GuildServiceCenter.getInstance().addGuildRecord(myGuild.id, record);
/*      */     
/* 1731 */     GuildResult.DepotUpgradeLevelData tmpData = new GuildResult.DepotUpgradeLevelData();
/* 1732 */     tmpData.costGoldNum = levelProp.gold;
/* 1733 */     tmpData.newLevel = depot.depotData.level;
/* 1734 */     tmpData.fund = myGuild.fund;
/* 1735 */     tmpData.id = myGuild.id;
/* 1736 */     tmpData.name = myGuild.name;
/* 1737 */     tmpData.preLevel = preLevel;
/* 1738 */     ret.result = 0;
/* 1739 */     ret.des = "sucess";
/* 1740 */     ret.data = tmpData;
/* 1741 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult playerOnlineRefreshGuild(WNPlayer player) {
/* 1745 */     GuildResult ret = new GuildResult();
/* 1746 */     GuildResult.PlayerOnlineRefreshGuild data = new GuildResult.PlayerOnlineRefreshGuild();
/* 1747 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1748 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1749 */     if (null == myInfo) {
/* 1750 */       ret.result = 1;
/* 1751 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1752 */       ret.data = data;
/* 1753 */       return ret;
/*      */     } 
/*      */     
/* 1756 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1757 */     if (null == myGuild) {
/* 1758 */       ret.result = 1;
/* 1759 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1760 */       ret.data = data;
/* 1761 */       return ret;
/*      */     } 
/*      */     
/* 1764 */     GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 1765 */     GuildBlessPO bless = (blessManager.getBless(myInfo.guildId)).blessData;
/* 1766 */     if (null == bless) {
/* 1767 */       ret.result = 0;
/* 1768 */       ret.des = "公会祈福未开启";
/* 1769 */       ret.data = data;
/* 1770 */       return ret;
/*      */     } 
/*      */     
/* 1773 */     if (myInfo.job == Const.GuildJob.PRESIDENT.getValue()) {
/* 1774 */       presidentOnline(player);
/*      */     }
/*      */     
/* 1777 */     data.isInGuild = 1;
/* 1778 */     data.goods = bless.allBlobData.goods;
/* 1779 */     data.techData = bless.allBlobData.techData;
/* 1780 */     data.refreshTime = bless.allBlobData.refreshTime;
/* 1781 */     data.finishStateArr = bless.allBlobData.finishStateArr;
/* 1782 */     data.throwAwardState = getThrowAwardState(myInfo.guildId, player.getId());
/*      */     
/* 1784 */     ret.result = 0;
/* 1785 */     ret.des = "success";
/* 1786 */     ret.data = data;
/* 1787 */     return ret;
/*      */   }
/*      */   
/*      */   public static int getThrowAwardState(String guildId, String playerId) {
/* 1791 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 1792 */     if (dungeonInfo.openState > 0) {
/* 1793 */       return 0;
/*      */     }
/*      */     
/* 1796 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 1797 */     Date now = new Date();
/* 1798 */     if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() > (dungeonConfig.throwTime * Const.Time.Minute.getValue())) {
/* 1799 */       return 0;
/*      */     }
/*      */     
/* 1802 */     for (int pos = 0; pos < dungeonInfo.throwInfo.size(); pos++) {
/* 1803 */       GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(pos);
/* 1804 */       if (null == info.diceInfo.get(playerId))
/*      */       {
/* 1806 */         if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId))
/*      */         {
/*      */           
/* 1809 */           return 1; } 
/*      */       }
/*      */     } 
/* 1812 */     return 0;
/*      */   }
/*      */   
/*      */   public static GuildResult blessAction(WNPlayer player, int id, int blessCount, int times) {
/* 1816 */     GuildResult ret = new GuildResult();
/* 1817 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1818 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1819 */     if (null == myInfo) {
/* 1820 */       ret.result = 1;
/* 1821 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1822 */       return ret;
/*      */     } 
/*      */     
/* 1825 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1826 */     if (null == myGuild) {
/* 1827 */       ret.result = 1;
/* 1828 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1829 */       return ret;
/*      */     } 
/*      */     
/* 1832 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/* 1833 */     if (null == bless) {
/* 1834 */       ret.result = 1;
/* 1835 */       ret.des = "公会祈福不存在";
/* 1836 */       return ret;
/*      */     } 
/*      */     
/* 1839 */     BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.blessLevel);
/* 1840 */     if (blessCount + times > ((BlessLevelCO)blessLevelExt).blessTime) {
/* 1841 */       ret.result = 2;
/* 1842 */       ret.des = "祈福次数不足";
/* 1843 */       return ret;
/*      */     } 
/* 1845 */     if (!bless.isTodayValidBlessId(id)) {
/* 1846 */       ret.result = 3;
/* 1847 */       ret.des = "该祈福道具今日不能使用";
/* 1848 */       return ret;
/*      */     } 
/*      */     
/* 1851 */     ret.result = 0;
/* 1852 */     ret.des = "success";
/* 1853 */     ret.data = (bless.blessAction(id, times, player)).data;
/* 1854 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildResult receiveBlessGift(WNPlayer player, int index) {
/* 1859 */     GuildResult ret = new GuildResult();
/* 1860 */     GuildServiceCenter guildServiceMgr = GuildServiceCenter.getInstance();
/* 1861 */     GuildMemberPO myInfo = guildServiceMgr.getGuildMember(player.getId());
/* 1862 */     if (null == myInfo) {
/* 1863 */       ret.result = 1;
/* 1864 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1865 */       return ret;
/*      */     } 
/*      */     
/* 1868 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1869 */     if (null == myGuild) {
/* 1870 */       ret.result = 1;
/* 1871 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1872 */       return ret;
/*      */     } 
/*      */     
/* 1875 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/* 1876 */     if (null == bless) {
/* 1877 */       ret.result = 1;
/* 1878 */       ret.des = "公会祈福不存在";
/* 1879 */       return ret;
/*      */     } 
/*      */     
/* 1882 */     if (index < 0 || bless.blessData.allBlobData.finishStateArr.length < index) {
/* 1883 */       ret.result = 3;
/* 1884 */       ret.des = "参数错误";
/* 1885 */       return ret;
/*      */     } 
/*      */     
/* 1888 */     if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == bless.blessData.allBlobData.finishStateArr[index]) {
/* 1889 */       ret.result = 2;
/* 1890 */       ret.des = "公会祈福未完成总进度";
/* 1891 */       return ret;
/*      */     } 
/*      */     
/* 1894 */     if (Const.EVENT_GIFT_STATE.RECEIVED.getValue() == bless.blessData.allBlobData.finishStateArr[index]) {
/* 1895 */       ret.result = 4;
/* 1896 */       ret.des = "已领取过改奖励";
/* 1897 */       return ret;
/*      */     } 
/*      */     
/* 1900 */     ret.result = 0;
/* 1901 */     ret.des = "success";
/* 1902 */     ret.data = bless.getGiftAndBuffInfo(index);
/* 1903 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult upgradeBlessLevel(WNPlayer player, int haveGold) {
/* 1907 */     GuildResult ret = new GuildResult();
/* 1908 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 1909 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 1910 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 1911 */     if (null == myInfo || null == myGuild) {
/* 1912 */       ret.result = 1;
/* 1913 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 1914 */       return ret;
/*      */     } 
/* 1916 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/* 1917 */     if (null == bless) {
/* 1918 */       ret.result = 1;
/* 1919 */       ret.des = "公会祈福不存在";
/* 1920 */       return ret;
/*      */     } 
/*      */     
/* 1923 */     if (myInfo.job != Const.GuildJob.PRESIDENT.getValue()) {
/* 1924 */       ret.result = 2;
/* 1925 */       ret.des = "没有祈福升级操作权限";
/* 1926 */       return ret;
/*      */     } 
/* 1928 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.BLESS.getValue());
/* 1929 */     if (bless.level >= buildProp.maxLv) {
/* 1930 */       ret.result = 3;
/* 1931 */       ret.des = "祈福等级已满";
/* 1932 */       return ret;
/*      */     } 
/* 1934 */     BlessLevelExt blessLevelExt = GuildUtil.getBlessPropByLevel(bless.level);
/* 1935 */     if (myGuild.level < ((BlessLevelCO)blessLevelExt).gLevel) {
/* 1936 */       ret.result = 4;
/* 1937 */       ret.des = "公会等级不足";
/* 1938 */       return ret;
/*      */     } 
/* 1940 */     if (haveGold < ((BlessLevelCO)blessLevelExt).gold) {
/* 1941 */       ret.result = 5;
/* 1942 */       ret.des = "银两不足";
/* 1943 */       return ret;
/*      */     } 
/* 1945 */     if (myGuild.fund < ((BlessLevelCO)blessLevelExt).funds) {
/* 1946 */       ret.result = 6;
/* 1947 */       ret.des = "公会资金不足";
/* 1948 */       return ret;
/*      */     } 
/*      */     
/* 1951 */     int preLevel = bless.level;
/* 1952 */     myGuild.fund -= ((BlessLevelCO)blessLevelExt).funds;
/* 1953 */     bless.upgradeLevel(myInfo.playerId);
/* 1954 */     bless.randomBlessItem();
/*      */ 
/*      */     
/* 1957 */     GuildRecordData record = new GuildRecordData();
/* 1958 */     record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
/* 1959 */     record.role1.pro = myInfo.pro;
/* 1960 */     record.role1.name = myInfo.name;
/* 1961 */     record.result.v2 = Integer.toString(bless.level);
/* 1962 */     record.build = buildProp.buildingName;
/* 1963 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 1965 */     GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
/* 1966 */     tmpData.level = bless.level;
/* 1967 */     tmpData.needGold = ((BlessLevelCO)blessLevelExt).gold;
/* 1968 */     tmpData.fund = myGuild.fund;
/* 1969 */     tmpData.id = myGuild.id;
/* 1970 */     tmpData.name = myGuild.name;
/* 1971 */     tmpData.preLevel = preLevel;
/*      */     
/* 1973 */     ret.result = 0;
/* 1974 */     ret.des = "success";
/* 1975 */     ret.data = tmpData;
/* 1976 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult getGuildTodayGoodsList(WNPlayer player) {
/* 1980 */     GuildResult ret = new GuildResult();
/* 1981 */     GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 1982 */     GuildBless bless = blessManager.getBlessByPlayerId(player.getId());
/* 1983 */     if (null == bless) {
/* 1984 */       ret.result = 0;
/* 1985 */       ret.des = "公会商店未开启";
/* 1986 */       ret.goods = null;
/* 1987 */       return ret;
/*      */     } 
/*      */     
/* 1990 */     ret.result = 0;
/* 1991 */     ret.des = "success";
/* 1992 */     ret.goods = bless.goods;
/* 1993 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult getGuildTodayTechData(WNPlayer player) {
/* 1997 */     GuildResult ret = new GuildResult();
/* 1998 */     GuildBlessCenter blessManager = GuildBlessCenter.getInstance();
/* 1999 */     GuildBless bless = blessManager.getBlessByPlayerId(player.getId());
/* 2000 */     if (null == bless) {
/* 2001 */       ret.result = 0;
/* 2002 */       ret.des = "公会修行未开启";
/* 2003 */       ret.techData = null;
/* 2004 */       return ret;
/*      */     } 
/* 2006 */     ret.result = 0;
/* 2007 */     ret.des = "success";
/* 2008 */     ret.techData = bless.tech.toJson4Serialize();
/* 2009 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult techUpgradeLevel(WNPlayer player) {
/* 2013 */     GuildResult ret = new GuildResult();
/* 2014 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2015 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 2016 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 2017 */     if (null == myInfo || null == myGuild) {
/* 2018 */       ret.result = 1;
/* 2019 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 2020 */       return ret;
/*      */     } 
/* 2022 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/* 2023 */     if (null == bless) {
/* 2024 */       ret.result = 1;
/* 2025 */       ret.des = "公会修行不存在";
/* 2026 */       return ret;
/*      */     } 
/*      */     
/* 2029 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 2030 */     if (jobProp.right8 == 0) {
/* 2031 */       ret.result = 2;
/* 2032 */       ret.des = "没有修行升级操作权限";
/* 2033 */       return ret;
/*      */     } 
/*      */     
/* 2036 */     GuildTech tech = bless.tech;
/* 2037 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
/* 2038 */     if (tech.level >= buildProp.maxLv) {
/* 2039 */       ret.result = 3;
/* 2040 */       ret.des = "修行等级已满";
/* 2041 */       return ret;
/*      */     } 
/*      */     
/* 2044 */     GTechnologyLevelCO levelProp = GuildUtil.getTechLevelPropByLevel(tech.level);
/* 2045 */     if (myGuild.level < levelProp.gLevel) {
/* 2046 */       ret.result = 4;
/* 2047 */       ret.des = "公会等级不足";
/* 2048 */       ret.needLevel = levelProp.gLevel;
/* 2049 */       return ret;
/*      */     } 
/* 2051 */     if (player.player.gold < levelProp.gold) {
/* 2052 */       ret.result = 5;
/* 2053 */       ret.des = "银两不足";
/* 2054 */       return ret;
/*      */     } 
/* 2056 */     if (myGuild.fund < levelProp.funds) {
/* 2057 */       ret.result = 6;
/* 2058 */       ret.des = "公会资金不足";
/* 2059 */       return ret;
/*      */     } 
/* 2061 */     myGuild.fund -= levelProp.funds;
/* 2062 */     tech.upgradeLevel(player);
/* 2063 */     bless.saveToRedis();
/*      */     
/* 2065 */     GuildRecordData record = new GuildRecordData();
/* 2066 */     record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
/* 2067 */     record.role1.pro = myInfo.pro;
/* 2068 */     record.role1.name = myInfo.name;
/* 2069 */     record.result.v2 = Integer.toString(tech.level);
/* 2070 */     record.build = buildProp.buildingName;
/* 2071 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 2073 */     GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
/* 2074 */     tmpData.level = tech.level;
/* 2075 */     tmpData.needGold = levelProp.gold;
/* 2076 */     tmpData.fund = myGuild.fund;
/* 2077 */     tmpData.id = myGuild.id;
/* 2078 */     tmpData.name = myGuild.name;
/*      */     
/* 2080 */     ret.result = 0;
/* 2081 */     ret.des = "success";
/* 2082 */     ret.data = tmpData;
/* 2083 */     return ret;
/*      */   }
/*      */   
/*      */   public static GuildResult techUpgradeBuffLevel(WNPlayer player) {
/* 2087 */     GuildResult ret = new GuildResult();
/* 2088 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2089 */     GuildMemberPO myInfo = guildManager.getGuildMember(player.getId());
/* 2090 */     GuildPO myGuild = GuildServiceCenter.getInstance().getGuild(myInfo.guildId);
/* 2091 */     if (null == myInfo || null == myGuild) {
/* 2092 */       ret.result = 1;
/* 2093 */       ret.des = LangService.getValue("GUILD_NOT_JOIN");
/* 2094 */       return ret;
/*      */     } 
/* 2096 */     GuildBless bless = GuildBlessCenter.getInstance().getBless(myInfo.guildId);
/* 2097 */     if (null == bless) {
/* 2098 */       ret.result = 1;
/* 2099 */       ret.des = "公会修行不存在";
/* 2100 */       return ret;
/*      */     } 
/* 2102 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 2103 */     if (jobProp.right9 == 0) {
/* 2104 */       ret.result = 2;
/* 2105 */       ret.des = "没有修行增益属性升级操作权限";
/* 2106 */       return ret;
/*      */     } 
/*      */     
/* 2109 */     GuildTech tech = bless.tech;
/* 2110 */     GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
/* 2111 */     if (tech.buffLevel >= buildProp.maxLv) {
/* 2112 */       ret.result = 3;
/* 2113 */       ret.des = "修行Buff等级已满";
/* 2114 */       return ret;
/*      */     } 
/* 2116 */     if (tech.buffLevel >= tech.level) {
/* 2117 */       ret.result = 4;
/* 2118 */       ret.des = "需要升级修行";
/* 2119 */       return ret;
/*      */     } 
/* 2121 */     GBuffExt gBuffExt = GuildUtil.getTechBuffPropByLevel(tech.buffLevel);
/* 2122 */     if (myGuild.fund < ((GBuffCO)gBuffExt).funds) {
/* 2123 */       ret.result = 5;
/* 2124 */       ret.des = "公会资金不足";
/* 2125 */       return ret;
/*      */     } 
/*      */     
/* 2128 */     myGuild.fund -= ((GBuffCO)gBuffExt).funds;
/* 2129 */     tech.upgradeBuffLevel(player);
/* 2130 */     bless.saveToRedis();
/*      */     
/* 2132 */     GuildRecordData record = new GuildRecordData();
/* 2133 */     record.type = Const.GuildRecord.UPGRADE_BUILDING.getValue();
/* 2134 */     record.role1.pro = myInfo.pro;
/* 2135 */     record.role1.name = myInfo.name;
/* 2136 */     record.result.v2 = Integer.toString(tech.buffLevel);
/* 2137 */     record.build = buildProp.buildingName2;
/* 2138 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 2140 */     GuildResult.UpgradeLevel tmpData = new GuildResult.UpgradeLevel();
/* 2141 */     tmpData.fund = myGuild.fund;
/* 2142 */     tmpData.buffLevel = tech.buffLevel;
/* 2143 */     ret.result = 0;
/* 2144 */     ret.des = "success";
/* 2145 */     ret.data = tmpData;
/* 2146 */     return ret;
/*      */   }
/*      */   
/*      */   public static boolean playerIsPresident(String playerId) {
/* 2150 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
/* 2151 */     if (null != myInfo && Const.GuildJob.PRESIDENT.getValue() == myInfo.job) {
/* 2152 */       return true;
/*      */     }
/* 2154 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean playerRemoveGuildData(String playerId, boolean isSave) {
/* 2158 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2159 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2160 */     if (null != myInfo && Const.GuildJob.PRESIDENT.getValue() == myInfo.job) {
/* 2161 */       return false;
/*      */     }
/*      */     
/* 2164 */     if (isSave) {
/* 2165 */       return true;
/*      */     }
/*      */     
/* 2168 */     if (null == myInfo) {
/* 2169 */       guildManager.removeAllPlayerApplyAsync(playerId);
/* 2170 */       return true;
/*      */     } 
/*      */     
/* 2173 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/* 2174 */     if (null != myGuild) {
/* 2175 */       GuildRecordData record = new GuildRecordData(Const.GuildRecord.EXIT.getValue(), myInfo, null);
/* 2176 */       guildManager.addGuildRecord(myGuild.id, record);
/*      */     } 
/*      */     
/* 2179 */     guildManager.removeMember(playerId);
/* 2180 */     guildManager.removeAllPlayerApplyAsync(playerId);
/* 2181 */     return true;
/*      */   }
/*      */   
/*      */   public static boolean setDungeonCloseTime(final String guildId, Date openTime) {
/* 2185 */     long lastTime = System.currentTimeMillis() - openTime.getTime();
/* 2186 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2187 */     lastTime = ((dungeonConfig.fightTime + dungeonConfig.openForReady) * Const.Time.Minute.getValue()) - lastTime;
/*      */     
/* 2189 */     if (lastTime <= 0L) {
/* 2190 */       GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2191 */       if (dungeonInfo.openState <= 0) {
/* 2192 */         return false;
/*      */       }
/* 2194 */       dungeonInfo.openState = 0;
/* 2195 */       dungeonInfo.dungeonPassedTime = new Date();
/* 2196 */       dungeonInfo.instanceId = "";
/* 2197 */       dungeonInfo.serverId = "";
/* 2198 */       GuildUtil.updateGuildDungeon(dungeonInfo);
/* 2199 */       return false;
/*      */     } 
/*      */     
/* 2202 */     JobFactory.addDelayJob(new Runnable()
/*      */         {
/*      */           public void run() {
/* 2205 */             GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2206 */             String instanceId = dungeonInfo.instanceId;
/*      */             
/* 2208 */             if (dungeonInfo.openState > 0) {
/* 2209 */               dungeonInfo.openState = 0;
/* 2210 */               dungeonInfo.dungeonPassedTime = new Date();
/* 2211 */               dungeonInfo.instanceId = "";
/* 2212 */               dungeonInfo.serverId = "";
/* 2213 */               GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */             } 
/*      */             
/* 2216 */             if (!StringUtil.isNullOrEmpty(instanceId));
/*      */           }
/*      */         },  lastTime);
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
/* 2230 */     return true;
/*      */   }
/*      */   
/*      */   public static void setDungeonThrowRewardTimeByopenTime(final String guildId, Date openTime) {
/* 2234 */     long lastTime = System.currentTimeMillis() - openTime.getTime();
/* 2235 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2236 */     lastTime = ((dungeonConfig.fightTime + dungeonConfig.openForReady + dungeonConfig.throwTime) * Const.Time.Minute.getValue()) - lastTime;
/* 2237 */     if (lastTime <= 0L) {
/* 2238 */       GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2239 */       if (dungeonInfo.bReward <= 0) {
/*      */         return;
/*      */       }
/*      */       
/* 2243 */       for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
/* 2244 */         GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
/* 2245 */         if (null != info.mostPointPlayerId && !info.mostPointPlayerId.isEmpty()) {
/*      */ 
/*      */ 
/*      */           
/* 2249 */           MailSysData mailData = new MailSysData("Guild_dungeon_roll");
/* 2250 */           mailData.attachments = new ArrayList();
/* 2251 */           MailData.Attachment attach = new MailData.Attachment();
/* 2252 */           attach.itemCode = info.dropItem.code;
/* 2253 */           attach.itemNum = 1;
/* 2254 */           mailData.attachments.add(attach);
/* 2255 */           mailData.entityItems = new ArrayList();
/* 2256 */           mailData.entityItems.add(info.dropItem);
/* 2257 */           MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*      */         } 
/*      */       } 
/* 2260 */       dungeonInfo.bReward = 1;
/* 2261 */       GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */       
/*      */       return;
/*      */     } 
/* 2265 */     JobFactory.addDelayJob(new Runnable()
/*      */         {
/*      */           public void run() {
/* 2268 */             GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2269 */             if (dungeonInfo.bReward > 0) {
/*      */               return;
/*      */             }
/* 2272 */             for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
/* 2273 */               GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
/* 2274 */               if (!StringUtil.isNullOrEmpty(info.mostPointPlayerId)) {
/*      */ 
/*      */                 
/* 2277 */                 MailSysData mailData = new MailSysData("Guild_dungeon_roll");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2283 */                 mailData.entityItems = new ArrayList();
/* 2284 */                 mailData.entityItems.add(info.dropItem);
/* 2285 */                 MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*      */               } 
/*      */             } 
/* 2288 */             dungeonInfo.bReward = 1;
/* 2289 */             GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */           }
/*      */         }lastTime);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setDungeonOpenTime(final String playerId, final String guildId, int readyTime) {
/* 2296 */     JobFactory.addDelayJob(new Runnable()
/*      */         {
/*      */           public void run() {
/* 2299 */             GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2300 */             Set<String> playerIds = guildManager.getGuildMemberIdList(guildId);
/* 2301 */             playerIds.remove(playerId);
/* 2302 */             GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_OPEN.getValue(), null);
/* 2303 */             GuildService.notifySomePlayerRefreshGuild(playerIds, msg, null);
/*      */           }
/*      */         }(readyTime * 60 * 1000));
/*      */   }
/*      */   
/*      */   public static int getGuildDungeonState(String playerId) {
/* 2309 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
/* 2310 */     if (null != myInfo) {
/* 2311 */       GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2312 */       if (null != dungeonInfo) {
/* 2313 */         return dungeonInfo.openState;
/*      */       }
/*      */     } 
/* 2316 */     return 0;
/*      */   }
/*      */   
/*      */   public static void clearDungeonState(String playerId) {
/* 2320 */     GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
/* 2321 */     if (null != myInfo) {
/* 2322 */       GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2323 */       if (null != dungeonInfo) {
/* 2324 */         dungeonInfo.enterState = 0;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public static OpenGuildDungeonResult openGuildDungeon(String playerId) {
/* 2330 */     OpenGuildDungeonResult data = new OpenGuildDungeonResult();
/* 2331 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2332 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2333 */     if (null == myInfo) {
/* 2334 */       data.result = false;
/* 2335 */       data.info = LangService.getValue("GUILD_NOT_JOIN");
/* 2336 */       return data;
/*      */     } 
/*      */     
/* 2339 */     GuildPositionCO jobProp = GuildUtil.getGuildJobPropByJobId(myInfo.job);
/* 2340 */     if (jobProp.right10 == 0) {
/* 2341 */       data.result = false;
/* 2342 */       data.info = LangService.getValue("GUILD_NO_POWER");
/* 2343 */       return data;
/*      */     } 
/*      */     
/* 2346 */     GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/* 2347 */     if (null == myGuild) {
/* 2348 */       data.result = false;
/* 2349 */       data.info = LangService.getValue("GUILD_NOT_EXIST");
/* 2350 */       return data;
/*      */     } 
/*      */     
/* 2353 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2354 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2355 */     Date now = new Date();
/*      */     
/* 2357 */     if (DateUtil.canRefreshData(5, dungeonInfo.openTime)) {
/* 2358 */       dungeonInfo.openTimesToday = 0;
/*      */     }
/*      */     
/* 2361 */     if (dungeonInfo.openTimesToday >= dungeonConfig.openTime) {
/* 2362 */       data.result = false;
/* 2363 */       data.info = LangService.getValue("GDUNGEON_OPEN_MAX");
/* 2364 */       return data;
/*      */     } 
/* 2366 */     if (dungeonInfo.openState > 0) {
/* 2367 */       data.result = false;
/* 2368 */       data.info = LangService.getValue("GDUNGEON_FIGHTING");
/* 2369 */       return data;
/*      */     } 
/*      */     
/* 2372 */     if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() < (dungeonConfig.openCD * Const.Time.Minute.getValue())) {
/* 2373 */       data.result = false;
/* 2374 */       data.info = LangService.getValue("GDUNGEON_OPEN_CD");
/* 2375 */       return data;
/*      */     } 
/*      */     
/* 2378 */     dungeonInfo.openTimesToday++;
/* 2379 */     dungeonInfo.openTime = now;
/* 2380 */     dungeonInfo.openState = 1;
/* 2381 */     dungeonInfo.bReward = 0;
/*      */     
/* 2383 */     dungeonInfo.dungeonPassedTime = new Date(0L);
/*      */     
/* 2385 */     dungeonInfo.dungeonRecord = new HashMap<>();
/* 2386 */     dungeonInfo.instanceId = "";
/* 2387 */     dungeonInfo.serverId = "";
/* 2388 */     dungeonInfo.throwInfo = new ArrayList();
/* 2389 */     dungeonInfo.damagePlayer = new HashMap<>();
/* 2390 */     dungeonInfo.damageRankInfo = new ArrayList();
/* 2391 */     dungeonInfo.healRankInfo = new ArrayList();
/*      */     
/* 2393 */     dungeonInfo.currPassedCount = 0;
/* 2394 */     dungeonInfo.totalPassedCount = myGuild.level;
/*      */     
/* 2396 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */     
/* 2398 */     setDungeonCloseTime(myInfo.guildId, dungeonInfo.openTime);
/* 2399 */     setDungeonThrowRewardTimeByopenTime(myInfo.guildId, dungeonInfo.openTime);
/* 2400 */     setDungeonOpenTime(playerId, myInfo.guildId, dungeonConfig.openForReady);
/*      */     
/* 2402 */     data.waitTime = (dungeonConfig.openForReady * 60);
/*      */     
/* 2404 */     GuildMsg.OnChatGuildMsg msgData = new GuildMsg.OnChatGuildMsg();
/* 2405 */     msgData.playerId = playerId;
/* 2406 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_OPEN_CHAT.getValue(), msgData);
/*      */     
/* 2408 */     notifyAllMemberRefreshGuild(myGuild.id, msg, null);
/*      */ 
/*      */     
/* 2411 */     GuildRecordData record = new GuildRecordData();
/* 2412 */     record.type = Const.GuildRecord.OPEN_GUILD_DUNGEON.getValue();
/* 2413 */     record.role1.pro = myInfo.pro;
/* 2414 */     record.role1.name = myInfo.name;
/* 2415 */     guildManager.addGuildRecord(myGuild.id, record);
/*      */     
/* 2417 */     Set<String> playerIds = guildManager.getGuildMemberIdList(myInfo.guildId);
/* 2418 */     MailSysData mailData = new MailSysData("Guild_dungeon_open");
/* 2419 */     mailData.replace = new HashMap<>();
/* 2420 */     mailData.replace.put("time", now.toString());
/*      */     
/* 2422 */     MailUtil.getInstance().sendMailToSomePlayer(playerIds.<String>toArray(new String[playerIds.size()]), (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/* 2423 */     return data;
/*      */   }
/*      */   
/*      */   public static GuildManagerHandler.DungeonList guildDungeonList(String playerId) {
/* 2427 */     GuildManagerHandler.DungeonList.Builder data = GuildManagerHandler.DungeonList.newBuilder();
/* 2428 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2429 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2430 */     if (null == myInfo) {
/* 2431 */       return data.build();
/*      */     }
/* 2433 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2434 */     Date now = new Date();
/* 2435 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2436 */     data.setOpenTime(dungeonConfig.openForReady * Const.Time.Minute.getValue() / 1000);
/* 2437 */     if (dungeonInfo.openState > 0) {
/* 2438 */       int tmpTime = (int)(dungeonInfo.openTime.getTime() + (dungeonConfig.openForReady * Const.Time.Minute.getValue()));
/* 2439 */       data.setTime(tmpTime);
/* 2440 */       if (now.getTime() > data.getTime()) {
/* 2441 */         data.setTime(data.getTime() + dungeonConfig.fightTime * Const.Time.Minute.getValue());
/* 2442 */         data.setState(3);
/*      */       } else {
/* 2444 */         data.setState(2);
/*      */       } 
/* 2446 */       data.setCurrDungeonCount(dungeonInfo.currPassedCount + 1);
/*      */     } else {
/* 2448 */       if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() < (dungeonConfig.openCD * Const.Time.Minute.getValue())) {
/* 2449 */         data.setState(4);
/*      */       } else {
/* 2451 */         data.setState(1);
/*      */       } 
/* 2453 */       int tmpTime2 = (int)(dungeonInfo.dungeonPassedTime.getTime() + (dungeonConfig.throwTime * Const.Time.Minute.getValue()));
/* 2454 */       data.setTime(tmpTime2);
/* 2455 */       data.setCurrDungeonCount(0);
/*      */     } 
/*      */     
/* 2458 */     data.setTime((int)Math.floor(data.getTime() * 0.001D));
/*      */     
/* 2460 */     data.setMaxDungeonCount(dungeonInfo.totalPassedCount);
/*      */     
/* 2462 */     if (dungeonInfo.totalPassedCount == 0) {
/* 2463 */       GuildPO myGuild = guildManager.getGuild(myInfo.guildId);
/* 2464 */       if (null != myGuild) {
/* 2465 */         data.setMaxDungeonCount(myGuild.level);
/*      */       }
/*      */     } 
/*      */     
/* 2469 */     List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));
/*      */ 
/*      */ 
/*      */     
/* 2473 */     props.sort(new Comparator<GDungeonMapCO>()
/*      */         {
/*      */           public int compare(GDungeonMapCO o1, GDungeonMapCO o2) {
/* 2476 */             return o1.layer - o2.layer;
/*      */           }
/*      */         });
/*      */     
/* 2480 */     for (int i = 0; i < props.size(); i++) {
/* 2481 */       GDungeonMapCO prop = props.get(i);
/* 2482 */       GuildDungeonRecord recordInfo = (GuildDungeonRecord)dungeonInfo.dungeonRecord.get(Integer.valueOf(i + 1));
/* 2483 */       GuildManagerHandler.DungeonInfo.Builder dungeon = GuildManagerHandler.DungeonInfo.newBuilder();
/* 2484 */       dungeon.setDungeonId(prop.mapID);
/* 2485 */       if (null != recordInfo) {
/* 2486 */         if (null != recordInfo.killPlayerId && !recordInfo.killPlayerId.isEmpty()) {
/* 2487 */           PlayerPO killPlayer = PlayerUtil.getPlayerBaseData(recordInfo.killPlayerId);
/* 2488 */           dungeon.setKilledPlayerInfo(PlayerUtil.playerBasicData(killPlayer));
/*      */         } 
/* 2490 */         dungeon.setCurrPlayerNum(recordInfo.currPlayerNum);
/*      */       } 
/*      */       
/* 2493 */       dungeon.setTotalPlayerNum(prop.allowedPlayers);
/* 2494 */       data.setDungeonList(i, dungeon);
/*      */     } 
/*      */ 
/*      */     
/* 2498 */     return data.build();
/*      */   }
/*      */   
/*      */   public static GuildDungeonResult joinGuildDungeon(String playerId, int playerLevel) {
/* 2502 */     GuildDungeonResult data = new GuildDungeonResult();
/* 2503 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2504 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2505 */     if (null == myInfo) {
/* 2506 */       data.result = false;
/* 2507 */       data.info = LangService.getValue("GUILD_NOT_JOIN");
/* 2508 */       return data;
/*      */     } 
/* 2510 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2511 */     if (dungeonInfo.openState <= 0) {
/* 2512 */       data.result = false;
/* 2513 */       data.info = LangService.getValue("GDUNGEON_NOTOPEN");
/* 2514 */       return data;
/*      */     } 
/* 2516 */     if (dungeonInfo.enterState == 1) {
/* 2517 */       data.result = false;
/* 2518 */       data.info = LangService.getValue("GDUNGEON_ENTER_ERROR");
/* 2519 */       return data;
/*      */     } 
/*      */     
/* 2522 */     Date now = new Date();
/* 2523 */     long diffTime = now.getTime() - dungeonInfo.openTime.getTime();
/* 2524 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2525 */     if (diffTime < (dungeonConfig.openForReady * Const.Time.Minute.getValue())) {
/* 2526 */       data.result = false;
/* 2527 */       data.info = LangService.getValue("GDUNGEON_OPEN_GETREADY");
/* 2528 */       return data;
/*      */     } 
/*      */     
/* 2531 */     List<GDungeonMapCO> props = GuildCommonUtil.findAndSortDungeonMap();
/* 2532 */     GDungeonMapCO prop = props.get(dungeonInfo.currPassedCount);
/* 2533 */     if (null == prop) {
/* 2534 */       data.result = false;
/* 2535 */       data.info = LangService.getValue("PARAM_ERROR");
/* 2536 */       return data;
/*      */     } 
/*      */     
/* 2539 */     if (playerLevel < prop.reqLevel) {
/* 2540 */       data.result = false;
/* 2541 */       data.info = LangService.getValue("DUNGEON_LEVEL_NOT_ENOUGH");
/* 2542 */       return data;
/*      */     } 
/* 2544 */     GuildDungeonRecord recordInfo = (GuildDungeonRecord)dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonInfo.currPassedCount + 1));
/* 2545 */     if (null != recordInfo && recordInfo.currPlayerNum >= prop.allowedPlayers) {
/* 2546 */       data.result = false;
/* 2547 */       data.info = LangService.getValue("GDUNGEON_PLAYER_MAX");
/* 2548 */       return data;
/*      */     } 
/*      */     
/* 2551 */     data.dungeonId = prop.mapID;
/* 2552 */     data.guildId = myInfo.guildId;
/* 2553 */     data.maxCountDungeonId = ((GDungeonMapCO)props.get(dungeonInfo.totalPassedCount - 1)).mapID;
/* 2554 */     data.instanceId = dungeonInfo.instanceId;
/* 2555 */     data.dungeonCount = dungeonInfo.currPassedCount + 1;
/*      */     
/* 2557 */     if (data.instanceId.isEmpty()) {
/* 2558 */       dungeonInfo.enterState = 1;
/*      */     }
/*      */     
/* 2561 */     return data;
/*      */   }
/*      */   
/*      */   public static ArrayList<GuildManagerHandler.RankInfo> dungeonRank(String playerId, int type) {
/* 2565 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2566 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/*      */     
/* 2568 */     if (null == myInfo) {
/* 2569 */       return null;
/*      */     }
/* 2571 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2572 */     if (type == 1) {
/* 2573 */       return dungeonInfo.damageRankInfo;
/*      */     }
/* 2575 */     return dungeonInfo.healRankInfo;
/*      */   }
/*      */ 
/*      */   
/*      */   public static GuildDungeonAward dungeonAwardInfo(String playerId) {
/* 2580 */     GuildDungeonAward data = new GuildDungeonAward();
/* 2581 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2582 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2583 */     PlayerBasePO basePO = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);
/*      */     
/* 2585 */     if (null == myInfo) {
/* 2586 */       return data;
/*      */     }
/*      */     
/* 2589 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/*      */     
/* 2591 */     if (dungeonInfo.openState > 0) {
/* 2592 */       data.isFightOver = 0;
/* 2593 */       return data;
/*      */     } 
/*      */     
/* 2596 */     Date now = new Date();
/*      */     
/* 2598 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/*      */     
/* 2600 */     long timeInterval = now.getTime() - dungeonInfo.dungeonPassedTime.getTime();
/*      */     
/* 2602 */     if (timeInterval < (dungeonConfig.throwTime * Const.Time.Minute.getValue()))
/*      */     {
/* 2604 */       data.diceLeftTime = (int)Math.floor(((dungeonConfig.throwTime * Const.Time.Minute.getValue()) - timeInterval) * 0.001D);
/*      */     }
/*      */     
/* 2607 */     data.getDungeonScoreInfo = getDungeonScoreInfo(dungeonInfo, playerId);
/*      */     
/* 2609 */     ArrayList<GuildManagerHandler.AwardInfo> itemInfos = new ArrayList<>();
/* 2610 */     for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
/* 2611 */       GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
/*      */       
/* 2613 */       GuildManagerHandler.AwardInfo.Builder itemInfo = GuildManagerHandler.AwardInfo.newBuilder();
/* 2614 */       itemInfo.setPos(i);
/* 2615 */       itemInfo.setDropItem(ItemUtil.createItemByDbOpts(info.dropItem).getItemDetail(basePO));
/* 2616 */       itemInfo.setDungeonCount(info.dungeonCount);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2621 */       if (null != info.mostPointPlayerName && !info.mostPointPlayerName.isEmpty()) {
/* 2622 */         itemInfo.setPlayerName(info.mostPointPlayerName);
/* 2623 */         itemInfo.setPlayerPro(info.mostPointPlayerPro);
/* 2624 */         itemInfo.setPlayerDicePoint(info.mostPoint);
/*      */       } 
/*      */       
/* 2627 */       for (int id = 0; id < info.diceInfo.size(); id++) {
/* 2628 */         itemInfo.setDiceInfo(id, (GuildManagerHandler.DiceInfo)info.diceInfo.get(Integer.valueOf(id)));
/*      */       }
/*      */       
/* 2631 */       if (null != info.diceInfo.get(playerId)) {
/* 2632 */         itemInfo.setState(1);
/* 2633 */       } else if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
/* 2634 */         itemInfo.setState(2);
/*      */       } else {
/* 2636 */         itemInfo.setState(3);
/*      */       } 
/*      */       
/* 2639 */       itemInfos.add(itemInfo.build());
/*      */     } 
/*      */     
/* 2642 */     itemInfos.sort(new Comparator<GuildManagerHandler.AwardInfo>()
/*      */         {
/*      */           public int compare(GuildManagerHandler.AwardInfo o1, GuildManagerHandler.AwardInfo o2) {
/* 2645 */             int QColor1 = (ItemUtil.getPropByCode(o1.toBuilder().getDropItem().getCode())).qcolor;
/* 2646 */             int QColor2 = (ItemUtil.getPropByCode(o2.toBuilder().getDropItem().getCode())).qcolor;
/* 2647 */             return (QColor1 > QColor2) ? 1 : -1;
/*      */           }
/*      */         });
/*      */     
/* 2651 */     data.itemInfos = itemInfos;
/* 2652 */     return data;
/*      */   }
/*      */   
/*      */   public static boolean isDamagePlayer(Map<Integer, ArrayList<String>> damagePlayer, int dungeonCount, String playerId) {
/* 2656 */     ArrayList<String> eachCountDamage = damagePlayer.get(Integer.valueOf(dungeonCount));
/* 2657 */     if (null != eachCountDamage && eachCountDamage.size() > 0 && 
/* 2658 */       eachCountDamage.indexOf(playerId) != -1) {
/* 2659 */       return true;
/*      */     }
/*      */     
/* 2662 */     return false;
/*      */   }
/*      */   
/*      */   public static ArrayList<GuildManagerHandler.GetDungeonScoreInfo> getDungeonScoreInfo(GuildDungeonPO dungeonInfo, String playerId) {
/* 2666 */     ArrayList<GuildManagerHandler.GetDungeonScoreInfo> data = new ArrayList<>();
/* 2667 */     if (dungeonInfo.currPassedCount > 0) {
/* 2668 */       GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
/* 2669 */       dungeonScoreInfo.setType(1);
/* 2670 */       dungeonScoreInfo.setValue(dungeonInfo.currPassedCount);
/* 2671 */       int dungeonScore = 0;
/* 2672 */       List<GDungeonMapCO> props = GuildCommonUtil.findAndSortDungeonMap();
/*      */       
/* 2674 */       for (int i = 0; i < dungeonInfo.currPassedCount; i++) {
/* 2675 */         if (isDamagePlayer(dungeonInfo.damagePlayer, i + 1, playerId)) {
/* 2676 */           dungeonScore += ((GDungeonMapCO)props.get(i)).gpoints;
/*      */         }
/*      */       } 
/* 2679 */       dungeonScoreInfo.setScore(dungeonScore);
/*      */       
/* 2681 */       data.add(dungeonScoreInfo.build());
/*      */     } 
/*      */     
/* 2684 */     int rank = getRank(dungeonInfo.damageRankInfo, playerId);
/*      */     
/* 2686 */     if (rank > 0) {
/* 2687 */       List<GDungeonRankCO> list = GameData.findGDungeonRanks(t -> 
/* 2688 */           (t.rankType == 1 && t.openTime == getRank(dungeonInfo.damageRankInfo, playerId)));
/*      */ 
/*      */       
/* 2691 */       GDungeonRankCO rankProp = null;
/* 2692 */       if (null != list && list.size() > 0) {
/* 2693 */         rankProp = list.get(0);
/*      */       }
/* 2695 */       if (null != rankProp) {
/* 2696 */         GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
/* 2697 */         dungeonScoreInfo.setType(2);
/* 2698 */         dungeonScoreInfo.setValue(rank);
/* 2699 */         dungeonScoreInfo.setScore(rankProp.gpoints);
/* 2700 */         data.add(dungeonScoreInfo.build());
/*      */       } 
/*      */     } 
/*      */     
/* 2704 */     if (rank > 0) {
/* 2705 */       rank = getRank(dungeonInfo.healRankInfo, playerId);
/* 2706 */       GDungeonRankCO rankProp = null;
/* 2707 */       List<GDungeonRankCO> list = GameData.findGDungeonRanks(t -> 
/* 2708 */           (t.rankType == 2 && t.openTime == getRank(dungeonInfo.healRankInfo, playerId)));
/*      */ 
/*      */       
/* 2711 */       if (null != list && list.size() > 0) {
/* 2712 */         rankProp = list.get(0);
/*      */       }
/*      */       
/* 2715 */       if (null != rankProp) {
/*      */         
/* 2717 */         GuildManagerHandler.GetDungeonScoreInfo.Builder dungeonScoreInfo = GuildManagerHandler.GetDungeonScoreInfo.newBuilder();
/* 2718 */         dungeonScoreInfo.setType(3);
/* 2719 */         dungeonScoreInfo.setValue(rank);
/* 2720 */         dungeonScoreInfo.setScore(rankProp.gpoints);
/*      */         
/* 2722 */         data.add(dungeonScoreInfo.build());
/*      */       } 
/*      */     } 
/* 2725 */     return data;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getRank(ArrayList<GuildManagerHandler.RankInfo> rankInfo, String playerId) {
/* 2730 */     for (int i = 0; i < rankInfo.size(); i++) {
/* 2731 */       if (((GuildManagerHandler.RankInfo)rankInfo.get(i)).getPlayerId() == playerId) {
/* 2732 */         return i + 1;
/*      */       }
/*      */     } 
/* 2735 */     return 0;
/*      */   }
/*      */   
/*      */   public static GuildDiceAwardResult diceAward(String playerId, int pos) {
/* 2739 */     GuildDiceAwardResult data = new GuildDiceAwardResult();
/* 2740 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2741 */     GuildMemberPO myInfo = guildManager.getGuildMember(playerId);
/* 2742 */     PlayerBasePO basePO = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);
/*      */     
/* 2744 */     if (null == myInfo) {
/* 2745 */       data.result = false;
/* 2746 */       data.info = LangService.getValue("GUILD_NOT_JOIN");
/* 2747 */       return data;
/*      */     } 
/*      */     
/* 2750 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(myInfo.guildId);
/* 2751 */     GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(pos);
/*      */     
/* 2753 */     if (null != info.diceInfo.get(playerId)) {
/* 2754 */       data.result = false;
/* 2755 */       data.info = LangService.getValue("ROLL_COMPLETED");
/* 2756 */       return data;
/* 2757 */     }  if (!isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
/* 2758 */       data.result = false;
/* 2759 */       data.info = LangService.getValue("ROLL_NORIGHT");
/* 2760 */       return data;
/*      */     } 
/*      */     
/* 2763 */     if (dungeonInfo.openState != 0) {
/* 2764 */       data.result = false;
/* 2765 */       data.info = LangService.getValue("ROLL_NOTOPEN");
/* 2766 */       return data;
/*      */     } 
/*      */     
/* 2769 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/*      */     
/* 2771 */     Date now = new Date();
/*      */     
/* 2773 */     if (now.getTime() - dungeonInfo.dungeonPassedTime.getTime() > (dungeonConfig.throwTime * Const.Time.Minute.getValue())) {
/* 2774 */       data.result = false;
/* 2775 */       data.info = LangService.getValue("ROLL_END");
/* 2776 */       return data;
/*      */     } 
/*      */     
/* 2779 */     PlayerPO player = PlayerUtil.getPlayerBaseData(playerId);
/* 2780 */     int point = Utils.random(0, 100);
/* 2781 */     GuildManagerHandler.DiceInfo.Builder tmpDiceInfo = GuildManagerHandler.DiceInfo.newBuilder();
/* 2782 */     tmpDiceInfo.setPlayerName(player.name);
/* 2783 */     tmpDiceInfo.setPlayerPro(player.pro);
/* 2784 */     tmpDiceInfo.setDicePoint(point);
/* 2785 */     info.diceInfo.put(playerId, tmpDiceInfo.build());
/*      */     
/* 2787 */     if (info.mostPoint == 0 || point > info.mostPoint) {
/* 2788 */       info.mostPointPlayerId = playerId;
/* 2789 */       info.mostPointPlayerName = player.name;
/* 2790 */       info.mostPointPlayerPro = player.pro;
/* 2791 */       info.mostPoint = point;
/*      */     } 
/*      */     
/* 2794 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */     
/* 2796 */     GuildManagerHandler.AwardInfo.Builder itemInfo = GuildManagerHandler.AwardInfo.newBuilder();
/* 2797 */     itemInfo.setPos(pos);
/* 2798 */     itemInfo.setDropItem(ItemUtil.createItemByDbOpts(info.dropItem).getItemDetail(basePO));
/* 2799 */     itemInfo.setDungeonCount(info.dungeonCount);
/* 2800 */     itemInfo.setPlayerName(info.mostPointPlayerName);
/* 2801 */     itemInfo.setPlayerPro(info.mostPointPlayerPro);
/* 2802 */     itemInfo.setPlayerDicePoint(info.mostPoint);
/*      */     
/* 2804 */     for (int i = 0; i < info.diceInfo.size(); i++) {
/* 2805 */       GuildManagerHandler.DiceInfo diceInfo = (GuildManagerHandler.DiceInfo)info.diceInfo.get(playerId);
/* 2806 */       itemInfo.setDiceInfo(i, diceInfo);
/*      */     } 
/*      */     
/* 2809 */     if (null != info.diceInfo.get(playerId)) {
/* 2810 */       itemInfo.setState(1);
/* 2811 */     } else if (isDamagePlayer(dungeonInfo.damagePlayer, info.dungeonCount, playerId)) {
/* 2812 */       itemInfo.setState(2);
/*      */     } else {
/* 2814 */       itemInfo.setState(3);
/*      */     } 
/*      */     
/* 2817 */     data.itemInfo = itemInfo.build();
/* 2818 */     return data;
/*      */   }
/*      */   
/*      */   public static void dungeonPass(String guildId, int dungeonCount, String killPlayerId) {
/* 2822 */     GuildServiceCenter guildManager = GuildServiceCenter.getInstance();
/* 2823 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/*      */     
/* 2825 */     if (dungeonInfo.openState <= 0) {
/*      */       return;
/*      */     }
/*      */     
/* 2829 */     dungeonInfo.currPassedCount = dungeonCount;
/* 2830 */     dungeonInfo.instanceId = "";
/* 2831 */     dungeonInfo.serverId = "";
/*      */     
/* 2833 */     if (dungeonInfo.currPassedCount >= dungeonInfo.totalPassedCount) {
/* 2834 */       dungeonInfo.openState = 0;
/* 2835 */       dungeonInfo.dungeonPassedTime = new Date();
/* 2836 */       setDungeonThrowRewardTimeByPassedTime(guildId, dungeonInfo.dungeonPassedTime);
/*      */ 
/*      */       
/* 2839 */       GuildRecordData record = new GuildRecordData();
/* 2840 */       record.type = Const.GuildRecord.GUILD_DUNGEON_PASS.getValue();
/* 2841 */       GuildMemberPO myInfo = guildManager.getGuildMember(killPlayerId);
/* 2842 */       if (null != myInfo) {
/* 2843 */         record.role1 = new RoleInfo();
/* 2844 */         record.role1.pro = myInfo.pro;
/* 2845 */         record.role1.name = myInfo.name;
/* 2846 */         GuildPO myGuild = guildManager.getGuild(guildId);
/* 2847 */         guildManager.addGuildRecord(myGuild.id, record);
/*      */       } 
/*      */     } 
/* 2850 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */     
/* 2852 */     GuildMsg.DungeonPassGuildMsg msgData = new GuildMsg.DungeonPassGuildMsg();
/* 2853 */     msgData.dungeonCount = dungeonCount + 1;
/* 2854 */     GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_PASS.getValue(), msgData);
/* 2855 */     notifyAllMemberRefreshGuild(guildId, msg, null);
/*      */   }
/*      */   
/*      */   public static void setDungeonThrowRewardTimeByPassedTime(final String guildId, Date dungeonPassedTime) {
/* 2859 */     long hasPassedTime = System.currentTimeMillis() - dungeonPassedTime.getTime();
/* 2860 */     GDungeonCO dungeonConfig = GuildUtil.getGuildDungeonConfig();
/* 2861 */     long leftTime = (dungeonConfig.throwTime * Const.Time.Minute.getValue()) - hasPassedTime;
/*      */     
/* 2863 */     if (leftTime < 0L) {
/*      */       return;
/*      */     }
/* 2866 */     JobFactory.addDelayJob(new Runnable()
/*      */         {
/*      */           public void run() {
/* 2869 */             GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2870 */             if (dungeonInfo.bReward > 0)
/*      */               return; 
/* 2872 */             for (int i = 0; i < dungeonInfo.throwInfo.size(); i++) {
/* 2873 */               GuildDungeonThrowInfo info = dungeonInfo.throwInfo.get(i);
/* 2874 */               if (!StringUtil.isNullOrEmpty(info.mostPointPlayerId)) {
/*      */ 
/*      */                 
/* 2877 */                 MailSysData mailData = new MailSysData("Guild_dungeon_roll");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2883 */                 mailData.entityItems = new ArrayList();
/* 2884 */                 mailData.entityItems.add(info.dropItem);
/* 2885 */                 MailUtil.getInstance().sendMailToOnePlayer(info.mostPointPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.guild_mail);
/*      */               } 
/* 2887 */             }  dungeonInfo.bReward = 1;
/* 2888 */             GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */           }
/*      */         }leftTime);
/*      */   }
/*      */   
/*      */   public static void updatePlayerNum(String guildId, int dungeonCount, int playerNum) {
/* 2894 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2895 */     GuildDungeonRecord recordInfo = (GuildDungeonRecord)dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonCount));
/* 2896 */     if (null != recordInfo) {
/* 2897 */       playerNumNotify(guildId, dungeonInfo.currPassedCount, recordInfo.currPlayerNum, playerNum);
/* 2898 */       recordInfo.currPlayerNum = playerNum;
/*      */     } else {
/* 2900 */       GuildDungeonRecord tmpRecord = new GuildDungeonRecord();
/* 2901 */       tmpRecord.currPlayerNum = playerNum;
/* 2902 */       tmpRecord.killPlayerId = "";
/* 2903 */       dungeonInfo.dungeonRecord.put(Integer.valueOf(dungeonCount), tmpRecord);
/*      */     } 
/* 2905 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void playerNumNotify(String guildId, int currPassedCount, int currPlayerNum, int playerNum) {
/* 2911 */     GDungeonMapCO prop = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue() && t.layer == currPassedCount + 1)).get(0);
/*      */     
/* 2913 */     if (null != prop && ((
/* 2914 */       currPlayerNum == prop.allowedPlayers && playerNum == prop.allowedPlayers - 1) || (playerNum == prop.allowedPlayers && currPlayerNum == prop.allowedPlayers - 1))) {
/* 2915 */       GuildMsg.DungeonPlayerNumGuildMsg msgData = new GuildMsg.DungeonPlayerNumGuildMsg();
/* 2916 */       msgData.playerNum = playerNum;
/* 2917 */       GuildMsg msg = new GuildMsg(Const.NotifyType.GUILD_DUNGEON_PLAYER_NUM.getValue(), msgData);
/* 2918 */       notifyAllMemberRefreshGuild(guildId, msg, null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dungeonInit(String guildId, String instanceId, String serverId) {
/* 2924 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2925 */     dungeonInfo.instanceId = instanceId;
/* 2926 */     dungeonInfo.serverId = serverId;
/* 2927 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */   }
/*      */   
/*      */   public static void updateDropItem(String guildId, int dungeonCount, List<PlayerItemPO> dropItemInfo) {
/* 2931 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2932 */     for (PlayerItemPO dropItem : dropItemInfo) {
/* 2933 */       GuildDungeonThrowInfo tmpInfo = new GuildDungeonThrowInfo();
/* 2934 */       tmpInfo.dropItem = dropItem;
/* 2935 */       tmpInfo.dungeonCount = dungeonCount;
/* 2936 */       tmpInfo.diceInfo = new HashMap<>();
/* 2937 */       tmpInfo.mostPointPlayerId = "";
/* 2938 */       tmpInfo.mostPointPlayerName = "";
/* 2939 */       tmpInfo.mostPointPlayerPro = 0;
/* 2940 */       tmpInfo.mostPoint = 0;
/* 2941 */       dungeonInfo.throwInfo.add(tmpInfo);
/*      */     } 
/* 2943 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */   }
/*      */   
/*      */   public static GuildDungeonPO updateDamageAndHeal(String guildId, Map<String, GuildDungeonPlayerInfo> playerInfo, int dungeonCount, String killPlayerId) {
/* 2947 */     GuildDungeonPO dungeonInfo = GuildUtil.getGuildDungeon(guildId);
/* 2948 */     for (String id : playerInfo.keySet()) {
/* 2949 */       GuildDungeonPlayerInfo info = playerInfo.get(id);
/* 2950 */       if (info.damage > 0) {
/* 2951 */         boolean isExsist = false;
/* 2952 */         for (int i = 0; i < dungeonInfo.damageRankInfo.size(); i++) {
/* 2953 */           GuildManagerHandler.RankInfo.Builder rankInfo = ((GuildManagerHandler.RankInfo)dungeonInfo.damageRankInfo.get(i)).toBuilder();
/* 2954 */           if (rankInfo.getPlayerId().equals(id)) {
/* 2955 */             rankInfo.setValue(rankInfo.getValue() + info.damage);
/* 2956 */             isExsist = true;
/*      */           } 
/*      */         } 
/* 2959 */         if (!isExsist) {
/* 2960 */           GuildManagerHandler.RankInfo.Builder rankData = GuildManagerHandler.RankInfo.newBuilder();
/* 2961 */           PlayerPO player = PlayerUtil.getPlayerBaseData(id);
/* 2962 */           rankData.setPlayerId(id);
/* 2963 */           rankData.setPlayerName(player.name);
/* 2964 */           rankData.setPlayerPro(player.pro);
/* 2965 */           rankData.setLevel(player.level);
/* 2966 */           rankData.setUpGradeLevel(player.upLevel);
/* 2967 */           rankData.setValue(info.damage);
/* 2968 */           dungeonInfo.damageRankInfo.add(rankData.build());
/*      */         } 
/*      */         
/* 2971 */         dungeonInfo.damageRankInfo.sort(new Comparator<GuildManagerHandler.RankInfo>()
/*      */             {
/*      */               public int compare(GuildManagerHandler.RankInfo o1, GuildManagerHandler.RankInfo o2) {
/* 2974 */                 return (o1.toBuilder().getValue() < o2.toBuilder().getValue()) ? 1 : -1;
/*      */               }
/*      */             });
/*      */         
/* 2978 */         ArrayList<String> eachCountDamage = (ArrayList<String>)dungeonInfo.damagePlayer.get(Integer.valueOf(dungeonCount));
/* 2979 */         if (null != eachCountDamage) {
/* 2980 */           int index = eachCountDamage.indexOf(id);
/* 2981 */           if (index == -1) {
/* 2982 */             eachCountDamage.add(id);
/*      */           }
/*      */         } else {
/* 2985 */           ArrayList<String> temp = new ArrayList<>();
/* 2986 */           temp.add(id);
/* 2987 */           dungeonInfo.damagePlayer.put(Integer.valueOf(dungeonCount), temp);
/*      */         } 
/*      */       } 
/*      */       
/* 2991 */       if (info.heal > 0) {
/* 2992 */         boolean isExsist = false;
/* 2993 */         for (int i = 0; i < dungeonInfo.healRankInfo.size(); i++) {
/* 2994 */           GuildManagerHandler.RankInfo.Builder rankInfo = ((GuildManagerHandler.RankInfo)dungeonInfo.healRankInfo.get(i)).toBuilder();
/* 2995 */           if (rankInfo.getPlayerId().equals(id)) {
/* 2996 */             rankInfo.setValue(rankInfo.getValue() + info.heal);
/* 2997 */             isExsist = true;
/*      */           } 
/*      */         } 
/*      */         
/* 3001 */         if (!isExsist) {
/* 3002 */           GuildManagerHandler.RankInfo.Builder rankData = GuildManagerHandler.RankInfo.newBuilder();
/* 3003 */           PlayerPO player = PlayerUtil.getPlayerBaseData(id);
/* 3004 */           rankData.setPlayerId(id);
/* 3005 */           rankData.setPlayerName(player.name);
/* 3006 */           rankData.setPlayerPro(player.pro);
/* 3007 */           rankData.setLevel(player.level);
/* 3008 */           rankData.setUpGradeLevel(player.upLevel);
/* 3009 */           rankData.setValue(info.heal);
/* 3010 */           dungeonInfo.healRankInfo.add(rankData.build());
/*      */         } 
/* 3012 */         dungeonInfo.healRankInfo.sort(new Comparator<GuildManagerHandler.RankInfo>()
/*      */             {
/*      */               public int compare(GuildManagerHandler.RankInfo o1, GuildManagerHandler.RankInfo o2) {
/* 3015 */                 return (o1.toBuilder().getValue() < o2.toBuilder().getValue()) ? 1 : -1;
/*      */               }
/*      */             });
/*      */       } 
/*      */     } 
/*      */     
/* 3021 */     if (null != killPlayerId && !killPlayerId.isEmpty()) {
/* 3022 */       GuildDungeonRecord recordInfo = (GuildDungeonRecord)dungeonInfo.dungeonRecord.get(Integer.valueOf(dungeonCount));
/* 3023 */       if (null != recordInfo) {
/* 3024 */         recordInfo.killPlayerId = killPlayerId;
/*      */       } else {
/* 3026 */         GuildDungeonRecord tmpRecord = new GuildDungeonRecord();
/* 3027 */         tmpRecord.currPlayerNum = 0;
/* 3028 */         tmpRecord.killPlayerId = killPlayerId;
/* 3029 */         dungeonInfo.dungeonRecord.put(Integer.valueOf(dungeonCount), tmpRecord);
/*      */       } 
/*      */     } 
/*      */     
/* 3033 */     GuildUtil.updateGuildDungeon(dungeonInfo);
/*      */     
/* 3035 */     return dungeonInfo;
/*      */   }
/*      */   
/*      */   public String getItemName(String code) {
/* 3039 */     DItemEquipBase prop = ItemUtil.getPropByCode(code);
/* 3040 */     if (null != prop) {
/* 3041 */       return prop.name;
/*      */     }
/* 3043 */     return "";
/*      */   }
/*      */   
/*      */   public static void addGuildMoneyByGuildBoss(String guildId, RankRewardExt co, int rank) {
/* 3047 */     if (co.guildFund <= 0) {
/*      */       return;
/*      */     }
/*      */     
/* 3051 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 3052 */     if (guild == null) {
/*      */       return;
/*      */     }
/*      */     
/* 3056 */     guild.fund += co.guildFund;
/* 3057 */     guild.sumFund += co.guildFund;
/* 3058 */     Out.info(new Object[] { "添加仙盟基金 guildId=", guildId, ", fund=", Integer.valueOf(co.guildFund) });
/*      */     
/* 3060 */     GuildServiceCenter.getInstance().saveGuild(guild);
/*      */ 
/*      */     
/*      */     try {
/* 3064 */       MailSysData mail = new MailSysData("GuildFundNotice");
/* 3065 */       mail.replace = new HashMap<>();
/* 3066 */       mail.replace.put("GuildNname", guild.name);
/* 3067 */       mail.replace.put("Rank", String.valueOf(rank));
/* 3068 */       mail.replace.put("GuildFund", String.valueOf(co.guildFund));
/* 3069 */       MailUtil.getInstance().sendMailToOnePlayer(guild.presidentId, (MailData)mail, Const.GOODS_CHANGE_TYPE.def);
/* 3070 */     } catch (Exception e) {
/* 3071 */       Out.warn(new Object[] { "给盟主再发个邮件.playerId=", guild.presidentId, e });
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */