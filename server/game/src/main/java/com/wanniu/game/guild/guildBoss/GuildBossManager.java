/*     */ package com.wanniu.game.guild.guildBoss;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.ext.InspireLevelExt;
/*     */ import com.wanniu.game.monster.GuildBossRatioConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildBossPo;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.poes.InspirePO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.GuildBossHandler;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildBossManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   private MapBase mapProp;
/*     */   
/*     */   public GuildBossManager(WNPlayer player) {
/*  46 */     this.player = player;
/*  47 */     this.mapProp = GuildBossService.getInstance().getGuildBossMap();
/*     */   }
/*     */   
/*     */   public String handleEnterGuildBossArea() {
/*  51 */     GuildPO guildPo = this.player.guildManager.getGuildInfo();
/*  52 */     String msg = canEnter(guildPo);
/*  53 */     if (msg == null) {
/*  54 */       String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildId(guildPo.id, guildPo);
/*  55 */       if (instanceId == null) {
/*  56 */         Out.info(new Object[] { "仙盟活动有新的工会进入场景。。。guildId=", guildPo.id });
/*  57 */         Area area = GuildBossService.getInstance().enterGuildBossSence(this.player, GuildBossService.getInstance().getGuildBossLevel());
/*  58 */         GuildBossCenter.getInstance().addOneGuildId(guildPo.id, area.instanceId, guildPo);
/*     */       } else {
/*  60 */         Area area = AreaUtil.getArea(instanceId);
/*  61 */         if (area == null) {
/*  62 */           Out.warn(new Object[] { "发现有玩家在进工会BOSS场景的时候发现场景为空,guildId=", guildPo.id });
/*  63 */           area = GuildBossService.getInstance().enterGuildBossSence(this.player, GuildBossService.getInstance().getGuildBossLevel());
/*  64 */           GuildBossCenter.getInstance().addOneGuildId(guildPo.id, area.instanceId, guildPo);
/*     */         } else {
/*  66 */           AreaUtil.dispatchByInstanceId(this.player, new AreaData(52001, instanceId));
/*     */         } 
/*     */       } 
/*     */     } 
/*  70 */     return msg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Integer> calAllInfluence() {
/*  79 */     Map<String, Integer> map = new HashMap<>();
/*  80 */     if (this.player.area == null) {
/*  81 */       return map;
/*     */     }
/*  83 */     if (this.player.area.areaId == 52001) {
/*  84 */       GuildPO guildPO = this.player.guildManager.guild;
/*  85 */       if (guildPO == null) {
/*  86 */         return map;
/*     */       }
/*  88 */       String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildIdNoLock(guildPO.id);
/*  89 */       if (instanceId != null) {
/*  90 */         Area currentArea = AreaUtil.getArea(instanceId);
/*  91 */         if (currentArea != null && 
/*  92 */           currentArea.getActor(this.player.getId()) != null) {
/*  93 */           int totalAtkAdd = ((GuildBossArea)currentArea).getTotalAtkAdd(this.player);
/*  94 */           map.put(Const.PlayerBtlData.PhyPer.toString(), Integer.valueOf(totalAtkAdd));
/*  95 */           map.put(Const.PlayerBtlData.MagPer.toString(), Integer.valueOf(totalAtkAdd));
/*  96 */           int totalDefAdd = ((GuildBossArea)currentArea).getTotalDefAdd(this.player);
/*  97 */           map.put(Const.PlayerBtlData.Def.toString(), Integer.valueOf(totalDefAdd / 100));
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 102 */       return map;
/*     */     } 
/* 104 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String handlerInspireGuildBoss(int index) {
/* 113 */     GuildPO guildPO = this.player.guildManager.guild;
/* 114 */     if (this.player.area.areaId != 52001) {
/* 115 */       return LangService.getValue("GUILD_BOSS_INSPIRE_SCENE");
/*     */     }
/* 117 */     InspirePO inspirePO = null;
/* 118 */     GuildBossPo guildBossPO = null;
/* 119 */     if (guildPO != null) {
/* 120 */       GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildPO.id);
/* 121 */       if (bean == null) {
/* 122 */         Out.warn(new Object[] { "在进行工会鼓舞的时候发生了未知错误2...playerId=", this.player.getId() });
/* 123 */         return LangService.getValue("GUILD_BOSS_INSPIRE_SCENE");
/* 124 */       }  if (bean.hasKilled()) {
/* 125 */         return LangService.getValue("GUILD_BOSS_INSPIRE_DEAD");
/*     */       }
/*     */     } 
/*     */     
/* 129 */     if (index == 1) {
/* 130 */       guildBossPO = getAndCheckUpdateGuildBossPo(this.player.player.id);
/* 131 */       inspirePO = guildBossPO.inspire;
/* 132 */     } else if (index == 2) {
/* 133 */       if (guildPO == null) {
/* 134 */         Out.warn(new Object[] { "在进行工会鼓舞的时候发生了未知错误...playerId=", this.player.getId() });
/* 135 */         return LangService.getValue("PLAYER_PRO_ILLEGALITY");
/*     */       } 
/* 137 */       inspirePO = getAndCheckGuildBossAtkPoForGuild(guildPO);
/* 138 */     } else if (index == 3) {
/* 139 */       if (guildPO == null) {
/* 140 */         Out.warn(new Object[] { "在进行工会鼓舞的时候发生了未知错误...playerId=", this.player.getId() });
/* 141 */         return LangService.getValue("PLAYER_PRO_ILLEGALITY");
/*     */       } 
/* 143 */       inspirePO = getAndCheckGuildBossDefPoForGuild(guildPO);
/*     */     } else {
/* 145 */       return LangService.getValue("PARAM_ERROR");
/*     */     } 
/* 147 */     int currentCount = inspirePO.count;
/* 148 */     int nextCount = currentCount + 1;
/* 149 */     InspireLevelExt co = GuildBossRatioConfig.getInspireLevelCO(index, nextCount);
/* 150 */     if (co == null) {
/* 151 */       return LangService.getValue("GUILD_BOSS_INSPIRE_MAXCOUNT");
/*     */     }
/* 153 */     boolean isEnoughMoney = this.player.moneyManager.costTicketAndDiamond(co.inspireCost, Const.GOODS_CHANGE_TYPE.BOSS_GUILD_INSPIRE).isSuccess();
/* 154 */     if (!isEnoughMoney) {
/* 155 */       return LangService.getValue("TICKET_NOT_ENOUGH");
/*     */     }
/* 157 */     inspirePO.count = nextCount;
/* 158 */     String instanceId = GuildBossCenter.getInstance().getGuildBossScenceIdByGuildIdNoLock(guildPO.id);
/* 159 */     if (instanceId != null) {
/* 160 */       Area currentArea = AreaUtil.getArea(instanceId);
/* 161 */       if (currentArea != null) {
/* 162 */         if (index == 1) {
/* 163 */           ((GuildBossArea)currentArea).receiveSinlgInspire(this.player, guildBossPO, true);
/* 164 */         } else if (index == 2 || index == 3) {
/* 165 */           guildPO.modify = true;
/* 166 */           ((GuildBossArea)currentArea).receiveGuildInspire(index, nextCount);
/* 167 */           pushAllAfterinprire(guildPO.name, this.player.getName(), co.totalInspirePlus / 100, index);
/*     */         } 
/*     */       }
/*     */     } 
/* 171 */     return null;
/*     */   }
/*     */   
/*     */   public void pushAllAfterinprire(String guildName, String roleName, int totalAdd, int index) {
/* 175 */     String tempStr2 = "";
/* 176 */     if (index == 2) {
/* 177 */       tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_GUILD_BOSS"), new Object[] { guildName, roleName, "" + totalAdd + "%", Const.TipsType.NORMAL });
/*     */     } else {
/* 179 */       tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_GUILD_DEF_BOSS"), new Object[] { guildName, roleName, "" + totalAdd, Const.TipsType.NORMAL });
/*     */     } 
/* 181 */     MessageUtil.sendRollChat(GWorld.__SERVER_ID, tempStr2, Const.CHAT_SCOPE.WORLD);
/*     */   }
/*     */   
/*     */   public GuildBossPo getAndCheckUpdateGuildBossPo(String playerId) {
/* 185 */     GuildBossPo guildBossPO = (GuildBossPo)PlayerPOManager.findPO(ConstsTR.guildBossTR, playerId, GuildBossPo.class);
/* 186 */     if (guildBossPO == null) {
/* 187 */       synchronized (this.player) {
/* 188 */         guildBossPO = (GuildBossPo)PlayerPOManager.findPO(ConstsTR.guildBossTR, playerId, GuildBossPo.class);
/* 189 */         if (guildBossPO == null) {
/* 190 */           guildBossPO = new GuildBossPo();
/* 191 */           PlayerPOManager.put(ConstsTR.guildBossTR, playerId, (GEntity)guildBossPO);
/*     */         } 
/*     */       } 
/*     */     }
/* 195 */     checkUpdate(guildBossPO.inspire);
/* 196 */     Date now = new Date();
/* 197 */     boolean isSameDay = DateUtil.isSameDay(guildBossPO.pointDate, now);
/* 198 */     if (!isSameDay) {
/* 199 */       guildBossPO.pointDate = new Date();
/* 200 */       guildBossPO.hasPoint = 0;
/*     */     } 
/* 202 */     boolean isUpdateAuc = false;
/* 203 */     if (guildBossPO.aucpointDate == null) {
/* 204 */       isUpdateAuc = true;
/* 205 */     } else if (!DateUtil.isSameDay(guildBossPO.aucpointDate, now)) {
/* 206 */       isUpdateAuc = true;
/*     */     } 
/* 208 */     if (isUpdateAuc) {
/* 209 */       guildBossPO.aucpointDate = new Date();
/* 210 */       guildBossPO.aucpoint = 0;
/*     */     } 
/* 212 */     return guildBossPO;
/*     */   }
/*     */   
/*     */   public InspirePO getAndCheckGuildBossAtkPoForGuild(GuildPO guildPO) {
/* 216 */     InspirePO inspirePo = guildPO.inspire;
/* 217 */     if (inspirePo == null) {
/* 218 */       synchronized (guildPO) {
/* 219 */         inspirePo = guildPO.inspire;
/* 220 */         if (inspirePo == null) {
/* 221 */           inspirePo = new InspirePO();
/* 222 */           guildPO.inspire = inspirePo;
/* 223 */           guildPO.modify = true;
/*     */         } 
/*     */       } 
/*     */     }
/* 227 */     if (checkUpdate(guildPO.inspire)) {
/* 228 */       guildPO.modify = true;
/*     */     }
/* 230 */     return inspirePo;
/*     */   }
/*     */   
/*     */   public InspirePO getAndCheckGuildBossDefPoForGuild(GuildPO guildPO) {
/* 234 */     InspirePO defInspirePo = guildPO.defInspire;
/* 235 */     if (defInspirePo == null) {
/* 236 */       synchronized (guildPO) {
/* 237 */         defInspirePo = guildPO.defInspire;
/* 238 */         if (defInspirePo == null) {
/* 239 */           defInspirePo = new InspirePO();
/* 240 */           guildPO.defInspire = defInspirePo;
/* 241 */           guildPO.modify = true;
/*     */         } 
/*     */       } 
/*     */     }
/* 245 */     if (checkUpdate(guildPO.defInspire)) {
/* 246 */       guildPO.modify = true;
/*     */     }
/* 248 */     return defInspirePo;
/*     */   }
/*     */   
/*     */   private boolean checkUpdate(InspirePO inspire) {
/* 252 */     if (inspire == null || inspire.date == null) {
/* 253 */       return false;
/*     */     }
/* 255 */     Date now = new Date();
/* 256 */     boolean isSameDay = DateUtil.isSameDay(inspire.date, now);
/* 257 */     if (!isSameDay) {
/* 258 */       inspire.count = 0;
/* 259 */       inspire.date = now;
/* 260 */       return true;
/*     */     } 
/*     */     
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public String handlerGetBossInfo(GuildBossHandler.GetGuildBossInfoResponse.Builder res) {
/* 267 */     GuildPO guildPo = this.player.guildManager.getGuildInfo();
/* 268 */     String msg = canShow(guildPo);
/* 269 */     if (msg == null) {
/* 270 */       if (GuildBossCenter.getInstance().isOpen()) {
/* 271 */         GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
/* 272 */         guildBossPO.hasPoint = 1;
/*     */       } 
/* 274 */       pushScripts();
/* 275 */       String guildId = guildPo.id;
/* 276 */       int rank = 1;
/* 277 */       List<RankBean> list = null;
/* 278 */       if (GuildBossCenter.getInstance().isOpen()) {
/* 279 */         list = this.player.guildBossAreaHurtRankManager.getRankBeanListOnBegin(guildId);
/*     */       } else {
/* 281 */         list = this.player.guildBossAreaHurtRankManager.getAndSetRankBeanList(guildId);
/*     */       } 
/* 283 */       if (list != null && !list.isEmpty()) {
/* 284 */         for (RankBean rankBean : list) {
/* 285 */           GuildBossHandler.GuildBossRankInfo.Builder bd = getGuildBossRankInfo(rankBean, rank++);
/* 286 */           res.addRankList(bd);
/*     */         } 
/*     */       }
/* 289 */       GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
/* 290 */       if (bean == null) {
/* 291 */         res.setKilled(false);
/*     */       }
/* 293 */       else if (bean.hasKilled()) {
/* 294 */         res.setKilled(true);
/*     */       } else {
/* 296 */         res.setKilled(false);
/*     */       } 
/*     */     } 
/*     */     
/* 300 */     return msg;
/*     */   }
/*     */   
/*     */   private GuildBossHandler.GuildBossRankInfo.Builder getGuildBossRankInfo(RankBean bean, int rank) {
/* 304 */     String playerId = bean.getId();
/* 305 */     PlayerPO po = PlayerUtil.getPlayerBaseData(playerId);
/* 306 */     if (po != null) {
/* 307 */       GuildBossHandler.GuildBossRankInfo.Builder bd = GuildBossHandler.GuildBossRankInfo.newBuilder();
/* 308 */       bd.setDamage(bean.getHurt());
/* 309 */       bd.setId(playerId);
/* 310 */       bd.setName(po.name);
/* 311 */       bd.setPro(po.pro);
/* 312 */       bd.setLevel(po.level);
/* 313 */       bd.setRank(rank);
/* 314 */       return bd;
/*     */     } 
/* 316 */     Out.warn(new Object[] { "根据工会BOSS伤害排行榜获取某个玩家的数据的时候发现角色不存在！,playerId=", playerId });
/* 317 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 324 */     boolean isOpen = GuildBossCenter.getInstance().isOpen();
/* 325 */     GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
/* 326 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*     */     
/* 328 */     PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
/* 329 */     data2.setType(Const.SUPERSCRIPT_TYPE.GUILD_BOSS.getValue());
/* 330 */     if (isOpen && guildBossPO.hasPoint == 0) {
/* 331 */       data2.setNumber(1);
/*     */     } else {
/* 333 */       data2.setNumber(0);
/*     */     } 
/* 335 */     list.add(data2.build());
/* 336 */     return list;
/*     */   }
/*     */   
/*     */   public boolean needUpdateRedPoint() {
/* 340 */     boolean isOpen = GuildBossCenter.getInstance().isOpen();
/* 341 */     GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
/* 342 */     if (isOpen && guildBossPO.hasPoint == 0) {
/* 343 */       return true;
/*     */     }
/* 345 */     return false;
/*     */   }
/*     */   
/*     */   public void pushScripts() {
/* 349 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/* 350 */     List<PlayerHandler.SuperScriptType> list = getSuperScript();
/* 351 */     if (list != null && !list.isEmpty()) {
/* 352 */       data.addAllS2CData(list);
/* 353 */       this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*     */     } 
/* 355 */     this.player.guildManager.pushRedPoint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String canEnter(GuildPO guildPo) {
/* 365 */     if (guildPo == null) {
/* 366 */       return LangService.getValue("DUNGEON_GUILDBOSS_NOT_GUILDMEMBER");
/*     */     }
/* 368 */     GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildPo.id);
/* 369 */     if (bean != null && bean.hasKilled()) {
/* 370 */       return LangService.getValue("DUNGEON_GUILDBOSS_BOSS_DEAD");
/*     */     }
/* 372 */     if (this.mapProp.reqUpLevel > 0 && (this.player.getPlayer()).upLevel < this.mapProp.reqUpLevel)
/* 373 */       return LangService.getValue("PLAER_UPLEVEL_NOT_ENOUGH"); 
/* 374 */     if (this.mapProp.reqLevel > 0 && this.player.getLevel() < this.mapProp.reqLevel) {
/* 375 */       return LangService.getValue("PLAYER_LEVEL_NOT_ENOUGH") + this.mapProp.reqUpLevel;
/*     */     }
/* 377 */     if (GuildBossCenter.getInstance().isOpen()) {
/*     */       
/* 379 */       Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
/* 380 */       if (members == null || members.isEmpty()) {
/* 381 */         return null;
/*     */       }
/* 383 */       for (TeamData.TeamMemberData member : members.values()) {
/* 384 */         if (member.getPlayer() == null || (member.getPlayer()).guildManager == null || (member.getPlayer()).guildManager.guild == null)
/* 385 */           return LangService.getValue("DUNGEON_GUILDBOSS_NOT_JOIN_GUILD"); 
/* 386 */         if (!(member.getPlayer()).guildManager.guild.id.equals(guildPo.id)) {
/* 387 */           return LangService.getValue("DUNGEON_GUILDBOSS_NOT_SAME_GUILD");
/*     */         }
/*     */       } 
/* 390 */       return null;
/*     */     } 
/* 392 */     return LangService.getValue("DUNGEON_GUILDBOSS_NOT_OPEN");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String canShow(GuildPO guildPo) {
/* 400 */     if (guildPo == null) {
/* 401 */       return LangService.getValue("DUNGEON_GUILDBOSS_NOT_GUILDMEMBER");
/*     */     }
/* 403 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 414 */     return Const.ManagerType.GUILD_BOSS;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */