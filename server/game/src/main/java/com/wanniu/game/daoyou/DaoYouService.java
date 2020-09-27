/*      */ package com.wanniu.game.daoyou;
/*      */ 
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.protocol.PomeloPush;
/*      */ import com.wanniu.core.tcp.protocol.Message;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.daoyou.dao.DaoYouDao;
/*      */ import com.wanniu.game.mail.MailUtil;
/*      */ import com.wanniu.game.mail.data.MailData;
/*      */ import com.wanniu.game.mail.data.MailSysData;
/*      */ import com.wanniu.game.message.MessageData;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.DaoYouMemberPO;
/*      */ import com.wanniu.game.poes.DaoYouPO;
/*      */ import com.wanniu.game.poes.MessagePO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.rank.handler.DaoYouRankHandler;
/*      */ import com.wanniu.game.team.TeamData;
/*      */ import com.wanniu.game.team.TeamUtil;
/*      */ import com.wanniu.game.util.BlackWordUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Comparator;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.UUID;
/*      */ import pomelo.area.MessageHandler;
/*      */ import pomelo.daoyou.DaoYouHandler;
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
/*      */ public class DaoYouService
/*      */ {
/*   53 */   public Map<String, Long> inviteTime = new HashMap<>();
/*      */ 
/*      */ 
/*      */   
/*   57 */   private static DaoYouService instance = null;
/*      */   
/*      */   public static DaoYouService getInstance() {
/*   60 */     if (instance == null) {
/*   61 */       instance = new DaoYouService();
/*      */     }
/*   63 */     return instance;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void applyDaoYouList(String playerId, DaoYouHandler.DaoYouResponse.Builder daoYouResponse) {
/*   73 */     DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*   74 */     if (dymp == null) {
/*   75 */       daoYouResponse.setS2CCode(200);
/*   76 */       daoYouResponse.setIsHasDaoYou(0);
/*      */       return;
/*      */     } 
/*   79 */     String dyId = dymp.daoYouId;
/*   80 */     DaoYouPO daoYou = DaoYouCenter.getInstance().getDaoYou(dyId);
/*   81 */     daoYouResponse.setS2CCode(200);
/*   82 */     daoYouResponse.setIsHasDaoYou(1);
/*   83 */     daoYouResponse.setIsEditedDyName(daoYou.isEditedDyName);
/*   84 */     daoYouResponse.setDyId(daoYou.id);
/*   85 */     daoYouResponse.setDyName(daoYou.name);
/*      */     
/*   87 */     List<DaoYouHandler.DaoYouInfo> daoYouList = new ArrayList<>();
/*   88 */     DaoYouHandler.DaoYouInfo.Builder adminDaoYouInfo = DaoYouHandler.DaoYouInfo.newBuilder();
/*   89 */     List<String> dyMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*   90 */     for (String dyMemPlayerId : dyMemPlayerIds) {
/*   91 */       DaoYouHandler.DaoYouInfo.Builder daoYouInfo = DaoYouHandler.DaoYouInfo.newBuilder();
/*   92 */       daoYouInfo.setPlayerId(dyMemPlayerId);
/*   93 */       PlayerPO playerBase = PlayerUtil.getPlayerBaseData(dyMemPlayerId);
/*   94 */       if (playerBase == null) {
/*      */         continue;
/*      */       }
/*   97 */       daoYouInfo.setPlayerName(playerBase.name);
/*   98 */       daoYouInfo.setPlayerLvl(playerBase.level);
/*   99 */       daoYouInfo.setPro(playerBase.pro);
/*      */ 
/*      */       
/*  102 */       daoYouInfo.setPlayerUpLvl(playerBase.upLevel);
/*  103 */       daoYouInfo.setPlayerFightPower(playerBase.fightPower);
/*  104 */       boolean isOnline = PlayerUtil.isOnline(dyMemPlayerId);
/*  105 */       if (isOnline) {
/*  106 */         WNPlayer dyMemPlayer = PlayerUtil.getOnlinePlayer(dyMemPlayerId);
/*  107 */         daoYouInfo.setAreaName(dyMemPlayer.getSceneName());
/*      */       } else {
/*  109 */         daoYouInfo.setAreaName("");
/*      */       } 
/*  111 */       daoYouInfo.setOnlineState(isOnline ? 1 : 0);
/*  112 */       daoYouInfo.setLastActiveTime((int)Math.floor((playerBase.logoutTime.getTime() / 1000L)));
/*  113 */       DaoYouMemberPO tempMemberPO = DaoYouCenter.getInstance().getDaoYouMember(dyMemPlayerId);
/*  114 */       daoYouInfo.setJoinTime((int)Math.floor((tempMemberPO.joinTime.getTime() / 1000L)));
/*  115 */       if (dyMemPlayerId.equals(daoYou.adminPlayerId)) {
/*  116 */         daoYouInfo.setIsAdmin(1);
/*  117 */         adminDaoYouInfo = daoYouInfo; continue;
/*      */       } 
/*  119 */       daoYouInfo.setIsAdmin(0);
/*  120 */       daoYouList.add(daoYouInfo.build());
/*      */     } 
/*      */     
/*  123 */     daoYouList.sort(new Comparator<DaoYouHandler.DaoYouInfo>()
/*      */         {
/*      */           public int compare(DaoYouHandler.DaoYouInfo o1, DaoYouHandler.DaoYouInfo o2)
/*      */           {
/*  127 */             DaoYouHandler.DaoYouInfo.Builder dyi1 = o1.toBuilder();
/*  128 */             DaoYouHandler.DaoYouInfo.Builder dyi2 = o2.toBuilder();
/*  129 */             if (dyi1.getOnlineState() != dyi2.getOnlineState()) {
/*  130 */               return (dyi1.getOnlineState() < dyi2.getOnlineState()) ? 1 : -1;
/*      */             }
/*  132 */             return (dyi1.getJoinTime() > dyi2.getJoinTime()) ? 1 : -1;
/*      */           }
/*      */         });
/*      */     
/*  136 */     daoYouList.add(0, adminDaoYouInfo.build());
/*  137 */     daoYouResponse.addAllDyInfo(daoYouList);
/*      */     
/*  139 */     daoYouResponse.setDyFightPower(daoYou.fightPower);
/*  140 */     daoYouResponse.setDyRank(getDaoYouRank(dyId));
/*  141 */     daoYouResponse.setDyNotice(daoYou.notice);
/*  142 */     List<DaoYouMessageVo> messages = daoYou.messages;
/*  143 */     List<DaoYouHandler.DaoYouMessage> responseMessages = new ArrayList<>();
/*  144 */     if (messages != null) {
/*  145 */       for (int i = messages.size() - 1; i >= 0; i--) {
/*  146 */         DaoYouMessageVo dm = messages.get(i);
/*  147 */         DaoYouHandler.DaoYouMessage.Builder sm = DaoYouHandler.DaoYouMessage.newBuilder();
/*  148 */         sm.setType(dm.type);
/*  149 */         sm.setContent(dm.message);
/*  150 */         sm.setTime((int)Math.floor((dm.time.getTime() / 1000L)));
/*  151 */         responseMessages.add(sm.build());
/*      */       } 
/*      */     }
/*  154 */     daoYouResponse.addAllMessage(responseMessages);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDaoYouRank(String daoYouId) {
/*  164 */     DaoYouPO daoYouPO = (DaoYouCenter.getInstance()).daoYouMap.get(daoYouId);
/*  165 */     if (daoYouPO == null) {
/*  166 */       return -1;
/*      */     }
/*  168 */     long rank = DaoYouRankHandler.getInstance().getRank(GWorld.__SERVER_ID, daoYouId);
/*  169 */     return (int)rank;
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
/*      */   public String editDaoYouName(String adminPlayerId, String adminPlayerName, String newDouYouname) {
/*  181 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(adminPlayerId);
/*  182 */     if (dyMemPo == null) {
/*  183 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  185 */     String dyId = dyMemPo.daoYouId;
/*  186 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  187 */     if (dyp == null) {
/*  188 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  190 */     if (!dyp.adminPlayerId.equals(adminPlayerId)) {
/*  191 */       return LangService.getValue("DAO_YOU_NOT_ADMIN");
/*      */     }
/*  193 */     if (newDouYouname.length() < Const.DaoYou.DaoYouNameMinLength.getValue()) {
/*  194 */       return LangService.getValue("DAO_YOU_NAME_TOO_SHORT");
/*      */     }
/*  196 */     if (newDouYouname.length() > Const.DaoYou.DaoYouNameMaxLength.getValue()) {
/*  197 */       return LangService.getValue("DAO_YOU_NAME_TOO_LANG");
/*      */     }
/*  199 */     if (BlackWordUtil.isIncludeSpecialChar(newDouYouname)) {
/*  200 */       return LangService.getValue("DAO_YOU_NAME_CONTAIN_SPECIAL_CHAR");
/*      */     }
/*  202 */     if (BlackWordUtil.isIncludeBlackString(newDouYouname)) {
/*  203 */       return LangService.getValue("DAO_YOU_NAME_CONTAIN_BLACK_CHAR");
/*      */     }
/*  205 */     Date lastEditNameTime = dyp.lastEditNameTime;
/*  206 */     if (lastEditNameTime != null) {
/*  207 */       Date editeNameAfterTime = DateUtil.getDateAfter(Const.DaoYou.DaoYouEditNameInterval.getValue());
/*  208 */       if (editeNameAfterTime.getTime() > System.currentTimeMillis()) {
/*  209 */         return LangService.getValue("DAO_YOU_EDITE_NAME_OFTEN");
/*      */       }
/*      */     } 
/*  212 */     Map<String, String> daoYouNameMap = (DaoYouCenter.getInstance()).daoYouNameMap;
/*  213 */     String daoYouId = daoYouNameMap.get(newDouYouname);
/*  214 */     if (daoYouId != null && !daoYouId.equals(dyId)) {
/*  215 */       return LangService.getValue("DAO_YOU_NAME_EXSIT");
/*      */     }
/*      */ 
/*      */     
/*  219 */     String oldName = dyp.name;
/*  220 */     daoYouNameMap.remove(oldName);
/*  221 */     daoYouNameMap.put(newDouYouname, dyId);
/*  222 */     dyp.name = newDouYouname;
/*  223 */     dyp.isEditedDyName = 1;
/*  224 */     dyp.updateTime = new Date();
/*  225 */     dyp.lastEditNameTime = new Date();
/*  226 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_EDIT_NAME_MESSAGE", new Object[] { adminPlayerName, newDouYouname });
/*  227 */     DaoYouDao.updateDaoYou(dyp);
/*  228 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fastInviteDaoYouCreateTeam(WNPlayer player) {
/*  238 */     String playerId = player.getId();
/*  239 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*  240 */     if (dyMemPo == null) {
/*  241 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*      */     
/*  244 */     String dyId = dyMemPo.daoYouId;
/*  245 */     TeamData team = player.teamManager.getTeam();
/*      */     
/*  247 */     List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  248 */     List<String> realInvitePlayer = new ArrayList<>();
/*  249 */     List<WNPlayer> inTeamPlayer = new ArrayList<>();
/*  250 */     for (String memPlayerId : daoYouMemPlayerIds) {
/*  251 */       if (!PlayerUtil.isOnline(memPlayerId) || memPlayerId.equals(playerId)) {
/*      */         continue;
/*      */       }
/*  254 */       if (TeamUtil.isInTeam(memPlayerId)) {
/*  255 */         inTeamPlayer.add(PlayerUtil.getOnlinePlayer(memPlayerId)); continue;
/*      */       } 
/*  257 */       realInvitePlayer.add(memPlayerId);
/*      */     } 
/*      */ 
/*      */     
/*  261 */     if (realInvitePlayer.size() > 0) {
/*  262 */       if (team == null) {
/*  263 */         String createResult = TeamUtil.createLocaleTeam(playerId, null);
/*  264 */         if (createResult == null) {
/*  265 */           team = player.teamManager.getTeam();
/*      */         } else {
/*  267 */           return createResult;
/*      */         } 
/*      */       } 
/*  270 */       for (String memPlayerId : realInvitePlayer) {
/*  271 */         team.invite(player, memPlayerId);
/*      */       }
/*      */     } 
/*  274 */     for (WNPlayer p : inTeamPlayer) {
/*  275 */       if (team != null && TeamUtil.isInTeam(team.id, p.getId())) {
/*      */         continue;
/*      */       }
/*  278 */       PlayerUtil.sendSysMessageToPlayer(String.format(LangService.getValue("DAO_YOU_PLAYER_IN_TEAM"), new Object[] { p.getName() }), playerId);
/*      */     } 
/*      */ 
/*      */     
/*  282 */     player.taskManager.dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
/*  283 */     return "";
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
/*      */   public String inviteDaoYou(WNPlayer player, String toPlayerId, boolean isFastInvite) {
/*  295 */     String fromPlayerId = player.getId();
/*  296 */     String fromPlayerName = player.getName();
/*  297 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
/*  298 */     if (dyMemPo != null) {
/*  299 */       String dyId = dyMemPo.daoYouId;
/*  300 */       DaoYouPO dyPo = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  301 */       if (dyPo != null && !dyPo.adminPlayerId.equals(fromPlayerId)) {
/*  302 */         return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
/*      */       }
/*  304 */       List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  305 */       if (daoYouMemPlayerIds != null && daoYouMemPlayerIds.size() == AllyConfiguration.getInstance().getConfigI("MaxPlayer")) {
/*  306 */         return LangService.getValue("DAO_YOU_MEMBER_COUNT_MAX");
/*      */       }
/*      */     } 
/*  309 */     WNPlayer toPlayer = PlayerUtil.getOnlinePlayer(toPlayerId);
/*  310 */     if (toPlayer == null) {
/*  311 */       return LangService.getValue("DAO_YOU_PLAYER_OFFLINE");
/*      */     }
/*      */     
/*  314 */     if (!toPlayer.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
/*  315 */       return LangService.getValue("DAO_YOU_NOT_OPEN_FRIEND");
/*      */     }
/*      */     
/*  318 */     if (this.inviteTime.containsKey(toPlayerId) && System.currentTimeMillis() - ((Long)this.inviteTime.get(toPlayerId)).longValue() < 60000L) {
/*  319 */       return LangService.getValue("DAO_YOU_INVITE_NOTICE");
/*      */     }
/*      */     
/*  322 */     DaoYouMemberPO toPlayerDaoYouMem = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
/*  323 */     if (toPlayerDaoYouMem != null) {
/*  324 */       return LangService.getValue("DAO_YOU_PLAYER_IS_ANOTHER_DAO_YOU");
/*      */     }
/*      */     
/*  327 */     MessageData.MessageData_DaoYou md = new MessageData.MessageData_DaoYou();
/*  328 */     md.fromPlayerId = fromPlayerId;
/*  329 */     md.fromPlayerName = fromPlayerName;
/*  330 */     HashMap<String, String> strMsg = new HashMap<>();
/*  331 */     strMsg.put("playerName", PlayerUtil.getFullColorName(player));
/*  332 */     MessagePO opts = new MessagePO();
/*  333 */     opts.createPlayerId = fromPlayerId;
/*  334 */     opts.id = fromPlayerId;
/*  335 */     opts.strMsg = strMsg;
/*  336 */     opts.createTime = new Date();
/*  337 */     opts.messageType = Const.MESSAGE_TYPE.daoyou_invite.getValue();
/*  338 */     opts.data = (MessageData.MessageData_Data)md;
/*  339 */     MessageData message = new MessageData(opts);
/*  340 */     MessageHandler.OnMessageAddPush.Builder builder = MessageHandler.OnMessageAddPush.newBuilder();
/*  341 */     builder.setS2CCode(200);
/*  342 */     builder.setS2CData(message.toJson4PayLoad());
/*  343 */     toPlayer.receive("area.messagePush.onMessageAddPush", (GeneratedMessage)builder.build());
/*  344 */     if (!isFastInvite) {
/*  345 */       this.inviteTime.put(toPlayerId, Long.valueOf(System.currentTimeMillis()));
/*      */     }
/*      */ 
/*      */     
/*  349 */     player.taskManager.dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
/*  350 */     return "";
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
/*      */   public boolean onMessage(WNPlayer toPlayer, int operate, String fromPlayerId) {
/*  362 */     String toPlayerId = toPlayer.getId();
/*      */     
/*  364 */     if (this.inviteTime.containsKey(toPlayerId)) {
/*  365 */       this.inviteTime.remove(toPlayerId);
/*      */     }
/*  367 */     if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
/*  368 */       if (!toPlayer.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
/*  369 */         toPlayer.sendSysTip(LangService.getValue("DAO_YOU_NOT_OPEN"));
/*  370 */         return false;
/*      */       } 
/*      */       
/*  373 */       DaoYouMemberPO daoYouMem = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
/*  374 */       if (daoYouMem != null) {
/*  375 */         toPlayer.sendSysTip(LangService.getValue("DAO_YOU_ALREADY_IN_DAO_YOU"));
/*  376 */         return false;
/*      */       } 
/*      */       
/*  379 */       DaoYouMemberPO fromDaoYouMem = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
/*  380 */       List<String> daoYouMemPlayerIds = new ArrayList<>();
/*  381 */       List<String> oldDaoYouMemIds = new ArrayList<>();
/*  382 */       if (fromDaoYouMem != null) {
/*  383 */         daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(fromDaoYouMem.daoYouId);
/*  384 */         oldDaoYouMemIds.addAll(daoYouMemPlayerIds);
/*  385 */         if (daoYouMemPlayerIds.size() == AllyConfiguration.getInstance().getConfigI("MaxPlayer")) {
/*  386 */           toPlayer.sendSysTip(LangService.getValue("DAO_YOU_MEMBER_COUNT_MAX"));
/*  387 */           return false;
/*      */         } 
/*      */       } else {
/*  390 */         oldDaoYouMemIds.add(fromPlayerId);
/*      */       } 
/*      */       
/*  393 */       PlayerPO fromPlayerPo = PlayerUtil.getPlayerBaseData(fromPlayerId);
/*  394 */       if (fromPlayerPo == null) {
/*  395 */         return false;
/*      */       }
/*  397 */       PlayerPO toPlayerPo = toPlayer.getPlayer();
/*  398 */       boolean ret = processInviteDaoYou(fromPlayerPo, toPlayerPo);
/*  399 */       if (ret) {
/*  400 */         toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_SUCCESS_TIPS"));
/*      */         
/*  402 */         DaoYouMemberPO toDaoYouMemPo = DaoYouCenter.getInstance().getDaoYouMember(toPlayerId);
/*  403 */         processDaoYouChange(oldDaoYouMemIds, toDaoYouMemPo, true);
/*  404 */         return true;
/*      */       } 
/*  406 */       toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_FAIL_TIPS"));
/*  407 */       return false;
/*      */     } 
/*      */     
/*  410 */     toPlayer.sendSysTip(LangService.getValue("DAO_YOU_JOIN_FAIL_TIPS"));
/*  411 */     return false;
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
/*      */   public boolean processInviteDaoYou(PlayerPO fromPlayer, PlayerPO toPlayer) {
/*  423 */     String fromPlayerId = fromPlayer.id;
/*  424 */     DaoYouMemberPO daoYouMemPo = DaoYouCenter.getInstance().getDaoYouMember(fromPlayerId);
/*  425 */     if (daoYouMemPo == null) {
/*  426 */       createDaoYou(fromPlayer, toPlayer);
/*  427 */       return true;
/*      */     } 
/*  429 */     String dypId = daoYouMemPo.daoYouId;
/*  430 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dypId);
/*  431 */     createDaoYouMember(dyp, toPlayer);
/*  432 */     return true;
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
/*      */   public int calDaoYouFightPower(String dyId, List<String> daoYouMems) {
/*  444 */     int daoYouFightPower = 0;
/*  445 */     for (int i = 0; i < daoYouMems.size(); i++) {
/*  446 */       String dyMemPlayerId = daoYouMems.get(i);
/*  447 */       PlayerPO playerBase = PlayerUtil.getPlayerBaseData(dyMemPlayerId);
/*  448 */       if (playerBase != null) {
/*  449 */         int playerFightPower = playerBase.fightPower;
/*  450 */         daoYouFightPower += playerFightPower;
/*      */       } 
/*      */     } 
/*  453 */     return daoYouFightPower;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DaoYouPO createDaoYou(PlayerPO fromPlayer, PlayerPO toPlayer) {
/*  464 */     DaoYouPO dyp = new DaoYouPO();
/*  465 */     dyp.id = UUID.randomUUID().toString();
/*  466 */     dyp.adminPlayerId = fromPlayer.id;
/*  467 */     dyp.name = getRandDaoYouName();
/*  468 */     dyp.notice = "";
/*  469 */     dyp.isEditedDyName = 0;
/*  470 */     dyp.createTime = new Date();
/*  471 */     dyp.updateTime = new Date();
/*      */     
/*  473 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_CREATE_NOTICE", new Object[] { fromPlayer.name, dyp.name });
/*      */     
/*  475 */     DaoYouCenter.getInstance().addDaoYou(dyp, false);
/*  476 */     createDaoYouMember(dyp, fromPlayer);
/*  477 */     createDaoYouMember(dyp, toPlayer);
/*      */     
/*  479 */     List<String> dyMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyp.id);
/*  480 */     int daoYouFightPower = calDaoYouFightPower(dyp.id, dyMemPlayerIds);
/*      */ 
/*      */     
/*  483 */     DaoYouRankHandler.getInstance().asyncUpdateRank(GWorld.__SERVER_ID, dyp.id, daoYouFightPower);
/*  484 */     return dyp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DaoYouMemberPO createDaoYouMember(DaoYouPO dyp, PlayerPO playerPO) {
/*  495 */     DaoYouMemberPO mem = new DaoYouMemberPO();
/*  496 */     mem.daoYouId = dyp.id;
/*  497 */     mem.playerId = playerPO.id;
/*  498 */     mem.totalSendRebate = 0;
/*  499 */     mem.totalReciveRebate = 0;
/*  500 */     mem.todayReciveRebate = 0;
/*  501 */     mem.joinTime = new Date();
/*  502 */     mem.createTime = new Date();
/*  503 */     mem.updateTime = new Date();
/*  504 */     DaoYouCenter.getInstance().addDaoYouMember(mem, false);
/*      */     
/*  506 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_JOIN_SUCCESS_NOTICE", new Object[] { playerPO.name });
/*  507 */     return mem;
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
/*      */   public void addDaoYouMessage(int messageType, String playerName, DaoYouPO dyp, String content, Object... param) {
/*  520 */     DaoYouMessageVo dym = new DaoYouMessageVo();
/*  521 */     List<DaoYouMessageVo> messages = dyp.messages;
/*  522 */     if (messages == null) {
/*  523 */       messages = new ArrayList<>();
/*      */     }
/*  525 */     dym.type = messageType;
/*  526 */     if (messageType == Const.DaoYou.DaoYouMessageTypeSystem.getValue()) {
/*  527 */       dym.message = LangService.format(content, param);
/*      */     } else {
/*  529 */       dym.message = playerName + ":" + content;
/*      */     } 
/*  531 */     while (messages.size() >= AllyConfiguration.getInstance().getConfigI("MaxMessage")) {
/*  532 */       messages.remove(0);
/*      */     }
/*      */     
/*  535 */     dym.time = new Date();
/*  536 */     dyp.updateTime = new Date();
/*  537 */     messages.add(dym);
/*  538 */     dyp.messages = messages;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized String getRandDaoYouName() {
/*  547 */     Calendar calendar = Calendar.getInstance();
/*  548 */     calendar.set(1, 2017);
/*  549 */     calendar.set(2, 0);
/*  550 */     calendar.set(5, 1);
/*  551 */     calendar.set(11, 0);
/*  552 */     calendar.set(12, 0);
/*  553 */     calendar.set(13, 0);
/*  554 */     long time = (System.currentTimeMillis() - calendar.getTimeInMillis()) / 1000L;
/*  555 */     String suffix = (new Long(time)).toString();
/*  556 */     return "DY" + suffix;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String kickDaoYou(String adminPlayerId, String adminPlayerName, String kickPlayerId) {
/*  567 */     String kickPlayerName = "";
/*  568 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(adminPlayerId);
/*  569 */     if (dyMemPo == null) {
/*  570 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  572 */     String dyId = dyMemPo.daoYouId;
/*  573 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  574 */     if (dyp == null) {
/*  575 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  577 */     if (!dyp.adminPlayerId.equals(adminPlayerId)) {
/*  578 */       return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
/*      */     }
/*  580 */     List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  581 */     if (daoYouMemIds == null) {
/*  582 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*      */     
/*  585 */     DaoYouMemberPO kickMemPo = DaoYouCenter.getInstance().getDaoYouMember(kickPlayerId);
/*  586 */     int todayReciveRebate = kickMemPo.todayReciveRebate;
/*      */     
/*  588 */     List<String> oldDaoYouMemIds = new ArrayList<>();
/*  589 */     oldDaoYouMemIds.addAll(daoYouMemIds);
/*  590 */     DaoYouCenter.getInstance().removeDaoYouMember(kickPlayerId);
/*      */     
/*  592 */     if (PlayerUtil.isOnline(kickPlayerId)) {
/*  593 */       WNPlayer player = PlayerUtil.findPlayer(kickPlayerId);
/*  594 */       player.sendSysTip(LangService.format("DAO_YOU_KICKED_TIPS", new Object[] { dyp.name }));
/*  595 */       kickPlayerName = player.getName();
/*      */     } else {
/*  597 */       sendKickedMail(kickPlayerId, adminPlayerName);
/*  598 */       kickPlayerName = (PlayerUtil.getPlayerBaseData(kickPlayerId)).name;
/*      */     } 
/*      */ 
/*      */     
/*  602 */     processDaoYouChange(oldDaoYouMemIds, kickMemPo, false);
/*      */     
/*  604 */     dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  605 */     if (dyp != null) {
/*  606 */       if (todayReciveRebate == 0) {
/*  607 */         addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_KICKED_NOTICE_NO_REBEATE", new Object[] { kickPlayerName, Integer.valueOf(todayReciveRebate) });
/*      */       } else {
/*  609 */         addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_KICKED_NOTICE", new Object[] { kickPlayerName, Integer.valueOf(todayReciveRebate) });
/*      */       } 
/*      */     }
/*  612 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String transferAdmin(WNPlayer oldAdminPlayer, String newAdminPlayerId) {
/*  623 */     String oldAdminPlayerId = oldAdminPlayer.getId();
/*  624 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(oldAdminPlayerId);
/*  625 */     if (dyMemPo == null) {
/*  626 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  628 */     String dyId = dyMemPo.daoYouId;
/*  629 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  630 */     if (dyp == null) {
/*  631 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  633 */     if (!dyp.adminPlayerId.equals(oldAdminPlayerId)) {
/*  634 */       return LangService.getValue("DAO_YOU_ONLY_ADMIN_CAN_DO_THIS");
/*      */     }
/*  636 */     List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  637 */     if (daoYouMemIds == null) {
/*  638 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  640 */     if (!daoYouMemIds.contains(newAdminPlayerId)) {
/*  641 */       return LangService.getValue("DAO_YOU_NOT_CONTAIN_MEMBER");
/*      */     }
/*      */     
/*  644 */     dyp.adminPlayerId = newAdminPlayerId;
/*  645 */     DaoYouDao.updateDaoYou(dyp);
/*  646 */     PlayerPO playerPo = PlayerUtil.getPlayerBaseData(newAdminPlayerId);
/*  647 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_TRANSFER_ADMIN", new Object[] { oldAdminPlayer.getName(), playerPo.name });
/*  648 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String leaveMessage(WNPlayer player, String content) {
/*  659 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
/*  660 */     if (dyMemPo == null) {
/*  661 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  663 */     String dyId = dyMemPo.daoYouId;
/*  664 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  665 */     if (dyp == null) {
/*  666 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  668 */     if (content.equals("")) {
/*  669 */       return LangService.getValue("DAO_YOU_LEAVE_MESSAGE_EMPTY");
/*      */     }
/*  671 */     if (content.length() > Const.DaoYou.DaoYouLeaveMessageMaxLength.getValue()) {
/*  672 */       return LangService.getValue("DAO_YOU_LEAVE_MESSAGE_TOO_LANG");
/*      */     }
/*      */     
/*  675 */     content = BlackWordUtil.replaceBlackString(content);
/*  676 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeLeave.getValue(), player.getName(), dyp, content, new Object[0]);
/*  677 */     DaoYouDao.updateDaoYou(dyp);
/*  678 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String editNotice(String playerId, String notice) {
/*  689 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*  690 */     if (dyMemPo == null) {
/*  691 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  693 */     String dyId = dyMemPo.daoYouId;
/*  694 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  695 */     if (dyp == null) {
/*  696 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  698 */     if (notice.equals("")) {
/*  699 */       return LangService.getValue("DAO_YOU_NOTICE_EMPTY");
/*      */     }
/*  701 */     if (notice.length() > Const.DaoYou.DaoYouNoticeMaxLength.getValue()) {
/*  702 */       return LangService.getValue("DAO_YOU_NOTICE_TOO_LANG");
/*      */     }
/*  704 */     notice = BlackWordUtil.replaceBlackString(notice);
/*  705 */     dyp.notice = notice;
/*  706 */     dyp.updateTime = new Date();
/*  707 */     DaoYouDao.updateDaoYou(dyp);
/*  708 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String quitDaoYou(WNPlayer player) {
/*  717 */     String playerId = player.getId();
/*  718 */     String playerName = player.getName();
/*  719 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*  720 */     if (dyMemPo == null) {
/*  721 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  723 */     String dyId = dyMemPo.daoYouId;
/*  724 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  725 */     if (dyp == null) {
/*  726 */       return LangService.getValue("DAO_YOU_NOT_HAS");
/*      */     }
/*  728 */     List<String> daoYouMemIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  729 */     List<String> oldDaoYouMemIds = new ArrayList<>();
/*  730 */     oldDaoYouMemIds.addAll(daoYouMemIds);
/*  731 */     DaoYouCenter.getInstance().removeDaoYouMember(playerId);
/*  732 */     String adminPlayerId = dyp.id;
/*  733 */     if (PlayerUtil.isOnline(adminPlayerId)) {
/*  734 */       WNPlayer adminPlayer = PlayerUtil.findPlayer(adminPlayerId);
/*  735 */       adminPlayer.sendSysTip(LangService.format("DAO_YOU_LEAVE", new Object[] { playerName }));
/*      */     } 
/*      */ 
/*      */     
/*  739 */     processDaoYouChange(daoYouMemIds, dyMemPo, false);
/*      */     
/*  741 */     dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  742 */     int todayReciveRebate = dyMemPo.todayReciveRebate;
/*  743 */     if (dyp != null) {
/*  744 */       if (todayReciveRebate == 0) {
/*  745 */         addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_LEAVE_NO_REBEATE", new Object[] { playerName, Integer.valueOf(todayReciveRebate) });
/*      */       } else {
/*  747 */         addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_LEAVE", new Object[] { playerName, Integer.valueOf(todayReciveRebate) });
/*      */       } 
/*      */     }
/*  750 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean sendKickedMail(String toPlayerId, String adminPlayerName) {
/*  761 */     MailSysData mailData = new MailSysData("Ally_kick");
/*  762 */     mailData.replace = new HashMap<>();
/*  763 */     mailData.replace.put("AllyName", adminPlayerName);
/*  764 */     mailData.attachments = new ArrayList();
/*  765 */     MailData.Attachment item1 = new MailData.Attachment();
/*  766 */     mailData.attachments.add(item1);
/*  767 */     return MailUtil.getInstance().sendMailToOnePlayer(toPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.DAOYOU);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getAllRebate(WNPlayer player, DaoYouHandler.DaoYouRebateResponse.Builder daoYouRebateResponse) {
/*  778 */     String playerId = player.getId();
/*  779 */     String playerName = player.getName();
/*  780 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*  781 */     if (dyMemPo == null) {
/*  782 */       daoYouRebateResponse.setS2CCode(500);
/*  783 */       daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));
/*      */       return;
/*      */     } 
/*  786 */     String dyId = dyMemPo.daoYouId;
/*  787 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  788 */     if (dyp == null) {
/*  789 */       daoYouRebateResponse.setS2CCode(500);
/*  790 */       daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));
/*      */       
/*      */       return;
/*      */     } 
/*  794 */     List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  795 */     if (daoYouMemPlayerIds == null) {
/*  796 */       daoYouRebateResponse.setS2CCode(500);
/*  797 */       daoYouRebateResponse.setS2CMsg(LangService.getValue("DAO_YOU_NOT_HAS"));
/*      */       return;
/*      */     } 
/*  800 */     List<DaoYouHandler.DaoYouRebateInfo> list = new ArrayList<>();
/*  801 */     DaoYouMemberPO selfDyMemPo = null;
/*  802 */     for (String id : daoYouMemPlayerIds) {
/*  803 */       DaoYouMemberPO tempDyMemPo = DaoYouCenter.getInstance().getDaoYouMember(id);
/*  804 */       if (!id.equals(playerId)) {
/*  805 */         PlayerPO pp = PlayerUtil.getPlayerBaseData(id);
/*  806 */         if (tempDyMemPo != null && pp != null) {
/*  807 */           DaoYouHandler.DaoYouRebateInfo.Builder builder = DaoYouHandler.DaoYouRebateInfo.newBuilder();
/*  808 */           builder.setPlayerName(pp.name);
/*  809 */           builder.setTotalSendRebate(tempDyMemPo.totalSendRebate);
/*  810 */           Map<String, Integer> map = tempDyMemPo.todaySendRebate;
/*  811 */           if (map == null) {
/*  812 */             map = new HashMap<>();
/*      */           }
/*  814 */           int todaySendRebateNumber = 0;
/*  815 */           List<DaoYouHandler.DaoYouMemRebaeReciveInfo> list1 = new ArrayList<>();
/*  816 */           if (map.size() > 0) {
/*  817 */             for (Map.Entry<String, Integer> everySend : map.entrySet()) {
/*  818 */               DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder dymr = DaoYouHandler.DaoYouMemRebaeReciveInfo.newBuilder();
/*  819 */               String name = everySend.getKey();
/*  820 */               Integer reciveNumber = everySend.getValue();
/*  821 */               dymr.setPlayerName(name);
/*  822 */               dymr.setReciveNumber(reciveNumber.intValue());
/*  823 */               list1.add(dymr.build());
/*  824 */               todaySendRebateNumber += reciveNumber.intValue();
/*      */             } 
/*      */           }
/*  827 */           builder.setTodaySendRebate(todaySendRebateNumber);
/*  828 */           builder.addAllMemRebaeReciveInfo(list1);
/*  829 */           list.add(builder.build());
/*      */         }  continue;
/*      */       } 
/*  832 */       selfDyMemPo = tempDyMemPo;
/*      */     } 
/*      */     
/*  835 */     DaoYouHandler.DaoYouRebateInfo.Builder r = DaoYouHandler.DaoYouRebateInfo.newBuilder();
/*  836 */     r.setPlayerName(playerName);
/*  837 */     r.setTotalSendRebate(selfDyMemPo.totalSendRebate);
/*  838 */     Map<String, Integer> todaySendRebateMap = selfDyMemPo.todaySendRebate;
/*  839 */     if (todaySendRebateMap == null) {
/*  840 */       todaySendRebateMap = new HashMap<>();
/*      */     }
/*  842 */     int todaySendRebate = 0;
/*  843 */     List<DaoYouHandler.DaoYouMemRebaeReciveInfo> everyMemRecives = new ArrayList<>();
/*  844 */     for (Map.Entry<String, Integer> everySend : todaySendRebateMap.entrySet()) {
/*  845 */       DaoYouHandler.DaoYouMemRebaeReciveInfo.Builder dymr = DaoYouHandler.DaoYouMemRebaeReciveInfo.newBuilder();
/*  846 */       String name = everySend.getKey();
/*  847 */       Integer reciveNumber = everySend.getValue();
/*  848 */       dymr.setPlayerName(name);
/*  849 */       dymr.setReciveNumber(reciveNumber.intValue());
/*  850 */       everyMemRecives.add(dymr.build());
/*  851 */       todaySendRebate += ((Integer)everySend.getValue()).intValue();
/*      */     } 
/*  853 */     r.setTodaySendRebate(todaySendRebate);
/*  854 */     r.addAllMemRebaeReciveInfo(everyMemRecives);
/*  855 */     list.add(0, r.build());
/*      */     
/*  857 */     daoYouRebateResponse.setS2CCode(200);
/*  858 */     daoYouRebateResponse.setSelfTotalReciveRebate(selfDyMemPo.totalReciveRebate);
/*  859 */     daoYouRebateResponse.setSelfTodayReciveRebate(selfDyMemPo.todayReciveRebate);
/*  860 */     daoYouRebateResponse.addAllRi(list);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void calDaoYouRebate(WNPlayer player, int rebateDiamond) {
/*  870 */     String playerId = player.getId();
/*  871 */     String playerName = player.getName();
/*  872 */     DaoYouMemberPO dyMemPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/*  873 */     if (dyMemPo == null) {
/*      */       return;
/*      */     }
/*      */     
/*  877 */     String dyId = dyMemPo.daoYouId;
/*  878 */     DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(dyId);
/*  879 */     if (dyp == null) {
/*      */       return;
/*      */     }
/*      */     
/*  883 */     List<String> daoYouMemPlayerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dyId);
/*  884 */     if (daoYouMemPlayerIds == null) {
/*      */       return;
/*      */     }
/*      */     
/*  888 */     Map<String, Integer> todaySendRebate = dyMemPo.todaySendRebate;
/*  889 */     if (todaySendRebate == null) {
/*  890 */       todaySendRebate = new HashMap<>();
/*      */     }
/*  892 */     int sumSendRebate = 0;
/*  893 */     for (Integer v : todaySendRebate.values()) {
/*  894 */       sumSendRebate += v.intValue();
/*      */     }
/*      */     
/*  897 */     int max = AllyConfiguration.getInstance().getConfigI("MaxFeeBack");
/*      */     
/*  899 */     if (sumSendRebate >= max) {
/*      */       return;
/*      */     }
/*  902 */     rebateDiamond = Math.min(max - sumSendRebate, rebateDiamond);
/*      */     
/*  904 */     List<DaoYouMemberPO> ranPlayer = new ArrayList<>();
/*  905 */     for (int i = 0; i < daoYouMemPlayerIds.size(); i++) {
/*  906 */       DaoYouMemberPO tempDyMemPo = DaoYouCenter.getInstance().getDaoYouMember(daoYouMemPlayerIds.get(i));
/*  907 */       ranPlayer.add(tempDyMemPo);
/*      */     } 
/*      */     
/*  910 */     int len = ranPlayer.size();
/*  911 */     if (len > rebateDiamond)
/*  912 */     { int leftValue = rebateDiamond;
/*  913 */       for (int j = 0; j < len; j++) {
/*  914 */         DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
/*  915 */         PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
/*  916 */         if (po != null)
/*      */         
/*      */         { 
/*  919 */           Integer old = todaySendRebate.get(po.name);
/*  920 */           if (old == null) {
/*  921 */             old = Integer.valueOf(0);
/*      */           }
/*  923 */           if (leftValue > 0) {
/*  924 */             int randomV = Utils.random(1, leftValue);
/*  925 */             tempDyMemPo.todayReciveRebate += randomV;
/*  926 */             leftValue -= randomV;
/*  927 */             todaySendRebate.put(po.name, Integer.valueOf(randomV + old.intValue()));
/*      */           } else {
/*  929 */             tempDyMemPo.todayReciveRebate += 0;
/*      */           } 
/*  931 */           DaoYouDao.updateDaoYouMember(tempDyMemPo); } 
/*      */       }  }
/*  933 */     else if (len == rebateDiamond)
/*  934 */     { for (int j = 0; j < len; j++) {
/*  935 */         DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
/*  936 */         tempDyMemPo.todayReciveRebate++;
/*  937 */         DaoYouDao.updateDaoYouMember(tempDyMemPo);
/*  938 */         PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
/*  939 */         if (po != null) {
/*      */ 
/*      */           
/*  942 */           Integer old = todaySendRebate.get(po.name);
/*  943 */           if (old == null) {
/*  944 */             old = Integer.valueOf(0);
/*      */           }
/*  946 */           todaySendRebate.put(po.name, Integer.valueOf(1 + old.intValue()));
/*      */         } 
/*      */       }  }
/*  949 */     else { int leftValue = rebateDiamond - len;
/*  950 */       for (int j = 0; j < len; j++) {
/*  951 */         DaoYouMemberPO tempDyMemPo = ranPlayer.get(j);
/*  952 */         PlayerPO po = PlayerUtil.getPlayerBaseData(tempDyMemPo.playerId);
/*  953 */         if (po != null) {
/*      */ 
/*      */           
/*  956 */           if (leftValue > 0) {
/*  957 */             int vaLeft = Utils.random(1, leftValue);
/*  958 */             tempDyMemPo.todayReciveRebate += 1 + vaLeft;
/*  959 */             leftValue -= vaLeft;
/*  960 */             leftValue = (leftValue > 0) ? leftValue : 0;
/*      */             
/*  962 */             Integer old = todaySendRebate.get(po.name);
/*  963 */             if (old == null) {
/*  964 */               old = Integer.valueOf(0);
/*      */             }
/*  966 */             todaySendRebate.put(po.name, Integer.valueOf(old.intValue() + 1 + vaLeft));
/*      */           } else {
/*  968 */             tempDyMemPo.todayReciveRebate++;
/*  969 */             Integer old = todaySendRebate.get(po.name);
/*  970 */             if (old == null) {
/*  971 */               old = Integer.valueOf(0);
/*      */             }
/*  973 */             todaySendRebate.put(po.name, Integer.valueOf(1 + old.intValue()));
/*      */           } 
/*  975 */           DaoYouDao.updateDaoYouMember(tempDyMemPo);
/*  976 */           if (j == len - 1 && 
/*  977 */             leftValue > 0) {
/*  978 */             DaoYouMemberPO firstDyMemPo = ranPlayer.get(0);
/*  979 */             firstDyMemPo.todayReciveRebate += leftValue;
/*  980 */             DaoYouDao.updateDaoYouMember(firstDyMemPo);
/*  981 */             po = PlayerUtil.getPlayerBaseData(firstDyMemPo.playerId);
/*  982 */             Integer old = todaySendRebate.get(po.name);
/*  983 */             if (old == null) {
/*  984 */               old = Integer.valueOf(0);
/*      */             }
/*  986 */             todaySendRebate.put(po.name, Integer.valueOf(leftValue + old.intValue()));
/*      */           } 
/*      */         } 
/*      */       }  }
/*      */     
/*  991 */     dyMemPo.todaySendRebate = todaySendRebate;
/*  992 */     dyMemPo.updateTime = new Date();
/*  993 */     DaoYouDao.updateDaoYouMember(dyMemPo);
/*  994 */     addDaoYouMessage(Const.DaoYou.DaoYouMessageTypeSystem.getValue(), null, dyp, "DAO_YOU_COST_DIAMOND", new Object[] { playerName });
/*  995 */     DaoYouDao.updateDaoYou(dyp);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendRebateMail(String toPlayerId, int rebateCount) {
/* 1005 */     MailSysData mailData = new MailSysData("Ally_rebate");
/* 1006 */     Map<String, String> replace = new HashMap<>();
/* 1007 */     replace.put("price", String.valueOf(rebateCount));
/* 1008 */     mailData.replace = replace;
/* 1009 */     mailData.attachments = new ArrayList();
/* 1010 */     MailData.Attachment item = new MailData.Attachment();
/* 1011 */     item.itemCode = "cash";
/* 1012 */     item.itemNum = rebateCount;
/* 1013 */     mailData.attachments.add(item);
/* 1014 */     MailUtil.getInstance().sendMailToOnePlayer(toPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.DAOYOU);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getDaoYouMemPlayerId(String playerId) {
/* 1024 */     DaoYouMemberPO memberPo = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/* 1025 */     if (memberPo == null) {
/* 1026 */       return null;
/*      */     }
/*      */     
/* 1029 */     String daoYouId = memberPo.daoYouId;
/* 1030 */     List<String> memPlayerId = DaoYouCenter.getInstance().getAllDaoYouMember(daoYouId);
/* 1031 */     return memPlayerId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendDaoYou(WNPlayer player, PomeloPush chatPush) {
/* 1041 */     DaoYouMemberPO dymp = DaoYouCenter.getInstance().getDaoYouMember(player.getId());
/* 1042 */     List<String> playerIds = DaoYouCenter.getInstance().getAllDaoYouMember(dymp.daoYouId);
/* 1043 */     for (String playerId : playerIds) {
/* 1044 */       WNPlayer daoyou = PlayerUtil.getOnlinePlayer(playerId);
/* 1045 */       if (daoyou != null) {
/* 1046 */         daoyou.receive((Message)chatPush);
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
/*      */   public DaoYouPO getDaoYou(String playerId) {
/* 1058 */     DaoYouMemberPO member = DaoYouCenter.getInstance().getDaoYouMember(playerId);
/* 1059 */     if (member == null) {
/* 1060 */       return null;
/*      */     }
/* 1062 */     DaoYouPO daoYou = DaoYouCenter.getInstance().getDaoYou(member.daoYouId);
/* 1063 */     return daoYou;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processDaoYouChange(List<String> daoYouMemPlayerId, DaoYouMemberPO changeMemPo, boolean isJoin) {
/* 1074 */     String daoYouId = changeMemPo.daoYouId;
/* 1075 */     String changePlayerId = changeMemPo.playerId;
/* 1076 */     PlayerPO changePlayerPo = PlayerUtil.getPlayerBaseData(changePlayerId);
/* 1077 */     if (isJoin) {
/* 1078 */       if (daoYouMemPlayerId == null) {
/*      */         return;
/*      */       }
/* 1081 */       for (int i = 0; i < daoYouMemPlayerId.size(); i++) {
/* 1082 */         String tempPlayerId = daoYouMemPlayerId.get(i);
/* 1083 */         WNPlayer player = PlayerUtil.findPlayer(tempPlayerId);
/* 1084 */         if (player != null) {
/*      */ 
/*      */           
/* 1087 */           player.sendSysTip(LangService.format("DAO_YOU_JOIN_SUCCESS_NOTICE", new Object[] { changePlayerPo.name }));
/* 1088 */           player.btlDataManager.onDaoYouChange();
/* 1089 */           player.refreshBattlerServerEffect(false);
/* 1090 */           player.calFightPower();
/* 1091 */           player.pushDynamicData("fightPower", Integer.valueOf(player.player.fightPower));
/*      */         } 
/* 1093 */       }  WNPlayer changePlayer = PlayerUtil.findPlayer(changePlayerId);
/* 1094 */       if (changePlayer != null) {
/* 1095 */         changePlayer.btlDataManager.onDaoYouChange();
/* 1096 */         changePlayer.refreshBattlerServerEffect(false);
/* 1097 */         changePlayer.calFightPower();
/* 1098 */         changePlayer.pushDynamicData("fightPower", Integer.valueOf(changePlayer.player.fightPower));
/*      */       } 
/*      */     } else {
/* 1101 */       int everyMemRecive = 0;
/* 1102 */       int todayReciveRebate = changeMemPo.todayReciveRebate;
/* 1103 */       int leftMemCount = daoYouMemPlayerId.size() - 1;
/* 1104 */       everyMemRecive = todayReciveRebate / leftMemCount;
/* 1105 */       for (int i = 0; i < daoYouMemPlayerId.size(); i++) {
/* 1106 */         String tempPlayerId = daoYouMemPlayerId.get(i);
/* 1107 */         WNPlayer player = PlayerUtil.findPlayer(tempPlayerId);
/* 1108 */         if (player != null) {
/*      */ 
/*      */           
/* 1111 */           if (!tempPlayerId.equals(changePlayerId)) {
/* 1112 */             String sendMessage = LangService.format("DAO_YOU_LEAVE_NO_REBEATE", new Object[] { changePlayerPo.name });
/* 1113 */             DaoYouMemberPO tempDaoYouMemberPo = DaoYouCenter.getInstance().getDaoYouMember(tempPlayerId);
/* 1114 */             if (tempDaoYouMemberPo != null) {
/* 1115 */               if (changeMemPo.todayReciveRebate != 0) {
/* 1116 */                 sendMessage = LangService.format("DAO_YOU_LEAVE", new Object[] { changePlayerPo.name, Integer.valueOf(changeMemPo.todayReciveRebate) });
/*      */               }
/* 1118 */               tempDaoYouMemberPo.todayReciveRebate += everyMemRecive;
/* 1119 */               DaoYouDao.updateDaoYouMember(tempDaoYouMemberPo);
/*      */             } 
/* 1121 */             player.sendSysTip(sendMessage);
/*      */           } 
/* 1123 */           player.btlDataManager.onDaoYouChange();
/* 1124 */           player.refreshBattlerServerEffect(false);
/* 1125 */           player.calFightPower();
/* 1126 */           player.pushDynamicData("fightPower", Integer.valueOf(player.player.fightPower));
/*      */         } 
/*      */       } 
/* 1129 */     }  DaoYouPO dyp = DaoYouCenter.getInstance().getDaoYou(daoYouId);
/* 1130 */     if (dyp != null) {
/* 1131 */       dyp.fightPower = calDaoYouFightPower(daoYouId, DaoYouCenter.getInstance().getAllDaoYouMember(dyp.id));
/* 1132 */       DaoYouDao.updateDaoYou(dyp);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\daoyou\DaoYouService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */