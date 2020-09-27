/*     */ package com.wanniu.game.leaderBoard;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.LeaderBoardPlayerPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.request.leaderboard.WorShipHandler;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.area.LeaderBoardHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LeaderBoardManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public LeaderBoardPlayerPO po;
/*     */   
/*     */   public LeaderBoardManager(WNPlayer player) {
/*  46 */     this.player = player;
/*  47 */     this.po = (LeaderBoardPlayerPO)PlayerPOManager.findPO(ConstsTR.player_leaderboardTR, this.player.getId(), LeaderBoardPlayerPO.class);
/*     */   }
/*     */   
/*     */   public LeaderBoardPlayerPO toJson4Serialize() {
/*  51 */     return this.po;
/*     */   }
/*     */   
/*     */   public WorShipHandler.WorshipRes worShip(WNPlayer player, int type) {
/*  55 */     List<String> awards = new ArrayList<>();
/*  56 */     WorShipHandler.WorshipRes data = new WorShipHandler.WorshipRes(true, "", awards);
/*     */     
/*  58 */     int reqLevel = GlobalConfig.WorldExp_ReqLevel;
/*     */     
/*  60 */     if (player.getLevel() < reqLevel) {
/*     */       
/*  62 */       data.result = false;
/*  63 */       data.info = LangService.getValue("REWARD_LEVEL_NOT_ENOUGH");
/*  64 */       return data;
/*     */     } 
/*     */     
/*  67 */     if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {
/*     */       
/*  69 */       this.po.worShipTimes = 0;
/*  70 */       this.po.worShipDiamondTimes = 0;
/*     */     } 
/*     */     
/*  73 */     int worShipTimeMax = GlobalConfig.WorldExp_Admire_MaxCount;
/*     */     
/*  75 */     if (this.po.worShipTimes >= worShipTimeMax) {
/*     */       
/*  77 */       data.result = false;
/*  78 */       data.info = LangService.getValue("WORLDEXP_NOT_TIME");
/*  79 */       return data;
/*     */     } 
/*     */     
/*  82 */     int addGold = 0;
/*     */     
/*  84 */     if (type == 0) {
/*     */       
/*  86 */       addGold = GlobalConfig.WorldExp_Admire_AddGold;
/*     */     } else {
/*  88 */       addGold = GlobalConfig.WorldExp_DiamondAdmire_AddGold;
/*     */       
/*  90 */       int costDiamond = GlobalConfig.WorldExp_DiamondAdmire_Price;
/*     */       
/*  92 */       if (player.moneyManager.getDiamond() < costDiamond) {
/*  93 */         player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.PREPAID, null, null, null);
/*  94 */         data.result = false;
/*  95 */         return data;
/*     */       } 
/*     */       
/*  98 */       player.moneyManager.costDiamond(costDiamond, Const.GOODS_CHANGE_TYPE.leaderBoard);
/*     */ 
/*     */       
/* 101 */       this.po.worShipDiamondTimes++;
/*     */     } 
/*     */     
/* 104 */     this.po.worShipTimes++;
/* 105 */     this.po.worShipTime = new Date();
/* 106 */     Out.info(new Object[] { "膜拜大神 playerId=", player.getId(), ",type=", Integer.valueOf(type) });
/* 107 */     player.moneyManager.addGold(addGold, Const.GOODS_CHANGE_TYPE.leaderBoard);
/* 108 */     BILogService.getInstance().ansycReportLeaderBoard(player.getPlayer(), type);
/*     */     
/* 110 */     if (this.po.worShipTimes == worShipTimeMax) {
/*     */       
/* 112 */       String itemCode = GlobalConfig.WorldExp_NormalChest_ItemCode;
/*     */       
/* 114 */       data.awards.add(itemCode);
/*     */       
/* 116 */       if (this.player.bag.testAddCodeItem(itemCode, 1, Const.ForceType.DEFAULT, true)) {
/*     */         
/* 118 */         this.player.bag.addCodeItem(itemCode, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.leaderBoard);
/*     */       } else {
/* 120 */         MailSysData mailData = new MailSysData("Worldexp_reward");
/* 121 */         mailData.attachments = new ArrayList();
/* 122 */         MailData.Attachment attachment = new MailData.Attachment();
/* 123 */         attachment.itemCode = itemCode;
/* 124 */         attachment.itemNum = 1;
/* 125 */         mailData.attachments.add(attachment);
/* 126 */         MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.leaderBoard);
/*     */       } 
/*     */       
/* 129 */       if (this.po.worShipDiamondTimes == worShipTimeMax) {
/*     */         
/* 131 */         int randValue = RandomUtil.getInt(1, 10000);
/*     */         
/* 133 */         if (randValue <= GlobalConfig.WorldExp_SuperChest_Chance) {
/*     */           
/* 135 */           itemCode = GlobalConfig.WorldExp_SuperChest_ItemCode;
/*     */           
/* 137 */           data.awards.add(itemCode);
/*     */           
/* 139 */           if (this.player.bag.testAddCodeItem(itemCode, 1, Const.ForceType.DEFAULT, true)) {
/*     */             
/* 141 */             this.player.bag.addCodeItem(itemCode, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.leaderBoard);
/*     */           } else {
/* 143 */             MailSysData mailData = new MailSysData("Worldexp_reward");
/* 144 */             mailData.attachments = new ArrayList();
/* 145 */             MailData.Attachment attachment = new MailData.Attachment();
/* 146 */             attachment.itemCode = itemCode;
/* 147 */             attachment.itemNum = 1;
/* 148 */             mailData.attachments.add(attachment);
/* 149 */             MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.leaderBoard);
/*     */           } 
/*     */           
/* 152 */           String playerName = MessageUtil.getPlayerNameColor(this.player.getName(), this.player.getPro());
/* 153 */           String msg = LangService.getValue("WORLDEXP_NEWS");
/*     */           
/* 155 */           msg = msg.replace("{playerName}", playerName);
/*     */           
/* 157 */           MessageUtil.sendRollChat(player.getLogicServerId(), msg, Const.CHAT_SCOPE.SYSTEM);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 162 */     updateSuperScript();
/*     */ 
/*     */     
/* 165 */     this.player.dailyActivityMgr.onEvent(Const.DailyType.WORLD_LEVEL, "0", 1);
/*     */     
/* 167 */     this.player.achievementManager.onWorldLevelTimes();
/* 168 */     return data;
/*     */   }
/*     */   
/*     */   public LeaderBoardHandler.WorldLevelInfo worldLevelInfo(WNPlayer player) {
/* 172 */     LeaderBoardHandler.WorldLevelInfo.Builder data = LeaderBoardHandler.WorldLevelInfo.newBuilder();
/*     */     
/* 174 */     if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {
/* 175 */       this.po.worShipTimes = 0;
/* 176 */       this.po.worShipDiamondTimes = 0;
/*     */     } 
/*     */     
/* 179 */     data.setWorShipTimes(this.po.worShipTimes);
/* 180 */     data.setMaxWorShipTimes(GlobalConfig.WorldExp_Admire_MaxCount);
/*     */     
/* 182 */     String playerId = RankType.LEVEL.getHandler().getFirstRankMemberId(GWorld.__SERVER_ID);
/* 183 */     if (StringUtil.isEmpty(playerId)) {
/* 184 */       playerId = player.getId();
/* 185 */       Out.warn(new Object[] { "获取排行榜第一名时没有值" });
/*     */     } 
/* 187 */     PlayerPO result = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
/*     */     
/* 189 */     data.setWorldLevelId(playerId);
/* 190 */     data.setWorldLevelName(result.name);
/* 191 */     data.setWorldLevel(result.level);
/* 192 */     data.setWorldUpLevel(result.upOrder);
/*     */     
/* 194 */     data.addAllAvatars(PlayerUtil.getBattlerServerAvatar(playerId));
/* 195 */     data.setWorldLevelPro(result.pro);
/*     */     
/* 197 */     data.setAddExp(getExpAdd(result));
/*     */     
/* 199 */     GuildPO guild = GuildUtil.getPlayerGuild(playerId);
/* 200 */     data.setRank1StGuildName((guild != null) ? guild.name : "");
/* 201 */     data.setRank1StFight(result.fightPower);
/* 202 */     return data.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExpAdd(PlayerPO result) {
/* 209 */     if (result == null) {
/* 210 */       return 0;
/*     */     }
/* 212 */     int expAdd = 0;
/*     */     
/* 214 */     int ratioPerLevel = GlobalConfig.WorldExp_RatioPerLevel;
/* 215 */     int maxExpRatio = GlobalConfig.WorldExp_MaxExpRatio;
/*     */     
/* 217 */     int levelDiff = result.level - this.player.getLevel();
/*     */     
/* 219 */     if (levelDiff > GlobalConfig.WorldExp_MaxLevelValue) {
/* 220 */       expAdd += ratioPerLevel * levelDiff;
/*     */     }
/*     */     
/* 223 */     if (levelDiff != 0 && 
/* 224 */       expAdd > maxExpRatio) {
/* 225 */       expAdd = maxExpRatio;
/*     */     }
/*     */ 
/*     */     
/* 229 */     return expAdd;
/*     */   }
/*     */   
/*     */   public void updateSuperScript() {
/* 233 */     List<PlayerHandler.SuperScriptType> data = getSuperScript();
/* 234 */     this.player.updateSuperScriptList(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 239 */     List<PlayerHandler.SuperScriptType> data = new ArrayList<>();
/*     */     
/* 241 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.WORLD_EXP.getValue())) {
/* 242 */       PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
/* 243 */       script.setType(Const.SUPERSCRIPT_TYPE.WORLD_LEVEL.getValue());
/* 244 */       script.setNumber(0);
/* 245 */       data.add(script.build());
/*     */     } else {
/* 247 */       if (this.po.worShipTime == null || DateUtil.isNeedFiveRefresh(this.po.worShipTime)) {
/*     */         
/* 249 */         this.po.worShipTimes = 0;
/* 250 */         this.po.worShipDiamondTimes = 0;
/*     */       } 
/*     */       
/* 253 */       int count = (GlobalConfig.WorldExp_Admire_MaxCount > this.po.worShipTimes) ? 1 : 0;
/*     */       
/* 255 */       PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
/* 256 */       script.setType(Const.SUPERSCRIPT_TYPE.WORLD_LEVEL.getValue());
/* 257 */       script.setNumber(count);
/* 258 */       data.add(script.build());
/*     */     } 
/*     */     
/* 261 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\leaderBoard\LeaderBoardManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */