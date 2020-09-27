/*      */ package com.wanniu.game.player;
/*      */ 
/*      */ import com.alibaba.fastjson.JSON;
/*      */ import com.alibaba.fastjson.JSONArray;
/*      */ import com.alibaba.fastjson.JSONObject;
/*      */ import com.wanniu.core.GGame;
/*      */ import com.wanniu.core.XLang;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.game.entity.GPlayer;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.login.AuthServer;
/*      */ import com.wanniu.core.tcp.protocol.Packet;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.core.util.StringUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.area.AreaUtil;
/*      */ import com.wanniu.game.attendance.PlayerAttendance;
/*      */ import com.wanniu.game.bag.BagPO;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.data.BranchLineCO;
/*      */ import com.wanniu.game.data.CharacterCO;
/*      */ import com.wanniu.game.data.CharacterLevelCO;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.MainLineCO;
/*      */ import com.wanniu.game.data.PrefixCO;
/*      */ import com.wanniu.game.data.SuffixCO;
/*      */ import com.wanniu.game.data.base.DItemEquipBase;
/*      */ import com.wanniu.game.data.base.TaskBase;
/*      */ import com.wanniu.game.data.ext.CharacterExt;
/*      */ import com.wanniu.game.data.ext.EquipSockExt;
/*      */ import com.wanniu.game.data.ext.OlGiftExt;
/*      */ import com.wanniu.game.data.ext.TransportExt;
/*      */ import com.wanniu.game.data.ext.UpLevelExpExt;
/*      */ import com.wanniu.game.equip.EquipUtil;
/*      */ import com.wanniu.game.equip.NormalEquip;
/*      */ import com.wanniu.game.fashion.FashionUtil;
/*      */ import com.wanniu.game.five2Five.Five2FiveService;
/*      */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*      */ import com.wanniu.game.guild.GuildService;
/*      */ import com.wanniu.game.guild.GuildServiceCenter;
/*      */ import com.wanniu.game.item.ItemConfig;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.po.MedalPO;
/*      */ import com.wanniu.game.mount.MountCenter;
/*      */ import com.wanniu.game.mount.MountUtil;
/*      */ import com.wanniu.game.onlineGift.OlGiftConfig;
/*      */ import com.wanniu.game.player.po.AllBlobPO;
/*      */ import com.wanniu.game.player.po.AvatarObj;
/*      */ import com.wanniu.game.playerSkill.SkillManager;
/*      */ import com.wanniu.game.poes.AchievementDataPO;
/*      */ import com.wanniu.game.poes.ActivityDataPO;
/*      */ import com.wanniu.game.poes.ArenaDataPO;
/*      */ import com.wanniu.game.poes.AttendancePO;
/*      */ import com.wanniu.game.poes.BagsPO;
/*      */ import com.wanniu.game.poes.DailyActivityPO;
/*      */ import com.wanniu.game.poes.FightLevelsPO;
/*      */ import com.wanniu.game.poes.FunctionOpenPO;
/*      */ import com.wanniu.game.poes.GuildPO;
/*      */ import com.wanniu.game.poes.HookSetPO;
/*      */ import com.wanniu.game.poes.LeaderBoardPlayerPO;
/*      */ import com.wanniu.game.poes.MountPO;
/*      */ import com.wanniu.game.poes.OnlineDataPO;
/*      */ import com.wanniu.game.poes.PlayerAttachPO;
/*      */ import com.wanniu.game.poes.PlayerBasePO;
/*      */ import com.wanniu.game.poes.PlayerChouRenPO;
/*      */ import com.wanniu.game.poes.PlayerConsignmentItemsPO;
/*      */ import com.wanniu.game.poes.PlayerFriendsPO;
/*      */ import com.wanniu.game.poes.PlayerMailDataPO;
/*      */ import com.wanniu.game.poes.PlayerPKDataPO;
/*      */ import com.wanniu.game.poes.PlayerPO;
/*      */ import com.wanniu.game.poes.PlayerPetsNewPO;
/*      */ import com.wanniu.game.poes.PlayerTempPO;
/*      */ import com.wanniu.game.poes.ShopMallPO;
/*      */ import com.wanniu.game.poes.SkillsPO;
/*      */ import com.wanniu.game.poes.SoloDataPO;
/*      */ import com.wanniu.game.poes.TaskListPO;
/*      */ import com.wanniu.game.poes.TitlePO;
/*      */ import com.wanniu.game.poes.VipPO;
/*      */ import com.wanniu.game.sysSet.SysSetFlag;
/*      */ import com.wanniu.game.task.LoopResult;
/*      */ import com.wanniu.game.task.TaskData;
/*      */ import com.wanniu.game.task.TaskUtils;
/*      */ import com.wanniu.game.xianyuan.XianYuanService;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import io.netty.channel.Channel;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.TeamHandler;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ import pomelo.player.PlayerOuterClass;
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
/*      */ public class PlayerUtil
/*      */ {
/*  116 */   public static int maxClassID = 0;
/*  117 */   public static int maxUpOrder = 0;
/*      */   
/*      */   static {
/*  120 */     Map<Integer, UpLevelExpExt> map = GameData.UpLevelExps;
/*  121 */     for (UpLevelExpExt prop : map.values()) {
/*  122 */       if (prop.classID > maxClassID && prop.isValid == 1)
/*  123 */         maxClassID = prop.classID; 
/*  124 */       if (prop.upOrder > maxUpOrder && prop.isValid == 1) {
/*  125 */         maxUpOrder = prop.upOrder;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JSONObject getPlayerPosition(WNPlayer player) {
/*  134 */     String res = player.getXmdsManager().getPlayerData(player.getId(), false);
/*  135 */     return StringUtil.isEmpty(res) ? Utils.toJSON(new Object[] { "x", Integer.valueOf(0), "y", Integer.valueOf(0) }) : JSON.parseObject(res);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final boolean isOnline(String playerId) {
/*  142 */     return GWorld.getInstance().isOnline(playerId);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isLocal(String rid) {
/*  149 */     return GWorld.getInstance().isLocal(rid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String sendSysMessageToPlayer(String message, String playerId) {
/*  156 */     return sendSysMessageToPlayer(message, playerId, Const.TipsType.NORMAL);
/*      */   }
/*      */   
/*      */   public static String sendSysMessageToPlayer(String message, String playerId, Const.TipsType type) {
/*  160 */     WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/*  161 */     if (player != null) {
/*  162 */       player.sendSysTip(message, type);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  171 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String handleGMChat(WNPlayer player, Map<String, Object> _data) {
/*  178 */     String operate = (String)_data.get("operate");
/*  179 */     if (operate.equals("add")) {
/*  180 */       String itemCode = (String)_data.get("itemCode");
/*  181 */       if (ItemConfig.getInstance().getItemPropByName(itemCode) != null) {
/*  182 */         itemCode = (ItemConfig.getInstance().getItemPropByName(itemCode)).code;
/*      */       }
/*  184 */       int num = ((Integer)_data.get("num")).intValue();
/*  185 */       if (player.bag.testAddCodeItem(itemCode, num)) {
/*  186 */         player.bag.addCodeItem(itemCode, num, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.gm, null);
/*      */       }
/*  188 */     } else if (operate.equals("addRank")) {
/*  189 */       int id = ((Integer)_data.get("id")).intValue();
/*  190 */       player.titleManager.onAwardRank(id);
/*  191 */     } else if (operate.equals("addPetExp")) {
/*  192 */       player.petNewManager.addExp(Integer.parseInt((String)_data.get("petId")), Integer.parseInt((String)_data.get("num")));
/*  193 */     } else if (operate.equalsIgnoreCase("finishTask")) {
/*  194 */       player.taskManager.gmFinishTask(((Integer)_data.get("id")).intValue());
/*  195 */     } else if (operate.equalsIgnoreCase("acceptTask")) {
/*  196 */       player.taskManager.gmAcceptTask(((Integer)_data.get("id")).intValue());
/*  197 */     } else if (operate.equals("finishTaskTarget")) {
/*  198 */       player.taskManager.gmfinishTaskTarget(((Integer)_data.get("id")).intValue());
/*  199 */     } else if (operate.equalsIgnoreCase("newTask")) {
/*  200 */       player.taskManager.gmNewTask(((Integer)_data.get("id")).intValue());
/*  201 */     } else if (operate.equalsIgnoreCase("discardTask")) {
/*  202 */       player.taskManager.gmDiscardTaskByID(((Integer)_data.get("id")).intValue());
/*  203 */     } else if (operate.equals("prepaid")) {
/*  204 */       player.prepaidManager.onPrepaidChargeByMoney(((Integer)_data.get("money")).intValue());
/*  205 */     } else if (operate.equals("openFunc")) {
/*  206 */       player.functionOpenManager.gmOpenFunction(((Integer)_data.get("functionID")).intValue());
/*  207 */     } else if (operate.equals("guildAdd")) {
/*  208 */       if (_data.get("moneyName").equals("contribution")) {
/*  209 */         player.guildManager.addContribution(((Integer)_data.get("num")).intValue(), Const.GOODS_CHANGE_TYPE.gm);
/*      */       } else {
/*  211 */         GuildService.gmAddGuildMoney(player.getId(), (String)_data.get("moneyName"), ((Integer)_data.get("num")).intValue());
/*      */       } 
/*  213 */     } else if (operate.equals("tp")) {
/*  214 */       AreaUtil.dispatchByAreaId(player, ((Integer)_data.get("mapID")).intValue(), null);
/*  215 */     } else if (operate.equals("guildFundAdd")) {
/*  216 */       GuildPO guildPo = player.guildManager.guild;
/*  217 */       if (null != guildPo) {
/*  218 */         int _num = ((Integer)_data.get("num")).intValue();
/*  219 */         guildPo.fund += _num;
/*  220 */         guildPo.sumFund += _num;
/*  221 */         GuildServiceCenter.getInstance().refreshGuildTopInfo(guildPo.id);
/*  222 */         GuildServiceCenter.getInstance().saveGuild(guildPo);
/*      */       } 
/*  224 */     } else if (operate.equals("guildExpAdd")) {
/*  225 */       GuildPO guildPo = player.guildManager.guild;
/*  226 */       if (null != guildPo) {
/*  227 */         guildPo.exp += ((Integer)_data.get("num")).intValue();
/*  228 */         GuildServiceCenter.getInstance().saveGuild(guildPo);
/*      */       } 
/*      */     } 
/*  231 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WNPlayer findPlayer(String playerId) {
/*  238 */     if (StringUtil.isEmpty(playerId)) {
/*  239 */       Out.error(new Object[] { "playerId is nil" });
/*  240 */       (new Exception()).printStackTrace();
/*  241 */       return null;
/*      */     } 
/*  243 */     WNPlayer player = getOnlinePlayer(playerId);
/*  244 */     if (player != null) {
/*  245 */       return player;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  251 */     return player;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WNPlayer getOnlinePlayer(String playerId) {
/*  258 */     if (StringUtil.isEmpty(playerId)) {
/*  259 */       Out.error(new Object[] { "playerId is null" });
/*  260 */       (new Exception()).printStackTrace();
/*  261 */       return null;
/*      */     } 
/*  263 */     return GWorld.getInstance().getPlayer(playerId);
/*      */   }
/*      */   
/*      */   public static WNPlayer getOnlinePlayerByUid(String uid) {
/*  267 */     return (WNPlayer)GGame.getInstance().getPlayerByUid(uid);
/*      */   }
/*      */   
/*      */   public static PlayerPO getPlayerBaseData(String playerId) {
/*  271 */     WNPlayer player = findPlayer(playerId);
/*      */     
/*  273 */     if (null != player) {
/*  274 */       return player.getPlayer();
/*      */     }
/*      */     
/*      */     try {
/*  278 */       return PlayerDao.getPlayerDataById(playerId);
/*  279 */     } catch (Exception e) {
/*  280 */       Out.error(new Object[] { e });
/*  281 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPlayerOpenedFunction(String playerId, String funcName) {
/*  291 */     int defState = FunctionOpenUtil.getDefaultOpenState(funcName);
/*  292 */     if (defState == -1) {
/*  293 */       return false;
/*      */     }
/*  295 */     if (defState == 1) {
/*  296 */       return true;
/*      */     }
/*  298 */     FunctionOpenPO db = (FunctionOpenPO)PlayerPOManager.findPO(ConstsTR.player_func_openTR, playerId, FunctionOpenPO.class);
/*  299 */     if (db == null) {
/*  300 */       return false;
/*      */     }
/*  302 */     if (db.openMap == null || !db.openMap.containsKey(funcName)) {
/*  303 */       return false;
/*      */     }
/*      */     
/*  306 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public static TeamHandler.Player.Builder transToJson4TeamMemberSimple(WNPlayer player) {
/*  311 */     PlayerPO playerData = player.getPlayer();
/*  312 */     TeamHandler.Player.Builder data = TeamHandler.Player.newBuilder();
/*  313 */     data.setId(playerData.id);
/*  314 */     data.setName(playerData.name);
/*  315 */     data.setPro(playerData.pro);
/*  316 */     data.setLevel(playerData.level);
/*  317 */     data.setUpLevel(playerData.upLevel);
/*  318 */     String guildName = player.guildManager.getGuildName();
/*  319 */     data.setGuildName(StringUtil.isEmpty(guildName) ? LangService.getValue("TEAM_NO_GUILD") : guildName);
/*  320 */     return data;
/*      */   }
/*      */ 
/*      */   
/*      */   public static PlayerOuterClass.PlayerBasic transToJson4BasicByBlob(AllBlobPO playerData) {
/*  325 */     PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
/*  326 */     data.setId(playerData.player.id);
/*  327 */     data.setName(playerData.player.name);
/*  328 */     data.setLevel(playerData.player.level);
/*  329 */     data.setPro(playerData.player.pro);
/*  330 */     data.setUpLevel(playerData.player.upLevel);
/*      */     
/*  332 */     if (playerData.playerBase.equipGrids == null) {
/*  333 */       playerData.playerBase.equipGrids = new HashMap<>();
/*      */     }
/*      */     
/*  336 */     data.addAllAvatars(getBattlerServerAvatar4Login(playerData.player.pro, playerData.playerBase));
/*  337 */     return data.build();
/*      */   }
/*      */   
/*      */   public static PlayerOuterClass.PlayerBasic transToJson4Basic(WNPlayer playerData) {
/*  341 */     PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
/*  342 */     data.setId(playerData.player.id);
/*  343 */     data.setName(playerData.player.name);
/*  344 */     data.setLevel(playerData.player.level);
/*  345 */     data.setPro(playerData.player.pro);
/*  346 */     data.setUpLevel(playerData.player.upLevel);
/*      */     
/*  348 */     if (playerData.playerBasePO.equipGrids == null) {
/*  349 */       playerData.playerBasePO.equipGrids = new HashMap<>();
/*      */     }
/*      */     
/*  352 */     data.addAllAvatars(getBattlerServerAvatar4Login(playerData.player.pro, playerData.playerBasePO));
/*  353 */     return data.build();
/*      */   }
/*      */   
/*      */   public static PlayerOuterClass.PlayerBasic playerBasicData(PlayerPO playerData) {
/*  357 */     Out.debug(new Object[] { PlayerUtil.class, "playerBasicData:::", playerData.id });
/*  358 */     PlayerOuterClass.PlayerBasic.Builder data = PlayerOuterClass.PlayerBasic.newBuilder();
/*  359 */     data.setId(playerData.id);
/*  360 */     data.setName(playerData.name);
/*  361 */     data.setLevel(playerData.level);
/*  362 */     data.setPro(playerData.pro);
/*  363 */     data.setUpLevel(playerData.upLevel);
/*  364 */     return data.build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Common.Avatar> getBattleServerAvatar(int pro) {
/*  371 */     CharacterCO basicProp = (CharacterCO)GameData.Characters.get(Integer.valueOf(pro));
/*  372 */     List<Common.Avatar> avatars = new ArrayList<>();
/*  373 */     Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
/*  374 */     avatar.setEffectType(0);
/*  375 */     avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);
/*  376 */     avatar.setFileName(basicProp.model);
/*  377 */     avatars.add(avatar.build());
/*  378 */     return avatars;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Common.Avatar> getBattlerServerAvatar(String playerId) {
/*  385 */     List<Common.Avatar> avatars = new ArrayList<>();
/*  386 */     PlayerPO playerPO = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*  387 */     if (playerPO == null) {
/*  388 */       Out.error(new Object[] { "getBattlerServerAvatarxxxxxxxxxxxxxxx-->>", playerId });
/*  389 */       return avatars;
/*      */     } 
/*  391 */     PlayerBasePO playerBasePO = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, playerId, PlayerBasePO.class);
/*      */ 
/*      */     
/*  394 */     MountPO mountPO = playerPO.openMount ? MountCenter.getInstance().findMount(playerId) : null;
/*      */     
/*  396 */     List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(playerPO.pro, playerBasePO, false);
/*  397 */     avatars.addAll(equipAvatars);
/*  398 */     avatars.addAll(MountUtil.getCurMountAvatarInfo(mountPO));
/*      */     
/*  400 */     List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
/*  401 */     Map<Integer, Common.Avatar> targetMap = new HashMap<>();
/*  402 */     for (Common.Avatar avatar : avatars) {
/*  403 */       targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
/*      */     }
/*  405 */     for (Common.Avatar fashionAvatar : fashionAvatars) {
/*  406 */       int tag = fashionAvatar.getTag();
/*  407 */       if (targetMap.containsKey(Integer.valueOf(tag))) {
/*      */         
/*  409 */         Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
/*  410 */         avatarBuilderNew.setTag(tag);
/*  411 */         avatarBuilderNew.setFileName(fashionAvatar.getFileName());
/*  412 */         avatarBuilderNew.setEffectType(((Common.Avatar)targetMap.get(Integer.valueOf(tag))).getEffectType());
/*  413 */         targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build()); continue;
/*      */       } 
/*  415 */       targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
/*      */     } 
/*      */     
/*  418 */     List<Common.Avatar> targetList = new LinkedList<>();
/*  419 */     for (Common.Avatar avatar : targetMap.values()) {
/*  420 */       targetList.add(avatar);
/*      */     }
/*  422 */     return targetList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Common.Avatar> getBattlerServerAvatar(WNPlayer source, boolean changeModel) {
/*  431 */     List<Common.Avatar> avatars = new ArrayList<>();
/*      */ 
/*      */     
/*  434 */     if (StringUtil.isNotEmpty(source.playerBasePO.model) && changeModel) {
/*  435 */       Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
/*  436 */       avatar.setEffectType(0);
/*  437 */       avatar.setTag(Const.AVATAR_TYPE.AVATAR_BODY.value);
/*  438 */       avatar.setFileName(source.playerBasePO.model);
/*  439 */       avatars.add(avatar.build());
/*  440 */       return avatars;
/*      */     } 
/*      */ 
/*      */     
/*  444 */     List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(source.player.pro, source.playerBasePO, changeModel);
/*  445 */     avatars.addAll(equipAvatars);
/*      */     
/*  447 */     if (!changeModel || StringUtil.isEmpty(source.playerBasePO.model)) {
/*  448 */       avatars.addAll(MountUtil.getCurMountAvatarInfo(source.mountManager.mount));
/*      */     }
/*      */     
/*  451 */     List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(source.playerBasePO);
/*  452 */     Map<Integer, Common.Avatar> targetMap = new HashMap<>();
/*  453 */     for (Common.Avatar avatar : avatars) {
/*  454 */       targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
/*      */     }
/*  456 */     for (Common.Avatar fashionAvatar : fashionAvatars) {
/*  457 */       int tag = fashionAvatar.getTag();
/*  458 */       if (targetMap.containsKey(Integer.valueOf(tag))) {
/*      */         
/*  460 */         Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
/*  461 */         avatarBuilderNew.setTag(tag);
/*  462 */         avatarBuilderNew.setFileName(fashionAvatar.getFileName());
/*  463 */         avatarBuilderNew.setEffectType(((Common.Avatar)targetMap.get(Integer.valueOf(tag))).getEffectType());
/*  464 */         targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build()); continue;
/*      */       } 
/*  466 */       targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
/*      */     } 
/*      */     
/*  469 */     List<Common.Avatar> targetList = new LinkedList<>();
/*  470 */     for (Common.Avatar avatar : targetMap.values()) {
/*  471 */       targetList.add(avatar);
/*      */     }
/*  473 */     return targetList;
/*      */   }
/*      */   
/*      */   public static List<Common.Avatar> getBattlerServerAvatar(PlayerPO player) {
/*  477 */     List<Common.Avatar> avatars = new ArrayList<>();
/*  478 */     PlayerBasePO playerBasePO = (PlayerBasePO)PlayerPOManager.findPO(ConstsTR.playerBaseTR, player.id, PlayerBasePO.class);
/*  479 */     List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(player.pro, playerBasePO, false);
/*  480 */     avatars.addAll(equipAvatars);
/*      */     
/*  482 */     List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
/*  483 */     Map<Integer, Common.Avatar> targetMap = new HashMap<>();
/*  484 */     for (Common.Avatar avatar : avatars) {
/*  485 */       targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
/*      */     }
/*  487 */     for (Common.Avatar fashionAvatar : fashionAvatars) {
/*  488 */       int tag = fashionAvatar.getTag();
/*  489 */       if (targetMap.containsKey(Integer.valueOf(tag))) {
/*      */         
/*  491 */         Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
/*  492 */         avatarBuilderNew.setTag(tag);
/*  493 */         avatarBuilderNew.setFileName(fashionAvatar.getFileName());
/*  494 */         avatarBuilderNew.setEffectType(((Common.Avatar)targetMap.get(Integer.valueOf(tag))).getEffectType());
/*  495 */         targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build()); continue;
/*      */       } 
/*  497 */       targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
/*      */     } 
/*      */     
/*  500 */     List<Common.Avatar> targetList = new LinkedList<>();
/*  501 */     for (Common.Avatar avatar : targetMap.values()) {
/*  502 */       targetList.add(avatar);
/*      */     }
/*  504 */     return targetList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Common.Avatar> getBattlerServerAvatar4Login(int pro, PlayerBasePO playerBasePO) {
/*  511 */     List<Common.Avatar> avatars = new ArrayList<>();
/*      */     
/*  513 */     List<Common.Avatar> equipAvatars = EquipUtil.getAvatarData(pro, playerBasePO, false);
/*  514 */     avatars.addAll(equipAvatars);
/*      */     
/*  516 */     List<Common.Avatar> fashionAvatars = FashionUtil.getAvatarData(playerBasePO);
/*  517 */     Map<Integer, Common.Avatar> targetMap = new HashMap<>();
/*  518 */     for (Common.Avatar avatar : avatars) {
/*  519 */       targetMap.put(Integer.valueOf(avatar.getTag()), avatar);
/*      */     }
/*  521 */     for (Common.Avatar fashionAvatar : fashionAvatars) {
/*  522 */       int tag = fashionAvatar.getTag();
/*  523 */       if (targetMap.containsKey(Integer.valueOf(tag))) {
/*      */         
/*  525 */         Common.Avatar.Builder avatarBuilderNew = Common.Avatar.newBuilder();
/*  526 */         avatarBuilderNew.setTag(tag);
/*  527 */         avatarBuilderNew.setFileName(fashionAvatar.getFileName());
/*  528 */         avatarBuilderNew.setEffectType(((Common.Avatar)targetMap.get(Integer.valueOf(tag))).getEffectType());
/*  529 */         targetMap.put(Integer.valueOf(tag), avatarBuilderNew.build()); continue;
/*      */       } 
/*  531 */       targetMap.put(Integer.valueOf(fashionAvatar.getTag()), fashionAvatar);
/*      */     } 
/*      */     
/*  534 */     List<Common.Avatar> targetList = new LinkedList<>();
/*  535 */     for (Common.Avatar avatar : targetMap.values()) {
/*  536 */       targetList.add(avatar);
/*      */     }
/*  538 */     return targetList;
/*      */   }
/*      */   
/*      */   public static List<AvatarObj> getBattlerServerAvatarObj(WNPlayer source) {
/*  542 */     List<Common.Avatar> list = getBattlerServerAvatar(source, true);
/*  543 */     List<AvatarObj> list_new = new ArrayList<>();
/*  544 */     for (Common.Avatar avatar : list) {
/*  545 */       list_new.add(new AvatarObj(avatar.getTag(), avatar.getFileName(), avatar.getEffectType()));
/*      */     }
/*  547 */     return list_new;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JSONObject getPlayerNowPosition(String playerId) {
/*  554 */     WNPlayer player = getOnlinePlayer(playerId);
/*  555 */     if (player != null) {
/*  556 */       return getPlayerPosition(player);
/*      */     }
/*  558 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long[] getLevelByExp(long exp, int nowLevel, int curMaxLv) {
/*  567 */     int level = nowLevel;
/*  568 */     long curExp = exp;
/*  569 */     for (int i = nowLevel; i < curMaxLv; i++) {
/*  570 */       CharacterLevelCO prop = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(i));
/*  571 */       int needExp = prop.experience;
/*  572 */       if (curExp < needExp) {
/*      */         break;
/*      */       }
/*  575 */       curExp -= needExp;
/*  576 */       level++;
/*  577 */       if (level == GlobalConfig.Role_LevelLimit) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  583 */     return new long[] { curExp, level };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int calExpLv(long exp, int nowLevel) {
/*  594 */     int level = nowLevel;
/*  595 */     long curExp = exp;
/*  596 */     for (int i = nowLevel; i <= GlobalConfig.Role_LevelLimit; i++) {
/*  597 */       CharacterLevelCO prop = (CharacterLevelCO)GameData.CharacterLevels.get(Integer.valueOf(i));
/*  598 */       int needExp = prop.experience;
/*  599 */       if (curExp < needExp) {
/*      */         break;
/*      */       }
/*  602 */       curExp -= needExp;
/*  603 */       level++;
/*      */     } 
/*  605 */     return level;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean transPortById(WNPlayer player, int id) {
/*  613 */     TransportExt transportProp = (TransportExt)GameData.Transports.get(Integer.valueOf(id));
/*  614 */     if (transportProp == null) {
/*  615 */       return false;
/*      */     }
/*  617 */     boolean flag = false;
/*  618 */     int transMod = transportProp.transMod;
/*  619 */     String modValue = transportProp.modValue;
/*  620 */     if (transMod == Const.TRANSPORT_CONDITION.NOTHING.value) {
/*  621 */       flag = true;
/*  622 */     } else if (transMod == Const.TRANSPORT_CONDITION.ACCEPT_TASK.value) {
/*  623 */       if (player.taskManager.isTaskDoing(Integer.parseInt(modValue))) {
/*  624 */         flag = true;
/*      */       }
/*  626 */     } else if (transMod == Const.TRANSPORT_CONDITION.FINISH_TASK.value) {
/*  627 */       if (player.taskManager.isFinishTask(Integer.parseInt(modValue))) {
/*  628 */         flag = true;
/*      */       }
/*  630 */     } else if (transMod == Const.TRANSPORT_CONDITION.HAS_ITEM.value) {
/*  631 */       if (player.getWnBag().findItemNumByCode(modValue) > 0) {
/*  632 */         flag = true;
/*      */       }
/*  634 */     } else if (transMod == Const.TRANSPORT_CONDITION.CONSUME_ITEM.value) {
/*  635 */       int itemNumber = transportProp.needNumber;
/*  636 */       if (player.getWnBag().findItemNumByCode(modValue) > itemNumber) {
/*  637 */         player.getWnBag().discardItem(modValue, 0, null);
/*      */ 
/*      */         
/*  640 */         flag = true;
/*      */       } 
/*      */     } 
/*      */     
/*  644 */     if (flag) {
/*  645 */       int areaId = transportProp.targetMap;
/*  646 */       Map<String, Integer> targetPoint = transportProp.targetPoint_;
/*  647 */       if (targetPoint != null && targetPoint.size() > 0) {
/*  648 */         AreaUtil.enterArea(player, areaId, ((Integer)targetPoint.get("targetX")).intValue(), ((Integer)targetPoint.get("targetY")).intValue());
/*      */       } else {
/*  650 */         AreaUtil.enterArea(player, areaId, 0.0F, 0.0F);
/*      */       } 
/*  652 */       return true;
/*      */     } 
/*  654 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isRobot(PlayerPO player) {
/*  658 */     return (GWorld.ROBOT && player.uid.startsWith("robot") && !player.uid.endsWith("hoolai"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static AllBlobPO createPlayer(String playerId, String uid, String name, int pro, int logicServerId) {
/*  665 */     AllBlobPO allBlobData = new AllBlobPO();
/*  666 */     PlayerPO player = createPlayerPO(playerId, uid, name, pro, logicServerId);
/*  667 */     allBlobData.player = player;
/*  668 */     PlayerPOManager.put(ConstsTR.playerTR, playerId, (GEntity)player);
/*      */     
/*  670 */     allBlobData.playerBase = createBaseData(playerId);
/*      */     
/*  672 */     allBlobData.playerTemp = createTempData(playerId);
/*      */     
/*  674 */     PlayerAttachPO playerAttachPO = new PlayerAttachPO();
/*  675 */     allBlobData.playerAttachPO = playerAttachPO;
/*  676 */     playerAttachPO.firstKillMonsterIds = new ArrayList();
/*      */     
/*  678 */     createShopMall(playerId);
/*      */     
/*  680 */     allBlobData.tasks = createTasks(playerId, 1);
/*      */     
/*  682 */     BagsPO bagsPO = new BagsPO(createBag(), createWareHouse(), createRecycle());
/*  683 */     PlayerPOManager.put(ConstsTR.bagTR, playerId, (GEntity)bagsPO);
/*      */     
/*  685 */     SkillsPO skills = createSkills(pro, 1);
/*  686 */     PlayerPOManager.put(ConstsTR.skillTR, playerId, (GEntity)skills);
/*      */     
/*  688 */     playerAttachPO.sysSet = createSysSetManager();
/*      */     
/*  690 */     allBlobData.hookSetData = createHookSetManager(playerId);
/*      */     
/*  692 */     createActivityManager(playerId);
/*      */     
/*  694 */     PlayerPOManager.put(ConstsTR.player_fightlevelTR, playerId, (GEntity)new FightLevelsPO());
/*      */     
/*  696 */     createAttendance(playerId);
/*      */     
/*  698 */     createTitle(playerId);
/*      */     
/*  700 */     createConsignment(playerId);
/*      */     
/*  702 */     createOnlineData(playerId, Const.ONLINE_GIFT_TYPE.FIRST_DAY, player.upLevel, player.level);
/*      */     
/*  704 */     PlayerPOManager.put(ConstsTR.mailTR, playerId, (GEntity)new PlayerMailDataPO());
/*      */     
/*  706 */     PlayerPOManager.put(ConstsTR.player_dailyTR, playerId, (GEntity)new DailyActivityPO());
/*      */     
/*  708 */     PlayerPOManager.put(ConstsTR.player_func_openTR, playerId, (GEntity)new FunctionOpenPO());
/*      */     
/*  710 */     PlayerPOManager.put(ConstsTR.pkRuleTR, playerId, (GEntity)new PlayerPKDataPO());
/*      */     
/*  712 */     PlayerPOManager.put(ConstsTR.player_arena_dataTR, playerId, (GEntity)new ArenaDataPO());
/*      */     
/*  714 */     PlayerPOManager.put(ConstsTR.player_leaderboardTR, playerId, (GEntity)new LeaderBoardPlayerPO());
/*      */     
/*  716 */     PlayerPOManager.put(ConstsTR.player_friendsTR, playerId, (GEntity)new PlayerFriendsPO());
/*      */     
/*  718 */     playerAttachPO.sceneProgress = new HashMap<>();
/*  719 */     playerAttachPO.vipData = new VipPO();
/*      */     
/*  721 */     allBlobData.chouRens = new PlayerChouRenPO();
/*  722 */     PlayerPOManager.put(ConstsTR.player_chourenTR, playerId, (GEntity)allBlobData.chouRens);
/*      */     
/*  724 */     allBlobData.achievements = new AchievementDataPO();
/*  725 */     allBlobData.achievements.achievements = new HashMap<>();
/*  726 */     playerAttachPO.medal = new MedalPO();
/*  727 */     PlayerPOManager.put(ConstsTR.achievementTR, playerId, (GEntity)allBlobData.achievements);
/*      */     
/*  729 */     PlayerPOManager.put(ConstsTR.playerPetTR, playerId, (GEntity)new PlayerPetsNewPO());
/*      */     
/*  731 */     PlayerPOManager.put(ConstsTR.player_solo_dataTR, playerId, (GEntity)new SoloDataPO(playerId));
/*      */     
/*  733 */     allBlobData.five2FivePo = Five2FiveService.getInstance().createFive2FivePO(playerId);
/*  734 */     PlayerPOManager.put(ConstsTR.five2FiveTR, playerId, (GEntity)allBlobData.five2FivePo);
/*      */ 
/*      */     
/*  737 */     allBlobData.xianYuan = XianYuanService.getInstance().createXianYuan(playerId);
/*  738 */     PlayerPOManager.put(ConstsTR.xianYuanTR, playerId, (GEntity)allBlobData.xianYuan);
/*      */     
/*  740 */     CharacterExt characterProp = (CharacterExt)GameData.Characters.get(Integer.valueOf(pro));
/*      */     
/*  742 */     List<CharacterExt.InitItem> initItems = characterProp.initItems;
/*  743 */     int index = 1;
/*  744 */     for (int i = 0; i < initItems.size(); i++) {
/*  745 */       CharacterExt.InitItem itemData = initItems.get(i);
/*  746 */       DItemEquipBase itemProp = ItemUtil.getPropByCode(itemData.itemCode);
/*  747 */       if (itemProp != null) {
/*  748 */         List<NormalItem> items = ItemUtil.createItemsByItemCode(itemData.itemCode, itemData.itemNum);
/*  749 */         for (int j = 0; j < items.size(); j++) {
/*  750 */           if (index <= bagsPO.bagData.bagGridCount) {
/*  751 */             NormalItem item = items.get(j);
/*  752 */             bagsPO.bagData.bagGrids.put(Integer.valueOf(index), item.itemDb);
/*  753 */             index++;
/*      */           } 
/*      */         } 
/*      */       } else {
/*  757 */         Out.warn(new Object[] { "角色初始化添加物品失败 player pro:", Integer.valueOf(pro), "itemCode:", itemData.itemCode });
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  762 */     allBlobData.playerBase.equipGrids = new HashMap<>();
/*  763 */     List<String> equips = isRobot(player) ? Arrays.<String>asList(new String[] { "lweap1-test", "lclot1-test" }) : characterProp.initEquips;
/*  764 */     for (String code : equips) {
/*      */       
/*  766 */       NormalEquip equip = ItemUtil.createItemsByItemCode(code, 1).get(0);
/*  767 */       equip.setBind(1);
/*  768 */       allBlobData.playerBase.equipGrids.put(Integer.valueOf(equip.prop.itemSecondType), equip.itemDb);
/*      */     } 
/*      */     
/*  771 */     PlayerPOManager.put(ConstsTR.bagTR, playerId, (GEntity)bagsPO);
/*  772 */     PlayerPOManager.put(ConstsTR.playerAttachTR, playerId, (GEntity)playerAttachPO);
/*  773 */     PlayerPOManager.put(ConstsTR.playerBaseTR, playerId, (GEntity)allBlobData.playerBase);
/*      */ 
/*      */     
/*  776 */     PlayerPOManager.sync(playerId);
/*  777 */     return allBlobData;
/*      */   }
/*      */   
/*      */   public static OnlineDataPO createOnlineData(String playerId, Const.ONLINE_GIFT_TYPE giftType, int upLevel, int level) {
/*  781 */     OnlineDataPO onlineData = new OnlineDataPO();
/*  782 */     PlayerPOManager.put(ConstsTR.onlineGiftTR, playerId, (GEntity)onlineData);
/*  783 */     List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(giftType.getValue(), upLevel, level);
/*  784 */     for (int i = 0; i < propList.size(); i++) {
/*  785 */       onlineData.rewardState.put(Integer.valueOf(((OlGiftExt)propList.get(i)).giftId), Integer.valueOf(PlayerAttendance.GiftState.NO_RECEIVE.getValue()));
/*      */     }
/*  787 */     return onlineData;
/*      */   }
/*      */   
/*      */   public static void createConsignment(String playerId) {
/*  791 */     PlayerConsignmentItemsPO po = new PlayerConsignmentItemsPO();
/*  792 */     PlayerPOManager.put(ConstsTR.player_consignmentTR, playerId, (GEntity)po);
/*      */   }
/*      */   
/*      */   public static void createTitle(String playerId) {
/*  796 */     TitlePO titlePO = new TitlePO();
/*  797 */     titlePO.awardRanks = new HashMap<>();
/*  798 */     titlePO.selectedRankId = 0;
/*  799 */     PlayerPOManager.put(ConstsTR.playerTitleTR, playerId, (GEntity)titlePO);
/*      */   }
/*      */   
/*      */   public static PlayerPO createPlayerPO(String playerId, String uid, String name, int pro, int logicServerId) {
/*  803 */     PlayerPO player = new PlayerPO();
/*  804 */     player.id = playerId;
/*  805 */     player.uid = uid;
/*  806 */     player.name = name;
/*  807 */     player.logicServerId = logicServerId;
/*  808 */     player.isDelete = 0;
/*  809 */     player.level = 1;
/*  810 */     player.exp = 0L;
/*  811 */     player.prestige = 0;
/*  812 */     player.pro = pro;
/*      */     
/*  814 */     player.gold = 0;
/*  815 */     player.ticket = 0;
/*  816 */     player.diamond = 0;
/*  817 */     player.totalCostDiamond = 0;
/*      */     
/*  819 */     player.friendly = 0;
/*      */     
/*  821 */     player.consumePoint = 0;
/*  822 */     player.charm = 100;
/*  823 */     player.pawnGold = 0;
/*  824 */     player.guildpoint = 0;
/*  825 */     player.treasurePoint = 0;
/*  826 */     player.vip = Const.VipType.none.value;
/*  827 */     Date date = new Date();
/*  828 */     player.isAcceptAutoTeam = GlobalConfig.TeamAutoInvite;
/*  829 */     player.createTime = date;
/*  830 */     player.loginTime = date;
/*  831 */     player.logoutTime = date;
/*  832 */     player.refreshTime = date;
/*  833 */     player.fightPower = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  839 */     return player;
/*      */   }
/*      */   
/*      */   public static PlayerTempPO createTempData(String playerId) {
/*  843 */     PlayerTempPO tempData = new PlayerTempPO();
/*  844 */     tempData.historyAreaId = GlobalConfig.motherland;
/*  845 */     tempData.historyX = 0.0F;
/*  846 */     tempData.historyY = 0.0F;
/*  847 */     tempData.bornAreaId = GlobalConfig.motherland;
/*  848 */     tempData.bornX = 0.0F;
/*  849 */     tempData.bornY = 0.0F;
/*  850 */     tempData.x = 0.0F;
/*  851 */     tempData.y = 0.0F;
/*  852 */     tempData.hp = 999999;
/*  853 */     tempData.mp = 999999;
/*  854 */     tempData.areaId = GlobalConfig.motherland;
/*      */     
/*  856 */     PlayerPOManager.put(ConstsTR.playerTempTR, playerId, (GEntity)tempData);
/*      */     
/*  858 */     return tempData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static PlayerBasePO createBaseData(String playerId) {
/*  865 */     PlayerBasePO playerBasePO = new PlayerBasePO();
/*  866 */     playerBasePO.equipGrids = new HashMap<>();
/*  867 */     playerBasePO.strengthPos = new HashMap<>();
/*      */     
/*  869 */     int gridsCount = (Const.EquipType.values()).length;
/*  870 */     for (int i = 1; i <= gridsCount; i++) {
/*  871 */       EquipSockExt sockCO = (EquipSockExt)GameData.EquipSocks.get(Integer.valueOf(i));
/*  872 */       playerBasePO.equipGrids.put(Integer.valueOf(i), null);
/*  873 */       PlayerBasePO.EquipStrengthPos pos = new PlayerBasePO.EquipStrengthPos();
/*  874 */       pos.enSection = 0;
/*  875 */       pos.enLevel = 0;
/*  876 */       pos.socks = 0;
/*  877 */       pos.gems = new HashMap<>();
/*  878 */       for (int j = 1; j <= sockCO.sockOpenLevel.size(); j++) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  883 */         if (1 >= ((Integer)sockCO.sockOpenLevel.get(Integer.valueOf(j))).intValue()) {
/*  884 */           pos.socks++;
/*      */         }
/*      */       } 
/*  887 */       playerBasePO.strengthPos.put(Integer.valueOf(i), pos);
/*      */     } 
/*  889 */     return playerBasePO;
/*      */   }
/*      */   
/*      */   private static ShopMallPO createShopMall(String playerId) {
/*  893 */     Map<Integer, Map<Integer, Boolean>> seenTab = new HashMap<>();
/*  894 */     seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()), new HashMap<>());
/*  895 */     seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()), new HashMap<>());
/*      */     
/*  897 */     ShopMallPO shopMall = new ShopMallPO(seenTab);
/*      */     
/*  899 */     PlayerPOManager.put(ConstsTR.shopMallTR, playerId, (GEntity)shopMall);
/*      */     
/*  901 */     return shopMall;
/*      */   }
/*      */   
/*      */   private static ActivityDataPO createActivityManager(String playerId) {
/*  905 */     ActivityDataPO activityData = new ActivityDataPO();
/*      */     
/*  907 */     activityData.activityRewardRecorder = new HashMap<>();
/*      */     
/*  909 */     activityData.activityInfo = new HashMap<>();
/*      */     
/*  911 */     activityData.luckyAwardContainer = new ArrayList();
/*  912 */     activityData.drawedContainer = new HashMap<>();
/*  913 */     activityData.refreshTime = new Date();
/*  914 */     activityData.buffTimes = 1;
/*      */     
/*  916 */     PlayerPOManager.put(ConstsTR.activityTR, playerId, (GEntity)activityData);
/*      */     
/*  918 */     return activityData;
/*      */   }
/*      */   
/*      */   private static int createSysSetManager() {
/*  922 */     int ret = 1;
/*  923 */     ret |= SysSetFlag.recvMailSet.getValue();
/*  924 */     ret |= SysSetFlag.teamInviteSet.getValue();
/*  925 */     ret |= SysSetFlag.recvStrangerMsgSet.getValue();
/*  926 */     ret |= SysSetFlag.recvAddFriendSet.getValue();
/*  927 */     return ret;
/*      */   }
/*      */   
/*      */   public static HookSetPO createHookSetManager(String playerId) {
/*  931 */     HookSetPO hootSet = new HookSetPO(playerId);
/*  932 */     hootSet.hpPercent = GlobalConfig.Auto_HP_Percent;
/*  933 */     hootSet.mpPercent = GlobalConfig.Auto_MP_Percent;
/*  934 */     hootSet.hpItemCode = GlobalConfig.Auto_HP_Item;
/*  935 */     hootSet.mpItemCode = GlobalConfig.Auto_MP_Item;
/*  936 */     hootSet.pkSet = GlobalConfig.Auto_PK_Reaction;
/*  937 */     hootSet.meltQcolor.add(Integer.valueOf(GlobalConfig.Auto_Eqip_Qcolor));
/*  938 */     hootSet.autoBuyHpItem = 1;
/*  939 */     hootSet.autoBuyMpItem = 0;
/*  940 */     hootSet.fieldMaphook = 0;
/*  941 */     hootSet.areaMaphook = 0;
/*      */     
/*  943 */     PlayerPOManager.put(ConstsTR.hookSetTR, playerId, (GEntity)hootSet);
/*      */     
/*  945 */     return hootSet;
/*      */   }
/*      */   
/*      */   public static AttendancePO createAttendance(String playerId) {
/*  949 */     AttendancePO sign = new AttendancePO();
/*      */     
/*  951 */     sign.stage = 1;
/*  952 */     sign.lastSignTime = DateUtil.getZeroDate();
/*  953 */     sign.signMap = new HashMap<>();
/*  954 */     sign.cumulativeMap = new HashMap<>();
/*  955 */     sign.lastLuxuryTime = DateUtil.getZeroDate();
/*  956 */     sign.luxuryState = PlayerAttendance.GiftState.NO_RECEIVE.getValue();
/*      */     
/*  958 */     PlayerPOManager.put(ConstsTR.player_signTR, playerId, (GEntity)sign);
/*  959 */     return sign;
/*      */   }
/*      */   
/*      */   public static TaskListPO createTasks(String playerId, int level) {
/*  963 */     TaskListPO tasks = new TaskListPO();
/*  964 */     tasks.normalTasks = new HashMap<>();
/*  965 */     tasks.dailyTasks = new HashMap<>();
/*  966 */     tasks.treasureTasks = new HashMap<>();
/*  967 */     tasks.finishedNormalTasks = new HashMap<>();
/*  968 */     tasks.finishedDailyTasks = new HashMap<>();
/*  969 */     tasks.finishedTreasureTasks = new HashMap<>();
/*  970 */     tasks.loopResult = new LoopResult();
/*      */     
/*  972 */     for (MainLineCO main : GameData.MainLines.values()) {
/*  973 */       if (main.before.equals("0")) {
/*      */         
/*  975 */         TaskData task = TaskUtils.createTask((TaskBase)main);
/*  976 */         tasks.normalTasks.put(Integer.valueOf(task.db.templateId), task.toJson4Serialize());
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  981 */     for (BranchLineCO branch : GameData.BranchLines.values()) {
/*  982 */       if (branch.before.equals("0") && branch.level <= level) {
/*      */         
/*  984 */         TaskData task = TaskUtils.createTask((TaskBase)branch);
/*  985 */         tasks.normalTasks.put(Integer.valueOf(task.db.templateId), task.toJson4Serialize());
/*      */       } 
/*      */     } 
/*      */     
/*  989 */     PlayerPOManager.put(ConstsTR.taskTR, playerId, (GEntity)tasks);
/*  990 */     return tasks;
/*      */   }
/*      */   
/*      */   private static SkillsPO createSkills(int pro, int initLevel) {
/*  994 */     SkillsPO skills = SkillManager.initNewPlayerSkills(pro, initLevel);
/*  995 */     skills.skillKeys = createSkillKeys(pro);
/*  996 */     return skills;
/*      */   }
/*      */   
/*      */   private static Map<Integer, Integer> createSkillKeys(int pro) {
/* 1000 */     Map<Integer, Integer> allSkillKeys = new HashMap<>();
/* 1001 */     for (int j = 0; j < 11; j++) {
/* 1002 */       allSkillKeys.put(Integer.valueOf(j), Integer.valueOf(-1));
/*      */     }
/* 1004 */     Out.debug(new Object[] { PlayerUtil.class, "createSkillKeys: ", allSkillKeys });
/* 1005 */     return allSkillKeys;
/*      */   }
/*      */   
/*      */   public static BagPO createBag() {
/* 1009 */     BagPO data = new BagPO();
/* 1010 */     data.bagGrids = new HashMap<>();
/* 1011 */     data.bagGridCount = GlobalConfig.Package_DefaultSize;
/* 1012 */     return data;
/*      */   }
/*      */   
/*      */   public static BagPO createWareHouse() {
/* 1016 */     BagPO data = new BagPO();
/* 1017 */     data.bagGrids = new HashMap<>();
/* 1018 */     data.bagGridCount = GlobalConfig.PersonalWarehouse_DefaultSize;
/* 1019 */     return data;
/*      */   }
/*      */   
/*      */   public static BagPO createRecycle() {
/* 1023 */     BagPO data = new BagPO();
/* 1024 */     data.bagGrids = new HashMap<>();
/* 1025 */     data.bagGridCount = GlobalConfig.Package_MaxSize;
/* 1026 */     return data;
/*      */   }
/*      */   
/*      */   public static String getRandomName(int pro) {
/* 1030 */     String firstName = getFirstName();
/* 1031 */     if (firstName.length() <= 0) {
/* 1032 */       return null;
/*      */     }
/*      */     
/* 1035 */     String lastName = getLastName(pro);
/*      */     
/* 1037 */     if (lastName.length() <= 0) {
/* 1038 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1042 */     if (GWorld.__SERVER_LANG == XLang.VN) {
/* 1043 */       return firstName + " " + lastName;
/*      */     }
/*      */     
/* 1046 */     return firstName + lastName;
/*      */   }
/*      */   
/*      */   public static String getFirstName() {
/* 1050 */     List<PrefixCO> first_list = (PlayerConfig.getInstance()).randomname_prefix;
/* 1051 */     if (first_list.size() <= 0) {
/* 1052 */       return "";
/*      */     }
/* 1054 */     int rndIndex = Utils.random(0, first_list.size() - 1);
/* 1055 */     return ((PrefixCO)first_list.get(rndIndex)).prefix;
/*      */   }
/*      */   
/*      */   private static int _getSexByPro(int pro) {
/* 1059 */     if (pro == Const.PlayerPro.CANG_LANG.value || pro == Const.PlayerPro.YI_XIAN.value || pro == Const.PlayerPro.SHEN_JIAN.value || pro == Const.PlayerPro.COMMON.value) {
/* 1060 */       return 1;
/*      */     }
/* 1062 */     return 0;
/*      */   }
/*      */   
/*      */   public static String getLastName(int pro) {
/* 1066 */     List<SuffixCO> lastWomanList = (PlayerConfig.getInstance()).randomname_suffix.get(Integer.valueOf(0));
/* 1067 */     List<SuffixCO> lastManList = (PlayerConfig.getInstance()).randomname_suffix.get(Integer.valueOf(1));
/*      */     
/* 1069 */     int sex = _getSexByPro(pro);
/* 1070 */     List<SuffixCO> last_list = null;
/* 1071 */     if (sex == 0) {
/* 1072 */       last_list = lastWomanList;
/*      */     } else {
/* 1074 */       last_list = lastManList;
/*      */     } 
/*      */     
/* 1077 */     if (last_list == null || last_list.size() <= 0) {
/* 1078 */       return "";
/*      */     }
/*      */     
/* 1081 */     int rndIndex = Utils.random(0, last_list.size() - 1);
/* 1082 */     return ((SuffixCO)last_list.get(rndIndex)).suffix;
/*      */   }
/*      */   
/*      */   public static void onFishItem(WNPlayer player, String tc, String extendTc) {
/* 1086 */     Out.debug(new Object[] { PlayerUtil.class, "onFishItem tc:", tc, "  extendTc:", extendTc });
/* 1087 */     List<NormalItem> items = ItemUtil.createItemsByTcCode(tc);
/* 1088 */     Out.debug(new Object[] { PlayerUtil.class, "onFishItem:" + tc });
/* 1089 */     List<NormalItem> extendItems = null;
/* 1090 */     if (StringUtil.isNotEmpty(extendTc)) {
/* 1091 */       extendItems = ItemUtil.createItemsByTcCode(extendTc);
/* 1092 */       items.addAll(extendItems);
/*      */     } 
/*      */     
/* 1095 */     Out.debug(new Object[] { PlayerUtil.class, "onFishItem 2222:", Integer.valueOf(items.size()) });
/* 1096 */     if (items.size() <= 0) {
/* 1097 */       player.sendSysTip(LangService.getValue("FISH_FAILED"), Const.TipsType.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1107 */     if (!player.bag.testEmptyGridLarge(ItemUtil.getPackUpItemsNum(items))) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1112 */     if (extendItems != null) {
/* 1113 */       for (NormalItem dropItem : extendItems) {
/* 1114 */         player.taskManager.dealTaskEvent(Const.TaskType.FISH, dropItem.itemDb.code, dropItem.itemDb.groupCount);
/*      */       }
/*      */     }
/*      */     
/* 1118 */     player.bag.addEntityItems(items, Const.GOODS_CHANGE_TYPE.fish, null);
/* 1119 */     List<ItemOuterClass.MiniItem> miniItem = new ArrayList<>();
/*      */     
/* 1121 */     for (NormalItem v : items) {
/* 1122 */       miniItem.add(ItemUtil.getMiniItemData(v.itemDb.code, v.itemDb.groupCount, Const.ForceType.getE(v.getBind())).build());
/*      */     }
/*      */ 
/*      */     
/* 1126 */     player.onFishItem(miniItem);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getColorPlayerNameByPro(int pro, String playerName) {
/* 1157 */     return playerName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String getUpLevelName(int upLevel, int pro) {
/* 1166 */     String name = "";
/* 1167 */     UpLevelExpExt prop = PlayerConfig.getInstance().findupLevelExpPropsByUpLevelAndPro(upLevel, pro);
/* 1168 */     if (prop == null) {
/* 1169 */       return name;
/*      */     }
/* 1171 */     int qColor = prop.qcolor;
/*      */     
/* 1173 */     String colorInfo = LangService.getValue("WHITE");
/* 1174 */     if (qColor == 1) {
/* 1175 */       colorInfo = LangService.getValue("GREEN");
/* 1176 */     } else if (qColor == 2) {
/* 1177 */       colorInfo = LangService.getValue("BLUE");
/* 1178 */     } else if (qColor == 3) {
/* 1179 */       colorInfo = LangService.getValue("PURPLE");
/* 1180 */     } else if (qColor == 4) {
/* 1181 */       colorInfo = LangService.getValue("ORANGE");
/* 1182 */     } else if (qColor == 5) {
/* 1183 */       colorInfo = LangService.getValue("RED");
/*      */     } 
/* 1185 */     colorInfo = colorInfo.replace("{a}", prop.uPName);
/* 1186 */     return colorInfo;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getFullColorName(WNPlayer player) {
/* 1191 */     StringBuilder name = new StringBuilder(getColorPlayerNameByPro(player.getPro(), player.getName()));
/* 1192 */     name.append("(");
/* 1193 */     String whiteColorInfo = LangService.getValue("WHITE");
/* 1194 */     String pro = "";
/* 1195 */     CharacterCO character = (CharacterCO)GameData.Characters.get(Integer.valueOf(player.getPro()));
/* 1196 */     if (character != null) {
/* 1197 */       pro = character.proName + ", ";
/*      */     }
/* 1199 */     name.append(whiteColorInfo.replace("{a}", pro + player.getLevel() + "级"));
/*      */     
/* 1201 */     name.append(")");
/* 1202 */     return name.toString();
/*      */   }
/*      */   
/*      */   public static int initCurMaxLv(PlayerPO baseData) {
/* 1206 */     return GlobalConfig.Role_LevelLimit;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Collection<GPlayer> getAllOnlinePlayer() {
/* 1216 */     return GWorld.getInstance().getOnlinePlayers().values();
/*      */   }
/*      */   
/*      */   public static void bi(Class<?> clazz, Const.BiLogType logType, WNPlayer player, Object... args) {
/* 1220 */     if (player == null) {
/* 1221 */       Out.error(new Object[] { logType.desc, " player is null" });
/*      */       return;
/*      */     } 
/* 1224 */     bi(clazz, logType, player.player, args);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void bi(Class<?> clazz, Const.BiLogType logType, PlayerPO player, Object... args) {
/* 1231 */     if (!GWorld.ROBOT) {
/* 1232 */       StringBuilder builder = new StringBuilder();
/* 1233 */       builder.append(player.uid).append(", ").append(player.id).append(", ");
/* 1234 */       builder.append(player.name).append(", ").append(player.logicServerId).append(", ");
/* 1235 */       builder.append(player.pro).append(", ").append(player.level).append(",");
/* 1236 */       builder.append(player.upLevel).append(", ").append(player.vip).append(", ");
/* 1237 */       builder.append(player.fightPower).append(", ").append(player.gold).append(", ");
/* 1238 */       builder.append(player.diamond).append(", ").append(player.ticket);
/* 1239 */       for (Object arg : args) {
/* 1240 */         builder.append(", ").append(arg);
/*      */       }
/* 1242 */       Out.info(new Object[] { clazz.getName(), "::", logType.desc, "::, ", builder });
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void logWarnIfPlayerNull(Packet packet) {
/* 1247 */     if (packet == null) {
/* 1248 */       Out.warn(new Object[] { "发现PlayerNUll.啥信息都没!" });
/*      */       return;
/*      */     } 
/* 1251 */     Channel c = packet.getSession();
/* 1252 */     if (c == null) {
/* 1253 */       Out.warn(new Object[] { "发现PlayerNUll.只有包信息!" });
/*      */       return;
/*      */     } 
/* 1256 */     Out.warn(new Object[] { "发现PlayerNUll.", c.remoteAddress() });
/*      */   }
/*      */   
/*      */   public static void addLoginServer(String uid, int sid, int count) {
/* 1260 */     String playerServers = AuthServer.get("/player/servers/" + uid);
/* 1261 */     JSONArray loginServers = null;
/* 1262 */     if (StringUtil.isNotEmpty(playerServers)) {
/* 1263 */       loginServers = JSON.parseArray(playerServers);
/*      */     } else {
/* 1265 */       loginServers = new JSONArray();
/*      */     } 
/* 1267 */     for (int i = loginServers.size() - 1; i >= 0; i--) {
/* 1268 */       JSONObject jSONObject = loginServers.getJSONObject(i);
/* 1269 */       if (jSONObject.getIntValue("sid") == sid) {
/* 1270 */         if (jSONObject.getIntValue("count") == count) {
/*      */           return;
/*      */         }
/* 1273 */         if (count == 0) {
/* 1274 */           loginServers.remove(i);
/*      */         } else {
/* 1276 */           jSONObject.put("count", Integer.valueOf(count));
/*      */         } 
/* 1278 */         AuthServer.put("/player/servers/" + uid, loginServers.toJSONString());
/*      */         return;
/*      */       } 
/*      */     } 
/* 1282 */     JSONObject json = new JSONObject();
/* 1283 */     json.put("sid", Integer.valueOf(sid));
/* 1284 */     json.put("count", Integer.valueOf(count));
/* 1285 */     loginServers.add(json);
/* 1286 */     AuthServer.put("/player/servers/" + uid, loginServers.toJSONString());
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PlayerUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */