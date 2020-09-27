/*      */ package com.wanniu.game.friend;
/*      */ 
/*      */ import com.alibaba.fastjson.JSON;
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.game.entity.GPlayer;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.game.area.Area;
/*      */ import com.wanniu.game.common.CommonUtil;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.msg.MessageUtil;
/*      */ import com.wanniu.game.daoyou.DaoYouService;
/*      */ import com.wanniu.game.data.SShopCO;
/*      */ import com.wanniu.game.data.SocialFriendCO;
/*      */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*      */ import com.wanniu.game.guild.GuildUtil;
/*      */ import com.wanniu.game.message.MessageData;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.poes.GuildMemberPO;
/*      */ import com.wanniu.game.poes.GuildPO;
/*      */ import com.wanniu.game.poes.PlayerAttachPO;
/*      */ import com.wanniu.game.poes.PlayerFriendsPO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.poes.SevenGoalPO;
/*      */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*      */ import com.wanniu.game.social.SocialFriendProps;
/*      */ import com.wanniu.game.sysSet.SysSetFlag;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.FriendHandler;
/*      */ import pomelo.chat.ChatHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FriendManager
/*      */ {
/*   58 */   private static BlackListComparator blackListComparator = new BlackListComparator();
/*   59 */   private static FriendMessageComparator friendMessageComparator = new FriendMessageComparator();
/*   60 */   private static FriendInfoComparator friendInfoComparator = new FriendInfoComparator();
/*   61 */   private static FriendComparator friendComparator = new FriendComparator();
/*      */   
/*      */   private String playerId;
/*      */   
/*      */   private PlayerPO player;
/*      */   public PlayerFriendsPO po;
/*      */   
/*      */   public static class ApplyFriendData
/*      */   {
/*      */     public String id;
/*      */     public long time;
/*      */     
/*      */     public ApplyFriendData() {}
/*      */     
/*      */     public ApplyFriendData(String id, long time) {
/*   76 */       this.id = id;
/*   77 */       this.time = time;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class RecordInfo
/*      */   {
/*      */     public String friendId;
/*      */     public Date concernTime;
/*      */   }
/*      */   
/*      */   public FriendManager() {}
/*      */   
/*      */   public FriendManager(String playerId, PlayerFriendsPO data) {
/*   91 */     setPlayerId(playerId);
/*   92 */     this.po = data;
/*   93 */     this.player = PlayerUtil.getPlayerBaseData(playerId);
/*      */     
/*   95 */     if (this.po == null) {
/*   96 */       this.po = new PlayerFriendsPO();
/*   97 */       PlayerPOManager.put(ConstsTR.player_friendsTR, playerId, (GEntity)this.po);
/*      */     } 
/*      */   }
/*      */   
/*      */   public List<FriendHandler.PlayerInfo> getAllFriends() {
/*  102 */     List<FriendHandler.PlayerInfo> friends = new ArrayList<>();
/*  103 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  104 */       FriendData data = node.getValue();
/*  105 */       FriendHandler.PlayerInfo friend = data.friendToJson4PayLoad((RecordInfo)this.po.recordInfos.get(data.friendId));
/*  106 */       if (friend != null) {
/*  107 */         friends.add(friend);
/*      */       }
/*      */     } 
/*      */     
/*  111 */     friends.sort(friendComparator);
/*  112 */     return friends;
/*      */   }
/*      */   
/*      */   public final String friendApply(String toPlayerId, WNPlayer player) {
/*  116 */     boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());
/*      */     
/*  118 */     if (!bOpen) {
/*  119 */       return FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue());
/*      */     }
/*  121 */     bOpen = PlayerUtil.isPlayerOpenedFunction(toPlayerId, Const.FunctionType.FRIEND.getValue());
/*  122 */     if (!bOpen) {
/*  123 */       return LangService.getValue("FUNC_SET_TARGET_NOT_OPEN");
/*      */     }
/*  125 */     if (this.po.blackList.containsKey(toPlayerId)) {
/*  126 */       return LangService.getValue("FRIEND_TARGET_IN_BLACK_LIST");
/*      */     }
/*      */     
/*  129 */     PlayerPO toPlayer = PlayerUtil.getPlayerBaseData(toPlayerId);
/*  130 */     if (toPlayer == null) {
/*  131 */       return LangService.getValue("CROSS_SERVER_AUTH_LIMIT_ADDFRIEND");
/*      */     }
/*      */ 
/*      */     
/*  135 */     PlayerAttachPO playerAttachPO = (PlayerAttachPO)PlayerPOManager.findPO(ConstsTR.playerAttachTR, toPlayerId, PlayerAttachPO.class);
/*  136 */     if (null != playerAttachPO && (
/*  137 */       playerAttachPO.sysSet & SysSetFlag.recvAddFriendSet.getValue()) == 0) {
/*  138 */       return LangService.getValue("FRIEND_FORBIDDEN_APPLY");
/*      */     }
/*      */ 
/*      */     
/*  142 */     if (hasApplyFriend(toPlayerId)) {
/*  143 */       return LangService.getValue("FRIEND_HAVE_ALREADY_APPLY");
/*      */     }
/*      */     
/*  146 */     FriendManager toPlayerFriendManager = FriendsCenter.getInstance().getFriendsMgr(toPlayerId);
/*  147 */     if (toPlayerFriendManager.isInBlackList(this.playerId)) {
/*  148 */       return LangService.getValue("FRIEND_IN_BLACK_LIST");
/*      */     }
/*      */     
/*  151 */     int num = applyFriendLength();
/*  152 */     if (num >= GlobalConfig.Social_InviteFriendMax) {
/*  153 */       return LangService.getValue("FRIEND_APPLY_FULL");
/*      */     }
/*      */ 
/*      */     
/*  157 */     if (toPlayerId.equals(this.playerId)) {
/*  158 */       return LangService.getValue("FRIEND_TARGET PLAYER_YOUSELF");
/*      */     }
/*  160 */     int friendNumLimit = GlobalConfig.Social_MaxFriendNum;
/*      */     
/*  162 */     if (this.po.friends.size() >= friendNumLimit) {
/*  163 */       return LangService.getValue("FRIEND_LIST_FULL");
/*      */     }
/*  165 */     if (this.po.friends.containsKey(toPlayerId)) {
/*  166 */       return LangService.getValue("FRIEND_HAVE_BEEN_FRIENDS");
/*      */     }
/*  168 */     if (toPlayerFriendManager.po.friends.size() >= friendNumLimit) {
/*  169 */       return LangService.getValue("FRIEND_TARGET_LIST_FULL");
/*      */     }
/*      */     
/*  172 */     if (isInFriendMessage(toPlayerId)) {
/*  173 */       return LangService.getValue("FRIEND_HAVE_IN_YOU_APPLY");
/*      */     }
/*      */     
/*  176 */     addApplyFriend(toPlayerId);
/*  177 */     addFriendMessageToFriend(player, toPlayerId);
/*  178 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final TreeMap<String, Object> friendAllApply(List<String> toPlayerIds, WNPlayer player) {
/*  184 */     TreeMap<String, Object> rtData = new TreeMap<>();
/*  185 */     rtData.put("result", Boolean.valueOf(true));
/*  186 */     rtData.put("info", LangService.getValue("FRIEND_SEND_MESSAGE"));
/*      */     
/*  188 */     boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());
/*      */     
/*  190 */     if (!bOpen) {
/*  191 */       rtData.put("result", Boolean.valueOf(false));
/*  192 */       rtData.put("info", FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue()));
/*  193 */       return rtData;
/*      */     } 
/*      */     
/*  196 */     int friendNumLimit = GlobalConfig.Social_MaxFriendNum;
/*      */     
/*  198 */     if (this.po.friends.size() >= friendNumLimit) {
/*  199 */       rtData.put("result", Boolean.valueOf(false));
/*  200 */       rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
/*  201 */       return rtData;
/*      */     } 
/*      */     
/*  204 */     int num = applyFriendLength();
/*  205 */     if (num >= GlobalConfig.Social_InviteFriendMax) {
/*  206 */       rtData.put("result", Boolean.valueOf(false));
/*  207 */       rtData.put("info", LangService.getValue("FRIEND_APPLY_FULL"));
/*  208 */       return rtData;
/*      */     } 
/*      */     
/*  211 */     boolean bNeedApply = false;
/*  212 */     bOpen = false;
/*      */     
/*  214 */     for (String playerId : toPlayerIds) {
/*  215 */       boolean result = PlayerUtil.isPlayerOpenedFunction(playerId, Const.FunctionType.FRIEND.getValue());
/*  216 */       if (result) {
/*  217 */         bOpen = true;
/*  218 */         if (!hasApplyFriend(playerId)) {
/*  219 */           bNeedApply = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  225 */     if (!bOpen) {
/*  226 */       rtData.put("result", Boolean.valueOf(false));
/*  227 */       rtData.put("info", LangService.getValue("FUNC_SET_TARGET_NOT_OPEN"));
/*  228 */       return rtData;
/*      */     } 
/*      */     
/*  231 */     if (!bNeedApply) {
/*  232 */       rtData.put("result", Boolean.valueOf(false));
/*  233 */       rtData.put("info", LangService.getValue("FRIEND_HAVE_ALREADY_APPLY"));
/*  234 */       return rtData;
/*      */     } 
/*      */     
/*  237 */     for (String playerId : toPlayerIds) {
/*  238 */       friendApply(playerId, player);
/*      */     }
/*  240 */     return rtData;
/*      */   }
/*      */   
/*      */   public final void addFriendMessageToFriend(WNPlayer player, String friendId) {
/*  244 */     FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
/*  245 */     friendMgr.addFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*      */     
/*  247 */     Map<String, String> strMsg = new HashMap<>(1);
/*  248 */     strMsg.put("playerName", player.getName());
/*  249 */     MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.friend_invite.getValue(), this.playerId, null, strMsg);
/*  250 */     if (player.messageManager.addSendedMessage(message)) {
/*  251 */       MessageUtil.sendMessageToPlayer(message, friendId);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public TreeMap<String, Object> friendAllAgreeApply(List<String> requestIds, WNPlayer player) {
/*  257 */     TreeMap<String, Object> rtData = new TreeMap<>();
/*  258 */     rtData.put("result", Boolean.valueOf(true));
/*      */     
/*  260 */     if (this.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
/*  261 */       rtData.put("result", Boolean.valueOf(false));
/*  262 */       rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
/*  263 */       return rtData;
/*      */     } 
/*  265 */     for (String s : requestIds) {
/*  266 */       friendAgreeApply(s);
/*      */     }
/*  268 */     return rtData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, Object> friendAgreeApply(String requestId) {
/*  278 */     Map<String, Object> rtData = new HashMap<>();
/*  279 */     rtData.put("result", Boolean.valueOf(true));
/*      */     
/*  281 */     if (requestId.equals(this.playerId)) {
/*  282 */       rtData.put("result", Boolean.valueOf(false));
/*  283 */       rtData.put("info", LangService.getValue("FRIEND_TARGET"));
/*  284 */       return rtData;
/*      */     } 
/*      */     
/*  287 */     if (this.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
/*  288 */       removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*  289 */       rtData.put("result", Boolean.valueOf(false));
/*  290 */       rtData.put("info", LangService.getValue("FRIEND_LIST_FULL"));
/*  291 */       return rtData;
/*      */     } 
/*      */     
/*  294 */     if (this.po.friends.containsKey(requestId)) {
/*  295 */       removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*  296 */       rtData.put("result", Boolean.valueOf(false));
/*  297 */       rtData.put("info", LangService.getValue("FRIEND_HAVE_BEEN_FRIENDS"));
/*  298 */       return rtData;
/*      */     } 
/*      */     
/*  301 */     FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(requestId);
/*  302 */     if (friendMgr.po.friends.size() >= GlobalConfig.Social_MaxFriendNum) {
/*  303 */       removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*  304 */       rtData.put("result", Boolean.valueOf(false));
/*  305 */       rtData.put("info", LangService.getValue("FRIEND_TARGET_LIST_FULL"));
/*  306 */       return rtData;
/*      */     } 
/*      */     
/*  309 */     if (friendMgr.po.blackList.containsKey(this.playerId)) {
/*  310 */       rtData.put("result", Boolean.valueOf(false));
/*  311 */       rtData.put("info", LangService.getValue("FRIEND_IN_BLACK_LIST"));
/*  312 */       return rtData;
/*      */     } 
/*      */ 
/*      */     
/*  316 */     addFriend(requestId);
/*  317 */     removeApplyFriend(requestId);
/*  318 */     removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*      */ 
/*      */     
/*  321 */     friendMgr.addFriend(this.playerId);
/*  322 */     friendMgr.removeFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());
/*  323 */     friendMgr.removeApplyFriend(this.player.id);
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
/*  335 */     WNPlayer player = PlayerUtil.findPlayer(this.playerId);
/*  336 */     String msg = LangService.getValue("FRIEND_INVITATION_SUCCESS");
/*  337 */     if (null != player) {
/*  338 */       msg = msg.replace("{friendName}", player.getName());
/*      */     }
/*      */     
/*  341 */     Out.debug(new Object[] { "fromPlayer.sendSysMessage ", msg });
/*  342 */     PlayerUtil.sendSysMessageToPlayer(msg, requestId, null);
/*      */     
/*  344 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ADD_FRIEND, new Object[0]);
/*  345 */     WNPlayer friend = PlayerUtil.getOnlinePlayer(requestId);
/*  346 */     if (friend != null) {
/*  347 */       friend.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.ADD_FRIEND, new Object[0]);
/*      */     } else {
/*      */       
/*  350 */       SevenGoalPO sevenGoalPO = (SevenGoalPO)PlayerPOManager.findPO(ConstsTR.SevenGoal, requestId, SevenGoalPO.class);
/*  351 */       sevenGoalPO.processAddFriend();
/*      */     } 
/*  353 */     return rtData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void addFriend(String requestId) {
/*  363 */     if (this.playerId.equals(requestId)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  368 */     if (this.po.friends.containsKey(requestId)) {
/*      */       return;
/*      */     }
/*      */     
/*  372 */     FriendData friend = new FriendData();
/*  373 */     friend.friendId = requestId;
/*  374 */     friend.friendLv = 0;
/*  375 */     friend.createTimeStamp = new Date();
/*  376 */     friend.addFriendLvTime = new Date(0L);
/*  377 */     friend.addFriendLvToday = 0;
/*      */     
/*  379 */     Out.debug(new Object[] { "add a new Friend: ", friend });
/*  380 */     this.po.friends.put(friend.friendId, friend);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final FriendHandler.Position getFriendPosition(String friendId) {
/*  390 */     FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
/*  391 */     WNPlayer friendPlayer = PlayerUtil.findPlayer(friendId);
/*  392 */     if (null != friendPlayer) {
/*  393 */       Area area = friendPlayer.getArea();
/*  394 */       if (null != area) {
/*  395 */         currentPos.setAreaName(area.getSceneName());
/*  396 */         currentPos.setAreaId(area.areaId);
/*      */       } 
/*      */     } else {
/*  399 */       currentPos.setAreaName("");
/*  400 */       currentPos.setTargetX(0);
/*  401 */       currentPos.setTargetY(0);
/*  402 */       currentPos.setAreaId(0);
/*      */     } 
/*      */     
/*  405 */     return currentPos.build();
/*      */   }
/*      */   
/*      */   public final boolean isFriend(String friendId) {
/*  409 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  410 */       if (((FriendData)node.getValue()).friendId.equals(friendId)) {
/*  411 */         return true;
/*      */       }
/*      */     } 
/*  414 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getAllFriendId() {
/*  423 */     return this.po.friends.keySet();
/*      */   }
/*      */   
/*      */   public final List<String> getAllOnlineFriendId() {
/*  427 */     ArrayList<String> data = new ArrayList<>();
/*  428 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  429 */       if (PlayerUtil.isOnline(node.getKey())) {
/*  430 */         data.add(node.getKey());
/*      */       }
/*      */     } 
/*  433 */     return data;
/*      */   }
/*      */   
/*      */   public final int getFriendsNum() {
/*  437 */     return this.po.friends.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public final ArrayList<FriendHandler.PlayerInfo> addFriendInfo(int selfLevel) {
/*  442 */     ArrayList<FriendHandler.PlayerInfo> friendInfos = new ArrayList<>();
/*  443 */     ArrayList<FriendHandler.PlayerInfo> otherfriendInfos = new ArrayList<>();
/*      */     
/*  445 */     int recommendNumLimit = GlobalConfig.Social_RecommendNum;
/*  446 */     int levelRange = GlobalConfig.Social_LevelRange;
/*      */     
/*  448 */     List<GPlayer> players = new ArrayList<>();
/*  449 */     for (GPlayer player : PlayerUtil.getAllOnlinePlayer()) {
/*  450 */       boolean isOpen = PlayerUtil.isPlayerOpenedFunction(player.getId(), Const.FunctionType.FRIEND.getValue());
/*  451 */       if (isOpen) {
/*  452 */         players.add(player);
/*      */       }
/*      */     } 
/*  455 */     Random r = new Random();
/*  456 */     while (players.size() > 0) {
/*  457 */       int idx = r.nextInt(players.size());
/*  458 */       WNPlayer friendPlayer = (WNPlayer)players.get(idx);
/*  459 */       if (null == friendPlayer) {
/*  460 */         players.remove(idx);
/*      */         
/*      */         continue;
/*      */       } 
/*  464 */       String playerId = friendPlayer.getId();
/*  465 */       if (null == friendPlayer || playerId.equals(this.playerId) || this.po.friends
/*  466 */         .containsKey(playerId) || this.po.blackList
/*  467 */         .containsKey(playerId) || 
/*  468 */         hasApplyFriend(playerId) || 
/*  469 */         isInFriendMessage(playerId)) {
/*      */         
/*  471 */         players.remove(idx);
/*      */         
/*      */         continue;
/*      */       } 
/*  475 */       if (friendPlayer.getLogicServerId() != this.player.logicServerId) {
/*  476 */         players.remove(idx);
/*      */         
/*      */         continue;
/*      */       } 
/*  480 */       FriendHandler.PlayerInfo.Builder friendInfo = FriendHandler.PlayerInfo.newBuilder();
/*  481 */       friendInfo.setId(playerId);
/*  482 */       friendInfo.setGuildId(friendPlayer.guildManager.getGuildId());
/*  483 */       friendInfo.setGuildName(friendPlayer.guildManager.getGuildName());
/*  484 */       friendInfo.setName(friendPlayer.getName());
/*  485 */       friendInfo.setLevel(friendPlayer.getLevel());
/*  486 */       friendInfo.setPro(friendPlayer.getPro());
/*  487 */       friendInfo.setStageLevel(friendPlayer.player.upLevel);
/*  488 */       friendInfo.setVip(0);
/*  489 */       friendInfo.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));
/*      */       
/*  491 */       List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(playerId);
/*  492 */       friendInfo.addAllAvatars(avatars);
/*  493 */       if (Math.abs(friendInfo.getLevel() - selfLevel) < levelRange) {
/*  494 */         friendInfos.add(friendInfo.build());
/*  495 */         if (friendInfos.size() >= recommendNumLimit) {
/*  496 */           players.remove(idx);
/*      */           
/*      */           break;
/*      */         } 
/*  500 */       } else if (otherfriendInfos.size() < recommendNumLimit) {
/*  501 */         otherfriendInfos.add(friendInfo.build());
/*      */       } 
/*      */       
/*  504 */       players.remove(idx);
/*      */     } 
/*      */     
/*  507 */     if (friendInfos.size() < recommendNumLimit) {
/*  508 */       while (otherfriendInfos.size() > 0) {
/*  509 */         int idx = r.nextInt(otherfriendInfos.size());
/*  510 */         friendInfos.add(otherfriendInfos.get(idx));
/*  511 */         if (friendInfos.size() >= recommendNumLimit) {
/*  512 */           otherfriendInfos.remove(idx);
/*      */           break;
/*      */         } 
/*  515 */         otherfriendInfos.remove(idx);
/*      */       } 
/*      */     }
/*  518 */     friendInfos.sort(friendInfoComparator);
/*  519 */     return friendInfos;
/*      */   }
/*      */   
/*      */   public FriendHandler.PlayerInfo.Builder getPlayerBaseData(String playerId) {
/*  523 */     FriendHandler.PlayerInfo.Builder datas = FriendHandler.PlayerInfo.newBuilder();
/*  524 */     FriendHandler.Position.Builder currentPos = FriendHandler.Position.newBuilder();
/*  525 */     boolean isOnline = PlayerUtil.isOnline(playerId);
/*  526 */     datas.setIsOnline(isOnline ? 1 : 0);
/*      */     
/*  528 */     if (isOnline) {
/*  529 */       WNPlayer friendPlayer = PlayerUtil.findPlayer(playerId);
/*  530 */       if (null == friendPlayer) {
/*  531 */         return datas;
/*      */       }
/*      */       
/*  534 */       datas.setGuildId(friendPlayer.guildManager.getGuildId());
/*  535 */       datas.setGuildName(friendPlayer.guildManager.getGuildName());
/*      */       
/*  537 */       datas.setName(friendPlayer.getName());
/*  538 */       datas.setLevel(friendPlayer.getLevel());
/*  539 */       datas.setPro(friendPlayer.getPro());
/*  540 */       datas.setStageLevel(friendPlayer.player.upLevel);
/*  541 */       datas.setVip(0);
/*  542 */       datas.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));
/*      */       
/*  544 */       if (DaoYouService.getInstance().getDaoYou(friendPlayer.getId()) != null) {
/*  545 */         datas.setHasAlly(1);
/*      */       }
/*  547 */       Area area = friendPlayer.getArea();
/*  548 */       if (area != null) {
/*  549 */         currentPos.setAreaName(area.getSceneName());
/*  550 */         currentPos.setAreaId(area.areaId);
/*      */       } 
/*      */     } else {
/*  553 */       PlayerPO friendPlayer = PlayerUtil.getPlayerBaseData(playerId);
/*      */       
/*  555 */       if (null == friendPlayer) {
/*  556 */         return datas;
/*      */       }
/*      */       
/*  559 */       datas.setName(friendPlayer.name);
/*  560 */       datas.setLevel(friendPlayer.level);
/*  561 */       datas.setPro(friendPlayer.pro);
/*  562 */       datas.setStageLevel(friendPlayer.upLevel);
/*  563 */       datas.setVip(0);
/*  564 */       datas.setGuildId("");
/*  565 */       datas.setGuildName("");
/*      */       
/*  567 */       GuildMemberPO myInfo = GuildUtil.getGuildMember(playerId);
/*  568 */       if (null != myInfo) {
/*  569 */         GuildPO myGuild = GuildUtil.getGuild(myInfo.guildId);
/*  570 */         if (null != myGuild) {
/*  571 */           datas.setGuildId(myGuild.id);
/*  572 */           datas.setGuildName(myGuild.name);
/*      */         } 
/*      */       } 
/*      */       
/*  576 */       datas.setFightPower(friendPlayer.fightPower);
/*      */     } 
/*      */     
/*  579 */     datas.setId(playerId);
/*  580 */     datas.setCurrentPos(currentPos.build());
/*  581 */     return datas;
/*      */   }
/*      */ 
/*      */   
/*      */   public FriendHandler.QueryPlayerNameResponse.Builder queryPlayerName(String strName) {
/*  586 */     FriendHandler.QueryPlayerNameResponse.Builder data = FriendHandler.QueryPlayerNameResponse.newBuilder();
/*      */     
/*  588 */     int playerNum = 0;
/*      */     
/*  590 */     int recommendNumLimit = GlobalConfig.Social_RecommendNum;
/*  591 */     ArrayList<FriendHandler.PlayerInfo> list = new ArrayList<>();
/*  592 */     Collection<GPlayer> players = PlayerUtil.getAllOnlinePlayer();
/*  593 */     for (GPlayer player : players) {
/*  594 */       WNPlayer friendPlayer = (WNPlayer)player;
/*      */       
/*  596 */       if (this.playerId.equals(friendPlayer.getId())) {
/*      */         continue;
/*      */       }
/*  599 */       FriendHandler.PlayerInfo.Builder playerName = FriendHandler.PlayerInfo.newBuilder();
/*  600 */       playerName.setId(friendPlayer.getId());
/*  601 */       playerName.setGuildId(friendPlayer.guildManager.getGuildId());
/*  602 */       playerName.setGuildName(friendPlayer.guildManager.getGuildName());
/*  603 */       playerName.setName(friendPlayer.getName());
/*  604 */       playerName.setLevel(friendPlayer.getLevel());
/*  605 */       playerName.setPro(friendPlayer.getPro());
/*  606 */       playerName.setStageLevel(friendPlayer.player.upLevel);
/*  607 */       playerName.setVip(0);
/*  608 */       playerName.setFightPower(CommonUtil.calFightPower(friendPlayer.btlDataManager.allInflus));
/*  609 */       List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(friendPlayer.getId());
/*  610 */       playerName.addAllAvatars(avatars);
/*  611 */       if (playerName.getName().equals(strName)) {
/*  612 */         list.add(playerName.build());
/*  613 */         playerNum++;
/*      */       } 
/*  615 */       if (playerNum >= recommendNumLimit)
/*      */         break; 
/*      */     } 
/*  618 */     if (list.size() == 0) {
/*  619 */       data.setS2CMsg(LangService.getValue("FRIEND_FIND_NONE"));
/*  620 */       data.setS2CCode(500);
/*      */     } else {
/*  622 */       data.setS2CCode(200);
/*      */     } 
/*  624 */     data.addAllData(list);
/*  625 */     return data;
/*      */   }
/*      */   
/*      */   public final void onPlayerEnter(Date logoutTime) {
/*  629 */     Date nowTime = new Date();
/*  630 */     int days = (int)Math.floor(((nowTime.getTime() - logoutTime.getTime()) / 86400000L));
/*      */     
/*  632 */     int decreaseFriendLv = days * GlobalConfig.Social_FavorReduce;
/*      */     
/*  634 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  635 */       FriendData data = node.getValue();
/*  636 */       if (days > 0) {
/*  637 */         data.friendLv -= decreaseFriendLv;
/*      */         
/*  639 */         if (data.friendLv < 0) {
/*  640 */           data.friendLv = 0;
/*      */         }
/*      */       } 
/*      */       
/*  644 */       String strData = MessageUtil.getPlayerNameColor(this.player.name, this.player.pro);
/*      */       
/*  646 */       String msg = LangService.getValue("FRIEND_ONLINE");
/*      */       
/*  648 */       msg = msg.replace("{playerName}", strData);
/*  649 */       WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
/*  650 */       if (null != player) {
/*  651 */         MessageUtil.sendSysChat(player, msg, Const.TipsType.NORMAL);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void onPlayerOffline() {
/*  660 */     WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
/*  661 */     if (null == selfPlayer) {
/*      */       return;
/*      */     }
/*  664 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  665 */       String strData = MessageUtil.getPlayerNameColor(this.player.name, this.player.pro);
/*  666 */       String msg = LangService.getValue("FRIEND_OFFLINE");
/*  667 */       msg = msg.replace("{playerName}", strData);
/*  668 */       ChatHandler.OnChatPush.Builder chatMsg = MessageUtil.createChatMsg(selfPlayer, msg, Const.CHAT_SCOPE.SYSTEM, Const.TipsType.NORMAL);
/*  669 */       WNPlayer player = PlayerUtil.findPlayer(node.getKey());
/*  670 */       if (null != player) {
/*  671 */         player.receive("chat.chatPush.onChatPush", (GeneratedMessage)chatMsg.build());
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public final TreeMap<String, Object> concernFriend(String friendId, WNPlayer player) {
/*  677 */     TreeMap<String, Object> rtData = new TreeMap<>();
/*  678 */     rtData.put("result", Boolean.valueOf(true));
/*  679 */     rtData.put("info", "");
/*  680 */     if (!this.po.friends.containsKey(friendId)) {
/*  681 */       rtData.put("result", Boolean.valueOf(false));
/*  682 */       rtData.put("info", LangService.getValue("FRIEND_TARGET_HAVE_DELETE"));
/*  683 */       return rtData;
/*      */     } 
/*  685 */     if (!PlayerUtil.isOnline(friendId)) {
/*  686 */       rtData.put("result", Boolean.valueOf(false));
/*  687 */       rtData.put("info", LangService.getValue("PLAYER_NOT_ONLINE"));
/*  688 */       return rtData;
/*      */     } 
/*      */     
/*  691 */     if (!this.po.recordInfos.containsKey(friendId)) {
/*  692 */       RecordInfo recordInfo = new RecordInfo();
/*  693 */       recordInfo.friendId = friendId;
/*  694 */       recordInfo.concernTime = new Date(0L);
/*  695 */       this.po.recordInfos.put(friendId, recordInfo);
/*      */     } 
/*  697 */     Date concernTime = ((RecordInfo)this.po.recordInfos.get(friendId)).concernTime;
/*      */     
/*  699 */     Date currDate = new Date();
/*  700 */     if (DateUtil.isSameDay(concernTime, currDate)) {
/*  701 */       rtData.put("result", Boolean.valueOf(false));
/*  702 */       rtData.put("info", LangService.getValue("FRIEND_ALREAD_CONCERNED"));
/*  703 */       return rtData;
/*      */     } 
/*  705 */     RecordInfo info = (RecordInfo)this.po.recordInfos.get(friendId);
/*  706 */     info.concernTime = currDate;
/*  707 */     this.po.recordInfos.put(friendId, info);
/*      */     
/*  709 */     SocialFriendCO socialFriendProp = SocialFriendProps.findByMSocialAction(1);
/*      */     
/*  711 */     addFriendLv(friendId, socialFriendProp.favorNum);
/*      */     
/*  713 */     socialFriendProp = SocialFriendProps.findByMSocialAction(2);
/*      */     
/*  715 */     int friendLv = socialFriendProp.favorNum;
/*      */     
/*  717 */     FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
/*  718 */     friendMgr.addFriendMessage(this.playerId, Const.FriendMessageType.TYPE_CONCERN.getValue());
/*  719 */     friendMgr.addFriendShipPoint();
/*  720 */     friendMgr.addFriendLv(this.playerId, friendLv);
/*      */     
/*  722 */     WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
/*      */     
/*  724 */     if (friendConcernTimesToday() == GlobalConfig.Social_FocusNum) {
/*      */       
/*  726 */       selfPlayer.initAndCalAllInflu(null);
/*  727 */       selfPlayer.pushAndRefreshEffect(false);
/*      */     } 
/*      */     
/*  730 */     player.getPlayerTasks().dealTaskEvent(Const.TaskType.CONCERN_FRIEND, 1);
/*      */     
/*  732 */     return rtData;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void addFriendLv(String friendId, int addFriendLv) {
/*  737 */     if (!this.po.friends.containsKey(friendId)) {
/*      */       return;
/*      */     }
/*  740 */     FriendData friendData = (FriendData)this.po.friends.get(friendId);
/*  741 */     if (addFriendLv < 0) {
/*  742 */       friendData.friendLv += addFriendLv;
/*      */       
/*  744 */       if (friendData.friendLv < 0) {
/*  745 */         friendData.friendLv = 0;
/*      */       }
/*  747 */       this.po.friends.put(friendId, friendData);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  752 */     Date currDate = new Date();
/*  753 */     if (!DateUtil.isSameDay(friendData.addFriendLvTime, currDate)) {
/*  754 */       friendData.addFriendLvToday = 0;
/*  755 */       friendData.addFriendLvTime = currDate;
/*      */     } 
/*      */     
/*  758 */     int favorNumMax = GlobalConfig.Social_FavorNumMax;
/*  759 */     int favorNumDailyMax = GlobalConfig.Social_FavorNumDailyMax;
/*      */     
/*  761 */     if (friendData.friendLv >= favorNumMax || friendData.addFriendLvToday >= favorNumDailyMax) {
/*      */       return;
/*      */     }
/*      */     
/*  765 */     friendData.friendLv += addFriendLv;
/*  766 */     friendData.addFriendLvToday += addFriendLv;
/*      */     
/*  768 */     if (friendData.friendLv > favorNumMax) {
/*  769 */       friendData.addFriendLvToday -= friendData.friendLv - favorNumMax;
/*      */       
/*  771 */       friendData.friendLv = favorNumMax;
/*      */     } 
/*      */     
/*  774 */     if (friendData.addFriendLvToday > favorNumDailyMax) {
/*  775 */       friendData.friendLv -= friendData.addFriendLvToday - favorNumDailyMax;
/*      */       
/*  777 */       friendData.addFriendLvToday = favorNumDailyMax;
/*      */     } 
/*  779 */     this.po.friends.put(friendId, friendData);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int friendConcernTimesToday() {
/*  785 */     int concernTimes = 0;
/*      */     
/*  787 */     Date currDate = new Date();
/*  788 */     for (Map.Entry<String, FriendData> node : (Iterable<Map.Entry<String, FriendData>>)this.po.friends.entrySet()) {
/*  789 */       String id = node.getKey();
/*  790 */       if (!this.po.recordInfos.containsKey(id)) {
/*      */         continue;
/*      */       }
/*  793 */       RecordInfo recordInfo = (RecordInfo)this.po.recordInfos.get(id);
/*  794 */       if (DateUtil.isSameDay(recordInfo.concernTime, currDate)) {
/*  795 */         concernTimes++;
/*      */       }
/*      */     } 
/*  798 */     return concernTimes;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Map<String, Integer> calAllInfluence() {
/*  803 */     Map<String, Integer> influs = new HashMap<>();
/*      */     
/*  805 */     if (friendConcernTimesToday() >= GlobalConfig.Social_FocusNum) {
/*      */       
/*  807 */       String values = GlobalConfig.Social_FocusBuff;
/*  808 */       String[] nodeValues = values.split(";");
/*  809 */       for (int i = 0; i < nodeValues.length; i++) {
/*  810 */         String[] buffValue = nodeValues[i].split(",");
/*  811 */         int value = 0;
/*  812 */         if (influs.containsKey(buffValue[0])) {
/*  813 */           value = ((Integer)influs.get(buffValue[0])).intValue();
/*      */         }
/*  815 */         value += Integer.parseInt(buffValue[1]);
/*  816 */         influs.put(buffValue[0], Integer.valueOf(value));
/*      */       } 
/*      */     } 
/*  819 */     return influs;
/*      */   }
/*      */   
/*      */   public final void addFriendShipPoint() {
/*  823 */     Date currDate = new Date();
/*  824 */     if (!DateUtil.isSameDay(this.po.addPointTime, currDate)) {
/*  825 */       this.po.addPointToday = 0;
/*  826 */       this.po.addPointTime = currDate;
/*      */     } 
/*      */     
/*  829 */     int friendshipNum = (SocialFriendProps.findByMSocialAction(2)).friendshipNum;
/*  830 */     int friendshipNumDailyMax = GlobalConfig.Social_FriendshipNumDailyMax;
/*  831 */     WNPlayer selfPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
/*  832 */     if (this.po.addPointToday < friendshipNumDailyMax - friendshipNum) {
/*  833 */       this.po.addPointToday += friendshipNum;
/*  834 */       selfPlayer.baseDataManager.addFriendly(friendshipNum);
/*  835 */       selfPlayer.pushDynamicData("friendly", Integer.valueOf(selfPlayer.player.friendly));
/*      */     }
/*  837 */     else if (this.po.addPointToday < friendshipNumDailyMax) {
/*  838 */       selfPlayer.baseDataManager.addFriendly(friendshipNumDailyMax - this.po.addPointToday);
/*  839 */       selfPlayer.pushDynamicData("friendly", Integer.valueOf(selfPlayer.player.friendly));
/*      */       
/*  841 */       this.po.addPointToday = friendshipNumDailyMax;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final int applyFriendLength() {
/*  847 */     int number = 0;
/*  848 */     Date now = new Date();
/*  849 */     for (Map.Entry<String, ApplyFriendData> node : (Iterable<Map.Entry<String, ApplyFriendData>>)this.po.applyFriendIds.entrySet()) {
/*  850 */       ApplyFriendData data = node.getValue();
/*  851 */       if (now.getTime() - data.time < 86400000L)
/*      */       {
/*  853 */         number++;
/*      */       }
/*      */     } 
/*  856 */     return number;
/*      */   }
/*      */   
/*      */   public final boolean hasApplyFriend(String friendId) {
/*  860 */     ApplyFriendData data = (ApplyFriendData)this.po.applyFriendIds.get(friendId);
/*  861 */     if (data == null) {
/*  862 */       return false;
/*      */     }
/*  864 */     Date now = new Date();
/*  865 */     if (now.getTime() - data.time < 86400000L) {
/*  866 */       return true;
/*      */     }
/*  868 */     return false;
/*      */   }
/*      */   
/*      */   public final void addApplyFriend(String friendId) {
/*  872 */     Date now = new Date();
/*  873 */     ApplyFriendData data = (ApplyFriendData)this.po.applyFriendIds.get(friendId);
/*  874 */     if (data != null) {
/*  875 */       if (now.getTime() - data.time < 86400000L) {
/*      */         return;
/*      */       }
/*  878 */       data.time = now.getTime();
/*      */     } else {
/*      */       
/*  881 */       data = new ApplyFriendData(friendId, now.getTime());
/*  882 */       this.po.applyFriendIds.put(friendId, data);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void removeApplyFriend(String friendId) {
/*  888 */     ApplyFriendData data = (ApplyFriendData)this.po.applyFriendIds.get(friendId);
/*  889 */     if (data != null) {
/*  890 */       this.po.applyFriendIds.remove(friendId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final FriendHandler.FriendMessageListResponse.Builder friendMessageList() {
/*  897 */     FriendHandler.FriendMessageListResponse.Builder data = FriendHandler.FriendMessageListResponse.newBuilder();
/*      */     
/*  899 */     ArrayList<FriendHandler.PlayerInfo> friendMessageInfos = new ArrayList<>();
/*      */     
/*  901 */     Out.debug(new Object[] { "friendMessageList :", this.po.friendMessage });
/*      */     
/*  903 */     for (MessageDate message : this.po.friendMessage) {
/*  904 */       FriendHandler.PlayerInfo.Builder info = getPlayerBaseData(message.playerId);
/*  905 */       info.setType(message.type);
/*  906 */       info.setId(message.playerId);
/*  907 */       info.setTime(JSON.toJSONString(message.time));
/*  908 */       info.setAddFriendShipPoint((SocialFriendProps.findByMSocialAction(2)).friendshipNum);
/*      */       
/*  910 */       friendMessageInfos.add(info.build());
/*      */     } 
/*  912 */     friendMessageInfos.sort(friendMessageComparator);
/*  913 */     data.addAllFriendMessageInfos(friendMessageInfos);
/*  914 */     data.setMessageNumMax(GlobalConfig.Social_MaxFriendMessageNum);
/*  915 */     data.setFriendlyCode("friendly");
/*  916 */     return data;
/*      */   }
/*      */   
/*      */   public final void deleteFriendMessage() {
/*  920 */     this.po.friendMessage.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<FriendHandler.PlayerInfo> getAllBlackList() {
/*  925 */     List<FriendHandler.PlayerInfo> blackList = new ArrayList<>();
/*  926 */     for (Map.Entry<String, BlackActor> node : (Iterable<Map.Entry<String, BlackActor>>)this.po.blackList.entrySet()) {
/*  927 */       String id = node.getKey();
/*  928 */       FriendHandler.PlayerInfo.Builder info = getPlayerBaseData(id);
/*  929 */       info.setId(id);
/*  930 */       info.setCreateTime(JSON.toJSONString(((BlackActor)node.getValue()).createTime));
/*  931 */       blackList.add(info.build());
/*      */     } 
/*  933 */     blackList.sort(blackListComparator);
/*  934 */     return blackList;
/*      */   }
/*      */   
/*      */   public final boolean deleteBlackListById(String blackListId) {
/*  938 */     if (!this.po.blackList.containsKey(blackListId)) {
/*  939 */       return false;
/*      */     }
/*  941 */     this.po.blackList.remove(blackListId);
/*      */ 
/*      */     
/*  944 */     return true;
/*      */   }
/*      */   
/*      */   public final void deleteBlackList() {
/*  948 */     this.po.blackList.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String addBlackList(String blackListId) {
/*  955 */     boolean bOpen = PlayerUtil.isPlayerOpenedFunction(this.playerId, Const.FunctionType.FRIEND.getValue());
/*      */     
/*  957 */     if (!bOpen) {
/*  958 */       return FunctionOpenUtil.getTipsByName(Const.FunctionType.FRIEND.getValue());
/*      */     }
/*      */     
/*  961 */     bOpen = PlayerUtil.isPlayerOpenedFunction(blackListId, Const.FunctionType.FRIEND.getValue());
/*      */     
/*  963 */     if (!bOpen) {
/*  964 */       return LangService.getValue("FUNC_SET_TARGET_NOT_OPEN");
/*      */     }
/*      */     
/*  967 */     if (this.po.blackList.size() >= GlobalConfig.Social_MaxBlacklistNum) {
/*  968 */       return LangService.getValue("FRIEND_BLACK_LIST_FULL");
/*      */     }
/*      */     
/*  971 */     if (this.po.blackList.containsKey(blackListId)) {
/*  972 */       return LangService.getValue("FRIEND_HAVE_IN_BLACK_LIST");
/*      */     }
/*      */     
/*  975 */     BlackActor blackList = new BlackActor();
/*  976 */     blackList.id = blackListId;
/*  977 */     blackList.createTime = new Date();
/*  978 */     this.po.blackList.put(blackListId, blackList);
/*      */ 
/*      */     
/*  981 */     deleteFriend(blackListId);
/*  982 */     return null;
/*      */   }
/*      */   
/*      */   public final boolean isInBlackList(String playerId) {
/*  986 */     return this.po.blackList.containsKey(playerId);
/*      */   }
/*      */   
/*      */   public final void killOtherOnce(String playerId) {
/*  990 */     int FavorNum = (SocialFriendProps.findByMSocialAction(3)).favorNum;
/*  991 */     addFriendLv(playerId, FavorNum);
/*      */   }
/*      */   
/*      */   public final void beKilledOnce(String playerId) {
/*  995 */     int FavorNum = (SocialFriendProps.findByMSocialAction(4)).favorNum;
/*  996 */     addFriendLv(playerId, FavorNum);
/*      */   }
/*      */   
/*      */   public final FriendHandler.GetSocialInfoResponse.Builder getSocialInfo(String playerId) {
/* 1000 */     FriendHandler.GetSocialInfoResponse.Builder data = FriendHandler.GetSocialInfoResponse.newBuilder();
/* 1001 */     Date currDate = new Date();
/* 1002 */     if (!DateUtil.isSameDay(this.po.addPointTime, currDate)) {
/* 1003 */       data.setAddPointToday(0);
/*      */     } else {
/* 1005 */       data.setAddPointToday(this.po.addPointToday);
/*      */     } 
/* 1007 */     data.setFriendShipPoint(this.player.friendly);
/* 1008 */     data.setAddPointTodayMax(GlobalConfig.Social_FriendshipNumDailyMax);
/* 1009 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final TreeMap<String, Object> friendRefuseApply(String requestId, WNPlayer player) {
/* 1015 */     TreeMap<String, Object> rtData = new TreeMap<>();
/* 1016 */     rtData.put("result", Boolean.valueOf(true));
/*      */     
/* 1018 */     removeFriendMessage(requestId, Const.FriendMessageType.TYPE_INVITE.getValue());
/* 1019 */     removeApplyFriend(requestId);
/*      */     
/* 1021 */     FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(requestId);
/* 1022 */     friendMgr.removeFriendMessage(this.playerId, Const.FriendMessageType.TYPE_INVITE.getValue());
/* 1023 */     friendMgr.removeApplyFriend(this.playerId);
/*      */     
/* 1025 */     String msg = LangService.getValue("FRIEND_INVITATION_REDUSE");
/* 1026 */     msg = msg.replace("{inviterName}", player.getName());
/* 1027 */     PlayerUtil.sendSysMessageToPlayer(msg, requestId, null);
/* 1028 */     return rtData;
/*      */   }
/*      */   
/*      */   public final ArrayList<FriendHandler.FriendShopCondition> getConditions(SShopCO prop) {
/* 1032 */     ArrayList<FriendHandler.FriendShopCondition> data = new ArrayList<>();
/* 1033 */     FriendHandler.FriendShopCondition.Builder level = FriendHandler.FriendShopCondition.newBuilder();
/* 1034 */     level.setType(1);
/* 1035 */     level.setNumber(prop.levelReq);
/* 1036 */     data.add(level.build());
/* 1037 */     FriendHandler.FriendShopCondition.Builder up = FriendHandler.FriendShopCondition.newBuilder();
/* 1038 */     up.setType(2);
/* 1039 */     up.setNumber(prop.upReq);
/* 1040 */     data.add(up.build());
/* 1041 */     FriendHandler.FriendShopCondition.Builder vip = FriendHandler.FriendShopCondition.newBuilder();
/* 1042 */     vip.setType(3);
/* 1043 */     vip.setNumber(prop.vipReq);
/* 1044 */     data.add(vip.build());
/* 1045 */     FriendHandler.FriendShopCondition.Builder race = FriendHandler.FriendShopCondition.newBuilder();
/* 1046 */     race.setType(4);
/* 1047 */     race.setNumber(prop.raceReq);
/* 1048 */     data.add(race.build());
/* 1049 */     FriendHandler.FriendShopCondition.Builder raceClass = FriendHandler.FriendShopCondition.newBuilder();
/* 1050 */     raceClass.setType(5);
/* 1051 */     raceClass.setNumber(prop.raceClass);
/* 1052 */     data.add(raceClass.build());
/* 1053 */     return data;
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
/*      */   public final String getConditionStatus(SShopCO prop) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: aload_1
/*      */     //   2: invokevirtual getConditions : (Lcom/wanniu/game/data/SShopCO;)Ljava/util/ArrayList;
/*      */     //   5: astore_2
/*      */     //   6: iconst_0
/*      */     //   7: istore_3
/*      */     //   8: iload_3
/*      */     //   9: aload_2
/*      */     //   10: invokevirtual size : ()I
/*      */     //   13: if_icmpge -> 122
/*      */     //   16: aload_2
/*      */     //   17: iload_3
/*      */     //   18: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   21: checkcast pomelo/area/FriendHandler$FriendShopCondition
/*      */     //   24: astore #4
/*      */     //   26: aload #4
/*      */     //   28: invokevirtual getType : ()I
/*      */     //   31: istore #5
/*      */     //   33: aload #4
/*      */     //   35: invokevirtual getNumber : ()I
/*      */     //   38: istore #6
/*      */     //   40: iload #5
/*      */     //   42: iconst_1
/*      */     //   43: if_icmpne -> 65
/*      */     //   46: aload_0
/*      */     //   47: getfield player : Lcom/wanniu/game/poes/PlayerPO;
/*      */     //   50: getfield level : I
/*      */     //   53: iload #6
/*      */     //   55: if_icmpge -> 65
/*      */     //   58: ldc_w 'EXCHANGE_LEVEL_NOT_REACH'
/*      */     //   61: invokestatic getValue : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   64: areturn
/*      */     //   65: iload #5
/*      */     //   67: iconst_2
/*      */     //   68: if_icmpne -> 90
/*      */     //   71: aload_0
/*      */     //   72: getfield player : Lcom/wanniu/game/poes/PlayerPO;
/*      */     //   75: getfield upLevel : I
/*      */     //   78: iload #6
/*      */     //   80: if_icmpge -> 90
/*      */     //   83: ldc_w 'EXCHANGE_STAGE_NOT_REACH'
/*      */     //   86: invokestatic getValue : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   89: areturn
/*      */     //   90: iload #5
/*      */     //   92: iconst_4
/*      */     //   93: if_icmpne -> 96
/*      */     //   96: iload #5
/*      */     //   98: iconst_5
/*      */     //   99: if_icmpne -> 102
/*      */     //   102: iload #5
/*      */     //   104: bipush #6
/*      */     //   106: if_icmpne -> 109
/*      */     //   109: iload #5
/*      */     //   111: bipush #7
/*      */     //   113: if_icmpne -> 116
/*      */     //   116: iinc #3, 1
/*      */     //   119: goto -> 8
/*      */     //   122: aconst_null
/*      */     //   123: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1057	-> 0
/*      */     //   #1058	-> 6
/*      */     //   #1059	-> 16
/*      */     //   #1060	-> 26
/*      */     //   #1061	-> 33
/*      */     //   #1062	-> 40
/*      */     //   #1063	-> 58
/*      */     //   #1065	-> 65
/*      */     //   #1066	-> 83
/*      */     //   #1071	-> 90
/*      */     //   #1072	-> 96
/*      */     //   #1073	-> 102
/*      */     //   #1074	-> 109
/*      */     //   #1058	-> 116
/*      */     //   #1076	-> 122
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   26	90	4	condition	Lpomelo/area/FriendHandler$FriendShopCondition;
/*      */     //   33	83	5	type	I
/*      */     //   40	76	6	number	I
/*      */     //   8	114	3	i	I
/*      */     //   0	124	0	this	Lcom/wanniu/game/friend/FriendManager;
/*      */     //   0	124	1	prop	Lcom/wanniu/game/data/SShopCO;
/*      */     //   6	118	2	conditions	Ljava/util/ArrayList;
/*      */     // Local variable type table:
/*      */     //   start	length	slot	name	signature
/*      */     //   6	118	2	conditions	Ljava/util/ArrayList<Lpomelo/area/FriendHandler$FriendShopCondition;>;
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
/*      */   public void removeFriendMessage(String playerId, int type) {
/* 1080 */     for (MessageDate messageData : this.po.friendMessage) {
/* 1081 */       if (messageData.type == type && messageData.playerId.equals(playerId)) {
/* 1082 */         this.po.friendMessage.remove(messageData);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addFriendMessage(String playerId, int type) {
/* 1091 */     if (this.po.friendMessage.size() >= GlobalConfig.Social_MaxFriendMessageNum) {
/* 1092 */       this.po.friendMessage.remove(this.po.friendMessage.size() - 1);
/*      */     }
/*      */     
/* 1095 */     MessageDate messageData = new MessageDate();
/* 1096 */     messageData.type = type;
/* 1097 */     messageData.playerId = playerId;
/* 1098 */     messageData.time = new Date();
/* 1099 */     this.po.friendMessage.add(messageData);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInFriendMessage(String playerId) {
/* 1105 */     boolean isIn = false;
/* 1106 */     for (int i = 0; i < this.po.friendMessage.size(); i++) {
/* 1107 */       MessageDate elem = this.po.friendMessage.get(i);
/* 1108 */       if (elem.playerId.equals(playerId)) {
/* 1109 */         isIn = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1113 */     return isIn;
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeFriend(String id) {
/* 1118 */     if (this.po.friends.containsKey(id)) {
/* 1119 */       this.po.friends.remove(id);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public JSONObject deleteFriend(String friendId) {
/* 1125 */     JSONObject ret = new JSONObject();
/*      */     
/* 1127 */     if (!this.po.friends.containsKey(friendId)) {
/* 1128 */       ret.put("code", Integer.valueOf(500));
/* 1129 */       ret.put("des", LangService.getValue("FRIEND_NOT_EXIST"));
/* 1130 */       return ret;
/*      */     } 
/*      */     
/* 1133 */     removeFriend(friendId);
/*      */     
/* 1135 */     FriendManager friendMgr = FriendsCenter.getInstance().getFriendsMgr(friendId);
/* 1136 */     friendMgr.removeFriend(this.playerId);
/* 1137 */     ret.put("code", Integer.valueOf(200));
/* 1138 */     ret.put("des", LangService.getValue("FRIEND_DEL_SUCESS"));
/* 1139 */     return ret;
/*      */   }
/*      */   
/*      */   public String getPlayerId() {
/* 1143 */     return this.playerId;
/*      */   }
/*      */   
/*      */   public void setPlayerId(String playerId) {
/* 1147 */     this.playerId = playerId;
/*      */   }
/*      */   
/*      */   private static class BlackListComparator
/*      */     implements Comparator<FriendHandler.PlayerInfo> {
/*      */     public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
/* 1153 */       return data1.getCreateTime().compareTo(data2.getCreateTime());
/*      */     }
/*      */     private BlackListComparator() {} }
/*      */   
/*      */   private static class FriendMessageComparator implements Comparator<FriendHandler.PlayerInfo> { private FriendMessageComparator() {}
/*      */     
/*      */     public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
/* 1160 */       return data1.getTime().compareTo(data2.getTime());
/*      */     } }
/*      */ 
/*      */   
/*      */   private static class FriendInfoComparator implements Comparator<FriendHandler.PlayerInfo> { private FriendInfoComparator() {}
/*      */     
/*      */     public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
/* 1167 */       return (data1.getLevel() < data2.getLevel()) ? 1 : -1;
/*      */     } }
/*      */   
/*      */   private static class FriendComparator implements Comparator<FriendHandler.PlayerInfo> {
/*      */     private FriendComparator() {}
/*      */     
/*      */     public int compare(FriendHandler.PlayerInfo data1, FriendHandler.PlayerInfo data2) {
/* 1174 */       if (data1.getIsOnline() != data2.getIsOnline()) {
/* 1175 */         return (data1.getIsOnline() < data2.getIsOnline()) ? 1 : -1;
/*      */       }
/* 1177 */       if (data1.getFriendLv() != data2.getFriendLv()) {
/* 1178 */         return (data1.getFriendLv() < data2.getFriendLv()) ? 1 : -1;
/*      */       }
/* 1180 */       if (data1.getVip() != data2.getVip()) {
/* 1181 */         return (data1.getVip() < data2.getVip()) ? 1 : -1;
/*      */       }
/*      */       
/* 1184 */       if (data1.getStageLevel() != data2.getStageLevel()) {
/* 1185 */         return (data1.getStageLevel() < data2.getStageLevel()) ? 1 : -1;
/*      */       }
/*      */       
/* 1188 */       if (data1.getLevel() == data2.getLevel()) {
/* 1189 */         return 0;
/*      */       }
/*      */       
/* 1192 */       return (data1.getLevel() <= data2.getLevel()) ? 1 : -1;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\FriendManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */